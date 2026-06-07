## Context

当前框架使用 Spring 的生命周期管理，但在 Bean 销毁时存在资源清理不完整的问题。主要场景包括：

- **连接资源**：数据库连接、HTTP 连接未正确关闭
- **流资源**：InputStream/OutputStream 未关闭
- **缓存资源**：本地缓存未清理
- **线程资源**：线程池、定时任务未关闭

现有机制依赖 `DisposableBean` 和 `@PreDestroy`，但实现分散且不统一，缺乏统一的资源管理抽象。

## Goals / Non-Goals

**Goals:**
- 建立统一的 Bean 资源清理机制
- 自动检测和报告资源泄漏
- 提供资源生命周期管理接口
- 最小化对现有代码的侵入性

**Non-Goals:**
- 不修改 Spring Framework 核心生命周期
- 不覆盖所有第三方库的资源管理
- 不提供运行时资源自动回收（仅在 Bean 销毁时）

## Decisions

### 1. 使用 ResourceCleanupAware 接口而非注解

**决策**：创建 `ResourceCleanupAware` 接口，Bean 实现该接口以声明需要清理的资源。

**理由**：
- 接口在编译时检查，减少运行时错误
- 支持多个资源清理方法的类型安全
- 符合 Spring 的设计模式（如 `Aware` 接口系列）

**替代方案**：使用 `@CleanupResource` 注解
- 缺点：注解处理需要额外的 AOP 拦截，性能开销更大

### 2. 资源注册表模式

**决策**：引入 `ResourceRegistry` 统一管理 Bean 持有的资源。

**理由**：
- 集中管理便于追踪和检测泄漏
- 支持按类型分组清理（先关闭外部连接，再清理内部资源）
- 便于监控和诊断

**实现**：
```java
public interface ResourceRegistry {
    <T> void register(ResourceHolder<T> holder);
    void cleanupAll();
    Set<ResourceHolder> getUnreleasedResources();
}
```

### 3. 泄漏检测机制

**决策**：在 `ApplicationContext` 关闭时检查未释放资源并生成报告。

**理由**：
- 延迟检测不影响正常业务性能
- 关闭时报告完整，便于开发阶段发现问题
- 可配置为严格模式（检测到泄漏即失败）

## Risks / Trade-offs

**风险**：增加 Bean 销毁时间 → 缓解：资源清理采用异步机制，超时保护

**风险**：现有 Bean 需要适配新接口 → 缓解：提供适配器模式，支持现有 `DisposableBean` 无缝集成

**权衡**：统一资源管理的便利性 vs. 灵活性 → 选择统一管理，允许特殊场景自定义清理顺序

## Migration Plan

1. **Phase 1**：引入 `ResourceCleanupAware` 和 `ResourceRegistry`
2. **Phase 2**：在核心模块中应用新机制（beans、context）
3. **Phase 3**：扩展到其他模块（cache、storage、monitoring）
4. **Phase 4**：启用严格模式检测

**回滚策略**：保留原有 `DisposableBean` 支持，新旧机制可共存

## Open Questions

- 是否需要支持优先级清理顺序？
- 如何处理清理失败的情况（继续 vs. 中止）？
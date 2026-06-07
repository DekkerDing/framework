## ADDED Requirements

### Requirement: Bean 资源清理接口
系统 SHALL 提供 `ResourceCleanupAware` 接口，允许 Bean 声明其持有的资源以便在销毁时自动清理。

#### Scenario: Bean 实现资源清理接口
- **WHEN** Bean 实现 `ResourceCleanupAware` 接口
- **THEN** 系统在 Bean 销毁时自动调用 `cleanupResources()` 方法
- **AND** 调用发生在 Spring 的 `DisposableBean.destroy()` 之后

### Requirement: 资源注册表
系统 SHALL 提供 `ResourceRegistry` 接口，用于统一注册和管理 Bean 持有的资源。

#### Scenario: 注册资源
- **WHEN** Bean 调用 `ResourceRegistry.register(ResourceHolder)`
- **THEN** 资源被记录到注册表中
- **AND** 返回唯一的资源标识符

#### Scenario: 资源分组
- **WHEN** 资源被注册到注册表
- **THEN** 相同类型的资源被归类到同一分组
- **AND** 清理时按分组顺序执行（外部连接优先）

### Requirement: 资源持有者
系统 SHALL 提供 `ResourceHolder<T>` 接口，封装资源的生命周期操作。

#### Scenario: 资源创建
- **WHEN** 创建 `ResourceHolder` 实例
- **THEN** 必须提供资源的 `close()` 或 `cleanup()` 方法引用
- **AND** 可选提供资源描述信息

#### Scenario: 资源释放
- **WHEN** 调用 `ResourceHolder.cleanup()`
- **THEN** 执行资源的清理操作
- **AND** 将资源标记为已释放状态

### Requirement: 自动资源清理顺序
系统 SHALL 按照以下优先级顺序清理资源：
1. 外部连接资源（数据库、HTTP、消息队列）
2. I/O 流资源
3. 缓存资源
4. 线程池和定时任务资源
5. 内部状态资源

#### Scenario: 按顺序清理
- **WHEN** Bean 销毁触发资源清理
- **THEN** 外部连接资源最先被清理
- **AND** 每个资源组清理完成后才进入下一组
- **AND** 单个资源清理失败不影响其他资源清理

### Requirement: 清理超时保护
系统 SHALL 为资源清理操作提供超时保护机制。

#### Scenario: 清理超时
- **WHEN** 单个资源清理操作超过配置的超时时间（默认 30 秒）
- **THEN** 系统中断该清理操作
- **AND** 记录警告日志
- **AND** 继续清理其他资源

### Requirement: 清理失败处理
系统 SHALL 记录资源清理失败信息并支持不同的失败处理策略。

#### Scenario: 清理失败继续模式
- **WHEN** 配置为 `CONTINUE_ON_FAILURE` 模式且资源清理失败
- **THEN** 记录错误日志
- **AND** 继续清理剩余资源

#### Scenario: 清理失败严格模式
- **WHEN** 配置为 `STRICT` 模式且资源清理失败
- **THEN** 抛出 `ResourceCleanupException`
- **AND** 中止后续资源清理

### Requirement: 兼容现有 DisposableBean
系统 SHALL 支持现有的 `DisposableBean` 和 `@PreDestroy` 机制。

#### Scenario: 兼容模式
- **WHEN** Bean 仅实现 `DisposableBean` 而未实现 `ResourceCleanupAware`
- **THEN** 系统仍执行原有的 `destroy()` 方法
- **AND** 不强制要求迁移到新接口
## ADDED Requirements

### Requirement: 资源泄漏检测
系统 SHALL 在 ApplicationContext 关闭时检测未被释放的资源。

#### Scenario: 应用关闭时检测
- **WHEN** ApplicationContext 执行 `close()` 操作
- **THEN** 系统扫描所有已注册的资源
- **AND** 检测是否存在未释放的资源
- **AND** 生成泄漏检测报告

### Requirement: 泄漏报告格式
系统 SHALL 生成结构化的资源泄漏报告。

#### Scenario: 报告内容
- **WHEN** 检测到资源泄漏
- **THEN** 报告包含以下信息：
  - 泄漏资源的 Bean 名称
  - 资源类型和描述
  - 资源注册时间
  - 资源持有者类名
  - 资源创建的调用堆栈（可选）

#### Scenario: 报告输出
- **WHEN** 泄漏检测完成
- **THEN** 报告输出到日志系统
- **AND** 日志级别为 WARN（默认模式）或 ERROR（严格模式）
- **AND** 包含泄漏资源统计摘要

### Requirement: 严格模式
系统 SHALL 支持严格模式，当检测到资源泄漏时使应用启动失败。

#### Scenario: 严格模式下启动失败
- **WHEN** 配置 `openspec.resource.detection.strict=true`
- **AND** 检测到任何未释放的资源
- **THEN** 抛出 `ResourceLeakException`
- **AND** ApplicationContext 启动失败
- **AND** 报告中包含所有泄漏资源详情

### Requirement: 资源追踪
系统 SHALL 支持资源创建时的调用堆栈追踪。

#### Scenario: 启用堆栈追踪
- **WHEN** 配置 `openspec.resource.trace.enabled=true`
- **THEN** 注册资源时捕获调用堆栈
- **AND** 堆栈信息存储在 ResourceHolder 中
- **AND** 泄漏报告中包含堆栈信息

#### Scenario: 性能影响控制
- **WHEN** 启用堆栈追踪
- **THEN** 系统限制堆栈深度（默认 10 层）
- **AND** 支持过滤特定包名的堆栈帧

### Requirement: 排除规则
系统 SHALL 支持配置资源泄漏检测的排除规则。

#### Scenario: 按类型排除
- **WHEN** 配置 `openspec.resource.detection.exclude.types`
- **THEN** 匹配的资源类型不参与泄漏检测

#### Scenario: 按 Bean 名称排除
- **WHEN** 配置 `openspec.resource.detection.exclude.beans`
- **THEN** 指定 Bean 的资源不参与泄漏检测

### Requirement: 泄漏指标
系统 SHALL 收集和暴露资源泄漏相关的监控指标。

#### Scenario: 指标暴露
- **WHEN** 资源泄漏检测执行
- **THEN** 系统记录以下指标：
  - 检测到的泄漏资源数量
  - 已清理的资源数量
  - 清理耗时
  - 清理失败次数
- **AND** 指标通过 `MeterRegistry` 暴露给监控系统

### Requirement: 开发环境增强
系统 SHALL 在开发环境中提供更详细的泄漏诊断信息。

#### Scenario: 开发模式
- **WHEN** 应用在开发环境运行（`spring.profiles.active=dev`）
- **THEN** 泄漏报告包含更详细的信息
- **AND** 提供资源依赖关系图
- **AND** 建议可能的修复方案
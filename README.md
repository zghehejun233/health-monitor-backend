# 学生在线2022暑期实训健康监测后端

学生在线2022暑期实训健康监测APP项目后端。

## 目录结构

> 按个人喜好配置

```shell
# cn.sdu.healthmonitorbackend
.
├── HealthMonitorBackendApplication.java
├── config
├── controller
├── domain
│   ├── pojo
│   └── vo
├── mapper
├── service
└── util
```

应该没有需要特别说明的，`domain`存放实体类；`mapper`写MyBatis；`service`里接口和实现自行安排吧，个人习惯把接口写在最外层，然后一个接口一个包去实现；后期有需要可以加一个`constants`，存放枚举之类的常量。

## TODOs

> 后端成员自行安排，使用这种语法可以实现复选框

- [] TODO
- [x] Finished TODO

## bug

## Commit规范


照抄i山大的格式得了，先用着下面几个标签

```shell
feat: 新功能
fix: 修复buf
doc: 修改文档
refact: 重构代码
other: 其他情况
```

提交格式为

```shell
<label>: <summary>
<empty line>
<details>
```
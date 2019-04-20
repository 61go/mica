# redis cache 增强

## 功能
1. 支持 # 号分隔 cachename 和 超时 timeOut

## 注意
使用 `protostuff` 做的 `redis` 序列化和反序列化。

`protostuff` 默认是根据 Model `属性顺序`进行序列化，如果在`中间插入`或者`删除字段`。

需要添加 @io.protostuff.Tag(1) 注解进行`顺序`的标注。

## protostuff 注解说明

|   注解   |   描述   |
| -------- | --------------------------  |
| @Tag(1)  |  Model `属性顺序` 标注        |
| @Exclude | 排除字段，不进行序列化和反序列化 |
| @Morph   | Set、List、Map 等集合添加 |

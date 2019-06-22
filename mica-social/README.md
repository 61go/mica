# 第三方登录组件

`mica-social`，如你所见，它仅仅是一个**第三方授权登录**的**工具类库**，它可以让我们脱离繁琐的第三方登录 SDK，让登录变得**So easy!**

`mica-social` 参考了 `JustAuth` 和我之前的 [`JFinal-oauth2.0-login`](https://gitee.com/596392912/JFinal-oauth2.0-login)

## API 列表
|  :computer: 平台  |
|:------:|
|  gitee  |
|  github  |
|  weibo  |
|  dingtalk  |
|  baidu  |
|  coding  |
|  tencentCloud  |
|  oschina  |
|  alipay  |
|  qq  |
|  wechat  |
|  taobao  |
|  google  |
|  facebook  |
|  douyin  |
|  linkedin  |
|  microsoft  |
|  mi  |
|  toutiao  |
|  csdn  |

`注`：CSDN 的授权开放平台已经下线。so, 本项目中的 CSDN 登录只能针对少部分用户使用。

## 添加依赖
### maven
```xml
<dependency>
  <groupId>net.dreamlu</groupId>
  <artifactId>mica-social</artifactId>
  <version>${version}</version>
</dependency>
```

### gradle
```groovy
compile("net.dreamlu:mica-social:${version}")
```

## 鸣谢
`mica-social` 修改与 [`JustAuth`](https://github.com/zhangyd-c/JustAuth)，感谢 `JustAuth` 所有开发者的奉献。
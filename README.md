# ZY-SHORT-URL

<p align="center">
	<strong>ZY-短网址</strong>
</p>
<p align="center">
	👉 <a href="https://zzzykj.cn/">https://zzzykj.cn/</a> 👈
</p>

<br/>

-------------------------------------------------------------------------------

## 📚简介
zy-short-url 是一个用于生成短网址的工具包, 同时提供了一写简单的网页接口.

-------------------------------------------------------------------------------

## 🛠️包含组件

| 模块                                  | 介绍                                   |
|-------------------------------------|--------------------------------------|
| zy-shorturl-core                    | 核心包, 提供URL缩短工具类                      |
| zy-shorturl-store                   | 数据仓库包, 提供多种数据仓库支持                    |
| zy-shorturl-spring-boot-starter     | SpringBoot依赖包, 内部实现了自动注入, 方便快速集成此工具包 |
| zu-shorturl-web-spring-boot-starter | Web包, 提供了几个相关接口实现                    |
| zy-shorturl-server                  | 简易实现了一个WebServer, 可直接运行并对外提供服务       |

可以根据需求对每个模块进行单独引入，也可以通过引入`zy-shorturl-spring-boot-starter`方式快速集成相关功能, 或者通过引用`zu-shorturl-web-spring-boot-starter`包快速提供Http服务。
或者直接编译并在服务器部署`zy-shorturl-server`, 可直接对外提供服务。

-------------------------------------------------------------------------------

## 📝文档

> 暂无

-------------------------------------------------------------------------------

## 🪙支持 ZY-SHORT-URL

### 💳捐赠



### 👕周边商店


-------------------------------------------------------------------------------

## 📦安装

### 🍊Maven
在项目的pom.xml的dependencies中加入以下内容:

> 暂未推送至Maven中央仓库, 可先自行下载编译

### 🍐Gradle
> 暂未推送至Maven中央仓库, 可先自行下载编译

### 📥下载jar

点击以下链接，下载`zy-short-url-XXX-X.X.X.jar`即可：

> 暂未推送至Maven中央仓库, 可先自行下载编译

> 🔔️注意
> 项目最低支持JDK1.8

### 🚽编译安装

访问Zy-Short-Url的GitHub主页：[https://github.com/1302344380/zy-short-url](https://github.com/1302344380/zy-short-url) 下载整个项目源码, 然后进入项目目录执行：

```sh
mvn clean install
```

然后就可以使用Maven引入了。

-------------------------------------------------------------------------------

## 🏗️添砖加瓦

### 🎋分支说明

ZY-SHORT-URL的源码分为两个分支，功能如下：

| 分支     | 作用                                         |
|--------|--------------------------------------------|
| master | 主分支，release版本使用的分支，与中央库提交的jar一致，不接收任何pr或修改 |
| dev    | 开发分支，接受修改或pr (暂未使用, 1.0版本开发完成后启用)          |

### 🐞提供bug反馈或建议

提交问题反馈请说明正在使用的JDK版本呢、ZY-SHORT-URL版本和相关依赖库版本。

- [Gitee: 暂不接受Gitee提交反馈, 请于Github提交](https://github.com/1302344380/zy-short-url/issues)
- [Github issue](https://github.com/1302344380/zy-short-url/issues)


### 🧬贡献代码的步骤

1. 在Gitee或者Github上fork项目到自己的repo
2. 把fork过去的项目也就是你的项目clone到你的本地
3. 修改代码（记得一定要修改dev分支）
4. commit后push到自己的库（dev分支）
5. 登录Gitee或Github在你首页可以看到一个 pull request 按钮，点击它，填写一些说明信息，然后提交即可。
6. 等待维护者合并

### 📐PR遵照的原则

ZY-SHORT-URL欢迎任何人为此添砖加瓦，贡献代码，但希望提交的pr（pull request）符合一些规范，规范如下：

1. 注释完备，尤其每个新增的方法应按照Java文档规范标明方法说明、参数说明、返回值说明等信息，必要时请添加单元测试，如果愿意，也可以加上你的大名。
2. 缩进按照 IDEA 默认（tab）缩进，所以请遵守。
3. 新加的方法尽量不要使用SpringFramework意外的第三方组件。
4. 请pull request到`dev`分支。
5. 我们如果关闭了你的issue或pr，请不要诧异，这是我们保持问题处理整洁的一种方式，你依旧可以继续讨论，当有讨论结果时我们会重新打开。

-------------------------------------------------------------------------------

## ⭐Star ZY-SHORT-URL

[![Stargazers over time](https://starchart.cc/1302344380/zy-short-url.svg)](https://starchart.cc/1302344380/zy-short-url)

## ❤ 鸣谢

### [HuTool: 一个小而全的Java工具类库](https://github.com/dromara/hutool/)

### [seruco/base62: A Base62 Encoder/Decoder for Java](https://github.com/seruco/base62/)

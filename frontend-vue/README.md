# 疫情监控系统的前端仓库

![](https://img.shields.io/badge/node->=12.0.0-green)
![](https://img.shields.io/badge/npm->=8.0.0-green)
![](https://img.shields.io/badge/vue-2.6.11-blue)
![](https://img.shields.io/badge/vuex-3.6.2-blue)
![](https://img.shields.io/badge/vue--router-3.5.3-blue)
![](https://img.shields.io/badge/eslint-%3E%3D6.0.0-yellow)
![](https://img.shields.io/badge/sass-=1.26.5-red)

## 技术栈
vue2 + vuex + vue-router + ES6/7 + sass + element-ui

## 参考文档

- [vue](https://vuejs.bootcss.com/v2/guide/)：Vue是一套用于构建用户界面的渐进式框架。

- [vuex](https://vuex.vuejs.org/zh/)：Vuex 是一个专为 Vue.js 应用程序开发的状态管理模式。

- [vue-router](https://router.vuejs.org/zh/)：Vue Router 是 Vue.js 官方的路由管理器。

- [vue-cli](https://cli.vuejs.org/zh/)：开发标准工具。

- [sass](https://www.sass.hk/)：Sass 是一款强化 CSS 的辅助工具，它在 CSS 语法的基础上增加了变量 (variables)、嵌套 (nested rules)、混合 (mixins)、导入 (inline imports) 等高级功能

- [element-ui](https://element.eleme.io/)：Element,一套为开发者、设计师和产品经理准备的基于 Vue 2.0 的桌面端组件库。


## 前序准备

**运行前准备：**

由于此项目是基于nodejs的前端项目，你需要进行nodejs的相关准备工作。项目运行之前，请确保系统已经安装以下应用：

(1)、node (6.0 及以上版本)。使用细节，请参考：[node的下载及安装。](https://nodejs.org/en/download/)


## 开发：
#### 克隆仓库到本地
```
git clone https://github.com/dontnet-wuenze/Epidemic-Service-System
```

#### 切换到前端项目目录
```
cd Epidemic-Service-System/frontend-vue
```

#### (可选,切换到国内源)
```
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

安装相关依赖
```
npm install/cnpm install
```

**本地运行：**

```
npm run serve
```
运行之后，会默认打开本地访问路径：http://localhost:8080

**发布：**
生成打包之后的项目文件,此文件主要用于项目部署。

```
**npm run bulid** 
```
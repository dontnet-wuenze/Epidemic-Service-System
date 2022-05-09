# Epidemic-Service-System

疫情监控与管理系统

采用前后端分离的架构

**前端** Vue2

[前端文档](frontend-vue/README.md)

**后端** springboot

**接口工具** APIPost



## Git的使用

cd 到你要工作的空目录，克隆仓库到本地：

```sh
git clone https://github.com/dontnet-wuenze/Epidemic-Service-System
```

在本地新建自己的dev分支，并检出该分支

```sh
git checkout -b {yourname}-dev
```

同时在远程也建立的自己的dev分支

```sh
git push --set-upstream origin {yourname}-dev
```

之后的开发可以在本地开自己的分支，开发完之后整合到本地的 {yourname}-dev 分支并push到远程的对应分支上。然后在github上发个pull request，把你远程的{yourname}-dev 分支 merge到develop分支上，或者让wez来 review 你的pull request。

示范：（checkout时会丢弃本地还未commit的更改，所以这一步要小心）

```sh
git checkout -b feature-1 # 新建一个feature分支并且检出
# ...
# 对代码进行修改，提交代码
# ...
git checkout develop #切换到本地的develop分支
git pull origin develop #使本地的develop更新至现在远程的develop
git checkout {yourname}-dev #切换到本地的开发分支
git merge develop #将本地develop的改动（相当于其他人在这段时间的改动）merge到你自己的开发分支里
git merge feature-1 #将你的改动 merge到自己的开发分支里
git push origin {yourname}-dev #提交你的开发分支到远程仓库
# 然后也可以删除feature-1分支了
最后在 github上进行 pull request，把你刚push的开发分支申请合并到远程的develop分支上，可以自己通过自己的request，也可以让别人帮你review后通过你的request。

```

上面的示范很麻烦，如果 github 玩的熟的话，只要遵循以下几个原则就可以了：

1. 远程的 master 分支作为release分支，不要改动。develop 分支是大家的公共开发分支，需要保证上面代码的正确性和稳定性，只允许通过pull request进行改动。
1. 不要直接从本地push到远端的develop分支，远端的develop分支只允许在github平台上通过pull request进行修改。
2. 如果merge时有冲突的发生，请根据实际情况手动解决冲突，并在pull request时指定别人对你做code review。
2. merge选项统一用 --no-rebase，不要用--rebase
3. 有不知道如何解决的冲突，或者有任何问题，随时在群里问。

注：如果github时不时push/pull不上去很正常，可以试试挂个梯子，并且设置让shell里也走你的代理端口。

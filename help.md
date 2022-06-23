## 5.1 主界面

主界面为四个子模块的导航界面。同时有健康打卡，登录，查看消息等

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654004167549-d9eda8ab-f918-4e3a-94d2-f419336c7f3e.png)

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654004171697-e2a57d56-f555-49e4-95b5-be3587c2962e.png)

## 5.2 用户注册界面

在用户注册界面首先通过get请求获得所有的已注册账户显示在列表中，点击添加用户可以向数据库中添加账户信息，同时可以对已经添加的用户信息进行编辑。

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654004296147-454f95f1-cc27-45ed-bddb-e0b3f4c84d0a.png?x-oss-process=image%2Fresize%2Cw_1600)



**添加用户**

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654004650074-eae31b75-44ff-4f20-bb8c-98414bb9ce0a.png)

**编辑用户**

**![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654004704450-5841ac2c-925c-4d84-be2b-cafff123a68b.png)**

**
**

## 5.3 核酸检测预约界面

 

核酸检测预约界面嵌入在系统边框内部，标题指明是核酸检测预约模块，随后是自动生成的申请编号与申请日期。接下来的基础信息与预约信息模块需要用户填写，并点击提交模块预约。



**![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654005275135-efa745b0-32b7-41ed-8d57-69622dc049aa.png)**

**![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654005279987-000054ee-b5d3-4f89-9cd3-2420546759d3.png)**

**
**

## 5.4  核酸检测结果查询界面

 

结果查询界面将会返回用户的核酸检测结果、检测时间与个人信息

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654005361285-b59c2458-41c3-4cf3-8249-461cb6b714f0.png)



 

## 5.5 核酸检测结果上传界面

 

用户可通过左上角的**读取excel文件**按钮导入检测结果，导入的项将在下方显示。也可通过添加条目下方的三个栏目添加检测结果。导入的项可以在表单内修改，也可以用下方的清空按钮全部清空。提交按钮用于提交表单。

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654005400262-add6344c-eb9f-4de5-ae11-1b772cb69b30.png)



## 5.6 离校报备/通行码申请

该界面全部由表单组成，其中部分由后端提供的数据字段不可编写，其他部分均可由用户自行选择与编写，点击提交按钮可进行提交，若失败会有相应的提示信息.

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654006477222-87c88b8c-d22f-4794-9502-e230fc19f3ae.png)



## 5.7 申请记录界面

 

用户可进入此界面查看有关的申请记录以及审批状态

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654006518223-9caf0ccf-c0d3-4061-9c86-4af99df776d7.png)



## 5.8 审批界面

 

仅管理员用户可进入此界面，在该界面可点击审批对相应表单进行审批。



![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654006538341-19562704-af12-4b6a-a3fe-092952a90f30.png)

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654006559806-9ecd25c0-413d-4632-983c-74dad53bd7c9.png)



## 5.9 健康打卡界面

 

用户填入每日健康打卡的各项信息, 和验证码匹配后点击提交按钮提交信息。



![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654007185241-49a42d8a-5aac-4e66-8210-2507a6be33c2.png)

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654007195872-732d451d-abd0-48ab-a84e-758f4b3b56e5.png)



## 5.10 查看通行码界面

​      用户可以进入该界面查看通行码状态，界面会显示学生的姓名，所在学院和年纪，同时展示通行码的状态。

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654007225345-7033ef4b-183a-467c-ae1f-3542ed7a0073.png)



## 5.11 健康打卡统计界面

​      具有管理员权限的辅导员可以进入该界面查找相关统计信息，分别有打卡人数和打卡校区分布的统计，统计图表有柱状图和饼状图两种形式。最后有未打卡人员的列表，可以想未打卡人员发送消息通知提醒打卡。

人数统计

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654007265298-f8167cd6-d8d3-4fc3-82d1-000ad6b7821d.png)

校区统计

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654007282877-654328a8-8ca8-468b-9daa-41d5890692bc.png)

未打卡人员![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654007294925-2fc1aece-8dd6-4f9a-b3ac-b386ca4ee133.png)



## 5.12 查看疫情监控情况

首先，系统将根据从后端获取的全校核酸检测情况、本科生核酸检测情况和在校人数情况，进行一定的统计信息计算。随后，将以柱状图、饼状图、折线图等形式展示核酸检测完成情况。在统计图中，管理员可通过点击具体颜色获得对应人数、校区等信息。

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654010338483-be319ec8-c1e4-41db-b999-06bae9522d7b.png)

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654010347075-2f2e43fb-d727-4f13-9844-d4e92e1e2a0b.png)

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654010355100-cfbe730e-5f5f-4510-bc5a-f46e09066688.png)

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654010361769-b1d5b279-995c-431f-ab49-28da1e37c7a8.png)

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654010367404-d6fa651a-8c7f-49cc-aaf6-4d9e8e17e4d7.png)

![image.png](https://yuque.zju.edu.cn/images/yuque/0/2022/png/22333/1654010376573-0a8dfb3f-d45d-49a7-a184-66ba7f78ccc8.png)

# 
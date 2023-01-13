# 数据库练手项目-企业设备库存管理系统	

## 上手之前

- 环境要求：

  首先当然是要为你的电脑配置Java的开发环境了，可能在这里说有点多余，以防万一，提一嘴。

  Java开发的IDE我选用的是Eclipse，推荐你用相同的IDE来运行这个项目，当然你用其他更方便的工具也完全可以。
  
  具体 ：
  
  - MySQL8.0；
  
  - Java jdk-18.0.1.1；
  
  - Eclipse 4.24.0，

## **企业设备库存管理系统主要功能**

- **多用户登录**

  主要提供两类用户登录：普通用户； 管理员用户

  ![登录界面](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-15-36.png)



- **主界面展示**

  登录后进入主界面主要是一张图片和标题，只起展示之用。

  ![主界面](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-19-04.png)

- **信息查询**

  可供查询的信息主要有：

  - 设备基本信息
  - 供应商信息
  - 设备和供应商信息
  - 库存信息
  - 设备信息&库存&需求信息
  - 入库综合信息
  - 出库综合信息
  - 还库综合信息

  界面展示：

  ![信息查询](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-22-41.png)

  功能说明：

  - 勾选查找全部后查找相关的全部信息

  - 未勾选时需要输入对应的查找信息，如：查找设备信息时需要输入设备id

- **信息统计**

  提供设备库存信息中的部分全局数据的统计，从而展示设备库存的一个全局状态

  ![信息统计](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-27-42.png)

- **库存更新**

  主要有需求登记，设备采购， 设备入库， 设备出库， 设备还库等可能对设备库存信息产生改变的操作

  - 需求登记

    ![需求登记](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-30-41.png)

  - 设备采购

    ![设备采购](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-31-19.png)

  - 设备入库

    ![设备入库](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-32-01.png)

  - 设备出库

    ![设备出库](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-32-38.png)

  - 设备还库

    ![设备还库](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-34-00.png)

- **信息修改**

  对员工信息， 供应商信息， 需求信息进行相应的修改操作

  - 修改员工信息（联系电话， 所属部门）

    ![修改员工信息](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-35-30.png)

  - 修改供应商信息（名字， 地址）

    ![修改供应商信息](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-36-48.png)

  - 修改需求信息（即撤销未完成的需求)

    ![撤销需求](https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_12-39-00.png)

## **数据库设计**

数据库表

- 生产供应商表 vendors
- 设备表 devices
- 部门表 department
- 员工表 employee
- 库存信息表 devices_remain
- 设备采购表 purchase_record
- 设备入库表 devices_in
- 设备出库表 devices_out
- 设备还库表 devices_back
- 设备需求表 devices_need

<img src="https://raw.githubusercontent.com/Moran-0/Java_Enterprise_Devices_ManageMent_System/master/Image/Snipaste_2023-01-13_13-10-03.png" alt="表间关系" style="zoom:50%;" />

存储过程

- 需求登记
- 设备采购存储过程
- 入库存储过程
- 出库存储过程
- 还库存储过程
- 需求删除存储过程
- 信息统计存储过程

触发器设计

- 入库触发器
- 出库触发器
- 采购触发器
- 还库触发器

## **文件说明**

- iconImage文件夹存放的是软件中用到的图片源文件。

- database文件夹存放数据库操作相关代码

- ui文件夹存放软件的图形界面设计相关代码

- 数据库设计源代码文件夹中存放建立数据所需源码 用word形式存储

  

## **联系方式**

可以通过邮箱2857599224@qq.com进行联系。
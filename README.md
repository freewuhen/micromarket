# micromarket
### 微超市项目
* #### 需求说明：
###### 1.  所需要开发的软件系统边界
本系统主要用于超市与顾客之间的商品的交易，因此商品的生产，监管，运输都不属于本系统功能范围之能。
###### 2.系统所有的相关及使用人员角色
*  超市管理者:使用传统web页面进行管理
* 顾客：通过微信小程序进行购物
###### 3.系统关键的使用场景
 顾客通过微信手机端，以微信公众号为入口来使用系统来进行商品分类、查询、查看、下单、支付等功能的使用；﻿
店面（小超市）管理者 可以通过后台进行商品管理、商品分类管理；
* #### 总体设计：
###### 1.组成系统的模块
  * 后端
       * 控制模块（controller）
       * 数据持续模块(Respository)
       * 服务模块(Service)
      * 数据模型模块(Domain)
      * 权限管理模块
  * 前端
      * 微信小程序（顾客）
      * 传统web端（超市管理者）


### 2.模块间的调用关系
    //(需补充)
### 3.数据库设计

* 数据库micromarket包含以下表：

 Tables_in_micromarket | 
---|
| admin                 |
| category              |
| commodity             |
| transation_record     |
| user                  |
|brands                |

* admin

Field  |Type | Null | Key | 
---|---|---|---
| aid      | varchar(20) | NO   | PRI | 
| password | varchar(20) | YES  | | 

* user

Field  |Type | Null | Key |Default | Extra |
---|---|---|---|---|--- 
| uid        | varchar(20) | NO   | PRI | NULL    |       |
| addr       | varchar(80) | YES  |     | NULL    |       |
| balence    | int(11)     | YES  |     | NULL    |       |
| password   | varchar(20) | YES  |     | NULL    |       |
| telenumber | varchar(11) | YES  |     | NULL    |       |

* category

Field  |Type | Null | Key | 
---|---|---|---
| cateid   | int(11)     | NO   | PRI | 
| amount   | int(11)     | YES  |     | 
| catename | varchar(30) | YES  ||

* commodity

Field  |Type | Null | Key |Default | Extra |
---|---|---|---|---|---
| cid             | varchar(20)  | NO   | PRI | NULL    |       |
| bimage          | varchar(100) | YES  |     | NULL    |       |
| cname           | varchar(40)  | YES  |     | NULL    |       |
| costprice       | float        | YES  |     | NULL    |       |
| description     | text         | YES  |     | NULL    |       |
| nopps           | int(11)      | YES  |     | NULL    |       |
| sales_volume    | int(11)      | YES  |     | NULL    |       |
| score           | float        | YES  |     | NULL    |       |
| sellingprice    | float        | YES  |     | NULL    |       |
| simage          | varchar(100) | YES  |     | NULL    |       |
| stock_quantity  | int(11)      | YES  |     | NULL    |       |
| brands_bid      | varchar(15)  | YES  | MUL | NULL    |       |
| category_cateid | int(11)      | YES  | MUL | NULL    |       |
| supplier_sid    | int(11)      | YES  | MUL | NULL    |       |




* transation_record

Field  |Type | Null | Key |Default | Extra |
---|---|---|---|---|--- 
| tid          | varchar(20) | NO   | PRI | NULL    |       |
| money        | float       | YES  |     | NULL    |       |
| transnumber  | int(11)     | YES  |     | NULL    |       |
| transstatus  | int(11)     | YES  |     | NULL    |       |
| transtime    | datetime    | YES  |     | NULL    |       |
| commodity_id | varchar(20) | YES  | MUL | NULL    |       |
| user_id      | varchar(20) | YES  | MUL | NULL    |       |


* brands

Field  |Type | Null | Key |Default | Extra |
---|---|---|---|---|--- 
| bid   | varchar(15) | NO   | PRI | NULL    |       |
| bname | varchar(40) | YES  |     | NULL    |       |

* supplier

Field  |Type | Null | Key |Default | Extra |
---|---|---|---|---|--- 
| sid         | int(11)     | NO   | PRI | NULL    | auto_increment |
| contactinfo | varchar(30) | YES  |     | NULL    |                |
| sname       | varchar(60) | YES  |     | NULL    |                |
* address
Field  |Type | Null | Key |Default | Extra |
---|---|---|---|---|--- 
| aid      | int(11)      | NO   | PRI | NULL    | auto_increment |
| address  | varchar(100) | YES  |     | NULL    |                |
| name     | varchar(14)  | YES  |     | NULL    |                |
| tele     | varchar(11)  | YES  |     | NULL    |                |
| user_uid | varchar(50)  | YES  | MUL | NULL    |                |

* #### 概要设计：
* ###### 部署方案：
  * **Nginx 存储静态资源**
  * **Tomcat 响应HTTP请求 返回Json**

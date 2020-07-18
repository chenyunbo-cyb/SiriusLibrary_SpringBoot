# 一、项目介绍
+ 项目名称：Sirius天狼图书馆管理系统（Web）
+ maven依赖：<br>
org.springframework.boot<br>
&emsp;&emsp;&emsp;&emsp;spring-boot-starter-data-mongodb<br>
&emsp;&emsp;&emsp;&emsp;spring-boot-starter-data-redis<br>
&emsp;&emsp;&emsp;&emsp;spring-boot-starter-mail<br>
&emsp;&emsp;&emsp;&emsp;spring-boot-starter-thymeleaf<br>
&emsp;&emsp;&emsp;&emsp;spring-boot-starter-web<br>
&emsp;&emsp;&emsp;&emsp;spring-boot-starter-test<br>
org.mybatis.spring.boot<br>
&emsp;&emsp;&emsp;&emsp;mybatis-spring-boot-starter<br>
mysql：<br>
&emsp;&emsp;&emsp;&emsp;mysql-connector-java<br>
org.projectlombok：<br>
&emsp;&emsp;&emsp;&emsp;lombok<br>
com.alibaba：<br>
&emsp;&emsp;&emsp;&emsp;druid-spring-boot-starter<br>
+ plugin插件：
org.mybatis.generator：<br>
&emsp;&emsp;&emsp;&emsp;mybatis-generator-maven-plugin<br>
其他默认插件
+ 打包方式：jar/war
+ 目录结构：<br>
--main：代码<br>
&emsp;&emsp;| comtroller：控制器层<br>
&emsp;&emsp;&emsp;&emsp;| user：用户端控制器<br>
&emsp;&emsp;&emsp;&emsp;| administrator：管理员端控制器<br>
&emsp;&emsp;| dao：数据库永久层<br>
&emsp;&emsp;| domain：实体类层<br>
&emsp;&emsp;| filter：过滤器层<br>
&emsp;&emsp;&emsp;&emsp;| conf：过滤器层配置类<br>
&emsp;&emsp;| service：服务层<br>
&emsp;&emsp;| transactor：拦截器层<br>
&emsp;&emsp;&emsp;&emsp;| conf：拦截器层配置类<br>
--resources：资源文件（所有的xml等类型的配置文件放在这里）<br>
&emsp;&emsp;| mapper：数据库SQL语句mapper文件<br>
&emsp;&emsp;| static：静态文件<br>
&emsp;&emsp;&emsp;&emsp;| css：css文件<br>
&emsp;&emsp;&emsp;&emsp;| js：JavaScript文件<br>
&emsp;&emsp;&emsp;&emsp;| images：图片文件<br>
&emsp;&emsp;&emsp;&emsp;| others：其他类型文件<br>
&emsp;&emsp;| templates：HTML文件

# 二、技术点
+ SpringBoot框架：集成MyBatis、日志功能（控制台、文件）、发送邮件验证码功能、Thymeleaf模板框架、Redis数据库操作、MongoDB操作；过滤器、拦截器
+ 数据库：MySQL（druid连接池）、Redis、MongoDB
+ **密码安全：加盐Hash-SHA1密码算法**
+ yml方式的SpringBoot配置文件
+ 完全脱离jsp
+ dubbo分布式框架（暂不实现）
+ 使用mybatis-generator插件辅助编辑，配合手动编辑生成实体类、dao接口、mapper文件
# 三、功能（随时更新）
## 1、管理员端
+ 管理所有读者信息（基本信息、登录信息、状态管理）
+ 管理员个人信息管理
+ 管理图书（增删改查）
+ 超级管理员（注册管理员账号）
+ 借还书
## 2、用户端
+ 图书信息借阅情况
+ 管理个人信息
+ 注册、删除账户
+ 预约
## 3、超级管理员
+ 管理员账号增删改查
+ 管理员端全部功能

# 四、版本信息
##2020.07.18
+ 完成了项目的初始化架构，编辑README

# 五、工具
+ 编辑器：IntelliJ IDEA
+ 编辑器插件：<br>
lombok：日志功能代码提示。<br>
EditStarts：在porm文件中通过右键调出spring依赖选择窗口，方便添加依赖。
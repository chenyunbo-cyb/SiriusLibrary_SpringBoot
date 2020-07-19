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
&emsp;&emsp;&emsp;&emsp;| main：公共页面控制器<br>
&emsp;&emsp;| dao：数据库永久dao接口层<br>
&emsp;&emsp;&emsp;&emsp;| mysql：mysql端数据库接口
&emsp;&emsp;&emsp;&emsp;| redis：redis端数据库接口
&emsp;&emsp;&emsp;&emsp;| mongo：MongoDB端数据库接口
&emsp;&emsp;| domain：实体类层<br>
&emsp;&emsp;| filter：过滤器层<br>
&emsp;&emsp;&emsp;&emsp;| conf：过滤器层配置类<br>
&emsp;&emsp;| service：服务层<br>
&emsp;&emsp;&emsp;&emsp;| impls：实现类<br>
&emsp;&emsp;&emsp;&emsp;| interfaces：接口类<br>
&emsp;&emsp;| transactor：拦截器层<br>
&emsp;&emsp;&emsp;&emsp;| conf：拦截器层配置类<br>
&emsp;&emsp;| tools：工具类<br>
&emsp;&emsp;| exceptions：自定义异常类<br>
--resources：资源文件（所有的xml等类型的配置文件放在这里）<br>
&emsp;&emsp;| mapper：数据库SQL语句mapper文件<br>
&emsp;&emsp;| static：静态文件<br>
&emsp;&emsp;&emsp;&emsp;| css：css文件<br>
&emsp;&emsp;&emsp;&emsp;| js：JavaScript文件<br>
&emsp;&emsp;&emsp;&emsp;| images：图片文件<br>
&emsp;&emsp;&emsp;&emsp;| others：其他类型文件<br>
&emsp;&emsp;| templates：HTML文件

# 环境：<br>
&emsp;&emsp;java 14.0.1<br>
&emsp;&emsp;Windows 10 x64<br>
&emsp;&emsp;MySQL Ver 8.0.20 for Win64 on x86_64 (MySQL Community Server - GPL)<br>
&emsp;&emsp;Redis 3.2.100<br>
&emsp;&emsp;Mongodb 4.2.8<br>
&emsp;&emsp;Tomcat（SpringBoot内嵌）；外部（用于war包部署）：9.0.36<br>
&emsp;&emsp;IDEA 2020.1.3
# 二、技术点
+ SpringBoot框架：集成MyBatis、日志功能（控制台、文件）、发送邮件验证码功能、Thymeleaf模板框架、Redis数据库操作、MongoDB操作；过滤器、拦截器
+ 数据库：MySQL（druid连接池）、Redis、MongoDB（暂不实现）
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
## 2020.07.19
+ 完成了项目的初始化架构，编辑README
+ 完成了dao层接口、mapper文件创建
+ 完成了数据库表的实体类的创建
+ 添加了登录页面
+ 添加了密码hash算法工具类
+ 完成了部分主页业务层（测试完毕）
+ 密码业务层、用户id业务层，包括接口和实现类（未完成测试）

# 五、拿到项目后需要做的事情
+ 1、将根目录下的sql文件运行至数据库。
+ 2、在idea内安装lombok插件，不安装的话log会飘红，但代码执行正常，强迫症福利。
+ 3、重命名核心配置文件applicationdev-2.yml为application.yml（xxxxxx重要xxxxxx）
+ 4、修改application.yml文件中数据库配置信息。
+ 5、对于mybatis-generator配置文件，请参照网络，真的有很多，项目开发阶段用不上，就不放在仓库了。
# 六、工具
+ 编辑器：IntelliJ IDEA
+ 编辑器插件：<br>
lombok：日志功能代码提示。<br>
EditStarts：在porm文件中通过右键调出spring依赖选择窗口，方便添加依赖。

# 一些想法
+ 先不做事务、线程安全，等基本功能实现后，进行线程安全和事务的优化。
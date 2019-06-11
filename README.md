# Springlearn
1.Spring HelloWorld 
 |—创建Sping IOC容器对象的时候会根据bean的配置文件去初始化bean
 	|-调用无参构造函数
 	|-调用setName()方法
 |-xml配制文件中bean的id必须唯一
 |—Spring 创建实例过程
 	|-根据配制创建Spring IOC 容器对象
 	|-通过getBean(String id)方法获取对象实例
 	|-调用对象实例的hello方法
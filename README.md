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


IOC&DI
	
	IOC:控制反转，其思想是改变资源获取的方向。传统的资源获取方向时组件向容器去请求资源，
	然后容器将组件所需资源发送个组件；IOC和这正好相反，容器将组件所需资源直接推送给组件，
	改变了资源获取的方法。
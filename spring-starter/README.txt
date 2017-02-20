What we have Learned so far.....

1. What is Spring?
Ans. Spring is a Software development framework for Java development to simplify J2EE development

2. What is Spring DI?
Ans: Spring Dependency Injection is used to manage bean instance creation and destruction. 
	There are three methods for DI:
		1.  Using xml config file.
		2.	Using JavaConfig.
		3.	Using Spring's Autowiring and ComponentScan.

I have started with Spring DI using Autowiring. This method is widely used for DI.
 Firstly, I have created two intefaces named CompactDisk and MediaPlayer.
 the created thier Implementations as SgtMusicDisk and CDPlayer and annotated them with @Component.
 Now, As I am using Spring's DI, I don't have to worry about instances for CompactDisk and MediaPlayer.
 
 ***@Component***
 Any Java Class annotated with @Component will becomes a Spring Component. Which means Springs DI will be 
 responsible for instantiation and destruction of class objects. Like in this situation if I want instance for
 CompactDisk, Spring's DI will automatically finds its Implementation and gives the instance ready to use.
 
 Automatically finding its implementation is a part of DI's automatic wiring.
 
 I have Created a JavaConfig file named CDPlayerConfig and annotated with @Configuration.
 
 ***@Configuration***
 Any class annotated with @Configuration becomes a JavaConfig for Spring. It tells Spring about which Java classes are to 
 be managed by spring. this class can be used for AutoWiring as well as manual JavaConfig wiring.
 
 Here I am using Autowiring with the help of ComponentScan annotation.
 
 ***@ComponentScan(##packege-name##)***
 This annotation is telling Spring to scan this package for @Componant annotated Java Classes whose 
 instantiation will be managed by Spring. If We don't specify package name then Spring takes that class's packege as 
 base package for component scanning. 
 
   
 



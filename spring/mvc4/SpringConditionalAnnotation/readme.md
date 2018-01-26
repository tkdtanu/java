Spring @Conditional Annotation
<br>

In this project we will look into @Condtional Annotation of Spring.
<br>
This Annation is provided by spring from 4.0 version . This will be helpfull to do configurations based on some Condtion.
<br>
In Spring MVC project we have to declare DispatcherServlet in web.xml file. But in spring boot we are not doing anything for that.
<br>
Spring @EnableAutoConfiguration will do all these for us.
<br>
it will check in the class path. If spring boot-starter is there on class path it will automatically generate Dispatcher Servlet for us.
<br>
<br>

This all things happens based on one annoation . which is @Conditional. This annatation is accepting one parameter. Which is the Condition Class name. i.e @Conditional(OnBeanCondition.class).It can accept multiple parameters also.
<br>
Here OnBeanCondtion is a class which is implementing  Condition interface and override one method => boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
<br>
if this method will give true then only the bean of the class which is annotated with @COndital will create. otherwise it will not create.
<br>
There are many Othe annotation which uses @Conditional and create some other annation.
<br>
ConditionalOnBean.class
<br>
ConditionalOnClass.class
<br>
ConditionalOnExpression.class
<br>

There are many other annotations also.

Typically all Auto Configuration classes look at other classes available in the classpath. If specific classes are available in the classpath, then configuration for that functionality is enabled through auto configuration. Annotations like @ConditionalOnClass, @ConditionalOnMissingBean help in providing these features!
<br>
<br>
@ConditionalOnClass({ DataSource.class, EmbeddedDatabaseType.class }) : This configuration is enabled only when these classes are available in the classpath.

<br>
<br>
@ConditionalOnMissingBean : This bean is configured only if there is no other bean configured with the same name
<br>

You can turn debug logging by adding a simple property value to application.properties.
<br>
logging.level.org.springframework: DEBUG
<br>
When you restart the application, you would see an auto configuration report printed in the log.
<br>
<br>
All auto configuration logic is implemented in spring-boot-autoconfigure.jar. All auto configuration logic for mvc, data, jms and other frameworks is present in a single jar.
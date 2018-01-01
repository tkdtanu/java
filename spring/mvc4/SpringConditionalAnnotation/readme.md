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


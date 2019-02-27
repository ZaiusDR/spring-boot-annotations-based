# Spring Boot Annotations and Java based config Notes

This are some notes while doing the tutorial.

## Anotations

### Component Scan

To activate annotations components scan:

`applicationContext.xml`

```
<context:component-scan base-package="path.to.package">
```

### @Component Annotation

To convert a plain Class to a Spring Bean use the @Component annotation:

```
@Component
public class MyClass {
...
...
```

It's possible to use a custom name for the Bean (`@Component("myCustomName")`), otherwise, the Class name will be used
with first lowercase letter (`myClass`)


### @Autowired Annotation

In order to inject a Bean into a constructor, it's possible to use @Autowired annotation:

 ```
public class MyClass {
 
    private MyType myAttribute;
    
    @Autowired
    public MyClass(MyType myAttribute) {
        this.myAttribute = myAttribute
    }
    ...
```

Spring looks for a Bean which implements `MyType` interface, so there must be only **one**, unless you complement
with the `@Qualifier("beanId")` annotation.

`@Autowired` annotation also works with Setter methods or fields:

```
public class MyClass {
 
    @Autowired
    private MyType myAttribute;
    ...
```

You don't even need a constructor for the dependency to be injected. Also the field can be private. Not bad!


### @Value Annotation

The setup is the same than with the XML based configuration, but instead of using `property` in the XML file,
it's possible to add the annotation to a field. Of course is necessary a properties file:

```
public class MyClass {
 
    @Value("user.email")
    private String email;
...
```

### @PostConstruct / @PreDestroy Annotations

Works exactly the same than the `init-method` and `destroy-method` in XML configuration.


### @Scope Annotation

Also pretty much the same than in XML configuration. Just indicate the scope type inside the annotation:

```
@Component
@Scope("prototype")
public class MyClass {

    private String email;
...
```

---

## Java Config

### @Configuration Annotation

It can be used in a class to convert it to a Spring Configuration class.

```
@Configuration
public class MyAppConfig {
}
```

Also is possible to activate the components scan with `@ComponentScan` annotation indicating the base package:

```
@Configuration
@ComponentScan("path.to.your.pkg")
public class MyAppConfig {
}
```

### @Bean Annotation

```
@Configuration
public class MyAppConfig {
    
    @Bean
    public MyType myClass() {
        MyTypedClass myTypedClass = new MyTypedClass();
        return myTypedClass;
    }
}
```


**This only works without `@ComponentScan` annotation!! Also the Bean class shouldn't be marked 
with `@Component` annotation.**

### Property Values in Java Conf 

```
@Configuration
@PropertySource("classpath:application.properties")
public class MyAppConfig {

    @Value("${user.email}")
    private String email;
    
    ...

}
```
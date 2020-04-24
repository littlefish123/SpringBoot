This example walks you through the process of creating a basic batch-driven solution.

Read csv file and insert into USER table.

Difference between @Component and @Bean<br>

1. @Component auto detects and configure the bean using classpath scanning
   @Bean explicitly declares a single bean, rather than Spring do it automatically.s
   
2. @Component does not DECOUPLE the declaration of bean from class definition.
   @Bean DECOOUPLE declaration of bean from the class definition.
   
3. @Component - class level annotation
   @Bean - method level annotation and name of method serves as bean name.
   
4. @Component - no need to use @Configuration annotation
   @Bean - use within class which is annotated with @Configuration 
   
5. Cannot create a bean of a class using @Component, if the class is outside spring container
we can create a bean of a class using @Bean even if the class is present outside the spring containers

6. @Component has different specializations like @Controller, @Repository and @Services
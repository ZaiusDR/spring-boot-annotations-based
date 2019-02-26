package info.esuarez.springdemoannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringDemoAnnotationsApplication {

    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");*/

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportAppConfiguration.class);

        Coach theCoach = context.getBean("swimCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        context.close();

        SpringApplication.run(SpringDemoAnnotationsApplication.class, args);

    }

}

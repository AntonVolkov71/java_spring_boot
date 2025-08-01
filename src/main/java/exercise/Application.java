package exercise;

import exercise.annotation.LogExecutionTime;
import exercise.component.DefaultUserProperties;
import exercise.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Page page1 = new Page();
        page1.setSlug("1");
        page1.setName("Anton");
        page1.setBody("Volkov");

        Page page2 = new Page();
        page2.setSlug("2");
        page2.setName("Diana");
        page2.setBody("Volkova");

        Page page3 = new Page();
        page3.setSlug("1");
        page3.setName("Inna");
        page3.setBody("Volkova");

        Page page4 = new Page();
        page4.setSlug("1");
        page4.setName("Anton");
        page4.setBody("Volkov");

        System.out.println("A == D " + page1.equals(page2));
        System.out.println("A == I " + page1.equals(page3));
        System.out.println("A == A2 " + page1.equals(page4));



        ApplicationContext context =SpringApplication.run(Application.class, args);

        SomeService service =context.getBean(SomeService.class);

        for (Method method : SomeService.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                var startTime = System.currentTimeMillis();

                try {
                    method.invoke(service);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                long endTime = System.currentTimeMillis();

                long executionTime = endTime - startTime;

                System.out.println("exec method: " + method.getName());
                System.out.println("exec time: " + executionTime + " milliseconds");
            }
        }
    }
}

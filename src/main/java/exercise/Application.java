package exercise;

import exercise.annotation.LogExecutionTime;
import exercise.component.DefaultUserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
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

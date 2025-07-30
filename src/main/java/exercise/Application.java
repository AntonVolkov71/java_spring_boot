package exercise;

import exercise.annotation.LogExecutionTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        SomeService service = new SomeService();

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

package exercise;

import exercise.annotation.LogExecutionTime;
import exercise.component.DefaultUserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeService {
    @Autowired
    private DefaultUserProperties userInfo;

    @LogExecutionTime(enabled = true)
    public void serve() throws InterruptedException {
        Thread.sleep(1500);  // Выполняем какую-то задачу
    }

    @LogExecutionTime(enabled = true, threshold = 100)
    public void anotherMethod() {
        System.out.println("user name " + userInfo.getFullName());
        System.out.println("user age " + userInfo.getAge());
    }
}

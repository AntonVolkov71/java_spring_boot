package exercise;

import exercise.annotation.LogExecutionTime;

public class SomeService {
    @LogExecutionTime(enabled = true)
    public void serve() throws InterruptedException {
        Thread.sleep(1500);  // Выполняем какую-то задачу
    }

    @LogExecutionTime(enabled = true, threshold = 100)
    public void anotherMethod() {
    }
}

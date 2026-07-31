package my.work.stream.parallel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleComparisonTest {

    @Test
    void whenCompareExecutionTime_ParallelExecutionIsFaster() {
        var numberOfTimes = 10;
        var serialExecutionTime = SimpleComparison.getExecutionTime(SimpleComparison::serialStreamSum, numberOfTimes);
        var parallelExecutionTime = SimpleComparison.getExecutionTime(SimpleComparison::parallelStreamSum, numberOfTimes);

        System.out.printf("Serial execution time for %d executions: %d ms %n", numberOfTimes, serialExecutionTime);
        System.out.printf("Parallel execution time for %d executions: %d ms %n", numberOfTimes, parallelExecutionTime);

        assertTrue(serialExecutionTime > parallelExecutionTime);
    }

}
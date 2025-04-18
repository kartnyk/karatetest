package examples;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RunKarateTest {

    @Test
    void testAll() {
        Results results = Runner.path("classpath:examples")  // adjust if your features are elsewhere
                .relativeTo(getClass())
                .outputJunitXml(true)
                .outputCucumberJson(true)
                .parallel(1); // change to >1 for parallel test execution

        System.out.println("=========================================");
        System.out.println("Karate Test Summary:");
        System.out.println("Total Features Run   : " + results.getFeatureCount());
        System.out.println("Total Scenarios Run  : " + results.getScenarioCount());
        System.out.println("Scenarios Passed     : " + (results.getScenarioCount() - results.getFailCount()));
        System.out.println("Scenarios Failed     : " + results.getFailCount());

        if (results.getFailCount() > 0) {
            System.out.println(">>> Failed Scenarios:");
            results.getErrorMessages().forEach(System.out::println);
        }
        System.out.println("=========================================");

        assertEquals(0, results.getFailCount(), "There are Karate test failures");
    }
}

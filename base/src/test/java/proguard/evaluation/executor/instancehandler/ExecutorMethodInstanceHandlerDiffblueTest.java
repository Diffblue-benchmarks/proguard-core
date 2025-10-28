package proguard.evaluation.executor.instancehandler;

import static org.junit.Assert.assertFalse;
import java.util.HashMap;
import org.junit.Test;

public class ExecutorMethodInstanceHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}
   */
  @Test
  public void testReturnsOwnInstance() {
    // Arrange, Act and Assert
    assertFalse(
        (new ExecutorMethodInstanceHandler(new HashMap<>())).returnsOwnInstance("Internal Class Name", "Method Name"));
  }
}

package proguard.evaluation.executor.instancehandler;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExecutorMethodInstanceHandlerDiffblueTest {
  /**
   * Test {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}.
   *
   * <p>Method under test: {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExecutorMethodInstanceHandler.returnsOwnInstance(String, String)"})
  public void testReturnsOwnInstance() {
    // Arrange, Act and Assert
    assertFalse(
        (new ExecutorMethodInstanceHandler(new HashMap<>()))
            .returnsOwnInstance("Internal Class Name", "Method Name"));
  }
}

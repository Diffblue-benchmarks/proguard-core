package proguard.evaluation.executor.instancehandler;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExecutorMethodInstanceHandlerDiffblueTest {
  /**
   * Test {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}.
   *
   * <p>Method under test: {@link ExecutorMethodInstanceHandler#returnsOwnInstance(String, String)}
   */
  @Test
  @DisplayName("Test returnsOwnInstance(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.executor.instancehandler.ExecutorMethodInstanceHandler.returnsOwnInstance(java.lang.String, java.lang.String)"
  })
  void testReturnsOwnInstance() {
    // Arrange, Act and Assert
    assertFalse(
        (new ExecutorMethodInstanceHandler(new HashMap<>()))
            .returnsOwnInstance("Internal Class Name", "Method Name"));
  }
}

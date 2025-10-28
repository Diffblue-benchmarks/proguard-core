package proguard.evaluation.value.object.model.reflective;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.object.model.ClassLoaderModel;

public class ReflectiveModelDiffblueTest {
  /**
   * Method under test:
   * {@link ReflectiveModel#invokeStatic(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  public void testInvokeStatic() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ClassLoaderModel()).invokeStatic(null, null));
  }
}

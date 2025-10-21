package proguard.evaluation.value.object.model.reflective;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.object.model.ClassLoaderModel;

public class ReflectiveModelDiffblueTest {
  /**
   * Test {@link ReflectiveModel#invokeStatic(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModel#invokeStatic(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult ReflectiveModel.invokeStatic(MethodExecutionInfo, ValueCalculator)"
  })
  public void testInvokeStatic_whenNull_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> (new ClassLoaderModel()).invokeStatic(null, null));
  }
}

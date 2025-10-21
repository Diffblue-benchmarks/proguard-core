package proguard.evaluation.executor;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.executor.ReflectionExecutor.InstanceCopyResult;
import proguard.evaluation.value.object.AnalyzedObject;

public class ReflectionExecutorDiffblueTest {
  /**
   * Test InstanceCopyResult getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstanceCopyResult#InstanceCopyResult(AnalyzedObject, boolean)}
   *   <li>{@link InstanceCopyResult#getInstance()}
   *   <li>{@link InstanceCopyResult#isMutable()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstanceCopyResult.<init>(AnalyzedObject, boolean)",
    "AnalyzedObject InstanceCopyResult.getInstance()",
    "boolean InstanceCopyResult.isMutable()"
  })
  public void testInstanceCopyResultGettersAndSetters() {
    // Arrange and Act
    InstanceCopyResult actualInstanceCopyResult = new InstanceCopyResult(null, true);
    AnalyzedObject actualInstance = actualInstanceCopyResult.getInstance();

    // Assert
    assertNull(actualInstance);
    assertTrue(actualInstanceCopyResult.isMutable());
  }
}

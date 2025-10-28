package proguard.evaluation.executor;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.value.object.AnalyzedObject;

public class ReflectionExecutorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ReflectionExecutor.InstanceCopyResult#InstanceCopyResult(AnalyzedObject, boolean)}
   *   <li>{@link ReflectionExecutor.InstanceCopyResult#getInstance()}
   *   <li>{@link ReflectionExecutor.InstanceCopyResult#isMutable()}
   * </ul>
   */
  @Test
  public void testInstanceCopyResultGettersAndSetters() {
    // Arrange and Act
    ReflectionExecutor.InstanceCopyResult actualInstanceCopyResult = new ReflectionExecutor.InstanceCopyResult(null,
        true);
    AnalyzedObject actualInstance = actualInstanceCopyResult.getInstance();

    // Assert
    assertNull(actualInstance);
    assertTrue(actualInstanceCopyResult.isMutable());
  }
}

package proguard.evaluation.executor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.executor.instancehandler.ExecutorInstanceHandler;
import proguard.evaluation.executor.instancehandler.ExecutorMethodInstanceHandler;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.ReferenceValue;

public class StringReflectionExecutorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringReflectionExecutor.Builder#build()}
   *   <li>{@link StringReflectionExecutor.Builder#Builder(ClassPool)}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange and Act
    StringReflectionExecutor actualBuildResult = (new StringReflectionExecutor.Builder(KotlinConstants.dummyClassPool))
        .build();

    // Assert
    assertTrue(actualBuildResult.getDefaultInstanceHandler() instanceof ExecutorMethodInstanceHandler);
    assertTrue(actualBuildResult.getSupportedMethodSignatures().isEmpty());
  }

  /**
   * Method under test:
   * {@link StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}
   */
  @Test
  public void testGetInstanceOrCopyIfMutable() {
    // Arrange, Act and Assert
    assertFalse((new StringReflectionExecutor(KotlinConstants.dummyClassPool))
        .getInstanceOrCopyIfMutable(BasicValueFactory.REFERENCE_VALUE)
        .isPresent());
  }

  /**
   * Method under test:
   * {@link StringReflectionExecutor#getDefaultInstanceHandler()}
   */
  @Test
  public void testGetDefaultInstanceHandler() {
    // Arrange and Act
    ExecutorInstanceHandler actualDefaultInstanceHandler = (new StringReflectionExecutor(
        KotlinConstants.dummyClassPool)).getDefaultInstanceHandler();
    boolean actualReturnsOwnInstanceResult = actualDefaultInstanceHandler.returnsOwnInstance("foo", "foo");

    // Assert
    assertTrue(actualDefaultInstanceHandler instanceof ExecutorMethodInstanceHandler);
    assertFalse(actualDefaultInstanceHandler.returnsOwnInstance("Internal Class Name", "Method Name"));
    assertFalse(actualReturnsOwnInstanceResult);
  }

  /**
   * Method under test:
   * {@link StringReflectionExecutor#getSupportedMethodSignatures()}
   */
  @Test
  public void testGetSupportedMethodSignatures() {
    // Arrange, Act and Assert
    assertTrue((new StringReflectionExecutor(KotlinConstants.dummyClassPool)).getSupportedMethodSignatures().isEmpty());
  }

  /**
   * Method under test:
   * {@link StringReflectionExecutor#StringReflectionExecutor(ClassPool)}
   */
  @Test
  public void testNewStringReflectionExecutor() {
    // Arrange and Act
    StringReflectionExecutor actualStringReflectionExecutor = new StringReflectionExecutor(
        KotlinConstants.dummyClassPool);

    // Assert
    assertTrue(actualStringReflectionExecutor.getDefaultInstanceHandler() instanceof ExecutorMethodInstanceHandler);
    assertTrue(actualStringReflectionExecutor.getSupportedMethodSignatures().isEmpty());
  }
}

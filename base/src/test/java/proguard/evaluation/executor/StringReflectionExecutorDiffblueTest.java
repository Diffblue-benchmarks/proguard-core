package proguard.evaluation.executor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.executor.StringReflectionExecutor.Builder;
import proguard.evaluation.executor.instancehandler.ExecutorInstanceHandler;
import proguard.evaluation.executor.instancehandler.ExecutorMethodInstanceHandler;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.ReferenceValue;

public class StringReflectionExecutorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#Builder(ClassPool)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Builder.<init>(ClassPool)", "StringReflectionExecutor Builder.build()"})
  public void testBuilderBuild() {
    // Arrange and Act
    StringReflectionExecutor actualBuildResult =
        (new Builder(KotlinConstants.dummyClassPool)).build();

    // Assert
    assertTrue(
        actualBuildResult.getDefaultInstanceHandler() instanceof ExecutorMethodInstanceHandler);
    assertTrue(actualBuildResult.getSupportedMethodSignatures().isEmpty());
  }

  /**
   * Test {@link StringReflectionExecutor#StringReflectionExecutor(ClassPool)}.
   *
   * <p>Method under test: {@link StringReflectionExecutor#StringReflectionExecutor(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StringReflectionExecutor.<init>(ClassPool)"})
  public void testNewStringReflectionExecutor() {
    // Arrange and Act
    StringReflectionExecutor actualStringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);

    // Assert
    assertTrue(
        actualStringReflectionExecutor.getDefaultInstanceHandler()
            instanceof ExecutorMethodInstanceHandler);
    assertTrue(actualStringReflectionExecutor.getSupportedMethodSignatures().isEmpty());
  }

  /**
   * Test {@link StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}.
   *
   * <p>Method under test: {@link
   * StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "java.util.Optional StringReflectionExecutor.getInstanceOrCopyIfMutable(ReferenceValue)"
  })
  public void testGetInstanceOrCopyIfMutable() {
    // Arrange, Act and Assert
    assertFalse(
        (new StringReflectionExecutor(KotlinConstants.dummyClassPool))
            .getInstanceOrCopyIfMutable(BasicValueFactory.REFERENCE_VALUE)
            .isPresent());
  }

  /**
   * Test {@link StringReflectionExecutor#getDefaultInstanceHandler()}.
   *
   * <p>Method under test: {@link StringReflectionExecutor#getDefaultInstanceHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ExecutorInstanceHandler StringReflectionExecutor.getDefaultInstanceHandler()"
  })
  public void testGetDefaultInstanceHandler() {
    // Arrange and Act
    ExecutorInstanceHandler actualDefaultInstanceHandler =
        (new StringReflectionExecutor(KotlinConstants.dummyClassPool)).getDefaultInstanceHandler();
    boolean actualReturnsOwnInstanceResult =
        actualDefaultInstanceHandler.returnsOwnInstance("foo", "foo");

    // Assert
    assertTrue(actualDefaultInstanceHandler instanceof ExecutorMethodInstanceHandler);
    assertFalse(
        actualDefaultInstanceHandler.returnsOwnInstance("Internal Class Name", "Method Name"));
    assertFalse(actualReturnsOwnInstanceResult);
  }

  /**
   * Test {@link StringReflectionExecutor#getSupportedMethodSignatures()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringReflectionExecutor#getSupportedMethodSignatures()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set StringReflectionExecutor.getSupportedMethodSignatures()"})
  public void testGetSupportedMethodSignatures_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new StringReflectionExecutor(KotlinConstants.dummyClassPool))
            .getSupportedMethodSignatures()
            .isEmpty());
  }
}

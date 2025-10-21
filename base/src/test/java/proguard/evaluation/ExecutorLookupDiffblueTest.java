package proguard.evaluation;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.executor.Executor;
import proguard.evaluation.executor.StringReflectionExecutor;

public class ExecutorLookupDiffblueTest {
  /**
   * Test {@link ExecutorLookup#ExecutorLookup(List)}.
   *
   * <p>Method under test: {@link ExecutorLookup#ExecutorLookup(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExecutorLookup.<init>(List)"})
  public void testNewExecutorLookup() {
    // Arrange
    ArrayList<Executor> registeredExecutors = new ArrayList<>();
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));

    // Act
    ExecutorLookup actualExecutorLookup = new ExecutorLookup(registeredExecutors);

    // Assert
    assertFalse(actualExecutorLookup.hasExecutorFor(null));
    assertFalse(actualExecutorLookup.shouldTrackInstancesOf("Class Name"));
  }

  /**
   * Test {@link ExecutorLookup#ExecutorLookup(List)}.
   *
   * <p>Method under test: {@link ExecutorLookup#ExecutorLookup(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExecutorLookup.<init>(List)"})
  public void testNewExecutorLookup2() {
    // Arrange
    ArrayList<Executor> registeredExecutors = new ArrayList<>();
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));

    // Act
    ExecutorLookup actualExecutorLookup = new ExecutorLookup(registeredExecutors);

    // Assert
    assertFalse(actualExecutorLookup.hasExecutorFor(null));
    assertFalse(actualExecutorLookup.shouldTrackInstancesOf("Class Name"));
  }

  /**
   * Test {@link ExecutorLookup#ExecutorLookup(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not hasExecutorFor {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorLookup#ExecutorLookup(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExecutorLookup.<init>(List)"})
  public void testNewExecutorLookup_whenArrayList_thenReturnNotHasExecutorForNull() {
    // Arrange and Act
    ExecutorLookup actualExecutorLookup = new ExecutorLookup(new ArrayList<>());

    // Assert
    assertFalse(actualExecutorLookup.hasExecutorFor(null));
    assertFalse(actualExecutorLookup.shouldTrackInstancesOf("Class Name"));
  }

  /**
   * Test {@link ExecutorLookup#hasExecutorFor(MethodSignature)}.
   *
   * <p>Method under test: {@link ExecutorLookup#hasExecutorFor(MethodSignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExecutorLookup.hasExecutorFor(MethodSignature)"})
  public void testHasExecutorFor() {
    // Arrange, Act and Assert
    assertFalse(
        (new ExecutorLookup(new ArrayList<>()))
            .hasExecutorFor(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link ExecutorLookup#shouldTrackInstancesOf(String)} with {@code className}.
   *
   * <p>Method under test: {@link ExecutorLookup#shouldTrackInstancesOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExecutorLookup.shouldTrackInstancesOf(String)"})
  public void testShouldTrackInstancesOfWithClassName() {
    // Arrange, Act and Assert
    assertFalse((new ExecutorLookup(new ArrayList<>())).shouldTrackInstancesOf("Class Name"));
  }

  /**
   * Test {@link ExecutorLookup#shouldTrackInstancesOf(Clazz)} with {@code clazz}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorLookup#shouldTrackInstancesOf(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExecutorLookup.shouldTrackInstancesOf(Clazz)"})
  public void testShouldTrackInstancesOfWithClazz_whenLibraryClass_thenReturnFalse() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());

    // Act and Assert
    assertFalse(executorLookup.shouldTrackInstancesOf(new LibraryClass()));
  }
}

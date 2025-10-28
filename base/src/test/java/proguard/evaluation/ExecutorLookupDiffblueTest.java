package proguard.evaluation;

import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.executor.Executor;
import proguard.evaluation.executor.StringReflectionExecutor;

public class ExecutorLookupDiffblueTest {
  /**
   * Method under test: {@link ExecutorLookup#hasExecutorFor(MethodSignature)}
   */
  @Test
  public void testHasExecutorFor() {
    // Arrange, Act and Assert
    assertFalse(
        (new ExecutorLookup(new ArrayList<>())).hasExecutorFor(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse((new ExecutorLookup(new ArrayList<>())).hasExecutorFor(null));
  }

  /**
   * Method under test: {@link ExecutorLookup#shouldTrackInstancesOf(String)}
   */
  @Test
  public void testShouldTrackInstancesOf() {
    // Arrange, Act and Assert
    assertFalse((new ExecutorLookup(new ArrayList<>())).shouldTrackInstancesOf("Class Name"));
  }

  /**
   * Method under test: {@link ExecutorLookup#shouldTrackInstancesOf(Clazz)}
   */
  @Test
  public void testShouldTrackInstancesOf2() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());

    // Act and Assert
    assertFalse(executorLookup.shouldTrackInstancesOf(new LibraryClass()));
  }

  /**
   * Method under test: {@link ExecutorLookup#ExecutorLookup(List)}
   */
  @Test
  public void testNewExecutorLookup() {
    // Arrange and Act
    ExecutorLookup actualExecutorLookup = new ExecutorLookup(new ArrayList<>());

    // Assert
    assertFalse(actualExecutorLookup.hasExecutorFor(null));
    assertFalse(actualExecutorLookup.shouldTrackInstancesOf("Class Name"));
  }

  /**
   * Method under test: {@link ExecutorLookup#ExecutorLookup(List)}
   */
  @Test
  public void testNewExecutorLookup2() {
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
   * Method under test: {@link ExecutorLookup#ExecutorLookup(List)}
   */
  @Test
  public void testNewExecutorLookup3() {
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
}

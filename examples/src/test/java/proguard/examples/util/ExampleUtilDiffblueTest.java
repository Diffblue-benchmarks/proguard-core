package proguard.examples.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;

public class ExampleUtilDiffblueTest {
  /**
   * Test {@link ExampleUtil#createClassPool(Class[])}.
   *
   * <ul>
   *   <li>When {@link Object}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ExampleUtil#createClassPool(Class[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassPool ExampleUtil.createClassPool(Class[])"})
  public void testCreateClassPool_whenObject_thenReturnSizeIsOne() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertEquals(1, ExampleUtil.createClassPool(forNameResult).size());
  }

  /**
   * Test {@link ExampleUtil#addClass(ClassPool, Class[])}.
   *
   * <ul>
   *   <li>When {@link Object}.
   *   <li>Then {@link ClassPool#ClassPool()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ExampleUtil#addClass(ClassPool, Class[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExampleUtil.addClass(ClassPool, Class[])"})
  public void testAddClass_whenObject_thenClassPoolSizeIsOne() {
    // Arrange
    ClassPool classPool = new ClassPool();
    Class<Object> forNameResult = Object.class;

    // Act
    ExampleUtil.addClass(classPool, forNameResult);

    // Assert
    assertEquals(1, classPool.size());
  }

  /**
   * Test {@link ExampleUtil#executeMainMethod(ClassPool, String, String[])} with {@code classPool},
   * {@code internalClassName}, {@code arguments}.
   *
   * <p>Method under test: {@link ExampleUtil#executeMainMethod(ClassPool, String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExampleUtil.executeMainMethod(ClassPool, String, String[])"})
  public void testExecuteMainMethodWithClassPoolInternalClassNameArguments() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ExampleUtil.executeMainMethod(new ClassPool(), "Internal Class Name", "Arguments"));
  }

  /**
   * Test {@link ExampleUtil#executeMainMethod(ClassPool, String)} with {@code classPool}, {@code
   * internalClassName}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleUtil#executeMainMethod(ClassPool, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExampleUtil.executeMainMethod(ClassPool, String)"})
  public void testExecuteMainMethodWithClassPoolInternalClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ExampleUtil.executeMainMethod(new ClassPool(), "Internal Class Name"));
  }
}

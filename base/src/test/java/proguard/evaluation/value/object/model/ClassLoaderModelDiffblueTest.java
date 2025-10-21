package proguard.evaluation.value.object.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.reflective.ModelHelper;
import proguard.evaluation.value.object.model.reflective.ModelHelper.MethodExecutionContext;

public class ClassLoaderModelDiffblueTest {
  /**
   * Test {@link ClassLoaderModel#init(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassLoaderModel#init(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult ClassLoaderModel.init(MethodExecutionInfo, ValueCalculator)"})
  public void testInit_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> (new ClassLoaderModel()).init(null, null));
  }

  /**
   * Test {@link ClassLoaderModel#loadClass(MethodExecutionContext, Value, Value)} with {@code
   * context}, {@code classNameValue}, {@code resolve}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext,
   * Value, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassLoaderModel.loadClass(ModelHelper.MethodExecutionContext, Value, Value)"
  })
  public void testLoadClassWithContextClassNameValueResolve_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult =
        classLoaderModel.loadClass(
            new MethodExecutionContext(null, null),
            BasicValueFactory.DOUBLE_VALUE,
            BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualLoadClassResult.isAnyParameterUpdated());
    assertFalse(actualLoadClassResult.isInstanceUpdated());
    assertFalse(actualLoadClassResult.isResultValid());
    assertFalse(actualLoadClassResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassLoaderModel#loadClass(MethodExecutionContext, Value, Value)} with {@code
   * context}, {@code classNameValue}, {@code resolve}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext,
   * Value, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassLoaderModel.loadClass(ModelHelper.MethodExecutionContext, Value, Value)"
  })
  public void testLoadClassWithContextClassNameValueResolve_whenReference_value() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult =
        classLoaderModel.loadClass(
            new MethodExecutionContext(null, null),
            BasicValueFactory.REFERENCE_VALUE,
            BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualLoadClassResult.isAnyParameterUpdated());
    assertFalse(actualLoadClassResult.isInstanceUpdated());
    assertFalse(actualLoadClassResult.isResultValid());
    assertFalse(actualLoadClassResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassLoaderModel#loadClass(MethodExecutionContext, Value)} with {@code context},
   * {@code classNameValue}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext,
   * Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassLoaderModel.loadClass(ModelHelper.MethodExecutionContext, Value)"
  })
  public void testLoadClassWithContextClassNameValue_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult =
        classLoaderModel.loadClass(
            new MethodExecutionContext(null, null), BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualLoadClassResult.isAnyParameterUpdated());
    assertFalse(actualLoadClassResult.isInstanceUpdated());
    assertFalse(actualLoadClassResult.isResultValid());
    assertFalse(actualLoadClassResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassLoaderModel#loadClass(MethodExecutionContext, Value)} with {@code context},
   * {@code classNameValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext,
   * Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassLoaderModel.loadClass(ModelHelper.MethodExecutionContext, Value)"
  })
  public void testLoadClassWithContextClassNameValue_whenReference_value() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult =
        classLoaderModel.loadClass(
            new MethodExecutionContext(null, null), BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertFalse(actualLoadClassResult.isAnyParameterUpdated());
    assertFalse(actualLoadClassResult.isInstanceUpdated());
    assertFalse(actualLoadClassResult.isResultValid());
    assertFalse(actualLoadClassResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassLoaderModel#findLoadedClass(MethodExecutionContext, Value)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassLoaderModel#findLoadedClass(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassLoaderModel.findLoadedClass(ModelHelper.MethodExecutionContext, Value)"
  })
  public void testFindLoadedClass_whenDouble_value_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualFindLoadedClassResult =
        classLoaderModel.findLoadedClass(
            new MethodExecutionContext(null, null), BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualFindLoadedClassResult.isAnyParameterUpdated());
    assertFalse(actualFindLoadedClassResult.isInstanceUpdated());
    assertFalse(actualFindLoadedClassResult.isResultValid());
    assertFalse(actualFindLoadedClassResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassLoaderModel#findLoadedClass(MethodExecutionContext, Value)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassLoaderModel#findLoadedClass(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassLoaderModel.findLoadedClass(ModelHelper.MethodExecutionContext, Value)"
  })
  public void testFindLoadedClass_whenNull_thenReturnNotAnyParameterUpdated() {
    // Arrange and Act
    MethodResult actualFindLoadedClassResult =
        (new ClassLoaderModel()).findLoadedClass(null, BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualFindLoadedClassResult.isAnyParameterUpdated());
    assertFalse(actualFindLoadedClassResult.isInstanceUpdated());
    assertFalse(actualFindLoadedClassResult.isResultValid());
    assertFalse(actualFindLoadedClassResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassLoaderModel#findLoadedClass(MethodExecutionContext, Value)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassLoaderModel#findLoadedClass(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassLoaderModel.findLoadedClass(ModelHelper.MethodExecutionContext, Value)"
  })
  public void testFindLoadedClass_whenReference_value_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualFindLoadedClassResult =
        classLoaderModel.findLoadedClass(
            new MethodExecutionContext(null, null), BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertFalse(actualFindLoadedClassResult.isAnyParameterUpdated());
    assertFalse(actualFindLoadedClassResult.isInstanceUpdated());
    assertFalse(actualFindLoadedClassResult.isResultValid());
    assertFalse(actualFindLoadedClassResult.isReturnValuePresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ClassLoaderModel}
   *   <li>{@link ClassLoaderModel#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassLoaderModel.<init>()",
    "java.lang.String ClassLoaderModel.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", (new ClassLoaderModel()).getType());
  }
}

package proguard.evaluation.value.object.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.reflective.ModelHelper;
import proguard.evaluation.value.object.model.reflective.ModelHelper.MethodExecutionContext;

class ClassLoaderModelDiffblueTest {
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
  @DisplayName(
      "Test init(MethodExecutionInfo, ValueCalculator); when 'null'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassLoaderModel.init(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInit_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> (new ClassLoaderModel()).init(null, mock(ValueCalculator.class)));
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
  @DisplayName(
      "Test loadClass(MethodExecutionContext, Value, Value) with 'context', 'classNameValue', 'resolve'; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassLoaderModel.loadClass(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value, proguard.evaluation.value.Value)"
  })
  void testLoadClassWithContextClassNameValueResolve_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult =
        classLoaderModel.loadClass(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
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
  @DisplayName(
      "Test loadClass(MethodExecutionContext, Value, Value) with 'context', 'classNameValue', 'resolve'; when REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassLoaderModel.loadClass(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value, proguard.evaluation.value.Value)"
  })
  void testLoadClassWithContextClassNameValueResolve_whenReference_value() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult =
        classLoaderModel.loadClass(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
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
  @DisplayName(
      "Test loadClass(MethodExecutionContext, Value) with 'context', 'classNameValue'; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassLoaderModel.loadClass(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value)"
  })
  void testLoadClassWithContextClassNameValue_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult =
        classLoaderModel.loadClass(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
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
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext,
   * Value)}
   */
  @Test
  @DisplayName(
      "Test loadClass(MethodExecutionContext, Value) with 'context', 'classNameValue'; when REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassLoaderModel.loadClass(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value)"
  })
  void testLoadClassWithContextClassNameValue_whenReference_value() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult =
        classLoaderModel.loadClass(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
            BasicValueFactory.REFERENCE_VALUE);

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
  @DisplayName(
      "Test findLoadedClass(MethodExecutionContext, Value); when DOUBLE_VALUE; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassLoaderModel.findLoadedClass(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value)"
  })
  void testFindLoadedClass_whenDouble_value_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualFindLoadedClassResult =
        classLoaderModel.findLoadedClass(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
            BasicValueFactory.DOUBLE_VALUE);

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
  @DisplayName(
      "Test findLoadedClass(MethodExecutionContext, Value); when 'null'; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassLoaderModel.findLoadedClass(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value)"
  })
  void testFindLoadedClass_whenNull_thenReturnNotAnyParameterUpdated() {
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
  @DisplayName(
      "Test findLoadedClass(MethodExecutionContext, Value); when REFERENCE_VALUE; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassLoaderModel.findLoadedClass(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value)"
  })
  void testFindLoadedClass_whenReference_value_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualFindLoadedClassResult =
        classLoaderModel.findLoadedClass(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
            BasicValueFactory.REFERENCE_VALUE);

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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.object.model.ClassLoaderModel.<init>()",
    "java.lang.String proguard.evaluation.value.object.model.ClassLoaderModel.getType()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", (new ClassLoaderModel()).getType());
  }
}

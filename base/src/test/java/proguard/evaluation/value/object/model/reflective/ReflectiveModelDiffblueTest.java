package proguard.evaluation.value.object.model.reflective;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassConstants;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ClassLoaderModel;

class ReflectiveModelDiffblueTest {
  /**
   * Test {@link ReflectiveModel#invoke(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModel#invoke(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test invoke(MethodExecutionInfo, ValueCalculator); given ArrayList() add DOUBLE_VALUE; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ReflectiveModel.invoke(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInvoke_givenArrayListAddDouble_value_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    ArrayList<Value> valueList = new ArrayList<>();
    valueList.add(BasicValueFactory.DOUBLE_VALUE);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.getParameters()).thenReturn(valueList);
    when(methodExecutionInfo.getSignature())
        .thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    MethodResult actualInvokeResult =
        classLoaderModel.invoke(methodExecutionInfo, mock(ValueCalculator.class));

    // Assert
    verify(methodExecutionInfo).getParameters();
    verify(methodExecutionInfo).getSignature();
    assertFalse(actualInvokeResult.isAnyParameterUpdated());
    assertFalse(actualInvokeResult.isInstanceUpdated());
    assertFalse(actualInvokeResult.isResultValid());
    assertFalse(actualInvokeResult.isReturnValuePresent());
  }

  /**
   * Test {@link ReflectiveModel#invoke(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModel#invoke(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test invoke(MethodExecutionInfo, ValueCalculator); given ArrayList() add REFERENCE_VALUE; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ReflectiveModel.invoke(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInvoke_givenArrayListAddReference_value_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    ArrayList<Value> valueList = new ArrayList<>();
    valueList.add(BasicValueFactory.REFERENCE_VALUE);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.getParameters()).thenReturn(valueList);
    when(methodExecutionInfo.getSignature())
        .thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    MethodResult actualInvokeResult =
        classLoaderModel.invoke(methodExecutionInfo, mock(ValueCalculator.class));

    // Assert
    verify(methodExecutionInfo).getParameters();
    verify(methodExecutionInfo).getSignature();
    assertFalse(actualInvokeResult.isAnyParameterUpdated());
    assertFalse(actualInvokeResult.isInstanceUpdated());
    assertFalse(actualInvokeResult.isResultValid());
    assertFalse(actualInvokeResult.isReturnValuePresent());
  }

  /**
   * Test {@link ReflectiveModel#invoke(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodExecutionInfo#getLibraryClassPool()}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModel#invoke(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test invoke(MethodExecutionInfo, ValueCalculator); then calls getLibraryClassPool()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ReflectiveModel.invoke(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInvoke_thenCallsGetLibraryClassPool() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();
    Value value = mock(Value.class);
    when(value.referenceValue()).thenReturn(BasicValueFactory.REFERENCE_VALUE);
    when(value.isParticular()).thenReturn(true);

    ArrayList<Value> valueList = new ArrayList<>();
    valueList.add(value);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.getLibraryClassPool()).thenReturn(KotlinConstants.dummyClassPool);
    when(methodExecutionInfo.getProgramClassPool()).thenReturn(KotlinConstants.dummyClassPool);
    when(methodExecutionInfo.getParameters()).thenReturn(valueList);
    when(methodExecutionInfo.getSignature())
        .thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    MethodResult actualInvokeResult =
        classLoaderModel.invoke(methodExecutionInfo, mock(ValueCalculator.class));

    // Assert
    verify(methodExecutionInfo).getLibraryClassPool();
    verify(methodExecutionInfo).getParameters();
    verify(methodExecutionInfo).getProgramClassPool();
    verify(methodExecutionInfo).getSignature();
    verify(value).isParticular();
    verify(value).referenceValue();
    assertFalse(actualInvokeResult.isAnyParameterUpdated());
    assertFalse(actualInvokeResult.isInstanceUpdated());
    assertFalse(actualInvokeResult.isResultValid());
    assertFalse(actualInvokeResult.isReturnValuePresent());
  }

  /**
   * Test {@link ReflectiveModel#invokeStatic(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Given {@link ClassLoaderModel} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModel#invokeStatic(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test invokeStatic(MethodExecutionInfo, ValueCalculator); given ClassLoaderModel (default constructor); when 'null'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ReflectiveModel.invokeStatic(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInvokeStatic_givenClassLoaderModel_whenNull_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> (new ClassLoaderModel()).invokeStatic(null, mock(ValueCalculator.class)));
  }
}

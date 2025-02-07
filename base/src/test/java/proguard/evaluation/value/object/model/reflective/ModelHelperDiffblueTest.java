package proguard.evaluation.value.object.model.reflective;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.BasicMethodInfo;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.ArrayReferenceValue;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.IdentifiedArrayReferenceValue;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.evaluation.value.object.model.Model;
import proguard.evaluation.value.object.model.reflective.ModelHelper.MethodExecutionContext;

class ModelHelperDiffblueTest {
  /**
   * Test {@link ModelHelper#getConstructorHandlers(Class)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#getConstructorHandlers(Class)}
   */
  @Test
  @DisplayName("Test getConstructorHandlers(Class); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.evaluation.value.object.model.reflective.ModelHelper.getConstructorHandlers(java.lang.Class)"
  })
  void testGetConstructorHandlers_thenReturnEmpty() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Map<BasicMethodInfo, Method> actualConstructorHandlers =
        ModelHelper.getConstructorHandlers(modelClass);

    // Assert
    assertTrue(actualConstructorHandlers.isEmpty());
  }

  /**
   * Test {@link ModelHelper#getStaticMethodHandlers(Class)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#getStaticMethodHandlers(Class)}
   */
  @Test
  @DisplayName("Test getStaticMethodHandlers(Class); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.evaluation.value.object.model.reflective.ModelHelper.getStaticMethodHandlers(java.lang.Class)"
  })
  void testGetStaticMethodHandlers_thenReturnEmpty() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Map<BasicMethodInfo, Method> actualStaticMethodHandlers =
        ModelHelper.getStaticMethodHandlers(modelClass);

    // Assert
    assertTrue(actualStaticMethodHandlers.isEmpty());
  }

  /**
   * Test {@link ModelHelper#getDummyObject(Class)}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/ClassLoader;}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#getDummyObject(Class)}
   */
  @Test
  @DisplayName("Test getDummyObject(Class); then return Type is 'Ljava/lang/ClassLoader;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.model.reflective.ReflectiveModel proguard.evaluation.value.object.model.reflective.ModelHelper.getDummyObject(java.lang.Class)"
  })
  void testGetDummyObject_thenReturnTypeIsLjavaLangClassLoader() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", ModelHelper.getDummyObject(modelClass).getType());
  }

  /**
   * Test {@link ModelHelper#getSupportedMethods(Class)}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#getSupportedMethods(Class)}
   */
  @Test
  @DisplayName("Test getSupportedMethods(Class); then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.evaluation.value.object.model.reflective.ModelHelper.getSupportedMethods(java.lang.Class)"
  })
  void testGetSupportedMethods_thenReturnSizeIsThree() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Collection<BasicMethodInfo> actualSupportedMethods =
        ModelHelper.getSupportedMethods(modelClass);

    // Assert
    assertTrue(actualSupportedMethods instanceof List);
    assertEquals(3, actualSupportedMethods.size());
    assertEquals(
        "findLoadedClass", ((List<BasicMethodInfo>) actualSupportedMethods).get(0).getMethodName());
    assertEquals(
        "loadClass", ((List<BasicMethodInfo>) actualSupportedMethods).get(1).getMethodName());
    assertEquals(
        "loadClass", ((List<BasicMethodInfo>) actualSupportedMethods).get(2).getMethodName());
  }

  /**
   * Test {@link ModelHelper#allParticular(List)}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  @DisplayName(
      "Test allParticular(List); given DOUBLE_VALUE; when ArrayList() add DOUBLE_VALUE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.reflective.ModelHelper.allParticular(java.util.List)"
  })
  void testAllParticular_givenDouble_value_whenArrayListAddDouble_value_thenReturnFalse() {
    // Arrange
    ArrayList<Value> values = new ArrayList<>();
    values.add(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertFalse(ModelHelper.allParticular(values));
  }

  /**
   * Test {@link ModelHelper#allParticular(List)}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  @DisplayName(
      "Test allParticular(List); given DOUBLE_VALUE; when ArrayList() add DOUBLE_VALUE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.reflective.ModelHelper.allParticular(java.util.List)"
  })
  void testAllParticular_givenDouble_value_whenArrayListAddDouble_value_thenReturnFalse2() {
    // Arrange
    ArrayList<Value> values = new ArrayList<>();
    values.add(BasicValueFactory.DOUBLE_VALUE);
    values.add(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertFalse(ModelHelper.allParticular(values));
  }

  /**
   * Test {@link ModelHelper#allParticular(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  @DisplayName("Test allParticular(List); when ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.reflective.ModelHelper.allParticular(java.util.List)"
  })
  void testAllParticular_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ModelHelper.allParticular(new ArrayList<>()));
  }

  /**
   * Test {@link ModelHelper#areInstanceAndParametersParticular(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ModelHelper#areInstanceAndParametersParticular(MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test areInstanceAndParametersParticular(MethodExecutionInfo); given ArrayList() add DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.reflective.ModelHelper.areInstanceAndParametersParticular(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testAreInstanceAndParametersParticular_givenArrayListAddDouble_value() {
    // Arrange
    ArrayList<Value> valueList = new ArrayList<>();
    valueList.add(BasicValueFactory.DOUBLE_VALUE);
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.isParticular()).thenReturn(true);
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getInstanceNonStatic()).thenReturn(arrayReferenceValue);
    when(executionInfo.isInstanceMethod()).thenReturn(true);
    when(executionInfo.getParameters()).thenReturn(valueList);

    // Act
    boolean actualAreInstanceAndParametersParticularResult =
        ModelHelper.areInstanceAndParametersParticular(executionInfo);

    // Assert
    verify(executionInfo).getInstanceNonStatic();
    verify(executionInfo).getParameters();
    verify(executionInfo).isInstanceMethod();
    verify(arrayReferenceValue).isParticular();
    assertFalse(actualAreInstanceAndParametersParticularResult);
  }

  /**
   * Test {@link ModelHelper#areInstanceAndParametersParticular(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ModelHelper#areInstanceAndParametersParticular(MethodExecutionInfo)}
   */
  @Test
  @DisplayName("Test areInstanceAndParametersParticular(MethodExecutionInfo); given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.reflective.ModelHelper.areInstanceAndParametersParticular(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testAreInstanceAndParametersParticular_givenFalse() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.isInstanceMethod()).thenReturn(false);
    when(executionInfo.getParameters()).thenReturn(new ArrayList<>());

    // Act
    boolean actualAreInstanceAndParametersParticularResult =
        ModelHelper.areInstanceAndParametersParticular(executionInfo);

    // Assert
    verify(executionInfo).getParameters();
    verify(executionInfo).isInstanceMethod();
    assertTrue(actualAreInstanceAndParametersParticularResult);
  }

  /**
   * Test {@link ModelHelper#areInstanceAndParametersParticular(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ModelHelper#areInstanceAndParametersParticular(MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test areInstanceAndParametersParticular(MethodExecutionInfo); given REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.reflective.ModelHelper.areInstanceAndParametersParticular(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testAreInstanceAndParametersParticular_givenReference_value() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getInstanceNonStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);
    when(executionInfo.isInstanceMethod()).thenReturn(true);
    when(executionInfo.getParameters()).thenReturn(new ArrayList<>());

    // Act
    boolean actualAreInstanceAndParametersParticularResult =
        ModelHelper.areInstanceAndParametersParticular(executionInfo);

    // Assert
    verify(executionInfo).getInstanceNonStatic();
    verify(executionInfo).getParameters();
    verify(executionInfo).isInstanceMethod();
    assertFalse(actualAreInstanceAndParametersParticularResult);
  }

  /**
   * Test {@link ModelHelper#areInstanceAndParametersParticular(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ModelHelper#areInstanceAndParametersParticular(MethodExecutionInfo)}
   */
  @Test
  @DisplayName("Test areInstanceAndParametersParticular(MethodExecutionInfo); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.reflective.ModelHelper.areInstanceAndParametersParticular(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testAreInstanceAndParametersParticular_thenReturnTrue() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.isParticular()).thenReturn(true);
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getInstanceNonStatic()).thenReturn(arrayReferenceValue);
    when(executionInfo.isInstanceMethod()).thenReturn(true);
    when(executionInfo.getParameters()).thenReturn(new ArrayList<>());

    // Act
    boolean actualAreInstanceAndParametersParticularResult =
        ModelHelper.areInstanceAndParametersParticular(executionInfo);

    // Assert
    verify(executionInfo).getInstanceNonStatic();
    verify(executionInfo).getParameters();
    verify(executionInfo).isInstanceMethod();
    verify(arrayReferenceValue).isParticular();
    assertTrue(actualAreInstanceAndParametersParticularResult);
  }

  /**
   * Test {@link ModelHelper#executeViaHandler(MethodExecutionContext, Map, Model)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#executeViaHandler(MethodExecutionContext, Map, Model)}
   */
  @Test
  @DisplayName(
      "Test executeViaHandler(MethodExecutionContext, Map, Model); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.executeViaHandler(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, java.util.Map, proguard.evaluation.value.object.model.Model)"
  })
  void testExecuteViaHandler_thenThrowUnsupportedOperationException() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getSignature())
        .thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    MethodExecutionContext context =
        new MethodExecutionContext(executionInfo, mock(ValueCalculator.class));

    HashMap<BasicMethodInfo, Method> handlers = new HashMap<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> ModelHelper.executeViaHandler(context, handlers, new ClassLoaderModel()));
    verify(executionInfo).getSignature();
  }

  /**
   * Test {@link ModelHelper#createDefaultConstructorResult(MethodExecutionContext, Model)}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#createDefaultConstructorResult(MethodExecutionContext,
   * Model)}
   */
  @Test
  @DisplayName(
      "Test createDefaultConstructorResult(MethodExecutionContext, Model); then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.createDefaultConstructorResult(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.object.model.Model)"
  })
  void testCreateDefaultConstructorResult_thenReturnNotAnyParameterUpdated() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getTargetType()).thenReturn("Target Type");
    when(executionInfo.getTargetClass()).thenReturn(new LibraryClass());
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    when(executionInfo.getSpecificInstance())
        .thenReturn(
            new IdentifiedReferenceValue("Type", referencedClass, true, true, valuefactory, "Id"));
    ValueCalculator valueCalculator = mock(ValueCalculator.class);
    when(valueCalculator.apply(
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            anyBoolean(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<Object>any()))
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
    MethodExecutionContext context = new MethodExecutionContext(executionInfo, valueCalculator);

    // Act
    MethodResult actualCreateDefaultConstructorResultResult =
        ModelHelper.createDefaultConstructorResult(context, new ClassLoaderModel());

    // Assert
    verify(valueCalculator)
        .apply(
            eq("Target Type"),
            isA(Clazz.class),
            eq(true),
            isA(Object.class),
            eq(false),
            isA(Object.class));
    verify(executionInfo).getSpecificInstance();
    verify(executionInfo).getTargetClass();
    verify(executionInfo).getTargetType();
    assertFalse(actualCreateDefaultConstructorResultResult.isAnyParameterUpdated());
    assertFalse(actualCreateDefaultConstructorResultResult.isReturnValuePresent());
    assertTrue(actualCreateDefaultConstructorResultResult.isInstanceUpdated());
    assertTrue(actualCreateDefaultConstructorResultResult.isResultValid());
    ReferenceValue expectedUpdatedInstance = valuefactory.REFERENCE_VALUE;
    assertSame(
        expectedUpdatedInstance, actualCreateDefaultConstructorResultResult.getUpdatedInstance());
  }

  /**
   * Test {@link ModelHelper#createDefaultConstructorResult(MethodExecutionContext, Model)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#createDefaultConstructorResult(MethodExecutionContext,
   * Model)}
   */
  @Test
  @DisplayName(
      "Test createDefaultConstructorResult(MethodExecutionContext, Model); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.createDefaultConstructorResult(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.object.model.Model)"
  })
  void testCreateDefaultConstructorResult_thenThrowIllegalStateException() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getTargetType()).thenReturn("Target Type");
    when(executionInfo.getTargetClass()).thenReturn(new LibraryClass());
    LibraryClass referencedClass = new LibraryClass();
    when(executionInfo.getSpecificInstance())
        .thenReturn(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));
    ValueCalculator valueCalculator = mock(ValueCalculator.class);
    when(valueCalculator.apply(
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            anyBoolean(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<Object>any()))
        .thenThrow(new IllegalStateException("foo"));
    MethodExecutionContext context = new MethodExecutionContext(executionInfo, valueCalculator);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> ModelHelper.createDefaultConstructorResult(context, new ClassLoaderModel()));
    verify(valueCalculator)
        .apply(
            eq("Target Type"),
            isA(Clazz.class),
            eq(true),
            isA(Object.class),
            eq(false),
            isA(Object.class));
    verify(executionInfo).getSpecificInstance();
    verify(executionInfo).getTargetClass();
    verify(executionInfo).getTargetType();
  }

  /**
   * Test {@link ModelHelper#createDefaultReturnResult(MethodExecutionContext, Object)}.
   *
   * <ul>
   *   <li>Then ReturnValue return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#createDefaultReturnResult(MethodExecutionContext,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test createDefaultReturnResult(MethodExecutionContext, Object); then ReturnValue return UnknownDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.createDefaultReturnResult(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, java.lang.Object)"
  })
  void testCreateDefaultReturnResult_thenReturnValueReturnUnknownDoubleValue() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getReturnType()).thenReturn("Return Type");
    when(executionInfo.getReturnClass()).thenReturn(new LibraryClass());
    ValueCalculator valueCalculator = mock(ValueCalculator.class);
    when(valueCalculator.apply(
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            anyBoolean(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<Object>any()))
        .thenReturn(BasicValueFactory.DOUBLE_VALUE);

    // Act
    MethodResult actualCreateDefaultReturnResultResult =
        ModelHelper.createDefaultReturnResult(
            new MethodExecutionContext(executionInfo, valueCalculator), "Concrete Value");

    // Assert
    verify(valueCalculator)
        .apply(
            eq("Return Type"), isA(Clazz.class), eq(true), isA(Object.class), eq(false), isNull());
    verify(executionInfo).getReturnClass();
    verify(executionInfo).getReturnType();
    Value returnValue = actualCreateDefaultReturnResultResult.getReturnValue();
    assertTrue(returnValue instanceof UnknownDoubleValue);
    assertFalse(actualCreateDefaultReturnResultResult.isAnyParameterUpdated());
    assertFalse(actualCreateDefaultReturnResultResult.isInstanceUpdated());
    assertFalse(returnValue.isParticular());
    assertFalse(returnValue.isSpecific());
    assertTrue(actualCreateDefaultReturnResultResult.isResultValid());
    assertTrue(actualCreateDefaultReturnResultResult.isReturnValuePresent());
    assertTrue(returnValue.isCategory2());
  }

  /**
   * Test {@link ModelHelper#createDefaultReturnResult(MethodExecutionContext, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#createDefaultReturnResult(MethodExecutionContext,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test createDefaultReturnResult(MethodExecutionContext, Object); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.createDefaultReturnResult(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, java.lang.Object)"
  })
  void testCreateDefaultReturnResult_thenThrowIllegalStateException() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getReturnType()).thenReturn("Return Type");
    when(executionInfo.getReturnClass()).thenReturn(new LibraryClass());
    ValueCalculator valueCalculator = mock(ValueCalculator.class);
    when(valueCalculator.apply(
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            anyBoolean(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<Object>any()))
        .thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            ModelHelper.createDefaultReturnResult(
                new MethodExecutionContext(executionInfo, valueCalculator), "Concrete Value"));
    verify(valueCalculator)
        .apply(
            eq("Return Type"), isA(Clazz.class), eq(true), isA(Object.class), eq(false), isNull());
    verify(executionInfo).getReturnClass();
    verify(executionInfo).getReturnType();
  }

  /**
   * Test {@link ModelHelper#createDefaultBuilderResult(MethodExecutionContext, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#createDefaultBuilderResult(MethodExecutionContext,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test createDefaultBuilderResult(MethodExecutionContext, Object); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.createDefaultBuilderResult(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, java.lang.Object)"
  })
  void testCreateDefaultBuilderResult_thenThrowIllegalStateException() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getReturnType()).thenReturn("Return Type");
    when(executionInfo.getReturnClass()).thenReturn(new LibraryClass());
    when(executionInfo.getInstanceNonStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);
    ValueCalculator valueCalculator = mock(ValueCalculator.class);
    when(valueCalculator.apply(
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            anyBoolean(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<Object>any()))
        .thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            ModelHelper.createDefaultBuilderResult(
                new MethodExecutionContext(executionInfo, valueCalculator), "New Instance"));
    verify(valueCalculator)
        .apply(
            eq("Return Type"), isA(Clazz.class), eq(true), isA(Object.class), eq(false), isNull());
    verify(executionInfo).getInstanceNonStatic();
    verify(executionInfo).getReturnClass();
    verify(executionInfo).getReturnType();
  }

  /**
   * Test {@link ModelHelper#createUnknownBuilderResult(MethodExecutionContext)}.
   *
   * <ul>
   *   <li>Then return InstanceUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#createUnknownBuilderResult(MethodExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test createUnknownBuilderResult(MethodExecutionContext); then return InstanceUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.createUnknownBuilderResult(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext)"
  })
  void testCreateUnknownBuilderResult_thenReturnInstanceUpdated() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getReturnType()).thenReturn("Return Type");
    when(executionInfo.getReturnClass()).thenReturn(new LibraryClass());
    LibraryClass referencedClass = new LibraryClass();
    when(executionInfo.getSpecificInstance())
        .thenReturn(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    when(executionInfo.getInstanceNonStatic())
        .thenReturn(
            new IdentifiedArrayReferenceValue(
                "Type", referencedClass2, true, BasicValueFactory.INTEGER_VALUE, valuefactory, 1));
    ValueCalculator valueCalculator = mock(ValueCalculator.class);
    when(valueCalculator.apply(
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            anyBoolean(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<Object>any()))
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    MethodResult actualCreateUnknownBuilderResultResult =
        ModelHelper.createUnknownBuilderResult(
            new MethodExecutionContext(executionInfo, valueCalculator));

    // Assert
    verify(valueCalculator)
        .apply(
            eq("Return Type"), isA(Clazz.class), eq(false), isNull(), eq(false), isA(Object.class));
    verify(executionInfo).getInstanceNonStatic();
    verify(executionInfo).getReturnClass();
    verify(executionInfo).getReturnType();
    verify(executionInfo).getSpecificInstance();
    assertTrue(actualCreateUnknownBuilderResultResult.isInstanceUpdated());
    assertTrue(actualCreateUnknownBuilderResultResult.isResultValid());
    assertTrue(actualCreateUnknownBuilderResultResult.isReturnValuePresent());
    ReferenceValue referenceValue = valuefactory.REFERENCE_VALUE;
    assertSame(referenceValue, actualCreateUnknownBuilderResultResult.getReturnValue());
    assertSame(referenceValue, actualCreateUnknownBuilderResultResult.getUpdatedInstance());
  }

  /**
   * Test {@link ModelHelper#createUnknownBuilderResult(MethodExecutionContext)}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#createUnknownBuilderResult(MethodExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test createUnknownBuilderResult(MethodExecutionContext); then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.createUnknownBuilderResult(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext)"
  })
  void testCreateUnknownBuilderResult_thenReturnNotAnyParameterUpdated() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getInstanceNonStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    MethodResult actualCreateUnknownBuilderResultResult =
        ModelHelper.createUnknownBuilderResult(
            new MethodExecutionContext(executionInfo, mock(ValueCalculator.class)));

    // Assert
    verify(executionInfo).getInstanceNonStatic();
    assertFalse(actualCreateUnknownBuilderResultResult.isAnyParameterUpdated());
    assertFalse(actualCreateUnknownBuilderResultResult.isInstanceUpdated());
    assertFalse(actualCreateUnknownBuilderResultResult.isResultValid());
    assertFalse(actualCreateUnknownBuilderResultResult.isReturnValuePresent());
  }

  /**
   * Test {@link ModelHelper#createUnknownBuilderResult(MethodExecutionContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#createUnknownBuilderResult(MethodExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test createUnknownBuilderResult(MethodExecutionContext); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.reflective.ModelHelper.createUnknownBuilderResult(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext)"
  })
  void testCreateUnknownBuilderResult_thenThrowIllegalStateException() {
    // Arrange
    MethodExecutionInfo executionInfo = mock(MethodExecutionInfo.class);
    when(executionInfo.getReturnType()).thenReturn("Return Type");
    when(executionInfo.getReturnClass()).thenReturn(new LibraryClass());
    LibraryClass referencedClass = new LibraryClass();
    when(executionInfo.getSpecificInstance())
        .thenReturn(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));
    LibraryClass referencedClass2 = new LibraryClass();
    when(executionInfo.getInstanceNonStatic())
        .thenReturn(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicValueFactory.INTEGER_VALUE,
                new ParticularReferenceValueFactory(),
                1));
    ValueCalculator valueCalculator = mock(ValueCalculator.class);
    when(valueCalculator.apply(
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            anyBoolean(),
            Mockito.<Object>any(),
            anyBoolean(),
            Mockito.<Object>any()))
        .thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            ModelHelper.createUnknownBuilderResult(
                new MethodExecutionContext(executionInfo, valueCalculator)));
    verify(valueCalculator)
        .apply(
            eq("Return Type"), isA(Clazz.class), eq(false), isNull(), eq(false), isA(Object.class));
    verify(executionInfo).getInstanceNonStatic();
    verify(executionInfo).getReturnClass();
    verify(executionInfo).getReturnType();
    verify(executionInfo).getSpecificInstance();
  }
}

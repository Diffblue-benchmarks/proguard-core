package proguard.evaluation.executor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.ReflectionExecutor.InstanceCopyResult;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.object.AnalyzedObject;

class ReflectionExecutorDiffblueTest {
  /**
   * Test {@link ReflectionExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodExecutionInfo#getSignature()}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectionExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); then calls getSignature()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectionExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_thenCallsGetSignature() {
    // Arrange
    StringReflectionExecutor stringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.returnsSameTypeAsInstance()).thenReturn(true);
    when(methodExecutionInfo.getReturnClass()).thenReturn(new LibraryClass());
    when(methodExecutionInfo.isConstructor()).thenReturn(false);
    when(methodExecutionInfo.getReturnType()).thenReturn("Return Type");
    when(methodExecutionInfo.isInstanceMethod()).thenReturn(true);
    when(methodExecutionInfo.getSignature())
        .thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    when(methodExecutionInfo.isStatic()).thenReturn(true);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    new IdentifiedReferenceValue("Type", referencedClass, true, true, valuefactory, "Id");

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
    MethodResult actualMethodResult =
        stringReflectionExecutor.getMethodResult(methodExecutionInfo, valueCalculator);

    // Assert
    verify(valueCalculator)
        .apply(eq("Return Type"), isA(Clazz.class), eq(false), isNull(), eq(true), isNull());
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo, atLeast(1)).getReturnClass();
    verify(methodExecutionInfo, atLeast(1)).getReturnType();
    verify(methodExecutionInfo, atLeast(1)).getSignature();
    verify(methodExecutionInfo).isConstructor();
    verify(methodExecutionInfo).isInstanceMethod();
    verify(methodExecutionInfo).isStatic();
    verify(methodExecutionInfo).returnsSameTypeAsInstance();
    assertFalse(actualMethodResult.isAnyParameterUpdated());
    assertFalse(actualMethodResult.isInstanceUpdated());
    assertTrue(actualMethodResult.isResultValid());
    assertTrue(actualMethodResult.isReturnValuePresent());
    DoubleValue expectedReturnValue = valuefactory.DOUBLE_VALUE;
    assertSame(expectedReturnValue, actualMethodResult.getReturnValue());
  }

  /**
   * Test {@link ReflectionExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectionExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectionExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_thenThrowIllegalStateException() {
    // Arrange
    StringReflectionExecutor stringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.getTargetType()).thenReturn("Target Type");
    when(methodExecutionInfo.getTargetClass()).thenReturn(new LibraryClass());
    LibraryClass referencedClass = new LibraryClass();
    when(methodExecutionInfo.getSpecificInstance())
        .thenReturn(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));
    when(methodExecutionInfo.isConstructor()).thenReturn(true);
    when(methodExecutionInfo.isInstanceMethod()).thenReturn(true);
    when(methodExecutionInfo.isStatic()).thenReturn(true);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
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
        () -> stringReflectionExecutor.getMethodResult(methodExecutionInfo, valueCalculator));
    verify(valueCalculator)
        .apply(
            eq("Target Type"), isA(Clazz.class), eq(false), isNull(), eq(false), isA(Object.class));
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo).getSpecificInstance();
    verify(methodExecutionInfo).getTargetClass();
    verify(methodExecutionInfo).getTargetType();
    verify(methodExecutionInfo).isConstructor();
    verify(methodExecutionInfo).isInstanceMethod();
    verify(methodExecutionInfo).isStatic();
  }

  /**
   * Test {@link ReflectionExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@link MethodExecutionInfo} {@link MethodExecutionInfo#getReturnClass()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectionExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); when MethodExecutionInfo getReturnClass() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectionExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_whenMethodExecutionInfoGetReturnClassReturnNull() {
    // Arrange
    StringReflectionExecutor stringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.returnsSameTypeAsInstance()).thenReturn(true);
    when(methodExecutionInfo.getReturnClass()).thenReturn(null);
    when(methodExecutionInfo.isConstructor()).thenReturn(false);
    when(methodExecutionInfo.getReturnType()).thenReturn("Return Type");
    when(methodExecutionInfo.isInstanceMethod()).thenReturn(true);
    when(methodExecutionInfo.getSignature())
        .thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    when(methodExecutionInfo.isStatic()).thenReturn(true);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    new IdentifiedReferenceValue("Type", referencedClass, true, true, valuefactory, "Id");

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
    MethodResult actualMethodResult =
        stringReflectionExecutor.getMethodResult(methodExecutionInfo, valueCalculator);

    // Assert
    verify(valueCalculator)
        .apply(eq("Return Type"), isNull(), eq(false), isNull(), eq(true), isNull());
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo, atLeast(1)).getReturnClass();
    verify(methodExecutionInfo, atLeast(1)).getReturnType();
    verify(methodExecutionInfo, atLeast(1)).getSignature();
    verify(methodExecutionInfo).isConstructor();
    verify(methodExecutionInfo).isInstanceMethod();
    verify(methodExecutionInfo).isStatic();
    verify(methodExecutionInfo).returnsSameTypeAsInstance();
    assertFalse(actualMethodResult.isAnyParameterUpdated());
    assertFalse(actualMethodResult.isInstanceUpdated());
    assertTrue(actualMethodResult.isResultValid());
    assertTrue(actualMethodResult.isReturnValuePresent());
    DoubleValue expectedReturnValue = valuefactory.DOUBLE_VALUE;
    assertSame(expectedReturnValue, actualMethodResult.getReturnValue());
  }

  /**
   * Test {@link ReflectionExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@link MethodExecutionInfo} {@link MethodExecutionInfo#returnsSameTypeAsInstance()}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectionExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); when MethodExecutionInfo returnsSameTypeAsInstance() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectionExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_whenMethodExecutionInfoReturnsSameTypeAsInstanceReturnFalse() {
    // Arrange
    StringReflectionExecutor stringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.returnsSameTypeAsInstance()).thenReturn(false);
    when(methodExecutionInfo.getReturnClass()).thenReturn(new LibraryClass());
    when(methodExecutionInfo.isConstructor()).thenReturn(false);
    when(methodExecutionInfo.getReturnType()).thenReturn("Return Type");
    when(methodExecutionInfo.isInstanceMethod()).thenReturn(true);
    when(methodExecutionInfo.isStatic()).thenReturn(true);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    new IdentifiedReferenceValue("Type", referencedClass, true, true, valuefactory, "Id");

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
    MethodResult actualMethodResult =
        stringReflectionExecutor.getMethodResult(methodExecutionInfo, valueCalculator);

    // Assert
    verify(valueCalculator)
        .apply(eq("Return Type"), isA(Clazz.class), eq(false), isNull(), eq(true), isNull());
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo, atLeast(1)).getReturnClass();
    verify(methodExecutionInfo, atLeast(1)).getReturnType();
    verify(methodExecutionInfo).isConstructor();
    verify(methodExecutionInfo).isInstanceMethod();
    verify(methodExecutionInfo).isStatic();
    verify(methodExecutionInfo).returnsSameTypeAsInstance();
    assertFalse(actualMethodResult.isAnyParameterUpdated());
    assertFalse(actualMethodResult.isInstanceUpdated());
    assertTrue(actualMethodResult.isResultValid());
    assertTrue(actualMethodResult.isReturnValuePresent());
    DoubleValue expectedReturnValue = valuefactory.DOUBLE_VALUE;
    assertSame(expectedReturnValue, actualMethodResult.getReturnValue());
  }

  /**
   * Test InstanceCopyResult getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstanceCopyResult#InstanceCopyResult(AnalyzedObject, boolean)}
   *   <li>{@link InstanceCopyResult#getInstance()}
   *   <li>{@link InstanceCopyResult#isMutable()}
   * </ul>
   */
  @Test
  @DisplayName("Test InstanceCopyResult getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.executor.ReflectionExecutor$InstanceCopyResult.<init>(proguard.evaluation.value.object.AnalyzedObject, boolean)",
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.executor.ReflectionExecutor$InstanceCopyResult.getInstance()",
    "boolean proguard.evaluation.executor.ReflectionExecutor$InstanceCopyResult.isMutable()"
  })
  void testInstanceCopyResultGettersAndSetters() {
    // Arrange
    AnalyzedObject instance = mock(AnalyzedObject.class);

    // Act
    InstanceCopyResult actualInstanceCopyResult = new InstanceCopyResult(instance, true);
    AnalyzedObject actualInstance = actualInstanceCopyResult.getInstance();

    // Assert
    assertTrue(actualInstanceCopyResult.isMutable());
    assertSame(instance, actualInstance);
  }
}

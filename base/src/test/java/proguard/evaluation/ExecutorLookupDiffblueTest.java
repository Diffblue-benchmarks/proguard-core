package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.executor.Executor;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.executor.StringReflectionExecutor;
import proguard.evaluation.value.ArrayReferenceValue;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.TypedReferenceValue;

class ExecutorLookupDiffblueTest {
  /**
   * Test {@link ExecutorLookup#ExecutorLookup(List)}.
   *
   * <p>Method under test: {@link ExecutorLookup#ExecutorLookup(List)}
   */
  @Test
  @DisplayName("Test new ExecutorLookup(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.ExecutorLookup.<init>(java.util.List)"})
  void testNewExecutorLookup() {
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
  @DisplayName("Test new ExecutorLookup(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.ExecutorLookup.<init>(java.util.List)"})
  void testNewExecutorLookup2() {
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
  @DisplayName(
      "Test new ExecutorLookup(List); when ArrayList(); then return not hasExecutorFor 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.ExecutorLookup.<init>(java.util.List)"})
  void testNewExecutorLookup_whenArrayList_thenReturnNotHasExecutorForNull() {
    // Arrange and Act
    ExecutorLookup actualExecutorLookup = new ExecutorLookup(new ArrayList<>());

    // Assert
    assertFalse(actualExecutorLookup.hasExecutorFor(null));
    assertFalse(actualExecutorLookup.shouldTrackInstancesOf("Class Name"));
  }

  /**
   * Test {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}.
   *
   * <p>Method under test: {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}
   */
  @Test
  @DisplayName("Test lookupExecutor(MethodExecutionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.Executor proguard.evaluation.ExecutorLookup.lookupExecutor(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testLookupExecutor() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());
    MethodExecutionInfo info = mock(MethodExecutionInfo.class);
    when(info.getInstanceNonStatic())
        .thenReturn(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE));
    when(info.isInstanceMethod()).thenReturn(true);
    when(info.getSignature()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    doNothing().when(info).setResolvedTargetSignature(Mockito.<MethodSignature>any());

    // Act
    Executor actualLookupExecutorResult = executorLookup.lookupExecutor(info);

    // Assert
    verify(info, atLeast(1)).getInstanceNonStatic();
    verify(info).getSignature();
    verify(info).isInstanceMethod();
    verify(info).setResolvedTargetSignature(isA(MethodSignature.class));
    assertNull(actualLookupExecutorResult);
  }

  /**
   * Test {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@link ArrayReferenceValue} {@link TypedReferenceValue#getType()} return empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test lookupExecutor(MethodExecutionInfo); given ArrayReferenceValue getType() return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.Executor proguard.evaluation.ExecutorLookup.lookupExecutor(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testLookupExecutor_givenArrayReferenceValueGetTypeReturnEmptyString() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.getType()).thenReturn("");
    MethodExecutionInfo info = mock(MethodExecutionInfo.class);
    when(info.getInstanceNonStatic()).thenReturn(arrayReferenceValue);
    when(info.isInstanceMethod()).thenReturn(true);
    when(info.getSignature()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    doNothing().when(info).setResolvedTargetSignature(Mockito.<MethodSignature>any());

    // Act
    Executor actualLookupExecutorResult = executorLookup.lookupExecutor(info);

    // Assert
    verify(info, atLeast(1)).getInstanceNonStatic();
    verify(info).getSignature();
    verify(info).isInstanceMethod();
    verify(info).setResolvedTargetSignature(isA(MethodSignature.class));
    verify(arrayReferenceValue, atLeast(1)).getType();
    assertNull(actualLookupExecutorResult);
  }

  /**
   * Test {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@link ArrayReferenceValue} {@link TypedReferenceValue#getType()} return {@code
   *       Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test lookupExecutor(MethodExecutionInfo); given ArrayReferenceValue getType() return 'Ljava/lang/Object;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.Executor proguard.evaluation.ExecutorLookup.lookupExecutor(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testLookupExecutor_givenArrayReferenceValueGetTypeReturnLjavaLangObject() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.getType()).thenReturn("Ljava/lang/Object;");
    MethodExecutionInfo info = mock(MethodExecutionInfo.class);
    when(info.getInstanceNonStatic()).thenReturn(arrayReferenceValue);
    when(info.isInstanceMethod()).thenReturn(true);
    when(info.getSignature()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    doNothing().when(info).setResolvedTargetSignature(Mockito.<MethodSignature>any());

    // Act
    Executor actualLookupExecutorResult = executorLookup.lookupExecutor(info);

    // Assert
    verify(info, atLeast(1)).getInstanceNonStatic();
    verify(info).getSignature();
    verify(info).isInstanceMethod();
    verify(info).setResolvedTargetSignature(isA(MethodSignature.class));
    verify(arrayReferenceValue, atLeast(1)).getType();
    assertNull(actualLookupExecutorResult);
  }

  /**
   * Test {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@link ArrayReferenceValue} {@link TypedReferenceValue#getType()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test lookupExecutor(MethodExecutionInfo); given ArrayReferenceValue getType() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.Executor proguard.evaluation.ExecutorLookup.lookupExecutor(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testLookupExecutor_givenArrayReferenceValueGetTypeReturnNull() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.getType()).thenReturn(null);
    MethodExecutionInfo info = mock(MethodExecutionInfo.class);
    when(info.getInstanceNonStatic()).thenReturn(arrayReferenceValue);
    when(info.isInstanceMethod()).thenReturn(true);
    when(info.getSignature()).thenReturn(MethodSignature.UNKNOWN);
    doNothing().when(info).setResolvedTargetSignature(Mockito.<MethodSignature>any());

    // Act
    Executor actualLookupExecutorResult = executorLookup.lookupExecutor(info);

    // Assert
    verify(info, atLeast(1)).getInstanceNonStatic();
    verify(info).getSignature();
    verify(info).isInstanceMethod();
    verify(info).setResolvedTargetSignature(isA(MethodSignature.class));
    verify(arrayReferenceValue).getType();
    assertNull(actualLookupExecutorResult);
  }

  /**
   * Test {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@link ArrayReferenceValue} {@link TypedReferenceValue#getType()} return {@code
   *       Type}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test lookupExecutor(MethodExecutionInfo); given ArrayReferenceValue getType() return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.Executor proguard.evaluation.ExecutorLookup.lookupExecutor(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testLookupExecutor_givenArrayReferenceValueGetTypeReturnType() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.getType()).thenReturn("Type");
    MethodExecutionInfo info = mock(MethodExecutionInfo.class);
    when(info.getInstanceNonStatic()).thenReturn(arrayReferenceValue);
    when(info.isInstanceMethod()).thenReturn(true);
    when(info.getSignature()).thenReturn(MethodSignature.UNKNOWN);
    doNothing().when(info).setResolvedTargetSignature(Mockito.<MethodSignature>any());

    // Act
    Executor actualLookupExecutorResult = executorLookup.lookupExecutor(info);

    // Assert
    verify(info, atLeast(1)).getInstanceNonStatic();
    verify(info).getSignature();
    verify(info).isInstanceMethod();
    verify(info).setResolvedTargetSignature(isA(MethodSignature.class));
    verify(arrayReferenceValue, atLeast(1)).getType();
    assertNull(actualLookupExecutorResult);
  }

  /**
   * Test {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link MethodExecutionInfo} {@link MethodExecutionInfo#isInstanceMethod()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test lookupExecutor(MethodExecutionInfo); given 'false'; when MethodExecutionInfo isInstanceMethod() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.Executor proguard.evaluation.ExecutorLookup.lookupExecutor(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testLookupExecutor_givenFalse_whenMethodExecutionInfoIsInstanceMethodReturnFalse() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());
    MethodExecutionInfo info = mock(MethodExecutionInfo.class);
    when(info.isInstanceMethod()).thenReturn(false);
    when(info.getSignature()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    doNothing().when(info).setResolvedTargetSignature(Mockito.<MethodSignature>any());

    // Act
    Executor actualLookupExecutorResult = executorLookup.lookupExecutor(info);

    // Assert
    verify(info).getSignature();
    verify(info).isInstanceMethod();
    verify(info).setResolvedTargetSignature(isA(MethodSignature.class));
    assertNull(actualLookupExecutorResult);
  }

  /**
   * Test {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutorLookup#lookupExecutor(MethodExecutionInfo)}
   */
  @Test
  @DisplayName("Test lookupExecutor(MethodExecutionInfo); given REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.Executor proguard.evaluation.ExecutorLookup.lookupExecutor(proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testLookupExecutor_givenReference_value() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());
    MethodExecutionInfo info = mock(MethodExecutionInfo.class);
    when(info.getInstanceNonStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);
    when(info.isInstanceMethod()).thenReturn(true);
    when(info.getSignature()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    doNothing().when(info).setResolvedTargetSignature(Mockito.<MethodSignature>any());

    // Act
    Executor actualLookupExecutorResult = executorLookup.lookupExecutor(info);

    // Assert
    verify(info).getInstanceNonStatic();
    verify(info).getSignature();
    verify(info).isInstanceMethod();
    verify(info).setResolvedTargetSignature(isA(MethodSignature.class));
    assertNull(actualLookupExecutorResult);
  }

  /**
   * Test {@link ExecutorLookup#hasExecutorFor(MethodSignature)}.
   *
   * <p>Method under test: {@link ExecutorLookup#hasExecutorFor(MethodSignature)}
   */
  @Test
  @DisplayName("Test hasExecutorFor(MethodSignature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.ExecutorLookup.hasExecutorFor(proguard.classfile.MethodSignature)"
  })
  void testHasExecutorFor() {
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
  @DisplayName("Test shouldTrackInstancesOf(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.ExecutorLookup.shouldTrackInstancesOf(java.lang.String)"
  })
  void testShouldTrackInstancesOfWithClassName() {
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
  @DisplayName(
      "Test shouldTrackInstancesOf(Clazz) with 'clazz'; when LibraryClass(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.ExecutorLookup.shouldTrackInstancesOf(proguard.classfile.Clazz)"
  })
  void testShouldTrackInstancesOfWithClazz_whenLibraryClass_thenReturnFalse() {
    // Arrange
    ExecutorLookup executorLookup = new ExecutorLookup(new ArrayList<>());

    // Act and Assert
    assertFalse(executorLookup.shouldTrackInstancesOf(new LibraryClass()));
  }
}

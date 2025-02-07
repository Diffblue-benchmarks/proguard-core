package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.ExecutingInvocationUnit.Builder;
import proguard.evaluation.executor.Executor;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.executor.StringReflectionExecutor;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;

class ExecutingInvocationUnitDiffblueTest {
  /**
   * Test Builder {@link Builder#build(ValueFactory)}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build(ValueFactory)}
   *   <li>{@link Builder#Builder(ClassPool, ClassPool)}
   *   <li>{@link Builder#setEnableSameInstanceIdApproximation(boolean)}
   *   <li>{@link Builder#useDefaultStringReflectionExecutor(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ExecutingInvocationUnit$Builder.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool)",
    "proguard.evaluation.ExecutingInvocationUnit proguard.evaluation.ExecutingInvocationUnit$Builder.build(proguard.evaluation.value.ValueFactory)",
    "proguard.evaluation.ExecutingInvocationUnit$Builder proguard.evaluation.ExecutingInvocationUnit$Builder.setEnableSameInstanceIdApproximation(boolean)",
    "proguard.evaluation.ExecutingInvocationUnit$Builder proguard.evaluation.ExecutingInvocationUnit$Builder.useDefaultStringReflectionExecutor(boolean)"
  })
  void testBuilderBuild() {
    // Arrange
    Builder useDefaultStringReflectionExecutorResult =
        (new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .setEnableSameInstanceIdApproximation(true)
            .useDefaultStringReflectionExecutor(true);

    // Act
    ExecutingInvocationUnit actualBuildResult =
        useDefaultStringReflectionExecutorResult.build(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildResult.method);
    assertNull(actualBuildResult.stack);
    assertNull(actualBuildResult.variables);
    assertFalse(actualBuildResult.isLoad);
    assertFalse(actualBuildResult.isStatic);
  }

  /**
   * Test Builder {@link Builder#buildWithoutDefaults(ValueFactory)}.
   *
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @DisplayName("Test Builder buildWithoutDefaults(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.ExecutingInvocationUnit proguard.evaluation.ExecutingInvocationUnit$Builder.buildWithoutDefaults(proguard.evaluation.value.ValueFactory)"
  })
  void testBuilderBuildWithoutDefaults() {
    // Arrange
    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult =
        builder.buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(
        actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Test Builder {@link Builder#buildWithoutDefaults(ValueFactory)}.
   *
   * <ul>
   *   <li>Then calls {@link Executor.Builder#build()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @DisplayName("Test Builder buildWithoutDefaults(ValueFactory); then calls build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.ExecutingInvocationUnit proguard.evaluation.ExecutingInvocationUnit$Builder.buildWithoutDefaults(proguard.evaluation.value.ValueFactory)"
  })
  void testBuilderBuildWithoutDefaults_thenCallsBuild() {
    // Arrange
    Executor.Builder<Executor> executor = mock(Executor.Builder.class);
    when(executor.build()).thenReturn(new StringReflectionExecutor(KotlinConstants.dummyClassPool));

    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    builder.addExecutor(executor);

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult =
        builder.buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    verify(executor).build();
    assertTrue(
        actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Test {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory,
   * boolean, List)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool,
   * ClassPool, ValueFactory, boolean, List)}
   */
  @Test
  @DisplayName(
      "Test new ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory, boolean, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ExecutingInvocationUnit.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.evaluation.value.ValueFactory, boolean, java.util.List)"
  })
  void testNewExecutingInvocationUnit() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ArrayList<Executor> registeredExecutors = new ArrayList<>();
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualExecutingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            registeredExecutors);

    // Assert
    assertTrue(
        actualExecutingInvocationUnit.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualExecutingInvocationUnit.method);
    assertNull(actualExecutingInvocationUnit.stack);
    assertNull(actualExecutingInvocationUnit.variables);
    assertFalse(actualExecutingInvocationUnit.isLoad);
    assertFalse(actualExecutingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory,
   * boolean, List)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool,
   * ClassPool, ValueFactory, boolean, List)}
   */
  @Test
  @DisplayName(
      "Test new ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory, boolean, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ExecutingInvocationUnit.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.evaluation.value.ValueFactory, boolean, java.util.List)"
  })
  void testNewExecutingInvocationUnit2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ArrayList<Executor> registeredExecutors = new ArrayList<>();
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualExecutingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            registeredExecutors);

    // Assert
    assertTrue(
        actualExecutingInvocationUnit.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualExecutingInvocationUnit.method);
    assertNull(actualExecutingInvocationUnit.stack);
    assertNull(actualExecutingInvocationUnit.variables);
    assertFalse(actualExecutingInvocationUnit.isLoad);
    assertFalse(actualExecutingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory,
   * boolean, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool,
   * ClassPool, ValueFactory, boolean, List)}
   */
  @Test
  @DisplayName(
      "Test new ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory, boolean, List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ExecutingInvocationUnit.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.evaluation.value.ValueFactory, boolean, java.util.List)"
  })
  void testNewExecutingInvocationUnit_whenArrayList() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    ExecutingInvocationUnit actualExecutingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());

    // Assert
    assertTrue(
        actualExecutingInvocationUnit.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualExecutingInvocationUnit.method);
    assertNull(actualExecutingInvocationUnit.stack);
    assertNull(actualExecutingInvocationUnit.variables);
    assertFalse(actualExecutingInvocationUnit.isLoad);
    assertFalse(actualExecutingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ExecutingInvocationUnit#methodMayHaveSideEffects(Clazz, AnyMethodrefConstant,
   * String)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#methodMayHaveSideEffects(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName("Test methodMayHaveSideEffects(Clazz, AnyMethodrefConstant, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.ExecutingInvocationUnit.methodMayHaveSideEffects(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testMethodMayHaveSideEffects() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(
        executingInvocationUnit.methodMayHaveSideEffects(
            clazz, new InterfaceMethodrefConstant(), "Return Type"));
  }

  /**
   * Test {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   * with {@code clazz}, {@code anyMethodrefConstant}, {@code returnType}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'returnType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        executingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Return Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Return Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((IdentifiedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodReturnValue).mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   * with {@code clazz}, {@code anyMethodrefConstant}, {@code returnType}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'returnType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        executingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Return Type"));
  }

  /**
   * Test {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   * with {@code clazz}, {@code anyMethodrefConstant}, {@code returnType}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'returnType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType3() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        executingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Return Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof MultiTypedReferenceValue);
    assertEquals("Return Type", ((MultiTypedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualMethodReturnValue).getGeneralizedType();
    assertEquals("Return Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(
        1, ((MultiTypedReferenceValue) actualMethodReturnValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualMethodReturnValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   * with {@code clazz}, {@code anyMethodrefConstant}, {@code returnType}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'returnType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType4() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        executingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Return Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof MultiTypedReferenceValue);
    assertEquals("Return Type", ((MultiTypedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualMethodReturnValue).getGeneralizedType();
    assertEquals("Return Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(
        1, ((MultiTypedReferenceValue) actualMethodReturnValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualMethodReturnValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   * with {@code clazz}, {@code anyMethodrefConstant}, {@code returnType}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'returnType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType5() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        executingInvocationUnit.getMethodReturnValue(
            clazz,
            new InterfaceMethodrefConstant(
                1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor")),
            "Return Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Return Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((IdentifiedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodReturnValue).mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   * with {@code clazz}, {@code anyMethodrefConstant}, {@code returnType}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @DisplayName(
      "Test getMethodReturnValue(Clazz, AnyMethodrefConstant, String) with 'clazz', 'anyMethodrefConstant', 'returnType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getMethodReturnValue(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant, java.lang.String)"
  })
  void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType6() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        executingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Return Type"));
  }

  /**
   * Test {@link ExecutingInvocationUnit#executeMethod(Executor, MethodExecutionInfo)} with {@code
   * executor}, {@code methodInfo}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#executeMethod(Executor,
   * MethodExecutionInfo)}
   */
  @Test
  @DisplayName("Test executeMethod(Executor, MethodExecutionInfo) with 'executor', 'methodInfo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.ExecutingInvocationUnit.executeMethod(proguard.evaluation.executor.Executor, proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testExecuteMethodWithExecutorMethodInfo() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    StringReflectionExecutor executor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    MethodExecutionInfo methodInfo = mock(MethodExecutionInfo.class);
    LibraryClass clazz = new LibraryClass();
    when(methodInfo.getCaller())
        .thenReturn(new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2));
    when(methodInfo.getTargetType()).thenReturn("Target Type");
    LibraryClass libraryClass = new LibraryClass();
    when(methodInfo.getTargetClass()).thenReturn(libraryClass);
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    when(methodInfo.getSpecificInstance()).thenReturn(identifiedReferenceValue);
    when(methodInfo.isInstanceMethod()).thenReturn(true);
    when(methodInfo.isConstructor()).thenReturn(true);
    when(methodInfo.isStatic()).thenReturn(true);
    when(methodInfo.getInstanceOrNullIfStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    MethodResult actualExecuteMethodResult =
        executingInvocationUnit.executeMethod(executor, methodInfo);

    // Assert
    verify(methodInfo).getCaller();
    verify(methodInfo).getInstanceOrNullIfStatic();
    verify(methodInfo).getSpecificInstance();
    verify(methodInfo).getTargetClass();
    verify(methodInfo).getTargetType();
    verify(methodInfo).isConstructor();
    verify(methodInfo).isInstanceMethod();
    verify(methodInfo).isStatic();
    ReferenceValue updatedInstance = actualExecuteMethodResult.getUpdatedInstance();
    Clazz referencedClass2 = updatedInstance.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(updatedInstance instanceof IdentifiedReferenceValue);
    Object object = ((IdentifiedReferenceValue) updatedInstance).id;
    assertEquals("Id", object);
    assertEquals("Target Type", updatedInstance.getType());
    assertEquals(0, updatedInstance.isNull());
    assertFalse(updatedInstance.mayBeExtension());
    assertFalse(updatedInstance.isParticular());
    assertTrue(updatedInstance.isSpecific());
    assertSame(libraryClass, referencedClass2);
    assertSame(identifiedReferenceValue.id, object);
  }

  /**
   * Test {@link ExecutingInvocationUnit#executeMethod(Executor, MethodExecutionInfo)} with {@code
   * executor}, {@code methodInfo}.
   *
   * <ul>
   *   <li>Then calls {@link ValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   *       Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#executeMethod(Executor,
   * MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test executeMethod(Executor, MethodExecutionInfo) with 'executor', 'methodInfo'; then calls createReferenceValueForId(String, Clazz, boolean, boolean, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.ExecutingInvocationUnit.executeMethod(proguard.evaluation.executor.Executor, proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testExecuteMethodWithExecutorMethodInfo_thenCallsCreateReferenceValueForId() {
    // Arrange
    ValueFactory valueFactory = mock(ValueFactory.class);
    when(valueFactory.createReferenceValueForId(
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<Object>any()))
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    StringReflectionExecutor executor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    MethodExecutionInfo methodInfo = mock(MethodExecutionInfo.class);
    LibraryClass clazz = new LibraryClass();
    when(methodInfo.getCaller())
        .thenReturn(new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2));
    when(methodInfo.getTargetType()).thenReturn("Target Type");
    when(methodInfo.getTargetClass()).thenReturn(new LibraryClass());
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    when(methodInfo.getSpecificInstance())
        .thenReturn(
            new IdentifiedReferenceValue("Type", referencedClass, true, true, valuefactory, "Id"));
    when(methodInfo.isInstanceMethod()).thenReturn(true);
    when(methodInfo.isConstructor()).thenReturn(true);
    when(methodInfo.isStatic()).thenReturn(true);
    when(methodInfo.getInstanceOrNullIfStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    MethodResult actualExecuteMethodResult =
        executingInvocationUnit.executeMethod(executor, methodInfo);

    // Assert
    verify(methodInfo).getCaller();
    verify(methodInfo).getInstanceOrNullIfStatic();
    verify(methodInfo).getSpecificInstance();
    verify(methodInfo).getTargetClass();
    verify(methodInfo).getTargetType();
    verify(methodInfo).isConstructor();
    verify(methodInfo).isInstanceMethod();
    verify(methodInfo).isStatic();
    verify(valueFactory)
        .createReferenceValueForId(
            eq("Target Type"), isA(Clazz.class), eq(false), eq(true), isA(Object.class));
    ReferenceValue expectedUpdatedInstance = valuefactory.REFERENCE_VALUE;
    assertSame(expectedUpdatedInstance, actualExecuteMethodResult.getUpdatedInstance());
  }

  /**
   * Test {@link ExecutingInvocationUnit#executeMethod(Executor, MethodExecutionInfo)} with {@code
   * executor}, {@code methodInfo}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#executeMethod(Executor,
   * MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test executeMethod(Executor, MethodExecutionInfo) with 'executor', 'methodInfo'; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.ExecutingInvocationUnit.executeMethod(proguard.evaluation.executor.Executor, proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testExecuteMethodWithExecutorMethodInfo_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ValueFactory valueFactory = mock(ValueFactory.class);
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    MethodExecutionInfo methodInfo = mock(MethodExecutionInfo.class);
    when(methodInfo.returnsSameTypeAsInstance()).thenReturn(true);
    when(methodInfo.returnsVoid()).thenReturn(true);
    when(methodInfo.getInstanceOrNullIfStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    MethodResult actualExecuteMethodResult =
        executingInvocationUnit.executeMethod(null, methodInfo);

    // Assert
    verify(methodInfo).getInstanceOrNullIfStatic();
    verify(methodInfo).returnsSameTypeAsInstance();
    verify(methodInfo).returnsVoid();
    assertFalse(actualExecuteMethodResult.isAnyParameterUpdated());
    assertFalse(actualExecuteMethodResult.isInstanceUpdated());
    assertFalse(actualExecuteMethodResult.isReturnValuePresent());
    assertTrue(actualExecuteMethodResult.isResultValid());
  }

  /**
   * Test {@link ExecutingInvocationUnit#executeMethod(Executor, MethodExecutionInfo)} with {@code
   * executor}, {@code methodInfo}.
   *
   * <ul>
   *   <li>Then return UpdatedParameters Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#executeMethod(Executor,
   * MethodExecutionInfo)}
   */
  @Test
  @DisplayName(
      "Test executeMethod(Executor, MethodExecutionInfo) with 'executor', 'methodInfo'; then return UpdatedParameters Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.ExecutingInvocationUnit.executeMethod(proguard.evaluation.executor.Executor, proguard.evaluation.executor.MethodExecutionInfo)"
  })
  void testExecuteMethodWithExecutorMethodInfo_thenReturnUpdatedParametersEmpty() {
    // Arrange
    ValueFactory valueFactory = mock(ValueFactory.class);
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    Executor executor = mock(Executor.class);
    MethodResult.Builder setUpdatedInstanceResult =
        (new MethodResult.Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();
    when(executor.getMethodResult(
            Mockito.<MethodExecutionInfo>any(), Mockito.<ValueCalculator>any()))
        .thenReturn(buildResult);
    MethodExecutionInfo methodInfo = mock(MethodExecutionInfo.class);
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    new IdentifiedReferenceValue("Type", referencedClass, true, true, valuefactory, "Id");

    // Act
    MethodResult actualExecuteMethodResult =
        executingInvocationUnit.executeMethod(executor, methodInfo);

    // Assert
    verify(executor).getMethodResult(isA(MethodExecutionInfo.class), isA(ValueCalculator.class));
    assertTrue(actualExecuteMethodResult.getUpdatedParameters().isEmpty());
    assertTrue(actualExecuteMethodResult.isAnyParameterUpdated());
    ReferenceValue expectedUpdatedInstance = valuefactory.REFERENCE_VALUE;
    assertSame(expectedUpdatedInstance, actualExecuteMethodResult.getUpdatedInstance());
  }

  /**
   * Test {@link ExecutingInvocationUnit#canExecute(MethodSignature)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#canExecute(MethodSignature)}
   */
  @Test
  @DisplayName("Test canExecute(MethodSignature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.ExecutingInvocationUnit.canExecute(proguard.classfile.MethodSignature)"
  })
  void testCanExecute() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertFalse(
        (new ExecutingInvocationUnit(
                KotlinConstants.dummyClassPool,
                KotlinConstants.dummyClassPool,
                valueFactory,
                true,
                new ArrayList<>()))
            .canExecute(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link ExecutingInvocationUnit#supportsAnyMethodOf(String)} with {@code className}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#supportsAnyMethodOf(String)}
   */
  @Test
  @DisplayName("Test supportsAnyMethodOf(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.ExecutingInvocationUnit.supportsAnyMethodOf(java.lang.String)"
  })
  void testSupportsAnyMethodOfWithClassName() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertFalse(
        (new ExecutingInvocationUnit(
                KotlinConstants.dummyClassPool,
                KotlinConstants.dummyClassPool,
                valueFactory,
                true,
                new ArrayList<>()))
            .supportsAnyMethodOf("Class Name"));
  }

  /**
   * Test {@link ExecutingInvocationUnit#supportsAnyMethodOf(Clazz)} with {@code clazz}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#supportsAnyMethodOf(Clazz)}
   */
  @Test
  @DisplayName(
      "Test supportsAnyMethodOf(Clazz) with 'clazz'; when LibraryClass(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.ExecutingInvocationUnit.supportsAnyMethodOf(proguard.classfile.Clazz)"
  })
  void testSupportsAnyMethodOfWithClazz_whenLibraryClass_thenReturnFalse() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());

    // Act and Assert
    assertFalse(executingInvocationUnit.supportsAnyMethodOf(new LibraryClass()));
  }

  /**
   * Test {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @DisplayName("Test getFieldValue(Clazz, FieldrefConstant, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualFieldValue).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualFieldValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualFieldValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualFieldValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @DisplayName("Test getFieldValue(Clazz, FieldrefConstant, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue2() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualFieldValue).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualFieldValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualFieldValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualFieldValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @DisplayName("Test getFieldValue(Clazz, FieldrefConstant, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualFieldValue =
        executingInvocationUnit.getFieldValue(
            clazz,
            new FieldrefConstant(1, 1, referencedClass, new LibraryField(24, "Name", "Descriptor")),
            "Type");

    // Assert
    assertTrue(actualFieldValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldValue).getType());
    assertNull(((IdentifiedReferenceValue) actualFieldValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldValue).mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
  }

  /**
   * Test {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(Clazz, FieldrefConstant, String); then return BasicValueFactory (default constructor) REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue_thenReturnBasicValueFactoryReference_value() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type"));
  }

  /**
   * Test {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(Clazz, FieldrefConstant, String); then return IdentifiedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue_thenReturnIdentifiedReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldValue).getType());
    assertNull(((IdentifiedReferenceValue) actualFieldValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldValue).mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
  }

  /**
   * Test {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return {@link PrimitiveTypedReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(Clazz, FieldrefConstant, String); then return PrimitiveTypedReferenceValueFactory (default constructor) REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ExecutingInvocationUnit.getFieldValue(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant, java.lang.String)"
  })
  void testGetFieldValue_thenReturnPrimitiveTypedReferenceValueFactoryReference_value() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type"));
  }
}

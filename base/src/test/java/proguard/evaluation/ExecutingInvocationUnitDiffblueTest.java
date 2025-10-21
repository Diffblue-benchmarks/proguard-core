package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import proguard.evaluation.executor.ObjectGetClassExecutor;
import proguard.evaluation.executor.ReflectiveModelExecutor;
import proguard.evaluation.executor.ReflectiveModelExecutor.SupportedModelInfo;
import proguard.evaluation.executor.StringReflectionExecutor;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.util.BasicHierarchyProvider;

public class ExecutingInvocationUnitDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Builder.<init>(ClassPool, ClassPool)",
    "ExecutingInvocationUnit Builder.build(ValueFactory)",
    "Builder Builder.setEnableSameInstanceIdApproximation(boolean)",
    "Builder Builder.useDefaultStringReflectionExecutor(boolean)"
  })
  public void testBuilderBuild() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutingInvocationUnit Builder.buildWithoutDefaults(ValueFactory)"})
  public void testBuilderBuildWithoutDefaults() {
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
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutingInvocationUnit Builder.buildWithoutDefaults(ValueFactory)"})
  public void testBuilderBuildWithoutDefaults2() {
    // Arrange
    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

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
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutingInvocationUnit Builder.buildWithoutDefaults(ValueFactory)"})
  public void testBuilderBuildWithoutDefaults3() {
    // Arrange
    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

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
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutingInvocationUnit Builder.buildWithoutDefaults(ValueFactory)"})
  public void testBuilderBuildWithoutDefaults4() {
    // Arrange
    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ReflectiveModelExecutor.Builder(
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)));

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
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutingInvocationUnit Builder.buildWithoutDefaults(ValueFactory)"})
  public void testBuilderBuildWithoutDefaults5() {
    // Arrange
    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    builder.addExecutor(new StringReflectionExecutor.Builder(KotlinConstants.dummyClassPool));

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
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutingInvocationUnit Builder.buildWithoutDefaults(ValueFactory)"})
  public void testBuilderBuildWithoutDefaults6() {
    // Arrange
    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    builder.addExecutor(new StringReflectionExecutor.Builder(KotlinConstants.dummyClassPool));

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
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutingInvocationUnit Builder.buildWithoutDefaults(ValueFactory)"})
  public void testBuilderBuildWithoutDefaults7() {
    // Arrange
    ReflectiveModelExecutor.Builder executor =
        new ReflectiveModelExecutor.Builder(
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;
    executor.addSupportedModel(new SupportedModelInfo<>(modelClass, true));

    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    builder.addExecutor(executor);

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
   * <p>Method under test: {@link Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutingInvocationUnit Builder.buildWithoutDefaults(ValueFactory)"})
  public void testBuilderBuildWithoutDefaults8() {
    // Arrange
    ReflectiveModelExecutor.Builder executor =
        new ReflectiveModelExecutor.Builder(
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;
    executor.addSupportedModel(new SupportedModelInfo<>(modelClass, true));
    Class<ClassLoaderModel> modelClass2 = ClassLoaderModel.class;
    executor.addSupportedModel(new SupportedModelInfo<>(modelClass2, true));

    Builder builder = new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    builder.addExecutor(executor);

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
   * Test {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory,
   * boolean, List)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool,
   * ClassPool, ValueFactory, boolean, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExecutingInvocationUnit.<init>(ClassPool, ClassPool, ValueFactory, boolean, List)"
  })
  public void testNewExecutingInvocationUnit() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExecutingInvocationUnit.<init>(ClassPool, ClassPool, ValueFactory, boolean, List)"
  })
  public void testNewExecutingInvocationUnit2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExecutingInvocationUnit.<init>(ClassPool, ClassPool, ValueFactory, boolean, List)"
  })
  public void testNewExecutingInvocationUnit_whenArrayList() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ExecutingInvocationUnit.methodMayHaveSideEffects(Clazz, AnyMethodrefConstant, String)"
  })
  public void testMethodMayHaveSideEffects() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantReturnType6() {
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
   * Test {@link ExecutingInvocationUnit#canExecute(MethodSignature)}.
   *
   * <p>Method under test: {@link ExecutingInvocationUnit#canExecute(MethodSignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExecutingInvocationUnit.canExecute(MethodSignature)"})
  public void testCanExecute() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExecutingInvocationUnit.supportsAnyMethodOf(String)"})
  public void testSupportsAnyMethodOfWithClassName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExecutingInvocationUnit.supportsAnyMethodOf(Clazz)"})
  public void testSupportsAnyMethodOfWithClazz_whenLibraryClass_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue_thenReturnBasicValueFactoryReference_value() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue_thenReturnIdentifiedReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ExecutingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue_thenReturnPrimitiveTypedReferenceValueFactoryReference_value() {
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

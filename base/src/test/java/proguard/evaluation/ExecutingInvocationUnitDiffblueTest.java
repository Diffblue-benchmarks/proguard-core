package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
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
import proguard.evaluation.executor.Executor;
import proguard.evaluation.executor.ObjectGetClassExecutor;
import proguard.evaluation.executor.ReflectiveModelExecutor;
import proguard.evaluation.executor.StringReflectionExecutor;
import proguard.evaluation.executor.model.ClassLoaderModelExecutor;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.util.BasicHierarchyProvider;

public class ExecutingInvocationUnitDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExecutingInvocationUnit.Builder#build(ValueFactory)}
   *   <li>{@link ExecutingInvocationUnit.Builder#Builder(ClassPool, ClassPool)}
   *   <li>
   * {@link ExecutingInvocationUnit.Builder#setEnableSameInstanceIdApproximation(boolean)}
   *   <li>
   * {@link ExecutingInvocationUnit.Builder#useDefaultStringReflectionExecutor(boolean)}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange
    ExecutingInvocationUnit.Builder useDefaultStringReflectionExecutorResult = (new ExecutingInvocationUnit.Builder(
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)).setEnableSameInstanceIdApproximation(true)
            .useDefaultStringReflectionExecutor(true);

    // Act
    ExecutingInvocationUnit actualBuildResult = useDefaultStringReflectionExecutorResult
        .build(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildResult.method);
    assertNull(actualBuildResult.stack);
    assertNull(actualBuildResult.variables);
    assertFalse(actualBuildResult.isLoad);
    assertFalse(actualBuildResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit.Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  public void testBuilderBuildWithoutDefaults() {
    // Arrange
    ExecutingInvocationUnit.Builder builder = new ExecutingInvocationUnit.Builder(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult = builder
        .buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit.Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  public void testBuilderBuildWithoutDefaults2() {
    // Arrange
    ExecutingInvocationUnit.Builder builder = new ExecutingInvocationUnit.Builder(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult = builder
        .buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit.Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  public void testBuilderBuildWithoutDefaults3() {
    // Arrange
    ExecutingInvocationUnit.Builder builder = new ExecutingInvocationUnit.Builder(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult = builder
        .buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit.Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  public void testBuilderBuildWithoutDefaults4() {
    // Arrange
    ExecutingInvocationUnit.Builder builder = new ExecutingInvocationUnit.Builder(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    builder.addExecutor(new ReflectiveModelExecutor.Builder(
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)));

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult = builder
        .buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit.Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  public void testBuilderBuildWithoutDefaults5() {
    // Arrange
    ExecutingInvocationUnit.Builder builder = new ExecutingInvocationUnit.Builder(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    builder.addExecutor(new StringReflectionExecutor.Builder(KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult = builder
        .buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit.Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  public void testBuilderBuildWithoutDefaults6() {
    // Arrange
    ExecutingInvocationUnit.Builder builder = new ExecutingInvocationUnit.Builder(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    builder.addExecutor(new StringReflectionExecutor.Builder(KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult = builder
        .buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit.Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  public void testBuilderBuildWithoutDefaults7() {
    // Arrange
    ExecutingInvocationUnit.Builder builder = new ExecutingInvocationUnit.Builder(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ClassLoaderModelExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult = builder
        .buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit.Builder#buildWithoutDefaults(ValueFactory)}
   */
  @Test
  public void testBuilderBuildWithoutDefaults8() {
    // Arrange
    ExecutingInvocationUnit.Builder builder = new ExecutingInvocationUnit.Builder(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    builder.addExecutor(
        new ObjectGetClassExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    builder.addExecutor(
        new ClassLoaderModelExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualBuildWithoutDefaultsResult = builder
        .buildWithoutDefaults(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBuildWithoutDefaultsResult.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBuildWithoutDefaultsResult.method);
    assertNull(actualBuildWithoutDefaultsResult.stack);
    assertNull(actualBuildWithoutDefaultsResult.variables);
    assertFalse(actualBuildWithoutDefaultsResult.isLoad);
    assertFalse(actualBuildWithoutDefaultsResult.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#methodMayHaveSideEffects(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testMethodMayHaveSideEffects() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(
        executingInvocationUnit.methodMayHaveSideEffects(clazz, new InterfaceMethodrefConstant(), "Return Type"));
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = executingInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(), "Return Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Return Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodReturnValue).mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        executingInvocationUnit.getMethodReturnValue(clazz, new InterfaceMethodrefConstant(), "Return Type"));
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue3() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = executingInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(), "Return Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof MultiTypedReferenceValue);
    assertEquals("Return Type", ((MultiTypedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualMethodReturnValue).getGeneralizedType();
    assertEquals("Return Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualMethodReturnValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(actualMethodReturnValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualMethodReturnValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue4() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = executingInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(), "Return Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof MultiTypedReferenceValue);
    assertEquals("Return Type", ((MultiTypedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualMethodReturnValue).getGeneralizedType();
    assertEquals("Return Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualMethodReturnValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(actualMethodReturnValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualMethodReturnValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue5() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodReturnValue = executingInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor")),
        "Return Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Return Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodReturnValue).mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue6() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        executingInvocationUnit.getMethodReturnValue(clazz, new InterfaceMethodrefConstant(), "Return Type"));
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#canExecute(MethodSignature)}
   */
  @Test
  public void testCanExecute() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertFalse((new ExecutingInvocationUnit(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool,
        valueFactory, true, new ArrayList<>())).canExecute(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#canExecute(MethodSignature)}
   */
  @Test
  public void testCanExecute2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertFalse((new ExecutingInvocationUnit(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool,
        valueFactory, true, new ArrayList<>())).canExecute(null));
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#supportsAnyMethodOf(String)}
   */
  @Test
  public void testSupportsAnyMethodOf() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertFalse((new ExecutingInvocationUnit(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool,
        valueFactory, true, new ArrayList<>())).supportsAnyMethodOf("Class Name"));
  }

  /**
   * Method under test: {@link ExecutingInvocationUnit#supportsAnyMethodOf(Clazz)}
   */
  @Test
  public void testSupportsAnyMethodOf2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());

    // Act and Assert
    assertFalse(executingInvocationUnit.supportsAnyMethodOf(new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualFieldValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isCategory2());
    assertFalse(actualFieldValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldValue).mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type"));
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue3() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualFieldValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualFieldValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualFieldValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualFieldValue).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualFieldValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldValue.isCategory2());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(actualFieldValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualFieldValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue4() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualFieldValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualFieldValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualFieldValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualFieldValue).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualFieldValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldValue.isCategory2());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(actualFieldValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualFieldValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue5() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualFieldValue = executingInvocationUnit.getFieldValue(clazz,
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(24, "Name", "Descriptor")), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualFieldValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isCategory2());
    assertFalse(actualFieldValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldValue).mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue6() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type"));
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory, boolean, List)}
   */
  @Test
  public void testNewExecutingInvocationUnit() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    ExecutingInvocationUnit actualExecutingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());

    // Assert
    assertTrue(actualExecutingInvocationUnit.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualExecutingInvocationUnit.method);
    assertNull(actualExecutingInvocationUnit.stack);
    assertNull(actualExecutingInvocationUnit.variables);
    assertFalse(actualExecutingInvocationUnit.isLoad);
    assertFalse(actualExecutingInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory, boolean, List)}
   */
  @Test
  public void testNewExecutingInvocationUnit2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ArrayList<Executor> registeredExecutors = new ArrayList<>();
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualExecutingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, registeredExecutors);

    // Assert
    assertTrue(actualExecutingInvocationUnit.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualExecutingInvocationUnit.method);
    assertNull(actualExecutingInvocationUnit.stack);
    assertNull(actualExecutingInvocationUnit.variables);
    assertFalse(actualExecutingInvocationUnit.isLoad);
    assertFalse(actualExecutingInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link ExecutingInvocationUnit#ExecutingInvocationUnit(ClassPool, ClassPool, ValueFactory, boolean, List)}
   */
  @Test
  public void testNewExecutingInvocationUnit3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ArrayList<Executor> registeredExecutors = new ArrayList<>();
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));
    registeredExecutors.add(new StringReflectionExecutor(KotlinConstants.dummyClassPool));

    // Act
    ExecutingInvocationUnit actualExecutingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, registeredExecutors);

    // Assert
    assertTrue(actualExecutingInvocationUnit.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualExecutingInvocationUnit.method);
    assertNull(actualExecutingInvocationUnit.stack);
    assertNull(actualExecutingInvocationUnit.variables);
    assertFalse(actualExecutingInvocationUnit.isLoad);
    assertFalse(actualExecutingInvocationUnit.isStatic);
  }
}

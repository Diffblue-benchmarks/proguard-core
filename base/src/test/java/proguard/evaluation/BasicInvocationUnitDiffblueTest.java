package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class BasicInvocationUnitDiffblueTest {
  /**
   * Method under test:
   * {@link BasicInvocationUnit#getExceptionValue(Clazz, ClassConstant)}
   */
  @Test
  public void testGetExceptionValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());

    // Act
    Value actualExceptionValue = basicInvocationUnit.getExceptionValue(new LibraryClass(), null);

    // Assert
    assertTrue(actualExceptionValue instanceof IdentifiedReferenceValue);
    assertEquals("Ljava/lang/Throwable;", ((IdentifiedReferenceValue) actualExceptionValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualExceptionValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualExceptionValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((IdentifiedReferenceValue) actualExceptionValue).isNotNull());
    assertFalse(actualExceptionValue.isCategory2());
    assertFalse(actualExceptionValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualExceptionValue).mayBeExtension());
    assertTrue(actualExceptionValue.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) actualExceptionValue).isNull());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getExceptionValue(Clazz, ClassConstant)}
   */
  @Test
  public void testGetExceptionValue2() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, basicInvocationUnit.getExceptionValue(new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldClassValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue = basicInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldClassValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldClassValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualFieldClassValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldClassValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldClassValue).isNull());
    assertFalse(actualFieldClassValue.isCategory2());
    assertFalse(actualFieldClassValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldClassValue).mayBeExtension());
    assertTrue(actualFieldClassValue.isSpecific());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldClassValue2() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(
        new MultiTypedReferenceValueFactory(true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue = basicInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldClassValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualFieldClassValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualFieldClassValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualFieldClassValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualFieldClassValue).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualFieldClassValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldClassValue.isCategory2());
    assertFalse(actualFieldClassValue.isParticular());
    assertFalse(actualFieldClassValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualFieldClassValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldClassValue3() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualFieldClassValue = basicInvocationUnit.getFieldClassValue(clazz,
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor")), "Type");

    // Assert
    assertTrue(actualFieldClassValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldClassValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualFieldClassValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldClassValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldClassValue).isNull());
    assertFalse(actualFieldClassValue.isCategory2());
    assertFalse(actualFieldClassValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldClassValue).mayBeExtension());
    assertTrue(actualFieldClassValue.isSpecific());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldClassValue4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type"));
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = basicInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

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
   * {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue2() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(
        new MultiTypedReferenceValueFactory(true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = basicInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

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
   * {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue3() {
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
   * {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue4() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualFieldValue = basicInvocationUnit.getFieldValue(clazz,
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor")), "Type");

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
   * {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, basicInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type"));
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue6() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit = new ExecutingInvocationUnit(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool, valueFactory, true, new ArrayList<>());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualFieldValue = executingInvocationUnit.getFieldValue(clazz,
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor")), "Type");

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
   * {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue = basicInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type",
        referencedClass);

    // Assert
    assertTrue(actualMethodParameterValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodParameterValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodParameterValue).mayBeExtension());
    assertTrue(actualMethodParameterValue.isSpecific());
    assertSame(referencedClass, ((IdentifiedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue2() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodParameterValue = basicInvocationUnit.getMethodParameterValue(clazz,
        new LibraryMethod(1, "Name", "Descriptor"), 0, "Type", null);

    // Assert
    assertTrue(actualMethodParameterValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodParameterValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((IdentifiedReferenceValue) actualMethodParameterValue).isNotNull());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodParameterValue).mayBeExtension());
    assertTrue(actualMethodParameterValue.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) actualMethodParameterValue).isNull());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue3() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(
        new MultiTypedReferenceValueFactory(true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue = basicInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type",
        referencedClass);

    // Assert
    assertTrue(actualMethodParameterValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualMethodParameterValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualMethodParameterValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualMethodParameterValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertFalse(actualMethodParameterValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualMethodParameterValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, ((MultiTypedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue4() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ProgramClass referencedClass = new ProgramClass();

    // Act
    Value actualMethodParameterValue = basicInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type",
        referencedClass);

    // Assert
    assertTrue(actualMethodParameterValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodParameterValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodParameterValue).mayBeExtension());
    assertTrue(actualMethodParameterValue.isSpecific());
    assertSame(referencedClass, ((IdentifiedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type", new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue6() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodParameterValue = basicInvocationUnit.getMethodParameterValue(clazz,
        new LibraryMethod(8, "Name", "Descriptor"), 0, "Type", null);

    // Assert
    assertTrue(actualMethodParameterValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodParameterValue).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodParameterValue).mayBeExtension());
    assertTrue(actualMethodParameterValue.isSpecific());
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = basicInvocationUnit.getMethodReturnValue(clazz, new InterfaceMethodrefConstant(),
        "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
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
   * {@link BasicInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue2() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(
        new MultiTypedReferenceValueFactory(true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = basicInvocationUnit.getMethodReturnValue(clazz, new InterfaceMethodrefConstant(),
        "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualMethodReturnValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
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
   * {@link BasicInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue3() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodReturnValue = basicInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor")), "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
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
   * {@link BasicInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getMethodReturnValue(clazz, new InterfaceMethodrefConstant(), "Type"));
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue5() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = basicInvocationUnit.getMethodReturnValue(clazz, new InvokeDynamicConstant(),
        "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
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
   * {@link BasicInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue6() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    invokeDynamicConstant.referencedClasses = new Clazz[]{new LibraryClass()};

    // Act
    Value actualMethodReturnValue = basicInvocationUnit.getMethodReturnValue(clazz, invokeDynamicConstant, "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
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
   * {@link BasicInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue7() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(
        new MultiTypedReferenceValueFactory(true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = basicInvocationUnit.getMethodReturnValue(clazz, new InvokeDynamicConstant(),
        "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualMethodReturnValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
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
   * {@link BasicInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue8() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getMethodReturnValue(clazz, new InvokeDynamicConstant(), "Type"));
  }

  /**
   * Method under test:
   * {@link BasicInvocationUnit#BasicInvocationUnit(ValueFactory)}
   */
  @Test
  public void testNewBasicInvocationUnit() {
    // Arrange and Act
    BasicInvocationUnit actualBasicInvocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBasicInvocationUnit.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBasicInvocationUnit.method);
    assertNull(actualBasicInvocationUnit.stack);
    assertNull(actualBasicInvocationUnit.variables);
    assertFalse(actualBasicInvocationUnit.isLoad);
    assertFalse(actualBasicInvocationUnit.isStatic);
  }
}

package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.DetailedArrayReferenceValue;
import proguard.evaluation.value.DetailedArrayValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.UnknownFloatValue;
import proguard.evaluation.value.UnknownIntegerValue;
import proguard.evaluation.value.UnknownLongValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

public class ConstantValueFactoryDiffblueTest {
  /**
   * Method under test: {@link ConstantValueFactory#constantValue(Clazz, int)}
   */
  @Test
  public void testConstantValue() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());

    // Act and Assert
    assertNull(constantValueFactory.constantValue(new LibraryClass(), 1));
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  public void testVisitIntegerConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitIntegerConstant(clazz, new IntegerConstant(42));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownIntegerValue);
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  public void testVisitLongConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitLongConstant(clazz, new LongConstant(42L));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownLongValue);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertTrue(value.isCategory2());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  public void testVisitFloatConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitFloatConstant(clazz, new FloatConstant(10.0f));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownFloatValue);
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  public void testVisitDoubleConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitDoubleConstant(clazz, new DoubleConstant(10.0d));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownDoubleValue);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertTrue(value.isCategory2());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   */
  @Test
  public void testVisitPrimitiveArrayConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("[\u0000", ((IdentifiedReferenceValue) value).getType());
    AnalyzedObject value2 = ((IdentifiedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   */
  @Test
  public void testVisitPrimitiveArrayConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new DetailedArrayValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof DetailedArrayReferenceValue);
    AnalyzedObject value2 = ((DetailedArrayReferenceValue) value).getValue();
    Model modeledOrNullValue = value2.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[\u0000", ((DetailedArrayReferenceValue) value).getType());
    assertEquals("[\u0000", modeledOrNullValue.getType());
    assertNull(((DetailedArrayReferenceValue) value).getReferencedClass());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertEquals(1, ((DetailedArrayReferenceValue) value).isNotNull());
    assertFalse(((DetailedArrayReferenceValue) value).mayBeExtension());
    assertFalse(value.isCategory2());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((DetailedArrayReferenceValue) value).isNull());
    assertSame(modeledOrNullValue, value2.getModeledValue());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   */
  @Test
  public void testVisitPrimitiveArrayConstant3() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(
        new MultiTypedReferenceValueFactory(true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertEquals("[\u0000", ((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertEquals("[\u0000", generalizedType.getType());
    AnalyzedObject value2 = ((MultiTypedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) value).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) value).isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(value.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertEquals(InitializationFinder.NONE, generalizedType.isNull());
    assertSame(value2, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Ljava/lang/invoke/MethodHandle;", ((IdentifiedReferenceValue) value).getType());
    AnalyzedObject value2 = ((IdentifiedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   */
  @Test
  public void testVisitMethodHandleConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    AnalyzedObject value2 = ((UnknownReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  public void testVisitMethodTypeConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Ljava/lang/invoke/MethodType;", ((IdentifiedReferenceValue) value).getType());
    AnalyzedObject value2 = ((IdentifiedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  public void testVisitMethodTypeConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory = new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    AnalyzedObject value2 = ((UnknownReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Method under test:
   * {@link ConstantValueFactory#ConstantValueFactory(ValueFactory)}
   */
  @Test
  public void testNewConstantValueFactory() {
    // Arrange and Act
    ConstantValueFactory actualConstantValueFactory = new ConstantValueFactory(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualConstantValueFactory.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualConstantValueFactory.value);
  }
}

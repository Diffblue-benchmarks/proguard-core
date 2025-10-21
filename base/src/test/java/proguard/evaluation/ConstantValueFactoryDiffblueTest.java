package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link ConstantValueFactory#ConstantValueFactory(ValueFactory)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#ConstantValueFactory(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantValueFactory.<init>(ValueFactory)"})
  public void testNewConstantValueFactory() {
    // Arrange and Act
    ConstantValueFactory actualConstantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualConstantValueFactory.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualConstantValueFactory.value);
  }

  /**
   * Test {@link ConstantValueFactory#constantValue(Clazz, int)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantValueFactory#constantValue(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ConstantValueFactory.constantValue(Clazz, int)"})
  public void testConstantValue_whenLibraryClass_thenReturnNull() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());

    // Act and Assert
    assertNull(constantValueFactory.constantValue(new LibraryClass(), 1));
  }

  /**
   * Test {@link ConstantValueFactory#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantValueFactory.visitIntegerConstant(Clazz, IntegerConstant)"})
  public void testVisitIntegerConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
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
   * Test {@link ConstantValueFactory#visitLongConstant(Clazz, LongConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantValueFactory.visitLongConstant(Clazz, LongConstant)"})
  public void testVisitLongConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
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
   * Test {@link ConstantValueFactory#visitFloatConstant(Clazz, FloatConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantValueFactory.visitFloatConstant(Clazz, FloatConstant)"})
  public void testVisitFloatConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
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
   * Test {@link ConstantValueFactory#visitDoubleConstant(Clazz, DoubleConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantValueFactory.visitDoubleConstant(Clazz, DoubleConstant)"})
  public void testVisitDoubleConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
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
   * Test {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueFactory.visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)"
  })
  public void testVisitPrimitiveArrayConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
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
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueFactory.visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)"
  })
  public void testVisitPrimitiveArrayConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new DetailedArrayValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof DetailedArrayReferenceValue);
    AnalyzedObject value2 = ((DetailedArrayReferenceValue) value).getValue();
    Model modeledOrNullValue = value2.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[\u0000", modeledOrNullValue.getType());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    assertSame(modeledOrNullValue, value2.getModeledValue());
  }

  /**
   * Test {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueFactory.visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)"
  })
  public void testVisitPrimitiveArrayConstant3() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertEquals("[\u0000", ((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertEquals("[\u0000", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) value).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(value.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(value.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertEquals(InitializationFinder.NONE, generalizedType.isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueFactory.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  public void testVisitMethodHandleConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Ljava/lang/invoke/MethodHandle;", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueFactory.visitMethodHandleConstant(Clazz, MethodHandleConstant)"
  })
  public void testVisitMethodHandleConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Test {@link ConstantValueFactory#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueFactory.visitMethodTypeConstant(Clazz, MethodTypeConstant)"
  })
  public void testVisitMethodTypeConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Ljava/lang/invoke/MethodType;", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueFactory.visitMethodTypeConstant(Clazz, MethodTypeConstant)"
  })
  public void testVisitMethodTypeConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }
}

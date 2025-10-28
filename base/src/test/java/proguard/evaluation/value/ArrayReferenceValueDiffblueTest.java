package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class ArrayReferenceValueDiffblueTest {
  /**
   * Method under test: {@link ArrayReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  public void testArrayLength() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(arrayReferenceValue.arrayLength, arrayReferenceValue.arrayLength(new ParticularReferenceValueFactory()));
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(arrayReferenceValue, arrayReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", referencedClass, false,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("proguard.evaluation.value.ArrayReferenceValue",
        null, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("proguard.evaluation.value.ArrayReferenceValue",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue
        .generalize(new ArrayReferenceValue("Type", null, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue(null, new LibraryClass(), false,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue
        .generalize(new ArrayReferenceValue("Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", referencedClass, false,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue
        .generalize(new ArrayReferenceValue(null, new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(other,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(other, (new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)).generalize(other));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = (new ArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

    // Act and Assert
    assertSame(other,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ArrayReferenceValue other = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, arrayReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize14() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue
        .generalize((ReferenceValue) new IdentifiedArrayReferenceValue("Type", referencedClass, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize15() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize16() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, arrayReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize17() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", referencedClass2, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize18() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue
        .generalize((ReferenceValue) new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize19() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other, (new ArrayReferenceValue("", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .generalize(other));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize20() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), false,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", referencedClass, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize21() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", referencedClass, false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize22() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue(null, new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue
        .generalize((ReferenceValue) new IdentifiedArrayReferenceValue("Type", referencedClass, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize23() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue
        .generalize((ReferenceValue) new IdentifiedArrayReferenceValue(null, referencedClass2, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, arrayReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), false,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, arrayReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", referencedClass, true,
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertEquals(0, arrayReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, arrayReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), false,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, arrayReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        ParticularValueFactory.INTEGER_VALUE_0);

    // Act and Assert
    assertEquals(0, arrayReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("proguard.evaluation.value.ArrayReferenceValue",
        new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(Value.NEVER, arrayReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual9() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedArrayReferenceValue("Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(), 1)).equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual10() {
    // Arrange, Act and Assert
    assertEquals(Value.NEVER,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual11() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual12() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, arrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual13() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual14() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new IdentifiedArrayReferenceValue("Type",
        referencedClass2, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual15() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicValueFactory.INTEGER_VALUE);

    // Act and Assert
    assertEquals(0, arrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual16() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, arrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(),
        false, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual17() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, arrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type", referencedClass, true,
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayReferenceValue#equals(Object)}
   *   <li>{@link ArrayReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ArrayReferenceValue arrayReferenceValue2 = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(arrayReferenceValue, arrayReferenceValue2);
    int expectedHashCodeResult = arrayReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayReferenceValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayReferenceValue#equals(Object)}
   *   <li>{@link ArrayReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(arrayReferenceValue, arrayReferenceValue);
    int expectedHashCodeResult = arrayReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayReferenceValue.hashCode());
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("proguard.evaluation.value.ArrayReferenceValue",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(arrayReferenceValue,
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link ArrayReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ArrayReferenceValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ArrayReferenceValue#ArrayReferenceValue(String, Clazz, boolean, IntegerValue)}
   *   <li>{@link ArrayReferenceValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ArrayReferenceValue actualArrayReferenceValue = new ArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertEquals("Type![b]", actualArrayReferenceValue.toString());
    assertEquals("Type", actualArrayReferenceValue.getType());
    assertSame(referencedClass, actualArrayReferenceValue.getReferencedClass());
  }
}

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

public class IdentifiedArrayReferenceValueDiffblueTest {
  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue
        .generalize(new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue
        .generalize(new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 2);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue
        .generalize(new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue
        .generalize(new IdentifiedArrayReferenceValue("Type", referencedClass2, false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(other, (new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)).generalize(other));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = (new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1))
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other, (new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)).generalize(other));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

    // Act and Assert
    assertSame(other, (new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)).generalize(other));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize9() {
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize10() {
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, identifiedArrayReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedArrayReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", referencedClass2, false,
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize14() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize15() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 2);
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass2,
        true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue(
        "proguard.evaluation.value.IdentifiedArrayReferenceValue", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass2,
        true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass2,
        true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass2,
        false, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue(
        "proguard.evaluation.value.IdentifiedArrayReferenceValue", referencedClass, false,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(Value.NEVER, identifiedArrayReferenceValue.equal(new IdentifiedArrayReferenceValue("Type",
        referencedClass2, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedArrayReferenceValue("Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(), 1)).equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(Value.NEVER,
        (new IdentifiedArrayReferenceValue("Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(), 1)).equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedArrayReferenceValue("Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(), 1))
                .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual9() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual10() {
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
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicValueFactory.INTEGER_VALUE, new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual12() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type",
        new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual13() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type",
        referencedClass2, true,
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual14() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue(
        "proguard.evaluation.value.IdentifiedArrayReferenceValue", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new IdentifiedArrayReferenceValue("Type",
        referencedClass2, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual15() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new IdentifiedArrayReferenceValue("Type",
        referencedClass2, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedArrayReferenceValue#equals(Object)}
   *   <li>{@link IdentifiedArrayReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedArrayReferenceValue, identifiedArrayReferenceValue);
    int expectedHashCodeResult = identifiedArrayReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedArrayReferenceValue.hashCode());
  }

  /**
   * Method under test: {@link IdentifiedArrayReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(identifiedArrayReferenceValue, new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Method under test: {@link IdentifiedArrayReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Method under test: {@link IdentifiedArrayReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedArrayReferenceValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link IdentifiedArrayReferenceValue#IdentifiedArrayReferenceValue(String, Clazz, boolean, IntegerValue, ValueFactory, int)}
   *   <li>{@link IdentifiedArrayReferenceValue#toString()}
   *   <li>{@link IdentifiedArrayReferenceValue#isSpecific()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    IdentifiedArrayReferenceValue actualIdentifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);
    String actualToStringResult = actualIdentifiedArrayReferenceValue.toString();
    boolean actualIsSpecificResult = actualIdentifiedArrayReferenceValue.isSpecific();

    // Assert
    assertEquals("Type![b]#1", actualToStringResult);
    assertEquals("Type", actualIdentifiedArrayReferenceValue.getType());
    assertTrue(actualIsSpecificResult);
    assertSame(referencedClass, actualIdentifiedArrayReferenceValue.getReferencedClass());
  }
}

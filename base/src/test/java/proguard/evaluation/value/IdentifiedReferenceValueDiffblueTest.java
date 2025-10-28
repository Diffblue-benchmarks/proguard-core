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

public class IdentifiedReferenceValueDiffblueTest {
  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

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
   * {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, false,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

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
   * {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        false, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

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
   * {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

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
   * {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, valuefactory, new IdentifiedReferenceValue("Type", referencedClass2, true, true,
            new ParticularReferenceValueFactory(), "Id"));
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass3, true, true, new ParticularReferenceValueFactory(), "Id"));

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
   * {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, valuefactory, new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass3, true, true, new ParticularReferenceValueFactory(), "Id"));

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
   * {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, false,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, false, true, new ParticularReferenceValueFactory(), "Id"));

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
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        false, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, true, false, new ParticularReferenceValueFactory(), "Id"));

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
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(other,
        (new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .generalize(other));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");

    // Act and Assert
    assertSame(identifiedReferenceValue,
        identifiedReferenceValue.generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other,
        (new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .generalize(other));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", referencedClass2, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

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
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass2, true, true,
            new ParticularReferenceValueFactory(), "Id"));

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
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize14() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize15() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, identifiedReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize16() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = (new IdentifiedReferenceValue("Type", referencedClass, true, false,
        new ParticularReferenceValueFactory(), "Id"))
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
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize17() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other,
        (new IdentifiedReferenceValue("", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .generalize(other));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize18() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

    // Act and Assert
    assertSame(other, (new IdentifiedReferenceValue("Type", referencedClass, true, false,
        new ParticularReferenceValueFactory(), "Id")).generalize(other));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize19() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", referencedClass2, false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

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
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize20() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, false,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass2, true, true,
            new ParticularReferenceValueFactory(), "Id"));

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
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize21() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        false, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass2, true, true,
            new ParticularReferenceValueFactory(), "Id"));

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
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize22() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass2, true, true,
            new ParticularReferenceValueFactory(), "Id"));

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
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize23() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass2, true, true, valuefactory,
            new IdentifiedReferenceValue("Type", referencedClass3, true, true, new ParticularReferenceValueFactory(),
                "Id")));

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
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize24() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass2, true, true, valuefactory,
            new IdentifiedArrayReferenceValue("Type", referencedClass3, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(), 1)));

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
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize25() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, false,
        true, new ParticularReferenceValueFactory(), "Id");
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize26() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        false, new ParticularReferenceValueFactory(), "Id");
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize27() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, valuefactory,
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize28() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, valuefactory,
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true));

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(
        (ReferenceValue) new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true),
            true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(identifiedReferenceValue.id, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize29() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, valuefactory, new IdentifiedReferenceValue("Type", referencedClass2, true, true,
            new ParticularReferenceValueFactory(), "Id"));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass2, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue(
        "proguard.evaluation.value.IdentifiedReferenceValue", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass2, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, false,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass2, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        false, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass2, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, false,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass2, false, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue(
        "proguard.evaluation.value.IdentifiedReferenceValue", referencedClass, false, true,
        new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(Value.NEVER, identifiedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass2,
        false, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual9() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual10() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(Value.NEVER, (new IdentifiedReferenceValue("Type", referencedClass, true, false,
        new ParticularReferenceValueFactory(), "Id")).equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual12() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue(
        "proguard.evaluation.value.IdentifiedReferenceValue", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual13() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, false,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual14() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        false, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual15() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type",
        referencedClass2, false, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedReferenceValue#equals(Object)}
   *   <li>{@link IdentifiedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");

    // Act and Assert
    assertEquals(identifiedReferenceValue, identifiedReferenceValue);
    int expectedHashCodeResult = identifiedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedReferenceValue.hashCode());
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(identifiedReferenceValue, new IdentifiedReferenceValue("Type", referencedClass2, true, true,
        new ParticularReferenceValueFactory(), "Id"));
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        null);
  }

  /**
   * Method under test: {@link IdentifiedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        "Different type to IdentifiedReferenceValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link IdentifiedReferenceValue#IdentifiedReferenceValue(String, Clazz, boolean, boolean, ValueFactory, Object)}
   *   <li>{@link IdentifiedReferenceValue#toString()}
   *   <li>{@link IdentifiedReferenceValue#isSpecific()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    IdentifiedReferenceValue actualIdentifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass,
        true, true, new ParticularReferenceValueFactory(), "Id");
    String actualToStringResult = actualIdentifiedReferenceValue.toString();
    boolean actualIsSpecificResult = actualIdentifiedReferenceValue.isSpecific();

    // Assert
    assertEquals("Type", actualIdentifiedReferenceValue.getType());
    assertEquals("Type#Id", actualToStringResult);
    assertTrue(actualIsSpecificResult);
    assertSame(referencedClass, actualIdentifiedReferenceValue.getReferencedClass());
  }
}

package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class UnknownReferenceValueDiffblueTest {
  /**
   * Method under test: {@link UnknownReferenceValue#mayBeExtension()}
   */
  @Test
  public void testMayBeExtension() {
    // Arrange, Act and Assert
    assertTrue((new UnknownReferenceValue()).mayBeExtension());
  }

  /**
   * Method under test: {@link UnknownReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(0, unknownReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = unknownReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertTrue(actualCastResult.mayBeExtension());
    assertTrue(actualCastResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeNull);
    assertSame(referencedClass, actualCastResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    BasicValueFactory valueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, unknownReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Method under test:
   * {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast3() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = unknownReferenceValue.cast("Type", referencedClass,
        new MultiTypedReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCastResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast4() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, unknownReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Method under test:
   * {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast5() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, unknownReferenceValue.cast("", referencedClass, valueFactory, true));
  }

  /**
   * Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(unknownReferenceValue, unknownReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link UnknownReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownReferenceValue()).equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link UnknownReferenceValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/Object;", (new UnknownReferenceValue()).internalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownReferenceValue}
   *   <li>{@link UnknownReferenceValue#toString()}
   *   <li>{@link UnknownReferenceValue#getReferencedClass()}
   *   <li>{@link UnknownReferenceValue#getType()}
   *   <li>{@link UnknownReferenceValue#isNull()}
   *   <li>{@link UnknownReferenceValue#isParticular()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UnknownReferenceValue actualUnknownReferenceValue = new UnknownReferenceValue();
    String actualToStringResult = actualUnknownReferenceValue.toString();
    Clazz actualReferencedClass = actualUnknownReferenceValue.getReferencedClass();
    String actualType = actualUnknownReferenceValue.getType();
    int actualIsNullResult = actualUnknownReferenceValue.isNull();

    // Assert
    assertEquals("Ljava/lang/Object;", actualType);
    assertEquals("a", actualToStringResult);
    assertNull(actualReferencedClass);
    assertEquals(0, actualIsNullResult);
    assertFalse(actualUnknownReferenceValue.isParticular());
  }
}

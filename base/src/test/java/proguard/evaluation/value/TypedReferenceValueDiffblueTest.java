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

public class TypedReferenceValueDiffblueTest {
  /**
   * Method under test: {@link TypedReferenceValue#isNull()}
   */
  @Test
  public void testIsNull() {
    // Arrange, Act and Assert
    assertEquals(0, (new TypedReferenceValue("Type", new LibraryClass(), true, true)).isNull());
    assertEquals(1, (new TypedReferenceValue(null, new LibraryClass(), true, true)).isNull());
    assertEquals(Value.NEVER, (new TypedReferenceValue("Type", new LibraryClass(), true, false)).isNull());
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf2() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Other Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf3() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf4() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf5() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", null, true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf6() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type",
        new LibraryClass(Short.SIZE, "Type", "Type"), true, true);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf7() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.instanceOf("Ljava/lang/Object;", new LibraryClass()));
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf8() {
    // Arrange, Act and Assert
    assertEquals(0, (new TypedReferenceValue("Type", new LibraryClass(), true, true)).instanceOf("Other Type", null));
  }

  /**
   * Method under test: {@link TypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf9() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Other Type", new LibraryClass(), true, false);

    // Act and Assert
    assertEquals(1, typedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(typedReferenceValue,
        typedReferenceValue.cast("Type", referencedClass, new ParticularReferenceValueFactory(), true));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast2() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = typedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof ParticularReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCastResult.isNull());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(actualCastResult.mayBeExtension());
    assertFalse(((ParticularReferenceValue) actualCastResult).mayBeExtension);
    assertTrue(actualCastResult.isParticular());
    assertTrue(actualCastResult.isSpecific());
    assertTrue(((ParticularReferenceValue) actualCastResult).mayBeNull);
    assertEquals(Value.NEVER, actualCastResult.isNotNull());
    assertSame(referencedClass, actualCastResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast3() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = typedReferenceValue.cast("Type", referencedClass,
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
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast4() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();
    BasicValueFactory valueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, typedReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast5() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = typedReferenceValue.cast("Type", referencedClass,
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
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast6() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(typedReferenceValue,
        typedReferenceValue.cast("Type", referencedClass, new ParticularReferenceValueFactory(), false));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast7() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = typedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), false);

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
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast8() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCastResult = typedReferenceValue.cast(null, referencedClass, valueFactory, true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCastResult.getType());
    assertNull(actualCastResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertEquals(Value.NEVER, actualCastResult.isNotNull());
    ReferenceValue expectedGeneralizedType = valueFactory.REFERENCE_VALUE_NULL;
    assertSame(expectedGeneralizedType, ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast9() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, typedReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast10() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    LibraryClass referencedClass = new LibraryClass();
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCastResult = typedReferenceValue.cast("Ljava/lang/Object;", referencedClass, valueFactory,
        true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualCastResult.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCastResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    ReferenceValue expectedGeneralizedType = valueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;
    assertSame(expectedGeneralizedType, ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalizeMayBeNull(boolean)}
   */
  @Test
  public void testGeneralizeMayBeNull() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(typedReferenceValue, typedReferenceValue.generalizeMayBeNull(true));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalizeMayBeNull(boolean)}
   */
  @Test
  public void testGeneralizeMayBeNull2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeMayBeNullResult = (new TypedReferenceValue("Type", referencedClass, true, false))
        .generalizeMayBeNull(true);

    // Assert
    assertTrue(actualGeneralizeMayBeNullResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeMayBeNullResult.getType());
    AnalyzedObject value = actualGeneralizeMayBeNullResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeMayBeNullResult.isNotNull());
    assertEquals(0, actualGeneralizeMayBeNullResult.isNull());
    assertFalse(actualGeneralizeMayBeNullResult.isCategory2());
    assertFalse(actualGeneralizeMayBeNullResult.isParticular());
    assertFalse(actualGeneralizeMayBeNullResult.isSpecific());
    assertTrue(actualGeneralizeMayBeNullResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeMayBeNullResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeMayBeNullResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeMayBeNullResult.getReferencedClass());
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(other, (new TypedReferenceValue("Type", new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(other,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(other, (new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)).generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(other,
        (new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(typedReferenceValue,
        typedReferenceValue.generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other, (new TypedReferenceValue("Type", new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange and Act
    ReferenceValue actualGeneralizeResult = (new TypedReferenceValue("Type", new LibraryClass(), true, true))
        .generalize(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(typedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, typedReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize11() {
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
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
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
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
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
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
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
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
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
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
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
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
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
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize18() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");

    // Act and Assert
    assertSame(identifiedReferenceValue,
        identifiedReferenceValue.generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize19() {
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
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize20() {
    // Arrange
    ReferenceValue other = PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL;

    // Act and Assert
    assertSame(other, (new TypedReferenceValue(null, new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize21() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other, (new TypedReferenceValue(null, new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize22() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other, (new TypedReferenceValue("", new LibraryClass(), true, true)).generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize23() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(other, (new TypedReferenceValue("Type", new LibraryClass(), false, true)).generalize(other));
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize24() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(typedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize25() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize26() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), false, true);
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize27() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(typedReferenceValue,
        typedReferenceValue.generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize28() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, typedReferenceValue.generalize(other));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize29() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), false, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize30() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, false);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize31() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize32() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(typedReferenceValue,
        typedReferenceValue.generalize(new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize33() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertSame(typedReferenceValue,
        typedReferenceValue.generalize(new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize34() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", null, true, true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue
        .generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize35() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = typedReferenceValue
        .generalize(new TypedReferenceValue("Type", null, true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize36() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, false);

    // Act and Assert
    assertSame(typedReferenceValue, typedReferenceValue.generalize((TypedReferenceValue) new ArrayReferenceValue("Type",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TypedReferenceValue("Type", new LibraryClass(), true, true)).equal(BasicValueFactory.REFERENCE_VALUE));
    assertEquals(0,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.REFERENCE_VALUE));
    assertEquals(0, (new TypedReferenceValue("Type", new LibraryClass(), true, true))
        .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
    assertEquals(0, (new TypedReferenceValue("Type", new LibraryClass(), true, true))
        .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
    assertEquals(Value.NEVER,
        (new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
    assertEquals(1, (new TypedReferenceValue(null, new LibraryClass(), true, true))
        .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
    assertEquals(0, (new TypedReferenceValue(null, new LibraryClass(), true, true))
        .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedArrayReferenceValue("Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(), 1)).equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, arrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue = new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(0, identifiedArrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual6() {
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
   * Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        (new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue(null, new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(Value.NEVER, arrayReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual9() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual10() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual11() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), false, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual12() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.equal(new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual13() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(1, typedReferenceValue.equal(new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual14() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(Value.NEVER,
        typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, false)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual15() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), false, true);

    // Act and Assert
    assertEquals(0, typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), false, true)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual16() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, false);

    // Act and Assert
    assertEquals(Value.NEVER, typedReferenceValue.equal(new TypedReferenceValue(null, new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual17() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", new LibraryClass(), false, true);

    // Act and Assert
    assertEquals(Value.NEVER,
        typedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), false, true)));
  }

  /**
   * Method under test: {@link TypedReferenceValue#isParticular()}
   */
  @Test
  public void testIsParticular() {
    // Arrange, Act and Assert
    assertFalse((new TypedReferenceValue("Type", new LibraryClass(), true, true)).isParticular());
    assertTrue((new TypedReferenceValue(null, new LibraryClass(), true, true)).isParticular());
  }

  /**
   * Method under test: {@link TypedReferenceValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("Type", (new TypedReferenceValue("Type", new LibraryClass(), true, true)).internalType());
    assertEquals("Ljava/lang/Object;", (new TypedReferenceValue(null, new LibraryClass(), true, true)).internalType());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#allowsIncompleteClassHierarchy()}
   */
  @Test
  public void testAllowsIncompleteClassHierarchy() {
    // Arrange, Act and Assert
    assertFalse(TypedReferenceValue.allowsIncompleteClassHierarchy());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testDoubleArrayLoad() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.DOUBLE_VALUE,
        typedReferenceValue.doubleArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testDoubleArrayLoad2() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    DoubleValue actualDoubleArrayLoadResult = typedReferenceValue
        .doubleArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualDoubleArrayLoadResult instanceof IdentifiedDoubleValue);
    assertFalse(actualDoubleArrayLoadResult.isParticular());
    assertTrue(actualDoubleArrayLoadResult.isCategory2());
    assertTrue(actualDoubleArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testIntegerArrayLoad() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE,
        typedReferenceValue.integerArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testIntegerArrayLoad2() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    IntegerValue actualIntegerArrayLoadResult = typedReferenceValue
        .integerArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualIntegerArrayLoadResult instanceof IdentifiedIntegerValue);
    assertFalse(actualIntegerArrayLoadResult.isCategory2());
    assertFalse(actualIntegerArrayLoadResult.isParticular());
    assertTrue(actualIntegerArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testLongArrayLoad() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.LONG_VALUE,
        typedReferenceValue.longArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testLongArrayLoad2() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    LongValue actualLongArrayLoadResult = typedReferenceValue.longArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualLongArrayLoadResult instanceof IdentifiedLongValue);
    assertFalse(actualLongArrayLoadResult.isParticular());
    assertTrue(actualLongArrayLoadResult.isCategory2());
    assertTrue(actualLongArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testFloatArrayLoad() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.FLOAT_VALUE,
        typedReferenceValue.floatArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TypedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testFloatArrayLoad2() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    FloatValue actualFloatArrayLoadResult = typedReferenceValue
        .floatArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualFloatArrayLoadResult instanceof IdentifiedFloatValue);
    assertFalse(actualFloatArrayLoadResult.isCategory2());
    assertFalse(actualFloatArrayLoadResult.isParticular());
    assertTrue(actualFloatArrayLoadResult.isSpecific());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypedReferenceValue#equals(Object)}
   *   <li>{@link TypedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    TypedReferenceValue typedReferenceValue2 = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(typedReferenceValue, typedReferenceValue2);
    int expectedHashCodeResult = typedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, typedReferenceValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypedReferenceValue#equals(Object)}
   *   <li>{@link TypedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);
    TypedReferenceValue typedReferenceValue2 = new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(typedReferenceValue, typedReferenceValue2);
    int expectedHashCodeResult = typedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, typedReferenceValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypedReferenceValue#equals(Object)}
   *   <li>{@link TypedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertEquals(typedReferenceValue, typedReferenceValue);
    int expectedHashCodeResult = typedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, typedReferenceValue.hashCode());
  }

  /**
   * Method under test: {@link TypedReferenceValue#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Type", (new TypedReferenceValue("Type", new LibraryClass(), true, true)).toString());
    assertEquals("n", (new TypedReferenceValue(null, new LibraryClass(), true, true)).toString());
    assertEquals("Type?", (new TypedReferenceValue("Type", null, true, true)).toString());
    assertEquals("Type=", (new TypedReferenceValue("Type", new LibraryClass(), false, true)).toString());
    assertEquals("Type!", (new TypedReferenceValue("Type", new LibraryClass(), true, false)).toString());
  }

  /**
   * Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    // Act and Assert
    assertNotEquals(typedReferenceValue, new TypedReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", new LibraryClass(), true, true);

    // Act and Assert
    assertNotEquals(typedReferenceValue, new TypedReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), false, true);

    // Act and Assert
    assertNotEquals(typedReferenceValue, new TypedReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, false);

    // Act and Assert
    assertNotEquals(typedReferenceValue, new TypedReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypedReferenceValue("Type", new LibraryClass(), true, true), null);
  }

  /**
   * Method under test: {@link TypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypedReferenceValue("Type", new LibraryClass(), true, true),
        "Different type to TypedReferenceValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TypedReferenceValue#TypedReferenceValue(String, Clazz, boolean, boolean)}
   *   <li>{@link TypedReferenceValue#getReferencedClass()}
   *   <li>{@link TypedReferenceValue#getType()}
   *   <li>{@link TypedReferenceValue#mayBeExtension()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    TypedReferenceValue actualTypedReferenceValue = new TypedReferenceValue("Type", referencedClass, true, true);
    Clazz actualReferencedClass = actualTypedReferenceValue.getReferencedClass();
    String actualType = actualTypedReferenceValue.getType();

    // Assert
    assertEquals("Type", actualType);
    assertTrue(actualTypedReferenceValue.mayBeExtension());
    assertSame(referencedClass, actualReferencedClass);
  }
}

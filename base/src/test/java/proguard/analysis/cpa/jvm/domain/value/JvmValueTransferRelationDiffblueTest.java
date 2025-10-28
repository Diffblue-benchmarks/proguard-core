package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ExecutingInvocationUnit;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.BasicRangeValueFactory;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.FloatValue;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.IntegerValue;
import proguard.evaluation.value.LongValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.ParticularDoubleValue;
import proguard.evaluation.value.ParticularFloatValue;
import proguard.evaluation.value.ParticularIntegerValue;
import proguard.evaluation.value.ParticularLongValue;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.RangeIntegerValue;
import proguard.evaluation.value.RangeValueFactory;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class JvmValueTransferRelationDiffblueTest {
  /**
   * Method under test: {@link JvmValueTransferRelation#getAbstractDefault()}
   */
  @Test
  public void testGetAbstractDefault() {
    // Arrange and Act
    ValueAbstractState actualAbstractDefault = (new JvmValueTransferRelation(new ParticularReferenceValueFactory(),
        null)).getAbstractDefault();

    // Assert
    assertSame(actualAbstractDefault.UNKNOWN, actualAbstractDefault);
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractByteConstant(byte)}
   */
  @Test
  public void testGetAbstractByteConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractByteConstant = jvmValueTransferRelation.getAbstractByteConstant((byte) 'A');

    // Assert
    assertNull(actualAbstractByteConstant.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractByteConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    IntegerValue expectedValue = valueFactory.INTEGER_VALUE;
    assertSame(expectedValue, actualAbstractByteConstant.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractByteConstant(byte)}
   */
  @Test
  public void testGetAbstractByteConstant2() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(new BasicRangeValueFactory(),
        null);

    // Act
    ValueAbstractState actualAbstractByteConstant = jvmValueTransferRelation.getAbstractByteConstant((byte) 'A');

    // Assert
    Value value = actualAbstractByteConstant.getValue();
    assertTrue(value instanceof ParticularIntegerValue);
    assertNull(actualAbstractByteConstant.getPrecision());
    assertEquals(65, ((ParticularIntegerValue) value).value());
    assertFalse(value.isCategory2());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    ValueAbstractState expectedAbstractDefault = actualAbstractByteConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractDoubleConstant(double)}
   */
  @Test
  public void testGetAbstractDoubleConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    List<ValueAbstractState> actualAbstractDoubleConstant = (new JvmValueTransferRelation(valueFactory, null))
        .getAbstractDoubleConstant(10.0d);

    // Assert
    assertEquals(2, actualAbstractDoubleConstant.size());
    ValueAbstractState getResult = actualAbstractDoubleConstant.get(0);
    Value value = getResult.getValue();
    assertTrue(value instanceof TopValue);
    assertNull(getResult.getPrecision());
    ValueAbstractState getResult2 = actualAbstractDoubleConstant.get(1);
    assertNull(getResult2.getPrecision());
    assertFalse(value.isCategory2());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    DoubleValue expectedValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedValue, getResult2.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractDoubleConstant(double)}
   */
  @Test
  public void testGetAbstractDoubleConstant2() {
    // Arrange and Act
    List<ValueAbstractState> actualAbstractDoubleConstant = (new JvmValueTransferRelation(new BasicRangeValueFactory(),
        null)).getAbstractDoubleConstant(10.0d);

    // Assert
    assertEquals(2, actualAbstractDoubleConstant.size());
    ValueAbstractState getResult = actualAbstractDoubleConstant.get(1);
    Value value = getResult.getValue();
    assertTrue(value instanceof ParticularDoubleValue);
    ValueAbstractState getResult2 = actualAbstractDoubleConstant.get(0);
    Value value2 = getResult2.getValue();
    assertTrue(value2 instanceof TopValue);
    assertNull(getResult2.getPrecision());
    assertNull(getResult.getPrecision());
    assertEquals(10.0d, ((ParticularDoubleValue) value).value(), 0.0);
    assertFalse(value2.isCategory2());
    assertTrue(value.isCategory2());
    assertTrue(value2.isParticular());
    assertTrue(value.isParticular());
    assertTrue(value2.isSpecific());
    assertTrue(value.isSpecific());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractFloatConstant(float)}
   */
  @Test
  public void testGetAbstractFloatConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractFloatConstant = jvmValueTransferRelation.getAbstractFloatConstant(10.0f);

    // Assert
    assertNull(actualAbstractFloatConstant.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractFloatConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    FloatValue expectedValue = valueFactory.FLOAT_VALUE;
    assertSame(expectedValue, actualAbstractFloatConstant.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractFloatConstant(float)}
   */
  @Test
  public void testGetAbstractFloatConstant2() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(new BasicRangeValueFactory(),
        null);

    // Act
    ValueAbstractState actualAbstractFloatConstant = jvmValueTransferRelation.getAbstractFloatConstant(10.0f);

    // Assert
    Value value = actualAbstractFloatConstant.getValue();
    assertTrue(value instanceof ParticularFloatValue);
    assertNull(actualAbstractFloatConstant.getPrecision());
    assertEquals(10.0f, ((ParticularFloatValue) value).value(), 0.0f);
    assertFalse(value.isCategory2());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    ValueAbstractState expectedAbstractDefault = actualAbstractFloatConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractIntegerConstant(int)}
   */
  @Test
  public void testGetAbstractIntegerConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractIntegerConstant = jvmValueTransferRelation.getAbstractIntegerConstant(1);

    // Assert
    assertNull(actualAbstractIntegerConstant.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractIntegerConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    IntegerValue expectedValue = valueFactory.INTEGER_VALUE;
    assertSame(expectedValue, actualAbstractIntegerConstant.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractIntegerConstant(int)}
   */
  @Test
  public void testGetAbstractIntegerConstant2() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(new RangeValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractIntegerConstant = jvmValueTransferRelation.getAbstractIntegerConstant(1);

    // Assert
    Value value = actualAbstractIntegerConstant.getValue();
    assertTrue(value instanceof RangeIntegerValue);
    assertNull(actualAbstractIntegerConstant.getPrecision());
    assertFalse(value.isCategory2());
    assertFalse(value.isSpecific());
    assertTrue(value.isParticular());
    ValueAbstractState expectedAbstractDefault = actualAbstractIntegerConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractLongConstant(long)}
   */
  @Test
  public void testGetAbstractLongConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    List<ValueAbstractState> actualAbstractLongConstant = (new JvmValueTransferRelation(valueFactory, null))
        .getAbstractLongConstant(1L);

    // Assert
    assertEquals(2, actualAbstractLongConstant.size());
    ValueAbstractState getResult = actualAbstractLongConstant.get(0);
    Value value = getResult.getValue();
    assertTrue(value instanceof TopValue);
    assertNull(getResult.getPrecision());
    ValueAbstractState getResult2 = actualAbstractLongConstant.get(1);
    assertNull(getResult2.getPrecision());
    assertFalse(value.isCategory2());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    LongValue expectedValue = valueFactory.LONG_VALUE;
    assertSame(expectedValue, getResult2.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractLongConstant(long)}
   */
  @Test
  public void testGetAbstractLongConstant2() {
    // Arrange and Act
    List<ValueAbstractState> actualAbstractLongConstant = (new JvmValueTransferRelation(new BasicRangeValueFactory(),
        null)).getAbstractLongConstant(-1L);

    // Assert
    assertEquals(2, actualAbstractLongConstant.size());
    ValueAbstractState getResult = actualAbstractLongConstant.get(1);
    Value value = getResult.getValue();
    assertTrue(value instanceof ParticularLongValue);
    ValueAbstractState getResult2 = actualAbstractLongConstant.get(0);
    Value value2 = getResult2.getValue();
    assertTrue(value2 instanceof TopValue);
    assertNull(getResult2.getPrecision());
    assertNull(getResult.getPrecision());
    assertEquals(-1L, ((ParticularLongValue) value).value());
    assertFalse(value2.isCategory2());
    assertTrue(value.isCategory2());
    assertTrue(value2.isParticular());
    assertTrue(value.isParticular());
    assertTrue(value2.isSpecific());
    assertTrue(value.isSpecific());
  }

  /**
   * Method under test: {@link JvmValueTransferRelation#getAbstractNull()}
   */
  @Test
  public void testGetAbstractNull() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractNull = jvmValueTransferRelation.getAbstractNull();

    // Assert
    Value value = actualAbstractNull.getValue();
    assertTrue(value instanceof TypedReferenceValue);
    AnalyzedObject value2 = ((TypedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((TypedReferenceValue) value).getType());
    assertNull(actualAbstractNull.getPrecision());
    assertNull(((TypedReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(-1, ((TypedReferenceValue) value).isNotNull());
    assertEquals(1, ((TypedReferenceValue) value).isNull());
    assertFalse(((TypedReferenceValue) value).mayBeExtension());
    assertFalse(value.isCategory2());
    assertFalse(value.isSpecific());
    assertTrue(value.isParticular());
    ValueAbstractState expectedAbstractDefault = actualAbstractNull.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test: {@link JvmValueTransferRelation#getAbstractNull()}
   */
  @Test
  public void testGetAbstractNull2() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new MultiTypedReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractNull = jvmValueTransferRelation.getAbstractNull();

    // Assert
    Value value = actualAbstractNull.getValue();
    assertTrue(value instanceof MultiTypedReferenceValue);
    AnalyzedObject value2 = ((MultiTypedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertNull(generalizedType.getType());
    assertNull(actualAbstractNull.getPrecision());
    assertNull(((MultiTypedReferenceValue) value).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(-1, generalizedType.isNotNull());
    assertEquals(-1, ((MultiTypedReferenceValue) value).isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertTrue(generalizedType.isParticular());
    assertSame(value2, generalizedType.getValue());
    ValueAbstractState expectedAbstractDefault = actualAbstractNull.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractShortConstant(short)}
   */
  @Test
  public void testGetAbstractShortConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractShortConstant = jvmValueTransferRelation.getAbstractShortConstant((short) 1);

    // Assert
    assertNull(actualAbstractShortConstant.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractShortConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    IntegerValue expectedValue = valueFactory.INTEGER_VALUE;
    assertSame(expectedValue, actualAbstractShortConstant.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractShortConstant(short)}
   */
  @Test
  public void testGetAbstractShortConstant2() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(new RangeValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractShortConstant = jvmValueTransferRelation.getAbstractShortConstant((short) 1);

    // Assert
    Value value = actualAbstractShortConstant.getValue();
    assertTrue(value instanceof RangeIntegerValue);
    assertNull(actualAbstractShortConstant.getPrecision());
    assertFalse(value.isCategory2());
    assertFalse(value.isSpecific());
    assertTrue(value.isParticular());
    ValueAbstractState expectedAbstractDefault = actualAbstractShortConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  public void testGetAbstractReferenceValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    Value value = actualAbstractReferenceValue.getValue();
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Class Name", ((IdentifiedReferenceValue) value).getType());
    AnalyzedObject value2 = ((IdentifiedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(actualAbstractReferenceValue.getPrecision());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertTrue(((IdentifiedReferenceValue) value).mayBeExtension());
    assertTrue(value.isSpecific());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  public void testGetAbstractReferenceValue2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    assertNull(actualAbstractReferenceValue.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  public void testGetAbstractReferenceValue3() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new MultiTypedReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    Value value = actualAbstractReferenceValue.getValue();
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertEquals("Class Name", ((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertEquals("Class Name", generalizedType.getType());
    AnalyzedObject value2 = ((MultiTypedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(actualAbstractReferenceValue.getPrecision());
    assertNull(((MultiTypedReferenceValue) value).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) value).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(value2, generalizedType.getValue());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  public void testGetAbstractReferenceValue4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    assertNull(actualAbstractReferenceValue.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  public void testGetAbstractReferenceValue5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation.getAbstractReferenceValue("");

    // Assert
    assertNull(actualAbstractReferenceValue.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testGetAbstractReferenceValue6() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);
    LibraryClass referencedClazz = new LibraryClass();

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation
        .getAbstractReferenceValue("Internal Type", referencedClazz, true, true);

    // Assert
    Value value = actualAbstractReferenceValue.getValue();
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Internal Type", ((IdentifiedReferenceValue) value).getType());
    AnalyzedObject value2 = ((IdentifiedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(actualAbstractReferenceValue.getPrecision());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertTrue(((IdentifiedReferenceValue) value).mayBeExtension());
    assertTrue(value.isSpecific());
    assertSame(referencedClazz, ((IdentifiedReferenceValue) value).getReferencedClass());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testGetAbstractReferenceValue7() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation
        .getAbstractReferenceValue("Internal Type", new LibraryClass(), true, true);

    // Assert
    assertNull(actualAbstractReferenceValue.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testGetAbstractReferenceValue8() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new MultiTypedReferenceValueFactory(), null);
    LibraryClass referencedClazz = new LibraryClass();

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation
        .getAbstractReferenceValue("Internal Type", referencedClazz, true, true);

    // Assert
    Value value = actualAbstractReferenceValue.getValue();
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertEquals("Internal Type", ((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertEquals("Internal Type", generalizedType.getType());
    AnalyzedObject value2 = ((MultiTypedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(actualAbstractReferenceValue.getPrecision());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) value).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClazz, ((MultiTypedReferenceValue) value).getReferencedClass());
    assertSame(referencedClazz, generalizedType.getReferencedClass());
    assertSame(value2, generalizedType.getValue());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testGetAbstractReferenceValue9() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation
        .getAbstractReferenceValue("Internal Type", new LibraryClass(), true, true);

    // Assert
    assertNull(actualAbstractReferenceValue.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testGetAbstractReferenceValue10() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue = jvmValueTransferRelation.getAbstractReferenceValue("",
        new LibraryClass(), true, true);

    // Assert
    assertNull(actualAbstractReferenceValue.getPrecision());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link JvmValueTransferRelation#handleCheckCast(ValueAbstractState, String)}
   */
  @Test
  public void testHandleCheckCast() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualHandleCheckCastResult = jvmValueTransferRelation
        .handleCheckCast(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE), "Internal Name");

    // Assert
    ValueAbstractState valueAbstractState = actualHandleCheckCastResult.UNKNOWN;
    assertSame(valueAbstractState, jvmValueTransferRelation.getAbstractDefault());
    assertSame(valueAbstractState, actualHandleCheckCastResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JvmValueTransferRelation#JvmValueTransferRelation(ValueFactory, ExecutingInvocationUnit)}
   *   <li>{@link JvmValueTransferRelation#getValueFactory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    ValueFactory actualValueFactory = (new JvmValueTransferRelation(valueFactory, null)).getValueFactory();

    // Assert
    assertTrue(actualValueFactory instanceof ParticularReferenceValueFactory);
    assertSame(valueFactory, actualValueFactory);
  }
}

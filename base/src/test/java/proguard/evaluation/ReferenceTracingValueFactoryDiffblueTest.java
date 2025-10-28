package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.ArrayReferenceValueFactory;
import proguard.evaluation.value.BasicRangeValueFactory;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DetailedArrayReferenceValue;
import proguard.evaluation.value.DetailedArrayValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.FloatValue;
import proguard.evaluation.value.IdentifiedArrayReferenceValue;
import proguard.evaluation.value.IdentifiedDoubleValue;
import proguard.evaluation.value.IdentifiedFloatValue;
import proguard.evaluation.value.IdentifiedIntegerValue;
import proguard.evaluation.value.IdentifiedLongValue;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.InstructionOffsetValue;
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
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.TracedReferenceValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

public class ReferenceTracingValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}
   */
  @Test
  public void testCast() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    TracedReferenceValue referenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.DOUBLE_VALUE);

    LibraryClass referencedClass = new LibraryClass();

    // Act
    TracedReferenceValue actualCastResult = referenceTracingValueFactory.cast(referenceValue, "Type", referencedClass,
        true);

    // Assert
    ReferenceValue referenceValue2 = actualCastResult.getReferenceValue();
    assertTrue(referenceValue2 instanceof IdentifiedReferenceValue);
    assertEquals("Type", referenceValue2.getType());
    assertEquals("Type", actualCastResult.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, referenceValue2.isNotNull());
    assertEquals(0, referenceValue2.isNull());
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(referenceValue2.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertFalse(referenceValue2.isParticular());
    assertTrue(referenceValue2.mayBeExtension());
    assertTrue(actualCastResult.isSpecific());
    assertTrue(referenceValue2.isSpecific());
    assertSame(referencedClass, referenceValue2.getReferencedClass());
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(value, referenceValue2.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, actualCastResult.getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}
   */
  @Test
  public void testCast2() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new BasicValueFactory(), true);
    TracedReferenceValue referenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(referenceValue, referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}
   */
  @Test
  public void testCast3() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    TracedReferenceValue referenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.DOUBLE_VALUE);

    LibraryClass referencedClass = new LibraryClass();

    // Act
    TracedReferenceValue actualCastResult = referenceTracingValueFactory.cast(referenceValue, "Type", referencedClass,
        true);

    // Assert
    ReferenceValue referenceValue2 = actualCastResult.getReferenceValue();
    assertTrue(referenceValue2 instanceof MultiTypedReferenceValue);
    assertEquals("Type", referenceValue2.getType());
    assertEquals("Type", actualCastResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) referenceValue2).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, referenceValue2.isNotNull());
    assertEquals(0, actualCastResult.isNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue2).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(referenceValue2.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(generalizedType.isParticular());
    assertFalse(referenceValue2.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(referenceValue2.isSpecific());
    assertFalse(((MultiTypedReferenceValue) referenceValue2).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, referenceValue2.getReferencedClass());
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
    assertSame(value, referenceValue2.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, actualCastResult.getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}
   */
  @Test
  public void testCast4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), false);
    TracedReferenceValue referenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.DOUBLE_VALUE);

    LibraryClass referencedClass = new LibraryClass();

    // Act
    TracedReferenceValue actualCastResult = referenceTracingValueFactory.cast(referenceValue, "Type", referencedClass,
        true);

    // Assert
    ReferenceValue referenceValue2 = actualCastResult.getReferenceValue();
    assertTrue(referenceValue2 instanceof IdentifiedReferenceValue);
    assertEquals("Type", referenceValue2.getType());
    assertEquals("Type", actualCastResult.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCastResult.getTraceValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, referenceValue2.isNotNull());
    assertEquals(0, referenceValue2.isNull());
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(referenceValue2.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertFalse(referenceValue2.isParticular());
    assertTrue(referenceValue2.mayBeExtension());
    assertTrue(actualCastResult.isSpecific());
    assertTrue(referenceValue2.isSpecific());
    assertSame(referencedClass, referenceValue2.getReferencedClass());
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(value, referenceValue2.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}
   */
  @Test
  public void testCast5() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), true);
    TracedReferenceValue referenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(referenceValue, referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}
   */
  @Test
  public void testCast6() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new PrimitiveTypedReferenceValueFactory(), true);
    TracedReferenceValue referenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(referenceValue, referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}
   */
  @Test
  public void testCast7() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    TracedReferenceValue referenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("", new LibraryClass(), true, true), true),
        BasicValueFactory.DOUBLE_VALUE);

    LibraryClass referencedClass = new LibraryClass();

    // Act
    TracedReferenceValue actualCastResult = referenceTracingValueFactory.cast(referenceValue, "Type", referencedClass,
        true);

    // Assert
    ReferenceValue referenceValue2 = actualCastResult.getReferenceValue();
    assertTrue(referenceValue2 instanceof MultiTypedReferenceValue);
    assertEquals("Type", referenceValue2.getType());
    assertEquals("Type", actualCastResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) referenceValue2).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, referenceValue2.isNotNull());
    assertEquals(0, actualCastResult.isNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue2).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(referenceValue2.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(generalizedType.isParticular());
    assertFalse(referenceValue2.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(referenceValue2.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) referenceValue2).mayBeUnknown);
    assertSame(referencedClass, referenceValue2.getReferencedClass());
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
    assertSame(value, referenceValue2.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, actualCastResult.getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}
   */
  @Test
  public void testCast8() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new PrimitiveTypedReferenceValueFactory(), true);
    TracedReferenceValue referenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(referenceValue, referenceTracingValueFactory.cast(referenceValue, "", new LibraryClass(), true));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = referenceTracingValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualCreateValueResult).getType());
    AnalyzedObject value = ((IdentifiedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((IdentifiedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, ((IdentifiedReferenceValue) actualCreateValueResult).isNull());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualCreateValueResult).mayBeExtension());
    assertTrue(actualCreateValueResult.isSpecific());
    assertSame(referencedClass, ((IdentifiedReferenceValue) actualCreateValueResult).getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = referenceTracingValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualCreateValueResult).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateValueResult instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualCreateValueResult).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualCreateValueResult).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualCreateValueResult.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(referencedClass, ((TracedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(value, referenceValue.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateValueResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue3() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = referenceTracingValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue5() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool),
        true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = referenceTracingValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue6() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createIntegerValue()}
   */
  @Test
  public void testCreateIntegerValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE, (new ReferenceTracingValueFactory(valueFactory, true)).createIntegerValue());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createIntegerValue()}
   */
  @Test
  public void testCreateIntegerValue2() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new ReferenceTracingValueFactory(new DetailedArrayValueFactory(),
        true)).createIntegerValue();

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof IdentifiedIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createIntegerValue(42));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue4() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
        .createIntegerValue(42);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof ParticularIntegerValue);
    assertEquals(42, actualCreateIntegerValueResult.value());
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertTrue(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createIntegerValue(int, int)}
   */
  @Test
  public void testCreateIntegerValue5() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createIntegerValue(1, 3));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createIntegerValue(int, int)}
   */
  @Test
  public void testCreateIntegerValue6() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
        .createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createLongValue()}
   */
  @Test
  public void testCreateLongValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.LONG_VALUE, (new ReferenceTracingValueFactory(valueFactory, true)).createLongValue());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createLongValue()}
   */
  @Test
  public void testCreateLongValue2() {
    // Arrange and Act
    LongValue actualCreateLongValueResult = (new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true))
        .createLongValue();

    // Assert
    assertTrue(actualCreateLongValueResult instanceof IdentifiedLongValue);
    assertFalse(actualCreateLongValueResult.isParticular());
    assertTrue(actualCreateLongValueResult.isCategory2());
    assertTrue(actualCreateLongValueResult.isSpecific());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createLongValue(long)}
   */
  @Test
  public void testCreateLongValue3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.LONG_VALUE, (new ReferenceTracingValueFactory(valueFactory, true)).createLongValue(42L));
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createLongValue(long)}
   */
  @Test
  public void testCreateLongValue4() {
    // Arrange and Act
    LongValue actualCreateLongValueResult = (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
        .createLongValue(42L);

    // Assert
    assertTrue(actualCreateLongValueResult instanceof ParticularLongValue);
    assertEquals(42L, actualCreateLongValueResult.value());
    assertTrue(actualCreateLongValueResult.isCategory2());
    assertTrue(actualCreateLongValueResult.isParticular());
    assertTrue(actualCreateLongValueResult.isSpecific());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createFloatValue()}
   */
  @Test
  public void testCreateFloatValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.FLOAT_VALUE, (new ReferenceTracingValueFactory(valueFactory, true)).createFloatValue());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createFloatValue()}
   */
  @Test
  public void testCreateFloatValue2() {
    // Arrange and Act
    FloatValue actualCreateFloatValueResult = (new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true))
        .createFloatValue();

    // Assert
    assertTrue(actualCreateFloatValueResult instanceof IdentifiedFloatValue);
    assertFalse(actualCreateFloatValueResult.isCategory2());
    assertFalse(actualCreateFloatValueResult.isParticular());
    assertTrue(actualCreateFloatValueResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createFloatValue(float)}
   */
  @Test
  public void testCreateFloatValue3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.FLOAT_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createFloatValue(10.0f));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createFloatValue(float)}
   */
  @Test
  public void testCreateFloatValue4() {
    // Arrange and Act
    FloatValue actualCreateFloatValueResult = (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
        .createFloatValue(10.0f);

    // Assert
    assertTrue(actualCreateFloatValueResult instanceof ParticularFloatValue);
    assertEquals(10.0f, actualCreateFloatValueResult.value(), 0.0f);
    assertFalse(actualCreateFloatValueResult.isCategory2());
    assertTrue(actualCreateFloatValueResult.isParticular());
    assertTrue(actualCreateFloatValueResult.isSpecific());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createDoubleValue()}
   */
  @Test
  public void testCreateDoubleValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.DOUBLE_VALUE, (new ReferenceTracingValueFactory(valueFactory, true)).createDoubleValue());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#createDoubleValue()}
   */
  @Test
  public void testCreateDoubleValue2() {
    // Arrange and Act
    DoubleValue actualCreateDoubleValueResult = (new ReferenceTracingValueFactory(new DetailedArrayValueFactory(),
        true)).createDoubleValue();

    // Assert
    assertTrue(actualCreateDoubleValueResult instanceof IdentifiedDoubleValue);
    assertFalse(actualCreateDoubleValueResult.isParticular());
    assertTrue(actualCreateDoubleValueResult.isCategory2());
    assertTrue(actualCreateDoubleValueResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createDoubleValue(double)}
   */
  @Test
  public void testCreateDoubleValue3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.DOUBLE_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createDoubleValue(10.0d));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createDoubleValue(double)}
   */
  @Test
  public void testCreateDoubleValue4() {
    // Arrange and Act
    DoubleValue actualCreateDoubleValueResult = (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
        .createDoubleValue(10.0d);

    // Assert
    assertTrue(actualCreateDoubleValueResult instanceof ParticularDoubleValue);
    assertEquals(10.0d, actualCreateDoubleValueResult.value(), 0.0);
    assertTrue(actualCreateDoubleValueResult.isCategory2());
    assertTrue(actualCreateDoubleValueResult.isParticular());
    assertTrue(actualCreateDoubleValueResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue()}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createReferenceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue()}
   */
  @Test
  public void testCreateReferenceValue2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue();

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateReferenceValueResult).getTraceValue());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedReferenceValue, ((TracedReferenceValue) actualCreateReferenceValueResult).getReferenceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue3() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue4() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualCreateReferenceValueResult).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateReferenceValueResult instanceof TracedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateReferenceValueResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue5() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue6() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueResult)
        .getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue7() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue8() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue("", new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue9() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ArrayReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue10() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue("Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue11() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueResult)
        .getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue12() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue("Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue13() {
    // Arrange
    ArrayReferenceValueFactory valueFactory = new ArrayReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualCreateReferenceValueResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertTrue(referenceValue.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateReferenceValueResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue14() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue15() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualCreateReferenceValueResult).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateReferenceValueResult instanceof TracedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateReferenceValueResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue16() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, referenceTracingValueFactory.createReferenceValue("Type", referencedClass,
        true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue17() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueResult)
        .getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue18() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, referenceTracingValueFactory.createReferenceValue("Type", referencedClass,
        true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue19() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ArrayReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue20() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, referenceTracingValueFactory.createReferenceValue("Type", referencedClass,
        true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue21() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = referenceTracingValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueResult)
        .getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue22() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, referenceTracingValueFactory.createReferenceValue("Type", referencedClass,
        true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueNull()}
   */
  @Test
  public void testCreateReferenceValueNull() {
    // Arrange and Act
    ReferenceValue actualCreateReferenceValueNullResult = (new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), true)).createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueNullResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueNullResult.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueNullResult.isNull());
    assertFalse(actualCreateReferenceValueNullResult.isCategory2());
    assertFalse(actualCreateReferenceValueNullResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueNullResult.isSpecific());
    assertTrue(actualCreateReferenceValueNullResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueNullResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueNull()}
   */
  @Test
  public void testCreateReferenceValueNull2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);

    // Act
    ReferenceValue actualCreateReferenceValueNullResult = referenceTracingValueFactory.createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualCreateReferenceValueNullResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueNullResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueNullResult.getType());
    assertNull(referenceValue.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertNull(referenceValue.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueNullResult.isNull());
    assertEquals(1, referenceValue.isNull());
    assertFalse(actualCreateReferenceValueNullResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(referenceValue.mayBeExtension());
    assertFalse(actualCreateReferenceValueNullResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertTrue(actualCreateReferenceValueNullResult.isParticular());
    assertTrue(referenceValue.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueNullResult.isNotNull());
    assertEquals(InitializationFinder.NONE, referenceValue.isNotNull());
    assertSame(value, referenceValue.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateReferenceValueNullResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueNull()}
   */
  @Test
  public void testCreateReferenceValueNull3() {
    // Arrange and Act
    ReferenceValue actualCreateReferenceValueNullResult = (new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(), true)).createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof MultiTypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueNullResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueNullResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueNullResult)
        .getGeneralizedType();
    assertNull(generalizedType.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNull());
    assertFalse(actualCreateReferenceValueNullResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateReferenceValueNullResult.isParticular());
    assertFalse(actualCreateReferenceValueNullResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).mayBeUnknown);
    assertTrue(generalizedType.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueNullResult.isNotNull());
    assertEquals(InitializationFinder.NONE, generalizedType.isNotNull());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = referenceTracingValueFactory
        .createReferenceValueForId("Type", referencedClass, true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof IdentifiedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = referenceTracingValueFactory
        .createReferenceValueForId("Type", referencedClass, true, true, "Id");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualCreateReferenceValueForIdResult).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TracedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) referenceValue).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateReferenceValueForIdResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId3() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = referenceTracingValueFactory
        .createReferenceValueForId("Type", referencedClass, true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult)
        .getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId6() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId("", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId7() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ArrayReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = referenceTracingValueFactory
        .createReferenceValueForId("Type", referencedClass, true, true, "Id", "Value");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId8() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId9() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = referenceTracingValueFactory
        .createReferenceValueForId("Type", referencedClass, true, true, "Id", "Value");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult)
        .getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId10() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = referenceTracingValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = referenceTracingValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualCreateArrayReferenceValueResult).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateArrayReferenceValueResult instanceof TracedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[Type", referenceValue.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(referenceValue.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertEquals(InitializationFinder.NONE, referenceValue.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateArrayReferenceValueResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue3() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, referenceTracingValueFactory.createArrayReferenceValue("Type",
        new LibraryClass(), BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new DetailedArrayValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = referenceTracingValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue5() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new MultiTypedReferenceValueFactory(true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool),
        true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = referenceTracingValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult)
        .getGeneralizedType();
    assertEquals("[Type", generalizedType.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getPotentialTypes().size());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertEquals(1, generalizedType.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeUnknown);
    assertEquals(InitializationFinder.NONE, generalizedType.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue6() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new DetailedArrayValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = referenceTracingValueFactory.createArrayReferenceValue("",
        referencedClass, new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    Value value2 = values[0];
    assertTrue(value2 instanceof TypedReferenceValue);
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[", modeledOrNullValue.getType());
    AnalyzedObject value3 = ((TypedReferenceValue) value2).getValue();
    assertNull(value3.getPreciseValue());
    assertNull(((TypedReferenceValue) value2).getType());
    assertNull(((TypedReferenceValue) value2).getReferencedClass());
    assertNull(value3.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertEquals(1, ((TypedReferenceValue) value2).isNull());
    assertEquals(42, values.length);
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(((TypedReferenceValue) value2).mayBeExtension());
    assertFalse(value2.isCategory2());
    assertFalse(value2.isSpecific());
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(value2.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, ((TypedReferenceValue) value2).isNotNull());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(value2, values[1]);
    assertSame(value2, values[10]);
    assertSame(value2, values[11]);
    assertSame(value2, values[12]);
    assertSame(value2, values[13]);
    assertSame(value2, values[14]);
    assertSame(value2, values[15]);
    assertSame(value2, values[17]);
    assertSame(value2, values[18]);
    assertSame(value2, values[19]);
    assertSame(value2, values[2]);
    assertSame(value2, values[20]);
    assertSame(value2, values[21]);
    assertSame(value2, values[22]);
    assertSame(value2, values[23]);
    assertSame(value2, values[24]);
    assertSame(value2, values[25]);
    assertSame(value2, values[26]);
    assertSame(value2, values[27]);
    assertSame(value2, values[28]);
    assertSame(value2, values[29]);
    assertSame(value2, values[3]);
    assertSame(value2, values[30]);
    assertSame(value2, values[31]);
    assertSame(value2, values[33]);
    assertSame(value2, values[34]);
    assertSame(value2, values[35]);
    assertSame(value2, values[36]);
    assertSame(value2, values[37]);
    assertSame(value2, values[38]);
    assertSame(value2, values[39]);
    assertSame(value2, values[4]);
    assertSame(value2, values[40]);
    assertSame(value2, values[41]);
    assertSame(value2, values[5]);
    assertSame(value2, values[6]);
    assertSame(value2, values[7]);
    assertSame(value2, values[8]);
    assertSame(value2, values[9]);
    assertSame(value2, values[Integer.SIZE]);
    assertSame(value2, values[Short.SIZE]);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue7() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = referenceTracingValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue8() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = referenceTracingValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualCreateArrayReferenceValueResult).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateArrayReferenceValueResult instanceof TracedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[Type", referenceValue.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(referenceValue.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertEquals(InitializationFinder.NONE, referenceValue.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualCreateArrayReferenceValueResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue9() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE, referenceTracingValueFactory.createArrayReferenceValue("Type",
        new LibraryClass(), BasicValueFactory.INTEGER_VALUE, "Element Values"));
  }

  /**
   * Method under test:
   * {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue10() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(
        new DetailedArrayValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = referenceTracingValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#trace(ReferenceValue)}
   */
  @Test
  public void testTrace() {
    // Arrange
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(referenceValue,
        (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true)).trace(referenceValue));
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#trace(ReferenceValue)}
   */
  @Test
  public void testTrace2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;

    // Act
    ReferenceValue actualTraceResult = referenceTracingValueFactory.trace(referenceValue);

    // Assert
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualTraceResult.getType());
    AnalyzedObject value = actualTraceResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualTraceResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualTraceResult.isNotNull());
    assertEquals(0, actualTraceResult.isNull());
    assertFalse(actualTraceResult.isCategory2());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualTraceResult).getTraceValue());
    assertSame(referenceValue, ((TracedReferenceValue) actualTraceResult).getReferenceValue());
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#trace(Value)}
   */
  @Test
  public void testTrace3() {
    // Arrange
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(value, (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true)).trace(value));
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#trace(Value)}
   */
  @Test
  public void testTrace4() {
    // Arrange
    ReferenceValue value = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(value,
        (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true)).trace((Value) value));
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#trace(Value)}
   */
  @Test
  public void testTrace5() {
    // Arrange and Act
    Value actualTraceResult = (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true))
        .trace(InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    assertSame(((InstructionOffsetValue) actualTraceResult).EMPTY_VALUE, actualTraceResult);
  }

  /**
   * Method under test: {@link ReferenceTracingValueFactory#trace(Value)}
   */
  @Test
  public void testTrace6() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory = new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    ReferenceValue value = BasicValueFactory.REFERENCE_VALUE;

    // Act
    Value actualTraceResult = referenceTracingValueFactory.trace((Value) value);

    // Assert
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    AnalyzedObject value2 = ((TracedReferenceValue) actualTraceResult).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isCategory2());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualTraceResult).getTraceValue());
    assertSame(value, ((TracedReferenceValue) actualTraceResult).getReferenceValue());
  }
}

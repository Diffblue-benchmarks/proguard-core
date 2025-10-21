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
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

public class ReferenceTracingValueFactoryDiffblueTest {
  /**
   * Test {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String,
   * Clazz, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TracedReferenceValue ReferenceTracingValueFactory.cast(TracedReferenceValue, String, Clazz, boolean)"
  })
  public void testCast() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new BasicValueFactory(), true);
    TracedReferenceValue referenceValue =
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(
        referenceValue,
        referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String,
   * Clazz, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TracedReferenceValue ReferenceTracingValueFactory.cast(TracedReferenceValue, String, Clazz, boolean)"
  })
  public void testCast2() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    TracedReferenceValue referenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(
        referenceValue,
        referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String,
   * Clazz, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TracedReferenceValue ReferenceTracingValueFactory.cast(TracedReferenceValue, String, Clazz, boolean)"
  })
  public void testCast3() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new PrimitiveTypedReferenceValueFactory(), true);
    TracedReferenceValue referenceValue =
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(
        referenceValue,
        referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String,
   * Clazz, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TracedReferenceValue ReferenceTracingValueFactory.cast(TracedReferenceValue, String, Clazz, boolean)"
  })
  public void testCast4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    TracedReferenceValue referenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("", new LibraryClass(), true, true), true),
            BasicValueFactory.DOUBLE_VALUE);

    // Act
    TracedReferenceValue actualCastResult =
        referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true);

    // Assert
    Clazz referencedClass = actualCastResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue2 = actualCastResult.getReferenceValue();
    assertTrue(referenceValue2 instanceof MultiTypedReferenceValue);
    assertSame(referencedClass, referenceValue2.getReferencedClass());
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) referenceValue2).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}.
   *
   * <ul>
   *   <li>Then return not ReferenceValue {@link MultiTypedReferenceValue#mayBeUnknown}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String,
   * Clazz, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TracedReferenceValue ReferenceTracingValueFactory.cast(TracedReferenceValue, String, Clazz, boolean)"
  })
  public void testCast_thenReturnNotReferenceValueMayBeUnknown() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    TracedReferenceValue referenceValue =
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Act
    TracedReferenceValue actualCastResult =
        referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true);

    // Assert
    Clazz referencedClass = actualCastResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue2 = actualCastResult.getReferenceValue();
    assertTrue(referenceValue2 instanceof MultiTypedReferenceValue);
    assertFalse(((MultiTypedReferenceValue) referenceValue2).mayBeUnknown);
    DoubleValue expectedTraceValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedTraceValue, actualCastResult.getTraceValue());
    assertSame(referencedClass, referenceValue2.getReferencedClass());
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) referenceValue2).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}.
   *
   * <ul>
   *   <li>Then return ReferenceValue Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String,
   * Clazz, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TracedReferenceValue ReferenceTracingValueFactory.cast(TracedReferenceValue, String, Clazz, boolean)"
  })
  public void testCast_thenReturnReferenceValueTypeIsType() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    TracedReferenceValue referenceValue =
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    LibraryClass referencedClass = new LibraryClass();

    // Act
    TracedReferenceValue actualCastResult =
        referenceTracingValueFactory.cast(referenceValue, "Type", referencedClass, true);

    // Assert
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    ReferenceValue referenceValue2 = actualCastResult.getReferenceValue();
    assertTrue(referenceValue2 instanceof IdentifiedReferenceValue);
    assertEquals("Type", referenceValue2.getType());
    assertEquals(0, referenceValue2.isNull());
    assertFalse(referenceValue2.isParticular());
    assertTrue(referenceValue2.mayBeExtension());
    assertTrue(actualCastResult.isSpecific());
    assertTrue(referenceValue2.isSpecific());
    assertSame(referencedClass, referenceValue2.getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}.
   *
   * <ul>
   *   <li>Then return TraceValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String,
   * Clazz, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TracedReferenceValue ReferenceTracingValueFactory.cast(TracedReferenceValue, String, Clazz, boolean)"
  })
  public void testCast_thenReturnTraceValueIsNull() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), false);
    TracedReferenceValue referenceValue =
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Act
    TracedReferenceValue actualCastResult =
        referenceTracingValueFactory.cast(referenceValue, "Type", new LibraryClass(), true);

    // Assert
    Clazz referencedClass = actualCastResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue2 = actualCastResult.getReferenceValue();
    assertTrue(referenceValue2 instanceof IdentifiedReferenceValue);
    assertNull(actualCastResult.getTraceValue());
    assertSame(referencedClass, referenceValue2.getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String, Clazz, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#cast(TracedReferenceValue, String,
   * Clazz, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TracedReferenceValue ReferenceTracingValueFactory.cast(TracedReferenceValue, String, Clazz, boolean)"
  })
  public void testCast_whenEmptyString() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new PrimitiveTypedReferenceValueFactory(), true);
    TracedReferenceValue referenceValue =
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(
        referenceValue,
        referenceTracingValueFactory.cast(referenceValue, "", new LibraryClass(), true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateValue() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult =
        referenceTracingValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 =
        ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    assertEquals(
        1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateValue2() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool),
            true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult =
        referenceTracingValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 =
        ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    assertEquals(
        1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateValue_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult =
        referenceTracingValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = ((TracedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(
        ((TracedReferenceValue) actualCreateValueResult).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateValueResult instanceof TracedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualCreateValueResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    assertEquals("Type", ((TracedReferenceValue) actualCreateValueResult).getType());
    assertEquals(0, ((TracedReferenceValue) actualCreateValueResult).isNull());
    assertFalse(actualCreateValueResult.isParticular());
    assertTrue(actualCreateValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateValue_thenReturnBasicValueFactoryReference_value() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateValue_thenReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult =
        referenceTracingValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 =
        ((IdentifiedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualCreateValueResult).getType());
    assertEquals(0, ((IdentifiedReferenceValue) actualCreateValueResult).isNull());
    assertFalse(actualCreateValueResult.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualCreateValueResult).mayBeExtension());
    assertTrue(actualCreateValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link PrimitiveTypedReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createValue(String, Clazz, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateValue_thenReturnPrimitiveTypedReferenceValueFactoryReference_value() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createIntegerValue(int, int)} with {@code min}, {@code
   * max}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceTracingValueFactory.createIntegerValue(int, int)"})
  public void testCreateIntegerValueWithMinMax() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.INTEGER_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createIntegerValue(1, 3));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createIntegerValue(int, int)} with {@code min}, {@code
   * max}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceTracingValueFactory.createIntegerValue(int, int)"})
  public void testCreateIntegerValueWithMinMax_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
            .createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createIntegerValue(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceTracingValueFactory.createIntegerValue(int)"})
  public void testCreateIntegerValueWithValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.INTEGER_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createIntegerValue(42));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createIntegerValue(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceTracingValueFactory.createIntegerValue(int)"})
  public void testCreateIntegerValueWithValue_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
            .createIntegerValue(42);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof ParticularIntegerValue);
    assertEquals(42, actualCreateIntegerValueResult.value());
    assertTrue(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createIntegerValue()}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createIntegerValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceTracingValueFactory.createIntegerValue()"})
  public void testCreateIntegerValue_thenReturnIdentifiedIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        (new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true))
            .createIntegerValue();

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof IdentifiedIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createIntegerValue()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createIntegerValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceTracingValueFactory.createIntegerValue()"})
  public void testCreateIntegerValue_thenReturnParticularReferenceValueFactoryInteger_value() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.INTEGER_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createIntegerValue());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createLongValue(long)} with {@code long}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createLongValue(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue ReferenceTracingValueFactory.createLongValue(long)"})
  public void testCreateLongValueWithLong_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualCreateLongValueResult =
        (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true)).createLongValue(42L);

    // Assert
    assertTrue(actualCreateLongValueResult instanceof ParticularLongValue);
    assertEquals(42L, actualCreateLongValueResult.value());
    assertTrue(actualCreateLongValueResult.isParticular());
    assertTrue(actualCreateLongValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createLongValue(long)} with {@code long}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createLongValue(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue ReferenceTracingValueFactory.createLongValue(long)"})
  public void testCreateLongValueWithLong_thenReturnParticularReferenceValueFactoryLong_value() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.LONG_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createLongValue(42L));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createLongValue()}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createLongValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue ReferenceTracingValueFactory.createLongValue()"})
  public void testCreateLongValue_thenReturnIdentifiedLongValue() {
    // Arrange and Act
    LongValue actualCreateLongValueResult =
        (new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true)).createLongValue();

    // Assert
    assertTrue(actualCreateLongValueResult instanceof IdentifiedLongValue);
    assertFalse(actualCreateLongValueResult.isParticular());
    assertTrue(actualCreateLongValueResult.isCategory2());
    assertTrue(actualCreateLongValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createLongValue()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createLongValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue ReferenceTracingValueFactory.createLongValue()"})
  public void testCreateLongValue_thenReturnParticularReferenceValueFactoryLong_value() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.LONG_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createLongValue());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createFloatValue(float)} with {@code float}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createFloatValue(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ReferenceTracingValueFactory.createFloatValue(float)"})
  public void testCreateFloatValueWithFloat() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.FLOAT_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createFloatValue(10.0f));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createFloatValue(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createFloatValue(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ReferenceTracingValueFactory.createFloatValue(float)"})
  public void testCreateFloatValueWithFloat_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualCreateFloatValueResult =
        (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
            .createFloatValue(10.0f);

    // Assert
    assertTrue(actualCreateFloatValueResult instanceof ParticularFloatValue);
    assertEquals(10.0f, actualCreateFloatValueResult.value(), 0.0f);
    assertTrue(actualCreateFloatValueResult.isParticular());
    assertTrue(actualCreateFloatValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createFloatValue()}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createFloatValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ReferenceTracingValueFactory.createFloatValue()"})
  public void testCreateFloatValue_thenReturnIdentifiedFloatValue() {
    // Arrange and Act
    FloatValue actualCreateFloatValueResult =
        (new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true))
            .createFloatValue();

    // Assert
    assertTrue(actualCreateFloatValueResult instanceof IdentifiedFloatValue);
    assertFalse(actualCreateFloatValueResult.isCategory2());
    assertFalse(actualCreateFloatValueResult.isParticular());
    assertTrue(actualCreateFloatValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createFloatValue()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createFloatValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ReferenceTracingValueFactory.createFloatValue()"})
  public void testCreateFloatValue_thenReturnParticularReferenceValueFactoryFloat_value() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.FLOAT_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createFloatValue());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createDoubleValue(double)} with {@code double}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createDoubleValue(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue ReferenceTracingValueFactory.createDoubleValue(double)"})
  public void testCreateDoubleValueWithDouble() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.DOUBLE_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createDoubleValue(10.0d));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createDoubleValue(double)} with {@code double}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createDoubleValue(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue ReferenceTracingValueFactory.createDoubleValue(double)"})
  public void testCreateDoubleValueWithDouble_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualCreateDoubleValueResult =
        (new ReferenceTracingValueFactory(new BasicRangeValueFactory(), true))
            .createDoubleValue(10.0d);

    // Assert
    assertTrue(actualCreateDoubleValueResult instanceof ParticularDoubleValue);
    assertEquals(10.0d, actualCreateDoubleValueResult.value(), 0.0);
    assertTrue(actualCreateDoubleValueResult.isParticular());
    assertTrue(actualCreateDoubleValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createDoubleValue()}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createDoubleValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue ReferenceTracingValueFactory.createDoubleValue()"})
  public void testCreateDoubleValue_thenReturnIdentifiedDoubleValue() {
    // Arrange and Act
    DoubleValue actualCreateDoubleValueResult =
        (new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true))
            .createDoubleValue();

    // Assert
    assertTrue(actualCreateDoubleValueResult instanceof IdentifiedDoubleValue);
    assertFalse(actualCreateDoubleValueResult.isParticular());
    assertTrue(actualCreateDoubleValueResult.isCategory2());
    assertTrue(actualCreateDoubleValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createDoubleValue()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createDoubleValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue ReferenceTracingValueFactory.createDoubleValue()"})
  public void testCreateDoubleValue_thenReturnParticularReferenceValueFactoryDouble_value() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.DOUBLE_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createDoubleValue());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue()}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceTracingValueFactory.createReferenceValue()"})
  public void testCreateReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        (new ReferenceTracingValueFactory(valueFactory, true)).createReferenceValue());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(
        ((TracedReferenceValue) actualCreateReferenceValueResult).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateReferenceValueResult instanceof TracedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualCreateReferenceValueResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean3() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(
        ((TracedReferenceValue) actualCreateReferenceValueResult).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateReferenceValueResult instanceof TracedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualCreateReferenceValueResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt3() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code
   * boolean}, {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ArrayReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code
   * boolean}, {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code
   * boolean}, {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject3() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code
   * boolean}, {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanObject() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ArrayReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanObject2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue(
            "Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanObject3() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanObject4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue(
            "Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanObject5() {
    // Arrange
    ArrayReferenceValueFactory valueFactory = new ArrayReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TracedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualCreateReferenceValueResult).getReferenceValue()
            instanceof TypedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualCreateReferenceValueResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean_whenEmptyString() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValue("", new LibraryClass(), true, true));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValue()}.
   *
   * <ul>
   *   <li>Then return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceTracingValueFactory.createReferenceValue()"})
  public void testCreateReferenceValue_thenReturnTracedReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        referenceTracingValueFactory.createReferenceValue();

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TracedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualCreateReferenceValueResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualCreateReferenceValueResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
    assertSame(valueFactory.REFERENCE_VALUE, referenceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueNull()}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceTracingValueFactory.createReferenceValueNull()"})
  public void testCreateReferenceValueNull_thenReturnMultiTypedReferenceValue() {
    // Arrange and Act
    ReferenceValue actualCreateReferenceValueNullResult =
        (new ReferenceTracingValueFactory(new MultiTypedReferenceValueFactory(), true))
            .createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof MultiTypedReferenceValue);
    assertNull(actualCreateReferenceValueNullResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).getGeneralizedType();
    assertNull(generalizedType.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateReferenceValueNullResult)
            .getPotentialTypes()
            .size());
    assertEquals(1, generalizedType.isNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateReferenceValueNullResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).mayBeUnknown);
    assertTrue(generalizedType.isParticular());
    assertEquals(InitializationFinder.NONE, generalizedType.isNotNull());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueNull()}.
   *
   * <ul>
   *   <li>Then return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceTracingValueFactory.createReferenceValueNull()"})
  public void testCreateReferenceValueNull_thenReturnTracedReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);

    // Act
    ReferenceValue actualCreateReferenceValueNullResult =
        referenceTracingValueFactory.createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof TracedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualCreateReferenceValueNullResult).getReferenceValue()
            instanceof TypedReferenceValue);
    Value traceValue =
        ((TracedReferenceValue) actualCreateReferenceValueNullResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    assertNull(actualCreateReferenceValueNullResult.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueNullResult.isNull());
    assertFalse(actualCreateReferenceValueNullResult.isSpecific());
    assertTrue(actualCreateReferenceValueNullResult.isParticular());
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueNull()}.
   *
   * <ul>
   *   <li>Then return {@link TypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceTracingValueFactory.createReferenceValueNull()"})
  public void testCreateReferenceValueNull_thenReturnTypedReferenceValue() {
    // Arrange and Act
    ReferenceValue actualCreateReferenceValueNullResult =
        (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true))
            .createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueNullResult.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueNullResult.isNull());
    assertFalse(actualCreateReferenceValueNullResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueNullResult.isParticular());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof IdentifiedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(
        ((TracedReferenceValue) actualCreateReferenceValueForIdResult).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TracedReferenceValue);
    Value traceValue =
        ((TracedReferenceValue) actualCreateReferenceValueForIdResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId3() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult)
            .getPotentialTypes()
            .size());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId6() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId(
            "", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension},
   * {@code mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ArrayReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id", "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension},
   * {@code mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  public void
      testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension},
   * {@code mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  public void
      testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue3() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new MultiTypedReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id", "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult)
            .getPotentialTypes()
            .size());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension},
   * {@code mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  public void
      testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createReferenceValueForId(
            "Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(
        ((TracedReferenceValue) actualCreateArrayReferenceValueResult).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateArrayReferenceValueResult instanceof TracedReferenceValue);
    Value traceValue =
        ((TracedReferenceValue) actualCreateArrayReferenceValueResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength3() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true);

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength5() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool),
            true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult)
            .getPotentialTypes()
            .size());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength6() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        referenceTracingValueFactory.createArrayReferenceValue(
            "", referencedClass, new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[", modeledOrNullValue.getType());
    assertEquals(42, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(
        ((TracedReferenceValue) actualCreateArrayReferenceValueResult).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateArrayReferenceValueResult instanceof TracedReferenceValue);
    Value traceValue =
        ((TracedReferenceValue) actualCreateArrayReferenceValueResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues3() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE, "Element Values"));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceTracingValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues4() {
    // Arrange
    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(new DetailedArrayValueFactory(), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        referenceTracingValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#trace(ReferenceValue)} with {@code referenceValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#trace(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceTracingValueFactory.trace(ReferenceValue)"})
  public void testTraceWithReferenceValue_thenReturnReference_value() {
    // Arrange
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        referenceValue,
        (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true))
            .trace(referenceValue));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#trace(ReferenceValue)} with {@code referenceValue}.
   *
   * <ul>
   *   <li>Then return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#trace(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceTracingValueFactory.trace(ReferenceValue)"})
  public void testTraceWithReferenceValue_thenReturnTracedReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;

    // Act
    ReferenceValue actualTraceResult = referenceTracingValueFactory.trace(referenceValue);

    // Assert
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualTraceResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    ReferenceValue referenceValue2 = ((TracedReferenceValue) actualTraceResult).getReferenceValue();
    assertTrue(referenceValue2 instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", actualTraceResult.getType());
    assertNull(actualTraceResult.getReferencedClass());
    assertEquals(0, actualTraceResult.isNull());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
    assertSame(referenceValue, referenceValue2);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#trace(Value)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#trace(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingValueFactory.trace(Value)"})
  public void testTraceWithValue_thenReturnTracedReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory referenceTracingValueFactory =
        new ReferenceTracingValueFactory(valueFactory, true);
    referenceTracingValueFactory.setTraceValue(BasicValueFactory.DOUBLE_VALUE);
    ReferenceValue value = BasicValueFactory.REFERENCE_VALUE;

    // Act
    Value actualTraceResult = referenceTracingValueFactory.trace((Value) value);

    // Assert
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualTraceResult).getTraceValue();
    assertTrue(traceValue instanceof UnknownDoubleValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualTraceResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertSame(valueFactory.DOUBLE_VALUE, traceValue);
    assertSame(value, referenceValue);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#trace(Value)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#trace(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingValueFactory.trace(Value)"})
  public void testTraceWithValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        value,
        (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true))
            .trace(value));
  }

  /**
   * Test {@link ReferenceTracingValueFactory#trace(Value)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#trace(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingValueFactory.trace(Value)"})
  public void testTraceWithValue_whenEmpty_value_thenReturnEmpty_value() {
    // Arrange and Act
    Value actualTraceResult =
        (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true))
            .trace(InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    assertSame(((InstructionOffsetValue) actualTraceResult).EMPTY_VALUE, actualTraceResult);
  }

  /**
   * Test {@link ReferenceTracingValueFactory#trace(Value)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingValueFactory#trace(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingValueFactory.trace(Value)"})
  public void testTraceWithValue_whenReference_value_thenReturnReference_value() {
    // Arrange
    ReferenceValue value = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        value,
        (new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true))
            .trace((Value) value));
  }
}

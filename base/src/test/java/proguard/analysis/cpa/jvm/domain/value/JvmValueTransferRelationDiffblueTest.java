package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.instruction.BranchInstruction;
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
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.UnknownIntegerValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;

public class JvmValueTransferRelationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmValueTransferRelation#JvmValueTransferRelation(ValueFactory,
   *       ExecutingInvocationUnit)}
   *   <li>{@link JvmValueTransferRelation#getValueFactory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmValueTransferRelation.<init>(ValueFactory, ExecutingInvocationUnit)",
    "ValueFactory JvmValueTransferRelation.getValueFactory()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    ValueFactory actualValueFactory =
        (new JvmValueTransferRelation(valueFactory, null)).getValueFactory();

    // Assert
    assertTrue(actualValueFactory instanceof ParticularReferenceValueFactory);
    assertSame(valueFactory, actualValueFactory);
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractDefault()}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractDefault()"})
  public void testGetAbstractDefault() {
    // Arrange and Act
    ValueAbstractState actualAbstractDefault =
        (new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null))
            .getAbstractDefault();

    // Assert
    assertSame(actualAbstractDefault.UNKNOWN, actualAbstractDefault);
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractByteConstant(byte)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractByteConstant(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractByteConstant(byte)"})
  public void testGetAbstractByteConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractByteConstant =
        jvmValueTransferRelation.getAbstractByteConstant((byte) 'A');

    // Assert
    ValueAbstractState expectedAbstractDefault = actualAbstractByteConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    IntegerValue expectedValue = valueFactory.INTEGER_VALUE;
    assertSame(expectedValue, actualAbstractByteConstant.getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractByteConstant(byte)}.
   *
   * <ul>
   *   <li>Then Value return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractByteConstant(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractByteConstant(byte)"})
  public void testGetAbstractByteConstant_thenValueReturnParticularIntegerValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new BasicRangeValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractByteConstant =
        jvmValueTransferRelation.getAbstractByteConstant((byte) 'A');

    // Assert
    Value value = actualAbstractByteConstant.getValue();
    assertTrue(value instanceof ParticularIntegerValue);
    assertEquals(65, ((ParticularIntegerValue) value).value());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    ValueAbstractState expectedAbstractDefault = actualAbstractByteConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractDoubleConstant(double)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractDoubleConstant(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JvmValueTransferRelation.getAbstractDoubleConstant(double)"})
  public void testGetAbstractDoubleConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    List<ValueAbstractState> actualAbstractDoubleConstant =
        (new JvmValueTransferRelation(valueFactory, null)).getAbstractDoubleConstant(10.0d);

    // Assert
    assertEquals(2, actualAbstractDoubleConstant.size());
    DoubleValue expectedValue = valueFactory.DOUBLE_VALUE;
    assertSame(expectedValue, actualAbstractDoubleConstant.get(1).getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractDoubleConstant(double)}.
   *
   * <ul>
   *   <li>Then second Value return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractDoubleConstant(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JvmValueTransferRelation.getAbstractDoubleConstant(double)"})
  public void testGetAbstractDoubleConstant_thenSecondValueReturnParticularDoubleValue() {
    // Arrange and Act
    List<ValueAbstractState> actualAbstractDoubleConstant =
        (new JvmValueTransferRelation(new BasicRangeValueFactory(), null))
            .getAbstractDoubleConstant(10.0d);

    // Assert
    assertEquals(2, actualAbstractDoubleConstant.size());
    Value value = actualAbstractDoubleConstant.get(1).getValue();
    assertTrue(value instanceof ParticularDoubleValue);
    assertEquals(10.0d, ((ParticularDoubleValue) value).value(), 0.0);
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractFloatConstant(float)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractFloatConstant(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractFloatConstant(float)"})
  public void testGetAbstractFloatConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractFloatConstant =
        jvmValueTransferRelation.getAbstractFloatConstant(10.0f);

    // Assert
    ValueAbstractState expectedAbstractDefault = actualAbstractFloatConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    FloatValue expectedValue = valueFactory.FLOAT_VALUE;
    assertSame(expectedValue, actualAbstractFloatConstant.getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractFloatConstant(float)}.
   *
   * <ul>
   *   <li>Then Value return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractFloatConstant(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractFloatConstant(float)"})
  public void testGetAbstractFloatConstant_thenValueReturnParticularFloatValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new BasicRangeValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractFloatConstant =
        jvmValueTransferRelation.getAbstractFloatConstant(10.0f);

    // Assert
    Value value = actualAbstractFloatConstant.getValue();
    assertTrue(value instanceof ParticularFloatValue);
    assertEquals(10.0f, ((ParticularFloatValue) value).value(), 0.0f);
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    ValueAbstractState expectedAbstractDefault = actualAbstractFloatConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractIntegerConstant(int)}.
   *
   * <ul>
   *   <li>Then Value return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractIntegerConstant(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractIntegerConstant(int)"})
  public void testGetAbstractIntegerConstant_thenValueReturnRangeIntegerValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new RangeValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractIntegerConstant =
        jvmValueTransferRelation.getAbstractIntegerConstant(1);

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
   * Test {@link JvmValueTransferRelation#getAbstractIntegerConstant(int)}.
   *
   * <ul>
   *   <li>Then Value return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractIntegerConstant(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractIntegerConstant(int)"})
  public void testGetAbstractIntegerConstant_thenValueReturnUnknownIntegerValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractIntegerConstant =
        jvmValueTransferRelation.getAbstractIntegerConstant(1);

    // Assert
    Value value = actualAbstractIntegerConstant.getValue();
    assertTrue(value instanceof UnknownIntegerValue);
    assertFalse(value.isParticular());
    ValueAbstractState expectedAbstractDefault = actualAbstractIntegerConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    assertSame(valueFactory.INTEGER_VALUE, value);
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractLongConstant(long)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractLongConstant(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JvmValueTransferRelation.getAbstractLongConstant(long)"})
  public void testGetAbstractLongConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    List<ValueAbstractState> actualAbstractLongConstant =
        (new JvmValueTransferRelation(valueFactory, null)).getAbstractLongConstant(1L);

    // Assert
    assertEquals(2, actualAbstractLongConstant.size());
    LongValue expectedValue = valueFactory.LONG_VALUE;
    assertSame(expectedValue, actualAbstractLongConstant.get(1).getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractLongConstant(long)}.
   *
   * <ul>
   *   <li>Then second Value return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractLongConstant(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JvmValueTransferRelation.getAbstractLongConstant(long)"})
  public void testGetAbstractLongConstant_thenSecondValueReturnParticularLongValue() {
    // Arrange and Act
    List<ValueAbstractState> actualAbstractLongConstant =
        (new JvmValueTransferRelation(new BasicRangeValueFactory(), null))
            .getAbstractLongConstant(-1L);

    // Assert
    assertEquals(2, actualAbstractLongConstant.size());
    Value value = actualAbstractLongConstant.get(1).getValue();
    assertTrue(value instanceof ParticularLongValue);
    assertEquals(-1L, ((ParticularLongValue) value).value());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractNull()}.
   *
   * <ul>
   *   <li>Then Value return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractNull()"})
  public void testGetAbstractNull_thenValueReturnMultiTypedReferenceValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new MultiTypedReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractNull = jvmValueTransferRelation.getAbstractNull();

    // Assert
    Value value = actualAbstractNull.getValue();
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertNull(((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertNull(generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) value).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(-1, generalizedType.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(value.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertTrue(generalizedType.isParticular());
    ValueAbstractState expectedAbstractDefault = actualAbstractNull.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractNull()}.
   *
   * <ul>
   *   <li>Then Value return {@link TypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractNull()"})
  public void testGetAbstractNull_thenValueReturnTypedReferenceValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractNull = jvmValueTransferRelation.getAbstractNull();

    // Assert
    Value value = actualAbstractNull.getValue();
    assertTrue(value instanceof TypedReferenceValue);
    assertNull(((TypedReferenceValue) value).getType());
    assertNull(((TypedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((TypedReferenceValue) value).isNull());
    assertFalse(((TypedReferenceValue) value).mayBeExtension());
    assertTrue(value.isParticular());
    ValueAbstractState expectedAbstractDefault = actualAbstractNull.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractShortConstant(short)}.
   *
   * <ul>
   *   <li>Then Value return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractShortConstant(short)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractShortConstant(short)"})
  public void testGetAbstractShortConstant_thenValueReturnRangeIntegerValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new RangeValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractShortConstant =
        jvmValueTransferRelation.getAbstractShortConstant((short) 1);

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
   * Test {@link JvmValueTransferRelation#getAbstractShortConstant(short)}.
   *
   * <ul>
   *   <li>Then Value return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractShortConstant(short)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState JvmValueTransferRelation.getAbstractShortConstant(short)"})
  public void testGetAbstractShortConstant_thenValueReturnUnknownIntegerValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractShortConstant =
        jvmValueTransferRelation.getAbstractShortConstant((short) 1);

    // Assert
    Value value = actualAbstractShortConstant.getValue();
    assertTrue(value instanceof UnknownIntegerValue);
    assertFalse(value.isParticular());
    ValueAbstractState expectedAbstractDefault = actualAbstractShortConstant.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    assertSame(valueFactory.INTEGER_VALUE, value);
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String)} with {@code className}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String)"
  })
  public void testGetAbstractReferenceValueWithClassName() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    Value value = actualAbstractReferenceValue.getValue();
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Class Name", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertTrue(((IdentifiedReferenceValue) value).mayBeExtension());
    assertTrue(value.isSpecific());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String)} with {@code className}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String)"
  })
  public void testGetAbstractReferenceValueWithClassName2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String)} with {@code className}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String)"
  })
  public void testGetAbstractReferenceValueWithClassName3() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new MultiTypedReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    Value value = actualAbstractReferenceValue.getValue();
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertEquals("Class Name", ((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertEquals("Class Name", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) value).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(value.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String)} with {@code className}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String)"
  })
  public void testGetAbstractReferenceValueWithClassName4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String)} with {@code className}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String)"
  })
  public void testGetAbstractReferenceValueWithClassName_whenEmptyString() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue("");

    // Assert
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code internalType}, {@code referencedClazz}, {@code mayBeExtension}, {@code
   * mayBeNull}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void
      testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);
    LibraryClass referencedClazz = new LibraryClass();

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue(
            "Internal Type", referencedClazz, true, true);

    // Assert
    Value value = actualAbstractReferenceValue.getValue();
    Clazz referencedClass = ((IdentifiedReferenceValue) value).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Internal Type", ((IdentifiedReferenceValue) value).getType());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertTrue(((IdentifiedReferenceValue) value).mayBeExtension());
    assertTrue(value.isSpecific());
    assertSame(referencedClazz, referencedClass);
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code internalType}, {@code referencedClazz}, {@code mayBeExtension}, {@code
   * mayBeNull}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void
      testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue(
            "Internal Type", new LibraryClass(), true, true);

    // Assert
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code internalType}, {@code referencedClazz}, {@code mayBeExtension}, {@code
   * mayBeNull}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void
      testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull3() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new MultiTypedReferenceValueFactory(), null);
    LibraryClass referencedClazz = new LibraryClass();

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue(
            "Internal Type", referencedClazz, true, true);

    // Assert
    Value value = actualAbstractReferenceValue.getValue();
    Clazz referencedClass = ((MultiTypedReferenceValue) value).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertEquals("Internal Type", ((MultiTypedReferenceValue) value).getType());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertFalse(value.isParticular());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertSame(referencedClazz, referencedClass);
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code internalType}, {@code referencedClazz}, {@code mayBeExtension}, {@code
   * mayBeNull}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void
      testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue(
            "Internal Type", new LibraryClass(), true, true);

    // Assert
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code internalType}, {@code referencedClazz}, {@code mayBeExtension}, {@code
   * mayBeNull}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.getAbstractReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void
      testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, null);

    // Act
    ValueAbstractState actualAbstractReferenceValue =
        jvmValueTransferRelation.getAbstractReferenceValue("", new LibraryClass(), true, true);

    // Assert
    ValueAbstractState expectedAbstractDefault = actualAbstractReferenceValue.UNKNOWN;
    assertSame(expectedAbstractDefault, jvmValueTransferRelation.getAbstractDefault());
    ReferenceValue expectedValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedValue, actualAbstractReferenceValue.getValue());
  }

  /**
   * Test {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call, List)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmValueTransferRelation.invokeMethod(JvmAbstractState, Call, List)"})
  public void testInvokeMethod() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    jvmValueTransferRelation.invokeMethod(state, call, new ArrayList<>());

    // Assert
    ValueAbstractState peekResult = state.peek();
    assertTrue(peekResult.getValue() instanceof IdentifiedReferenceValue);
    assertNull(peekResult.getPrecision());
    assertEquals(1, state.getFrame().getOperandStack().size());
    assertSame(peekResult, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call, List)}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmValueTransferRelation.invokeMethod(JvmAbstractState, Call, List)"})
  public void testInvokeMethod_givenUnknown_whenArrayListAddUnknown_thenArrayListSizeIsOne() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    ArrayList<ValueAbstractState> operands = new ArrayList<>();
    operands.add(ValueAbstractState.UNKNOWN);

    // Act
    jvmValueTransferRelation.invokeMethod(state, call, operands);

    // Assert
    ValueAbstractState peekResult = state.peek();
    assertTrue(peekResult.getValue() instanceof IdentifiedReferenceValue);
    assertNull(peekResult.getPrecision());
    assertEquals(1, operands.size());
    assertEquals(operands, state.getFrame().getOperandStack());
    assertSame(peekResult, operands.get(0));
    assertSame(peekResult, jvmValueTransferRelation.getAbstractDefault());
  }

  /**
   * Test {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call, List)}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmValueTransferRelation.invokeMethod(JvmAbstractState, Call, List)"})
  public void testInvokeMethod_givenUnknown_whenArrayListAddUnknown_thenArrayListSizeIsTwo() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    ArrayList<ValueAbstractState> operands = new ArrayList<>();
    operands.add(ValueAbstractState.UNKNOWN);
    operands.add(ValueAbstractState.UNKNOWN);

    // Act
    jvmValueTransferRelation.invokeMethod(state, call, operands);

    // Assert
    assertEquals(1, state.getFrame().getOperandStack().size());
    assertEquals(2, operands.size());
  }

  /**
   * Test {@link JvmValueTransferRelation#handleCheckCast(ValueAbstractState, String)} with {@code
   * ValueAbstractState}, {@code String}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#handleCheckCast(ValueAbstractState,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueTransferRelation.handleCheckCast(ValueAbstractState, String)"
  })
  public void testHandleCheckCastWithValueAbstractStateString() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);

    // Act
    ValueAbstractState actualHandleCheckCastResult =
        jvmValueTransferRelation.handleCheckCast(
            new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE), "Internal Name");

    // Assert
    ValueAbstractState valueAbstractState = actualHandleCheckCastResult.UNKNOWN;
    assertSame(valueAbstractState, jvmValueTransferRelation.getAbstractDefault());
    assertSame(valueAbstractState, actualHandleCheckCastResult);
  }
}

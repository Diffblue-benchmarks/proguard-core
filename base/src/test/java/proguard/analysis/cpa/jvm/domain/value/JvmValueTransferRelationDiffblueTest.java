package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.analysis.datastructure.callgraph.ConcreteCall;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.visitor.MemberVisitor;
import proguard.evaluation.ExecutingInvocationUnit;
import proguard.evaluation.MethodResult;
import proguard.evaluation.MethodResult.Builder;
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
import proguard.exception.ProguardCoreException;

class JvmValueTransferRelationDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.<init>(proguard.evaluation.value.ValueFactory, proguard.evaluation.ExecutingInvocationUnit)",
    "proguard.evaluation.value.ValueFactory proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getValueFactory()"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test getAbstractDefault()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractDefault()"
  })
  void testGetAbstractDefault() {
    // Arrange and Act
    ValueAbstractState actualAbstractDefault =
        (new JvmValueTransferRelation(
                new ParticularReferenceValueFactory(), mock(ExecutingInvocationUnit.class)))
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
  @DisplayName("Test getAbstractByteConstant(byte)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractByteConstant(byte)"
  })
  void testGetAbstractByteConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractByteConstant(byte); then Value return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractByteConstant(byte)"
  })
  void testGetAbstractByteConstant_thenValueReturnParticularIntegerValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new BasicRangeValueFactory(), mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractDoubleConstant(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractDoubleConstant(double)"
  })
  void testGetAbstractDoubleConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    List<ValueAbstractState> actualAbstractDoubleConstant =
        (new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class)))
            .getAbstractDoubleConstant(10.0d);

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
  @DisplayName(
      "Test getAbstractDoubleConstant(double); then second Value return ParticularDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractDoubleConstant(double)"
  })
  void testGetAbstractDoubleConstant_thenSecondValueReturnParticularDoubleValue() {
    // Arrange and Act
    List<ValueAbstractState> actualAbstractDoubleConstant =
        (new JvmValueTransferRelation(
                new BasicRangeValueFactory(), mock(ExecutingInvocationUnit.class)))
            .getAbstractDoubleConstant(10.0d);

    // Assert
    assertEquals(2, actualAbstractDoubleConstant.size());
    Value value = actualAbstractDoubleConstant.get(1).getValue();
    assertTrue(value instanceof ParticularDoubleValue);
    assertEquals(10.0d, ((ParticularDoubleValue) value).value());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
  }

  /**
   * Test {@link JvmValueTransferRelation#getAbstractFloatConstant(float)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#getAbstractFloatConstant(float)}
   */
  @Test
  @DisplayName("Test getAbstractFloatConstant(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractFloatConstant(float)"
  })
  void testGetAbstractFloatConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractFloatConstant(float); then Value return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractFloatConstant(float)"
  })
  void testGetAbstractFloatConstant_thenValueReturnParticularFloatValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new BasicRangeValueFactory(), mock(ExecutingInvocationUnit.class));

    // Act
    ValueAbstractState actualAbstractFloatConstant =
        jvmValueTransferRelation.getAbstractFloatConstant(10.0f);

    // Assert
    Value value = actualAbstractFloatConstant.getValue();
    assertTrue(value instanceof ParticularFloatValue);
    assertEquals(10.0f, ((ParticularFloatValue) value).value());
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
  @DisplayName("Test getAbstractIntegerConstant(int); then Value return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractIntegerConstant(int)"
  })
  void testGetAbstractIntegerConstant_thenValueReturnRangeIntegerValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new RangeValueFactory(), mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractIntegerConstant(int); then Value return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractIntegerConstant(int)"
  })
  void testGetAbstractIntegerConstant_thenValueReturnUnknownIntegerValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractLongConstant(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractLongConstant(long)"
  })
  void testGetAbstractLongConstant() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    List<ValueAbstractState> actualAbstractLongConstant =
        (new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class)))
            .getAbstractLongConstant(1L);

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
  @DisplayName("Test getAbstractLongConstant(long); then second Value return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractLongConstant(long)"
  })
  void testGetAbstractLongConstant_thenSecondValueReturnParticularLongValue() {
    // Arrange and Act
    List<ValueAbstractState> actualAbstractLongConstant =
        (new JvmValueTransferRelation(
                new BasicRangeValueFactory(), mock(ExecutingInvocationUnit.class)))
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
  @DisplayName("Test getAbstractNull(); then Value return MultiTypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractNull()"
  })
  void testGetAbstractNull_thenValueReturnMultiTypedReferenceValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new MultiTypedReferenceValueFactory(), mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractNull(); then Value return TypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractNull()"
  })
  void testGetAbstractNull_thenValueReturnTypedReferenceValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractShortConstant(short); then Value return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractShortConstant(short)"
  })
  void testGetAbstractShortConstant_thenValueReturnRangeIntegerValue() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new RangeValueFactory(), mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractShortConstant(short); then Value return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractShortConstant(short)"
  })
  void testGetAbstractShortConstant_thenValueReturnUnknownIntegerValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractReferenceValue(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String)"
  })
  void testGetAbstractReferenceValueWithClassName() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractReferenceValue(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String)"
  })
  void testGetAbstractReferenceValueWithClassName2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractReferenceValue(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String)"
  })
  void testGetAbstractReferenceValueWithClassName3() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new MultiTypedReferenceValueFactory(), mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractReferenceValue(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String)"
  })
  void testGetAbstractReferenceValueWithClassName4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName("Test getAbstractReferenceValue(String) with 'className'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String)"
  })
  void testGetAbstractReferenceValueWithClassName_whenEmptyString() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName(
      "Test getAbstractReferenceValue(String, Clazz, boolean, boolean) with 'internalType', 'referencedClazz', 'mayBeExtension', 'mayBeNull'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), mock(ExecutingInvocationUnit.class));
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
  @DisplayName(
      "Test getAbstractReferenceValue(String, Clazz, boolean, boolean) with 'internalType', 'referencedClazz', 'mayBeExtension', 'mayBeNull'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull2() {
    // Arrange
    BasicValueFactory valueFactory = new BasicValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName(
      "Test getAbstractReferenceValue(String, Clazz, boolean, boolean) with 'internalType', 'referencedClazz', 'mayBeExtension', 'mayBeNull'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull3() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new MultiTypedReferenceValueFactory(), mock(ExecutingInvocationUnit.class));
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
  @DisplayName(
      "Test getAbstractReferenceValue(String, Clazz, boolean, boolean) with 'internalType', 'referencedClazz', 'mayBeExtension', 'mayBeNull'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
  @DisplayName(
      "Test getAbstractReferenceValue(String, Clazz, boolean, boolean) with 'internalType', 'referencedClazz', 'mayBeExtension', 'mayBeNull'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.getAbstractReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testGetAbstractReferenceValueWithInternalTypeReferencedClazzMayBeExtensionMayBeNull5() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(valueFactory, mock(ExecutingInvocationUnit.class));

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
   * Test {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}
   */
  @Test
  @DisplayName("Test processCall(JvmAbstractState, Call)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.processCall(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testProcessCall() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);
    JvmValueAbstractState state = mock(JvmValueAbstractState.class);
    when(state.push(Mockito.<ValueAbstractState>any())).thenReturn(ValueAbstractState.UNKNOWN);
    when(state.pop()).thenReturn(ValueAbstractState.UNKNOWN);
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    jvmValueTransferRelation.processCall(
        state,
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Assert
    verify(state, atLeast(1)).pop();
    verify(state).push(isA(ValueAbstractState.class));
  }

  /**
   * Test {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}
   */
  @Test
  @DisplayName("Test processCall(JvmAbstractState, Call)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.processCall(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testProcessCall2() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);
    JvmValueAbstractState state = mock(JvmValueAbstractState.class);
    when(state.push(Mockito.<ValueAbstractState>any())).thenReturn(ValueAbstractState.UNKNOWN);
    when(state.pop()).thenReturn(ValueAbstractState.UNKNOWN);
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    jvmValueTransferRelation.processCall(
        state,
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Assert
    verify(state, atLeast(1)).pop();
    verify(state).push(isA(ValueAbstractState.class));
  }

  /**
   * Test {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}
   */
  @Test
  @DisplayName("Test processCall(JvmAbstractState, Call)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.processCall(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testProcessCall3() {
    // Arrange
    ExecutingInvocationUnit executingInvocationUnit = mock(ExecutingInvocationUnit.class);
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();
    when(executingInvocationUnit.executeMethod(
            Mockito.<ConcreteCall>any(), (Value[]) Mockito.any()))
        .thenReturn(buildResult);
    when(executingInvocationUnit.canExecute(Mockito.<MethodSignature>any())).thenReturn(true);
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), executingInvocationUnit);
    JvmValueAbstractState state = mock(JvmValueAbstractState.class);
    when(state.push(Mockito.<ValueAbstractState>any())).thenReturn(ValueAbstractState.UNKNOWN);
    when(state.pop()).thenReturn(ValueAbstractState.UNKNOWN);
    ConcreteCall call = mock(ConcreteCall.class);
    when(call.getTargetClass()).thenReturn(new LibraryClass());
    when(call.getTargetMethod()).thenReturn(new LibraryMethod(1, "Name", "Descriptor"));
    when(call.isStatic()).thenReturn(true);
    when(call.getTarget()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    jvmValueTransferRelation.processCall(state, call);

    // Assert
    verify(state).pop();
    verify(state).push(isA(ValueAbstractState.class));
    verify(call, atLeast(1)).isStatic();
    verify(call, atLeast(1)).getTarget();
    verify(call).getTargetClass();
    verify(call).getTargetMethod();
    verify(executingInvocationUnit).canExecute(isA(MethodSignature.class));
    verify(executingInvocationUnit).executeMethod(isA(ConcreteCall.class), (Value[]) Mockito.any());
  }

  /**
   * Test {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}.
   *
   * <ul>
   *   <li>Given {@link ExecutingInvocationUnit} {@link
   *       ExecutingInvocationUnit#supportsAnyMethodOf(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}
   */
  @Test
  @DisplayName(
      "Test processCall(JvmAbstractState, Call); given ExecutingInvocationUnit supportsAnyMethodOf(String) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.processCall(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testProcessCall_givenExecutingInvocationUnitSupportsAnyMethodOfReturnFalse() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.setUpdatedInstance(Mockito.<ReferenceValue>any())).thenReturn(new Builder());
    Builder setUpdatedInstanceResult =
        builder.setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();
    ExecutingInvocationUnit executingInvocationUnit = mock(ExecutingInvocationUnit.class);
    when(executingInvocationUnit.canExecute(Mockito.<MethodSignature>any())).thenReturn(false);
    when(executingInvocationUnit.supportsAnyMethodOf(Mockito.<String>any())).thenReturn(false);
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), executingInvocationUnit);
    JvmValueAbstractState state = mock(JvmValueAbstractState.class);
    when(state.push(Mockito.<ValueAbstractState>any())).thenReturn(ValueAbstractState.UNKNOWN);
    when(state.pop()).thenReturn(ValueAbstractState.UNKNOWN);
    ConcreteCall call = mock(ConcreteCall.class);
    when(call.isStatic()).thenReturn(true);
    when(call.getTarget()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    jvmValueTransferRelation.processCall(state, call);

    // Assert
    verify(state).pop();
    verify(state).push(isA(ValueAbstractState.class));
    verify(call).isStatic();
    verify(call, atLeast(1)).getTarget();
    verify(executingInvocationUnit).canExecute(isA(MethodSignature.class));
    verify(executingInvocationUnit).supportsAnyMethodOf(eq("java/lang/Class"));
    verify(builder).setUpdatedInstance(isA(ReferenceValue.class));
  }

  /**
   * Test {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}.
   *
   * <ul>
   *   <li>Then calls {@link ConcreteCall#getTargetMethod()}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}
   */
  @Test
  @DisplayName("Test processCall(JvmAbstractState, Call); then calls getTargetMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.processCall(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testProcessCall_thenCallsGetTargetMethod() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.setUpdatedInstance(Mockito.<ReferenceValue>any())).thenReturn(new Builder());
    Builder setUpdatedInstanceResult =
        builder.setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();
    ExecutingInvocationUnit executingInvocationUnit = mock(ExecutingInvocationUnit.class);
    when(executingInvocationUnit.executeMethod(
            Mockito.<ConcreteCall>any(), (Value[]) Mockito.any()))
        .thenReturn(buildResult);
    when(executingInvocationUnit.canExecute(Mockito.<MethodSignature>any())).thenReturn(true);
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), executingInvocationUnit);
    JvmValueAbstractState state = mock(JvmValueAbstractState.class);
    when(state.push(Mockito.<ValueAbstractState>any())).thenReturn(ValueAbstractState.UNKNOWN);
    when(state.pop()).thenReturn(ValueAbstractState.UNKNOWN);
    ConcreteCall call = mock(ConcreteCall.class);
    when(call.getTargetClass()).thenReturn(new LibraryClass());
    when(call.getTargetMethod()).thenReturn(new LibraryMethod(1, "Name", "Descriptor"));
    when(call.isStatic()).thenReturn(true);
    when(call.getTarget()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    jvmValueTransferRelation.processCall(state, call);

    // Assert
    verify(state).pop();
    verify(state).push(isA(ValueAbstractState.class));
    verify(call, atLeast(1)).isStatic();
    verify(call, atLeast(1)).getTarget();
    verify(call).getTargetClass();
    verify(call).getTargetMethod();
    verify(executingInvocationUnit).canExecute(isA(MethodSignature.class));
    verify(executingInvocationUnit).executeMethod(isA(ConcreteCall.class), (Value[]) Mockito.any());
    verify(builder).setUpdatedInstance(isA(ReferenceValue.class));
  }

  /**
   * Test {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}.
   *
   * <ul>
   *   <li>Then calls {@link ConcreteCall#targetMethodAccept(MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}
   */
  @Test
  @DisplayName(
      "Test processCall(JvmAbstractState, Call); then calls targetMethodAccept(MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.processCall(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testProcessCall_thenCallsTargetMethodAccept() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.setUpdatedInstance(Mockito.<ReferenceValue>any())).thenReturn(new Builder());
    Builder setUpdatedInstanceResult =
        builder.setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();
    ExecutingInvocationUnit executingInvocationUnit = mock(ExecutingInvocationUnit.class);
    when(executingInvocationUnit.canExecute(Mockito.<MethodSignature>any())).thenReturn(false);
    when(executingInvocationUnit.supportsAnyMethodOf(Mockito.<String>any())).thenReturn(true);
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), executingInvocationUnit);
    JvmValueAbstractState state = mock(JvmValueAbstractState.class);
    when(state.push(Mockito.<ValueAbstractState>any())).thenReturn(ValueAbstractState.UNKNOWN);
    when(state.pop()).thenReturn(ValueAbstractState.UNKNOWN);
    ConcreteCall call = mock(ConcreteCall.class);
    doNothing().when(call).targetMethodAccept(Mockito.<MemberVisitor>any());
    when(call.isStatic()).thenReturn(true);
    when(call.getTarget()).thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    jvmValueTransferRelation.processCall(state, call);

    // Assert
    verify(state).pop();
    verify(state).push(isA(ValueAbstractState.class));
    verify(call).isStatic();
    verify(call, atLeast(1)).getTarget();
    verify(call).targetMethodAccept(isA(MemberVisitor.class));
    verify(executingInvocationUnit).canExecute(isA(MethodSignature.class));
    verify(executingInvocationUnit).supportsAnyMethodOf(eq("java/lang/Class"));
    verify(builder).setUpdatedInstance(isA(ReferenceValue.class));
  }

  /**
   * Test {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}.
   *
   * <ul>
   *   <li>When {@link JvmFrameAbstractState} {@link
   *       JvmFrameAbstractState#push(LatticeAbstractState)} return {@link
   *       ValueAbstractState#UNKNOWN}.
   *   <li>Then calls {@link JvmFrameAbstractState#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#processCall(JvmAbstractState, Call)}
   */
  @Test
  @DisplayName(
      "Test processCall(JvmAbstractState, Call); when JvmFrameAbstractState push(LatticeAbstractState) return UNKNOWN; then calls pop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.processCall(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testProcessCall_whenJvmFrameAbstractStatePushReturnUnknown_thenCallsPop() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = mock(JvmFrameAbstractState.class);
    when(frame.push(Mockito.<ValueAbstractState>any())).thenReturn(ValueAbstractState.UNKNOWN);
    when(frame.pop()).thenReturn(ValueAbstractState.UNKNOWN);
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    jvmValueTransferRelation.processCall(
        state,
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Assert
    verify(frame, atLeast(1)).pop();
    verify(frame).push(isA(ValueAbstractState.class));
  }

  /**
   * Test {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call, List)}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @DisplayName("Test invokeMethod(JvmAbstractState, Call, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.invokeMethod(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call, java.util.List)"
  })
  void testInvokeMethod() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), mock(ExecutingInvocationUnit.class));
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
    assertTrue(peekResult.getValue() instanceof TypedReferenceValue);
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
  @DisplayName(
      "Test invokeMethod(JvmAbstractState, Call, List); given UNKNOWN; when ArrayList() add UNKNOWN; then ArrayList() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.invokeMethod(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call, java.util.List)"
  })
  void testInvokeMethod_givenUnknown_whenArrayListAddUnknown_thenArrayListSizeIsOne() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), mock(ExecutingInvocationUnit.class));
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
    assertTrue(peekResult.getValue() instanceof TypedReferenceValue);
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
  @DisplayName(
      "Test invokeMethod(JvmAbstractState, Call, List); given UNKNOWN; when ArrayList() add UNKNOWN; then ArrayList() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.invokeMethod(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call, java.util.List)"
  })
  void testInvokeMethod_givenUnknown_whenArrayListAddUnknown_thenArrayListSizeIsTwo() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), mock(ExecutingInvocationUnit.class));
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
   * Test {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call, List)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @DisplayName("Test invokeMethod(JvmAbstractState, Call, List); then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.invokeMethod(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call, java.util.List)"
  })
  void testInvokeMethod_thenThrowProguardCoreException() {
    // Arrange
    ExecutingInvocationUnit executingInvocationUnit = mock(ExecutingInvocationUnit.class);

    ProguardCoreException.Builder builder =
        new ProguardCoreException.Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    when(executingInvocationUnit.canExecute(Mockito.<MethodSignature>any())).thenThrow(buildResult);
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), executingInvocationUnit);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod();
    ConcreteCall call =
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () -> jvmValueTransferRelation.invokeMethod(state, call, new ArrayList<>()));
    verify(executingInvocationUnit).canExecute(isA(MethodSignature.class));
  }

  /**
   * Test {@link JvmValueTransferRelation#handleCheckCast(ValueAbstractState, String)} with {@code
   * ValueAbstractState}, {@code String}.
   *
   * <p>Method under test: {@link JvmValueTransferRelation#handleCheckCast(ValueAbstractState,
   * String)}
   */
  @Test
  @DisplayName(
      "Test handleCheckCast(ValueAbstractState, String) with 'ValueAbstractState', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation.handleCheckCast(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState, java.lang.String)"
  })
  void testHandleCheckCastWithValueAbstractStateString() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation =
        new JvmValueTransferRelation(
            new ParticularReferenceValueFactory(), mock(ExecutingInvocationUnit.class));

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

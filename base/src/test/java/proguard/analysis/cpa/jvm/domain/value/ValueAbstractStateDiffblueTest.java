package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.ArrayReferenceValue;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.CompositeDoubleValue;
import proguard.evaluation.value.CompositeFloatValue;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;

public class ValueAbstractStateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValueAbstractState#ValueAbstractState(Value)}
   *   <li>{@link ValueAbstractState#setValue(Value)}
   *   <li>{@link ValueAbstractState#toString()}
   *   <li>{@link ValueAbstractState#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ValueAbstractState.<init>(Value)",
    "Value ValueAbstractState.getValue()",
    "void ValueAbstractState.setValue(Value)",
    "String ValueAbstractState.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ValueAbstractState actualValueAbstractState =
        new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;
    actualValueAbstractState.setValue(value);
    String actualToStringResult = actualValueAbstractState.toString();

    // Assert
    assertEquals("ValueAbstractState(d)", actualToStringResult);
    assertSame(value, actualValueAbstractState.getValue());
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertSame(
        valueAbstractState,
        valueAbstractState.join(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState2() {
    // Arrange
    ValueAbstractState valueAbstractState =
        new ValueAbstractState(
            new CompositeDoubleValue(
                BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));
    ValueAbstractState abstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(abstractState, valueAbstractState.join(abstractState));
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState_givenUnknown_whenUnknown_thenReturnUnknown() {
    // Arrange and Act
    ValueAbstractState actualJoinResult =
        ValueAbstractState.UNKNOWN.join(ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState_givenValueAbstractStateWithValueIsDouble_value() {
    // Arrange and Act
    ValueAbstractState actualJoinResult =
        (new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)).join(ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState_givenValueAbstractStateWithValueIsReference_value() {
    // Arrange
    ValueAbstractState valueAbstractState =
        new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState.join(ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState_thenReturnUnknown() {
    // Arrange and Act
    ValueAbstractState actualJoinResult =
        ValueAbstractState.UNKNOWN.join(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Then return Value Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState_thenReturnValueTypeIsLjavaLangObject() {
    // Arrange, Act and Assert
    Value value =
        (new ValueAbstractState(
                new ArrayReferenceValue("Type", null, true, BasicValueFactory.INTEGER_VALUE)))
            .join(ValueAbstractState.UNKNOWN)
            .getValue();
    assertTrue(value instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TypedReferenceValue) value).getType());
    assertNull(((TypedReferenceValue) value).getReferencedClass());
    assertEquals(0, ((TypedReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertTrue(((TypedReferenceValue) value).mayBeExtension());
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Then Value ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState_thenValueReferencedClassReturnLibraryClass() {
    // Arrange, Act and Assert
    Value value =
        (new ValueAbstractState(
                new ArrayReferenceValue(
                    "Ljava/lang/String;", null, true, BasicValueFactory.INTEGER_VALUE)))
            .join(ValueAbstractState.UNKNOWN)
            .getValue();
    Clazz referencedClass = ((TypedReferenceValue) value).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/String;", ((TypedReferenceValue) value).getType());
    assertNull(((LibraryClass) referencedClass).interfaceNames);
    assertNull(((LibraryClass) referencedClass).fields);
    assertNull(((LibraryClass) referencedClass).methods);
    assertNull(referencedClass.getProcessingInfo());
    assertNull(referencedClass.getName());
    assertNull(referencedClass.getSuperName());
    assertNull(referencedClass.getFeatureName());
    assertNull(referencedClass.getSuperClass());
    assertNull(((LibraryClass) referencedClass).kotlinMetadata);
    assertEquals(0, referencedClass.getAccessFlags());
    assertEquals(0, referencedClass.getInterfaceCount());
    assertEquals(0, referencedClass.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) referencedClass).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, ((LibraryClass) referencedClass).subClassCount);
    assertTrue(referencedClass.getExtraFeatureNames().isEmpty());
    assertSame(clazzArray, ((LibraryClass) referencedClass).subClasses);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>When {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  public void testJoinWithValueAbstractState_whenValueAbstractStateWithValueIsReference_value() {
    // Arrange
    ValueAbstractState abstractState = new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertEquals(abstractState, ValueAbstractState.UNKNOWN.join(abstractState));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  public void testIsLessOrEqualWithValueAbstractState() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertTrue(
        valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  public void testIsLessOrEqualWithValueAbstractState2() {
    // Arrange, Act and Assert
    assertTrue(
        ValueAbstractState.UNKNOWN.isLessOrEqual(
            new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  public void testIsLessOrEqualWithValueAbstractState3() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertFalse(
        valueAbstractState.isLessOrEqual(
            new ValueAbstractState(
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE))));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  public void testIsLessOrEqualWithValueAbstractState4() {
    // Arrange
    ValueAbstractState valueAbstractState =
        new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertFalse(
        valueAbstractState.isLessOrEqual(
            new ValueAbstractState(
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE))));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  public void testIsLessOrEqualWithValueAbstractState5() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE);

    // Act and Assert
    assertTrue(
        valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  public void testIsLessOrEqualWithValueAbstractState_givenUnknown_whenUnknown_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ValueAbstractState.UNKNOWN.isLessOrEqual(ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  public void testIsLessOrEqualWithValueAbstractState_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        ValueAbstractState.UNKNOWN.isLessOrEqual(
            new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#copy()}.
   *
   * <p>Method under test: {@link ValueAbstractState#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AbstractState ValueAbstractState.copy()"})
  public void testCopy() {
    // Arrange and Act
    AbstractState actualCopyResult = ValueAbstractState.UNKNOWN.copy();
    AbstractState actualCopyResult2 = actualCopyResult.copy();

    // Assert
    assertTrue(actualCopyResult2 instanceof ValueAbstractState);
    assertTrue(actualCopyResult instanceof ValueAbstractState);
    ValueAbstractState valueAbstractState = ((ValueAbstractState) actualCopyResult2).UNKNOWN;
    assertEquals(valueAbstractState, actualCopyResult2);
    assertEquals(valueAbstractState, actualCopyResult);
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}, and {@link ValueAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValueAbstractState#equals(Object)}
   *   <li>{@link ValueAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    ValueAbstractState valueAbstractState2 = ValueAbstractState.UNKNOWN;

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState2);
    int expectedHashCodeResult = valueAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, valueAbstractState2.hashCode());
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}, and {@link ValueAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValueAbstractState#equals(Object)}
   *   <li>{@link ValueAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState);
    int expectedHashCodeResult = valueAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, valueAbstractState.hashCode());
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE), ValueAbstractState.UNKNOWN);
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE), ValueAbstractState.UNKNOWN);
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(
        ValueAbstractState.UNKNOWN, new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValueAbstractState.UNKNOWN, null);
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValueAbstractState.UNKNOWN, "Different type to ValueAbstractState");
  }
}

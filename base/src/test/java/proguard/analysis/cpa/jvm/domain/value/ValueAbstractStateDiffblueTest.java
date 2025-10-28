package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
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
import proguard.evaluation.value.object.AnalyzedObject;

public class ValueAbstractStateDiffblueTest {
  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin() {
    // Arrange and Act
    ValueAbstractState actualJoinResult = ValueAbstractState.UNKNOWN.join(ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin2() {
    // Arrange and Act
    ValueAbstractState actualJoinResult = (new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE))
        .join(ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin3() {
    // Arrange and Act
    ValueAbstractState actualJoinResult = ValueAbstractState.UNKNOWN
        .join(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin4() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState.join(ValueAbstractState.UNKNOWN));
  }

  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin5() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertSame(valueAbstractState, valueAbstractState.join(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin6() {
    // Arrange
    ValueAbstractState abstractState = new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertEquals(abstractState, ValueAbstractState.UNKNOWN.join(abstractState));
  }

  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin7() {
    // Arrange and Act
    ValueAbstractState actualJoinResult = (new ValueAbstractState(
        new ArrayReferenceValue("Type", null, true, BasicValueFactory.INTEGER_VALUE))).join(ValueAbstractState.UNKNOWN);

    // Assert
    Value value = actualJoinResult.getValue();
    assertTrue(value instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TypedReferenceValue) value).getType());
    AnalyzedObject value2 = ((TypedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(actualJoinResult.getPrecision());
    assertNull(((TypedReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, ((TypedReferenceValue) value).isNotNull());
    assertEquals(0, ((TypedReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertTrue(((TypedReferenceValue) value).mayBeExtension());
  }

  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin8() {
    // Arrange and Act
    ValueAbstractState actualJoinResult = (new ValueAbstractState(
        new ArrayReferenceValue("Ljava/lang/String;", null, true, BasicValueFactory.INTEGER_VALUE)))
            .join(ValueAbstractState.UNKNOWN);

    // Assert
    Value value = actualJoinResult.getValue();
    Clazz referencedClass = ((TypedReferenceValue) value).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/String;", ((TypedReferenceValue) value).getType());
    assertNull(((LibraryClass) referencedClass).interfaceNames);
    assertNull(((LibraryClass) referencedClass).fields);
    assertNull(((LibraryClass) referencedClass).methods);
    AnalyzedObject value2 = ((TypedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(referencedClass.getProcessingInfo());
    assertNull(referencedClass.getName());
    assertNull(referencedClass.getSuperName());
    assertNull(referencedClass.getFeatureName());
    assertNull(actualJoinResult.getPrecision());
    assertNull(referencedClass.getSuperClass());
    assertNull(((LibraryClass) referencedClass).kotlinMetadata);
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, referencedClass.getAccessFlags());
    assertEquals(0, referencedClass.getInterfaceCount());
    assertEquals(0, ((TypedReferenceValue) value).isNotNull());
    assertEquals(0, ((TypedReferenceValue) value).isNull());
    assertEquals(0, referencedClass.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) referencedClass).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, ((LibraryClass) referencedClass).subClassCount);
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertTrue(referencedClass.getExtraFeatureNames().isEmpty());
    assertTrue(((TypedReferenceValue) value).mayBeExtension());
    assertSame(clazzArray, ((LibraryClass) referencedClass).subClasses);
  }

  /**
   * Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  public void testJoin9() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));
    ValueAbstractState abstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(abstractState, valueAbstractState.join(abstractState));
  }

  /**
   * Method under test:
   * {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  public void testIsLessOrEqual() {
    // Arrange, Act and Assert
    assertTrue(ValueAbstractState.UNKNOWN.isLessOrEqual(ValueAbstractState.UNKNOWN));
    assertFalse(ValueAbstractState.UNKNOWN.isLessOrEqual(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
    assertTrue(ValueAbstractState.UNKNOWN.isLessOrEqual(new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE)));
  }

  /**
   * Method under test:
   * {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  public void testIsLessOrEqual2() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertTrue(valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Method under test:
   * {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  public void testIsLessOrEqual3() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertFalse(valueAbstractState.isLessOrEqual(new ValueAbstractState(
        new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE))));
  }

  /**
   * Method under test:
   * {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  public void testIsLessOrEqual4() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertFalse(valueAbstractState.isLessOrEqual(new ValueAbstractState(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE))));
  }

  /**
   * Method under test:
   * {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  public void testIsLessOrEqual5() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE);

    // Act and Assert
    assertTrue(valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE)));
  }

  /**
   * Method under test: {@link ValueAbstractState#copy()}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ValueAbstractState#equals(Object)}
   *   <li>{@link ValueAbstractState#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ValueAbstractState#equals(Object)}
   *   <li>{@link ValueAbstractState#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState);
    int expectedHashCodeResult = valueAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, valueAbstractState.hashCode());
  }

  /**
   * Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE), ValueAbstractState.UNKNOWN);
    assertNotEquals(new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE), ValueAbstractState.UNKNOWN);
    assertNotEquals(ValueAbstractState.UNKNOWN, new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValueAbstractState.UNKNOWN, null);
  }

  /**
   * Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValueAbstractState.UNKNOWN, "Different type to ValueAbstractState");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ValueAbstractState#ValueAbstractState(Value)}
   *   <li>{@link ValueAbstractState#setValue(Value)}
   *   <li>{@link ValueAbstractState#toString()}
   *   <li>{@link ValueAbstractState#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ValueAbstractState actualValueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;
    actualValueAbstractState.setValue(value);
    String actualToStringResult = actualValueAbstractState.toString();

    // Assert that nothing has changed
    assertEquals("ValueAbstractState(d)", actualToStringResult);
    assertSame(value, actualValueAbstractState.getValue());
  }
}

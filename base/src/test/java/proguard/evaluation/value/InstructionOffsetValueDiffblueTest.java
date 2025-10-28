package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class InstructionOffsetValueDiffblueTest {
  /**
   * Method under test: {@link InstructionOffsetValue#instructionOffsetCount()}
   */
  @Test
  public void testInstructionOffsetCount() {
    // Arrange, Act and Assert
    assertEquals(0, InstructionOffsetValue.EMPTY_VALUE.instructionOffsetCount());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#instructionOffset(int)}
   */
  @Test
  public void testInstructionOffset() {
    // Arrange, Act and Assert
    assertEquals(1, (new InstructionOffsetValue(new int[]{42, 1, 42, 1})).instructionOffset(1));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#contains(int)}
   */
  @Test
  public void testContains() {
    // Arrange, Act and Assert
    assertFalse(InstructionOffsetValue.EMPTY_VALUE.contains(42));
    assertTrue((new InstructionOffsetValue(42)).contains(42));
    assertFalse((new InstructionOffsetValue(1)).contains(42));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#minimumValue()}
   */
  @Test
  public void testMinimumValue() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, InstructionOffsetValue.EMPTY_VALUE.minimumValue());
    assertEquals(42, (new InstructionOffsetValue(42)).minimumValue());
    assertEquals(42,
        (new InstructionOffsetValue(new int[]{42, Integer.MAX_VALUE, 42, Integer.MAX_VALUE})).minimumValue());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#maximumValue()}
   */
  @Test
  public void testMaximumValue() {
    // Arrange, Act and Assert
    assertEquals(Integer.MIN_VALUE, InstructionOffsetValue.EMPTY_VALUE.maximumValue());
    assertEquals(42, (new InstructionOffsetValue(42)).maximumValue());
    assertEquals(42,
        (new InstructionOffsetValue(new int[]{42, Integer.MIN_VALUE, 42, Integer.MIN_VALUE})).maximumValue());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#isMethodParameter(int)}
   */
  @Test
  public void testIsMethodParameter() {
    // Arrange, Act and Assert
    assertFalse((new InstructionOffsetValue(new int[]{42, 1, 42, 1})).isMethodParameter(1));
    assertTrue((new InstructionOffsetValue(new int[]{42, InstructionOffsetValue.METHOD_PARAMETER, 42, 1}))
        .isMethodParameter(1));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#methodParameter(int)}
   */
  @Test
  public void testMethodParameter() {
    // Arrange, Act and Assert
    assertEquals(1, (new InstructionOffsetValue(new int[]{42, 1, 42, 1})).methodParameter(1));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#isMethodReturnValue(int)}
   */
  @Test
  public void testIsMethodReturnValue() {
    // Arrange, Act and Assert
    assertFalse((new InstructionOffsetValue(new int[]{42, 1, 42, 1})).isMethodReturnValue(1));
    assertTrue((new InstructionOffsetValue(new int[]{42, InstructionOffsetValue.METHOD_RETURN_VALUE, 42, 1}))
        .isMethodReturnValue(1));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#isFieldValue(int)}
   */
  @Test
  public void testIsFieldValue() {
    // Arrange, Act and Assert
    assertFalse((new InstructionOffsetValue(new int[]{42, 1, 42, 1})).isFieldValue(1));
    assertTrue((new InstructionOffsetValue(new int[]{42, InstructionOffsetValue.FIELD_VALUE, 42, 1})).isFieldValue(1));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#isNewinstance(int)}
   */
  @Test
  public void testIsNewinstance() {
    // Arrange, Act and Assert
    assertFalse((new InstructionOffsetValue(new int[]{42, 1, 42, 1})).isNewinstance(1));
    assertTrue(
        (new InstructionOffsetValue(new int[]{42, InstructionOffsetValue.NEW_INSTANCE, 42, 1})).isNewinstance(1));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#isCast(int)}
   */
  @Test
  public void testIsCast() {
    // Arrange, Act and Assert
    assertFalse((new InstructionOffsetValue(new int[]{42, 1, 42, 1})).isCast(1));
    assertTrue((new InstructionOffsetValue(new int[]{42, InstructionOffsetValue.CAST, 42, 1})).isCast(1));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#isExceptionHandler(int)}
   */
  @Test
  public void testIsExceptionHandler() {
    // Arrange, Act and Assert
    assertFalse((new InstructionOffsetValue(new int[]{42, 1, 42, 1})).isExceptionHandler(1));
    assertTrue((new InstructionOffsetValue(new int[]{42, InstructionOffsetValue.EXCEPTION_HANDLER, 42, 1}))
        .isExceptionHandler(1));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#add(int)}
   */
  @Test
  public void testAdd() {
    // Arrange and Act
    InstructionOffsetValue actualAddResult = InstructionOffsetValue.EMPTY_VALUE.add(42);

    // Assert
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#add(int)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);

    // Act and Assert
    assertSame(instructionOffsetValue, instructionOffsetValue.add(42));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#add(int)}
   */
  @Test
  public void testAdd3() {
    // Arrange and Act
    InstructionOffsetValue actualAddResult = (new InstructionOffsetValue(1)).add(42);

    // Assert
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#remove(int)}
   */
  @Test
  public void testRemove() {
    // Arrange and Act
    InstructionOffsetValue actualRemoveResult = InstructionOffsetValue.EMPTY_VALUE.remove(42);

    // Assert
    assertSame(actualRemoveResult.EMPTY_VALUE, actualRemoveResult);
  }

  /**
   * Method under test: {@link InstructionOffsetValue#remove(int)}
   */
  @Test
  public void testRemove2() {
    // Arrange and Act
    InstructionOffsetValue actualRemoveResult = (new InstructionOffsetValue(42)).remove(42);

    // Assert
    assertEquals(actualRemoveResult.EMPTY_VALUE, actualRemoveResult);
  }

  /**
   * Method under test: {@link InstructionOffsetValue#remove(int)}
   */
  @Test
  public void testRemove3() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(1);

    // Act and Assert
    assertSame(instructionOffsetValue, instructionOffsetValue.remove(42));
  }

  /**
   * Method under test:
   * {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange and Act
    InstructionOffsetValue actualGeneralizeResult = InstructionOffsetValue.EMPTY_VALUE
        .generalize(InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    assertSame(actualGeneralizeResult.EMPTY_VALUE, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);

    // Act and Assert
    assertSame(instructionOffsetValue, instructionOffsetValue.generalize(InstructionOffsetValue.EMPTY_VALUE));
  }

  /**
   * Method under test:
   * {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);
    InstructionOffsetValue other = new InstructionOffsetValue(42);

    // Act and Assert
    assertSame(other, instructionOffsetValue.generalize(other));
  }

  /**
   * Method under test:
   * {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(1);

    // Act
    InstructionOffsetValue actualGeneralizeResult = instructionOffsetValue.generalize(new InstructionOffsetValue(42));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertTrue(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(new int[]{42, 1, 42, 1});

    // Act
    InstructionOffsetValue actualGeneralizeResult = instructionOffsetValue.generalize(new InstructionOffsetValue(42));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertTrue(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(new int[]{42, 1, 42, 42});

    // Act and Assert
    assertSame(instructionOffsetValue, instructionOffsetValue.generalize(new InstructionOffsetValue(42)));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#generalize(Value)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange and Act
    Value actualGeneralizeResult = InstructionOffsetValue.EMPTY_VALUE
        .generalize((Value) InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    assertSame(((InstructionOffsetValue) actualGeneralizeResult).EMPTY_VALUE, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link InstructionOffsetValue#generalize(Value)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);

    // Act and Assert
    assertSame(instructionOffsetValue, instructionOffsetValue.generalize((Value) InstructionOffsetValue.EMPTY_VALUE));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#generalize(Value)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, InstructionOffsetValue.EMPTY_VALUE.generalize(other));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#instructionOffsetValue()}
   */
  @Test
  public void testInstructionOffsetValue() {
    // Arrange and Act
    InstructionOffsetValue actualInstructionOffsetValueResult = InstructionOffsetValue.EMPTY_VALUE
        .instructionOffsetValue();

    // Assert
    assertSame(actualInstructionOffsetValueResult.EMPTY_VALUE, actualInstructionOffsetValueResult);
  }

  /**
   * Method under test: {@link InstructionOffsetValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(6, InstructionOffsetValue.EMPTY_VALUE.computationalType());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("I", InstructionOffsetValue.EMPTY_VALUE.internalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InstructionOffsetValue#equals(Object)}
   *   <li>{@link InstructionOffsetValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = InstructionOffsetValue.EMPTY_VALUE;
    InstructionOffsetValue instructionOffsetValue2 = InstructionOffsetValue.EMPTY_VALUE;

    // Act and Assert
    assertEquals(instructionOffsetValue, instructionOffsetValue2);
    int expectedHashCodeResult = instructionOffsetValue.hashCode();
    assertEquals(expectedHashCodeResult, instructionOffsetValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InstructionOffsetValue#equals(Object)}
   *   <li>{@link InstructionOffsetValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);
    InstructionOffsetValue instructionOffsetValue2 = new InstructionOffsetValue(42);

    // Act and Assert
    assertEquals(instructionOffsetValue, instructionOffsetValue2);
    int expectedHashCodeResult = instructionOffsetValue.hashCode();
    assertEquals(expectedHashCodeResult, instructionOffsetValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InstructionOffsetValue#equals(Object)}
   *   <li>{@link InstructionOffsetValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = InstructionOffsetValue.EMPTY_VALUE;

    // Act and Assert
    assertEquals(instructionOffsetValue, instructionOffsetValue);
    int expectedHashCodeResult = instructionOffsetValue.hashCode();
    assertEquals(expectedHashCodeResult, instructionOffsetValue.hashCode());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals(":", InstructionOffsetValue.EMPTY_VALUE.toString());
    assertEquals("42:", (new InstructionOffsetValue(42)).toString());
    assertEquals("42,58,42,58:", (new InstructionOffsetValue(new int[]{42, 58, 42, 58})).toString());
    assertEquals("P0:", (new InstructionOffsetValue(InstructionOffsetValue.METHOD_PARAMETER)).toString());
    assertEquals("M0:", (new InstructionOffsetValue(InstructionOffsetValue.METHOD_RETURN_VALUE)).toString());
    assertEquals("F0:", (new InstructionOffsetValue(InstructionOffsetValue.FIELD_VALUE)).toString());
    assertEquals("N0:", (new InstructionOffsetValue(InstructionOffsetValue.NEW_INSTANCE)).toString());
    assertEquals("-1:", (new InstructionOffsetValue(Value.NEVER)).toString());
    assertEquals("C0:", (new InstructionOffsetValue(InstructionOffsetValue.CAST)).toString());
    assertEquals("E0:", (new InstructionOffsetValue(InstructionOffsetValue.EXCEPTION_HANDLER)).toString());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new InstructionOffsetValue(42), InstructionOffsetValue.EMPTY_VALUE);
  }

  /**
   * Method under test: {@link InstructionOffsetValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(1);

    // Act and Assert
    assertNotEquals(instructionOffsetValue, new InstructionOffsetValue(42));
  }

  /**
   * Method under test: {@link InstructionOffsetValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionOffsetValue.EMPTY_VALUE, null);
  }

  /**
   * Method under test: {@link InstructionOffsetValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionOffsetValue.EMPTY_VALUE, "Different type to InstructionOffsetValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InstructionOffsetValue#isParticular()}
   *   <li>{@link InstructionOffsetValue#isSpecific()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);

    // Act
    boolean actualIsParticularResult = instructionOffsetValue.isParticular();

    // Assert
    assertTrue(actualIsParticularResult);
    assertTrue(instructionOffsetValue.isSpecific());
  }

  /**
   * Method under test: {@link InstructionOffsetValue#InstructionOffsetValue(int)}
   */
  @Test
  public void testNewInstructionOffsetValue() {
    // Arrange and Act
    InstructionOffsetValue actualInstructionOffsetValue = new InstructionOffsetValue(42);

    // Assert
    assertFalse(actualInstructionOffsetValue.isCategory2());
    assertTrue(actualInstructionOffsetValue.isParticular());
    assertTrue(actualInstructionOffsetValue.isSpecific());
  }

  /**
   * Method under test:
   * {@link InstructionOffsetValue#InstructionOffsetValue(int[])}
   */
  @Test
  public void testNewInstructionOffsetValue2() {
    // Arrange and Act
    InstructionOffsetValue actualInstructionOffsetValue = new InstructionOffsetValue(new int[]{42, 1, 42, 1});

    // Assert
    assertFalse(actualInstructionOffsetValue.isCategory2());
    assertTrue(actualInstructionOffsetValue.isParticular());
    assertTrue(actualInstructionOffsetValue.isSpecific());
  }
}

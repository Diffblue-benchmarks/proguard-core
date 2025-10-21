package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnknownValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownValue}
   *   <li>{@link UnknownValue#toString()}
   *   <li>{@link UnknownValue#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnknownValue.<init>()",
    "boolean UnknownValue.isCategory2()",
    "String UnknownValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UnknownValue actualUnknownValue = new UnknownValue();
    String actualToStringResult = actualUnknownValue.toString();

    // Assert
    assertEquals("UNKNOWN", actualToStringResult);
    assertFalse(actualUnknownValue.isCategory2());
  }

  /**
   * Test {@link UnknownValue#generalize(Value)}.
   *
   * <p>Method under test: {@link UnknownValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value UnknownValue.generalize(Value)"})
  public void testGeneralize() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(unknownValue, unknownValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownValue#computationalType()}.
   *
   * <p>Method under test: {@link UnknownValue#computationalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnknownValue.computationalType()"})
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(Value.NEVER, BasicValueFactory.UNKNOWN_VALUE.computationalType());
  }

  /**
   * Test {@link UnknownValue#internalType()}.
   *
   * <p>Method under test: {@link UnknownValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnknownValue.internalType()"})
  public void testInternalType() {
    // Arrange, Act and Assert
    assertNull(BasicValueFactory.UNKNOWN_VALUE.internalType());
  }

  /**
   * Test {@link UnknownValue#equals(Object)}, and {@link UnknownValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownValue#equals(Object)}
   *   <li>{@link UnknownValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownValue.equals(Object)", "int UnknownValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;
    UnknownValue unknownValue2 = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertEquals(unknownValue, unknownValue2);
    int expectedHashCodeResult = unknownValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownValue2.hashCode());
  }

  /**
   * Test {@link UnknownValue#equals(Object)}, and {@link UnknownValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownValue#equals(Object)}
   *   <li>{@link UnknownValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownValue.equals(Object)", "int UnknownValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertEquals(unknownValue, unknownValue);
    int expectedHashCodeResult = unknownValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownValue.hashCode());
  }

  /**
   * Test {@link UnknownValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownValue.equals(Object)", "int UnknownValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, 3);
  }

  /**
   * Test {@link UnknownValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownValue.equals(Object)", "int UnknownValue.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, null);
  }

  /**
   * Test {@link UnknownValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownValue.equals(Object)", "int UnknownValue.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, "Different type to UnknownValue");
  }
}

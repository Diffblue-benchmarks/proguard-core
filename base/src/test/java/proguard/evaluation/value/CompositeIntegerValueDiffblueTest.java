package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CompositeIntegerValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeIntegerValue#CompositeIntegerValue(IntegerValue, byte, IntegerValue)}
   *   <li>{@link CompositeIntegerValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompositeIntegerValue.<init>(IntegerValue, byte, IntegerValue)",
    "java.lang.String CompositeIntegerValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(bAb)",
        (new CompositeIntegerValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .toString());
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}, and {@link
   * CompositeIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeIntegerValue#equals(Object)}
   *   <li>{@link CompositeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    CompositeIntegerValue compositeIntegerValue2 =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeIntegerValue, compositeIntegerValue2);
    int expectedHashCodeResult = compositeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeIntegerValue2.hashCode());
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}, and {@link
   * CompositeIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeIntegerValue#equals(Object)}
   *   <li>{@link CompositeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeIntegerValue, compositeIntegerValue);
    int expectedHashCodeResult = compositeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeIntegerValue.hashCode());
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_CHAR,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            new CompositeIntegerValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 1,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            new CompositeIntegerValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeIntegerValue.equals(Object)",
    "int CompositeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to CompositeIntegerValue");
  }
}

package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConvertedLongValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedLongValue#ConvertedLongValue(Value)}
   *   <li>{@link ConvertedLongValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConvertedLongValue.<init>(Value)",
    "java.lang.String ConvertedLongValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(long)(b)",
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link ConvertedLongValue#equals(Object)}, and {@link ConvertedLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedLongValue#equals(Object)}
   *   <li>{@link ConvertedLongValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedLongValue.equals(Object)",
    "int ConvertedLongValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedLongValue convertedLongValue2 =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedLongValue, convertedLongValue2);
    int expectedHashCodeResult = convertedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedLongValue2.hashCode());
  }

  /**
   * Test {@link ConvertedLongValue#equals(Object)}, and {@link ConvertedLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedLongValue#equals(Object)}
   *   <li>{@link ConvertedLongValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedLongValue.equals(Object)",
    "int ConvertedLongValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedLongValue, convertedLongValue);
    int expectedHashCodeResult = convertedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedLongValue.hashCode());
  }

  /**
   * Test {@link ConvertedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedLongValue.equals(Object)",
    "int ConvertedLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        convertedLongValue, new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedLongValue.equals(Object)",
    "int ConvertedLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link ConvertedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedLongValue.equals(Object)",
    "int ConvertedLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedLongValue");
  }
}

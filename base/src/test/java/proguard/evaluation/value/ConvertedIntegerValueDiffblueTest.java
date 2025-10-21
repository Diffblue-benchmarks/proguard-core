package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConvertedIntegerValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedIntegerValue#ConvertedIntegerValue(Value)}
   *   <li>{@link ConvertedIntegerValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConvertedIntegerValue.<init>(Value)",
    "java.lang.String ConvertedIntegerValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(int)(b)",
        (new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}, and {@link
   * ConvertedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedIntegerValue#equals(Object)}
   *   <li>{@link ConvertedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedIntegerValue.equals(Object)",
    "int ConvertedIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue =
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedIntegerValue convertedIntegerValue2 =
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedIntegerValue, convertedIntegerValue2);
    int expectedHashCodeResult = convertedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedIntegerValue2.hashCode());
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}, and {@link
   * ConvertedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedIntegerValue#equals(Object)}
   *   <li>{@link ConvertedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedIntegerValue.equals(Object)",
    "int ConvertedIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue =
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedIntegerValue, convertedIntegerValue);
    int expectedHashCodeResult = convertedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedIntegerValue.hashCode());
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedIntegerValue.equals(Object)",
    "int ConvertedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue =
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        convertedIntegerValue,
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedIntegerValue.equals(Object)",
    "int ConvertedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedIntegerValue.equals(Object)",
    "int ConvertedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedIntegerValue");
  }
}

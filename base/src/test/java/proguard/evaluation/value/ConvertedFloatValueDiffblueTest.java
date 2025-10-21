package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConvertedFloatValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedFloatValue#ConvertedFloatValue(Value)}
   *   <li>{@link ConvertedFloatValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConvertedFloatValue.<init>(Value)",
    "java.lang.String ConvertedFloatValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(float)(b)",
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link ConvertedFloatValue#equals(Object)}, and {@link ConvertedFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedFloatValue#equals(Object)}
   *   <li>{@link ConvertedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedFloatValue.equals(Object)",
    "int ConvertedFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedFloatValue convertedFloatValue =
        new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedFloatValue convertedFloatValue2 =
        new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedFloatValue, convertedFloatValue2);
    int expectedHashCodeResult = convertedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedFloatValue2.hashCode());
  }

  /**
   * Test {@link ConvertedFloatValue#equals(Object)}, and {@link ConvertedFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedFloatValue#equals(Object)}
   *   <li>{@link ConvertedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedFloatValue.equals(Object)",
    "int ConvertedFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedFloatValue convertedFloatValue =
        new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedFloatValue, convertedFloatValue);
    int expectedHashCodeResult = convertedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedFloatValue.hashCode());
  }

  /**
   * Test {@link ConvertedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedFloatValue.equals(Object)",
    "int ConvertedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedFloatValue convertedFloatValue =
        new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        convertedFloatValue, new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedFloatValue.equals(Object)",
    "int ConvertedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedFloatValue convertedFloatValue =
        new ConvertedFloatValue(new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        convertedFloatValue, new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedFloatValue.equals(Object)",
    "int ConvertedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link ConvertedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedFloatValue.equals(Object)",
    "int ConvertedFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedFloatValue");
  }
}

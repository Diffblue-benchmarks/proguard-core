package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConvertedDoubleValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedDoubleValue#ConvertedDoubleValue(Value)}
   *   <li>{@link ConvertedDoubleValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConvertedDoubleValue.<init>(Value)",
    "java.lang.String ConvertedDoubleValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(double)(b)",
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link ConvertedDoubleValue#equals(Object)}, and {@link ConvertedDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedDoubleValue#equals(Object)}
   *   <li>{@link ConvertedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedDoubleValue.equals(Object)",
    "int ConvertedDoubleValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue =
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedDoubleValue convertedDoubleValue2 =
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedDoubleValue, convertedDoubleValue2);
    int expectedHashCodeResult = convertedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedDoubleValue2.hashCode());
  }

  /**
   * Test {@link ConvertedDoubleValue#equals(Object)}, and {@link ConvertedDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedDoubleValue#equals(Object)}
   *   <li>{@link ConvertedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedDoubleValue.equals(Object)",
    "int ConvertedDoubleValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue =
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedDoubleValue, convertedDoubleValue);
    int expectedHashCodeResult = convertedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedDoubleValue.hashCode());
  }

  /**
   * Test {@link ConvertedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedDoubleValue.equals(Object)",
    "int ConvertedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue =
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        convertedDoubleValue, new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedDoubleValue.equals(Object)",
    "int ConvertedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue =
        new ConvertedDoubleValue(
            new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        convertedDoubleValue, new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedDoubleValue.equals(Object)",
    "int ConvertedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link ConvertedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedDoubleValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedDoubleValue.equals(Object)",
    "int ConvertedDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedDoubleValue");
  }
}

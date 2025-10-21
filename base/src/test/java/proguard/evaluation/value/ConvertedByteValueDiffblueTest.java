package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConvertedByteValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedByteValue#ConvertedByteValue(IntegerValue)}
   *   <li>{@link ConvertedByteValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConvertedByteValue.<init>(IntegerValue)",
    "java.lang.String ConvertedByteValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(byte)(b)",
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}, and {@link ConvertedByteValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedByteValue#equals(Object)}
   *   <li>{@link ConvertedByteValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue convertedByteValue2 =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedByteValue, convertedByteValue2);
    int expectedHashCodeResult = convertedByteValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedByteValue2.hashCode());
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}, and {@link ConvertedByteValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedByteValue#equals(Object)}
   *   <li>{@link ConvertedByteValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedByteValue, convertedByteValue);
    int expectedHashCodeResult = convertedByteValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedByteValue.hashCode());
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        convertedByteValue, new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        convertedByteValue, new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedByteValue");
  }
}

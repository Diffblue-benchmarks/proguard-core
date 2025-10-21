package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConvertedCharacterValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedCharacterValue#ConvertedCharacterValue(IntegerValue)}
   *   <li>{@link ConvertedCharacterValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConvertedCharacterValue.<init>(IntegerValue)",
    "java.lang.String ConvertedCharacterValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(char)(b)",
        (new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link ConvertedCharacterValue#equals(Object)}, and {@link
   * ConvertedCharacterValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedCharacterValue#equals(Object)}
   *   <li>{@link ConvertedCharacterValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedCharacterValue.equals(Object)",
    "int ConvertedCharacterValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedCharacterValue convertedCharacterValue =
        new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedCharacterValue convertedCharacterValue2 =
        new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedCharacterValue, convertedCharacterValue2);
    int expectedHashCodeResult = convertedCharacterValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedCharacterValue2.hashCode());
  }

  /**
   * Test {@link ConvertedCharacterValue#equals(Object)}, and {@link
   * ConvertedCharacterValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedCharacterValue#equals(Object)}
   *   <li>{@link ConvertedCharacterValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedCharacterValue.equals(Object)",
    "int ConvertedCharacterValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedCharacterValue convertedCharacterValue =
        new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedCharacterValue, convertedCharacterValue);
    int expectedHashCodeResult = convertedCharacterValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedCharacterValue.hashCode());
  }

  /**
   * Test {@link ConvertedCharacterValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedCharacterValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedCharacterValue.equals(Object)",
    "int ConvertedCharacterValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedCharacterValue convertedCharacterValue =
        new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        convertedCharacterValue,
        new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedCharacterValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedCharacterValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedCharacterValue.equals(Object)",
    "int ConvertedCharacterValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedCharacterValue convertedCharacterValue =
        new ConvertedCharacterValue(
            new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        convertedCharacterValue,
        new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedCharacterValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedCharacterValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedCharacterValue.equals(Object)",
    "int ConvertedCharacterValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link ConvertedCharacterValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedCharacterValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ConvertedCharacterValue.equals(Object)",
    "int ConvertedCharacterValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedCharacterValue");
  }
}

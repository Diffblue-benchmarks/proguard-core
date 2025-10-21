package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CompositeFloatValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeFloatValue#CompositeFloatValue(FloatValue, byte, FloatValue)}
   *   <li>{@link CompositeFloatValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompositeFloatValue.<init>(FloatValue, byte, FloatValue)",
    "java.lang.String CompositeFloatValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(fAf)",
        (new CompositeFloatValue(
                BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE))
            .toString());
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}, and {@link CompositeFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeFloatValue#equals(Object)}
   *   <li>{@link CompositeFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);
    CompositeFloatValue compositeFloatValue2 =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(compositeFloatValue, compositeFloatValue2);
    int expectedHashCodeResult = compositeFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeFloatValue2.hashCode());
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}, and {@link CompositeFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeFloatValue#equals(Object)}
   *   <li>{@link CompositeFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(compositeFloatValue, compositeFloatValue);
    int expectedHashCodeResult = compositeFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeFloatValue.hashCode());
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            ParticularValueFactory.FLOAT_VALUE_0, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertNotEquals(
        compositeFloatValue,
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            new CompositeFloatValue(
                BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE),
            (byte) 'A',
            BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertNotEquals(
        compositeFloatValue,
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 1, BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertNotEquals(
        compositeFloatValue,
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', ParticularValueFactory.FLOAT_VALUE_0);

    // Act and Assert
    assertNotEquals(
        compositeFloatValue,
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE,
            (byte) 'A',
            new CompositeFloatValue(
                BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Act and Assert
    assertNotEquals(
        compositeFloatValue,
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE),
        null);
  }

  /**
   * Test {@link CompositeFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CompositeFloatValue.equals(Object)",
    "int CompositeFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE),
        "Different type to CompositeFloatValue");
  }
}

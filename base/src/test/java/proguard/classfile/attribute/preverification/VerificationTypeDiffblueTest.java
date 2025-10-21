package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VerificationTypeDiffblueTest {
  /**
   * Test {@link VerificationType#equals(Object)}, and {@link VerificationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VerificationType#equals(Object)}
   *   <li>{@link VerificationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VerificationType.equals(Object)", "int VerificationType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoubleType doubleType = VerificationTypeFactory.DOUBLE_TYPE;
    DoubleType doubleType2 = VerificationTypeFactory.DOUBLE_TYPE;

    // Act and Assert
    assertEquals(doubleType, doubleType2);
    int expectedHashCodeResult = doubleType.hashCode();
    assertEquals(expectedHashCodeResult, doubleType2.hashCode());
  }

  /**
   * Test {@link VerificationType#equals(Object)}, and {@link VerificationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VerificationType#equals(Object)}
   *   <li>{@link VerificationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VerificationType.equals(Object)", "int VerificationType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleType doubleType = VerificationTypeFactory.DOUBLE_TYPE;

    // Act and Assert
    assertEquals(doubleType, doubleType);
    int expectedHashCodeResult = doubleType.hashCode();
    assertEquals(expectedHashCodeResult, doubleType.hashCode());
  }

  /**
   * Test {@link VerificationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VerificationType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VerificationType.equals(Object)", "int VerificationType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.DOUBLE_TYPE, 1);
  }

  /**
   * Test {@link VerificationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VerificationType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VerificationType.equals(Object)", "int VerificationType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.DOUBLE_TYPE, null);
  }

  /**
   * Test {@link VerificationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VerificationType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VerificationType.equals(Object)", "int VerificationType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.DOUBLE_TYPE, "Different type to VerificationType");
  }
}

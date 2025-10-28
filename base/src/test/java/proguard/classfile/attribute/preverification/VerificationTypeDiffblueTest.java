package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class VerificationTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VerificationType#equals(Object)}
   *   <li>{@link VerificationType#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link VerificationType#equals(Object)}
   *   <li>{@link VerificationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleType doubleType = VerificationTypeFactory.DOUBLE_TYPE;

    // Act and Assert
    assertEquals(doubleType, doubleType);
    int expectedHashCodeResult = doubleType.hashCode();
    assertEquals(expectedHashCodeResult, doubleType.hashCode());
  }

  /**
   * Method under test: {@link VerificationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.DOUBLE_TYPE, 1);
  }

  /**
   * Method under test: {@link VerificationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.DOUBLE_TYPE, null);
  }

  /**
   * Method under test: {@link VerificationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.DOUBLE_TYPE, "Different type to VerificationType");
  }
}

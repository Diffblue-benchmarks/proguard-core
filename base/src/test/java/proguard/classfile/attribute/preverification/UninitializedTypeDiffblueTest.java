package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class UninitializedTypeDiffblueTest {
  /**
   * Method under test: {@link UninitializedType#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(8, VerificationTypeFactory.createUninitializedType(1).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UninitializedType#equals(Object)}
   *   <li>{@link UninitializedType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult = VerificationTypeFactory.createUninitializedType(1);
    UninitializedType createUninitializedTypeResult2 = VerificationTypeFactory.createUninitializedType(1);

    // Act and Assert
    assertEquals(createUninitializedTypeResult, createUninitializedTypeResult2);
    int expectedHashCodeResult = createUninitializedTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createUninitializedTypeResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UninitializedType#equals(Object)}
   *   <li>{@link UninitializedType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult = VerificationTypeFactory.createUninitializedType(1);

    // Act and Assert
    assertEquals(createUninitializedTypeResult, createUninitializedTypeResult);
    int expectedHashCodeResult = createUninitializedTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createUninitializedTypeResult.hashCode());
  }

  /**
   * Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult = VerificationTypeFactory.createUninitializedType(0);

    // Act and Assert
    assertNotEquals(createUninitializedTypeResult, VerificationTypeFactory.createUninitializedType(1));
  }

  /**
   * Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createUninitializedType(1), null);
  }

  /**
   * Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createUninitializedType(1), "Different type to UninitializedType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UninitializedType#UninitializedType()}
   *   <li>{@link UninitializedType#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UninitializedType actualUninitializedType = new UninitializedType();

    // Assert
    assertEquals("u:0", actualUninitializedType.toString());
    assertNull(actualUninitializedType.getProcessingInfo());
    assertEquals(0, actualUninitializedType.getProcessingFlags());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UninitializedType#UninitializedType(int)}
   *   <li>{@link UninitializedType#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    UninitializedType actualUninitializedType = new UninitializedType(1);

    // Assert
    assertEquals("u:1", actualUninitializedType.toString());
    assertNull(actualUninitializedType.getProcessingInfo());
    assertEquals(0, actualUninitializedType.getProcessingFlags());
  }
}

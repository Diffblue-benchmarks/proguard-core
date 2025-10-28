package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ObjectTypeDiffblueTest {
  /**
   * Method under test: {@link ObjectType#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(7, VerificationTypeFactory.createObjectType(1).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ObjectType#equals(Object)}
   *   <li>{@link ObjectType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);
    ObjectType createObjectTypeResult2 = VerificationTypeFactory.createObjectType(1);

    // Act and Assert
    assertEquals(createObjectTypeResult, createObjectTypeResult2);
    int expectedHashCodeResult = createObjectTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createObjectTypeResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ObjectType#equals(Object)}
   *   <li>{@link ObjectType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);

    // Act and Assert
    assertEquals(createObjectTypeResult, createObjectTypeResult);
    int expectedHashCodeResult = createObjectTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createObjectTypeResult.hashCode());
  }

  /**
   * Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(0);

    // Act and Assert
    assertNotEquals(createObjectTypeResult, VerificationTypeFactory.createObjectType(1));
  }

  /**
   * Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createObjectType(1), null);
  }

  /**
   * Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createObjectType(1), "Different type to ObjectType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ObjectType#ObjectType()}
   *   <li>{@link ObjectType#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ObjectType actualObjectType = new ObjectType();

    // Assert
    assertEquals("a:0", actualObjectType.toString());
    assertNull(actualObjectType.getProcessingInfo());
    assertEquals(0, actualObjectType.getProcessingFlags());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ObjectType#ObjectType(int)}
   *   <li>{@link ObjectType#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    ObjectType actualObjectType = new ObjectType(1);

    // Assert
    assertEquals("a:1", actualObjectType.toString());
    assertNull(actualObjectType.getProcessingInfo());
    assertEquals(0, actualObjectType.getProcessingFlags());
  }
}

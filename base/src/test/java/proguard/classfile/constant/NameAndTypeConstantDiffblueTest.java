package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class NameAndTypeConstantDiffblueTest {
  /**
   * Method under test: {@link NameAndTypeConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.NAME_AND_TYPE, (new NameAndTypeConstant(1, 1)).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NameAndTypeConstant#equals(Object)}
   *   <li>{@link NameAndTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);
    NameAndTypeConstant nameAndTypeConstant2 = new NameAndTypeConstant(1, 1);

    // Act and Assert
    assertEquals(nameAndTypeConstant, nameAndTypeConstant2);
    int expectedHashCodeResult = nameAndTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, nameAndTypeConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NameAndTypeConstant#equals(Object)}
   *   <li>{@link NameAndTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);

    // Act and Assert
    assertEquals(nameAndTypeConstant, nameAndTypeConstant);
    int expectedHashCodeResult = nameAndTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, nameAndTypeConstant.hashCode());
  }

  /**
   * Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(0, 1);

    // Act and Assert
    assertNotEquals(nameAndTypeConstant, new NameAndTypeConstant(1, 1));
  }

  /**
   * Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 0);

    // Act and Assert
    assertNotEquals(nameAndTypeConstant, new NameAndTypeConstant(1, 1));
  }

  /**
   * Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NameAndTypeConstant(1, 1), null);
  }

  /**
   * Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NameAndTypeConstant(1, 1), "Different type to NameAndTypeConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NameAndTypeConstant#NameAndTypeConstant()}
   *   <li>{@link NameAndTypeConstant#setDescriptorIndex(int)}
   *   <li>{@link NameAndTypeConstant#setNameIndex(int)}
   *   <li>{@link NameAndTypeConstant#toString()}
   *   <li>{@link NameAndTypeConstant#getDescriptorIndex()}
   *   <li>{@link NameAndTypeConstant#getNameIndex()}
   *   <li>{@link NameAndTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NameAndTypeConstant actualNameAndTypeConstant = new NameAndTypeConstant();
    actualNameAndTypeConstant.setDescriptorIndex(1);
    actualNameAndTypeConstant.setNameIndex(1);
    String actualToStringResult = actualNameAndTypeConstant.toString();
    int actualDescriptorIndex = actualNameAndTypeConstant.getDescriptorIndex();
    int actualNameIndex = actualNameAndTypeConstant.getNameIndex();
    boolean actualIsCategory2Result = actualNameAndTypeConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("NameAndType(1,1)", actualToStringResult);
    assertEquals(0, actualNameAndTypeConstant.getProcessingFlags());
    assertEquals(1, actualDescriptorIndex);
    assertEquals(1, actualNameIndex);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NameAndTypeConstant#NameAndTypeConstant(int, int)}
   *   <li>{@link NameAndTypeConstant#setDescriptorIndex(int)}
   *   <li>{@link NameAndTypeConstant#setNameIndex(int)}
   *   <li>{@link NameAndTypeConstant#toString()}
   *   <li>{@link NameAndTypeConstant#getDescriptorIndex()}
   *   <li>{@link NameAndTypeConstant#getNameIndex()}
   *   <li>{@link NameAndTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    NameAndTypeConstant actualNameAndTypeConstant = new NameAndTypeConstant(1, 1);
    actualNameAndTypeConstant.setDescriptorIndex(1);
    actualNameAndTypeConstant.setNameIndex(1);
    String actualToStringResult = actualNameAndTypeConstant.toString();
    int actualDescriptorIndex = actualNameAndTypeConstant.getDescriptorIndex();
    int actualNameIndex = actualNameAndTypeConstant.getNameIndex();
    boolean actualIsCategory2Result = actualNameAndTypeConstant.isCategory2();

    // Assert that nothing has changed
    assertEquals("NameAndType(1,1)", actualToStringResult);
    assertEquals(0, actualNameAndTypeConstant.getProcessingFlags());
    assertEquals(1, actualDescriptorIndex);
    assertEquals(1, actualNameIndex);
    assertFalse(actualIsCategory2Result);
  }
}

package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;

public class RefConstantDiffblueTest {
  /**
   * Method under test: {@link RefConstant#getClassIndex()}
   */
  @Test
  public void testGetClassIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldrefConstant()).getClassIndex());
  }

  /**
   * Method under test: {@link RefConstant#getNameAndTypeIndex()}
   */
  @Test
  public void testGetNameAndTypeIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldrefConstant()).getNameAndTypeIndex());
  }

  /**
   * Method under test: {@link RefConstant#setNameAndTypeIndex(int)}
   */
  @Test
  public void testSetNameAndTypeIndex() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();

    // Act
    fieldrefConstant.setNameAndTypeIndex(1);

    // Assert
    assertEquals(1, fieldrefConstant.getNameAndTypeIndex());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RefConstant#equals(Object)}
   *   <li>{@link RefConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    FieldrefConstant fieldrefConstant2 = new FieldrefConstant();

    // Act and Assert
    assertEquals(fieldrefConstant, fieldrefConstant2);
    int expectedHashCodeResult = fieldrefConstant.hashCode();
    assertEquals(expectedHashCodeResult, fieldrefConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RefConstant#equals(Object)}
   *   <li>{@link RefConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();

    // Act and Assert
    assertEquals(fieldrefConstant, fieldrefConstant);
    int expectedHashCodeResult = fieldrefConstant.hashCode();
    assertEquals(expectedHashCodeResult, fieldrefConstant.hashCode());
  }

  /**
   * Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    FieldrefConstant fieldrefConstant = new FieldrefConstant(1, 1, referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Act and Assert
    assertNotEquals(fieldrefConstant, new FieldrefConstant());
  }

  /**
   * Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    fieldrefConstant.setNameAndTypeIndex(1);

    // Act and Assert
    assertNotEquals(fieldrefConstant, new FieldrefConstant());
  }

  /**
   * Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldrefConstant(), null);
  }

  /**
   * Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldrefConstant(), "Different type to RefConstant");
  }

  /**
   * Method under test: {@link RefConstant#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Fieldref(0,0)", (new FieldrefConstant()).toString());
  }
}

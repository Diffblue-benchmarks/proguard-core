package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;

public class RefConstantDiffblueTest {
  /**
   * Test {@link RefConstant#getClassIndex()}.
   *
   * <p>Method under test: {@link RefConstant#getClassIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RefConstant.getClassIndex()"})
  public void testGetClassIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldrefConstant()).getClassIndex());
  }

  /**
   * Test {@link RefConstant#getNameAndTypeIndex()}.
   *
   * <p>Method under test: {@link RefConstant#getNameAndTypeIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RefConstant.getNameAndTypeIndex()"})
  public void testGetNameAndTypeIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldrefConstant()).getNameAndTypeIndex());
  }

  /**
   * Test {@link RefConstant#setNameAndTypeIndex(int)}.
   *
   * <p>Method under test: {@link RefConstant#setNameAndTypeIndex(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RefConstant.setNameAndTypeIndex(int)"})
  public void testSetNameAndTypeIndex() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();

    // Act
    fieldrefConstant.setNameAndTypeIndex(1);

    // Assert
    assertEquals(1, fieldrefConstant.getNameAndTypeIndex());
  }

  /**
   * Test {@link RefConstant#equals(Object)}, and {@link RefConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RefConstant#equals(Object)}
   *   <li>{@link RefConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RefConstant.equals(Object)", "int RefConstant.hashCode()"})
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
   * Test {@link RefConstant#equals(Object)}, and {@link RefConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RefConstant#equals(Object)}
   *   <li>{@link RefConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RefConstant.equals(Object)", "int RefConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();

    // Act and Assert
    assertEquals(fieldrefConstant, fieldrefConstant);
    int expectedHashCodeResult = fieldrefConstant.hashCode();
    assertEquals(expectedHashCodeResult, fieldrefConstant.hashCode());
  }

  /**
   * Test {@link RefConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RefConstant.equals(Object)", "int RefConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    FieldrefConstant fieldrefConstant =
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Act and Assert
    assertNotEquals(fieldrefConstant, new FieldrefConstant());
  }

  /**
   * Test {@link RefConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RefConstant.equals(Object)", "int RefConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    fieldrefConstant.setNameAndTypeIndex(1);

    // Act and Assert
    assertNotEquals(fieldrefConstant, new FieldrefConstant());
  }

  /**
   * Test {@link RefConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RefConstant.equals(Object)", "int RefConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldrefConstant(), null);
  }

  /**
   * Test {@link RefConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RefConstant.equals(Object)", "int RefConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldrefConstant(), "Different type to RefConstant");
  }

  /**
   * Test {@link RefConstant#toString()}.
   *
   * <p>Method under test: {@link RefConstant#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RefConstant.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Fieldref(0,0)", (new FieldrefConstant()).toString());
  }
}

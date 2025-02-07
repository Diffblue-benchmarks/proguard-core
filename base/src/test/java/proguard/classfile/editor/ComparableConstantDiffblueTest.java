package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class ComparableConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComparableConstant#ComparableConstant(Clazz, int, Constant)}
   *   <li>{@link ComparableConstant#getConstant()}
   *   <li>{@link ComparableConstant#getIndex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ComparableConstant.<init>(proguard.classfile.Clazz, int, proguard.classfile.constant.Constant)",
    "proguard.classfile.constant.Constant proguard.classfile.editor.ComparableConstant.getConstant()",
    "int proguard.classfile.editor.ComparableConstant.getIndex()"
  })
  void testGettersAndSetters() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    ClassConstant constant = new ClassConstant();

    // Act
    ComparableConstant actualComparableConstant = new ComparableConstant(clazz, 1, constant);
    Constant actualConstant = actualComparableConstant.getConstant();

    // Assert
    assertEquals(1, actualComparableConstant.getIndex());
    assertSame(constant, actualConstant);
  }

  /**
   * Test {@link ComparableConstant#equals(Object)}, and {@link ComparableConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComparableConstant#equals(Object)}
   *   <li>{@link ComparableConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.ComparableConstant.equals(java.lang.Object)",
    "int proguard.classfile.editor.ComparableConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Clazz clazz = mock(Clazz.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    ComparableConstant comparableConstant = new ComparableConstant(clazz, 1, new ClassConstant());
    LibraryClass clazz2 = new LibraryClass();
    ComparableConstant comparableConstant2 = new ComparableConstant(clazz2, 1, new ClassConstant());

    // Act and Assert
    assertEquals(comparableConstant, comparableConstant2);
    int expectedHashCodeResult = comparableConstant.hashCode();
    assertEquals(expectedHashCodeResult, comparableConstant2.hashCode());
  }

  /**
   * Test {@link ComparableConstant#equals(Object)}, and {@link ComparableConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComparableConstant#equals(Object)}
   *   <li>{@link ComparableConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.ComparableConstant.equals(java.lang.Object)",
    "int proguard.classfile.editor.ComparableConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    ComparableConstant comparableConstant = new ComparableConstant(clazz, 1, new ClassConstant());

    // Act and Assert
    assertEquals(comparableConstant, comparableConstant);
    int expectedHashCodeResult = comparableConstant.hashCode();
    assertEquals(expectedHashCodeResult, comparableConstant.hashCode());
  }

  /**
   * Test {@link ComparableConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparableConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.ComparableConstant.equals(java.lang.Object)",
    "int proguard.classfile.editor.ComparableConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Clazz clazz = mock(Clazz.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    ComparableConstant comparableConstant =
        new ComparableConstant(clazz, 1, mock(ClassConstant.class));
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(comparableConstant, new ComparableConstant(clazz2, 1, new ClassConstant()));
  }

  /**
   * Test {@link ComparableConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparableConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.ComparableConstant.equals(java.lang.Object)",
    "int proguard.classfile.editor.ComparableConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNotEquals(new ComparableConstant(clazz, 1, new ClassConstant()), null);
  }

  /**
   * Test {@link ComparableConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparableConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.ComparableConstant.equals(java.lang.Object)",
    "int proguard.classfile.editor.ComparableConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new ComparableConstant(clazz, 1, new ClassConstant()),
        "Different type to ComparableConstant");
  }
}

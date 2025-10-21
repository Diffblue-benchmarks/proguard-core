package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;

public class ComparableConstantDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ComparableConstant.<init>(Clazz, int, Constant)",
    "Constant ComparableConstant.getConstant()",
    "int ComparableConstant.getIndex()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ComparableConstant.equals(Object)",
    "int ComparableConstant.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ComparableConstant.equals(Object)",
    "int ComparableConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    ComparableConstant comparableConstant = new ComparableConstant(clazz, 1, new DoubleConstant());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ComparableConstant.equals(Object)",
    "int ComparableConstant.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ComparableConstant.equals(Object)",
    "int ComparableConstant.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new ComparableConstant(clazz, 1, new ClassConstant()),
        "Different type to ComparableConstant");
  }
}

package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.testutils.cpa.NamedClass;

public class NestHostFinderDiffblueTest {
  /**
   * Test {@link NestHostFinder#inSameNest(Clazz, Clazz)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NestHostFinder#inSameNest(Clazz, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NestHostFinder.inSameNest(Clazz, Clazz)"})
  public void testInSameNest_thenReturnFalse() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();
    LibraryClass class1 = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertFalse(nestHostFinder.inSameNest(class1, new LibraryClass()));
  }

  /**
   * Test {@link NestHostFinder#inSameNest(Clazz, Clazz)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NestHostFinder#inSameNest(Clazz, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NestHostFinder.inSameNest(Clazz, Clazz)"})
  public void testInSameNest_thenReturnTrue() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();
    LibraryClass class1 = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertTrue(
        nestHostFinder.inSameNest(
            class1, new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link NestHostFinder#inSameNest(Clazz, Clazz)}.
   *
   * <ul>
   *   <li>When {@link NamedClass#NamedClass(String)} with {@code Member Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NestHostFinder#inSameNest(Clazz, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NestHostFinder.inSameNest(Clazz, Clazz)"})
  public void testInSameNest_whenNamedClassWithMemberName_thenReturnFalse() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();
    NamedClass class1 = new NamedClass("Member Name");

    // Act and Assert
    assertFalse(nestHostFinder.inSameNest(class1, new LibraryClass()));
  }

  /**
   * Test {@link NestHostFinder#findNestHostClassName(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NestHostFinder#findNestHostClassName(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String NestHostFinder.findNestHostClassName(Clazz)"})
  public void testFindNestHostClassName_whenLibraryClass_thenReturnNull() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();

    // Act and Assert
    assertNull(nestHostFinder.findNestHostClassName(new LibraryClass()));
  }

  /**
   * Test {@link NestHostFinder#findNestHostClassName(Clazz)}.
   *
   * <ul>
   *   <li>When {@link NamedClass#NamedClass(String)} with {@code Member Name}.
   *   <li>Then return {@code Member Name}.
   * </ul>
   *
   * <p>Method under test: {@link NestHostFinder#findNestHostClassName(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String NestHostFinder.findNestHostClassName(Clazz)"})
  public void testFindNestHostClassName_whenNamedClassWithMemberName_thenReturnMemberName() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();

    // Act and Assert
    assertEquals(
        "Member Name", nestHostFinder.findNestHostClassName(new NamedClass("Member Name")));
  }
}

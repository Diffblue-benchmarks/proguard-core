package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.NestHostAttribute;
import proguard.testutils.cpa.NamedClass;

class NestHostFinderDiffblueTest {
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
  @DisplayName("Test inSameNest(Clazz, Clazz); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.NestHostFinder.inSameNest(proguard.classfile.Clazz, proguard.classfile.Clazz)"
  })
  void testInSameNest_thenReturnFalse() {
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
  @DisplayName("Test inSameNest(Clazz, Clazz); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.NestHostFinder.inSameNest(proguard.classfile.Clazz, proguard.classfile.Clazz)"
  })
  void testInSameNest_thenReturnTrue() {
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
  @DisplayName(
      "Test inSameNest(Clazz, Clazz); when NamedClass(String) with 'Member Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.NestHostFinder.inSameNest(proguard.classfile.Clazz, proguard.classfile.Clazz)"
  })
  void testInSameNest_whenNamedClassWithMemberName_thenReturnFalse() {
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
  @DisplayName("Test findNestHostClassName(Clazz); when LibraryClass(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.NestHostFinder.findNestHostClassName(proguard.classfile.Clazz)"
  })
  void testFindNestHostClassName_whenLibraryClass_thenReturnNull() {
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
  @DisplayName(
      "Test findNestHostClassName(Clazz); when NamedClass(String) with 'Member Name'; then return 'Member Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.NestHostFinder.findNestHostClassName(proguard.classfile.Clazz)"
  })
  void testFindNestHostClassName_whenNamedClassWithMemberName_thenReturnMemberName() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();

    // Act and Assert
    assertEquals(
        "Member Name", nestHostFinder.findNestHostClassName(new NamedClass("Member Name")));
  }

  /**
   * Test {@link NestHostFinder#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link NestHostFinder#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); given 'Class Name'; then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.NestHostFinder.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_givenClassName_thenCallsGetClassName() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    nestHostFinder.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(clazz).getClassName(eq(1));
  }
}

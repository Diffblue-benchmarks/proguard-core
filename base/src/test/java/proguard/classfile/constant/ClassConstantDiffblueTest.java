package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantTagFilter;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.visitor.ClassVisitor;

class ClassConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Class(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassConstant#ClassConstant()}
   *   <li>{@link ClassConstant#toString()}
   *   <li>{@link ClassConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'Class(0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.ClassConstant.<init>()",
    "void proguard.classfile.constant.ClassConstant.<init>(int, proguard.classfile.Clazz)",
    "boolean proguard.classfile.constant.ClassConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.ClassConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsClass0() {
    // Arrange and Act
    ClassConstant actualClassConstant = new ClassConstant();
    String actualToStringResult = actualClassConstant.toString();
    boolean actualIsCategory2Result = actualClassConstant.isCategory2();

    // Assert
    assertEquals("Class(0)", actualToStringResult);
    assertNull(actualClassConstant.getProcessingInfo());
    assertEquals(0, actualClassConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Class(1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassConstant#ClassConstant(int, Clazz)}
   *   <li>{@link ClassConstant#toString()}
   *   <li>{@link ClassConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'Class(1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.ClassConstant.<init>()",
    "void proguard.classfile.constant.ClassConstant.<init>(int, proguard.classfile.Clazz)",
    "boolean proguard.classfile.constant.ClassConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.ClassConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsClass1() {
    // Arrange and Act
    ClassConstant actualClassConstant = new ClassConstant(1, new LibraryClass());
    String actualToStringResult = actualClassConstant.toString();
    boolean actualIsCategory2Result = actualClassConstant.isCategory2();

    // Assert
    assertEquals("Class(1)", actualToStringResult);
    assertNull(actualClassConstant.getProcessingInfo());
    assertEquals(0, actualClassConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link ClassConstant#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstant#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.ClassConstant.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = classConstant.getName(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualName);
  }

  /**
   * Test {@link ClassConstant#getTag()}.
   *
   * <p>Method under test: {@link ClassConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.ClassConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(7, (new ClassConstant()).getTag());
  }

  /**
   * Test {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <p>Method under test: {@link ClassConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.ClassConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    LibraryClass clazz = new LibraryClass();

    // Act
    classConstant.accept(clazz, new BootstrapMethodHandleTraveler(new ConstantLookupVisitor()));

    // Assert that nothing has changed
    assertNull(classConstant.getProcessingInfo());
  }

  /**
   * Test {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <p>Method under test: {@link ClassConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.ClassConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    LibraryClass clazz = new LibraryClass();

    // Act
    classConstant.accept(clazz, new ConstantTagFilter(1, new ConstantLookupVisitor()));

    // Assert that nothing has changed
    assertNull(classConstant.getProcessingInfo());
  }

  /**
   * Test {@link ClassConstant#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstant#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.ClassConstant.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    classConstant.referencedClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    classConstant.referencedClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassConstant#equals(Object)}, and {@link ClassConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassConstant#equals(Object)}
   *   <li>{@link ClassConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ClassConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ClassConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();

    // Act and Assert
    assertEquals(classConstant, classConstant2);
    int expectedHashCodeResult = classConstant.hashCode();
    assertEquals(expectedHashCodeResult, classConstant2.hashCode());
  }

  /**
   * Test {@link ClassConstant#equals(Object)}, and {@link ClassConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassConstant#equals(Object)}
   *   <li>{@link ClassConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ClassConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ClassConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(classConstant, classConstant);
    int expectedHashCodeResult = classConstant.hashCode();
    assertEquals(expectedHashCodeResult, classConstant.hashCode());
  }

  /**
   * Test {@link ClassConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ClassConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ClassConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClassConstant classConstant = new ClassConstant(1, new LibraryClass());

    // Act and Assert
    assertNotEquals(classConstant, new ClassConstant());
  }

  /**
   * Test {@link ClassConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ClassConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ClassConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassConstant(), null);
  }

  /**
   * Test {@link ClassConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ClassConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ClassConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassConstant(), "Different type to ClassConstant");
  }
}

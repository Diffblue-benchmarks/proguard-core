package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;
import proguard.classfile.visitor.MethodImplementationFilter;

class LibraryFieldDiffblueTest {
  /**
   * Test {@link LibraryField#LibraryField()}.
   *
   * <ul>
   *   <li>Then return AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link LibraryField#LibraryField()}
   */
  @Test
  @DisplayName("Test new LibraryField(); then return AccessFlags is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryField.<init>()",
    "void proguard.classfile.LibraryField.<init>(int, java.lang.String, java.lang.String)"
  })
  void testNewLibraryField_thenReturnAccessFlagsIsZero() {
    // Arrange and Act
    LibraryField actualLibraryField = new LibraryField();

    // Assert
    assertNull(actualLibraryField.getProcessingInfo());
    assertEquals(0, actualLibraryField.getAccessFlags());
    assertEquals(0, actualLibraryField.getProcessingFlags());
  }

  /**
   * Test {@link LibraryField#LibraryField(int, String, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link LibraryField#LibraryField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LibraryField(int, String, String); when one; then return AccessFlags is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryField.<init>()",
    "void proguard.classfile.LibraryField.<init>(int, java.lang.String, java.lang.String)"
  })
  void testNewLibraryField_whenOne_thenReturnAccessFlagsIsOne() {
    // Arrange and Act
    LibraryField actualLibraryField = new LibraryField(1, "Name", "Descriptor");

    // Assert
    assertNull(actualLibraryField.getProcessingInfo());
    assertEquals(0, actualLibraryField.getProcessingFlags());
    assertEquals(1, actualLibraryField.getAccessFlags());
  }

  /**
   * Test {@link LibraryField#accept(LibraryClass, MemberVisitor)} with {@code libraryClass}, {@code
   * memberVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryField#accept(LibraryClass, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(LibraryClass, MemberVisitor) with 'libraryClass', 'memberVisitor'; then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryField.accept(proguard.classfile.LibraryClass, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAcceptWithLibraryClassMemberVisitor_thenCallsVisitLibraryField() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");
    LibraryClass libraryClass = new LibraryClass();
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());

    // Act
    libraryField.accept(libraryClass, memberVisitor);

    // Assert
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link LibraryField#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryField#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryField.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");
    libraryField.referencedClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryField.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}

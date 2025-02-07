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

class LibraryMethodDiffblueTest {
  /**
   * Test {@link LibraryMethod#LibraryMethod()}.
   *
   * <ul>
   *   <li>Then return AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link LibraryMethod#LibraryMethod()}
   */
  @Test
  @DisplayName("Test new LibraryMethod(); then return AccessFlags is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryMethod.<init>()",
    "void proguard.classfile.LibraryMethod.<init>(int, java.lang.String, java.lang.String)"
  })
  void testNewLibraryMethod_thenReturnAccessFlagsIsZero() {
    // Arrange and Act
    LibraryMethod actualLibraryMethod = new LibraryMethod();

    // Assert
    assertNull(actualLibraryMethod.getProcessingInfo());
    assertEquals(0, actualLibraryMethod.getAccessFlags());
    assertEquals(0, actualLibraryMethod.getProcessingFlags());
  }

  /**
   * Test {@link LibraryMethod#LibraryMethod(int, String, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link LibraryMethod#LibraryMethod(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LibraryMethod(int, String, String); when one; then return AccessFlags is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryMethod.<init>()",
    "void proguard.classfile.LibraryMethod.<init>(int, java.lang.String, java.lang.String)"
  })
  void testNewLibraryMethod_whenOne_thenReturnAccessFlagsIsOne() {
    // Arrange and Act
    LibraryMethod actualLibraryMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Assert
    assertNull(actualLibraryMethod.getProcessingInfo());
    assertEquals(0, actualLibraryMethod.getProcessingFlags());
    assertEquals(1, actualLibraryMethod.getAccessFlags());
  }

  /**
   * Test {@link LibraryMethod#accept(LibraryClass, MemberVisitor)} with {@code libraryClass},
   * {@code memberVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryMethod#accept(LibraryClass, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(LibraryClass, MemberVisitor) with 'libraryClass', 'memberVisitor'; then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryMethod.accept(proguard.classfile.LibraryClass, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAcceptWithLibraryClassMemberVisitor_thenCallsVisitLibraryMethod() {
    // Arrange
    LibraryMethod libraryMethod = new LibraryMethod(1, "Name", "Descriptor");
    LibraryClass libraryClass = new LibraryClass();
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());

    // Act
    libraryMethod.accept(libraryClass, memberVisitor);

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link LibraryMethod#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryMethod#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryMethod.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    LibraryMethod libraryMethod = new LibraryMethod(1, "Name", "Descriptor");
    libraryMethod.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryMethod.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}

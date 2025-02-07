package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;
import proguard.classfile.visitor.MethodImplementationFilter;

class ProgramMethodDiffblueTest {
  /**
   * Test {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[])}.
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[])}
   */
  @Test
  @DisplayName("Test new ProgramMethod(int, int, int, Clazz[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramMethod.<init>(int, int, int, proguard.classfile.Clazz[])"
  })
  void testNewProgramMethod() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act
    ProgramMethod actualProgramMethod = new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass});

    // Assert
    Clazz[] clazzArray = actualProgramMethod.referencedClasses;
    Clazz clazz = clazzArray[0];
    assertTrue(clazz instanceof LibraryClass);
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
    assertEquals(0, actualProgramMethod.attributes.length);
    assertEquals(0, actualProgramMethod.u2attributesCount);
    assertEquals(1, actualProgramMethod.getAccessFlags());
    assertEquals(1, clazzArray.length);
    assertEquals(1, actualProgramMethod.u2descriptorIndex);
    assertEquals(1, actualProgramMethod.u2nameIndex);
    assertSame(libraryClass, clazz);
  }

  /**
   * Test {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[], int, Object)}.
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[], int, Object)}
   */
  @Test
  @DisplayName("Test new ProgramMethod(int, int, int, Clazz[], int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramMethod.<init>(int, int, int, proguard.classfile.Clazz[], int, java.lang.Object)"
  })
  void testNewProgramMethod2() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act
    ProgramMethod actualProgramMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass}, 1, "Processing Info");

    // Assert
    Clazz[] clazzArray = actualProgramMethod.referencedClasses;
    Clazz clazz = clazzArray[0];
    assertTrue(clazz instanceof LibraryClass);
    assertEquals("Processing Info", actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.attributes.length);
    assertEquals(0, actualProgramMethod.u2attributesCount);
    assertEquals(1, actualProgramMethod.getAccessFlags());
    assertEquals(1, actualProgramMethod.getProcessingFlags());
    assertEquals(1, clazzArray.length);
    assertEquals(1, actualProgramMethod.u2descriptorIndex);
    assertEquals(1, actualProgramMethod.u2nameIndex);
    assertSame(libraryClass, clazz);
  }

  /**
   * Test {@link ProgramMethod#ProgramMethod()}.
   *
   * <ul>
   *   <li>Then return AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod()}
   */
  @Test
  @DisplayName("Test new ProgramMethod(); then return AccessFlags is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramMethod.<init>()",
    "void proguard.classfile.ProgramMethod.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz[])",
    "void proguard.classfile.ProgramMethod.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz[], int, java.lang.Object)"
  })
  void testNewProgramMethod_thenReturnAccessFlagsIsZero() {
    // Arrange and Act
    ProgramMethod actualProgramMethod = new ProgramMethod();

    // Assert
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getAccessFlags());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
  }

  /**
   * Test {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[], Clazz[])}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[],
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test new ProgramMethod(int, int, int, int, Attribute[], Clazz[]); when one; then return ProcessingInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramMethod.<init>()",
    "void proguard.classfile.ProgramMethod.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz[])",
    "void proguard.classfile.ProgramMethod.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz[], int, java.lang.Object)"
  })
  void testNewProgramMethod_whenOne_thenReturnProcessingInfoIsNull() {
    // Arrange and Act
    ProgramMethod actualProgramMethod =
        new ProgramMethod(
            1,
            1,
            1,
            3,
            new Attribute[] {new BootstrapMethodsAttribute()},
            new Clazz[] {new LibraryClass()});

    // Assert
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
    assertEquals(1, actualProgramMethod.getAccessFlags());
  }

  /**
   * Test {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[], Clazz[], int,
   * Object)}.
   *
   * <ul>
   *   <li>When {@code Processing Info}.
   *   <li>Then return {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[],
   * Clazz[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test new ProgramMethod(int, int, int, int, Attribute[], Clazz[], int, Object); when 'Processing Info'; then return 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramMethod.<init>()",
    "void proguard.classfile.ProgramMethod.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz[])",
    "void proguard.classfile.ProgramMethod.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz[], int, java.lang.Object)"
  })
  void testNewProgramMethod_whenProcessingInfo_thenReturnProcessingInfo() {
    // Arrange and Act
    ProgramMethod actualProgramMethod =
        new ProgramMethod(
            1,
            1,
            1,
            3,
            new Attribute[] {new BootstrapMethodsAttribute()},
            new Clazz[] {new LibraryClass()},
            1,
            "Processing Info");

    // Assert
    assertEquals("Processing Info", actualProgramMethod.getProcessingInfo());
    assertEquals(1, actualProgramMethod.getAccessFlags());
    assertEquals(1, actualProgramMethod.getProcessingFlags());
  }

  /**
   * Test {@link ProgramMethod#accept(ProgramClass, MemberVisitor)} with {@code programClass},
   * {@code memberVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   *       ProgramMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMethod#accept(ProgramClass, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ProgramClass, MemberVisitor) with 'programClass', 'memberVisitor'; then calls visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramMethod.accept(proguard.classfile.ProgramClass, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAcceptWithProgramClassMemberVisitor_thenCallsVisitProgramMethod() {
    // Arrange
    ProgramMethod programMethod = new ProgramMethod();
    ProgramClass programClass = new ProgramClass();
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramMethod(Mockito.<ProgramClass>any(), Mockito.<ProgramMethod>any());

    // Act
    programMethod.accept(programClass, memberVisitor);

    // Assert
    verify(memberVisitor).visitProgramMethod(isA(ProgramClass.class), isA(ProgramMethod.class));
  }

  /**
   * Test {@link ProgramMethod#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMethod#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramMethod.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    ProgramMethod programMethod = new ProgramMethod();
    programMethod.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    programMethod.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}

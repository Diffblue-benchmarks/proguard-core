package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

class ProgramFieldDiffblueTest {
  /**
   * Test {@link ProgramField#ProgramField(int, int, int, Clazz)}.
   *
   * <p>Method under test: {@link ProgramField#ProgramField(int, int, int, Clazz)}
   */
  @Test
  @DisplayName("Test new ProgramField(int, int, int, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramField.<init>(int, int, int, proguard.classfile.Clazz)"
  })
  void testNewProgramField() {
    // Arrange and Act
    ProgramField actualProgramField = new ProgramField(1, 1, 1, new LibraryClass());

    // Assert
    assertTrue(actualProgramField.referencedClass instanceof LibraryClass);
    assertNull(actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.getProcessingFlags());
    assertEquals(0, actualProgramField.attributes.length);
    assertEquals(0, actualProgramField.u2attributesCount);
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.u2descriptorIndex);
    assertEquals(1, actualProgramField.u2nameIndex);
  }

  /**
   * Test {@link ProgramField#ProgramField(int, int, int, Clazz, int, Object)}.
   *
   * <p>Method under test: {@link ProgramField#ProgramField(int, int, int, Clazz, int, Object)}
   */
  @Test
  @DisplayName("Test new ProgramField(int, int, int, Clazz, int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramField.<init>(int, int, int, proguard.classfile.Clazz, int, java.lang.Object)"
  })
  void testNewProgramField2() {
    // Arrange and Act
    ProgramField actualProgramField =
        new ProgramField(1, 1, 1, new LibraryClass(), 1, "Processing Info");

    // Assert
    assertTrue(actualProgramField.referencedClass instanceof LibraryClass);
    assertEquals("Processing Info", actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.attributes.length);
    assertEquals(0, actualProgramField.u2attributesCount);
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.getProcessingFlags());
    assertEquals(1, actualProgramField.u2descriptorIndex);
    assertEquals(1, actualProgramField.u2nameIndex);
  }

  /**
   * Test {@link ProgramField#ProgramField()}.
   *
   * <ul>
   *   <li>Then return AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProgramField#ProgramField()}
   */
  @Test
  @DisplayName("Test new ProgramField(); then return AccessFlags is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramField.<init>()",
    "void proguard.classfile.ProgramField.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz)",
    "void proguard.classfile.ProgramField.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz, int, java.lang.Object)"
  })
  void testNewProgramField_thenReturnAccessFlagsIsZero() {
    // Arrange and Act
    ProgramField actualProgramField = new ProgramField();

    // Assert
    assertNull(actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.getAccessFlags());
    assertEquals(0, actualProgramField.getProcessingFlags());
  }

  /**
   * Test {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz)}
   */
  @Test
  @DisplayName(
      "Test new ProgramField(int, int, int, int, Attribute[], Clazz); when one; then return ProcessingInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramField.<init>()",
    "void proguard.classfile.ProgramField.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz)",
    "void proguard.classfile.ProgramField.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz, int, java.lang.Object)"
  })
  void testNewProgramField_whenOne_thenReturnProcessingInfoIsNull() {
    // Arrange and Act
    ProgramField actualProgramField =
        new ProgramField(
            1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass());

    // Assert
    assertNull(actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.getProcessingFlags());
    assertEquals(1, actualProgramField.getAccessFlags());
  }

  /**
   * Test {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz, int, Object)}.
   *
   * <ul>
   *   <li>When {@code Processing Info}.
   *   <li>Then return {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz,
   * int, Object)}
   */
  @Test
  @DisplayName(
      "Test new ProgramField(int, int, int, int, Attribute[], Clazz, int, Object); when 'Processing Info'; then return 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramField.<init>()",
    "void proguard.classfile.ProgramField.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz)",
    "void proguard.classfile.ProgramField.<init>(int, int, int, int, proguard.classfile.attribute.Attribute[], proguard.classfile.Clazz, int, java.lang.Object)"
  })
  void testNewProgramField_whenProcessingInfo_thenReturnProcessingInfo() {
    // Arrange and Act
    ProgramField actualProgramField =
        new ProgramField(
            1,
            1,
            1,
            3,
            new Attribute[] {new BootstrapMethodsAttribute()},
            new LibraryClass(),
            1,
            "Processing Info");

    // Assert
    assertEquals("Processing Info", actualProgramField.getProcessingInfo());
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.getProcessingFlags());
  }

  /**
   * Test {@link ProgramField#accept(ProgramClass, MemberVisitor)} with {@code programClass}, {@code
   * memberVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramField#accept(ProgramClass, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ProgramClass, MemberVisitor) with 'programClass', 'memberVisitor'; then calls visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramField.accept(proguard.classfile.ProgramClass, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAcceptWithProgramClassMemberVisitor_thenCallsVisitProgramField() {
    // Arrange
    ProgramField programField = new ProgramField();
    ProgramClass programClass = new ProgramClass();
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());

    // Act
    programField.accept(programClass, memberVisitor);

    // Assert
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link ProgramField#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramField#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramField.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    ProgramField programField = new ProgramField();
    programField.referencedClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    programField.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}

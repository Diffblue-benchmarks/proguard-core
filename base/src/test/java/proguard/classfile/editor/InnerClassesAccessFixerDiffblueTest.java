package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.visitor.ClassVisitor;

class InnerClassesAccessFixerDiffblueTest {
  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo2() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, new ClassConstant(1, new LibraryClass())},
            1,
            1,
            1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo3() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {classConstant, new DoubleConstant(10.0d)}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo4() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {classConstant, new DynamicConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo5() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {classConstant, new FieldrefConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo6() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {classConstant, new FloatConstant(10.0f)}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo7() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {classConstant, new IntegerConstant(42)}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo8() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, new InterfaceMethodrefConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo9() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, new InvokeDynamicConstant()}, 1, 1, 1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo10() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass clazz =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, new ClassConstant(1, new ProgramClass())},
            1,
            1,
            1);

    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    assertEquals(0, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo); given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo_givenZero() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    innerClassesInfo.u2innerClassIndex = 0;

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo); when LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo_whenLibraryClass() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    LibraryClass clazz = new LibraryClass();
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    innerClassesAccessFixer.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert that nothing has changed
    assertEquals(1, innerClassesInfo.u2innerClassAccessFlags);
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass} {@link LibraryClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given LibraryClass accept(ClassVisitor) does nothing; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenLibraryClassAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    LibraryClass clazz = new LibraryClass();
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).accept(Mockito.<ClassVisitor>any());
    ClassConstant classConstant = new ClassConstant();
    classConstant.referencedClass = libraryClass;

    // Act
    innerClassesAccessFixer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(libraryClass).accept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link InnerClassesAccessFixer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassConstant#referencedClassAccept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAccessFixer#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls referencedClassAccept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InnerClassesAccessFixer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsReferencedClassAccept() {
    // Arrange
    InnerClassesAccessFixer innerClassesAccessFixer = new InnerClassesAccessFixer();
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).referencedClassAccept(Mockito.<ClassVisitor>any());

    // Act
    innerClassesAccessFixer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).referencedClassAccept(isA(ClassVisitor.class));
  }
}

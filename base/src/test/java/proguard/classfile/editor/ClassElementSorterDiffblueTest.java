package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;

class ClassElementSorterDiffblueTest {
  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass2() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, true, true, true);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass3() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass4() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();

    FloatConstant floatConstant = new FloatConstant();
    floatConstant.addProcessingFlags(2, 1, 2, 1);
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, floatConstant, classConstant2}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(3, constantArray.length);
    assertEquals(classConstant, constant);
    assertSame(classConstant2, constant);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass5() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();

    IntegerConstant integerConstant = new IntegerConstant();
    integerConstant.addProcessingFlags(2, 1, 2, 1);
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, integerConstant, classConstant2}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(3, constantArray.length);
    assertEquals(classConstant, constant);
    assertSame(classConstant2, constant);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass6() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(false, true, true, true);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass7() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, false, true, true);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass8() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, true, true, false);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element is {@link DynamicConstant#DynamicConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then third element is DynamicConstant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenThirdElementIsDynamicConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, dynamicConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(dynamicConstant, constantArray[2]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element is {@link FieldrefConstant#FieldrefConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then third element is FieldrefConstant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenThirdElementIsFieldrefConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();

    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    fieldrefConstant.addProcessingFlags(2, 1, 2, 1);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, fieldrefConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(fieldrefConstant, constantArray[2]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element is {@link InterfaceMethodrefConstant#InterfaceMethodrefConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then third element is InterfaceMethodrefConstant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenThirdElementIsInterfaceMethodrefConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();

    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    interfaceMethodrefConstant.addProcessingFlags(2, 1, 2, 1);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, interfaceMethodrefConstant, new ClassConstant()},
            1,
            1,
            1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(interfaceMethodrefConstant, constantArray[2]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element is {@link InvokeDynamicConstant#InvokeDynamicConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then third element is InvokeDynamicConstant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenThirdElementIsInvokeDynamicConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();

    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    invokeDynamicConstant.addProcessingFlags(2, 1, 2, 1);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, invokeDynamicConstant, new ClassConstant()},
            1,
            1,
            1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(invokeDynamicConstant, constantArray[2]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element is {@link MethodHandleConstant#MethodHandleConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then third element is MethodHandleConstant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenThirdElementIsMethodHandleConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();

    MethodHandleConstant methodHandleConstant = new MethodHandleConstant();
    methodHandleConstant.addProcessingFlags(2, 1, 2, 1);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, methodHandleConstant, new ClassConstant()},
            1,
            1,
            1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(methodHandleConstant, constantArray[2]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element is {@link MethodTypeConstant#MethodTypeConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then third element is MethodTypeConstant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassElementSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenThirdElementIsMethodTypeConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();

    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();
    methodTypeConstant.addProcessingFlags(2, 1, 2, 1);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, methodTypeConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(methodTypeConstant, constantArray[2]);
  }
}

package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.kotlin.KotlinConstants;

class ConstantPoolEditorDiffblueTest {
  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolEditor.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean)"
  })
  void testNewConstantPoolEditor() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(
                targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool); given one; when ProgramClass() u2constantPoolCount is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolEditor.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewConstantPoolEditor_givenOne_whenProgramClassU2constantPoolCountIsOne() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass); given two; when ProgramClass() u2constantPoolCount is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolEditor.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewConstantPoolEditor_givenTwo_whenProgramClassU2constantPoolCountIsTwo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool); given two; when ProgramClass() u2constantPoolCount is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolEditor.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewConstantPoolEditor_givenTwo_whenProgramClassU2constantPoolCountIsTwo2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return TargetClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean); when 'false'; then return TargetClass is ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolEditor.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean)"
  })
  void testNewConstantPoolEditor_whenFalse_thenReturnTargetClassIsProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool, false))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass); when ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolEditor.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewConstantPoolEditor_whenProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool); when ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolEditor.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewConstantPoolEditor_whenProgramClass2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(
                targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then return TargetClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean); when ProgramClass(); then return TargetClass is ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolEditor.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean)"
  })
  void testNewConstantPoolEditor_whenProgramClass_thenReturnTargetClassIsProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(
                targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#getTargetClass()}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#getTargetClass()}
   */
  @Test
  @DisplayName("Test getTargetClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ProgramClass proguard.classfile.editor.ConstantPoolEditor.getTargetClass()"
  })
  void testGetTargetClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#addConstant(Constant)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addConstant(Constant)}
   */
  @Test
  @DisplayName("Test addConstant(Constant); then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.ConstantPoolEditor.addConstant(proguard.classfile.constant.Constant)"
  })
  void testAddConstant_thenReturnThree() {
    // Arrange
    ProgramClass targetClass =
        new ProgramClass(2, 3, new Constant[] {new ClassConstant()}, 2, 2, 2);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addConstant(new ClassConstant()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }
}

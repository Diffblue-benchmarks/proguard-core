package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.editor.CompactCodeAttributeComposer.Label;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;
import proguard.classfile.instruction.VariableInstruction;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFile;

class CompactCodeAttributeComposerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ConstantPoolEditor,
   *       CodeAttributeComposer)}
   *   <li>{@link CompactCodeAttributeComposer#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link CompactCodeAttributeComposer#getConstantPoolEditor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.editor.ConstantPoolEditor, proguard.classfile.editor.CodeAttributeComposer)",
    "proguard.classfile.editor.ConstantPoolEditor proguard.classfile.editor.CompactCodeAttributeComposer.getConstantPoolEditor()",
    "void proguard.classfile.editor.CompactCodeAttributeComposer.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testGettersAndSetters() {
    // Arrange
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(constantPoolEditor, new CodeAttributeComposer());
    LibraryClass clazz = new LibraryClass();
    actualCompactCodeAttributeComposer.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertSame(constantPoolEditor, actualCompactCodeAttributeComposer.getConstantPoolEditor());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ConstantPoolEditor,
   * boolean, boolean, boolean)}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ConstantPoolEditor, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ConstantPoolEditor, boolean, boolean, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.editor.ConstantPoolEditor, boolean, boolean, boolean)"
  })
  void testNewCompactCodeAttributeComposer() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(constantPoolEditor, true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(constantPoolEditor, actualCompactCodeAttributeComposer.getConstantPoolEditor());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool); given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewCompactCodeAttributeComposer_givenOne() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool); given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass, boolean, boolean, boolean, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewCompactCodeAttributeComposer_givenOne2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            targetClass, true, true, true, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}
   */
  @Test
  @DisplayName("Test new CompactCodeAttributeComposer(ProgramClass); given two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewCompactCodeAttributeComposer_givenTwo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool); given two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewCompactCodeAttributeComposer_givenTwo2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean); given two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass, boolean, boolean, boolean)"
  })
  void testNewCompactCodeAttributeComposer_givenTwo3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass, true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool); given two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass, boolean, boolean, boolean, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewCompactCodeAttributeComposer_givenTwo4() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            targetClass, true, true, true, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}
   */
  @Test
  @DisplayName("Test new CompactCodeAttributeComposer(ProgramClass); when ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewCompactCodeAttributeComposer_whenProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool); when ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewCompactCodeAttributeComposer_whenProgramClass2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean); when ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass, boolean, boolean, boolean)"
  })
  void testNewCompactCodeAttributeComposer_whenProgramClass3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass, true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool); when ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CompactCodeAttributeComposer.<init>(proguard.classfile.ProgramClass, boolean, boolean, boolean, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewCompactCodeAttributeComposer_whenProgramClass4() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            targetClass,
            true,
            true,
            true,
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getTargetClass()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getTargetClass()}
   */
  @Test
  @DisplayName("Test getTargetClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ProgramClass proguard.classfile.editor.CompactCodeAttributeComposer.getTargetClass()"
  })
  void testGetTargetClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new CompactCodeAttributeComposer(targetClass)).getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getCodeLength()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getCodeLength()}
   */
  @Test
  @DisplayName("Test getCodeLength()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.editor.CompactCodeAttributeComposer.getCodeLength()"})
  void testGetCodeLength() {
    // Arrange, Act and Assert
    assertEquals(0, (new CompactCodeAttributeComposer(new ProgramClass())).getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then eighth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @DisplayName("Test convertToTargetType(String, String); then eighth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertToTargetType(java.lang.String, java.lang.String)"
  })
  void testConvertToTargetType_thenEighthElementReturnClassConstant() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 1, new Constant[] {new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic("java/lang/Short", "java/lang/Short", "java/lang/Short");
    compactCodeAttributeComposer.putstatic(
        "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;");

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult =
        compactCodeAttributeComposer.convertToTargetType("Source Type", "Target Type");

    // Assert
    ProgramClass targetClass = actualConvertToTargetTypeResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[7] instanceof ClassConstant);
    assertTrue(constantArray[8] instanceof FieldrefConstant);
    assertTrue(constantArray[11] instanceof MethodrefConstant);
    assertTrue(constantArray[10] instanceof NameAndTypeConstant);
    assertTrue(constantArray[9] instanceof Utf8Constant);
    assertEquals(12, targetClass.u2constantPoolCount);
    assertEquals(17, constantArray.length);
    assertEquals(9, compactCodeAttributeComposer.getCodeLength());
    assertEquals(9, actualConvertToTargetTypeResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then fifth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @DisplayName("Test convertToTargetType(String, String); then fifth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertToTargetType(java.lang.String, java.lang.String)"
  })
  void testConvertToTargetType_thenFifthElementReturnClassConstant() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 1, new Constant[] {new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic(
        "(S)Ljava/lang/Short;", "valueOf", "(S)Ljava/lang/Short;");

    // Act and Assert
    Constant[] constantArray =
        compactCodeAttributeComposer
            .convertToTargetType("Source Type", "Target Type")
            .getTargetClass()
            .constantPool;
    assertTrue(constantArray[4] instanceof ClassConstant);
    assertTrue(constantArray[5] instanceof FieldrefConstant);
    assertTrue(constantArray[8] instanceof MethodrefConstant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(17, constantArray.length);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then ninth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @DisplayName("Test convertToTargetType(String, String); then ninth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertToTargetType(java.lang.String, java.lang.String)"
  })
  void testConvertToTargetType_thenNinthElementReturnClassConstant() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 1, new Constant[] {new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic(
        "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;");

    // Act and Assert
    ProgramClass targetClass =
        compactCodeAttributeComposer
            .convertToTargetType("Source Type", "Target Type")
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[8] instanceof ClassConstant);
    assertTrue(constantArray[9] instanceof MethodrefConstant);
    assertTrue(constantArray[7] instanceof Utf8Constant);
    assertEquals(10, targetClass.u2constantPoolCount);
    assertEquals(17, constantArray.length);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @DisplayName("Test convertToTargetType(String, String); then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertToTargetType(java.lang.String, java.lang.String)"
  })
  void testConvertToTargetType_thenSixthElementReturnClassConstant() {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new CompactCodeAttributeComposer(
                new ProgramClass(90, 1, new Constant[] {new ClassConstant()}, 90, 90, 90)))
            .convertToTargetType("Source Type", "Target Type")
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof MethodrefConstant);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertEquals(17, constantArray.length);
    assertEquals(7, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then sixth element return {@link NameAndTypeConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @DisplayName(
      "Test convertToTargetType(String, String); then sixth element return NameAndTypeConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertToTargetType(java.lang.String, java.lang.String)"
  })
  void testConvertToTargetType_thenSixthElementReturnNameAndTypeConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult =
        (new CompactCodeAttributeComposer(
                new ProgramClass(
                    90,
                    3,
                    new Constant[] {classConstant, classConstant2, classConstant3},
                    90,
                    90,
                    90)))
            .convertToTargetType("Source Type", "Target Type");

    // Assert
    ProgramClass targetClass = actualConvertToTargetTypeResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof NameAndTypeConstant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(19, constantArray.length);
    assertSame(classConstant2, constantArray[1]);
    assertSame(classConstant3, constantArray[2]);
    assertSame(
        targetClass, actualConvertToTargetTypeResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Short}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @DisplayName("Test convertToTargetType(String, String); when 'java/lang/Short'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertToTargetType(java.lang.String, java.lang.String)"
  })
  void testConvertToTargetType_whenJavaLangShort() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 3, new Constant[] {new ClassConstant()}, 90, 90, 90));

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult =
        compactCodeAttributeComposer.convertToTargetType("java/lang/Short", "Target Type");

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertEquals(0, actualConvertToTargetTypeResult.getCodeLength());
    ProgramClass targetClass = actualConvertToTargetTypeResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(
        targetClass, actualConvertToTargetTypeResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>When {@code (S)Ljava/lang/Short;}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @DisplayName("Test convertToTargetType(String, String); when '(S)Ljava/lang/Short;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertToTargetType(java.lang.String, java.lang.String)"
  })
  void testConvertToTargetType_whenSLjavaLangShort() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 3, new Constant[] {new ClassConstant()}, 90, 90, 90));

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult =
        compactCodeAttributeComposer.convertToTargetType("(S)Ljava/lang/Short;", "Target Type");

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertEquals(0, actualConvertToTargetTypeResult.getCodeLength());
    ProgramClass targetClass = actualConvertToTargetTypeResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(
        targetClass, actualConvertToTargetTypeResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#boxPrimitiveType(char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test boxPrimitiveType(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.boxPrimitiveType('A'));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('A', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'S');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenB() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('B', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenB2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'C'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenC() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('C', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'C'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenC2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'C');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenD() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('D', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenD2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenF() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('F', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenF2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenJ() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('J', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @DisplayName("Test convertPrimitiveType(char, char); when 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  void testConvertPrimitiveType_whenJ2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  @DisplayName("Test unboxPrimitiveType(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.unboxPrimitiveType(java.lang.String, java.lang.String)"
  })
  void testUnboxPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.unboxPrimitiveType("Source Type", "Target Type"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  @DisplayName("Test unboxPrimitiveType(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.unboxPrimitiveType(java.lang.String, java.lang.String)"
  })
  void testUnboxPrimitiveType2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(66, 1, new Constant[] {new ClassConstant()}, 66, 66, 66));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.unboxPrimitiveType("Source Type", "Source Type"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  @DisplayName("Test unboxPrimitiveType(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.unboxPrimitiveType(java.lang.String, java.lang.String)"
  })
  void testUnboxPrimitiveType3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                66,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                66,
                66,
                66));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.unboxPrimitiveType("Source Type", "Source Type"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#reset()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.reset()"
  })
  void testReset() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.reset());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#beginCodeFragment(int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#beginCodeFragment(int)}
   */
  @Test
  @DisplayName("Test beginCodeFragment(int); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.beginCodeFragment(int)"
  })
  void testBeginCodeFragment_whenThree() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.beginCodeFragment(3));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#beginCodeFragment(int)}.
   *
   * <ul>
   *   <li>When {@link ClassEstimates#TYPICAL_CODE_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#beginCodeFragment(int)}
   */
  @Test
  @DisplayName("Test beginCodeFragment(int); when TYPICAL_CODE_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.beginCodeFragment(int)"
  })
  void testBeginCodeFragment_whenTypical_code_length() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.beginCodeFragment(ClassEstimates.TYPICAL_CODE_LENGTH));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new BranchInstruction((byte) 'A', 1)};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof BranchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertEquals(3, actualAppendInstructionsResult.getCodeLength());
    assertEquals('A', ((BranchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new VariableInstruction((byte) 'A')};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof VariableInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualAppendInstructionsResult.getCodeLength());
    assertEquals(1, instructions.length);
    assertEquals('A', ((VariableInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link ConstantInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[]); then first element ConstantInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementConstantInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new ConstantInstruction((byte) 'A', 1)};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof ConstantInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertEquals(3, actualAppendInstructionsResult.getCodeLength());
    assertEquals('A', ((ConstantInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link LookUpSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[]); then first element LookUpSwitchInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementLookUpSwitchInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions =
        new Instruction[] {
          new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 2, 1, 2}, new int[] {1, 2, 1, 2})
        };

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof LookUpSwitchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(44, compactCodeAttributeComposer.getCodeLength());
    assertEquals(44, actualAppendInstructionsResult.getCodeLength());
    assertEquals('A', ((LookUpSwitchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code goto_w}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[]); then first element Name is 'goto_w'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementNameIsGotoW() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions =
        new Instruction[] {new BranchInstruction((byte) -89, Integer.MIN_VALUE)};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof BranchInstruction);
    assertEquals("goto_w", instruction.getName());
    assertEquals((byte) -56, ((BranchInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertEquals(5, actualAppendInstructionsResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[]); then first element Name is 'nop'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementNameIsNop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new VariableInstruction()};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof VariableInstruction);
    assertEquals("nop", instruction.getName());
    assertEquals((byte) 0, ((VariableInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertEquals(2, actualAppendInstructionsResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link SimpleInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[]); then first element SimpleInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementSimpleInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new SimpleInstruction((byte) 'A')};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof SimpleInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualAppendInstructionsResult.getCodeLength());
    assertEquals(1, instructions.length);
    assertEquals('A', ((SimpleInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link TableSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[]); then first element TableSwitchInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementTableSwitchInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions =
        new Instruction[] {new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 2, 1, 2})};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof TableSwitchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(20, compactCodeAttributeComposer.getCodeLength());
    assertEquals(20, actualAppendInstructionsResult.getCodeLength());
    assertEquals('A', ((TableSwitchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName("Test appendInstruction(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertEquals(3, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName("Test appendInstruction(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    ConstantInstruction instruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertEquals(3, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName("Test appendInstruction(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    LookUpSwitchInstruction instruction =
        new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 2, 1, 2}, new int[] {1, 2, 1, 2});

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(44, compactCodeAttributeComposer.getCodeLength());
    assertEquals(44, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName("Test appendInstruction(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    TableSwitchInstruction instruction =
        new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 2, 1, 2});

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(20, compactCodeAttributeComposer.getCodeLength());
    assertEquals(20, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName("Test appendInstruction(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    BranchInstruction instruction = new BranchInstruction((byte) -89, Integer.MIN_VALUE);

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("goto_w", instruction.getName());
    assertEquals((byte) -56, instruction.opcode);
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertEquals(5, actualAppendInstructionResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} Name is
   *       {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName(
      "Test appendInstruction(Instruction); then SimpleInstruction(byte) with opcode is 'A' Name is 'lstore_2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction_thenSimpleInstructionWithOpcodeIsANameIsLstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    SimpleInstruction instruction = new SimpleInstruction((byte) 'A');

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName(
      "Test appendInstruction(Instruction); then VariableInstruction(byte) with opcode is 'A' Name is 'lstore_2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction_thenVariableInstructionWithOpcodeIsANameIsLstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    VariableInstruction instruction = new VariableInstruction((byte) 'A');

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <ul>
   *   <li>When {@link VariableInstruction#VariableInstruction()}.
   *   <li>Then {@link VariableInstruction#VariableInstruction()} Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName(
      "Test appendInstruction(Instruction); when VariableInstruction(); then VariableInstruction() Name is 'nop'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction_whenVariableInstruction_thenVariableInstructionNameIsNop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    VariableInstruction instruction = new VariableInstruction();

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("nop", instruction.getName());
    assertEquals((byte) 0, instruction.opcode);
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertEquals(2, actualAppendInstructionResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#nop()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#nop()}
   */
  @Test
  @DisplayName("Test nop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.nop()"
  })
  void testNop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNopResult = compactCodeAttributeComposer.nop();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNopResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aconst_null()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aconst_null()}
   */
  @Test
  @DisplayName("Test aconst_null()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aconst_null()"
  })
  void testAconst_null() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAconst_nullResult =
        compactCodeAttributeComposer.aconst_null();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAconst_nullResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  @DisplayName("Test iconst(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst(int)"
  })
  void testIconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  @DisplayName("Test iconst(int); when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst(int)"
  })
  void testIconst_whenMinusOneHundredTwentyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst(int)}.
   *
   * <ul>
   *   <li>When six.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  @DisplayName("Test iconst(int); when six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst(int)"
  })
  void testIconst_whenSix() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(6);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_m1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_m1()}
   */
  @Test
  @DisplayName("Test iconst_m1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst_m1()"
  })
  void testIconst_m1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_m1Result = compactCodeAttributeComposer.iconst_m1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_m1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_0()}
   */
  @Test
  @DisplayName("Test iconst_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst_0()"
  })
  void testIconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_0Result = compactCodeAttributeComposer.iconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_1()}
   */
  @Test
  @DisplayName("Test iconst_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst_1()"
  })
  void testIconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_1Result = compactCodeAttributeComposer.iconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_2()}
   */
  @Test
  @DisplayName("Test iconst_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst_2()"
  })
  void testIconst_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_2Result = compactCodeAttributeComposer.iconst_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_3()}
   */
  @Test
  @DisplayName("Test iconst_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst_3()"
  })
  void testIconst_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_3Result = compactCodeAttributeComposer.iconst_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_4()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_4()}
   */
  @Test
  @DisplayName("Test iconst_4()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst_4()"
  })
  void testIconst_4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_4Result = compactCodeAttributeComposer.iconst_4();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_4Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_5()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_5()}
   */
  @Test
  @DisplayName("Test iconst_5()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iconst_5()"
  })
  void testIconst_5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_5Result = compactCodeAttributeComposer.iconst_5();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_5Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  @DisplayName("Test lconst(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lconst(int)"
  })
  void testLconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(7);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  @DisplayName("Test lconst(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lconst(int)"
  })
  void testLconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(8);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  @DisplayName("Test lconst(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lconst(int)"
  })
  void testLconst_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  @DisplayName("Test lconst(int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lconst(int)"
  })
  void testLconst_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst_0()}
   */
  @Test
  @DisplayName("Test lconst_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lconst_0()"
  })
  void testLconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconst_0Result = compactCodeAttributeComposer.lconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconst_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst_1()}
   */
  @Test
  @DisplayName("Test lconst_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lconst_1()"
  })
  void testLconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconst_1Result = compactCodeAttributeComposer.lconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconst_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  @DisplayName("Test fconst(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fconst(int)"
  })
  void testFconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  @DisplayName("Test fconst(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fconst(int)"
  })
  void testFconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(5);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  @DisplayName("Test fconst(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fconst(int)"
  })
  void testFconst3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(6);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst_0()}
   */
  @Test
  @DisplayName("Test fconst_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fconst_0()"
  })
  void testFconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_0Result = compactCodeAttributeComposer.fconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst_1()}
   */
  @Test
  @DisplayName("Test fconst_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fconst_1()"
  })
  void testFconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_1Result = compactCodeAttributeComposer.fconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst_2()}
   */
  @Test
  @DisplayName("Test fconst_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fconst_2()"
  })
  void testFconst_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_2Result = compactCodeAttributeComposer.fconst_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  @DisplayName("Test dconst(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dconst(int)"
  })
  void testDconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(2);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  @DisplayName("Test dconst(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dconst(int)"
  })
  void testDconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(3);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  @DisplayName("Test dconst(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dconst(int)"
  })
  void testDconst_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  @DisplayName("Test dconst(int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dconst(int)"
  })
  void testDconst_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst_0()}
   */
  @Test
  @DisplayName("Test dconst_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dconst_0()"
  })
  void testDconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconst_0Result = compactCodeAttributeComposer.dconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconst_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst_1()}
   */
  @Test
  @DisplayName("Test dconst_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dconst_1()"
  })
  void testDconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconst_1Result = compactCodeAttributeComposer.dconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconst_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#bipush(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  @DisplayName("Test bipush(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.bipush(int)"
  })
  void testBipush() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult = compactCodeAttributeComposer.bipush(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#bipush(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  @DisplayName("Test bipush(int); when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.bipush(int)"
  })
  void testBipush_whenMinusOneHundredTwentyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult = compactCodeAttributeComposer.bipush(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#bipush(int)}.
   *
   * <ul>
   *   <li>When {@link ClassEstimates#TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  @DisplayName("Test bipush(int); when TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.bipush(int)"
  })
  void testBipush_whenTypical_bootstrap_methods_attribute_size() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult =
        compactCodeAttributeComposer.bipush(
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#sipush(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  @DisplayName("Test sipush(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.sipush(int)"
  })
  void testSipush() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#sipush(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  @DisplayName("Test sipush(int); when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.sipush(int)"
  })
  void testSipush_whenMinusOneHundredTwentyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#sipush(int)}.
   *
   * <ul>
   *   <li>When seventeen.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  @DisplayName("Test sipush(int); when seventeen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.sipush(int)"
  })
  void testSipush_whenSeventeen() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(17);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Clazz)} with {@code Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz)}
   */
  @Test
  @DisplayName("Test ldc(Clazz) with 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(proguard.classfile.Clazz)"
  })
  void testLdcWithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    CompactCodeAttributeComposer actualLdcResult =
        compactCodeAttributeComposer.ldc((Clazz) new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc(Clazz, Member) with 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithClazzMember() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc(Clazz, Member) with 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  @DisplayName("Test ldc(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(float)"
  })
  void testLdcWithFloat() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(4, 1, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  @DisplayName("Test ldc(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(float)"
  })
  void testLdcWithFloat2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(4, 0, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  @DisplayName("Test ldc(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(float)"
  })
  void testLdcWithFloat3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                4,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                4,
                4,
                4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  @DisplayName("Test ldc(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(int)"
  })
  void testLdcWithInt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(3, 1, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  @DisplayName("Test ldc(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(int)"
  })
  void testLdcWithInt2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(3, 0, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  @DisplayName("Test ldc(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(int)"
  })
  void testLdcWithInt3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                3,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                3,
                3,
                3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  @DisplayName("Test ldc(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.Object)"
  })
  void testLdcWithObject() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(99, 1, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  @DisplayName("Test ldc(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.Object)"
  })
  void testLdcWithObject2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(99, 0, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  @DisplayName("Test ldc(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.Object)"
  })
  void testLdcWithObject3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                99,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                99,
                99,
                99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc(ResourceFile) with 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(proguard.resources.file.ResourceFile)"
  })
  void testLdcWithResourceFile() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc(ResourceFile) with 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(proguard.resources.file.ResourceFile)"
  })
  void testLdcWithResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String)} with {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String)}
   */
  @Test
  @DisplayName("Test ldc(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.String)"
  })
  void testLdcWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc("String"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String)} with {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String)}
   */
  @Test
  @DisplayName("Test ldc(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.String)"
  })
  void testLdcWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc("String"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz) with 'String', 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdcWithStringClazz() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz) with 'String', 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdcWithStringClazz2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz, Member) with 'String', 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithStringClazzMember() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz, Member) with 'String', 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithStringClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc(String, ResourceFile) with 'String', 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdcWithStringResourceFile() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc(String, ResourceFile) with 'String', 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdcWithStringResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_(int)}
   */
  @Test
  @DisplayName("Test ldc_(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_(int)"
  })
  void testLdc_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_Result = compactCodeAttributeComposer.ldc_(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_(int)}
   */
  @Test
  @DisplayName("Test ldc_(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_(int)"
  })
  void testLdc_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_Result =
        compactCodeAttributeComposer.ldc_(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Clazz)} with {@code Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz) with 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(proguard.classfile.Clazz)"
  })
  void testLdc_wWithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult =
        compactCodeAttributeComposer.ldc_w((Clazz) new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz, Member) with 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithClazzMember() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz, Member) with 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  @DisplayName("Test ldc_w(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(float)"
  })
  void testLdc_wWithFloat() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(4, 1, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  @DisplayName("Test ldc_w(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(float)"
  })
  void testLdc_wWithFloat2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(4, 0, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  @DisplayName("Test ldc_w(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(float)"
  })
  void testLdc_wWithFloat3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                4,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                4,
                4,
                4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  @DisplayName("Test ldc_w(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(int)"
  })
  void testLdc_wWithInt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(3, 1, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  @DisplayName("Test ldc_w(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(int)"
  })
  void testLdc_wWithInt2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(3, 0, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  @DisplayName("Test ldc_w(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(int)"
  })
  void testLdc_wWithInt3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                3,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                3,
                3,
                3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  @DisplayName("Test ldc_w(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.Object)"
  })
  void testLdc_wWithObject() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(99, 1, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  @DisplayName("Test ldc_w(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.Object)"
  })
  void testLdc_wWithObject2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(99, 0, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  @DisplayName("Test ldc_w(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.Object)"
  })
  void testLdc_wWithObject3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                99,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                99,
                99,
                99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc_w(ResourceFile) with 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithResourceFile() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc_w(ResourceFile) with 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String)} with {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String)}
   */
  @Test
  @DisplayName("Test ldc_w(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.String)"
  })
  void testLdc_wWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w("String"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String)} with {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String)}
   */
  @Test
  @DisplayName("Test ldc_w(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.String)"
  })
  void testLdc_wWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w("String"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)}
   */
  @Test
  @DisplayName("Test ldc_w(String, Clazz) with 'String', 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdc_wWithStringClazz() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)}
   */
  @Test
  @DisplayName("Test ldc_w(String, Clazz) with 'String', 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdc_wWithStringClazz2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc_w(String, Clazz, Member) with 'String', 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithStringClazzMember() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc_w(String, Clazz, Member) with 'String', 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithStringClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)} with {@code String},
   * {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc_w(String, ResourceFile) with 'String', 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithStringResourceFile() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)} with {@code String},
   * {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc_w(String, ResourceFile) with 'String', 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithStringResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w_(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w_(int)}
   */
  @Test
  @DisplayName("Test ldc_w_(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w_(int)"
  })
  void testLdc_w_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_w_Result = compactCodeAttributeComposer.ldc_w_(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_w_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w_(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w_(int)}
   */
  @Test
  @DisplayName("Test ldc_w_(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc_w_(int)"
  })
  void testLdc_w_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_w_Result =
        compactCodeAttributeComposer.ldc_w_(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_w_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(double)} with {@code double}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(double)}
   */
  @Test
  @DisplayName("Test ldc2_w(double) with 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc2_w(double)"
  })
  void testLdc2_wWithDouble() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(6, 1, new Constant[] {new ClassConstant()}, 6, 6, 6));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc2_w(10.0d));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(double)} with {@code double}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(double)}
   */
  @Test
  @DisplayName("Test ldc2_w(double) with 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc2_w(double)"
  })
  void testLdc2_wWithDouble2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                6,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                6,
                6,
                6));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc2_w(10.0d));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(int)}
   */
  @Test
  @DisplayName("Test ldc2_w(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc2_w(int)"
  })
  void testLdc2_wWithInt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc2_wResult = compactCodeAttributeComposer.ldc2_w(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc2_wResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(long)} with {@code long}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(long)}
   */
  @Test
  @DisplayName("Test ldc2_w(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc2_w(long)"
  })
  void testLdc2_wWithLong() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(5, 1, new Constant[] {new ClassConstant()}, 5, 5, 5));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc2_w(42L));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(long)} with {@code long}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(long)}
   */
  @Test
  @DisplayName("Test ldc2_w(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldc2_w(long)"
  })
  void testLdc2_wWithLong2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                5,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                5,
                5,
                5));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc2_w(42L));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload(int)}
   */
  @Test
  @DisplayName("Test iload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iload(int)"
  })
  void testIload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIloadResult = compactCodeAttributeComposer.iload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload(int)}
   */
  @Test
  @DisplayName("Test iload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iload(int)"
  })
  void testIload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIloadResult = compactCodeAttributeComposer.iload(21);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload(int)}
   */
  @Test
  @DisplayName("Test lload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lload(int)"
  })
  void testLload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLloadResult = compactCodeAttributeComposer.lload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload(int)}
   */
  @Test
  @DisplayName("Test lload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lload(int)"
  })
  void testLload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLloadResult = compactCodeAttributeComposer.lload(22);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload(int)}
   */
  @Test
  @DisplayName("Test fload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fload(int)"
  })
  void testFload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFloadResult = compactCodeAttributeComposer.fload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload(int)}
   */
  @Test
  @DisplayName("Test fload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fload(int)"
  })
  void testFload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFloadResult = compactCodeAttributeComposer.fload(23);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload(int)}
   */
  @Test
  @DisplayName("Test dload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dload(int)"
  })
  void testDload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDloadResult = compactCodeAttributeComposer.dload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload(int)}
   */
  @Test
  @DisplayName("Test dload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dload(int)"
  })
  void testDload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDloadResult = compactCodeAttributeComposer.dload(24);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload(int)}
   */
  @Test
  @DisplayName("Test aload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aload(int)"
  })
  void testAload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAloadResult = compactCodeAttributeComposer.aload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload(int)}
   */
  @Test
  @DisplayName("Test aload(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aload(int)"
  })
  void testAload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAloadResult = compactCodeAttributeComposer.aload(25);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload_0()}
   */
  @Test
  @DisplayName("Test iload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iload_0()"
  })
  void testIload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_0Result = compactCodeAttributeComposer.iload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload_1()}
   */
  @Test
  @DisplayName("Test iload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iload_1()"
  })
  void testIload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_1Result = compactCodeAttributeComposer.iload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload_2()}
   */
  @Test
  @DisplayName("Test iload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iload_2()"
  })
  void testIload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_2Result = compactCodeAttributeComposer.iload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload_3()}
   */
  @Test
  @DisplayName("Test iload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iload_3()"
  })
  void testIload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_3Result = compactCodeAttributeComposer.iload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload_0()}
   */
  @Test
  @DisplayName("Test lload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lload_0()"
  })
  void testLload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_0Result = compactCodeAttributeComposer.lload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload_1()}
   */
  @Test
  @DisplayName("Test lload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lload_1()"
  })
  void testLload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_1Result = compactCodeAttributeComposer.lload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload_2()}
   */
  @Test
  @DisplayName("Test lload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lload_2()"
  })
  void testLload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_2Result = compactCodeAttributeComposer.lload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload_3()}
   */
  @Test
  @DisplayName("Test lload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lload_3()"
  })
  void testLload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_3Result = compactCodeAttributeComposer.lload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload_0()}
   */
  @Test
  @DisplayName("Test fload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fload_0()"
  })
  void testFload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_0Result = compactCodeAttributeComposer.fload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload_1()}
   */
  @Test
  @DisplayName("Test fload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fload_1()"
  })
  void testFload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_1Result = compactCodeAttributeComposer.fload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload_2()}
   */
  @Test
  @DisplayName("Test fload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fload_2()"
  })
  void testFload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_2Result = compactCodeAttributeComposer.fload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload_3()}
   */
  @Test
  @DisplayName("Test fload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fload_3()"
  })
  void testFload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_3Result = compactCodeAttributeComposer.fload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload_0()}
   */
  @Test
  @DisplayName("Test dload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dload_0()"
  })
  void testDload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_0Result = compactCodeAttributeComposer.dload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload_1()}
   */
  @Test
  @DisplayName("Test dload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dload_1()"
  })
  void testDload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_1Result = compactCodeAttributeComposer.dload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload_2()}
   */
  @Test
  @DisplayName("Test dload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dload_2()"
  })
  void testDload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_2Result = compactCodeAttributeComposer.dload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload_3()}
   */
  @Test
  @DisplayName("Test dload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dload_3()"
  })
  void testDload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_3Result = compactCodeAttributeComposer.dload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload_0()}
   */
  @Test
  @DisplayName("Test aload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aload_0()"
  })
  void testAload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_0Result = compactCodeAttributeComposer.aload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload_1()}
   */
  @Test
  @DisplayName("Test aload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aload_1()"
  })
  void testAload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_1Result = compactCodeAttributeComposer.aload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload_2()}
   */
  @Test
  @DisplayName("Test aload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aload_2()"
  })
  void testAload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_2Result = compactCodeAttributeComposer.aload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload_3()}
   */
  @Test
  @DisplayName("Test aload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aload_3()"
  })
  void testAload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_3Result = compactCodeAttributeComposer.aload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iaload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iaload()}
   */
  @Test
  @DisplayName("Test iaload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iaload()"
  })
  void testIaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIaloadResult = compactCodeAttributeComposer.iaload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#laload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#laload()}
   */
  @Test
  @DisplayName("Test laload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.laload()"
  })
  void testLaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLaloadResult = compactCodeAttributeComposer.laload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#faload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#faload()}
   */
  @Test
  @DisplayName("Test faload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.faload()"
  })
  void testFaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFaloadResult = compactCodeAttributeComposer.faload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#daload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#daload()}
   */
  @Test
  @DisplayName("Test daload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.daload()"
  })
  void testDaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDaloadResult = compactCodeAttributeComposer.daload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aaload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aaload()}
   */
  @Test
  @DisplayName("Test aaload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aaload()"
  })
  void testAaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAaloadResult = compactCodeAttributeComposer.aaload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#baload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#baload()}
   */
  @Test
  @DisplayName("Test baload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.baload()"
  })
  void testBaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBaloadResult = compactCodeAttributeComposer.baload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#caload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#caload()}
   */
  @Test
  @DisplayName("Test caload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.caload()"
  })
  void testCaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCaloadResult = compactCodeAttributeComposer.caload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#saload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#saload()}
   */
  @Test
  @DisplayName("Test saload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.saload()"
  })
  void testSaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSaloadResult = compactCodeAttributeComposer.saload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore(int)}
   */
  @Test
  @DisplayName("Test istore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.istore(int)"
  })
  void testIstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstoreResult = compactCodeAttributeComposer.istore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore(int)}
   */
  @Test
  @DisplayName("Test istore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.istore(int)"
  })
  void testIstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstoreResult = compactCodeAttributeComposer.istore(54);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore(int)}
   */
  @Test
  @DisplayName("Test lstore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lstore(int)"
  })
  void testLstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstoreResult = compactCodeAttributeComposer.lstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore(int)}
   */
  @Test
  @DisplayName("Test lstore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lstore(int)"
  })
  void testLstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstoreResult = compactCodeAttributeComposer.lstore(55);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore(int)}
   */
  @Test
  @DisplayName("Test fstore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fstore(int)"
  })
  void testFstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstoreResult = compactCodeAttributeComposer.fstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore(int)}
   */
  @Test
  @DisplayName("Test fstore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fstore(int)"
  })
  void testFstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstoreResult = compactCodeAttributeComposer.fstore(56);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore(int)}
   */
  @Test
  @DisplayName("Test dstore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dstore(int)"
  })
  void testDstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstoreResult = compactCodeAttributeComposer.dstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore(int)}
   */
  @Test
  @DisplayName("Test dstore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dstore(int)"
  })
  void testDstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstoreResult = compactCodeAttributeComposer.dstore(57);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore(int)}
   */
  @Test
  @DisplayName("Test astore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.astore(int)"
  })
  void testAstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstoreResult = compactCodeAttributeComposer.astore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore(int)}
   */
  @Test
  @DisplayName("Test astore(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.astore(int)"
  })
  void testAstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstoreResult = compactCodeAttributeComposer.astore(58);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore_0()}
   */
  @Test
  @DisplayName("Test istore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.istore_0()"
  })
  void testIstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_0Result = compactCodeAttributeComposer.istore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore_1()}
   */
  @Test
  @DisplayName("Test istore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.istore_1()"
  })
  void testIstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_1Result = compactCodeAttributeComposer.istore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore_2()}
   */
  @Test
  @DisplayName("Test istore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.istore_2()"
  })
  void testIstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_2Result = compactCodeAttributeComposer.istore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore_3()}
   */
  @Test
  @DisplayName("Test istore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.istore_3()"
  })
  void testIstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_3Result = compactCodeAttributeComposer.istore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore_0()}
   */
  @Test
  @DisplayName("Test lstore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lstore_0()"
  })
  void testLstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_0Result = compactCodeAttributeComposer.lstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore_1()}
   */
  @Test
  @DisplayName("Test lstore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lstore_1()"
  })
  void testLstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_1Result = compactCodeAttributeComposer.lstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore_2()}
   */
  @Test
  @DisplayName("Test lstore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lstore_2()"
  })
  void testLstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_2Result = compactCodeAttributeComposer.lstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore_3()}
   */
  @Test
  @DisplayName("Test lstore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lstore_3()"
  })
  void testLstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_3Result = compactCodeAttributeComposer.lstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore_0()}
   */
  @Test
  @DisplayName("Test fstore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fstore_0()"
  })
  void testFstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_0Result = compactCodeAttributeComposer.fstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore_1()}
   */
  @Test
  @DisplayName("Test fstore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fstore_1()"
  })
  void testFstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_1Result = compactCodeAttributeComposer.fstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore_2()}
   */
  @Test
  @DisplayName("Test fstore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fstore_2()"
  })
  void testFstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_2Result = compactCodeAttributeComposer.fstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore_3()}
   */
  @Test
  @DisplayName("Test fstore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fstore_3()"
  })
  void testFstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_3Result = compactCodeAttributeComposer.fstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore_0()}
   */
  @Test
  @DisplayName("Test dstore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dstore_0()"
  })
  void testDstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_0Result = compactCodeAttributeComposer.dstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore_1()}
   */
  @Test
  @DisplayName("Test dstore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dstore_1()"
  })
  void testDstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_1Result = compactCodeAttributeComposer.dstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore_2()}
   */
  @Test
  @DisplayName("Test dstore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dstore_2()"
  })
  void testDstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_2Result = compactCodeAttributeComposer.dstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore_3()}
   */
  @Test
  @DisplayName("Test dstore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dstore_3()"
  })
  void testDstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_3Result = compactCodeAttributeComposer.dstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore_0()}
   */
  @Test
  @DisplayName("Test astore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.astore_0()"
  })
  void testAstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_0Result = compactCodeAttributeComposer.astore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore_1()}
   */
  @Test
  @DisplayName("Test astore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.astore_1()"
  })
  void testAstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_1Result = compactCodeAttributeComposer.astore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore_2()}
   */
  @Test
  @DisplayName("Test astore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.astore_2()"
  })
  void testAstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_2Result = compactCodeAttributeComposer.astore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore_3()}
   */
  @Test
  @DisplayName("Test astore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.astore_3()"
  })
  void testAstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_3Result = compactCodeAttributeComposer.astore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iastore()}
   */
  @Test
  @DisplayName("Test iastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iastore()"
  })
  void testIastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIastoreResult = compactCodeAttributeComposer.iastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lastore()}
   */
  @Test
  @DisplayName("Test lastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lastore()"
  })
  void testLastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLastoreResult = compactCodeAttributeComposer.lastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fastore()}
   */
  @Test
  @DisplayName("Test fastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fastore()"
  })
  void testFastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFastoreResult = compactCodeAttributeComposer.fastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dastore()}
   */
  @Test
  @DisplayName("Test dastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dastore()"
  })
  void testDastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDastoreResult = compactCodeAttributeComposer.dastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aastore()}
   */
  @Test
  @DisplayName("Test aastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.aastore()"
  })
  void testAastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAastoreResult = compactCodeAttributeComposer.aastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#bastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#bastore()}
   */
  @Test
  @DisplayName("Test bastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.bastore()"
  })
  void testBastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBastoreResult = compactCodeAttributeComposer.bastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#castore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#castore()}
   */
  @Test
  @DisplayName("Test castore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.castore()"
  })
  void testCastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCastoreResult = compactCodeAttributeComposer.castore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#sastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#sastore()}
   */
  @Test
  @DisplayName("Test sastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.sastore()"
  })
  void testSastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSastoreResult = compactCodeAttributeComposer.sastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pop()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pop()}
   */
  @Test
  @DisplayName("Test pop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pop()"
  })
  void testPop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPopResult = compactCodeAttributeComposer.pop();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPopResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pop2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pop2()}
   */
  @Test
  @DisplayName("Test pop2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pop2()"
  })
  void testPop2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPop2Result = compactCodeAttributeComposer.pop2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPop2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup()}
   */
  @Test
  @DisplayName("Test dup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dup()"
  })
  void testDup() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDupResult = compactCodeAttributeComposer.dup();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDupResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup_x1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup_x1()}
   */
  @Test
  @DisplayName("Test dup_x1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dup_x1()"
  })
  void testDup_x1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup_x1Result = compactCodeAttributeComposer.dup_x1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup_x1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup_x2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup_x2()}
   */
  @Test
  @DisplayName("Test dup_x2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dup_x2()"
  })
  void testDup_x2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup_x2Result = compactCodeAttributeComposer.dup_x2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup_x2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup2()}
   */
  @Test
  @DisplayName("Test dup2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dup2()"
  })
  void testDup2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2Result = compactCodeAttributeComposer.dup2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup2_x1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup2_x1()}
   */
  @Test
  @DisplayName("Test dup2_x1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dup2_x1()"
  })
  void testDup2_x1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2_x1Result = compactCodeAttributeComposer.dup2_x1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2_x1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup2_x2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup2_x2()}
   */
  @Test
  @DisplayName("Test dup2_x2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dup2_x2()"
  })
  void testDup2_x2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2_x2Result = compactCodeAttributeComposer.dup2_x2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2_x2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#swap()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#swap()}
   */
  @Test
  @DisplayName("Test swap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.swap()"
  })
  void testSwap() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSwapResult = compactCodeAttributeComposer.swap();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSwapResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iadd()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iadd()}
   */
  @Test
  @DisplayName("Test iadd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iadd()"
  })
  void testIadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIaddResult = compactCodeAttributeComposer.iadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIaddResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ladd()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ladd()}
   */
  @Test
  @DisplayName("Test ladd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ladd()"
  })
  void testLadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLaddResult = compactCodeAttributeComposer.ladd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLaddResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fadd()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fadd()}
   */
  @Test
  @DisplayName("Test fadd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fadd()"
  })
  void testFadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFaddResult = compactCodeAttributeComposer.fadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFaddResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dadd()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dadd()}
   */
  @Test
  @DisplayName("Test dadd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dadd()"
  })
  void testDadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDaddResult = compactCodeAttributeComposer.dadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDaddResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#isub()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#isub()}
   */
  @Test
  @DisplayName("Test isub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.isub()"
  })
  void testIsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIsubResult = compactCodeAttributeComposer.isub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIsubResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lsub()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lsub()}
   */
  @Test
  @DisplayName("Test lsub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lsub()"
  })
  void testLsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLsubResult = compactCodeAttributeComposer.lsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLsubResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fsub()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fsub()}
   */
  @Test
  @DisplayName("Test fsub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fsub()"
  })
  void testFsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFsubResult = compactCodeAttributeComposer.fsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFsubResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dsub()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dsub()}
   */
  @Test
  @DisplayName("Test dsub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dsub()"
  })
  void testDsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDsubResult = compactCodeAttributeComposer.dsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDsubResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#imul()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#imul()}
   */
  @Test
  @DisplayName("Test imul()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.imul()"
  })
  void testImul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualImulResult = compactCodeAttributeComposer.imul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualImulResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lmul()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lmul()}
   */
  @Test
  @DisplayName("Test lmul()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lmul()"
  })
  void testLmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLmulResult = compactCodeAttributeComposer.lmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLmulResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fmul()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fmul()}
   */
  @Test
  @DisplayName("Test fmul()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fmul()"
  })
  void testFmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFmulResult = compactCodeAttributeComposer.fmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFmulResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dmul()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dmul()}
   */
  @Test
  @DisplayName("Test dmul()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dmul()"
  })
  void testDmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDmulResult = compactCodeAttributeComposer.dmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDmulResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#idiv()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#idiv()}
   */
  @Test
  @DisplayName("Test idiv()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.idiv()"
  })
  void testIdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIdivResult = compactCodeAttributeComposer.idiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIdivResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldiv()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldiv()}
   */
  @Test
  @DisplayName("Test ldiv()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ldiv()"
  })
  void testLdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdivResult = compactCodeAttributeComposer.ldiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdivResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fdiv()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fdiv()}
   */
  @Test
  @DisplayName("Test fdiv()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fdiv()"
  })
  void testFdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFdivResult = compactCodeAttributeComposer.fdiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFdivResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ddiv()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ddiv()}
   */
  @Test
  @DisplayName("Test ddiv()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ddiv()"
  })
  void testDdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDdivResult = compactCodeAttributeComposer.ddiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDdivResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#irem()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#irem()}
   */
  @Test
  @DisplayName("Test irem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.irem()"
  })
  void testIrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIremResult = compactCodeAttributeComposer.irem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIremResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lrem()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lrem()}
   */
  @Test
  @DisplayName("Test lrem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lrem()"
  })
  void testLrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLremResult = compactCodeAttributeComposer.lrem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLremResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#frem()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#frem()}
   */
  @Test
  @DisplayName("Test frem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.frem()"
  })
  void testFrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFremResult = compactCodeAttributeComposer.frem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFremResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#drem()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#drem()}
   */
  @Test
  @DisplayName("Test drem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.drem()"
  })
  void testDrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDremResult = compactCodeAttributeComposer.drem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDremResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ineg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ineg()}
   */
  @Test
  @DisplayName("Test ineg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ineg()"
  })
  void testIneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInegResult = compactCodeAttributeComposer.ineg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInegResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lneg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lneg()}
   */
  @Test
  @DisplayName("Test lneg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lneg()"
  })
  void testLneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLnegResult = compactCodeAttributeComposer.lneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLnegResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fneg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fneg()}
   */
  @Test
  @DisplayName("Test fneg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fneg()"
  })
  void testFneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFnegResult = compactCodeAttributeComposer.fneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFnegResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dneg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dneg()}
   */
  @Test
  @DisplayName("Test dneg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dneg()"
  })
  void testDneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDnegResult = compactCodeAttributeComposer.dneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDnegResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ishl()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ishl()}
   */
  @Test
  @DisplayName("Test ishl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ishl()"
  })
  void testIshl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIshlResult = compactCodeAttributeComposer.ishl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIshlResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lshl()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lshl()}
   */
  @Test
  @DisplayName("Test lshl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lshl()"
  })
  void testLshl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLshlResult = compactCodeAttributeComposer.lshl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLshlResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ishr()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ishr()}
   */
  @Test
  @DisplayName("Test ishr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ishr()"
  })
  void testIshr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIshrResult = compactCodeAttributeComposer.ishr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIshrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lshr()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lshr()}
   */
  @Test
  @DisplayName("Test lshr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lshr()"
  })
  void testLshr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLshrResult = compactCodeAttributeComposer.lshr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLshrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iushr()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iushr()}
   */
  @Test
  @DisplayName("Test iushr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iushr()"
  })
  void testIushr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIushrResult = compactCodeAttributeComposer.iushr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIushrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lushr()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lushr()}
   */
  @Test
  @DisplayName("Test lushr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lushr()"
  })
  void testLushr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLushrResult = compactCodeAttributeComposer.lushr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLushrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iand()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iand()}
   */
  @Test
  @DisplayName("Test iand()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iand()"
  })
  void testIand() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIandResult = compactCodeAttributeComposer.iand();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIandResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#land()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#land()}
   */
  @Test
  @DisplayName("Test land()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.land()"
  })
  void testLand() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLandResult = compactCodeAttributeComposer.land();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLandResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ior()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ior()}
   */
  @Test
  @DisplayName("Test ior()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ior()"
  })
  void testIor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIorResult = compactCodeAttributeComposer.ior();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIorResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lor()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lor()}
   */
  @Test
  @DisplayName("Test lor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lor()"
  })
  void testLor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLorResult = compactCodeAttributeComposer.lor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLorResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ixor()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ixor()}
   */
  @Test
  @DisplayName("Test ixor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ixor()"
  })
  void testIxor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIxorResult = compactCodeAttributeComposer.ixor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIxorResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lxor()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lxor()}
   */
  @Test
  @DisplayName("Test lxor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lxor()"
  })
  void testLxor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLxorResult = compactCodeAttributeComposer.lxor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLxorResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iinc(int, int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iinc(int, int)}
   */
  @Test
  @DisplayName("Test iinc(int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iinc(int, int)"
  })
  void testIinc() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIincResult = compactCodeAttributeComposer.iinc(1, 1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIincResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iinc(int, int)}.
   *
   * <ul>
   *   <li>When twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iinc(int, int)}
   */
  @Test
  @DisplayName("Test iinc(int, int); when twenty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iinc(int, int)"
  })
  void testIinc_whenTwentySix() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIincResult = compactCodeAttributeComposer.iinc(26, 1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIincResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2l()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2l()}
   */
  @Test
  @DisplayName("Test i2l()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.i2l()"
  })
  void testI2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2lResult = compactCodeAttributeComposer.i2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2lResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2f()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2f()}
   */
  @Test
  @DisplayName("Test i2f()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.i2f()"
  })
  void testI2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2fResult = compactCodeAttributeComposer.i2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2fResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2d()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2d()}
   */
  @Test
  @DisplayName("Test i2d()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.i2d()"
  })
  void testI2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2dResult = compactCodeAttributeComposer.i2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2dResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#l2i()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#l2i()}
   */
  @Test
  @DisplayName("Test l2i()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.l2i()"
  })
  void testL2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2iResult = compactCodeAttributeComposer.l2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2iResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#l2f()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#l2f()}
   */
  @Test
  @DisplayName("Test l2f()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.l2f()"
  })
  void testL2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2fResult = compactCodeAttributeComposer.l2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2fResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#l2d()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#l2d()}
   */
  @Test
  @DisplayName("Test l2d()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.l2d()"
  })
  void testL2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2dResult = compactCodeAttributeComposer.l2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2dResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#f2i()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#f2i()}
   */
  @Test
  @DisplayName("Test f2i()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.f2i()"
  })
  void testF2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2iResult = compactCodeAttributeComposer.f2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2iResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#f2l()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#f2l()}
   */
  @Test
  @DisplayName("Test f2l()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.f2l()"
  })
  void testF2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2lResult = compactCodeAttributeComposer.f2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2lResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#f2d()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#f2d()}
   */
  @Test
  @DisplayName("Test f2d()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.f2d()"
  })
  void testF2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2dResult = compactCodeAttributeComposer.f2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2dResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#d2i()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#d2i()}
   */
  @Test
  @DisplayName("Test d2i()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.d2i()"
  })
  void testD2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2iResult = compactCodeAttributeComposer.d2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2iResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#d2l()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#d2l()}
   */
  @Test
  @DisplayName("Test d2l()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.d2l()"
  })
  void testD2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2lResult = compactCodeAttributeComposer.d2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2lResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#d2f()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#d2f()}
   */
  @Test
  @DisplayName("Test d2f()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.d2f()"
  })
  void testD2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2fResult = compactCodeAttributeComposer.d2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2fResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2b()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2b()}
   */
  @Test
  @DisplayName("Test i2b()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.i2b()"
  })
  void testI2b() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2bResult = compactCodeAttributeComposer.i2b();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2bResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2c()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2c()}
   */
  @Test
  @DisplayName("Test i2c()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.i2c()"
  })
  void testI2c() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2cResult = compactCodeAttributeComposer.i2c();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2cResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2s()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2s()}
   */
  @Test
  @DisplayName("Test i2s()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.i2s()"
  })
  void testI2s() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2sResult = compactCodeAttributeComposer.i2s();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2sResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lcmp()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lcmp()}
   */
  @Test
  @DisplayName("Test lcmp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lcmp()"
  })
  void testLcmp() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLcmpResult = compactCodeAttributeComposer.lcmp();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLcmpResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fcmpl()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fcmpl()}
   */
  @Test
  @DisplayName("Test fcmpl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fcmpl()"
  })
  void testFcmpl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFcmplResult = compactCodeAttributeComposer.fcmpl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFcmplResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fcmpg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fcmpg()}
   */
  @Test
  @DisplayName("Test fcmpg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.fcmpg()"
  })
  void testFcmpg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFcmpgResult = compactCodeAttributeComposer.fcmpg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFcmpgResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dcmpl()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dcmpl()}
   */
  @Test
  @DisplayName("Test dcmpl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dcmpl()"
  })
  void testDcmpl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDcmplResult = compactCodeAttributeComposer.dcmpl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDcmplResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dcmpg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dcmpg()}
   */
  @Test
  @DisplayName("Test dcmpg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dcmpg()"
  })
  void testDcmpg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDcmpgResult = compactCodeAttributeComposer.dcmpg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDcmpgResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifeq(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifeq(Label)}
   */
  @Test
  @DisplayName("Test ifeq(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifeq(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfeq() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfeqResult =
        compactCodeAttributeComposer.ifeq(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfeqResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifne(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifne(Label)}
   */
  @Test
  @DisplayName("Test ifne(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifne(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfneResult =
        compactCodeAttributeComposer.ifne(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfneResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iflt(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iflt(Label)}
   */
  @Test
  @DisplayName("Test iflt(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.iflt(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIflt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfltResult =
        compactCodeAttributeComposer.iflt(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfltResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifge(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifge(Label)}
   */
  @Test
  @DisplayName("Test ifge(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifge(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfge() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfgeResult =
        compactCodeAttributeComposer.ifge(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfgeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifgt(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifgt(Label)}
   */
  @Test
  @DisplayName("Test ifgt(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifgt(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfgt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfgtResult =
        compactCodeAttributeComposer.ifgt(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfgtResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifle(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifle(Label)}
   */
  @Test
  @DisplayName("Test ifle(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifle(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfle() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfleResult =
        compactCodeAttributeComposer.ifle(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfleResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ificmpeq(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ificmpeq(Label)}
   */
  @Test
  @DisplayName("Test ificmpeq(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ificmpeq(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIficmpeq() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIficmpeqResult =
        compactCodeAttributeComposer.ificmpeq(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIficmpeqResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ificmpne(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ificmpne(Label)}
   */
  @Test
  @DisplayName("Test ificmpne(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ificmpne(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIficmpne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIficmpneResult =
        compactCodeAttributeComposer.ificmpne(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIficmpneResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ificmplt(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ificmplt(Label)}
   */
  @Test
  @DisplayName("Test ificmplt(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ificmplt(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIficmplt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIficmpltResult =
        compactCodeAttributeComposer.ificmplt(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIficmpltResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ificmpge(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ificmpge(Label)}
   */
  @Test
  @DisplayName("Test ificmpge(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ificmpge(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIficmpge() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIficmpgeResult =
        compactCodeAttributeComposer.ificmpge(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIficmpgeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ificmpgt(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ificmpgt(Label)}
   */
  @Test
  @DisplayName("Test ificmpgt(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ificmpgt(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIficmpgt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIficmpgtResult =
        compactCodeAttributeComposer.ificmpgt(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIficmpgtResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ificmple(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ificmple(Label)}
   */
  @Test
  @DisplayName("Test ificmple(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ificmple(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIficmple() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIficmpleResult =
        compactCodeAttributeComposer.ificmple(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIficmpleResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifacmpeq(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifacmpeq(Label)}
   */
  @Test
  @DisplayName("Test ifacmpeq(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifacmpeq(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfacmpeq() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfacmpeqResult =
        compactCodeAttributeComposer.ifacmpeq(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfacmpeqResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifacmpne(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifacmpne(Label)}
   */
  @Test
  @DisplayName("Test ifacmpne(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifacmpne(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfacmpne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfacmpneResult =
        compactCodeAttributeComposer.ifacmpne(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfacmpneResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#goto_(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#goto_(Label)}
   */
  @Test
  @DisplayName("Test goto_(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.goto_(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testGoto_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualGoto_Result =
        compactCodeAttributeComposer.goto_(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGoto_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#jsr(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#jsr(Label)}
   */
  @Test
  @DisplayName("Test jsr(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.jsr(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testJsr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualJsrResult =
        compactCodeAttributeComposer.jsr(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualJsrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ret(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ret(int)}
   */
  @Test
  @DisplayName("Test ret(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ret(int)"
  })
  void testRet_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualRetResult = compactCodeAttributeComposer.ret(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualRetResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ret(int)}.
   *
   * <ul>
   *   <li>When twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ret(int)}
   */
  @Test
  @DisplayName("Test ret(int); when twenty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ret(int)"
  })
  void testRet_whenTwentySix() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualRetResult = compactCodeAttributeComposer.ret(26);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualRetResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#tableswitch(Label, int, int, Label[])}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#tableswitch(Label, int, int,
   * Label[])}
   */
  @Test
  @DisplayName("Test tableswitch(Label, int, int, Label[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.tableswitch(proguard.classfile.editor.CompactCodeAttributeComposer$Label, int, int, proguard.classfile.editor.CompactCodeAttributeComposer$Label[])"
  })
  void testTableswitch() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    compactCodeAttributeComposer.appendInstructions(
        new Instruction[] {new BranchInstruction((byte) 'A', -86)});

    // Act
    CompactCodeAttributeComposer actualTableswitchResult =
        compactCodeAttributeComposer.tableswitch(
            mock(Label.class), 1, 1, new Label[] {mock(Label.class)});

    // Assert
    assertEquals(20, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualTableswitchResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#tableswitch(Label, int, int, Label[])}.
   *
   * <ul>
   *   <li>Given {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}
   *       with targetClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#tableswitch(Label, int, int,
   * Label[])}
   */
  @Test
  @DisplayName(
      "Test tableswitch(Label, int, int, Label[]); given CompactCodeAttributeComposer(ProgramClass) with targetClass is ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.tableswitch(proguard.classfile.editor.CompactCodeAttributeComposer$Label, int, int, proguard.classfile.editor.CompactCodeAttributeComposer$Label[])"
  })
  void testTableswitch_givenCompactCodeAttributeComposerWithTargetClassIsProgramClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualTableswitchResult =
        compactCodeAttributeComposer.tableswitch(
            mock(Label.class), 1, 1, new Label[] {mock(Label.class)});

    // Assert
    assertEquals(20, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualTableswitchResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ireturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ireturn()}
   */
  @Test
  @DisplayName("Test ireturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ireturn()"
  })
  void testIreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIreturnResult = compactCodeAttributeComposer.ireturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lreturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lreturn()}
   */
  @Test
  @DisplayName("Test lreturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.lreturn()"
  })
  void testLreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLreturnResult = compactCodeAttributeComposer.lreturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#freturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#freturn()}
   */
  @Test
  @DisplayName("Test freturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.freturn()"
  })
  void testFreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFreturnResult = compactCodeAttributeComposer.freturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dreturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dreturn()}
   */
  @Test
  @DisplayName("Test dreturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.dreturn()"
  })
  void testDreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDreturnResult = compactCodeAttributeComposer.dreturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#areturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#areturn()}
   */
  @Test
  @DisplayName("Test areturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.areturn()"
  })
  void testAreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAreturnResult = compactCodeAttributeComposer.areturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#return_()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#return_()}
   */
  @Test
  @DisplayName("Test return_()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.return_()"
  })
  void testReturn_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result = compactCodeAttributeComposer.return_();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#return_(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code ()I}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#return_(String)}
   */
  @Test
  @DisplayName("Test return_(String) with 'String'; when '()I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.return_(java.lang.String)"
  })
  void testReturn_WithString_whenI() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result = compactCodeAttributeComposer.return_("()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#return_(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#return_(String)}
   */
  @Test
  @DisplayName("Test return_(String) with 'String'; when 'Internal Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.return_(java.lang.String)"
  })
  void testReturn_WithString_whenInternalType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result =
        compactCodeAttributeComposer.return_("Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(String, String, String)}
   */
  @Test
  @DisplayName("Test getstatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetstaticWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(String, String, String)}
   */
  @Test
  @DisplayName("Test getstatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetstaticWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test getstatic(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getstatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetstaticWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test getstatic(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getstatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetstaticWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(int)}
   */
  @Test
  @DisplayName("Test getstatic(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getstatic(int)"
  })
  void testGetstaticWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualGetstaticResult = compactCodeAttributeComposer.getstatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetstaticResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(String, String, String)}
   */
  @Test
  @DisplayName("Test putstatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutstaticWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(String, String, String)}
   */
  @Test
  @DisplayName("Test putstatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutstaticWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test putstatic(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putstatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutstaticWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test putstatic(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putstatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutstaticWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(int)}
   */
  @Test
  @DisplayName("Test putstatic(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putstatic(int)"
  })
  void testPutstaticWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPutstaticResult = compactCodeAttributeComposer.putstatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutstaticResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(String, String, String)}
   */
  @Test
  @DisplayName("Test getfield(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetfieldWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(String, String, String)}
   */
  @Test
  @DisplayName("Test getfield(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetfieldWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test getfield(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getfield(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetfieldWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test getfield(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getfield(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetfieldWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(int)}
   */
  @Test
  @DisplayName("Test getfield(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.getfield(int)"
  })
  void testGetfieldWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualGetfieldResult = compactCodeAttributeComposer.getfield(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetfieldResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(String, String, String)}
   */
  @Test
  @DisplayName("Test putfield(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutfieldWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(String, String, String)}
   */
  @Test
  @DisplayName("Test putfield(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutfieldWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test putfield(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putfield(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutfieldWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test putfield(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putfield(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutfieldWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(int)}
   */
  @Test
  @DisplayName("Test putfield(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.putfield(int)"
  })
  void testPutfieldWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPutfieldResult = compactCodeAttributeComposer.putfield(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutfieldResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(String, String,
   * String)}
   */
  @Test
  @DisplayName("Test invokevirtual(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokevirtual(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokevirtual("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(String, String,
   * String)}
   */
  @Test
  @DisplayName("Test invokevirtual(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokevirtual(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokevirtual("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokevirtual(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokevirtual(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokevirtualWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokevirtual(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokevirtual(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokevirtual(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokevirtualWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokevirtual(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(int)}
   */
  @Test
  @DisplayName("Test invokevirtual(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokevirtual(int)"
  })
  void testInvokevirtualWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokevirtualResult =
        compactCodeAttributeComposer.invokevirtual(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokevirtualResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(String, String,
   * String)}
   */
  @Test
  @DisplayName("Test invokespecial(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokespecial(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecialWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokespecial("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(String, String,
   * String)}
   */
  @Test
  @DisplayName("Test invokespecial(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokespecial(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecialWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokespecial("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokespecial(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokespecial(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokespecialWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokespecial(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokespecial(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokespecial(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokespecialWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokespecial(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(int)}
   */
  @Test
  @DisplayName("Test invokespecial(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokespecial(int)"
  })
  void testInvokespecialWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokespecialResult =
        compactCodeAttributeComposer.invokespecial(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokespecialResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(String, String, String)}
   */
  @Test
  @DisplayName("Test invokestatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestaticWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(String, String, String)}
   */
  @Test
  @DisplayName("Test invokestatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestaticWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestaticWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestaticWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(int)}
   */
  @Test
  @DisplayName("Test invokestatic(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic(int)"
  })
  void testInvokestaticWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokestaticResult =
        compactCodeAttributeComposer.invokestatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestaticResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic_interface(String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic_interface(String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic_interface(String,
   * String, String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic_interface(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic_interface(String,
   * String, String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic_interface(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokeinterface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokeinterface("Class Name", "Name", "()I"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokeinterface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokeinterface("Class Name", "Name", "()I"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokeinterface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokeinterface(
            "Class Name",
            "Name",
            "()I",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokeinterface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokeinterface(
            "Class Name",
            "Name",
            "()I",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(int, int)} with {@code constantIndex},
   * {@code constant}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(int, int)}
   */
  @Test
  @DisplayName("Test invokeinterface(int, int) with 'constantIndex', 'constant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokeinterface(int, int)"
  })
  void testInvokeinterfaceWithConstantIndexConstant() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult =
        compactCodeAttributeComposer.invokeinterface(1, 1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(int, int)} with {@code constantIndex},
   * {@code constant}.
   *
   * <ul>
   *   <li>When {@link ClassEstimates#TYPICAL_CODE_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(int, int)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(int, int) with 'constantIndex', 'constant'; when TYPICAL_CODE_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokeinterface(int, int)"
  })
  void testInvokeinterfaceWithConstantIndexConstant_whenTypical_code_length() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult =
        compactCodeAttributeComposer.invokeinterface(ClassEstimates.TYPICAL_CODE_LENGTH, 1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokedynamic(int, String, String, Clazz[])} with
   * {@code bootStrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String, Clazz[]) with 'bootStrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokedynamic(int, java.lang.String, java.lang.String, proguard.classfile.Clazz[])"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokedynamic(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokedynamic(int, String, String, Clazz[])} with
   * {@code bootStrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String, Clazz[]) with 'bootStrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokedynamic(int, java.lang.String, java.lang.String, proguard.classfile.Clazz[])"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokedynamic(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokedynamic(int)} with {@code constantIndex}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int)}
   */
  @Test
  @DisplayName("Test invokedynamic(int) with 'constantIndex'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokedynamic(int)"
  })
  void testInvokedynamicWithConstantIndex_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokedynamicResult =
        compactCodeAttributeComposer.invokedynamic(1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokedynamicResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokedynamic(int)} with {@code constantIndex}.
   *
   * <ul>
   *   <li>When {@link ClassEstimates#TYPICAL_CODE_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int)}
   */
  @Test
  @DisplayName("Test invokedynamic(int) with 'constantIndex'; when TYPICAL_CODE_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.invokedynamic(int)"
  })
  void testInvokedynamicWithConstantIndex_whenTypical_code_length() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokedynamicResult =
        compactCodeAttributeComposer.invokedynamic(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokedynamicResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(String)} with {@code className}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(String)}
   */
  @Test
  @DisplayName("Test new_(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.new_(java.lang.String)"
  })
  void testNew_WithClassName() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.new_("Class Name"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(String)} with {@code className}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(String)}
   */
  @Test
  @DisplayName("Test new_(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.new_(java.lang.String)"
  })
  void testNew_WithClassName2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.new_("Class Name"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(String, Clazz)} with {@code className}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(String, Clazz)}
   */
  @Test
  @DisplayName("Test new_(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.new_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testNew_WithClassNameReferencedClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.new_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(String, Clazz)} with {@code className}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(String, Clazz)}
   */
  @Test
  @DisplayName("Test new_(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.new_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testNew_WithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.new_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(Clazz)}
   */
  @Test
  @DisplayName("Test new_(Clazz) with 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.new_(proguard.classfile.Clazz)"
  })
  void testNew_WithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    CompactCodeAttributeComposer actualNew_Result =
        compactCodeAttributeComposer.new_(new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(int)}
   */
  @Test
  @DisplayName("Test new_(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.new_(int)"
  })
  void testNew_WithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNew_Result = compactCodeAttributeComposer.new_(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#newarray(int)}.
   *
   * <ul>
   *   <li>When minus sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  @DisplayName("Test newarray(int); when minus sixty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.newarray(int)"
  })
  void testNewarray_whenMinusSixtyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(-68);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#newarray(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  @DisplayName("Test newarray(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.newarray(int)"
  })
  void testNewarray_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#newarray(int)}.
   *
   * <ul>
   *   <li>When six.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  @DisplayName("Test newarray(int); when six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.newarray(int)"
  })
  void testNewarray_whenSix() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(6);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#anewarray(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#anewarray(String, Clazz)}
   */
  @Test
  @DisplayName("Test anewarray(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.anewarray(java.lang.String, proguard.classfile.Clazz)"
  })
  void testAnewarrayWithClassNameReferencedClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.anewarray("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#anewarray(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#anewarray(String, Clazz)}
   */
  @Test
  @DisplayName("Test anewarray(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.anewarray(java.lang.String, proguard.classfile.Clazz)"
  })
  void testAnewarrayWithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.anewarray("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#anewarray(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#anewarray(int)}
   */
  @Test
  @DisplayName("Test anewarray(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.anewarray(int)"
  })
  void testAnewarrayWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAnewarrayResult = compactCodeAttributeComposer.anewarray(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAnewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#arraylength()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#arraylength()}
   */
  @Test
  @DisplayName("Test arraylength()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.arraylength()"
  })
  void testArraylength() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualArraylengthResult =
        compactCodeAttributeComposer.arraylength();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualArraylengthResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#athrow()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#athrow()}
   */
  @Test
  @DisplayName("Test athrow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.athrow()"
  })
  void testAthrow() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAthrowResult = compactCodeAttributeComposer.athrow();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAthrowResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(String)} with {@code className}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(String)}
   */
  @Test
  @DisplayName("Test checkcast(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.checkcast(java.lang.String)"
  })
  void testCheckcastWithClassName() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.checkcast("Class Name"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(String)} with {@code className}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(String)}
   */
  @Test
  @DisplayName("Test checkcast(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.checkcast(java.lang.String)"
  })
  void testCheckcastWithClassName2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.checkcast("Class Name"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(String, Clazz)}
   */
  @Test
  @DisplayName("Test checkcast(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.checkcast(java.lang.String, proguard.classfile.Clazz)"
  })
  void testCheckcastWithClassNameReferencedClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.checkcast("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(String, Clazz)}
   */
  @Test
  @DisplayName("Test checkcast(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.checkcast(java.lang.String, proguard.classfile.Clazz)"
  })
  void testCheckcastWithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.checkcast("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(int)}
   */
  @Test
  @DisplayName("Test checkcast(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.checkcast(int)"
  })
  void testCheckcastWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCheckcastResult = compactCodeAttributeComposer.checkcast(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCheckcastResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceof_(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.instanceof_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceof_WithClassNameReferencedClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.instanceof_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceof_(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.instanceof_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceof_WithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.instanceof_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#instanceof_(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#instanceof_(int)}
   */
  @Test
  @DisplayName("Test instanceof_(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.instanceof_(int)"
  })
  void testInstanceof_WithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInstanceof_Result =
        compactCodeAttributeComposer.instanceof_(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInstanceof_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#monitorenter()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#monitorenter()}
   */
  @Test
  @DisplayName("Test monitorenter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.monitorenter()"
  })
  void testMonitorenter() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMonitorenterResult =
        compactCodeAttributeComposer.monitorenter();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMonitorenterResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#monitorexit()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#monitorexit()}
   */
  @Test
  @DisplayName("Test monitorexit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.monitorexit()"
  })
  void testMonitorexit() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMonitorexitResult =
        compactCodeAttributeComposer.monitorexit();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMonitorexitResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#wide()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#wide()}
   */
  @Test
  @DisplayName("Test wide()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.wide()"
  })
  void testWide() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualWideResult = compactCodeAttributeComposer.wide();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualWideResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)} with {@code
   * className}, {@code referencedClass}, {@code dimensions}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test multianewarray(String, Clazz, int) with 'className', 'referencedClass', 'dimensions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.multianewarray(java.lang.String, proguard.classfile.Clazz, int)"
  })
  void testMultianewarrayWithClassNameReferencedClassDimensions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.multianewarray("Class Name", new LibraryClass(), 1));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)} with {@code
   * className}, {@code referencedClass}, {@code dimensions}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test multianewarray(String, Clazz, int) with 'className', 'referencedClass', 'dimensions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.multianewarray(java.lang.String, proguard.classfile.Clazz, int)"
  })
  void testMultianewarrayWithClassNameReferencedClassDimensions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.multianewarray("Class Name", new LibraryClass(), 1));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#multianewarray(int, int)} with {@code constantIndex},
   * {@code dimensions}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#multianewarray(int, int)}
   */
  @Test
  @DisplayName("Test multianewarray(int, int) with 'constantIndex', 'dimensions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.multianewarray(int, int)"
  })
  void testMultianewarrayWithConstantIndexDimensions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMultianewarrayResult =
        compactCodeAttributeComposer.multianewarray(1, 1);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMultianewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#multianewarray(int, int)} with {@code constantIndex},
   * {@code dimensions}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#multianewarray(int, int)}
   */
  @Test
  @DisplayName("Test multianewarray(int, int) with 'constantIndex', 'dimensions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.multianewarray(int, int)"
  })
  void testMultianewarrayWithConstantIndexDimensions2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMultianewarrayResult =
        compactCodeAttributeComposer.multianewarray(ClassEstimates.TYPICAL_CODE_LENGTH, 1);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMultianewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifnull(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifnull(Label)}
   */
  @Test
  @DisplayName("Test ifnull(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifnull(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfnull() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfnullResult =
        compactCodeAttributeComposer.ifnull(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfnullResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ifnonnull(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ifnonnull(Label)}
   */
  @Test
  @DisplayName("Test ifnonnull(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.ifnonnull(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testIfnonnull() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIfnonnullResult =
        compactCodeAttributeComposer.ifnonnull(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIfnonnullResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#goto_w(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#goto_w(Label)}
   */
  @Test
  @DisplayName("Test goto_w(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.goto_w(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testGoto_w() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualGoto_wResult =
        compactCodeAttributeComposer.goto_w(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGoto_wResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#jsr_w(Label)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#jsr_w(Label)}
   */
  @Test
  @DisplayName("Test jsr_w(Label)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.jsr_w(proguard.classfile.editor.CompactCodeAttributeComposer$Label)"
  })
  void testJsr_w() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualJsr_wResult =
        compactCodeAttributeComposer.jsr_w(mock(Label.class));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualJsr_wResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushPrimitive(Object, char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushPrimitive(Object, char)}
   */
  @Test
  @DisplayName("Test pushPrimitive(Object, char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushPrimitive(java.lang.Object, char)"
  })
  void testPushPrimitive() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            (new CompactCodeAttributeComposer(new ProgramClass())).pushPrimitive("Primitive", 'A'));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenFive() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(5);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenFortyTwo() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenFour() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(4);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenMinusOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(-1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenMinusOneHundredTwentyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenThree() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(3);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenTwo() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(2);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushInt(int)"
  })
  void testPushInt_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushFloat(float)"
  })
  void testPushFloat() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.pushFloat(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushFloat(float)"
  })
  void testPushFloat2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 0, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.pushFloat(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <ul>
   *   <li>Then fourth element return {@link FloatConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float); then fourth element return FloatConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushFloat(float)"
  })
  void testPushFloat_thenFourthElementReturnFloatConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();

    // Act
    CompactCodeAttributeComposer actualPushFloatResult =
        (new CompactCodeAttributeComposer(
                new ProgramClass(
                    1, 3, new Constant[] {classConstant, classConstant2, classConstant3}, 1, 1, 1)))
            .pushFloat(10.0f);

    // Assert
    ProgramClass targetClass = actualPushFloatResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[3];
    assertTrue(constant instanceof FloatConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(targetClass.getSuperClass());
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(10.0f, ((FloatConstant) constant).getValue());
    assertEquals(19, constantArray.length);
    assertEquals(4, constant.getTag());
    assertEquals(4, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertSame(classConstant2, constantArray[1]);
    assertSame(classConstant3, constantArray[2]);
    assertSame(targetClass, actualPushFloatResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushFloat(float)"
  })
  void testPushFloat_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult =
        compactCodeAttributeComposer.pushFloat(1.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushFloatResult.getCodeLength());
    ProgramClass targetClass = actualPushFloatResult.getTargetClass();
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(targetClass, actualPushFloatResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float); when two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushFloat(float)"
  })
  void testPushFloat_whenTwo() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult =
        compactCodeAttributeComposer.pushFloat(2.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushFloatResult.getCodeLength());
    ProgramClass targetClass = actualPushFloatResult.getTargetClass();
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(targetClass, actualPushFloatResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushFloat(float)"
  })
  void testPushFloat_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult =
        compactCodeAttributeComposer.pushFloat(0.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushFloatResult.getCodeLength());
    ProgramClass targetClass = actualPushFloatResult.getTargetClass();
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(targetClass, actualPushFloatResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushLong(long)}.
   *
   * <ul>
   *   <li>Then fourth element return {@link LongConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  @DisplayName("Test pushLong(long); then fourth element return LongConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushLong(long)"
  })
  void testPushLong_thenFourthElementReturnLongConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();

    // Act
    CompactCodeAttributeComposer actualPushLongResult =
        (new CompactCodeAttributeComposer(
                new ProgramClass(
                    42,
                    3,
                    new Constant[] {classConstant, classConstant2, classConstant3},
                    42,
                    42,
                    42)))
            .pushLong(42L);

    // Assert
    ProgramClass targetClass = actualPushLongResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[3];
    assertTrue(constant instanceof LongConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(19, constantArray.length);
    assertEquals(42L, ((LongConstant) constant).getValue());
    assertEquals(5, constant.getTag());
    assertEquals(5, targetClass.u2constantPoolCount);
    assertTrue(constant.isCategory2());
    assertSame(classConstant2, constantArray[1]);
    assertSame(classConstant3, constantArray[2]);
    assertSame(targetClass, actualPushLongResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushLong(long)}.
   *
   * <ul>
   *   <li>Then return {@link
   *       CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)} with targetClass
   *       is {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  @DisplayName(
      "Test pushLong(long); then return CompactCodeAttributeComposer(ProgramClass) with targetClass is ProgramClass(int, int, Constant[], int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushLong(long)"
  })
  void testPushLong_thenReturnCompactCodeAttributeComposerWithTargetClassIsProgramClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(42, 1, new Constant[] {new ClassConstant()}, 42, 42, 42));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.pushLong(42L));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushLong(long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  @DisplayName("Test pushLong(long); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushLong(long)"
  })
  void testPushLong_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(42, 3, new Constant[] {new ClassConstant()}, 42, 42, 42));

    // Act
    CompactCodeAttributeComposer actualPushLongResult = compactCodeAttributeComposer.pushLong(1L);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushLongResult.getCodeLength());
    ProgramClass targetClass = actualPushLongResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertSame(targetClass, actualPushLongResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushLong(long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  @DisplayName("Test pushLong(long); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushLong(long)"
  })
  void testPushLong_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(42, 3, new Constant[] {new ClassConstant()}, 42, 42, 42));

    // Act
    CompactCodeAttributeComposer actualPushLongResult = compactCodeAttributeComposer.pushLong(0L);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushLongResult.getCodeLength());
    ProgramClass targetClass = actualPushLongResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertSame(targetClass, actualPushLongResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushDouble(double)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  @DisplayName("Test pushDouble(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushDouble(double)"
  })
  void testPushDouble() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.pushDouble(10.0d));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushDouble(double)}.
   *
   * <ul>
   *   <li>Then fourth element return {@link DoubleConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  @DisplayName("Test pushDouble(double); then fourth element return DoubleConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushDouble(double)"
  })
  void testPushDouble_thenFourthElementReturnDoubleConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult =
        (new CompactCodeAttributeComposer(
                new ProgramClass(
                    1, 3, new Constant[] {classConstant, classConstant2, classConstant3}, 1, 1, 1)))
            .pushDouble(10.0d);

    // Assert
    ProgramClass targetClass = actualPushDoubleResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[3];
    assertTrue(constant instanceof DoubleConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(targetClass.getSuperClass());
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(10.0d, ((DoubleConstant) constant).getValue());
    assertEquals(19, constantArray.length);
    assertEquals(5, targetClass.u2constantPoolCount);
    assertEquals(6, constant.getTag());
    assertTrue(constant.isCategory2());
    assertSame(classConstant2, constantArray[1]);
    assertSame(classConstant3, constantArray[2]);
    assertSame(targetClass, actualPushDoubleResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushDouble(double)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  @DisplayName("Test pushDouble(double); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushDouble(double)"
  })
  void testPushDouble_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult =
        compactCodeAttributeComposer.pushDouble(1.0d);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushDoubleResult.getCodeLength());
    ProgramClass targetClass = actualPushDoubleResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertSame(targetClass, actualPushDoubleResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushDouble(double)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  @DisplayName("Test pushDouble(double); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushDouble(double)"
  })
  void testPushDouble_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult =
        compactCodeAttributeComposer.pushDouble(0.0d);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushDoubleResult.getCodeLength());
    ProgramClass targetClass = actualPushDoubleResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertSame(targetClass, actualPushDoubleResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushNewArray(String, int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushNewArray(String, int)}
   */
  @Test
  @DisplayName("Test pushNewArray(String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(-1, 1, new Constant[] {new ClassConstant()}, -1, -1, -1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.pushNewArray("Element Type Or Class Name", 3));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushNewArray(String, int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushNewArray(String, int)}
   */
  @Test
  @DisplayName("Test pushNewArray(String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                -1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                -1,
                -1,
                -1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.pushNewArray("Element Type Or Class Name", 3));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, char)"
  })
  void testLoadWithIntChar() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(66, 'A');

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, char)"
  })
  void testLoadWithIntChar_whenA() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'A');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, char)"
  })
  void testLoadWithIntChar_whenB() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, char)"
  })
  void testLoadWithIntChar_whenD() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, char)"
  })
  void testLoadWithIntChar_whenF() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, char)"
  })
  void testLoadWithIntChar_whenJ() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  @DisplayName("Test load(int, String) with 'int', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, java.lang.String)"
  })
  void testLoadWithIntString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult =
        compactCodeAttributeComposer.load(1, "Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  @DisplayName("Test load(int, String) with 'int', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, java.lang.String)"
  })
  void testLoadWithIntString2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult =
        compactCodeAttributeComposer.load(66, "Internal Type");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When {@code ()I}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  @DisplayName("Test load(int, String) with 'int', 'String'; when '()I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.load(int, java.lang.String)"
  })
  void testLoadWithIntString_whenI() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, "()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, char)"
  })
  void testStoreWithIntChar() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(66, 'A');

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, char)"
  })
  void testStoreWithIntChar_whenA() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'A');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, char)"
  })
  void testStoreWithIntChar_whenB() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, char)"
  })
  void testStoreWithIntChar_whenD() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, char)"
  })
  void testStoreWithIntChar_whenF() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, char)"
  })
  void testStoreWithIntChar_whenJ() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  @DisplayName("Test store(int, String) with 'int', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, java.lang.String)"
  })
  void testStoreWithIntString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult =
        compactCodeAttributeComposer.store(1, "Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  @DisplayName("Test store(int, String) with 'int', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, java.lang.String)"
  })
  void testStoreWithIntString2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult =
        compactCodeAttributeComposer.store(66, "Internal Type");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When {@code ()I}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  @DisplayName("Test store(int, String) with 'int', 'String'; when '()I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.store(int, java.lang.String)"
  })
  void testStoreWithIntString_whenI() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, "()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#storeToArray(String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#storeToArray(String)}
   */
  @Test
  @DisplayName("Test storeToArray(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.storeToArray(java.lang.String)"
  })
  void testStoreToArray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreToArrayResult =
        compactCodeAttributeComposer.storeToArray("Element Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreToArrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintIntegerInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintIntegerInstructions()"
  })
  void testAppendPrintIntegerInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintIntegerInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintIntegerInstructions()"
  })
  void testAppendPrintIntegerInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintIntegerInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintIntegerInstructions(java.lang.String)"
  })
  void testAppendPrintIntegerInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintIntegerInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintIntegerInstructions(java.lang.String)"
  })
  void testAppendPrintIntegerInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintIntegerHexInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintIntegerHexInstructions()"
  })
  void testAppendPrintIntegerHexInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerHexInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintIntegerHexInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintIntegerHexInstructions()"
  })
  void testAppendPrintIntegerHexInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerHexInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintIntegerHexInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintIntegerHexInstructions(java.lang.String)"
  })
  void testAppendPrintIntegerHexInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerHexInstructions("0123456789ABCDEF"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintIntegerHexInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintIntegerHexInstructions(java.lang.String)"
  })
  void testAppendPrintIntegerHexInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerHexInstructions("0123456789ABCDEF"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintLongInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintLongInstructions()"
  })
  void testAppendPrintLongInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(92, 1, new Constant[] {new ClassConstant()}, 92, 92, 92));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintLongInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintLongInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintLongInstructions()"
  })
  void testAppendPrintLongInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                92,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                92,
                92,
                92));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintLongInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintLongInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintLongInstructions(java.lang.String)"
  })
  void testAppendPrintLongInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintLongInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintLongInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintLongInstructions(java.lang.String)"
  })
  void testAppendPrintLongInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintLongInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintStringInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintStringInstructions()"
  })
  void testAppendPrintStringInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintStringInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintStringInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintStringInstructions()"
  })
  void testAppendPrintStringInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintStringInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStringInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintStringInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintStringInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintStringInstructions(java.lang.String)"
  })
  void testAppendPrintStringInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStringInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStringInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintStringInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintStringInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintStringInstructions(java.lang.String)"
  })
  void testAppendPrintStringInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStringInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintObjectInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintObjectInstructions()"
  })
  void testAppendPrintObjectInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintObjectInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintObjectInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintObjectInstructions()"
  })
  void testAppendPrintObjectInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintObjectInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintObjectInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintObjectInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintObjectInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintObjectInstructions(java.lang.String)"
  })
  void testAppendPrintObjectInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintObjectInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintObjectInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintObjectInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintObjectInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintObjectInstructions(java.lang.String)"
  })
  void testAppendPrintObjectInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintObjectInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintStackTraceInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintStackTraceInstructions()"
  })
  void testAppendPrintStackTraceInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStackTraceInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}
   */
  @Test
  @DisplayName("Test appendPrintStackTraceInstructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintStackTraceInstructions()"
  })
  void testAppendPrintStackTraceInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStackTraceInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintStackTraceInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintStackTraceInstructions(java.lang.String)"
  })
  void testAppendPrintStackTraceInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStackTraceInstructions(
            "Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintStackTraceInstructions(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintStackTraceInstructions(java.lang.String)"
  })
  void testAppendPrintStackTraceInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStackTraceInstructions(
            "Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintInstructions(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintInstructions(java.lang.String)"
  })
  void testAppendPrintInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}
   */
  @Test
  @DisplayName("Test appendPrintInstructions(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CompactCodeAttributeComposer proguard.classfile.editor.CompactCodeAttributeComposer.appendPrintInstructions(java.lang.String)"
  })
  void testAppendPrintInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintInstructions("Not all who wander are lost"));
  }
}

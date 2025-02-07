package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantCounter;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFile;

class InstructionSequenceBuilderDiffblueTest {
  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}
   */
  @Test
  @DisplayName("Test new InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.InstructionSequenceBuilder.<init>()"})
  void testNewInstructionSequenceBuilder() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).size());
  }

  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ConstantPoolEditor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceBuilder#InstructionSequenceBuilder(ConstantPoolEditor)}
   */
  @Test
  @DisplayName("Test new InstructionSequenceBuilder(ConstantPoolEditor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceBuilder.<init>(proguard.classfile.editor.ConstantPoolEditor)"
  })
  void testNewInstructionSequenceBuilder2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder =
        new InstructionSequenceBuilder(constantPoolEditor);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    ConstantPoolEditor constantPoolEditor2 =
        actualInstructionSequenceBuilder.getConstantPoolEditor();
    assertSame(targetClass, constantPoolEditor2.getTargetClass());
    assertSame(constantPoolEditor, constantPoolEditor2);
  }

  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName("Test new InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool); given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceBuilder.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewInstructionSequenceBuilder_givenOne() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder =
        new InstructionSequenceBuilder(targetClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(
        targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass)}
   */
  @Test
  @DisplayName("Test new InstructionSequenceBuilder(ProgramClass); given two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceBuilder.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewInstructionSequenceBuilder_givenTwo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder =
        new InstructionSequenceBuilder(targetClass);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(
        targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName("Test new InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool); given two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceBuilder.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewInstructionSequenceBuilder_givenTwo2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder =
        new InstructionSequenceBuilder(targetClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(
        targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>When {@link KotlinConstants#dummyClassPool}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ClassPool,
   * ClassPool)}
   */
  @Test
  @DisplayName("Test new InstructionSequenceBuilder(ClassPool, ClassPool); when dummyClassPool")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceBuilder.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewInstructionSequenceBuilder_whenDummyClassPool() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new InstructionSequenceBuilder(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .size());
  }

  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ClassPool,
   * ClassPool)}
   */
  @Test
  @DisplayName("Test new InstructionSequenceBuilder(ClassPool, ClassPool); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceBuilder.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewInstructionSequenceBuilder_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder(null, KotlinConstants.dummyClassPool)).size());
  }

  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass)}
   */
  @Test
  @DisplayName("Test new InstructionSequenceBuilder(ProgramClass); when ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceBuilder.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewInstructionSequenceBuilder_whenProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder =
        new InstructionSequenceBuilder(targetClass);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(
        targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool); when ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceBuilder.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewInstructionSequenceBuilder_whenProgramClass2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder =
        new InstructionSequenceBuilder(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(
        targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link InstructionSequenceBuilder#getConstantPoolEditor()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getConstantPoolEditor()}
   */
  @Test
  @DisplayName("Test getConstantPoolEditor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ConstantPoolEditor proguard.classfile.editor.InstructionSequenceBuilder.getConstantPoolEditor()"
  })
  void testGetConstantPoolEditor() {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder()).getConstantPoolEditor().getTargetClass();
    assertNull(targetClass.getProcessingInfo());
    assertNull(targetClass.getName());
    assertNull(targetClass.getSuperName());
    assertNull(targetClass.getFeatureName());
    assertNull(targetClass.getSuperClass());
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[0]);
    assertNull(constantArray[1]);
    assertNull(constantArray[10]);
    assertNull(constantArray[11]);
    assertNull(constantArray[12]);
    assertNull(constantArray[13]);
    assertNull(constantArray[14]);
    assertNull(constantArray[15]);
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertNull(constantArray[19]);
    assertNull(constantArray[2]);
    assertNull(constantArray[20]);
    assertNull(constantArray[21]);
    assertNull(constantArray[22]);
    assertNull(constantArray[23]);
    assertNull(constantArray[231]);
    assertNull(constantArray[232]);
    assertNull(constantArray[233]);
    assertNull(constantArray[234]);
    assertNull(constantArray[235]);
    assertNull(constantArray[236]);
    assertNull(constantArray[237]);
    assertNull(constantArray[238]);
    assertNull(constantArray[239]);
    assertNull(constantArray[24]);
    assertNull(constantArray[240]);
    assertNull(constantArray[241]);
    assertNull(constantArray[242]);
    assertNull(constantArray[243]);
    assertNull(constantArray[244]);
    assertNull(constantArray[245]);
    assertNull(constantArray[246]);
    assertNull(constantArray[247]);
    assertNull(constantArray[248]);
    assertNull(constantArray[249]);
    assertNull(constantArray[250]);
    assertNull(constantArray[251]);
    assertNull(constantArray[252]);
    assertNull(constantArray[253]);
    assertNull(constantArray[254]);
    assertNull(constantArray[255]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertNull(constantArray[9]);
    assertNull(constantArray[ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE]);
    assertNull(targetClass.kotlinMetadata);
    assertEquals(0, targetClass.getAccessFlags());
    assertEquals(0, targetClass.getInterfaceCount());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, targetClass.attributes.length);
    assertEquals(0, targetClass.fields.length);
    assertEquals(0, targetClass.methods.length);
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, targetClass.subClassCount);
    assertEquals(0, targetClass.u2attributesCount);
    assertEquals(0, targetClass.u2fieldsCount);
    assertEquals(0, targetClass.u2methodsCount);
    assertEquals(0, targetClass.u2superClass);
    assertEquals(0, targetClass.u2thisClass);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(2949123, targetClass.u4version);
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals(new int[] {}, targetClass.u2interfaces);
  }

  /**
   * Test {@link InstructionSequenceBuilder#label(Instruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#label(Instruction)}
   */
  @Test
  @DisplayName("Test label(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.label(proguard.classfile.instruction.Instruction)"
  })
  void testLabel() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLabelResult =
        instructionSequenceBuilder.label(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLabelResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#catch_(Instruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#catch_(Instruction)}
   */
  @Test
  @DisplayName("Test catch_(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.catch_(proguard.classfile.instruction.Instruction)"
  })
  void testCatch_() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCatch_Result =
        instructionSequenceBuilder.catch_(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCatch_Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#line(Instruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#line(Instruction)}
   */
  @Test
  @DisplayName("Test line(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.line(proguard.classfile.instruction.Instruction)"
  })
  void testLine() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLineResult =
        instructionSequenceBuilder.line(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLineResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#appendInstruction(Instruction)}
   */
  @Test
  @DisplayName("Test appendInstruction(Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstruction() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAppendInstructionResult =
        instructionSequenceBuilder.appendInstruction(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAppendInstructionResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAppendInstructionsResult =
        instructionSequenceBuilder.appendInstructions(
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAppendInstructionsResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#__()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#__()}
   */
  @Test
  @DisplayName("Test __()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction[] proguard.classfile.editor.InstructionSequenceBuilder.__()"
  })
  void test__() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).__().length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#instructions()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#instructions()}
   */
  @Test
  @DisplayName("Test instructions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction[] proguard.classfile.editor.InstructionSequenceBuilder.instructions()"
  })
  void testInstructions() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).instructions().length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#constants()}.
   *
   * <ul>
   *   <li>Given {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#constants()}
   */
  @Test
  @DisplayName(
      "Test constants(); given InstructionSequenceBuilder(); then return first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.constant.Constant[] proguard.classfile.editor.InstructionSequenceBuilder.constants()"
  })
  void testConstants_givenInstructionSequenceBuilder_thenReturnFirstElementIsNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    Constant[] actualConstantsResult = instructionSequenceBuilder.constants();

    // Assert
    assertNull(actualConstantsResult[0]);
    assertEquals(
        0, instructionSequenceBuilder.getConstantPoolEditor().getTargetClass().u2constantPoolCount);
    assertEquals(1, actualConstantsResult.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#size()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.editor.InstructionSequenceBuilder.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).size());
  }

  /**
   * Test {@link InstructionSequenceBuilder#nop()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#nop()}
   */
  @Test
  @DisplayName("Test nop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.nop()"
  })
  void testNop() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualNopResult = instructionSequenceBuilder.nop();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNopResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aconst_null()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aconst_null()}
   */
  @Test
  @DisplayName("Test aconst_null()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aconst_null()"
  })
  void testAconst_null() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAconst_nullResult = instructionSequenceBuilder.aconst_null();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAconst_nullResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst(int)}.
   *
   * <ul>
   *   <li>When minus two.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst(int)}
   */
  @Test
  @DisplayName("Test iconst(int); when minus two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst(int)"
  })
  void testIconst_whenMinusTwo() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconstResult = instructionSequenceBuilder.iconst(-2);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst(int)}
   */
  @Test
  @DisplayName("Test iconst(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst(int)"
  })
  void testIconst_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconstResult = instructionSequenceBuilder.iconst(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst(int)}.
   *
   * <ul>
   *   <li>When six.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst(int)}
   */
  @Test
  @DisplayName("Test iconst(int); when six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst(int)"
  })
  void testIconst_whenSix() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconstResult = instructionSequenceBuilder.iconst(6);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst_m1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst_m1()}
   */
  @Test
  @DisplayName("Test iconst_m1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst_m1()"
  })
  void testIconst_m1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconst_m1Result = instructionSequenceBuilder.iconst_m1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconst_m1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst_0()}
   */
  @Test
  @DisplayName("Test iconst_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst_0()"
  })
  void testIconst_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconst_0Result = instructionSequenceBuilder.iconst_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconst_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst_1()}
   */
  @Test
  @DisplayName("Test iconst_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst_1()"
  })
  void testIconst_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconst_1Result = instructionSequenceBuilder.iconst_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconst_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst_2()}
   */
  @Test
  @DisplayName("Test iconst_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst_2()"
  })
  void testIconst_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconst_2Result = instructionSequenceBuilder.iconst_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconst_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst_3()}
   */
  @Test
  @DisplayName("Test iconst_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst_3()"
  })
  void testIconst_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconst_3Result = instructionSequenceBuilder.iconst_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconst_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst_4()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst_4()}
   */
  @Test
  @DisplayName("Test iconst_4()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst_4()"
  })
  void testIconst_4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconst_4Result = instructionSequenceBuilder.iconst_4();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconst_4Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iconst_5()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iconst_5()}
   */
  @Test
  @DisplayName("Test iconst_5()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iconst_5()"
  })
  void testIconst_5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconst_5Result = instructionSequenceBuilder.iconst_5();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconst_5Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lconst(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lconst(int)}
   */
  @Test
  @DisplayName("Test lconst(int); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lconst(int)"
  })
  void testLconst_whenMinusOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLconstResult = instructionSequenceBuilder.lconst(-1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lconst(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lconst(int)}
   */
  @Test
  @DisplayName("Test lconst(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lconst(int)"
  })
  void testLconst_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLconstResult = instructionSequenceBuilder.lconst(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lconst(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lconst(int)}
   */
  @Test
  @DisplayName("Test lconst(int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lconst(int)"
  })
  void testLconst_whenZero() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLconstResult = instructionSequenceBuilder.lconst(0);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lconst_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lconst_0()}
   */
  @Test
  @DisplayName("Test lconst_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lconst_0()"
  })
  void testLconst_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLconst_0Result = instructionSequenceBuilder.lconst_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLconst_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lconst_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lconst_1()}
   */
  @Test
  @DisplayName("Test lconst_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lconst_1()"
  })
  void testLconst_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLconst_1Result = instructionSequenceBuilder.lconst_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLconst_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fconst(int)}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fconst(int)}
   */
  @Test
  @DisplayName("Test fconst(int); when five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fconst(int)"
  })
  void testFconst_whenFive() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconstResult = instructionSequenceBuilder.fconst(5);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fconst(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fconst(int)}
   */
  @Test
  @DisplayName("Test fconst(int); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fconst(int)"
  })
  void testFconst_whenMinusOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconstResult = instructionSequenceBuilder.fconst(-1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fconst(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fconst(int)}
   */
  @Test
  @DisplayName("Test fconst(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fconst(int)"
  })
  void testFconst_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconstResult = instructionSequenceBuilder.fconst(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fconst_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fconst_0()}
   */
  @Test
  @DisplayName("Test fconst_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fconst_0()"
  })
  void testFconst_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconst_0Result = instructionSequenceBuilder.fconst_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconst_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fconst_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fconst_1()}
   */
  @Test
  @DisplayName("Test fconst_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fconst_1()"
  })
  void testFconst_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconst_1Result = instructionSequenceBuilder.fconst_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconst_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fconst_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fconst_2()}
   */
  @Test
  @DisplayName("Test fconst_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fconst_2()"
  })
  void testFconst_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconst_2Result = instructionSequenceBuilder.fconst_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconst_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dconst(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dconst(int)}
   */
  @Test
  @DisplayName("Test dconst(int); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dconst(int)"
  })
  void testDconst_whenMinusOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDconstResult = instructionSequenceBuilder.dconst(-1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dconst(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dconst(int)}
   */
  @Test
  @DisplayName("Test dconst(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dconst(int)"
  })
  void testDconst_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDconstResult = instructionSequenceBuilder.dconst(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dconst(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dconst(int)}
   */
  @Test
  @DisplayName("Test dconst(int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dconst(int)"
  })
  void testDconst_whenZero() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDconstResult = instructionSequenceBuilder.dconst(0);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDconstResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dconst_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dconst_0()}
   */
  @Test
  @DisplayName("Test dconst_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dconst_0()"
  })
  void testDconst_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDconst_0Result = instructionSequenceBuilder.dconst_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDconst_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dconst_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dconst_1()}
   */
  @Test
  @DisplayName("Test dconst_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dconst_1()"
  })
  void testDconst_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDconst_1Result = instructionSequenceBuilder.dconst_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDconst_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#bipush(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#bipush(int)}
   */
  @Test
  @DisplayName("Test bipush(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.bipush(int)"
  })
  void testBipush() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBipushResult = instructionSequenceBuilder.bipush(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBipushResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#sipush(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#sipush(int)}
   */
  @Test
  @DisplayName("Test sipush(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.sipush(int)"
  })
  void testSipush() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualSipushResult = instructionSequenceBuilder.sipush(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualSipushResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz)} with {@code Clazz}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz)}
   */
  @Test
  @DisplayName("Test ldc(Clazz) with 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz)"
  })
  void testLdcWithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.ldc((Clazz) new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)} with {@code Clazz}, {@code
   * ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test ldc(Clazz, ConstantVisitor) with 'Clazz', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithClazzConstantVisitor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    instructionSequenceBuilder.ldc((Clazz) clazz, visitor);

    // Assert
    Clazz clazz2 = visitor.resultClazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", clazz2.getName());
    assertEquals("This Class Name", visitor.result);
    assertEquals(1, clazz2.getAccessFlags());
    assertSame(clazz.fields, ((LibraryClass) clazz2).fields);
    assertSame(clazz.interfaceNames, ((LibraryClass) clazz2).interfaceNames);
    assertSame(clazz.methods, ((LibraryClass) clazz2).methods);
    Clazz[] clazzArray = clazz.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz2).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)} with {@code Clazz}, {@code
   * ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test ldc(Clazz, ConstantVisitor) with 'Clazz', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithClazzConstantVisitor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(targetClass);
    LibraryClass clazz = new LibraryClass();
    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc((Clazz) clazz, visitor);

    // Assert
    Clazz clazz2 = visitor.resultClazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertEquals(0, clazz2.getAccessFlags());
    assertSame(targetClass, actualLdcResult.getConstantPoolEditor().getTargetClass());
    assertSame(instructionSequenceBuilder, actualLdcResult);
    Clazz[] clazzArray = clazz.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz2).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)} with {@code Clazz}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(Clazz, ConstantVisitor) with 'Clazz', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithClazzConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc((Clazz) clazz, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)} with {@code Clazz}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(Clazz, ConstantVisitor) with 'Clazz', 'ConstantVisitor'; when 'null'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithClazzConstantVisitor_whenNull_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(
            (Clazz) new LibraryClass(1, "This Class Name", "Super Class Name"),
            (ConstantVisitor) null));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, Member)} with {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc(Clazz, Member) with 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithClazzMember() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, Member)} with {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc(Clazz, Member) with 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
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
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, Member, ConstantVisitor)} with {@code Clazz},
   * {@code Member}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(Clazz, Member, ConstantVisitor) with 'Clazz', 'Member', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithClazzMemberConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc(clazz, member, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, Member, ConstantVisitor)} with {@code Clazz},
   * {@code Member}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(Clazz, Member, ConstantVisitor) with 'Clazz', 'Member', 'ConstantVisitor'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithClazzMemberConstantVisitor_whenNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc(clazz, new LibraryField(1, "Name", "Descriptor"), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, Member)} with {@code Clazz}, {@code Member}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test ldc(Clazz, Member) with 'Clazz', 'Member'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithClazzMember_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz, Member)} with {@code Clazz}, {@code Member}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test ldc(Clazz, Member) with 'Clazz', 'Member'; then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithClazzMember_thenSixthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualLdcResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertTrue(constantArray[7] instanceof StringConstant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualLdcResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Clazz)} with {@code Clazz}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Clazz)}
   */
  @Test
  @DisplayName("Test ldc(Clazz) with 'Clazz'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.classfile.Clazz)"
  })
  void testLdcWithClazz_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(
            (Clazz) new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(float)} with {@code float}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(float)}
   */
  @Test
  @DisplayName("Test ldc(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(float)"
  })
  void testLdcWithFloat() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(4, 1, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc(10.0f));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(float)} with {@code float}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(float)}
   */
  @Test
  @DisplayName("Test ldc(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(float)"
  })
  void testLdcWithFloat2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                4,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                4,
                4,
                4));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc(10.0f));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(float, ConstantVisitor)} with {@code float}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(float, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(float, ConstantVisitor) with 'float', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(float, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithFloatConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(10.0f, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(float, ConstantVisitor)} with {@code float}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(float, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(float, ConstantVisitor) with 'float', 'ConstantVisitor'; when 'null'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(float, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithFloatConstantVisitor_whenNull_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(10.0f, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(float)}
   */
  @Test
  @DisplayName("Test ldc(float) with 'float'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(float)"
  })
  void testLdcWithFloat_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc(10.0f));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(int)} with {@code int}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(int)}
   */
  @Test
  @DisplayName("Test ldc(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(int)"
  })
  void testLdcWithInt() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(3, 1, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc(42));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(int, ConstantVisitor)} with {@code int}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@link ConstantCounter} (default constructor).
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(int, ConstantVisitor) with 'int', 'ConstantVisitor'; when ConstantCounter (default constructor); then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithIntConstantVisitor_whenConstantCounter_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(42, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(int, ConstantVisitor)} with {@code int}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(int, ConstantVisitor) with 'int', 'ConstantVisitor'; when 'null'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithIntConstantVisitor_whenNull_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(42, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(int)}
   */
  @Test
  @DisplayName("Test ldc(int) with 'int'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(int)"
  })
  void testLdcWithInt_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc(42));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass)}
   *       with targetClass is {@link ProgramClass#ProgramClass(int, int, Constant[], int, int,
   *       int)}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(int)}
   */
  @Test
  @DisplayName(
      "Test ldc(int) with 'int'; then return InstructionSequenceBuilder(ProgramClass) with targetClass is ProgramClass(int, int, Constant[], int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(int)"
  })
  void testLdcWithInt_thenReturnInstructionSequenceBuilderWithTargetClassIsProgramClass() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                3,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                3,
                3,
                3));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc(42));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Object)}
   */
  @Test
  @DisplayName("Test ldc(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.Object)"
  })
  void testLdcWithObject() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(99, 1, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Object)}
   */
  @Test
  @DisplayName("Test ldc(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.Object)"
  })
  void testLdcWithObject2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                99,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                99,
                99,
                99));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Object, ConstantVisitor)} with {@code Object},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Object, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(Object, ConstantVisitor) with 'Object', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.Object, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithObjectConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc((Object) "Primitive Array", visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Object, ConstantVisitor)} with {@code Object},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Object, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(Object, ConstantVisitor) with 'Object', 'ConstantVisitor'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.Object, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithObjectConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc((Object) "Primitive Array", null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(Object)}
   */
  @Test
  @DisplayName("Test ldc(Object) with 'Object'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.Object)"
  })
  void testLdcWithObject_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc(ResourceFile) with 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.resources.file.ResourceFile)"
  })
  void testLdcWithResourceFile() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc(ResourceFile) with 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.resources.file.ResourceFile)"
  })
  void testLdcWithResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(ResourceFile, ConstantVisitor)} with {@code
   * ResourceFile}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(ResourceFile, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(ResourceFile, ConstantVisitor) with 'ResourceFile', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.resources.file.ResourceFile, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithResourceFileConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc(resourceFile, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(ResourceFile, ConstantVisitor)} with {@code
   * ResourceFile}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(ResourceFile, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(ResourceFile, ConstantVisitor) with 'ResourceFile', 'ConstantVisitor'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.resources.file.ResourceFile, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithResourceFileConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc(new ResourceFile("foo.txt", 3L), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(ResourceFile)} with {@code ResourceFile}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test ldc(ResourceFile) with 'ResourceFile'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(proguard.resources.file.ResourceFile)"
  })
  void testLdcWithResourceFile_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String)} with {@code String}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String)}
   */
  @Test
  @DisplayName("Test ldc(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String)"
  })
  void testLdcWithString() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc("String"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String)} with {@code String}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String)}
   */
  @Test
  @DisplayName("Test ldc(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String)"
  })
  void testLdcWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc("String"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz)} with {@code String}, {@code Clazz}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz) with 'String', 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdcWithStringClazz() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz)} with {@code String}, {@code Clazz}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz) with 'String', 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdcWithStringClazz2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)} with {@code
   * String}, {@code Clazz}, {@code ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz, ConstantVisitor) with 'String', 'Clazz', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringClazzConstantVisitor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    instructionSequenceBuilder.ldc("Type Name", referencedClass, visitor);

    // Assert
    Clazz clazz = visitor.resultClazz;
    assertTrue(clazz instanceof LibraryClass);
    assertEquals("Type Name", visitor.result);
    assertNull(((LibraryClass) clazz).interfaceNames);
    assertNull(((LibraryClass) clazz).fields);
    assertNull(((LibraryClass) clazz).methods);
    assertNull(clazz.getProcessingInfo());
    assertNull(clazz.getName());
    assertNull(clazz.getSuperName());
    assertNull(clazz.getFeatureName());
    assertNull(clazz.getSuperClass());
    assertNull(((LibraryClass) clazz).kotlinMetadata);
    assertEquals(0, clazz.getAccessFlags());
    assertEquals(0, clazz.getInterfaceCount());
    assertEquals(0, clazz.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz).subClassCount);
    assertEquals(1, visitor.resultSize);
    Clazz[] clazzArray = referencedClass.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz).subClasses);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)} with {@code
   * String}, {@code Clazz}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, Clazz, ConstantVisitor) with 'String', 'Clazz', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringClazzConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc("Type Name", referencedClass, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)} with {@code
   * String}, {@code Clazz}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, Clazz, ConstantVisitor) with 'String', 'Clazz', 'ConstantVisitor'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringClazzConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc("Type Name", new LibraryClass(), (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)} with {@code String}, {@code
   * Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz, Member) with 'String', 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithStringClazzMember() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)} with {@code String}, {@code
   * Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc(String, Clazz, Member) with 'String', 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithStringClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
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
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz, Member, ConstantVisitor)} with {@code
   * String}, {@code Clazz}, {@code Member}, {@code ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz, Member,
   * ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, Clazz, Member, ConstantVisitor) with 'String', 'Clazz', 'Member', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringClazzMemberConstantVisitor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor"), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz, Member, ConstantVisitor)} with {@code
   * String}, {@code Clazz}, {@code Member}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz, Member,
   * ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, Clazz, Member, ConstantVisitor) with 'String', 'Clazz', 'Member', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringClazzMemberConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc("String", referencedClass, referencedMember, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)} with {@code String}, {@code
   * Clazz}, {@code Member}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, Clazz, Member) with 'String', 'Clazz', 'Member'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdcWithStringClazzMember_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, Clazz)} with {@code String}, {@code Clazz}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, Clazz) with 'String', 'Clazz'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdcWithStringClazz_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, ConstantVisitor)} with {@code String},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, ConstantVisitor) with 'String', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String", visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, ConstantVisitor)} with {@code String},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, ConstantVisitor) with 'String', 'ConstantVisitor'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc("String", (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc(String, ResourceFile) with 'String', 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdcWithStringResourceFile() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc(String, ResourceFile) with 'String', 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdcWithStringResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, ResourceFile, ConstantVisitor)} with {@code
   * String}, {@code ResourceFile}, {@code ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, ResourceFile,
   * ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, ResourceFile, ConstantVisitor) with 'String', 'ResourceFile', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.resources.file.ResourceFile, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringResourceFileConstantVisitor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc("String", new ResourceFile("foo.txt", 3L), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, ResourceFile, ConstantVisitor)} with {@code
   * String}, {@code ResourceFile}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, ResourceFile,
   * ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, ResourceFile, ConstantVisitor) with 'String', 'ResourceFile', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.resources.file.ResourceFile, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdcWithStringResourceFileConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ResourceFile referencedResourceFile = new ResourceFile("foo.txt", 3L);

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult =
        instructionSequenceBuilder.ldc("String", referencedResourceFile, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String, ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test ldc(String, ResourceFile) with 'String', 'ResourceFile'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdcWithStringResourceFile_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc(String)}
   */
  @Test
  @DisplayName("Test ldc(String) with 'String'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc(java.lang.String)"
  })
  void testLdcWithString_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc("String"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_(int)}
   */
  @Test
  @DisplayName("Test ldc_(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_(int)"
  })
  void testLdc_WithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_Result = instructionSequenceBuilder.ldc_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)} with {@code constantIndex},
   * {@code visitor}.
   *
   * <ul>
   *   <li>Then return second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_(int, ConstantVisitor) with 'constantIndex', 'visitor'; then return second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_WithConstantIndexVisitor_thenReturnSecondElementIsNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_Result =
        instructionSequenceBuilder.ldc_(1, new ConstantLookupVisitor());

    // Assert
    ProgramClass targetClass = actualLdc_Result.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[1]);
    assertNull(constantArray[2]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualLdc_Result.size());
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)} with {@code constantIndex},
   * {@code visitor}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_(int, ConstantVisitor) with 'constantIndex', 'visitor'; then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_WithConstantIndexVisitor_thenSixthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualLdc_Result =
        instructionSequenceBuilder.ldc_(
            1, new BootstrapMethodHandleTraveler(new ConstantLookupVisitor()));

    // Assert
    ProgramClass targetClass = actualLdc_Result.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualLdc_Result.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)} with {@code constantIndex},
   * {@code visitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_(int, ConstantVisitor) with 'constantIndex', 'visitor'; when 'null'; then return second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_WithConstantIndexVisitor_whenNull_thenReturnSecondElementIsNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_Result = instructionSequenceBuilder.ldc_(1, null);

    // Assert
    ProgramClass targetClass = actualLdc_Result.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[1]);
    assertNull(constantArray[2]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualLdc_Result.size());
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz)} with {@code Clazz}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz) with 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz)"
  })
  void testLdc_wWithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.ldc_w((Clazz) new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)} with {@code Clazz},
   * {@code ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz, ConstantVisitor) with 'Clazz', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithClazzConstantVisitor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    instructionSequenceBuilder.ldc_w((Clazz) clazz, visitor);

    // Assert
    Clazz clazz2 = visitor.resultClazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", clazz2.getName());
    assertEquals("This Class Name", visitor.result);
    assertEquals(1, clazz2.getAccessFlags());
    assertSame(clazz.fields, ((LibraryClass) clazz2).fields);
    assertSame(clazz.interfaceNames, ((LibraryClass) clazz2).interfaceNames);
    assertSame(clazz.methods, ((LibraryClass) clazz2).methods);
    Clazz[] clazzArray = clazz.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz2).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)} with {@code Clazz},
   * {@code ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz, ConstantVisitor) with 'Clazz', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithClazzConstantVisitor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(targetClass);
    LibraryClass clazz = new LibraryClass();
    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w((Clazz) clazz, visitor);

    // Assert
    Clazz clazz2 = visitor.resultClazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertEquals(0, clazz2.getAccessFlags());
    assertSame(targetClass, actualLdc_wResult.getConstantPoolEditor().getTargetClass());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
    Clazz[] clazzArray = clazz.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz2).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)} with {@code Clazz},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(Clazz, ConstantVisitor) with 'Clazz', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithClazzConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w((Clazz) clazz, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)} with {@code Clazz},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(Clazz, ConstantVisitor) with 'Clazz', 'ConstantVisitor'; when 'null'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithClazzConstantVisitor_whenNull_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(
            (Clazz) new LibraryClass(1, "This Class Name", "Super Class Name"),
            (ConstantVisitor) null));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz, Member) with 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithClazzMember() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz, Member) with 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
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
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, Member, ConstantVisitor)} with {@code
   * Clazz}, {@code Member}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(Clazz, Member, ConstantVisitor) with 'Clazz', 'Member', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithClazzMemberConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w(clazz, member, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, Member, ConstantVisitor)} with {@code
   * Clazz}, {@code Member}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(Clazz, Member, ConstantVisitor) with 'Clazz', 'Member', 'ConstantVisitor'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithClazzMemberConstantVisitor_whenNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor"), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(Clazz, Member) with 'Clazz', 'Member'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithClazzMember_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(Clazz, Member) with 'Clazz', 'Member'; then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithClazzMember_thenSixthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualLdc_wResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertTrue(constantArray[7] instanceof StringConstant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualLdc_wResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Clazz)} with {@code Clazz}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz)}
   */
  @Test
  @DisplayName("Test ldc_w(Clazz) with 'Clazz'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.classfile.Clazz)"
  })
  void testLdc_wWithClazz_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(
            (Clazz) new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(float)} with {@code float}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(float)}
   */
  @Test
  @DisplayName("Test ldc_w(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(float)"
  })
  void testLdc_wWithFloat() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(4, 1, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w(10.0f));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(float)} with {@code float}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(float)}
   */
  @Test
  @DisplayName("Test ldc_w(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(float)"
  })
  void testLdc_wWithFloat2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                4,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                4,
                4,
                4));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w(10.0f));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(float, ConstantVisitor)} with {@code float},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(float, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(float, ConstantVisitor) with 'float', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(float, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithFloatConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(10.0f, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(float, ConstantVisitor)} with {@code float},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(float, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test ldc_w(float, ConstantVisitor) with 'float', 'ConstantVisitor'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(float, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithFloatConstantVisitor_whenNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(10.0f, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(float)}
   */
  @Test
  @DisplayName("Test ldc_w(float) with 'float'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(float)"
  })
  void testLdc_wWithFloat_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w(10.0f));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(int)}
   */
  @Test
  @DisplayName("Test ldc_w(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(int)"
  })
  void testLdc_wWithInt() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(3, 1, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w(42));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(int)}
   */
  @Test
  @DisplayName("Test ldc_w(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(int)"
  })
  void testLdc_wWithInt2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                3,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                3,
                3,
                3));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w(42));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(int, ConstantVisitor)} with {@code int}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(int, ConstantVisitor) with 'int', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithIntConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(42, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(int, ConstantVisitor)} with {@code int}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(int, ConstantVisitor) with 'int', 'ConstantVisitor'; when 'null'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithIntConstantVisitor_whenNull_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(42, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(int)}
   */
  @Test
  @DisplayName("Test ldc_w(int) with 'int'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(int)"
  })
  void testLdc_wWithInt_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w(42));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Object)}
   */
  @Test
  @DisplayName("Test ldc_w(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.Object)"
  })
  void testLdc_wWithObject() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(99, 1, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Object)}
   */
  @Test
  @DisplayName("Test ldc_w(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.Object)"
  })
  void testLdc_wWithObject2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                99,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                99,
                99,
                99));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Object, ConstantVisitor)} with {@code Object},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Object, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(Object, ConstantVisitor) with 'Object', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.Object, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithObjectConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w((Object) "Primitive Array", visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Object, ConstantVisitor)} with {@code Object},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Object, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(Object, ConstantVisitor) with 'Object', 'ConstantVisitor'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.Object, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithObjectConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w((Object) "Primitive Array", null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(Object)}
   */
  @Test
  @DisplayName("Test ldc_w(Object) with 'Object'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.Object)"
  })
  void testLdc_wWithObject_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc_w(ResourceFile) with 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithResourceFile() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc_w(ResourceFile) with 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(ResourceFile, ConstantVisitor)} with {@code
   * ResourceFile}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(ResourceFile, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(ResourceFile, ConstantVisitor) with 'ResourceFile', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.resources.file.ResourceFile, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithResourceFileConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w(resourceFile, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(ResourceFile, ConstantVisitor)} with {@code
   * ResourceFile}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(ResourceFile, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(ResourceFile, ConstantVisitor) with 'ResourceFile', 'ConstantVisitor'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.resources.file.ResourceFile, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithResourceFileConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w(new ResourceFile("foo.txt", 3L), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(ResourceFile)} with {@code ResourceFile}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(ResourceFile) with 'ResourceFile'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithResourceFile_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String)} with {@code String}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String)}
   */
  @Test
  @DisplayName("Test ldc_w(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String)"
  })
  void testLdc_wWithString() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w("String"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String)} with {@code String}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String)}
   */
  @Test
  @DisplayName("Test ldc_w(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String)"
  })
  void testLdc_wWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w("String"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz)}
   */
  @Test
  @DisplayName("Test ldc_w(String, Clazz) with 'String', 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdc_wWithStringClazz() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz)}
   */
  @Test
  @DisplayName("Test ldc_w(String, Clazz) with 'String', 'Clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdc_wWithStringClazz2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)} with {@code
   * String}, {@code Clazz}, {@code ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, Clazz, ConstantVisitor) with 'String', 'Clazz', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringClazzConstantVisitor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    instructionSequenceBuilder.ldc_w("Type Name", referencedClass, visitor);

    // Assert
    Clazz clazz = visitor.resultClazz;
    assertTrue(clazz instanceof LibraryClass);
    assertEquals("Type Name", visitor.result);
    assertNull(((LibraryClass) clazz).interfaceNames);
    assertNull(((LibraryClass) clazz).fields);
    assertNull(((LibraryClass) clazz).methods);
    assertNull(clazz.getProcessingInfo());
    assertNull(clazz.getName());
    assertNull(clazz.getSuperName());
    assertNull(clazz.getFeatureName());
    assertNull(clazz.getSuperClass());
    assertNull(((LibraryClass) clazz).kotlinMetadata);
    assertEquals(0, clazz.getAccessFlags());
    assertEquals(0, clazz.getInterfaceCount());
    assertEquals(0, clazz.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz).subClassCount);
    assertEquals(1, visitor.resultSize);
    Clazz[] clazzArray = referencedClass.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz).subClasses);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)} with {@code
   * String}, {@code Clazz}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, Clazz, ConstantVisitor) with 'String', 'Clazz', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringClazzConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w("Type Name", referencedClass, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)} with {@code
   * String}, {@code Clazz}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, Clazz, ConstantVisitor) with 'String', 'Clazz', 'ConstantVisitor'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringClazzConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w("Type Name", new LibraryClass(), (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc_w(String, Clazz, Member) with 'String', 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithStringClazzMember() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)}
   */
  @Test
  @DisplayName("Test ldc_w(String, Clazz, Member) with 'String', 'Clazz', 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithStringClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
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
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member, ConstantVisitor)} with
   * {@code String}, {@code Clazz}, {@code Member}, {@code ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member,
   * ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, Clazz, Member, ConstantVisitor) with 'String', 'Clazz', 'Member', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringClazzMemberConstantVisitor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor"), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member, ConstantVisitor)} with
   * {@code String}, {@code Clazz}, {@code Member}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member,
   * ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, Clazz, Member, ConstantVisitor) with 'String', 'Clazz', 'Member', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringClazzMemberConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w("String", referencedClass, referencedMember, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, Clazz, Member) with 'String', 'Clazz', 'Member'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testLdc_wWithStringClazzMember_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, Clazz) with 'String', 'Clazz'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.Clazz)"
  })
  void testLdc_wWithStringClazz_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, ConstantVisitor)} with {@code String},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, ConstantVisitor) with 'String', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w("String", visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, ConstantVisitor)} with {@code String},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, ConstantVisitor) with 'String', 'ConstantVisitor'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w("String", (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc_w(String, ResourceFile) with 'String', 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithStringResourceFile() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)}
   */
  @Test
  @DisplayName("Test ldc_w(String, ResourceFile) with 'String', 'ResourceFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithStringResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile, ConstantVisitor)} with
   * {@code String}, {@code ResourceFile}, {@code ConstantVisitor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile,
   * ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, ResourceFile, ConstantVisitor) with 'String', 'ResourceFile', 'ConstantVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.resources.file.ResourceFile, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringResourceFileConstantVisitor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w("String", new ResourceFile("foo.txt", 3L), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile, ConstantVisitor)} with
   * {@code String}, {@code ResourceFile}, {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile,
   * ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, ResourceFile, ConstantVisitor) with 'String', 'ResourceFile', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.resources.file.ResourceFile, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_wWithStringResourceFileConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ResourceFile referencedResourceFile = new ResourceFile("foo.txt", 3L);

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult =
        instructionSequenceBuilder.ldc_w("String", referencedResourceFile, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test ldc_w(String, ResourceFile) with 'String', 'ResourceFile'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String, proguard.resources.file.ResourceFile)"
  })
  void testLdc_wWithStringResourceFile_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.ldc_w("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w(String)}
   */
  @Test
  @DisplayName("Test ldc_w(String) with 'String'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w(java.lang.String)"
  })
  void testLdc_wWithString_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc_w("String"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w_(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w_(int)}
   */
  @Test
  @DisplayName("Test ldc_w_(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w_(int)"
  })
  void testLdc_w_WithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_w_Result = instructionSequenceBuilder.ldc_w_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_w_Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)} with {@code
   * constantIndex}, {@code visitor}.
   *
   * <ul>
   *   <li>Then return second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w_(int, ConstantVisitor) with 'constantIndex', 'visitor'; then return second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w_(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_w_WithConstantIndexVisitor_thenReturnSecondElementIsNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_w_Result =
        instructionSequenceBuilder.ldc_w_(1, new ConstantLookupVisitor());

    // Assert
    ProgramClass targetClass = actualLdc_w_Result.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[1]);
    assertNull(constantArray[2]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualLdc_w_Result.size());
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)} with {@code
   * constantIndex}, {@code visitor}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w_(int, ConstantVisitor) with 'constantIndex', 'visitor'; then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w_(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_w_WithConstantIndexVisitor_thenSixthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualLdc_w_Result =
        instructionSequenceBuilder.ldc_w_(
            1, new BootstrapMethodHandleTraveler(new ConstantLookupVisitor()));

    // Assert
    ProgramClass targetClass = actualLdc_w_Result.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualLdc_w_Result.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)} with {@code
   * constantIndex}, {@code visitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc_w_(int, ConstantVisitor) with 'constantIndex', 'visitor'; when 'null'; then return second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc_w_(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc_w_WithConstantIndexVisitor_whenNull_thenReturnSecondElementIsNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_w_Result = instructionSequenceBuilder.ldc_w_(1, null);

    // Assert
    ProgramClass targetClass = actualLdc_w_Result.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[1]);
    assertNull(constantArray[2]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualLdc_w_Result.size());
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(double)} with {@code double}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(double)}
   */
  @Test
  @DisplayName("Test ldc2_w(double) with 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(double)"
  })
  void testLdc2_wWithDouble() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(6, 1, new Constant[] {new ClassConstant()}, 6, 6, 6));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc2_w(10.0d));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(double)} with {@code double}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(double)}
   */
  @Test
  @DisplayName("Test ldc2_w(double) with 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(double)"
  })
  void testLdc2_wWithDouble2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                6,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                6,
                6,
                6));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc2_w(10.0d));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(double, ConstantVisitor)} with {@code double},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(double, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc2_w(double, ConstantVisitor) with 'double', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(double, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc2_wWithDoubleConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult =
        instructionSequenceBuilder.ldc2_w(10.0d, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(double, ConstantVisitor)} with {@code double},
   * {@code ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(double, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test ldc2_w(double, ConstantVisitor) with 'double', 'ConstantVisitor'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(double, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc2_wWithDoubleConstantVisitor_whenNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(10.0d, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(double)} with {@code double}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(double)}
   */
  @Test
  @DisplayName("Test ldc2_w(double) with 'double'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(double)"
  })
  void testLdc2_wWithDouble_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc2_w(10.0d));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(int)}
   */
  @Test
  @DisplayName("Test ldc2_w(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(int)"
  })
  void testLdc2_wWithInt() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)} with {@code int}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>Then return second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc2_w(int, ConstantVisitor) with 'int', 'ConstantVisitor'; then return second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc2_wWithIntConstantVisitor_thenReturnSecondElementIsNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult =
        instructionSequenceBuilder.ldc2_w(1, new ConstantLookupVisitor());

    // Assert
    ProgramClass targetClass = actualLdc2_wResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[1]);
    assertNull(constantArray[2]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualLdc2_wResult.size());
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)} with {@code int}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc2_w(int, ConstantVisitor) with 'int', 'ConstantVisitor'; then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc2_wWithIntConstantVisitor_thenSixthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualLdc2_wResult =
        instructionSequenceBuilder.ldc2_w(
            1, new BootstrapMethodHandleTraveler(new ConstantLookupVisitor()));

    // Assert
    ProgramClass targetClass = actualLdc2_wResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualLdc2_wResult.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)} with {@code int}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc2_w(int, ConstantVisitor) with 'int', 'ConstantVisitor'; when 'null'; then return second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc2_wWithIntConstantVisitor_whenNull_thenReturnSecondElementIsNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(1, null);

    // Assert
    ProgramClass targetClass = actualLdc2_wResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[1]);
    assertNull(constantArray[2]);
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertNull(constantArray[5]);
    assertNull(constantArray[6]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualLdc2_wResult.size());
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(long)} with {@code long}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(long)}
   */
  @Test
  @DisplayName("Test ldc2_w(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(long)"
  })
  void testLdc2_wWithLong() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(5, 1, new Constant[] {new ClassConstant()}, 5, 5, 5));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc2_w(42L));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(long)} with {@code long}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(long)}
   */
  @Test
  @DisplayName("Test ldc2_w(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(long)"
  })
  void testLdc2_wWithLong2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                5,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                5,
                5,
                5));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc2_w(42L));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(long, ConstantVisitor)} with {@code long}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(long, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test ldc2_w(long, ConstantVisitor) with 'long', 'ConstantVisitor'; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(long, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc2_wWithLongConstantVisitor_thenConstantCounterCountIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(42L, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(long, ConstantVisitor)} with {@code long}, {@code
   * ConstantVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(long, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test ldc2_w(long, ConstantVisitor) with 'long', 'ConstantVisitor'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(long, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testLdc2_wWithLongConstantVisitor_whenNull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(42L, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldc2_w(long)} with {@code long}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldc2_w(long)}
   */
  @Test
  @DisplayName("Test ldc2_w(long) with 'long'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldc2_w(long)"
  })
  void testLdc2_wWithLong_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.ldc2_w(42L));
  }

  /**
   * Test {@link InstructionSequenceBuilder#iload(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iload(int)}
   */
  @Test
  @DisplayName("Test iload(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iload(int)"
  })
  void testIload_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIloadResult = instructionSequenceBuilder.iload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iload(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iload(int)}
   */
  @Test
  @DisplayName("Test iload(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iload(int)"
  })
  void testIload_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIloadResult = instructionSequenceBuilder.iload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iload(int)}.
   *
   * <ul>
   *   <li>When twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iload(int)}
   */
  @Test
  @DisplayName("Test iload(int); when twenty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iload(int)"
  })
  void testIload_whenTwentyOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIloadResult = instructionSequenceBuilder.iload(21);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lload(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lload(int)}
   */
  @Test
  @DisplayName("Test lload(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lload(int)"
  })
  void testLload_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLloadResult = instructionSequenceBuilder.lload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lload(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lload(int)}
   */
  @Test
  @DisplayName("Test lload(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lload(int)"
  })
  void testLload_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLloadResult = instructionSequenceBuilder.lload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lload(int)}.
   *
   * <ul>
   *   <li>When twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lload(int)}
   */
  @Test
  @DisplayName("Test lload(int); when twenty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lload(int)"
  })
  void testLload_whenTwentyTwo() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLloadResult = instructionSequenceBuilder.lload(22);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fload(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fload(int)}
   */
  @Test
  @DisplayName("Test fload(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fload(int)"
  })
  void testFload_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFloadResult = instructionSequenceBuilder.fload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fload(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fload(int)}
   */
  @Test
  @DisplayName("Test fload(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fload(int)"
  })
  void testFload_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFloadResult = instructionSequenceBuilder.fload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fload(int)}.
   *
   * <ul>
   *   <li>When twenty-three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fload(int)}
   */
  @Test
  @DisplayName("Test fload(int); when twenty-three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fload(int)"
  })
  void testFload_whenTwentyThree() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFloadResult = instructionSequenceBuilder.fload(23);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dload(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dload(int)}
   */
  @Test
  @DisplayName("Test dload(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dload(int)"
  })
  void testDload_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDloadResult = instructionSequenceBuilder.dload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dload(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dload(int)}
   */
  @Test
  @DisplayName("Test dload(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dload(int)"
  })
  void testDload_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDloadResult = instructionSequenceBuilder.dload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dload(int)}.
   *
   * <ul>
   *   <li>When twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dload(int)}
   */
  @Test
  @DisplayName("Test dload(int); when twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dload(int)"
  })
  void testDload_whenTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDloadResult = instructionSequenceBuilder.dload(24);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aload(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aload(int)}
   */
  @Test
  @DisplayName("Test aload(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aload(int)"
  })
  void testAload_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAloadResult = instructionSequenceBuilder.aload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aload(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aload(int)}
   */
  @Test
  @DisplayName("Test aload(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aload(int)"
  })
  void testAload_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAloadResult = instructionSequenceBuilder.aload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aload(int)}.
   *
   * <ul>
   *   <li>When twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aload(int)}
   */
  @Test
  @DisplayName("Test aload(int); when twenty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aload(int)"
  })
  void testAload_whenTwentyFive() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAloadResult = instructionSequenceBuilder.aload(25);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iload_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iload_0()}
   */
  @Test
  @DisplayName("Test iload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iload_0()"
  })
  void testIload_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIload_0Result = instructionSequenceBuilder.iload_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIload_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iload_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iload_1()}
   */
  @Test
  @DisplayName("Test iload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iload_1()"
  })
  void testIload_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIload_1Result = instructionSequenceBuilder.iload_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIload_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iload_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iload_2()}
   */
  @Test
  @DisplayName("Test iload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iload_2()"
  })
  void testIload_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIload_2Result = instructionSequenceBuilder.iload_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIload_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iload_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iload_3()}
   */
  @Test
  @DisplayName("Test iload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iload_3()"
  })
  void testIload_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIload_3Result = instructionSequenceBuilder.iload_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIload_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lload_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lload_0()}
   */
  @Test
  @DisplayName("Test lload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lload_0()"
  })
  void testLload_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLload_0Result = instructionSequenceBuilder.lload_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLload_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lload_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lload_1()}
   */
  @Test
  @DisplayName("Test lload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lload_1()"
  })
  void testLload_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLload_1Result = instructionSequenceBuilder.lload_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLload_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lload_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lload_2()}
   */
  @Test
  @DisplayName("Test lload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lload_2()"
  })
  void testLload_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLload_2Result = instructionSequenceBuilder.lload_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLload_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lload_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lload_3()}
   */
  @Test
  @DisplayName("Test lload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lload_3()"
  })
  void testLload_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLload_3Result = instructionSequenceBuilder.lload_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLload_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fload_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fload_0()}
   */
  @Test
  @DisplayName("Test fload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fload_0()"
  })
  void testFload_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFload_0Result = instructionSequenceBuilder.fload_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFload_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fload_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fload_1()}
   */
  @Test
  @DisplayName("Test fload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fload_1()"
  })
  void testFload_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFload_1Result = instructionSequenceBuilder.fload_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFload_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fload_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fload_2()}
   */
  @Test
  @DisplayName("Test fload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fload_2()"
  })
  void testFload_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFload_2Result = instructionSequenceBuilder.fload_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFload_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fload_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fload_3()}
   */
  @Test
  @DisplayName("Test fload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fload_3()"
  })
  void testFload_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFload_3Result = instructionSequenceBuilder.fload_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFload_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dload_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dload_0()}
   */
  @Test
  @DisplayName("Test dload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dload_0()"
  })
  void testDload_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDload_0Result = instructionSequenceBuilder.dload_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDload_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dload_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dload_1()}
   */
  @Test
  @DisplayName("Test dload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dload_1()"
  })
  void testDload_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDload_1Result = instructionSequenceBuilder.dload_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDload_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dload_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dload_2()}
   */
  @Test
  @DisplayName("Test dload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dload_2()"
  })
  void testDload_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDload_2Result = instructionSequenceBuilder.dload_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDload_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dload_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dload_3()}
   */
  @Test
  @DisplayName("Test dload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dload_3()"
  })
  void testDload_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDload_3Result = instructionSequenceBuilder.dload_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDload_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aload_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aload_0()}
   */
  @Test
  @DisplayName("Test aload_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aload_0()"
  })
  void testAload_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAload_0Result = instructionSequenceBuilder.aload_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAload_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aload_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aload_1()}
   */
  @Test
  @DisplayName("Test aload_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aload_1()"
  })
  void testAload_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAload_1Result = instructionSequenceBuilder.aload_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAload_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aload_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aload_2()}
   */
  @Test
  @DisplayName("Test aload_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aload_2()"
  })
  void testAload_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAload_2Result = instructionSequenceBuilder.aload_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAload_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aload_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aload_3()}
   */
  @Test
  @DisplayName("Test aload_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aload_3()"
  })
  void testAload_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAload_3Result = instructionSequenceBuilder.aload_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAload_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iaload()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iaload()}
   */
  @Test
  @DisplayName("Test iaload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iaload()"
  })
  void testIaload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIaloadResult = instructionSequenceBuilder.iaload();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIaloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#laload()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#laload()}
   */
  @Test
  @DisplayName("Test laload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.laload()"
  })
  void testLaload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLaloadResult = instructionSequenceBuilder.laload();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLaloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#faload()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#faload()}
   */
  @Test
  @DisplayName("Test faload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.faload()"
  })
  void testFaload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFaloadResult = instructionSequenceBuilder.faload();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFaloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#daload()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#daload()}
   */
  @Test
  @DisplayName("Test daload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.daload()"
  })
  void testDaload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDaloadResult = instructionSequenceBuilder.daload();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDaloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aaload()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aaload()}
   */
  @Test
  @DisplayName("Test aaload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aaload()"
  })
  void testAaload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAaloadResult = instructionSequenceBuilder.aaload();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAaloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#baload()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#baload()}
   */
  @Test
  @DisplayName("Test baload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.baload()"
  })
  void testBaload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBaloadResult = instructionSequenceBuilder.baload();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBaloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#caload()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#caload()}
   */
  @Test
  @DisplayName("Test caload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.caload()"
  })
  void testCaload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCaloadResult = instructionSequenceBuilder.caload();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCaloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#saload()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#saload()}
   */
  @Test
  @DisplayName("Test saload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.saload()"
  })
  void testSaload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualSaloadResult = instructionSequenceBuilder.saload();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualSaloadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#istore(int)}.
   *
   * <ul>
   *   <li>When fifty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#istore(int)}
   */
  @Test
  @DisplayName("Test istore(int); when fifty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.istore(int)"
  })
  void testIstore_whenFiftyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstoreResult = instructionSequenceBuilder.istore(54);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#istore(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#istore(int)}
   */
  @Test
  @DisplayName("Test istore(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.istore(int)"
  })
  void testIstore_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstoreResult = instructionSequenceBuilder.istore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#istore(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#istore(int)}
   */
  @Test
  @DisplayName("Test istore(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.istore(int)"
  })
  void testIstore_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstoreResult = instructionSequenceBuilder.istore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lstore(int)}.
   *
   * <ul>
   *   <li>When fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lstore(int)}
   */
  @Test
  @DisplayName("Test lstore(int); when fifty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lstore(int)"
  })
  void testLstore_whenFiftyFive() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstoreResult = instructionSequenceBuilder.lstore(55);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lstore(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lstore(int)}
   */
  @Test
  @DisplayName("Test lstore(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lstore(int)"
  })
  void testLstore_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstoreResult = instructionSequenceBuilder.lstore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lstore(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lstore(int)}
   */
  @Test
  @DisplayName("Test lstore(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lstore(int)"
  })
  void testLstore_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstoreResult = instructionSequenceBuilder.lstore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fstore(int)}.
   *
   * <ul>
   *   <li>When fifty-six.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fstore(int)}
   */
  @Test
  @DisplayName("Test fstore(int); when fifty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fstore(int)"
  })
  void testFstore_whenFiftySix() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstoreResult = instructionSequenceBuilder.fstore(56);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fstore(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fstore(int)}
   */
  @Test
  @DisplayName("Test fstore(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fstore(int)"
  })
  void testFstore_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstoreResult = instructionSequenceBuilder.fstore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fstore(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fstore(int)}
   */
  @Test
  @DisplayName("Test fstore(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fstore(int)"
  })
  void testFstore_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstoreResult = instructionSequenceBuilder.fstore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dstore(int)}.
   *
   * <ul>
   *   <li>When fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dstore(int)}
   */
  @Test
  @DisplayName("Test dstore(int); when fifty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dstore(int)"
  })
  void testDstore_whenFiftySeven() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstoreResult = instructionSequenceBuilder.dstore(57);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dstore(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dstore(int)}
   */
  @Test
  @DisplayName("Test dstore(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dstore(int)"
  })
  void testDstore_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstoreResult = instructionSequenceBuilder.dstore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dstore(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dstore(int)}
   */
  @Test
  @DisplayName("Test dstore(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dstore(int)"
  })
  void testDstore_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstoreResult = instructionSequenceBuilder.dstore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#astore(int)}.
   *
   * <ul>
   *   <li>When fifty-eight.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#astore(int)}
   */
  @Test
  @DisplayName("Test astore(int); when fifty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.astore(int)"
  })
  void testAstore_whenFiftyEight() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstoreResult = instructionSequenceBuilder.astore(58);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#astore(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#astore(int)}
   */
  @Test
  @DisplayName("Test astore(int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.astore(int)"
  })
  void testAstore_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstoreResult = instructionSequenceBuilder.astore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#astore(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#astore(int)}
   */
  @Test
  @DisplayName("Test astore(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.astore(int)"
  })
  void testAstore_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstoreResult = instructionSequenceBuilder.astore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#istore_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#istore_0()}
   */
  @Test
  @DisplayName("Test istore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.istore_0()"
  })
  void testIstore_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstore_0Result = instructionSequenceBuilder.istore_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstore_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#istore_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#istore_1()}
   */
  @Test
  @DisplayName("Test istore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.istore_1()"
  })
  void testIstore_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstore_1Result = instructionSequenceBuilder.istore_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstore_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#istore_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#istore_2()}
   */
  @Test
  @DisplayName("Test istore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.istore_2()"
  })
  void testIstore_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstore_2Result = instructionSequenceBuilder.istore_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstore_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#istore_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#istore_3()}
   */
  @Test
  @DisplayName("Test istore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.istore_3()"
  })
  void testIstore_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstore_3Result = instructionSequenceBuilder.istore_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstore_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lstore_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lstore_0()}
   */
  @Test
  @DisplayName("Test lstore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lstore_0()"
  })
  void testLstore_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstore_0Result = instructionSequenceBuilder.lstore_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstore_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lstore_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lstore_1()}
   */
  @Test
  @DisplayName("Test lstore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lstore_1()"
  })
  void testLstore_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstore_1Result = instructionSequenceBuilder.lstore_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstore_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lstore_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lstore_2()}
   */
  @Test
  @DisplayName("Test lstore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lstore_2()"
  })
  void testLstore_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstore_2Result = instructionSequenceBuilder.lstore_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstore_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lstore_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lstore_3()}
   */
  @Test
  @DisplayName("Test lstore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lstore_3()"
  })
  void testLstore_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstore_3Result = instructionSequenceBuilder.lstore_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstore_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fstore_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fstore_0()}
   */
  @Test
  @DisplayName("Test fstore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fstore_0()"
  })
  void testFstore_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstore_0Result = instructionSequenceBuilder.fstore_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstore_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fstore_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fstore_1()}
   */
  @Test
  @DisplayName("Test fstore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fstore_1()"
  })
  void testFstore_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstore_1Result = instructionSequenceBuilder.fstore_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstore_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fstore_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fstore_2()}
   */
  @Test
  @DisplayName("Test fstore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fstore_2()"
  })
  void testFstore_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstore_2Result = instructionSequenceBuilder.fstore_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstore_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fstore_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fstore_3()}
   */
  @Test
  @DisplayName("Test fstore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fstore_3()"
  })
  void testFstore_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstore_3Result = instructionSequenceBuilder.fstore_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstore_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dstore_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dstore_0()}
   */
  @Test
  @DisplayName("Test dstore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dstore_0()"
  })
  void testDstore_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstore_0Result = instructionSequenceBuilder.dstore_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstore_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dstore_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dstore_1()}
   */
  @Test
  @DisplayName("Test dstore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dstore_1()"
  })
  void testDstore_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstore_1Result = instructionSequenceBuilder.dstore_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstore_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dstore_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dstore_2()}
   */
  @Test
  @DisplayName("Test dstore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dstore_2()"
  })
  void testDstore_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstore_2Result = instructionSequenceBuilder.dstore_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstore_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dstore_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dstore_3()}
   */
  @Test
  @DisplayName("Test dstore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dstore_3()"
  })
  void testDstore_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstore_3Result = instructionSequenceBuilder.dstore_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstore_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#astore_0()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#astore_0()}
   */
  @Test
  @DisplayName("Test astore_0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.astore_0()"
  })
  void testAstore_0() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstore_0Result = instructionSequenceBuilder.astore_0();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstore_0Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#astore_1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#astore_1()}
   */
  @Test
  @DisplayName("Test astore_1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.astore_1()"
  })
  void testAstore_1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstore_1Result = instructionSequenceBuilder.astore_1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstore_1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#astore_2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#astore_2()}
   */
  @Test
  @DisplayName("Test astore_2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.astore_2()"
  })
  void testAstore_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstore_2Result = instructionSequenceBuilder.astore_2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstore_2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#astore_3()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#astore_3()}
   */
  @Test
  @DisplayName("Test astore_3()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.astore_3()"
  })
  void testAstore_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstore_3Result = instructionSequenceBuilder.astore_3();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstore_3Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iastore()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iastore()}
   */
  @Test
  @DisplayName("Test iastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iastore()"
  })
  void testIastore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIastoreResult = instructionSequenceBuilder.iastore();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIastoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lastore()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lastore()}
   */
  @Test
  @DisplayName("Test lastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lastore()"
  })
  void testLastore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLastoreResult = instructionSequenceBuilder.lastore();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLastoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fastore()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fastore()}
   */
  @Test
  @DisplayName("Test fastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fastore()"
  })
  void testFastore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFastoreResult = instructionSequenceBuilder.fastore();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFastoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dastore()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dastore()}
   */
  @Test
  @DisplayName("Test dastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dastore()"
  })
  void testDastore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDastoreResult = instructionSequenceBuilder.dastore();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDastoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#aastore()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#aastore()}
   */
  @Test
  @DisplayName("Test aastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.aastore()"
  })
  void testAastore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAastoreResult = instructionSequenceBuilder.aastore();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAastoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#bastore()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#bastore()}
   */
  @Test
  @DisplayName("Test bastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.bastore()"
  })
  void testBastore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBastoreResult = instructionSequenceBuilder.bastore();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBastoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#castore()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#castore()}
   */
  @Test
  @DisplayName("Test castore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.castore()"
  })
  void testCastore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCastoreResult = instructionSequenceBuilder.castore();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCastoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#sastore()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#sastore()}
   */
  @Test
  @DisplayName("Test sastore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.sastore()"
  })
  void testSastore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualSastoreResult = instructionSequenceBuilder.sastore();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualSastoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pop()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pop()}
   */
  @Test
  @DisplayName("Test pop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pop()"
  })
  void testPop() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPopResult = instructionSequenceBuilder.pop();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPopResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pop2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pop2()}
   */
  @Test
  @DisplayName("Test pop2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pop2()"
  })
  void testPop2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPop2Result = instructionSequenceBuilder.pop2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPop2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dup()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dup()}
   */
  @Test
  @DisplayName("Test dup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dup()"
  })
  void testDup() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDupResult = instructionSequenceBuilder.dup();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDupResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dup_x1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dup_x1()}
   */
  @Test
  @DisplayName("Test dup_x1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dup_x1()"
  })
  void testDup_x1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDup_x1Result = instructionSequenceBuilder.dup_x1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDup_x1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dup_x2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dup_x2()}
   */
  @Test
  @DisplayName("Test dup_x2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dup_x2()"
  })
  void testDup_x2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDup_x2Result = instructionSequenceBuilder.dup_x2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDup_x2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dup2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dup2()}
   */
  @Test
  @DisplayName("Test dup2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dup2()"
  })
  void testDup2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDup2Result = instructionSequenceBuilder.dup2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDup2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dup2_x1()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dup2_x1()}
   */
  @Test
  @DisplayName("Test dup2_x1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dup2_x1()"
  })
  void testDup2_x1() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDup2_x1Result = instructionSequenceBuilder.dup2_x1();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDup2_x1Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dup2_x2()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dup2_x2()}
   */
  @Test
  @DisplayName("Test dup2_x2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dup2_x2()"
  })
  void testDup2_x2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDup2_x2Result = instructionSequenceBuilder.dup2_x2();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDup2_x2Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#swap()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#swap()}
   */
  @Test
  @DisplayName("Test swap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.swap()"
  })
  void testSwap() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualSwapResult = instructionSequenceBuilder.swap();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualSwapResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iadd()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iadd()}
   */
  @Test
  @DisplayName("Test iadd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iadd()"
  })
  void testIadd() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIaddResult = instructionSequenceBuilder.iadd();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIaddResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ladd()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ladd()}
   */
  @Test
  @DisplayName("Test ladd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ladd()"
  })
  void testLadd() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLaddResult = instructionSequenceBuilder.ladd();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLaddResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fadd()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fadd()}
   */
  @Test
  @DisplayName("Test fadd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fadd()"
  })
  void testFadd() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFaddResult = instructionSequenceBuilder.fadd();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFaddResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dadd()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dadd()}
   */
  @Test
  @DisplayName("Test dadd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dadd()"
  })
  void testDadd() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDaddResult = instructionSequenceBuilder.dadd();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDaddResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#isub()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#isub()}
   */
  @Test
  @DisplayName("Test isub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.isub()"
  })
  void testIsub() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIsubResult = instructionSequenceBuilder.isub();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIsubResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lsub()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lsub()}
   */
  @Test
  @DisplayName("Test lsub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lsub()"
  })
  void testLsub() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLsubResult = instructionSequenceBuilder.lsub();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLsubResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fsub()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fsub()}
   */
  @Test
  @DisplayName("Test fsub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fsub()"
  })
  void testFsub() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFsubResult = instructionSequenceBuilder.fsub();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFsubResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dsub()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dsub()}
   */
  @Test
  @DisplayName("Test dsub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dsub()"
  })
  void testDsub() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDsubResult = instructionSequenceBuilder.dsub();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDsubResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#imul()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#imul()}
   */
  @Test
  @DisplayName("Test imul()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.imul()"
  })
  void testImul() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualImulResult = instructionSequenceBuilder.imul();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualImulResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lmul()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lmul()}
   */
  @Test
  @DisplayName("Test lmul()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lmul()"
  })
  void testLmul() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLmulResult = instructionSequenceBuilder.lmul();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLmulResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fmul()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fmul()}
   */
  @Test
  @DisplayName("Test fmul()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fmul()"
  })
  void testFmul() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFmulResult = instructionSequenceBuilder.fmul();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFmulResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dmul()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dmul()}
   */
  @Test
  @DisplayName("Test dmul()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dmul()"
  })
  void testDmul() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDmulResult = instructionSequenceBuilder.dmul();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDmulResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#idiv()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#idiv()}
   */
  @Test
  @DisplayName("Test idiv()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.idiv()"
  })
  void testIdiv() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIdivResult = instructionSequenceBuilder.idiv();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIdivResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ldiv()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ldiv()}
   */
  @Test
  @DisplayName("Test ldiv()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ldiv()"
  })
  void testLdiv() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdivResult = instructionSequenceBuilder.ldiv();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdivResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fdiv()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fdiv()}
   */
  @Test
  @DisplayName("Test fdiv()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fdiv()"
  })
  void testFdiv() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFdivResult = instructionSequenceBuilder.fdiv();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFdivResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ddiv()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ddiv()}
   */
  @Test
  @DisplayName("Test ddiv()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ddiv()"
  })
  void testDdiv() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDdivResult = instructionSequenceBuilder.ddiv();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDdivResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#irem()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#irem()}
   */
  @Test
  @DisplayName("Test irem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.irem()"
  })
  void testIrem() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIremResult = instructionSequenceBuilder.irem();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIremResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lrem()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lrem()}
   */
  @Test
  @DisplayName("Test lrem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lrem()"
  })
  void testLrem() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLremResult = instructionSequenceBuilder.lrem();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLremResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#frem()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#frem()}
   */
  @Test
  @DisplayName("Test frem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.frem()"
  })
  void testFrem() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFremResult = instructionSequenceBuilder.frem();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFremResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#drem()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#drem()}
   */
  @Test
  @DisplayName("Test drem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.drem()"
  })
  void testDrem() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDremResult = instructionSequenceBuilder.drem();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDremResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ineg()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ineg()}
   */
  @Test
  @DisplayName("Test ineg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ineg()"
  })
  void testIneg() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInegResult = instructionSequenceBuilder.ineg();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInegResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lneg()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lneg()}
   */
  @Test
  @DisplayName("Test lneg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lneg()"
  })
  void testLneg() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLnegResult = instructionSequenceBuilder.lneg();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLnegResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fneg()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fneg()}
   */
  @Test
  @DisplayName("Test fneg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fneg()"
  })
  void testFneg() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFnegResult = instructionSequenceBuilder.fneg();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFnegResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dneg()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dneg()}
   */
  @Test
  @DisplayName("Test dneg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dneg()"
  })
  void testDneg() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDnegResult = instructionSequenceBuilder.dneg();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDnegResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ishl()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ishl()}
   */
  @Test
  @DisplayName("Test ishl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ishl()"
  })
  void testIshl() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIshlResult = instructionSequenceBuilder.ishl();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIshlResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lshl()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lshl()}
   */
  @Test
  @DisplayName("Test lshl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lshl()"
  })
  void testLshl() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLshlResult = instructionSequenceBuilder.lshl();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLshlResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ishr()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ishr()}
   */
  @Test
  @DisplayName("Test ishr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ishr()"
  })
  void testIshr() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIshrResult = instructionSequenceBuilder.ishr();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIshrResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lshr()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lshr()}
   */
  @Test
  @DisplayName("Test lshr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lshr()"
  })
  void testLshr() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLshrResult = instructionSequenceBuilder.lshr();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLshrResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iushr()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iushr()}
   */
  @Test
  @DisplayName("Test iushr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iushr()"
  })
  void testIushr() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIushrResult = instructionSequenceBuilder.iushr();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIushrResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lushr()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lushr()}
   */
  @Test
  @DisplayName("Test lushr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lushr()"
  })
  void testLushr() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLushrResult = instructionSequenceBuilder.lushr();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLushrResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iand()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iand()}
   */
  @Test
  @DisplayName("Test iand()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iand()"
  })
  void testIand() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIandResult = instructionSequenceBuilder.iand();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIandResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#land()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#land()}
   */
  @Test
  @DisplayName("Test land()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.land()"
  })
  void testLand() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLandResult = instructionSequenceBuilder.land();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLandResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ior()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ior()}
   */
  @Test
  @DisplayName("Test ior()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ior()"
  })
  void testIor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIorResult = instructionSequenceBuilder.ior();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIorResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lor()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lor()}
   */
  @Test
  @DisplayName("Test lor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lor()"
  })
  void testLor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLorResult = instructionSequenceBuilder.lor();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLorResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ixor()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ixor()}
   */
  @Test
  @DisplayName("Test ixor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ixor()"
  })
  void testIxor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIxorResult = instructionSequenceBuilder.ixor();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIxorResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lxor()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lxor()}
   */
  @Test
  @DisplayName("Test lxor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lxor()"
  })
  void testLxor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLxorResult = instructionSequenceBuilder.lxor();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLxorResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iinc(int, int)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  @DisplayName("Test iinc(int, int); when four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iinc(int, int)"
  })
  void testIinc_whenFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult =
        instructionSequenceBuilder.iinc(4, Integer.MIN_VALUE);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iinc(int, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  @DisplayName("Test iinc(int, int); when MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iinc(int, int)"
  })
  void testIinc_whenMin_value() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult =
        instructionSequenceBuilder.iinc(1, Integer.MIN_VALUE);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iinc(int, int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  @DisplayName("Test iinc(int, int); when minus one hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iinc(int, int)"
  })
  void testIinc_whenMinusOneHundredTwentyFour() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult = instructionSequenceBuilder.iinc(-124, 1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iinc(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  @DisplayName("Test iinc(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iinc(int, int)"
  })
  void testIinc_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult = instructionSequenceBuilder.iinc(1, 1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iinc(int, int)}.
   *
   * <ul>
   *   <li>When two hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  @DisplayName("Test iinc(int, int); when two hundred fifty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iinc(int, int)"
  })
  void testIinc_whenTwoHundredFiftyFive() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult = instructionSequenceBuilder.iinc(4, 255);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#i2l()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#i2l()}
   */
  @Test
  @DisplayName("Test i2l()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.i2l()"
  })
  void testI2l() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualI2lResult = instructionSequenceBuilder.i2l();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualI2lResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#i2f()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#i2f()}
   */
  @Test
  @DisplayName("Test i2f()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.i2f()"
  })
  void testI2f() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualI2fResult = instructionSequenceBuilder.i2f();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualI2fResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#i2d()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#i2d()}
   */
  @Test
  @DisplayName("Test i2d()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.i2d()"
  })
  void testI2d() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualI2dResult = instructionSequenceBuilder.i2d();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualI2dResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#l2i()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#l2i()}
   */
  @Test
  @DisplayName("Test l2i()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.l2i()"
  })
  void testL2i() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualL2iResult = instructionSequenceBuilder.l2i();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualL2iResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#l2f()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#l2f()}
   */
  @Test
  @DisplayName("Test l2f()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.l2f()"
  })
  void testL2f() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualL2fResult = instructionSequenceBuilder.l2f();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualL2fResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#l2d()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#l2d()}
   */
  @Test
  @DisplayName("Test l2d()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.l2d()"
  })
  void testL2d() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualL2dResult = instructionSequenceBuilder.l2d();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualL2dResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#f2i()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#f2i()}
   */
  @Test
  @DisplayName("Test f2i()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.f2i()"
  })
  void testF2i() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualF2iResult = instructionSequenceBuilder.f2i();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualF2iResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#f2l()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#f2l()}
   */
  @Test
  @DisplayName("Test f2l()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.f2l()"
  })
  void testF2l() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualF2lResult = instructionSequenceBuilder.f2l();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualF2lResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#f2d()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#f2d()}
   */
  @Test
  @DisplayName("Test f2d()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.f2d()"
  })
  void testF2d() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualF2dResult = instructionSequenceBuilder.f2d();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualF2dResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#d2i()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#d2i()}
   */
  @Test
  @DisplayName("Test d2i()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.d2i()"
  })
  void testD2i() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualD2iResult = instructionSequenceBuilder.d2i();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualD2iResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#d2l()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#d2l()}
   */
  @Test
  @DisplayName("Test d2l()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.d2l()"
  })
  void testD2l() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualD2lResult = instructionSequenceBuilder.d2l();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualD2lResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#d2f()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#d2f()}
   */
  @Test
  @DisplayName("Test d2f()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.d2f()"
  })
  void testD2f() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualD2fResult = instructionSequenceBuilder.d2f();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualD2fResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#i2b()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#i2b()}
   */
  @Test
  @DisplayName("Test i2b()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.i2b()"
  })
  void testI2b() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualI2bResult = instructionSequenceBuilder.i2b();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualI2bResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#i2c()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#i2c()}
   */
  @Test
  @DisplayName("Test i2c()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.i2c()"
  })
  void testI2c() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualI2cResult = instructionSequenceBuilder.i2c();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualI2cResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#i2s()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#i2s()}
   */
  @Test
  @DisplayName("Test i2s()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.i2s()"
  })
  void testI2s() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualI2sResult = instructionSequenceBuilder.i2s();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualI2sResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lcmp()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lcmp()}
   */
  @Test
  @DisplayName("Test lcmp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lcmp()"
  })
  void testLcmp() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLcmpResult = instructionSequenceBuilder.lcmp();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLcmpResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fcmpl()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fcmpl()}
   */
  @Test
  @DisplayName("Test fcmpl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fcmpl()"
  })
  void testFcmpl() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFcmplResult = instructionSequenceBuilder.fcmpl();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFcmplResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#fcmpg()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#fcmpg()}
   */
  @Test
  @DisplayName("Test fcmpg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.fcmpg()"
  })
  void testFcmpg() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFcmpgResult = instructionSequenceBuilder.fcmpg();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFcmpgResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dcmpl()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dcmpl()}
   */
  @Test
  @DisplayName("Test dcmpl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dcmpl()"
  })
  void testDcmpl() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDcmplResult = instructionSequenceBuilder.dcmpl();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDcmplResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dcmpg()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dcmpg()}
   */
  @Test
  @DisplayName("Test dcmpg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dcmpg()"
  })
  void testDcmpg() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDcmpgResult = instructionSequenceBuilder.dcmpg();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDcmpgResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifeq(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifeq(int)}
   */
  @Test
  @DisplayName("Test ifeq(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifeq(int)"
  })
  void testIfeq() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfeqResult = instructionSequenceBuilder.ifeq(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfeqResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifne(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifne(int)}
   */
  @Test
  @DisplayName("Test ifne(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifne(int)"
  })
  void testIfne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfneResult = instructionSequenceBuilder.ifne(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfneResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#iflt(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#iflt(int)}
   */
  @Test
  @DisplayName("Test iflt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.iflt(int)"
  })
  void testIflt() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfltResult = instructionSequenceBuilder.iflt(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfltResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifge(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifge(int)}
   */
  @Test
  @DisplayName("Test ifge(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifge(int)"
  })
  void testIfge() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfgeResult = instructionSequenceBuilder.ifge(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfgeResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifgt(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifgt(int)}
   */
  @Test
  @DisplayName("Test ifgt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifgt(int)"
  })
  void testIfgt() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfgtResult = instructionSequenceBuilder.ifgt(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfgtResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifle(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifle(int)}
   */
  @Test
  @DisplayName("Test ifle(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifle(int)"
  })
  void testIfle() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfleResult = instructionSequenceBuilder.ifle(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfleResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ificmpeq(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ificmpeq(int)}
   */
  @Test
  @DisplayName("Test ificmpeq(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ificmpeq(int)"
  })
  void testIficmpeq() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIficmpeqResult = instructionSequenceBuilder.ificmpeq(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIficmpeqResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ificmpne(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ificmpne(int)}
   */
  @Test
  @DisplayName("Test ificmpne(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ificmpne(int)"
  })
  void testIficmpne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIficmpneResult = instructionSequenceBuilder.ificmpne(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIficmpneResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ificmplt(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ificmplt(int)}
   */
  @Test
  @DisplayName("Test ificmplt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ificmplt(int)"
  })
  void testIficmplt() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIficmpltResult = instructionSequenceBuilder.ificmplt(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIficmpltResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ificmpge(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ificmpge(int)}
   */
  @Test
  @DisplayName("Test ificmpge(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ificmpge(int)"
  })
  void testIficmpge() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIficmpgeResult = instructionSequenceBuilder.ificmpge(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIficmpgeResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ificmpgt(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ificmpgt(int)}
   */
  @Test
  @DisplayName("Test ificmpgt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ificmpgt(int)"
  })
  void testIficmpgt() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIficmpgtResult = instructionSequenceBuilder.ificmpgt(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIficmpgtResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ificmple(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ificmple(int)}
   */
  @Test
  @DisplayName("Test ificmple(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ificmple(int)"
  })
  void testIficmple() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIficmpleResult = instructionSequenceBuilder.ificmple(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIficmpleResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifacmpeq(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifacmpeq(int)}
   */
  @Test
  @DisplayName("Test ifacmpeq(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifacmpeq(int)"
  })
  void testIfacmpeq() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfacmpeqResult = instructionSequenceBuilder.ifacmpeq(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfacmpeqResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifacmpne(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifacmpne(int)}
   */
  @Test
  @DisplayName("Test ifacmpne(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifacmpne(int)"
  })
  void testIfacmpne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfacmpneResult = instructionSequenceBuilder.ifacmpne(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfacmpneResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#goto_(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#goto_(int)}
   */
  @Test
  @DisplayName("Test goto_(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.goto_(int)"
  })
  void testGoto_() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualGoto_Result = instructionSequenceBuilder.goto_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGoto_Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#jsr(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#jsr(int)}
   */
  @Test
  @DisplayName("Test jsr(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.jsr(int)"
  })
  void testJsr() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualJsrResult = instructionSequenceBuilder.jsr(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualJsrResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ret(int)}.
   *
   * <ul>
   *   <li>When minus eighty-seven.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ret(int)}
   */
  @Test
  @DisplayName("Test ret(int); when minus eighty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ret(int)"
  })
  void testRet_whenMinusEightySeven() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualRetResult = instructionSequenceBuilder.ret(-87);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualRetResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ret(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ret(int)}
   */
  @Test
  @DisplayName("Test ret(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ret(int)"
  })
  void testRet_whenOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualRetResult = instructionSequenceBuilder.ret(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualRetResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#tableswitch(int, int, int, int[])}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#tableswitch(int, int, int, int[])}
   */
  @Test
  @DisplayName("Test tableswitch(int, int, int, int[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.tableswitch(int, int, int, int[])"
  })
  void testTableswitch() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualTableswitchResult =
        instructionSequenceBuilder.tableswitch(1, 1, 1, new int[] {1, -128, 1, -128});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualTableswitchResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lookupswitch(int, int[], int[])}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lookupswitch(int, int[], int[])}
   */
  @Test
  @DisplayName("Test lookupswitch(int, int[], int[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lookupswitch(int, int[], int[])"
  })
  void testLookupswitch() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLookupswitchResult =
        instructionSequenceBuilder.lookupswitch(
            1, new int[] {1, -128, 1, -128}, new int[] {1, -128, 1, -128});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLookupswitchResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ireturn()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ireturn()}
   */
  @Test
  @DisplayName("Test ireturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ireturn()"
  })
  void testIreturn() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIreturnResult = instructionSequenceBuilder.ireturn();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIreturnResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#lreturn()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#lreturn()}
   */
  @Test
  @DisplayName("Test lreturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.lreturn()"
  })
  void testLreturn() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLreturnResult = instructionSequenceBuilder.lreturn();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLreturnResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#freturn()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#freturn()}
   */
  @Test
  @DisplayName("Test freturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.freturn()"
  })
  void testFreturn() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFreturnResult = instructionSequenceBuilder.freturn();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFreturnResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#dreturn()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#dreturn()}
   */
  @Test
  @DisplayName("Test dreturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.dreturn()"
  })
  void testDreturn() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDreturnResult = instructionSequenceBuilder.dreturn();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDreturnResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#areturn()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#areturn()}
   */
  @Test
  @DisplayName("Test areturn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.areturn()"
  })
  void testAreturn() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAreturnResult = instructionSequenceBuilder.areturn();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAreturnResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#return_()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#return_()}
   */
  @Test
  @DisplayName("Test return_()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.return_()"
  })
  void testReturn_() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualReturn_Result = instructionSequenceBuilder.return_();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualReturn_Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#getstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getstatic(String, String, String)}
   */
  @Test
  @DisplayName("Test getstatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetstaticWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.getstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#getstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getstatic(String, String, String)}
   */
  @Test
  @DisplayName("Test getstatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetstaticWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.getstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#getstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test getstatic(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getstatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetstaticWithClassNameNameDescriptorReferencedClassReferencedField()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualGetstaticResult =
        instructionSequenceBuilder.getstatic(
            "Class Name", "Name", "Descriptor", referencedClass, referencedField);

    // Assert
    Constant[] constantArray =
        actualGetstaticResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[5];
    Clazz clazz = ((ClassConstant) constant).referencedClass;
    assertTrue(clazz instanceof LibraryClass);
    Constant constant2 = constantArray[6];
    Field field = ((FieldrefConstant) constant2).referencedField;
    assertTrue(field instanceof LibraryField);
    assertTrue(constant instanceof ClassConstant);
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[2];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[4];
    assertTrue(constant5 instanceof Utf8Constant);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualGetstaticResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(referencedClass, clazz);
    assertSame(referencedClass, ((FieldrefConstant) constant2).referencedClass);
    assertSame(referencedField, field);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#getstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test getstatic(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getstatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetstaticWithClassNameNameDescriptorReferencedClassReferencedField2()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualGetstaticResult =
        instructionSequenceBuilder.getstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor"));

    // Assert
    Constant[] constantArray =
        actualGetstaticResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[2];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[4];
    assertTrue(constant5 instanceof Utf8Constant);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(((FieldrefConstant) constant2).referencedClass);
    assertNull(((FieldrefConstant) constant2).referencedField);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualGetstaticResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#getstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getstatic(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getstatic(String, String, String) with 'className', 'name', 'descriptor'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetstaticWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.getstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#getstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then second element return {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getstatic(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getstatic(String, String, String) with 'className', 'name', 'descriptor'; then second element return Utf8Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetstaticWithClassNameNameDescriptor_thenSecondElementReturnUtf8Constant()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualGetstaticResult =
        instructionSequenceBuilder.getstatic("Class Name", "Name", "Descriptor");

    // Assert
    Constant[] constantArray =
        actualGetstaticResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualGetstaticResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#getstatic(Clazz, Field)} with {@code clazz}, {@code
   * field}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getstatic(Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test getstatic(Clazz, Field) with 'clazz', 'field'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getstatic(proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetstaticWithClazzField_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualGetstaticResult =
        instructionSequenceBuilder.getstatic(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#getstatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getstatic(int)}
   */
  @Test
  @DisplayName("Test getstatic(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getstatic(int)"
  })
  void testGetstaticWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#putstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putstatic(String, String, String)}
   */
  @Test
  @DisplayName("Test putstatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutstaticWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#putstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putstatic(String, String, String)}
   */
  @Test
  @DisplayName("Test putstatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutstaticWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#putstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test putstatic(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putstatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutstaticWithClassNameNameDescriptorReferencedClassReferencedField()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualPutstaticResult =
        instructionSequenceBuilder.putstatic(
            "Class Name", "Name", "Descriptor", referencedClass, referencedField);

    // Assert
    Constant[] constantArray =
        actualPutstaticResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[5];
    Clazz clazz = ((ClassConstant) constant).referencedClass;
    assertTrue(clazz instanceof LibraryClass);
    Constant constant2 = constantArray[6];
    Field field = ((FieldrefConstant) constant2).referencedField;
    assertTrue(field instanceof LibraryField);
    assertTrue(constant instanceof ClassConstant);
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[2];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[4];
    assertTrue(constant5 instanceof Utf8Constant);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualPutstaticResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(referencedClass, clazz);
    assertSame(referencedClass, ((FieldrefConstant) constant2).referencedClass);
    assertSame(referencedField, field);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#putstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test putstatic(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putstatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutstaticWithClassNameNameDescriptorReferencedClassReferencedField2()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualPutstaticResult =
        instructionSequenceBuilder.putstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor"));

    // Assert
    Constant[] constantArray =
        actualPutstaticResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[2];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[4];
    assertTrue(constant5 instanceof Utf8Constant);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(((FieldrefConstant) constant2).referencedClass);
    assertNull(((FieldrefConstant) constant2).referencedField);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualPutstaticResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#putstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putstatic(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test putstatic(String, String, String) with 'className', 'name', 'descriptor'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutstaticWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#putstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then second element return {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putstatic(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test putstatic(String, String, String) with 'className', 'name', 'descriptor'; then second element return Utf8Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putstatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutstaticWithClassNameNameDescriptor_thenSecondElementReturnUtf8Constant()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualPutstaticResult =
        instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Assert
    Constant[] constantArray =
        actualPutstaticResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualPutstaticResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#putstatic(Clazz, Field)} with {@code clazz}, {@code
   * field}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putstatic(Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test putstatic(Clazz, Field) with 'clazz', 'field'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putstatic(proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutstaticWithClazzField_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualPutstaticResult =
        instructionSequenceBuilder.putstatic(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#putstatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putstatic(int)}
   */
  @Test
  @DisplayName("Test putstatic(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putstatic(int)"
  })
  void testPutstaticWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#getfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getfield(String, String, String)}
   */
  @Test
  @DisplayName("Test getfield(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetfieldWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.getfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#getfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getfield(String, String, String)}
   */
  @Test
  @DisplayName("Test getfield(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetfieldWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.getfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#getfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getfield(String, String, String, Clazz,
   * Field)}
   */
  @Test
  @DisplayName(
      "Test getfield(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getfield(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetfieldWithClassNameNameDescriptorReferencedClassReferencedField()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualGetfieldResult =
        instructionSequenceBuilder.getfield(
            "Class Name", "Name", "Descriptor", referencedClass, referencedField);

    // Assert
    Constant[] constantArray =
        actualGetfieldResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[5];
    Clazz clazz = ((ClassConstant) constant).referencedClass;
    assertTrue(clazz instanceof LibraryClass);
    Constant constant2 = constantArray[6];
    Field field = ((FieldrefConstant) constant2).referencedField;
    assertTrue(field instanceof LibraryField);
    assertTrue(constant instanceof ClassConstant);
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[2];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[4];
    assertTrue(constant5 instanceof Utf8Constant);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualGetfieldResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(referencedClass, clazz);
    assertSame(referencedClass, ((FieldrefConstant) constant2).referencedClass);
    assertSame(referencedField, field);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#getfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getfield(String, String, String, Clazz,
   * Field)}
   */
  @Test
  @DisplayName(
      "Test getfield(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getfield(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetfieldWithClassNameNameDescriptorReferencedClassReferencedField2()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualGetfieldResult =
        instructionSequenceBuilder.getfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor"));

    // Assert
    Constant[] constantArray =
        actualGetfieldResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[2];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[4];
    assertTrue(constant5 instanceof Utf8Constant);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(((FieldrefConstant) constant2).referencedClass);
    assertNull(((FieldrefConstant) constant2).referencedField);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualGetfieldResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#getfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getfield(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getfield(String, String, String) with 'className', 'name', 'descriptor'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetfieldWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.getfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#getfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then second element return {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getfield(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getfield(String, String, String) with 'className', 'name', 'descriptor'; then second element return Utf8Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testGetfieldWithClassNameNameDescriptor_thenSecondElementReturnUtf8Constant()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualGetfieldResult =
        instructionSequenceBuilder.getfield("Class Name", "Name", "Descriptor");

    // Assert
    Constant[] constantArray =
        actualGetfieldResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualGetfieldResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#getfield(Clazz, Field)} with {@code clazz}, {@code
   * field}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getfield(Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test getfield(Clazz, Field) with 'clazz', 'field'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getfield(proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testGetfieldWithClazzField_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualGetfieldResult =
        instructionSequenceBuilder.getfield(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#getfield(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#getfield(int)}
   */
  @Test
  @DisplayName("Test getfield(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.getfield(int)"
  })
  void testGetfieldWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#putfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putfield(String, String, String)}
   */
  @Test
  @DisplayName("Test putfield(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutfieldWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.putfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#putfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putfield(String, String, String)}
   */
  @Test
  @DisplayName("Test putfield(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutfieldWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.putfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#putfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putfield(String, String, String, Clazz,
   * Field)}
   */
  @Test
  @DisplayName(
      "Test putfield(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putfield(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutfieldWithClassNameNameDescriptorReferencedClassReferencedField()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualPutfieldResult =
        instructionSequenceBuilder.putfield(
            "Class Name", "Name", "Descriptor", referencedClass, referencedField);

    // Assert
    Constant[] constantArray =
        actualPutfieldResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[5];
    Clazz clazz = ((ClassConstant) constant).referencedClass;
    assertTrue(clazz instanceof LibraryClass);
    Constant constant2 = constantArray[6];
    Field field = ((FieldrefConstant) constant2).referencedField;
    assertTrue(field instanceof LibraryField);
    assertTrue(constant instanceof ClassConstant);
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[2];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[4];
    assertTrue(constant5 instanceof Utf8Constant);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualPutfieldResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(referencedClass, clazz);
    assertSame(referencedClass, ((FieldrefConstant) constant2).referencedClass);
    assertSame(referencedField, field);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#putfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putfield(String, String, String, Clazz,
   * Field)}
   */
  @Test
  @DisplayName(
      "Test putfield(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putfield(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutfieldWithClassNameNameDescriptorReferencedClassReferencedField2()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualPutfieldResult =
        instructionSequenceBuilder.putfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor"));

    // Assert
    Constant[] constantArray =
        actualPutfieldResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[1];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[2];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[4];
    assertTrue(constant5 instanceof Utf8Constant);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(((FieldrefConstant) constant2).referencedClass);
    assertNull(((FieldrefConstant) constant2).referencedField);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualPutfieldResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#putfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putfield(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test putfield(String, String, String) with 'className', 'name', 'descriptor'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutfieldWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.putfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#putfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then second element return {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putfield(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test putfield(String, String, String) with 'className', 'name', 'descriptor'; then second element return Utf8Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putfield(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPutfieldWithClassNameNameDescriptor_thenSecondElementReturnUtf8Constant()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualPutfieldResult =
        instructionSequenceBuilder.putfield("Class Name", "Name", "Descriptor");

    // Assert
    Constant[] constantArray =
        actualPutfieldResult.getConstantPoolEditor().getTargetClass().constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualPutfieldResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes2 = "Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#putfield(Clazz, Field)} with {@code clazz}, {@code
   * field}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putfield(Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test putfield(Clazz, Field) with 'clazz', 'field'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putfield(proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testPutfieldWithClazzField_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualPutfieldResult =
        instructionSequenceBuilder.putfield(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#putfield(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#putfield(int)}
   */
  @Test
  @DisplayName("Test putfield(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.putfield(int)"
  })
  void testPutfieldWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(int, String, String)} with {@code
   * classIndex}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(int, String, String)}
   */
  @Test
  @DisplayName("Test invokevirtual(int, String, String) with 'classIndex', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(int, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassIndexNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokevirtual(1, "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(int, String, String)} with {@code
   * classIndex}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(int, String, String)}
   */
  @Test
  @DisplayName("Test invokevirtual(int, String, String) with 'classIndex', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(int, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassIndexNameDescriptor2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult =
        instructionSequenceBuilder.invokevirtual(1, "Name", "Descriptor");

    // Assert
    ProgramClass targetClass = actualInvokevirtualResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof MethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokevirtualResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(int, String, String)} with {@code
   * classIndex}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(int, String, String)}
   */
  @Test
  @DisplayName("Test invokevirtual(int, String, String) with 'classIndex', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(int, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassIndexNameDescriptor3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokevirtual(1, "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(int, String, String)} with {@code
   * classIndex}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(int, String, String)}
   */
  @Test
  @DisplayName("Test invokevirtual(int, String, String) with 'classIndex', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(int, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassIndexNameDescriptor4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokevirtual(1, "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(String, String, String)}
   */
  @Test
  @DisplayName("Test invokevirtual(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokevirtual("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(String, String, String)}
   */
  @Test
  @DisplayName("Test invokevirtual(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassNameNameDescriptor2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult =
        instructionSequenceBuilder.invokevirtual("Class Name", "Name", "Descriptor");

    // Assert
    ProgramClass targetClass = actualInvokevirtualResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof MethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokevirtualResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(String, String, String)}
   */
  @Test
  @DisplayName("Test invokevirtual(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassNameNameDescriptor3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokevirtual("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(String, String, String)}
   */
  @Test
  @DisplayName("Test invokevirtual(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokevirtualWithClassNameNameDescriptor4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokevirtual("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokevirtual(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokevirtualWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult =
        instructionSequenceBuilder.invokevirtual(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualInvokevirtualResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof MethodrefConstant);
    assertNull(constantArray[7]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualInvokevirtualResult.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokevirtual(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokevirtualWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult =
        instructionSequenceBuilder.invokevirtual(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualInvokevirtualResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof MethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokevirtualResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(Clazz, Method)} with {@code clazz}, {@code
   * method}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokevirtual(Clazz, Method) with 'clazz', 'method'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokevirtualWithClazzMethod_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult =
        instructionSequenceBuilder.invokevirtual(clazz, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokevirtual(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokevirtual(int)}
   */
  @Test
  @DisplayName("Test invokevirtual(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokevirtual(int)"
  })
  void testInvokevirtualWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult =
        instructionSequenceBuilder.invokevirtual(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial(String, String, String)}
   */
  @Test
  @DisplayName("Test invokespecial(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecialWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokespecial("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial(String, String, String)}
   */
  @Test
  @DisplayName("Test invokespecial(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecialWithClassNameNameDescriptor2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokespecialResult =
        instructionSequenceBuilder.invokespecial("Class Name", "Name", "Descriptor");

    // Assert
    ProgramClass targetClass = actualInvokespecialResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof MethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokespecialResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial(String, String, String)}
   */
  @Test
  @DisplayName("Test invokespecial(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecialWithClassNameNameDescriptor3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokespecial("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial(String, String, String)}
   */
  @Test
  @DisplayName("Test invokespecial(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecialWithClassNameNameDescriptor4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokespecial("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokespecial(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokespecialWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokespecialResult =
        instructionSequenceBuilder.invokespecial(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualInvokespecialResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof MethodrefConstant);
    assertNull(constantArray[7]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualInvokespecialResult.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokespecial(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokespecialWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokespecialResult =
        instructionSequenceBuilder.invokespecial(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualInvokespecialResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof MethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokespecialResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial(Clazz, Method)} with {@code clazz}, {@code
   * method}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial(Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokespecial(Clazz, Method) with 'clazz', 'method'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokespecialWithClazzMethod_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokespecialResult =
        instructionSequenceBuilder.invokespecial(clazz, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial(int)}
   */
  @Test
  @DisplayName("Test invokespecial(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial(int)"
  })
  void testInvokespecialWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokespecialResult =
        instructionSequenceBuilder.invokespecial(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic(String, String, String)}
   */
  @Test
  @DisplayName("Test invokestatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestaticWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokestaticResult =
        instructionSequenceBuilder.invokestatic("Class Name", "Name", "Descriptor");

    // Assert
    ProgramClass targetClass = actualInvokestaticResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof MethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokestaticResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic(String, String, String)}
   */
  @Test
  @DisplayName("Test invokestatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestaticWithClassNameNameDescriptor2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokestatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic(String, String, String)}
   */
  @Test
  @DisplayName("Test invokestatic(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestaticWithClassNameNameDescriptor3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokestatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestaticWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokestaticResult =
        instructionSequenceBuilder.invokestatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualInvokestaticResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof MethodrefConstant);
    assertNull(constantArray[7]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualInvokestaticResult.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestaticWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokestaticResult =
        instructionSequenceBuilder.invokestatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualInvokestaticResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof MethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokestaticResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test invokestatic(String, String, String) with 'className', 'name', 'descriptor'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestaticWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokestatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic(Clazz, Method)} with {@code clazz}, {@code
   * method}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic(Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic(Clazz, Method) with 'clazz', 'method'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestaticWithClazzMethod_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokestaticResult =
        instructionSequenceBuilder.invokestatic(clazz, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic(int)}
   */
  @Test
  @DisplayName("Test invokestatic(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic(int)"
  })
  void testInvokestaticWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokestaticResult =
        instructionSequenceBuilder.invokestatic(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic_interface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokestatic_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic_interface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptor2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult =
        instructionSequenceBuilder.invokestatic_interface("Class Name", "Name", "Descriptor");

    // Assert
    ProgramClass targetClass =
        actualInvokestatic_interfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof InterfaceMethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokestatic_interfaceResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic_interface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptor3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokestatic_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic_interface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptor4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokestatic_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic_interface(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult =
        instructionSequenceBuilder.invokestatic_interface(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass =
        actualInvokestatic_interfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof InterfaceMethodrefConstant);
    assertNull(constantArray[7]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualInvokestatic_interfaceResult.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic_interface(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokestatic_interface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic_interface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestatic_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult =
        instructionSequenceBuilder.invokestatic_interface(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass =
        actualInvokestatic_interfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof InterfaceMethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokestatic_interfaceResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokestatic_interface(Clazz, Method)} with {@code
   * clazz}, {@code method}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokestatic_interface(Clazz, Method)}
   */
  @Test
  @DisplayName("Test invokestatic_interface(Clazz, Method) with 'clazz', 'method'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokestatic_interface(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokestatic_interfaceWithClazzMethod() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult =
        instructionSequenceBuilder.invokestatic_interface(
            clazz, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestatic_interfaceResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial_interface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokespecial_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecial_interfaceWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokespecial_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial_interface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokespecial_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecial_interfaceWithClassNameNameDescriptor2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult =
        instructionSequenceBuilder.invokespecial_interface("Class Name", "Name", "Descriptor");

    // Assert
    ProgramClass targetClass =
        actualInvokespecial_interfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof InterfaceMethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokespecial_interfaceResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial_interface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokespecial_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecial_interfaceWithClassNameNameDescriptor3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokespecial_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial_interface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokespecial_interface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial_interface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokespecial_interfaceWithClassNameNameDescriptor4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokespecial_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial_interface(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokespecial_interface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial_interface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokespecial_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult =
        instructionSequenceBuilder.invokespecial_interface(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass =
        actualInvokespecial_interfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof InterfaceMethodrefConstant);
    assertNull(constantArray[7]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualInvokespecial_interfaceResult.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial_interface(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokespecial_interface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial_interface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokespecial_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult =
        instructionSequenceBuilder.invokespecial_interface(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass =
        actualInvokespecial_interfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof InterfaceMethodrefConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokespecial_interfaceResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokespecial_interface(Clazz, Method)} with {@code
   * clazz}, {@code method}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokespecial_interface(Clazz, Method)}
   */
  @Test
  @DisplayName("Test invokespecial_interface(Clazz, Method) with 'clazz', 'method'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokespecial_interface(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokespecial_interfaceWithClazzMethod() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult =
        instructionSequenceBuilder.invokespecial_interface(
            clazz, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecial_interfaceResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokeinterface(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokeinterface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokeinterface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult =
        instructionSequenceBuilder.invokeinterface("Class Name", "Name", "()D");

    // Assert
    ProgramClass targetClass = actualInvokeinterfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[6] instanceof InterfaceMethodrefConstant);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertNull(constantArray[9]);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualInvokeinterfaceResult.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokeinterface(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokeinterface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokeinterface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptor2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .invokeinterface("Class Name", "Name", "(D)Ljava/lang/Double;")
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(D)Ljava/lang/Double;", ((Utf8Constant) constant2).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(D)Ljava/lang/Double;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokeinterface(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokeinterface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokeinterface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptor3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "", "");

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult =
        instructionSequenceBuilder.invokeinterface("Class Name", "Name", "()D");

    // Assert
    ProgramClass targetClass = actualInvokeinterfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[4] instanceof ClassConstant);
    assertTrue(constantArray[5] instanceof FieldrefConstant);
    assertTrue(constantArray[9] instanceof InterfaceMethodrefConstant);
    assertTrue(constantArray[2] instanceof NameAndTypeConstant);
    assertTrue(constantArray[8] instanceof NameAndTypeConstant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertTrue(constantArray[7] instanceof Utf8Constant);
    assertEquals(10, targetClass.u2constantPoolCount);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokeinterfaceResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokeinterface(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokeinterface(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String) with 'className', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokeinterface(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptor4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("", "Name", "()D");
    instructionSequenceBuilder.putstatic("Class Name", "", "");

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult =
        instructionSequenceBuilder.invokeinterface("Class Name", "Name", "()D");

    // Assert
    ProgramClass targetClass = actualInvokeinterfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[9] instanceof ClassConstant);
    assertTrue(constantArray[10] instanceof FieldrefConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[11] instanceof InterfaceMethodrefConstant);
    assertTrue(constantArray[7] instanceof NameAndTypeConstant);
    assertTrue(constantArray[8] instanceof Utf8Constant);
    assertEquals(12, targetClass.u2constantPoolCount);
    assertEquals(3, instructionSequenceBuilder.size());
    assertEquals(3, actualInvokeinterfaceResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokeinterface(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokeinterface(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokeinterface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    Constant[] constantArray =
        instructionSequenceBuilder
            .invokeinterface(
                "Class Name",
                "Name",
                "()D",
                referencedClass,
                new LibraryMethod(1, "Name", "Descriptor"))
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    assertTrue(constantArray[6] instanceof InterfaceMethodrefConstant);
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("()D", ((Utf8Constant) constant2).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "()D".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokeinterface(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokeinterface(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokeinterface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2()
      throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    Constant[] constantArray =
        instructionSequenceBuilder
            .invokeinterface(
                "Class Name",
                "Name",
                "(D)Ljava/lang/Double;",
                referencedClass,
                new LibraryMethod(1, "Name", "Descriptor"))
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    assertTrue(constantArray[6] instanceof InterfaceMethodrefConstant);
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(D)Ljava/lang/Double;", ((Utf8Constant) constant2).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(D)Ljava/lang/Double;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokeinterface(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokeinterface(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test invokeinterface(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokeinterface(java.lang.String, java.lang.String, java.lang.String, proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "", "");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult =
        instructionSequenceBuilder.invokeinterface(
            "Class Name",
            "Name",
            "()D",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    ProgramClass targetClass = actualInvokeinterfaceResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[4] instanceof ClassConstant);
    assertTrue(constantArray[5] instanceof FieldrefConstant);
    assertTrue(constantArray[9] instanceof InterfaceMethodrefConstant);
    assertTrue(constantArray[2] instanceof NameAndTypeConstant);
    assertTrue(constantArray[8] instanceof NameAndTypeConstant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertTrue(constantArray[7] instanceof Utf8Constant);
    assertEquals(10, targetClass.u2constantPoolCount);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokeinterfaceResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokeinterface(int, int)} with {@code constantIndex},
   * {@code constant}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokeinterface(int, int)}
   */
  @Test
  @DisplayName("Test invokeinterface(int, int) with 'constantIndex', 'constant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokeinterface(int, int)"
  })
  void testInvokeinterfaceWithConstantIndexConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult =
        instructionSequenceBuilder.invokeinterface(1, 1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int, String, String)} with {@code
   * bootStrapMethodIndex}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String) with 'bootStrapMethodIndex', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int, java.lang.String, java.lang.String)"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptor() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokedynamic(1, "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int, String, String)} with {@code
   * bootStrapMethodIndex}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String) with 'bootStrapMethodIndex', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int, java.lang.String, java.lang.String)"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptor2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult =
        instructionSequenceBuilder.invokedynamic(1, "Name", "Descriptor");

    // Assert
    ProgramClass targetClass = actualInvokedynamicResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof InvokeDynamicConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokedynamicResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int, String, String)} with {@code
   * bootStrapMethodIndex}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String) with 'bootStrapMethodIndex', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int, java.lang.String, java.lang.String)"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptor3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokedynamic(1, "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int, String, String)} with {@code
   * bootStrapMethodIndex}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String) with 'bootStrapMethodIndex', 'name', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int, java.lang.String, java.lang.String)"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptor4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokedynamic(1, "Name", "Descriptor"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int, String, String, Clazz[])} with {@code
   * bootStrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String, Clazz[]) with 'bootStrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int, java.lang.String, java.lang.String, proguard.classfile.Clazz[])"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokedynamic(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int, String, String, Clazz[])} with {@code
   * bootStrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String, Clazz[]) with 'bootStrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int, java.lang.String, java.lang.String, proguard.classfile.Clazz[])"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult =
        instructionSequenceBuilder.invokedynamic(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass = actualInvokedynamicResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[7] instanceof InvokeDynamicConstant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualInvokedynamicResult.size());
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int, String, String, Clazz[])} with {@code
   * bootStrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String, Clazz[]) with 'bootStrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int, java.lang.String, java.lang.String, proguard.classfile.Clazz[])"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokedynamic(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int, String, String, Clazz[])} with {@code
   * bootStrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test invokedynamic(int, String, String, Clazz[]) with 'bootStrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int, java.lang.String, java.lang.String, proguard.classfile.Clazz[])"
  })
  void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.invokedynamic(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link InstructionSequenceBuilder#invokedynamic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#invokedynamic(int)}
   */
  @Test
  @DisplayName("Test invokedynamic(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.invokedynamic(int)"
  })
  void testInvokedynamicWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult =
        instructionSequenceBuilder.invokedynamic(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(String)} with {@code className}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(String)}
   */
  @Test
  @DisplayName("Test new_(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(java.lang.String)"
  })
  void testNew_WithClassName() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.new_("Class Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(String)} with {@code className}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(String)}
   */
  @Test
  @DisplayName("Test new_(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(java.lang.String)"
  })
  void testNew_WithClassName2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.new_("Class Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(String, Clazz)} with {@code className}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(String, Clazz)}
   */
  @Test
  @DisplayName("Test new_(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testNew_WithClassNameReferencedClass() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.new_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(String, Clazz)} with {@code className}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(String, Clazz)}
   */
  @Test
  @DisplayName("Test new_(String, Clazz) with 'className', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testNew_WithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.new_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(String, Clazz)} with {@code className}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test new_(String, Clazz) with 'className', 'referencedClass'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testNew_WithClassNameReferencedClass_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.new_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(String, Clazz)} with {@code className}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test new_(String, Clazz) with 'className', 'referencedClass'; then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testNew_WithClassNameReferencedClass_thenSixthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualNew_Result =
        instructionSequenceBuilder.new_("Class Name", new LibraryClass());

    // Assert
    ProgramClass targetClass = actualNew_Result.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualNew_Result.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(String)}
   */
  @Test
  @DisplayName("Test new_(String) with 'className'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(java.lang.String)"
  })
  void testNew_WithClassName_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.new_("Class Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(String)}
   */
  @Test
  @DisplayName("Test new_(String) with 'className'; then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(java.lang.String)"
  })
  void testNew_WithClassName_thenSixthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name");

    // Assert
    ProgramClass targetClass = actualNew_Result.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualNew_Result.size());
    assertEquals(7, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(Clazz)}
   */
  @Test
  @DisplayName("Test new_(Clazz) with 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(proguard.classfile.Clazz)"
  })
  void testNew_WithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.new_(new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(Clazz)} with {@code clazz}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(Clazz)}
   */
  @Test
  @DisplayName("Test new_(Clazz) with 'clazz'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(proguard.classfile.Clazz)"
  })
  void testNew_WithClazz_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.new_(
            new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#new_(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#new_(int)}
   */
  @Test
  @DisplayName("Test new_(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.new_(int)"
  })
  void testNew_WithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#newarray(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#newarray(int)}
   */
  @Test
  @DisplayName("Test newarray(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.newarray(int)"
  })
  void testNewarray() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualNewarrayResult = instructionSequenceBuilder.newarray(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNewarrayResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#anewarray(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#anewarray(int)}
   */
  @Test
  @DisplayName("Test anewarray(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.anewarray(int)"
  })
  void testAnewarrayWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAnewarrayResult = instructionSequenceBuilder.anewarray(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAnewarrayResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#anewarray(Clazz)} with {@code elementType}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#anewarray(Clazz)}
   */
  @Test
  @DisplayName("Test anewarray(Clazz) with 'elementType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.anewarray(proguard.classfile.Clazz)"
  })
  void testAnewarrayWithElementType() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.anewarray(new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#anewarray(String, Clazz)} with {@code elementTypeName},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#anewarray(String, Clazz)}
   */
  @Test
  @DisplayName("Test anewarray(String, Clazz) with 'elementTypeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.anewarray(java.lang.String, proguard.classfile.Clazz)"
  })
  void testAnewarrayWithElementTypeNameReferencedClass() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.anewarray("Element Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#anewarray(String, Clazz)} with {@code elementTypeName},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#anewarray(String, Clazz)}
   */
  @Test
  @DisplayName("Test anewarray(String, Clazz) with 'elementTypeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.anewarray(java.lang.String, proguard.classfile.Clazz)"
  })
  void testAnewarrayWithElementTypeNameReferencedClass2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.anewarray("Element Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#anewarray(String, Clazz)} with {@code elementTypeName},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#anewarray(String, Clazz)}
   */
  @Test
  @DisplayName("Test anewarray(String, Clazz) with 'elementTypeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.anewarray(java.lang.String, proguard.classfile.Clazz)"
  })
  void testAnewarrayWithElementTypeNameReferencedClass3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.anewarray("Element Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#anewarray(Clazz)} with {@code elementType}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#anewarray(Clazz)}
   */
  @Test
  @DisplayName("Test anewarray(Clazz) with 'elementType'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.anewarray(proguard.classfile.Clazz)"
  })
  void testAnewarrayWithElementType_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.anewarray(
            new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#arraylength()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#arraylength()}
   */
  @Test
  @DisplayName("Test arraylength()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.arraylength()"
  })
  void testArraylength() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualArraylengthResult = instructionSequenceBuilder.arraylength();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualArraylengthResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#athrow()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#athrow()}
   */
  @Test
  @DisplayName("Test athrow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.athrow()"
  })
  void testAthrow() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAthrowResult = instructionSequenceBuilder.athrow();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAthrowResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(int)}
   */
  @Test
  @DisplayName("Test checkcast(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(int)"
  })
  void testCheckcastWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(Clazz)} with {@code type}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(Clazz)}
   */
  @Test
  @DisplayName("Test checkcast(Clazz) with 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(proguard.classfile.Clazz)"
  })
  void testCheckcastWithType() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.checkcast(new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(String)} with {@code typeName}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(String)}
   */
  @Test
  @DisplayName("Test checkcast(String) with 'typeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(java.lang.String)"
  })
  void testCheckcastWithTypeName() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.checkcast("Type Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(String)} with {@code typeName}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(String)}
   */
  @Test
  @DisplayName("Test checkcast(String) with 'typeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(java.lang.String)"
  })
  void testCheckcastWithTypeName2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.checkcast("Type Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(String, Clazz)} with {@code typeName}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(String, Clazz)}
   */
  @Test
  @DisplayName("Test checkcast(String, Clazz) with 'typeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(java.lang.String, proguard.classfile.Clazz)"
  })
  void testCheckcastWithTypeNameReferencedClass() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.checkcast("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(String, Clazz)} with {@code typeName}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(String, Clazz)}
   */
  @Test
  @DisplayName("Test checkcast(String, Clazz) with 'typeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(java.lang.String, proguard.classfile.Clazz)"
  })
  void testCheckcastWithTypeNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.checkcast("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(String, Clazz)} with {@code typeName}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test checkcast(String, Clazz) with 'typeName', 'referencedClass'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(java.lang.String, proguard.classfile.Clazz)"
  })
  void testCheckcastWithTypeNameReferencedClass_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.checkcast("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(String)} with {@code typeName}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(String)}
   */
  @Test
  @DisplayName("Test checkcast(String) with 'typeName'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(java.lang.String)"
  })
  void testCheckcastWithTypeName_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.checkcast("Type Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#checkcast(Clazz)} with {@code type}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#checkcast(Clazz)}
   */
  @Test
  @DisplayName("Test checkcast(Clazz) with 'type'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.checkcast(proguard.classfile.Clazz)"
  })
  void testCheckcastWithType_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.checkcast(
            new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#instanceof_(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#instanceof_(int)}
   */
  @Test
  @DisplayName("Test instanceof_(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.instanceof_(int)"
  })
  void testInstanceof_WithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInstanceof_Result = instructionSequenceBuilder.instanceof_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInstanceof_Result);
  }

  /**
   * Test {@link InstructionSequenceBuilder#instanceof_(Clazz)} with {@code type}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#instanceof_(Clazz)}
   */
  @Test
  @DisplayName("Test instanceof_(Clazz) with 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.instanceof_(proguard.classfile.Clazz)"
  })
  void testInstanceof_WithType() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.instanceof_(new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#instanceof_(String, Clazz)} with {@code typeName},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#instanceof_(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceof_(String, Clazz) with 'typeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.instanceof_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceof_WithTypeNameReferencedClass() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.instanceof_("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#instanceof_(String, Clazz)} with {@code typeName},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#instanceof_(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceof_(String, Clazz) with 'typeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.instanceof_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceof_WithTypeNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.instanceof_("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#instanceof_(String, Clazz)} with {@code typeName},
   * {@code referencedClass}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#instanceof_(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test instanceof_(String, Clazz) with 'typeName', 'referencedClass'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.instanceof_(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceof_WithTypeNameReferencedClass_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.instanceof_("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#instanceof_(Clazz)} with {@code type}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#instanceof_(Clazz)}
   */
  @Test
  @DisplayName("Test instanceof_(Clazz) with 'type'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.instanceof_(proguard.classfile.Clazz)"
  })
  void testInstanceof_WithType_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.instanceof_(
            new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#monitorenter()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#monitorenter()}
   */
  @Test
  @DisplayName("Test monitorenter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.monitorenter()"
  })
  void testMonitorenter() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualMonitorenterResult = instructionSequenceBuilder.monitorenter();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMonitorenterResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#monitorexit()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#monitorexit()}
   */
  @Test
  @DisplayName("Test monitorexit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.monitorexit()"
  })
  void testMonitorexit() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualMonitorexitResult = instructionSequenceBuilder.monitorexit();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMonitorexitResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#wide()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#wide()}
   */
  @Test
  @DisplayName("Test wide()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.wide()"
  })
  void testWide() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualWideResult = instructionSequenceBuilder.wide();

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualWideResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(int)}
   */
  @Test
  @DisplayName("Test multianewarray(int) with 'constantIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(int)"
  })
  void testMultianewarrayWithConstantIndex() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult =
        instructionSequenceBuilder.multianewarray(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(Clazz)} with {@code type}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(Clazz)}
   */
  @Test
  @DisplayName("Test multianewarray(Clazz) with 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(proguard.classfile.Clazz)"
  })
  void testMultianewarrayWithType() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder, instructionSequenceBuilder.multianewarray(new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(String)} with {@code typeName}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(String)}
   */
  @Test
  @DisplayName("Test multianewarray(String) with 'typeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(java.lang.String)"
  })
  void testMultianewarrayWithTypeName() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.multianewarray("Type Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(String)} with {@code typeName}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(String)}
   */
  @Test
  @DisplayName("Test multianewarray(String) with 'typeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(java.lang.String)"
  })
  void testMultianewarrayWithTypeName2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.multianewarray("Type Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(String, Clazz)} with {@code typeName},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(String, Clazz)}
   */
  @Test
  @DisplayName("Test multianewarray(String, Clazz) with 'typeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(java.lang.String, proguard.classfile.Clazz)"
  })
  void testMultianewarrayWithTypeNameReferencedClass() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.multianewarray("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(String, Clazz)} with {@code typeName},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(String, Clazz)}
   */
  @Test
  @DisplayName("Test multianewarray(String, Clazz) with 'typeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(java.lang.String, proguard.classfile.Clazz)"
  })
  void testMultianewarrayWithTypeNameReferencedClass2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.multianewarray("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(String, Clazz)} with {@code typeName},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(String, Clazz)}
   */
  @Test
  @DisplayName("Test multianewarray(String, Clazz) with 'typeName', 'referencedClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(java.lang.String, proguard.classfile.Clazz)"
  })
  void testMultianewarrayWithTypeNameReferencedClass3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder =
        new InstructionSequenceBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.multianewarray("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(String)} with {@code typeName}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(String)}
   */
  @Test
  @DisplayName(
      "Test multianewarray(String) with 'typeName'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(java.lang.String)"
  })
  void testMultianewarrayWithTypeName_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(instructionSequenceBuilder, instructionSequenceBuilder.multianewarray("Type Name"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#multianewarray(Clazz)} with {@code type}.
   *
   * <ul>
   *   <li>Then return {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#multianewarray(Clazz)}
   */
  @Test
  @DisplayName("Test multianewarray(Clazz) with 'type'; then return InstructionSequenceBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.multianewarray(proguard.classfile.Clazz)"
  })
  void testMultianewarrayWithType_thenReturnInstructionSequenceBuilder() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act and Assert
    assertSame(
        instructionSequenceBuilder,
        instructionSequenceBuilder.multianewarray(
            new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifnull(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifnull(int)}
   */
  @Test
  @DisplayName("Test ifnull(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifnull(int)"
  })
  void testIfnull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfnullResult = instructionSequenceBuilder.ifnull(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfnullResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#ifnonnull(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#ifnonnull(int)}
   */
  @Test
  @DisplayName("Test ifnonnull(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.ifnonnull(int)"
  })
  void testIfnonnull() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIfnonnullResult = instructionSequenceBuilder.ifnonnull(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIfnonnullResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#goto_w(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#goto_w(int)}
   */
  @Test
  @DisplayName("Test goto_w(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.goto_w(int)"
  })
  void testGoto_w() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualGoto_wResult = instructionSequenceBuilder.goto_w(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGoto_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#jsr_w(int)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#jsr_w(int)}
   */
  @Test
  @DisplayName("Test jsr_w(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.jsr_w(int)"
  })
  void testJsr_w() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualJsr_wResult = instructionSequenceBuilder.jsr_w(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualJsr_wResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushPrimitive(Object, char)}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushPrimitive(Object, char)}
   */
  @Test
  @DisplayName("Test pushPrimitive(Object, char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushPrimitive(java.lang.Object, char)"
  })
  void testPushPrimitive() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitive("Value", 'A'));
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>Then fourth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test boxPrimitiveType(char); then fourth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_thenFourthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("java/lang/Byte", "java/lang/Byte", "java/lang/Byte");

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult =
        instructionSequenceBuilder.boxPrimitiveType('B');

    // Assert
    ProgramClass targetClass =
        actualBoxPrimitiveTypeResult.getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[3] instanceof ClassConstant);
    assertTrue(constantArray[4] instanceof FieldrefConstant);
    assertTrue(constantArray[8] instanceof MethodrefConstant);
    assertTrue(constantArray[2] instanceof NameAndTypeConstant);
    assertTrue(constantArray[7] instanceof NameAndTypeConstant);
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualBoxPrimitiveTypeResult.size());
    assertEquals(9, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName("Test boxPrimitiveType(char); when 'A'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).boxPrimitiveType('A'));
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code B}.
   *   <li>Then return third element String is {@code (B)Ljava/lang/Byte;}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test boxPrimitiveType(char); when 'B'; then return third element String is '(B)Ljava/lang/Byte;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenB_thenReturnThirdElementStringIsBLjavaLangByte()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .boxPrimitiveType('B')
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(B)Ljava/lang/Byte;", ((Utf8Constant) constant2).getString());
    assertEquals("java/lang/Byte", ((Utf8Constant) constant3).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(B)Ljava/lang/Byte;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "java/lang/Byte".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "valueOf".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code C}.
   *   <li>Then return third element String is {@code (C)Ljava/lang/Character;}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test boxPrimitiveType(char); when 'C'; then return third element String is '(C)Ljava/lang/Character;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenC_thenReturnThirdElementStringIsCLjavaLangCharacter()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .boxPrimitiveType('C')
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(C)Ljava/lang/Character;", ((Utf8Constant) constant2).getString());
    assertEquals("java/lang/Character", ((Utf8Constant) constant3).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(C)Ljava/lang/Character;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "java/lang/Character".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "valueOf".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code D}.
   *   <li>Then return third element String is {@code (D)Ljava/lang/Double;}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test boxPrimitiveType(char); when 'D'; then return third element String is '(D)Ljava/lang/Double;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenD_thenReturnThirdElementStringIsDLjavaLangDouble()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .boxPrimitiveType('D')
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(D)Ljava/lang/Double;", ((Utf8Constant) constant2).getString());
    assertEquals("java/lang/Double", ((Utf8Constant) constant3).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(D)Ljava/lang/Double;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "java/lang/Double".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "valueOf".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code F}.
   *   <li>Then return third element String is {@code (F)Ljava/lang/Float;}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test boxPrimitiveType(char); when 'F'; then return third element String is '(F)Ljava/lang/Float;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenF_thenReturnThirdElementStringIsFLjavaLangFloat()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .boxPrimitiveType('F')
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(F)Ljava/lang/Float;", ((Utf8Constant) constant2).getString());
    assertEquals("java/lang/Float", ((Utf8Constant) constant3).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(F)Ljava/lang/Float;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "java/lang/Float".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "valueOf".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code I}.
   *   <li>Then return third element String is {@code (I)Ljava/lang/Integer;}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test boxPrimitiveType(char); when 'I'; then return third element String is '(I)Ljava/lang/Integer;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenI_thenReturnThirdElementStringIsILjavaLangInteger()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .boxPrimitiveType('I')
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(I)Ljava/lang/Integer;", ((Utf8Constant) constant2).getString());
    assertEquals("java/lang/Integer", ((Utf8Constant) constant3).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(I)Ljava/lang/Integer;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "java/lang/Integer".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "valueOf".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code J}.
   *   <li>Then return third element String is {@code (J)Ljava/lang/Long;}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test boxPrimitiveType(char); when 'J'; then return third element String is '(J)Ljava/lang/Long;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenJ_thenReturnThirdElementStringIsJLjavaLangLong()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .boxPrimitiveType('J')
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(J)Ljava/lang/Long;", ((Utf8Constant) constant2).getString());
    assertEquals("java/lang/Long", ((Utf8Constant) constant3).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(J)Ljava/lang/Long;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "java/lang/Long".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "valueOf".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code S}.
   *   <li>Then return third element String is {@code (S)Ljava/lang/Short;}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test boxPrimitiveType(char); when 'S'; then return third element String is '(S)Ljava/lang/Short;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenS_thenReturnThirdElementStringIsSLjavaLangShort()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .boxPrimitiveType('S')
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(S)Ljava/lang/Short;", ((Utf8Constant) constant2).getString());
    assertEquals("java/lang/Short", ((Utf8Constant) constant3).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(S)Ljava/lang/Short;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "java/lang/Short".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "valueOf".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#boxPrimitiveType(char)}.
   *
   * <ul>
   *   <li>When {@code Z}.
   *   <li>Then return third element String is {@code (Z)Ljava/lang/Boolean;}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  @DisplayName(
      "Test boxPrimitiveType(char); when 'Z'; then return third element String is '(Z)Ljava/lang/Boolean;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  void testBoxPrimitiveType_whenZ_thenReturnThirdElementStringIsZLjavaLangBoolean()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new InstructionSequenceBuilder())
            .boxPrimitiveType('Z')
            .getConstantPoolEditor()
            .getTargetClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[2];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[4];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("(Z)Ljava/lang/Boolean;", ((Utf8Constant) constant2).getString());
    assertEquals("java/lang/Boolean", ((Utf8Constant) constant3).getString());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "(Z)Ljava/lang/Boolean;".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "java/lang/Boolean".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "valueOf".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}
   */
  @Test
  @DisplayName("Test unboxPrimitiveType(String, String); then sixth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.unboxPrimitiveType(java.lang.String, java.lang.String)"
  })
  void testUnboxPrimitiveType_thenSixthElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualUnboxPrimitiveTypeResult =
        instructionSequenceBuilder.unboxPrimitiveType("Source Type", "Source Type");

    // Assert
    Constant[] constantArray =
        actualUnboxPrimitiveTypeResult.getConstantPoolEditor().getTargetClass().constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, actualUnboxPrimitiveTypeResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Object;}.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}
   */
  @Test
  @DisplayName(
      "Test unboxPrimitiveType(String, String); when 'Ljava/lang/Object;'; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.unboxPrimitiveType(java.lang.String, java.lang.String)"
  })
  void testUnboxPrimitiveType_whenLjavaLangObject_thenThirdElementReturnClassConstant() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualUnboxPrimitiveTypeResult =
        instructionSequenceBuilder.unboxPrimitiveType("Ljava/lang/Object;", "Source Type");

    // Assert
    Constant[] constantArray =
        actualUnboxPrimitiveTypeResult.getConstantPoolEditor().getTargetClass().constantPool;
    assertTrue(constantArray[2] instanceof ClassConstant);
    assertTrue(constantArray[5] instanceof NameAndTypeConstant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertEquals(2, instructionSequenceBuilder.size());
    assertEquals(2, actualUnboxPrimitiveTypeResult.size());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}.
   *
   * <ul>
   *   <li>When {@code Target Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}
   */
  @Test
  @DisplayName(
      "Test unboxPrimitiveType(String, String); when 'Target Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.unboxPrimitiveType(java.lang.String, java.lang.String)"
  })
  void testUnboxPrimitiveType_whenTargetType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).unboxPrimitiveType("Source Type", "Target Type"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String, boolean)} with
   * {@code value}, {@code type}, {@code allowBoxing}.
   *
   * <ul>
   *   <li>When {@code java/lang/Void}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test pushPrimitiveOrString(Object, String, boolean) with 'value', 'type', 'allowBoxing'; when 'java/lang/Void'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushPrimitiveOrString(java.lang.Object, java.lang.String, boolean)"
  })
  void testPushPrimitiveOrStringWithValueTypeAllowBoxing_whenJavaLangVoid() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            (new InstructionSequenceBuilder()).pushPrimitiveOrString(-1, "java/lang/Void", false));
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String, boolean)} with
   * {@code value}, {@code type}, {@code allowBoxing}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test pushPrimitiveOrString(Object, String, boolean) with 'value', 'type', 'allowBoxing'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushPrimitiveOrString(java.lang.Object, java.lang.String, boolean)"
  })
  void testPushPrimitiveOrStringWithValueTypeAllowBoxing_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString(-1, null, false));
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String, boolean)} with
   * {@code value}, {@code type}, {@code allowBoxing}.
   *
   * <ul>
   *   <li>When {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test pushPrimitiveOrString(Object, String, boolean) with 'value', 'type', 'allowBoxing'; when 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushPrimitiveOrString(java.lang.Object, java.lang.String, boolean)"
  })
  void testPushPrimitiveOrStringWithValueTypeAllowBoxing_whenValue() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString("Value", "Type", true));
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String)} with {@code
   * value}, {@code type}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String)}
   */
  @Test
  @DisplayName("Test pushPrimitiveOrString(Object, String) with 'value', 'type'; when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushPrimitiveOrString(java.lang.Object, java.lang.String)"
  })
  void testPushPrimitiveOrStringWithValueType_whenMinusOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString(-1, null));
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String)} with {@code
   * value}, {@code type}.
   *
   * <ul>
   *   <li>When {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String)}
   */
  @Test
  @DisplayName("Test pushPrimitiveOrString(Object, String) with 'value', 'type'; when 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushPrimitiveOrString(java.lang.Object, java.lang.String)"
  })
  void testPushPrimitiveOrStringWithValueType_whenValue() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString("Value", "Type"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushBoxedPrimitive(Object, String)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushBoxedPrimitive(Object, String)}
   */
  @Test
  @DisplayName(
      "Test pushBoxedPrimitive(Object, String); when 'Value'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushBoxedPrimitive(java.lang.Object, java.lang.String)"
  })
  void testPushBoxedPrimitive_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushBoxedPrimitive("Value", "Type"));
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when five; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenFive_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(5);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when forty-two; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenFortyTwo_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(42);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when four; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenFour_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(4);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then second element return {@link IntegerConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when MIN_VALUE; then second element return IntegerConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenMin_value_thenSecondElementReturnIntegerConstant() {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushInt(Integer.MIN_VALUE)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof IntegerConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(2, targetClass.u2constantPoolCount);
    assertEquals(3, constant.getTag());
    assertFalse(constant.isCategory2());
    assertEquals(Integer.MIN_VALUE, ((IntegerConstant) constant).getValue());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when minus one; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenMinusOne_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(-1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when one; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when three; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenThree_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(3);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when two; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenTwo_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(2);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushInt(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  @DisplayName("Test pushInt(int); when zero; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushInt(int)"
  })
  void testPushInt_whenZero_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(0);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushFloat(float)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float); when one; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushFloat(float)"
  })
  void testPushFloat_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushFloatResult = instructionSequenceBuilder.pushFloat(1.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushFloatResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushFloat(float)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then second element return {@link FloatConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float); when ten; then second element return FloatConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushFloat(float)"
  })
  void testPushFloat_whenTen_thenSecondElementReturnFloatConstant() {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushFloat(10.0f)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof FloatConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(10.0f, ((FloatConstant) constant).getValue());
    assertEquals(2, targetClass.u2constantPoolCount);
    assertEquals(4, constant.getTag());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushFloat(float)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float); when two; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushFloat(float)"
  })
  void testPushFloat_whenTwo_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushFloatResult = instructionSequenceBuilder.pushFloat(2.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushFloatResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushFloat(float)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushFloat(float)}
   */
  @Test
  @DisplayName("Test pushFloat(float); when zero; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushFloat(float)"
  })
  void testPushFloat_whenZero_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushFloatResult = instructionSequenceBuilder.pushFloat(0.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushFloatResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushLong(long)}.
   *
   * <ul>
   *   <li>Given {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   *   <li>Then second element return {@link LongConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushLong(long)}
   */
  @Test
  @DisplayName(
      "Test pushLong(long); given InstructionSequenceBuilder(); then second element return LongConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushLong(long)"
  })
  void testPushLong_givenInstructionSequenceBuilder_thenSecondElementReturnLongConstant() {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder()).pushLong(42L).getConstantPoolEditor().getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof LongConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(42L, ((LongConstant) constant).getValue());
    assertEquals(5, constant.getTag());
    assertTrue(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushLong(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushLong(long)}
   */
  @Test
  @DisplayName("Test pushLong(long); when one; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushLong(long)"
  })
  void testPushLong_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushLongResult = instructionSequenceBuilder.pushLong(1L);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushLongResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushLong(long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushLong(long)}
   */
  @Test
  @DisplayName("Test pushLong(long); when zero; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushLong(long)"
  })
  void testPushLong_whenZero_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushLongResult = instructionSequenceBuilder.pushLong(0L);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushLongResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushDouble(double)}.
   *
   * <ul>
   *   <li>Then second element return {@link DoubleConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushDouble(double)}
   */
  @Test
  @DisplayName("Test pushDouble(double); then second element return DoubleConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushDouble(double)"
  })
  void testPushDouble_thenSecondElementReturnDoubleConstant() {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushDouble(10.0d)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof DoubleConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(10.0d, ((DoubleConstant) constant).getValue());
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(6, constant.getTag());
    assertTrue(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushDouble(double)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushDouble(double)}
   */
  @Test
  @DisplayName("Test pushDouble(double); when one; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushDouble(double)"
  })
  void testPushDouble_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushDoubleResult = instructionSequenceBuilder.pushDouble(1.0d);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushDoubleResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushDouble(double)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushDouble(double)}
   */
  @Test
  @DisplayName("Test pushDouble(double); when zero; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushDouble(double)"
  })
  void testPushDouble_whenZero_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushDoubleResult = instructionSequenceBuilder.pushDouble(0.0d);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushDoubleResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName("Test pushNewArray(String, int); when five; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenFive_thenThirdElementReturnClassConstant()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", 5)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Type", ((Utf8Constant) constant2).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[3]);
    assertEquals(1, constant2.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Type".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName("Test pushNewArray(String, int); when four; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenFour_thenThirdElementReturnClassConstant()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", 4)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Type", ((Utf8Constant) constant2).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[3]);
    assertEquals(1, constant2.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Type".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then fourth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName(
      "Test pushNewArray(String, int); when MIN_VALUE; then fourth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenMin_value_thenFourthElementReturnClassConstant() {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", Integer.MIN_VALUE)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[3] instanceof ClassConstant);
    assertTrue(constantArray[1] instanceof IntegerConstant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertEquals(4, targetClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName("Test pushNewArray(String, int); when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenMinusOneHundredTwentyEight() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", -128)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Type", ((Utf8Constant) constant2).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[3]);
    assertEquals(1, constant2.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Type".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName(
      "Test pushNewArray(String, int); when minus one; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenMinusOne_thenThirdElementReturnClassConstant()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", -1)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Type", ((Utf8Constant) constant2).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[3]);
    assertEquals(1, constant2.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Type".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName("Test pushNewArray(String, int); when one; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenOne_thenThirdElementReturnClassConstant()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", 1)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Type", ((Utf8Constant) constant2).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[3]);
    assertEquals(1, constant2.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Type".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName(
      "Test pushNewArray(String, int); when three; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenThree_thenThirdElementReturnClassConstant()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", 3)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Type", ((Utf8Constant) constant2).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[3]);
    assertEquals(1, constant2.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Type".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName("Test pushNewArray(String, int); when two; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenTwo_thenThirdElementReturnClassConstant()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", 2)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Type", ((Utf8Constant) constant2).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[3]);
    assertEquals(1, constant2.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Type".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushNewArray(String, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  @DisplayName("Test pushNewArray(String, int); when zero; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushNewArray(java.lang.String, int)"
  })
  void testPushNewArray_whenZero_thenThirdElementReturnClassConstant()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new InstructionSequenceBuilder())
            .pushNewArray("Type", 0)
            .getConstantPoolEditor()
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Type", ((Utf8Constant) constant2).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertNull(((ClassConstant) constant).referencedClass);
    assertNull(constantArray[3]);
    assertEquals(1, constant2.getTag());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant2.isCategory2());
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Type".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushPrimitiveOrStringArray(String, Object[])}.
   *
   * <ul>
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is
   *       seventy-five.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushPrimitiveOrStringArray(String,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test pushPrimitiveOrStringArray(String, Object[]); then InstructionSequenceBuilder() size is seventy-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushPrimitiveOrStringArray(java.lang.String, java.lang.Object[])"
  })
  void testPushPrimitiveOrStringArray_thenInstructionSequenceBuilderSizeIsSeventyFive() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushPrimitiveOrStringArrayResult =
        instructionSequenceBuilder.pushPrimitiveOrStringArray(
            "Ljava/lang/String;",
            new Object[] {
              "42", "42", "42", "42", "42", "42", "42", "42", "42", "42", "42", "42", "42", "42",
              "42", "42", "42", "42"
            });

    // Assert
    assertEquals(75, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushPrimitiveOrStringArrayResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushPrimitiveOrStringArray(String, Object[])}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushPrimitiveOrStringArray(String,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test pushPrimitiveOrStringArray(String, Object[]); when 'Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushPrimitiveOrStringArray(java.lang.String, java.lang.Object[])"
  })
  void testPushPrimitiveOrStringArray_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            (new InstructionSequenceBuilder())
                .pushPrimitiveOrStringArray("Type", new Object[] {"Values"}));
  }

  /**
   * Test {@link InstructionSequenceBuilder#pushDefault(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#pushDefault(String)}
   */
  @Test
  @DisplayName(
      "Test pushDefault(String); when 'Type'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.pushDefault(java.lang.String)"
  })
  void testPushDefault_whenType_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushDefaultResult =
        instructionSequenceBuilder.pushDefault("Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushDefaultResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, char)"
  })
  void testLoadWithIntChar_whenA() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'A');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, char)"
  })
  void testLoadWithIntChar_whenB() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'B');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, char)"
  })
  void testLoadWithIntChar_whenD() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'D');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, char)"
  })
  void testLoadWithIntChar_whenF() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'F');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, char)"
  })
  void testLoadWithIntChar_whenJ() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'J');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  @DisplayName("Test load(int, char) with 'int', 'char'; when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, char)"
  })
  void testLoadWithIntChar_whenMinusOneHundredTwentyEight() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(-128, 'C');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, String)}
   */
  @Test
  @DisplayName("Test load(int, String) with 'int', 'String'; when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, java.lang.String)"
  })
  void testLoadWithIntString_whenMinusOneHundredTwentyEight() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(-128, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, String)}
   */
  @Test
  @DisplayName(
      "Test load(int, String) with 'int', 'String'; when one; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, java.lang.String)"
  })
  void testLoadWithIntString_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#load(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When sixty-six.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#load(int, String)}
   */
  @Test
  @DisplayName(
      "Test load(int, String) with 'int', 'String'; when sixty-six; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.load(int, java.lang.String)"
  })
  void testLoadWithIntString_whenSixtySix_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(66, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, char)"
  })
  void testStoreWithIntChar_whenA() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'A');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, char)"
  })
  void testStoreWithIntChar_whenB() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'B');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, char)"
  })
  void testStoreWithIntChar_whenD() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'D');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, char)"
  })
  void testStoreWithIntChar_whenF() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'F');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when 'J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, char)"
  })
  void testStoreWithIntChar_whenJ() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'J');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  @DisplayName("Test store(int, char) with 'int', 'char'; when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, char)"
  })
  void testStoreWithIntChar_whenMinusOneHundredTwentyEight() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(-128, 'C');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, String)}
   */
  @Test
  @DisplayName("Test store(int, String) with 'int', 'String'; when minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, java.lang.String)"
  })
  void testStoreWithIntString_whenMinusOneHundredTwentyEight() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(-128, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, String)}
   */
  @Test
  @DisplayName(
      "Test store(int, String) with 'int', 'String'; when one; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, java.lang.String)"
  })
  void testStoreWithIntString_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#store(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When sixty-six.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#store(int, String)}
   */
  @Test
  @DisplayName(
      "Test store(int, String) with 'int', 'String'; when sixty-six; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.store(int, java.lang.String)"
  })
  void testStoreWithIntString_whenSixtySix_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(66, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#storeToArray(String)}.
   *
   * <ul>
   *   <li>When {@code Element Type}.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#storeToArray(String)}
   */
  @Test
  @DisplayName(
      "Test storeToArray(String); when 'Element Type'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.storeToArray(java.lang.String)"
  })
  void testStoreToArray_whenElementType_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreToArrayResult =
        instructionSequenceBuilder.storeToArray("Element Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreToArrayResult);
  }

  /**
   * Test {@link InstructionSequenceBuilder#loadFromArray(String)}.
   *
   * <ul>
   *   <li>When {@code Element Type}.
   *   <li>Then {@link InstructionSequenceBuilder#InstructionSequenceBuilder()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#loadFromArray(String)}
   */
  @Test
  @DisplayName(
      "Test loadFromArray(String); when 'Element Type'; then InstructionSequenceBuilder() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceBuilder proguard.classfile.editor.InstructionSequenceBuilder.loadFromArray(java.lang.String)"
  })
  void testLoadFromArray_whenElementType_thenInstructionSequenceBuilderSizeIsOne() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadFromArrayResult =
        instructionSequenceBuilder.loadFromArray("Element Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadFromArrayResult);
  }
}

package proguard.classfile.editor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class InstructionSequenceBuilderDiffblueTest {
  /**
   * Test {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>()"})
  public void testNewInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>(ConstantPoolEditor)"})
  public void testNewInstructionSequenceBuilder2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewInstructionSequenceBuilder_givenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>(ProgramClass)"})
  public void testNewInstructionSequenceBuilder_givenTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewInstructionSequenceBuilder_givenTwo2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>(ClassPool, ClassPool)"})
  public void testNewInstructionSequenceBuilder_whenDummyClassPool() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>(ClassPool, ClassPool)"})
  public void testNewInstructionSequenceBuilder_whenNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>(ProgramClass)"})
  public void testNewInstructionSequenceBuilder_whenProgramClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InstructionSequenceBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewInstructionSequenceBuilder_whenProgramClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ConstantPoolEditor InstructionSequenceBuilder.getConstantPoolEditor()"})
  public void testGetConstantPoolEditor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.label(Instruction)"})
  public void testLabel() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.catch_(Instruction)"})
  public void testCatch_() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.line(Instruction)"})
  public void testLine() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.appendInstruction(Instruction)"
  })
  public void testAppendInstruction() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction[] InstructionSequenceBuilder.__()"})
  public void test__() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).__().length);
  }

  /**
   * Test {@link InstructionSequenceBuilder#instructions()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#instructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction[] InstructionSequenceBuilder.instructions()"})
  public void testInstructions() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Constant[] InstructionSequenceBuilder.constants()"})
  public void testConstants_givenInstructionSequenceBuilder_thenReturnFirstElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceBuilder.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).size());
  }

  /**
   * Test {@link InstructionSequenceBuilder#nop()}.
   *
   * <p>Method under test: {@link InstructionSequenceBuilder#nop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.nop()"})
  public void testNop() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aconst_null()"})
  public void testAconst_null() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst(int)"})
  public void testIconst_whenMinusTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst(int)"})
  public void testIconst_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst(int)"})
  public void testIconst_whenSix() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst_m1()"})
  public void testIconst_m1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst_0()"})
  public void testIconst_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst_1()"})
  public void testIconst_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst_2()"})
  public void testIconst_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst_3()"})
  public void testIconst_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst_4()"})
  public void testIconst_4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iconst_5()"})
  public void testIconst_5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lconst(int)"})
  public void testLconst_whenMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lconst(int)"})
  public void testLconst_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lconst(int)"})
  public void testLconst_whenZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lconst_0()"})
  public void testLconst_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lconst_1()"})
  public void testLconst_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fconst(int)"})
  public void testFconst_whenFive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fconst(int)"})
  public void testFconst_whenMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fconst(int)"})
  public void testFconst_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fconst_0()"})
  public void testFconst_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fconst_1()"})
  public void testFconst_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fconst_2()"})
  public void testFconst_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dconst(int)"})
  public void testDconst_whenMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dconst(int)"})
  public void testDconst_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dconst(int)"})
  public void testDconst_whenZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dconst_0()"})
  public void testDconst_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dconst_1()"})
  public void testDconst_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.bipush(int)"})
  public void testBipush() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.sipush(int)"})
  public void testSipush() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz)"})
  public void testLdcWithClazz() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, ConstantVisitor)"
  })
  public void testLdcWithClazzConstantVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, ConstantVisitor)"
  })
  public void testLdcWithClazzConstantVisitor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, ConstantVisitor)"
  })
  public void testLdcWithClazzConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, ConstantVisitor)"
  })
  public void testLdcWithClazzConstantVisitor_whenNull_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, Member)"})
  public void testLdcWithClazzMember() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, Member)"})
  public void testLdcWithClazzMember2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, Member, ConstantVisitor)"
  })
  public void testLdcWithClazzMemberConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, Member, ConstantVisitor)"
  })
  public void testLdcWithClazzMemberConstantVisitor_whenNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, Member)"})
  public void testLdcWithClazzMember_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz, Member)"})
  public void testLdcWithClazzMember_thenSixthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Clazz)"})
  public void testLdcWithClazz_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(float)"})
  public void testLdcWithFloat() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(float)"})
  public void testLdcWithFloat2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(float, ConstantVisitor)"
  })
  public void testLdcWithFloatConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(float, ConstantVisitor)"
  })
  public void testLdcWithFloatConstantVisitor_whenNull_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(float)"})
  public void testLdcWithFloat_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(int)"})
  public void testLdcWithInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(int, ConstantVisitor)"
  })
  public void testLdcWithIntConstantVisitor_whenConstantCounter_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(int, ConstantVisitor)"
  })
  public void testLdcWithIntConstantVisitor_whenNull_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(int)"})
  public void testLdcWithInt_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(int)"})
  public void testLdcWithInt_thenReturnInstructionSequenceBuilderWithTargetClassIsProgramClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Object)"})
  public void testLdcWithObject() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Object)"})
  public void testLdcWithObject2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Object, ConstantVisitor)"
  })
  public void testLdcWithObjectConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Object, ConstantVisitor)"
  })
  public void testLdcWithObjectConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(Object)"})
  public void testLdcWithObject_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(ResourceFile)"})
  public void testLdcWithResourceFile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(ResourceFile)"})
  public void testLdcWithResourceFile2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(ResourceFile, ConstantVisitor)"
  })
  public void testLdcWithResourceFileConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(ResourceFile, ConstantVisitor)"
  })
  public void testLdcWithResourceFileConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(ResourceFile)"})
  public void testLdcWithResourceFile_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String)"})
  public void testLdcWithString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String)"})
  public void testLdcWithString2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz)"})
  public void testLdcWithStringClazz() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz)"})
  public void testLdcWithStringClazz2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz, ConstantVisitor)"
  })
  public void testLdcWithStringClazzConstantVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz, ConstantVisitor)"
  })
  public void testLdcWithStringClazzConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz, ConstantVisitor)"
  })
  public void testLdcWithStringClazzConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz, Member)"
  })
  public void testLdcWithStringClazzMember() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz, Member)"
  })
  public void testLdcWithStringClazzMember2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz, Member, ConstantVisitor)"
  })
  public void testLdcWithStringClazzMemberConstantVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz, Member, ConstantVisitor)"
  })
  public void testLdcWithStringClazzMemberConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz, Member)"
  })
  public void testLdcWithStringClazzMember_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, Clazz)"})
  public void testLdcWithStringClazz_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, ConstantVisitor)"
  })
  public void testLdcWithStringConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, ConstantVisitor)"
  })
  public void testLdcWithStringConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, ResourceFile)"
  })
  public void testLdcWithStringResourceFile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, ResourceFile)"
  })
  public void testLdcWithStringResourceFile2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, ResourceFile, ConstantVisitor)"
  })
  public void testLdcWithStringResourceFileConstantVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, ResourceFile, ConstantVisitor)"
  })
  public void testLdcWithStringResourceFileConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String, ResourceFile)"
  })
  public void testLdcWithStringResourceFile_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc(String)"})
  public void testLdcWithString_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_(int)"})
  public void testLdc_WithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_(int, ConstantVisitor)"
  })
  public void testLdc_WithConstantIndexVisitor_thenReturnSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_(int, ConstantVisitor)"
  })
  public void testLdc_WithConstantIndexVisitor_thenSixthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_(int, ConstantVisitor)"
  })
  public void testLdc_WithConstantIndexVisitor_whenNull_thenReturnSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz)"})
  public void testLdc_wWithClazz() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, ConstantVisitor)"
  })
  public void testLdc_wWithClazzConstantVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, ConstantVisitor)"
  })
  public void testLdc_wWithClazzConstantVisitor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, ConstantVisitor)"
  })
  public void testLdc_wWithClazzConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, ConstantVisitor)"
  })
  public void testLdc_wWithClazzConstantVisitor_whenNull_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, Member)"})
  public void testLdc_wWithClazzMember() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, Member)"})
  public void testLdc_wWithClazzMember2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, Member, ConstantVisitor)"
  })
  public void testLdc_wWithClazzMemberConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, Member, ConstantVisitor)"
  })
  public void testLdc_wWithClazzMemberConstantVisitor_whenNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, Member)"})
  public void testLdc_wWithClazzMember_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz, Member)"})
  public void testLdc_wWithClazzMember_thenSixthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Clazz)"})
  public void testLdc_wWithClazz_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(float)"})
  public void testLdc_wWithFloat() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(float)"})
  public void testLdc_wWithFloat2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(float, ConstantVisitor)"
  })
  public void testLdc_wWithFloatConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(float, ConstantVisitor)"
  })
  public void testLdc_wWithFloatConstantVisitor_whenNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(float)"})
  public void testLdc_wWithFloat_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(int)"})
  public void testLdc_wWithInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(int)"})
  public void testLdc_wWithInt2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(int, ConstantVisitor)"
  })
  public void testLdc_wWithIntConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(int, ConstantVisitor)"
  })
  public void testLdc_wWithIntConstantVisitor_whenNull_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(int)"})
  public void testLdc_wWithInt_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Object)"})
  public void testLdc_wWithObject() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Object)"})
  public void testLdc_wWithObject2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Object, ConstantVisitor)"
  })
  public void testLdc_wWithObjectConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Object, ConstantVisitor)"
  })
  public void testLdc_wWithObjectConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(Object)"})
  public void testLdc_wWithObject_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(ResourceFile)"})
  public void testLdc_wWithResourceFile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(ResourceFile)"})
  public void testLdc_wWithResourceFile2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(ResourceFile, ConstantVisitor)"
  })
  public void testLdc_wWithResourceFileConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(ResourceFile, ConstantVisitor)"
  })
  public void testLdc_wWithResourceFileConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(ResourceFile)"})
  public void testLdc_wWithResourceFile_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String)"})
  public void testLdc_wWithString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String)"})
  public void testLdc_wWithString2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz)"})
  public void testLdc_wWithStringClazz() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz)"})
  public void testLdc_wWithStringClazz2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz, ConstantVisitor)"
  })
  public void testLdc_wWithStringClazzConstantVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz, ConstantVisitor)"
  })
  public void testLdc_wWithStringClazzConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz, ConstantVisitor)"
  })
  public void testLdc_wWithStringClazzConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz, Member)"
  })
  public void testLdc_wWithStringClazzMember() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz, Member)"
  })
  public void testLdc_wWithStringClazzMember2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz, Member, ConstantVisitor)"
  })
  public void testLdc_wWithStringClazzMemberConstantVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz, Member, ConstantVisitor)"
  })
  public void testLdc_wWithStringClazzMemberConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz, Member)"
  })
  public void testLdc_wWithStringClazzMember_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, Clazz)"})
  public void testLdc_wWithStringClazz_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, ConstantVisitor)"
  })
  public void testLdc_wWithStringConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, ConstantVisitor)"
  })
  public void testLdc_wWithStringConstantVisitor_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, ResourceFile)"
  })
  public void testLdc_wWithStringResourceFile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, ResourceFile)"
  })
  public void testLdc_wWithStringResourceFile2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, ResourceFile, ConstantVisitor)"
  })
  public void testLdc_wWithStringResourceFileConstantVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, ResourceFile, ConstantVisitor)"
  })
  public void testLdc_wWithStringResourceFileConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String, ResourceFile)"
  })
  public void testLdc_wWithStringResourceFile_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w(String)"})
  public void testLdc_wWithString_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w_(int)"})
  public void testLdc_w_WithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w_(int, ConstantVisitor)"
  })
  public void testLdc_w_WithConstantIndexVisitor_thenReturnSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w_(int, ConstantVisitor)"
  })
  public void testLdc_w_WithConstantIndexVisitor_thenSixthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc_w_(int, ConstantVisitor)"
  })
  public void testLdc_w_WithConstantIndexVisitor_whenNull_thenReturnSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(double)"})
  public void testLdc2_wWithDouble() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(double)"})
  public void testLdc2_wWithDouble2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(double, ConstantVisitor)"
  })
  public void testLdc2_wWithDoubleConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(double, ConstantVisitor)"
  })
  public void testLdc2_wWithDoubleConstantVisitor_whenNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(double)"})
  public void testLdc2_wWithDouble_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(int)"})
  public void testLdc2_wWithInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(int, ConstantVisitor)"
  })
  public void testLdc2_wWithIntConstantVisitor_thenReturnSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(int, ConstantVisitor)"
  })
  public void testLdc2_wWithIntConstantVisitor_thenSixthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(int, ConstantVisitor)"
  })
  public void testLdc2_wWithIntConstantVisitor_whenNull_thenReturnSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(long)"})
  public void testLdc2_wWithLong() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(long)"})
  public void testLdc2_wWithLong2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(long, ConstantVisitor)"
  })
  public void testLdc2_wWithLongConstantVisitor_thenConstantCounterCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(long, ConstantVisitor)"
  })
  public void testLdc2_wWithLongConstantVisitor_whenNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldc2_w(long)"})
  public void testLdc2_wWithLong_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iload(int)"})
  public void testIload_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iload(int)"})
  public void testIload_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iload(int)"})
  public void testIload_whenTwentyOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lload(int)"})
  public void testLload_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lload(int)"})
  public void testLload_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lload(int)"})
  public void testLload_whenTwentyTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fload(int)"})
  public void testFload_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fload(int)"})
  public void testFload_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fload(int)"})
  public void testFload_whenTwentyThree() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dload(int)"})
  public void testDload_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dload(int)"})
  public void testDload_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dload(int)"})
  public void testDload_whenTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aload(int)"})
  public void testAload_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aload(int)"})
  public void testAload_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aload(int)"})
  public void testAload_whenTwentyFive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iload_0()"})
  public void testIload_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iload_1()"})
  public void testIload_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iload_2()"})
  public void testIload_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iload_3()"})
  public void testIload_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lload_0()"})
  public void testLload_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lload_1()"})
  public void testLload_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lload_2()"})
  public void testLload_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lload_3()"})
  public void testLload_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fload_0()"})
  public void testFload_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fload_1()"})
  public void testFload_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fload_2()"})
  public void testFload_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fload_3()"})
  public void testFload_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dload_0()"})
  public void testDload_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dload_1()"})
  public void testDload_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dload_2()"})
  public void testDload_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dload_3()"})
  public void testDload_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aload_0()"})
  public void testAload_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aload_1()"})
  public void testAload_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aload_2()"})
  public void testAload_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aload_3()"})
  public void testAload_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iaload()"})
  public void testIaload() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.laload()"})
  public void testLaload() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.faload()"})
  public void testFaload() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.daload()"})
  public void testDaload() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aaload()"})
  public void testAaload() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.baload()"})
  public void testBaload() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.caload()"})
  public void testCaload() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.saload()"})
  public void testSaload() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.istore(int)"})
  public void testIstore_whenFiftyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.istore(int)"})
  public void testIstore_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.istore(int)"})
  public void testIstore_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lstore(int)"})
  public void testLstore_whenFiftyFive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lstore(int)"})
  public void testLstore_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lstore(int)"})
  public void testLstore_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fstore(int)"})
  public void testFstore_whenFiftySix() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fstore(int)"})
  public void testFstore_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fstore(int)"})
  public void testFstore_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dstore(int)"})
  public void testDstore_whenFiftySeven() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dstore(int)"})
  public void testDstore_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dstore(int)"})
  public void testDstore_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.astore(int)"})
  public void testAstore_whenFiftyEight() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.astore(int)"})
  public void testAstore_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.astore(int)"})
  public void testAstore_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.istore_0()"})
  public void testIstore_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.istore_1()"})
  public void testIstore_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.istore_2()"})
  public void testIstore_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.istore_3()"})
  public void testIstore_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lstore_0()"})
  public void testLstore_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lstore_1()"})
  public void testLstore_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lstore_2()"})
  public void testLstore_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lstore_3()"})
  public void testLstore_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fstore_0()"})
  public void testFstore_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fstore_1()"})
  public void testFstore_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fstore_2()"})
  public void testFstore_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fstore_3()"})
  public void testFstore_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dstore_0()"})
  public void testDstore_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dstore_1()"})
  public void testDstore_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dstore_2()"})
  public void testDstore_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dstore_3()"})
  public void testDstore_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.astore_0()"})
  public void testAstore_0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.astore_1()"})
  public void testAstore_1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.astore_2()"})
  public void testAstore_2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.astore_3()"})
  public void testAstore_3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iastore()"})
  public void testIastore() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lastore()"})
  public void testLastore() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fastore()"})
  public void testFastore() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dastore()"})
  public void testDastore() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.aastore()"})
  public void testAastore() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.bastore()"})
  public void testBastore() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.castore()"})
  public void testCastore() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.sastore()"})
  public void testSastore() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pop()"})
  public void testPop() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pop2()"})
  public void testPop2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dup()"})
  public void testDup() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dup_x1()"})
  public void testDup_x1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dup_x2()"})
  public void testDup_x2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dup2()"})
  public void testDup2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dup2_x1()"})
  public void testDup2_x1() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dup2_x2()"})
  public void testDup2_x2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.swap()"})
  public void testSwap() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iadd()"})
  public void testIadd() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ladd()"})
  public void testLadd() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fadd()"})
  public void testFadd() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dadd()"})
  public void testDadd() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.isub()"})
  public void testIsub() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lsub()"})
  public void testLsub() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fsub()"})
  public void testFsub() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dsub()"})
  public void testDsub() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.imul()"})
  public void testImul() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lmul()"})
  public void testLmul() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fmul()"})
  public void testFmul() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dmul()"})
  public void testDmul() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.idiv()"})
  public void testIdiv() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ldiv()"})
  public void testLdiv() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fdiv()"})
  public void testFdiv() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ddiv()"})
  public void testDdiv() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.irem()"})
  public void testIrem() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lrem()"})
  public void testLrem() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.frem()"})
  public void testFrem() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.drem()"})
  public void testDrem() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ineg()"})
  public void testIneg() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lneg()"})
  public void testLneg() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fneg()"})
  public void testFneg() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dneg()"})
  public void testDneg() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ishl()"})
  public void testIshl() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lshl()"})
  public void testLshl() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ishr()"})
  public void testIshr() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lshr()"})
  public void testLshr() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iushr()"})
  public void testIushr() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lushr()"})
  public void testLushr() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iand()"})
  public void testIand() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.land()"})
  public void testLand() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ior()"})
  public void testIor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lor()"})
  public void testLor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ixor()"})
  public void testIxor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lxor()"})
  public void testLxor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iinc(int, int)"})
  public void testIinc_whenFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iinc(int, int)"})
  public void testIinc_whenMin_value() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iinc(int, int)"})
  public void testIinc_whenMinusOneHundredTwentyFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iinc(int, int)"})
  public void testIinc_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iinc(int, int)"})
  public void testIinc_whenTwoHundredFiftyFive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.i2l()"})
  public void testI2l() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.i2f()"})
  public void testI2f() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.i2d()"})
  public void testI2d() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.l2i()"})
  public void testL2i() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.l2f()"})
  public void testL2f() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.l2d()"})
  public void testL2d() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.f2i()"})
  public void testF2i() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.f2l()"})
  public void testF2l() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.f2d()"})
  public void testF2d() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.d2i()"})
  public void testD2i() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.d2l()"})
  public void testD2l() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.d2f()"})
  public void testD2f() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.i2b()"})
  public void testI2b() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.i2c()"})
  public void testI2c() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.i2s()"})
  public void testI2s() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lcmp()"})
  public void testLcmp() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fcmpl()"})
  public void testFcmpl() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.fcmpg()"})
  public void testFcmpg() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dcmpl()"})
  public void testDcmpl() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dcmpg()"})
  public void testDcmpg() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifeq(int)"})
  public void testIfeq() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifne(int)"})
  public void testIfne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.iflt(int)"})
  public void testIflt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifge(int)"})
  public void testIfge() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifgt(int)"})
  public void testIfgt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifle(int)"})
  public void testIfle() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ificmpeq(int)"})
  public void testIficmpeq() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ificmpne(int)"})
  public void testIficmpne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ificmplt(int)"})
  public void testIficmplt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ificmpge(int)"})
  public void testIficmpge() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ificmpgt(int)"})
  public void testIficmpgt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ificmple(int)"})
  public void testIficmple() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifacmpeq(int)"})
  public void testIfacmpeq() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifacmpne(int)"})
  public void testIfacmpne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.goto_(int)"})
  public void testGoto_() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.jsr(int)"})
  public void testJsr() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ret(int)"})
  public void testRet_whenMinusEightySeven() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ret(int)"})
  public void testRet_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.tableswitch(int, int, int, int[])"
  })
  public void testTableswitch() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.lookupswitch(int, int[], int[])"
  })
  public void testLookupswitch() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ireturn()"})
  public void testIreturn() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.lreturn()"})
  public void testLreturn() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.freturn()"})
  public void testFreturn() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.dreturn()"})
  public void testDreturn() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.areturn()"})
  public void testAreturn() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.return_()"})
  public void testReturn_() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getstatic(String, String, String)"
  })
  public void testGetstaticWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getstatic(String, String, String)"
  })
  public void testGetstaticWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getstatic(String, String, String, Clazz, Field)"
  })
  public void testGetstaticWithClassNameNameDescriptorReferencedClassReferencedField()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getstatic(String, String, String, Clazz, Field)"
  })
  public void testGetstaticWithClassNameNameDescriptorReferencedClassReferencedField2()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getstatic(String, String, String)"
  })
  public void testGetstaticWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getstatic(String, String, String)"
  })
  public void testGetstaticWithClassNameNameDescriptor_thenSecondElementReturnUtf8Constant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getstatic(Clazz, Field)"
  })
  public void testGetstaticWithClazzField_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.getstatic(int)"})
  public void testGetstaticWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putstatic(String, String, String)"
  })
  public void testPutstaticWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putstatic(String, String, String)"
  })
  public void testPutstaticWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putstatic(String, String, String, Clazz, Field)"
  })
  public void testPutstaticWithClassNameNameDescriptorReferencedClassReferencedField()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putstatic(String, String, String, Clazz, Field)"
  })
  public void testPutstaticWithClassNameNameDescriptorReferencedClassReferencedField2()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putstatic(String, String, String)"
  })
  public void testPutstaticWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putstatic(String, String, String)"
  })
  public void testPutstaticWithClassNameNameDescriptor_thenSecondElementReturnUtf8Constant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putstatic(Clazz, Field)"
  })
  public void testPutstaticWithClazzField_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.putstatic(int)"})
  public void testPutstaticWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getfield(String, String, String)"
  })
  public void testGetfieldWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getfield(String, String, String)"
  })
  public void testGetfieldWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getfield(String, String, String, Clazz, Field)"
  })
  public void testGetfieldWithClassNameNameDescriptorReferencedClassReferencedField()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getfield(String, String, String, Clazz, Field)"
  })
  public void testGetfieldWithClassNameNameDescriptorReferencedClassReferencedField2()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getfield(String, String, String)"
  })
  public void testGetfieldWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getfield(String, String, String)"
  })
  public void testGetfieldWithClassNameNameDescriptor_thenSecondElementReturnUtf8Constant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.getfield(Clazz, Field)"
  })
  public void testGetfieldWithClazzField_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.getfield(int)"})
  public void testGetfieldWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putfield(String, String, String)"
  })
  public void testPutfieldWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putfield(String, String, String)"
  })
  public void testPutfieldWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putfield(String, String, String, Clazz, Field)"
  })
  public void testPutfieldWithClassNameNameDescriptorReferencedClassReferencedField()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putfield(String, String, String, Clazz, Field)"
  })
  public void testPutfieldWithClassNameNameDescriptorReferencedClassReferencedField2()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putfield(String, String, String)"
  })
  public void testPutfieldWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putfield(String, String, String)"
  })
  public void testPutfieldWithClassNameNameDescriptor_thenSecondElementReturnUtf8Constant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.putfield(Clazz, Field)"
  })
  public void testPutfieldWithClazzField_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.putfield(int)"})
  public void testPutfieldWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(int, String, String)"
  })
  public void testInvokevirtualWithClassIndexNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(int, String, String)"
  })
  public void testInvokevirtualWithClassIndexNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(int, String, String)"
  })
  public void testInvokevirtualWithClassIndexNameDescriptor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(int, String, String)"
  })
  public void testInvokevirtualWithClassIndexNameDescriptor4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(String, String, String)"
  })
  public void testInvokevirtualWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(String, String, String)"
  })
  public void testInvokevirtualWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(String, String, String)"
  })
  public void testInvokevirtualWithClassNameNameDescriptor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(String, String, String)"
  })
  public void testInvokevirtualWithClassNameNameDescriptor4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(String, String, String, Clazz, Method)"
  })
  public void testInvokevirtualWithClassNameNameDescriptorReferencedClassReferencedMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(String, String, String, Clazz, Method)"
  })
  public void testInvokevirtualWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(Clazz, Method)"
  })
  public void testInvokevirtualWithClazzMethod_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.invokevirtual(int)"})
  public void testInvokevirtualWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial(String, String, String)"
  })
  public void testInvokespecialWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial(String, String, String)"
  })
  public void testInvokespecialWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial(String, String, String)"
  })
  public void testInvokespecialWithClassNameNameDescriptor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial(String, String, String)"
  })
  public void testInvokespecialWithClassNameNameDescriptor4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial(String, String, String, Clazz, Method)"
  })
  public void testInvokespecialWithClassNameNameDescriptorReferencedClassReferencedMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial(String, String, String, Clazz, Method)"
  })
  public void testInvokespecialWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial(Clazz, Method)"
  })
  public void testInvokespecialWithClazzMethod_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial(int)"})
  public void testInvokespecialWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic(String, String, String)"
  })
  public void testInvokestaticWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic(String, String, String)"
  })
  public void testInvokestaticWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic(String, String, String)"
  })
  public void testInvokestaticWithClassNameNameDescriptor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic(String, String, String, Clazz, Method)"
  })
  public void testInvokestaticWithClassNameNameDescriptorReferencedClassReferencedMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic(String, String, String, Clazz, Method)"
  })
  public void testInvokestaticWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic(String, String, String)"
  })
  public void testInvokestaticWithClassNameNameDescriptor_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic(Clazz, Method)"
  })
  public void testInvokestaticWithClazzMethod_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic(int)"})
  public void testInvokestaticWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic_interface(String, String, String)"
  })
  public void testInvokestatic_interfaceWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic_interface(String, String, String)"
  })
  public void testInvokestatic_interfaceWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic_interface(String, String, String)"
  })
  public void testInvokestatic_interfaceWithClassNameNameDescriptor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic_interface(String, String, String)"
  })
  public void testInvokestatic_interfaceWithClassNameNameDescriptor4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic_interface(String, String, String, Clazz, Method)"
  })
  public void
      testInvokestatic_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic_interface(String, String, String, Clazz, Method)"
  })
  public void
      testInvokestatic_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokestatic_interface(Clazz, Method)"
  })
  public void testInvokestatic_interfaceWithClazzMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial_interface(String, String, String)"
  })
  public void testInvokespecial_interfaceWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial_interface(String, String, String)"
  })
  public void testInvokespecial_interfaceWithClassNameNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial_interface(String, String, String)"
  })
  public void testInvokespecial_interfaceWithClassNameNameDescriptor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial_interface(String, String, String)"
  })
  public void testInvokespecial_interfaceWithClassNameNameDescriptor4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial_interface(String, String, String, Clazz, Method)"
  })
  public void
      testInvokespecial_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial_interface(String, String, String, Clazz, Method)"
  })
  public void
      testInvokespecial_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokespecial_interface(Clazz, Method)"
  })
  public void testInvokespecial_interfaceWithClazzMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokeinterface(String, String, String)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokeinterface(String, String, String)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptor2()
      throws UnsupportedEncodingException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokeinterface(String, String, String)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokeinterface(String, String, String)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptor4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokeinterface(String, String, String, Clazz, Method)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokeinterface(String, String, String, Clazz, Method)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokeinterface(String, String, String, Clazz, Method)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokeinterface(int, int)"
  })
  public void testInvokeinterfaceWithConstantIndexConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int, String, String)"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int, String, String)"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int, String, String)"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int, String, String)"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptor4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int, String, String, Clazz[])"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int, String, String, Clazz[])"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int, String, String, Clazz[])"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int, String, String, Clazz[])"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.invokedynamic(int)"})
  public void testInvokedynamicWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(String)"})
  public void testNew_WithClassName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(String)"})
  public void testNew_WithClassName2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(String, Clazz)"})
  public void testNew_WithClassNameReferencedClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(String, Clazz)"})
  public void testNew_WithClassNameReferencedClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(String, Clazz)"})
  public void testNew_WithClassNameReferencedClass_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(String, Clazz)"})
  public void testNew_WithClassNameReferencedClass_thenSixthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(String)"})
  public void testNew_WithClassName_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(String)"})
  public void testNew_WithClassName_thenSixthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(Clazz)"})
  public void testNew_WithClazz() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(Clazz)"})
  public void testNew_WithClazz_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.new_(int)"})
  public void testNew_WithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.newarray(int)"})
  public void testNewarray() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.anewarray(int)"})
  public void testAnewarrayWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.anewarray(Clazz)"})
  public void testAnewarrayWithElementType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.anewarray(String, Clazz)"
  })
  public void testAnewarrayWithElementTypeNameReferencedClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.anewarray(String, Clazz)"
  })
  public void testAnewarrayWithElementTypeNameReferencedClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.anewarray(String, Clazz)"
  })
  public void testAnewarrayWithElementTypeNameReferencedClass3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.anewarray(Clazz)"})
  public void testAnewarrayWithElementType_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.arraylength()"})
  public void testArraylength() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.athrow()"})
  public void testAthrow() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(int)"})
  public void testCheckcastWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(Clazz)"})
  public void testCheckcastWithType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(String)"})
  public void testCheckcastWithTypeName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(String)"})
  public void testCheckcastWithTypeName2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(String, Clazz)"
  })
  public void testCheckcastWithTypeNameReferencedClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(String, Clazz)"
  })
  public void testCheckcastWithTypeNameReferencedClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(String, Clazz)"
  })
  public void testCheckcastWithTypeNameReferencedClass_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(String)"})
  public void testCheckcastWithTypeName_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.checkcast(Clazz)"})
  public void testCheckcastWithType_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.instanceof_(int)"})
  public void testInstanceof_WithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.instanceof_(Clazz)"})
  public void testInstanceof_WithType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.instanceof_(String, Clazz)"
  })
  public void testInstanceof_WithTypeNameReferencedClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.instanceof_(String, Clazz)"
  })
  public void testInstanceof_WithTypeNameReferencedClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.instanceof_(String, Clazz)"
  })
  public void testInstanceof_WithTypeNameReferencedClass_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.instanceof_(Clazz)"})
  public void testInstanceof_WithType_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.monitorenter()"})
  public void testMonitorenter() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.monitorexit()"})
  public void testMonitorexit() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.wide()"})
  public void testWide() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(int)"})
  public void testMultianewarrayWithConstantIndex() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(Clazz)"})
  public void testMultianewarrayWithType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(String)"
  })
  public void testMultianewarrayWithTypeName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(String)"
  })
  public void testMultianewarrayWithTypeName2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(String, Clazz)"
  })
  public void testMultianewarrayWithTypeNameReferencedClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(String, Clazz)"
  })
  public void testMultianewarrayWithTypeNameReferencedClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(String, Clazz)"
  })
  public void testMultianewarrayWithTypeNameReferencedClass3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(String)"
  })
  public void testMultianewarrayWithTypeName_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.multianewarray(Clazz)"})
  public void testMultianewarrayWithType_thenReturnInstructionSequenceBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifnull(int)"})
  public void testIfnull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.ifnonnull(int)"})
  public void testIfnonnull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.goto_w(int)"})
  public void testGoto_w() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.jsr_w(int)"})
  public void testJsr_w() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushPrimitive(Object, char)"
  })
  public void testPushPrimitive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_thenFourthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenA_thenThrowIllegalArgumentException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenB_thenReturnThirdElementStringIsBLjavaLangByte()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenC_thenReturnThirdElementStringIsCLjavaLangCharacter()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenD_thenReturnThirdElementStringIsDLjavaLangDouble()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenF_thenReturnThirdElementStringIsFLjavaLangFloat()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenI_thenReturnThirdElementStringIsILjavaLangInteger()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenJ_thenReturnThirdElementStringIsJLjavaLangLong()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenS_thenReturnThirdElementStringIsSLjavaLangShort()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType_whenZ_thenReturnThirdElementStringIsZLjavaLangBoolean()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.unboxPrimitiveType(String, String)"
  })
  public void testUnboxPrimitiveType_thenSixthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.unboxPrimitiveType(String, String)"
  })
  public void testUnboxPrimitiveType_whenLjavaLangObject_thenThirdElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.unboxPrimitiveType(String, String)"
  })
  public void testUnboxPrimitiveType_whenTargetType_thenThrowIllegalArgumentException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushPrimitiveOrString(Object, String, boolean)"
  })
  public void testPushPrimitiveOrStringWithValueTypeAllowBoxing_whenJavaLangVoid() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushPrimitiveOrString(Object, String, boolean)"
  })
  public void testPushPrimitiveOrStringWithValueTypeAllowBoxing_whenNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushPrimitiveOrString(Object, String, boolean)"
  })
  public void testPushPrimitiveOrStringWithValueTypeAllowBoxing_whenValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushPrimitiveOrString(Object, String)"
  })
  public void testPushPrimitiveOrStringWithValueType_whenMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushPrimitiveOrString(Object, String)"
  })
  public void testPushPrimitiveOrStringWithValueType_whenValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushBoxedPrimitive(Object, String)"
  })
  public void testPushBoxedPrimitive_whenValue_thenThrowIllegalArgumentException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenFive_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenFortyTwo_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenFour_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenMin_value_thenSecondElementReturnIntegerConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenMinusOne_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenThree_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenTwo_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushInt(int)"})
  public void testPushInt_whenZero_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushFloat(float)"})
  public void testPushFloat_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushFloat(float)"})
  public void testPushFloat_whenTen_thenSecondElementReturnFloatConstant() {
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
    assertEquals(10.0f, ((FloatConstant) constant).getValue(), 0.0f);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushFloat(float)"})
  public void testPushFloat_whenTwo_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushFloat(float)"})
  public void testPushFloat_whenZero_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushLong(long)"})
  public void testPushLong_givenInstructionSequenceBuilder_thenSecondElementReturnLongConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushLong(long)"})
  public void testPushLong_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushLong(long)"})
  public void testPushLong_whenZero_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushDouble(double)"})
  public void testPushDouble_thenSecondElementReturnDoubleConstant() {
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
    assertEquals(10.0d, ((DoubleConstant) constant).getValue(), 0.0);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushDouble(double)"})
  public void testPushDouble_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushDouble(double)"})
  public void testPushDouble_whenZero_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenFive_thenThirdElementReturnClassConstant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenFour_thenThirdElementReturnClassConstant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenMin_value_thenFourthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenMinusOneHundredTwentyEight()
      throws UnsupportedEncodingException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenMinusOne_thenThirdElementReturnClassConstant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenOne_thenThirdElementReturnClassConstant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenThree_thenThirdElementReturnClassConstant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenTwo_thenThirdElementReturnClassConstant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushNewArray(String, int)"
  })
  public void testPushNewArray_whenZero_thenThirdElementReturnClassConstant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushPrimitiveOrStringArray(String, Object[])"
  })
  public void testPushPrimitiveOrStringArray_thenInstructionSequenceBuilderSizeIsSeventyFive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceBuilder InstructionSequenceBuilder.pushPrimitiveOrStringArray(String, Object[])"
  })
  public void testPushPrimitiveOrStringArray_whenType_thenThrowIllegalArgumentException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.pushDefault(String)"})
  public void testPushDefault_whenType_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, char)"})
  public void testLoadWithIntChar_whenA() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, char)"})
  public void testLoadWithIntChar_whenB() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, char)"})
  public void testLoadWithIntChar_whenD() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, char)"})
  public void testLoadWithIntChar_whenF() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, char)"})
  public void testLoadWithIntChar_whenJ() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, char)"})
  public void testLoadWithIntChar_whenMinusOneHundredTwentyEight() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, String)"})
  public void testLoadWithIntString_whenMinusOneHundredTwentyEight() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, String)"})
  public void testLoadWithIntString_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.load(int, String)"})
  public void testLoadWithIntString_whenSixtySix_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, char)"})
  public void testStoreWithIntChar_whenA() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, char)"})
  public void testStoreWithIntChar_whenB() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, char)"})
  public void testStoreWithIntChar_whenD() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, char)"})
  public void testStoreWithIntChar_whenF() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, char)"})
  public void testStoreWithIntChar_whenJ() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, char)"})
  public void testStoreWithIntChar_whenMinusOneHundredTwentyEight() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, String)"})
  public void testStoreWithIntString_whenMinusOneHundredTwentyEight() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, String)"})
  public void testStoreWithIntString_whenOne_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.store(int, String)"})
  public void testStoreWithIntString_whenSixtySix_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.storeToArray(String)"})
  public void testStoreToArray_whenElementType_thenInstructionSequenceBuilderSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionSequenceBuilder InstructionSequenceBuilder.loadFromArray(String)"})
  public void testLoadFromArray_whenElementType_thenInstructionSequenceBuilderSizeIsOne() {
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

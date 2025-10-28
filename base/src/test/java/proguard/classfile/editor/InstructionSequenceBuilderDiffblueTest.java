package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
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
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantCounter;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFile;

public class InstructionSequenceBuilderDiffblueTest {
  /**
   * Method under test: {@link InstructionSequenceBuilder#getConstantPoolEditor()}
   */
  @Test
  public void testGetConstantPoolEditor() {
    // Arrange, Act and Assert
    ProgramClass targetClass = (new InstructionSequenceBuilder()).getConstantPoolEditor().getTargetClass();
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
    assertEquals(0, targetClass.u2interfaces.length);
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
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#label(Instruction)}
   */
  @Test
  public void testLabel() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLabelResult = instructionSequenceBuilder
        .label(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLabelResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#catch_(Instruction)}
   */
  @Test
  public void testCatch_() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCatch_Result = instructionSequenceBuilder
        .catch_(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCatch_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#line(Instruction)}
   */
  @Test
  public void testLine() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLineResult = instructionSequenceBuilder.line(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLineResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAppendInstructionResult = instructionSequenceBuilder
        .appendInstruction(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAppendInstructionResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAppendInstructionsResult = instructionSequenceBuilder
        .appendInstructions(new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAppendInstructionsResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#__()}
   */
  @Test
  public void test__() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).__().length);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#instructions()}
   */
  @Test
  public void testInstructions() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).instructions().length);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#constants()}
   */
  @Test
  public void testConstants() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    Constant[] actualConstantsResult = instructionSequenceBuilder.constants();

    // Assert
    assertNull(actualConstantsResult[0]);
    assertEquals(0, instructionSequenceBuilder.getConstantPoolEditor().getTargetClass().u2constantPoolCount);
    assertEquals(1, actualConstantsResult.length);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new InstructionSequenceBuilder()).size());
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#nop()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#aconst_null()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iconst(int)}
   */
  @Test
  public void testIconst() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconstResult = instructionSequenceBuilder.iconst(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iconst(int)}
   */
  @Test
  public void testIconst2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconstResult = instructionSequenceBuilder.iconst(-2);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iconst(int)}
   */
  @Test
  public void testIconst3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIconstResult = instructionSequenceBuilder.iconst(6);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iconst_m1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iconst_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iconst_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iconst_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iconst_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iconst_4()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iconst_5()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lconst(int)}
   */
  @Test
  public void testLconst() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLconstResult = instructionSequenceBuilder.lconst(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lconst(int)}
   */
  @Test
  public void testLconst2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLconstResult = instructionSequenceBuilder.lconst(-1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lconst(int)}
   */
  @Test
  public void testLconst3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLconstResult = instructionSequenceBuilder.lconst(0);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lconst_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lconst_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fconst(int)}
   */
  @Test
  public void testFconst() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconstResult = instructionSequenceBuilder.fconst(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fconst(int)}
   */
  @Test
  public void testFconst2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconstResult = instructionSequenceBuilder.fconst(-1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fconst(int)}
   */
  @Test
  public void testFconst3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFconstResult = instructionSequenceBuilder.fconst(5);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fconst_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fconst_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fconst_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dconst(int)}
   */
  @Test
  public void testDconst() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDconstResult = instructionSequenceBuilder.dconst(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dconst(int)}
   */
  @Test
  public void testDconst2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDconstResult = instructionSequenceBuilder.dconst(-1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dconst(int)}
   */
  @Test
  public void testDconst3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDconstResult = instructionSequenceBuilder.dconst(0);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDconstResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dconst_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dconst_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#bipush(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#sipush(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ldc(float)}
   */
  @Test
  public void testLdc() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(10.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(float)}
   */
  @Test
  public void testLdc2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(4, 1, new Constant[]{new ClassConstant()}, 4, 4, 4));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(10.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(float)}
   */
  @Test
  public void testLdc3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(4, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 4, 4, 4));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(10.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(float, ConstantVisitor)}
   */
  @Test
  public void testLdc4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(10.0f, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(float, ConstantVisitor)}
   */
  @Test
  public void testLdc5() {
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
   * Method under test: {@link InstructionSequenceBuilder#ldc(int)}
   */
  @Test
  public void testLdc6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(42);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(int)}
   */
  @Test
  public void testLdc7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(3, 1, new Constant[]{new ClassConstant()}, 3, 3, 3));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(42);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(int)}
   */
  @Test
  public void testLdc8() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(3, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 3, 3, 3));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(42);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(int, ConstantVisitor)}
   */
  @Test
  public void testLdc9() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(42, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(int, ConstantVisitor)}
   */
  @Test
  public void testLdc10() {
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
   * Method under test: {@link InstructionSequenceBuilder#ldc(Object)}
   */
  @Test
  public void testLdc11() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Object) "Primitive Array");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(Object)}
   */
  @Test
  public void testLdc12() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(99, 1, new Constant[]{new ClassConstant()}, 99, 99, 99));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Object) "Primitive Array");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(Object)}
   */
  @Test
  public void testLdc13() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(99, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 99, 99, 99));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Object) "Primitive Array");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(Object, ConstantVisitor)}
   */
  @Test
  public void testLdc14() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Object) "Primitive Array", null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(Object, ConstantVisitor)}
   */
  @Test
  public void testLdc15() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Object) "Primitive Array", visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(String)}
   */
  @Test
  public void testLdc16() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(String)}
   */
  @Test
  public void testLdc17() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(String)}
   */
  @Test
  public void testLdc18() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz)}
   */
  @Test
  public void testLdc19() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("Type Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz)}
   */
  @Test
  public void testLdc20() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("Type Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(String, Clazz)}
   */
  @Test
  public void testLdc21() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("Type Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)}
   */
  @Test
  public void testLdc22() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)}
   */
  @Test
  public void testLdc23() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, Clazz, Member)}
   */
  @Test
  public void testLdc24() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, Clazz, Member, ConstantVisitor)}
   */
  @Test
  public void testLdc25() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, Clazz, Member, ConstantVisitor)}
   */
  @Test
  public void testLdc26() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String", referencedClass,
        referencedMember, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc27() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("Type Name", referencedClass, visitor);

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
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, visitor.resultSize);
    assertSame(instructionSequenceBuilder, actualLdcResult);
    Clazz[] clazzArray = referencedClass.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz).subClasses);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc28() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("Type Name", new LibraryClass(),
        (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc29() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("Type Name", referencedClass, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, ConstantVisitor)}
   */
  @Test
  public void testLdc30() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String", (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, ConstantVisitor)}
   */
  @Test
  public void testLdc31() {
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
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, ResourceFile)}
   */
  @Test
  public void testLdc32() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, ResourceFile)}
   */
  @Test
  public void testLdc33() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, ResourceFile)}
   */
  @Test
  public void testLdc34() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, ResourceFile, ConstantVisitor)}
   */
  @Test
  public void testLdc35() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String",
        new ResourceFile("foo.txt", 3L), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(String, ResourceFile, ConstantVisitor)}
   */
  @Test
  public void testLdc36() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ResourceFile referencedResourceFile = new ResourceFile("foo.txt", 3L);

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc("String", referencedResourceFile,
        visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(Clazz)}
   */
  @Test
  public void testLdc37() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder
        .ldc((Clazz) new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(Clazz)}
   */
  @Test
  public void testLdc38() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Clazz) new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member)}
   */
  @Test
  public void testLdc39() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member)}
   */
  @Test
  public void testLdc40() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member)}
   */
  @Test
  public void testLdc41() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(Clazz, Member)}
   */
  @Test
  public void testLdc42() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(Clazz, Member, ConstantVisitor)}
   */
  @Test
  public void testLdc43() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(clazz,
        new LibraryField(1, "Name", "Descriptor"), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(Clazz, Member, ConstantVisitor)}
   */
  @Test
  public void testLdc44() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(clazz, member, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc45() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Clazz) clazz, visitor);

    // Assert
    Clazz clazz2 = visitor.resultClazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", clazz2.getName());
    assertEquals("This Class Name", visitor.result);
    assertNull(clazz2.getProcessingInfo());
    assertNull(clazz2.getFeatureName());
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(1, clazz2.getAccessFlags());
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, visitor.resultSize);
    assertSame(instructionSequenceBuilder, actualLdcResult);
    assertSame(clazz.fields, ((LibraryClass) clazz2).fields);
    assertSame(clazz.interfaceNames, ((LibraryClass) clazz2).interfaceNames);
    assertSame(clazz.methods, ((LibraryClass) clazz2).methods);
    Clazz[] clazzArray = clazz.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz2).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc46() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder
        .ldc((Clazz) new LibraryClass(1, "This Class Name", "Super Class Name"), (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc47() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Clazz) clazz, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc48() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();
    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc((Clazz) clazz, visitor);

    // Assert
    Clazz clazz2 = visitor.resultClazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(clazz2.getFeatureName());
    assertNull(visitor.result);
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, visitor.resultSize);
    assertSame(instructionSequenceBuilder, actualLdcResult);
    Clazz[] clazzArray = clazz.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz2).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(ResourceFile)}
   */
  @Test
  public void testLdc49() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(ResourceFile)}
   */
  @Test
  public void testLdc50() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc(ResourceFile)}
   */
  @Test
  public void testLdc51() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(ResourceFile, ConstantVisitor)}
   */
  @Test
  public void testLdc52() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(new ResourceFile("foo.txt", 3L), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc(ResourceFile, ConstantVisitor)}
   */
  @Test
  public void testLdc53() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdcResult = instructionSequenceBuilder.ldc(resourceFile, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdcResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_(int)}
   */
  @Test
  public void testLdc_() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_Result = instructionSequenceBuilder.ldc_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)}
   */
  @Test
  public void testLdc_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_Result = instructionSequenceBuilder.ldc_(1, new ConstantLookupVisitor());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)}
   */
  @Test
  public void testLdc_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_Result = instructionSequenceBuilder.ldc_(1, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_(int, ConstantVisitor)}
   */
  @Test
  public void testLdc_4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualLdc_Result = instructionSequenceBuilder.ldc_(1,
        new BootstrapMethodHandleTraveler(new ConstantLookupVisitor()));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(float)}
   */
  @Test
  public void testLdc_w() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(10.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(float)}
   */
  @Test
  public void testLdc_w2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(4, 1, new Constant[]{new ClassConstant()}, 4, 4, 4));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(10.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(float)}
   */
  @Test
  public void testLdc_w3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(4, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 4, 4, 4));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(10.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(float, ConstantVisitor)}
   */
  @Test
  public void testLdc_w4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(10.0f, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(float, ConstantVisitor)}
   */
  @Test
  public void testLdc_w5() {
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
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(int)}
   */
  @Test
  public void testLdc_w6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(42);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(int)}
   */
  @Test
  public void testLdc_w7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(3, 1, new Constant[]{new ClassConstant()}, 3, 3, 3));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(42);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(int)}
   */
  @Test
  public void testLdc_w8() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(3, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 3, 3, 3));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(42);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(int, ConstantVisitor)}
   */
  @Test
  public void testLdc_w9() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(42, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(int, ConstantVisitor)}
   */
  @Test
  public void testLdc_w10() {
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
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Object)}
   */
  @Test
  public void testLdc_w11() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Object) "Primitive Array");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Object)}
   */
  @Test
  public void testLdc_w12() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(99, 1, new Constant[]{new ClassConstant()}, 99, 99, 99));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Object) "Primitive Array");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Object)}
   */
  @Test
  public void testLdc_w13() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(99, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 99, 99, 99));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Object) "Primitive Array");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(Object, ConstantVisitor)}
   */
  @Test
  public void testLdc_w14() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Object) "Primitive Array", null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(Object, ConstantVisitor)}
   */
  @Test
  public void testLdc_w15() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Object) "Primitive Array",
        visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(String)}
   */
  @Test
  public void testLdc_w16() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(String)}
   */
  @Test
  public void testLdc_w17() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(String)}
   */
  @Test
  public void testLdc_w18() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz)}
   */
  @Test
  public void testLdc_w19() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("Type Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz)}
   */
  @Test
  public void testLdc_w20() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("Type Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(String, Clazz)}
   */
  @Test
  public void testLdc_w21() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("Type Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)}
   */
  @Test
  public void testLdc_w22() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)}
   */
  @Test
  public void testLdc_w23() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member)}
   */
  @Test
  public void testLdc_w24() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member, ConstantVisitor)}
   */
  @Test
  public void testLdc_w25() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, Clazz, Member, ConstantVisitor)}
   */
  @Test
  public void testLdc_w26() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String", referencedClass,
        referencedMember, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc_w27() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("Type Name", referencedClass,
        visitor);

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
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, visitor.resultSize);
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
    Clazz[] clazzArray = referencedClass.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz).subClasses);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc_w28() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("Type Name", new LibraryClass(),
        (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc_w29() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("Type Name", referencedClass,
        visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, ConstantVisitor)}
   */
  @Test
  public void testLdc_w30() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String", (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, ConstantVisitor)}
   */
  @Test
  public void testLdc_w31() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String", visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)}
   */
  @Test
  public void testLdc_w32() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)}
   */
  @Test
  public void testLdc_w33() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile)}
   */
  @Test
  public void testLdc_w34() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile, ConstantVisitor)}
   */
  @Test
  public void testLdc_w35() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String",
        new ResourceFile("foo.txt", 3L), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(String, ResourceFile, ConstantVisitor)}
   */
  @Test
  public void testLdc_w36() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ResourceFile referencedResourceFile = new ResourceFile("foo.txt", 3L);

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w("String", referencedResourceFile,
        visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz)}
   */
  @Test
  public void testLdc_w37() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder
        .ldc_w((Clazz) new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz)}
   */
  @Test
  public void testLdc_w38() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Clazz) new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)}
   */
  @Test
  public void testLdc_w39() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)}
   */
  @Test
  public void testLdc_w40() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)}
   */
  @Test
  public void testLdc_w41() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(Clazz, Member)}
   */
  @Test
  public void testLdc_w42() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(Clazz, Member, ConstantVisitor)}
   */
  @Test
  public void testLdc_w43() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(clazz,
        new LibraryField(1, "Name", "Descriptor"), null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(Clazz, Member, ConstantVisitor)}
   */
  @Test
  public void testLdc_w44() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(clazz, member, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc_w45() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Clazz) clazz, visitor);

    // Assert
    Clazz clazz2 = visitor.resultClazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", clazz2.getName());
    assertEquals("This Class Name", visitor.result);
    assertNull(clazz2.getProcessingInfo());
    assertNull(clazz2.getFeatureName());
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(1, clazz2.getAccessFlags());
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, visitor.resultSize);
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
    assertSame(clazz.fields, ((LibraryClass) clazz2).fields);
    assertSame(clazz.interfaceNames, ((LibraryClass) clazz2).interfaceNames);
    assertSame(clazz.methods, ((LibraryClass) clazz2).methods);
    Clazz[] clazzArray = clazz.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz2).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc_w46() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder
        .ldc_w((Clazz) new LibraryClass(1, "This Class Name", "Super Class Name"), (ConstantVisitor) null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc_w47() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Clazz) clazz, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(Clazz, ConstantVisitor)}
   */
  @Test
  public void testLdc_w48() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();
    ConstantLookupVisitor visitor = new ConstantLookupVisitor();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w((Clazz) clazz, visitor);

    // Assert
    Clazz clazz2 = visitor.resultClazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(clazz2.getFeatureName());
    assertNull(visitor.result);
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(1, instructionSequenceBuilder.size());
    assertEquals(1, visitor.resultSize);
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
    Clazz[] clazzArray = clazz.subClasses;
    assertSame(clazzArray, ((LibraryClass) clazz2).interfaceClasses);
    assertSame(clazzArray, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(ResourceFile)}
   */
  @Test
  public void testLdc_w49() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(ResourceFile)}
   */
  @Test
  public void testLdc_w50() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w(ResourceFile)}
   */
  @Test
  public void testLdc_w51() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(ResourceFile, ConstantVisitor)}
   */
  @Test
  public void testLdc_w52() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(new ResourceFile("foo.txt", 3L),
        null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w(ResourceFile, ConstantVisitor)}
   */
  @Test
  public void testLdc_w53() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc_wResult = instructionSequenceBuilder.ldc_w(resourceFile, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc_w_(int)}
   */
  @Test
  public void testLdc_w_() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_w_Result = instructionSequenceBuilder.ldc_w_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_w_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)}
   */
  @Test
  public void testLdc_w_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_w_Result = instructionSequenceBuilder.ldc_w_(1, new ConstantLookupVisitor());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_w_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)}
   */
  @Test
  public void testLdc_w_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc_w_Result = instructionSequenceBuilder.ldc_w_(1, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_w_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc_w_(int, ConstantVisitor)}
   */
  @Test
  public void testLdc_w_4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualLdc_w_Result = instructionSequenceBuilder.ldc_w_(1,
        new BootstrapMethodHandleTraveler(new ConstantLookupVisitor()));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc_w_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc2_w(double)}
   */
  @Test
  public void testLdc2_w() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(10.0d);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc2_w(double)}
   */
  @Test
  public void testLdc2_w2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(6, 1, new Constant[]{new ClassConstant()}, 6, 6, 6));

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(10.0d);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc2_w(double)}
   */
  @Test
  public void testLdc2_w3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(6, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 6, 6, 6));

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(10.0d);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc2_w(double, ConstantVisitor)}
   */
  @Test
  public void testLdc2_w4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(10.0d, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc2_w(double, ConstantVisitor)}
   */
  @Test
  public void testLdc2_w5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    ConstantCounter visitor = new ConstantCounter();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(10.0d, visitor);

    // Assert
    assertEquals(1, visitor.getCount());
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc2_w(int)}
   */
  @Test
  public void testLdc2_w6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)}
   */
  @Test
  public void testLdc2_w7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(1, new ConstantLookupVisitor());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)}
   */
  @Test
  public void testLdc2_w8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(1, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc2_w(int, ConstantVisitor)}
   */
  @Test
  public void testLdc2_w9() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(1,
        new BootstrapMethodHandleTraveler(new ConstantLookupVisitor()));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc2_w(long)}
   */
  @Test
  public void testLdc2_w10() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(42L);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc2_w(long)}
   */
  @Test
  public void testLdc2_w11() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(5, 1, new Constant[]{new ClassConstant()}, 5, 5, 5));

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(42L);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ldc2_w(long)}
   */
  @Test
  public void testLdc2_w12() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(5, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 5, 5, 5));

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(42L);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc2_w(long, ConstantVisitor)}
   */
  @Test
  public void testLdc2_w13() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLdc2_wResult = instructionSequenceBuilder.ldc2_w(42L, null);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLdc2_wResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#ldc2_w(long, ConstantVisitor)}
   */
  @Test
  public void testLdc2_w14() {
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
   * Method under test: {@link InstructionSequenceBuilder#iload(int)}
   */
  @Test
  public void testIload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIloadResult = instructionSequenceBuilder.iload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iload(int)}
   */
  @Test
  public void testIload2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIloadResult = instructionSequenceBuilder.iload(21);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iload(int)}
   */
  @Test
  public void testIload3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIloadResult = instructionSequenceBuilder.iload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lload(int)}
   */
  @Test
  public void testLload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLloadResult = instructionSequenceBuilder.lload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lload(int)}
   */
  @Test
  public void testLload2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLloadResult = instructionSequenceBuilder.lload(22);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lload(int)}
   */
  @Test
  public void testLload3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLloadResult = instructionSequenceBuilder.lload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fload(int)}
   */
  @Test
  public void testFload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFloadResult = instructionSequenceBuilder.fload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fload(int)}
   */
  @Test
  public void testFload2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFloadResult = instructionSequenceBuilder.fload(23);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fload(int)}
   */
  @Test
  public void testFload3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFloadResult = instructionSequenceBuilder.fload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dload(int)}
   */
  @Test
  public void testDload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDloadResult = instructionSequenceBuilder.dload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dload(int)}
   */
  @Test
  public void testDload2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDloadResult = instructionSequenceBuilder.dload(24);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dload(int)}
   */
  @Test
  public void testDload3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDloadResult = instructionSequenceBuilder.dload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#aload(int)}
   */
  @Test
  public void testAload() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAloadResult = instructionSequenceBuilder.aload(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#aload(int)}
   */
  @Test
  public void testAload2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAloadResult = instructionSequenceBuilder.aload(25);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#aload(int)}
   */
  @Test
  public void testAload3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAloadResult = instructionSequenceBuilder.aload(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAloadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iload_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iload_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iload_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iload_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lload_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lload_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lload_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lload_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fload_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fload_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fload_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fload_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dload_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dload_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dload_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dload_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#aload_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#aload_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#aload_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#aload_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iaload()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#laload()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#faload()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#daload()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#aaload()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#baload()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#caload()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#saload()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#istore(int)}
   */
  @Test
  public void testIstore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstoreResult = instructionSequenceBuilder.istore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#istore(int)}
   */
  @Test
  public void testIstore2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstoreResult = instructionSequenceBuilder.istore(54);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#istore(int)}
   */
  @Test
  public void testIstore3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIstoreResult = instructionSequenceBuilder.istore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lstore(int)}
   */
  @Test
  public void testLstore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstoreResult = instructionSequenceBuilder.lstore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lstore(int)}
   */
  @Test
  public void testLstore2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstoreResult = instructionSequenceBuilder.lstore(55);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#lstore(int)}
   */
  @Test
  public void testLstore3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLstoreResult = instructionSequenceBuilder.lstore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fstore(int)}
   */
  @Test
  public void testFstore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstoreResult = instructionSequenceBuilder.fstore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fstore(int)}
   */
  @Test
  public void testFstore2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstoreResult = instructionSequenceBuilder.fstore(56);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#fstore(int)}
   */
  @Test
  public void testFstore3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualFstoreResult = instructionSequenceBuilder.fstore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualFstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dstore(int)}
   */
  @Test
  public void testDstore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstoreResult = instructionSequenceBuilder.dstore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dstore(int)}
   */
  @Test
  public void testDstore2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstoreResult = instructionSequenceBuilder.dstore(57);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#dstore(int)}
   */
  @Test
  public void testDstore3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualDstoreResult = instructionSequenceBuilder.dstore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualDstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#astore(int)}
   */
  @Test
  public void testAstore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstoreResult = instructionSequenceBuilder.astore(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#astore(int)}
   */
  @Test
  public void testAstore2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstoreResult = instructionSequenceBuilder.astore(58);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#astore(int)}
   */
  @Test
  public void testAstore3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAstoreResult = instructionSequenceBuilder.astore(-124);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAstoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#istore_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#istore_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#istore_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#istore_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lstore_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lstore_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lstore_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lstore_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fstore_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fstore_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fstore_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fstore_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dstore_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dstore_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dstore_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dstore_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#astore_0()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#astore_1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#astore_2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#astore_3()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iastore()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lastore()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fastore()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dastore()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#aastore()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#bastore()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#castore()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#sastore()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#pop()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#pop2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dup()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dup_x1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dup_x2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dup2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dup2_x1()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dup2_x2()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#swap()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iadd()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ladd()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fadd()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dadd()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#isub()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lsub()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fsub()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dsub()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#imul()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lmul()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fmul()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dmul()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#idiv()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ldiv()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fdiv()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ddiv()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#irem()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lrem()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#frem()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#drem()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ineg()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lneg()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fneg()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dneg()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ishl()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lshl()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ishr()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lshr()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iushr()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lushr()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iand()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#land()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ior()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lor()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ixor()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lxor()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  public void testIinc() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult = instructionSequenceBuilder.iinc(1, 1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  public void testIinc2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult = instructionSequenceBuilder.iinc(-124, 1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  public void testIinc3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult = instructionSequenceBuilder.iinc(1, Integer.MIN_VALUE);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  public void testIinc4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult = instructionSequenceBuilder.iinc(4, Integer.MIN_VALUE);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#iinc(int, int)}
   */
  @Test
  public void testIinc5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualIincResult = instructionSequenceBuilder.iinc(4, 255);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualIincResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#i2l()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#i2f()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#i2d()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#l2i()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#l2f()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#l2d()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#f2i()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#f2l()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#f2d()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#d2i()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#d2l()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#d2f()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#i2b()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#i2c()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#i2s()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lcmp()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fcmpl()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#fcmpg()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dcmpl()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dcmpg()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ifeq(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ifne(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#iflt(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ifge(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ifgt(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ifle(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ificmpeq(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ificmpne(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ificmplt(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ificmpge(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ificmpgt(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ificmple(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ifacmpeq(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ifacmpne(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#goto_(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#jsr(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ret(int)}
   */
  @Test
  public void testRet() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualRetResult = instructionSequenceBuilder.ret(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualRetResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ret(int)}
   */
  @Test
  public void testRet2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualRetResult = instructionSequenceBuilder.ret(-87);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualRetResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#tableswitch(int, int, int, int[])}
   */
  @Test
  public void testTableswitch() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualTableswitchResult = instructionSequenceBuilder.tableswitch(1, 1, 1,
        new int[]{1, -128, 1, -128});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualTableswitchResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#lookupswitch(int, int[], int[])}
   */
  @Test
  public void testLookupswitch() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLookupswitchResult = instructionSequenceBuilder.lookupswitch(1,
        new int[]{1, -128, 1, -128}, new int[]{1, -128, 1, -128});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLookupswitchResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ireturn()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#lreturn()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#freturn()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#dreturn()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#areturn()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#return_()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#getstatic(int)}
   */
  @Test
  public void testGetstatic() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getstatic(String, String, String)}
   */
  @Test
  public void testGetstatic2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getstatic(String, String, String)}
   */
  @Test
  public void testGetstatic3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getstatic(String, String, String)}
   */
  @Test
  public void testGetstatic4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getstatic(String, String, String)}
   */
  @Test
  public void testGetstatic5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getstatic(String, String, String, Clazz, Field)}
   */
  @Test
  public void testGetstatic6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getstatic(String, String, String, Clazz, Field)}
   */
  @Test
  public void testGetstatic7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#getstatic(Clazz, Field)}
   */
  @Test
  public void testGetstatic8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualGetstaticResult = instructionSequenceBuilder.getstatic(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetstaticResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#putstatic(int)}
   */
  @Test
  public void testPutstatic() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putstatic(String, String, String)}
   */
  @Test
  public void testPutstatic2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putstatic(String, String, String)}
   */
  @Test
  public void testPutstatic3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putstatic(String, String, String)}
   */
  @Test
  public void testPutstatic4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putstatic(String, String, String)}
   */
  @Test
  public void testPutstatic5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putstatic(String, String, String, Clazz, Field)}
   */
  @Test
  public void testPutstatic6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putstatic(String, String, String, Clazz, Field)}
   */
  @Test
  public void testPutstatic7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#putstatic(Clazz, Field)}
   */
  @Test
  public void testPutstatic8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualPutstaticResult = instructionSequenceBuilder.putstatic(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutstaticResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#getfield(int)}
   */
  @Test
  public void testGetfield() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getfield(String, String, String)}
   */
  @Test
  public void testGetfield2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getfield(String, String, String)}
   */
  @Test
  public void testGetfield3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getfield(String, String, String)}
   */
  @Test
  public void testGetfield4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getfield(String, String, String)}
   */
  @Test
  public void testGetfield5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getfield(String, String, String, Clazz, Field)}
   */
  @Test
  public void testGetfield6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#getfield(String, String, String, Clazz, Field)}
   */
  @Test
  public void testGetfield7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#getfield(Clazz, Field)}
   */
  @Test
  public void testGetfield8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualGetfieldResult = instructionSequenceBuilder.getfield(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualGetfieldResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#putfield(int)}
   */
  @Test
  public void testPutfield() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putfield(String, String, String)}
   */
  @Test
  public void testPutfield2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putfield(String, String, String)}
   */
  @Test
  public void testPutfield3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putfield(String, String, String)}
   */
  @Test
  public void testPutfield4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putfield(String, String, String)}
   */
  @Test
  public void testPutfield5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putfield(String, String, String, Clazz, Field)}
   */
  @Test
  public void testPutfield6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#putfield(String, String, String, Clazz, Field)}
   */
  @Test
  public void testPutfield7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#putfield(Clazz, Field)}
   */
  @Test
  public void testPutfield8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualPutfieldResult = instructionSequenceBuilder.putfield(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPutfieldResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#invokevirtual(int)}
   */
  @Test
  public void testInvokevirtual() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(int, String, String)}
   */
  @Test
  public void testInvokevirtual2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual(1, "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(int, String, String)}
   */
  @Test
  public void testInvokevirtual3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual(1, "Name",
        "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(int, String, String)}
   */
  @Test
  public void testInvokevirtual4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual(1, "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(int, String, String)}
   */
  @Test
  public void testInvokevirtual5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual(1, "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(String, String, String)}
   */
  @Test
  public void testInvokevirtual6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(String, String, String)}
   */
  @Test
  public void testInvokevirtual7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(String, String, String)}
   */
  @Test
  public void testInvokevirtual8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(String, String, String)}
   */
  @Test
  public void testInvokevirtual9() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokevirtual10() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokevirtual11() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokevirtual(Clazz, Method)}
   */
  @Test
  public void testInvokevirtual12() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokevirtualResult = instructionSequenceBuilder.invokevirtual(clazz,
        new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokevirtualResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#invokespecial(int)}
   */
  @Test
  public void testInvokespecial() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokespecialResult = instructionSequenceBuilder.invokespecial(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial(String, String, String)}
   */
  @Test
  public void testInvokespecial2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokespecialResult = instructionSequenceBuilder.invokespecial("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial(String, String, String)}
   */
  @Test
  public void testInvokespecial3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokespecialResult = instructionSequenceBuilder.invokespecial("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial(String, String, String)}
   */
  @Test
  public void testInvokespecial4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokespecialResult = instructionSequenceBuilder.invokespecial("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial(String, String, String)}
   */
  @Test
  public void testInvokespecial5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokespecialResult = instructionSequenceBuilder.invokespecial("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokespecial6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokespecialResult = instructionSequenceBuilder.invokespecial("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokespecial7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokespecialResult = instructionSequenceBuilder.invokespecial("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial(Clazz, Method)}
   */
  @Test
  public void testInvokespecial8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokespecialResult = instructionSequenceBuilder.invokespecial(clazz,
        new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecialResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#invokestatic(int)}
   */
  @Test
  public void testInvokestatic() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokestaticResult = instructionSequenceBuilder.invokestatic(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic(String, String, String)}
   */
  @Test
  public void testInvokestatic2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokestaticResult = instructionSequenceBuilder.invokestatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic(String, String, String)}
   */
  @Test
  public void testInvokestatic3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokestaticResult = instructionSequenceBuilder.invokestatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic(String, String, String)}
   */
  @Test
  public void testInvokestatic4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokestaticResult = instructionSequenceBuilder.invokestatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic(String, String, String)}
   */
  @Test
  public void testInvokestatic5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokestaticResult = instructionSequenceBuilder.invokestatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokestatic6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokestaticResult = instructionSequenceBuilder.invokestatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokestatic7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokestaticResult = instructionSequenceBuilder.invokestatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic(Clazz, Method)}
   */
  @Test
  public void testInvokestatic8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokestaticResult = instructionSequenceBuilder.invokestatic(clazz,
        new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String)}
   */
  @Test
  public void testInvokestatic_interface() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult = instructionSequenceBuilder
        .invokestatic_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String)}
   */
  @Test
  public void testInvokestatic_interface2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult = instructionSequenceBuilder
        .invokestatic_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String)}
   */
  @Test
  public void testInvokestatic_interface3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult = instructionSequenceBuilder
        .invokestatic_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String)}
   */
  @Test
  public void testInvokestatic_interface4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult = instructionSequenceBuilder
        .invokestatic_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokestatic_interface5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult = instructionSequenceBuilder.invokestatic_interface(
        "Class Name", "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic_interface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokestatic_interface6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult = instructionSequenceBuilder.invokestatic_interface(
        "Class Name", "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokestatic_interface(Clazz, Method)}
   */
  @Test
  public void testInvokestatic_interface7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokestatic_interfaceResult = instructionSequenceBuilder
        .invokestatic_interface(clazz, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String)}
   */
  @Test
  public void testInvokespecial_interface() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult = instructionSequenceBuilder
        .invokespecial_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecial_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String)}
   */
  @Test
  public void testInvokespecial_interface2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult = instructionSequenceBuilder
        .invokespecial_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecial_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String)}
   */
  @Test
  public void testInvokespecial_interface3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult = instructionSequenceBuilder
        .invokespecial_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecial_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String)}
   */
  @Test
  public void testInvokespecial_interface4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult = instructionSequenceBuilder
        .invokespecial_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecial_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokespecial_interface5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult = instructionSequenceBuilder.invokespecial_interface(
        "Class Name", "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecial_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial_interface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokespecial_interface6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult = instructionSequenceBuilder.invokespecial_interface(
        "Class Name", "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecial_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokespecial_interface(Clazz, Method)}
   */
  @Test
  public void testInvokespecial_interface7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    InstructionSequenceBuilder actualInvokespecial_interfaceResult = instructionSequenceBuilder
        .invokespecial_interface(clazz, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokespecial_interfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokeinterface(int, int)}
   */
  @Test
  public void testInvokeinterface() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult = instructionSequenceBuilder.invokeinterface(1, 1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokeinterface(String, String, String)}
   */
  @Test
  public void testInvokeinterface2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult = instructionSequenceBuilder.invokeinterface("Class Name",
        "Name", "()D");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokeinterface(String, String, String)}
   */
  @Test
  public void testInvokeinterface3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult = instructionSequenceBuilder.invokeinterface("Class Name",
        "Name", "(D)Ljava/lang/Double;");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokeinterface(String, String, String)}
   */
  @Test
  public void testInvokeinterface4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "", "");

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult = instructionSequenceBuilder.invokeinterface("Class Name",
        "Name", "()D");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokeinterface(String, String, String)}
   */
  @Test
  public void testInvokeinterface5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("", "Name", "()D");
    instructionSequenceBuilder.putstatic("Class Name", "", "");

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult = instructionSequenceBuilder.invokeinterface("Class Name",
        "Name", "()D");

    // Assert
    assertEquals(3, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokeinterface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokeinterface6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult = instructionSequenceBuilder.invokeinterface("Class Name",
        "Name", "()D", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokeinterface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokeinterface7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult = instructionSequenceBuilder.invokeinterface("Class Name",
        "Name", "(D)Ljava/lang/Double;", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokeinterface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokeinterface8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "", "");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InstructionSequenceBuilder actualInvokeinterfaceResult = instructionSequenceBuilder.invokeinterface("Class Name",
        "Name", "()D", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokeinterfaceResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#invokedynamic(int)}
   */
  @Test
  public void testInvokedynamic() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokedynamic(int, String, String)}
   */
  @Test
  public void testInvokedynamic2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1, "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokedynamic(int, String, String)}
   */
  @Test
  public void testInvokedynamic3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1, "Name",
        "Descriptor");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokedynamic(int, String, String)}
   */
  @Test
  public void testInvokedynamic4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1, "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokedynamic(int, String, String)}
   */
  @Test
  public void testInvokedynamic5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1, "Name",
        "Descriptor");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokedynamic(int, String, String, Clazz[])}
   */
  @Test
  public void testInvokedynamic6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1, "Name",
        "Descriptor", new Clazz[]{new LibraryClass()});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokedynamic(int, String, String, Clazz[])}
   */
  @Test
  public void testInvokedynamic7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1, "Name",
        "Descriptor", new Clazz[]{new LibraryClass()});

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokedynamic(int, String, String, Clazz[])}
   */
  @Test
  public void testInvokedynamic8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1, "Name",
        "Descriptor", new Clazz[]{new LibraryClass()});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#invokedynamic(int, String, String, Clazz[])}
   */
  @Test
  public void testInvokedynamic9() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInvokedynamicResult = instructionSequenceBuilder.invokedynamic(1, "Name",
        "Descriptor", new Clazz[]{new LibraryClass()});

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInvokedynamicResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(int)}
   */
  @Test
  public void testNew_() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(String)}
   */
  @Test
  public void testNew_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(String)}
   */
  @Test
  public void testNew_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(String)}
   */
  @Test
  public void testNew_4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(String)}
   */
  @Test
  public void testNew_5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(String, Clazz)}
   */
  @Test
  public void testNew_6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(String, Clazz)}
   */
  @Test
  public void testNew_7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("Class Name", "Name", "Descriptor");

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name", new LibraryClass());

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(String, Clazz)}
   */
  @Test
  public void testNew_8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(String, Clazz)}
   */
  @Test
  public void testNew_9() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_("Class Name", new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(Clazz)}
   */
  @Test
  public void testNew_10() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder
        .new_(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#new_(Clazz)}
   */
  @Test
  public void testNew_11() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualNew_Result = instructionSequenceBuilder.new_(new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualNew_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#newarray(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#anewarray(int)}
   */
  @Test
  public void testAnewarray() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAnewarrayResult = instructionSequenceBuilder.anewarray(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAnewarrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#anewarray(String, Clazz)}
   */
  @Test
  public void testAnewarray2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAnewarrayResult = instructionSequenceBuilder.anewarray("Element Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAnewarrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#anewarray(String, Clazz)}
   */
  @Test
  public void testAnewarray3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualAnewarrayResult = instructionSequenceBuilder.anewarray("Element Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAnewarrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#anewarray(String, Clazz)}
   */
  @Test
  public void testAnewarray4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualAnewarrayResult = instructionSequenceBuilder.anewarray("Element Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAnewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#anewarray(Clazz)}
   */
  @Test
  public void testAnewarray5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualAnewarrayResult = instructionSequenceBuilder
        .anewarray(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAnewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#anewarray(Clazz)}
   */
  @Test
  public void testAnewarray6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualAnewarrayResult = instructionSequenceBuilder.anewarray(new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualAnewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#arraylength()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#athrow()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#checkcast(int)}
   */
  @Test
  public void testCheckcast() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#checkcast(String)}
   */
  @Test
  public void testCheckcast2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast("Type Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#checkcast(String)}
   */
  @Test
  public void testCheckcast3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast("Type Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#checkcast(String)}
   */
  @Test
  public void testCheckcast4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast("Type Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#checkcast(String, Clazz)}
   */
  @Test
  public void testCheckcast5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#checkcast(String, Clazz)}
   */
  @Test
  public void testCheckcast6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#checkcast(String, Clazz)}
   */
  @Test
  public void testCheckcast7() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#checkcast(Clazz)}
   */
  @Test
  public void testCheckcast8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder
        .checkcast(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#checkcast(Clazz)}
   */
  @Test
  public void testCheckcast9() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualCheckcastResult = instructionSequenceBuilder.checkcast(new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualCheckcastResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#instanceof_(int)}
   */
  @Test
  public void testInstanceof_() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInstanceof_Result = instructionSequenceBuilder.instanceof_(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInstanceof_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#instanceof_(String, Clazz)}
   */
  @Test
  public void testInstanceof_2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInstanceof_Result = instructionSequenceBuilder.instanceof_("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInstanceof_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#instanceof_(String, Clazz)}
   */
  @Test
  public void testInstanceof_3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInstanceof_Result = instructionSequenceBuilder.instanceof_("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInstanceof_Result);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#instanceof_(String, Clazz)}
   */
  @Test
  public void testInstanceof_4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInstanceof_Result = instructionSequenceBuilder.instanceof_("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInstanceof_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#instanceof_(Clazz)}
   */
  @Test
  public void testInstanceof_5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualInstanceof_Result = instructionSequenceBuilder
        .instanceof_(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInstanceof_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#instanceof_(Clazz)}
   */
  @Test
  public void testInstanceof_6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualInstanceof_Result = instructionSequenceBuilder.instanceof_(new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualInstanceof_Result);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#monitorenter()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#monitorexit()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#wide()}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#multianewarray(int)}
   */
  @Test
  public void testMultianewarray() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder.multianewarray(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#multianewarray(String)}
   */
  @Test
  public void testMultianewarray2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder.multianewarray("Type Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#multianewarray(String)}
   */
  @Test
  public void testMultianewarray3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder.multianewarray("Type Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#multianewarray(String)}
   */
  @Test
  public void testMultianewarray4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder.multianewarray("Type Name");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#multianewarray(String, Clazz)}
   */
  @Test
  public void testMultianewarray5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder.multianewarray("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#multianewarray(String, Clazz)}
   */
  @Test
  public void testMultianewarray6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder.multianewarray("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#multianewarray(String, Clazz)}
   */
  @Test
  public void testMultianewarray7() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder.multianewarray("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#multianewarray(Clazz)}
   */
  @Test
  public void testMultianewarray8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder
        .multianewarray(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#multianewarray(Clazz)}
   */
  @Test
  public void testMultianewarray9() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    InstructionSequenceBuilder actualMultianewarrayResult = instructionSequenceBuilder
        .multianewarray(new LibraryClass());

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualMultianewarrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#ifnull(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#ifnonnull(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#goto_w(int)}
   */
  @Test
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
   * Method under test: {@link InstructionSequenceBuilder#jsr_w(int)}
   */
  @Test
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
   * Method under test:
   * {@link InstructionSequenceBuilder#pushPrimitive(Object, char)}
   */
  @Test
  public void testPushPrimitive() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new InstructionSequenceBuilder()).pushPrimitive("Value", 'A'));
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new InstructionSequenceBuilder()).boxPrimitiveType('A'));
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('B');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('C');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('D');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('F');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('I');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('J');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('S');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType9() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('Z');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType10() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
    instructionSequenceBuilder.putstatic("java/lang/Byte", "java/lang/Byte", "java/lang/Byte");

    // Act
    InstructionSequenceBuilder actualBoxPrimitiveTypeResult = instructionSequenceBuilder.boxPrimitiveType('B');

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualBoxPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}
   */
  @Test
  public void testUnboxPrimitiveType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).unboxPrimitiveType("Source Type", "Target Type"));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}
   */
  @Test
  public void testUnboxPrimitiveType2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualUnboxPrimitiveTypeResult = instructionSequenceBuilder
        .unboxPrimitiveType("Source Type", "Source Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualUnboxPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#unboxPrimitiveType(String, String)}
   */
  @Test
  public void testUnboxPrimitiveType3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualUnboxPrimitiveTypeResult = instructionSequenceBuilder
        .unboxPrimitiveType("Ljava/lang/Object;", "Source Type");

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualUnboxPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushPrimitiveOrString(Object, String)}
   */
  @Test
  public void testPushPrimitiveOrString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString("Value", "Type"));
    assertThrows(IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString(-1, null));
    assertThrows(IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString("Value", "Type", true));
    assertThrows(IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString(-1, null, false));
    assertThrows(IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrString(-1, "java/lang/Void", false));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushBoxedPrimitive(Object, String)}
   */
  @Test
  public void testPushBoxedPrimitive() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushBoxedPrimitive("Value", "Type"));
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(42);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(-1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(1);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(2);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(3);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(4);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(0);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(5);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushInt(int)}
   */
  @Test
  public void testPushInt9() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushIntResult = instructionSequenceBuilder.pushInt(Integer.MIN_VALUE);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushIntResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushFloat(float)}
   */
  @Test
  public void testPushFloat() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushFloatResult = instructionSequenceBuilder.pushFloat(10.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushFloatResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushFloat(float)}
   */
  @Test
  public void testPushFloat2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushFloatResult = instructionSequenceBuilder.pushFloat(1.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushFloatResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushFloat(float)}
   */
  @Test
  public void testPushFloat3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushFloatResult = instructionSequenceBuilder.pushFloat(2.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushFloatResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushFloat(float)}
   */
  @Test
  public void testPushFloat4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushFloatResult = instructionSequenceBuilder.pushFloat(0.0f);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushFloatResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushLong(long)}
   */
  @Test
  public void testPushLong() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushLongResult = instructionSequenceBuilder.pushLong(42L);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushLongResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushLong(long)}
   */
  @Test
  public void testPushLong2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushLongResult = instructionSequenceBuilder.pushLong(1L);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushLongResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushLong(long)}
   */
  @Test
  public void testPushLong3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushLongResult = instructionSequenceBuilder.pushLong(0L);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushLongResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushDouble(double)}
   */
  @Test
  public void testPushDouble() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushDoubleResult = instructionSequenceBuilder.pushDouble(10.0d);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushDoubleResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushDouble(double)}
   */
  @Test
  public void testPushDouble2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushDoubleResult = instructionSequenceBuilder.pushDouble(1.0d);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushDoubleResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushDouble(double)}
   */
  @Test
  public void testPushDouble3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushDoubleResult = instructionSequenceBuilder.pushDouble(0.0d);

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushDoubleResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type", 3);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type", -1);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type", 1);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type", 2);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type", 4);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type", 0);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type", 5);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type", -128);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray9() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushNewArrayResult = instructionSequenceBuilder.pushNewArray("Type",
        Integer.MIN_VALUE);

    // Assert
    assertEquals(2, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushPrimitiveOrStringArray(String, Object[])}
   */
  @Test
  public void testPushPrimitiveOrStringArray() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new InstructionSequenceBuilder()).pushPrimitiveOrStringArray("Type", new Object[]{"Values"}));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#pushPrimitiveOrStringArray(String, Object[])}
   */
  @Test
  public void testPushPrimitiveOrStringArray2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushPrimitiveOrStringArrayResult = instructionSequenceBuilder
        .pushPrimitiveOrStringArray("Ljava/lang/String;", new Object[]{"42", "42", "42", "42", "42", "42", "42", "42",
            "42", "42", "42", "42", "42", "42", "42", "42", "42", "42"});

    // Assert
    assertEquals(75, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushPrimitiveOrStringArrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#pushDefault(String)}
   */
  @Test
  public void testPushDefault() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualPushDefaultResult = instructionSequenceBuilder.pushDefault("Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualPushDefaultResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  public void testLoad() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'A');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  public void testLoad2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'B');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  public void testLoad3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'D');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  public void testLoad4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'F');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  public void testLoad5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, 'J');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, char)}
   */
  @Test
  public void testLoad6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(-128, 'C');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, String)}
   */
  @Test
  public void testLoad7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(1, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, String)}
   */
  @Test
  public void testLoad8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(66, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#load(int, String)}
   */
  @Test
  public void testLoad9() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadResult = instructionSequenceBuilder.load(-128, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  public void testStore() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'A');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  public void testStore2() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'B');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  public void testStore3() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'D');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  public void testStore4() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'F');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  public void testStore5() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, 'J');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, char)}
   */
  @Test
  public void testStore6() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(-128, 'C');

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, String)}
   */
  @Test
  public void testStore7() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(1, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, String)}
   */
  @Test
  public void testStore8() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(66, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#store(int, String)}
   */
  @Test
  public void testStore9() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreResult = instructionSequenceBuilder.store(-128, "Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#storeToArray(String)}
   */
  @Test
  public void testStoreToArray() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualStoreToArrayResult = instructionSequenceBuilder.storeToArray("Element Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualStoreToArrayResult);
  }

  /**
   * Method under test: {@link InstructionSequenceBuilder#loadFromArray(String)}
   */
  @Test
  public void testLoadFromArray() {
    // Arrange
    InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();

    // Act
    InstructionSequenceBuilder actualLoadFromArrayResult = instructionSequenceBuilder.loadFromArray("Element Type");

    // Assert
    assertEquals(1, instructionSequenceBuilder.size());
    assertSame(instructionSequenceBuilder, actualLoadFromArrayResult);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder()}
   */
  @Test
  public void testNewInstructionSequenceBuilder() {
    // Arrange and Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder();

    // Assert
    ProgramClass targetClass = actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass();
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
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, targetClass.attributes.length);
    assertEquals(0, targetClass.fields.length);
    assertEquals(0, targetClass.methods.length);
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, targetClass.u2interfaces.length);
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
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ClassPool, ClassPool)}
   */
  @Test
  public void testNewInstructionSequenceBuilder2() {
    // Arrange and Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder(
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    ProgramClass targetClass = actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass();
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
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, targetClass.attributes.length);
    assertEquals(0, targetClass.fields.length);
    assertEquals(0, targetClass.methods.length);
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, targetClass.u2interfaces.length);
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
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ClassPool, ClassPool)}
   */
  @Test
  public void testNewInstructionSequenceBuilder3() {
    // Arrange and Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder(null,
        KotlinConstants.dummyClassPool);

    // Assert
    ProgramClass targetClass = actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass();
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
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, targetClass.attributes.length);
    assertEquals(0, targetClass.fields.length);
    assertEquals(0, targetClass.methods.length);
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, targetClass.u2interfaces.length);
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
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass)}
   */
  @Test
  public void testNewInstructionSequenceBuilder4() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder(targetClass);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass)}
   */
  @Test
  public void testNewInstructionSequenceBuilder5() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder(targetClass);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewInstructionSequenceBuilder6() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder(targetClass,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewInstructionSequenceBuilder7() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder(targetClass, null,
        KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewInstructionSequenceBuilder8() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder(targetClass, null,
        KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(targetClass, actualInstructionSequenceBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceBuilder#InstructionSequenceBuilder(ConstantPoolEditor)}
   */
  @Test
  public void testNewInstructionSequenceBuilder9() {
    // Arrange
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(new ProgramClass());

    // Act
    InstructionSequenceBuilder actualInstructionSequenceBuilder = new InstructionSequenceBuilder(constantPoolEditor);

    // Assert
    assertEquals(0, actualInstructionSequenceBuilder.size());
    assertSame(constantPoolEditor, actualInstructionSequenceBuilder.getConstantPoolEditor());
  }
}

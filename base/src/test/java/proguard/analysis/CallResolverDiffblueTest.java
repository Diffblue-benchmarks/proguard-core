package proguard.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.MethodSignature;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;

class CallResolverDiffblueTest {
  /**
   * Test {@link CallResolver#quickResolve(Instruction, ProgramClass)}.
   *
   * <p>Method under test: {@link CallResolver#quickResolve(Instruction, ProgramClass)}
   */
  @Test
  @DisplayName("Test quickResolve(Instruction, ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MethodSignature CallResolver.quickResolve(Instruction, ProgramClass)"})
  void testQuickResolve() {
    // Arrange
    ConstantInstruction instruction = new ConstantInstruction();
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    // Act
    MethodSignature actualQuickResolveResult =
        CallResolver.quickResolve(instruction, new ProgramClass(1, 3, constantPool, 1, 1, 1));

    // Assert
    assertEquals("? ?.?(?)", actualQuickResolveResult.getPrettyFqn());
    assertEquals("?", actualQuickResolveResult.getExternalPackageName());
    assertEquals("?", actualQuickResolveResult.getPackageName());
    assertEquals("L?;?null", actualQuickResolveResult.getFqn());
    assertNull(actualQuickResolveResult.getMethodName());
    assertNull(actualQuickResolveResult.getClassName());
    assertNull(actualQuickResolveResult.getReferencedClass());
    assertNull(actualQuickResolveResult.getReferencedMethod());
    assertNull(actualQuickResolveResult.getDescriptor());
    assertTrue(actualQuickResolveResult.isIncomplete());
  }

  /**
   * Test {@link CallResolver#quickResolve(Instruction, ProgramClass)}.
   *
   * <p>Method under test: {@link CallResolver#quickResolve(Instruction, ProgramClass)}
   */
  @Test
  @DisplayName("Test quickResolve(Instruction, ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MethodSignature CallResolver.quickResolve(Instruction, ProgramClass)"})
  void testQuickResolve2() {
    // Arrange
    ConstantInstruction instruction = new ConstantInstruction();
    Constant[] constantPool = new Constant[] {new InterfaceMethodrefConstant()};

    // Act
    MethodSignature actualQuickResolveResult =
        CallResolver.quickResolve(instruction, new ProgramClass(1, 3, constantPool, 1, 1, 1));

    // Assert
    assertEquals("? ?.?(?)", actualQuickResolveResult.getPrettyFqn());
    assertEquals("?", actualQuickResolveResult.getExternalPackageName());
    assertEquals("?", actualQuickResolveResult.getPackageName());
    assertEquals("L?;?null", actualQuickResolveResult.getFqn());
    assertNull(actualQuickResolveResult.getMethodName());
    assertNull(actualQuickResolveResult.getClassName());
    assertNull(actualQuickResolveResult.getReferencedClass());
    assertNull(actualQuickResolveResult.getReferencedMethod());
    assertNull(actualQuickResolveResult.getDescriptor());
    assertTrue(actualQuickResolveResult.isIncomplete());
  }

  /**
   * Test {@link CallResolver#quickResolve(Instruction, ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@code A} and
   *       branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link CallResolver#quickResolve(Instruction, ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test quickResolve(Instruction, ProgramClass); when BranchInstruction(byte, int) with opcode is 'A' and branchOffset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MethodSignature CallResolver.quickResolve(Instruction, ProgramClass)"})
  void testQuickResolve_whenBranchInstructionWithOpcodeIsAAndBranchOffsetIsOne() {
    // Arrange
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    MethodSignature actualQuickResolveResult =
        CallResolver.quickResolve(instruction, new ProgramClass());

    // Assert
    assertEquals("? ?.?(?)", actualQuickResolveResult.getPrettyFqn());
    assertEquals("?", actualQuickResolveResult.getExternalPackageName());
    assertEquals("?", actualQuickResolveResult.getPackageName());
    assertEquals("L?;?null", actualQuickResolveResult.getFqn());
    assertNull(actualQuickResolveResult.getMethodName());
    assertNull(actualQuickResolveResult.getClassName());
    assertNull(actualQuickResolveResult.getReferencedClass());
    assertNull(actualQuickResolveResult.getReferencedMethod());
    assertNull(actualQuickResolveResult.getDescriptor());
    assertTrue(actualQuickResolveResult.isIncomplete());
  }
}

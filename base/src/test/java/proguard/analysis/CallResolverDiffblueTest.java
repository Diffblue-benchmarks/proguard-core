package proguard.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.MethodSignature;
import proguard.classfile.ProgramClass;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;

class CallResolverDiffblueTest {
  /**
   * Test {@link CallResolver#quickResolve(Instruction, ProgramClass)}.
   *
   * <p>Method under test: {@link CallResolver#quickResolve(Instruction, ProgramClass)}
   */
  @Test
  @DisplayName("Test quickResolve(Instruction, ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.MethodSignature proguard.analysis.CallResolver.quickResolve(proguard.classfile.instruction.Instruction, proguard.classfile.ProgramClass)"
  })
  void testQuickResolve() {
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

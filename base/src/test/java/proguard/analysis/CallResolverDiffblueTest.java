package proguard.analysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.MethodSignature;
import proguard.classfile.ProgramClass;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;

public class CallResolverDiffblueTest {
  /**
   * Method under test:
   * {@link CallResolver#quickResolve(Instruction, ProgramClass)}
   */
  @Test
  public void testQuickResolve() {
    // Arrange
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    MethodSignature actualQuickResolveResult = CallResolver.quickResolve(instruction, new ProgramClass());

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

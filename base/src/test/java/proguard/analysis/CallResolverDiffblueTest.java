package proguard.analysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.MethodSignature;
import proguard.classfile.ProgramClass;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;

public class CallResolverDiffblueTest {
  /**
   * Test {@link CallResolver#quickResolve(Instruction, ProgramClass)}.
   *
   * <p>Method under test: {@link CallResolver#quickResolve(Instruction, ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodSignature CallResolver.quickResolve(Instruction, ProgramClass)"})
  public void testQuickResolve() {
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

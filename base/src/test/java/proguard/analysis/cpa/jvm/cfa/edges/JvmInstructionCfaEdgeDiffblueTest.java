package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class JvmInstructionCfaEdgeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmInstructionCfaEdge#JvmInstructionCfaEdge(CodeAttribute, int)}
   *   <li>{@link JvmInstructionCfaEdge#getMethodCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInstructionCfaEdge.<init>(CodeAttribute, int)",
    "CodeAttribute JvmInstructionCfaEdge.getMethodCode()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmInstructionCfaEdge actualJvmInstructionCfaEdge = new JvmInstructionCfaEdge(methodCode, 2);
    CodeAttribute actualMethodCode = actualJvmInstructionCfaEdge.getMethodCode();

    // Assert
    assertNull(actualJvmInstructionCfaEdge.getSource());
    assertNull(actualJvmInstructionCfaEdge.getTarget());
    assertSame(methodCode, actualMethodCode);
  }

  /**
   * Test {@link JvmInstructionCfaEdge#JvmInstructionCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute,
   * int)}.
   *
   * <ul>
   *   <li>Then Source return {@link JvmUnknownCfaNode}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInstructionCfaEdge#JvmInstructionCfaEdge(JvmCfaNode,
   * JvmCfaNode, CodeAttribute, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInstructionCfaEdge.<init>(JvmCfaNode, JvmCfaNode, CodeAttribute, int)"
  })
  public void testNewJvmInstructionCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmInstructionCfaEdge actualJvmInstructionCfaEdge =
        new JvmInstructionCfaEdge(JvmUnknownCfaNode.INSTANCE, target, methodCode, 2);

    // Assert
    JvmCfaNode source = actualJvmInstructionCfaEdge.getSource();
    assertTrue(source instanceof JvmUnknownCfaNode);
    assertSame(methodCode, actualJvmInstructionCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, source);
    assertSame(jvmUnknownCfaNode, actualJvmInstructionCfaEdge.getTarget());
  }

  /**
   * Test {@link JvmInstructionCfaEdge#getInstruction()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInstructionCfaEdge#getInstruction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction JvmInstructionCfaEdge.getInstruction()"})
  public void testGetInstruction_thenReturnSimpleInstruction() throws UnsupportedEncodingException {
    // Arrange and Act
    Instruction actualInstruction =
        (new JvmInstructionCfaEdge(new CodeAttribute(1, 3, 3, 3, "AXXXAXAX".getBytes("UTF-8")), 2))
            .getInstruction();

    // Assert
    assertTrue(actualInstruction instanceof SimpleInstruction);
    assertEquals("pop2", actualInstruction.getName());
    assertEquals(0, ((SimpleInstruction) actualInstruction).constant);
    assertTrue(actualInstruction.isCategory2());
    assertEquals('X', ((SimpleInstruction) actualInstruction).opcode);
  }

  /**
   * Test {@link JvmInstructionCfaEdge#getInstruction()}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInstructionCfaEdge#getInstruction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction JvmInstructionCfaEdge.getInstruction()"})
  public void testGetInstruction_thenReturnVariableInstruction()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Instruction actualInstruction =
        (new JvmInstructionCfaEdge(new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8")), 2))
            .getInstruction();

    // Assert
    assertTrue(actualInstruction instanceof VariableInstruction);
    assertEquals("lstore_2", actualInstruction.getName());
    assertEquals(2, ((VariableInstruction) actualInstruction).variableIndex);
    assertFalse(((VariableInstruction) actualInstruction).isLoad());
    assertTrue(((VariableInstruction) actualInstruction).isStore());
    assertEquals('A', ((VariableInstruction) actualInstruction).opcode);
  }
}

package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class JvmInstructionCfaEdgeDiffblueTest {
  /**
   * Method under test: {@link JvmInstructionCfaEdge#getInstruction()}
   */
  @Test
  public void testGetInstruction() throws UnsupportedEncodingException {
    // Arrange and Act
    Instruction actualInstruction = (new JvmInstructionCfaEdge(
        new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8")), 2)).getInstruction();

    // Assert
    assertTrue(actualInstruction instanceof VariableInstruction);
    assertEquals("lstore_2", actualInstruction.getName());
    assertEquals(0, ((VariableInstruction) actualInstruction).constant);
    assertEquals(2, ((VariableInstruction) actualInstruction).variableIndex);
    assertFalse(((VariableInstruction) actualInstruction).isLoad());
    assertTrue(actualInstruction.isCategory2());
    assertTrue(((VariableInstruction) actualInstruction).isStore());
    assertEquals('A', ((VariableInstruction) actualInstruction).opcode);
  }

  /**
   * Method under test: {@link JvmInstructionCfaEdge#getInstruction()}
   */
  @Test
  public void testGetInstruction2() throws UnsupportedEncodingException {
    // Arrange and Act
    Instruction actualInstruction = (new JvmInstructionCfaEdge(
        new CodeAttribute(1, 3, 3, 3, "AXXXAXAX".getBytes("UTF-8")), 2)).getInstruction();

    // Assert
    assertTrue(actualInstruction instanceof SimpleInstruction);
    assertEquals("pop2", actualInstruction.getName());
    assertEquals(0, ((SimpleInstruction) actualInstruction).constant);
    assertTrue(actualInstruction.isCategory2());
    assertEquals('X', ((SimpleInstruction) actualInstruction).opcode);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmInstructionCfaEdge#JvmInstructionCfaEdge(CodeAttribute, int)}
   *   <li>{@link JvmInstructionCfaEdge#getMethodCode()}
   * </ul>
   */
  @Test
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
   * Method under test:
   * {@link JvmInstructionCfaEdge#JvmInstructionCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int)}
   */
  @Test
  public void testNewJvmInstructionCfaEdge() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmInstructionCfaEdge actualJvmInstructionCfaEdge = new JvmInstructionCfaEdge(JvmUnknownCfaNode.INSTANCE, target,
        methodCode, 2);

    // Assert
    assertSame(methodCode, actualJvmInstructionCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, actualJvmInstructionCfaEdge.getSource());
    assertSame(jvmUnknownCfaNode, actualJvmInstructionCfaEdge.getTarget());
  }
}

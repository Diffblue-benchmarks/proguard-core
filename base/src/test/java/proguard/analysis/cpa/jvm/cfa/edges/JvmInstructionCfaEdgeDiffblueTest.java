package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;

class JvmInstructionCfaEdgeDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmInstructionCfaEdge.<init>(CodeAttribute, int)",
    "CodeAttribute JvmInstructionCfaEdge.getMethodCode()"
  })
  void testGettersAndSetters() {
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
  @DisplayName(
      "Test new JvmInstructionCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int); then Source return JvmUnknownCfaNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmInstructionCfaEdge.<init>(JvmCfaNode, JvmCfaNode, CodeAttribute, int)"
  })
  void testNewJvmInstructionCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmInstructionCfaEdge actualJvmInstructionCfaEdge =
        new JvmInstructionCfaEdge(
            JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE, methodCode, 2);

    // Assert
    JvmCfaNode source = actualJvmInstructionCfaEdge.getSource();
    assertTrue(source instanceof JvmUnknownCfaNode);
    assertSame(methodCode, actualJvmInstructionCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;
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
  @DisplayName("Test getInstruction(); then return SimpleInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction JvmInstructionCfaEdge.getInstruction()"})
  void testGetInstruction_thenReturnSimpleInstruction() throws UnsupportedEncodingException {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    Instruction actualInstruction = new JvmInstructionCfaEdge(methodCode, 1).getInstruction();

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
  @DisplayName("Test getInstruction(); then return VariableInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction JvmInstructionCfaEdge.getInstruction()"})
  void testGetInstruction_thenReturnVariableInstruction() throws UnsupportedEncodingException {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    Instruction actualInstruction = new JvmInstructionCfaEdge(methodCode, 2).getInstruction();

    // Assert
    assertTrue(actualInstruction instanceof VariableInstruction);
    assertEquals("lstore_2", actualInstruction.getName());
    assertEquals(2, ((VariableInstruction) actualInstruction).variableIndex);
    assertFalse(((VariableInstruction) actualInstruction).isLoad());
    assertTrue(((VariableInstruction) actualInstruction).isStore());
    assertEquals('A', ((VariableInstruction) actualInstruction).opcode);
  }
}

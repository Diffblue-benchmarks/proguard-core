package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class InstructionEvaluationRecordDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InstructionEvaluationRecord#InstructionEvaluationRecord(Boolean, Boolean, Integer, String, Integer, List, List)}
   *   <li>{@link InstructionEvaluationRecord#setJsrBlockEvaluations(List)}
   *   <li>{@link InstructionEvaluationRecord#setUpdatedEvaluationStack(List)}
   *   <li>{@link InstructionEvaluationRecord#getEvaluationCount()}
   *   <li>{@link InstructionEvaluationRecord#getInstruction()}
   *   <li>{@link InstructionEvaluationRecord#getInstructionOffset()}
   *   <li>{@link InstructionEvaluationRecord#getJsrBlockEvaluations()}
   *   <li>{@link InstructionEvaluationRecord#getStackBefore()}
   *   <li>{@link InstructionEvaluationRecord#getUpdatedEvaluationStack()}
   *   <li>{@link InstructionEvaluationRecord#getVariablesBefore()}
   *   <li>{@link InstructionEvaluationRecord#isGeneralization()}
   *   <li>{@link InstructionEvaluationRecord#isSkipEvaluation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();
    ArrayList<String> stackBefore = new ArrayList<>();

    // Act
    InstructionEvaluationRecord actualInstructionEvaluationRecord = new InstructionEvaluationRecord(true, true, 3,
        "Instruction", 1, variablesBefore, stackBefore);
    ArrayList<InstructionBlockEvaluationRecord> jsrBlockEvaluations = new ArrayList<>();
    actualInstructionEvaluationRecord.setJsrBlockEvaluations(jsrBlockEvaluations);
    ArrayList<BranchTargetRecord> updatedEvaluationStack = new ArrayList<>();
    actualInstructionEvaluationRecord.setUpdatedEvaluationStack(updatedEvaluationStack);
    int actualEvaluationCount = actualInstructionEvaluationRecord.getEvaluationCount();
    String actualInstruction = actualInstructionEvaluationRecord.getInstruction();
    int actualInstructionOffset = actualInstructionEvaluationRecord.getInstructionOffset();
    List<InstructionBlockEvaluationRecord> actualJsrBlockEvaluations = actualInstructionEvaluationRecord
        .getJsrBlockEvaluations();
    List<String> actualStackBefore = actualInstructionEvaluationRecord.getStackBefore();
    List<BranchTargetRecord> actualUpdatedEvaluationStack = actualInstructionEvaluationRecord
        .getUpdatedEvaluationStack();
    List<String> actualVariablesBefore = actualInstructionEvaluationRecord.getVariablesBefore();
    boolean actualIsGeneralizationResult = actualInstructionEvaluationRecord.isGeneralization();
    boolean actualIsSkipEvaluationResult = actualInstructionEvaluationRecord.isSkipEvaluation();

    // Assert that nothing has changed
    assertEquals("Instruction", actualInstruction);
    assertEquals(1, actualInstructionOffset);
    assertEquals(3, actualEvaluationCount);
    assertTrue(actualJsrBlockEvaluations.isEmpty());
    assertTrue(actualStackBefore.isEmpty());
    assertTrue(actualUpdatedEvaluationStack.isEmpty());
    assertTrue(actualVariablesBefore.isEmpty());
    assertTrue(actualIsGeneralizationResult);
    assertTrue(actualIsSkipEvaluationResult);
    assertSame(jsrBlockEvaluations, actualJsrBlockEvaluations);
    assertSame(stackBefore, actualStackBefore);
    assertSame(updatedEvaluationStack, actualUpdatedEvaluationStack);
    assertSame(variablesBefore, actualVariablesBefore);
  }

  /**
   * Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();
    InstructionEvaluationRecord instructionEvaluationRecord = new InstructionEvaluationRecord(true, true, 3,
        "Instruction", 1, variablesBefore, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson2() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();
    variablesBefore.add("{");
    InstructionEvaluationRecord instructionEvaluationRecord = new InstructionEvaluationRecord(true, true, 3,
        "Instruction", 1, variablesBefore, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[\"{\"],\"stackBefore\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[\"{\"],\"stackBefore\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson3() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();
    variablesBefore.add("skipEvaluation");
    variablesBefore.add("{");
    InstructionEvaluationRecord instructionEvaluationRecord = new InstructionEvaluationRecord(true, true, 3,
        "Instruction", 1, variablesBefore, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[\"skipEvaluation\",\"{\"],\"stackBefore\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[\"skipEvaluation\",\"{\"],\"stackBefore\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }
}

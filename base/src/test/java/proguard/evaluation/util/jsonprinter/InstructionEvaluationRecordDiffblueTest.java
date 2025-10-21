package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstructionEvaluationRecordDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstructionEvaluationRecord#InstructionEvaluationRecord(Boolean, Boolean, Integer,
   *       String, Integer, List, List)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionEvaluationRecord.<init>(Boolean, Boolean, Integer, String, Integer, List, List)",
    "int InstructionEvaluationRecord.getEvaluationCount()",
    "String InstructionEvaluationRecord.getInstruction()",
    "int InstructionEvaluationRecord.getInstructionOffset()",
    "List InstructionEvaluationRecord.getJsrBlockEvaluations()",
    "List InstructionEvaluationRecord.getStackBefore()",
    "List InstructionEvaluationRecord.getUpdatedEvaluationStack()",
    "List InstructionEvaluationRecord.getVariablesBefore()",
    "boolean InstructionEvaluationRecord.isGeneralization()",
    "boolean InstructionEvaluationRecord.isSkipEvaluation()",
    "void InstructionEvaluationRecord.setJsrBlockEvaluations(List)",
    "void InstructionEvaluationRecord.setUpdatedEvaluationStack(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();
    ArrayList<String> stackBefore = new ArrayList<>();

    // Act
    InstructionEvaluationRecord actualInstructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, stackBefore);
    ArrayList<InstructionBlockEvaluationRecord> jsrBlockEvaluations = new ArrayList<>();
    actualInstructionEvaluationRecord.setJsrBlockEvaluations(jsrBlockEvaluations);
    ArrayList<BranchTargetRecord> updatedEvaluationStack = new ArrayList<>();
    actualInstructionEvaluationRecord.setUpdatedEvaluationStack(updatedEvaluationStack);
    int actualEvaluationCount = actualInstructionEvaluationRecord.getEvaluationCount();
    String actualInstruction = actualInstructionEvaluationRecord.getInstruction();
    int actualInstructionOffset = actualInstructionEvaluationRecord.getInstructionOffset();
    List<InstructionBlockEvaluationRecord> actualJsrBlockEvaluations =
        actualInstructionEvaluationRecord.getJsrBlockEvaluations();
    List<String> actualStackBefore = actualInstructionEvaluationRecord.getStackBefore();
    List<BranchTargetRecord> actualUpdatedEvaluationStack =
        actualInstructionEvaluationRecord.getUpdatedEvaluationStack();
    List<String> actualVariablesBefore = actualInstructionEvaluationRecord.getVariablesBefore();
    boolean actualIsGeneralizationResult = actualInstructionEvaluationRecord.isGeneralization();
    boolean actualIsSkipEvaluationResult = actualInstructionEvaluationRecord.isSkipEvaluation();

    // Assert
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
   * Test {@link InstructionEvaluationRecord#toJson(StringBuilder)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  public void testToJson_givenArrayListAddLeftCurlyBracket() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();
    variablesBefore.add("{");
    InstructionEvaluationRecord instructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[\"{\"],\"stackBefore\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionEvaluationRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code skipEvaluation}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  public void testToJson_givenArrayListAddSkipEvaluation() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();
    variablesBefore.add("skipEvaluation");
    variablesBefore.add("{");
    InstructionEvaluationRecord instructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[\"skipEvaluation\",\"{\"],\"stackBefore\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionEvaluationRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link StringBuilder#StringBuilder(String)} with {@code foo}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  public void testToJson_whenStringBuilderWithFoo_thenStringBuilderWithFooToStringIsAString() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();
    InstructionEvaluationRecord instructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }
}

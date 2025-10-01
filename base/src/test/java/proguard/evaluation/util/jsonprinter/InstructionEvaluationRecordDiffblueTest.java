package proguard.evaluation.util.jsonprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InstructionEvaluationRecordDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  void testGettersAndSetters() {
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
   *
   * <p>Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  void testToJson() {
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

  /**
   * Test {@link InstructionEvaluationRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  void testToJson2() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();

    InstructionEvaluationRecord instructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, new ArrayList<>());
    instructionEvaluationRecord.setUpdatedEvaluationStack(new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[],\"updatedEvaluationStack\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionEvaluationRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  void testToJson3() {
    // Arrange
    ArrayList<String> variablesBefore = new ArrayList<>();

    InstructionEvaluationRecord instructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, new ArrayList<>());
    instructionEvaluationRecord.setJsrBlockEvaluations(new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[],\"jsrBlockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionEvaluationRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  void testToJson4() {
    // Arrange
    ArrayList<BranchTargetRecord> updatedEvaluationStack = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    BranchTargetRecord branchTargetRecord = new BranchTargetRecord(variables, new ArrayList<>(), 1);
    updatedEvaluationStack.add(branchTargetRecord);
    ArrayList<String> variablesBefore = new ArrayList<>();

    InstructionEvaluationRecord instructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, new ArrayList<>());
    instructionEvaluationRecord.setUpdatedEvaluationStack(updatedEvaluationStack);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[],\"updatedEvaluationStack\":[{\"startOffset\""
            + ":1,\"startStack\":[],\"startVariables\":[]}]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionEvaluationRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  void testToJson5() {
    // Arrange
    ArrayList<BranchTargetRecord> updatedEvaluationStack = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    BranchTargetRecord branchTargetRecord = new BranchTargetRecord(variables, new ArrayList<>(), 1);
    updatedEvaluationStack.add(branchTargetRecord);
    ArrayList<String> variables2 = new ArrayList<>();
    BranchTargetRecord branchTargetRecord2 =
        new BranchTargetRecord(variables2, new ArrayList<>(), 1);
    updatedEvaluationStack.add(branchTargetRecord2);
    ArrayList<String> variablesBefore = new ArrayList<>();

    InstructionEvaluationRecord instructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, new ArrayList<>());
    instructionEvaluationRecord.setUpdatedEvaluationStack(updatedEvaluationStack);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[],\"updatedEvaluationStack\":[{\"startOffset\""
            + ":1,\"startStack\":[],\"startVariables\":[]},{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionEvaluationRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  void testToJson6() {
    // Arrange
    ArrayList<InstructionBlockEvaluationRecord> jsrBlockEvaluations = new ArrayList<>();
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "{");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>());
    jsrBlockEvaluations.add(instructionBlockEvaluationRecord);
    ArrayList<String> variablesBefore = new ArrayList<>();

    InstructionEvaluationRecord instructionEvaluationRecord =
        new InstructionEvaluationRecord(
            true, true, 3, "Instruction", 1, variablesBefore, new ArrayList<>());
    instructionEvaluationRecord.setJsrBlockEvaluations(jsrBlockEvaluations);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"Instruction\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[],\"jsrBlockEvaluations\":[{\"startOffset\":1,"
            + "\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{\"catchStartOffset\":1,\"catchEndOffset"
            + "\":1,\"handlerStartOffset\":1,\"catchType\":\"{\"},\"startVariables\":[],\"startStack\":[]}]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
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
  @DisplayName("Test toJson(StringBuilder); given ArrayList() add '{'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddLeftCurlyBracket() {
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
  @DisplayName("Test toJson(StringBuilder); given ArrayList() add 'skipEvaluation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionEvaluationRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddSkipEvaluation() {
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
}

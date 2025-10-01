package proguard.evaluation.util.jsonprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InstructionBlockEvaluationRecordDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstructionBlockEvaluationRecord#InstructionBlockEvaluationRecord(List, List, int,
   *       ExceptionHandlerRecord, List)}
   *   <li>{@link InstructionBlockEvaluationRecord#setStartStack(List)}
   *   <li>{@link InstructionBlockEvaluationRecord#setStartVariables(List)}
   *   <li>{@link InstructionBlockEvaluationRecord#getBranchEvaluationStack()}
   *   <li>{@link InstructionBlockEvaluationRecord#getEvaluations()}
   *   <li>{@link InstructionBlockEvaluationRecord#getExceptionHandlerInfo()}
   *   <li>{@link InstructionBlockEvaluationRecord#getStartOffset()}
   *   <li>{@link InstructionBlockEvaluationRecord#getStartStack()}
   *   <li>{@link InstructionBlockEvaluationRecord#getStartVariables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InstructionBlockEvaluationRecord.<init>(List, List, int, ExceptionHandlerRecord, List)",
    "List InstructionBlockEvaluationRecord.getBranchEvaluationStack()",
    "List InstructionBlockEvaluationRecord.getEvaluations()",
    "ExceptionHandlerRecord InstructionBlockEvaluationRecord.getExceptionHandlerInfo()",
    "int InstructionBlockEvaluationRecord.getStartOffset()",
    "List InstructionBlockEvaluationRecord.getStartStack()",
    "List InstructionBlockEvaluationRecord.getStartVariables()",
    "void InstructionBlockEvaluationRecord.setStartStack(List)",
    "void InstructionBlockEvaluationRecord.setStartVariables(List)"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");
    ArrayList<BranchTargetRecord> branchEvaluationStack = new ArrayList<>();

    // Act
    InstructionBlockEvaluationRecord actualInstructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, branchEvaluationStack);
    ArrayList<String> startStack2 = new ArrayList<>();
    actualInstructionBlockEvaluationRecord.setStartStack(startStack2);
    ArrayList<String> startVariables2 = new ArrayList<>();
    actualInstructionBlockEvaluationRecord.setStartVariables(startVariables2);
    List<BranchTargetRecord> actualBranchEvaluationStack =
        actualInstructionBlockEvaluationRecord.getBranchEvaluationStack();
    List<InstructionEvaluationRecord> actualEvaluations =
        actualInstructionBlockEvaluationRecord.getEvaluations();
    ExceptionHandlerRecord actualExceptionHandlerInfo =
        actualInstructionBlockEvaluationRecord.getExceptionHandlerInfo();
    int actualStartOffset = actualInstructionBlockEvaluationRecord.getStartOffset();
    List<String> actualStartStack = actualInstructionBlockEvaluationRecord.getStartStack();
    List<String> actualStartVariables = actualInstructionBlockEvaluationRecord.getStartVariables();

    // Assert
    assertEquals(1, actualStartOffset);
    assertTrue(actualBranchEvaluationStack.isEmpty());
    assertTrue(actualEvaluations.isEmpty());
    assertTrue(actualStartStack.isEmpty());
    assertTrue(actualStartVariables.isEmpty());
    assertSame(branchEvaluationStack, actualBranchEvaluationStack);
    assertSame(startStack2, actualStartStack);
    assertSame(startVariables2, actualStartVariables);
    assertSame(exceptionHandlerInfo, actualExceptionHandlerInfo);
  }

  /**
   * Test {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionBlockEvaluationRecord.toJson(StringBuilder)"})
  void testToJson() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, null, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionBlockEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"startVariables\":[],\"startStack\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionBlockEvaluationRecord.toJson(StringBuilder)"})
  void testToJson2() {
    // Arrange
    ArrayList<BranchTargetRecord> branchEvaluationStack = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    BranchTargetRecord branchTargetRecord = new BranchTargetRecord(variables, new ArrayList<>(), 1);
    branchEvaluationStack.add(branchTargetRecord);
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, branchEvaluationStack);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionBlockEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[{\"startOffset\":1,\"startStack\":[],"
            + "\"startVariables\":[]}],\"exceptionHandlerInfo\":{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset"
            + "\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[],\"startStack\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionBlockEvaluationRecord.toJson(StringBuilder)"})
  void testToJson3() {
    // Arrange
    ArrayList<BranchTargetRecord> branchEvaluationStack = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    BranchTargetRecord branchTargetRecord = new BranchTargetRecord(variables, new ArrayList<>(), 1);
    branchEvaluationStack.add(branchTargetRecord);
    ArrayList<String> variables2 = new ArrayList<>();
    BranchTargetRecord branchTargetRecord2 =
        new BranchTargetRecord(variables2, new ArrayList<>(), 1);
    branchEvaluationStack.add(branchTargetRecord2);
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, branchEvaluationStack);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionBlockEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[{\"startOffset\":1,\"startStack\":[],"
            + "\"startVariables\":[]},{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}],\"exceptionHandlerInfo\":{"
            + "\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"},\"startVariables"
            + "\":[],\"startStack\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder); given ArrayList() add '{'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionBlockEvaluationRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddLeftCurlyBracket() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    startVariables.add("{");
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionBlockEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{\"catchStartOffset"
            + "\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[\"{\"],"
            + "\"startStack\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code startOffset}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder); given ArrayList() add 'startOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionBlockEvaluationRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddStartOffset() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    startVariables.add("startOffset");
    startVariables.add("{");
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionBlockEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{\"catchStartOffset"
            + "\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[\"startOffset"
            + "\",\"{\"],\"startStack\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test toJson(StringBuilder); then StringBuilder(String) with 'foo' toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionBlockEvaluationRecord.toJson(StringBuilder)"})
  void testToJson_thenStringBuilderWithFooToStringIsAString() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionBlockEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{\"catchStartOffset"
            + "\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[],\"startStack"
            + "\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionBlockEvaluationRecord#getLastInstructionEvaluation()}.
   *
   * <p>Method under test: {@link InstructionBlockEvaluationRecord#getLastInstructionEvaluation()}
   */
  @Test
  @DisplayName("Test getLastInstructionEvaluation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InstructionEvaluationRecord InstructionBlockEvaluationRecord.getLastInstructionEvaluation()"
  })
  void testGetLastInstructionEvaluation() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord =
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>());

    // Act and Assert
    assertNull(instructionBlockEvaluationRecord.getLastInstructionEvaluation());
  }
}

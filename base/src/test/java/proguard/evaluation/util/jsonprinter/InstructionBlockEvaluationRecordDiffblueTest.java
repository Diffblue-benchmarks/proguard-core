package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class InstructionBlockEvaluationRecordDiffblueTest {
  /**
   * Method under test:
   * {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord = new InstructionBlockEvaluationRecord(
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
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{\"catchStartOffset"
            + "\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[],\"startStack"
            + "\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test:
   * {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson2() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    startVariables.add("{");
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord = new InstructionBlockEvaluationRecord(
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
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{\"catchStartOffset"
            + "\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[\"{\"],"
            + "\"startStack\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test:
   * {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson3() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    startVariables.add("startOffset");
    startVariables.add("{");
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord = new InstructionBlockEvaluationRecord(
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
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{\"catchStartOffset"
            + "\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[\"startOffset"
            + "\",\"{\"],\"startStack\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test:
   * {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson4() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord = new InstructionBlockEvaluationRecord(
        startVariables, startStack, 1, null, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionBlockEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"startVariables\":[],\"startStack\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"startVariables\":[],\"startStack\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test:
   * {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson5() {
    // Arrange
    ArrayList<BranchTargetRecord> branchEvaluationStack = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    branchEvaluationStack.add(new BranchTargetRecord(variables, new ArrayList<>(), 1));
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord = new InstructionBlockEvaluationRecord(
        startVariables, startStack, 1, new ExceptionHandlerRecord(1, 1, 1, "Catch Type"), branchEvaluationStack);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionBlockEvaluationRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[{\"startOffset\":1,\"startStack\":[],"
            + "\"startVariables\":[]}],\"exceptionHandlerInfo\":{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset"
            + "\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[],\"startStack\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[{\"startOffset\":1,\"startStack\":[],"
            + "\"startVariables\":[]}],\"exceptionHandlerInfo\":{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset"
            + "\":1,\"catchType\":\"Catch Type\"},\"startVariables\":[],\"startStack\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test:
   * {@link InstructionBlockEvaluationRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson6() {
    // Arrange
    ArrayList<BranchTargetRecord> branchEvaluationStack = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    branchEvaluationStack.add(new BranchTargetRecord(variables, new ArrayList<>(), 1));
    ArrayList<String> variables2 = new ArrayList<>();
    branchEvaluationStack.add(new BranchTargetRecord(variables2, new ArrayList<>(), 1));
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    InstructionBlockEvaluationRecord instructionBlockEvaluationRecord = new InstructionBlockEvaluationRecord(
        startVariables, startStack, 1, new ExceptionHandlerRecord(1, 1, 1, "Catch Type"), branchEvaluationStack);
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
    assertEquals(
        "foo{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[{\"startOffset\":1,\"startStack\":[],"
            + "\"startVariables\":[]},{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}],\"exceptionHandlerInfo\":{"
            + "\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"},\"startVariables"
            + "\":[],\"startStack\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test:
   * {@link InstructionBlockEvaluationRecord#getLastInstructionEvaluation()}
   */
  @Test
  public void testGetLastInstructionEvaluation() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    // Act and Assert
    assertNull(
        (new InstructionBlockEvaluationRecord(startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>()))
            .getLastInstructionEvaluation());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InstructionBlockEvaluationRecord#InstructionBlockEvaluationRecord(List, List, int, ExceptionHandlerRecord, List)}
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
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");

    ArrayList<BranchTargetRecord> branchEvaluationStack = new ArrayList<>();

    // Act
    InstructionBlockEvaluationRecord actualInstructionBlockEvaluationRecord = new InstructionBlockEvaluationRecord(
        startVariables, startStack, 1, exceptionHandlerInfo, branchEvaluationStack);
    ArrayList<String> startStack2 = new ArrayList<>();
    actualInstructionBlockEvaluationRecord.setStartStack(startStack2);
    ArrayList<String> startVariables2 = new ArrayList<>();
    actualInstructionBlockEvaluationRecord.setStartVariables(startVariables2);
    List<BranchTargetRecord> actualBranchEvaluationStack = actualInstructionBlockEvaluationRecord
        .getBranchEvaluationStack();
    List<InstructionEvaluationRecord> actualEvaluations = actualInstructionBlockEvaluationRecord.getEvaluations();
    ExceptionHandlerRecord actualExceptionHandlerInfo = actualInstructionBlockEvaluationRecord
        .getExceptionHandlerInfo();
    int actualStartOffset = actualInstructionBlockEvaluationRecord.getStartOffset();
    List<String> actualStartStack = actualInstructionBlockEvaluationRecord.getStartStack();
    List<String> actualStartVariables = actualInstructionBlockEvaluationRecord.getStartVariables();

    // Assert that nothing has changed
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
}

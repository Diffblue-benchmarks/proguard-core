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

class CodeAttributeRecordDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeAttributeRecord#CodeAttributeRecord(String, String, List, List)}
   *   <li>{@link CodeAttributeRecord#setError(ErrorRecord)}
   *   <li>{@link CodeAttributeRecord#getBlockEvaluations()}
   *   <li>{@link CodeAttributeRecord#getClazz()}
   *   <li>{@link CodeAttributeRecord#getError()}
   *   <li>{@link CodeAttributeRecord#getInstructions()}
   *   <li>{@link CodeAttributeRecord#getMethod()}
   *   <li>{@link CodeAttributeRecord#getParameters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CodeAttributeRecord.<init>(String, String, List, List)",
    "List CodeAttributeRecord.getBlockEvaluations()",
    "String CodeAttributeRecord.getClazz()",
    "ErrorRecord CodeAttributeRecord.getError()",
    "List CodeAttributeRecord.getInstructions()",
    "String CodeAttributeRecord.getMethod()",
    "List CodeAttributeRecord.getParameters()",
    "void CodeAttributeRecord.setError(ErrorRecord)"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    ArrayList<InstructionRecord> instructions = new ArrayList<>();

    // Act
    CodeAttributeRecord actualCodeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", parameters, instructions);
    ErrorRecord error = new ErrorRecord(1, "Not all who wander are lost");
    actualCodeAttributeRecord.setError(error);
    List<InstructionBlockEvaluationRecord> actualBlockEvaluations =
        actualCodeAttributeRecord.getBlockEvaluations();
    String actualClazz = actualCodeAttributeRecord.getClazz();
    ErrorRecord actualError = actualCodeAttributeRecord.getError();
    List<InstructionRecord> actualInstructions = actualCodeAttributeRecord.getInstructions();
    String actualMethod = actualCodeAttributeRecord.getMethod();
    List<String> actualParameters = actualCodeAttributeRecord.getParameters();

    // Assert
    assertEquals("Clazz", actualClazz);
    assertEquals("Method", actualMethod);
    assertTrue(actualBlockEvaluations.isEmpty());
    assertTrue(actualInstructions.isEmpty());
    assertTrue(actualParameters.isEmpty());
    assertSame(instructions, actualInstructions);
    assertSame(parameters, actualParameters);
    assertSame(error, actualError);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson2() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    parameters.add("{");
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[\"{\"],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson3() {
    // Arrange
    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(new InstructionRecord(2, "{"));
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(), instructions);
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\"}],\"parameters\":["
            + "],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson4() {
    // Arrange
    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(new InstructionRecord(2, "{"));
    instructions.add(new InstructionRecord(2, "{"));
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(), instructions);
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\"},{\"offset\":2,"
            + "\"instruction\":\"{\"}],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson5() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();

    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    codeAttributeRecord.setError(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[],\"error"
            + "\":{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson6() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "{");
    instructionRecord.setFinalStackBefore(new ArrayList<>());

    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(instructionRecord);
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(), instructions);
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\",\"finalStackBefore"
            + "\":[]}],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson7() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "{");
    instructionRecord.setFinalTargetInstructions(new ArrayList<>());

    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(instructionRecord);
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(), instructions);
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\",\"finalTargetInstructions"
            + "\":[]}],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code clazz}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test toJson(StringBuilder); given ArrayList() add 'clazz'; then StringBuilder(String) with 'Str' toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddClazz_thenStringBuilderWithStrToStringIsAString() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    parameters.add("clazz");
    parameters.add("{");
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[\"clazz\",\"{\"],\"blockEvaluations"
            + "\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test toJson(StringBuilder); given ArrayList() add one; then StringBuilder(String) with 'Str' toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddOne_thenStringBuilderWithStrToStringIsAString() {
    // Arrange
    ArrayList<Integer> finalTargetInstructions = new ArrayList<>();
    finalTargetInstructions.add(1);
    finalTargetInstructions.add(2);

    InstructionRecord instructionRecord = new InstructionRecord(2, "{");
    instructionRecord.setFinalTargetInstructions(finalTargetInstructions);

    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(instructionRecord);
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(), instructions);
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\",\"finalTargetInstructions"
            + "\":[1,2]}],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test toJson(StringBuilder); given ArrayList() add two; then StringBuilder(String) with 'Str' toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddTwo_thenStringBuilderWithStrToStringIsAString() {
    // Arrange
    ArrayList<Integer> finalTargetInstructions = new ArrayList<>();
    finalTargetInstructions.add(2);

    InstructionRecord instructionRecord = new InstructionRecord(2, "{");
    instructionRecord.setFinalTargetInstructions(finalTargetInstructions);

    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(instructionRecord);
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(), instructions);
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\",\"finalTargetInstructions"
            + "\":[2]}],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }
}

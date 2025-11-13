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

class InstructionRecordDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstructionRecord#InstructionRecord(int, String)}
   *   <li>{@link InstructionRecord#setFinalOriginInstructions(List)}
   *   <li>{@link InstructionRecord#setFinalStackBefore(List)}
   *   <li>{@link InstructionRecord#setFinalTargetInstructions(List)}
   *   <li>{@link InstructionRecord#setFinalVariablesBefore(List)}
   *   <li>{@link InstructionRecord#getFinalOriginInstructions()}
   *   <li>{@link InstructionRecord#getFinalStackBefore()}
   *   <li>{@link InstructionRecord#getFinalTargetInstructions()}
   *   <li>{@link InstructionRecord#getFinalVariablesBefore()}
   *   <li>{@link InstructionRecord#getInstruction()}
   *   <li>{@link InstructionRecord#getOffset()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InstructionRecord.<init>(int, String)",
    "List InstructionRecord.getFinalOriginInstructions()",
    "List InstructionRecord.getFinalStackBefore()",
    "List InstructionRecord.getFinalTargetInstructions()",
    "List InstructionRecord.getFinalVariablesBefore()",
    "String InstructionRecord.getInstruction()",
    "int InstructionRecord.getOffset()",
    "void InstructionRecord.setFinalOriginInstructions(List)",
    "void InstructionRecord.setFinalStackBefore(List)",
    "void InstructionRecord.setFinalTargetInstructions(List)",
    "void InstructionRecord.setFinalVariablesBefore(List)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    InstructionRecord actualInstructionRecord = new InstructionRecord(2, "Instruction");
    ArrayList<Integer> finalOriginInstructions = new ArrayList<>();
    actualInstructionRecord.setFinalOriginInstructions(finalOriginInstructions);
    ArrayList<String> finalStackBefore = new ArrayList<>();
    actualInstructionRecord.setFinalStackBefore(finalStackBefore);
    ArrayList<Integer> finalTargetInstructions = new ArrayList<>();
    actualInstructionRecord.setFinalTargetInstructions(finalTargetInstructions);
    ArrayList<String> finalVariablesBefore = new ArrayList<>();
    actualInstructionRecord.setFinalVariablesBefore(finalVariablesBefore);
    List<Integer> actualFinalOriginInstructions =
        actualInstructionRecord.getFinalOriginInstructions();
    List<String> actualFinalStackBefore = actualInstructionRecord.getFinalStackBefore();
    List<Integer> actualFinalTargetInstructions =
        actualInstructionRecord.getFinalTargetInstructions();
    List<String> actualFinalVariablesBefore = actualInstructionRecord.getFinalVariablesBefore();
    String actualInstruction = actualInstructionRecord.getInstruction();

    // Assert
    assertEquals("Instruction", actualInstruction);
    assertEquals(2, actualInstructionRecord.getOffset());
    assertTrue(actualFinalOriginInstructions.isEmpty());
    assertTrue(actualFinalStackBefore.isEmpty());
    assertTrue(actualFinalTargetInstructions.isEmpty());
    assertTrue(actualFinalVariablesBefore.isEmpty());
    assertSame(finalOriginInstructions, actualFinalOriginInstructions);
    assertSame(finalStackBefore, actualFinalStackBefore);
    assertSame(finalTargetInstructions, actualFinalTargetInstructions);
    assertSame(finalVariablesBefore, actualFinalVariablesBefore);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  void testToJson() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalStackBefore(new ArrayList<>());
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"offset\":2,\"instruction\":\"Instruction\",\"finalStackBefore\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test toJson(StringBuilder); given ArrayList() add 'foo'; then StringBuilder(String) with 'Str' toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddFoo_thenStringBuilderWithStrToStringIsAString() {
    // Arrange
    ArrayList<String> finalVariablesBefore = new ArrayList<>();
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");

    ArrayList<String> finalStackBefore = new ArrayList<>();
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");

    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(finalVariablesBefore);
    instructionRecord.setFinalStackBefore(finalStackBefore);
    instructionRecord.setFinalTargetInstructions(new ArrayList<>());
    instructionRecord.setFinalOriginInstructions(new ArrayList<>());
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"offset\":2,\"instruction\":\"Instruction\",\"finalVariablesBefore\":[\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo"
            + "\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\"],\"finalStackBefore\":"
            + "[\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo"
            + "\",\"foo\",\"foo\"],\"finalTargetInstructions\":[],\"finalOriginInstructions\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test toJson(StringBuilder); given ArrayList() add one; then StringBuilder(String) with 'Str' toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddOne_thenStringBuilderWithStrToStringIsAString() {
    // Arrange
    ArrayList<String> finalVariablesBefore = new ArrayList<>();
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");

    ArrayList<String> finalStackBefore = new ArrayList<>();
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");

    ArrayList<Integer> finalTargetInstructions = new ArrayList<>();
    finalTargetInstructions.add(1);
    finalTargetInstructions.add(2);

    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(finalVariablesBefore);
    instructionRecord.setFinalStackBefore(finalStackBefore);
    instructionRecord.setFinalTargetInstructions(finalTargetInstructions);
    instructionRecord.setFinalOriginInstructions(new ArrayList<>());
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"offset\":2,\"instruction\":\"Instruction\",\"finalVariablesBefore\":[\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo"
            + "\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\"],\"finalStackBefore\":"
            + "[\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo"
            + "\",\"foo\",\"foo\"],\"finalTargetInstructions\":[1,2],\"finalOriginInstructions\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test toJson(StringBuilder); given ArrayList() add two; then StringBuilder(String) with 'Str' toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  void testToJson_givenArrayListAddTwo_thenStringBuilderWithStrToStringIsAString() {
    // Arrange
    ArrayList<String> finalVariablesBefore = new ArrayList<>();
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");
    finalVariablesBefore.add("foo");

    ArrayList<String> finalStackBefore = new ArrayList<>();
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");
    finalStackBefore.add("foo");

    ArrayList<Integer> finalTargetInstructions = new ArrayList<>();
    finalTargetInstructions.add(2);

    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(finalVariablesBefore);
    instructionRecord.setFinalStackBefore(finalStackBefore);
    instructionRecord.setFinalTargetInstructions(finalTargetInstructions);
    instructionRecord.setFinalOriginInstructions(new ArrayList<>());
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"offset\":2,\"instruction\":\"Instruction\",\"finalVariablesBefore\":[\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo"
            + "\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\"],\"finalStackBefore\":"
            + "[\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo"
            + "\",\"foo\",\"foo\"],\"finalTargetInstructions\":[2],\"finalOriginInstructions\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is {@code
   *       Str{"offset":2,"instruction":"Instruction"}}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test toJson(StringBuilder); then StringBuilder(String) with 'Str' toString is 'Str{\"offset\":2,\"instruction\":\"Instruction\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  void testToJson_thenStringBuilderWithStrToStringIsStrOffset2InstructionInstruction() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals("Str{\"offset\":2,\"instruction\":\"Instruction\"}", builder.toString());
    assertSame(builder, actualToJsonResult);
  }
}

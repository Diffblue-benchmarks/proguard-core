package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class InstructionRecordDiffblueTest {
  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
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
    List<Integer> actualFinalOriginInstructions = actualInstructionRecord.getFinalOriginInstructions();
    List<String> actualFinalStackBefore = actualInstructionRecord.getFinalStackBefore();
    List<Integer> actualFinalTargetInstructions = actualInstructionRecord.getFinalTargetInstructions();
    List<String> actualFinalVariablesBefore = actualInstructionRecord.getFinalVariablesBefore();
    String actualInstruction = actualInstructionRecord.getInstruction();

    // Assert that nothing has changed
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
   * Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\"}", builder.toString());
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\"}", actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson2() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(null);
    instructionRecord.setFinalStackBefore(null);
    instructionRecord.setFinalTargetInstructions(null);
    instructionRecord.setFinalOriginInstructions(new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[]}",
        builder.toString());
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson3() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(null);
    instructionRecord.setFinalStackBefore(null);
    instructionRecord.setFinalTargetInstructions(new ArrayList<>());
    instructionRecord.setFinalOriginInstructions(null);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalTargetInstructions\":[]}",
        builder.toString());
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalTargetInstructions\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson4() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(null);
    instructionRecord.setFinalStackBefore(new ArrayList<>());
    instructionRecord.setFinalTargetInstructions(null);
    instructionRecord.setFinalOriginInstructions(null);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalStackBefore\":[]}", builder.toString());
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalStackBefore\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson5() {
    // Arrange
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
    instructionRecord.setFinalVariablesBefore(null);
    instructionRecord.setFinalStackBefore(finalStackBefore);
    instructionRecord.setFinalTargetInstructions(null);
    instructionRecord.setFinalOriginInstructions(null);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalStackBefore\":[\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\","
            + "\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\"]}",
        builder.toString());
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalStackBefore\":[\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\","
            + "\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\",\"foo\"]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson6() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(new ArrayList<>());
    instructionRecord.setFinalStackBefore(null);
    instructionRecord.setFinalTargetInstructions(null);
    instructionRecord.setFinalOriginInstructions(new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalVariablesBefore\":[],\"finalOriginInstructions\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalVariablesBefore\":[],\"finalOriginInstructions\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson7() {
    // Arrange
    ArrayList<Integer> finalOriginInstructions = new ArrayList<>();
    finalOriginInstructions.add(2);

    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(null);
    instructionRecord.setFinalStackBefore(null);
    instructionRecord.setFinalTargetInstructions(null);
    instructionRecord.setFinalOriginInstructions(finalOriginInstructions);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[2]}",
        builder.toString());
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[2]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson8() {
    // Arrange
    ArrayList<Integer> finalOriginInstructions = new ArrayList<>();
    finalOriginInstructions.add(1);
    finalOriginInstructions.add(2);

    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    instructionRecord.setFinalVariablesBefore(null);
    instructionRecord.setFinalStackBefore(null);
    instructionRecord.setFinalTargetInstructions(null);
    instructionRecord.setFinalOriginInstructions(finalOriginInstructions);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[1,2]}",
        builder.toString());
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[1,2]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }
}

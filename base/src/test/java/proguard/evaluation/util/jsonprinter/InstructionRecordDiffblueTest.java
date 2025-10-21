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

public class InstructionRecordDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  public void testToJson() {
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
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  public void testToJson2() {
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
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalTargetInstructions\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  public void testToJson3() {
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
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalStackBefore\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  public void testToJson4() {
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
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  public void testToJson5() {
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
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[2]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  public void testToJson6() {
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
    assertEquals(
        "foo{\"offset\":2,\"instruction\":\"Instruction\",\"finalOriginInstructions\":[1,2]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  public void testToJson_givenArrayListAddFoo_thenStringBuilderWithFooToStringIsAString() {
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
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link InstructionRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo{"offset":2,"instruction":"Instruction"}}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder InstructionRecord.toJson(StringBuilder)"})
  public void testToJson_thenStringBuilderWithFooToStringIsFooOffset2InstructionInstruction() {
    // Arrange
    InstructionRecord instructionRecord = new InstructionRecord(2, "Instruction");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = instructionRecord.toJson(builder);

    // Assert
    assertEquals("foo{\"offset\":2,\"instruction\":\"Instruction\"}", builder.toString());
    assertSame(builder, actualToJsonResult);
  }
}

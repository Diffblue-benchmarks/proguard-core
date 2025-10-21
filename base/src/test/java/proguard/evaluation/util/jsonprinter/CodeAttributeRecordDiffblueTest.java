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

public class CodeAttributeRecordDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
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
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  public void testToJson() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  public void testToJson2() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    parameters.add("{");
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[\"{\"],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  public void testToJson3() {
    // Arrange
    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(new InstructionRecord(2, "{"));
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(), instructions);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\"}],\"parameters\":["
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  public void testToJson4() {
    // Arrange
    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(new InstructionRecord(2, "{"));
    instructions.add(new InstructionRecord(2, "{"));
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(), instructions);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\"},{\"offset\":2,"
            + "\"instruction\":\"{\"}],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link CodeAttributeRecord#toJson(StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code clazz}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder CodeAttributeRecord.toJson(StringBuilder)"})
  public void testToJson_givenArrayListAddClazz_thenStringBuilderWithFooToStringIsAString() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    parameters.add("clazz");
    parameters.add("{");
    CodeAttributeRecord codeAttributeRecord =
        new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[\"clazz\",\"{\"],\"blockEvaluations"
            + "\":[]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }
}

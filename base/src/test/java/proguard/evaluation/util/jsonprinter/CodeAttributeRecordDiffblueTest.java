package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CodeAttributeRecordDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CodeAttributeRecord#CodeAttributeRecord(String, String, List, List)}
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
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    ArrayList<InstructionRecord> instructions = new ArrayList<>();

    // Act
    CodeAttributeRecord actualCodeAttributeRecord = new CodeAttributeRecord("Clazz", "Method", parameters,
        instructions);
    ErrorRecord error = new ErrorRecord(1, "Not all who wander are lost");

    actualCodeAttributeRecord.setError(error);
    List<InstructionBlockEvaluationRecord> actualBlockEvaluations = actualCodeAttributeRecord.getBlockEvaluations();
    String actualClazz = actualCodeAttributeRecord.getClazz();
    ErrorRecord actualError = actualCodeAttributeRecord.getError();
    List<InstructionRecord> actualInstructions = actualCodeAttributeRecord.getInstructions();
    String actualMethod = actualCodeAttributeRecord.getMethod();
    List<String> actualParameters = actualCodeAttributeRecord.getParameters();

    // Assert that nothing has changed
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
   * Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    CodeAttributeRecord codeAttributeRecord = new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson2() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    parameters.add("{");
    CodeAttributeRecord codeAttributeRecord = new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[\"{\"],\"blockEvaluations\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[\"{\"],\"blockEvaluations\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson3() {
    // Arrange
    ArrayList<String> parameters = new ArrayList<>();
    parameters.add("clazz");
    parameters.add("{");
    CodeAttributeRecord codeAttributeRecord = new CodeAttributeRecord("Clazz", "Method", parameters, new ArrayList<>());
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[\"clazz\",\"{\"],\"blockEvaluations"
            + "\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[],\"parameters\":[\"clazz\",\"{\"],\"blockEvaluations"
            + "\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson4() {
    // Arrange
    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(new InstructionRecord(2, "{"));
    CodeAttributeRecord codeAttributeRecord = new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(),
        instructions);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\"}],\"parameters\":["
            + "],\"blockEvaluations\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\"}],\"parameters\":["
            + "],\"blockEvaluations\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Method under test: {@link CodeAttributeRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson5() {
    // Arrange
    ArrayList<InstructionRecord> instructions = new ArrayList<>();
    instructions.add(new InstructionRecord(2, "{"));
    instructions.add(new InstructionRecord(2, "{"));
    CodeAttributeRecord codeAttributeRecord = new CodeAttributeRecord("Clazz", "Method", new ArrayList<>(),
        instructions);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = codeAttributeRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\"},{\"offset\":2,"
            + "\"instruction\":\"{\"}],\"parameters\":[],\"blockEvaluations\":[]}",
        builder.toString());
    assertEquals(
        "foo{\"clazz\":\"Clazz\",\"method\":\"Method\",\"instructions\":[{\"offset\":2,\"instruction\":\"{\"},{\"offset\":2,"
            + "\"instruction\":\"{\"}],\"parameters\":[],\"blockEvaluations\":[]}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }
}

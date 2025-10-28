package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.Variables;

public class JsonPrinterDiffblueTest {
  /**
   * Method under test: {@link JsonPrinter#getJson()}
   */
  @Test
  public void testGetJson() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Method under test: {@link JsonPrinter#JsonPrinter(Clazz, Method)}
   */
  @Test
  public void testNewJsonPrinter3() {
    // Arrange
    LibraryClass clazzFilter = new LibraryClass();

    // Act and Assert
    assertEquals("{\"codeAttributes\":[]}",
        (new JsonPrinter(clazzFilter, new LibraryMethod(1, "Name", "Descriptor"))).getJson());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}
   */
  @Test
  public void testSerializeJsonSerializable() {
    // Arrange
    ErrorRecord errorRecord = new ErrorRecord(1, "Not all who wander are lost");

    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonPrinter.serializeJsonSerializable("Key", errorRecord, builder);

    // Assert
    assertEquals("foo\"Key\":{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}",
        builder.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}
   */
  @Test
  public void testSerializeJsonSerializable2() {
    // Arrange
    ExceptionHandlerRecord exceptionHandlerRecord = new ExceptionHandlerRecord(1, 1, 1, "\"");

    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonPrinter.serializeJsonSerializable("Key", exceptionHandlerRecord, builder);

    // Assert
    assertEquals(
        "foo\"Key\":{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"}",
        builder.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}
   */
  @Test
  public void testSerializeJsonSerializable3() {
    // Arrange
    ErrorRecord errorRecord = new ErrorRecord(1, "Not all who wander are lost");

    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonPrinter.serializeJsonSerializable("Key", errorRecord, builder);

    // Assert
    assertEquals("foo\"Key\":{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}",
        builder.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}
   */
  @Test
  public void testSerializeJsonSerializable4() {
    // Arrange
    ExceptionHandlerRecord exceptionHandlerRecord = new ExceptionHandlerRecord(1, 1, 1, "\"");

    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonPrinter.serializeJsonSerializable("Key", exceptionHandlerRecord, builder);

    // Assert
    assertEquals(
        "foo\"Key\":{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"}",
        builder.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson2() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,"
            + "\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are"
            + " lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,"
            + "\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are"
            + " lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson3() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        builder.toString());
    assertEquals("foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson4() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,"
            + "\"message\":\"Not all who wander are lost\"}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,"
            + "\"message\":\"Not all who wander are lost\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson5() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    formattableList.add(new BranchTargetRecord(variables, new ArrayList<>(), 1));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]", builder.toString());
    assertEquals("foo\"Key\":[{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson6() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> parameters = new ArrayList<>();
    formattableList.add(new CodeAttributeRecord("\"", "\"", parameters, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"clazz\":\"\"\",\"method\":\"\"\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"clazz\":\"\"\",\"method\":\"\"\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson7() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ExceptionHandlerRecord(1, 1, 1, "\""));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson8() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "\"");

    formattableList.add(
        new InstructionBlockEvaluationRecord(startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{"
            + "\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"},\"startVariables\":[],"
            + "\"startStack\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{"
            + "\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"},\"startVariables\":[],"
            + "\"startStack\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson9() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> variablesBefore = new ArrayList<>();
    formattableList.add(new InstructionEvaluationRecord(true, true, 3, "\"", 1, variablesBefore, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"\"\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"\"\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson10() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    ArrayList<String> parameters = new ArrayList<>();
    formattableList.add(new CodeAttributeRecord("\"", "\"", parameters, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"clazz\":\"\"\",\"method\":\"\"\","
            + "\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"clazz\":\"\"\",\"method\":\"\"\","
            + "\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson11() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    ArrayList<String> variablesBefore = new ArrayList<>();
    formattableList.add(new InstructionEvaluationRecord(true, true, 3, "\"", 1, variablesBefore, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"skipEvaluation\":true,"
            + "\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"\"\",\"instructionOffset\":1,\"variablesBefore"
            + "\":[],\"stackBefore\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"skipEvaluation\":true,"
            + "\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"\"\",\"instructionOffset\":1,\"variablesBefore"
            + "\":[],\"stackBefore\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson12() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson13() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,"
            + "\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are"
            + " lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,"
            + "\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are"
            + " lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not"
            + " all who wander are lost\"},{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{"
            + "\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson14() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        builder.toString());
    assertEquals("foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson15() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,"
            + "\"message\":\"Not all who wander are lost\"}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"instructionOffset\":1,"
            + "\"message\":\"Not all who wander are lost\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson16() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    formattableList.add(new BranchTargetRecord(variables, new ArrayList<>(), 1));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]", builder.toString());
    assertEquals("foo\"Key\":[{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson17() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> parameters = new ArrayList<>();
    formattableList.add(new CodeAttributeRecord("\"", "\"", parameters, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"clazz\":\"\"\",\"method\":\"\"\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"clazz\":\"\"\",\"method\":\"\"\",\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson18() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ExceptionHandlerRecord(1, 1, 1, "\""));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson19() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "\"");

    formattableList.add(
        new InstructionBlockEvaluationRecord(startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{"
            + "\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"},\"startVariables\":[],"
            + "\"startStack\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"startOffset\":1,\"evaluations\":[],\"branchEvaluationStack\":[],\"exceptionHandlerInfo\":{"
            + "\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"\"\"},\"startVariables\":[],"
            + "\"startStack\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson20() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> variablesBefore = new ArrayList<>();
    formattableList.add(new InstructionEvaluationRecord(true, true, 3, "\"", 1, variablesBefore, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"\"\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"skipEvaluation\":true,\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"\"\","
            + "\"instructionOffset\":1,\"variablesBefore\":[],\"stackBefore\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson21() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    ArrayList<String> parameters = new ArrayList<>();
    formattableList.add(new CodeAttributeRecord("\"", "\"", parameters, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"clazz\":\"\"\",\"method\":\"\"\","
            + "\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"clazz\":\"\"\",\"method\":\"\"\","
            + "\"instructions\":[],\"parameters\":[],\"blockEvaluations\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  public void testListToJson22() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    ArrayList<String> variablesBefore = new ArrayList<>();
    formattableList.add(new InstructionEvaluationRecord(true, true, 3, "\"", 1, variablesBefore, new ArrayList<>()));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"skipEvaluation\":true,"
            + "\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"\"\",\"instructionOffset\":1,\"variablesBefore"
            + "\":[],\"stackBefore\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"},{\"skipEvaluation\":true,"
            + "\"isGeneralization\":true,\"evaluationCount\":3,\"instruction\":\"\"\",\"instructionOffset\":1,\"variablesBefore"
            + "\":[],\"stackBefore\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testStringListToJson() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult = JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualStringListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testStringListToJson2() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult = JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\"]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\"]",
        actualStringListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testStringListToJson3() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("\"");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult = JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[\"\"\"]", builder.toString());
    assertEquals("foo\"Key\":[\"\"\"]", actualStringListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testStringListToJson4() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("\":");
    formattableList.add("\"");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult = JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[\"\":\",\"\"\"]", builder.toString());
    assertEquals("foo\"Key\":[\"\":\",\"\"\"]", actualStringListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testStringListToJson5() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult = JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualStringListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testStringListToJson6() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    formattableList.add("Formattable List");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult = JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\"]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable"
            + " List\",\"Formattable List\",\"Formattable List\",\"Formattable List\",\"Formattable List\"]",
        actualStringListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testStringListToJson7() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("\"");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult = JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[\"\"\"]", builder.toString());
    assertEquals("foo\"Key\":[\"\"\"]", actualStringListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testStringListToJson8() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("\":");
    formattableList.add("\"");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult = JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[\"\":\",\"\"\"]", builder.toString());
    assertEquals("foo\"Key\":[\"\":\",\"\"\"]", actualStringListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testIntListToJson() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult = JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualIntListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testIntListToJson2() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    formattableList.add(2);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult = JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[2]", builder.toString());
    assertEquals("foo\"Key\":[2]", actualIntListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testIntListToJson3() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    formattableList.add(1);
    formattableList.add(2);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult = JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[1,2]", builder.toString());
    assertEquals("foo\"Key\":[1,2]", actualIntListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testIntListToJson4() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult = JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualIntListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testIntListToJson5() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    formattableList.add(2);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult = JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[2]", builder.toString());
    assertEquals("foo\"Key\":[2]", actualIntListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  public void testIntListToJson6() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    formattableList.add(1);
    formattableList.add(2);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult = JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[1,2]", builder.toString());
    assertEquals("foo\"Key\":[1,2]", actualIntListToJsonResult.toString());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}
   */
  @Test
  public void testStartCodeAttribute() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    jsonPrinter.startCodeAttribute(clazz, method, codeAttribute, new Variables(3));

    // Assert
    assertEquals(
        "{\"codeAttributes\":[{\"clazz\":\"null\",\"method\":\"NameDescriptor\",\"instructions\":[],\"parameters\":[\"empty\""
            + ",\"empty\",\"empty\"],\"blockEvaluations\":[]}]}",
        jsonPrinter.getJson());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}
   */
  @Test
  public void testStartCodeAttribute2() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    jsonPrinter.startCodeAttribute(clazz, method, codeAttribute, new Variables(3));

    // Assert
    assertEquals(
        "{\"codeAttributes\":[{\"clazz\":\"null\",\"method\":\"NameDescriptor\",\"instructions\":[{\"offset\":0,\"instruction"
            + "\":\"lstore_2 v2\"},{\"offset\":1,\"instruction\":\"iconst_0\"},{\"offset\":2,\"instruction\":\"lstore_2 v2\"}],"
            + "\"parameters\":[\"empty\",\"empty\",\"empty\"],\"blockEvaluations\":[]}]}",
        jsonPrinter.getJson());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}
   */
  @Test
  public void testStartCodeAttribute3() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    jsonPrinter.startCodeAttribute(clazz, method, codeAttribute, new Variables(3));

    // Assert
    assertEquals(
        "{\"codeAttributes\":[{\"clazz\":\"null\",\"method\":\"NameDescriptor\",\"instructions\":[],\"parameters\":[\"empty\""
            + ",\"empty\",\"empty\"],\"blockEvaluations\":[]}]}",
        jsonPrinter.getJson());
  }

  /**
   * Method under test:
   * {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}
   */
  @Test
  public void testStartCodeAttribute4() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    jsonPrinter.startCodeAttribute(clazz, method, codeAttribute, new Variables(3));

    // Assert
    assertEquals(
        "{\"codeAttributes\":[{\"clazz\":\"null\",\"method\":\"NameDescriptor\",\"instructions\":[{\"offset\":0,\"instruction"
            + "\":\"lstore_2 v2\"},{\"offset\":1,\"instruction\":\"iconst_0\"},{\"offset\":2,\"instruction\":\"lstore_2 v2\"}],"
            + "\"parameters\":[\"empty\",\"empty\",\"empty\"],\"blockEvaluations\":[]}]}",
        jsonPrinter.getJson());
  }

  /**
   * Method under test: {@link JsonPrinter#JsonPrinter()}
   */
  @Test
  public void testNewJsonPrinter() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter(new LibraryClass())).getJson());
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter(new LibraryClass())).getJson());
  }

  /**
   * Method under test: {@link JsonPrinter#JsonPrinter(Clazz, Method)}
   */
  @Test
  public void testNewJsonPrinter2() {
    // Arrange
    LibraryClass clazzFilter = new LibraryClass();

    // Act and Assert
    assertEquals("{\"codeAttributes\":[]}",
        (new JsonPrinter(clazzFilter, new LibraryMethod(1, "Name", "Descriptor"))).getJson());
  }
}

package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.Variables;

public class JsonPrinterDiffblueTest {
  /**
   * Test {@link JsonPrinter#JsonPrinter()}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonPrinter.<init>()"})
  public void testNewJsonPrinter() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter(Clazz)}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonPrinter.<init>(Clazz)"})
  public void testNewJsonPrinter2() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter(new LibraryClass())).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter(Clazz, Method)}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter(Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonPrinter.<init>(Clazz, Method)"})
  public void testNewJsonPrinter3() {
    // Arrange
    LibraryClass clazzFilter = new LibraryClass();

    // Act and Assert
    assertEquals(
        "{\"codeAttributes\":[]}",
        (new JsonPrinter(clazzFilter, new LibraryMethod(1, "Name", "Descriptor"))).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter()}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonPrinter.<init>()"})
  public void testNewJsonPrinter4() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter(Clazz)}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonPrinter.<init>(Clazz)"})
  public void testNewJsonPrinter5() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter(new LibraryClass())).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter(Clazz, Method)}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter(Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonPrinter.<init>(Clazz, Method)"})
  public void testNewJsonPrinter6() {
    // Arrange
    LibraryClass clazzFilter = new LibraryClass();

    // Act and Assert
    assertEquals(
        "{\"codeAttributes\":[]}",
        (new JsonPrinter(clazzFilter, new LibraryMethod(1, "Name", "Descriptor"))).getJson());
  }

  /**
   * Test {@link JsonPrinter#getJson()}.
   *
   * <p>Method under test: {@link JsonPrinter#getJson()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonPrinter.getJson()"})
  public void testGetJson() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Test {@link JsonPrinter#getJson()}.
   *
   * <p>Method under test: {@link JsonPrinter#getJson()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonPrinter.getJson()"})
  public void testGetJson2() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Test {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable,
   * StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.serializeJsonSerializable(String, JsonSerializable, StringBuilder)"
  })
  public void testSerializeJsonSerializable() {
    // Arrange
    ErrorRecord errorRecord = new ErrorRecord(1, "Not all who wander are lost");

    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonPrinter.serializeJsonSerializable("Key", errorRecord, builder);

    // Assert
    assertEquals(
        "foo\"Key\":{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}",
        builder.toString());
  }

  /**
   * Test {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable,
   * StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.serializeJsonSerializable(String, JsonSerializable, StringBuilder)"
  })
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
   * Test {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable,
   * StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.serializeJsonSerializable(String, JsonSerializable, StringBuilder)"
  })
  public void testSerializeJsonSerializable3() {
    // Arrange
    ErrorRecord errorRecord = new ErrorRecord(1, "Not all who wander are lost");

    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonPrinter.serializeJsonSerializable("Key", errorRecord, builder);

    // Assert
    assertEquals(
        "foo\"Key\":{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}",
        builder.toString());
  }

  /**
   * Test {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable,
   * StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.serializeJsonSerializable(String, JsonSerializable, StringBuilder)"
  })
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson2() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    formattableList.add(new BranchTargetRecord(variables, new ArrayList<>(), 1));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson3() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson4() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson5() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "\"");

    formattableList.add(
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>()));
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson6() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> variablesBefore = new ArrayList<>();
    formattableList.add(
        new InstructionEvaluationRecord(
            true, true, 3, "\"", 1, variablesBefore, new ArrayList<>()));
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson7() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson8() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    ArrayList<String> variablesBefore = new ArrayList<>();
    formattableList.add(
        new InstructionEvaluationRecord(
            true, true, 3, "\"", 1, variablesBefore, new ArrayList<>()));
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson9() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}]",
        actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson10() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> variables = new ArrayList<>();
    formattableList.add(new BranchTargetRecord(variables, new ArrayList<>(), 1));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    assertEquals(
        "foo\"Key\":[{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]",
        builder.toString());
    assertEquals(
        "foo\"Key\":[{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}]",
        actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson11() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson12() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson13() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> startVariables = new ArrayList<>();
    ArrayList<String> startStack = new ArrayList<>();
    ExceptionHandlerRecord exceptionHandlerInfo = new ExceptionHandlerRecord(1, 1, 1, "\"");

    formattableList.add(
        new InstructionBlockEvaluationRecord(
            startVariables, startStack, 1, exceptionHandlerInfo, new ArrayList<>()));
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson14() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    ArrayList<String> variablesBefore = new ArrayList<>();
    formattableList.add(
        new InstructionEvaluationRecord(
            true, true, 3, "\"", 1, variablesBefore, new ArrayList<>()));
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson15() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson16() {
    // Arrange
    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(new ErrorRecord(1, "Not all who wander are lost"));
    ArrayList<String> variablesBefore = new ArrayList<>();
    formattableList.add(
        new InstructionEvaluationRecord(
            true, true, 3, "\"", 1, variablesBefore, new ArrayList<>()));
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson_thenStringBuilderWithFooToStringIsAString() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson_thenStringBuilderWithFooToStringIsAString2() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson_thenStringBuilderWithFooToStringIsAString3() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson_thenStringBuilderWithFooToStringIsAString4() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey() {
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
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.listToJson(String, List, StringBuilder)"})
  public void testListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey2() {
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
   * Test {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@code "}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":["""]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.stringListToJson(String, List, StringBuilder)"})
  public void testStringListToJson_givenQuotationMark_thenStringBuilderWithFooToStringIsFooKey() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("\"");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult =
        JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[\"\"\"]", builder.toString());
    assertEquals("foo\"Key\":[\"\"\"]", actualStringListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Given {@code "}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":["""]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.stringListToJson(String, List, StringBuilder)"})
  public void testStringListToJson_givenQuotationMark_thenStringBuilderWithFooToStringIsFooKey2() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("\"");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult =
        JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[\"\"\"]", builder.toString());
    assertEquals("foo\"Key\":[\"\"\"]", actualStringListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.stringListToJson(String, List, StringBuilder)"})
  public void testStringListToJson_thenStringBuilderWithFooToStringIsAString() {
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
    StringBuilder actualStringListToJsonResult =
        JsonPrinter.stringListToJson("Key", formattableList, builder);

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
   * Test {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.stringListToJson(String, List, StringBuilder)"})
  public void testStringListToJson_thenStringBuilderWithFooToStringIsAString2() {
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
    StringBuilder actualStringListToJsonResult =
        JsonPrinter.stringListToJson("Key", formattableList, builder);

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
   * Test {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":["":","""]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.stringListToJson(String, List, StringBuilder)"})
  public void testStringListToJson_thenStringBuilderWithFooToStringIsFooKey() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("\":");
    formattableList.add("\"");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult =
        JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[\"\":\",\"\"\"]", builder.toString());
    assertEquals("foo\"Key\":[\"\":\",\"\"\"]", actualStringListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":["":","""]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.stringListToJson(String, List, StringBuilder)"})
  public void testStringListToJson_thenStringBuilderWithFooToStringIsFooKey2() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    formattableList.add("\":");
    formattableList.add("\"");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult =
        JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[\"\":\",\"\"\"]", builder.toString());
    assertEquals("foo\"Key\":[\"\":\",\"\"\"]", actualStringListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.stringListToJson(String, List, StringBuilder)"})
  public void testStringListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult =
        JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualStringListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#stringListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.stringListToJson(String, List, StringBuilder)"})
  public void testStringListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey2() {
    // Arrange
    ArrayList<String> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualStringListToJsonResult =
        JsonPrinter.stringListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualStringListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#intListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[1,2]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.intListToJson(String, List, StringBuilder)"})
  public void testIntListToJson_givenOne_thenStringBuilderWithFooToStringIsFooKey12() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    formattableList.add(1);
    formattableList.add(2);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult =
        JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[1,2]", builder.toString());
    assertEquals("foo\"Key\":[1,2]", actualIntListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#intListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[1,2]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.intListToJson(String, List, StringBuilder)"})
  public void testIntListToJson_givenOne_thenStringBuilderWithFooToStringIsFooKey122() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    formattableList.add(1);
    formattableList.add(2);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult =
        JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[1,2]", builder.toString());
    assertEquals("foo\"Key\":[1,2]", actualIntListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#intListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[2]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.intListToJson(String, List, StringBuilder)"})
  public void testIntListToJson_givenTwo_thenStringBuilderWithFooToStringIsFooKey2() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    formattableList.add(2);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult =
        JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[2]", builder.toString());
    assertEquals("foo\"Key\":[2]", actualIntListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#intListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[2]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.intListToJson(String, List, StringBuilder)"})
  public void testIntListToJson_givenTwo_thenStringBuilderWithFooToStringIsFooKey22() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    formattableList.add(2);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult =
        JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[2]", builder.toString());
    assertEquals("foo\"Key\":[2]", actualIntListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#intListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.intListToJson(String, List, StringBuilder)"})
  public void testIntListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult =
        JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualIntListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#intListToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#intListToJson(String, List, StringBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder JsonPrinter.intListToJson(String, List, StringBuilder)"})
  public void testIntListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey2() {
    // Arrange
    ArrayList<Integer> formattableList = new ArrayList<>();
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualIntListToJsonResult =
        JsonPrinter.intListToJson("Key", formattableList, builder);

    // Assert
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualIntListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}.
   *
   * <p>Method under test: {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute,
   * Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.startCodeAttribute(Clazz, Method, CodeAttribute, Variables)"
  })
  public void testStartCodeAttribute() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter(new LibraryClass());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    jsonPrinter.startCodeAttribute(clazz, method, codeAttribute, new Variables(3));

    // Assert that nothing has changed
    assertEquals("{\"codeAttributes\":[]}", jsonPrinter.getJson());
  }

  /**
   * Test {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}.
   *
   * <p>Method under test: {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute,
   * Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.startCodeAttribute(Clazz, Method, CodeAttribute, Variables)"
  })
  public void testStartCodeAttribute2() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

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
   * Test {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}.
   *
   * <p>Method under test: {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute,
   * Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.startCodeAttribute(Clazz, Method, CodeAttribute, Variables)"
  })
  public void testStartCodeAttribute3() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter(new LibraryClass());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    jsonPrinter.startCodeAttribute(clazz, method, codeAttribute, new Variables(3));

    // Assert that nothing has changed
    assertEquals("{\"codeAttributes\":[]}", jsonPrinter.getJson());
  }

  /**
   * Test {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}.
   *
   * <p>Method under test: {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute,
   * Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.startCodeAttribute(Clazz, Method, CodeAttribute, Variables)"
  })
  public void testStartCodeAttribute4() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

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
   * Test {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}.
   *
   * <ul>
   *   <li>Then {@link JsonPrinter#JsonPrinter()} Json is a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute,
   * Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.startCodeAttribute(Clazz, Method, CodeAttribute, Variables)"
  })
  public void testStartCodeAttribute_thenJsonPrinterJsonIsAString() {
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
   * Test {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}.
   *
   * <ul>
   *   <li>Then {@link JsonPrinter#JsonPrinter()} Json is a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#startCodeAttribute(Clazz, Method, CodeAttribute,
   * Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JsonPrinter.startCodeAttribute(Clazz, Method, CodeAttribute, Variables)"
  })
  public void testStartCodeAttribute_thenJsonPrinterJsonIsAString2() {
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
}

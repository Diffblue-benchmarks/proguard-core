package proguard.evaluation.util.jsonprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.Variables;

class JsonPrinterDiffblueTest {
  /**
   * Test {@link JsonPrinter#JsonPrinter()}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter()}
   */
  @Test
  @DisplayName("Test new JsonPrinter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.util.jsonprinter.JsonPrinter.<init>()"})
  void testNewJsonPrinter() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter(Clazz)}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter(Clazz)}
   */
  @Test
  @DisplayName("Test new JsonPrinter(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.<init>(proguard.classfile.Clazz)"
  })
  void testNewJsonPrinter2() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter(new LibraryClass())).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter(Clazz, Method)}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter(Clazz, Method)}
   */
  @Test
  @DisplayName("Test new JsonPrinter(Clazz, Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.<init>(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testNewJsonPrinter3() {
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
  @DisplayName("Test new JsonPrinter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.util.jsonprinter.JsonPrinter.<init>()"})
  void testNewJsonPrinter4() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter(Clazz)}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter(Clazz)}
   */
  @Test
  @DisplayName("Test new JsonPrinter(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.<init>(proguard.classfile.Clazz)"
  })
  void testNewJsonPrinter5() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter(new LibraryClass())).getJson());
  }

  /**
   * Test {@link JsonPrinter#JsonPrinter(Clazz, Method)}.
   *
   * <p>Method under test: {@link JsonPrinter#JsonPrinter(Clazz, Method)}
   */
  @Test
  @DisplayName("Test new JsonPrinter(Clazz, Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.<init>(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testNewJsonPrinter6() {
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
  @DisplayName("Test getJson()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.util.jsonprinter.JsonPrinter.getJson()"})
  void testGetJson() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Test {@link JsonPrinter#getJson()}.
   *
   * <p>Method under test: {@link JsonPrinter#getJson()}
   */
  @Test
  @DisplayName("Test getJson()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.util.jsonprinter.JsonPrinter.getJson()"})
  void testGetJson2() {
    // Arrange, Act and Assert
    assertEquals("{\"codeAttributes\":[]}", (new JsonPrinter()).getJson());
  }

  /**
   * Test {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable,
   * StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test serializeJsonSerializable(String, JsonSerializable, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.serializeJsonSerializable(java.lang.String, proguard.evaluation.util.jsonprinter.JsonSerializable, java.lang.StringBuilder)"
  })
  void testSerializeJsonSerializable_thenStringBuilderWithFooToStringIsFooKey() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonPrinter.serializeJsonSerializable("Key", jsonSerializable, builder);

    // Assert
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    assertEquals("foo\"Key\":", builder.toString());
  }

  /**
   * Test {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable,
   * StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test serializeJsonSerializable(String, JsonSerializable, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.serializeJsonSerializable(java.lang.String, proguard.evaluation.util.jsonprinter.JsonSerializable, java.lang.StringBuilder)"
  })
  void testSerializeJsonSerializable_thenStringBuilderWithFooToStringIsFooKey2() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    StringBuilder builder = new StringBuilder("foo");

    // Act
    JsonPrinter.serializeJsonSerializable("Key", jsonSerializable, builder);

    // Assert
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    assertEquals("foo\"Key\":", builder.toString());
  }

  /**
   * Test {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable,
   * StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test serializeJsonSerializable(String, JsonSerializable, StringBuilder); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.serializeJsonSerializable(java.lang.String, proguard.evaluation.util.jsonprinter.JsonSerializable, java.lang.StringBuilder)"
  })
  void testSerializeJsonSerializable_thenThrowRuntimeException() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenThrow(new RuntimeException("\""));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonPrinter.serializeJsonSerializable(
                "Key", jsonSerializable, new StringBuilder("foo")));
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
  }

  /**
   * Test {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable, StringBuilder)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#serializeJsonSerializable(String, JsonSerializable,
   * StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test serializeJsonSerializable(String, JsonSerializable, StringBuilder); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.serializeJsonSerializable(java.lang.String, proguard.evaluation.util.jsonprinter.JsonSerializable, java.lang.StringBuilder)"
  })
  void testSerializeJsonSerializable_thenThrowRuntimeException2() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenThrow(new RuntimeException("\""));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonPrinter.serializeJsonSerializable(
                "Key", jsonSerializable, new StringBuilder("foo")));
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[,,,,,,,,,,,,,,,,,,]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test listToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[,,,,,,,,,,,,,,,,,,]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenStringBuilderWithFooToStringIsFooKey() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable2 = mock(JsonSerializable.class);
    when(jsonSerializable2.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable3 = mock(JsonSerializable.class);
    when(jsonSerializable3.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable4 = mock(JsonSerializable.class);
    when(jsonSerializable4.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable5 = mock(JsonSerializable.class);
    when(jsonSerializable5.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable6 = mock(JsonSerializable.class);
    when(jsonSerializable6.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable7 = mock(JsonSerializable.class);
    when(jsonSerializable7.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable8 = mock(JsonSerializable.class);
    when(jsonSerializable8.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable9 = mock(JsonSerializable.class);
    when(jsonSerializable9.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable10 = mock(JsonSerializable.class);
    when(jsonSerializable10.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable11 = mock(JsonSerializable.class);
    when(jsonSerializable11.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable12 = mock(JsonSerializable.class);
    when(jsonSerializable12.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable13 = mock(JsonSerializable.class);
    when(jsonSerializable13.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable14 = mock(JsonSerializable.class);
    when(jsonSerializable14.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable15 = mock(JsonSerializable.class);
    when(jsonSerializable15.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable16 = mock(JsonSerializable.class);
    when(jsonSerializable16.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable17 = mock(JsonSerializable.class);
    when(jsonSerializable17.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable18 = mock(JsonSerializable.class);
    when(jsonSerializable18.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable19 = mock(JsonSerializable.class);
    when(jsonSerializable19.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable);
    formattableList.add(jsonSerializable2);
    formattableList.add(jsonSerializable3);
    formattableList.add(jsonSerializable4);
    formattableList.add(jsonSerializable5);
    formattableList.add(jsonSerializable6);
    formattableList.add(jsonSerializable7);
    formattableList.add(jsonSerializable8);
    formattableList.add(jsonSerializable9);
    formattableList.add(jsonSerializable10);
    formattableList.add(jsonSerializable11);
    formattableList.add(jsonSerializable12);
    formattableList.add(jsonSerializable13);
    formattableList.add(jsonSerializable14);
    formattableList.add(jsonSerializable15);
    formattableList.add(jsonSerializable16);
    formattableList.add(jsonSerializable17);
    formattableList.add(jsonSerializable18);
    formattableList.add(jsonSerializable19);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    verify(jsonSerializable2).toJson(isA(StringBuilder.class));
    verify(jsonSerializable3).toJson(isA(StringBuilder.class));
    verify(jsonSerializable4).toJson(isA(StringBuilder.class));
    verify(jsonSerializable5).toJson(isA(StringBuilder.class));
    verify(jsonSerializable6).toJson(isA(StringBuilder.class));
    verify(jsonSerializable7).toJson(isA(StringBuilder.class));
    verify(jsonSerializable8).toJson(isA(StringBuilder.class));
    verify(jsonSerializable9).toJson(isA(StringBuilder.class));
    verify(jsonSerializable10).toJson(isA(StringBuilder.class));
    verify(jsonSerializable11).toJson(isA(StringBuilder.class));
    verify(jsonSerializable12).toJson(isA(StringBuilder.class));
    verify(jsonSerializable13).toJson(isA(StringBuilder.class));
    verify(jsonSerializable14).toJson(isA(StringBuilder.class));
    verify(jsonSerializable15).toJson(isA(StringBuilder.class));
    verify(jsonSerializable16).toJson(isA(StringBuilder.class));
    verify(jsonSerializable17).toJson(isA(StringBuilder.class));
    verify(jsonSerializable18).toJson(isA(StringBuilder.class));
    verify(jsonSerializable19).toJson(isA(StringBuilder.class));
    assertEquals("foo\"Key\":[,,,,,,,,,,,,,,,,,,]", builder.toString());
    assertEquals("foo\"Key\":[,,,,,,,,,,,,,,,,,,]", actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test listToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenStringBuilderWithFooToStringIsFooKey2() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[,]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test listToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[,]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenStringBuilderWithFooToStringIsFooKey3() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable2 = mock(JsonSerializable.class);
    when(jsonSerializable2.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable2);
    formattableList.add(jsonSerializable);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    verify(jsonSerializable2).toJson(isA(StringBuilder.class));
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    assertEquals("foo\"Key\":[,]", builder.toString());
    assertEquals("foo\"Key\":[,]", actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[,,,,,,,,,,,,,,,,,,]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test listToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[,,,,,,,,,,,,,,,,,,]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenStringBuilderWithFooToStringIsFooKey4() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable2 = mock(JsonSerializable.class);
    when(jsonSerializable2.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable3 = mock(JsonSerializable.class);
    when(jsonSerializable3.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable4 = mock(JsonSerializable.class);
    when(jsonSerializable4.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable5 = mock(JsonSerializable.class);
    when(jsonSerializable5.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable6 = mock(JsonSerializable.class);
    when(jsonSerializable6.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable7 = mock(JsonSerializable.class);
    when(jsonSerializable7.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable8 = mock(JsonSerializable.class);
    when(jsonSerializable8.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable9 = mock(JsonSerializable.class);
    when(jsonSerializable9.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable10 = mock(JsonSerializable.class);
    when(jsonSerializable10.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable11 = mock(JsonSerializable.class);
    when(jsonSerializable11.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable12 = mock(JsonSerializable.class);
    when(jsonSerializable12.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable13 = mock(JsonSerializable.class);
    when(jsonSerializable13.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable14 = mock(JsonSerializable.class);
    when(jsonSerializable14.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable15 = mock(JsonSerializable.class);
    when(jsonSerializable15.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable16 = mock(JsonSerializable.class);
    when(jsonSerializable16.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable17 = mock(JsonSerializable.class);
    when(jsonSerializable17.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable18 = mock(JsonSerializable.class);
    when(jsonSerializable18.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable19 = mock(JsonSerializable.class);
    when(jsonSerializable19.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable);
    formattableList.add(jsonSerializable2);
    formattableList.add(jsonSerializable3);
    formattableList.add(jsonSerializable4);
    formattableList.add(jsonSerializable5);
    formattableList.add(jsonSerializable6);
    formattableList.add(jsonSerializable7);
    formattableList.add(jsonSerializable8);
    formattableList.add(jsonSerializable9);
    formattableList.add(jsonSerializable10);
    formattableList.add(jsonSerializable11);
    formattableList.add(jsonSerializable12);
    formattableList.add(jsonSerializable13);
    formattableList.add(jsonSerializable14);
    formattableList.add(jsonSerializable15);
    formattableList.add(jsonSerializable16);
    formattableList.add(jsonSerializable17);
    formattableList.add(jsonSerializable18);
    formattableList.add(jsonSerializable19);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    verify(jsonSerializable2).toJson(isA(StringBuilder.class));
    verify(jsonSerializable3).toJson(isA(StringBuilder.class));
    verify(jsonSerializable4).toJson(isA(StringBuilder.class));
    verify(jsonSerializable5).toJson(isA(StringBuilder.class));
    verify(jsonSerializable6).toJson(isA(StringBuilder.class));
    verify(jsonSerializable7).toJson(isA(StringBuilder.class));
    verify(jsonSerializable8).toJson(isA(StringBuilder.class));
    verify(jsonSerializable9).toJson(isA(StringBuilder.class));
    verify(jsonSerializable10).toJson(isA(StringBuilder.class));
    verify(jsonSerializable11).toJson(isA(StringBuilder.class));
    verify(jsonSerializable12).toJson(isA(StringBuilder.class));
    verify(jsonSerializable13).toJson(isA(StringBuilder.class));
    verify(jsonSerializable14).toJson(isA(StringBuilder.class));
    verify(jsonSerializable15).toJson(isA(StringBuilder.class));
    verify(jsonSerializable16).toJson(isA(StringBuilder.class));
    verify(jsonSerializable17).toJson(isA(StringBuilder.class));
    verify(jsonSerializable18).toJson(isA(StringBuilder.class));
    verify(jsonSerializable19).toJson(isA(StringBuilder.class));
    assertEquals("foo\"Key\":[,,,,,,,,,,,,,,,,,,]", builder.toString());
    assertEquals("foo\"Key\":[,,,,,,,,,,,,,,,,,,]", actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test listToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenStringBuilderWithFooToStringIsFooKey5() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    assertEquals("foo\"Key\":[]", builder.toString());
    assertEquals("foo\"Key\":[]", actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       foo"Key":[,]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test listToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[,]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenStringBuilderWithFooToStringIsFooKey6() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable2 = mock(JsonSerializable.class);
    when(jsonSerializable2.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable2);
    formattableList.add(jsonSerializable);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualListToJsonResult = JsonPrinter.listToJson("Key", formattableList, builder);

    // Assert
    verify(jsonSerializable2).toJson(isA(StringBuilder.class));
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    assertEquals("foo\"Key\":[,]", builder.toString());
    assertEquals("foo\"Key\":[,]", actualListToJsonResult.toString());
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName("Test listToJson(String, List, StringBuilder); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenThrowRuntimeException() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable2 = mock(JsonSerializable.class);
    when(jsonSerializable2.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable3 = mock(JsonSerializable.class);
    when(jsonSerializable3.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable4 = mock(JsonSerializable.class);
    when(jsonSerializable4.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable5 = mock(JsonSerializable.class);
    when(jsonSerializable5.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable6 = mock(JsonSerializable.class);
    when(jsonSerializable6.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable7 = mock(JsonSerializable.class);
    when(jsonSerializable7.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable8 = mock(JsonSerializable.class);
    when(jsonSerializable8.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable9 = mock(JsonSerializable.class);
    when(jsonSerializable9.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable10 = mock(JsonSerializable.class);
    when(jsonSerializable10.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable11 = mock(JsonSerializable.class);
    when(jsonSerializable11.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable12 = mock(JsonSerializable.class);
    when(jsonSerializable12.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable13 = mock(JsonSerializable.class);
    when(jsonSerializable13.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable14 = mock(JsonSerializable.class);
    when(jsonSerializable14.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable15 = mock(JsonSerializable.class);
    when(jsonSerializable15.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable16 = mock(JsonSerializable.class);
    when(jsonSerializable16.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable17 = mock(JsonSerializable.class);
    when(jsonSerializable17.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable18 = mock(JsonSerializable.class);
    when(jsonSerializable18.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable19 = mock(JsonSerializable.class);
    when(jsonSerializable19.toJson(Mockito.<StringBuilder>any()))
        .thenThrow(new RuntimeException("\""));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable);
    formattableList.add(jsonSerializable2);
    formattableList.add(jsonSerializable3);
    formattableList.add(jsonSerializable4);
    formattableList.add(jsonSerializable5);
    formattableList.add(jsonSerializable6);
    formattableList.add(jsonSerializable7);
    formattableList.add(jsonSerializable8);
    formattableList.add(jsonSerializable9);
    formattableList.add(jsonSerializable10);
    formattableList.add(jsonSerializable11);
    formattableList.add(jsonSerializable12);
    formattableList.add(jsonSerializable13);
    formattableList.add(jsonSerializable14);
    formattableList.add(jsonSerializable15);
    formattableList.add(jsonSerializable16);
    formattableList.add(jsonSerializable17);
    formattableList.add(jsonSerializable18);
    formattableList.add(jsonSerializable19);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonPrinter.listToJson("Key", formattableList, new StringBuilder("foo")));
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    verify(jsonSerializable2).toJson(isA(StringBuilder.class));
    verify(jsonSerializable3).toJson(isA(StringBuilder.class));
    verify(jsonSerializable4).toJson(isA(StringBuilder.class));
    verify(jsonSerializable5).toJson(isA(StringBuilder.class));
    verify(jsonSerializable6).toJson(isA(StringBuilder.class));
    verify(jsonSerializable7).toJson(isA(StringBuilder.class));
    verify(jsonSerializable8).toJson(isA(StringBuilder.class));
    verify(jsonSerializable9).toJson(isA(StringBuilder.class));
    verify(jsonSerializable10).toJson(isA(StringBuilder.class));
    verify(jsonSerializable11).toJson(isA(StringBuilder.class));
    verify(jsonSerializable12).toJson(isA(StringBuilder.class));
    verify(jsonSerializable13).toJson(isA(StringBuilder.class));
    verify(jsonSerializable14).toJson(isA(StringBuilder.class));
    verify(jsonSerializable15).toJson(isA(StringBuilder.class));
    verify(jsonSerializable16).toJson(isA(StringBuilder.class));
    verify(jsonSerializable17).toJson(isA(StringBuilder.class));
    verify(jsonSerializable18).toJson(isA(StringBuilder.class));
    verify(jsonSerializable19).toJson(isA(StringBuilder.class));
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName("Test listToJson(String, List, StringBuilder); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenThrowRuntimeException2() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable2 = mock(JsonSerializable.class);
    when(jsonSerializable2.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable3 = mock(JsonSerializable.class);
    when(jsonSerializable3.toJson(Mockito.<StringBuilder>any()))
        .thenThrow(new RuntimeException("\""));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable3);
    formattableList.add(jsonSerializable2);
    formattableList.add(jsonSerializable);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonPrinter.listToJson("Key", formattableList, new StringBuilder("foo")));
    verify(jsonSerializable3).toJson(isA(StringBuilder.class));
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName("Test listToJson(String, List, StringBuilder); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenThrowRuntimeException3() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable2 = mock(JsonSerializable.class);
    when(jsonSerializable2.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable3 = mock(JsonSerializable.class);
    when(jsonSerializable3.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable4 = mock(JsonSerializable.class);
    when(jsonSerializable4.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable5 = mock(JsonSerializable.class);
    when(jsonSerializable5.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable6 = mock(JsonSerializable.class);
    when(jsonSerializable6.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable7 = mock(JsonSerializable.class);
    when(jsonSerializable7.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable8 = mock(JsonSerializable.class);
    when(jsonSerializable8.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable9 = mock(JsonSerializable.class);
    when(jsonSerializable9.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable10 = mock(JsonSerializable.class);
    when(jsonSerializable10.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable11 = mock(JsonSerializable.class);
    when(jsonSerializable11.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable12 = mock(JsonSerializable.class);
    when(jsonSerializable12.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable13 = mock(JsonSerializable.class);
    when(jsonSerializable13.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable14 = mock(JsonSerializable.class);
    when(jsonSerializable14.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable15 = mock(JsonSerializable.class);
    when(jsonSerializable15.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable16 = mock(JsonSerializable.class);
    when(jsonSerializable16.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable17 = mock(JsonSerializable.class);
    when(jsonSerializable17.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable18 = mock(JsonSerializable.class);
    when(jsonSerializable18.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable19 = mock(JsonSerializable.class);
    when(jsonSerializable19.toJson(Mockito.<StringBuilder>any()))
        .thenThrow(new RuntimeException("\""));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable);
    formattableList.add(jsonSerializable2);
    formattableList.add(jsonSerializable3);
    formattableList.add(jsonSerializable4);
    formattableList.add(jsonSerializable5);
    formattableList.add(jsonSerializable6);
    formattableList.add(jsonSerializable7);
    formattableList.add(jsonSerializable8);
    formattableList.add(jsonSerializable9);
    formattableList.add(jsonSerializable10);
    formattableList.add(jsonSerializable11);
    formattableList.add(jsonSerializable12);
    formattableList.add(jsonSerializable13);
    formattableList.add(jsonSerializable14);
    formattableList.add(jsonSerializable15);
    formattableList.add(jsonSerializable16);
    formattableList.add(jsonSerializable17);
    formattableList.add(jsonSerializable18);
    formattableList.add(jsonSerializable19);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonPrinter.listToJson("Key", formattableList, new StringBuilder("foo")));
    verify(jsonSerializable).toJson(isA(StringBuilder.class));
    verify(jsonSerializable2).toJson(isA(StringBuilder.class));
    verify(jsonSerializable3).toJson(isA(StringBuilder.class));
    verify(jsonSerializable4).toJson(isA(StringBuilder.class));
    verify(jsonSerializable5).toJson(isA(StringBuilder.class));
    verify(jsonSerializable6).toJson(isA(StringBuilder.class));
    verify(jsonSerializable7).toJson(isA(StringBuilder.class));
    verify(jsonSerializable8).toJson(isA(StringBuilder.class));
    verify(jsonSerializable9).toJson(isA(StringBuilder.class));
    verify(jsonSerializable10).toJson(isA(StringBuilder.class));
    verify(jsonSerializable11).toJson(isA(StringBuilder.class));
    verify(jsonSerializable12).toJson(isA(StringBuilder.class));
    verify(jsonSerializable13).toJson(isA(StringBuilder.class));
    verify(jsonSerializable14).toJson(isA(StringBuilder.class));
    verify(jsonSerializable15).toJson(isA(StringBuilder.class));
    verify(jsonSerializable16).toJson(isA(StringBuilder.class));
    verify(jsonSerializable17).toJson(isA(StringBuilder.class));
    verify(jsonSerializable18).toJson(isA(StringBuilder.class));
    verify(jsonSerializable19).toJson(isA(StringBuilder.class));
  }

  /**
   * Test {@link JsonPrinter#listToJson(String, List, StringBuilder)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPrinter#listToJson(String, List, StringBuilder)}
   */
  @Test
  @DisplayName("Test listToJson(String, List, StringBuilder); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_thenThrowRuntimeException4() {
    // Arrange
    JsonSerializable jsonSerializable = mock(JsonSerializable.class);
    when(jsonSerializable.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable2 = mock(JsonSerializable.class);
    when(jsonSerializable2.toJson(Mockito.<StringBuilder>any()))
        .thenReturn(new StringBuilder("foo"));
    JsonSerializable jsonSerializable3 = mock(JsonSerializable.class);
    when(jsonSerializable3.toJson(Mockito.<StringBuilder>any()))
        .thenThrow(new RuntimeException("\""));

    ArrayList<JsonSerializable> formattableList = new ArrayList<>();
    formattableList.add(jsonSerializable3);
    formattableList.add(jsonSerializable2);
    formattableList.add(jsonSerializable);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonPrinter.listToJson("Key", formattableList, new StringBuilder("foo")));
    verify(jsonSerializable3).toJson(isA(StringBuilder.class));
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
  @DisplayName(
      "Test listToJson(String, List, StringBuilder); when ArrayList(); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey() {
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
  @DisplayName(
      "Test listToJson(String, List, StringBuilder); when ArrayList(); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.listToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey2() {
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
  @DisplayName(
      "Test stringListToJson(String, List, StringBuilder); given '\"'; then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[\"\"\"]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.stringListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testStringListToJson_givenQuotationMark_thenStringBuilderWithFooToStringIsFooKey() {
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
  @DisplayName(
      "Test stringListToJson(String, List, StringBuilder); given '\"'; then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[\"\"\"]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.stringListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testStringListToJson_givenQuotationMark_thenStringBuilderWithFooToStringIsFooKey2() {
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
  @DisplayName(
      "Test stringListToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.stringListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testStringListToJson_thenStringBuilderWithFooToStringIsAString() {
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
  @DisplayName(
      "Test stringListToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.stringListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testStringListToJson_thenStringBuilderWithFooToStringIsAString2() {
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
  @DisplayName(
      "Test stringListToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[\"\":\",\"\"\"]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.stringListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testStringListToJson_thenStringBuilderWithFooToStringIsFooKey() {
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
  @DisplayName(
      "Test stringListToJson(String, List, StringBuilder); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[\"\":\",\"\"\"]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.stringListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testStringListToJson_thenStringBuilderWithFooToStringIsFooKey2() {
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
  @DisplayName(
      "Test stringListToJson(String, List, StringBuilder); when ArrayList(); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.stringListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testStringListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey() {
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
  @DisplayName(
      "Test stringListToJson(String, List, StringBuilder); when ArrayList(); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.stringListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testStringListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey2() {
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
  @DisplayName(
      "Test intListToJson(String, List, StringBuilder); given one; then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[1,2]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.intListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testIntListToJson_givenOne_thenStringBuilderWithFooToStringIsFooKey12() {
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
  @DisplayName(
      "Test intListToJson(String, List, StringBuilder); given one; then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[1,2]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.intListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testIntListToJson_givenOne_thenStringBuilderWithFooToStringIsFooKey122() {
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
  @DisplayName(
      "Test intListToJson(String, List, StringBuilder); given two; then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[2]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.intListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testIntListToJson_givenTwo_thenStringBuilderWithFooToStringIsFooKey2() {
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
  @DisplayName(
      "Test intListToJson(String, List, StringBuilder); given two; then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[2]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.intListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testIntListToJson_givenTwo_thenStringBuilderWithFooToStringIsFooKey22() {
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
  @DisplayName(
      "Test intListToJson(String, List, StringBuilder); when ArrayList(); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.intListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testIntListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey() {
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
  @DisplayName(
      "Test intListToJson(String, List, StringBuilder); when ArrayList(); then StringBuilder(String) with 'foo' toString is 'foo\"Key\":[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.JsonPrinter.intListToJson(java.lang.String, java.util.List, java.lang.StringBuilder)"
  })
  void testIntListToJson_whenArrayList_thenStringBuilderWithFooToStringIsFooKey2() {
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
  @DisplayName("Test startCodeAttribute(Clazz, Method, CodeAttribute, Variables)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.startCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.Variables)"
  })
  void testStartCodeAttribute() {
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
  @DisplayName("Test startCodeAttribute(Clazz, Method, CodeAttribute, Variables)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.startCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.Variables)"
  })
  void testStartCodeAttribute2() {
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
  @DisplayName("Test startCodeAttribute(Clazz, Method, CodeAttribute, Variables)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.startCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.Variables)"
  })
  void testStartCodeAttribute3() {
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
  @DisplayName("Test startCodeAttribute(Clazz, Method, CodeAttribute, Variables)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.startCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.Variables)"
  })
  void testStartCodeAttribute4() {
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
  @DisplayName(
      "Test startCodeAttribute(Clazz, Method, CodeAttribute, Variables); then JsonPrinter() Json is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.startCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.Variables)"
  })
  void testStartCodeAttribute_thenJsonPrinterJsonIsAString() {
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
  @DisplayName(
      "Test startCodeAttribute(Clazz, Method, CodeAttribute, Variables); then JsonPrinter() Json is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.JsonPrinter.startCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.Variables)"
  })
  void testStartCodeAttribute_thenJsonPrinterJsonIsAString2() {
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

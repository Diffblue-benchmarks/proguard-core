package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.object.model.reflective.ReflectiveModel;

class WarningPrinterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WarningPrinter#WarningPrinter(PrintWriter)}
   *   <li>{@link WarningPrinter#getWarningCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WarningPrinter.<init>(java.io.PrintWriter)",
    "int proguard.classfile.util.WarningPrinter.getWarningCount()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new WarningPrinter(new PrintWriter(new StringWriter()))).getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#WarningPrinter(PrintWriter, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return WarningCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#WarningPrinter(PrintWriter, List)}
   */
  @Test
  @DisplayName(
      "Test new WarningPrinter(PrintWriter, List); given '42'; when ArrayList() add '42'; then return WarningCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WarningPrinter.<init>(java.io.PrintWriter, java.util.List)"
  })
  void testNewWarningPrinter_given42_whenArrayListAdd42_thenReturnWarningCountIsZero() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    ArrayList<Object> classFilter = new ArrayList<>();
    classFilter.add("42");

    // Act and Assert
    assertEquals(0, (new WarningPrinter(printWriter, classFilter)).getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#WarningPrinter(PrintWriter, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return WarningCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#WarningPrinter(PrintWriter, List)}
   */
  @Test
  @DisplayName(
      "Test new WarningPrinter(PrintWriter, List); given '42'; when ArrayList() add '42'; then return WarningCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WarningPrinter.<init>(java.io.PrintWriter, java.util.List)"
  })
  void testNewWarningPrinter_given42_whenArrayListAdd42_thenReturnWarningCountIsZero2() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    ArrayList<Object> classFilter = new ArrayList<>();
    classFilter.add("42");
    classFilter.add("42");

    // Act and Assert
    assertEquals(0, (new WarningPrinter(printWriter, classFilter)).getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#WarningPrinter(PrintWriter, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return WarningCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#WarningPrinter(PrintWriter, List)}
   */
  @Test
  @DisplayName(
      "Test new WarningPrinter(PrintWriter, List); when ArrayList(); then return WarningCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WarningPrinter.<init>(java.io.PrintWriter, java.util.List)"
  })
  void testNewWarningPrinter_whenArrayList_thenReturnWarningCountIsZero() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    // Act and Assert
    assertEquals(0, (new WarningPrinter(printWriter, new ArrayList<>())).getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#WarningPrinter(PrintWriter, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return WarningCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#WarningPrinter(PrintWriter, List)}
   */
  @Test
  @DisplayName(
      "Test new WarningPrinter(PrintWriter, List); when 'null'; then return WarningCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WarningPrinter.<init>(java.io.PrintWriter, java.util.List)"
  })
  void testNewWarningPrinter_whenNull_thenReturnWarningCountIsZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new WarningPrinter(new PrintWriter(new StringWriter()), null)).getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String, String)} with {@code className1}, {@code
   * className2}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className1', 'className2', 'warning'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WarningPrinter.print(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testPrintWithClassName1ClassName2Warning() {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    warningPrinter.print("Class Name1", "Class Name2", "Warning");

    // Assert
    assertEquals(1, warningPrinter.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String)} with {@code className}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String)}
   */
  @Test
  @DisplayName("Test print(String, String) with 'className', 'warning'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WarningPrinter.print(java.lang.String, java.lang.String)"
  })
  void testPrintWithClassNameWarning() {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    warningPrinter.print("Class Name", "Warning");

    // Assert
    assertEquals(1, warningPrinter.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#accepts(String, String)} with {@code className1}, {@code
   * className2}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#accepts(String, String)}
   */
  @Test
  @DisplayName(
      "Test accepts(String, String) with 'className1', 'className2'; given ArrayList() add 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.WarningPrinter.accepts(java.lang.String, java.lang.String)"
  })
  void testAcceptsWithClassName1ClassName2_givenArrayListAddFoo_thenReturnTrue() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");

    // Act and Assert
    assertTrue(
        (new WarningLogger(ReflectiveModel.log, classFilter))
            .accepts("Class Name1", "Class Name2"));
  }

  /**
   * Test {@link WarningPrinter#accepts(String, String)} with {@code className1}, {@code
   * className2}.
   *
   * <ul>
   *   <li>Given {@link PrintWriter#PrintWriter(Writer)} with {@link StringWriter#StringWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#accepts(String, String)}
   */
  @Test
  @DisplayName(
      "Test accepts(String, String) with 'className1', 'className2'; given PrintWriter(Writer) with StringWriter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.WarningPrinter.accepts(java.lang.String, java.lang.String)"
  })
  void testAcceptsWithClassName1ClassName2_givenPrintWriterWithStringWriter() {
    // Arrange, Act and Assert
    assertTrue(
        (new WarningPrinter(new PrintWriter(new StringWriter())))
            .accepts("Class Name1", "Class Name2"));
  }

  /**
   * Test {@link WarningPrinter#accepts(String, String)} with {@code className1}, {@code
   * className2}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#accepts(String, String)}
   */
  @Test
  @DisplayName("Test accepts(String, String) with 'className1', 'className2'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.WarningPrinter.accepts(java.lang.String, java.lang.String)"
  })
  void testAcceptsWithClassName1ClassName2_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new WarningLogger(ReflectiveModel.log, new ArrayList<>()))
            .accepts("Class Name1", "Class Name2"));
  }

  /**
   * Test {@link WarningPrinter#accepts(String)} with {@code className}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#accepts(String)}
   */
  @Test
  @DisplayName(
      "Test accepts(String) with 'className'; given ArrayList() add 'foo'; when 'Class Name'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.WarningPrinter.accepts(java.lang.String)"})
  void testAcceptsWithClassName_givenArrayListAddFoo_whenClassName_thenReturnTrue() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");

    // Act and Assert
    assertTrue((new WarningLogger(ReflectiveModel.log, classFilter)).accepts("Class Name"));
  }

  /**
   * Test {@link WarningPrinter#accepts(String)} with {@code className}.
   *
   * <ul>
   *   <li>Given {@link PrintWriter#PrintWriter(Writer)} with {@link StringWriter#StringWriter()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#accepts(String)}
   */
  @Test
  @DisplayName(
      "Test accepts(String) with 'className'; given PrintWriter(Writer) with StringWriter(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.WarningPrinter.accepts(java.lang.String)"})
  void testAcceptsWithClassName_givenPrintWriterWithStringWriter_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new WarningPrinter(new PrintWriter(new StringWriter()))).accepts("Class Name"));
  }

  /**
   * Test {@link WarningPrinter#accepts(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#accepts(String)}
   */
  @Test
  @DisplayName("Test accepts(String) with 'className'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.WarningPrinter.accepts(java.lang.String)"})
  void testAcceptsWithClassName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new WarningLogger(ReflectiveModel.log, new ArrayList<>())).accepts("Class Name"));
  }
}

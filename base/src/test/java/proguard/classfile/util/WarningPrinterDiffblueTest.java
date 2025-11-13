package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WarningPrinter.<init>(PrintWriter)",
    "int WarningPrinter.getWarningCount()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, new WarningPrinter(new PrintWriter(new StringWriter())).getWarningCount());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.<init>(PrintWriter, List)"})
  void testNewWarningPrinter_given42_whenArrayListAdd42_thenReturnWarningCountIsZero() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    ArrayList<Object> classFilter = new ArrayList<>();
    classFilter.add("42");

    // Act
    WarningPrinter actualWarningPrinter = new WarningPrinter(printWriter, classFilter);

    // Assert
    assertEquals(0, actualWarningPrinter.getWarningCount());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.<init>(PrintWriter, List)"})
  void testNewWarningPrinter_given42_whenArrayListAdd42_thenReturnWarningCountIsZero2() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    ArrayList<Object> classFilter = new ArrayList<>();
    classFilter.add("42");
    classFilter.add("42");

    // Act
    WarningPrinter actualWarningPrinter = new WarningPrinter(printWriter, classFilter);

    // Assert
    assertEquals(0, actualWarningPrinter.getWarningCount());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.<init>(PrintWriter, List)"})
  void testNewWarningPrinter_whenArrayList_thenReturnWarningCountIsZero() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    // Act
    WarningPrinter actualWarningPrinter = new WarningPrinter(printWriter, new ArrayList<>());

    // Assert
    assertEquals(0, actualWarningPrinter.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String, String)} with {@code className1}, {@code
   * className2}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className1', 'className2', 'warning'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String, String)"})
  void testPrintWithClassName1ClassName2Warning() {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    warningPrinter.print("Class Name1", "Class Name2", "Warning");

    // Assert
    assertEquals(1, warningPrinter.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String, String)} with {@code className1}, {@code
   * className2}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className1', 'className2', 'warning'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String, String)"})
  void testPrintWithClassName1ClassName2Warning2() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);

    // Act
    warningLogger.print("Class Name1", "Class Name2", "Warning");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String, String)} with {@code className1}, {@code
   * className2}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className1', 'className2', 'warning'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String, String)"})
  void testPrintWithClassName1ClassName2Warning3() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, new ArrayList<>());

    // Act
    warningLogger.print("Class Name1", "Class Name2", "Warning");

    // Assert that nothing has changed
    assertEquals(0, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String, String)} with {@code className1}, {@code
   * className2}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className1', 'className2', 'warning'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String, String)"})
  void testPrintWithClassName1ClassName2Warning4() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    WarningPrinter warningPrinter = new WarningPrinter(printWriter, new ArrayList<>());

    // Act
    warningPrinter.print("Class Name1", "Class Name2", "Warning");

    // Assert that nothing has changed
    assertEquals(0, warningPrinter.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String, String)} with {@code className1}, {@code
   * className2}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className1', 'className2', 'warning'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String, String)"})
  void testPrintWithClassName1ClassName2Warning5() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, classFilter);

    // Act
    warningLogger.print("Class Name1", "Class Name2", "Warning");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String)} with {@code className}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String)}
   */
  @Test
  @DisplayName("Test print(String, String) with 'className', 'warning'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String)"})
  void testPrintWithClassNameWarning() {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    warningPrinter.print("Class Name", "Warning");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String)"})
  void testPrintWithClassNameWarning2() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, new ArrayList<>());

    // Act
    warningLogger.print("Class Name", "Warning");

    // Assert that nothing has changed
    assertEquals(0, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String)} with {@code className}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String)}
   */
  @Test
  @DisplayName("Test print(String, String) with 'className', 'warning'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String)"})
  void testPrintWithClassNameWarning3() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    WarningPrinter warningPrinter = new WarningPrinter(printWriter, new ArrayList<>());

    // Act
    warningPrinter.print("Class Name", "Warning");

    // Assert that nothing has changed
    assertEquals(0, warningPrinter.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String)} with {@code className}, {@code warning}.
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String)}
   */
  @Test
  @DisplayName("Test print(String, String) with 'className', 'warning'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String)"})
  void testPrintWithClassNameWarning4() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, classFilter);

    // Act
    warningLogger.print("Class Name", "Warning");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningPrinter#print(String, String)} with {@code className}, {@code warning}.
   *
   * <ul>
   *   <li>Then {@link WarningLogger#WarningLogger(Logger)} with logger is {@link
   *       ReflectiveModel#log} WarningCount is one.
   * </ul>
   *
   * <p>Method under test: {@link WarningPrinter#print(String, String)}
   */
  @Test
  @DisplayName(
      "Test print(String, String) with 'className', 'warning'; then WarningLogger(Logger) with logger is log WarningCount is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningPrinter.print(String, String)"})
  void testPrintWithClassNameWarning_thenWarningLoggerWithLoggerIsLogWarningCountIsOne() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);

    // Act
    warningLogger.print("Class Name", "Warning");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningPrinter.accepts(String, String)"})
  void testAcceptsWithClassName1ClassName2_givenArrayListAddFoo_thenReturnTrue() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, classFilter);

    // Act and Assert
    assertTrue(warningLogger.accepts("Class Name1", "Class Name2"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningPrinter.accepts(String, String)"})
  void testAcceptsWithClassName1ClassName2_givenPrintWriterWithStringWriter() {
    // Arrange, Act and Assert
    assertTrue(
        new WarningPrinter(new PrintWriter(new StringWriter()))
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningPrinter.accepts(String, String)"})
  void testAcceptsWithClassName1ClassName2_thenReturnFalse() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, new ArrayList<>());

    // Act and Assert
    assertFalse(warningLogger.accepts("Class Name1", "Class Name2"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningPrinter.accepts(String)"})
  void testAcceptsWithClassName_givenArrayListAddFoo_whenClassName_thenReturnTrue() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, classFilter);

    // Act and Assert
    assertTrue(warningLogger.accepts("Class Name"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningPrinter.accepts(String)"})
  void testAcceptsWithClassName_givenPrintWriterWithStringWriter_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new WarningPrinter(new PrintWriter(new StringWriter())).accepts("Class Name"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningPrinter.accepts(String)"})
  void testAcceptsWithClassName_thenReturnFalse() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, new ArrayList<>());

    // Act and Assert
    assertFalse(warningLogger.accepts("Class Name"));
  }
}

package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.object.model.reflective.ReflectiveModel;

class WarningLoggerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WarningLogger#WarningLogger(Logger)}
   *   <li>{@link WarningLogger#getWarningCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningLogger.<init>(Logger)", "int WarningLogger.getWarningCount()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, new WarningLogger(ReflectiveModel.log).getWarningCount());
  }

  /**
   * Test {@link WarningLogger#print(String, String, String)} with {@code className}, {@code
   * className2}, {@code message}.
   *
   * <p>Method under test: {@link WarningLogger#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className', 'className2', 'message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningLogger.print(String, String, String)"})
  void testPrintWithClassNameClassName2Message() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);

    // Act
    warningLogger.print("Class Name", "Class Name2", "Not all who wander are lost");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningLogger#print(String, String, String)} with {@code className}, {@code
   * className2}, {@code message}.
   *
   * <p>Method under test: {@link WarningLogger#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className', 'className2', 'message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningLogger.print(String, String, String)"})
  void testPrintWithClassNameClassName2Message2() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, new ArrayList<>());

    // Act
    warningLogger.print("Class Name", "Class Name2", "Not all who wander are lost");

    // Assert that nothing has changed
    assertEquals(0, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningLogger#print(String, String, String)} with {@code className}, {@code
   * className2}, {@code message}.
   *
   * <p>Method under test: {@link WarningLogger#print(String, String, String)}
   */
  @Test
  @DisplayName("Test print(String, String, String) with 'className', 'className2', 'message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningLogger.print(String, String, String)"})
  void testPrintWithClassNameClassName2Message3() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, classFilter);

    // Act
    warningLogger.print("Class Name", "Class Name2", "Not all who wander are lost");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningLogger#print(String, String)} with {@code className}, {@code message}.
   *
   * <p>Method under test: {@link WarningLogger#print(String, String)}
   */
  @Test
  @DisplayName("Test print(String, String) with 'className', 'message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningLogger.print(String, String)"})
  void testPrintWithClassNameMessage() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, new ArrayList<>());

    // Act
    warningLogger.print("Class Name", "Not all who wander are lost");

    // Assert that nothing has changed
    assertEquals(0, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningLogger#print(String, String)} with {@code className}, {@code message}.
   *
   * <p>Method under test: {@link WarningLogger#print(String, String)}
   */
  @Test
  @DisplayName("Test print(String, String) with 'className', 'message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningLogger.print(String, String)"})
  void testPrintWithClassNameMessage2() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, classFilter);

    // Act
    warningLogger.print("Class Name", "Not all who wander are lost");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }

  /**
   * Test {@link WarningLogger#print(String, String)} with {@code className}, {@code message}.
   *
   * <ul>
   *   <li>Then {@link WarningLogger#WarningLogger(Logger)} with logger is {@link
   *       ReflectiveModel#log} WarningCount is one.
   * </ul>
   *
   * <p>Method under test: {@link WarningLogger#print(String, String)}
   */
  @Test
  @DisplayName(
      "Test print(String, String) with 'className', 'message'; then WarningLogger(Logger) with logger is log WarningCount is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WarningLogger.print(String, String)"})
  void testPrintWithClassNameMessage_thenWarningLoggerWithLoggerIsLogWarningCountIsOne() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);

    // Act
    warningLogger.print("Class Name", "Not all who wander are lost");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }
}

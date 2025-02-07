package proguard.util.kotlin.asserter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.util.WarningPrinter;

class DefaultReporterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultReporter#DefaultReporter(WarningPrinter)}
   *   <li>{@link DefaultReporter#setErrorMessage(String)}
   *   <li>{@link DefaultReporter#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.DefaultReporter.<init>(proguard.classfile.util.WarningPrinter)",
    "int proguard.util.kotlin.asserter.DefaultReporter.getCount()",
    "void proguard.util.kotlin.asserter.DefaultReporter.setErrorMessage(java.lang.String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultReporter actualDefaultReporter =
        new DefaultReporter(new WarningPrinter(new PrintWriter(new StringWriter())));
    actualDefaultReporter.setErrorMessage("An error occurred");

    // Assert
    assertEquals(0, actualDefaultReporter.getCount());
  }

  /**
   * Test {@link DefaultReporter#report(String)}.
   *
   * <p>Method under test: {@link DefaultReporter#report(String)}
   */
  @Test
  @DisplayName("Test report(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.kotlin.asserter.DefaultReporter.report(java.lang.String)"})
  void testReport() {
    // Arrange
    DefaultReporter defaultReporter =
        new DefaultReporter(new WarningPrinter(new PrintWriter(new StringWriter())));

    // Act
    defaultReporter.report("An error occurred");

    // Assert
    assertEquals(1, defaultReporter.getCount());
  }
}

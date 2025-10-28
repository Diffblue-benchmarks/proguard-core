package proguard.util.kotlin.asserter;

import static org.junit.Assert.assertEquals;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.Test;
import proguard.classfile.util.WarningPrinter;

public class DefaultReporterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultReporter#DefaultReporter(WarningPrinter)}
   *   <li>{@link DefaultReporter#setErrorMessage(String)}
   *   <li>{@link DefaultReporter#getCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DefaultReporter actualDefaultReporter = new DefaultReporter(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    actualDefaultReporter.setErrorMessage("An error occurred");

    // Assert that nothing has changed
    assertEquals(0, actualDefaultReporter.getCount());
  }

  /**
   * Method under test: {@link DefaultReporter#report(String)}
   */
  @Test
  public void testReport() {
    // Arrange
    DefaultReporter defaultReporter = new DefaultReporter(new WarningPrinter(new PrintWriter(new StringWriter())));

    // Act
    defaultReporter.report("An error occurred");

    // Assert
    assertEquals(1, defaultReporter.getCount());
  }
}

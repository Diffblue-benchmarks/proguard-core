package proguard.util.kotlin.asserter;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.util.WarningPrinter;

public class DefaultReporterDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DefaultReporter.<init>(WarningPrinter)",
    "int DefaultReporter.getCount()",
    "void DefaultReporter.setErrorMessage(String)"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultReporter.report(String)"})
  public void testReport() {
    // Arrange
    DefaultReporter defaultReporter =
        new DefaultReporter(new WarningPrinter(new PrintWriter(new StringWriter())));

    // Act
    defaultReporter.report("An error occurred");

    // Assert
    assertEquals(1, defaultReporter.getCount());
  }
}

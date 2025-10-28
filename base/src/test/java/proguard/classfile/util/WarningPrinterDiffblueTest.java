package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.evaluation.value.object.model.reflective.ReflectiveModel;

public class WarningPrinterDiffblueTest {
  /**
   * Method under test: {@link WarningPrinter#print(String, String)}
   */
  @Test
  public void testPrint() {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    warningPrinter.print("Class Name", "Warning");

    // Assert
    assertEquals(1, warningPrinter.getWarningCount());
  }

  /**
   * Method under test: {@link WarningPrinter#print(String, String, String)}
   */
  @Test
  public void testPrint2() {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    warningPrinter.print("Class Name1", "Class Name2", "Warning");

    // Assert
    assertEquals(1, warningPrinter.getWarningCount());
  }

  /**
   * Method under test: {@link WarningPrinter#accepts(String)}
   */
  @Test
  public void testAccepts() {
    // Arrange, Act and Assert
    assertTrue((new WarningPrinter(new PrintWriter(new StringWriter()))).accepts("Class Name"));
    assertFalse((new WarningLogger(ReflectiveModel.log, new ArrayList<>())).accepts("Class Name"));
    assertTrue((new WarningPrinter(new PrintWriter(new StringWriter()))).accepts("Class Name1", "Class Name2"));
    assertFalse((new WarningLogger(ReflectiveModel.log, new ArrayList<>())).accepts("Class Name1", "Class Name2"));
  }

  /**
   * Method under test: {@link WarningPrinter#accepts(String)}
   */
  @Test
  public void testAccepts2() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");

    // Act and Assert
    assertTrue((new WarningLogger(ReflectiveModel.log, classFilter)).accepts("Class Name"));
  }

  /**
   * Method under test: {@link WarningPrinter#accepts(String, String)}
   */
  @Test
  public void testAccepts3() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");

    // Act and Assert
    assertTrue((new WarningLogger(ReflectiveModel.log, classFilter)).accepts("Class Name1", "Class Name2"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WarningPrinter#WarningPrinter(PrintWriter)}
   *   <li>{@link WarningPrinter#getWarningCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new WarningPrinter(new PrintWriter(new StringWriter()))).getWarningCount());
  }

  /**
   * Method under test: {@link WarningPrinter#WarningPrinter(PrintWriter, List)}
   */
  @Test
  public void testNewWarningPrinter() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    // Act and Assert
    assertEquals(0, (new WarningPrinter(printWriter, new ArrayList<>())).getWarningCount());
  }

  /**
   * Method under test: {@link WarningPrinter#WarningPrinter(PrintWriter, List)}
   */
  @Test
  public void testNewWarningPrinter2() {
    // Arrange, Act and Assert
    assertEquals(0, (new WarningPrinter(new PrintWriter(new StringWriter()), null)).getWarningCount());
  }

  /**
   * Method under test: {@link WarningPrinter#WarningPrinter(PrintWriter, List)}
   */
  @Test
  public void testNewWarningPrinter3() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    ArrayList<Object> classFilter = new ArrayList<>();
    classFilter.add("42");

    // Act and Assert
    assertEquals(0, (new WarningPrinter(printWriter, classFilter)).getWarningCount());
  }

  /**
   * Method under test: {@link WarningPrinter#WarningPrinter(PrintWriter, List)}
   */
  @Test
  public void testNewWarningPrinter4() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());

    ArrayList<Object> classFilter = new ArrayList<>();
    classFilter.add("42");
    classFilter.add("42");

    // Act and Assert
    assertEquals(0, (new WarningPrinter(printWriter, classFilter)).getWarningCount());
  }
}

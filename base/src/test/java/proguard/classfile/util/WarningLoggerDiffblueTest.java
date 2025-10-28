package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import proguard.evaluation.value.object.model.reflective.ReflectiveModel;

public class WarningLoggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WarningLogger#WarningLogger(Logger)}
   *   <li>{@link WarningLogger#getWarningCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new WarningLogger(ReflectiveModel.log)).getWarningCount());
  }

  /**
   * Method under test: {@link WarningLogger#print(String, String)}
   */
  @Test
  public void testPrint() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);

    // Act
    warningLogger.print("Class Name", "Not all who wander are lost");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }

  /**
   * Method under test: {@link WarningLogger#print(String, String)}
   */
  @Test
  public void testPrint2() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, new ArrayList<>());

    // Act
    warningLogger.print("Class Name", "Not all who wander are lost");

    // Assert that nothing has changed
    assertEquals(0, warningLogger.getWarningCount());
  }

  /**
   * Method under test: {@link WarningLogger#print(String, String)}
   */
  @Test
  public void testPrint3() {
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
   * Method under test: {@link WarningLogger#print(String, String, String)}
   */
  @Test
  public void testPrint4() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);

    // Act
    warningLogger.print("Class Name", "Class Name2", "Not all who wander are lost");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }

  /**
   * Method under test: {@link WarningLogger#print(String, String, String)}
   */
  @Test
  public void testPrint5() {
    // Arrange
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, new ArrayList<>());

    // Act
    warningLogger.print("Class Name", "Class Name2", "Not all who wander are lost");

    // Assert that nothing has changed
    assertEquals(0, warningLogger.getWarningCount());
  }

  /**
   * Method under test: {@link WarningLogger#print(String, String, String)}
   */
  @Test
  public void testPrint6() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("foo");
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log, classFilter);

    // Act
    warningLogger.print("Class Name", "Class Name2", "Not all who wander are lost");

    // Assert
    assertEquals(1, warningLogger.getWarningCount());
  }
}

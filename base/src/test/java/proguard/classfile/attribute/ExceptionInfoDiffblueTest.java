package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ExceptionInfoDiffblueTest {
  /**
   * Method under test: {@link ExceptionInfo#isApplicable(int)}
   */
  @Test
  public void testIsApplicable() {
    // Arrange, Act and Assert
    assertTrue((new ExceptionInfo(1, 3, 1, 1)).isApplicable(1));
    assertFalse((new ExceptionInfo(3, 3, 1, 1)).isApplicable(1));
    assertFalse((new ExceptionInfo(1, 1, 1, 1)).isApplicable(1));
    assertTrue((new ExceptionInfo(1, 3, 1, 1)).isApplicable(1, 3));
    assertFalse((new ExceptionInfo(3, 3, 1, 1)).isApplicable(1, 3));
    assertFalse((new ExceptionInfo(1, 1, 1, 1)).isApplicable(1, 3));
  }

  /**
   * Method under test: {@link ExceptionInfo#ExceptionInfo()}
   */
  @Test
  public void testNewExceptionInfo() {
    // Arrange and Act
    ExceptionInfo actualExceptionInfo = new ExceptionInfo();

    // Assert
    assertNull(actualExceptionInfo.getProcessingInfo());
    assertEquals(0, actualExceptionInfo.getProcessingFlags());
  }

  /**
   * Method under test: {@link ExceptionInfo#ExceptionInfo(int, int, int, int)}
   */
  @Test
  public void testNewExceptionInfo2() {
    // Arrange and Act
    ExceptionInfo actualExceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    // Assert
    assertNull(actualExceptionInfo.getProcessingInfo());
    assertEquals(0, actualExceptionInfo.getProcessingFlags());
  }
}

package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ParameterInfoDiffblueTest {
  /**
   * Method under test: {@link ParameterInfo#ParameterInfo()}
   */
  @Test
  public void testNewParameterInfo() {
    // Arrange and Act
    ParameterInfo actualParameterInfo = new ParameterInfo();

    // Assert
    assertNull(actualParameterInfo.getProcessingInfo());
    assertEquals(0, actualParameterInfo.getProcessingFlags());
  }

  /**
   * Method under test: {@link ParameterInfo#ParameterInfo(int, int)}
   */
  @Test
  public void testNewParameterInfo2() {
    // Arrange and Act
    ParameterInfo actualParameterInfo = new ParameterInfo(1, 1);

    // Assert
    assertNull(actualParameterInfo.getProcessingInfo());
    assertEquals(0, actualParameterInfo.getProcessingFlags());
  }
}

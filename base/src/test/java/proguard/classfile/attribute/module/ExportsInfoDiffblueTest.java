package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ExportsInfoDiffblueTest {
  /**
   * Method under test: {@link ExportsInfo#ExportsInfo()}
   */
  @Test
  public void testNewExportsInfo() {
    // Arrange and Act
    ExportsInfo actualExportsInfo = new ExportsInfo();

    // Assert
    assertNull(actualExportsInfo.getProcessingInfo());
    assertEquals(0, actualExportsInfo.getProcessingFlags());
  }

  /**
   * Method under test: {@link ExportsInfo#ExportsInfo(int, int, int, int[])}
   */
  @Test
  public void testNewExportsInfo2() {
    // Arrange and Act
    ExportsInfo actualExportsInfo = new ExportsInfo(1, 1, 3, new int[]{1, 0, 1, 0});

    // Assert
    assertNull(actualExportsInfo.getProcessingInfo());
    assertEquals(0, actualExportsInfo.getProcessingFlags());
  }
}

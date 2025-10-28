package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ProvidesInfoDiffblueTest {
  /**
   * Method under test: {@link ProvidesInfo#ProvidesInfo()}
   */
  @Test
  public void testNewProvidesInfo() {
    // Arrange and Act
    ProvidesInfo actualProvidesInfo = new ProvidesInfo();

    // Assert
    assertNull(actualProvidesInfo.getProcessingInfo());
    assertEquals(0, actualProvidesInfo.getProcessingFlags());
  }

  /**
   * Method under test: {@link ProvidesInfo#ProvidesInfo(int, int, int[])}
   */
  @Test
  public void testNewProvidesInfo2() {
    // Arrange and Act
    ProvidesInfo actualProvidesInfo = new ProvidesInfo(1, 1, new int[]{1, 2, 1, 2});

    // Assert
    assertNull(actualProvidesInfo.getProcessingInfo());
    assertEquals(0, actualProvidesInfo.getProcessingFlags());
  }
}

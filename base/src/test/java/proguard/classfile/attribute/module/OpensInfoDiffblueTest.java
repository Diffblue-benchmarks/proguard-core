package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class OpensInfoDiffblueTest {
  /**
   * Method under test: {@link OpensInfo#OpensInfo()}
   */
  @Test
  public void testNewOpensInfo() {
    // Arrange and Act
    OpensInfo actualOpensInfo = new OpensInfo();

    // Assert
    assertNull(actualOpensInfo.getProcessingInfo());
    assertEquals(0, actualOpensInfo.getProcessingFlags());
  }

  /**
   * Method under test: {@link OpensInfo#OpensInfo(int, int, int, int[])}
   */
  @Test
  public void testNewOpensInfo2() {
    // Arrange and Act
    OpensInfo actualOpensInfo = new OpensInfo(1, 1, 3, new int[]{1, 0, 1, 0});

    // Assert
    assertNull(actualOpensInfo.getProcessingInfo());
    assertEquals(0, actualOpensInfo.getProcessingFlags());
  }
}

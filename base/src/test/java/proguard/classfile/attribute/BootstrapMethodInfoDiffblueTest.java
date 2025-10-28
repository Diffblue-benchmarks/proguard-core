package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BootstrapMethodInfoDiffblueTest {
  /**
   * Method under test: {@link BootstrapMethodInfo#BootstrapMethodInfo()}
   */
  @Test
  public void testNewBootstrapMethodInfo() {
    // Arrange and Act
    BootstrapMethodInfo actualBootstrapMethodInfo = new BootstrapMethodInfo();

    // Assert
    assertNull(actualBootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodInfo.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodInfo#BootstrapMethodInfo(int, int, int[])}
   */
  @Test
  public void testNewBootstrapMethodInfo2() {
    // Arrange and Act
    BootstrapMethodInfo actualBootstrapMethodInfo = new BootstrapMethodInfo(1, 3, new int[]{1, 0, 1, 0});

    // Assert
    assertNull(actualBootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodInfo.getProcessingFlags());
  }
}

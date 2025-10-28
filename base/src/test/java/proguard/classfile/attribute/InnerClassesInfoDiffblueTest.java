package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class InnerClassesInfoDiffblueTest {
  /**
   * Method under test: {@link InnerClassesInfo#InnerClassesInfo()}
   */
  @Test
  public void testNewInnerClassesInfo() {
    // Arrange and Act
    InnerClassesInfo actualInnerClassesInfo = new InnerClassesInfo();

    // Assert
    assertNull(actualInnerClassesInfo.getProcessingInfo());
    assertEquals(0, actualInnerClassesInfo.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link InnerClassesInfo#InnerClassesInfo(int, int, int, int)}
   */
  @Test
  public void testNewInnerClassesInfo2() {
    // Arrange and Act
    InnerClassesInfo actualInnerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Assert
    assertNull(actualInnerClassesInfo.getProcessingInfo());
    assertEquals(0, actualInnerClassesInfo.getProcessingFlags());
  }
}

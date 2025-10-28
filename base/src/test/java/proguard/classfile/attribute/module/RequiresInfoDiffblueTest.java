package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RequiresInfoDiffblueTest {
  /**
   * Method under test: {@link RequiresInfo#RequiresInfo()}
   */
  @Test
  public void testNewRequiresInfo() {
    // Arrange and Act
    RequiresInfo actualRequiresInfo = new RequiresInfo();

    // Assert
    assertNull(actualRequiresInfo.getProcessingInfo());
    assertEquals(0, actualRequiresInfo.getProcessingFlags());
  }

  /**
   * Method under test: {@link RequiresInfo#RequiresInfo(int, int, int)}
   */
  @Test
  public void testNewRequiresInfo2() {
    // Arrange and Act
    RequiresInfo actualRequiresInfo = new RequiresInfo(1, 1, 1);

    // Assert
    assertNull(actualRequiresInfo.getProcessingInfo());
    assertEquals(0, actualRequiresInfo.getProcessingFlags());
  }
}

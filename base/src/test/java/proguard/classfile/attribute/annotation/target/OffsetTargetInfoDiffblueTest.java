package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OffsetTargetInfoDiffblueTest {
  /**
   * Method under test: {@link OffsetTargetInfo#OffsetTargetInfo()}
   */
  @Test
  public void testNewOffsetTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new OffsetTargetInfo()).getTargetType());
    assertEquals('A', (new OffsetTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new OffsetTargetInfo((byte) 'A', 2)).getTargetType());
  }
}

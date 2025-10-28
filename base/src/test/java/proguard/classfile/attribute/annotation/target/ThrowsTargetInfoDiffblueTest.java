package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ThrowsTargetInfoDiffblueTest {
  /**
   * Method under test: {@link ThrowsTargetInfo#ThrowsTargetInfo()}
   */
  @Test
  public void testNewThrowsTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new ThrowsTargetInfo()).getTargetType());
    assertEquals('A', (new ThrowsTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new ThrowsTargetInfo((byte) 'A', 1)).getTargetType());
  }
}

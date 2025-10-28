package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SuperTypeTargetInfoDiffblueTest {
  /**
   * Method under test: {@link SuperTypeTargetInfo#SuperTypeTargetInfo()}
   */
  @Test
  public void testNewSuperTypeTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new SuperTypeTargetInfo()).getTargetType());
    assertEquals('A', (new SuperTypeTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new SuperTypeTargetInfo((byte) 'A', 1)).getTargetType());
  }
}

package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CatchTargetInfoDiffblueTest {
  /**
   * Method under test: {@link CatchTargetInfo#CatchTargetInfo()}
   */
  @Test
  public void testNewCatchTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new CatchTargetInfo()).getTargetType());
    assertEquals('A', (new CatchTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new CatchTargetInfo((byte) 'A', 1)).getTargetType());
  }
}

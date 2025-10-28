package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FormalParameterTargetInfoDiffblueTest {
  /**
   * Method under test:
   * {@link FormalParameterTargetInfo#FormalParameterTargetInfo()}
   */
  @Test
  public void testNewFormalParameterTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new FormalParameterTargetInfo()).getTargetType());
    assertEquals('A', (new FormalParameterTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new FormalParameterTargetInfo((byte) 'A', 1)).getTargetType());
  }
}

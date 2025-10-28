package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LocalVariableTargetInfoDiffblueTest {
  /**
   * Method under test: {@link LocalVariableTargetInfo#LocalVariableTargetInfo()}
   */
  @Test
  public void testNewLocalVariableTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new LocalVariableTargetInfo()).getTargetType());
    assertEquals('A', (new LocalVariableTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new LocalVariableTargetInfo((byte) 'A', 3,
        new LocalVariableTargetElement[]{new LocalVariableTargetElement(1, 3, 1)})).getTargetType());
  }
}

package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TypeArgumentTargetInfoDiffblueTest {
  /**
   * Method under test: {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo()}
   */
  @Test
  public void testNewTypeArgumentTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new TypeArgumentTargetInfo()).getTargetType());
    assertEquals('A', (new TypeArgumentTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new TypeArgumentTargetInfo((byte) 'A', 2, 1)).getTargetType());
  }
}

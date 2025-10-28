package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TypeParameterTargetInfoDiffblueTest {
  /**
   * Method under test: {@link TypeParameterTargetInfo#TypeParameterTargetInfo()}
   */
  @Test
  public void testNewTypeParameterTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new TypeParameterTargetInfo()).getTargetType());
    assertEquals('A', (new TypeParameterTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new TypeParameterTargetInfo((byte) 'A', 1)).getTargetType());
  }
}

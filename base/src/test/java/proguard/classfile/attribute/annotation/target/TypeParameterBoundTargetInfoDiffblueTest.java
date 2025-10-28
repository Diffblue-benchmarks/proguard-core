package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TypeParameterBoundTargetInfoDiffblueTest {
  /**
   * Method under test:
   * {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo()}
   */
  @Test
  public void testNewTypeParameterBoundTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new TypeParameterBoundTargetInfo()).getTargetType());
    assertEquals('A', (new TypeParameterBoundTargetInfo((byte) 'A')).getTargetType());
    assertEquals('A', (new TypeParameterBoundTargetInfo((byte) 'A', 1, 1)).getTargetType());
  }
}

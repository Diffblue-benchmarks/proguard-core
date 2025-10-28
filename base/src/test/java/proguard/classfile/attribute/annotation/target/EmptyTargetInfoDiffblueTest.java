package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EmptyTargetInfoDiffblueTest {
  /**
   * Method under test: {@link EmptyTargetInfo#EmptyTargetInfo()}
   */
  @Test
  public void testNewEmptyTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new EmptyTargetInfo()).getTargetType());
    assertEquals('A', (new EmptyTargetInfo((byte) 'A')).getTargetType());
  }
}

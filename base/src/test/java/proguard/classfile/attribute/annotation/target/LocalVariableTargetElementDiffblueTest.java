package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LocalVariableTargetElementDiffblueTest {
  /**
   * Method under test:
   * {@link LocalVariableTargetElement#LocalVariableTargetElement()}
   */
  @Test
  public void testNewLocalVariableTargetElement() {
    // Arrange and Act
    LocalVariableTargetElement actualLocalVariableTargetElement = new LocalVariableTargetElement();

    // Assert
    assertEquals(0, actualLocalVariableTargetElement.u2index);
    assertEquals(0, actualLocalVariableTargetElement.u2length);
    assertEquals(0, actualLocalVariableTargetElement.u2startPC);
  }

  /**
   * Method under test:
   * {@link LocalVariableTargetElement#LocalVariableTargetElement(int, int, int)}
   */
  @Test
  public void testNewLocalVariableTargetElement2() {
    // Arrange and Act
    LocalVariableTargetElement actualLocalVariableTargetElement = new LocalVariableTargetElement(1, 3, 1);

    // Assert
    assertEquals(1, actualLocalVariableTargetElement.u2index);
    assertEquals(1, actualLocalVariableTargetElement.u2startPC);
    assertEquals(3, actualLocalVariableTargetElement.u2length);
  }
}

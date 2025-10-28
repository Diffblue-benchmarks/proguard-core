package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OpDiffblueTest {
  /**
   * Method under test: {@link Op#canBranch()}
   */
  @Test
  public void testCanBranch() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canBranch());
  }

  /**
   * Method under test: {@link Op#canContinue()}
   */
  @Test
  public void testCanContinue() {
    // Arrange, Act and Assert
    assertTrue(Op.NOP.canContinue());
    assertFalse(Op.RETURN_VOID.canContinue());
  }

  /**
   * Method under test: {@link Op#canReturn()}
   */
  @Test
  public void testCanReturn() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canReturn());
    assertTrue(Op.RETURN_VOID.canReturn());
  }

  /**
   * Method under test: {@link Op#canSwitch()}
   */
  @Test
  public void testCanSwitch() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canSwitch());
  }

  /**
   * Method under test: {@link Op#canThrow()}
   */
  @Test
  public void testCanThrow() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canThrow());
  }

  /**
   * Method under test: {@link Op#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("nop", Op.valueOf("NOP").toString());
  }
}

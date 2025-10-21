package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OpDiffblueTest {
  /**
   * Test {@link Op#canBranch()}.
   *
   * <p>Method under test: {@link Op#canBranch()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Op.canBranch()"})
  public void testCanBranch() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canBranch());
  }

  /**
   * Test {@link Op#canContinue()}.
   *
   * <ul>
   *   <li>Given {@code NOP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Op#canContinue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Op.canContinue()"})
  public void testCanContinue_givenNop_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Op.NOP.canContinue());
  }

  /**
   * Test {@link Op#canContinue()}.
   *
   * <ul>
   *   <li>Given {@code RETURN_VOID}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Op#canContinue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Op.canContinue()"})
  public void testCanContinue_givenReturnVoid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Op.RETURN_VOID.canContinue());
  }

  /**
   * Test {@link Op#canReturn()}.
   *
   * <ul>
   *   <li>Given {@code NOP}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Op#canReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Op.canReturn()"})
  public void testCanReturn_givenNop_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canReturn());
  }

  /**
   * Test {@link Op#canReturn()}.
   *
   * <ul>
   *   <li>Given {@code RETURN_VOID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Op#canReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Op.canReturn()"})
  public void testCanReturn_givenReturnVoid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Op.RETURN_VOID.canReturn());
  }

  /**
   * Test {@link Op#canSwitch()}.
   *
   * <p>Method under test: {@link Op#canSwitch()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Op.canSwitch()"})
  public void testCanSwitch() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canSwitch());
  }

  /**
   * Test {@link Op#canThrow()}.
   *
   * <p>Method under test: {@link Op#canThrow()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Op.canThrow()"})
  public void testCanThrow() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canThrow());
  }

  /**
   * Test {@link Op#toString()}.
   *
   * <p>Method under test: {@link Op#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Op.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("nop", Op.valueOf("NOP").toString());
  }
}

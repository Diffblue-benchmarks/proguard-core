package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpDiffblueTest {
  /**
   * Test {@link Op#canBranch()}.
   *
   * <p>Method under test: {@link Op#canBranch()}
   */
  @Test
  @DisplayName("Test canBranch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Op.canBranch()"})
  void testCanBranch() {
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
  @DisplayName("Test canContinue(); given 'NOP'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Op.canContinue()"})
  void testCanContinue_givenNop_thenReturnTrue() {
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
  @DisplayName("Test canContinue(); given 'RETURN_VOID'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Op.canContinue()"})
  void testCanContinue_givenReturnVoid_thenReturnFalse() {
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
  @DisplayName("Test canReturn(); given 'NOP'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Op.canReturn()"})
  void testCanReturn_givenNop_thenReturnFalse() {
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
  @DisplayName("Test canReturn(); given 'RETURN_VOID'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Op.canReturn()"})
  void testCanReturn_givenReturnVoid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Op.RETURN_VOID.canReturn());
  }

  /**
   * Test {@link Op#canSwitch()}.
   *
   * <p>Method under test: {@link Op#canSwitch()}
   */
  @Test
  @DisplayName("Test canSwitch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Op.canSwitch()"})
  void testCanSwitch() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canSwitch());
  }

  /**
   * Test {@link Op#canThrow()}.
   *
   * <p>Method under test: {@link Op#canThrow()}
   */
  @Test
  @DisplayName("Test canThrow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Op.canThrow()"})
  void testCanThrow() {
    // Arrange, Act and Assert
    assertFalse(Op.NOP.canThrow());
  }

  /**
   * Test {@link Op#toString()}.
   *
   * <p>Method under test: {@link Op#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Op.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("nop", Op.valueOf("NOP").toString());
  }
}

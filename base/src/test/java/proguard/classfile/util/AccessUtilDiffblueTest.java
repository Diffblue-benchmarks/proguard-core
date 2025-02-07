package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AccessUtilDiffblueTest {
  /**
   * Test {@link AccessUtil#accessLevel(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accessLevel(int)}
   */
  @Test
  @DisplayName("Test accessLevel(int); when four; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.accessLevel(int)"})
  void testAccessLevel_whenFour_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, AccessUtil.accessLevel(4));
  }

  /**
   * Test {@link AccessUtil#accessLevel(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accessLevel(int)}
   */
  @Test
  @DisplayName("Test accessLevel(int); when one; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.accessLevel(int)"})
  void testAccessLevel_whenOne_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, AccessUtil.accessLevel(1));
  }

  /**
   * Test {@link AccessUtil#accessLevel(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accessLevel(int)}
   */
  @Test
  @DisplayName("Test accessLevel(int); when seven; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.accessLevel(int)"})
  void testAccessLevel_whenSeven_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, AccessUtil.accessLevel(7));
  }

  /**
   * Test {@link AccessUtil#accessLevel(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accessLevel(int)}
   */
  @Test
  @DisplayName("Test accessLevel(int); when two; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.accessLevel(int)"})
  void testAccessLevel_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, AccessUtil.accessLevel(2));
  }

  /**
   * Test {@link AccessUtil#accessFlags(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accessFlags(int)}
   */
  @Test
  @DisplayName("Test accessFlags(int); when one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.accessFlags(int)"})
  void testAccessFlags_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, AccessUtil.accessFlags(1));
  }

  /**
   * Test {@link AccessUtil#accessFlags(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accessFlags(int)}
   */
  @Test
  @DisplayName("Test accessFlags(int); when three; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.accessFlags(int)"})
  void testAccessFlags_whenThree_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, AccessUtil.accessFlags(3));
  }

  /**
   * Test {@link AccessUtil#accessFlags(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accessFlags(int)}
   */
  @Test
  @DisplayName("Test accessFlags(int); when two; then return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.accessFlags(int)"})
  void testAccessFlags_whenTwo_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, AccessUtil.accessFlags(2));
  }

  /**
   * Test {@link AccessUtil#accessFlags(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accessFlags(int)}
   */
  @Test
  @DisplayName("Test accessFlags(int); when zero; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.accessFlags(int)"})
  void testAccessFlags_whenZero_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, AccessUtil.accessFlags(0));
  }

  /**
   * Test {@link AccessUtil#replaceAccessFlags(int, int)}.
   *
   * <ul>
   *   <li>When minus eight.
   *   <li>Then return minus five.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#replaceAccessFlags(int, int)}
   */
  @Test
  @DisplayName("Test replaceAccessFlags(int, int); when minus eight; then return minus five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.replaceAccessFlags(int, int)"})
  void testReplaceAccessFlags_whenMinusEight_thenReturnMinusFive() {
    // Arrange, Act and Assert
    assertEquals(-5, AccessUtil.replaceAccessFlags(-8, 3));
  }

  /**
   * Test {@link AccessUtil#replaceAccessFlags(int, int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#replaceAccessFlags(int, int)}
   */
  @Test
  @DisplayName("Test replaceAccessFlags(int, int); when seven; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.replaceAccessFlags(int, int)"})
  void testReplaceAccessFlags_whenSeven_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, AccessUtil.replaceAccessFlags(7, 3));
  }

  /**
   * Test {@link AccessUtil#replaceAccessFlags(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#replaceAccessFlags(int, int)}
   */
  @Test
  @DisplayName("Test replaceAccessFlags(int, int); when three; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.replaceAccessFlags(int, int)"})
  void testReplaceAccessFlags_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, AccessUtil.replaceAccessFlags(3, 3));
  }

  /**
   * Test {@link AccessUtil#replaceAccessFlags(int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#replaceAccessFlags(int, int)}
   */
  @Test
  @DisplayName("Test replaceAccessFlags(int, int); when two; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.AccessUtil.replaceAccessFlags(int, int)"})
  void testReplaceAccessFlags_whenTwo_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, AccessUtil.replaceAccessFlags(3, 2));
  }

  /**
   * Test {@link AccessUtil#accepted(int, int, int)}.
   *
   * <ul>
   *   <li>When minus eight.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accepted(int, int, int)}
   */
  @Test
  @DisplayName("Test accepted(int, int, int); when minus eight; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.AccessUtil.accepted(int, int, int)"})
  void testAccepted_whenMinusEight_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AccessUtil.accepted(-8, 1, 1));
  }

  /**
   * Test {@link AccessUtil#accepted(int, int, int)}.
   *
   * <ul>
   *   <li>When minus eight.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accepted(int, int, int)}
   */
  @Test
  @DisplayName("Test accepted(int, int, int); when minus eight; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.AccessUtil.accepted(int, int, int)"})
  void testAccepted_whenMinusEight_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(AccessUtil.accepted(1, -8, 1));
  }

  /**
   * Test {@link AccessUtil#accepted(int, int, int)}.
   *
   * <ul>
   *   <li>When minus eight.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accepted(int, int, int)}
   */
  @Test
  @DisplayName("Test accepted(int, int, int); when minus eight; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.AccessUtil.accepted(int, int, int)"})
  void testAccepted_whenMinusEight_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AccessUtil.accepted(1, 1, -8));
  }

  /**
   * Test {@link AccessUtil#accepted(int, int, int)}.
   *
   * <ul>
   *   <li>When minus eight.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accepted(int, int, int)}
   */
  @Test
  @DisplayName("Test accepted(int, int, int); when minus eight; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.AccessUtil.accepted(int, int, int)"})
  void testAccepted_whenMinusEight_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(AccessUtil.accepted(-8, -8, 1));
  }

  /**
   * Test {@link AccessUtil#accepted(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccessUtil#accepted(int, int, int)}
   */
  @Test
  @DisplayName("Test accepted(int, int, int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.AccessUtil.accepted(int, int, int)"})
  void testAccepted_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AccessUtil.accepted(1, 1, 1));
  }
}

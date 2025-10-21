package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AccessUtilDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.accessLevel(int)"})
  public void testAccessLevel_whenFour_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.accessLevel(int)"})
  public void testAccessLevel_whenOne_thenReturnThree() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.accessLevel(int)"})
  public void testAccessLevel_whenSeven_thenReturnOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.accessLevel(int)"})
  public void testAccessLevel_whenTwo_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.accessFlags(int)"})
  public void testAccessFlags_whenOne_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.accessFlags(int)"})
  public void testAccessFlags_whenThree_thenReturnOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.accessFlags(int)"})
  public void testAccessFlags_whenTwo_thenReturnFour() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.accessFlags(int)"})
  public void testAccessFlags_whenZero_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.replaceAccessFlags(int, int)"})
  public void testReplaceAccessFlags_whenMinusEight_thenReturnMinusFive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.replaceAccessFlags(int, int)"})
  public void testReplaceAccessFlags_whenSeven_thenReturnThree() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.replaceAccessFlags(int, int)"})
  public void testReplaceAccessFlags_whenThree_thenReturnThree() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccessUtil.replaceAccessFlags(int, int)"})
  public void testReplaceAccessFlags_whenTwo_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccessUtil.accepted(int, int, int)"})
  public void testAccepted_whenMinusEight_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccessUtil.accepted(int, int, int)"})
  public void testAccepted_whenMinusEight_thenReturnFalse2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccessUtil.accepted(int, int, int)"})
  public void testAccepted_whenMinusEight_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccessUtil.accepted(int, int, int)"})
  public void testAccepted_whenMinusEight_thenReturnTrue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccessUtil.accepted(int, int, int)"})
  public void testAccepted_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AccessUtil.accepted(1, 1, 1));
  }
}

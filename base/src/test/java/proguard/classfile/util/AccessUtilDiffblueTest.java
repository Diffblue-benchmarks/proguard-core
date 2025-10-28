package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AccessUtilDiffblueTest {
  /**
   * Method under test: {@link AccessUtil#accessLevel(int)}
   */
  @Test
  public void testAccessLevel() {
    // Arrange, Act and Assert
    assertEquals(3, AccessUtil.accessLevel(1));
    assertEquals(1, AccessUtil.accessLevel(7));
    assertEquals(0, AccessUtil.accessLevel(2));
    assertEquals(2, AccessUtil.accessLevel(4));
  }

  /**
   * Method under test: {@link AccessUtil#accessFlags(int)}
   */
  @Test
  public void testAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(0, AccessUtil.accessFlags(1));
    assertEquals(2, AccessUtil.accessFlags(0));
    assertEquals(4, AccessUtil.accessFlags(2));
    assertEquals(1, AccessUtil.accessFlags(3));
  }

  /**
   * Method under test: {@link AccessUtil#replaceAccessFlags(int, int)}
   */
  @Test
  public void testReplaceAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(3, AccessUtil.replaceAccessFlags(3, 3));
    assertEquals(2, AccessUtil.replaceAccessFlags(3, 2));
    assertEquals(-5, AccessUtil.replaceAccessFlags(-8, 3));
    assertEquals(3, AccessUtil.replaceAccessFlags(7, 3));
  }

  /**
   * Method under test: {@link AccessUtil#accepted(int, int, int)}
   */
  @Test
  public void testAccepted() {
    // Arrange, Act and Assert
    assertFalse(AccessUtil.accepted(1, 1, 1));
    assertFalse(AccessUtil.accepted(-8, 1, 1));
    assertFalse(AccessUtil.accepted(1, -8, 1));
    assertTrue(AccessUtil.accepted(1, 1, -8));
    assertTrue(AccessUtil.accepted(-8, -8, 1));
  }
}

package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LocalVariableInfoDiffblueTest {
  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(0, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo2() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo()));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo3() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo();

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo4() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 1, 1, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo5() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 3, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo6() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 0, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo7() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 3, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo8() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 0, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo9() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 3);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo10() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 0);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo11() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 1, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableInfo#LocalVariableInfo()}
   */
  @Test
  public void testNewLocalVariableInfo() {
    // Arrange and Act
    LocalVariableInfo actualLocalVariableInfo = new LocalVariableInfo();

    // Assert
    assertNull(actualLocalVariableInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableInfo.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link LocalVariableInfo#LocalVariableInfo(int, int, int, int, int)}
   */
  @Test
  public void testNewLocalVariableInfo2() {
    // Arrange and Act
    LocalVariableInfo actualLocalVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Assert
    assertNull(actualLocalVariableInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableInfo.getProcessingFlags());
  }
}

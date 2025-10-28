package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LocalVariableTypeInfoDiffblueTest {
  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(0, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo2() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo()));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo3() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo();

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo4() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 1, 1, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo5() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 3, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo6() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 0, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo7() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 3, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo8() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 0, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo9() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 3);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo10() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 0);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  public void testCompareTo11() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 1, 1, 1, 1)));
  }

  /**
   * Method under test: {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}
   */
  @Test
  public void testNewLocalVariableTypeInfo() {
    // Arrange and Act
    LocalVariableTypeInfo actualLocalVariableTypeInfo = new LocalVariableTypeInfo();

    // Assert
    assertNull(actualLocalVariableTypeInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeInfo.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link LocalVariableTypeInfo#LocalVariableTypeInfo(int, int, int, int, int)}
   */
  @Test
  public void testNewLocalVariableTypeInfo2() {
    // Arrange and Act
    LocalVariableTypeInfo actualLocalVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Assert
    assertNull(actualLocalVariableTypeInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeInfo.getProcessingFlags());
  }
}

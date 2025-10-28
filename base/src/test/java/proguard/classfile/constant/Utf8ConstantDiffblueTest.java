package proguard.classfile.constant;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class Utf8ConstantDiffblueTest {
  /**
   * Method under test: {@link Utf8Constant#setBytes(byte[])}
   */
  @Test
  public void testSetBytes() throws UnsupportedEncodingException {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");

    // Act
    utf8Constant.setBytes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("AXAXAXAX", utf8Constant.getString());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, utf8Constant.getBytes());
  }

  /**
   * Method under test: {@link Utf8Constant#setBytes(byte[])}
   */
  @Test
  public void testSetBytes2() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");

    // Act
    utf8Constant.setBytes(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("XAXAX", utf8Constant.getString());
    assertArrayEquals(new byte[]{-17, -104, -127, 'X', 'A', 'X', 'A', 'X'}, utf8Constant.getBytes());
  }

  /**
   * Method under test: {@link Utf8Constant#getBytes()}
   */
  @Test
  public void testGetBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = (new Utf8Constant("String")).getBytes();

    // Assert
    assertArrayEquals("String".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Method under test: {@link Utf8Constant#getBytes()}
   */
  @Test
  public void testGetBytes2() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");
    utf8Constant.setBytes(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertArrayEquals(new byte[]{-17, -104, -127, 'X', 'A', 'X', 'A', 'X'}, utf8Constant.getBytes());
  }

  /**
   * Method under test: {@link Utf8Constant#getBytes()}
   */
  @Test
  public void testGetBytes3() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");
    utf8Constant.setBytes(new byte[]{-1, 'X', 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertArrayEquals(new byte[]{-17, -104, -127, -64, Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}, utf8Constant.getBytes());
  }

  /**
   * Method under test: {@link Utf8Constant#getBytes()}
   */
  @Test
  public void testGetBytes4() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");
    utf8Constant.setBytes(new byte[]{-1, 'X', 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertArrayEquals(new byte[]{-17, -104, -127, -62, Byte.MIN_VALUE, 'A', 'X', 'A', 'X'}, utf8Constant.getBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Utf8Constant#equals(Object)}
   *   <li>{@link Utf8Constant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");
    Utf8Constant utf8Constant2 = new Utf8Constant("String");

    // Act and Assert
    assertEquals(utf8Constant, utf8Constant2);
    int expectedHashCodeResult = utf8Constant.hashCode();
    assertEquals(expectedHashCodeResult, utf8Constant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Utf8Constant#equals(Object)}
   *   <li>{@link Utf8Constant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");

    // Act and Assert
    assertEquals(utf8Constant, utf8Constant);
    int expectedHashCodeResult = utf8Constant.hashCode();
    assertEquals(expectedHashCodeResult, utf8Constant.hashCode());
  }

  /**
   * Method under test: {@link Utf8Constant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("proguard.classfile.constant.Utf8Constant");

    // Act and Assert
    assertNotEquals(utf8Constant, new Utf8Constant("String"));
  }

  /**
   * Method under test: {@link Utf8Constant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Utf8Constant("String"), null);
  }

  /**
   * Method under test: {@link Utf8Constant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Utf8Constant("String"), "Different type to Utf8Constant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Utf8Constant#Utf8Constant()}
   *   <li>{@link Utf8Constant#setString(String)}
   *   <li>{@link Utf8Constant#toString()}
   *   <li>{@link Utf8Constant#getString()}
   *   <li>{@link Utf8Constant#getTag()}
   *   <li>{@link Utf8Constant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Utf8Constant actualUtf8Constant = new Utf8Constant();
    actualUtf8Constant.setString("Utf8 String");
    String actualToStringResult = actualUtf8Constant.toString();
    String actualString = actualUtf8Constant.getString();
    int actualTag = actualUtf8Constant.getTag();
    boolean actualIsCategory2Result = actualUtf8Constant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Utf8 String", actualString);
    assertEquals("Utf8(Utf8 String)", actualToStringResult);
    assertEquals(0, actualUtf8Constant.getProcessingFlags());
    assertEquals(1, actualTag);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Utf8Constant#Utf8Constant(String)}
   *   <li>{@link Utf8Constant#setString(String)}
   *   <li>{@link Utf8Constant#toString()}
   *   <li>{@link Utf8Constant#getString()}
   *   <li>{@link Utf8Constant#getTag()}
   *   <li>{@link Utf8Constant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    Utf8Constant actualUtf8Constant = new Utf8Constant("String");
    actualUtf8Constant.setString("Utf8 String");
    String actualToStringResult = actualUtf8Constant.toString();
    String actualString = actualUtf8Constant.getString();
    int actualTag = actualUtf8Constant.getTag();
    boolean actualIsCategory2Result = actualUtf8Constant.isCategory2();

    // Assert that nothing has changed
    assertEquals("Utf8 String", actualString);
    assertEquals("Utf8(Utf8 String)", actualToStringResult);
    assertEquals(0, actualUtf8Constant.getProcessingFlags());
    assertEquals(1, actualTag);
    assertFalse(actualIsCategory2Result);
  }
}

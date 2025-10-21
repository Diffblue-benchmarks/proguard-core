package proguard.classfile.constant;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Utf8ConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Utf8Constant.<init>()",
    "void Utf8Constant.<init>(String)",
    "String Utf8Constant.getString()",
    "int Utf8Constant.getTag()",
    "boolean Utf8Constant.isCategory2()",
    "void Utf8Constant.setString(String)",
    "String Utf8Constant.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Utf8Constant actualUtf8Constant = new Utf8Constant();
    actualUtf8Constant.setString("Utf8 String");
    String actualToStringResult = actualUtf8Constant.toString();
    String actualString = actualUtf8Constant.getString();
    int actualTag = actualUtf8Constant.getTag();
    boolean actualIsCategory2Result = actualUtf8Constant.isCategory2();

    // Assert
    assertEquals("Utf8 String", actualString);
    assertEquals("Utf8(Utf8 String)", actualToStringResult);
    assertNull(actualUtf8Constant.getProcessingInfo());
    assertEquals(0, actualUtf8Constant.getProcessingFlags());
    assertEquals(1, actualTag);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code String}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Utf8Constant.<init>()",
    "void Utf8Constant.<init>(String)",
    "String Utf8Constant.getString()",
    "int Utf8Constant.getTag()",
    "boolean Utf8Constant.isCategory2()",
    "void Utf8Constant.setString(String)",
    "String Utf8Constant.toString()"
  })
  public void testGettersAndSetters_whenString() {
    // Arrange and Act
    Utf8Constant actualUtf8Constant = new Utf8Constant("String");
    actualUtf8Constant.setString("Utf8 String");
    String actualToStringResult = actualUtf8Constant.toString();
    String actualString = actualUtf8Constant.getString();
    int actualTag = actualUtf8Constant.getTag();
    boolean actualIsCategory2Result = actualUtf8Constant.isCategory2();

    // Assert
    assertEquals("Utf8 String", actualString);
    assertEquals("Utf8(Utf8 String)", actualToStringResult);
    assertNull(actualUtf8Constant.getProcessingInfo());
    assertEquals(0, actualUtf8Constant.getProcessingFlags());
    assertEquals(1, actualTag);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link Utf8Constant#setBytes(byte[])}.
   *
   * <ul>
   *   <li>Then {@link Utf8Constant#Utf8Constant(String)} with {@code String} String is {@code
   *       XAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#setBytes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Utf8Constant.setBytes(byte[])"})
  public void testSetBytes_thenUtf8ConstantWithStringStringIsXaxax() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");

    // Act
    utf8Constant.setBytes(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("XAXAX", utf8Constant.getString());
    assertArrayEquals(
        new byte[] {-17, -104, -127, 'X', 'A', 'X', 'A', 'X'}, utf8Constant.getBytes());
  }

  /**
   * Test {@link Utf8Constant#setBytes(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then {@link Utf8Constant#Utf8Constant(String)} with {@code String} String is {@code
   *       AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#setBytes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Utf8Constant.setBytes(byte[])"})
  public void testSetBytes_whenAxaxaxaxBytesIsUtf8_thenUtf8ConstantWithStringStringIsAxaxaxax()
      throws UnsupportedEncodingException {
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
   * Test {@link Utf8Constant#getBytes()}.
   *
   * <ul>
   *   <li>Given {@link Utf8Constant#Utf8Constant(String)} with {@code String}.
   *   <li>Then return {@code String} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#getBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Utf8Constant.getBytes()"})
  public void testGetBytes_givenUtf8ConstantWithString_thenReturnStringBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = (new Utf8Constant("String")).getBytes();

    // Assert
    assertArrayEquals("String".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Test {@link Utf8Constant#getBytes()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus seventeen and minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#getBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Utf8Constant.getBytes()"})
  public void testGetBytes_thenReturnArrayOfByteWithMinusSeventeenAndMinusOneHundredFour() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");
    utf8Constant.setBytes(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertArrayEquals(
        new byte[] {-17, -104, -127, 'X', 'A', 'X', 'A', 'X'}, utf8Constant.getBytes());
  }

  /**
   * Test {@link Utf8Constant#getBytes()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus seventeen and minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#getBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Utf8Constant.getBytes()"})
  public void testGetBytes_thenReturnArrayOfByteWithMinusSeventeenAndMinusOneHundredFour2() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");
    utf8Constant.setBytes(new byte[] {-1, 'X', 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertArrayEquals(
        new byte[] {-17, -104, -127, -64, Byte.MIN_VALUE, 'A', 'X', 'A', 'X'},
        utf8Constant.getBytes());
  }

  /**
   * Test {@link Utf8Constant#getBytes()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus seventeen and minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#getBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Utf8Constant.getBytes()"})
  public void testGetBytes_thenReturnArrayOfByteWithMinusSeventeenAndMinusOneHundredFour3() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");
    utf8Constant.setBytes(new byte[] {-1, 'X', 'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertArrayEquals(
        new byte[] {-17, -104, -127, -62, Byte.MIN_VALUE, 'A', 'X', 'A', 'X'},
        utf8Constant.getBytes());
  }

  /**
   * Test {@link Utf8Constant#equals(Object)}, and {@link Utf8Constant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Utf8Constant#equals(Object)}
   *   <li>{@link Utf8Constant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Utf8Constant.equals(Object)", "int Utf8Constant.hashCode()"})
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
   * Test {@link Utf8Constant#equals(Object)}, and {@link Utf8Constant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Utf8Constant#equals(Object)}
   *   <li>{@link Utf8Constant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Utf8Constant.equals(Object)", "int Utf8Constant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("String");

    // Act and Assert
    assertEquals(utf8Constant, utf8Constant);
    int expectedHashCodeResult = utf8Constant.hashCode();
    assertEquals(expectedHashCodeResult, utf8Constant.hashCode());
  }

  /**
   * Test {@link Utf8Constant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Utf8Constant.equals(Object)", "int Utf8Constant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Utf8Constant utf8Constant = new Utf8Constant("proguard.classfile.constant.Utf8Constant");

    // Act and Assert
    assertNotEquals(utf8Constant, new Utf8Constant("String"));
  }

  /**
   * Test {@link Utf8Constant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Utf8Constant.equals(Object)", "int Utf8Constant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Utf8Constant("String"), null);
  }

  /**
   * Test {@link Utf8Constant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Utf8Constant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Utf8Constant.equals(Object)", "int Utf8Constant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Utf8Constant("String"), "Different type to Utf8Constant");
  }
}

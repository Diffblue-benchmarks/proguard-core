package proguard.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ArrayUtilDiffblueTest {
  /**
   * Test {@link ArrayUtil#indexOf(boolean[], int, boolean)} with {@code boolean[]}, {@code int},
   * {@code boolean}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(boolean[], int, boolean)}
   */
  @Test
  @DisplayName(
      "Test indexOf(boolean[], int, boolean) with 'boolean[]', 'int', 'boolean'; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(boolean[], int, boolean)"})
  void testIndexOfWithBooleanIntBoolean_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, ArrayUtil.indexOf(new boolean[] {false, false, true, false}, 3, true));
  }

  /**
   * Test {@link ArrayUtil#indexOf(boolean[], int, boolean)} with {@code boolean[]}, {@code int},
   * {@code boolean}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(boolean[], int, boolean)}
   */
  @Test
  @DisplayName(
      "Test indexOf(boolean[], int, boolean) with 'boolean[]', 'int', 'boolean'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(boolean[], int, boolean)"})
  void testIndexOfWithBooleanIntBoolean_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf(new boolean[] {true, false, true, false}, 3, true));
  }

  /**
   * Test {@link ArrayUtil#indexOf(boolean[], int, boolean)} with {@code boolean[]}, {@code int},
   * {@code boolean}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(boolean[], int, boolean)}
   */
  @Test
  @DisplayName(
      "Test indexOf(boolean[], int, boolean) with 'boolean[]', 'int', 'boolean'; when zero; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(boolean[], int, boolean)"})
  void testIndexOfWithBooleanIntBoolean_whenZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.indexOf(new boolean[] {true, false, true, false}, 0, true));
  }

  /**
   * Test {@link ArrayUtil#indexOf(byte[], int, byte)} with {@code byte[]}, {@code int}, {@code
   * byte}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@code X}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(byte[], int, byte)}
   */
  @Test
  @DisplayName(
      "Test indexOf(byte[], int, byte) with 'byte[]', 'int', 'byte'; when array of byte with 'A' and 'X'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(byte[], int, byte)"})
  void testIndexOfWithByteIntByte_whenArrayOfByteWithAAndX_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1, ArrayUtil.indexOf(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, (byte) 'A'));
  }

  /**
   * Test {@link ArrayUtil#indexOf(byte[], int, byte)} with {@code byte[]}, {@code int}, {@code
   * byte}.
   *
   * <ul>
   *   <li>When array of {@code byte} with three and {@code X}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(byte[], int, byte)}
   */
  @Test
  @DisplayName(
      "Test indexOf(byte[], int, byte) with 'byte[]', 'int', 'byte'; when array of byte with three and 'X'; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(byte[], int, byte)"})
  void testIndexOfWithByteIntByte_whenArrayOfByteWithThreeAndX_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(
        2, ArrayUtil.indexOf(new byte[] {3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 3, (byte) 'A'));
  }

  /**
   * Test {@link ArrayUtil#indexOf(byte[], int, byte)} with {@code byte[]}, {@code int}, {@code
   * byte}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(byte[], int, byte)}
   */
  @Test
  @DisplayName(
      "Test indexOf(byte[], int, byte) with 'byte[]', 'int', 'byte'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(byte[], int, byte)"})
  void testIndexOfWithByteIntByte_whenAxaxaxaxBytesIsUtf8_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf("AXAXAXAX".getBytes("UTF-8"), 3, (byte) 'A'));
  }

  /**
   * Test {@link ArrayUtil#indexOf(char[], int, char)} with {@code char[]}, {@code int}, {@code
   * char}.
   *
   * <ul>
   *   <li>When array of {@code char} with {@code A} and {@code Z}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(char[], int, char)}
   */
  @Test
  @DisplayName(
      "Test indexOf(char[], int, char) with 'char[]', 'int', 'char'; when array of char with 'A' and 'Z'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(char[], int, char)"})
  void testIndexOfWithCharIntChar_whenArrayOfCharWithAAndZ_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.indexOf(new char[] {'A', 'Z', 'A', 'Z'}, 0, 'A'));
  }

  /**
   * Test {@link ArrayUtil#indexOf(char[], int, char)} with {@code char[]}, {@code int}, {@code
   * char}.
   *
   * <ul>
   *   <li>When {@code AZAZ} toCharArray.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(char[], int, char)}
   */
  @Test
  @DisplayName(
      "Test indexOf(char[], int, char) with 'char[]', 'int', 'char'; when 'AZAZ' toCharArray; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(char[], int, char)"})
  void testIndexOfWithCharIntChar_whenAzazToCharArray_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf("AZAZ".toCharArray(), 3, 'A'));
  }

  /**
   * Test {@link ArrayUtil#indexOf(char[], int, char)} with {@code char[]}, {@code int}, {@code
   * char}.
   *
   * <ul>
   *   <li>When {@code ZAZ} toCharArray.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(char[], int, char)}
   */
  @Test
  @DisplayName(
      "Test indexOf(char[], int, char) with 'char[]', 'int', 'char'; when 'ZAZ' toCharArray; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(char[], int, char)"})
  void testIndexOfWithCharIntChar_whenZazToCharArray_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, ArrayUtil.indexOf("\u0003ZAZ".toCharArray(), 3, 'A'));
  }

  /**
   * Test {@link ArrayUtil#indexOf(double[], int, double)} with {@code double[]}, {@code int},
   * {@code double}.
   *
   * <ul>
   *   <li>When array of {@code double} with one and one.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(double[], int, double)}
   */
  @Test
  @DisplayName(
      "Test indexOf(double[], int, double) with 'double[]', 'int', 'double'; when array of double with one and one; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(double[], int, double)"})
  void testIndexOfWithDoubleIntDouble_whenArrayOfDoubleWithOneAndOne_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, ArrayUtil.indexOf(new double[] {1.0d, 1.0d, 10.0d, 1.0d}, 3, 10.0d));
  }

  /**
   * Test {@link ArrayUtil#indexOf(double[], int, double)} with {@code double[]}, {@code int},
   * {@code double}.
   *
   * <ul>
   *   <li>When array of {@code double} with ten and one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(double[], int, double)}
   */
  @Test
  @DisplayName(
      "Test indexOf(double[], int, double) with 'double[]', 'int', 'double'; when array of double with ten and one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(double[], int, double)"})
  void testIndexOfWithDoubleIntDouble_whenArrayOfDoubleWithTenAndOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf(new double[] {10.0d, 1.0d, 10.0d, 1.0d}, 3, 10.0d));
  }

  /**
   * Test {@link ArrayUtil#indexOf(double[], int, double)} with {@code double[]}, {@code int},
   * {@code double}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(double[], int, double)}
   */
  @Test
  @DisplayName(
      "Test indexOf(double[], int, double) with 'double[]', 'int', 'double'; when zero; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(double[], int, double)"})
  void testIndexOfWithDoubleIntDouble_whenZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.indexOf(new double[] {10.0d, 1.0d, 10.0d, 1.0d}, 0, 10.0d));
  }

  /**
   * Test {@link ArrayUtil#indexOf(float[], int, float)} with {@code float[]}, {@code int}, {@code
   * float}.
   *
   * <ul>
   *   <li>When array of {@code float} with ten and zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(float[], int, float)}
   */
  @Test
  @DisplayName(
      "Test indexOf(float[], int, float) with 'float[]', 'int', 'float'; when array of float with ten and zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(float[], int, float)"})
  void testIndexOfWithFloatIntFloat_whenArrayOfFloatWithTenAndZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf(new float[] {10.0f, 0.0f, 10.0f, 0.0f}, 3, 10.0f));
  }

  /**
   * Test {@link ArrayUtil#indexOf(float[], int, float)} with {@code float[]}, {@code int}, {@code
   * float}.
   *
   * <ul>
   *   <li>When array of {@code float} with zero and zero.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(float[], int, float)}
   */
  @Test
  @DisplayName(
      "Test indexOf(float[], int, float) with 'float[]', 'int', 'float'; when array of float with zero and zero; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(float[], int, float)"})
  void testIndexOfWithFloatIntFloat_whenArrayOfFloatWithZeroAndZero_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, ArrayUtil.indexOf(new float[] {0.0f, 0.0f, 10.0f, 0.0f}, 3, 10.0f));
  }

  /**
   * Test {@link ArrayUtil#indexOf(float[], int, float)} with {@code float[]}, {@code int}, {@code
   * float}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(float[], int, float)}
   */
  @Test
  @DisplayName(
      "Test indexOf(float[], int, float) with 'float[]', 'int', 'float'; when zero; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(float[], int, float)"})
  void testIndexOfWithFloatIntFloat_whenZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.indexOf(new float[] {10.0f, 0.0f, 10.0f, 0.0f}, 0, 10.0f));
  }

  /**
   * Test {@link ArrayUtil#indexOf(int[], int, int)} with {@code int[]}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code int} with forty-two and zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(int[], int, int)}
   */
  @Test
  @DisplayName(
      "Test indexOf(int[], int, int) with 'int[]', 'int', 'int'; when array of int with forty-two and zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(int[], int, int)"})
  void testIndexOfWithIntIntInt_whenArrayOfIntWithFortyTwoAndZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf(new int[] {42, 0, 1, 0}, 3, 42));
  }

  /**
   * Test {@link ArrayUtil#indexOf(int[], int, int)} with {@code int[]}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code int} with one and zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(int[], int, int)}
   */
  @Test
  @DisplayName(
      "Test indexOf(int[], int, int) with 'int[]', 'int', 'int'; when array of int with one and zero; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(int[], int, int)"})
  void testIndexOfWithIntIntInt_whenArrayOfIntWithOneAndZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.indexOf(new int[] {1, 0, 1, 0}, 3, 42));
  }

  /**
   * Test {@link ArrayUtil#indexOf(long[], int, long)} with {@code long[]}, {@code int}, {@code
   * long}.
   *
   * <ul>
   *   <li>When array of {@code long} with forty-two and zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(long[], int, long)}
   */
  @Test
  @DisplayName(
      "Test indexOf(long[], int, long) with 'long[]', 'int', 'long'; when array of long with forty-two and zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(long[], int, long)"})
  void testIndexOfWithLongIntLong_whenArrayOfLongWithFortyTwoAndZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf(new long[] {42L, 0L, 1L, 0L}, 3, 42L));
  }

  /**
   * Test {@link ArrayUtil#indexOf(long[], int, long)} with {@code long[]}, {@code int}, {@code
   * long}.
   *
   * <ul>
   *   <li>When array of {@code long} with one and zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(long[], int, long)}
   */
  @Test
  @DisplayName(
      "Test indexOf(long[], int, long) with 'long[]', 'int', 'long'; when array of long with one and zero; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(long[], int, long)"})
  void testIndexOfWithLongIntLong_whenArrayOfLongWithOneAndZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.indexOf(new long[] {1L, 0L, 1L, 0L}, 3, 42L));
  }

  /**
   * Test {@link ArrayUtil#indexOf(Object[], int, Object)} with {@code Object[]}, {@code int},
   * {@code Object}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test indexOf(Object[], int, Object) with 'Object[]', 'int', 'Object'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.util.ArrayUtil.indexOf(java.lang.Object[], int, java.lang.Object)"
  })
  void testIndexOfWithObjectIntObject_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.indexOf(new Object[] {"Array", "Array", "Array"}, 3, "Value"));
  }

  /**
   * Test {@link ArrayUtil#indexOf(Object[], int, Object)} with {@code Object[]}, {@code int},
   * {@code Object}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Value}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test indexOf(Object[], int, Object) with 'Object[]', 'int', 'Object'; when array of Object with 'Value'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.util.ArrayUtil.indexOf(java.lang.Object[], int, java.lang.Object)"
  })
  void testIndexOfWithObjectIntObject_whenArrayOfObjectWithValue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf(new Object[] {"Value"}, 3, "Value"));
  }

  /**
   * Test {@link ArrayUtil#indexOf(short[], int, short)} with {@code short[]}, {@code int}, {@code
   * short}.
   *
   * <ul>
   *   <li>When array of {@code short} with one and thirty-one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(short[], int, short)}
   */
  @Test
  @DisplayName(
      "Test indexOf(short[], int, short) with 'short[]', 'int', 'short'; when array of short with one and thirty-one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(short[], int, short)"})
  void testIndexOfWithShortIntShort_whenArrayOfShortWithOneAndThirtyOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf(new short[] {1, 31, 1, 31}, 3, (short) 1));
  }

  /**
   * Test {@link ArrayUtil#indexOf(short[], int, short)} with {@code short[]}, {@code int}, {@code
   * short}.
   *
   * <ul>
   *   <li>When array of {@code short} with three and thirty-one.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(short[], int, short)}
   */
  @Test
  @DisplayName(
      "Test indexOf(short[], int, short) with 'short[]', 'int', 'short'; when array of short with three and thirty-one; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(short[], int, short)"})
  void testIndexOfWithShortIntShort_whenArrayOfShortWithThreeAndThirtyOne_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, ArrayUtil.indexOf(new short[] {3, 31, 1, 31}, 3, (short) 1));
  }

  /**
   * Test {@link ArrayUtil#indexOf(short[], int, short)} with {@code short[]}, {@code int}, {@code
   * short}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#indexOf(short[], int, short)}
   */
  @Test
  @DisplayName(
      "Test indexOf(short[], int, short) with 'short[]', 'int', 'short'; when zero; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.indexOf(short[], int, short)"})
  void testIndexOfWithShortIntShort_whenZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.indexOf(new short[] {1, 31, 1, 31}, 0, (short) 1));
  }

  /**
   * Test {@link ArrayUtil#equal(boolean[], boolean[], int)} with {@code boolean[]}, {@code
   * boolean[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(boolean[], boolean[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(boolean[], boolean[], int) with 'boolean[]', 'boolean[]', 'int'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(boolean[], boolean[], int)"})
  void testEqualWithBooleanBooleanInt_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        ArrayUtil.equal(
            new boolean[] {false, false, true, false},
            new boolean[] {true, false, true, false},
            3));
  }

  /**
   * Test {@link ArrayUtil#equal(boolean[], boolean[], int)} with {@code boolean[]}, {@code
   * boolean[]}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(boolean[], boolean[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(boolean[], boolean[], int) with 'boolean[]', 'boolean[]', 'int'; when three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(boolean[], boolean[], int)"})
  void testEqualWithBooleanBooleanInt_whenThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ArrayUtil.equal(
            new boolean[] {true, false, true, false}, new boolean[] {true, false, true, false}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(byte[], byte[], int)} with {@code byte[]}, {@code byte[]}, {@code
   * int}.
   *
   * <ul>
   *   <li>When array of {@code byte} with three and {@code X}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(byte[], byte[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(byte[], byte[], int) with 'byte[]', 'byte[]', 'int'; when array of byte with three and 'X'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(byte[], byte[], int)"})
  void testEqualWithByteByteInt_whenArrayOfByteWithThreeAndX_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        ArrayUtil.equal(
            new byte[] {3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test {@link ArrayUtil#equal(byte[], byte[], int)} with {@code byte[]}, {@code byte[]}, {@code
   * int}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(byte[], byte[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(byte[], byte[], int) with 'byte[]', 'byte[]', 'int'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(byte[], byte[], int)"})
  void testEqualWithByteByteInt_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] array1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ArrayUtil.equal(array1, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test {@link ArrayUtil#equal(char[], char[], int)} with {@code char[]}, {@code char[]}, {@code
   * int}.
   *
   * <ul>
   *   <li>When {@code AZAZ} toCharArray.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(char[], char[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(char[], char[], int) with 'char[]', 'char[]', 'int'; when 'AZAZ' toCharArray; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(char[], char[], int)"})
  void testEqualWithCharCharInt_whenAzazToCharArray_thenReturnTrue() {
    // Arrange
    char[] array1 = "AZAZ".toCharArray();

    // Act and Assert
    assertTrue(ArrayUtil.equal(array1, "AZAZ".toCharArray(), 3));
  }

  /**
   * Test {@link ArrayUtil#equal(char[], char[], int)} with {@code char[]}, {@code char[]}, {@code
   * int}.
   *
   * <ul>
   *   <li>When {@code ZAZ} toCharArray.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(char[], char[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(char[], char[], int) with 'char[]', 'char[]', 'int'; when 'ZAZ' toCharArray; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(char[], char[], int)"})
  void testEqualWithCharCharInt_whenZazToCharArray_thenReturnFalse() {
    // Arrange
    char[] array1 = "\u0003ZAZ".toCharArray();

    // Act and Assert
    assertFalse(ArrayUtil.equal(array1, "AZAZ".toCharArray(), 3));
  }

  /**
   * Test {@link ArrayUtil#equal(double[], double[], int)} with {@code double[]}, {@code double[]},
   * {@code int}.
   *
   * <ul>
   *   <li>When array of {@code double} with one and one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(double[], double[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(double[], double[], int) with 'double[]', 'double[]', 'int'; when array of double with one and one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(double[], double[], int)"})
  void testEqualWithDoubleDoubleInt_whenArrayOfDoubleWithOneAndOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        ArrayUtil.equal(
            new double[] {1.0d, 1.0d, 10.0d, 1.0d}, new double[] {10.0d, 1.0d, 10.0d, 1.0d}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(double[], double[], int)} with {@code double[]}, {@code double[]},
   * {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(double[], double[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(double[], double[], int) with 'double[]', 'double[]', 'int'; when three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(double[], double[], int)"})
  void testEqualWithDoubleDoubleInt_whenThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ArrayUtil.equal(
            new double[] {10.0d, 1.0d, 10.0d, 1.0d}, new double[] {10.0d, 1.0d, 10.0d, 1.0d}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(float[], float[], int)} with {@code float[]}, {@code float[]},
   * {@code int}.
   *
   * <ul>
   *   <li>When array of {@code float} with zero and zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(float[], float[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(float[], float[], int) with 'float[]', 'float[]', 'int'; when array of float with zero and zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(float[], float[], int)"})
  void testEqualWithFloatFloatInt_whenArrayOfFloatWithZeroAndZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        ArrayUtil.equal(
            new float[] {0.0f, 0.0f, 10.0f, 0.0f}, new float[] {10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(float[], float[], int)} with {@code float[]}, {@code float[]},
   * {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(float[], float[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(float[], float[], int) with 'float[]', 'float[]', 'int'; when three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(float[], float[], int)"})
  void testEqualWithFloatFloatInt_whenThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ArrayUtil.equal(
            new float[] {10.0f, 0.0f, 10.0f, 0.0f}, new float[] {10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(int[], int[], int)} with {@code int[]}, {@code int[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code int} with three and zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(int[], int[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(int[], int[], int) with 'int[]', 'int[]', 'int'; when array of int with three and zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(int[], int[], int)"})
  void testEqualWithIntIntInt_whenArrayOfIntWithThreeAndZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new int[] {3, 0, 1, 0}, new int[] {1, 0, 1, 0}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(int[], int[], int)} with {@code int[]}, {@code int[]}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(int[], int[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(int[], int[], int) with 'int[]', 'int[]', 'int'; when three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(int[], int[], int)"})
  void testEqualWithIntIntInt_whenThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(long[], long[], int)} with {@code long[]}, {@code long[]}, {@code
   * int}.
   *
   * <ul>
   *   <li>When array of {@code long} with three and zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(long[], long[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(long[], long[], int) with 'long[]', 'long[]', 'int'; when array of long with three and zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(long[], long[], int)"})
  void testEqualWithLongLongInt_whenArrayOfLongWithThreeAndZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new long[] {3L, 0L, 1L, 0L}, new long[] {1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(long[], long[], int)} with {@code long[]}, {@code long[]}, {@code
   * int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(long[], long[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(long[], long[], int) with 'long[]', 'long[]', 'int'; when three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(long[], long[], int)"})
  void testEqualWithLongLongInt_whenThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new long[] {1L, 0L, 1L, 0L}, new long[] {1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(Object[], Object[], int)} with {@code Object[]}, {@code Object[]},
   * {@code int}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Array1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(Object[], Object[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(Object[], Object[], int) with 'Object[]', 'Object[]', 'int'; when array of Object with 'Array1'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equal(java.lang.Object[], java.lang.Object[], int)"
  })
  void testEqualWithObjectObjectInt_whenArrayOfObjectWithArray1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new Object[] {"Array1"}, new Object[] {"Array2"}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(Object[], Object[], int)} with {@code Object[]}, {@code Object[]},
   * {@code int}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(Object[], Object[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(Object[], Object[], int) with 'Object[]', 'Object[]', 'int'; when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equal(java.lang.Object[], java.lang.Object[], int)"
  })
  void testEqualWithObjectObjectInt_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new Object[] {"Array1"}, new Object[] {"Array2"}, 0));
  }

  /**
   * Test {@link ArrayUtil#equal(short[], short[], int)} with {@code short[]}, {@code short[]},
   * {@code int}.
   *
   * <ul>
   *   <li>When array of {@code short} with three and thirty-one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(short[], short[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(short[], short[], int) with 'short[]', 'short[]', 'int'; when array of short with three and thirty-one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(short[], short[], int)"})
  void testEqualWithShortShortInt_whenArrayOfShortWithThreeAndThirtyOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new short[] {3, 31, 1, 31}, new short[] {1, 31, 1, 31}, 3));
  }

  /**
   * Test {@link ArrayUtil#equal(short[], short[], int)} with {@code short[]}, {@code short[]},
   * {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equal(short[], short[], int)}
   */
  @Test
  @DisplayName(
      "Test equal(short[], short[], int) with 'short[]', 'short[]', 'int'; when three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ArrayUtil.equal(short[], short[], int)"})
  void testEqualWithShortShortInt_whenThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new short[] {1, 31, 1, 31}, new short[] {1, 31, 1, 31}, 3));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[], int)} with {@code array1}, {@code
   * array2}, {@code size}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Array1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[], int)}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[], int) with 'array1', 'array2', 'size'; when array of Object with 'Array1'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[], int)"
  })
  void testEqualOrNullWithArray1Array2Size_whenArrayOfObjectWithArray1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equalOrNull(new Object[] {"Array1"}, new Object[] {"Array2"}, 3));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[], int)} with {@code array1}, {@code
   * array2}, {@code size}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[], int)}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[], int) with 'array1', 'array2', 'size'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[], int)"
  })
  void testEqualOrNullWithArray1Array2Size_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equalOrNull(null, new Object[] {"Array2"}, 3));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[], int)} with {@code array1}, {@code
   * array2}, {@code size}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[], int)}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[], int) with 'array1', 'array2', 'size'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[], int)"
  })
  void testEqualOrNullWithArray1Array2Size_whenNull_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equalOrNull(new Object[] {"Array1"}, null, 3));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[], int)} with {@code array1}, {@code
   * array2}, {@code size}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[], int)}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[], int) with 'array1', 'array2', 'size'; when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[], int)"
  })
  void testEqualOrNullWithArray1Array2Size_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equalOrNull(null, null, 3));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[], int)} with {@code array1}, {@code
   * array2}, {@code size}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[], int)}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[], int) with 'array1', 'array2', 'size'; when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[], int)"
  })
  void testEqualOrNullWithArray1Array2Size_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equalOrNull(new Object[] {"Array1"}, new Object[] {"Array2"}, 0));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[])} with {@code array1}, {@code array2}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Array1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[])}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[]) with 'array1', 'array2'; when array of Object with 'Array1'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[])"
  })
  void testEqualOrNullWithArray1Array2_whenArrayOfObjectWithArray1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equalOrNull(new Object[] {"Array1"}, new Object[] {"Array2"}));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[])} with {@code array1}, {@code array2}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Array1}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[])}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[]) with 'array1', 'array2'; when array of Object with 'Array1'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[])"
  })
  void testEqualOrNullWithArray1Array2_whenArrayOfObjectWithArray1_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equalOrNull(new Object[] {"Array1"}, null));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[])} with {@code array1}, {@code array2}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Array2}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[])}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[]) with 'array1', 'array2'; when array of Object with 'Array2'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[])"
  })
  void testEqualOrNullWithArray1Array2_whenArrayOfObjectWithArray2_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equalOrNull(new Object[] {"Array2"}, new Object[] {"Array2"}));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[])} with {@code array1}, {@code array2}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[])}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[]) with 'array1', 'array2'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[])"
  })
  void testEqualOrNullWithArray1Array2_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equalOrNull(null, new Object[] {"Array2"}));
  }

  /**
   * Test {@link ArrayUtil#equalOrNull(Object[], Object[])} with {@code array1}, {@code array2}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[])}
   */
  @Test
  @DisplayName(
      "Test equalOrNull(Object[], Object[]) with 'array1', 'array2'; when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.util.ArrayUtil.equalOrNull(java.lang.Object[], java.lang.Object[])"
  })
  void testEqualOrNullWithArray1Array2_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equalOrNull(null, null));
  }

  /**
   * Test {@link ArrayUtil#hashCode(boolean[], int)} with {@code boolean[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code boolean} with {@code true} and {@code false}.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(boolean[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCode(boolean[], int) with 'boolean[]', 'int'; when array of boolean with 'true' and 'false'; then return five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(boolean[], int)"})
  void testHashCodeWithBooleanInt_whenArrayOfBooleanWithTrueAndFalse_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5, ArrayUtil.hashCode(new boolean[] {true, false, true, false}, 3));
  }

  /**
   * Test {@link ArrayUtil#hashCode(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return five hundred one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCode(byte[], int) with 'byte[]', 'int'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return five hundred one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(byte[], int)"})
  void testHashCodeWithByteInt_whenAxaxaxaxBytesIsUtf8_thenReturnFiveHundredOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(501, ArrayUtil.hashCode("AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test {@link ArrayUtil#hashCode(char[], int)} with {@code char[]}, {@code int}.
   *
   * <ul>
   *   <li>When {@code AZAZ} toCharArray.
   *   <li>Then return four hundred ninety-seven.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(char[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCode(char[], int) with 'char[]', 'int'; when 'AZAZ' toCharArray; then return four hundred ninety-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(char[], int)"})
  void testHashCodeWithCharInt_whenAzazToCharArray_thenReturnFourHundredNinetySeven() {
    // Arrange, Act and Assert
    assertEquals(497, ArrayUtil.hashCode("AZAZ".toCharArray(), 3));
  }

  /**
   * Test {@link ArrayUtil#hashCode(double[], int)} with {@code double[]}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 1062469633}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(double[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCode(double[], int) with 'double[]', 'int'; when three; then return '1062469633'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(double[], int)"})
  void testHashCodeWithDoubleInt_whenThree_thenReturn1062469633() {
    // Arrange, Act and Assert
    assertEquals(1062469633, ArrayUtil.hashCode(new double[] {10.0d, 1.0d, 10.0d, 1.0d}, 3));
  }

  /**
   * Test {@link ArrayUtil#hashCode(float[], int)} with {@code float[]}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 1168113665}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(float[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCode(float[], int) with 'float[]', 'int'; when three; then return '1168113665'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(float[], int)"})
  void testHashCodeWithFloatInt_whenThree_thenReturn1168113665() {
    // Arrange, Act and Assert
    assertEquals(1168113665, ArrayUtil.hashCode(new float[] {10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Test {@link ArrayUtil#hashCode(int[], int)} with {@code int[]}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 95310073}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(int[], int)}
   */
  @Test
  @DisplayName("Test hashCode(int[], int) with 'int[]', 'int'; when three; then return '95310073'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(int[], int)"})
  void testHashCodeWithIntInt_whenThree_thenReturn95310073() {
    // Arrange, Act and Assert
    assertEquals(95310073, ArrayUtil.hashCode(new int[] {19088743, 1, 19088743, 1}, 3));
  }

  /**
   * Test {@link ArrayUtil#hashCode(long[], int)} with {@code long[]}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code -1358628269}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(long[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCode(long[], int) with 'long[]', 'int'; when three; then return '-1358628269'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(long[], int)"})
  void testHashCodeWithLongInt_whenThree_thenReturn1358628269() {
    // Arrange, Act and Assert
    assertEquals(
        -1358628269,
        ArrayUtil.hashCode(new long[] {81985529216486895L, 1L, 81985529216486895L, 1L}, 3));
  }

  /**
   * Test {@link ArrayUtil#hashCode(Object[], int)} with {@code Object[]}, {@code int}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(Object[], int)}
   */
  @Test
  @DisplayName("Test hashCode(Object[], int) with 'Object[]', 'int'; when zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(java.lang.Object[], int)"})
  void testHashCodeWithObjectInt_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.hashCode(new Object[] {"Array"}, 0));
  }

  /**
   * Test {@link ArrayUtil#hashCode(short[], int)} with {@code short[]}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return fifty-nine.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCode(short[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCode(short[], int) with 'short[]', 'int'; when three; then return fifty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCode(short[], int)"})
  void testHashCodeWithShortInt_whenThree_thenReturnFiftyNine() {
    // Arrange, Act and Assert
    assertEquals(59, ArrayUtil.hashCode(new short[] {1, 31, 1, 31}, 3));
  }

  /**
   * Test {@link ArrayUtil#hashCodeOrNull(Object[], int)} with {@code array}, {@code size}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Array}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCodeOrNull(Object[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCodeOrNull(Object[], int) with 'array', 'size'; when array of Object with 'Array'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCodeOrNull(java.lang.Object[], int)"})
  void testHashCodeOrNullWithArraySize_whenArrayOfObjectWithArray_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.hashCodeOrNull(new Object[] {"Array"}, 0));
  }

  /**
   * Test {@link ArrayUtil#hashCodeOrNull(Object[], int)} with {@code array}, {@code size}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCodeOrNull(Object[], int)}
   */
  @Test
  @DisplayName(
      "Test hashCodeOrNull(Object[], int) with 'array', 'size'; when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCodeOrNull(java.lang.Object[], int)"})
  void testHashCodeOrNullWithArraySize_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.hashCodeOrNull(null, 0));
  }

  /**
   * Test {@link ArrayUtil#hashCodeOrNull(Object[])} with {@code array}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Array}.
   *   <li>Then return {@code 63537721}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCodeOrNull(Object[])}
   */
  @Test
  @DisplayName(
      "Test hashCodeOrNull(Object[]) with 'array'; when array of Object with 'Array'; then return '63537721'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCodeOrNull(java.lang.Object[])"})
  void testHashCodeOrNullWithArray_whenArrayOfObjectWithArray_thenReturn63537721() {
    // Arrange, Act and Assert
    assertEquals(63537721, ArrayUtil.hashCodeOrNull(new Object[] {"Array"}));
  }

  /**
   * Test {@link ArrayUtil#hashCodeOrNull(Object[])} with {@code array}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#hashCodeOrNull(Object[])}
   */
  @Test
  @DisplayName("Test hashCodeOrNull(Object[]) with 'array'; when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.hashCodeOrNull(java.lang.Object[])"})
  void testHashCodeOrNullWithArray_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.hashCodeOrNull(null));
  }

  /**
   * Test {@link ArrayUtil#compare(boolean[], int, boolean[], int)} with {@code boolean[]}, {@code
   * int}, {@code boolean[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(boolean[], int, boolean[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(boolean[], int, boolean[], int) with 'boolean[]', 'int', 'boolean[]', 'int'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(boolean[], int, boolean[], int)"})
  void testCompareWithBooleanIntBooleanInt_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        ArrayUtil.compare(
            new boolean[] {false, false, true, false},
            3,
            new boolean[] {true, false, true, false},
            3));
  }

  /**
   * Test {@link ArrayUtil#compare(boolean[], int, boolean[], int)} with {@code boolean[]}, {@code
   * int}, {@code boolean[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(boolean[], int, boolean[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(boolean[], int, boolean[], int) with 'boolean[]', 'int', 'boolean[]', 'int'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(boolean[], int, boolean[], int)"})
  void testCompareWithBooleanIntBooleanInt_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ArrayUtil.compare(
            new boolean[] {true, false, true, false},
            3,
            new boolean[] {true, false, true, false},
            3));
  }

  /**
   * Test {@link ArrayUtil#compare(byte[], int, byte[], int)} with {@code byte[]}, {@code int},
   * {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return minus sixty-two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(byte[], int, byte[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(byte[], int, byte[], int) with 'byte[]', 'int', 'byte[]', 'int'; when 'A'; then return minus sixty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(byte[], int, byte[], int)"})
  void testCompareWithByteIntByteInt_whenA_thenReturnMinusSixtyTwo()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        -62,
        ArrayUtil.compare(
            new byte[] {3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 3, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test {@link ArrayUtil#compare(byte[], int, byte[], int)} with {@code byte[]}, {@code int},
   * {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(byte[], int, byte[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(byte[], int, byte[], int) with 'byte[]', 'int', 'byte[]', 'int'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(byte[], int, byte[], int)"})
  void testCompareWithByteIntByteInt_whenAxaxaxaxBytesIsUtf8_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] array1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ArrayUtil.compare(array1, 3, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test {@link ArrayUtil#compare(char[], int, char[], int)} with {@code char[]}, {@code int},
   * {@code char[]}, {@code int}.
   *
   * <ul>
   *   <li>When {@code AZAZ} toCharArray.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(char[], int, char[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(char[], int, char[], int) with 'char[]', 'int', 'char[]', 'int'; when 'AZAZ' toCharArray; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(char[], int, char[], int)"})
  void testCompareWithCharIntCharInt_whenAzazToCharArray_thenReturnZero() {
    // Arrange
    char[] array1 = "AZAZ".toCharArray();

    // Act and Assert
    assertEquals(0, ArrayUtil.compare(array1, 3, "AZAZ".toCharArray(), 3));
  }

  /**
   * Test {@link ArrayUtil#compare(char[], int, char[], int)} with {@code char[]}, {@code int},
   * {@code char[]}, {@code int}.
   *
   * <ul>
   *   <li>When {@code ZAZ} toCharArray.
   *   <li>Then return minus sixty-two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(char[], int, char[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(char[], int, char[], int) with 'char[]', 'int', 'char[]', 'int'; when 'ZAZ' toCharArray; then return minus sixty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(char[], int, char[], int)"})
  void testCompareWithCharIntCharInt_whenZazToCharArray_thenReturnMinusSixtyTwo() {
    // Arrange
    char[] array1 = "\u0003ZAZ".toCharArray();

    // Act and Assert
    assertEquals(-62, ArrayUtil.compare(array1, 3, "AZAZ".toCharArray(), 3));
  }

  /**
   * Test {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)} with {@code Comparable[]},
   * {@code int}, {@code Comparable[]}, {@code int}.
   *
   * <p>Method under test: {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(Comparable[], int, Comparable[], int) with 'Comparable[]', 'int', 'Comparable[]', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.util.ArrayUtil.compare(java.lang.Comparable[], int, java.lang.Comparable[], int)"
  })
  void testCompareWithComparableIntComparableInt() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        ArrayUtil.compare(
            new Comparable[] {null, Charset.forName("UTF-8")},
            3,
            new Comparable[] {Charset.forName("UTF-8")},
            3));
  }

  /**
   * Test {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)} with {@code Comparable[]},
   * {@code int}, {@code Comparable[]}, {@code int}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link Comparable#compareTo(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(Comparable[], int, Comparable[], int) with 'Comparable[]', 'int', 'Comparable[]', 'int'; given one; then calls compareTo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.util.ArrayUtil.compare(java.lang.Comparable[], int, java.lang.Comparable[], int)"
  })
  void testCompareWithComparableIntComparableInt_givenOne_thenCallsCompareTo() {
    // Arrange
    Comparable comparable = mock(Comparable.class);
    when(comparable.compareTo(Mockito.<Object>any())).thenReturn(1);

    // Act
    int actualCompareResult =
        ArrayUtil.compare(
            new Comparable[] {comparable}, 3, new Comparable[] {Charset.forName("UTF-8")}, 3);

    // Assert
    verify(comparable).compareTo(isA(Object.class));
    assertEquals(1, actualCompareResult);
  }

  /**
   * Test {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)} with {@code Comparable[]},
   * {@code int}, {@code Comparable[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@link Comparable} with {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(Comparable[], int, Comparable[], int) with 'Comparable[]', 'int', 'Comparable[]', 'int'; when array of Comparable with 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.util.ArrayUtil.compare(java.lang.Comparable[], int, java.lang.Comparable[], int)"
  })
  void testCompareWithComparableIntComparableInt_whenArrayOfComparableWithNull() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        ArrayUtil.compare(
            new Comparable[] {mock(Comparable.class)}, 3, new Comparable[] {null}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)} with {@code Comparable[]},
   * {@code int}, {@code Comparable[]}, {@code int}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(Comparable[], int, Comparable[], int) with 'Comparable[]', 'int', 'Comparable[]', 'int'; when zero; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.util.ArrayUtil.compare(java.lang.Comparable[], int, java.lang.Comparable[], int)"
  })
  void testCompareWithComparableIntComparableInt_whenZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        ArrayUtil.compare(
            new Comparable[] {mock(Comparable.class)},
            0,
            new Comparable[] {Charset.forName("UTF-8")},
            3));
  }

  /**
   * Test {@link ArrayUtil#compare(double[], int, double[], int)} with {@code double[]}, {@code
   * int}, {@code double[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(double[], int, double[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(double[], int, double[], int) with 'double[]', 'int', 'double[]', 'int'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(double[], int, double[], int)"})
  void testCompareWithDoubleIntDoubleInt_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        ArrayUtil.compare(
            new double[] {1.0d, 1.0d, 10.0d, 1.0d}, 3, new double[] {10.0d, 1.0d, 10.0d, 1.0d}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(double[], int, double[], int)} with {@code double[]}, {@code
   * int}, {@code double[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code double} with ten and one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(double[], int, double[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(double[], int, double[], int) with 'double[]', 'int', 'double[]', 'int'; when array of double with ten and one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(double[], int, double[], int)"})
  void testCompareWithDoubleIntDoubleInt_whenArrayOfDoubleWithTenAndOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ArrayUtil.compare(
            new double[] {10.0d, 1.0d, 10.0d, 1.0d},
            3,
            new double[] {10.0d, 1.0d, 10.0d, 1.0d},
            3));
  }

  /**
   * Test {@link ArrayUtil#compare(float[], int, float[], int)} with {@code float[]}, {@code int},
   * {@code float[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(float[], int, float[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(float[], int, float[], int) with 'float[]', 'int', 'float[]', 'int'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(float[], int, float[], int)"})
  void testCompareWithFloatIntFloatInt_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        ArrayUtil.compare(
            new float[] {0.0f, 0.0f, 10.0f, 0.0f}, 3, new float[] {10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(float[], int, float[], int)} with {@code float[]}, {@code int},
   * {@code float[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code float} with ten and zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(float[], int, float[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(float[], int, float[], int) with 'float[]', 'int', 'float[]', 'int'; when array of float with ten and zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(float[], int, float[], int)"})
  void testCompareWithFloatIntFloatInt_whenArrayOfFloatWithTenAndZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ArrayUtil.compare(
            new float[] {10.0f, 0.0f, 10.0f, 0.0f}, 3, new float[] {10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(int[], int, int[], int)} with {@code int[]}, {@code int}, {@code
   * int[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code int} with one and zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(int[], int, int[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(int[], int, int[], int) with 'int[]', 'int', 'int[]', 'int'; when array of int with one and zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(int[], int, int[], int)"})
  void testCompareWithIntIntIntInt_whenArrayOfIntWithOneAndZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.compare(new int[] {1, 0, 1, 0}, 3, new int[] {1, 0, 1, 0}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(int[], int, int[], int)} with {@code int[]}, {@code int}, {@code
   * int[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code int} with three and zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(int[], int, int[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(int[], int, int[], int) with 'int[]', 'int', 'int[]', 'int'; when array of int with three and zero; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(int[], int, int[], int)"})
  void testCompareWithIntIntIntInt_whenArrayOfIntWithThreeAndZero_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ArrayUtil.compare(new int[] {3, 0, 1, 0}, 3, new int[] {1, 0, 1, 0}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(long[], int, long[], int)} with {@code long[]}, {@code int},
   * {@code long[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code long} with one and zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(long[], int, long[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(long[], int, long[], int) with 'long[]', 'int', 'long[]', 'int'; when array of long with one and zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(long[], int, long[], int)"})
  void testCompareWithLongIntLongInt_whenArrayOfLongWithOneAndZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, ArrayUtil.compare(new long[] {1L, 0L, 1L, 0L}, 3, new long[] {1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(long[], int, long[], int)} with {@code long[]}, {@code int},
   * {@code long[]}, {@code int}.
   *
   * <ul>
   *   <li>When array of {@code long} with three and zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(long[], int, long[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(long[], int, long[], int) with 'long[]', 'int', 'long[]', 'int'; when array of long with three and zero; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(long[], int, long[], int)"})
  void testCompareWithLongIntLongInt_whenArrayOfLongWithThreeAndZero_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1, ArrayUtil.compare(new long[] {3L, 0L, 1L, 0L}, 3, new long[] {1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(short[], int, short[], int)} with {@code short[]}, {@code int},
   * {@code short[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(short[], int, short[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(short[], int, short[], int) with 'short[]', 'int', 'short[]', 'int'; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(short[], int, short[], int)"})
  void testCompareWithShortIntShortInt_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(
        2, ArrayUtil.compare(new short[] {3, 31, 1, 31}, 3, new short[] {1, 31, 1, 31}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(short[], int, short[], int)} with {@code short[]}, {@code int},
   * {@code short[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(short[], int, short[], int)}
   */
  @Test
  @DisplayName(
      "Test compare(short[], int, short[], int) with 'short[]', 'int', 'short[]', 'int'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.ArrayUtil.compare(short[], int, short[], int)"})
  void testCompareWithShortIntShortInt_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, ArrayUtil.compare(new short[] {1, 31, 1, 31}, 3, new short[] {1, 31, 1, 31}, 3));
  }

  /**
   * Test {@link ArrayUtil#cloneOrNull(Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Array}.
   *   <li>Then return first element is {@code Array}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#cloneOrNull(Object[])}
   */
  @Test
  @DisplayName(
      "Test cloneOrNull(Object[]); when array of Object with 'Array'; then return first element is 'Array'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object[] proguard.util.ArrayUtil.cloneOrNull(java.lang.Object[])"})
  void testCloneOrNull_whenArrayOfObjectWithArray_thenReturnFirstElementIsArray() {
    // Arrange and Act
    Object[] actualCloneOrNullResult = ArrayUtil.cloneOrNull(new Object[] {"Array"});

    // Assert
    assertEquals("Array", actualCloneOrNullResult[0]);
    assertEquals(1, actualCloneOrNullResult.length);
  }

  /**
   * Test {@link ArrayUtil#cloneOrNull(Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#cloneOrNull(Object[])}
   */
  @Test
  @DisplayName("Test cloneOrNull(Object[]); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object[] proguard.util.ArrayUtil.cloneOrNull(java.lang.Object[])"})
  void testCloneOrNull_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ArrayUtil.cloneOrNull(null));
  }

  /**
   * Test {@link ArrayUtil#extendArray(Object[], int)} with {@code Object[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return first element is {@code Array}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#extendArray(Object[], int)}
   */
  @Test
  @DisplayName(
      "Test extendArray(Object[], int) with 'Object[]', 'int'; then return first element is 'Array'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.extendArray(java.lang.Object[], int)"
  })
  void testExtendArrayWithObjectInt_thenReturnFirstElementIsArray() {
    // Arrange and Act
    Object[] actualExtendArrayResult = ArrayUtil.extendArray(new Object[] {"Array"}, 3);

    // Assert
    assertEquals("Array", actualExtendArrayResult[0]);
    assertNull(actualExtendArrayResult[1]);
    assertNull(actualExtendArrayResult[2]);
    assertEquals(3, actualExtendArrayResult.length);
  }

  /**
   * Test {@link ArrayUtil#extendArray(Object[], int)} with {@code Object[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return second element is {@code Array}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#extendArray(Object[], int)}
   */
  @Test
  @DisplayName(
      "Test extendArray(Object[], int) with 'Object[]', 'int'; then return second element is 'Array'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.extendArray(java.lang.Object[], int)"
  })
  void testExtendArrayWithObjectInt_thenReturnSecondElementIsArray() {
    // Arrange and Act
    Object[] actualExtendArrayResult =
        ArrayUtil.extendArray(new Object[] {"Array", "Array", "Array"}, 3);

    // Assert
    assertEquals("Array", actualExtendArrayResult[1]);
    assertEquals("Array", actualExtendArrayResult[2]);
    assertEquals(3, actualExtendArrayResult.length);
  }

  /**
   * Test {@link ArrayUtil#ensureArraySize(Object[], int, Object)} with {@code Object[]}, {@code
   * int}, {@code Object}.
   *
   * <ul>
   *   <li>Then first element is {@code Initial Value}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#ensureArraySize(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test ensureArraySize(Object[], int, Object) with 'Object[]', 'int', 'Object'; then first element is 'Initial Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.ensureArraySize(java.lang.Object[], int, java.lang.Object)"
  })
  void testEnsureArraySizeWithObjectIntObject_thenFirstElementIsInitialValue() {
    // Arrange
    Object[] array = new Object[] {"Array", "Array", "Array"};

    // Act
    ArrayUtil.ensureArraySize(array, 3, "Initial Value");

    // Assert
    assertEquals("Initial Value", array[0]);
    assertEquals("Initial Value", array[1]);
    assertEquals("Initial Value", array[2]);
    assertEquals(3, array.length);
  }

  /**
   * Test {@link ArrayUtil#ensureArraySize(Object[], int, Object)} with {@code Object[]}, {@code
   * int}, {@code Object}.
   *
   * <ul>
   *   <li>Then return first element is {@code Initial Value}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#ensureArraySize(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test ensureArraySize(Object[], int, Object) with 'Object[]', 'int', 'Object'; then return first element is 'Initial Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.ensureArraySize(java.lang.Object[], int, java.lang.Object)"
  })
  void testEnsureArraySizeWithObjectIntObject_thenReturnFirstElementIsInitialValue() {
    // Arrange and Act
    Object[] actualEnsureArraySizeResult =
        ArrayUtil.ensureArraySize(new Object[] {"Array"}, 3, "Initial Value");

    // Assert
    assertEquals("Initial Value", actualEnsureArraySizeResult[0]);
    assertEquals("Initial Value", actualEnsureArraySizeResult[1]);
    assertEquals("Initial Value", actualEnsureArraySizeResult[2]);
    assertEquals(3, actualEnsureArraySizeResult.length);
  }

  /**
   * Test {@link ArrayUtil#ensureArraySize(Object[], int, Object)} with {@code Object[]}, {@code
   * int}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then first element is {@code Array}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#ensureArraySize(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test ensureArraySize(Object[], int, Object) with 'Object[]', 'int', 'Object'; when 'null'; then first element is 'Array'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.ensureArraySize(java.lang.Object[], int, java.lang.Object)"
  })
  void testEnsureArraySizeWithObjectIntObject_whenNull_thenFirstElementIsArray() {
    // Arrange
    Object[] array = new Object[] {"Array"};

    // Act
    Object[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(array, 3, null);

    // Assert
    assertEquals("Array", array[0]);
    assertNull(actualEnsureArraySizeResult[0]);
    assertNull(actualEnsureArraySizeResult[1]);
    assertNull(actualEnsureArraySizeResult[2]);
    assertEquals(1, array.length);
    assertEquals(3, actualEnsureArraySizeResult.length);
  }

  /**
   * Test {@link ArrayUtil#add(Object[], int, Object)} with {@code Object[]}, {@code int}, {@code
   * Object}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return first element is {@code Array}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#add(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object[], int, Object) with 'Object[]', 'int', 'Object'; when three; then return first element is 'Array'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.add(java.lang.Object[], int, java.lang.Object)"
  })
  void testAddWithObjectIntObject_whenThree_thenReturnFirstElementIsArray() {
    // Arrange
    Object[] array = new Object[] {"Array"};

    // Act
    Object[] actualAddResult = ArrayUtil.add(array, 3, "Element");

    // Assert
    assertEquals("Array", actualAddResult[0]);
    assertEquals("Array", array[0]);
    assertEquals("Element", actualAddResult[3]);
    assertNull(actualAddResult[1]);
    assertNull(actualAddResult[2]);
    assertEquals(1, array.length);
    assertEquals(4, actualAddResult.length);
  }

  /**
   * Test {@link ArrayUtil#add(Object[], int, Object)} with {@code Object[]}, {@code int}, {@code
   * Object}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return first element is {@code Element}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#add(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object[], int, Object) with 'Object[]', 'int', 'Object'; when zero; then return first element is 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.add(java.lang.Object[], int, java.lang.Object)"
  })
  void testAddWithObjectIntObject_whenZero_thenReturnFirstElementIsElement() {
    // Arrange
    Object[] array = new Object[] {"Array"};

    // Act
    Object[] actualAddResult = ArrayUtil.add(array, 0, "Element");

    // Assert
    assertEquals("Element", actualAddResult[0]);
    assertEquals("Element", array[0]);
    assertEquals(1, actualAddResult.length);
    assertEquals(1, array.length);
  }

  /**
   * Test {@link ArrayUtil#insert(Object[], int, int, Object)} with {@code Object[]}, {@code int},
   * {@code int}, {@code Object}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return first element is {@code Array}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#insert(Object[], int, int, Object)}
   */
  @Test
  @DisplayName(
      "Test insert(Object[], int, int, Object) with 'Object[]', 'int', 'int', 'Object'; when three; then return first element is 'Array'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.insert(java.lang.Object[], int, int, java.lang.Object)"
  })
  void testInsertWithObjectIntIntObject_whenThree_thenReturnFirstElementIsArray() {
    // Arrange and Act
    Object[] actualInsertResult = ArrayUtil.insert(new Object[] {"Array"}, 3, 1, "Element");

    // Assert
    assertEquals("Array", actualInsertResult[0]);
    assertEquals("Element", actualInsertResult[1]);
    assertNull(actualInsertResult[2]);
    assertNull(actualInsertResult[3]);
    assertEquals(4, actualInsertResult.length);
  }

  /**
   * Test {@link ArrayUtil#remove(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#remove(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test remove(byte[], int, int) with 'byte[]', 'int', 'int'; then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.ArrayUtil.remove(byte[], int, int)"})
  void testRemoveWithByteIntInt_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndA()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] array = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertArrayEquals(new byte[] {'A', 'A', 0, 'A', 'X', 'A', 'X', 'X'}, array);
  }

  /**
   * Test {@link ArrayUtil#remove(char[], int, int)} with {@code char[]}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then {@code AZAZ} toCharArray is AA null Z toCharArray.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#remove(char[], int, int)}
   */
  @Test
  @DisplayName(
      "Test remove(char[], int, int) with 'char[]', 'int', 'int'; then 'AZAZ' toCharArray is AA null Z toCharArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.ArrayUtil.remove(char[], int, int)"})
  void testRemoveWithCharIntInt_thenAzazToCharArrayIsAaNullZToCharArray() {
    // Arrange
    char[] array = "AZAZ".toCharArray();

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertArrayEquals("AA\u0000Z".toCharArray(), array);
  }

  /**
   * Test {@link ArrayUtil#remove(double[], int, int)} with {@code double[]}, {@code int}, {@code
   * int}.
   *
   * <p>Method under test: {@link ArrayUtil#remove(double[], int, int)}
   */
  @Test
  @DisplayName("Test remove(double[], int, int) with 'double[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.ArrayUtil.remove(double[], int, int)"})
  void testRemoveWithDoubleIntInt() {
    // Arrange
    double[] array = new double[] {10.0d, 1.0d, 10.0d, 1.0d};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertArrayEquals(new double[] {10.0d, 10.0d, 0.0d, 1.0d}, array, 0.0);
  }

  /**
   * Test {@link ArrayUtil#remove(float[], int, int)} with {@code float[]}, {@code int}, {@code
   * int}.
   *
   * <p>Method under test: {@link ArrayUtil#remove(float[], int, int)}
   */
  @Test
  @DisplayName("Test remove(float[], int, int) with 'float[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.ArrayUtil.remove(float[], int, int)"})
  void testRemoveWithFloatIntInt() {
    // Arrange
    float[] array = new float[] {10.0f, 0.0f, 10.0f, 0.0f};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertArrayEquals(new float[] {10.0f, 10.0f, 0.0f, 0.0f}, array, 0.0f);
  }

  /**
   * Test {@link ArrayUtil#remove(int[], int, int)} with {@code int[]}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then array of {@code int} with one and zero is array of {@code int} with one and one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#remove(int[], int, int)}
   */
  @Test
  @DisplayName(
      "Test remove(int[], int, int) with 'int[]', 'int', 'int'; then array of int with one and zero is array of int with one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.ArrayUtil.remove(int[], int, int)"})
  void testRemoveWithIntIntInt_thenArrayOfIntWithOneAndZeroIsArrayOfIntWithOneAndOne() {
    // Arrange
    int[] array = new int[] {1, 0, 1, 0};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertArrayEquals(new int[] {1, 1, 0, 0}, array);
  }

  /**
   * Test {@link ArrayUtil#remove(long[], int, int)} with {@code long[]}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then array of {@code long} with one and zero is array of {@code long} with one and one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#remove(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test remove(long[], int, int) with 'long[]', 'int', 'int'; then array of long with one and zero is array of long with one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.ArrayUtil.remove(long[], int, int)"})
  void testRemoveWithLongIntInt_thenArrayOfLongWithOneAndZeroIsArrayOfLongWithOneAndOne() {
    // Arrange
    long[] array = new long[] {1L, 0L, 1L, 0L};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertArrayEquals(new long[] {1L, 1L, 0L, 0L}, array);
  }

  /**
   * Test {@link ArrayUtil#remove(Object[], int, int)} with {@code Object[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Then third element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#remove(Object[], int, int)}
   */
  @Test
  @DisplayName(
      "Test remove(Object[], int, int) with 'Object[]', 'int', 'int'; then third element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.ArrayUtil.remove(java.lang.Object[], int, int)"})
  void testRemoveWithObjectIntInt_thenThirdElementIsNull() {
    // Arrange
    Object[] array = new Object[] {"Array", "Array", "Array"};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertNull(array[2]);
    assertEquals(3, array.length);
  }

  /**
   * Test {@link ArrayUtil#remove(short[], int, int)} with {@code short[]}, {@code int}, {@code
   * int}.
   *
   * <p>Method under test: {@link ArrayUtil#remove(short[], int, int)}
   */
  @Test
  @DisplayName("Test remove(short[], int, int) with 'short[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.ArrayUtil.remove(short[], int, int)"})
  void testRemoveWithShortIntInt() {
    // Arrange
    short[] array = new short[] {1, 31, 1, 31};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertArrayEquals(new short[] {1, 1, 0, 31}, array);
  }

  /**
   * Test {@link ArrayUtil#concat(Object[], Object[])}.
   *
   * <p>Method under test: {@link ArrayUtil#concat(Object[], Object[])}
   */
  @Test
  @DisplayName("Test concat(Object[], Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object[] proguard.util.ArrayUtil.concat(java.lang.Object[], java.lang.Object[])"
  })
  void testConcat() {
    // Arrange and Act
    Object[] actualConcatResult = ArrayUtil.concat(new Object[] {"First"}, new Object[] {"Second"});

    // Assert
    assertEquals("First", actualConcatResult[0]);
    assertEquals("Second", actualConcatResult[1]);
    assertEquals(2, actualConcatResult.length);
  }
}

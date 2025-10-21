package proguard.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.Metrics.MetricType;

public class ArrayUtilDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(boolean[], int, boolean)"})
  public void testIndexOfWithBooleanIntBoolean_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(boolean[], int, boolean)"})
  public void testIndexOfWithBooleanIntBoolean_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(boolean[], int, boolean)"})
  public void testIndexOfWithBooleanIntBoolean_whenZero_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(byte[], int, byte)"})
  public void testIndexOfWithByteIntByte_whenArrayOfByteWithAAndX_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(byte[], int, byte)"})
  public void testIndexOfWithByteIntByte_whenArrayOfByteWithThreeAndX_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(byte[], int, byte)"})
  public void testIndexOfWithByteIntByte_whenAxaxaxaxBytesIsUtf8_thenReturnZero()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(char[], int, char)"})
  public void testIndexOfWithCharIntChar_whenArrayOfCharWithAAndZ_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(char[], int, char)"})
  public void testIndexOfWithCharIntChar_whenAzazToCharArray_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(char[], int, char)"})
  public void testIndexOfWithCharIntChar_whenZazToCharArray_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(double[], int, double)"})
  public void testIndexOfWithDoubleIntDouble_whenArrayOfDoubleWithOneAndOne_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(double[], int, double)"})
  public void testIndexOfWithDoubleIntDouble_whenArrayOfDoubleWithTenAndOne_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(double[], int, double)"})
  public void testIndexOfWithDoubleIntDouble_whenZero_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(float[], int, float)"})
  public void testIndexOfWithFloatIntFloat_whenArrayOfFloatWithTenAndZero_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(float[], int, float)"})
  public void testIndexOfWithFloatIntFloat_whenArrayOfFloatWithZeroAndZero_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(float[], int, float)"})
  public void testIndexOfWithFloatIntFloat_whenZero_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(int[], int, int)"})
  public void testIndexOfWithIntIntInt_whenArrayOfIntWithFortyTwoAndZero_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(int[], int, int)"})
  public void testIndexOfWithIntIntInt_whenArrayOfIntWithOneAndZero_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(long[], int, long)"})
  public void testIndexOfWithLongIntLong_whenArrayOfLongWithFortyTwoAndZero_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(long[], int, long)"})
  public void testIndexOfWithLongIntLong_whenArrayOfLongWithOneAndZero_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(Object[], int, Object)"})
  public void testIndexOfWithObjectIntObject_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(Object[], int, Object)"})
  public void testIndexOfWithObjectIntObject_whenArrayOfObjectWithValue_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(short[], int, short)"})
  public void testIndexOfWithShortIntShort_whenArrayOfShortWithOneAndThirtyOne_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(short[], int, short)"})
  public void testIndexOfWithShortIntShort_whenArrayOfShortWithThreeAndThirtyOne_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.indexOf(short[], int, short)"})
  public void testIndexOfWithShortIntShort_whenZero_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(boolean[], boolean[], int)"})
  public void testEqualWithBooleanBooleanInt_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(boolean[], boolean[], int)"})
  public void testEqualWithBooleanBooleanInt_whenThree_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(byte[], byte[], int)"})
  public void testEqualWithByteByteInt_whenArrayOfByteWithThreeAndX_thenReturnFalse()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(byte[], byte[], int)"})
  public void testEqualWithByteByteInt_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(char[], char[], int)"})
  public void testEqualWithCharCharInt_whenAzazToCharArray_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(char[], char[], int)"})
  public void testEqualWithCharCharInt_whenZazToCharArray_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(double[], double[], int)"})
  public void testEqualWithDoubleDoubleInt_whenArrayOfDoubleWithOneAndOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(double[], double[], int)"})
  public void testEqualWithDoubleDoubleInt_whenThree_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(float[], float[], int)"})
  public void testEqualWithFloatFloatInt_whenArrayOfFloatWithZeroAndZero_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(float[], float[], int)"})
  public void testEqualWithFloatFloatInt_whenThree_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(int[], int[], int)"})
  public void testEqualWithIntIntInt_whenArrayOfIntWithThreeAndZero_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(int[], int[], int)"})
  public void testEqualWithIntIntInt_whenThree_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(long[], long[], int)"})
  public void testEqualWithLongLongInt_whenArrayOfLongWithThreeAndZero_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(long[], long[], int)"})
  public void testEqualWithLongLongInt_whenThree_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(Object[], Object[], int)"})
  public void testEqualWithObjectObjectInt_whenArrayOfObjectWithArray1_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(Object[], Object[], int)"})
  public void testEqualWithObjectObjectInt_whenZero_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(short[], short[], int)"})
  public void testEqualWithShortShortInt_whenArrayOfShortWithThreeAndThirtyOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equal(short[], short[], int)"})
  public void testEqualWithShortShortInt_whenThree_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[], int)"})
  public void testEqualOrNullWithArray1Array2Size_whenArrayOfObjectWithArray1_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[], int)"})
  public void testEqualOrNullWithArray1Array2Size_whenNull_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[], int)"})
  public void testEqualOrNullWithArray1Array2Size_whenNull_thenReturnFalse2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[], int)"})
  public void testEqualOrNullWithArray1Array2Size_whenNull_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[], int)"})
  public void testEqualOrNullWithArray1Array2Size_whenZero_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[])"})
  public void testEqualOrNullWithArray1Array2_whenArrayOfObjectWithArray1_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[])"})
  public void testEqualOrNullWithArray1Array2_whenArrayOfObjectWithArray1_thenReturnFalse2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[])"})
  public void testEqualOrNullWithArray1Array2_whenArrayOfObjectWithArray2_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[])"})
  public void testEqualOrNullWithArray1Array2_whenNull_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayUtil.equalOrNull(Object[], Object[])"})
  public void testEqualOrNullWithArray1Array2_whenNull_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(boolean[], int)"})
  public void testHashCodeWithBooleanInt_whenArrayOfBooleanWithTrueAndFalse_thenReturnFive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(byte[], int)"})
  public void testHashCodeWithByteInt_whenAxaxaxaxBytesIsUtf8_thenReturnFiveHundredOne()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(char[], int)"})
  public void testHashCodeWithCharInt_whenAzazToCharArray_thenReturnFourHundredNinetySeven() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(double[], int)"})
  public void testHashCodeWithDoubleInt_whenThree_thenReturn1062469633() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(float[], int)"})
  public void testHashCodeWithFloatInt_whenThree_thenReturn1168113665() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(int[], int)"})
  public void testHashCodeWithIntInt_whenThree_thenReturn95310073() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(long[], int)"})
  public void testHashCodeWithLongInt_whenThree_thenReturn1358628269() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(Object[], int)"})
  public void testHashCodeWithObjectInt_whenZero_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCode(short[], int)"})
  public void testHashCodeWithShortInt_whenThree_thenReturnFiftyNine() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCodeOrNull(Object[], int)"})
  public void testHashCodeOrNullWithArraySize_whenArrayOfObjectWithArray_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCodeOrNull(Object[], int)"})
  public void testHashCodeOrNullWithArraySize_whenNull_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCodeOrNull(Object[])"})
  public void testHashCodeOrNullWithArray_whenArrayOfObjectWithArray_thenReturn63537721() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.hashCodeOrNull(Object[])"})
  public void testHashCodeOrNullWithArray_whenNull_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(boolean[], int, boolean[], int)"})
  public void testCompareWithBooleanIntBooleanInt_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(boolean[], int, boolean[], int)"})
  public void testCompareWithBooleanIntBooleanInt_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(byte[], int, byte[], int)"})
  public void testCompareWithByteIntByteInt_whenA_thenReturnMinusSixtyTwo()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(byte[], int, byte[], int)"})
  public void testCompareWithByteIntByteInt_whenAxaxaxaxBytesIsUtf8_thenReturnZero()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(char[], int, char[], int)"})
  public void testCompareWithCharIntCharInt_whenAzazToCharArray_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(char[], int, char[], int)"})
  public void testCompareWithCharIntCharInt_whenZazToCharArray_thenReturnMinusSixtyTwo() {
    // Arrange
    char[] array1 = "\u0003ZAZ".toCharArray();

    // Act and Assert
    assertEquals(-62, ArrayUtil.compare(array1, 3, "AZAZ".toCharArray(), 3));
  }

  /**
   * Test {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)} with {@code Comparable[]},
   * {@code int}, {@code Comparable[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(Comparable[], int, Comparable[], int)"})
  public void testCompareWithComparableIntComparableInt_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        ArrayUtil.compare(
            new Comparable[] {null}, 3, new Comparable[] {Charset.forName("UTF-8")}, 3));
  }

  /**
   * Test {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)} with {@code Comparable[]},
   * {@code int}, {@code Comparable[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(Comparable[], int, Comparable[], int)"})
  public void testCompareWithComparableIntComparableInt_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        ArrayUtil.compare(
            new Comparable[] {MetricType.CALL_GRAPH_RECONSTRUCTION_MAX_DEPTH_REACHED},
            3,
            new Comparable[] {null},
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(double[], int, double[], int)"})
  public void testCompareWithDoubleIntDoubleInt_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(double[], int, double[], int)"})
  public void testCompareWithDoubleIntDoubleInt_whenArrayOfDoubleWithTenAndOne_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(float[], int, float[], int)"})
  public void testCompareWithFloatIntFloatInt_thenReturnMinusOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(float[], int, float[], int)"})
  public void testCompareWithFloatIntFloatInt_whenArrayOfFloatWithTenAndZero_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(int[], int, int[], int)"})
  public void testCompareWithIntIntIntInt_whenArrayOfIntWithOneAndZero_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(int[], int, int[], int)"})
  public void testCompareWithIntIntIntInt_whenArrayOfIntWithThreeAndZero_thenReturnOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(long[], int, long[], int)"})
  public void testCompareWithLongIntLongInt_whenArrayOfLongWithOneAndZero_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(long[], int, long[], int)"})
  public void testCompareWithLongIntLongInt_whenArrayOfLongWithThreeAndZero_thenReturnOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(short[], int, short[], int)"})
  public void testCompareWithShortIntShortInt_thenReturnTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayUtil.compare(short[], int, short[], int)"})
  public void testCompareWithShortIntShortInt_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.cloneOrNull(Object[])"})
  public void testCloneOrNull_whenArrayOfObjectWithArray_thenReturnFirstElementIsArray() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.cloneOrNull(Object[])"})
  public void testCloneOrNull_whenNull_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.extendArray(Object[], int)"})
  public void testExtendArrayWithObjectInt_thenReturnFirstElementIsArray() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.extendArray(Object[], int)"})
  public void testExtendArrayWithObjectInt_thenReturnSecondElementIsArray() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.ensureArraySize(Object[], int, Object)"})
  public void testEnsureArraySizeWithObjectIntObject_thenFirstElementIsInitialValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.ensureArraySize(Object[], int, Object)"})
  public void testEnsureArraySizeWithObjectIntObject_thenReturnFirstElementIsInitialValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.ensureArraySize(Object[], int, Object)"})
  public void testEnsureArraySizeWithObjectIntObject_whenNull_thenFirstElementIsArray() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.add(Object[], int, Object)"})
  public void testAddWithObjectIntObject_whenThree_thenReturnFirstElementIsArray() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.add(Object[], int, Object)"})
  public void testAddWithObjectIntObject_whenZero_thenReturnFirstElementIsElement() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.insert(Object[], int, int, Object)"})
  public void testInsertWithObjectIntIntObject_whenThree_thenReturnFirstElementIsArray() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayUtil.remove(byte[], int, int)"})
  public void testRemoveWithByteIntInt_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndA()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayUtil.remove(char[], int, int)"})
  public void testRemoveWithCharIntInt_thenAzazToCharArrayIsAaNullZToCharArray() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayUtil.remove(double[], int, int)"})
  public void testRemoveWithDoubleIntInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayUtil.remove(float[], int, int)"})
  public void testRemoveWithFloatIntInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayUtil.remove(int[], int, int)"})
  public void testRemoveWithIntIntInt_thenArrayOfIntWithOneAndZeroIsArrayOfIntWithOneAndOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayUtil.remove(long[], int, int)"})
  public void testRemoveWithLongIntInt_thenArrayOfLongWithOneAndZeroIsArrayOfLongWithOneAndOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayUtil.remove(Object[], int, int)"})
  public void testRemoveWithObjectIntInt_thenThirdElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayUtil.remove(short[], int, int)"})
  public void testRemoveWithShortIntInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayUtil.concat(Object[], Object[])"})
  public void testConcat() {
    // Arrange and Act
    Object[] actualConcatResult = ArrayUtil.concat(new Object[] {"First"}, new Object[] {"Second"});

    // Assert
    assertEquals("First", actualConcatResult[0]);
    assertEquals("Second", actualConcatResult[1]);
    assertEquals(2, actualConcatResult.length);
  }
}

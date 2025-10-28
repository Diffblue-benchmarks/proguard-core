package proguard.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.analysis.Metrics;

public class ArrayUtilDiffblueTest {
  /**
   * Method under test: {@link ArrayUtil#indexOf(byte[], int, byte)}
   */
  @Test
  public void testIndexOf() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.indexOf("AXAXAXAX".getBytes("UTF-8"), 3, (byte) 'A'));
    assertEquals(-1, ArrayUtil.indexOf(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, (byte) 'A'));
    assertEquals(2, ArrayUtil.indexOf(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 3, (byte) 'A'));
    assertEquals(0, ArrayUtil.indexOf("AZAZ".toCharArray(), 3, 'A'));
    assertEquals(-1, ArrayUtil.indexOf(new char[]{'A', 'Z', 'A', 'Z'}, 0, 'A'));
    assertEquals(2, ArrayUtil.indexOf("\u0003ZAZ".toCharArray(), 3, 'A'));
    assertEquals(0, ArrayUtil.indexOf(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3, 10.0d));
    assertEquals(-1, ArrayUtil.indexOf(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 0, 10.0d));
    assertEquals(2, ArrayUtil.indexOf(new double[]{1.0d, 1.0d, 10.0d, 1.0d}, 3, 10.0d));
    assertEquals(0, ArrayUtil.indexOf(new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 3, 10.0f));
    assertEquals(-1, ArrayUtil.indexOf(new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 0, 10.0f));
    assertEquals(2, ArrayUtil.indexOf(new float[]{0.0f, 0.0f, 10.0f, 0.0f}, 3, 10.0f));
    assertEquals(-1, ArrayUtil.indexOf(new int[]{1, 0, 1, 0}, 3, 42));
    assertEquals(0, ArrayUtil.indexOf(new int[]{42, 0, 1, 0}, 3, 42));
    assertEquals(-1, ArrayUtil.indexOf(new long[]{1L, 0L, 1L, 0L}, 3, 42L));
    assertEquals(0, ArrayUtil.indexOf(new long[]{42L, 0L, 1L, 0L}, 3, 42L));
    assertEquals(0, ArrayUtil.indexOf(new Object[]{"Value"}, 3, "Value"));
    assertEquals(-1, ArrayUtil.indexOf(new Object[]{"Array", "Array", "Array"}, 3, "Value"));
    assertEquals(0, ArrayUtil.indexOf(new short[]{1, 31, 1, 31}, 3, (short) 1));
    assertEquals(-1, ArrayUtil.indexOf(new short[]{1, 31, 1, 31}, 0, (short) 1));
    assertEquals(2, ArrayUtil.indexOf(new short[]{3, 31, 1, 31}, 3, (short) 1));
    assertEquals(0, ArrayUtil.indexOf(new boolean[]{true, false, true, false}, 3, true));
    assertEquals(-1, ArrayUtil.indexOf(new boolean[]{true, false, true, false}, 0, true));
    assertEquals(2, ArrayUtil.indexOf(new boolean[]{false, false, true, false}, 3, true));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(byte[], byte[], int)}
   */
  @Test
  public void testEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] array1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ArrayUtil.equal(array1, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(byte[], byte[], int)}
   */
  @Test
  public void testEqual2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(char[], char[], int)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    char[] array1 = "AZAZ".toCharArray();

    // Act and Assert
    assertTrue(ArrayUtil.equal(array1, "AZAZ".toCharArray(), 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(char[], char[], int)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    char[] array1 = "\u0003ZAZ".toCharArray();

    // Act and Assert
    assertFalse(ArrayUtil.equal(array1, "AZAZ".toCharArray(), 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(double[], double[], int)}
   */
  @Test
  public void testEqual5() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(double[], double[], int)}
   */
  @Test
  public void testEqual6() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new double[]{1.0d, 1.0d, 10.0d, 1.0d}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(float[], float[], int)}
   */
  @Test
  public void testEqual7() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new float[]{10.0f, 0.0f, 10.0f, 0.0f}, new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(float[], float[], int)}
   */
  @Test
  public void testEqual8() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new float[]{0.0f, 0.0f, 10.0f, 0.0f}, new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(int[], int[], int)}
   */
  @Test
  public void testEqual9() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(int[], int[], int)}
   */
  @Test
  public void testEqual10() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new int[]{3, 0, 1, 0}, new int[]{1, 0, 1, 0}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(long[], long[], int)}
   */
  @Test
  public void testEqual11() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new long[]{1L, 0L, 1L, 0L}, new long[]{1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(long[], long[], int)}
   */
  @Test
  public void testEqual12() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new long[]{3L, 0L, 1L, 0L}, new long[]{1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(Object[], Object[], int)}
   */
  @Test
  public void testEqual13() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new Object[]{"Array1"}, new Object[]{"Array2"}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(Object[], Object[], int)}
   */
  @Test
  public void testEqual14() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new Object[]{"Array1"}, new Object[]{"Array2"}, 0));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(short[], short[], int)}
   */
  @Test
  public void testEqual15() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new short[]{1, 31, 1, 31}, new short[]{1, 31, 1, 31}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(short[], short[], int)}
   */
  @Test
  public void testEqual16() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new short[]{3, 31, 1, 31}, new short[]{1, 31, 1, 31}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(boolean[], boolean[], int)}
   */
  @Test
  public void testEqual17() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtil.equal(new boolean[]{true, false, true, false}, new boolean[]{true, false, true, false}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equal(boolean[], boolean[], int)}
   */
  @Test
  public void testEqual18() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equal(new boolean[]{false, false, true, false}, new boolean[]{true, false, true, false}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#equalOrNull(Object[], Object[])}
   */
  @Test
  public void testEqualOrNull() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtil.equalOrNull(new Object[]{"Array1"}, new Object[]{"Array2"}));
    assertTrue(ArrayUtil.equalOrNull(new Object[]{"Array2"}, new Object[]{"Array2"}));
    assertFalse(ArrayUtil.equalOrNull(null, new Object[]{"Array2"}));
    assertFalse(ArrayUtil.equalOrNull(new Object[]{"Array1"}, null));
    assertTrue(ArrayUtil.equalOrNull(null, null));
    assertFalse(ArrayUtil.equalOrNull(new Object[]{"Array1"}, new Object[]{"Array2"}, 3));
    assertFalse(ArrayUtil.equalOrNull(null, new Object[]{"Array2"}, 3));
    assertFalse(ArrayUtil.equalOrNull(new Object[]{"Array1"}, null, 3));
    assertTrue(ArrayUtil.equalOrNull(new Object[]{"Array1"}, new Object[]{"Array2"}, 0));
    assertTrue(ArrayUtil.equalOrNull(null, null, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#hashCode(byte[], int)}
   */
  @Test
  public void testHashCode() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(501, ArrayUtil.hashCode("AXAXAXAX".getBytes("UTF-8"), 3));
    assertEquals(497, ArrayUtil.hashCode("AZAZ".toCharArray(), 3));
    assertEquals(1062469633, ArrayUtil.hashCode(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3));
    assertEquals(1168113665, ArrayUtil.hashCode(new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 3));
    assertEquals(95310073, ArrayUtil.hashCode(new int[]{19088743, 1, 19088743, 1}, 3));
    assertEquals(-1358628269, ArrayUtil.hashCode(new long[]{81985529216486895L, 1L, 81985529216486895L, 1L}, 3));
    assertEquals(0, ArrayUtil.hashCode(new Object[]{"Array"}, 0));
    assertEquals(59, ArrayUtil.hashCode(new short[]{1, 31, 1, 31}, 3));
    assertEquals(5, ArrayUtil.hashCode(new boolean[]{true, false, true, false}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#hashCodeOrNull(Object[])}
   */
  @Test
  public void testHashCodeOrNull() {
    // Arrange, Act and Assert
    assertEquals(63537721, ArrayUtil.hashCodeOrNull(new Object[]{"Array"}));
    assertEquals(0, ArrayUtil.hashCodeOrNull(null));
    assertEquals(0, ArrayUtil.hashCodeOrNull(null, 0));
    assertEquals(0, ArrayUtil.hashCodeOrNull(new Object[]{"Array"}, 0));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(byte[], int, byte[], int)}
   */
  @Test
  public void testCompare() throws UnsupportedEncodingException {
    // Arrange
    byte[] array1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ArrayUtil.compare(array1, 3, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(byte[], int, byte[], int)}
   */
  @Test
  public void testCompare2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(-62,
        ArrayUtil.compare(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 3, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(char[], int, char[], int)}
   */
  @Test
  public void testCompare3() {
    // Arrange
    char[] array1 = "AZAZ".toCharArray();

    // Act and Assert
    assertEquals(0, ArrayUtil.compare(array1, 3, "AZAZ".toCharArray(), 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(char[], int, char[], int)}
   */
  @Test
  public void testCompare4() {
    // Arrange
    char[] array1 = "\u0003ZAZ".toCharArray();

    // Act and Assert
    assertEquals(-62, ArrayUtil.compare(array1, 3, "AZAZ".toCharArray(), 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(double[], int, double[], int)}
   */
  @Test
  public void testCompare5() {
    // Arrange, Act and Assert
    assertEquals(0,
        ArrayUtil.compare(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3, new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(double[], int, double[], int)}
   */
  @Test
  public void testCompare6() {
    // Arrange, Act and Assert
    assertEquals(-1,
        ArrayUtil.compare(new double[]{1.0d, 1.0d, 10.0d, 1.0d}, 3, new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(float[], int, float[], int)}
   */
  @Test
  public void testCompare7() {
    // Arrange, Act and Assert
    assertEquals(0,
        ArrayUtil.compare(new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 3, new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(float[], int, float[], int)}
   */
  @Test
  public void testCompare8() {
    // Arrange, Act and Assert
    assertEquals(-1,
        ArrayUtil.compare(new float[]{0.0f, 0.0f, 10.0f, 0.0f}, 3, new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(int[], int, int[], int)}
   */
  @Test
  public void testCompare9() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.compare(new int[]{1, 0, 1, 0}, 3, new int[]{1, 0, 1, 0}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(int[], int, int[], int)}
   */
  @Test
  public void testCompare10() {
    // Arrange, Act and Assert
    assertEquals(1, ArrayUtil.compare(new int[]{3, 0, 1, 0}, 3, new int[]{1, 0, 1, 0}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(long[], int, long[], int)}
   */
  @Test
  public void testCompare11() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.compare(new long[]{1L, 0L, 1L, 0L}, 3, new long[]{1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(long[], int, long[], int)}
   */
  @Test
  public void testCompare12() {
    // Arrange, Act and Assert
    assertEquals(1, ArrayUtil.compare(new long[]{3L, 0L, 1L, 0L}, 3, new long[]{1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Method under test:
   * {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  public void testCompare13() {
    // Arrange, Act and Assert
    assertEquals(1, ArrayUtil.compare(new Comparable[]{Metrics.MetricType.CALL_GRAPH_RECONSTRUCTION_MAX_WIDTH_REACHED},
        3, new Comparable[]{Metrics.MetricType.CALL_GRAPH_RECONSTRUCTION_MAX_DEPTH_REACHED}, 3));
  }

  /**
   * Method under test:
   * {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  public void testCompare14() {
    // Arrange, Act and Assert
    assertEquals(-1, ArrayUtil.compare(new Comparable[]{null}, 3,
        new Comparable[]{Metrics.MetricType.CALL_GRAPH_RECONSTRUCTION_MAX_DEPTH_REACHED}, 3));
  }

  /**
   * Method under test:
   * {@link ArrayUtil#compare(Comparable[], int, Comparable[], int)}
   */
  @Test
  public void testCompare15() {
    // Arrange, Act and Assert
    assertEquals(1, ArrayUtil.compare(new Comparable[]{true}, 3, new Comparable[]{null}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(short[], int, short[], int)}
   */
  @Test
  public void testCompare16() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtil.compare(new short[]{1, 31, 1, 31}, 3, new short[]{1, 31, 1, 31}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(short[], int, short[], int)}
   */
  @Test
  public void testCompare17() {
    // Arrange, Act and Assert
    assertEquals(2, ArrayUtil.compare(new short[]{3, 31, 1, 31}, 3, new short[]{1, 31, 1, 31}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(boolean[], int, boolean[], int)}
   */
  @Test
  public void testCompare18() {
    // Arrange, Act and Assert
    assertEquals(0,
        ArrayUtil.compare(new boolean[]{true, false, true, false}, 3, new boolean[]{true, false, true, false}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#compare(boolean[], int, boolean[], int)}
   */
  @Test
  public void testCompare19() {
    // Arrange, Act and Assert
    assertEquals(-1,
        ArrayUtil.compare(new boolean[]{false, false, true, false}, 3, new boolean[]{true, false, true, false}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#cloneOrNull(Object[])}
   */
  @Test
  public void testCloneOrNull() {
    // Arrange and Act
    Object[] actualCloneOrNullResult = ArrayUtil.cloneOrNull(new Object[]{"Array"});

    // Assert
    assertEquals("Array", actualCloneOrNullResult[0]);
    assertEquals(1, actualCloneOrNullResult.length);
  }

  /**
   * Method under test: {@link ArrayUtil#cloneOrNull(Object[])}
   */
  @Test
  public void testCloneOrNull2() {
    // Arrange, Act and Assert
    assertNull(ArrayUtil.cloneOrNull(null));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(byte[], int)}
   */
  @Test
  public void testExtendArray() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualExtendArrayResult = ArrayUtil.extendArray("AXAXAXAX".getBytes("UTF-8"), 3);

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualExtendArrayResult);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(byte[], int)}
   */
  @Test
  public void testExtendArray2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0}, ArrayUtil.extendArray(new byte[]{}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(char[], int)}
   */
  @Test
  public void testExtendArray3() {
    // Arrange and Act
    char[] actualExtendArrayResult = ArrayUtil.extendArray("AZAZ".toCharArray(), 3);

    // Assert
    assertArrayEquals("AZAZ".toCharArray(), actualExtendArrayResult);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(char[], int)}
   */
  @Test
  public void testExtendArray4() {
    // Arrange and Act
    char[] actualExtendArrayResult = ArrayUtil.extendArray(new char[]{}, 3);

    // Assert
    assertArrayEquals("\u0000\u0000\u0000".toCharArray(), actualExtendArrayResult);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(double[], int)}
   */
  @Test
  public void testExtendArray5() {
    // Arrange, Act and Assert
    assertArrayEquals(new double[]{10.0d, 1.0d, 10.0d, 1.0d},
        ArrayUtil.extendArray(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3), 0.0);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(double[], int)}
   */
  @Test
  public void testExtendArray6() {
    // Arrange, Act and Assert
    assertArrayEquals(new double[]{0.0d, 0.0d, 0.0d}, ArrayUtil.extendArray(new double[]{}, 3), 0.0);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(float[], int)}
   */
  @Test
  public void testExtendArray7() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.0f, 10.0f, 0.0f},
        ArrayUtil.extendArray(new float[]{10.0f, 0.0f, 10.0f, 0.0f}, 3), 0.0f);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(float[], int)}
   */
  @Test
  public void testExtendArray8() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, ArrayUtil.extendArray(new float[]{}, 3), 0.0f);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(int[], int)}
   */
  @Test
  public void testExtendArray9() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{1, 0, 1, 0}, ArrayUtil.extendArray(new int[]{1, 0, 1, 0}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(int[], int)}
   */
  @Test
  public void testExtendArray10() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{0, 0, 0}, ArrayUtil.extendArray(new int[]{}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(long[], int)}
   */
  @Test
  public void testExtendArray11() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[]{1L, 0L, 1L, 0L}, ArrayUtil.extendArray(new long[]{1L, 0L, 1L, 0L}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(long[], int)}
   */
  @Test
  public void testExtendArray12() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[]{0L, 0L, 0L}, ArrayUtil.extendArray(new long[]{}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(Object[], int)}
   */
  @Test
  public void testExtendArray13() {
    // Arrange and Act
    Object[] actualExtendArrayResult = ArrayUtil.extendArray(new Object[]{"Array"}, 3);

    // Assert
    assertEquals("Array", actualExtendArrayResult[0]);
    assertNull(actualExtendArrayResult[1]);
    assertNull(actualExtendArrayResult[2]);
    assertEquals(3, actualExtendArrayResult.length);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(Object[], int)}
   */
  @Test
  public void testExtendArray14() {
    // Arrange and Act
    Object[] actualExtendArrayResult = ArrayUtil.extendArray(new Object[]{"Array", "Array", "Array"}, 3);

    // Assert
    assertEquals("Array", actualExtendArrayResult[0]);
    assertEquals("Array", actualExtendArrayResult[1]);
    assertEquals("Array", actualExtendArrayResult[2]);
    assertEquals(3, actualExtendArrayResult.length);
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(short[], int)}
   */
  @Test
  public void testExtendArray15() {
    // Arrange, Act and Assert
    assertArrayEquals(new short[]{1, 31, 1, 31}, ArrayUtil.extendArray(new short[]{1, 31, 1, 31}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(short[], int)}
   */
  @Test
  public void testExtendArray16() {
    // Arrange, Act and Assert
    assertArrayEquals(new short[]{0, 0, 0}, ArrayUtil.extendArray(new short[]{}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(boolean[], int)}
   */
  @Test
  public void testExtendArray17() {
    // Arrange, Act and Assert
    assertArrayEquals(new boolean[]{true, false, true, false},
        ArrayUtil.extendArray(new boolean[]{true, false, true, false}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#extendArray(boolean[], int)}
   */
  @Test
  public void testExtendArray18() {
    // Arrange, Act and Assert
    assertArrayEquals(new boolean[]{false, false, false}, ArrayUtil.extendArray(new boolean[]{}, 3));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(byte[], int, byte)}
   */
  @Test
  public void testEnsureArraySize() throws UnsupportedEncodingException {
    // Arrange
    byte[] array = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(array, 3, (byte) 'A');

    // Assert
    assertEquals(8, array.length);
    assertEquals('A', array[1]);
    assertArrayEquals("AAAXAXAX".getBytes("UTF-8"), actualEnsureArraySizeResult);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(byte[], int, byte)}
   */
  @Test
  public void testEnsureArraySize2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(new byte[]{}, 3, (byte) 'A');

    // Assert
    assertArrayEquals("AAA".getBytes("UTF-8"), actualEnsureArraySizeResult);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(byte[], int, byte)}
   */
  @Test
  public void testEnsureArraySize3() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0}, ArrayUtil.ensureArraySize(new byte[]{}, 3, (byte) 0));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(char[], int, char)}
   */
  @Test
  public void testEnsureArraySize4() {
    // Arrange
    char[] array = "AZAZ".toCharArray();

    // Act
    char[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(array, 3, 'A');

    // Assert
    assertEquals('A', array[1]);
    assertEquals(4, array.length);
    assertArrayEquals("AAAZ".toCharArray(), actualEnsureArraySizeResult);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(char[], int, char)}
   */
  @Test
  public void testEnsureArraySize5() {
    // Arrange and Act
    char[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(new char[]{}, 3, 'A');

    // Assert
    assertArrayEquals("AAA".toCharArray(), actualEnsureArraySizeResult);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(char[], int, char)}
   */
  @Test
  public void testEnsureArraySize6() {
    // Arrange and Act
    char[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(new char[]{}, 3, '\u0000');

    // Assert
    assertArrayEquals("\u0000\u0000\u0000".toCharArray(), actualEnsureArraySizeResult);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(double[], int, double)}
   */
  @Test
  public void testEnsureArraySize7() {
    // Arrange, Act and Assert
    assertArrayEquals(new double[]{10.0d, 10.0d, 10.0d}, ArrayUtil.ensureArraySize(new double[]{}, 3, 10.0d), 0.0);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(double[], int, double)}
   */
  @Test
  public void testEnsureArraySize8() {
    // Arrange, Act and Assert
    assertArrayEquals(new double[]{0.0d, 0.0d, 0.0d}, ArrayUtil.ensureArraySize(new double[]{}, 3, 0.0d), 0.0);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(float[], int, float)}
   */
  @Test
  public void testEnsureArraySize9() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f}, ArrayUtil.ensureArraySize(new float[]{}, 3, 10.0f), 0.0f);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(float[], int, float)}
   */
  @Test
  public void testEnsureArraySize10() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, ArrayUtil.ensureArraySize(new float[]{}, 3, 0.0f), 0.0f);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(int[], int, int)}
   */
  @Test
  public void testEnsureArraySize11() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{42, 42, 42}, ArrayUtil.ensureArraySize(new int[]{}, 3, 42));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(int[], int, int)}
   */
  @Test
  public void testEnsureArraySize12() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{0, 0, 0}, ArrayUtil.ensureArraySize(new int[]{}, 3, 0));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(long[], int, long)}
   */
  @Test
  public void testEnsureArraySize13() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[]{42L, 42L, 42L}, ArrayUtil.ensureArraySize(new long[]{}, 3, 42L));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(long[], int, long)}
   */
  @Test
  public void testEnsureArraySize14() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[]{0L, 0L, 0L}, ArrayUtil.ensureArraySize(new long[]{}, 3, 0L));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(Object[], int, Object)}
   */
  @Test
  public void testEnsureArraySize15() {
    // Arrange and Act
    Object[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(new Object[]{"Array"}, 3, "Initial Value");

    // Assert
    assertEquals("Initial Value", actualEnsureArraySizeResult[0]);
    assertEquals("Initial Value", actualEnsureArraySizeResult[1]);
    assertEquals("Initial Value", actualEnsureArraySizeResult[2]);
    assertEquals(3, actualEnsureArraySizeResult.length);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(Object[], int, Object)}
   */
  @Test
  public void testEnsureArraySize16() {
    // Arrange and Act
    Object[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(new Object[]{"Array"}, 3, null);

    // Assert
    assertNull(actualEnsureArraySizeResult[0]);
    assertNull(actualEnsureArraySizeResult[1]);
    assertNull(actualEnsureArraySizeResult[2]);
    assertEquals(3, actualEnsureArraySizeResult.length);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(Object[], int, Object)}
   */
  @Test
  public void testEnsureArraySize17() {
    // Arrange
    Object[] array = new Object[]{"Array", "Array", "Array"};

    // Act
    Object[] actualEnsureArraySizeResult = ArrayUtil.ensureArraySize(array, 3, "Initial Value");

    // Assert
    assertEquals("Initial Value", actualEnsureArraySizeResult[0]);
    assertEquals("Initial Value", actualEnsureArraySizeResult[1]);
    assertEquals("Initial Value", actualEnsureArraySizeResult[2]);
    assertEquals("Initial Value", array[0]);
    assertEquals("Initial Value", array[1]);
    assertEquals("Initial Value", array[2]);
    assertEquals(3, actualEnsureArraySizeResult.length);
    assertEquals(3, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(short[], int, short)}
   */
  @Test
  public void testEnsureArraySize18() {
    // Arrange, Act and Assert
    assertArrayEquals(new short[]{1, 1, 1}, ArrayUtil.ensureArraySize(new short[]{}, 3, (short) 1));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(short[], int, short)}
   */
  @Test
  public void testEnsureArraySize19() {
    // Arrange, Act and Assert
    assertArrayEquals(new short[]{0, 0, 0}, ArrayUtil.ensureArraySize(new short[]{}, 3, (short) 0));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(boolean[], int, boolean)}
   */
  @Test
  public void testEnsureArraySize20() {
    // Arrange, Act and Assert
    assertArrayEquals(new boolean[]{true, true, true}, ArrayUtil.ensureArraySize(new boolean[]{}, 3, true));
  }

  /**
   * Method under test: {@link ArrayUtil#ensureArraySize(boolean[], int, boolean)}
   */
  @Test
  public void testEnsureArraySize21() {
    // Arrange, Act and Assert
    assertArrayEquals(new boolean[]{false, false, false}, ArrayUtil.ensureArraySize(new boolean[]{}, 3, false));
  }

  /**
   * Method under test: {@link ArrayUtil#add(byte[], int, byte)}
   */
  @Test
  public void testAdd() throws UnsupportedEncodingException {
    // Arrange
    byte[] array = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualAddResult = ArrayUtil.add(array, 3, (byte) 'A');

    // Assert
    assertEquals(8, array.length);
    assertEquals('A', array[3]);
    assertArrayEquals("AXAAAXAX".getBytes("UTF-8"), actualAddResult);
  }

  /**
   * Method under test: {@link ArrayUtil#add(byte[], int, byte)}
   */
  @Test
  public void testAdd2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 'A'}, ArrayUtil.add(new byte[]{}, 3, (byte) 'A'));
  }

  /**
   * Method under test: {@link ArrayUtil#add(char[], int, char)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    char[] array = "AZAZ".toCharArray();

    // Act
    char[] actualAddResult = ArrayUtil.add(array, 3, 'A');

    // Assert
    assertEquals('A', array[3]);
    assertEquals(4, array.length);
    assertArrayEquals("AZAA".toCharArray(), actualAddResult);
  }

  /**
   * Method under test: {@link ArrayUtil#add(char[], int, char)}
   */
  @Test
  public void testAdd4() {
    // Arrange and Act
    char[] actualAddResult = ArrayUtil.add(new char[]{}, 3, 'A');

    // Assert
    assertArrayEquals("\u0000\u0000\u0000A".toCharArray(), actualAddResult);
  }

  /**
   * Method under test: {@link ArrayUtil#add(double[], int, double)}
   */
  @Test
  public void testAdd5() {
    // Arrange, Act and Assert
    assertArrayEquals(new double[]{0.0d, 0.0d, 0.0d, 10.0d}, ArrayUtil.add(new double[]{}, 3, 10.0d), 0.0);
  }

  /**
   * Method under test: {@link ArrayUtil#add(float[], int, float)}
   */
  @Test
  public void testAdd6() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f, 10.0f}, ArrayUtil.add(new float[]{}, 3, 10.0f), 0.0f);
  }

  /**
   * Method under test: {@link ArrayUtil#add(int[], int, int)}
   */
  @Test
  public void testAdd7() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{0, 0, 0, 2}, ArrayUtil.add(new int[]{}, 3, 2));
  }

  /**
   * Method under test: {@link ArrayUtil#add(long[], int, long)}
   */
  @Test
  public void testAdd8() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[]{0L, 0L, 0L, 1L}, ArrayUtil.add(new long[]{}, 3, 1L));
  }

  /**
   * Method under test: {@link ArrayUtil#add(Object[], int, Object)}
   */
  @Test
  public void testAdd9() {
    // Arrange
    Object[] array = new Object[]{"Array"};

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
   * Method under test: {@link ArrayUtil#add(Object[], int, Object)}
   */
  @Test
  public void testAdd10() {
    // Arrange
    Object[] array = new Object[]{"Array"};

    // Act
    Object[] actualAddResult = ArrayUtil.add(array, 0, "Element");

    // Assert
    assertEquals("Element", actualAddResult[0]);
    assertEquals("Element", array[0]);
    assertEquals(1, actualAddResult.length);
    assertEquals(1, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#add(short[], int, short)}
   */
  @Test
  public void testAdd11() {
    // Arrange, Act and Assert
    assertArrayEquals(new short[]{0, 0, 0, 1}, ArrayUtil.add(new short[]{}, 3, (short) 1));
  }

  /**
   * Method under test: {@link ArrayUtil#insert(byte[], int, int, byte)}
   */
  @Test
  public void testInsert() throws UnsupportedEncodingException {
    // Arrange
    byte[] array = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualInsertResult = ArrayUtil.insert(array, 3, 1, (byte) 'A');

    // Assert
    assertEquals(8, array.length);
    assertEquals('A', array[1]);
    assertEquals('A', array[3]);
    assertEquals('X', array[2]);
    assertArrayEquals("AAXAAXAX".getBytes("UTF-8"), actualInsertResult);
  }

  /**
   * Method under test: {@link ArrayUtil#insert(byte[], int, int, byte)}
   */
  @Test
  public void testInsert2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 'A', 0, 0}, ArrayUtil.insert(new byte[]{}, 3, 1, (byte) 'A'));
  }

  /**
   * Method under test: {@link ArrayUtil#insert(char[], int, int, char)}
   */
  @Test
  public void testInsert3() {
    // Arrange
    char[] array = "AZAZ".toCharArray();

    // Act
    char[] actualInsertResult = ArrayUtil.insert(array, 3, 1, 'A');

    // Assert
    assertEquals('A', array[1]);
    assertEquals('A', array[3]);
    assertEquals('Z', array[2]);
    assertEquals(4, array.length);
    assertArrayEquals("AAZA".toCharArray(), actualInsertResult);
  }

  /**
   * Method under test: {@link ArrayUtil#insert(char[], int, int, char)}
   */
  @Test
  public void testInsert4() {
    // Arrange and Act
    char[] actualInsertResult = ArrayUtil.insert(new char[]{}, 3, 1, 'A');

    // Assert
    assertArrayEquals("\u0000A\u0000\u0000".toCharArray(), actualInsertResult);
  }

  /**
   * Method under test: {@link ArrayUtil#insert(double[], int, int, double)}
   */
  @Test
  public void testInsert5() {
    // Arrange, Act and Assert
    assertArrayEquals(new double[]{0.0d, 10.0d, 0.0d, 0.0d}, ArrayUtil.insert(new double[]{}, 3, 1, 10.0d), 0.0);
  }

  /**
   * Method under test: {@link ArrayUtil#insert(float[], int, int, float)}
   */
  @Test
  public void testInsert6() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 10.0f, 0.0f, 0.0f}, ArrayUtil.insert(new float[]{}, 3, 1, 10.0f), 0.0f);
  }

  /**
   * Method under test: {@link ArrayUtil#insert(int[], int, int, int)}
   */
  @Test
  public void testInsert7() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{0, 1, 0, 0}, ArrayUtil.insert(new int[]{}, 3, 1, 1));
  }

  /**
   * Method under test: {@link ArrayUtil#insert(long[], int, int, long)}
   */
  @Test
  public void testInsert8() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[]{0L, 1L, 0L, 0L}, ArrayUtil.insert(new long[]{}, 3, 1, 1L));
  }

  /**
   * Method under test: {@link ArrayUtil#insert(Object[], int, int, Object)}
   */
  @Test
  public void testInsert9() {
    // Arrange and Act
    Object[] actualInsertResult = ArrayUtil.insert(new Object[]{"Array"}, 3, 1, "Element");

    // Assert
    assertEquals("Array", actualInsertResult[0]);
    assertEquals("Element", actualInsertResult[1]);
    assertNull(actualInsertResult[2]);
    assertNull(actualInsertResult[3]);
    assertEquals(4, actualInsertResult.length);
  }

  /**
   * Method under test: {@link ArrayUtil#insert(short[], int, int, short)}
   */
  @Test
  public void testInsert10() {
    // Arrange, Act and Assert
    assertArrayEquals(new short[]{0, 1, 0, 0}, ArrayUtil.insert(new short[]{}, 3, 1, (short) 1));
  }

  /**
   * Method under test: {@link ArrayUtil#remove(byte[], int, int)}
   */
  @Test
  public void testRemove() throws UnsupportedEncodingException {
    // Arrange
    byte[] array = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertEquals((byte) 0, array[2]);
    assertEquals(8, array.length);
    assertEquals('A', array[1]);
    assertEquals('A', array[3]);
    assertEquals('A', array[5]);
    assertEquals('X', array[4]);
    assertEquals('X', array[6]);
  }

  /**
   * Method under test: {@link ArrayUtil#remove(char[], int, int)}
   */
  @Test
  public void testRemove2() {
    // Arrange
    char[] array = "AZAZ".toCharArray();

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertEquals('A', array[1]);
    assertEquals('\u0000', array[2]);
    assertEquals(4, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#remove(double[], int, int)}
   */
  @Test
  public void testRemove3() {
    // Arrange
    double[] array = new double[]{10.0d, 1.0d, 10.0d, 1.0d};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertEquals(0.0d, array[2], 0.0);
    assertEquals(10.0d, array[1], 0.0);
    assertEquals(4, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#remove(float[], int, int)}
   */
  @Test
  public void testRemove4() {
    // Arrange
    float[] array = new float[]{10.0f, 0.0f, 10.0f, 0.0f};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertEquals(0.0f, array[2], 0.0f);
    assertEquals(10.0f, array[1], 0.0f);
    assertEquals(4, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#remove(int[], int, int)}
   */
  @Test
  public void testRemove5() {
    // Arrange
    int[] array = new int[]{1, 0, 1, 0};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertEquals(0, array[2]);
    assertEquals(1, array[1]);
    assertEquals(4, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#remove(long[], int, int)}
   */
  @Test
  public void testRemove6() {
    // Arrange
    long[] array = new long[]{1L, 0L, 1L, 0L};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertEquals(0L, array[2]);
    assertEquals(1L, array[1]);
    assertEquals(4, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#remove(Object[], int, int)}
   */
  @Test
  public void testRemove7() {
    // Arrange
    Object[] array = new Object[]{"Array", "Array", "Array"};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertNull(array[2]);
    assertEquals(3, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#remove(short[], int, int)}
   */
  @Test
  public void testRemove8() {
    // Arrange
    short[] array = new short[]{1, 31, 1, 31};

    // Act
    ArrayUtil.remove(array, 3, 1);

    // Assert
    assertEquals((short) 0, array[2]);
    assertEquals((short) 1, array[1]);
    assertEquals(4, array.length);
  }

  /**
   * Method under test: {@link ArrayUtil#concat(Object[], Object[])}
   */
  @Test
  public void testConcat() {
    // Arrange and Act
    Object[] actualConcatResult = ArrayUtil.concat(new Object[]{"First"}, new Object[]{"Second"});

    // Assert
    assertEquals("First", actualConcatResult[0]);
    assertEquals("Second", actualConcatResult[1]);
    assertEquals(2, actualConcatResult.length);
  }
}

package proguard.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#getModifiedUtf8Length(String)}.
   *
   * <p>Method under test: {@link StringUtil#getModifiedUtf8Length(String)}
   */
  @Test
  @DisplayName("Test getModifiedUtf8Length(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int StringUtil.getModifiedUtf8Length(String)"})
  void testGetModifiedUtf8Length() {
    // Arrange, Act and Assert
    assertEquals(6, StringUtil.getModifiedUtf8Length("String"));
  }

  /**
   * Test {@link StringUtil#getModifiedUtf8Bytes(String)}.
   *
   * <p>Method under test: {@link StringUtil#getModifiedUtf8Bytes(String)}
   */
  @Test
  @DisplayName("Test getModifiedUtf8Bytes(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] StringUtil.getModifiedUtf8Bytes(String)"})
  void testGetModifiedUtf8Bytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("String".getBytes("UTF-8"), StringUtil.getModifiedUtf8Bytes("String"));
  }

  /**
   * Test {@link StringUtil#getString(byte[], int, int)} with {@code modifiedUtf8Bytes}, {@code
   * startIndex}, {@code endIndex}.
   *
   * <p>Method under test: {@link StringUtil#getString(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test getString(byte[], int, int) with 'modifiedUtf8Bytes', 'startIndex', 'endIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[], int, int)"})
  void testGetStringWithModifiedUtf8BytesStartIndexEndIndex() {
    // Arrange, Act and Assert
    assertEquals(
        "", StringUtil.getString(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Test {@link StringUtil#getString(byte[], int, int)} with {@code modifiedUtf8Bytes}, {@code
   * startIndex}, {@code endIndex}.
   *
   * <ul>
   *   <li>Then return start of heading.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#getString(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test getString(byte[], int, int) with 'modifiedUtf8Bytes', 'startIndex', 'endIndex'; then return start of heading")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[], int, int)"})
  void testGetStringWithModifiedUtf8BytesStartIndexEndIndex_thenReturnStartOfHeading() {
    // Arrange, Act and Assert
    assertEquals(
        "\u0001", StringUtil.getString(new byte[] {'A', -64, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Test {@link StringUtil#getString(byte[], int, int)} with {@code modifiedUtf8Bytes}, {@code
   * startIndex}, {@code endIndex}.
   *
   * <ul>
   *   <li>Then return {@code XA}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#getString(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test getString(byte[], int, int) with 'modifiedUtf8Bytes', 'startIndex', 'endIndex'; then return 'XA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[], int, int)"})
  void testGetStringWithModifiedUtf8BytesStartIndexEndIndex_thenReturnXa()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("XA", StringUtil.getString("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link StringUtil#getString(byte[])} with {@code modifiedUtf8Bytes}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#getString(byte[])}
   */
  @Test
  @DisplayName("Test getString(byte[]) with 'modifiedUtf8Bytes'; then return 'AXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[])"})
  void testGetStringWithModifiedUtf8Bytes_thenReturnAxaxax() {
    // Arrange, Act and Assert
    assertEquals(
        "\u0018AXAXAX", StringUtil.getString(new byte[] {-64, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link StringUtil#getString(byte[])} with {@code modifiedUtf8Bytes}.
   *
   * <ul>
   *   <li>Then return {@code XAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#getString(byte[])}
   */
  @Test
  @DisplayName("Test getString(byte[]) with 'modifiedUtf8Bytes'; then return 'XAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[])"})
  void testGetStringWithModifiedUtf8Bytes_thenReturnXaxax() {
    // Arrange, Act and Assert
    assertEquals(
        "XAXAX", StringUtil.getString(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link StringUtil#getString(byte[])} with {@code modifiedUtf8Bytes}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#getString(byte[])}
   */
  @Test
  @DisplayName(
      "Test getString(byte[]) with 'modifiedUtf8Bytes'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[])"})
  void testGetStringWithModifiedUtf8Bytes_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StringUtil.getString(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link StringUtil#getString(byte[])} with {@code modifiedUtf8Bytes}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#getString(byte[])}
   */
  @Test
  @DisplayName(
      "Test getString(byte[]) with 'modifiedUtf8Bytes'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[])"})
  void testGetStringWithModifiedUtf8Bytes_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StringUtil.getString(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', -1}));
  }

  /**
   * Test {@link StringUtil#getString(byte[])} with {@code modifiedUtf8Bytes}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#getString(byte[])}
   */
  @Test
  @DisplayName(
      "Test getString(byte[]) with 'modifiedUtf8Bytes'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[])"})
  void testGetStringWithModifiedUtf8Bytes_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StringUtil.getString(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', -64}));
  }

  /**
   * Test {@link StringUtil#getString(byte[])} with {@code modifiedUtf8Bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#getString(byte[])}
   */
  @Test
  @DisplayName(
      "Test getString(byte[]) with 'modifiedUtf8Bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.getString(byte[])"})
  void testGetStringWithModifiedUtf8Bytes_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxax()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", StringUtil.getString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StringUtil#join(String, String[])}.
   *
   * <ul>
   *   <li>When {@code Strings} and {@code ]}.
   *   <li>Then return {@code StringsSeparator]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#join(String, String[])}
   */
  @Test
  @DisplayName(
      "Test join(String, String[]); when 'Strings' and ']'; then return 'StringsSeparator]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.join(String, String[])"})
  void testJoin_whenStringsAndRightSquareBracket_thenReturnStringsSeparator() {
    // Arrange and Act
    String actualJoinResult = StringUtil.join("Separator", "Strings", "]");

    // Assert
    assertEquals("StringsSeparator]", actualJoinResult);
  }

  /**
   * Test {@link StringUtil#join(String, String[])}.
   *
   * <ul>
   *   <li>When {@code Strings}.
   *   <li>Then return {@code Strings}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#join(String, String[])}
   */
  @Test
  @DisplayName("Test join(String, String[]); when 'Strings'; then return 'Strings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.join(String, String[])"})
  void testJoin_whenStrings_thenReturnStrings() {
    // Arrange, Act and Assert
    assertEquals("Strings", StringUtil.join("Separator", "Strings"));
  }

  /**
   * Test {@link StringUtil#toHexString(byte[], String, boolean)} with {@code bytes}, {@code
   * separator}, {@code upperCase}.
   *
   * <ul>
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#toHexString(byte[], String, boolean)}
   */
  @Test
  @DisplayName(
      "Test toHexString(byte[], String, boolean) with 'bytes', 'separator', 'upperCase'; then return '4158415841584158'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.toHexString(byte[], String, boolean)"})
  void testToHexStringWithBytesSeparatorUpperCase_thenReturn4158415841584158() {
    // Arrange and Act
    String actualToHexStringResult =
        StringUtil.toHexString(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null, false);

    // Assert
    assertEquals("4158415841584158", actualToHexStringResult);
  }

  /**
   * Test {@link StringUtil#toHexString(byte[], String, boolean)} with {@code bytes}, {@code
   * separator}, {@code upperCase}.
   *
   * <ul>
   *   <li>When array of {@code byte} with fifteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#toHexString(byte[], String, boolean)}
   */
  @Test
  @DisplayName(
      "Test toHexString(byte[], String, boolean) with 'bytes', 'separator', 'upperCase'; when array of byte with fifteen and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.toHexString(byte[], String, boolean)"})
  void testToHexStringWithBytesSeparatorUpperCase_whenArrayOfByteWithFifteenAndX() {
    // Arrange and Act
    String actualToHexStringResult =
        StringUtil.toHexString(
            new byte[] {15, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "0123456789ABCDEF", true);

    // Assert
    assertEquals(
        "0F0123456789ABCDEF580123456789ABCDEF410123456789ABCDEF580123456789ABCDEF410123456789ABCDEF5801234567"
            + "89ABCDEF410123456789ABCDEF58",
        actualToHexStringResult);
  }

  /**
   * Test {@link StringUtil#toHexString(byte[], String, boolean)} with {@code bytes}, {@code
   * separator}, {@code upperCase}.
   *
   * <ul>
   *   <li>When array of {@code byte} with fifteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#toHexString(byte[], String, boolean)}
   */
  @Test
  @DisplayName(
      "Test toHexString(byte[], String, boolean) with 'bytes', 'separator', 'upperCase'; when array of byte with fifteen and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.toHexString(byte[], String, boolean)"})
  void testToHexStringWithBytesSeparatorUpperCase_whenArrayOfByteWithFifteenAndX2() {
    // Arrange and Act
    String actualToHexStringResult =
        StringUtil.toHexString(
            new byte[] {15, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "0123456789ABCDEF", false);

    // Assert
    assertEquals(
        "0f0123456789ABCDEF580123456789ABCDEF410123456789ABCDEF580123456789ABCDEF410123456789ABCDEF5801234567"
            + "89ABCDEF410123456789ABCDEF58",
        actualToHexStringResult);
  }

  /**
   * Test {@link StringUtil#toHexString(byte[], String, boolean)} with {@code bytes}, {@code
   * separator}, {@code upperCase}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#toHexString(byte[], String, boolean)}
   */
  @Test
  @DisplayName(
      "Test toHexString(byte[], String, boolean) with 'bytes', 'separator', 'upperCase'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.toHexString(byte[], String, boolean)"})
  void testToHexStringWithBytesSeparatorUpperCase_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    String actualToHexStringResult =
        StringUtil.toHexString("AXAXAXAX".getBytes("UTF-8"), "0123456789ABCDEF", true);

    // Assert
    assertEquals(
        "410123456789ABCDEF580123456789ABCDEF410123456789ABCDEF580123456789ABCDEF410123456789ABCDEF5801234567"
            + "89ABCDEF410123456789ABCDEF58",
        actualToHexStringResult);
  }

  /**
   * Test {@link StringUtil#toHexString(byte[], String, boolean)} with {@code bytes}, {@code
   * separator}, {@code upperCase}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#toHexString(byte[], String, boolean)}
   */
  @Test
  @DisplayName(
      "Test toHexString(byte[], String, boolean) with 'bytes', 'separator', 'upperCase'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.toHexString(byte[], String, boolean)"})
  void testToHexStringWithBytesSeparatorUpperCase_whenNull_thenReturnNull() {
    // Arrange and Act
    String actualToHexStringResult = StringUtil.toHexString(null, null, false);

    // Assert
    assertNull(actualToHexStringResult);
  }

  /**
   * Test {@link StringUtil#toHexString(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code 0F58415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#toHexString(byte[])}
   */
  @Test
  @DisplayName("Test toHexString(byte[]) with 'bytes'; when 'A'; then return '0F58415841584158'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.toHexString(byte[])"})
  void testToHexStringWithBytes_whenA_thenReturn0f58415841584158() {
    // Arrange, Act and Assert
    assertEquals(
        "0F58415841584158",
        StringUtil.toHexString(new byte[] {15, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link StringUtil#toHexString(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#toHexString(byte[])}
   */
  @Test
  @DisplayName(
      "Test toHexString(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return '4158415841584158'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.toHexString(byte[])"})
  void testToHexStringWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", StringUtil.toHexString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StringUtil#toHexString(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#toHexString(byte[])}
   */
  @Test
  @DisplayName("Test toHexString(byte[]) with 'bytes'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.toHexString(byte[])"})
  void testToHexStringWithBytes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtil.toHexString(null));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42\\b}.
   *   <li>Then return {@code \n42\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42\\\\b'; then return '\\n42\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42B_thenReturnN42B() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\\\b", StringUtil.escapeControlCharacters("\n42\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42\\f}.
   *   <li>Then return {@code \n42\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42\\\\f'; then return '\\n42\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42F_thenReturnN42F() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\\\f", StringUtil.escapeControlCharacters("\n42\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42Input}.
   *   <li>Then return {@code \n42Input}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42Input'; then return '\\n42Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42Input_thenReturnN42Input() {
    // Arrange, Act and Assert
    assertEquals("\\n42Input", StringUtil.escapeControlCharacters("\n42Input"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42\\n}.
   *   <li>Then return {@code \n42\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42\\\\n'; then return '\\n42\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42N_thenReturnN42N() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\\\n", StringUtil.escapeControlCharacters("\n42\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42\\r}.
   *   <li>Then return {@code \n42\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42\\\\r'; then return '\\n42\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42R_thenReturnN42R() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\\\r", StringUtil.escapeControlCharacters("\n42\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42\\t}.
   *   <li>Then return {@code \n42\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42\\\\t'; then return '\\n42\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42T_thenReturnN42T() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\\\t", StringUtil.escapeControlCharacters("\n42\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '42\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturn42B() {
    // Arrange, Act and Assert
    assertEquals("42\\b", StringUtil.escapeControlCharacters("42\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '42\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturn42F() {
    // Arrange, Act and Assert
    assertEquals("42\\f", StringUtil.escapeControlCharacters("42\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '42\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturn42N() {
    // Arrange, Act and Assert
    assertEquals("42\\n", StringUtil.escapeControlCharacters("42\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '42\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturn42R() {
    // Arrange, Act and Assert
    assertEquals("42\\r", StringUtil.escapeControlCharacters("42\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '42\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturn42T() {
    // Arrange, Act and Assert
    assertEquals("42\\t", StringUtil.escapeControlCharacters("42\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \b42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\b42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnB42() {
    // Arrange, Act and Assert
    assertEquals("\\b42", StringUtil.escapeControlCharacters("\b42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \f42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\f42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnF42() {
    // Arrange, Act and Assert
    assertEquals("\\f42", StringUtil.escapeControlCharacters("\f42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnN42() {
    // Arrange, Act and Assert
    assertEquals("\\n42", StringUtil.escapeControlCharacters("\n42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n42\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n42\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnN42B() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\b", StringUtil.escapeControlCharacters("\n42\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n42\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n42\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnN42F() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\f", StringUtil.escapeControlCharacters("\n42\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n42\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n42\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnN42N() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\n", StringUtil.escapeControlCharacters("\n42\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n42\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n42\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnN42R() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\r", StringUtil.escapeControlCharacters("\n42\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n42\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n42\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnN42T() {
    // Arrange, Act and Assert
    assertEquals("\\n42\\t", StringUtil.escapeControlCharacters("\n42\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]42}.
   *   <li>Then return {@code \n]42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']42'; then return '\\n]42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnN422() {
    // Arrange, Act and Assert
    assertEquals("\\n]42", StringUtil.escapeControlCharacters("\n]42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42]}.
   *   <li>Then return {@code \n42]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42]'; then return '\\n42]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnN423() {
    // Arrange, Act and Assert
    assertEquals("\\n42]", StringUtil.escapeControlCharacters("\n42]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n\b42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n\\b42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnNB42() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b42", StringUtil.escapeControlCharacters("\n\b42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n\f42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n\\f42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnNF42() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f42", StringUtil.escapeControlCharacters("\n\f42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n\n42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n\\n42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnNN42() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n42", StringUtil.escapeControlCharacters("\n\n42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n\r42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n\\r42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnNR42() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r42", StringUtil.escapeControlCharacters("\n\r42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \n\t42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\n\\t42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnNT42() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t42", StringUtil.escapeControlCharacters("\n\t42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \r42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\r42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnR42() {
    // Arrange, Act and Assert
    assertEquals("\\r42", StringUtil.escapeControlCharacters("\r42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code \t42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '42'; then return '\\t42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when42_thenReturnT42() {
    // Arrange, Act and Assert
    assertEquals("\\t42", StringUtil.escapeControlCharacters("\t42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code \n4242}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '4242'; then return '\\n4242'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_when4242_thenReturnN4242() {
    // Arrange, Act and Assert
    assertEquals("\\n4242", StringUtil.escapeControlCharacters("\n4242"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \b\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\b\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnBB() {
    // Arrange, Act and Assert
    assertEquals("\\b\\\\b", StringUtil.escapeControlCharacters("\b\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \\b\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\\\b\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnBB2() {
    // Arrange, Act and Assert
    assertEquals("\\\\b\\b", StringUtil.escapeControlCharacters("\\\\b\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \\b\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\\\b\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnBF() {
    // Arrange, Act and Assert
    assertEquals("\\\\b\\f", StringUtil.escapeControlCharacters("\\\\b\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \\b\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\\\b\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnBN() {
    // Arrange, Act and Assert
    assertEquals("\\\\b\\n", StringUtil.escapeControlCharacters("\\\\b\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \\b\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\\\b\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnBR() {
    // Arrange, Act and Assert
    assertEquals("\\\\b\\r", StringUtil.escapeControlCharacters("\\\\b\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \\b\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\\\b\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnBT() {
    // Arrange, Act and Assert
    assertEquals("\\\\b\\t", StringUtil.escapeControlCharacters("\\\\b\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \f\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\f\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnFB() {
    // Arrange, Act and Assert
    assertEquals("\\f\\\\b", StringUtil.escapeControlCharacters("\f\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \n\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\n\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnNB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\b", StringUtil.escapeControlCharacters("\n\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]\\b}.
   *   <li>Then return {@code \n]\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']\\\\b'; then return '\\n]\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnNB2() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\\\b", StringUtil.escapeControlCharacters("\n]\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \n\b\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\n\\b\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnNBB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\\\b", StringUtil.escapeControlCharacters("\n\b\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \n\f\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\n\\f\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnNFB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\\\b", StringUtil.escapeControlCharacters("\n\f\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \n\n\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\n\\n\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnNNB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\\\b", StringUtil.escapeControlCharacters("\n\n\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \n\r\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\n\\r\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnNRB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\\\b", StringUtil.escapeControlCharacters("\n\r\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \n\t\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\n\\t\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnNTB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\\\b", StringUtil.escapeControlCharacters("\n\t\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \r\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\r\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnRB() {
    // Arrange, Act and Assert
    assertEquals("\\r\\\\b", StringUtil.escapeControlCharacters("\r\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\b}.
   *   <li>Then return {@code \t\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\b'; then return '\\t\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenB_thenReturnTB() {
    // Arrange, Act and Assert
    assertEquals("\\t\\\\b", StringUtil.escapeControlCharacters("\t\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When backspace backspace.
   *   <li>Then return {@code \b\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when backspace backspace; then return '\\b\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenBackspaceBackspace_thenReturnBB() {
    // Arrange, Act and Assert
    assertEquals("\\b\\b", StringUtil.escapeControlCharacters("\b\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When backspace cr.
   *   <li>Then return {@code \b\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when backspace cr; then return '\\b\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenBackspaceCr_thenReturnBR() {
    // Arrange, Act and Assert
    assertEquals("\\b\\r", StringUtil.escapeControlCharacters("\b\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When backspace form feed (ff).
   *   <li>Then return {@code \b\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when backspace form feed (ff); then return '\\b\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenBackspaceFormFeed_thenReturnBF() {
    // Arrange, Act and Assert
    assertEquals("\\b\\f", StringUtil.escapeControlCharacters("\b\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When backspace lf.
   *   <li>Then return {@code \b\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when backspace lf; then return '\\b\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenBackspaceLf_thenReturnBN() {
    // Arrange, Act and Assert
    assertEquals("\\b\\n", StringUtil.escapeControlCharacters("\b\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When backspace tab.
   *   <li>Then return {@code \b\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when backspace tab; then return '\\b\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenBackspaceTab_thenReturnBT() {
    // Arrange, Act and Assert
    assertEquals("\\b\\t", StringUtil.escapeControlCharacters("\b\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return {@code \b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when backspace; then return '\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenBackspace_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals("\\b", StringUtil.escapeControlCharacters("\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When cr backspace.
   *   <li>Then return {@code \r\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when cr backspace; then return '\\r\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenCrBackspace_thenReturnRB() {
    // Arrange, Act and Assert
    assertEquals("\\r\\b", StringUtil.escapeControlCharacters("\r\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When cr cr.
   *   <li>Then return {@code \r\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when cr cr; then return '\\r\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenCrCr_thenReturnRR() {
    // Arrange, Act and Assert
    assertEquals("\\r\\r", StringUtil.escapeControlCharacters("\r\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When cr form feed (ff).
   *   <li>Then return {@code \r\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when cr form feed (ff); then return '\\r\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenCrFormFeed_thenReturnRF() {
    // Arrange, Act and Assert
    assertEquals("\\r\\f", StringUtil.escapeControlCharacters("\r\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When cr lf.
   *   <li>Then return {@code \r\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when cr lf; then return '\\r\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenCrLf_thenReturnRN() {
    // Arrange, Act and Assert
    assertEquals("\\r\\n", StringUtil.escapeControlCharacters("\r\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When cr tab.
   *   <li>Then return {@code \r\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when cr tab; then return '\\r\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenCrTab_thenReturnRT() {
    // Arrange, Act and Assert
    assertEquals("\\r\\t", StringUtil.escapeControlCharacters("\r\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When cr.
   *   <li>Then return {@code \r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when cr; then return '\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenCr_thenReturnR() {
    // Arrange, Act and Assert
    assertEquals("\\r", StringUtil.escapeControlCharacters("\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \b\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\b\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnBF() {
    // Arrange, Act and Assert
    assertEquals("\\b\\\\f", StringUtil.escapeControlCharacters("\b\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \\f\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\\\f\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnFB() {
    // Arrange, Act and Assert
    assertEquals("\\\\f\\b", StringUtil.escapeControlCharacters("\\\\f\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \f\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\f\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnFF() {
    // Arrange, Act and Assert
    assertEquals("\\f\\\\f", StringUtil.escapeControlCharacters("\f\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \\f\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\\\f\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnFF2() {
    // Arrange, Act and Assert
    assertEquals("\\\\f\\f", StringUtil.escapeControlCharacters("\\\\f\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \\f\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\\\f\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnFN() {
    // Arrange, Act and Assert
    assertEquals("\\\\f\\n", StringUtil.escapeControlCharacters("\\\\f\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \\f\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\\\f\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnFR() {
    // Arrange, Act and Assert
    assertEquals("\\\\f\\r", StringUtil.escapeControlCharacters("\\\\f\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \\f\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\\\f\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnFT() {
    // Arrange, Act and Assert
    assertEquals("\\\\f\\t", StringUtil.escapeControlCharacters("\\\\f\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \n\b\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\n\\b\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnNBF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\\\f", StringUtil.escapeControlCharacters("\n\b\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \n\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\n\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnNF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\f", StringUtil.escapeControlCharacters("\n\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]\\f}.
   *   <li>Then return {@code \n]\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']\\\\f'; then return '\\n]\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnNF2() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\\\f", StringUtil.escapeControlCharacters("\n]\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \n\f\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\n\\f\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnNFF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\\\f", StringUtil.escapeControlCharacters("\n\f\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \n\n\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\n\\n\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnNNF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\\\f", StringUtil.escapeControlCharacters("\n\n\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \n\r\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\n\\r\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnNRF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\\\f", StringUtil.escapeControlCharacters("\n\r\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \n\t\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\n\\t\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnNTF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\\\f", StringUtil.escapeControlCharacters("\n\t\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \r\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\r\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnRF() {
    // Arrange, Act and Assert
    assertEquals("\\r\\\\f", StringUtil.escapeControlCharacters("\r\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\f}.
   *   <li>Then return {@code \t\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\f'; then return '\\t\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenF_thenReturnTF() {
    // Arrange, Act and Assert
    assertEquals("\\t\\\\f", StringUtil.escapeControlCharacters("\t\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When form feed (ff) backspace.
   *   <li>Then return {@code \f\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when form feed (ff) backspace; then return '\\f\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenFormFeedBackspace_thenReturnFB() {
    // Arrange, Act and Assert
    assertEquals("\\f\\b", StringUtil.escapeControlCharacters("\f\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When form feed (ff) cr.
   *   <li>Then return {@code \f\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when form feed (ff) cr; then return '\\f\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenFormFeedCr_thenReturnFR() {
    // Arrange, Act and Assert
    assertEquals("\\f\\r", StringUtil.escapeControlCharacters("\f\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When form feed (ff) form feed (ff).
   *   <li>Then return {@code \f\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when form feed (ff) form feed (ff); then return '\\f\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenFormFeedFormFeed_thenReturnFF() {
    // Arrange, Act and Assert
    assertEquals("\\f\\f", StringUtil.escapeControlCharacters("\f\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When form feed (ff) lf.
   *   <li>Then return {@code \f\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when form feed (ff) lf; then return '\\f\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenFormFeedLf_thenReturnFN() {
    // Arrange, Act and Assert
    assertEquals("\\f\\n", StringUtil.escapeControlCharacters("\f\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When form feed (ff) tab.
   *   <li>Then return {@code \f\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when form feed (ff) tab; then return '\\f\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenFormFeedTab_thenReturnFT() {
    // Arrange, Act and Assert
    assertEquals("\\f\\t", StringUtil.escapeControlCharacters("\f\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When form feed (ff).
   *   <li>Then return {@code \f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when form feed (ff); then return '\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenFormFeed_thenReturnF() {
    // Arrange, Act and Assert
    assertEquals("\\f", StringUtil.escapeControlCharacters("\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input42}.
   *   <li>Then return {@code \nInput42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input42'; then return '\\nInput42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput42_thenReturnNInput42() {
    // Arrange, Act and Assert
    assertEquals("\\nInput42", StringUtil.escapeControlCharacters("\nInput42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input\\b}.
   *   <li>Then return {@code \nInput\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when 'Input\\\\b'; then return '\\nInput\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInputB_thenReturnNInputB() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\\\b", StringUtil.escapeControlCharacters("\nInput\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input\\f}.
   *   <li>Then return {@code \nInput\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when 'Input\\\\f'; then return '\\nInput\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInputF_thenReturnNInputF() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\\\f", StringUtil.escapeControlCharacters("\nInput\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code InputInput}.
   *   <li>Then return {@code \nInputInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when 'InputInput'; then return '\\nInputInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInputInput_thenReturnNInputInput() {
    // Arrange, Act and Assert
    assertEquals("\\nInputInput", StringUtil.escapeControlCharacters("\nInputInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input\\n}.
   *   <li>Then return {@code \nInput\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when 'Input\\\\n'; then return '\\nInput\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInputN_thenReturnNInputN() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\\\n", StringUtil.escapeControlCharacters("\nInput\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input\\r}.
   *   <li>Then return {@code \nInput\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when 'Input\\\\r'; then return '\\nInput\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInputR_thenReturnNInputR() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\\\r", StringUtil.escapeControlCharacters("\nInput\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input\\t}.
   *   <li>Then return {@code \nInput\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when 'Input\\\\t'; then return '\\nInput\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInputT_thenReturnNInputT() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\\\t", StringUtil.escapeControlCharacters("\nInput\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \bInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\bInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnBInput() {
    // Arrange, Act and Assert
    assertEquals("\\bInput", StringUtil.escapeControlCharacters("\bInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \fInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\fInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnFInput() {
    // Arrange, Act and Assert
    assertEquals("\\fInput", StringUtil.escapeControlCharacters("\fInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", StringUtil.escapeControlCharacters("Input"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code Input\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return 'Input\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnInputB() {
    // Arrange, Act and Assert
    assertEquals("Input\\b", StringUtil.escapeControlCharacters("Input\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code Input\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return 'Input\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnInputF() {
    // Arrange, Act and Assert
    assertEquals("Input\\f", StringUtil.escapeControlCharacters("Input\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code Input\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return 'Input\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnInputN() {
    // Arrange, Act and Assert
    assertEquals("Input\\n", StringUtil.escapeControlCharacters("Input\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code Input\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return 'Input\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnInputR() {
    // Arrange, Act and Assert
    assertEquals("Input\\r", StringUtil.escapeControlCharacters("Input\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code Input\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return 'Input\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnInputT() {
    // Arrange, Act and Assert
    assertEquals("Input\\t", StringUtil.escapeControlCharacters("Input\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \n\bInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\n\\bInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNBInput() {
    // Arrange, Act and Assert
    assertEquals("\\n\\bInput", StringUtil.escapeControlCharacters("\n\bInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \n\fInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\n\\fInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNFInput() {
    // Arrange, Act and Assert
    assertEquals("\\n\\fInput", StringUtil.escapeControlCharacters("\n\fInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \nInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\nInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNInput() {
    // Arrange, Act and Assert
    assertEquals("\\nInput", StringUtil.escapeControlCharacters("\nInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input]}.
   *   <li>Then return {@code \nInput]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input]'; then return '\\nInput]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNInput2() {
    // Arrange, Act and Assert
    assertEquals("\\nInput]", StringUtil.escapeControlCharacters("\nInput]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]Input}.
   *   <li>Then return {@code \n]Input}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']Input'; then return '\\n]Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNInput3() {
    // Arrange, Act and Assert
    assertEquals("\\n]Input", StringUtil.escapeControlCharacters("\n]Input"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \nInput\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\nInput\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNInputB() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\b", StringUtil.escapeControlCharacters("\nInput\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \nInput\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\nInput\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNInputF() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\f", StringUtil.escapeControlCharacters("\nInput\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \nInput\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\nInput\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNInputN() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\n", StringUtil.escapeControlCharacters("\nInput\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \nInput\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\nInput\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNInputR() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\r", StringUtil.escapeControlCharacters("\nInput\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \nInput\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\nInput\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNInputT() {
    // Arrange, Act and Assert
    assertEquals("\\nInput\\t", StringUtil.escapeControlCharacters("\nInput\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \n\nInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\n\\nInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNNInput() {
    // Arrange, Act and Assert
    assertEquals("\\n\\nInput", StringUtil.escapeControlCharacters("\n\nInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \n\rInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\n\\rInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNRInput() {
    // Arrange, Act and Assert
    assertEquals("\\n\\rInput", StringUtil.escapeControlCharacters("\n\rInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \n\tInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\n\\tInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnNTInput() {
    // Arrange, Act and Assert
    assertEquals("\\n\\tInput", StringUtil.escapeControlCharacters("\n\tInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \rInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\rInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnRInput() {
    // Arrange, Act and Assert
    assertEquals("\\rInput", StringUtil.escapeControlCharacters("\rInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code \tInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when 'Input'; then return '\\tInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenInput_thenReturnTInput() {
    // Arrange, Act and Assert
    assertEquals("\\tInput", StringUtil.escapeControlCharacters("\tInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf backspace backspace.
   *   <li>Then return {@code \n\b\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf backspace backspace; then return '\\n\\b\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfBackspaceBackspace_thenReturnNBB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\b", StringUtil.escapeControlCharacters("\n\b\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf backspace cr.
   *   <li>Then return {@code \n\b\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf backspace cr; then return '\\n\\b\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfBackspaceCr_thenReturnNBR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\r", StringUtil.escapeControlCharacters("\n\b\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf backspace form feed (ff).
   *   <li>Then return {@code \n\b\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf backspace form feed (ff); then return '\\n\\b\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfBackspaceFormFeed_thenReturnNBF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\f", StringUtil.escapeControlCharacters("\n\b\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf backspace lf.
   *   <li>Then return {@code \n\b\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf backspace lf; then return '\\n\\b\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfBackspaceLf_thenReturnNBN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\n", StringUtil.escapeControlCharacters("\n\b\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf backspace tab.
   *   <li>Then return {@code \n\b\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf backspace tab; then return '\\n\\b\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfBackspaceTab_thenReturnNBT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\t", StringUtil.escapeControlCharacters("\n\b\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf backspace.
   *   <li>Then return {@code \n\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf backspace; then return '\\n\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfBackspace_thenReturnNB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b", StringUtil.escapeControlCharacters("\n\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf cr backspace.
   *   <li>Then return {@code \n\r\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf cr backspace; then return '\\n\\r\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfCrBackspace_thenReturnNRB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\b", StringUtil.escapeControlCharacters("\n\r\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf cr cr.
   *   <li>Then return {@code \n\r\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf cr cr; then return '\\n\\r\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfCrCr_thenReturnNRR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\r", StringUtil.escapeControlCharacters("\n\r\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf cr form feed (ff).
   *   <li>Then return {@code \n\r\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf cr form feed (ff); then return '\\n\\r\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfCrFormFeed_thenReturnNRF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\f", StringUtil.escapeControlCharacters("\n\r\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf cr lf.
   *   <li>Then return {@code \n\r\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf cr lf; then return '\\n\\r\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfCrLf_thenReturnNRN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\n", StringUtil.escapeControlCharacters("\n\r\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf cr tab.
   *   <li>Then return {@code \n\r\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf cr tab; then return '\\n\\r\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfCrTab_thenReturnNRT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\t", StringUtil.escapeControlCharacters("\n\r\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf cr.
   *   <li>Then return {@code \n\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf cr; then return '\\n\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfCr_thenReturnNR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r", StringUtil.escapeControlCharacters("\n\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf form feed (ff) backspace.
   *   <li>Then return {@code \n\f\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf form feed (ff) backspace; then return '\\n\\f\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfFormFeedBackspace_thenReturnNFB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\b", StringUtil.escapeControlCharacters("\n\f\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf form feed (ff) cr.
   *   <li>Then return {@code \n\f\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf form feed (ff) cr; then return '\\n\\f\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfFormFeedCr_thenReturnNFR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\r", StringUtil.escapeControlCharacters("\n\f\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf form feed (ff) form feed (ff).
   *   <li>Then return {@code \n\f\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf form feed (ff) form feed (ff); then return '\\n\\f\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfFormFeedFormFeed_thenReturnNFF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\f", StringUtil.escapeControlCharacters("\n\f\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf form feed (ff) lf.
   *   <li>Then return {@code \n\f\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf form feed (ff) lf; then return '\\n\\f\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfFormFeedLf_thenReturnNFN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\n", StringUtil.escapeControlCharacters("\n\f\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf form feed (ff) tab.
   *   <li>Then return {@code \n\f\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf form feed (ff) tab; then return '\\n\\f\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfFormFeedTab_thenReturnNFT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\t", StringUtil.escapeControlCharacters("\n\f\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf form feed (ff).
   *   <li>Then return {@code \n\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf form feed (ff); then return '\\n\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfFormFeed_thenReturnNF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f", StringUtil.escapeControlCharacters("\n\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf lf backspace.
   *   <li>Then return {@code \n\n\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf lf backspace; then return '\\n\\n\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfLfBackspace_thenReturnNNB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\b", StringUtil.escapeControlCharacters("\n\n\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf lf cr.
   *   <li>Then return {@code \n\n\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf lf cr; then return '\\n\\n\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfLfCr_thenReturnNNR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\r", StringUtil.escapeControlCharacters("\n\n\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf lf form feed (ff).
   *   <li>Then return {@code \n\n\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf lf form feed (ff); then return '\\n\\n\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfLfFormFeed_thenReturnNNF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\f", StringUtil.escapeControlCharacters("\n\n\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf lf lf.
   *   <li>Then return {@code \n\n\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf lf lf; then return '\\n\\n\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfLfLf_thenReturnNNN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\n", StringUtil.escapeControlCharacters("\n\n\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf lf tab.
   *   <li>Then return {@code \n\n\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf lf tab; then return '\\n\\n\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfLfTab_thenReturnNNT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\t", StringUtil.escapeControlCharacters("\n\n\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf lf.
   *   <li>Then return {@code \n\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf lf; then return '\\n\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfLf_thenReturnNN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n", StringUtil.escapeControlCharacters("\n\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf tab backspace.
   *   <li>Then return {@code \n\t\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf tab backspace; then return '\\n\\t\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfTabBackspace_thenReturnNTB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\b", StringUtil.escapeControlCharacters("\n\t\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf tab cr.
   *   <li>Then return {@code \n\t\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf tab cr; then return '\\n\\t\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfTabCr_thenReturnNTR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\r", StringUtil.escapeControlCharacters("\n\t\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf tab form feed (ff).
   *   <li>Then return {@code \n\t\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when lf tab form feed (ff); then return '\\n\\t\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfTabFormFeed_thenReturnNTF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\f", StringUtil.escapeControlCharacters("\n\t\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf tab lf.
   *   <li>Then return {@code \n\t\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf tab lf; then return '\\n\\t\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfTabLf_thenReturnNTN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\n", StringUtil.escapeControlCharacters("\n\t\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf tab tab.
   *   <li>Then return {@code \n\t\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf tab tab; then return '\\n\\t\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfTabTab_thenReturnNTT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\t", StringUtil.escapeControlCharacters("\n\t\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf tab.
   *   <li>Then return {@code \n\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf tab; then return '\\n\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLfTab_thenReturnNT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t", StringUtil.escapeControlCharacters("\n\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return {@code \n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when lf; then return '\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenLf_thenReturnN() {
    // Arrange, Act and Assert
    assertEquals("\\n", StringUtil.escapeControlCharacters("\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n42}.
   *   <li>Then return {@code \n\\n42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n42'; then return '\\n\\\\n42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN42_thenReturnNN42() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n42", StringUtil.escapeControlCharacters("\n\\\\n42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n\\b}.
   *   <li>Then return {@code \n\\n\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\n\\\\b'; then return '\\n\\\\n\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenNB_thenReturnNNB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\\\b", StringUtil.escapeControlCharacters("\n\\\\n\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n\\f}.
   *   <li>Then return {@code \n\\n\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\n\\\\f'; then return '\\n\\\\n\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenNF_thenReturnNNF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\\\f", StringUtil.escapeControlCharacters("\n\\\\n\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\nInput}.
   *   <li>Then return {@code \n\\nInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\nInput'; then return '\\n\\\\nInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenNInput_thenReturnNNInput() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\nInput", StringUtil.escapeControlCharacters("\n\\\\nInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n\\n}.
   *   <li>Then return {@code \n\\n\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\n\\\\n'; then return '\\n\\\\n\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenNN_thenReturnNNN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\\\n", StringUtil.escapeControlCharacters("\n\\\\n\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n\\r}.
   *   <li>Then return {@code \n\\n\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\n\\\\r'; then return '\\n\\\\n\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenNR_thenReturnNNR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\\\r", StringUtil.escapeControlCharacters("\n\\\\n\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n\\t}.
   *   <li>Then return {@code \n\\n\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\n\\\\t'; then return '\\n\\\\n\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenNT_thenReturnNNT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\\\t", StringUtil.escapeControlCharacters("\n\\\\n\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \b\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\b\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnBN() {
    // Arrange, Act and Assert
    assertEquals("\\b\\\\n", StringUtil.escapeControlCharacters("\b\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \f\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\f\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnFN() {
    // Arrange, Act and Assert
    assertEquals("\\f\\\\n", StringUtil.escapeControlCharacters("\f\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \\n\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\\\n\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNB() {
    // Arrange, Act and Assert
    assertEquals("\\\\n\\b", StringUtil.escapeControlCharacters("\\\\n\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\b\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\b\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNBN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\\\n", StringUtil.escapeControlCharacters("\n\b\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \\n\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\\\n\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNF() {
    // Arrange, Act and Assert
    assertEquals("\\\\n\\f", StringUtil.escapeControlCharacters("\\\\n\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\f\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\f\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNFN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\\\n", StringUtil.escapeControlCharacters("\n\f\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n", StringUtil.escapeControlCharacters("\n\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \\n\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\\\n\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNN2() {
    // Arrange, Act and Assert
    assertEquals("\\\\n\\n", StringUtil.escapeControlCharacters("\\\\n\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n]}.
   *   <li>Then return {@code \n\\n]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n]'; then return '\\n\\\\n]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNN3() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n]", StringUtil.escapeControlCharacters("\n\\\\n]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]\\n}.
   *   <li>Then return {@code \n]\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']\\\\n'; then return '\\n]\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNN4() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\\\n", StringUtil.escapeControlCharacters("\n]\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\\n\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\\\n\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNNB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\b", StringUtil.escapeControlCharacters("\n\\\\n\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\\n\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\\\n\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNNF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\f", StringUtil.escapeControlCharacters("\n\\\\n\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\n\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\n\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNNN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\\\n", StringUtil.escapeControlCharacters("\n\n\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\\n\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\\\n\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNNN2() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\n", StringUtil.escapeControlCharacters("\n\\\\n\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\\n\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\\\n\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNNR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\r", StringUtil.escapeControlCharacters("\n\\\\n\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\\n\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\\\n\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNNT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\n\\t", StringUtil.escapeControlCharacters("\n\\\\n\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \\n\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\\\n\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNR() {
    // Arrange, Act and Assert
    assertEquals("\\\\n\\r", StringUtil.escapeControlCharacters("\\\\n\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\r\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\r\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNRN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\\\n", StringUtil.escapeControlCharacters("\n\r\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \\n\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\\\n\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNT() {
    // Arrange, Act and Assert
    assertEquals("\\\\n\\t", StringUtil.escapeControlCharacters("\\\\n\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \n\t\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\n\\t\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnNTN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\\\n", StringUtil.escapeControlCharacters("\n\t\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \r\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\r\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnRN() {
    // Arrange, Act and Assert
    assertEquals("\\r\\\\n", StringUtil.escapeControlCharacters("\r\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\n}.
   *   <li>Then return {@code \t\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\n'; then return '\\t\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenN_thenReturnTN() {
    // Arrange, Act and Assert
    assertEquals("\\t\\\\n", StringUtil.escapeControlCharacters("\t\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r42}.
   *   <li>Then return {@code \n\\r42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r42'; then return '\\n\\\\r42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR42_thenReturnNR42() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r42", StringUtil.escapeControlCharacters("\n\\\\r42"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r\\b}.
   *   <li>Then return {@code \n\\r\\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\r\\\\b'; then return '\\n\\\\r\\\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRB_thenReturnNRB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\\\b", StringUtil.escapeControlCharacters("\n\\\\r\\\\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r\\f}.
   *   <li>Then return {@code \n\\r\\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\r\\\\f'; then return '\\n\\\\r\\\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRF_thenReturnNRF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\\\f", StringUtil.escapeControlCharacters("\n\\\\r\\\\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\rInput}.
   *   <li>Then return {@code \n\\rInput}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\rInput'; then return '\\n\\\\rInput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRInput_thenReturnNRInput() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\rInput", StringUtil.escapeControlCharacters("\n\\\\rInput"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r\\n}.
   *   <li>Then return {@code \n\\r\\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\r\\\\n'; then return '\\n\\\\r\\\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRN_thenReturnNRN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\\\n", StringUtil.escapeControlCharacters("\n\\\\r\\\\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r\\r}.
   *   <li>Then return {@code \n\\r\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\r\\\\r'; then return '\\n\\\\r\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRR_thenReturnNRR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\\\r", StringUtil.escapeControlCharacters("\n\\\\r\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r\\t}.
   *   <li>Then return {@code \n\\r\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when '\\\\r\\\\t'; then return '\\n\\\\r\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRT_thenReturnNRT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\\\t", StringUtil.escapeControlCharacters("\n\\\\r\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \b\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\b\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnBR() {
    // Arrange, Act and Assert
    assertEquals("\\b\\\\r", StringUtil.escapeControlCharacters("\b\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \f\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\f\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnFR() {
    // Arrange, Act and Assert
    assertEquals("\\f\\\\r", StringUtil.escapeControlCharacters("\f\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\b\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\b\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNBR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\\\r", StringUtil.escapeControlCharacters("\n\b\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\f\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\f\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNFR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\\\r", StringUtil.escapeControlCharacters("\n\f\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\n\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\n\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNNR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\\\r", StringUtil.escapeControlCharacters("\n\n\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r", StringUtil.escapeControlCharacters("\n\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r]}.
   *   <li>Then return {@code \n\\r]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r]'; then return '\\n\\\\r]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNR2() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r]", StringUtil.escapeControlCharacters("\n\\\\r]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]\\r}.
   *   <li>Then return {@code \n]\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']\\\\r'; then return '\\n]\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNR3() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\\\r", StringUtil.escapeControlCharacters("\n]\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\\r\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\\\r\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNRB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\b", StringUtil.escapeControlCharacters("\n\\\\r\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\\r\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\\\r\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNRF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\f", StringUtil.escapeControlCharacters("\n\\\\r\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\\r\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\\\r\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNRN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\n", StringUtil.escapeControlCharacters("\n\\\\r\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\r\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\r\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNRR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\\\r", StringUtil.escapeControlCharacters("\n\r\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\\r\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\\\r\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNRR2() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\r", StringUtil.escapeControlCharacters("\n\\\\r\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\\r\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\\\r\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNRT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\r\\t", StringUtil.escapeControlCharacters("\n\\\\r\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \n\t\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\n\\t\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnNTR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\\\r", StringUtil.escapeControlCharacters("\n\t\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \\r\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\\\r\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnRB() {
    // Arrange, Act and Assert
    assertEquals("\\\\r\\b", StringUtil.escapeControlCharacters("\\\\r\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \\r\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\\\r\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnRF() {
    // Arrange, Act and Assert
    assertEquals("\\\\r\\f", StringUtil.escapeControlCharacters("\\\\r\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \\r\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\\\r\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnRN() {
    // Arrange, Act and Assert
    assertEquals("\\\\r\\n", StringUtil.escapeControlCharacters("\\\\r\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \r\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\r\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnRR() {
    // Arrange, Act and Assert
    assertEquals("\\r\\\\r", StringUtil.escapeControlCharacters("\r\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \\r\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\\\r\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnRR2() {
    // Arrange, Act and Assert
    assertEquals("\\\\r\\r", StringUtil.escapeControlCharacters("\\\\r\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \\r\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\\\r\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnRT() {
    // Arrange, Act and Assert
    assertEquals("\\\\r\\t", StringUtil.escapeControlCharacters("\\\\r\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\r}.
   *   <li>Then return {@code \t\\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\r'; then return '\\t\\\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenR_thenReturnTR() {
    // Arrange, Act and Assert
    assertEquals("\\t\\\\r", StringUtil.escapeControlCharacters("\t\\\\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]]}.
   *   <li>Then return {@code \n]]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']]'; then return '\\n]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracketRightSquareBracket_thenReturnN() {
    // Arrange, Act and Assert
    assertEquals("\\n]]", StringUtil.escapeControlCharacters("\n]]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \b]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\b]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals("\\b]", StringUtil.escapeControlCharacters("\b]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code ]\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return ']\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnB2() {
    // Arrange, Act and Assert
    assertEquals("]\\b", StringUtil.escapeControlCharacters("]\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \f]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\f]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnF() {
    // Arrange, Act and Assert
    assertEquals("\\f]", StringUtil.escapeControlCharacters("\f]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code ]\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return ']\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnF2() {
    // Arrange, Act and Assert
    assertEquals("]\\f", StringUtil.escapeControlCharacters("]\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnN() {
    // Arrange, Act and Assert
    assertEquals("\\n]", StringUtil.escapeControlCharacters("\n]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code ]\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return ']\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnN2() {
    // Arrange, Act and Assert
    assertEquals("]\\n", StringUtil.escapeControlCharacters("]\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n\b]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n\\b]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNB() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b]", StringUtil.escapeControlCharacters("\n\b]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n]\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n]\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNB2() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\b", StringUtil.escapeControlCharacters("\n]\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n\f]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n\\f]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNF() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f]", StringUtil.escapeControlCharacters("\n\f]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n]\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n]\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNF2() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\f", StringUtil.escapeControlCharacters("\n]\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n\n]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n\\n]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n]", StringUtil.escapeControlCharacters("\n\n]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n]\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n]\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNN2() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\n", StringUtil.escapeControlCharacters("\n]\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n\\r]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNR() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r]", StringUtil.escapeControlCharacters("\n\r]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n]\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n]\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNR2() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\r", StringUtil.escapeControlCharacters("\n]\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n\t]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n\\t]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t]", StringUtil.escapeControlCharacters("\n\t]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \n]\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\n]\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnNT2() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\t", StringUtil.escapeControlCharacters("\n]\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \r]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\r]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnR() {
    // Arrange, Act and Assert
    assertEquals("\\r]", StringUtil.escapeControlCharacters("\r]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code ]\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return ']\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnR2() {
    // Arrange, Act and Assert
    assertEquals("]\\r", StringUtil.escapeControlCharacters("]\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code \t]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return '\\t]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnT() {
    // Arrange, Act and Assert
    assertEquals("\\t]", StringUtil.escapeControlCharacters("\t]"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return {@code ]\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']'; then return ']\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenRightSquareBracket_thenReturnT2() {
    // Arrange, Act and Assert
    assertEquals("]\\t", StringUtil.escapeControlCharacters("]\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \b\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\b\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnBT() {
    // Arrange, Act and Assert
    assertEquals("\\b\\\\t", StringUtil.escapeControlCharacters("\b\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \f\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\f\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnFT() {
    // Arrange, Act and Assert
    assertEquals("\\f\\\\t", StringUtil.escapeControlCharacters("\f\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \n\b\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\n\\b\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnNBT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\b\\\\t", StringUtil.escapeControlCharacters("\n\b\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \n\f\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\n\\f\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnNFT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\f\\\\t", StringUtil.escapeControlCharacters("\n\f\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \n\n\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\n\\n\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnNNT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\n\\\\t", StringUtil.escapeControlCharacters("\n\n\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \n\r\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\n\\r\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnNRT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\r\\\\t", StringUtil.escapeControlCharacters("\n\r\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \n\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\n\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnNT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\t", StringUtil.escapeControlCharacters("\n\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code ]\\t}.
   *   <li>Then return {@code \n]\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when ']\\\\t'; then return '\\n]\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnNT2() {
    // Arrange, Act and Assert
    assertEquals("\\n]\\\\t", StringUtil.escapeControlCharacters("\n]\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \n\\t\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\n\\\\t\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnNTN() {
    // Arrange, Act and Assert
    assertEquals("\\n\\\\t\\n", StringUtil.escapeControlCharacters("\n\\\\t\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \n\t\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\n\\t\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnNTT() {
    // Arrange, Act and Assert
    assertEquals("\\n\\t\\\\t", StringUtil.escapeControlCharacters("\n\t\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \r\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\r\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnRT() {
    // Arrange, Act and Assert
    assertEquals("\\r\\\\t", StringUtil.escapeControlCharacters("\r\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \\t\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\\\t\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnTB() {
    // Arrange, Act and Assert
    assertEquals("\\\\t\\b", StringUtil.escapeControlCharacters("\\\\t\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \\t\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\\\t\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnTF() {
    // Arrange, Act and Assert
    assertEquals("\\\\t\\f", StringUtil.escapeControlCharacters("\\\\t\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \\t\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\\\t\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnTN() {
    // Arrange, Act and Assert
    assertEquals("\\\\t\\n", StringUtil.escapeControlCharacters("\\\\t\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \\t\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\\\t\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnTR() {
    // Arrange, Act and Assert
    assertEquals("\\\\t\\r", StringUtil.escapeControlCharacters("\\\\t\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \t\\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\t\\\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnTT() {
    // Arrange, Act and Assert
    assertEquals("\\t\\\\t", StringUtil.escapeControlCharacters("\t\\\\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When {@code \\t}.
   *   <li>Then return {@code \\t\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when '\\\\t'; then return '\\\\t\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenT_thenReturnTT2() {
    // Arrange, Act and Assert
    assertEquals("\\\\t\\t", StringUtil.escapeControlCharacters("\\\\t\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When tab backspace.
   *   <li>Then return {@code \t\b}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when tab backspace; then return '\\t\\b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenTabBackspace_thenReturnTB() {
    // Arrange, Act and Assert
    assertEquals("\\t\\b", StringUtil.escapeControlCharacters("\t\b"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When tab cr.
   *   <li>Then return {@code \t\r}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when tab cr; then return '\\t\\r'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenTabCr_thenReturnTR() {
    // Arrange, Act and Assert
    assertEquals("\\t\\r", StringUtil.escapeControlCharacters("\t\r"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When tab form feed (ff).
   *   <li>Then return {@code \t\f}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName(
      "Test escapeControlCharacters(String); when tab form feed (ff); then return '\\t\\f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenTabFormFeed_thenReturnTF() {
    // Arrange, Act and Assert
    assertEquals("\\t\\f", StringUtil.escapeControlCharacters("\t\f"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When tab lf.
   *   <li>Then return {@code \t\n}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when tab lf; then return '\\t\\n'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenTabLf_thenReturnTN() {
    // Arrange, Act and Assert
    assertEquals("\\t\\n", StringUtil.escapeControlCharacters("\t\n"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When tab tab.
   *   <li>Then return {@code \t\t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when tab tab; then return '\\t\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenTabTab_thenReturnTT() {
    // Arrange, Act and Assert
    assertEquals("\\t\\t", StringUtil.escapeControlCharacters("\t\t"));
  }

  /**
   * Test {@link StringUtil#escapeControlCharacters(String)}.
   *
   * <ul>
   *   <li>When tab.
   *   <li>Then return {@code \t}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  @DisplayName("Test escapeControlCharacters(String); when tab; then return '\\t'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.escapeControlCharacters(String)"})
  void testEscapeControlCharacters_whenTab_thenReturnT() {
    // Arrange, Act and Assert
    assertEquals("\\t", StringUtil.escapeControlCharacters("\t"));
  }

  /**
   * Test {@link StringUtil#listToString(List)}.
   *
   * <ul>
   *   <li>Given {@code ,}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ,}.
   *   <li>Then return {@code [", ", "[%s]"]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#listToString(List)}
   */
  @Test
  @DisplayName(
      "Test listToString(List); given ','; when ArrayList() add ','; then return '[\", \", \"[%s]\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.listToString(List)"})
  void testListToString_givenComma_whenArrayListAddComma_thenReturnS() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(", ");
    stringList.add("[%s]");

    // Act and Assert
    assertEquals("[\", \", \"[%s]\"]", StringUtil.listToString(stringList));
  }

  /**
   * Test {@link StringUtil#listToString(List)}.
   *
   * <ul>
   *   <li>Given {@code [%s]}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code [%s]}.
   *   <li>Then return {@code ["[%s]"]}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#listToString(List)}
   */
  @Test
  @DisplayName(
      "Test listToString(List); given '[%s]'; when ArrayList() add '[%s]'; then return '[\"[%s]\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.listToString(List)"})
  void testListToString_givenS_whenArrayListAddS_thenReturnS() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("[%s]");

    // Act and Assert
    assertEquals("[\"[%s]\"]", StringUtil.listToString(stringList));
  }

  /**
   * Test {@link StringUtil#listToString(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#listToString(List)}
   */
  @Test
  @DisplayName("Test listToString(List); when ArrayList(); then return '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.listToString(List)"})
  void testListToString_whenArrayList_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("[]", StringUtil.listToString(new ArrayList<>()));
  }
}

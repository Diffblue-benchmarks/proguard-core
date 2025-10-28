package proguard.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StringUtilDiffblueTest {
  /**
   * Method under test: {@link StringUtil#getModifiedUtf8Length(String)}
   */
  @Test
  public void testGetModifiedUtf8Length() {
    // Arrange, Act and Assert
    assertEquals(6, StringUtil.getModifiedUtf8Length("String"));
  }

  /**
   * Method under test: {@link StringUtil#getModifiedUtf8Bytes(String)}
   */
  @Test
  public void testGetModifiedUtf8Bytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualModifiedUtf8Bytes = StringUtil.getModifiedUtf8Bytes("String");

    // Assert
    assertArrayEquals("String".getBytes("UTF-8"), actualModifiedUtf8Bytes);
  }

  /**
   * Method under test: {@link StringUtil#getString(byte[])}
   */
  @Test
  public void testGetString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", StringUtil.getString("AXAXAXAX".getBytes("UTF-8")));
    assertEquals("XAXAX", StringUtil.getString(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertEquals("\u0018AXAXAX", StringUtil.getString(new byte[]{-64, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(IllegalArgumentException.class,
        () -> StringUtil.getString(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'}));
    assertThrows(IllegalArgumentException.class,
        () -> StringUtil.getString(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', -1}));
    assertThrows(IllegalArgumentException.class,
        () -> StringUtil.getString(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', -64}));
    assertEquals("XA", StringUtil.getString("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    assertEquals("", StringUtil.getString(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
    assertEquals("\u0001", StringUtil.getString(new byte[]{'A', -64, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Method under test: {@link StringUtil#join(String, String[])}
   */
  @Test
  public void testJoin() {
    // Arrange, Act and Assert
    assertEquals("Strings", StringUtil.join("Separator", "Strings"));
    assertEquals("StringsSeparator]", StringUtil.join("Separator", "Strings", "]"));
  }

  /**
   * Method under test: {@link StringUtil#toHexString(byte[])}
   */
  @Test
  public void testToHexString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", StringUtil.toHexString("AXAXAXAX".getBytes("UTF-8")));
    assertNull(StringUtil.toHexString(null));
    assertEquals("0F58415841584158", StringUtil.toHexString(new byte[]{15, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertEquals(
        "410123456789ABCDEF580123456789ABCDEF410123456789ABCDEF580123456789ABCDEF410123456789ABCDEF5801234567"
            + "89ABCDEF410123456789ABCDEF58",
        StringUtil.toHexString("AXAXAXAX".getBytes("UTF-8"), "0123456789ABCDEF", true));
    assertNull(StringUtil.toHexString(null, null, false));
    assertEquals("4158415841584158",
        StringUtil.toHexString(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null, false));
    assertEquals(
        "0F0123456789ABCDEF580123456789ABCDEF410123456789ABCDEF580123456789ABCDEF410123456789ABCDEF5801234567"
            + "89ABCDEF410123456789ABCDEF58",
        StringUtil.toHexString(new byte[]{15, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "0123456789ABCDEF", true));
    assertEquals(
        "0f0123456789ABCDEF580123456789ABCDEF410123456789ABCDEF580123456789ABCDEF410123456789ABCDEF5801234567"
            + "89ABCDEF410123456789ABCDEF58",
        StringUtil.toHexString(new byte[]{15, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "0123456789ABCDEF", false));
  }

  /**
   * Method under test: {@link StringUtil#escapeControlCharacters(String)}
   */
  @Test
  public void testEscapeControlCharacters() {
    // Arrange, Act and Assert
    assertEquals("Input", StringUtil.escapeControlCharacters("Input"));
    assertEquals("\\n", StringUtil.escapeControlCharacters("\n"));
    assertEquals("\\r", StringUtil.escapeControlCharacters("\r"));
    assertEquals("\\t", StringUtil.escapeControlCharacters("\t"));
    assertEquals("\\f", StringUtil.escapeControlCharacters("\f"));
    assertEquals("\\b", StringUtil.escapeControlCharacters("\b"));
    assertEquals("\\n\\n", StringUtil.escapeControlCharacters("\n\n"));
    assertEquals("\\n\\r", StringUtil.escapeControlCharacters("\n\r"));
    assertEquals("\\n\\t", StringUtil.escapeControlCharacters("\n\t"));
    assertEquals("\\n\\f", StringUtil.escapeControlCharacters("\n\f"));
    assertEquals("\\n\\b", StringUtil.escapeControlCharacters("\n\b"));
    assertEquals("\\n\\\\n", StringUtil.escapeControlCharacters("\n\\\\n"));
    assertEquals("\\nInput", StringUtil.escapeControlCharacters("\nInput"));
    assertEquals("\\n\\\\r", StringUtil.escapeControlCharacters("\n\\\\r"));
    assertEquals("\\n]", StringUtil.escapeControlCharacters("\n]"));
    assertEquals("\\n42", StringUtil.escapeControlCharacters("\n42"));
    assertEquals("\\n\\\\t", StringUtil.escapeControlCharacters("\n\\\\t"));
    assertEquals("\\n\\\\f", StringUtil.escapeControlCharacters("\n\\\\f"));
    assertEquals("\\n\\\\b", StringUtil.escapeControlCharacters("\n\\\\b"));
    assertEquals("\\r\\n", StringUtil.escapeControlCharacters("\r\n"));
    assertEquals("\\r\\r", StringUtil.escapeControlCharacters("\r\r"));
    assertEquals("\\r\\t", StringUtil.escapeControlCharacters("\r\t"));
    assertEquals("\\r\\f", StringUtil.escapeControlCharacters("\r\f"));
    assertEquals("\\r\\b", StringUtil.escapeControlCharacters("\r\b"));
    assertEquals("\\r\\\\n", StringUtil.escapeControlCharacters("\r\\\\n"));
    assertEquals("\\rInput", StringUtil.escapeControlCharacters("\rInput"));
    assertEquals("\\r\\\\r", StringUtil.escapeControlCharacters("\r\\\\r"));
    assertEquals("\\r]", StringUtil.escapeControlCharacters("\r]"));
    assertEquals("\\r42", StringUtil.escapeControlCharacters("\r42"));
    assertEquals("\\r\\\\t", StringUtil.escapeControlCharacters("\r\\\\t"));
    assertEquals("\\r\\\\f", StringUtil.escapeControlCharacters("\r\\\\f"));
    assertEquals("\\r\\\\b", StringUtil.escapeControlCharacters("\r\\\\b"));
    assertEquals("\\t\\n", StringUtil.escapeControlCharacters("\t\n"));
    assertEquals("\\t\\r", StringUtil.escapeControlCharacters("\t\r"));
    assertEquals("\\t\\t", StringUtil.escapeControlCharacters("\t\t"));
    assertEquals("\\t\\f", StringUtil.escapeControlCharacters("\t\f"));
    assertEquals("\\t\\b", StringUtil.escapeControlCharacters("\t\b"));
    assertEquals("\\t\\\\n", StringUtil.escapeControlCharacters("\t\\\\n"));
    assertEquals("\\tInput", StringUtil.escapeControlCharacters("\tInput"));
    assertEquals("\\t\\\\r", StringUtil.escapeControlCharacters("\t\\\\r"));
    assertEquals("\\t]", StringUtil.escapeControlCharacters("\t]"));
    assertEquals("\\t42", StringUtil.escapeControlCharacters("\t42"));
    assertEquals("\\t\\\\t", StringUtil.escapeControlCharacters("\t\\\\t"));
    assertEquals("\\t\\\\f", StringUtil.escapeControlCharacters("\t\\\\f"));
    assertEquals("\\t\\\\b", StringUtil.escapeControlCharacters("\t\\\\b"));
    assertEquals("\\f\\n", StringUtil.escapeControlCharacters("\f\n"));
    assertEquals("\\f\\r", StringUtil.escapeControlCharacters("\f\r"));
    assertEquals("\\f\\t", StringUtil.escapeControlCharacters("\f\t"));
    assertEquals("\\f\\f", StringUtil.escapeControlCharacters("\f\f"));
    assertEquals("\\f\\b", StringUtil.escapeControlCharacters("\f\b"));
    assertEquals("\\f\\\\n", StringUtil.escapeControlCharacters("\f\\\\n"));
    assertEquals("\\fInput", StringUtil.escapeControlCharacters("\fInput"));
    assertEquals("\\f\\\\r", StringUtil.escapeControlCharacters("\f\\\\r"));
    assertEquals("\\f]", StringUtil.escapeControlCharacters("\f]"));
    assertEquals("\\f42", StringUtil.escapeControlCharacters("\f42"));
    assertEquals("\\f\\\\t", StringUtil.escapeControlCharacters("\f\\\\t"));
    assertEquals("\\f\\\\f", StringUtil.escapeControlCharacters("\f\\\\f"));
    assertEquals("\\f\\\\b", StringUtil.escapeControlCharacters("\f\\\\b"));
    assertEquals("\\b\\n", StringUtil.escapeControlCharacters("\b\n"));
    assertEquals("\\b\\r", StringUtil.escapeControlCharacters("\b\r"));
    assertEquals("\\b\\t", StringUtil.escapeControlCharacters("\b\t"));
    assertEquals("\\b\\f", StringUtil.escapeControlCharacters("\b\f"));
    assertEquals("\\b\\b", StringUtil.escapeControlCharacters("\b\b"));
    assertEquals("\\b\\\\n", StringUtil.escapeControlCharacters("\b\\\\n"));
    assertEquals("\\bInput", StringUtil.escapeControlCharacters("\bInput"));
    assertEquals("\\b\\\\r", StringUtil.escapeControlCharacters("\b\\\\r"));
    assertEquals("\\b]", StringUtil.escapeControlCharacters("\b]"));
    assertEquals("\\b42", StringUtil.escapeControlCharacters("\b42"));
    assertEquals("\\b\\\\t", StringUtil.escapeControlCharacters("\b\\\\t"));
    assertEquals("\\b\\\\f", StringUtil.escapeControlCharacters("\b\\\\f"));
    assertEquals("\\b\\\\b", StringUtil.escapeControlCharacters("\b\\\\b"));
    assertEquals("\\\\n\\n", StringUtil.escapeControlCharacters("\\\\n\n"));
    assertEquals("\\\\n\\r", StringUtil.escapeControlCharacters("\\\\n\r"));
    assertEquals("\\\\n\\t", StringUtil.escapeControlCharacters("\\\\n\t"));
    assertEquals("\\\\n\\f", StringUtil.escapeControlCharacters("\\\\n\f"));
    assertEquals("\\\\n\\b", StringUtil.escapeControlCharacters("\\\\n\b"));
    assertEquals("Input\\n", StringUtil.escapeControlCharacters("Input\n"));
    assertEquals("Input\\r", StringUtil.escapeControlCharacters("Input\r"));
    assertEquals("Input\\t", StringUtil.escapeControlCharacters("Input\t"));
    assertEquals("Input\\f", StringUtil.escapeControlCharacters("Input\f"));
    assertEquals("Input\\b", StringUtil.escapeControlCharacters("Input\b"));
    assertEquals("\\\\r\\n", StringUtil.escapeControlCharacters("\\\\r\n"));
    assertEquals("\\\\r\\r", StringUtil.escapeControlCharacters("\\\\r\r"));
    assertEquals("\\\\r\\t", StringUtil.escapeControlCharacters("\\\\r\t"));
    assertEquals("\\\\r\\f", StringUtil.escapeControlCharacters("\\\\r\f"));
    assertEquals("\\\\r\\b", StringUtil.escapeControlCharacters("\\\\r\b"));
    assertEquals("]\\n", StringUtil.escapeControlCharacters("]\n"));
    assertEquals("]\\r", StringUtil.escapeControlCharacters("]\r"));
    assertEquals("]\\t", StringUtil.escapeControlCharacters("]\t"));
    assertEquals("]\\f", StringUtil.escapeControlCharacters("]\f"));
    assertEquals("]\\b", StringUtil.escapeControlCharacters("]\b"));
    assertEquals("42\\n", StringUtil.escapeControlCharacters("42\n"));
    assertEquals("42\\r", StringUtil.escapeControlCharacters("42\r"));
    assertEquals("42\\t", StringUtil.escapeControlCharacters("42\t"));
    assertEquals("42\\f", StringUtil.escapeControlCharacters("42\f"));
    assertEquals("42\\b", StringUtil.escapeControlCharacters("42\b"));
    assertEquals("\\\\t\\n", StringUtil.escapeControlCharacters("\\\\t\n"));
    assertEquals("\\\\t\\r", StringUtil.escapeControlCharacters("\\\\t\r"));
    assertEquals("\\\\t\\t", StringUtil.escapeControlCharacters("\\\\t\t"));
    assertEquals("\\\\t\\f", StringUtil.escapeControlCharacters("\\\\t\f"));
    assertEquals("\\\\t\\b", StringUtil.escapeControlCharacters("\\\\t\b"));
    assertEquals("\\\\f\\n", StringUtil.escapeControlCharacters("\\\\f\n"));
    assertEquals("\\\\f\\r", StringUtil.escapeControlCharacters("\\\\f\r"));
    assertEquals("\\\\f\\t", StringUtil.escapeControlCharacters("\\\\f\t"));
    assertEquals("\\\\f\\f", StringUtil.escapeControlCharacters("\\\\f\f"));
    assertEquals("\\\\f\\b", StringUtil.escapeControlCharacters("\\\\f\b"));
    assertEquals("\\\\b\\n", StringUtil.escapeControlCharacters("\\\\b\n"));
    assertEquals("\\\\b\\r", StringUtil.escapeControlCharacters("\\\\b\r"));
    assertEquals("\\\\b\\t", StringUtil.escapeControlCharacters("\\\\b\t"));
    assertEquals("\\\\b\\f", StringUtil.escapeControlCharacters("\\\\b\f"));
    assertEquals("\\\\b\\b", StringUtil.escapeControlCharacters("\\\\b\b"));
    assertEquals("\\n\\n\\n", StringUtil.escapeControlCharacters("\n\n\n"));
    assertEquals("\\n\\n\\r", StringUtil.escapeControlCharacters("\n\n\r"));
    assertEquals("\\n\\n\\t", StringUtil.escapeControlCharacters("\n\n\t"));
    assertEquals("\\n\\n\\f", StringUtil.escapeControlCharacters("\n\n\f"));
    assertEquals("\\n\\n\\b", StringUtil.escapeControlCharacters("\n\n\b"));
    assertEquals("\\n\\n\\\\n", StringUtil.escapeControlCharacters("\n\n\\\\n"));
    assertEquals("\\n\\nInput", StringUtil.escapeControlCharacters("\n\nInput"));
    assertEquals("\\n\\n\\\\r", StringUtil.escapeControlCharacters("\n\n\\\\r"));
    assertEquals("\\n\\n]", StringUtil.escapeControlCharacters("\n\n]"));
    assertEquals("\\n\\n42", StringUtil.escapeControlCharacters("\n\n42"));
    assertEquals("\\n\\n\\\\t", StringUtil.escapeControlCharacters("\n\n\\\\t"));
    assertEquals("\\n\\n\\\\f", StringUtil.escapeControlCharacters("\n\n\\\\f"));
    assertEquals("\\n\\n\\\\b", StringUtil.escapeControlCharacters("\n\n\\\\b"));
    assertEquals("\\n\\r\\n", StringUtil.escapeControlCharacters("\n\r\n"));
    assertEquals("\\n\\r\\r", StringUtil.escapeControlCharacters("\n\r\r"));
    assertEquals("\\n\\r\\t", StringUtil.escapeControlCharacters("\n\r\t"));
    assertEquals("\\n\\r\\f", StringUtil.escapeControlCharacters("\n\r\f"));
    assertEquals("\\n\\r\\b", StringUtil.escapeControlCharacters("\n\r\b"));
    assertEquals("\\n\\r\\\\n", StringUtil.escapeControlCharacters("\n\r\\\\n"));
    assertEquals("\\n\\rInput", StringUtil.escapeControlCharacters("\n\rInput"));
    assertEquals("\\n\\r\\\\r", StringUtil.escapeControlCharacters("\n\r\\\\r"));
    assertEquals("\\n\\r]", StringUtil.escapeControlCharacters("\n\r]"));
    assertEquals("\\n\\r42", StringUtil.escapeControlCharacters("\n\r42"));
    assertEquals("\\n\\r\\\\t", StringUtil.escapeControlCharacters("\n\r\\\\t"));
    assertEquals("\\n\\r\\\\f", StringUtil.escapeControlCharacters("\n\r\\\\f"));
    assertEquals("\\n\\r\\\\b", StringUtil.escapeControlCharacters("\n\r\\\\b"));
    assertEquals("\\n\\t\\n", StringUtil.escapeControlCharacters("\n\t\n"));
    assertEquals("\\n\\t\\r", StringUtil.escapeControlCharacters("\n\t\r"));
    assertEquals("\\n\\t\\t", StringUtil.escapeControlCharacters("\n\t\t"));
    assertEquals("\\n\\t\\f", StringUtil.escapeControlCharacters("\n\t\f"));
    assertEquals("\\n\\t\\b", StringUtil.escapeControlCharacters("\n\t\b"));
    assertEquals("\\n\\t\\\\n", StringUtil.escapeControlCharacters("\n\t\\\\n"));
    assertEquals("\\n\\tInput", StringUtil.escapeControlCharacters("\n\tInput"));
    assertEquals("\\n\\t\\\\r", StringUtil.escapeControlCharacters("\n\t\\\\r"));
    assertEquals("\\n\\t]", StringUtil.escapeControlCharacters("\n\t]"));
    assertEquals("\\n\\t42", StringUtil.escapeControlCharacters("\n\t42"));
    assertEquals("\\n\\t\\\\t", StringUtil.escapeControlCharacters("\n\t\\\\t"));
    assertEquals("\\n\\t\\\\f", StringUtil.escapeControlCharacters("\n\t\\\\f"));
    assertEquals("\\n\\t\\\\b", StringUtil.escapeControlCharacters("\n\t\\\\b"));
    assertEquals("\\n\\f\\n", StringUtil.escapeControlCharacters("\n\f\n"));
    assertEquals("\\n\\f\\r", StringUtil.escapeControlCharacters("\n\f\r"));
    assertEquals("\\n\\f\\t", StringUtil.escapeControlCharacters("\n\f\t"));
    assertEquals("\\n\\f\\f", StringUtil.escapeControlCharacters("\n\f\f"));
    assertEquals("\\n\\f\\b", StringUtil.escapeControlCharacters("\n\f\b"));
    assertEquals("\\n\\f\\\\n", StringUtil.escapeControlCharacters("\n\f\\\\n"));
    assertEquals("\\n\\fInput", StringUtil.escapeControlCharacters("\n\fInput"));
    assertEquals("\\n\\f\\\\r", StringUtil.escapeControlCharacters("\n\f\\\\r"));
    assertEquals("\\n\\f]", StringUtil.escapeControlCharacters("\n\f]"));
    assertEquals("\\n\\f42", StringUtil.escapeControlCharacters("\n\f42"));
    assertEquals("\\n\\f\\\\t", StringUtil.escapeControlCharacters("\n\f\\\\t"));
    assertEquals("\\n\\f\\\\f", StringUtil.escapeControlCharacters("\n\f\\\\f"));
    assertEquals("\\n\\f\\\\b", StringUtil.escapeControlCharacters("\n\f\\\\b"));
    assertEquals("\\n\\b\\n", StringUtil.escapeControlCharacters("\n\b\n"));
    assertEquals("\\n\\b\\r", StringUtil.escapeControlCharacters("\n\b\r"));
    assertEquals("\\n\\b\\t", StringUtil.escapeControlCharacters("\n\b\t"));
    assertEquals("\\n\\b\\f", StringUtil.escapeControlCharacters("\n\b\f"));
    assertEquals("\\n\\b\\b", StringUtil.escapeControlCharacters("\n\b\b"));
    assertEquals("\\n\\b\\\\n", StringUtil.escapeControlCharacters("\n\b\\\\n"));
    assertEquals("\\n\\bInput", StringUtil.escapeControlCharacters("\n\bInput"));
    assertEquals("\\n\\b\\\\r", StringUtil.escapeControlCharacters("\n\b\\\\r"));
    assertEquals("\\n\\b]", StringUtil.escapeControlCharacters("\n\b]"));
    assertEquals("\\n\\b42", StringUtil.escapeControlCharacters("\n\b42"));
    assertEquals("\\n\\b\\\\t", StringUtil.escapeControlCharacters("\n\b\\\\t"));
    assertEquals("\\n\\b\\\\f", StringUtil.escapeControlCharacters("\n\b\\\\f"));
    assertEquals("\\n\\b\\\\b", StringUtil.escapeControlCharacters("\n\b\\\\b"));
    assertEquals("\\n\\\\n\\n", StringUtil.escapeControlCharacters("\n\\\\n\n"));
    assertEquals("\\n\\\\n\\r", StringUtil.escapeControlCharacters("\n\\\\n\r"));
    assertEquals("\\n\\\\n\\t", StringUtil.escapeControlCharacters("\n\\\\n\t"));
    assertEquals("\\n\\\\n\\f", StringUtil.escapeControlCharacters("\n\\\\n\f"));
    assertEquals("\\n\\\\n\\b", StringUtil.escapeControlCharacters("\n\\\\n\b"));
    assertEquals("\\n\\\\n\\\\n", StringUtil.escapeControlCharacters("\n\\\\n\\\\n"));
    assertEquals("\\n\\\\nInput", StringUtil.escapeControlCharacters("\n\\\\nInput"));
    assertEquals("\\n\\\\n\\\\r", StringUtil.escapeControlCharacters("\n\\\\n\\\\r"));
    assertEquals("\\n\\\\n]", StringUtil.escapeControlCharacters("\n\\\\n]"));
    assertEquals("\\n\\\\n42", StringUtil.escapeControlCharacters("\n\\\\n42"));
    assertEquals("\\n\\\\n\\\\t", StringUtil.escapeControlCharacters("\n\\\\n\\\\t"));
    assertEquals("\\n\\\\n\\\\f", StringUtil.escapeControlCharacters("\n\\\\n\\\\f"));
    assertEquals("\\n\\\\n\\\\b", StringUtil.escapeControlCharacters("\n\\\\n\\\\b"));
    assertEquals("\\nInput\\n", StringUtil.escapeControlCharacters("\nInput\n"));
    assertEquals("\\nInput\\r", StringUtil.escapeControlCharacters("\nInput\r"));
    assertEquals("\\nInput\\t", StringUtil.escapeControlCharacters("\nInput\t"));
    assertEquals("\\nInput\\f", StringUtil.escapeControlCharacters("\nInput\f"));
    assertEquals("\\nInput\\b", StringUtil.escapeControlCharacters("\nInput\b"));
    assertEquals("\\nInput\\\\n", StringUtil.escapeControlCharacters("\nInput\\\\n"));
    assertEquals("\\nInputInput", StringUtil.escapeControlCharacters("\nInputInput"));
    assertEquals("\\nInput\\\\r", StringUtil.escapeControlCharacters("\nInput\\\\r"));
    assertEquals("\\nInput]", StringUtil.escapeControlCharacters("\nInput]"));
    assertEquals("\\nInput42", StringUtil.escapeControlCharacters("\nInput42"));
    assertEquals("\\nInput\\\\t", StringUtil.escapeControlCharacters("\nInput\\\\t"));
    assertEquals("\\nInput\\\\f", StringUtil.escapeControlCharacters("\nInput\\\\f"));
    assertEquals("\\nInput\\\\b", StringUtil.escapeControlCharacters("\nInput\\\\b"));
    assertEquals("\\n\\\\r\\n", StringUtil.escapeControlCharacters("\n\\\\r\n"));
    assertEquals("\\n\\\\r\\r", StringUtil.escapeControlCharacters("\n\\\\r\r"));
    assertEquals("\\n\\\\r\\t", StringUtil.escapeControlCharacters("\n\\\\r\t"));
    assertEquals("\\n\\\\r\\f", StringUtil.escapeControlCharacters("\n\\\\r\f"));
    assertEquals("\\n\\\\r\\b", StringUtil.escapeControlCharacters("\n\\\\r\b"));
    assertEquals("\\n\\\\r\\\\n", StringUtil.escapeControlCharacters("\n\\\\r\\\\n"));
    assertEquals("\\n\\\\rInput", StringUtil.escapeControlCharacters("\n\\\\rInput"));
    assertEquals("\\n\\\\r\\\\r", StringUtil.escapeControlCharacters("\n\\\\r\\\\r"));
    assertEquals("\\n\\\\r]", StringUtil.escapeControlCharacters("\n\\\\r]"));
    assertEquals("\\n\\\\r42", StringUtil.escapeControlCharacters("\n\\\\r42"));
    assertEquals("\\n\\\\r\\\\t", StringUtil.escapeControlCharacters("\n\\\\r\\\\t"));
    assertEquals("\\n\\\\r\\\\f", StringUtil.escapeControlCharacters("\n\\\\r\\\\f"));
    assertEquals("\\n\\\\r\\\\b", StringUtil.escapeControlCharacters("\n\\\\r\\\\b"));
    assertEquals("\\n]\\n", StringUtil.escapeControlCharacters("\n]\n"));
    assertEquals("\\n]\\r", StringUtil.escapeControlCharacters("\n]\r"));
    assertEquals("\\n]\\t", StringUtil.escapeControlCharacters("\n]\t"));
    assertEquals("\\n]\\f", StringUtil.escapeControlCharacters("\n]\f"));
    assertEquals("\\n]\\b", StringUtil.escapeControlCharacters("\n]\b"));
    assertEquals("\\n]\\\\n", StringUtil.escapeControlCharacters("\n]\\\\n"));
    assertEquals("\\n]Input", StringUtil.escapeControlCharacters("\n]Input"));
    assertEquals("\\n]\\\\r", StringUtil.escapeControlCharacters("\n]\\\\r"));
    assertEquals("\\n]]", StringUtil.escapeControlCharacters("\n]]"));
    assertEquals("\\n]42", StringUtil.escapeControlCharacters("\n]42"));
    assertEquals("\\n]\\\\t", StringUtil.escapeControlCharacters("\n]\\\\t"));
    assertEquals("\\n]\\\\f", StringUtil.escapeControlCharacters("\n]\\\\f"));
    assertEquals("\\n]\\\\b", StringUtil.escapeControlCharacters("\n]\\\\b"));
    assertEquals("\\n42\\n", StringUtil.escapeControlCharacters("\n42\n"));
    assertEquals("\\n42\\r", StringUtil.escapeControlCharacters("\n42\r"));
    assertEquals("\\n42\\t", StringUtil.escapeControlCharacters("\n42\t"));
    assertEquals("\\n42\\f", StringUtil.escapeControlCharacters("\n42\f"));
    assertEquals("\\n42\\b", StringUtil.escapeControlCharacters("\n42\b"));
    assertEquals("\\n42\\\\n", StringUtil.escapeControlCharacters("\n42\\\\n"));
    assertEquals("\\n42Input", StringUtil.escapeControlCharacters("\n42Input"));
    assertEquals("\\n42\\\\r", StringUtil.escapeControlCharacters("\n42\\\\r"));
    assertEquals("\\n42]", StringUtil.escapeControlCharacters("\n42]"));
    assertEquals("\\n4242", StringUtil.escapeControlCharacters("\n4242"));
    assertEquals("\\n42\\\\t", StringUtil.escapeControlCharacters("\n42\\\\t"));
    assertEquals("\\n42\\\\f", StringUtil.escapeControlCharacters("\n42\\\\f"));
    assertEquals("\\n42\\\\b", StringUtil.escapeControlCharacters("\n42\\\\b"));
    assertEquals("\\n\\\\t\\n", StringUtil.escapeControlCharacters("\n\\\\t\n"));
  }

  /**
   * Method under test: {@link StringUtil#listToString(List)}
   */
  @Test
  public void testListToString() {
    // Arrange, Act and Assert
    assertEquals("[]", StringUtil.listToString(new ArrayList<>()));
  }

  /**
   * Method under test: {@link StringUtil#listToString(List)}
   */
  @Test
  public void testListToString2() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("[%s]");

    // Act and Assert
    assertEquals("[\"[%s]\"]", StringUtil.listToString(stringList));
  }

  /**
   * Method under test: {@link StringUtil#listToString(List)}
   */
  @Test
  public void testListToString3() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(", ");
    stringList.add("[%s]");

    // Act and Assert
    assertEquals("[\", \", \"[%s]\"]", StringUtil.listToString(stringList));
  }
}

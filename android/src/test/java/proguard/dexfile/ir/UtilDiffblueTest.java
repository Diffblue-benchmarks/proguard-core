package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class UtilDiffblueTest {
  /**
   * Method under test: {@link Util#listDesc(String)}
   */
  @Test
  public void testListDesc() {
    // Arrange and Act
    List<String> actualListDescResult = Util.listDesc("");

    // Assert
    assertTrue(actualListDescResult.isEmpty());
  }

  /**
   * Method under test: {@link Util#appendString(StringBuffer, String)}
   */
  @Test
  public void testAppendString() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    Util.appendString(buf, "foo");

    // Assert
    assertEquals("foo\"foo\"", buf.toString());
  }

  /**
   * Method under test: {@link Util#appendString(StringBuffer, String)}
   */
  @Test
  public void testAppendString2() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    Util.appendString(buf, "\\\"");

    // Assert
    assertEquals("foo\"\\\\\\\"\"", buf.toString());
  }

  /**
   * Method under test: {@link Util#toShortClassName(String)}
   */
  @Test
  public void testToShortClassName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> Util.toShortClassName("The characteristics of someone or something"));
    assertEquals("", Util.toShortClassName(null));
    assertEquals("", Util.toShortClassName(""));
    assertEquals("double", Util.toShortClassName("Desc"));
  }

  /**
   * Method under test: {@link Util#isMemoryLimitReached(long)}
   */
  @Test
  public void testIsMemoryLimitReached() {
    // Arrange, Act and Assert
    assertFalse(Util.isMemoryLimitReached(1L));
    assertFalse(Util.isMemoryLimitReached(0L));
    assertTrue(Util.isMemoryLimitReached(Long.MAX_VALUE));
  }
}

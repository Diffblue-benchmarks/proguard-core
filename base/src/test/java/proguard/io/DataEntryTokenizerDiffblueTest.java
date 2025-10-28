package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import java.io.StringReader;
import org.junit.Test;

public class DataEntryTokenizerDiffblueTest {
  /**
   * Method under test: {@link DataEntryTokenizer#nextToken()}
   */
  @Test
  public void testNextToken() throws IOException {
    // Arrange and Act
    DataEntryToken actualNextTokenResult = (new DataEntryTokenizer(new StringReader("foo"))).nextToken();

    // Assert
    assertEquals("foo", actualNextTokenResult.string);
    assertEquals(DataEntryTokenType.JAVA_IDENTIFIER, actualNextTokenResult.type);
  }

  /**
   * Method under test: {@link DataEntryTokenizer#nextToken()}
   */
  @Test
  public void testNextToken2() throws IOException {
    // Arrange, Act and Assert
    assertNull((new DataEntryTokenizer(new StringReader(""))).nextToken());
  }
}

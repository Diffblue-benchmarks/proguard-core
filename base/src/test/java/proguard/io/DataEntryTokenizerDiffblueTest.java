package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.StringReader;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataEntryTokenizerDiffblueTest {
  /**
   * Test {@link DataEntryTokenizer#nextToken()}.
   *
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryTokenizer#nextToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryToken DataEntryTokenizer.nextToken()"})
  public void testNextToken_givenStringReaderWithEmptyString_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new DataEntryTokenizer(new StringReader(""))).nextToken());
  }

  /**
   * Test {@link DataEntryTokenizer#nextToken()}.
   *
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then return {@link DataEntryToken#string} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryTokenizer#nextToken()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryToken DataEntryTokenizer.nextToken()"})
  public void testNextToken_givenStringReaderWithFoo_thenReturnStringIsFoo() throws IOException {
    // Arrange and Act
    DataEntryToken actualNextTokenResult =
        (new DataEntryTokenizer(new StringReader("foo"))).nextToken();

    // Assert
    assertEquals("foo", actualNextTokenResult.string);
    assertEquals(DataEntryTokenType.JAVA_IDENTIFIER, actualNextTokenResult.type);
  }
}

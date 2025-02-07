package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataEntryTokenizerDiffblueTest {
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
  @DisplayName("Test nextToken(); given StringReader(String) with empty string; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.io.DataEntryToken proguard.io.DataEntryTokenizer.nextToken()"})
  void testNextToken_givenStringReaderWithEmptyString_thenReturnNull() throws IOException {
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
  @DisplayName(
      "Test nextToken(); given StringReader(String) with 'foo'; then return string is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.io.DataEntryToken proguard.io.DataEntryTokenizer.nextToken()"})
  void testNextToken_givenStringReaderWithFoo_thenReturnStringIsFoo() throws IOException {
    // Arrange and Act
    DataEntryToken actualNextTokenResult =
        (new DataEntryTokenizer(new StringReader("foo"))).nextToken();

    // Assert
    assertEquals("foo", actualNextTokenResult.string);
    assertEquals(DataEntryTokenType.JAVA_IDENTIFIER, actualNextTokenResult.type);
  }
}

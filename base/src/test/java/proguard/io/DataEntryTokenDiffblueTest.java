package proguard.io;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DataEntryTokenDiffblueTest {
  /**
   * Method under test:
   * {@link DataEntryToken#DataEntryToken(String, DataEntryTokenType)}
   */
  @Test
  public void testNewDataEntryToken() {
    // Arrange and Act
    DataEntryToken actualDataEntryToken = new DataEntryToken("String", DataEntryTokenType.JAVA_IDENTIFIER);

    // Assert
    assertEquals("String", actualDataEntryToken.string);
    assertEquals(DataEntryTokenType.JAVA_IDENTIFIER, actualDataEntryToken.type);
  }
}

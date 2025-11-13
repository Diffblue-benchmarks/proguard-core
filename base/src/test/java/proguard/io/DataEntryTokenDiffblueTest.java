package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataEntryTokenDiffblueTest {
  /**
   * Test {@link DataEntryToken#DataEntryToken(String, DataEntryTokenType)}.
   *
   * <p>Method under test: {@link DataEntryToken#DataEntryToken(String, DataEntryTokenType)}
   */
  @Test
  @DisplayName("Test new DataEntryToken(String, DataEntryTokenType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataEntryToken.<init>(String, DataEntryTokenType)"})
  void testNewDataEntryToken() {
    // Arrange and Act
    DataEntryToken actualDataEntryToken =
        new DataEntryToken("String", DataEntryTokenType.JAVA_IDENTIFIER);

    // Assert
    assertEquals("String", actualDataEntryToken.string);
    assertEquals(DataEntryTokenType.JAVA_IDENTIFIER, actualDataEntryToken.type);
  }
}

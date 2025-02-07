package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.DataEntryToken.<init>(java.lang.String, proguard.io.DataEntryTokenType)"
  })
  void testNewDataEntryToken() {
    // Arrange and Act
    DataEntryToken actualDataEntryToken =
        new DataEntryToken("String", DataEntryTokenType.JAVA_IDENTIFIER);

    // Assert
    assertEquals("String", actualDataEntryToken.string);
    assertEquals(DataEntryTokenType.JAVA_IDENTIFIER, actualDataEntryToken.type);
  }
}

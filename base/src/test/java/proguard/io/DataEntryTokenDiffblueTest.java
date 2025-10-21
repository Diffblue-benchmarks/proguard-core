package proguard.io;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataEntryTokenDiffblueTest {
  /**
   * Test {@link DataEntryToken#DataEntryToken(String, DataEntryTokenType)}.
   *
   * <p>Method under test: {@link DataEntryToken#DataEntryToken(String, DataEntryTokenType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataEntryToken.<init>(String, DataEntryTokenType)"})
  public void testNewDataEntryToken() {
    // Arrange and Act
    DataEntryToken actualDataEntryToken =
        new DataEntryToken("String", DataEntryTokenType.JAVA_IDENTIFIER);

    // Assert
    assertEquals("String", actualDataEntryToken.string);
    assertEquals(DataEntryTokenType.JAVA_IDENTIFIER, actualDataEntryToken.type);
  }
}

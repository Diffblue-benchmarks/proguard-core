package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DexTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexType#DexType(String)}
   *   <li>{@link DexType#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexType.<init>(String)", "String DexType.toString()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "The characteristics of someone or something",
        new DexType("The characteristics of someone or something").toString());
  }
}

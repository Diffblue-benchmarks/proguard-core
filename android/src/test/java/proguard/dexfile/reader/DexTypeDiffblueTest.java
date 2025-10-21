package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DexTypeDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexType.<init>(String)", "String DexType.toString()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "The characteristics of someone or something",
        (new DexType("The characteristics of someone or something")).toString());
  }
}

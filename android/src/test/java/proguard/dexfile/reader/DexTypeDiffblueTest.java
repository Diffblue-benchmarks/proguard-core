package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DexTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DexType#DexType(String)}
   *   <li>{@link DexType#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("The characteristics of someone or something",
        (new DexType("The characteristics of someone or something")).toString());
  }
}

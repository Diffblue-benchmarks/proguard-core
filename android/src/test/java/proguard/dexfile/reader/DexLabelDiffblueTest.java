package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DexLabelDiffblueTest {
  /**
   * Method under test: {@link DexLabel#DexLabel(int)}
   */
  @Test
  public void testNewDexLabel() {
    // Arrange, Act and Assert
    assertEquals("L2", (new DexLabel(2)).toString());
  }
}

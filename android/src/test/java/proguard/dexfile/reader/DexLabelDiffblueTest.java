package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DexLabelDiffblueTest {
  /**
   * Test {@link DexLabel#DexLabel(int)}.
   *
   * <p>Method under test: {@link DexLabel#DexLabel(int)}
   */
  @Test
  @DisplayName("Test new DexLabel(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.DexLabel.<init>(int)"})
  void testNewDexLabel() {
    // Arrange, Act and Assert
    assertEquals("L2", (new DexLabel(2)).toString());
  }
}

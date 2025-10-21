package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DexLabelDiffblueTest {
  /**
   * Test {@link DexLabel#DexLabel(int)}.
   *
   * <p>Method under test: {@link DexLabel#DexLabel(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexLabel.<init>(int)"})
  public void testNewDexLabel() {
    // Arrange, Act and Assert
    assertEquals("L2", (new DexLabel(2)).toString());
  }
}

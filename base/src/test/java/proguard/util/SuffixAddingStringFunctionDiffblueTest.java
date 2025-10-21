package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SuffixAddingStringFunctionDiffblueTest {
  /**
   * Test {@link SuffixAddingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link SuffixAddingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SuffixAddingStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("StringSuffix", (new SuffixAddingStringFunction("Suffix")).transform("String"));
  }
}

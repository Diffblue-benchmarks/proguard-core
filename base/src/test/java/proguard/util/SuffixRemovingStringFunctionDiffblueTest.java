package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SuffixRemovingStringFunctionDiffblueTest {
  /**
   * Test {@link SuffixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link SuffixRemovingStringFunction#SuffixRemovingStringFunction(String)} with
   *       {@code Suffix}.
   * </ul>
   *
   * <p>Method under test: {@link SuffixRemovingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SuffixRemovingStringFunction.transform(String)"})
  public void testTransform_givenSuffixRemovingStringFunctionWithSuffix() {
    // Arrange, Act and Assert
    assertEquals("String", (new SuffixRemovingStringFunction("Suffix")).transform("String"));
  }

  /**
   * Test {@link SuffixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link SuffixRemovingStringFunction#SuffixRemovingStringFunction(String)} with
   *       suffix is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SuffixRemovingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SuffixRemovingStringFunction.transform(String)"})
  public void testTransform_givenSuffixRemovingStringFunctionWithSuffixIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("String", (new SuffixRemovingStringFunction("")).transform("String"));
  }
}

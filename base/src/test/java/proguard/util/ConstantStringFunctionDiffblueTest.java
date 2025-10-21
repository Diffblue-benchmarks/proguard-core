package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConstantStringFunctionDiffblueTest {
  /**
   * Test {@link ConstantStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link ConstantStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("String", (new ConstantStringFunction("String")).transform("String"));
  }
}

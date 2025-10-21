package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IdentityStringFunctionDiffblueTest {
  /**
   * Test {@link IdentityStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link IdentityStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IdentityStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("String", (new IdentityStringFunction()).transform("String"));
  }
}

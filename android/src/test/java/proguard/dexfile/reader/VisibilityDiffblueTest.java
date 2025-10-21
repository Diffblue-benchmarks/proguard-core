package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VisibilityDiffblueTest {
  /**
   * Test {@link Visibility#displayName()}.
   *
   * <p>Method under test: {@link Visibility#displayName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Visibility.displayName()"})
  public void testDisplayName() {
    // Arrange, Act and Assert
    assertEquals("build", Visibility.BUILD.displayName());
  }
}

package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VisibilityDiffblueTest {
  /**
   * Test {@link Visibility#displayName()}.
   *
   * <p>Method under test: {@link Visibility#displayName()}
   */
  @Test
  @DisplayName("Test displayName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.reader.Visibility.displayName()"})
  void testDisplayName() {
    // Arrange, Act and Assert
    assertEquals("build", Visibility.BUILD.displayName());
  }
}

package proguard.util;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapStringFunctionDiffblueTest {
  /**
   * Test {@link MapStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link MapStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MapStringFunction.transform(String)"})
  void testTransform() {
    // Arrange, Act and Assert
    assertNull(new MapStringFunction(new HashMap<>()).transform("String"));
  }
}

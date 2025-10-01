package proguard.resources.file.util;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.resources.file.ResourceFilePool;

class FilePoolNameFunctionDiffblueTest {
  /**
   * Test {@link FilePoolNameFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilePoolNameFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilePoolNameFunction.transform(String)"})
  void testTransform_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FilePoolNameFunction(new ResourceFilePool()).transform("String"));
  }
}

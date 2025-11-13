package proguard.util;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.kotlin.KotlinConstants;

class ClassPoolFeatureNameFunctionDiffblueTest {
  /**
   * Test {@link ClassPoolFeatureNameFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPoolFeatureNameFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPoolFeatureNameFunction.transform(String)"})
  void testTransform_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool).transform("String"));
  }

  /**
   * Test {@link ClassPoolFeatureNameFunction#transform(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPoolFeatureNameFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ClassPoolFeatureNameFunction.transform(String)"})
  void testTransform_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool).transform(""));
  }
}

package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleFeatureNamedProcessableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleFeatureNamedProcessable#SimpleFeatureNamedProcessable()}
   *   <li>{@link SimpleFeatureNamedProcessable#setFeatureName(String)}
   *   <li>{@link SimpleFeatureNamedProcessable#getExtraFeatureNames()}
   *   <li>{@link SimpleFeatureNamedProcessable#getFeatureName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return ProcessingInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleFeatureNamedProcessable.<init>()",
    "void SimpleFeatureNamedProcessable.<init>(String, int, Object)",
    "Set SimpleFeatureNamedProcessable.getExtraFeatureNames()",
    "String SimpleFeatureNamedProcessable.getFeatureName()",
    "void SimpleFeatureNamedProcessable.setFeatureName(String)"
  })
  void testGettersAndSetters_thenReturnProcessingInfoIsNull() {
    // Arrange and Act
    SimpleFeatureNamedProcessable actualSimpleFeatureNamedProcessable =
        new SimpleFeatureNamedProcessable();
    actualSimpleFeatureNamedProcessable.setFeatureName("Feature Name");
    Set<String> actualExtraFeatureNames =
        actualSimpleFeatureNamedProcessable.getExtraFeatureNames();

    // Assert
    assertEquals("Feature Name", actualSimpleFeatureNamedProcessable.getFeatureName());
    assertNull(actualSimpleFeatureNamedProcessable.getProcessingInfo());
    assertEquals(0, actualSimpleFeatureNamedProcessable.getProcessingFlags());
    assertTrue(actualExtraFeatureNames.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Feature Name}.
   *   <li>Then return {@code Processing Info}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleFeatureNamedProcessable#SimpleFeatureNamedProcessable(String, int, Object)}
   *   <li>{@link SimpleFeatureNamedProcessable#setFeatureName(String)}
   *   <li>{@link SimpleFeatureNamedProcessable#getExtraFeatureNames()}
   *   <li>{@link SimpleFeatureNamedProcessable#getFeatureName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Feature Name'; then return 'Processing Info'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleFeatureNamedProcessable.<init>()",
    "void SimpleFeatureNamedProcessable.<init>(String, int, Object)",
    "Set SimpleFeatureNamedProcessable.getExtraFeatureNames()",
    "String SimpleFeatureNamedProcessable.getFeatureName()",
    "void SimpleFeatureNamedProcessable.setFeatureName(String)"
  })
  void testGettersAndSetters_whenFeatureName_thenReturnProcessingInfo() {
    // Arrange and Act
    SimpleFeatureNamedProcessable actualSimpleFeatureNamedProcessable =
        new SimpleFeatureNamedProcessable("Feature Name", 1, "Processing Info");
    actualSimpleFeatureNamedProcessable.setFeatureName("Feature Name");
    Set<String> actualExtraFeatureNames =
        actualSimpleFeatureNamedProcessable.getExtraFeatureNames();

    // Assert
    assertEquals("Feature Name", actualSimpleFeatureNamedProcessable.getFeatureName());
    assertEquals("Processing Info", actualSimpleFeatureNamedProcessable.getProcessingInfo());
    assertEquals(1, actualSimpleFeatureNamedProcessable.getProcessingFlags());
    assertTrue(actualExtraFeatureNames.isEmpty());
  }

  /**
   * Test {@link SimpleFeatureNamedProcessable#addExtraFeatureName(String)}.
   *
   * <p>Method under test: {@link SimpleFeatureNamedProcessable#addExtraFeatureName(String)}
   */
  @Test
  @DisplayName("Test addExtraFeatureName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleFeatureNamedProcessable.addExtraFeatureName(String)"})
  void testAddExtraFeatureName() {
    // Arrange
    SimpleFeatureNamedProcessable simpleFeatureNamedProcessable =
        new SimpleFeatureNamedProcessable();

    // Act
    simpleFeatureNamedProcessable.addExtraFeatureName("Feature Name");

    // Assert
    Set<String> extraFeatureNames = simpleFeatureNamedProcessable.getExtraFeatureNames();
    assertEquals(1, extraFeatureNames.size());
    assertTrue(extraFeatureNames.contains("Feature Name"));
  }

  /**
   * Test {@link SimpleFeatureNamedProcessable#isInFeature(String)}.
   *
   * <ul>
   *   <li>Given {@link SimpleFeatureNamedProcessable#SimpleFeatureNamedProcessable()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleFeatureNamedProcessable#isInFeature(String)}
   */
  @Test
  @DisplayName(
      "Test isInFeature(String); given SimpleFeatureNamedProcessable(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleFeatureNamedProcessable.isInFeature(String)"})
  void testIsInFeature_givenSimpleFeatureNamedProcessable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SimpleFeatureNamedProcessable().isInFeature("Feature Name"));
  }

  /**
   * Test {@link SimpleFeatureNamedProcessable#isInFeature(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleFeatureNamedProcessable#isInFeature(String)}
   */
  @Test
  @DisplayName("Test isInFeature(String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleFeatureNamedProcessable.isInFeature(String)"})
  void testIsInFeature_thenReturnTrue() {
    // Arrange
    SimpleFeatureNamedProcessable simpleFeatureNamedProcessable =
        new SimpleFeatureNamedProcessable();
    simpleFeatureNamedProcessable.addExtraFeatureName("Feature Name");

    // Act and Assert
    assertTrue(simpleFeatureNamedProcessable.isInFeature("Feature Name"));
  }
}

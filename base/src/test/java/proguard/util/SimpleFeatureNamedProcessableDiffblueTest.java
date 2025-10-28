package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import org.junit.Test;

public class SimpleFeatureNamedProcessableDiffblueTest {
  /**
   * Method under test:
   * {@link SimpleFeatureNamedProcessable#addExtraFeatureName(String)}
   */
  @Test
  public void testAddExtraFeatureName() {
    // Arrange
    SimpleFeatureNamedProcessable simpleFeatureNamedProcessable = new SimpleFeatureNamedProcessable();

    // Act
    simpleFeatureNamedProcessable.addExtraFeatureName("Feature Name");

    // Assert
    Set<String> extraFeatureNames = simpleFeatureNamedProcessable.getExtraFeatureNames();
    assertEquals(1, extraFeatureNames.size());
    assertTrue(extraFeatureNames.contains("Feature Name"));
  }

  /**
   * Method under test: {@link SimpleFeatureNamedProcessable#isInFeature(String)}
   */
  @Test
  public void testIsInFeature() {
    // Arrange, Act and Assert
    assertFalse((new SimpleFeatureNamedProcessable()).isInFeature("Feature Name"));
  }

  /**
   * Method under test: {@link SimpleFeatureNamedProcessable#isInFeature(String)}
   */
  @Test
  public void testIsInFeature2() {
    // Arrange
    SimpleFeatureNamedProcessable simpleFeatureNamedProcessable = new SimpleFeatureNamedProcessable();
    simpleFeatureNamedProcessable.addExtraFeatureName("Feature Name");

    // Act and Assert
    assertTrue(simpleFeatureNamedProcessable.isInFeature("Feature Name"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleFeatureNamedProcessable#SimpleFeatureNamedProcessable()}
   *   <li>{@link SimpleFeatureNamedProcessable#setFeatureName(String)}
   *   <li>{@link SimpleFeatureNamedProcessable#getExtraFeatureNames()}
   *   <li>{@link SimpleFeatureNamedProcessable#getFeatureName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SimpleFeatureNamedProcessable actualSimpleFeatureNamedProcessable = new SimpleFeatureNamedProcessable();
    actualSimpleFeatureNamedProcessable.setFeatureName("Feature Name");
    Set<String> actualExtraFeatureNames = actualSimpleFeatureNamedProcessable.getExtraFeatureNames();

    // Assert that nothing has changed
    assertEquals("Feature Name", actualSimpleFeatureNamedProcessable.getFeatureName());
    assertEquals(0, actualSimpleFeatureNamedProcessable.getProcessingFlags());
    assertTrue(actualExtraFeatureNames.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SimpleFeatureNamedProcessable#SimpleFeatureNamedProcessable(String, int, Object)}
   *   <li>{@link SimpleFeatureNamedProcessable#setFeatureName(String)}
   *   <li>{@link SimpleFeatureNamedProcessable#getExtraFeatureNames()}
   *   <li>{@link SimpleFeatureNamedProcessable#getFeatureName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    SimpleFeatureNamedProcessable actualSimpleFeatureNamedProcessable = new SimpleFeatureNamedProcessable(
        "Feature Name", 1, "Processing Info");
    actualSimpleFeatureNamedProcessable.setFeatureName("Feature Name");
    Set<String> actualExtraFeatureNames = actualSimpleFeatureNamedProcessable.getExtraFeatureNames();

    // Assert that nothing has changed
    assertEquals("Feature Name", actualSimpleFeatureNamedProcessable.getFeatureName());
    assertEquals("Processing Info", actualSimpleFeatureNamedProcessable.getProcessingInfo());
    assertEquals(1, actualSimpleFeatureNamedProcessable.getProcessingFlags());
    assertTrue(actualExtraFeatureNames.isEmpty());
  }
}

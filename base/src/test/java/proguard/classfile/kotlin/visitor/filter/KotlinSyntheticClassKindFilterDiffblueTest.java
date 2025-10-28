package proguard.classfile.kotlin.visitor.filter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata;

public class KotlinSyntheticClassKindFilterDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  public void testIsLambda() {
    // Arrange, Act and Assert
    assertFalse(KotlinSyntheticClassKindFilter.isLambda(new KotlinSyntheticClassKindMetadata(new int[]{1, 3, 1, 3}, 1,
        "Xs", "Pn", KotlinSyntheticClassKindMetadata.Flavor.REGULAR)));
    assertTrue(KotlinSyntheticClassKindFilter.isLambda(new KotlinSyntheticClassKindMetadata(new int[]{1, 3, 1, 3}, 1,
        "Xs", "Pn", KotlinSyntheticClassKindMetadata.Flavor.LAMBDA)));
  }

  /**
   * Method under test:
   * {@link KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  public void testIsWhenMappings() {
    // Arrange, Act and Assert
    assertFalse(KotlinSyntheticClassKindFilter.isWhenMappings(new KotlinSyntheticClassKindMetadata(
        new int[]{1, 3, 1, 3}, 1, "Xs", "Pn", KotlinSyntheticClassKindMetadata.Flavor.REGULAR)));
    assertTrue(KotlinSyntheticClassKindFilter.isWhenMappings(new KotlinSyntheticClassKindMetadata(new int[]{1, 3, 1, 3},
        1, "Xs", "Pn", KotlinSyntheticClassKindMetadata.Flavor.WHEN_MAPPINGS)));
  }

  /**
   * Method under test:
   * {@link KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  public void testIsDefaultImpls() {
    // Arrange, Act and Assert
    assertFalse(KotlinSyntheticClassKindFilter.isDefaultImpls(new KotlinSyntheticClassKindMetadata(
        new int[]{1, 3, 1, 3}, 1, "Xs", "Pn", KotlinSyntheticClassKindMetadata.Flavor.REGULAR)));
    assertTrue(KotlinSyntheticClassKindFilter.isDefaultImpls(new KotlinSyntheticClassKindMetadata(new int[]{1, 3, 1, 3},
        1, "Xs", "Pn", KotlinSyntheticClassKindMetadata.Flavor.DEFAULT_IMPLS)));
  }
}

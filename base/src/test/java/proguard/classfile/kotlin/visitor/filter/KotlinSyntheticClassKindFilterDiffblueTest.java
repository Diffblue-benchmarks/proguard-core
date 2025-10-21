package proguard.classfile.kotlin.visitor.filter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;

public class KotlinSyntheticClassKindFilterDiffblueTest {
  /**
   * Test {@link KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinSyntheticClassKindFilter.isLambda(KotlinSyntheticClassKindMetadata)"
  })
  public void testIsLambda_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        KotlinSyntheticClassKindFilter.isLambda(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinSyntheticClassKindFilter.isLambda(KotlinSyntheticClassKindMetadata)"
  })
  public void testIsLambda_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        KotlinSyntheticClassKindFilter.isLambda(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.LAMBDA)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinSyntheticClassKindFilter.isWhenMappings(KotlinSyntheticClassKindMetadata)"
  })
  public void testIsWhenMappings_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        KotlinSyntheticClassKindFilter.isWhenMappings(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinSyntheticClassKindFilter.isWhenMappings(KotlinSyntheticClassKindMetadata)"
  })
  public void testIsWhenMappings_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        KotlinSyntheticClassKindFilter.isWhenMappings(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.WHEN_MAPPINGS)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinSyntheticClassKindFilter.isDefaultImpls(KotlinSyntheticClassKindMetadata)"
  })
  public void testIsDefaultImpls_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        KotlinSyntheticClassKindFilter.isDefaultImpls(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinSyntheticClassKindFilter.isDefaultImpls(KotlinSyntheticClassKindMetadata)"
  })
  public void testIsDefaultImpls_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        KotlinSyntheticClassKindFilter.isDefaultImpls(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.DEFAULT_IMPLS)));
  }
}

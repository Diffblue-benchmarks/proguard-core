package proguard.util;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.kotlin.KotlinConstants;

class BasicHierarchyProviderDiffblueTest {
  /**
   * Test {@link BasicHierarchyProvider#getClazz(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicHierarchyProvider#getClazz(String)}
   */
  @Test
  @DisplayName("Test getClazz(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.util.BasicHierarchyProvider.getClazz(java.lang.String)"
  })
  void testGetClazz_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .getClazz("Class Name"));
  }

  /**
   * Test {@link BasicHierarchyProvider#getSubClasses(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicHierarchyProvider#getSubClasses(String)}
   */
  @Test
  @DisplayName("Test getSubClasses(String); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.BasicHierarchyProvider.getSubClasses(java.lang.String)"
  })
  void testGetSubClasses_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .getSubClasses("Class Name")
            .isEmpty());
  }

  /**
   * Test {@link BasicHierarchyProvider#getSubClasses(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicHierarchyProvider#getSubClasses(String)}
   */
  @Test
  @DisplayName("Test getSubClasses(String); when empty string; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.BasicHierarchyProvider.getSubClasses(java.lang.String)"
  })
  void testGetSubClasses_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .getSubClasses("")
            .isEmpty());
  }
}

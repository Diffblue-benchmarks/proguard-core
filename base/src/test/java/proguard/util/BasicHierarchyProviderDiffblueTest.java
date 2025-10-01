package proguard.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Clazz BasicHierarchyProvider.getClazz(String)"})
  void testGetClazz_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)
            .getClazz("Class Name"));
  }

  /**
   * Test {@link BasicHierarchyProvider#getClazz(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link ProgramClass}.
   * </ul>
   *
   * <p>Method under test: {@link BasicHierarchyProvider#getClazz(String)}
   */
  @Test
  @DisplayName("Test getClazz(String); when empty string; then return ProgramClass")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Clazz BasicHierarchyProvider.getClazz(String)"})
  void testGetClazz_whenEmptyString_thenReturnProgramClass() {
    // Arrange and Act
    Clazz actualClazz =
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)
            .getClazz("");

    // Assert
    assertTrue(actualClazz instanceof ProgramClass);
    assertEquals("", actualClazz.getName());
    assertEquals("java/lang/Object", actualClazz.getSuperName());
    assertNull(actualClazz.getProcessingInfo());
    assertNull(actualClazz.getFeatureName());
    assertNull(actualClazz.getSuperClass());
    assertNull(((ProgramClass) actualClazz).kotlinMetadata);
    assertEquals(0, actualClazz.getInterfaceCount());
    assertEquals(0, ((ProgramClass) actualClazz).attributes.length);
    assertEquals(0, ((ProgramClass) actualClazz).fields.length);
    assertEquals(0, ((ProgramClass) actualClazz).methods.length);
    assertEquals(0, ((ProgramClass) actualClazz).subClasses.length);
    assertEquals(0, ((ProgramClass) actualClazz).subClassCount);
    assertEquals(0, ((ProgramClass) actualClazz).u2attributesCount);
    assertEquals(0, ((ProgramClass) actualClazz).u2fieldsCount);
    assertEquals(0, ((ProgramClass) actualClazz).u2methodsCount);
    assertEquals(1, actualClazz.getAccessFlags());
    assertEquals(2, ((ProgramClass) actualClazz).u2thisClass);
    assertEquals(256, ((ProgramClass) actualClazz).constantPool.length);
    assertEquals(4, ((ProgramClass) actualClazz).u2superClass);
    assertEquals(5, ((ProgramClass) actualClazz).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) actualClazz).u4version);
    assertTrue(actualClazz.getExtraFeatureNames().isEmpty());
    assertEquals(
        ProcessingFlags.DONT_SHRINK_OR_OPTIMIZE_OR_OBFUSCATE, actualClazz.getProcessingFlags());
    assertArrayEquals(new int[] {}, ((ProgramClass) actualClazz).u2interfaces);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set BasicHierarchyProvider.getSubClasses(String)"})
  void testGetSubClasses_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set BasicHierarchyProvider.getSubClasses(String)"})
  void testGetSubClasses_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)
            .getSubClasses("")
            .isEmpty());
  }
}

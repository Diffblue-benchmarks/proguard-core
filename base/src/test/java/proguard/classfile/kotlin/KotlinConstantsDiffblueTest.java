package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class KotlinConstantsDiffblueTest {
  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code multi-file class part}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @DisplayName("Test metadataKindToString(int); when five; then return 'multi-file class part'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  void testMetadataKindToString_whenFive_thenReturnMultiFileClassPart() {
    // Arrange, Act and Assert
    assertEquals("multi-file class part", KotlinConstants.metadataKindToString(5));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code multi-file class facade}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @DisplayName("Test metadataKindToString(int); when four; then return 'multi-file class facade'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  void testMetadataKindToString_whenFour_thenReturnMultiFileClassFacade() {
    // Arrange, Act and Assert
    assertEquals("multi-file class facade", KotlinConstants.metadataKindToString(4));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code class}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @DisplayName("Test metadataKindToString(int); when one; then return 'class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  void testMetadataKindToString_whenOne_thenReturnClass() {
    // Arrange, Act and Assert
    assertEquals("class", KotlinConstants.metadataKindToString(1));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code synthetic class}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @DisplayName("Test metadataKindToString(int); when three; then return 'synthetic class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  void testMetadataKindToString_whenThree_thenReturnSyntheticClass() {
    // Arrange, Act and Assert
    assertEquals("synthetic class", KotlinConstants.metadataKindToString(3));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code file facade}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @DisplayName("Test metadataKindToString(int); when two; then return 'file facade'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  void testMetadataKindToString_whenTwo_thenReturnFileFacade() {
    // Arrange, Act and Assert
    assertEquals("file facade", KotlinConstants.metadataKindToString(2));
  }

  /**
   * Test {@link KotlinConstants#metadataKindToString(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code unknown}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#metadataKindToString(int)}
   */
  @Test
  @DisplayName("Test metadataKindToString(int); when zero; then return 'unknown'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String KotlinConstants.metadataKindToString(int)"})
  void testMetadataKindToString_whenZero_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals("unknown", KotlinConstants.metadataKindToString(0));
  }

  /**
   * Test {@link KotlinConstants#getKotlinType(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstants#getKotlinType(Clazz)}
   */
  @Test
  @DisplayName("Test getKotlinType(Clazz); when LibraryClass(); then return LibraryClass")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Clazz KotlinConstants.getKotlinType(Clazz)"})
  void testGetKotlinType_whenLibraryClass_thenReturnLibraryClass() {
    // Arrange and Act
    Clazz actualKotlinType = KotlinConstants.getKotlinType(new LibraryClass());

    // Assert
    assertTrue(actualKotlinType instanceof LibraryClass);
    assertNull(actualKotlinType.getProcessingInfo());
    assertNull(actualKotlinType.getName());
    assertNull(actualKotlinType.getSuperName());
    assertNull(actualKotlinType.getFeatureName());
    assertNull(((LibraryClass) actualKotlinType).interfaceNames);
    assertNull(actualKotlinType.getSuperClass());
    assertNull(((LibraryClass) actualKotlinType).fields);
    assertNull(((LibraryClass) actualKotlinType).methods);
    assertNull(((LibraryClass) actualKotlinType).kotlinMetadata);
    assertEquals(0, actualKotlinType.getAccessFlags());
    assertEquals(0, actualKotlinType.getInterfaceCount());
    assertEquals(0, actualKotlinType.getProcessingFlags());
    assertEquals(0, ((LibraryClass) actualKotlinType).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) actualKotlinType).subClasses.length);
    assertEquals(0, ((LibraryClass) actualKotlinType).subClassCount);
    assertTrue(actualKotlinType.getExtraFeatureNames().isEmpty());
  }
}

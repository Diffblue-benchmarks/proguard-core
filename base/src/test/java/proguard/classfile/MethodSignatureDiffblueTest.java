package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MethodSignatureDiffblueTest {
  /**
   * Test {@link MethodSignature#isIncomplete()}.
   *
   * <ul>
   *   <li>Given {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#isIncomplete()}
   */
  @Test
  @DisplayName(
      "Test isIncomplete(); given CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.isIncomplete()"})
  void testIsIncomplete_givenClassloader_find_loaded_class_signature_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.isIncomplete());
  }

  /**
   * Test {@link MethodSignature#isIncomplete()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#MethodSignature(String)} with {@code Class Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#isIncomplete()}
   */
  @Test
  @DisplayName(
      "Test isIncomplete(); given MethodSignature(String) with 'Class Name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.isIncomplete()"})
  void testIsIncomplete_givenMethodSignatureWithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MethodSignature("Class Name").isIncomplete());
  }

  /**
   * Test {@link MethodSignature#isIncomplete()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#isIncomplete()}
   */
  @Test
  @DisplayName("Test isIncomplete(); given UNKNOWN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.isIncomplete()"})
  void testIsIncomplete_givenUnknown_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MethodSignature.UNKNOWN.isIncomplete());
  }

  /**
   * Test {@link MethodSignature#calculateFqn()}.
   *
   * <p>Method under test: {@link MethodSignature#calculateFqn()}
   */
  @Test
  @DisplayName("Test calculateFqn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodSignature.calculateFqn()"})
  void testCalculateFqn() {
    // Arrange, Act and Assert
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.calculateFqn());
  }

  /**
   * Test {@link MethodSignature#calculateFqn()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#UNKNOWN}.
   *   <li>Then return {@code L?;?null}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#calculateFqn()}
   */
  @Test
  @DisplayName("Test calculateFqn(); given UNKNOWN; then return 'L?;?null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodSignature.calculateFqn()"})
  void testCalculateFqn_givenUnknown_thenReturnLNull() {
    // Arrange, Act and Assert
    assertEquals("L?;?null", MethodSignature.UNKNOWN.calculateFqn());
  }

  /**
   * Test {@link MethodSignature#calculatePrettyFqn()}.
   *
   * <p>Method under test: {@link MethodSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName("Test calculatePrettyFqn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("? ?.?(?)", MethodSignature.UNKNOWN.calculatePrettyFqn());
  }

  /**
   * Test {@link MethodSignature#calculatePrettyFqn()}.
   *
   * <ul>
   *   <li>Then return {@code Class ClassLoader.findLoadedClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName("Test calculatePrettyFqn(); then return 'Class ClassLoader.findLoadedClass(String)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn_thenReturnClassClassLoaderFindLoadedClassString() {
    // Arrange, Act and Assert
    assertEquals(
        "Class ClassLoader.findLoadedClass(String)",
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.calculatePrettyFqn());
  }

  /**
   * Test {@link MethodSignature#calculatePrettyFqn()}.
   *
   * <ul>
   *   <li>Then return {@code Class ClassLoader.loadClass(String,boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName(
      "Test calculatePrettyFqn(); then return 'Class ClassLoader.loadClass(String,boolean)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn_thenReturnClassClassLoaderLoadClassStringBoolean() {
    // Arrange, Act and Assert
    assertEquals(
        "Class ClassLoader.loadClass(String,boolean)",
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2.calculatePrettyFqn());
  }

  /**
   * Test {@link MethodSignature#calculatePrettyFqn()}.
   *
   * <ul>
   *   <li>Then return {@code Method Class.getMethod(String,Class[])}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName("Test calculatePrettyFqn(); then return 'Method Class.getMethod(String,Class[])'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn_thenReturnMethodClassGetMethodStringClass() {
    // Arrange, Act and Assert
    assertEquals(
        "Method Class.getMethod(String,Class[])",
        ClassConstants.CLASS_GET_METHOD_SIGNATURE.calculatePrettyFqn());
  }

  /**
   * Test {@link MethodSignature#calculatePrettyFqn()}.
   *
   * <ul>
   *   <li>Then return {@code String Class.getCanonicalName()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#calculatePrettyFqn()}
   */
  @Test
  @DisplayName("Test calculatePrettyFqn(); then return 'String Class.getCanonicalName()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MethodSignature.calculatePrettyFqn()"})
  void testCalculatePrettyFqn_thenReturnStringClassGetCanonicalName() {
    // Arrange, Act and Assert
    assertEquals(
        "String Class.getCanonicalName()",
        ClassConstants.CLASS_GET_CANONICAL_NAME_SIGNATURE.calculatePrettyFqn());
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNull(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNull(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodSignature, MethodSignature); when CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.matchesIgnoreNull(MethodSignature, MethodSignature)"})
  void testMatchesIgnoreNull_whenClassloader_find_loaded_class_signature_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        MethodSignature.matchesIgnoreNull(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNull(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE2}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNull(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodSignature, MethodSignature); when CLASSLOADER_LOAD_CLASS_SIGNATURE2; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.matchesIgnoreNull(MethodSignature, MethodSignature)"})
  void testMatchesIgnoreNull_whenClassloader_load_class_signature2_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        MethodSignature.matchesIgnoreNull(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNull(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNull(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodSignature, MethodSignature); when CLASSLOADER_LOAD_CLASS_SIGNATURE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.matchesIgnoreNull(MethodSignature, MethodSignature)"})
  void testMatchesIgnoreNull_whenClassloader_load_class_signature_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        MethodSignature.matchesIgnoreNull(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNull(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNull(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodSignature, MethodSignature); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.matchesIgnoreNull(MethodSignature, MethodSignature)"})
  void testMatchesIgnoreNull_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MethodSignature.matchesIgnoreNull(null, MethodSignature.UNKNOWN));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNull(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNull(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodSignature, MethodSignature); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.matchesIgnoreNull(MethodSignature, MethodSignature)"})
  void testMatchesIgnoreNull_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MethodSignature.matchesIgnoreNull(null, null));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNull(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link MethodSignature#UNKNOWN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNull(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodSignature, MethodSignature); when UNKNOWN; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.matchesIgnoreNull(MethodSignature, MethodSignature)"})
  void testMatchesIgnoreNull_whenUnknown_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        MethodSignature.matchesIgnoreNull(
            MethodSignature.UNKNOWN, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNull(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link MethodSignature#UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNull(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNull(MethodSignature, MethodSignature); when UNKNOWN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.matchesIgnoreNull(MethodSignature, MethodSignature)"})
  void testMatchesIgnoreNull_whenUnknown_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MethodSignature.matchesIgnoreNull(MethodSignature.UNKNOWN, MethodSignature.UNKNOWN));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASS_GET_CANONICAL_NAME_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when CLASS_GET_CANONICAL_NAME_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenClass_get_canonical_name_signature() {
    // Arrange, Act and Assert
    assertTrue(
        MethodSignature.matchesIgnoreNullAndDollar(
            ClassConstants.CLASS_GET_CANONICAL_NAME_SIGNATURE,
            ClassConstants.CLASS_GET_CANONICAL_NAME_SIGNATURE));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenClassloader_find_loaded_class_signature() {
    // Arrange, Act and Assert
    assertFalse(
        MethodSignature.matchesIgnoreNullAndDollar(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, MethodSignature.UNKNOWN));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenClassloader_find_loaded_class_signature2() {
    // Arrange, Act and Assert
    assertTrue(
        MethodSignature.matchesIgnoreNullAndDollar(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when CLASSLOADER_LOAD_CLASS_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenClassloader_load_class_signature() {
    // Arrange, Act and Assert
    assertFalse(
        MethodSignature.matchesIgnoreNullAndDollar(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE2}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when CLASSLOADER_LOAD_CLASS_SIGNATURE2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenClassloader_load_class_signature2() {
    // Arrange, Act and Assert
    assertFalse(
        MethodSignature.matchesIgnoreNullAndDollar(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2,
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE2}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when CLASSLOADER_LOAD_CLASS_SIGNATURE2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenClassloader_load_class_signature22() {
    // Arrange, Act and Assert
    assertTrue(
        MethodSignature.matchesIgnoreNullAndDollar(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2,
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MethodSignature.matchesIgnoreNullAndDollar(null, MethodSignature.UNKNOWN));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MethodSignature.matchesIgnoreNullAndDollar(null, null));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link MethodSignature#UNKNOWN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when UNKNOWN; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenUnknown_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        MethodSignature.matchesIgnoreNullAndDollar(
            MethodSignature.UNKNOWN, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link MethodSignature#UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature,
   * MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test matchesIgnoreNullAndDollar(MethodSignature, MethodSignature); when UNKNOWN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MethodSignature.matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)"
  })
  void testMatchesIgnoreNullAndDollar_whenUnknown_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        MethodSignature.matchesIgnoreNullAndDollar(
            MethodSignature.UNKNOWN, MethodSignature.UNKNOWN));
  }

  /**
   * Test {@link MethodSignature#equals(Object)}, and {@link MethodSignature#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.equals(Object)"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodSignature methodSignature = MethodSignature.UNKNOWN;
    MethodSignature methodSignature2 = MethodSignature.UNKNOWN;

    // Act and Assert
    assertEquals(methodSignature, methodSignature2);
    assertEquals(methodSignature.hashCode(), methodSignature2.hashCode());
  }

  /**
   * Test {@link MethodSignature#equals(Object)}, and {@link MethodSignature#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.equals(Object)"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MethodSignature methodSignature = new MethodSignature("Class Name");
    MethodSignature methodSignature2 = new MethodSignature("Class Name");

    // Act and Assert
    assertEquals(methodSignature, methodSignature2);
    assertEquals(methodSignature.hashCode(), methodSignature2.hashCode());
  }

  /**
   * Test {@link MethodSignature#equals(Object)}, and {@link MethodSignature#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.equals(Object)"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodSignature methodSignature = MethodSignature.UNKNOWN;

    // Act and Assert
    assertEquals(methodSignature, methodSignature);
    int expectedHashCodeResult = methodSignature.hashCode();
    assertEquals(expectedHashCodeResult, methodSignature.hashCode());
  }

  /**
   * Test {@link MethodSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.equals(Object)"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, MethodSignature.UNKNOWN);
  }

  /**
   * Test {@link MethodSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.equals(Object)"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);
  }

  /**
   * Test {@link MethodSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.equals(Object)"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2,
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);
  }

  /**
   * Test {@link MethodSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.equals(Object)"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MethodSignature.UNKNOWN, null);
  }

  /**
   * Test {@link MethodSignature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodSignature.equals(Object)"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MethodSignature.UNKNOWN, "Different type to MethodSignature");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodSignature#getDescriptor()}
   *   <li>{@link MethodSignature#getMethodName()}
   *   <li>{@link MethodSignature#getReferencedMethod()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MethodDescriptor MethodSignature.getDescriptor()",
    "String MethodSignature.getMethodName()",
    "proguard.classfile.Method MethodSignature.getReferencedMethod()"
  })
  void testGettersAndSetters() {
    // Arrange
    MethodSignature methodSignature = new MethodSignature("Class Name");

    // Act
    MethodDescriptor actualDescriptor = methodSignature.getDescriptor();
    String actualMethodName = methodSignature.getMethodName();

    // Assert
    assertNull(actualMethodName);
    assertNull(methodSignature.getReferencedMethod());
    assertNull(actualDescriptor);
  }
}

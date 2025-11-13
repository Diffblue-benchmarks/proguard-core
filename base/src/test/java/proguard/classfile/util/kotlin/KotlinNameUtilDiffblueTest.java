package proguard.classfile.util.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinNameUtilDiffblueTest {
  /**
   * Test {@link KotlinNameUtil#generateGetterName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateGetterName(String)}
   */
  @Test
  @DisplayName("Test generateGetterName(String); when empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  void testGenerateGetterName_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinNameUtil.generateGetterName(""));
  }

  /**
   * Test {@link KotlinNameUtil#generateGetterName(String)}.
   *
   * <ul>
   *   <li>When {@code isName}.
   *   <li>Then return {@code isName}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateGetterName(String)}
   */
  @Test
  @DisplayName("Test generateGetterName(String); when 'isName'; then return 'isName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  void testGenerateGetterName_whenIsName_thenReturnIsName() {
    // Arrange, Act and Assert
    assertEquals("isName", KotlinNameUtil.generateGetterName("isName"));
  }

  /**
   * Test {@link KotlinNameUtil#generateGetterName(String)}.
   *
   * <ul>
   *   <li>When {@link KotlinNameUtil#IS_PREFIX}.
   *   <li>Then return {@code getIs}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateGetterName(String)}
   */
  @Test
  @DisplayName("Test generateGetterName(String); when IS_PREFIX; then return 'getIs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  void testGenerateGetterName_whenIs_prefix_thenReturnGetIs() {
    // Arrange, Act and Assert
    assertEquals("getIs", KotlinNameUtil.generateGetterName(KotlinNameUtil.IS_PREFIX));
  }

  /**
   * Test {@link KotlinNameUtil#generateGetterName(String)}.
   *
   * <ul>
   *   <li>When {@code isis}.
   *   <li>Then return {@code getIsis}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateGetterName(String)}
   */
  @Test
  @DisplayName("Test generateGetterName(String); when 'isis'; then return 'getIsis'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  void testGenerateGetterName_whenIsis_thenReturnGetIsis() {
    // Arrange, Act and Assert
    assertEquals("getIsis", KotlinNameUtil.generateGetterName("isis"));
  }

  /**
   * Test {@link KotlinNameUtil#generateGetterName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code getName}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateGetterName(String)}
   */
  @Test
  @DisplayName("Test generateGetterName(String); when 'Name'; then return 'getName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  void testGenerateGetterName_whenName_thenReturnGetName() {
    // Arrange, Act and Assert
    assertEquals("getName", KotlinNameUtil.generateGetterName("Name"));
  }

  /**
   * Test {@link KotlinNameUtil#generateSetterName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateSetterName(String)}
   */
  @Test
  @DisplayName("Test generateSetterName(String); when empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  void testGenerateSetterName_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinNameUtil.generateSetterName(""));
  }

  /**
   * Test {@link KotlinNameUtil#generateSetterName(String)}.
   *
   * <ul>
   *   <li>When {@code isName}.
   *   <li>Then return {@code setName}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateSetterName(String)}
   */
  @Test
  @DisplayName("Test generateSetterName(String); when 'isName'; then return 'setName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  void testGenerateSetterName_whenIsName_thenReturnSetName() {
    // Arrange, Act and Assert
    assertEquals("setName", KotlinNameUtil.generateSetterName("isName"));
  }

  /**
   * Test {@link KotlinNameUtil#generateSetterName(String)}.
   *
   * <ul>
   *   <li>When {@link KotlinNameUtil#IS_PREFIX}.
   *   <li>Then return {@code setIs}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateSetterName(String)}
   */
  @Test
  @DisplayName("Test generateSetterName(String); when IS_PREFIX; then return 'setIs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  void testGenerateSetterName_whenIs_prefix_thenReturnSetIs() {
    // Arrange, Act and Assert
    assertEquals("setIs", KotlinNameUtil.generateSetterName(KotlinNameUtil.IS_PREFIX));
  }

  /**
   * Test {@link KotlinNameUtil#generateSetterName(String)}.
   *
   * <ul>
   *   <li>When {@code isset}.
   *   <li>Then return {@code setIsset}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateSetterName(String)}
   */
  @Test
  @DisplayName("Test generateSetterName(String); when 'isset'; then return 'setIsset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  void testGenerateSetterName_whenIsset_thenReturnSetIsset() {
    // Arrange, Act and Assert
    assertEquals("setIsset", KotlinNameUtil.generateSetterName("isset"));
  }

  /**
   * Test {@link KotlinNameUtil#generateSetterName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code setName}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#generateSetterName(String)}
   */
  @Test
  @DisplayName("Test generateSetterName(String); when 'Name'; then return 'setName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  void testGenerateSetterName_whenName_thenReturnSetName() {
    // Arrange, Act and Assert
    assertEquals("setName", KotlinNameUtil.generateSetterName("Name"));
  }

  /**
   * Test {@link KotlinNameUtil#isGetterName(String)}.
   *
   * <ul>
   *   <li>When {@link KotlinNameUtil#GET_PREFIX}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#isGetterName(String)}
   */
  @Test
  @DisplayName("Test isGetterName(String); when GET_PREFIX; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinNameUtil.isGetterName(String)"})
  void testIsGetterName_whenGet_prefix_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinNameUtil.isGetterName(KotlinNameUtil.GET_PREFIX));
  }

  /**
   * Test {@link KotlinNameUtil#isGetterName(String)}.
   *
   * <ul>
   *   <li>When {@link KotlinNameUtil#IS_PREFIX}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#isGetterName(String)}
   */
  @Test
  @DisplayName("Test isGetterName(String); when IS_PREFIX; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinNameUtil.isGetterName(String)"})
  void testIsGetterName_whenIs_prefix_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinNameUtil.isGetterName(KotlinNameUtil.IS_PREFIX));
  }

  /**
   * Test {@link KotlinNameUtil#isGetterName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#isGetterName(String)}
   */
  @Test
  @DisplayName("Test isGetterName(String); when 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinNameUtil.isGetterName(String)"})
  void testIsGetterName_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KotlinNameUtil.isGetterName("Name"));
  }

  /**
   * Test {@link KotlinNameUtil#isSetterName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#isSetterName(String)}
   */
  @Test
  @DisplayName("Test isSetterName(String); when 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinNameUtil.isSetterName(String)"})
  void testIsSetterName_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KotlinNameUtil.isSetterName("Name"));
  }

  /**
   * Test {@link KotlinNameUtil#isSetterName(String)}.
   *
   * <ul>
   *   <li>When {@link KotlinNameUtil#SET_PREFIX}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#isSetterName(String)}
   */
  @Test
  @DisplayName("Test isSetterName(String); when SET_PREFIX; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinNameUtil.isSetterName(String)"})
  void testIsSetterName_whenSet_prefix_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinNameUtil.isSetterName(KotlinNameUtil.SET_PREFIX));
  }

  /**
   * Test {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code $}.
   *   <li>Then return {@code $}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}
   */
  @Test
  @DisplayName("Test getterNameToPropertyName(String, boolean); when '$'; then return '$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  void testGetterNameToPropertyName_whenDollarSign_thenReturnDollarSign() {
    // Arrange, Act and Assert
    assertEquals("$", KotlinNameUtil.getterNameToPropertyName("$", false));
  }

  /**
   * Test {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code $}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}
   */
  @Test
  @DisplayName("Test getterNameToPropertyName(String, boolean); when '$'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  void testGetterNameToPropertyName_whenDollarSign_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinNameUtil.getterNameToPropertyName("$", true));
  }

  /**
   * Test {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}.
   *
   * <ul>
   *   <li>When {@link KotlinNameUtil#GET_PREFIX}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getterNameToPropertyName(String, boolean); when GET_PREFIX; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  void testGetterNameToPropertyName_whenGet_prefix_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinNameUtil.getterNameToPropertyName(KotlinNameUtil.GET_PREFIX, false));
  }

  /**
   * Test {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}.
   *
   * <ul>
   *   <li>When {@link KotlinNameUtil#IS_PREFIX}.
   *   <li>Then return {@link KotlinNameUtil#IS_PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getterNameToPropertyName(String, boolean); when IS_PREFIX; then return IS_PREFIX")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  void testGetterNameToPropertyName_whenIs_prefix_thenReturnIs_prefix() {
    // Arrange, Act and Assert
    assertEquals(
        KotlinNameUtil.IS_PREFIX,
        KotlinNameUtil.getterNameToPropertyName(KotlinNameUtil.IS_PREFIX, false));
  }

  /**
   * Test {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}
   */
  @Test
  @DisplayName("Test getterNameToPropertyName(String, boolean); when 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  void testGetterNameToPropertyName_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", KotlinNameUtil.getterNameToPropertyName("Name", true));
  }

  /**
   * Test {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}.
   *
   * <ul>
   *   <li>When {@link KotlinNameUtil#SET_PREFIX}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getterNameToPropertyName(String, boolean); when SET_PREFIX; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  void testGetterNameToPropertyName_whenSet_prefix_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinNameUtil.getterNameToPropertyName(KotlinNameUtil.SET_PREFIX, false));
  }
}

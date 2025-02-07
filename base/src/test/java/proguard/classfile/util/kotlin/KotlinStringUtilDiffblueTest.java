package proguard.classfile.util.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinStringUtilDiffblueTest {
  /**
   * Test {@link KotlinStringUtil#capitializeFirstCharacterAsciiOnly(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#capitializeFirstCharacterAsciiOnly(String)}
   */
  @Test
  @DisplayName("Test capitializeFirstCharacterAsciiOnly(String); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.capitializeFirstCharacterAsciiOnly(java.lang.String)"
  })
  void testCapitializeFirstCharacterAsciiOnly_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", KotlinStringUtil.capitializeFirstCharacterAsciiOnly("42"));
  }

  /**
   * Test {@link KotlinStringUtil#capitializeFirstCharacterAsciiOnly(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#capitializeFirstCharacterAsciiOnly(String)}
   */
  @Test
  @DisplayName(
      "Test capitializeFirstCharacterAsciiOnly(String); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.capitializeFirstCharacterAsciiOnly(java.lang.String)"
  })
  void testCapitializeFirstCharacterAsciiOnly_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinStringUtil.capitializeFirstCharacterAsciiOnly(""));
  }

  /**
   * Test {@link KotlinStringUtil#capitializeFirstCharacterAsciiOnly(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code Foo}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#capitializeFirstCharacterAsciiOnly(String)}
   */
  @Test
  @DisplayName("Test capitializeFirstCharacterAsciiOnly(String); when 'foo'; then return 'Foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.capitializeFirstCharacterAsciiOnly(java.lang.String)"
  })
  void testCapitializeFirstCharacterAsciiOnly_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("Foo", KotlinStringUtil.capitializeFirstCharacterAsciiOnly("foo"));
  }

  /**
   * Test {@link KotlinStringUtil#decapitializeFirstCharacterAsciiOnly(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#decapitializeFirstCharacterAsciiOnly(String)}
   */
  @Test
  @DisplayName("Test decapitializeFirstCharacterAsciiOnly(String); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.decapitializeFirstCharacterAsciiOnly(java.lang.String)"
  })
  void testDecapitializeFirstCharacterAsciiOnly_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", KotlinStringUtil.decapitializeFirstCharacterAsciiOnly("42"));
  }

  /**
   * Test {@link KotlinStringUtil#decapitializeFirstCharacterAsciiOnly(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#decapitializeFirstCharacterAsciiOnly(String)}
   */
  @Test
  @DisplayName(
      "Test decapitializeFirstCharacterAsciiOnly(String); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.decapitializeFirstCharacterAsciiOnly(java.lang.String)"
  })
  void testDecapitializeFirstCharacterAsciiOnly_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinStringUtil.decapitializeFirstCharacterAsciiOnly(""));
  }

  /**
   * Test {@link KotlinStringUtil#decapitializeFirstCharacterAsciiOnly(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#decapitializeFirstCharacterAsciiOnly(String)}
   */
  @Test
  @DisplayName("Test decapitializeFirstCharacterAsciiOnly(String); when 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.decapitializeFirstCharacterAsciiOnly(java.lang.String)"
  })
  void testDecapitializeFirstCharacterAsciiOnly_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", KotlinStringUtil.decapitializeFirstCharacterAsciiOnly("foo"));
  }

  /**
   * Test {@link KotlinStringUtil#decapitializeForKotlinCompiler(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#decapitializeForKotlinCompiler(String)}
   */
  @Test
  @DisplayName("Test decapitializeForKotlinCompiler(String); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.decapitializeForKotlinCompiler(java.lang.String)"
  })
  void testDecapitializeForKotlinCompiler_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", KotlinStringUtil.decapitializeForKotlinCompiler("42"));
  }

  /**
   * Test {@link KotlinStringUtil#decapitializeForKotlinCompiler(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#decapitializeForKotlinCompiler(String)}
   */
  @Test
  @DisplayName(
      "Test decapitializeForKotlinCompiler(String); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.decapitializeForKotlinCompiler(java.lang.String)"
  })
  void testDecapitializeForKotlinCompiler_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinStringUtil.decapitializeForKotlinCompiler(""));
  }

  /**
   * Test {@link KotlinStringUtil#decapitializeForKotlinCompiler(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinStringUtil#decapitializeForKotlinCompiler(String)}
   */
  @Test
  @DisplayName("Test decapitializeForKotlinCompiler(String); when 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.util.kotlin.KotlinStringUtil.decapitializeForKotlinCompiler(java.lang.String)"
  })
  void testDecapitializeForKotlinCompiler_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", KotlinStringUtil.decapitializeForKotlinCompiler("foo"));
  }
}

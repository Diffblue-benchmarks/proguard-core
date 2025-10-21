package proguard.classfile.util.kotlin;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinStringUtilDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.capitializeFirstCharacterAsciiOnly(String)"})
  public void testCapitializeFirstCharacterAsciiOnly_when42_thenReturn42() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.capitializeFirstCharacterAsciiOnly(String)"})
  public void testCapitializeFirstCharacterAsciiOnly_whenEmptyString_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.capitializeFirstCharacterAsciiOnly(String)"})
  public void testCapitializeFirstCharacterAsciiOnly_whenFoo_thenReturnFoo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.decapitializeFirstCharacterAsciiOnly(String)"})
  public void testDecapitializeFirstCharacterAsciiOnly_when42_thenReturn42() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.decapitializeFirstCharacterAsciiOnly(String)"})
  public void testDecapitializeFirstCharacterAsciiOnly_whenEmptyString_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.decapitializeFirstCharacterAsciiOnly(String)"})
  public void testDecapitializeFirstCharacterAsciiOnly_whenFoo_thenReturnFoo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.decapitializeForKotlinCompiler(String)"})
  public void testDecapitializeForKotlinCompiler_when42_thenReturn42() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.decapitializeForKotlinCompiler(String)"})
  public void testDecapitializeForKotlinCompiler_whenEmptyString_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinStringUtil.decapitializeForKotlinCompiler(String)"})
  public void testDecapitializeForKotlinCompiler_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", KotlinStringUtil.decapitializeForKotlinCompiler("foo"));
  }
}

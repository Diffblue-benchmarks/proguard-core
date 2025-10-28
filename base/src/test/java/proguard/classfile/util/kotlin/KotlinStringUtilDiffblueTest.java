package proguard.classfile.util.kotlin;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KotlinStringUtilDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinStringUtil#capitializeFirstCharacterAsciiOnly(String)}
   */
  @Test
  public void testCapitializeFirstCharacterAsciiOnly() {
    // Arrange, Act and Assert
    assertEquals("Foo", KotlinStringUtil.capitializeFirstCharacterAsciiOnly("foo"));
    assertEquals("42", KotlinStringUtil.capitializeFirstCharacterAsciiOnly("42"));
    assertEquals("", KotlinStringUtil.capitializeFirstCharacterAsciiOnly(""));
  }

  /**
   * Method under test:
   * {@link KotlinStringUtil#decapitializeFirstCharacterAsciiOnly(String)}
   */
  @Test
  public void testDecapitializeFirstCharacterAsciiOnly() {
    // Arrange, Act and Assert
    assertEquals("foo", KotlinStringUtil.decapitializeFirstCharacterAsciiOnly("foo"));
    assertEquals("42", KotlinStringUtil.decapitializeFirstCharacterAsciiOnly("42"));
    assertEquals("", KotlinStringUtil.decapitializeFirstCharacterAsciiOnly(""));
  }

  /**
   * Method under test:
   * {@link KotlinStringUtil#decapitializeForKotlinCompiler(String)}
   */
  @Test
  public void testDecapitializeForKotlinCompiler() {
    // Arrange, Act and Assert
    assertEquals("foo", KotlinStringUtil.decapitializeForKotlinCompiler("foo"));
    assertEquals("42", KotlinStringUtil.decapitializeForKotlinCompiler("42"));
    assertEquals("", KotlinStringUtil.decapitializeForKotlinCompiler(""));
  }
}

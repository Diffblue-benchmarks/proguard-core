package proguard.classfile.util.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KotlinNameUtilDiffblueTest {
  /**
   * Method under test: {@link KotlinNameUtil#generateGetterName(String)}
   */
  @Test
  public void testGenerateGetterName() {
    // Arrange, Act and Assert
    assertEquals("getName", KotlinNameUtil.generateGetterName("Name"));
    assertEquals("getIs", KotlinNameUtil.generateGetterName(KotlinNameUtil.IS_PREFIX));
    assertEquals("", KotlinNameUtil.generateGetterName(""));
    assertEquals("getIsis", KotlinNameUtil.generateGetterName("isis"));
    assertEquals("isName", KotlinNameUtil.generateGetterName("isName"));
  }

  /**
   * Method under test: {@link KotlinNameUtil#generateSetterName(String)}
   */
  @Test
  public void testGenerateSetterName() {
    // Arrange, Act and Assert
    assertEquals("setName", KotlinNameUtil.generateSetterName("Name"));
    assertEquals("setIs", KotlinNameUtil.generateSetterName(KotlinNameUtil.IS_PREFIX));
    assertEquals("", KotlinNameUtil.generateSetterName(""));
    assertEquals("setIsset", KotlinNameUtil.generateSetterName("isset"));
    assertEquals("setName", KotlinNameUtil.generateSetterName("isName"));
  }

  /**
   * Method under test: {@link KotlinNameUtil#isGetterName(String)}
   */
  @Test
  public void testIsGetterName() {
    // Arrange, Act and Assert
    assertFalse(KotlinNameUtil.isGetterName("Name"));
    assertTrue(KotlinNameUtil.isGetterName(KotlinNameUtil.GET_PREFIX));
    assertTrue(KotlinNameUtil.isGetterName(KotlinNameUtil.IS_PREFIX));
  }

  /**
   * Method under test: {@link KotlinNameUtil#isSetterName(String)}
   */
  @Test
  public void testIsSetterName() {
    // Arrange, Act and Assert
    assertFalse(KotlinNameUtil.isSetterName("Name"));
    assertTrue(KotlinNameUtil.isSetterName(KotlinNameUtil.SET_PREFIX));
  }

  /**
   * Method under test:
   * {@link KotlinNameUtil#getterNameToPropertyName(String, boolean)}
   */
  @Test
  public void testGetterNameToPropertyName() {
    // Arrange, Act and Assert
    assertEquals("Name", KotlinNameUtil.getterNameToPropertyName("Name", true));
    assertEquals("$", KotlinNameUtil.getterNameToPropertyName("$", false));
    assertEquals("", KotlinNameUtil.getterNameToPropertyName(KotlinNameUtil.GET_PREFIX, false));
    assertEquals("", KotlinNameUtil.getterNameToPropertyName(KotlinNameUtil.SET_PREFIX, false));
    assertEquals(KotlinNameUtil.IS_PREFIX, KotlinNameUtil.getterNameToPropertyName(KotlinNameUtil.IS_PREFIX, false));
    assertEquals("", KotlinNameUtil.getterNameToPropertyName("$", true));
  }
}

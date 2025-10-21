package proguard.classfile.util.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinNameUtilDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  public void testGenerateGetterName_whenEmptyString_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  public void testGenerateGetterName_whenIsName_thenReturnIsName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  public void testGenerateGetterName_whenIs_prefix_thenReturnGetIs() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  public void testGenerateGetterName_whenIsis_thenReturnGetIsis() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateGetterName(String)"})
  public void testGenerateGetterName_whenName_thenReturnGetName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  public void testGenerateSetterName_whenEmptyString_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  public void testGenerateSetterName_whenIsName_thenReturnSetName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  public void testGenerateSetterName_whenIs_prefix_thenReturnSetIs() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  public void testGenerateSetterName_whenIsset_thenReturnSetIsset() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.generateSetterName(String)"})
  public void testGenerateSetterName_whenName_thenReturnSetName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinNameUtil.isGetterName(String)"})
  public void testIsGetterName_whenGet_prefix_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinNameUtil.isGetterName(String)"})
  public void testIsGetterName_whenIs_prefix_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinNameUtil.isGetterName(String)"})
  public void testIsGetterName_whenName_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinNameUtil.isSetterName(String)"})
  public void testIsSetterName_whenName_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinNameUtil.isSetterName(String)"})
  public void testIsSetterName_whenSet_prefix_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  public void testGetterNameToPropertyName_whenDollarSign_thenReturnDollarSign() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  public void testGetterNameToPropertyName_whenDollarSign_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  public void testGetterNameToPropertyName_whenGet_prefix_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  public void testGetterNameToPropertyName_whenIs_prefix_thenReturnIs_prefix() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  public void testGetterNameToPropertyName_whenName_thenReturnName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinNameUtil.getterNameToPropertyName(String, boolean)"})
  public void testGetterNameToPropertyName_whenSet_prefix_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", KotlinNameUtil.getterNameToPropertyName(KotlinNameUtil.SET_PREFIX, false));
  }
}

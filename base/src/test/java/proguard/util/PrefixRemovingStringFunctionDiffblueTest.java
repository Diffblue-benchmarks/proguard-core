package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class PrefixRemovingStringFunctionDiffblueTest {
  /**
   * Test {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PrefixRemovingStringFunction.<init>(String)"})
  public void testNewPrefixRemovingStringFunction_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("")).transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}.
   *
   * <ul>
   *   <li>When {@code Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PrefixRemovingStringFunction.<init>(String)"})
  public void testNewPrefixRemovingStringFunction_whenPrefix() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("Prefix")).transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixRemovingStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new PrefixRemovingStringFunction(
                "Prefix",
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)} with
   *       prefix is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixRemovingStringFunction.transform(String)"})
  public void testTransform_givenPrefixRemovingStringFunctionWithPrefixIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("")).transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)} with
   *       {@code Prefix}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixRemovingStringFunction.transform(String)"})
  public void testTransform_givenPrefixRemovingStringFunctionWithPrefix_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("Prefix")).transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixRemovingStringFunction.transform(String)"})
  public void testTransform_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new PrefixRemovingStringFunction(
                "Prefix",
                new AndStringFunction(
                    new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
                    StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
  }

  /**
   * Test {@link PrefixRemovingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixRemovingStringFunction.transform(String)"})
  public void testTransform_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(
        (new PrefixRemovingStringFunction(
                "",
                new AndStringFunction(
                    new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
                    StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
  }
}

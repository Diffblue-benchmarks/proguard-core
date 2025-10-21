package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class PrefixAddingStringFunctionDiffblueTest {
  /**
   * Test {@link PrefixAddingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixAddingStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals(
        "PrefixString",
        (new PrefixAddingStringFunction("Prefix", StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link PrefixAddingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixAddingStringFunction.transform(String)"})
  public void testTransform2() {
    // Arrange, Act and Assert
    assertEquals(
        "PrefixString",
        (new PrefixAddingStringFunction(
                "Prefix",
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
  }

  /**
   * Test {@link PrefixAddingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixAddingStringFunction.transform(String)"})
  public void testTransform3() {
    // Arrange, Act and Assert
    assertEquals(
        "PrefixPrefixString",
        (new PrefixAddingStringFunction("Prefix", new PrefixAddingStringFunction("Prefix")))
            .transform("String"));
  }

  /**
   * Test {@link PrefixAddingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixAddingStringFunction.transform(String)"})
  public void testTransform4() {
    // Arrange, Act and Assert
    assertEquals(
        "PrefixPrefixString",
        (new PrefixAddingStringFunction(
                "Prefix",
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, new PrefixAddingStringFunction("Prefix"))))
            .transform("String"));
  }

  /**
   * Test {@link PrefixAddingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link PrefixAddingStringFunction#PrefixAddingStringFunction(String)} with {@code
   *       Prefix}.
   *   <li>Then return {@code PrefixString}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixAddingStringFunction.transform(String)"})
  public void testTransform_givenPrefixAddingStringFunctionWithPrefix_thenReturnPrefixString() {
    // Arrange, Act and Assert
    assertEquals("PrefixString", (new PrefixAddingStringFunction("Prefix")).transform("String"));
  }

  /**
   * Test {@link PrefixAddingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code Prefixnull}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PrefixAddingStringFunction.transform(String)"})
  public void testTransform_thenReturnPrefixnull() {
    // Arrange, Act and Assert
    assertEquals(
        "Prefixnull",
        (new PrefixAddingStringFunction(
                "Prefix", new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("String"));
  }
}

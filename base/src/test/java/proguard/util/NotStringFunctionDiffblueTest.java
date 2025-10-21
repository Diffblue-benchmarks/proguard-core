package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class NotStringFunctionDiffblueTest {
  /**
   * Test {@link NotStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link NotStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NotStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertNull(
        (new NotStringFunction(
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
  }

  /**
   * Test {@link NotStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link NotStringFunction#NotStringFunction(StringFunction)} with stringFunction is
   *       {@link StringFunction#IDENTITY_FUNCTION}.
   * </ul>
   *
   * <p>Method under test: {@link NotStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NotStringFunction.transform(String)"})
  public void testTransform_givenNotStringFunctionWithStringFunctionIsIdentity_function() {
    // Arrange, Act and Assert
    assertNull((new NotStringFunction(StringFunction.IDENTITY_FUNCTION)).transform("String"));
  }

  /**
   * Test {@link NotStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link NotStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NotStringFunction.transform(String)"})
  public void testTransform_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new NotStringFunction(new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("String"));
  }
}

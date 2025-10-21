package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class AndNotStringFunctionDiffblueTest {
  /**
   * Test {@link AndNotStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndNotStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndNotStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertNull(
        (new AndNotStringFunction(
                StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link AndNotStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndNotStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndNotStringFunction.transform(String)"})
  public void testTransform2() {
    // Arrange, Act and Assert
    assertNull(
        (new AndNotStringFunction(
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link AndNotStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndNotStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndNotStringFunction.transform(String)"})
  public void testTransform3() {
    // Arrange
    ClassPoolFeatureNameFunction stringFunction1 =
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool);

    // Act and Assert
    assertNull(
        (new AndNotStringFunction(
                stringFunction1, new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("String"));
  }

  /**
   * Test {@link AndNotStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link AndNotStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndNotStringFunction.transform(String)"})
  public void testTransform_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new AndNotStringFunction(
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }
}

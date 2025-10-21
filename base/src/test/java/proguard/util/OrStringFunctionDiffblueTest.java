package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class OrStringFunctionDiffblueTest {
  /**
   * Test {@link OrStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link OrStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new OrStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link OrStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link OrStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrStringFunction.transform(String)"})
  public void testTransform2() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new OrStringFunction(
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link OrStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link OrStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrStringFunction.transform(String)"})
  public void testTransform3() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new OrStringFunction(
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link OrStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrStringFunction.transform(String)"})
  public void testTransform_thenReturnNull() {
    // Arrange
    ClassPoolFeatureNameFunction stringFunction1 =
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool);

    // Act and Assert
    assertNull(
        (new OrStringFunction(
                stringFunction1, new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("String"));
  }
}

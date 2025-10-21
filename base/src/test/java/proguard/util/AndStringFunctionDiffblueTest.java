package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class AndStringFunctionDiffblueTest {
  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndStringFunction.transform(String)"})
  public void testTransform2() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new AndStringFunction(
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndStringFunction.transform(String)"})
  public void testTransform3() {
    // Arrange, Act and Assert
    assertNull(
        (new AndStringFunction(
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndStringFunction.transform(String)"})
  public void testTransform4() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new AndStringFunction(
                new ConcatenatingStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndStringFunction.transform(String)"})
  public void testTransform5() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new AndStringFunction(
                StringFunction.IDENTITY_FUNCTION,
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
  }

  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndStringFunction.transform(String)"})
  public void testTransform6() {
    // Arrange, Act and Assert
    assertNull(
        (new AndStringFunction(
                StringFunction.IDENTITY_FUNCTION,
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("String"));
  }

  /**
   * Test {@link AndStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndStringFunction.transform(String)"})
  public void testTransform7() {
    // Arrange, Act and Assert
    assertEquals(
        "String",
        (new AndStringFunction(
                new ConcatenatingStringFunction(
                    StringFunction.IDENTITY_FUNCTION,
                    new AndStringFunction(
                        StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }
}

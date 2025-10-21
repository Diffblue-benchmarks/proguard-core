package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class ConcatenatingStringFunctionDiffblueTest {
  /**
   * Test {@link ConcatenatingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConcatenatingStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals(
        "StringString",
        (new ConcatenatingStringFunction(
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link ConcatenatingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConcatenatingStringFunction.transform(String)"})
  public void testTransform2() {
    // Arrange, Act and Assert
    assertEquals(
        "StringStringString",
        (new ConcatenatingStringFunction(
                new ConcatenatingStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link ConcatenatingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConcatenatingStringFunction.transform(String)"})
  public void testTransform3() {
    // Arrange, Act and Assert
    assertEquals(
        "StringStringString",
        (new ConcatenatingStringFunction(
                StringFunction.IDENTITY_FUNCTION,
                new ConcatenatingStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
  }

  /**
   * Test {@link ConcatenatingStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConcatenatingStringFunction.transform(String)"})
  public void testTransform4() {
    // Arrange, Act and Assert
    assertEquals(
        "StringStringString",
        (new ConcatenatingStringFunction(
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION,
                    new ConcatenatingStringFunction(
                        StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link ConcatenatingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code nullString}.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConcatenatingStringFunction.transform(String)"})
  public void testTransform_thenReturnNullString() {
    // Arrange, Act and Assert
    assertEquals(
        "nullString",
        (new ConcatenatingStringFunction(
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
                StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link ConcatenatingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code StringString}.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConcatenatingStringFunction.transform(String)"})
  public void testTransform_thenReturnStringString() {
    // Arrange, Act and Assert
    assertEquals(
        "StringString",
        (new ConcatenatingStringFunction(
                StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
  }

  /**
   * Test {@link ConcatenatingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code Stringnull}.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConcatenatingStringFunction.transform(String)"})
  public void testTransform_thenReturnStringnull() {
    // Arrange, Act and Assert
    assertEquals(
        "Stringnull",
        (new ConcatenatingStringFunction(
                StringFunction.IDENTITY_FUNCTION,
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("String"));
  }
}

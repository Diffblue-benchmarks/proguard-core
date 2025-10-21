package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class FilteredStringFunctionDiffblueTest {
  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilteredStringFunction.<init>(String, StringFunction, StringFunction)"})
  public void testNewFilteredStringFunction() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "Name Filter",
                StringFunction.IDENTITY_FUNCTION,
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilteredStringFunction.<init>(String, StringFunction, StringFunction)"})
  public void testNewFilteredStringFunction2() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "Name Filter",
                StringFunction.IDENTITY_FUNCTION,
                new FilteredStringFunction(
                    "Name Filter",
                    StringFunction.IDENTITY_FUNCTION,
                    StringFunction.IDENTITY_FUNCTION)))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilteredStringFunction.<init>(String, StringFunction, StringFunction)"})
  public void testNewFilteredStringFunction3() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "",
                new FilteredStringFunction(
                    "Name Filter",
                    StringFunction.IDENTITY_FUNCTION,
                    StringFunction.IDENTITY_FUNCTION),
                StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilteredStringFunction.<init>(String, StringFunction, StringFunction)"})
  public void testNewFilteredStringFunction4() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "Name Filter",
                StringFunction.IDENTITY_FUNCTION,
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION,
                    new FilteredStringFunction(
                        "Name Filter",
                        StringFunction.IDENTITY_FUNCTION,
                        StringFunction.IDENTITY_FUNCTION))))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <ul>
   *   <li>Then return transform {@code foo.txt} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilteredStringFunction.<init>(String, StringFunction, StringFunction)"})
  public void testNewFilteredStringFunction_thenReturnTransformFooTxtIsNull() {
    // Arrange, Act and Assert
    assertNull(
        (new FilteredStringFunction(
                "Name Filter",
                StringFunction.IDENTITY_FUNCTION,
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <ul>
   *   <li>Then return transform {@code foo.txt} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilteredStringFunction.<init>(String, StringFunction, StringFunction)"})
  public void testNewFilteredStringFunction_thenReturnTransformFooTxtIsNull2() {
    // Arrange, Act and Assert
    assertNull(
        (new FilteredStringFunction(
                "",
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
                StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return transform {@code foo.txt} is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilteredStringFunction.<init>(String, StringFunction, StringFunction)"})
  public void testNewFilteredStringFunction_whenEmptyString_thenReturnTransformFooTxtIsFooTxt() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction,
   * StringFunction)}.
   *
   * <ul>
   *   <li>When {@code Name Filter}.
   *   <li>Then return transform {@code foo.txt} is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredStringFunction#FilteredStringFunction(String,
   * StringFunction, StringFunction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilteredStringFunction.<init>(String, StringFunction, StringFunction)"})
  public void testNewFilteredStringFunction_whenNameFilter_thenReturnTransformFooTxtIsFooTxt() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilteredStringFunction.transform(String)"})
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilteredStringFunction.transform(String)"})
  public void testTransform2() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilteredStringFunction.transform(String)"})
  public void testTransform3() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "Name Filter",
                StringFunction.IDENTITY_FUNCTION,
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilteredStringFunction.transform(String)"})
  public void testTransform4() {
    // Arrange, Act and Assert
    assertNull(
        (new FilteredStringFunction(
                "Name Filter",
                StringFunction.IDENTITY_FUNCTION,
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilteredStringFunction.transform(String)"})
  public void testTransform5() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "Name Filter",
                StringFunction.IDENTITY_FUNCTION,
                new FilteredStringFunction(
                    "Name Filter",
                    StringFunction.IDENTITY_FUNCTION,
                    StringFunction.IDENTITY_FUNCTION)))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilteredStringFunction.transform(String)"})
  public void testTransform6() {
    // Arrange, Act and Assert
    assertNull(
        (new FilteredStringFunction(
                "",
                new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
                StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilteredStringFunction.transform(String)"})
  public void testTransform7() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "",
                new FilteredStringFunction(
                    "Name Filter",
                    StringFunction.IDENTITY_FUNCTION,
                    StringFunction.IDENTITY_FUNCTION),
                StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
  }

  /**
   * Test {@link FilteredStringFunction#transform(String)}.
   *
   * <p>Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilteredStringFunction.transform(String)"})
  public void testTransform8() {
    // Arrange, Act and Assert
    assertEquals(
        "foo.txt",
        (new FilteredStringFunction(
                "Name Filter",
                StringFunction.IDENTITY_FUNCTION,
                new AndStringFunction(
                    StringFunction.IDENTITY_FUNCTION,
                    new FilteredStringFunction(
                        "Name Filter",
                        StringFunction.IDENTITY_FUNCTION,
                        StringFunction.IDENTITY_FUNCTION))))
            .transform("foo.txt"));
  }
}

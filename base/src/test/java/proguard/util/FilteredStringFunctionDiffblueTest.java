package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class FilteredStringFunctionDiffblueTest {
  /**
   * Method under test:
   * {@link FilteredStringFunction#FilteredStringFunction(String, StringFunction, StringFunction)}
   */
  @Test
  public void testNewFilteredStringFunction() {
    // Arrange, Act and Assert
    assertEquals("foo.txt",
        (new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
    assertEquals("foo.txt",
        (new FilteredStringFunction("", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
    assertEquals("foo.txt",
        (new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
                .transform("foo.txt"));
    assertNull((new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool))).transform("foo.txt"));
    assertEquals("foo.txt", (new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
        new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("foo.txt"));
    assertNull((new FilteredStringFunction("", new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
        StringFunction.IDENTITY_FUNCTION)).transform("foo.txt"));
    assertEquals("foo.txt", (new FilteredStringFunction("",
        new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
        StringFunction.IDENTITY_FUNCTION)).transform("foo.txt"));
    assertEquals("foo.txt",
        (new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, new FilteredStringFunction("Name Filter",
                StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))).transform("foo.txt"));
  }

  /**
   * Method under test: {@link FilteredStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("foo.txt",
        (new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
    assertEquals("foo.txt",
        (new FilteredStringFunction("", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("foo.txt"));
    assertEquals("foo.txt",
        (new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
                .transform("foo.txt"));
    assertNull((new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool))).transform("foo.txt"));
    assertEquals("foo.txt", (new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
        new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("foo.txt"));
    assertNull((new FilteredStringFunction("", new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
        StringFunction.IDENTITY_FUNCTION)).transform("foo.txt"));
    assertEquals("foo.txt", (new FilteredStringFunction("",
        new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
        StringFunction.IDENTITY_FUNCTION)).transform("foo.txt"));
    assertEquals("foo.txt",
        (new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, new FilteredStringFunction("Name Filter",
                StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))).transform("foo.txt"));
  }
}

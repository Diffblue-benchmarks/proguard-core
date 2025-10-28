package proguard.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class ConcatenatingStringFunctionDiffblueTest {
  /**
   * Method under test: {@link ConcatenatingStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("StringString",
        (new ConcatenatingStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
            .transform("String"));
    assertEquals("StringString",
        (new ConcatenatingStringFunction(
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
            StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertEquals("nullString",
        (new ConcatenatingStringFunction(new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
            StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertEquals("StringStringString",
        (new ConcatenatingStringFunction(
            new ConcatenatingStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
            StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertEquals("Stringnull", (new ConcatenatingStringFunction(StringFunction.IDENTITY_FUNCTION,
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool))).transform("String"));
    assertEquals("StringStringString",
        (new ConcatenatingStringFunction(StringFunction.IDENTITY_FUNCTION,
            new ConcatenatingStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
                .transform("String"));
    assertEquals("StringStringString",
        (new ConcatenatingStringFunction(
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION,
                new ConcatenatingStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)),
            StringFunction.IDENTITY_FUNCTION)).transform("String"));
  }
}

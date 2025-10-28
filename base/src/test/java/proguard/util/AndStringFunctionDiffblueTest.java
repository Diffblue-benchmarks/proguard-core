package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class AndStringFunctionDiffblueTest {
  /**
   * Method under test: {@link AndStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("String", (new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
        .transform("String"));
    assertEquals("String",
        (new AndStringFunction(
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
            StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertNull((new AndStringFunction(new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
        StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertEquals("String",
        (new AndStringFunction(
            new ConcatenatingStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
            StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertEquals("String",
        (new AndStringFunction(StringFunction.IDENTITY_FUNCTION,
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
                .transform("String"));
    assertNull((new AndStringFunction(StringFunction.IDENTITY_FUNCTION,
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool))).transform("String"));
    assertEquals("String",
        (new AndStringFunction(
            new ConcatenatingStringFunction(StringFunction.IDENTITY_FUNCTION,
                new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)),
            StringFunction.IDENTITY_FUNCTION)).transform("String"));
  }
}

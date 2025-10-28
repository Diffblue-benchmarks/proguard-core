package proguard.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class PrefixAddingStringFunctionDiffblueTest {
  /**
   * Method under test: {@link PrefixAddingStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("PrefixString", (new PrefixAddingStringFunction("Prefix")).transform("String"));
    assertEquals("PrefixString",
        (new PrefixAddingStringFunction("Prefix", StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertEquals("PrefixString",
        (new PrefixAddingStringFunction("Prefix",
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
                .transform("String"));
    assertEquals("Prefixnull",
        (new PrefixAddingStringFunction("Prefix", new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("String"));
    assertEquals("PrefixPrefixString",
        (new PrefixAddingStringFunction("Prefix", new PrefixAddingStringFunction("Prefix"))).transform("String"));
    assertEquals("PrefixPrefixString",
        (new PrefixAddingStringFunction("Prefix",
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, new PrefixAddingStringFunction("Prefix"))))
                .transform("String"));
  }
}

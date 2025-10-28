package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class PrefixRemovingStringFunctionDiffblueTest {
  /**
   * Method under test:
   * {@link PrefixRemovingStringFunction#PrefixRemovingStringFunction(String)}
   */
  @Test
  public void testNewPrefixRemovingStringFunction() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("Prefix")).transform("String"));
    assertEquals("String", (new PrefixRemovingStringFunction("")).transform("String"));
  }

  /**
   * Method under test: {@link PrefixRemovingStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("String", (new PrefixRemovingStringFunction("Prefix")).transform("String"));
    assertEquals("String", (new PrefixRemovingStringFunction("")).transform("String"));
    assertEquals("String",
        (new PrefixRemovingStringFunction("Prefix",
            new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
                .transform("String"));
    assertNull((new PrefixRemovingStringFunction("Prefix", new AndStringFunction(
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool), StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
    assertNull((new PrefixRemovingStringFunction("", new AndStringFunction(
        new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool), StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
  }
}

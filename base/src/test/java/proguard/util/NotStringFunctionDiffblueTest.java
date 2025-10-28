package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class NotStringFunctionDiffblueTest {
  /**
   * Method under test: {@link NotStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertNull((new NotStringFunction(StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertNull((new NotStringFunction(
        new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION)))
            .transform("String"));
    assertEquals("String",
        (new NotStringFunction(new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool))).transform("String"));
  }
}

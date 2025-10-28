package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class AndNotStringFunctionDiffblueTest {
  /**
   * Method under test: {@link AndNotStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertNull((new AndNotStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION))
        .transform("String"));
    assertNull((new AndNotStringFunction(
        new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION),
        StringFunction.IDENTITY_FUNCTION)).transform("String"));
    assertEquals("String", (new AndNotStringFunction(new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool),
        StringFunction.IDENTITY_FUNCTION)).transform("String"));
  }

  /**
   * Method under test: {@link AndNotStringFunction#transform(String)}
   */
  @Test
  public void testTransform2() {
    // Arrange
    ClassPoolFeatureNameFunction stringFunction1 = new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool);

    // Act and Assert
    assertNull(
        (new AndNotStringFunction(stringFunction1, new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)))
            .transform("String"));
  }
}

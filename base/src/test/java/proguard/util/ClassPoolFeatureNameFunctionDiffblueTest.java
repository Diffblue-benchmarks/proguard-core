package proguard.util;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassPoolFeatureNameFunctionDiffblueTest {
  /**
   * Method under test: {@link ClassPoolFeatureNameFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertNull((new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)).transform("String"));
  }
}

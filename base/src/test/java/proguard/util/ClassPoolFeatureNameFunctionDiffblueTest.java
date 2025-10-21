package proguard.util;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassPoolFeatureNameFunctionDiffblueTest {
  /**
   * Test {@link ClassPoolFeatureNameFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPoolFeatureNameFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassPoolFeatureNameFunction.transform(String)"})
  public void testTransform_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)).transform("String"));
  }

  /**
   * Test {@link ClassPoolFeatureNameFunction#transform(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPoolFeatureNameFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassPoolFeatureNameFunction.transform(String)"})
  public void testTransform_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool)).transform(""));
  }
}

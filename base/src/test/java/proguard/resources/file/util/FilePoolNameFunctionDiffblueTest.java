package proguard.resources.file.util;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.resources.file.ResourceFilePool;

public class FilePoolNameFunctionDiffblueTest {
  /**
   * Test {@link FilePoolNameFunction#transform(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilePoolNameFunction#transform(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FilePoolNameFunction.transform(String)"})
  public void testTransform_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FilePoolNameFunction(new ResourceFilePool())).transform("String"));
  }
}

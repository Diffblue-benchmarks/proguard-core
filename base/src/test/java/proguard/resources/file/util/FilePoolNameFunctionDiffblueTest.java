package proguard.resources.file.util;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.resources.file.ResourceFilePool;

public class FilePoolNameFunctionDiffblueTest {
  /**
   * Method under test: {@link FilePoolNameFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertNull((new FilePoolNameFunction(new ResourceFilePool())).transform("String"));
  }
}

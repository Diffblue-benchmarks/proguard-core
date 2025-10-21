package proguard.resources.file.visitor;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ResourceJavaReferenceCollectorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ResourceJavaReferenceCollector}
   *   <li>{@link ResourceJavaReferenceCollector#getReferences()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ResourceJavaReferenceCollector.<init>()",
    "java.util.Set ResourceJavaReferenceCollector.getReferences()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new ResourceJavaReferenceCollector()).getReferences());
  }
}

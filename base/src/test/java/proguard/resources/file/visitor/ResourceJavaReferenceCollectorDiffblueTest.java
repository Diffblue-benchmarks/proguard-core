package proguard.resources.file.visitor;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceJavaReferenceCollectorDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceJavaReferenceCollector.<init>()",
    "java.util.Set ResourceJavaReferenceCollector.getReferences()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(new ResourceJavaReferenceCollector().getReferences());
  }
}

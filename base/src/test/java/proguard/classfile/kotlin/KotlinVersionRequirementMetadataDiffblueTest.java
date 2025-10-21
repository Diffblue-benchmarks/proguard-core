package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinVersionRequirementMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KotlinVersionRequirementMetadata}
   *   <li>{@link KotlinVersionRequirementMetadata#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinVersionRequirementMetadata.<init>()",
    "java.lang.String KotlinVersionRequirementMetadata.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinVersionRequirementMetadata actualKotlinVersionRequirementMetadata =
        new KotlinVersionRequirementMetadata();

    // Assert
    assertEquals("Kotlin version req (0.0.0)", actualKotlinVersionRequirementMetadata.toString());
    assertNull(actualKotlinVersionRequirementMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinVersionRequirementMetadata.getProcessingFlags());
  }
}

package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinContractMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KotlinContractMetadata}
   *   <li>{@link KotlinContractMetadata#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinContractMetadata.<init>()",
    "java.lang.String KotlinContractMetadata.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinContractMetadata actualKotlinContractMetadata = new KotlinContractMetadata();

    // Assert
    assertEquals("Kotlin contract", actualKotlinContractMetadata.toString());
    assertNull(actualKotlinContractMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinContractMetadata.getProcessingFlags());
  }
}

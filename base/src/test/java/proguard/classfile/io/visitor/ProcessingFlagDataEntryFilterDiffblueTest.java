package proguard.classfile.io.visitor;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;
import proguard.resources.file.ResourceFilePool;

class ProcessingFlagDataEntryFilterDiffblueTest {
  /**
   * Test {@link ProcessingFlagDataEntryFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessingFlagDataEntryFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName("Test accepts(DataEntry); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.io.visitor.ProcessingFlagDataEntryFilter.accepts(proguard.io.DataEntry)"
  })
  void testAccepts_thenReturnFalse() {
    // Arrange
    ProcessingFlagDataEntryFilter processingFlagDataEntryFilter =
        new ProcessingFlagDataEntryFilter(new ResourceFilePool(), 1, 1);

    // Act and Assert
    assertFalse(processingFlagDataEntryFilter.accepts(new ClassPathDataEntry("Name")));
  }
}

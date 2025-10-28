package proguard.classfile.io.visitor;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;
import proguard.resources.file.ResourceFilePool;

public class ProcessingFlagDataEntryFilterDiffblueTest {
  /**
   * Method under test: {@link ProcessingFlagDataEntryFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts() {
    // Arrange
    ProcessingFlagDataEntryFilter processingFlagDataEntryFilter = new ProcessingFlagDataEntryFilter(
        new ResourceFilePool(), 1, 1);

    // Act and Assert
    assertFalse(processingFlagDataEntryFilter.accepts(new ClassPathDataEntry("Name")));
  }
}

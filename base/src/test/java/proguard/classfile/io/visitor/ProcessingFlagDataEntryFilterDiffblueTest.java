package proguard.classfile.io.visitor;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;
import proguard.resources.file.ResourceFilePool;

public class ProcessingFlagDataEntryFilterDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProcessingFlagDataEntryFilter.accepts(DataEntry)"})
  public void testAccepts_thenReturnFalse() {
    // Arrange
    ProcessingFlagDataEntryFilter processingFlagDataEntryFilter =
        new ProcessingFlagDataEntryFilter(new ResourceFilePool(), 1, 1);

    // Act and Assert
    assertFalse(processingFlagDataEntryFilter.accepts(new ClassPathDataEntry("Name")));
  }
}

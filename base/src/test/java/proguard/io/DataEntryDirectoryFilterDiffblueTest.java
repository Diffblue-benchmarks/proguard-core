package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataEntryDirectoryFilterDiffblueTest {
  /**
   * Test {@link DataEntryDirectoryFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryDirectoryFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryDirectoryFilter.accepts(DataEntry)"})
  public void testAccepts_thenReturnTrue() {
    // Arrange
    DataEntryDirectoryFilter dataEntryDirectoryFilter = new DataEntryDirectoryFilter();

    // Act and Assert
    assertTrue(
        dataEntryDirectoryFilter.accepts(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Test {@link DataEntryDirectoryFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryDirectoryFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryDirectoryFilter.accepts(DataEntry)"})
  public void testAccepts_whenClassPathDataEntryWithName_thenReturnFalse() {
    // Arrange
    DataEntryDirectoryFilter dataEntryDirectoryFilter = new DataEntryDirectoryFilter();

    // Act and Assert
    assertFalse(dataEntryDirectoryFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link DataEntryDirectoryFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryDirectoryFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryDirectoryFilter.accepts(DataEntry)"})
  public void testAccepts_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DataEntryDirectoryFilter()).accepts(null));
  }
}

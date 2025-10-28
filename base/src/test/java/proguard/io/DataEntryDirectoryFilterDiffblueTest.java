package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DataEntryDirectoryFilterDiffblueTest {
  /**
   * Method under test: {@link DataEntryDirectoryFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts() {
    // Arrange
    DataEntryDirectoryFilter dataEntryDirectoryFilter = new DataEntryDirectoryFilter();

    // Act and Assert
    assertFalse(dataEntryDirectoryFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link DataEntryDirectoryFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts2() {
    // Arrange, Act and Assert
    assertFalse((new DataEntryDirectoryFilter()).accepts(null));
  }

  /**
   * Method under test: {@link DataEntryDirectoryFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts3() {
    // Arrange
    DataEntryDirectoryFilter dataEntryDirectoryFilter = new DataEntryDirectoryFilter();

    // Act and Assert
    assertTrue(dataEntryDirectoryFilter.accepts(new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }
}

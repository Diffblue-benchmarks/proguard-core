package proguard.io;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class DataEntryParentFilterDiffblueTest {
  /**
   * Method under test: {@link DataEntryParentFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts() {
    // Arrange
    DataEntryParentFilter dataEntryParentFilter = new DataEntryParentFilter(new DataEntryDirectoryFilter());

    // Act and Assert
    assertFalse(dataEntryParentFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link DataEntryParentFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts2() {
    // Arrange, Act and Assert
    assertFalse((new DataEntryParentFilter(new DataEntryDirectoryFilter())).accepts(null));
  }

  /**
   * Method under test: {@link DataEntryParentFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts3() {
    // Arrange
    DataEntryParentFilter dataEntryParentFilter = new DataEntryParentFilter(
        new DataEntryParentFilter(new DataEntryDirectoryFilter()));

    // Act and Assert
    assertFalse(dataEntryParentFilter.accepts(new ClassPathDataEntry("Name")));
  }
}

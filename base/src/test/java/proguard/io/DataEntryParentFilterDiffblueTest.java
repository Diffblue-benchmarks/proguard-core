package proguard.io;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataEntryParentFilterDiffblueTest {
  /**
   * Test {@link DataEntryParentFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryParentFilter#DataEntryParentFilter(DataEntryFilter)} with
   *       dataEntryFilter is {@link DataEntryParentFilter#DataEntryParentFilter(DataEntryFilter)}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryParentFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryParentFilter.accepts(DataEntry)"})
  public void testAccepts_givenDataEntryParentFilterWithDataEntryFilterIsDataEntryParentFilter() {
    // Arrange
    DataEntryParentFilter dataEntryParentFilter =
        new DataEntryParentFilter(new DataEntryParentFilter(new DataEntryDirectoryFilter()));

    // Act and Assert
    assertFalse(dataEntryParentFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link DataEntryParentFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryParentFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryParentFilter.accepts(DataEntry)"})
  public void testAccepts_thenReturnFalse() {
    // Arrange
    DataEntryParentFilter dataEntryParentFilter =
        new DataEntryParentFilter(new DataEntryDirectoryFilter());

    // Act and Assert
    assertFalse(dataEntryParentFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link DataEntryParentFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryParentFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryParentFilter.accepts(DataEntry)"})
  public void testAccepts_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DataEntryParentFilter(new DataEntryDirectoryFilter())).accepts(null));
  }
}

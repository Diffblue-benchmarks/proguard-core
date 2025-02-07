package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataEntryDirectoryFilterDiffblueTest {
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
  @DisplayName("Test accepts(DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.DataEntryDirectoryFilter.accepts(proguard.io.DataEntry)"})
  void testAccepts_thenReturnTrue() {
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
  @DisplayName(
      "Test accepts(DataEntry); when ClassPathDataEntry(String) with 'Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.DataEntryDirectoryFilter.accepts(proguard.io.DataEntry)"})
  void testAccepts_whenClassPathDataEntryWithName_thenReturnFalse() {
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
  @DisplayName("Test accepts(DataEntry); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.DataEntryDirectoryFilter.accepts(proguard.io.DataEntry)"})
  void testAccepts_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DataEntryDirectoryFilter()).accepts(null));
  }
}

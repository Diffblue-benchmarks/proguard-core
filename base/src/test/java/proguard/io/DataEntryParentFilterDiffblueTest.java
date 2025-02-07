package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataEntryParentFilterDiffblueTest {
  /**
   * Test {@link DataEntryParentFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryParentFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test accepts(DataEntry); given DataEntryFilter accepts(DataEntry) return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.DataEntryParentFilter.accepts(proguard.io.DataEntry)"})
  void testAccepts_givenDataEntryFilterAcceptsReturnFalse_thenReturnFalse() {
    // Arrange
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    DataEntryParentFilter dataEntryParentFilter = new DataEntryParentFilter(dataEntryFilter);

    // Act
    boolean actualAcceptsResult = dataEntryParentFilter.accepts(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isNull());
    assertFalse(actualAcceptsResult);
  }

  /**
   * Test {@link DataEntryParentFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryParentFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test accepts(DataEntry); given DataEntryFilter accepts(DataEntry) return 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.DataEntryParentFilter.accepts(proguard.io.DataEntry)"})
  void testAccepts_givenDataEntryFilterAcceptsReturnTrue_thenReturnTrue() {
    // Arrange
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryParentFilter dataEntryParentFilter = new DataEntryParentFilter(dataEntryFilter);

    // Act
    boolean actualAcceptsResult = dataEntryParentFilter.accepts(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isNull());
    assertTrue(actualAcceptsResult);
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
  @DisplayName("Test accepts(DataEntry); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.DataEntryParentFilter.accepts(proguard.io.DataEntry)"})
  void testAccepts_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DataEntryParentFilter(mock(DataEntryFilter.class))).accepts(null));
  }
}

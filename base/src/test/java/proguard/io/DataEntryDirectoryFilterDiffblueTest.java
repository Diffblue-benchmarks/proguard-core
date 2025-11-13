package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryDirectoryFilter.accepts(DataEntry)"})
  void testAccepts_thenReturnTrue() {
    // Arrange
    DataEntryDirectoryFilter dataEntryDirectoryFilter = new DataEntryDirectoryFilter();
    Class<Object> clazz = Object.class;
    DummyDataEntry dataEntry = new DummyDataEntry(new ClassPathDataEntry(clazz), "Name", 3L, true);

    // Act
    boolean actualAcceptsResult = dataEntryDirectoryFilter.accepts(dataEntry);

    // Assert
    assertTrue(actualAcceptsResult);
  }

  /**
   * Test {@link DataEntryDirectoryFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryDirectoryFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName("Test accepts(DataEntry); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryDirectoryFilter.accepts(DataEntry)"})
  void testAccepts_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DataEntryDirectoryFilter dataEntryDirectoryFilter = new DataEntryDirectoryFilter();
    Class<Object> clazz = Object.class;

    // Act
    boolean actualAcceptsResult = dataEntryDirectoryFilter.accepts(new ClassPathDataEntry(clazz));

    // Assert
    assertFalse(actualAcceptsResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryDirectoryFilter.accepts(DataEntry)"})
  void testAccepts_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DataEntryDirectoryFilter().accepts(null));
  }
}

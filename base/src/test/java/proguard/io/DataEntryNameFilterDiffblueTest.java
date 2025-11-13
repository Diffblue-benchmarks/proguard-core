package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.util.CollectionMatcher;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;

class DataEntryNameFilterDiffblueTest {
  /**
   * Test {@link DataEntryNameFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test accepts(DataEntry); given CollectionMatcher(Set) with set is HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryNameFilter.accepts(DataEntry)"})
  void testAccepts_givenCollectionMatcherWithSetIsHashSet_thenReturnFalse() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter =
        new DataEntryNameFilter(new CollectionMatcher(new HashSet<>()));
    Class<Object> clazz = Object.class;

    // Act
    boolean actualAcceptsResult = dataEntryNameFilter.accepts(new ClassPathDataEntry(clazz));

    // Assert
    assertFalse(actualAcceptsResult);
  }

  /**
   * Test {@link DataEntryNameFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test accepts(DataEntry); given ConstantMatcher(boolean) with matches is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryNameFilter.accepts(DataEntry)"})
  void testAccepts_givenConstantMatcherWithMatchesIsTrue_thenReturnTrue() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter = new DataEntryNameFilter(new ConstantMatcher(true));
    Class<Object> clazz = Object.class;

    // Act
    boolean actualAcceptsResult = dataEntryNameFilter.accepts(new ClassPathDataEntry(clazz));

    // Assert
    assertTrue(actualAcceptsResult);
  }

  /**
   * Test {@link DataEntryNameFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryNameFilter#DataEntryNameFilter(StringMatcher)} with stringMatcher
   *       is {@link EmptyStringMatcher} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test accepts(DataEntry); given DataEntryNameFilter(StringMatcher) with stringMatcher is EmptyStringMatcher (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryNameFilter.accepts(DataEntry)"})
  void testAccepts_givenDataEntryNameFilterWithStringMatcherIsEmptyStringMatcher() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter = new DataEntryNameFilter(new EmptyStringMatcher());
    Class<Object> clazz = Object.class;

    // Act
    boolean actualAcceptsResult = dataEntryNameFilter.accepts(new ClassPathDataEntry(clazz));

    // Assert
    assertFalse(actualAcceptsResult);
  }

  /**
   * Test {@link DataEntryNameFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName("Test accepts(DataEntry); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryNameFilter.accepts(DataEntry)"})
  void testAccepts_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new DataEntryNameFilter(new EmptyStringMatcher()).accepts(null));
  }
}

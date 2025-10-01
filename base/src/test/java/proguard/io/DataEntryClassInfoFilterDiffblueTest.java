package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.kotlin.KotlinConstants;

class DataEntryClassInfoFilterDiffblueTest {
  /**
   * Test {@link DataEntryClassInfoFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test accepts(DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryClassInfoFilter.accepts(DataEntry)"})
  void testAccepts_whenClassPathDataEntryWithNameIsClass_thenReturnFalse() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter =
        new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool, "Processing Info");

    // Act
    boolean actualAcceptsResult =
        dataEntryClassInfoFilter.accepts(new ClassPathDataEntry(".class"));

    // Assert
    assertFalse(actualAcceptsResult);
  }

  /**
   * Test {@link DataEntryClassInfoFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test accepts(DataEntry); when ClassPathDataEntry(String) with 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryClassInfoFilter.accepts(DataEntry)"})
  void testAccepts_whenClassPathDataEntryWithName_thenReturnFalse() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter =
        new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool, "Processing Info");

    // Act
    boolean actualAcceptsResult = dataEntryClassInfoFilter.accepts(new ClassPathDataEntry("Name"));

    // Assert
    assertFalse(actualAcceptsResult);
  }

  /**
   * Test {@link DataEntryClassInfoFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  @DisplayName("Test accepts(DataEntry); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataEntryClassInfoFilter.accepts(DataEntry)"})
  void testAccepts_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter =
        new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool, "Processing Info");
    Class<Object> clazz = Object.class;

    // Act
    boolean actualAcceptsResult = dataEntryClassInfoFilter.accepts(new ClassPathDataEntry(clazz));

    // Assert
    assertFalse(actualAcceptsResult);
  }
}

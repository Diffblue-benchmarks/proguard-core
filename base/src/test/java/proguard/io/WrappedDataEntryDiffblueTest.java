package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WrappedDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WrappedDataEntry#WrappedDataEntry(DataEntry)}
   *   <li>{@link WrappedDataEntry#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WrappedDataEntry.<init>(DataEntry)",
    "java.lang.String WrappedDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", new WrappedDataEntry(new ClassPathDataEntry("Name")).toString());
  }

  /**
   * Test {@link WrappedDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getName()}
   */
  @Test
  @DisplayName("Test getName(); given ClassPathDataEntry(String) with 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getName()"})
  void testGetName_givenClassPathDataEntryWithName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", new WrappedDataEntry(new ClassPathDataEntry("Name")).getName());
  }

  /**
   * Test {@link WrappedDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       WrappedDataEntry#WrappedDataEntry(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given WrappedDataEntry(DataEntry) with wrappedEntry is WrappedDataEntry(DataEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getName()"})
  void testGetName_givenWrappedDataEntryWithWrappedEntryIsWrappedDataEntry() {
    // Arrange
    WrappedDataEntry wrappedEntry = new WrappedDataEntry(new ClassPathDataEntry("Name"));

    // Act and Assert
    assertEquals("Name", new WrappedDataEntry(wrappedEntry).getName());
  }

  /**
   * Test {@link WrappedDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link WrappedDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getOriginalName()"})
  void testGetOriginalName() {
    // Arrange
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name");

    // Act and Assert
    assertEquals("Name", new WrappedDataEntry(wrappedEntry).getOriginalName());
  }

  /**
   * Test {@link WrappedDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName(
      "Test getOriginalName(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getOriginalName()"})
  void testGetOriginalName_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertEquals("Name", new WrappedDataEntry(new ClassPathDataEntry("Name")).getOriginalName());
  }

  /**
   * Test {@link WrappedDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(String)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getSize()}
   */
  @Test
  @DisplayName(
      "Test getSize(); given RenamedDataEntry(DataEntry, String) with dataEntry is ClassPathDataEntry(String) and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WrappedDataEntry.getSize()"})
  void testGetSize_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name");

    // Act and Assert
    assertEquals(-1L, new WrappedDataEntry(wrappedEntry).getSize());
  }

  /**
   * Test {@link WrappedDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getSize()}
   */
  @Test
  @DisplayName(
      "Test getSize(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WrappedDataEntry.getSize()"})
  void testGetSize_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertEquals(-1L, new WrappedDataEntry(new ClassPathDataEntry("Name")).getSize());
  }

  /**
   * Test {@link WrappedDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(String)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  @DisplayName(
      "Test isDirectory(); given RenamedDataEntry(DataEntry, String) with dataEntry is ClassPathDataEntry(String) and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WrappedDataEntry.isDirectory()"})
  void testIsDirectory_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name");

    // Act and Assert
    assertFalse(new WrappedDataEntry(wrappedEntry).isDirectory());
  }

  /**
   * Test {@link WrappedDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  @DisplayName(
      "Test isDirectory(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WrappedDataEntry.isDirectory()"})
  void testIsDirectory_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertFalse(new WrappedDataEntry(new ClassPathDataEntry("Name")).isDirectory());
  }

  /**
   * Test {@link WrappedDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  @DisplayName("Test isDirectory(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WrappedDataEntry.isDirectory()"})
  void testIsDirectory_thenReturnTrue() {
    // Arrange
    DummyDataEntry wrappedEntry =
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(new WrappedDataEntry(wrappedEntry).isDirectory());
  }

  /**
   * Test {@link WrappedDataEntry#getInputStream()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(String)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getInputStream()}
   */
  @Test
  @DisplayName(
      "Test getInputStream(); given RenamedDataEntry(DataEntry, String) with dataEntry is ClassPathDataEntry(String) and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream WrappedDataEntry.getInputStream()"})
  void testGetInputStream_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName()
      throws IOException {
    // Arrange
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name");

    // Act and Assert
    assertNull(new WrappedDataEntry(wrappedEntry).getInputStream());
  }

  /**
   * Test {@link WrappedDataEntry#getInputStream()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getInputStream()}
   */
  @Test
  @DisplayName(
      "Test getInputStream(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream WrappedDataEntry.getInputStream()"})
  void testGetInputStream_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new WrappedDataEntry(new ClassPathDataEntry("Name")).getInputStream());
  }

  /**
   * Test {@link WrappedDataEntry#getParent()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(String)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getParent()}
   */
  @Test
  @DisplayName(
      "Test getParent(); given RenamedDataEntry(DataEntry, String) with dataEntry is ClassPathDataEntry(String) and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataEntry WrappedDataEntry.getParent()"})
  void testGetParent_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name");

    // Act and Assert
    assertNull(new WrappedDataEntry(wrappedEntry).getParent());
  }

  /**
   * Test {@link WrappedDataEntry#getParent()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getParent()}
   */
  @Test
  @DisplayName(
      "Test getParent(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataEntry WrappedDataEntry.getParent()"})
  void testGetParent_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertNull(new WrappedDataEntry(new ClassPathDataEntry("Name")).getParent());
  }
}

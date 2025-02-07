package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.WrappedDataEntry.<init>(proguard.io.DataEntry)",
    "java.lang.String proguard.io.WrappedDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).toString());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.WrappedDataEntry.getName()"})
  void testGetName_givenClassPathDataEntryWithName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.WrappedDataEntry.getName()"})
  void testGetName_givenWrappedDataEntryWithWrappedEntryIsWrappedDataEntry() {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new WrappedDataEntry(new WrappedDataEntry(new ClassPathDataEntry("Name")))).getName());
  }

  /**
   * Test {@link WrappedDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link WrappedDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.WrappedDataEntry.getOriginalName()"})
  void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .getOriginalName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.WrappedDataEntry.getOriginalName()"})
  void testGetOriginalName_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getOriginalName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long proguard.io.WrappedDataEntry.getSize()"})
  void testGetSize_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange, Act and Assert
    assertEquals(
        -1L,
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .getSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long proguard.io.WrappedDataEntry.getSize()"})
  void testGetSize_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.WrappedDataEntry.isDirectory()"})
  void testIsDirectory_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange, Act and Assert
    assertFalse(
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .isDirectory());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.WrappedDataEntry.isDirectory()"})
  void testIsDirectory_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertFalse((new WrappedDataEntry(new ClassPathDataEntry("Name"))).isDirectory());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.WrappedDataEntry.isDirectory()"})
  void testIsDirectory_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new WrappedDataEntry(new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)))
            .isDirectory());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream proguard.io.WrappedDataEntry.getInputStream()"})
  void testGetInputStream_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .getInputStream());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream proguard.io.WrappedDataEntry.getInputStream()"})
  void testGetInputStream_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry()
      throws IOException {
    // Arrange, Act and Assert
    assertNull((new WrappedDataEntry(new ClassPathDataEntry("Name"))).getInputStream());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.io.DataEntry proguard.io.WrappedDataEntry.getParent()"})
  void testGetParent_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange, Act and Assert
    assertNull(
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .getParent());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.io.DataEntry proguard.io.WrappedDataEntry.getParent()"})
  void testGetParent_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertNull((new WrappedDataEntry(new ClassPathDataEntry("Name"))).getParent());
  }
}

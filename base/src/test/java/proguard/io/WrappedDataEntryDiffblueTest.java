package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        "java/lang/Object.class", new WrappedDataEntry(new ClassPathDataEntry(clazz)).toString());
  }

  /**
   * Test {@link WrappedDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@code java/lang/Object.class}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getName()}
   */
  @Test
  @DisplayName("Test getName(); given 'java.lang.Object'; then return 'java/lang/Object.class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getName()"})
  void testGetName_givenJavaLangObject_thenReturnJavaLangObjectClass() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        "java/lang/Object.class", new WrappedDataEntry(new ClassPathDataEntry(clazz)).getName());
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
    Class<Object> clazz = Object.class;
    WrappedDataEntry wrappedEntry = new WrappedDataEntry(new ClassPathDataEntry(clazz));

    // Act and Assert
    assertEquals("java/lang/Object.class", new WrappedDataEntry(wrappedEntry).getName());
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
    Class<Object> clazz = Object.class;
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry(clazz), "Name");

    // Act and Assert
    assertEquals("java/lang/Object.class", new WrappedDataEntry(wrappedEntry).getOriginalName());
  }

  /**
   * Test {@link WrappedDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName(
      "Test getOriginalName(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getOriginalName()"})
  void testGetOriginalName_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        "java/lang/Object.class",
        new WrappedDataEntry(new ClassPathDataEntry(clazz)).getOriginalName());
  }

  /**
   * Test {@link WrappedDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(Class)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getSize()}
   */
  @Test
  @DisplayName(
      "Test getSize(); given RenamedDataEntry(DataEntry, String) with dataEntry is ClassPathDataEntry(Class) and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WrappedDataEntry.getSize()"})
  void testGetSize_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange
    Class<Object> clazz = Object.class;
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry(clazz), "Name");

    // Act and Assert
    assertEquals(-1L, new WrappedDataEntry(wrappedEntry).getSize());
  }

  /**
   * Test {@link WrappedDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getSize()}
   */
  @Test
  @DisplayName(
      "Test getSize(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WrappedDataEntry.getSize()"})
  void testGetSize_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(-1L, new WrappedDataEntry(new ClassPathDataEntry(clazz)).getSize());
  }

  /**
   * Test {@link WrappedDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(Class)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  @DisplayName(
      "Test isDirectory(); given RenamedDataEntry(DataEntry, String) with dataEntry is ClassPathDataEntry(Class) and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WrappedDataEntry.isDirectory()"})
  void testIsDirectory_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange
    Class<Object> clazz = Object.class;
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry(clazz), "Name");

    // Act and Assert
    assertFalse(new WrappedDataEntry(wrappedEntry).isDirectory());
  }

  /**
   * Test {@link WrappedDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  @DisplayName(
      "Test isDirectory(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WrappedDataEntry.isDirectory()"})
  void testIsDirectory_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(new WrappedDataEntry(new ClassPathDataEntry(clazz)).isDirectory());
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
    Class<Object> clazz = Object.class;
    DummyDataEntry wrappedEntry =
        new DummyDataEntry(new ClassPathDataEntry(clazz), "Name", 3L, true);

    // Act and Assert
    assertTrue(new WrappedDataEntry(wrappedEntry).isDirectory());
  }

  /**
   * Test {@link WrappedDataEntry#getParent()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(Class)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getParent()}
   */
  @Test
  @DisplayName(
      "Test getParent(); given RenamedDataEntry(DataEntry, String) with dataEntry is ClassPathDataEntry(Class) and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataEntry WrappedDataEntry.getParent()"})
  void testGetParent_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange
    Class<Object> clazz = Object.class;
    RenamedDataEntry wrappedEntry = new RenamedDataEntry(new ClassPathDataEntry(clazz), "Name");

    // Act and Assert
    assertNull(new WrappedDataEntry(wrappedEntry).getParent());
  }

  /**
   * Test {@link WrappedDataEntry#getParent()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getParent()}
   */
  @Test
  @DisplayName(
      "Test getParent(); given WrappedDataEntry(DataEntry) with wrappedEntry is ClassPathDataEntry(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataEntry WrappedDataEntry.getParent()"})
  void testGetParent_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(new WrappedDataEntry(new ClassPathDataEntry(clazz)).getParent());
  }
}

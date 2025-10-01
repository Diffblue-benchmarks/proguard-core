package proguard.resources.kotlinmodule.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;
import proguard.io.DirectoryWriter;
import proguard.io.FixedFileWriter;
import proguard.io.NameFilteredDataEntryWriter;
import proguard.resources.file.ResourceFilePool;

class KotlinModuleDataEntryWriterDiffblueTest {
  /**
   * Test {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinModuleDataEntryWriter.createDirectory(DataEntry)"})
  void testCreateDirectory_thenReturnFalse() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ResourceFilePool resourceFilePool = new ResourceFilePool(new ArrayList<>());
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    NameFilteredDataEntryWriter dataEntryWriter =
        new NameFilteredDataEntryWriter("Regular Expression", acceptedDataEntryWriter);

    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(resourceFilePool, dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult =
        kotlinModuleDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinModuleDataEntryWriter.createDirectory(DataEntry)"})
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    FixedFileWriter dataEntryWriter =
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(resourceFilePool, dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult =
        kotlinModuleDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinModuleDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DirectoryWriter dataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(resourceFilePool, dataEntryWriter);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        kotlinModuleDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KotlinModuleDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DirectoryWriter dataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(resourceFilePool, dataEntryWriter);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        kotlinModuleDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link KotlinModuleDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName("Test createOutputStream(DataEntry); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream KotlinModuleDataEntryWriter.createOutputStream(DataEntry)"})
  void testCreateOutputStream_thenReturnNull() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DirectoryWriter dataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(resourceFilePool, dataEntryWriter);

    // Act
    OutputStream actualCreateOutputStreamResult =
        kotlinModuleDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name"));

    // Assert
    assertNull(actualCreateOutputStreamResult);
  }
}

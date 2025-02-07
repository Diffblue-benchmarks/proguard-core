package proguard.resources.kotlinmodule.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;
import proguard.io.DirectoryWriter;
import proguard.io.FixedFileWriter;
import proguard.resources.file.ResourceFilePool;

class KotlinModuleDataEntryWriterDiffblueTest {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.resources.kotlinmodule.io.KotlinModuleDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(kotlinModuleDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.resources.kotlinmodule.io.KotlinModuleDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.resources.kotlinmodule.io.KotlinModuleDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.resources.kotlinmodule.io.KotlinModuleDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_thenReturnNull() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertNull(kotlinModuleDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }
}

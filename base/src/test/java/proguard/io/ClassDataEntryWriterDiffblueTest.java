package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.kotlin.KotlinConstants;

class ClassDataEntryWriterDiffblueTest {
  /**
   * Test {@link ClassDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ClassDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassDataEntryWriter.createDirectory(DataEntry)"})
  void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FixedFileWriter dataEntryWriter =
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult =
        classDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link ClassDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ClassDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassDataEntryWriter.createDirectory(DataEntry)"})
  void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DirectoryWriter dataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassDataEntryWriter dataEntryWriter2 =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter);
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter2);

    // Act
    boolean actualCreateDirectoryResult =
        classDataEntryWriter.createDirectory(new ClassPathDataEntry(""));

    // Assert
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link ClassDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassDataEntryWriter.createDirectory(DataEntry)"})
  void testCreateDirectory_thenReturnFalse() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    NameFilteredDataEntryWriter dataEntryWriter =
        new NameFilteredDataEntryWriter("Regular Expression", acceptedDataEntryWriter);
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult =
        classDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter dataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassDataEntryWriter dataEntryWriter2 =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter);
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter2);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    NameFilteredDataEntryWriter dataEntryWriter =
        new NameFilteredDataEntryWriter("Regular Expression", acceptedDataEntryWriter);
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    DirectoryWriter dataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    DirectoryWriter dataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(classDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName("Test createOutputStream(DataEntry); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream ClassDataEntryWriter.createOutputStream(DataEntry)"})
  void testCreateOutputStream_thenReturnNull() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    NameFilteredDataEntryWriter dataEntryWriter =
        new NameFilteredDataEntryWriter("Regular Expression", acceptedDataEntryWriter);
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(KotlinConstants.dummyClassPool, dataEntryWriter);

    // Act
    OutputStream actualCreateOutputStreamResult =
        classDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name"));

    // Assert
    assertNull(actualCreateOutputStreamResult);
  }
}

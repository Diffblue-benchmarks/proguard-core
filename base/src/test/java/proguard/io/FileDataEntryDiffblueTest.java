package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FileDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileDataEntry#FileDataEntry(File)}
   *   <li>{@link FileDataEntry#toString()}
   *   <li>{@link FileDataEntry#getParent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileDataEntry.<init>(File)",
    "void FileDataEntry.<init>(File, File)",
    "proguard.io.DataEntry FileDataEntry.getParent()",
    "String FileDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    FileDataEntry actualFileDataEntry =
        new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    String actualToStringResult = actualFileDataEntry.toString();

    // Assert
    assertEquals("test.txt", actualToStringResult);
    assertNull(actualFileDataEntry.getParent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileDataEntry#FileDataEntry(File, File)}
   *   <li>{@link FileDataEntry#toString()}
   *   <li>{@link FileDataEntry#getParent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileDataEntry.<init>(File)",
    "void FileDataEntry.<init>(File, File)",
    "proguard.io.DataEntry FileDataEntry.getParent()",
    "String FileDataEntry.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange and Act
    FileDataEntry actualFileDataEntry =
        new FileDataEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    String actualToStringResult = actualFileDataEntry.toString();

    // Assert
    assertEquals("test.txt", actualToStringResult);
    assertNull(actualFileDataEntry.getParent());
  }

  /**
   * Test {@link FileDataEntry#getFile()}.
   *
   * <p>Method under test: {@link FileDataEntry#getFile()}
   */
  @Test
  @DisplayName("Test getFile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileDataEntry.getFile()"})
  void testGetFile() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FileDataEntry fileDataEntry =
        new FileDataEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    File actualFile = fileDataEntry.getFile();

    // Assert
    assertEquals("test.txt", actualFile.getName());
    assertTrue(actualFile.isAbsolute());
  }

  /**
   * Test {@link FileDataEntry#getFile()}.
   *
   * <ul>
   *   <li>Given {@link FileDataEntry#FileDataEntry(File)} with file is Property is {@code
   *       java.io.tmpdir} is {@code test.txt} toFile.
   * </ul>
   *
   * <p>Method under test: {@link FileDataEntry#getFile()}
   */
  @Test
  @DisplayName(
      "Test getFile(); given FileDataEntry(File) with file is Property is 'java.io.tmpdir' is 'test.txt' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileDataEntry.getFile()"})
  void testGetFile_givenFileDataEntryWithFileIsPropertyIsJavaIoTmpdirIsTestTxtToFile() {
    // Arrange and Act
    File actualFile =
        new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())
            .getFile();

    // Assert
    assertEquals("test.txt", actualFile.getName());
    assertTrue(actualFile.isAbsolute());
  }

  /**
   * Test {@link FileDataEntry#getFile()}.
   *
   * <ul>
   *   <li>Then return Name is {@code .txt}.
   * </ul>
   *
   * <p>Method under test: {@link FileDataEntry#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return Name is '.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileDataEntry.getFile()"})
  void testGetFile_thenReturnNameIsTxt() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FileDataEntry fileDataEntry =
        new FileDataEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    File actualFile = fileDataEntry.getFile();

    // Assert
    assertEquals(".txt", actualFile.getName());
    assertTrue(actualFile.isAbsolute());
  }

  /**
   * Test {@link FileDataEntry#getName()}.
   *
   * <p>Method under test: {@link FileDataEntry#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileDataEntry.getName()"})
  void testGetName() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FileDataEntry fileDataEntry =
        new FileDataEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertEquals("test.txt", fileDataEntry.getName());
  }

  /**
   * Test {@link FileDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link FileDataEntry#FileDataEntry(File)} with file is Property is {@code
   *       java.io.tmpdir} is {@code test.txt} toFile.
   * </ul>
   *
   * <p>Method under test: {@link FileDataEntry#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given FileDataEntry(File) with file is Property is 'java.io.tmpdir' is 'test.txt' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileDataEntry.getName()"})
  void testGetName_givenFileDataEntryWithFileIsPropertyIsJavaIoTmpdirIsTestTxtToFile() {
    // Arrange, Act and Assert
    assertEquals(
        "test.txt",
        new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())
            .getName());
  }

  /**
   * Test {@link FileDataEntry#getName()}.
   *
   * <ul>
   *   <li>Then return {@code .txt}.
   * </ul>
   *
   * <p>Method under test: {@link FileDataEntry#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileDataEntry.getName()"})
  void testGetName_thenReturnTxt() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FileDataEntry fileDataEntry =
        new FileDataEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertEquals(".txt", fileDataEntry.getName());
  }

  /**
   * Test {@link FileDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link FileDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileDataEntry.getOriginalName()"})
  void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals(
        "test.txt",
        new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())
            .getOriginalName());
  }

  /**
   * Test {@link FileDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link FileDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileDataEntry.getOriginalName()"})
  void testGetOriginalName2() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FileDataEntry fileDataEntry =
        new FileDataEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertEquals("test.txt", fileDataEntry.getOriginalName());
  }

  /**
   * Test {@link FileDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Then return {@code .txt}.
   * </ul>
   *
   * <p>Method under test: {@link FileDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName(); then return '.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileDataEntry.getOriginalName()"})
  void testGetOriginalName_thenReturnTxt() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FileDataEntry fileDataEntry =
        new FileDataEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertEquals(".txt", fileDataEntry.getOriginalName());
  }

  /**
   * Test {@link FileDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FileDataEntry#isDirectory()}
   */
  @Test
  @DisplayName("Test isDirectory(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileDataEntry.isDirectory()"})
  void testIsDirectory_thenReturnFalse() {
    // Arrange
    Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "42", "42", "foo");

    // Act and Assert
    assertFalse(new FileDataEntry(getResult.toFile()).isDirectory());
  }

  /**
   * Test {@link FileDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FileDataEntry#isDirectory()}
   */
  @Test
  @DisplayName("Test isDirectory(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileDataEntry.isDirectory()"})
  void testIsDirectory_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())
            .isDirectory());
  }
}

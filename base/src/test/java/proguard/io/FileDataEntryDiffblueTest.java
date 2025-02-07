package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.FileDataEntry.<init>(java.io.File)",
    "void proguard.io.FileDataEntry.<init>(java.io.File, java.io.File)",
    "proguard.io.DataEntry proguard.io.FileDataEntry.getParent()",
    "java.lang.String proguard.io.FileDataEntry.toString()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.FileDataEntry.<init>(java.io.File)",
    "void proguard.io.FileDataEntry.<init>(java.io.File, java.io.File)",
    "proguard.io.DataEntry proguard.io.FileDataEntry.getParent()",
    "java.lang.String proguard.io.FileDataEntry.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    FileDataEntry actualFileDataEntry =
        new FileDataEntry(
            directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.File proguard.io.FileDataEntry.getFile()"})
  void testGetFile() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    File actualFile =
        (new FileDataEntry(
                directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getFile();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.File proguard.io.FileDataEntry.getFile()"})
  void testGetFile_givenFileDataEntryWithFileIsPropertyIsJavaIoTmpdirIsTestTxtToFile() {
    // Arrange and Act
    File actualFile =
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.File proguard.io.FileDataEntry.getFile()"})
  void testGetFile_thenReturnNameIsTxt() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act
    File actualFile =
        (new FileDataEntry(
                directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getFile();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.FileDataEntry.getName()"})
  void testGetName() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act and Assert
    assertEquals(
        "test.txt",
        (new FileDataEntry(
                directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.FileDataEntry.getName()"})
  void testGetName_givenFileDataEntryWithFileIsPropertyIsJavaIoTmpdirIsTestTxtToFile() {
    // Arrange, Act and Assert
    assertEquals(
        "test.txt",
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.FileDataEntry.getName()"})
  void testGetName_thenReturnTxt() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertEquals(
        ".txt",
        (new FileDataEntry(
                directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getName());
  }

  /**
   * Test {@link FileDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link FileDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.FileDataEntry.getOriginalName()"})
  void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals(
        "test.txt",
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getOriginalName());
  }

  /**
   * Test {@link FileDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link FileDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.FileDataEntry.getOriginalName()"})
  void testGetOriginalName2() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act and Assert
    assertEquals(
        "test.txt",
        (new FileDataEntry(
                directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getOriginalName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.FileDataEntry.getOriginalName()"})
  void testGetOriginalName_thenReturnTxt() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertEquals(
        ".txt",
        (new FileDataEntry(
                directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getOriginalName());
  }

  /**
   * Test {@link FileDataEntry#getSize()}.
   *
   * <p>Method under test: {@link FileDataEntry#getSize()}
   */
  @Test
  @DisplayName("Test getSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long proguard.io.FileDataEntry.getSize()"})
  void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(
        4096L,
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.FileDataEntry.isDirectory()"})
  void testIsDirectory_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new FileDataEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "42", "42", "foo").toFile()))
            .isDirectory());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.FileDataEntry.isDirectory()"})
  void testIsDirectory_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .isDirectory());
  }
}

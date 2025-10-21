package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FileDataEntryDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FileDataEntry.<init>(File)",
    "void FileDataEntry.<init>(File, File)",
    "proguard.io.DataEntry FileDataEntry.getParent()",
    "String FileDataEntry.toString()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FileDataEntry.<init>(File)",
    "void FileDataEntry.<init>(File, File)",
    "proguard.io.DataEntry FileDataEntry.getParent()",
    "String FileDataEntry.toString()"
  })
  public void testGettersAndSetters2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File FileDataEntry.getFile()"})
  public void testGetFile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File FileDataEntry.getFile()"})
  public void testGetFile_givenFileDataEntryWithFileIsPropertyIsJavaIoTmpdirIsTestTxtToFile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File FileDataEntry.getFile()"})
  public void testGetFile_thenReturnNameIsTxt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileDataEntry.getName()"})
  public void testGetName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileDataEntry.getName()"})
  public void testGetName_givenFileDataEntryWithFileIsPropertyIsJavaIoTmpdirIsTestTxtToFile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileDataEntry.getName()"})
  public void testGetName_thenReturnTxt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileDataEntry.getOriginalName()"})
  public void testGetOriginalName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileDataEntry.getOriginalName()"})
  public void testGetOriginalName2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileDataEntry.getOriginalName()"})
  public void testGetOriginalName_thenReturnTxt() {
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
   * Test {@link FileDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FileDataEntry#isDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileDataEntry.isDirectory()"})
  public void testIsDirectory_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .isDirectory());
  }
}

package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.nio.file.Paths;
import org.junit.Test;

public class FileDataEntryDiffblueTest {
  /**
   * Method under test: {@link FileDataEntry#getFile()}
   */
  @Test
  public void testGetFile() {
    // Arrange and Act
    File actualFile = (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
        .getFile();

    // Assert
    assertEquals("test.txt", actualFile.getName());
    assertTrue(actualFile.isAbsolute());
  }

  /**
   * Method under test: {@link FileDataEntry#getFile()}
   */
  @Test
  public void testGetFile2() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    File actualFile = (new FileDataEntry(directory,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).getFile();

    // Assert
    assertEquals("test.txt", actualFile.getName());
    assertTrue(actualFile.isAbsolute());
  }

  /**
   * Method under test: {@link FileDataEntry#getFile()}
   */
  @Test
  public void testGetFile3() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act
    File actualFile = (new FileDataEntry(directory,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).getFile();

    // Assert
    assertEquals(".txt", actualFile.getName());
    assertTrue(actualFile.isAbsolute());
  }

  /**
   * Method under test: {@link FileDataEntry#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("test.txt",
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).getName());
  }

  /**
   * Method under test: {@link FileDataEntry#getName()}
   */
  @Test
  public void testGetName2() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act and Assert
    assertEquals("test.txt",
        (new FileDataEntry(directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).getName());
  }

  /**
   * Method under test: {@link FileDataEntry#getName()}
   */
  @Test
  public void testGetName3() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertEquals(".txt",
        (new FileDataEntry(directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).getName());
  }

  /**
   * Method under test: {@link FileDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals("test.txt",
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).getOriginalName());
  }

  /**
   * Method under test: {@link FileDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName2() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act and Assert
    assertEquals("test.txt",
        (new FileDataEntry(directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getOriginalName());
  }

  /**
   * Method under test: {@link FileDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName3() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertEquals(".txt",
        (new FileDataEntry(directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            .getOriginalName());
  }

  /**
   * Method under test: {@link FileDataEntry#getSize()}
   */
  @Test
  public void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(89L,
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).getSize());
  }

  /**
   * Method under test: {@link FileDataEntry#isDirectory()}
   */
  @Test
  public void testIsDirectory() {
    // Arrange, Act and Assert
    assertTrue((new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())).isDirectory());
    assertFalse(
        (new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "42", "42").toFile())).isDirectory());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileDataEntry#FileDataEntry(File)}
   *   <li>{@link FileDataEntry#toString()}
   *   <li>{@link FileDataEntry#getParent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FileDataEntry actualFileDataEntry = new FileDataEntry(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    String actualToStringResult = actualFileDataEntry.toString();

    // Assert
    assertEquals("test.txt", actualToStringResult);
    assertNull(actualFileDataEntry.getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileDataEntry#FileDataEntry(File, File)}
   *   <li>{@link FileDataEntry#toString()}
   *   <li>{@link FileDataEntry#getParent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    FileDataEntry actualFileDataEntry = new FileDataEntry(directory,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    String actualToStringResult = actualFileDataEntry.toString();

    // Assert
    assertEquals("test.txt", actualToStringResult);
    assertNull(actualFileDataEntry.getParent());
  }
}

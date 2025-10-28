package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.zip.ZipEntry;
import org.junit.Test;

public class ZipFileDataEntryDiffblueTest {
  /**
   * Method under test: {@link ZipFileDataEntry#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("foo", (new ZipFileDataEntry(parent, new ZipEntry("foo"), null)).getName());
  }

  /**
   * Method under test: {@link ZipFileDataEntry#getName()}
   */
  @Test
  public void testGetName2() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("", (new ZipFileDataEntry(parent, new ZipEntry(""), null)).getName());
  }

  /**
   * Method under test: {@link ZipFileDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("foo", (new ZipFileDataEntry(parent, new ZipEntry("foo"), null)).getOriginalName());
  }

  /**
   * Method under test: {@link ZipFileDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName2() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("", (new ZipFileDataEntry(parent, new ZipEntry(""), null)).getOriginalName());
  }

  /**
   * Method under test: {@link ZipFileDataEntry#getSize()}
   */
  @Test
  public void testGetSize() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals(-1L, (new ZipFileDataEntry(parent, new ZipEntry("foo"), null)).getSize());
  }

  /**
   * Method under test: {@link ZipFileDataEntry#isDirectory()}
   */
  @Test
  public void testIsDirectory() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertFalse((new ZipFileDataEntry(parent, new ZipEntry("foo"), null)).isDirectory());
  }
}

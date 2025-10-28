package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.zip.ZipEntry;
import org.junit.Test;

public class ZipDataEntryDiffblueTest {
  /**
   * Method under test: {@link ZipDataEntry#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("foo", (new ZipDataEntry(parent, new ZipEntry("foo"), null)).getName());
  }

  /**
   * Method under test: {@link ZipDataEntry#getName()}
   */
  @Test
  public void testGetName2() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("", (new ZipDataEntry(parent, new ZipEntry(""), null)).getName());
  }

  /**
   * Method under test: {@link ZipDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("foo", (new ZipDataEntry(parent, new ZipEntry("foo"), null)).getOriginalName());
  }

  /**
   * Method under test: {@link ZipDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName2() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("", (new ZipDataEntry(parent, new ZipEntry(""), null)).getOriginalName());
  }

  /**
   * Method under test: {@link ZipDataEntry#getSize()}
   */
  @Test
  public void testGetSize() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals(-1L, (new ZipDataEntry(parent, new ZipEntry("foo"), null)).getSize());
  }

  /**
   * Method under test: {@link ZipDataEntry#isDirectory()}
   */
  @Test
  public void testIsDirectory() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertFalse((new ZipDataEntry(parent, new ZipEntry("foo"), null)).isDirectory());
  }
}

package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.zip.ZipEntry;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ZipFileDataEntryDiffblueTest {
  /**
   * Test {@link ZipFileDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ZipFileDataEntry.getName()"})
  public void testGetName_givenZipEntryWithEmptyString_thenReturnEmptyString() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("", (new ZipFileDataEntry(parent, new ZipEntry(""), null)).getName());
  }

  /**
   * Test {@link ZipFileDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ZipFileDataEntry.getName()"})
  public void testGetName_givenZipEntryWithFoo_thenReturnFoo() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("foo", (new ZipFileDataEntry(parent, new ZipEntry("foo"), null)).getName());
  }

  /**
   * Test {@link ZipFileDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getOriginalName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ZipFileDataEntry.getOriginalName()"})
  public void testGetOriginalName_givenZipEntryWithEmptyString_thenReturnEmptyString() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals("", (new ZipFileDataEntry(parent, new ZipEntry(""), null)).getOriginalName());
  }

  /**
   * Test {@link ZipFileDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getOriginalName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ZipFileDataEntry.getOriginalName()"})
  public void testGetOriginalName_givenZipEntryWithFoo_thenReturnFoo() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals(
        "foo", (new ZipFileDataEntry(parent, new ZipEntry("foo"), null)).getOriginalName());
  }

  /**
   * Test {@link ZipFileDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ZipFileDataEntry.getSize()"})
  public void testGetSize_thenReturnMinusOne() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertEquals(-1L, (new ZipFileDataEntry(parent, new ZipEntry("foo"), null)).getSize());
  }

  /**
   * Test {@link ZipFileDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#isDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZipFileDataEntry.isDirectory()"})
  public void testIsDirectory_thenReturnFalse() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act and Assert
    assertFalse((new ZipFileDataEntry(parent, new ZipEntry("foo"), null)).isDirectory());
  }
}

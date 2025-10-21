package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ZipDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ZipDataEntry#ZipDataEntry(DataEntry, ZipEntry, ZipInputStream)}
   *   <li>{@link ZipDataEntry#toString()}
   *   <li>{@link ZipDataEntry#getParent()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ZipDataEntry.<init>(DataEntry, ZipEntry, ZipInputStream)",
    "DataEntry ZipDataEntry.getParent()",
    "String ZipDataEntry.toString()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ZipDataEntry actualZipDataEntry =
        new ZipDataEntry(
            parent, zipEntry, new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8")));
    String actualToStringResult = actualZipDataEntry.toString();

    // Assert
    assertEquals("Name:foo", actualToStringResult);
    assertSame(parent, actualZipDataEntry.getParent());
  }

  /**
   * Test {@link ZipDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ZipDataEntry#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ZipDataEntry.getName()"})
  public void testGetName_givenZipEntryWithEmptyString_thenReturnEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "",
        (new ZipDataEntry(
                parent,
                zipEntry,
                new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"))))
            .getName());
  }

  /**
   * Test {@link ZipDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ZipDataEntry#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ZipDataEntry.getName()"})
  public void testGetName_givenZipEntryWithFoo_thenReturnFoo() throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "foo",
        (new ZipDataEntry(
                parent,
                zipEntry,
                new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"))))
            .getName());
  }

  /**
   * Test {@link ZipDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ZipDataEntry#getOriginalName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ZipDataEntry.getOriginalName()"})
  public void testGetOriginalName_givenZipEntryWithEmptyString_thenReturnEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "",
        (new ZipDataEntry(
                parent,
                zipEntry,
                new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"))))
            .getOriginalName());
  }

  /**
   * Test {@link ZipDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ZipDataEntry#getOriginalName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ZipDataEntry.getOriginalName()"})
  public void testGetOriginalName_givenZipEntryWithFoo_thenReturnFoo()
      throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "foo",
        (new ZipDataEntry(
                parent,
                zipEntry,
                new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"))))
            .getOriginalName());
  }

  /**
   * Test {@link ZipDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with {@code foo}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ZipDataEntry#getSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ZipDataEntry.getSize()"})
  public void testGetSize_givenZipEntryWithFoo_thenReturnMinusOne()
      throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        -1L,
        (new ZipDataEntry(
                parent,
                zipEntry,
                new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"))))
            .getSize());
  }

  /**
   * Test {@link ZipDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZipDataEntry#isDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZipDataEntry.isDirectory()"})
  public void testIsDirectory_givenZipEntryWithFoo_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(
        (new ZipDataEntry(
                parent,
                zipEntry,
                new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"))))
            .isDirectory());
  }

  /**
   * Test {@link ZipDataEntry#getInputStream()}.
   *
   * <p>Method under test: {@link ZipDataEntry#getInputStream()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.InputStream ZipDataEntry.getInputStream()"})
  public void testGetInputStream() throws IOException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    (new ZipDataEntry(
            parent, zipEntry, new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"))))
        .getInputStream();

    // Assert
    assertEquals(51, (new byte[51]).length);
  }
}

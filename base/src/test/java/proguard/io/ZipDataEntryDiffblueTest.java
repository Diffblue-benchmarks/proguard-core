package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ZipDataEntryDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ZipDataEntry.<init>(DataEntry, ZipEntry, ZipInputStream)",
    "DataEntry ZipDataEntry.getParent()",
    "String ZipDataEntry.toString()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ZipInputStream zipInputStream =
        new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"));

    // Act
    ZipDataEntry actualZipDataEntry = new ZipDataEntry(parent, zipEntry, zipInputStream);
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
  @DisplayName("Test getName(); given ZipEntry(String) with empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ZipDataEntry.getName()"})
  void testGetName_givenZipEntryWithEmptyString_thenReturnEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ZipInputStream zipInputStream =
        new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"));

    ZipDataEntry zipDataEntry = new ZipDataEntry(parent, zipEntry, zipInputStream);

    // Act and Assert
    assertEquals("", zipDataEntry.getName());
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
  @DisplayName("Test getName(); given ZipEntry(String) with 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ZipDataEntry.getName()"})
  void testGetName_givenZipEntryWithFoo_thenReturnFoo() throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ZipInputStream zipInputStream =
        new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"));

    ZipDataEntry zipDataEntry = new ZipDataEntry(parent, zipEntry, zipInputStream);

    // Act and Assert
    assertEquals("foo", zipDataEntry.getName());
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
  @DisplayName(
      "Test getOriginalName(); given ZipEntry(String) with empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ZipDataEntry.getOriginalName()"})
  void testGetOriginalName_givenZipEntryWithEmptyString_thenReturnEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ZipInputStream zipInputStream =
        new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"));

    ZipDataEntry zipDataEntry = new ZipDataEntry(parent, zipEntry, zipInputStream);

    // Act and Assert
    assertEquals("", zipDataEntry.getOriginalName());
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
  @DisplayName("Test getOriginalName(); given ZipEntry(String) with 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ZipDataEntry.getOriginalName()"})
  void testGetOriginalName_givenZipEntryWithFoo_thenReturnFoo()
      throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ZipInputStream zipInputStream =
        new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"));

    ZipDataEntry zipDataEntry = new ZipDataEntry(parent, zipEntry, zipInputStream);

    // Act and Assert
    assertEquals("foo", zipDataEntry.getOriginalName());
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
  @DisplayName("Test getSize(); given ZipEntry(String) with 'foo'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ZipDataEntry.getSize()"})
  void testGetSize_givenZipEntryWithFoo_thenReturnMinusOne() throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ZipInputStream zipInputStream =
        new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"));

    ZipDataEntry zipDataEntry = new ZipDataEntry(parent, zipEntry, zipInputStream);

    // Act and Assert
    assertEquals(-1L, zipDataEntry.getSize());
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
  @DisplayName("Test isDirectory(); given ZipEntry(String) with 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZipDataEntry.isDirectory()"})
  void testIsDirectory_givenZipEntryWithFoo_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ZipInputStream zipInputStream =
        new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"));

    ZipDataEntry zipDataEntry = new ZipDataEntry(parent, zipEntry, zipInputStream);

    // Act and Assert
    assertFalse(zipDataEntry.isDirectory());
  }

  /**
   * Test {@link ZipDataEntry#getInputStream()}.
   *
   * <p>Method under test: {@link ZipDataEntry#getInputStream()}
   */
  @Test
  @DisplayName("Test getInputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream ZipDataEntry.getInputStream()"})
  void testGetInputStream() throws IOException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipEntry zipEntry = new ZipEntry("foo");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ZipInputStream zipInputStream =
        new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8"));

    ZipDataEntry zipDataEntry = new ZipDataEntry(parent, zipEntry, zipInputStream);

    // Act
    zipDataEntry.getInputStream();

    // Assert
    assertEquals(51, new byte[51].length);
  }
}

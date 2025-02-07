package proguard.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.util.StringFunction;

class JarWriterDiffblueTest {
  /**
   * Test {@link JarWriter#JarWriter(DataEntryWriter)}.
   *
   * <p>Method under test: {@link JarWriter#JarWriter(DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new JarWriter(DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.JarWriter.<init>(proguard.io.DataEntryWriter)"})
  void testNewJarWriter() {
    // Arrange and Act
    JarWriter actualJarWriter =
        new JarWriter(
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualJarWriter.manifestEntryWriter instanceof DirectoryWriter);
    assertTrue(actualJarWriter.zipEntryWriter instanceof DirectoryWriter);
    assertNull(actualJarWriter.creator);
    assertNull(actualJarWriter.currentManifestEntry);
    assertArrayEquals(
        new String[] {JarWriter.DEFAULT_DIGEST_ALGORITHM}, actualJarWriter.digestAlgorithms);
  }

  /**
   * Test {@link JarWriter#JarWriter(String[], String, String, StringFunction, DataEntryWriter,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link JarWriter#JarWriter(String[], String, String, StringFunction,
   * DataEntryWriter, DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new JarWriter(String[], String, String, StringFunction, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.JarWriter.<init>(java.lang.String[], java.lang.String, java.lang.String, proguard.util.StringFunction, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewJarWriter2() {
    // Arrange
    StringFunction manifestEntryNameFunction = mock(StringFunction.class);
    DirectoryWriter zipEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    JarWriter actualJarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            "Creator",
            "foo.txt",
            manifestEntryNameFunction,
            zipEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualJarWriter.manifestEntryWriter instanceof DirectoryWriter);
    assertTrue(actualJarWriter.zipEntryWriter instanceof DirectoryWriter);
    assertEquals("Creator", actualJarWriter.creator);
    assertNull(actualJarWriter.currentManifestEntry);
    assertArrayEquals(new String[] {"Digest Algorithms"}, actualJarWriter.digestAlgorithms);
  }

  /**
   * Test {@link JarWriter#JarWriter(String[], String, DataEntryWriter)}.
   *
   * <p>Method under test: {@link JarWriter#JarWriter(String[], String, DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new JarWriter(String[], String, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.JarWriter.<init>(java.lang.String[], java.lang.String, proguard.io.DataEntryWriter)"
  })
  void testNewJarWriter3() {
    // Arrange and Act
    JarWriter actualJarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            "Creator",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualJarWriter.manifestEntryWriter instanceof DirectoryWriter);
    assertTrue(actualJarWriter.zipEntryWriter instanceof DirectoryWriter);
    assertEquals("Creator", actualJarWriter.creator);
    assertNull(actualJarWriter.currentManifestEntry);
    assertArrayEquals(new String[] {"Digest Algorithms"}, actualJarWriter.digestAlgorithms);
  }

  /**
   * Test {@link JarWriter#JarWriter(String[], DataEntryWriter)}.
   *
   * <p>Method under test: {@link JarWriter#JarWriter(String[], DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new JarWriter(String[], DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.JarWriter.<init>(java.lang.String[], proguard.io.DataEntryWriter)"
  })
  void testNewJarWriter4() {
    // Arrange and Act
    JarWriter actualJarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualJarWriter.manifestEntryWriter instanceof DirectoryWriter);
    assertTrue(actualJarWriter.zipEntryWriter instanceof DirectoryWriter);
    assertNull(actualJarWriter.creator);
    assertNull(actualJarWriter.currentManifestEntry);
    assertArrayEquals(new String[] {"Digest Algorithms"}, actualJarWriter.digestAlgorithms);
  }

  /**
   * Test {@link JarWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException(String)} with
   *       {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JarWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given UnsupportedOperationException(String) with 'foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.JarWriter.createDirectory(proguard.io.DataEntry)"})
  void testCreateDirectory_givenUnsupportedOperationExceptionWithFoo_thenReturnFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    new UnsupportedOperationException("foo");
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(jarWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link JarWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JarWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.JarWriter.createDirectory(proguard.io.DataEntry)"})
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(jarWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.JarWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new JarWriter(
                new String[] {"Digest Algorithms"},
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.JarWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream2() throws IOException {
    // Arrange
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 =
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.JarWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream3() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.JarWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.JarWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link JarWriter#createOutputStream(DataEntry)}.
   *
   * <p>Method under test: {@link JarWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName("Test createOutputStream(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.JarWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    new UnsupportedOperationException("foo");
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry = new ClassPathDataEntry("Name");

    // Act
    OutputStream actualCreateOutputStreamResult = jarWriter.createOutputStream(dataEntry);

    // Assert
    DataEntry dataEntry2 = jarWriter.currentManifestEntry;
    assertTrue(dataEntry2 instanceof RenamedDataEntry);
    assertEquals("META-INF/MANIFEST.MF", dataEntry2.getName());
    assertEquals("Name", dataEntry2.getOriginalName());
    assertNull(dataEntry2.getInputStream());
    assertNull(actualCreateOutputStreamResult);
    assertNull(dataEntry2.getParent());
    assertEquals(-1L, dataEntry2.getSize());
    assertFalse(dataEntry2.isDirectory());
    assertSame(dataEntry, ((RenamedDataEntry) dataEntry2).wrappedEntry);
  }

  /**
   * Test {@link JarWriter#openManifestFiles()}.
   *
   * <ul>
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link JarWriter#openManifestFiles()}
   */
  @Test
  @DisplayName("Test openManifestFiles(); then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.JarWriter.openManifestFiles()"})
  void testOpenManifestFiles_thenCallsAccepts() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);

    // Act
    (new JarWriter(
            new String[] {"Digest Algorithms"}, new FilteredDataEntryWriter(dataEntryFilter, null)))
        .openManifestFiles();

    // Assert
    verify(dataEntryFilter).accepts(isNull());
  }

  /**
   * Test {@link JarWriter#createManifestOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JarWriter#createManifestOutputStream(DataEntry)}
   */
  @Test
  @DisplayName("Test createManifestOutputStream(DataEntry); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.JarWriter.createManifestOutputStream(proguard.io.DataEntry)"
  })
  void testCreateManifestOutputStream_thenReturnNull() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertNull(jarWriter.createManifestOutputStream(new ClassPathDataEntry("Name")));
  }
}

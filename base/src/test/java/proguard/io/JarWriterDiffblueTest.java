package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.util.StringFunction;

public class JarWriterDiffblueTest {
  /**
   * Method under test: {@link JarWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(jarWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"}, new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(jarWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory3() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new NameFilteredDataEntryWriter("Regular Expression",
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(jarWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new JarWriter(new String[]{"Digest Algorithms"},
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream3() throws IOException {
    // Arrange
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream4() throws IOException {
    // Arrange
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 = new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream5() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new NameFilteredDataEntryWriter("Regular Expression",
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(jarWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#createOutputStream(DataEntry)}
   */
  @Test
  public void testCreateOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"}, new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
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
   * Method under test: {@link JarWriter#createManifestOutputStream(DataEntry)}
   */
  @Test
  public void testCreateManifestOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    JarWriter jarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new NameFilteredDataEntryWriter("Regular Expression",
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertNull(jarWriter.createManifestOutputStream(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link JarWriter#JarWriter(DataEntryWriter)}
   */
  @Test
  public void testNewJarWriter() {
    // Arrange and Act
    JarWriter actualJarWriter = new JarWriter(
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualJarWriter.manifestEntryWriter instanceof DirectoryWriter);
    assertTrue(actualJarWriter.zipEntryWriter instanceof DirectoryWriter);
    assertNull(actualJarWriter.creator);
    assertNull(actualJarWriter.currentManifestEntry);
    assertArrayEquals(new String[]{JarWriter.DEFAULT_DIGEST_ALGORITHM}, actualJarWriter.digestAlgorithms);
  }

  /**
   * Method under test:
   * {@link JarWriter#JarWriter(String[], String, String, StringFunction, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewJarWriter2() {
    // Arrange
    DirectoryWriter zipEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    JarWriter actualJarWriter = new JarWriter(new String[]{"Digest Algorithms"}, "Creator", "foo.txt",
        StringFunction.IDENTITY_FUNCTION, zipEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualJarWriter.manifestEntryWriter instanceof DirectoryWriter);
    assertTrue(actualJarWriter.zipEntryWriter instanceof DirectoryWriter);
    assertEquals("Creator", actualJarWriter.creator);
    assertNull(actualJarWriter.currentManifestEntry);
    assertArrayEquals(new String[]{"Digest Algorithms"}, actualJarWriter.digestAlgorithms);
  }

  /**
   * Method under test:
   * {@link JarWriter#JarWriter(String[], String, DataEntryWriter)}
   */
  @Test
  public void testNewJarWriter3() {
    // Arrange and Act
    JarWriter actualJarWriter = new JarWriter(new String[]{"Digest Algorithms"}, "Creator",
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualJarWriter.manifestEntryWriter instanceof DirectoryWriter);
    assertTrue(actualJarWriter.zipEntryWriter instanceof DirectoryWriter);
    assertEquals("Creator", actualJarWriter.creator);
    assertNull(actualJarWriter.currentManifestEntry);
    assertArrayEquals(new String[]{"Digest Algorithms"}, actualJarWriter.digestAlgorithms);
  }

  /**
   * Method under test: {@link JarWriter#JarWriter(String[], DataEntryWriter)}
   */
  @Test
  public void testNewJarWriter4() {
    // Arrange and Act
    JarWriter actualJarWriter = new JarWriter(new String[]{"Digest Algorithms"},
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualJarWriter.manifestEntryWriter instanceof DirectoryWriter);
    assertTrue(actualJarWriter.zipEntryWriter instanceof DirectoryWriter);
    assertNull(actualJarWriter.creator);
    assertNull(actualJarWriter.currentManifestEntry);
    assertArrayEquals(new String[]{"Digest Algorithms"}, actualJarWriter.digestAlgorithms);
  }
}

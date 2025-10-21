package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.util.StringFunction;

public class JarWriterDiffblueTest {
  /**
   * Test {@link JarWriter#JarWriter(DataEntryWriter)}.
   *
   * <p>Method under test: {@link JarWriter#JarWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JarWriter.<init>(DataEntryWriter)"})
  public void testNewJarWriter() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JarWriter.<init>(String[], String, String, StringFunction, DataEntryWriter, DataEntryWriter)"
  })
  public void testNewJarWriter2() {
    // Arrange
    DirectoryWriter zipEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    JarWriter actualJarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            "Creator",
            "foo.txt",
            StringFunction.IDENTITY_FUNCTION,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JarWriter.<init>(String[], String, DataEntryWriter)"})
  public void testNewJarWriter3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JarWriter.<init>(String[], DataEntryWriter)"})
  public void testNewJarWriter4() {
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
   * <p>Method under test: {@link JarWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JarWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new FilteredDataEntryWriter(
                dataEntryFilter,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(jarWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link JarWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link JarWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JarWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory2() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JarWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_thenReturnTrue() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JarWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JarWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream2() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JarWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream3() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JarWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_thenReturnTrue() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JarWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputStream JarWriter.createOutputStream(DataEntry)"})
  public void testCreateOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    JarWriter jarWriter =
        new JarWriter(
            new String[] {"Digest Algorithms"},
            new FilteredDataEntryWriter(
                dataEntryFilter,
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
   * Test {@link JarWriter#createManifestOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JarWriter#createManifestOutputStream(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputStream JarWriter.createManifestOutputStream(DataEntry)"})
  public void testCreateManifestOutputStream_thenReturnNull() throws IOException {
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

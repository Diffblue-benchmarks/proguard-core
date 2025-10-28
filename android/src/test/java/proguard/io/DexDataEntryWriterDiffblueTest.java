package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.util.EmptyStringMatcher;

public class DexDataEntryWriterDiffblueTest {
  /**
   * Method under test: {@link DexDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    FixedFileWriter dexDataEntryWriter = new FixedFileWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    D8BasedDexDataEntryWriter d8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(d8BasedDexDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link DexDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    ClassPool classPool2 = new ClassPool();
    EmptyStringMatcher classNameFilter2 = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor2 = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    FilteredDataEntryWriter dexDataEntryWriter2 = new FilteredDataEntryWriter(dataEntryFilter,
        new D8BasedDexDataEntryWriter(classPool2, classNameFilter2, libraryJars2, "foo.txt", true, 1, true,
            extraDexDataEntryVisitor2, dexDataEntryWriter,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    D8BasedDexDataEntryWriter d8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter2,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertFalse(d8BasedDexDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    D8BasedDexDataEntryWriter d8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(d8BasedDexDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    ClassPool classPool2 = new ClassPool();
    EmptyStringMatcher classNameFilter2 = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor2 = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    D8BasedDexDataEntryWriter dataEntryWriter1 = new D8BasedDexDataEntryWriter(classPool2, classNameFilter2,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor2, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    ClassPool classPool3 = new ClassPool();
    EmptyStringMatcher classNameFilter3 = new EmptyStringMatcher();
    ClassPath libraryJars3 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor3 = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter2 = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    CascadingDataEntryWriter dexDataEntryWriter3 = new CascadingDataEntryWriter(dataEntryWriter1,
        new D8BasedDexDataEntryWriter(classPool3, classNameFilter3, libraryJars3, "foo.txt", true, 1, true,
            extraDexDataEntryVisitor3, dexDataEntryWriter2,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    D8BasedDexDataEntryWriter d8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter3,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(d8BasedDexDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream3() throws IOException {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    D8BasedDexDataEntryWriter d8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("42");

    // Act and Assert
    assertFalse(d8BasedDexDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}

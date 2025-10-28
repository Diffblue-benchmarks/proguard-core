package proguard.io;

import static org.junit.Assert.assertTrue;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.util.EmptyStringMatcher;

public class DexDataEntryWriterFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, libraryJars,
        true, 1, 1, true,
        new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter2() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    programClassPool.addClass("base/dex/", new LibraryClass());
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, libraryJars,
        true, 1, 1, true,
        new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter3() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "base/dex/").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, libraryJars,
        true, 1, 1, true,
        new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter4() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, libraryJars,
        true, 1, 1, true,
        new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter5() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, libraryJars,
        true, 1, 1, true,
        new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter6() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, libraryJars,
        true, 1, 1, true,
        new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter7() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, libraryJars,
        true, 1, 1, true,
        new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter8() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, null, true, 1,
        1, true, new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }

  /**
   * Method under test:
   * {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  public void testWrapInDexWriter9() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory = new DexDataEntryWriterFactory(programClassPool, libraryJars,
        false, 1, 1, true,
        new DexClassReader(true, new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(dexDataEntryWriterFactory.wrapInDexWriter(new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars2, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter, new DirectoryWriter(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))) instanceof FilteredDataEntryWriter);
  }
}

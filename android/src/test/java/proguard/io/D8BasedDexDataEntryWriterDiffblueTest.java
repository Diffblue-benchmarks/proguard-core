package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.visitor.ClassVisitor;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

public class D8BasedDexDataEntryWriterDiffblueTest {
  /**
   * Method under test: {@link D8BasedDexDataEntryWriter#createClassConverter()}
   */
  @Test
  public void testCreateClassConverter() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    ClassVisitor actualCreateClassConverterResult = (new D8BasedDexDataEntryWriter(classPool, classNameFilter,
        libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            .createClassConverter();
    actualCreateClassConverterResult.visitAnyClass(new LibraryClass());

    // Assert that nothing has changed
    assertTrue(actualCreateClassConverterResult instanceof D8ClassConverter);
  }

  /**
   * Method under test:
   * {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewD8BasedDexDataEntryWriter() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool,
        classNameFilter, libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Method under test:
   * {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewD8BasedDexDataEntryWriter2() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool,
        classNameFilter, libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Method under test:
   * {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewD8BasedDexDataEntryWriter3() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".ap_").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool,
        classNameFilter, libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Method under test:
   * {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewD8BasedDexDataEntryWriter4() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool,
        classNameFilter, libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Method under test:
   * {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewD8BasedDexDataEntryWriter5() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool,
        classNameFilter, libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Method under test:
   * {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewD8BasedDexDataEntryWriter6() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool,
        classNameFilter, libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Method under test:
   * {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewD8BasedDexDataEntryWriter7() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars = new ClassPath(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile(), true));
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool,
        classNameFilter, libraryJars, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Method under test:
   * {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}
   */
  @Test
  public void testNewD8BasedDexDataEntryWriter8() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    DexClassReader extraDexDataEntryVisitor = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    DirectoryWriter dexDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter = new D8BasedDexDataEntryWriter(classPool,
        classNameFilter, null, "foo.txt", true, 1, true, extraDexDataEntryVisitor, dexDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }
}

package proguard.io;

import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.io.D8ClassConverter.D8DexFile;
import proguard.util.EmptyStringMatcher;

public class DexDataEntryWriterFactoryDiffblueTest {
  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            libraryJars,
            true,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars2,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }

  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter2() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "base/dex/").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            libraryJars,
            true,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars2,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }

  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter3() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            libraryJars,
            true,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars2,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }

  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter4() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            libraryJars,
            true,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars2,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }

  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter5() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            libraryJars,
            true,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars2,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }

  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter6() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            libraryJars,
            true,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars2,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }

  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter7() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            null,
            true,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }

  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter8() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            libraryJars,
            false,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars2,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }

  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <ul>
   *   <li>Given {@link ClassPool#ClassPool()} addClass {@code base/dex/} and {@link
   *       LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntryWriter DexDataEntryWriterFactory.wrapInDexWriter(DataEntryWriter)"})
  public void testWrapInDexWriterWithDexWriter_givenClassPoolAddClassBaseDexAndLibraryClass() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    programClassPool.addClass("base/dex/", new LibraryClass());
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            libraryJars,
            true,
            1,
            1,
            true,
            new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true))));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DexClassReader extraDexDataEntryVisitor =
        new DexClassReader(true, new D8ClassConverter(new D8DexFile(null, 1, true)));

    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(
        dexDataEntryWriterFactory.wrapInDexWriter(
                new D8BasedDexDataEntryWriter(
                    classPool,
                    classNameFilter,
                    libraryJars2,
                    "foo.txt",
                    true,
                    1,
                    true,
                    extraDexDataEntryVisitor,
                    dexDataEntryWriter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            instanceof FilteredDataEntryWriter);
  }
}

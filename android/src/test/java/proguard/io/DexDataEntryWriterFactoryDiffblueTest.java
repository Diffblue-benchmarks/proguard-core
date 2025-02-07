package proguard.io;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.util.EmptyStringMatcher;

class DexDataEntryWriterFactoryDiffblueTest {
  /**
   * Test {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)} with {@code dexWriter}.
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @DisplayName("Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            true,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
  @DisplayName("Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter2() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "base/dex/").toFile(), true)),
            true,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
  @DisplayName("Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter3() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true)),
            true,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
  @DisplayName("Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter4() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true)),
            true,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
  @DisplayName("Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter5() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true)),
            true,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
  @DisplayName("Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter6() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true)),
            true,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
  @DisplayName("Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter7() {
    // Arrange
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            new ClassPool(), null, true, 1, 1, true, mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
  @DisplayName("Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter8() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            false,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
   * <ul>
   *   <li>Given {@link ClassPool#ClassPool()} addClass {@code base/dex/} and {@link
   *       LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'; given ClassPool() addClass 'base/dex/' and LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter_givenClassPoolAddClassBaseDexAndLibraryClass() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    programClassPool.addClass("base/dex/", new LibraryClass());
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            true,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
   * <ul>
   *   <li>Then return {@link NameFilteredDataEntryWriter}.
   * </ul>
   *
   * <p>Method under test: {@link DexDataEntryWriterFactory#wrapInDexWriter(DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test wrapInDexWriter(DataEntryWriter) with 'dexWriter'; then return NameFilteredDataEntryWriter")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DexDataEntryWriterFactory.wrapInDexWriter(proguard.io.DataEntryWriter)"
  })
  void testWrapInDexWriterWithDexWriter_thenReturnNameFilteredDataEntryWriter() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    clazz.addExtraFeatureName("base/dex/");

    ClassPool programClassPool = new ClassPool();
    programClassPool.addClass("base/dex/", clazz);
    DexDataEntryWriterFactory dexDataEntryWriterFactory =
        new DexDataEntryWriterFactory(
            programClassPool,
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            true,
            1,
            1,
            true,
            mock(DataEntryReader.class));
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
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
            instanceof NameFilteredDataEntryWriter);
  }
}

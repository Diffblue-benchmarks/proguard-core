package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.visitor.ClassVisitor;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

class D8BasedDexDataEntryWriterDiffblueTest {
  /**
   * Test {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher,
   * ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool,
   * StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8BasedDexDataEntryWriter.<init>(proguard.classfile.ClassPool, proguard.util.StringMatcher, proguard.io.ClassPath, java.lang.String, boolean, int, boolean, proguard.io.DataEntryReader, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewD8BasedDexDataEntryWriter() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter =
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
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Test {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher,
   * ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool,
   * StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8BasedDexDataEntryWriter.<init>(proguard.classfile.ClassPool, proguard.util.StringMatcher, proguard.io.ClassPath, java.lang.String, boolean, int, boolean, proguard.io.DataEntryReader, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewD8BasedDexDataEntryWriter2() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    ClassPool classPool2 = new ClassPool();
    EmptyStringMatcher classNameFilter2 = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor2 = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    D8BasedDexDataEntryWriter dexDataEntryWriter2 =
        new D8BasedDexDataEntryWriter(
            classPool2,
            classNameFilter2,
            libraryJars,
            "foo.txt",
            true,
            1,
            true,
            extraDexDataEntryVisitor2,
            dexDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    ClassPool classPool3 = new ClassPool();
    EmptyStringMatcher classNameFilter3 = new EmptyStringMatcher();
    ClassPath libraryJars2 =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor3 = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter3 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    D8BasedDexDataEntryWriter otherDataEntryWriter =
        new D8BasedDexDataEntryWriter(
            classPool3,
            classNameFilter3,
            libraryJars2,
            "foo.txt",
            true,
            1,
            true,
            extraDexDataEntryVisitor3,
            dexDataEntryWriter3,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter =
        new D8BasedDexDataEntryWriter(
            classPool,
            classNameFilter,
            null,
            "foo.txt",
            true,
            1,
            true,
            extraDexDataEntryVisitor,
            dexDataEntryWriter2,
            otherDataEntryWriter);

    // Assert
    DataEntryWriter dataEntryWriter = actualD8BasedDexDataEntryWriter.dexDataEntryWriter;
    assertTrue(dataEntryWriter instanceof D8BasedDexDataEntryWriter);
    DataEntryWriter dataEntryWriter2 = actualD8BasedDexDataEntryWriter.otherDataEntryWriter;
    assertTrue(dataEntryWriter2 instanceof D8BasedDexDataEntryWriter);
    DataEntryWriter dataEntryWriter3 =
        ((D8BasedDexDataEntryWriter) dataEntryWriter).dexDataEntryWriter;
    assertTrue(dataEntryWriter3 instanceof DirectoryWriter);
    DataEntryWriter dataEntryWriter4 =
        ((D8BasedDexDataEntryWriter) dataEntryWriter2).dexDataEntryWriter;
    assertTrue(dataEntryWriter4 instanceof DirectoryWriter);
    DataEntryWriter dataEntryWriter5 =
        ((D8BasedDexDataEntryWriter) dataEntryWriter).otherDataEntryWriter;
    assertTrue(dataEntryWriter5 instanceof DirectoryWriter);
    DataEntryWriter dataEntryWriter6 =
        ((D8BasedDexDataEntryWriter) dataEntryWriter2).otherDataEntryWriter;
    assertTrue(dataEntryWriter6 instanceof DirectoryWriter);
    assertEquals("foo.txt", ((D8BasedDexDataEntryWriter) dataEntryWriter).dexFileName);
    assertEquals("foo.txt", ((D8BasedDexDataEntryWriter) dataEntryWriter2).dexFileName);
    assertSame(dexDataEntryWriter2.dexDataEntryWriter, dataEntryWriter3);
    assertSame(otherDataEntryWriter.dexDataEntryWriter, dataEntryWriter4);
    assertSame(dexDataEntryWriter2.otherDataEntryWriter, dataEntryWriter5);
    assertSame(otherDataEntryWriter.otherDataEntryWriter, dataEntryWriter6);
  }

  /**
   * Test {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher,
   * ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool,
   * StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8BasedDexDataEntryWriter.<init>(proguard.classfile.ClassPool, proguard.util.StringMatcher, proguard.io.ClassPath, java.lang.String, boolean, int, boolean, proguard.io.DataEntryReader, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewD8BasedDexDataEntryWriter3() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter =
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
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Test {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher,
   * ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool,
   * StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8BasedDexDataEntryWriter.<init>(proguard.classfile.ClassPool, proguard.util.StringMatcher, proguard.io.ClassPath, java.lang.String, boolean, int, boolean, proguard.io.DataEntryReader, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewD8BasedDexDataEntryWriter4() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter =
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
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Test {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher,
   * ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool,
   * StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8BasedDexDataEntryWriter.<init>(proguard.classfile.ClassPool, proguard.util.StringMatcher, proguard.io.ClassPath, java.lang.String, boolean, int, boolean, proguard.io.DataEntryReader, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewD8BasedDexDataEntryWriter5() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".ap_").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter =
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
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Test {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher,
   * ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool,
   * StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8BasedDexDataEntryWriter.<init>(proguard.classfile.ClassPool, proguard.util.StringMatcher, proguard.io.ClassPath, java.lang.String, boolean, int, boolean, proguard.io.DataEntryReader, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewD8BasedDexDataEntryWriter6() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter =
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
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Test {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher,
   * ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool,
   * StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8BasedDexDataEntryWriter.<init>(proguard.classfile.ClassPool, proguard.util.StringMatcher, proguard.io.ClassPath, java.lang.String, boolean, int, boolean, proguard.io.DataEntryReader, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewD8BasedDexDataEntryWriter7() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter =
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
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Test {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool, StringMatcher,
   * ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#D8BasedDexDataEntryWriter(ClassPool,
   * StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new D8BasedDexDataEntryWriter(ClassPool, StringMatcher, ClassPath, String, boolean, int, boolean, DataEntryReader, DataEntryWriter, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8BasedDexDataEntryWriter.<init>(proguard.classfile.ClassPool, proguard.util.StringMatcher, proguard.io.ClassPath, java.lang.String, boolean, int, boolean, proguard.io.DataEntryReader, proguard.io.DataEntryWriter, proguard.io.DataEntryWriter)"
  })
  void testNewD8BasedDexDataEntryWriter8() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    D8BasedDexDataEntryWriter actualD8BasedDexDataEntryWriter =
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
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualD8BasedDexDataEntryWriter.dexDataEntryWriter instanceof DirectoryWriter);
    assertTrue(actualD8BasedDexDataEntryWriter.otherDataEntryWriter instanceof DirectoryWriter);
    assertEquals("foo.txt", actualD8BasedDexDataEntryWriter.dexFileName);
  }

  /**
   * Test {@link D8BasedDexDataEntryWriter#createClassConverter()}.
   *
   * <p>Method under test: {@link D8BasedDexDataEntryWriter#createClassConverter()}
   */
  @Test
  @DisplayName("Test createClassConverter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.visitor.ClassVisitor proguard.io.D8BasedDexDataEntryWriter.createClassConverter()"
  })
  void testCreateClassConverter() {
    // Arrange
    ClassPool classPool = new ClassPool();
    EmptyStringMatcher classNameFilter = new EmptyStringMatcher();
    ClassPath libraryJars =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    DataEntryReader extraDexDataEntryVisitor = mock(DataEntryReader.class);
    DirectoryWriter dexDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    ClassVisitor actualCreateClassConverterResult =
        (new D8BasedDexDataEntryWriter(
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
            .createClassConverter();
    actualCreateClassConverterResult.visitAnyClass(new LibraryClass());

    // Assert
    assertTrue(actualCreateClassConverterResult instanceof D8ClassConverter);
  }
}

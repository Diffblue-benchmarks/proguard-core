package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;
import proguard.io.D8ClassConverter.D8DexFile;

class D8ClassConverterDiffblueTest {
  /**
   * Test D8DexFile {@link D8DexFile#isArchive(ClassPathEntry)}.
   *
   * <p>Method under test: {@link D8DexFile#isArchive(ClassPathEntry)}
   */
  @Test
  @DisplayName("Test D8DexFile isArchive(ClassPathEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.D8ClassConverter$D8DexFile.isArchive(proguard.io.ClassPathEntry)"
  })
  void testD8DexFileIsArchive() {
    // Arrange, Act and Assert
    assertTrue(
        D8DexFile.isArchive(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#isArchive(ClassPathEntry)}.
   *
   * <p>Method under test: {@link D8DexFile#isArchive(ClassPathEntry)}
   */
  @Test
  @DisplayName("Test D8DexFile isArchive(ClassPathEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.D8ClassConverter$D8DexFile.isArchive(proguard.io.ClassPathEntry)"
  })
  void testD8DexFileIsArchive2() {
    // Arrange, Act and Assert
    assertTrue(
        D8DexFile.isArchive(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#isArchive(ClassPathEntry)}.
   *
   * <p>Method under test: {@link D8DexFile#isArchive(ClassPathEntry)}
   */
  @Test
  @DisplayName("Test D8DexFile isArchive(ClassPathEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.D8ClassConverter$D8DexFile.isArchive(proguard.io.ClassPathEntry)"
  })
  void testD8DexFileIsArchive3() {
    // Arrange, Act and Assert
    assertTrue(
        D8DexFile.isArchive(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#isArchive(ClassPathEntry)}.
   *
   * <p>Method under test: {@link D8DexFile#isArchive(ClassPathEntry)}
   */
  @Test
  @DisplayName("Test D8DexFile isArchive(ClassPathEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.D8ClassConverter$D8DexFile.isArchive(proguard.io.ClassPathEntry)"
  })
  void testD8DexFileIsArchive4() {
    // Arrange, Act and Assert
    assertTrue(
        D8DexFile.isArchive(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#isArchive(ClassPathEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link D8DexFile#isArchive(ClassPathEntry)}
   */
  @Test
  @DisplayName("Test D8DexFile isArchive(ClassPathEntry); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.D8ClassConverter$D8DexFile.isArchive(proguard.io.ClassPathEntry)"
  })
  void testD8DexFileIsArchive_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        D8DexFile.isArchive(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#D8DexFile(ClassPath, int, boolean)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link ClassPathEntry#getFile()}.
   * </ul>
   *
   * <p>Method under test: {@link D8DexFile#D8DexFile(ClassPath, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test D8DexFile new D8DexFile(ClassPath, int, boolean); given 'true'; then calls getFile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8ClassConverter$D8DexFile.<init>(proguard.io.ClassPath, int, boolean)"
  })
  void testD8DexFileNewD8DexFile_givenTrue_thenCallsGetFile() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassPathEntry classPathEntry = mock(ClassPathEntry.class);
    when(classPathEntry.isDex()).thenReturn(true);
    when(classPathEntry.getFile())
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    new D8DexFile(new ClassPath(classPathEntry), 1, true);

    // Assert
    verify(classPathEntry, atLeast(1)).getFile();
    verify(classPathEntry).isDex();
  }

  /**
   * Test D8DexFile {@link D8DexFile#D8DexFile(ClassPath, int, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassPath#get(int)}.
   * </ul>
   *
   * <p>Method under test: {@link D8DexFile#D8DexFile(ClassPath, int, boolean)}
   */
  @Test
  @DisplayName("Test D8DexFile new D8DexFile(ClassPath, int, boolean); then calls get(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8ClassConverter$D8DexFile.<init>(proguard.io.ClassPath, int, boolean)"
  })
  void testD8DexFileNewD8DexFile_thenCallsGet() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassPath libraryJars = mock(ClassPath.class);
    when(libraryJars.get(anyInt()))
        .thenReturn(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    when(libraryJars.size()).thenReturn(3);

    // Act
    new D8DexFile(libraryJars, 1, true);

    // Assert
    verify(libraryJars, atLeast(1)).get(anyInt());
    verify(libraryJars, atLeast(1)).size();
  }

  /**
   * Test D8DexFile {@link D8DexFile#writeTo(OutputStream)}.
   *
   * <p>Method under test: {@link D8DexFile#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test D8DexFile writeTo(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.D8ClassConverter$D8DexFile.writeTo(java.io.OutputStream)"})
  void testD8DexFileWriteTo() throws IOException {
    // Arrange
    D8DexFile d8DexFile =
        new D8DexFile(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1,
            true);
    d8DexFile.addProgramClassData(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(IOException.class, () -> d8DexFile.writeTo(new ByteArrayOutputStream(1)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#writeTo(OutputStream)}.
   *
   * <p>Method under test: {@link D8DexFile#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test D8DexFile writeTo(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.D8ClassConverter$D8DexFile.writeTo(java.io.OutputStream)"})
  void testD8DexFileWriteTo2() throws IOException {
    // Arrange
    D8DexFile d8DexFile =
        new D8DexFile(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1,
            true);
    d8DexFile.addProgramClassData(new byte[] {'X', 1, 'A', 1, 'A', 1, 'A', 1});
    d8DexFile.addProgramClassData(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(IOException.class, () -> d8DexFile.writeTo(new ByteArrayOutputStream(1)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#writeTo(OutputStream)}.
   *
   * <p>Method under test: {@link D8DexFile#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test D8DexFile writeTo(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.D8ClassConverter$D8DexFile.writeTo(java.io.OutputStream)"})
  void testD8DexFileWriteTo3() throws IOException {
    // Arrange
    D8DexFile d8DexFile =
        new D8DexFile(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            0,
            true);
    d8DexFile.addProgramClassData(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(IOException.class, () -> d8DexFile.writeTo(new ByteArrayOutputStream(1)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#writeTo(OutputStream)}.
   *
   * <p>Method under test: {@link D8DexFile#writeTo(OutputStream)}
   */
  @Test
  @DisplayName("Test D8DexFile writeTo(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.D8ClassConverter$D8DexFile.writeTo(java.io.OutputStream)"})
  void testD8DexFileWriteTo4() throws IOException {
    // Arrange
    D8DexFile d8DexFile =
        new D8DexFile(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1,
            false);
    d8DexFile.addProgramClassData(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(IOException.class, () -> d8DexFile.writeTo(new ByteArrayOutputStream(1)));
  }

  /**
   * Test {@link D8ClassConverter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then calls {@link ClassPathEntry#getFile()}.
   * </ul>
   *
   * <p>Method under test: {@link D8ClassConverter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); when ProgramClass(); then calls getFile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.D8ClassConverter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_whenProgramClass_thenCallsGetFile() {
    // Arrange
    ClassPathEntry classPathEntry = mock(ClassPathEntry.class);
    when(classPathEntry.isDex()).thenReturn(true);
    when(classPathEntry.getFile())
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    D8ClassConverter d8ClassConverter =
        new D8ClassConverter(new D8DexFile(new ClassPath(classPathEntry), 1, true));

    // Act
    d8ClassConverter.visitProgramClass(new ProgramClass());

    // Assert
    verify(classPathEntry, atLeast(1)).getFile();
    verify(classPathEntry).isDex();
  }
}

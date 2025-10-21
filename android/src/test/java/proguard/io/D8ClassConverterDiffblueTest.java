package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.io.D8ClassConverter.D8DexFile;

public class D8ClassConverterDiffblueTest {
  /**
   * Test D8DexFile {@link D8DexFile#isArchive(ClassPathEntry)}.
   *
   * <p>Method under test: {@link D8DexFile#isArchive(ClassPathEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean D8DexFile.isArchive(ClassPathEntry)"})
  public void testD8DexFileIsArchive() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean D8DexFile.isArchive(ClassPathEntry)"})
  public void testD8DexFileIsArchive2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean D8DexFile.isArchive(ClassPathEntry)"})
  public void testD8DexFileIsArchive3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean D8DexFile.isArchive(ClassPathEntry)"})
  public void testD8DexFileIsArchive4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean D8DexFile.isArchive(ClassPathEntry)"})
  public void testD8DexFileIsArchive_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        D8DexFile.isArchive(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)));
  }

  /**
   * Test D8DexFile {@link D8DexFile#writeTo(OutputStream)}.
   *
   * <p>Method under test: {@link D8DexFile#writeTo(OutputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void D8DexFile.writeTo(OutputStream)"})
  public void testD8DexFileWriteTo() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void D8DexFile.writeTo(OutputStream)"})
  public void testD8DexFileWriteTo2() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void D8DexFile.writeTo(OutputStream)"})
  public void testD8DexFileWriteTo3() throws IOException {
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
}

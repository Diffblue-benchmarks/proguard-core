package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.Test;

public class D8ClassConverterDiffblueTest {
  /**
   * Method under test:
   * {@link D8ClassConverter.D8DexFile#isArchive(ClassPathEntry)}
   */
  @Test
  public void testD8DexFileIsArchive() {
    // Arrange, Act and Assert
    assertFalse(D8ClassConverter.D8DexFile
        .isArchive(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)));
    assertTrue(D8ClassConverter.D8DexFile
        .isArchive(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true)));
    assertTrue(D8ClassConverter.D8DexFile
        .isArchive(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true)));
    assertTrue(D8ClassConverter.D8DexFile
        .isArchive(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true)));
    assertTrue(D8ClassConverter.D8DexFile
        .isArchive(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".zip").toFile(), true)));
  }

  /**
   * Method under test: {@link D8ClassConverter.D8DexFile#writeTo(OutputStream)}
   */
  @Test
  public void testD8DexFileWriteTo() throws IOException {
    // Arrange
    D8ClassConverter.D8DexFile d8DexFile = new D8ClassConverter.D8DexFile(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
        1, true);
    d8DexFile.addProgramClassData(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(IOException.class, () -> d8DexFile.writeTo(new ByteArrayOutputStream(1)));
  }

  /**
   * Method under test: {@link D8ClassConverter.D8DexFile#writeTo(OutputStream)}
   */
  @Test
  public void testD8DexFileWriteTo2() throws IOException {
    // Arrange
    D8ClassConverter.D8DexFile d8DexFile = new D8ClassConverter.D8DexFile(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
        0, true);
    d8DexFile.addProgramClassData(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(IOException.class, () -> d8DexFile.writeTo(new ByteArrayOutputStream(1)));
  }

  /**
   * Method under test: {@link D8ClassConverter.D8DexFile#writeTo(OutputStream)}
   */
  @Test
  public void testD8DexFileWriteTo3() throws IOException {
    // Arrange
    D8ClassConverter.D8DexFile d8DexFile = new D8ClassConverter.D8DexFile(
        new ClassPath(new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
        1, false);
    d8DexFile.addProgramClassData(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(IOException.class, () -> d8DexFile.writeTo(new ByteArrayOutputStream(1)));
  }
}

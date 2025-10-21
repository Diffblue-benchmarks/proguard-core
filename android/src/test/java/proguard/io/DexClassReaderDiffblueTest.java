package proguard.io;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.io.D8ClassConverter.D8DexFile;

public class DexClassReaderDiffblueTest {
  /**
   * Test {@link DexClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DexClassReader#DexClassReader(boolean, ClassVisitor)} with readCode is
   *       {@code false} and classVisitor is {@link D8ClassConverter#D8ClassConverter(D8DexFile)}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassReader.read(DataEntry)"})
  public void testRead_givenDexClassReaderWithReadCodeIsFalseAndClassVisitorIsD8ClassConverter()
      throws IOException {
    // Arrange
    DexClassReader dexClassReader =
        new DexClassReader(
            false,
            new D8ClassConverter(
                new D8DexFile(
                    new ClassPath(
                        new ClassPathEntry(
                            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                            true)),
                    1,
                    true)));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> dexClassReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Test {@link DexClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassReader.read(DataEntry)"})
  public void testRead_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenThrowIOException()
      throws IOException {
    // Arrange
    DexClassReader dexClassReader =
        new DexClassReader(
            true,
            new D8ClassConverter(
                new D8DexFile(
                    new ClassPath(
                        new ClassPathEntry(
                            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                            true)),
                    1,
                    true)));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            dexClassReader.read(
                new StreamingDataEntry(
                    "Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link DexClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassReader.read(DataEntry)"})
  public void testRead_whenJavaLangObject_thenThrowIOException() throws IOException {
    // Arrange
    DexClassReader dexClassReader =
        new DexClassReader(
            true,
            new D8ClassConverter(
                new D8DexFile(
                    new ClassPath(
                        new ClassPathEntry(
                            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                            true)),
                    1,
                    true)));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> dexClassReader.read(new ClassPathDataEntry(clazz)));
  }
}

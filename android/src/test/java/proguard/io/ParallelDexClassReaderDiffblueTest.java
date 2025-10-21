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

public class ParallelDexClassReaderDiffblueTest {
  /**
   * Test {@link ParallelDexClassReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link ParallelDexClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ParallelDexClassReader.read(DataEntry)"})
  public void testRead() throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader =
        new ParallelDexClassReader(
            false,
            true,
            new D8ClassConverter(
                new D8DexFile(
                    new ClassPath(
                        new ClassPathEntry(
                            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                            true)),
                    1,
                    true)),
            3);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IOException.class, () -> parallelDexClassReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Test {@link ParallelDexClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ParallelDexClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ParallelDexClassReader.read(DataEntry)"})
  public void testRead_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenThrowIOException()
      throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader =
        new ParallelDexClassReader(
            true,
            true,
            new D8ClassConverter(
                new D8DexFile(
                    new ClassPath(
                        new ClassPathEntry(
                            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                            true)),
                    1,
                    true)),
            3);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            parallelDexClassReader.read(
                new StreamingDataEntry(
                    "Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ParallelDexClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ParallelDexClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ParallelDexClassReader.read(DataEntry)"})
  public void testRead_whenJavaLangObject_thenThrowIOException() throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader =
        new ParallelDexClassReader(
            true,
            true,
            new D8ClassConverter(
                new D8DexFile(
                    new ClassPath(
                        new ClassPathEntry(
                            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                            true)),
                    1,
                    true)),
            3);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IOException.class, () -> parallelDexClassReader.read(new ClassPathDataEntry(clazz)));
  }
}

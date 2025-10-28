package proguard.io;

import static org.junit.Assert.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class ParallelDexClassReaderDiffblueTest {
  /**
   * Method under test: {@link ParallelDexClassReader#read(DataEntry)}
   */
  @Test
  public void testRead() throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader = new ParallelDexClassReader(true, true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)),
        3);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> parallelDexClassReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Method under test: {@link ParallelDexClassReader#read(DataEntry)}
   */
  @Test
  public void testRead2() throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader = new ParallelDexClassReader(true, true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)),
        3);

    // Act and Assert
    assertThrows(IOException.class, () -> parallelDexClassReader
        .read(new StreamingDataEntry("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Method under test: {@link ParallelDexClassReader#read(DataEntry)}
   */
  @Test
  public void testRead3() throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader = new ParallelDexClassReader(false, true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)),
        3);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> parallelDexClassReader.read(new ClassPathDataEntry(clazz)));
  }
}

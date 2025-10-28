package proguard.io;

import static org.junit.Assert.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class DexClassReaderDiffblueTest {
  /**
   * Method under test: {@link DexClassReader#read(DataEntry)}
   */
  @Test
  public void testRead() throws IOException {
    // Arrange
    DexClassReader dexClassReader = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> dexClassReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Method under test: {@link DexClassReader#read(DataEntry)}
   */
  @Test
  public void testRead2() throws IOException {
    // Arrange
    DexClassReader dexClassReader = new DexClassReader(true,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));

    // Act and Assert
    assertThrows(IOException.class, () -> dexClassReader
        .read(new StreamingDataEntry("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Method under test: {@link DexClassReader#read(DataEntry)}
   */
  @Test
  public void testRead3() throws IOException {
    // Arrange
    DexClassReader dexClassReader = new DexClassReader(false,
        new D8ClassConverter(new D8ClassConverter.D8DexFile(
            new ClassPath(
                new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)),
            1, true)));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> dexClassReader.read(new ClassPathDataEntry(clazz)));
  }
}

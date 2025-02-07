package proguard.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.visitor.ClassVisitor;

class ParallelDexClassReaderDiffblueTest {
  /**
   * Test {@link ParallelDexClassReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link ParallelDexClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ParallelDexClassReader.read(proguard.io.DataEntry)"})
  void testRead() throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader =
        new ParallelDexClassReader(false, true, mock(ClassVisitor.class), 3);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IOException.class, () -> parallelDexClassReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Test {@link ParallelDexClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ParallelDexClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ParallelDexClassReader.read(proguard.io.DataEntry)"})
  void testRead_whenA_thenThrowIOException() throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader =
        new ParallelDexClassReader(true, true, mock(ClassVisitor.class), 3);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            parallelDexClassReader.read(
                new StreamingDataEntry(
                    "Name",
                    new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}))));
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
  @DisplayName("Test read(DataEntry); when 'java.lang.Object'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ParallelDexClassReader.read(proguard.io.DataEntry)"})
  void testRead_whenJavaLangObject_thenThrowIOException() throws IOException {
    // Arrange
    ParallelDexClassReader parallelDexClassReader =
        new ParallelDexClassReader(true, true, mock(ClassVisitor.class), 3);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IOException.class, () -> parallelDexClassReader.read(new ClassPathDataEntry(clazz)));
  }
}

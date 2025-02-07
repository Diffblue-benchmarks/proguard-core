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

class DexClassReaderDiffblueTest {
  /**
   * Test {@link DexClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DexClassReader#DexClassReader(boolean, ClassVisitor)} with readCode is
   *       {@code false} and {@link ClassVisitor}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DexClassReader(boolean, ClassVisitor) with readCode is 'false' and ClassVisitor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.DexClassReader.read(proguard.io.DataEntry)"})
  void testRead_givenDexClassReaderWithReadCodeIsFalseAndClassVisitor() throws IOException {
    // Arrange
    DexClassReader dexClassReader = new DexClassReader(false, mock(ClassVisitor.class));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> dexClassReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Test {@link DexClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); when 'A'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.DexClassReader.read(proguard.io.DataEntry)"})
  void testRead_whenA_thenThrowIOException() throws IOException {
    // Arrange
    DexClassReader dexClassReader = new DexClassReader(true, mock(ClassVisitor.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            dexClassReader.read(
                new StreamingDataEntry(
                    "Name",
                    new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}))));
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
  @DisplayName("Test read(DataEntry); when 'java.lang.Object'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.DexClassReader.read(proguard.io.DataEntry)"})
  void testRead_whenJavaLangObject_thenThrowIOException() throws IOException {
    // Arrange
    DexClassReader dexClassReader = new DexClassReader(true, mock(ClassVisitor.class));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> dexClassReader.read(new ClassPathDataEntry(clazz)));
  }
}

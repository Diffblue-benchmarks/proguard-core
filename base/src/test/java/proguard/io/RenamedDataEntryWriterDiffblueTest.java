package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.util.StringFunction;

class RenamedDataEntryWriterDiffblueTest {
  /**
   * Test {@link RenamedDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given StringFunction transform(String) return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenStringFunctionTransformReturnEmptyString() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("");
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(nameFunction, null);

    // Act
    boolean actualCreateDirectoryResult =
        renamedDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(nameFunction).transform(eq("Name/"));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link RenamedDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given StringFunction transform(String) return 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenStringFunctionTransformReturnNull_thenReturnFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn(null);
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(nameFunction, null);

    // Act
    boolean actualCreateDirectoryResult =
        renamedDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(nameFunction).transform(eq("Name/"));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link RenamedDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("Transform");
    RenamedDataEntryWriter renamedDataEntryWriter =
        new RenamedDataEntryWriter(
            nameFunction,
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    boolean actualCreateDirectoryResult =
        renamedDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(nameFunction).transform(eq("Name/"));
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); given StringFunction transform(String) return 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_givenStringFunctionTransformReturnNull_thenReturnFalse()
      throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn(null);
    RenamedDataEntryWriter renamedDataEntryWriter =
        new RenamedDataEntryWriter(
            nameFunction,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act
    boolean actualSameOutputStreamResult =
        renamedDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(nameFunction, atLeast(1)).transform(eq("Name"));
    assertFalse(actualSameOutputStreamResult);
  }

  /**
   * Test {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       Transform}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); given StringFunction transform(String) return 'Transform'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_givenStringFunctionTransformReturnTransform_thenReturnTrue()
      throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("Transform");
    RenamedDataEntryWriter renamedDataEntryWriter =
        new RenamedDataEntryWriter(
            nameFunction,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act
    boolean actualSameOutputStreamResult =
        renamedDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(nameFunction, atLeast(1)).transform(eq("Name"));
    assertTrue(actualSameOutputStreamResult);
  }

  /**
   * Test {@link RenamedDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(DataEntry); given StringFunction transform(String) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.RenamedDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_givenStringFunctionTransformReturnNull_thenReturnNull()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn(null);
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(nameFunction, null);

    // Act
    OutputStream actualCreateOutputStreamResult =
        renamedDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name"));

    // Assert
    verify(nameFunction).transform(eq("Name"));
    assertNull(actualCreateOutputStreamResult);
  }

  /**
   * Test {@link RenamedDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName("Test createOutputStream(DataEntry); then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.RenamedDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_thenCallsAccepts() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("");
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    RenamedDataEntryWriter renamedDataEntryWriter =
        new RenamedDataEntryWriter(
            nameFunction,
            new FilteredDataEntryWriter(
                dataEntryFilter,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act
    OutputStream actualCreateOutputStreamResult =
        renamedDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(nameFunction).transform(eq("Name"));
    assertNull(actualCreateOutputStreamResult);
  }
}

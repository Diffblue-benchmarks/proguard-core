package proguard.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.util.StringFunction;

class RenamedDataEntryReaderDiffblueTest {
  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead() throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("");
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(nameFunction, mock(DataEntryReader.class));

    // Act
    renamedDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(nameFunction).transform(eq("Name"));
  }

  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead2() throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("");
    DataEntryReader missingDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(missingDataEntryReader).read(Mockito.<DataEntry>any());
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(
            nameFunction, mock(DataEntryReader.class), missingDataEntryReader);

    // Act
    renamedDataEntryReader.read(
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true));

    // Assert
    verify(missingDataEntryReader).read(isA(DataEntry.class));
    verify(nameFunction).transform(eq("Name/"));
  }

  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead3() throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("foo");
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    DataEntryReader missingDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(missingDataEntryReader).read(Mockito.<DataEntry>any());
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(nameFunction, dataEntryReader, missingDataEntryReader);

    // Act
    renamedDataEntryReader.read(
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true));

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
    verify(nameFunction).transform(eq("Name/"));
  }

  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead4() throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("foo");
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    DataEntryReader missingDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(missingDataEntryReader).read(Mockito.<DataEntry>any());
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(nameFunction, dataEntryReader, missingDataEntryReader);

    // Act
    renamedDataEntryReader.read(new DummyDataEntry(new ClassPathDataEntry("Name"), "", 3L, true));

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
    verify(nameFunction).transform(eq(""));
  }

  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} throw {@link
   *       IOException#IOException(String)} with {@code foo}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryReader read(DataEntry) throw IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryReaderReadThrowIOExceptionWithFoo_thenThrowIOException()
      throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("");
    DataEntryReader missingDataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("foo")).when(missingDataEntryReader).read(Mockito.<DataEntry>any());
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(
            nameFunction, mock(DataEntryReader.class), missingDataEntryReader);

    // Act and Assert
    assertThrows(
        IOException.class, () -> renamedDataEntryReader.read(new ClassPathDataEntry("Name")));
    verify(missingDataEntryReader).read(isA(DataEntry.class));
    verify(nameFunction).transform(eq("Name"));
  }

  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return empty
   *       string.
   *   <li>Then calls {@link DataEntryReader#read(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given StringFunction transform(String) return empty string; then calls read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenStringFunctionTransformReturnEmptyString_thenCallsRead() throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("");
    DataEntryReader missingDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(missingDataEntryReader).read(Mockito.<DataEntry>any());
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(
            nameFunction, mock(DataEntryReader.class), missingDataEntryReader);

    // Act
    renamedDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(missingDataEntryReader).read(isA(DataEntry.class));
    verify(nameFunction).transform(eq("Name"));
  }

  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       null}.
   *   <li>Then calls {@link StringFunction#transform(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given StringFunction transform(String) return 'null'; then calls transform(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenStringFunctionTransformReturnNull_thenCallsTransform() throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn(null);
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(nameFunction, mock(DataEntryReader.class));

    // Act
    renamedDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(nameFunction).transform(eq("Name"));
  }

  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       Transform}.
   *   <li>Then calls {@link DataEntryReader#read(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given StringFunction transform(String) return 'Transform'; then calls read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenStringFunctionTransformReturnTransform_thenCallsRead() throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("Transform");
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(nameFunction, dataEntryReader);

    // Act
    renamedDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
    verify(nameFunction).transform(eq("Name"));
  }

  /**
   * Test {@link RenamedDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link StringFunction} {@link StringFunction#transform(String)} return {@code
   *       Transform}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given StringFunction transform(String) return 'Transform'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.RenamedDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenStringFunctionTransformReturnTransform_thenThrowIOException()
      throws IOException {
    // Arrange
    StringFunction nameFunction = mock(StringFunction.class);
    when(nameFunction.transform(Mockito.<String>any())).thenReturn("Transform");
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("foo")).when(dataEntryReader).read(Mockito.<DataEntry>any());
    RenamedDataEntryReader renamedDataEntryReader =
        new RenamedDataEntryReader(nameFunction, dataEntryReader);

    // Act and Assert
    assertThrows(
        IOException.class, () -> renamedDataEntryReader.read(new ClassPathDataEntry("Name")));
    verify(dataEntryReader).read(isA(DataEntry.class));
    verify(nameFunction).transform(eq("Name"));
  }
}

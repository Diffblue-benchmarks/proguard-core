package proguard.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

class FilteredDataEntryReaderDiffblueTest {
  /**
   * Test {@link FilteredDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       false}.
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryFilter accepts(DataEntry) return 'false'; then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryFilterAcceptsReturnFalse_thenCallsAccepts() throws IOException {
    // Arrange
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    FilteredDataEntryReader filteredDataEntryReader =
        new FilteredDataEntryReader(dataEntryFilter, mock(DataEntryReader.class));

    // Act
    filteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
  }

  /**
   * Test {@link FilteredDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} does nothing.
   *   <li>Then calls {@link DataEntryReader#read(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryReader read(DataEntry) does nothing; then calls read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryReaderReadDoesNothing_thenCallsRead() throws IOException {
    // Arrange
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());
    FilteredDataEntryReader filteredDataEntryReader =
        new FilteredDataEntryReader(dataEntryFilter, acceptedDataEntryReader);

    // Act
    filteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(acceptedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link FilteredDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} throw {@link
   *       IOException#IOException(String)} with {@code foo}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryReader read(DataEntry) throw IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryReaderReadThrowIOExceptionWithFoo_thenThrowIOException()
      throws IOException {
    // Arrange
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("foo")).when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());
    FilteredDataEntryReader filteredDataEntryReader =
        new FilteredDataEntryReader(dataEntryFilter, acceptedDataEntryReader);

    // Act and Assert
    assertThrows(
        IOException.class, () -> filteredDataEntryReader.read(new ClassPathDataEntry("Name")));
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(acceptedDataEntryReader).read(isA(DataEntry.class));
  }
}

package proguard.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MultiDataEntryReaderDiffblueTest {
  /**
   * Test {@link MultiDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link MultiDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); given DataEntryReader read(DataEntry) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.MultiDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryReaderReadDoesNothing() throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    MultiDataEntryReader multiDataEntryReader = new MultiDataEntryReader(dataEntryReader);

    // Act
    multiDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link MultiDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} throw {@link
   *       IOException#IOException(String)} with {@code foo}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link MultiDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryReader read(DataEntry) throw IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.MultiDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryReaderReadThrowIOExceptionWithFoo_thenThrowIOException()
      throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("foo")).when(dataEntryReader).read(Mockito.<DataEntry>any());
    MultiDataEntryReader multiDataEntryReader =
        new MultiDataEntryReader(dataEntryReader, mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class, () -> multiDataEntryReader.read(new ClassPathDataEntry("Name")));
    verify(dataEntryReader).read(isA(DataEntry.class));
  }
}

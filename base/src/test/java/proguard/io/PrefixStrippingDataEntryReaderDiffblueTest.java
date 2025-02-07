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

class PrefixStrippingDataEntryReaderDiffblueTest {
  /**
   * Test {@link PrefixStrippingDataEntryReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link PrefixStrippingDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.PrefixStrippingDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead() throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    PrefixStrippingDataEntryReader prefixStrippingDataEntryReader =
        new PrefixStrippingDataEntryReader("", dataEntryReader);

    // Act
    prefixStrippingDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link PrefixStrippingDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} does nothing.
   *   <li>Then calls {@link DataEntryReader#read(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixStrippingDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryReader read(DataEntry) does nothing; then calls read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.PrefixStrippingDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryReaderReadDoesNothing_thenCallsRead() throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    PrefixStrippingDataEntryReader prefixStrippingDataEntryReader =
        new PrefixStrippingDataEntryReader("Prefix", dataEntryReader);

    // Act
    prefixStrippingDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link PrefixStrippingDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} throw {@link
   *       IOException#IOException(String)} with {@code foo}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixStrippingDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryReader read(DataEntry) throw IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.PrefixStrippingDataEntryReader.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryReaderReadThrowIOExceptionWithFoo_thenThrowIOException()
      throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("foo")).when(dataEntryReader).read(Mockito.<DataEntry>any());
    PrefixStrippingDataEntryReader prefixStrippingDataEntryReader =
        new PrefixStrippingDataEntryReader("Prefix", dataEntryReader);

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> prefixStrippingDataEntryReader.read(new ClassPathDataEntry("Name")));
    verify(dataEntryReader).read(isA(DataEntry.class));
  }
}

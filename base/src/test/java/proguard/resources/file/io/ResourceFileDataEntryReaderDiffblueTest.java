package proguard.resources.file.io;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;
import proguard.io.DataEntryFilter;
import proguard.resources.file.visitor.ResourceJavaReferenceCleaner;

class ResourceFileDataEntryReaderDiffblueTest {
  /**
   * Test {@link ResourceFileDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       false}.
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFileDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryFilter accepts(DataEntry) return 'false'; then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.io.ResourceFileDataEntryReader.read(proguard.io.DataEntry)"
  })
  void testRead_givenDataEntryFilterAcceptsReturnFalse_thenCallsAccepts() throws IOException {
    // Arrange
    DataEntryFilter adaptedDataEntryFilter = mock(DataEntryFilter.class);
    when(adaptedDataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    ResourceFileDataEntryReader resourceFileDataEntryReader =
        new ResourceFileDataEntryReader(new ResourceJavaReferenceCleaner(), adaptedDataEntryFilter);
    Class<Object> clazz = Object.class;

    // Act
    resourceFileDataEntryReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(adaptedDataEntryFilter).accepts(isA(DataEntry.class));
  }

  /**
   * Test {@link ResourceFileDataEntryReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFileDataEntryReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); when 'java.lang.Object'; then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.io.ResourceFileDataEntryReader.read(proguard.io.DataEntry)"
  })
  void testRead_whenJavaLangObject_thenCallsAccepts() throws IOException {
    // Arrange
    DataEntryFilter adaptedDataEntryFilter = mock(DataEntryFilter.class);
    when(adaptedDataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    ResourceFileDataEntryReader resourceFileDataEntryReader =
        new ResourceFileDataEntryReader(new ResourceJavaReferenceCleaner(), adaptedDataEntryFilter);
    Class<Object> clazz = Object.class;

    // Act
    resourceFileDataEntryReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(adaptedDataEntryFilter).accepts(isA(DataEntry.class));
  }
}

package proguard.io;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

class NameFilteredDataEntryReaderDiffblueTest {
  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(List, DataEntryReader,
   * DataEntryReader)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(List,
   * DataEntryReader, DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(List, DataEntryReader, DataEntryReader); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(java.util.List, proguard.io.DataEntryReader, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_given42_whenArrayListAdd42() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());
    DataEntryReader rejectedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(rejectedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader(
            regularExpressions, acceptedDataEntryReader, rejectedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(rejectedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(List, DataEntryReader,
   * DataEntryReader)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(List,
   * DataEntryReader, DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(List, DataEntryReader, DataEntryReader); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(java.util.List, proguard.io.DataEntryReader, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_given42_whenArrayListAdd422() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("42");
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());
    DataEntryReader rejectedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(rejectedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader(
            regularExpressions, acceptedDataEntryReader, rejectedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(rejectedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(StringMatcher,
   * DataEntryReader)}.
   *
   * <ul>
   *   <li>Then calls {@link DataEntryReader#read(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NameFilteredDataEntryReader#NameFilteredDataEntryReader(StringMatcher, DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(StringMatcher, DataEntryReader); then calls read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(proguard.util.StringMatcher, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_thenCallsRead() throws IOException {
    // Arrange
    ConstantMatcher stringMatcher = new ConstantMatcher(true);
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader(stringMatcher, acceptedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(acceptedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(List, DataEntryReader,
   * DataEntryReader)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(List,
   * DataEntryReader, DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(List, DataEntryReader, DataEntryReader); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(java.util.List, proguard.io.DataEntryReader, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_whenArrayList() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader(
            regularExpressions, acceptedDataEntryReader, mock(DataEntryReader.class));
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(acceptedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(List, DataEntryReader)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link DataEntryReader#read(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(List,
   * DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(List, DataEntryReader); when ArrayList(); then calls read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(java.util.List, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_whenArrayList_thenCallsRead() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader(regularExpressions, acceptedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(acceptedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(StringMatcher,
   * DataEntryReader, DataEntryReader)}.
   *
   * <ul>
   *   <li>When {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NameFilteredDataEntryReader#NameFilteredDataEntryReader(StringMatcher, DataEntryReader,
   * DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(StringMatcher, DataEntryReader, DataEntryReader); when ConstantMatcher(boolean) with matches is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(proguard.util.StringMatcher, proguard.io.DataEntryReader, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_whenConstantMatcherWithMatchesIsTrue()
      throws IOException {
    // Arrange
    ConstantMatcher stringMatcher = new ConstantMatcher(true);
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());
    DataEntryReader rejectedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(rejectedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader(
            stringMatcher, acceptedDataEntryReader, rejectedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(acceptedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(String, DataEntryReader,
   * DataEntryReader)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(String,
   * DataEntryReader, DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(String, DataEntryReader, DataEntryReader); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(java.lang.String, proguard.io.DataEntryReader, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_whenEmptyString() throws IOException {
    // Arrange
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());
    DataEntryReader rejectedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(rejectedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader("", acceptedDataEntryReader, rejectedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(acceptedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(StringMatcher,
   * DataEntryReader, DataEntryReader)}.
   *
   * <ul>
   *   <li>When {@link EmptyStringMatcher} (default constructor).
   *   <li>Then calls {@link DataEntryReader#read(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NameFilteredDataEntryReader#NameFilteredDataEntryReader(StringMatcher, DataEntryReader,
   * DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(StringMatcher, DataEntryReader, DataEntryReader); when EmptyStringMatcher (default constructor); then calls read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(proguard.util.StringMatcher, proguard.io.DataEntryReader, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_whenEmptyStringMatcher_thenCallsRead()
      throws IOException {
    // Arrange
    EmptyStringMatcher stringMatcher = new EmptyStringMatcher();
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    DataEntryReader rejectedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(rejectedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader(
            stringMatcher, acceptedDataEntryReader, rejectedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(rejectedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(String, DataEntryReader)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link DataEntryReader#read(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(String,
   * DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(String, DataEntryReader); when empty string; then calls read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(java.lang.String, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_whenEmptyString_thenCallsRead() throws IOException {
    // Arrange
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(acceptedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader("", acceptedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(acceptedDataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(String, DataEntryReader,
   * DataEntryReader)}.
   *
   * <ul>
   *   <li>When {@code Regular Expression}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryReader#NameFilteredDataEntryReader(String,
   * DataEntryReader, DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryReader(String, DataEntryReader, DataEntryReader); when 'Regular Expression'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NameFilteredDataEntryReader.<init>(java.lang.String, proguard.io.DataEntryReader, proguard.io.DataEntryReader)"
  })
  void testNewNameFilteredDataEntryReader_whenRegularExpression() throws IOException {
    // Arrange
    DataEntryReader acceptedDataEntryReader = mock(DataEntryReader.class);
    DataEntryReader rejectedDataEntryReader = mock(DataEntryReader.class);
    doNothing().when(rejectedDataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    NameFilteredDataEntryReader actualNameFilteredDataEntryReader =
        new NameFilteredDataEntryReader(
            "Regular Expression", acceptedDataEntryReader, rejectedDataEntryReader);
    actualNameFilteredDataEntryReader.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(rejectedDataEntryReader).read(isA(DataEntry.class));
  }
}

package proguard.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.ClassVisitor;
import proguard.io.util.IOUtil;

class DataEntryRewriterDiffblueTest {
  /**
   * Test {@link DataEntryRewriter#DataEntryRewriter(ClassPool, Charset, DataEntryWriter)}.
   *
   * <ul>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryRewriter#DataEntryRewriter(ClassPool, Charset,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new DataEntryRewriter(ClassPool, Charset, DataEntryWriter); then calls apply(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.DataEntryRewriter.<init>(proguard.classfile.ClassPool, java.nio.charset.Charset, proguard.io.DataEntryWriter)"
  })
  void testNewDataEntryRewriter_thenCallsApply() throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);
    ClassPool classPool =
        IOUtil.read(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false)),
            "Class Name Filter",
            true,
            true,
            true,
            true,
            true,
            true,
            extraDataEntryReader);
    Charset charset = Charset.forName("UTF-8");
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);

    // Act
    DataEntryRewriter actualDataEntryRewriter =
        new DataEntryRewriter(
            classPool, charset, new FilteredDataEntryWriter(dataEntryFilter, null));
    actualDataEntryRewriter.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
  }

  /**
   * Test {@link DataEntryRewriter#DataEntryRewriter(ClassPool, Charset, DataEntryWriter)}.
   *
   * <ul>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryRewriter#DataEntryRewriter(ClassPool, Charset,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new DataEntryRewriter(ClassPool, Charset, DataEntryWriter); then calls apply(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.DataEntryRewriter.<init>(proguard.classfile.ClassPool, java.nio.charset.Charset, proguard.io.DataEntryWriter)"
  })
  void testNewDataEntryRewriter_thenCallsApply2() throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);
    ClassPool classPool =
        IOUtil.read(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile(), false)),
            "Class Name Filter",
            true,
            true,
            true,
            true,
            true,
            true,
            extraDataEntryReader);
    Charset charset = Charset.forName("UTF-8");
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);

    // Act
    DataEntryRewriter actualDataEntryRewriter =
        new DataEntryRewriter(
            classPool, charset, new FilteredDataEntryWriter(dataEntryFilter, null));
    actualDataEntryRewriter.read(
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true));

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
  }

  /**
   * Test {@link DataEntryRewriter#copyData(InputStream, OutputStream)} with {@code inputStream},
   * {@code outputStream}.
   *
   * <p>Method under test: {@link DataEntryRewriter#copyData(InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test copyData(InputStream, OutputStream) with 'inputStream', 'outputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.DataEntryRewriter.copyData(java.io.InputStream, java.io.OutputStream)"
  })
  void testCopyDataWithInputStreamOutputStream() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    DataEntryRewriter dataEntryRewriter =
        new DataEntryRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    dataEntryRewriter.copyData(inputStream, outputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[] {}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }

  /**
   * Test {@link DataEntryRewriter#copyData(InputStream, OutputStream)} with {@code inputStream},
   * {@code outputStream}.
   *
   * <p>Method under test: {@link DataEntryRewriter#copyData(InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test copyData(InputStream, OutputStream) with 'inputStream', 'outputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.DataEntryRewriter.copyData(java.io.InputStream, java.io.OutputStream)"
  })
  void testCopyDataWithInputStreamOutputStream2() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    DataEntryRewriter dataEntryRewriter =
        new DataEntryRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    dataEntryRewriter.copyData(inputStream, outputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[] {}));
    assertArrayEquals(
        new byte[] {-17, -65, -67, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, outputStream.toByteArray());
  }

  /**
   * Test {@link DataEntryRewriter#copyData(Reader, Writer)} with {@code reader}, {@code writer}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryRewriter#copyData(Reader, Writer)}
   */
  @Test
  @DisplayName(
      "Test copyData(Reader, Writer) with 'reader', 'writer'; then StringWriter() toString is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.DataEntryRewriter.copyData(java.io.Reader, java.io.Writer)"})
  void testCopyDataWithReaderWriter_thenStringWriterToStringIsFoo() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    DataEntryRewriter dataEntryRewriter =
        new DataEntryRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    dataEntryRewriter.copyData(reader, writer);

    // Assert
    assertEquals("foo", writer.toString());
  }
}

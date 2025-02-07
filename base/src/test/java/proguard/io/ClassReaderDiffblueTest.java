package proguard.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.util.WarningPrinter;
import proguard.classfile.visitor.ClassVisitor;

class ClassReaderDiffblueTest {
  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, WarningPrinter,
   * ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitLibraryClass() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(true, true, true, true, warningPrinter, classVisitor);
    Class<Object> clazz = Object.class;
    actualClassReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * boolean, WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitLibraryClass2() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(true, true, true, true, true, warningPrinter, classVisitor);
    Class<Object> clazz = Object.class;
    actualClassReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, WarningPrinter,
   * ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitProgramClass() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(false, true, true, true, warningPrinter, classVisitor);
    Class<Object> clazz = Object.class;
    actualClassReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, WarningPrinter,
   * ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitProgramClass2() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(false, true, true, false, warningPrinter, classVisitor);
    Class<Object> clazz = Object.class;
    actualClassReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, WarningPrinter,
   * ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitProgramClass3() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(false, true, true, true, warningPrinter, classVisitor);
    actualClassReader.read(new ClassPathDataEntry("module-info.class"));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * boolean, WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitProgramClass4() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(false, true, true, true, true, warningPrinter, classVisitor);
    Class<Object> clazz = Object.class;
    actualClassReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * boolean, WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitProgramClass5() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(false, true, true, false, true, warningPrinter, classVisitor);
    Class<Object> clazz = Object.class;
    actualClassReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * boolean, WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitProgramClass6() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(false, true, true, true, false, warningPrinter, classVisitor);
    Class<Object> clazz = Object.class;
    actualClassReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean, boolean,
   * WarningPrinter, ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#ClassReader(boolean, boolean, boolean, boolean,
   * boolean, WarningPrinter, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassReader(boolean, boolean, boolean, boolean, boolean, WarningPrinter, ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ClassReader.<init>(boolean, boolean, boolean, boolean, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassReader_thenCallsVisitProgramClass7() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    ClassReader actualClassReader =
        new ClassReader(false, true, true, true, true, warningPrinter, classVisitor);
    actualClassReader.read(new ClassPathDataEntry("module-info.class"));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead() throws IOException {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ClassReader classReader =
        new ClassReader(
            false,
            true,
            true,
            true,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            classVisitor);
    Class<Object> clazz = Object.class;

    // Act
    classReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead2() throws IOException {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ClassReader classReader =
        new ClassReader(
            false,
            true,
            true,
            false,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            classVisitor);
    Class<Object> clazz = Object.class;

    // Act
    classReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead3() throws IOException {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassReader classReader =
        new ClassReader(
            true,
            false,
            true,
            true,
            true,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            classVisitor);

    // Act
    classReader.read(new ClassPathDataEntry("module-info.class"));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead_thenCallsVisitLibraryClass() throws IOException {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassReader classReader =
        new ClassReader(
            true,
            true,
            true,
            true,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            classVisitor);
    Class<Object> clazz = Object.class;

    // Act
    classReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead_thenCallsVisitLibraryClass2() throws IOException {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassReader classReader =
        new ClassReader(
            true,
            true,
            true,
            true,
            true,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            classVisitor);
    Class<Object> clazz = Object.class;

    // Act
    classReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead_thenCallsVisitProgramClass() throws IOException {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ClassReader classReader =
        new ClassReader(
            false,
            true,
            true,
            true,
            true,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            classVisitor);
    Class<Object> clazz = Object.class;

    // Act
    classReader.read(new ClassPathDataEntry(clazz));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead_thenCallsVisitProgramClass2() throws IOException {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ClassReader classReader =
        new ClassReader(
            false,
            true,
            true,
            true,
            true,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            classVisitor);

    // Act
    classReader.read(new ClassPathDataEntry("module-info.class"));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with {@code A} and one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); when ByteArrayInputStream(byte[]) with array of byte with 'A' and one; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead_whenByteArrayInputStreamWithArrayOfByteWithAAndOne_thenThrowIOException()
      throws IOException {
    // Arrange
    ClassReader classReader =
        new ClassReader(
            false,
            true,
            true,
            true,
            true,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            mock(ClassVisitor.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            classReader.read(
                new StreamingDataEntry(
                    "Can't process class [",
                    new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}))));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ZipEntry#ZipEntry(String)} with {@code module-info.class}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); when ZipEntry(String) with 'module-info.class'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ClassReader.read(proguard.io.DataEntry)"})
  void testRead_whenZipEntryWithModuleInfoClass_thenThrowIOException() throws IOException {
    // Arrange
    ClassReader classReader =
        new ClassReader(
            false,
            true,
            true,
            true,
            true,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            mock(ClassVisitor.class));
    ClassPathDataEntry parent = new ClassPathDataEntry("module-info.class");
    ZipEntry zipEntry = new ZipEntry("module-info.class");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream(new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            classReader.read(
                new ZipDataEntry(
                    parent,
                    zipEntry,
                    new ZipInputStream(byteArrayInputStream, Charset.forName("UTF-8")))));
  }
}

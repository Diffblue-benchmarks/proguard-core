package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
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

class ClassMapDataEntryWriterDiffblueTest {
  /**
   * Test {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} does nothing.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given DataEntryReader read(DataEntry) does nothing; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ClassMapDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenDataEntryReaderReadDoesNothing_thenReturnFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);
    ClassPool programClassPool =
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
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            programClassPool, new FilteredDataEntryWriter(dataEntryFilter, null));

    // Act
    boolean actualCreateDirectoryResult =
        classMapDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ClassMapDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(classMapDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ClassMapDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new ClassMapDataEntryWriter(
                KotlinConstants.dummyClassPool,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ClassMapDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ClassMapDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ClassMapDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}

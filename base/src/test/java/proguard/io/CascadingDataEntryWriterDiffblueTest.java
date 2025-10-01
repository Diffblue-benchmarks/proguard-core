package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CascadingDataEntryWriterDiffblueTest {
  /**
   * Test {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CascadingDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter dataEntryWriter1 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DirectoryWriter dataEntryWriter2 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    CascadingDataEntryWriter dataEntryWriter12 =
        new CascadingDataEntryWriter(dataEntryWriter1, dataEntryWriter2);
    DirectoryWriter dataEntryWriter22 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    CascadingDataEntryWriter cascadingDataEntryWriter =
        new CascadingDataEntryWriter(dataEntryWriter12, dataEntryWriter22);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CascadingDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter dataEntryWriter1 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DirectoryWriter dataEntryWriter12 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DirectoryWriter dataEntryWriter2 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    CascadingDataEntryWriter dataEntryWriter22 =
        new CascadingDataEntryWriter(dataEntryWriter12, dataEntryWriter2);

    CascadingDataEntryWriter cascadingDataEntryWriter =
        new CascadingDataEntryWriter(dataEntryWriter1, dataEntryWriter22);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CascadingDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream3() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter dataEntryWriter1 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    FixedFileWriter dataEntryWriter2 =
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    CascadingDataEntryWriter cascadingDataEntryWriter =
        new CascadingDataEntryWriter(dataEntryWriter1, dataEntryWriter2);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertTrue(
        cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CascadingDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream_thenReturnFalse() throws IOException {
    // Arrange
    DirectoryWriter dataEntryWriter1 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DirectoryWriter dataEntryWriter2 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    CascadingDataEntryWriter cascadingDataEntryWriter =
        new CascadingDataEntryWriter(dataEntryWriter1, dataEntryWriter2);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CascadingDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    DirectoryWriter dataEntryWriter1 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DirectoryWriter dataEntryWriter2 =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    CascadingDataEntryWriter cascadingDataEntryWriter =
        new CascadingDataEntryWriter(dataEntryWriter1, dataEntryWriter2);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}

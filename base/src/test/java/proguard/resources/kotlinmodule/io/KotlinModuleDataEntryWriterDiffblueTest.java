package proguard.resources.kotlinmodule.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;
import proguard.io.DataEntryDirectoryFilter;
import proguard.io.DirectoryWriter;
import proguard.io.FilteredDataEntryWriter;
import proguard.resources.file.ResourceFilePool;

public class KotlinModuleDataEntryWriterDiffblueTest {
  /**
   * Test {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinModuleDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_thenReturnFalse() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new FilteredDataEntryWriter(
                dataEntryFilter,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(kotlinModuleDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinModuleDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(kotlinModuleDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinModuleDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        kotlinModuleDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinModuleDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        kotlinModuleDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link KotlinModuleDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "java.io.OutputStream KotlinModuleDataEntryWriter.createOutputStream(DataEntry)"
  })
  public void testCreateOutputStream_thenReturnNull() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter =
        new KotlinModuleDataEntryWriter(
            resourceFilePool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertNull(kotlinModuleDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }
}

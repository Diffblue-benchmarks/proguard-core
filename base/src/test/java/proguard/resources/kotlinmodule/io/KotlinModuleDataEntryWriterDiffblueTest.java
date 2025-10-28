package proguard.resources.kotlinmodule.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;
import proguard.io.DataEntryDirectoryFilter;
import proguard.io.DirectoryWriter;
import proguard.io.FilteredDataEntryWriter;
import proguard.resources.file.ResourceFilePool;

public class KotlinModuleDataEntryWriterDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter = new KotlinModuleDataEntryWriter(resourceFilePool,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(kotlinModuleDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link KotlinModuleDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter = new KotlinModuleDataEntryWriter(resourceFilePool,
        new FilteredDataEntryWriter(dataEntryFilter,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(kotlinModuleDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter = new KotlinModuleDataEntryWriter(resourceFilePool,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(kotlinModuleDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link KotlinModuleDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter = new KotlinModuleDataEntryWriter(resourceFilePool,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(kotlinModuleDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link KotlinModuleDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  public void testCreateOutputStream() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    KotlinModuleDataEntryWriter kotlinModuleDataEntryWriter = new KotlinModuleDataEntryWriter(resourceFilePool,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertNull(kotlinModuleDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }
}

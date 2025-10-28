package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.util.AndStringFunction;
import proguard.util.ClassPoolFeatureNameFunction;
import proguard.util.IdentityStringFunction;
import proguard.util.StringFunction;

public class RenamedDataEntryWriterDiffblueTest {
  /**
   * Method under test: {@link RenamedDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    ClassPoolFeatureNameFunction nameFunction = new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool);
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(nameFunction,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertFalse(renamedDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link RenamedDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    IdentityStringFunction nameFunction = new IdentityStringFunction();
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(nameFunction,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(renamedDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(StringFunction.IDENTITY_FUNCTION,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(renamedDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    AndStringFunction nameFunction = new AndStringFunction(StringFunction.IDENTITY_FUNCTION,
        StringFunction.IDENTITY_FUNCTION);

    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(nameFunction,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(renamedDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream3() throws IOException {
    // Arrange
    ClassPoolFeatureNameFunction nameFunction = new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool);
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(nameFunction,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertFalse(renamedDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream4() throws IOException {
    // Arrange
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(StringFunction.IDENTITY_FUNCTION,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(renamedDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream5() throws IOException {
    // Arrange
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(StringFunction.IDENTITY_FUNCTION,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertFalse(renamedDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry((String) null)));
  }

  /**
   * Method under test:
   * {@link RenamedDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  public void testCreateOutputStream() throws IOException {
    // Arrange
    ClassPoolFeatureNameFunction nameFunction = new ClassPoolFeatureNameFunction(KotlinConstants.dummyClassPool);
    RenamedDataEntryWriter renamedDataEntryWriter = new RenamedDataEntryWriter(nameFunction,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertNull(renamedDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }
}

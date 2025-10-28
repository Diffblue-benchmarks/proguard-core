package proguard.analysis.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;

public class FileLocationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileLocation#equals(Object)}
   *   <li>{@link FileLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);
    FileLocation fileLocation2 = new FileLocation("foo.txt", 2);

    // Act and Assert
    assertEquals(fileLocation, fileLocation2);
    int expectedHashCodeResult = fileLocation.hashCode();
    assertEquals(expectedHashCodeResult, fileLocation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileLocation#equals(Object)}
   *   <li>{@link FileLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);

    // Act and Assert
    assertEquals(fileLocation, fileLocation);
    int expectedHashCodeResult = fileLocation.hashCode();
    assertEquals(expectedHashCodeResult, fileLocation.hashCode());
  }

  /**
   * Method under test: {@link FileLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);

    // Act and Assert
    assertEquals(0, fileLocation.compareTo(new FileLocation("foo.txt", 2)));
  }

  /**
   * Method under test: {@link FileLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo2() {
    // Arrange
    FileLocation fileLocation = new FileLocation("Filename", 2);

    // Act and Assert
    assertEquals(-32, fileLocation.compareTo(new FileLocation("foo.txt", 2)));
  }

  /**
   * Method under test: {@link FileLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo3() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(Location.UNKNOWN_LINE,
        fileLocation.compareTo(new CodeLocation(clazz, new LibraryField(1, "foo.txt", "foo.txt"), 2)));
  }

  /**
   * Method under test: {@link FileLocation#getOriginalFilename()}
   */
  @Test
  public void testGetOriginalFilename() {
    // Arrange, Act and Assert
    assertEquals("foo.txt", (new FileLocation("foo.txt", 2)).getOriginalFilename());
  }

  /**
   * Method under test: {@link FileLocation#getOriginalFilename()}
   */
  @Test
  public void testGetOriginalFilename2() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);
    fileLocation.obfuscatedFilename = "foo";

    // Act and Assert
    assertEquals("foo", fileLocation.getOriginalFilename());
  }

  /**
   * Method under test: {@link FileLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FileLocation fileLocation = new FileLocation("Filename", 2);

    // Act and Assert
    assertNotEquals(fileLocation, new FileLocation("foo.txt", 2));
  }

  /**
   * Method under test: {@link FileLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 1);

    // Act and Assert
    assertNotEquals(fileLocation, new FileLocation("foo.txt", 2));
  }

  /**
   * Method under test: {@link FileLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FileLocation("foo.txt", 2), null);
  }

  /**
   * Method under test: {@link FileLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FileLocation("foo.txt", 2), "Different type to FileLocation");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileLocation#FileLocation(String, int)}
   *   <li>{@link FileLocation#toString()}
   *   <li>{@link FileLocation#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FileLocation actualFileLocation = new FileLocation("foo.txt", 2);
    String actualToStringResult = actualFileLocation.toString();

    // Assert
    assertEquals("foo.txt (line 2)", actualToStringResult);
    assertEquals("foo.txt", actualFileLocation.getName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileLocation#FileLocation(String, int, String)}
   *   <li>{@link FileLocation#toString()}
   *   <li>{@link FileLocation#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    FileLocation actualFileLocation = new FileLocation("foo.txt", 2, "foo.txt");
    String actualToStringResult = actualFileLocation.toString();

    // Assert
    assertEquals("foo.txt (line 2)", actualToStringResult);
    assertEquals("foo.txt", actualFileLocation.getName());
  }
}

package proguard.analysis.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;

class FileLocationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileLocation#FileLocation(String, int)}
   *   <li>{@link FileLocation#toString()}
   *   <li>{@link FileLocation#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileLocation.<init>(String, int)",
    "void FileLocation.<init>(String, int, String)",
    "String FileLocation.getName()",
    "String FileLocation.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    FileLocation actualFileLocation = new FileLocation("foo.txt", 2);
    String actualToStringResult = actualFileLocation.toString();

    // Assert
    assertEquals("foo.txt (line 2)", actualToStringResult);
    assertEquals("foo.txt", actualFileLocation.getName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileLocation#FileLocation(String, int, String)}
   *   <li>{@link FileLocation#toString()}
   *   <li>{@link FileLocation#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileLocation.<init>(String, int)",
    "void FileLocation.<init>(String, int, String)",
    "String FileLocation.getName()",
    "String FileLocation.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange and Act
    FileLocation actualFileLocation = new FileLocation("foo.txt", 2, "foo.txt");
    String actualToStringResult = actualFileLocation.toString();

    // Assert
    assertEquals("foo.txt (line 2)", actualToStringResult);
    assertEquals("foo.txt", actualFileLocation.getName());
  }

  /**
   * Test {@link FileLocation#equals(Object)}, and {@link FileLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileLocation#equals(Object)}
   *   <li>{@link FileLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileLocation.equals(Object)", "int FileLocation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);
    FileLocation fileLocation2 = new FileLocation("foo.txt", 2);

    // Act and Assert
    assertEquals(fileLocation, fileLocation2);
    assertEquals(fileLocation.hashCode(), fileLocation2.hashCode());
  }

  /**
   * Test {@link FileLocation#equals(Object)}, and {@link FileLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileLocation#equals(Object)}
   *   <li>{@link FileLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileLocation.equals(Object)", "int FileLocation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);

    // Act and Assert
    assertEquals(fileLocation, fileLocation);
    int expectedHashCodeResult = fileLocation.hashCode();
    assertEquals(expectedHashCodeResult, fileLocation.hashCode());
  }

  /**
   * Test {@link FileLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileLocation.equals(Object)", "int FileLocation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FileLocation fileLocation = new FileLocation("Filename", 2);

    // Act and Assert
    assertNotEquals(fileLocation, new FileLocation("foo.txt", 2));
  }

  /**
   * Test {@link FileLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileLocation.equals(Object)", "int FileLocation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 1);

    // Act and Assert
    assertNotEquals(fileLocation, new FileLocation("foo.txt", 2));
  }

  /**
   * Test {@link FileLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileLocation.equals(Object)", "int FileLocation.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FileLocation("foo.txt", 2), null);
  }

  /**
   * Test {@link FileLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileLocation.equals(Object)", "int FileLocation.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FileLocation("foo.txt", 2), "Different type to FileLocation");
  }

  /**
   * Test {@link FileLocation#compareTo(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return minus thirty-two.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'; then return minus thirty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FileLocation.compareTo(Location)"})
  void testCompareToWithLocation_thenReturnMinusThirtyTwo() {
    // Arrange
    FileLocation fileLocation = new FileLocation("Filename", 2);

    // Act
    int actualCompareToResult = fileLocation.compareTo(new FileLocation("foo.txt", 2));

    // Assert
    assertEquals(-32, actualCompareToResult);
  }

  /**
   * Test {@link FileLocation#compareTo(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return {@link Location#UNKNOWN_LINE}.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'; then return UNKNOWN_LINE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FileLocation.compareTo(Location)"})
  void testCompareToWithLocation_thenReturnUnknown_line() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "foo.txt", "foo.txt");

    CodeLocation o = new CodeLocation(clazz, member, 2);

    // Act
    int actualCompareToResult = fileLocation.compareTo(o);

    // Assert
    assertEquals(Location.UNKNOWN_LINE, actualCompareToResult);
  }

  /**
   * Test {@link FileLocation#compareTo(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FileLocation.compareTo(Location)"})
  void testCompareToWithLocation_thenReturnZero() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);

    // Act
    int actualCompareToResult = fileLocation.compareTo(new FileLocation("foo.txt", 2));

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link FileLocation#getOriginalFilename()}.
   *
   * <ul>
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#getOriginalFilename()}
   */
  @Test
  @DisplayName("Test getOriginalFilename(); then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileLocation.getOriginalFilename()"})
  void testGetOriginalFilename_thenReturnFoo() {
    // Arrange
    FileLocation fileLocation = new FileLocation("foo.txt", 2);
    fileLocation.obfuscatedFilename = "foo";

    // Act and Assert
    assertEquals("foo", fileLocation.getOriginalFilename());
  }

  /**
   * Test {@link FileLocation#getOriginalFilename()}.
   *
   * <ul>
   *   <li>Then return {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link FileLocation#getOriginalFilename()}
   */
  @Test
  @DisplayName("Test getOriginalFilename(); then return 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileLocation.getOriginalFilename()"})
  void testGetOriginalFilename_thenReturnFooTxt() {
    // Arrange, Act and Assert
    assertEquals("foo.txt", new FileLocation("foo.txt", 2).getOriginalFilename());
  }
}

package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.resources.file.ResourceFile;

public class StringConstantDiffblueTest {
  /**
   * Method under test: {@link StringConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(8, (new StringConstant()).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringConstant#equals(Object)}
   *   <li>{@link StringConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringConstant stringConstant = new StringConstant();
    StringConstant stringConstant2 = new StringConstant();

    // Act and Assert
    assertEquals(stringConstant, stringConstant2);
    int expectedHashCodeResult = stringConstant.hashCode();
    assertEquals(expectedHashCodeResult, stringConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringConstant#equals(Object)}
   *   <li>{@link StringConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringConstant stringConstant = new StringConstant();

    // Act and Assert
    assertEquals(stringConstant, stringConstant);
    int expectedHashCodeResult = stringConstant.hashCode();
    assertEquals(expectedHashCodeResult, stringConstant.hashCode());
  }

  /**
   * Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StringConstant stringConstant = new StringConstant(1, new ResourceFile("foo.txt", 3L));

    // Act and Assert
    assertNotEquals(stringConstant, new StringConstant());
  }

  /**
   * Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StringConstant stringConstant = new StringConstant(0, new ResourceFile("foo.txt", 3L));

    // Act and Assert
    assertNotEquals(stringConstant, new StringConstant());
  }

  /**
   * Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StringConstant stringConstant = new StringConstant(1, new ResourceFile("foo.txt", 3L));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(stringConstant, new StringConstant(1, referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StringConstant stringConstant = new StringConstant(1, new ResourceFile("foo.txt", 3L));

    // Act and Assert
    assertNotEquals(stringConstant, new StringConstant(1, null, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringConstant(), null);
  }

  /**
   * Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringConstant(), "Different type to StringConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringConstant#StringConstant()}
   *   <li>{@link StringConstant#toString()}
   *   <li>{@link StringConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StringConstant actualStringConstant = new StringConstant();
    String actualToStringResult = actualStringConstant.toString();
    boolean actualIsCategory2Result = actualStringConstant.isCategory2();

    // Assert
    assertEquals("String(0)", actualToStringResult);
    assertNull(actualStringConstant.getProcessingInfo());
    assertEquals(0, actualStringConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringConstant#StringConstant(int, Clazz, Member)}
   *   <li>{@link StringConstant#toString()}
   *   <li>{@link StringConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    StringConstant actualStringConstant = new StringConstant(1, referencedClass,
        new LibraryField(1, "Name", "Descriptor"));
    String actualToStringResult = actualStringConstant.toString();
    boolean actualIsCategory2Result = actualStringConstant.isCategory2();

    // Assert
    assertEquals("String(1)", actualToStringResult);
    assertNull(actualStringConstant.getProcessingInfo());
    assertEquals(0, actualStringConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link StringConstant#StringConstant(int, Clazz, Member, int, ResourceFile)}
   *   <li>{@link StringConstant#toString()}
   *   <li>{@link StringConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    StringConstant actualStringConstant = new StringConstant(1, referencedClass, referencedMember, 1,
        new ResourceFile("foo.txt", 3L));
    String actualToStringResult = actualStringConstant.toString();
    boolean actualIsCategory2Result = actualStringConstant.isCategory2();

    // Assert
    assertEquals("String(1)", actualToStringResult);
    ResourceFile resourceFile = actualStringConstant.referencedResourceFile;
    assertEquals("foo.txt", resourceFile.getFileName());
    assertNull(actualStringConstant.getProcessingInfo());
    assertNull(resourceFile.getProcessingInfo());
    assertNull(resourceFile.getFeatureName());
    assertEquals(0, actualStringConstant.getProcessingFlags());
    assertEquals(0, resourceFile.getProcessingFlags());
    assertEquals(3L, resourceFile.getFileSize());
    assertFalse(actualIsCategory2Result);
    assertTrue(resourceFile.getExtraFeatureNames().isEmpty());
    assertTrue(resourceFile.references.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringConstant#StringConstant(int, ResourceFile)}
   *   <li>{@link StringConstant#toString()}
   *   <li>{@link StringConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters4() {
    // Arrange and Act
    StringConstant actualStringConstant = new StringConstant(1, new ResourceFile("foo.txt", 3L));
    String actualToStringResult = actualStringConstant.toString();
    boolean actualIsCategory2Result = actualStringConstant.isCategory2();

    // Assert
    assertEquals("String(1)", actualToStringResult);
    ResourceFile resourceFile = actualStringConstant.referencedResourceFile;
    assertEquals("foo.txt", resourceFile.getFileName());
    assertNull(actualStringConstant.getProcessingInfo());
    assertNull(resourceFile.getProcessingInfo());
    assertNull(resourceFile.getFeatureName());
    assertEquals(0, actualStringConstant.getProcessingFlags());
    assertEquals(0, resourceFile.getProcessingFlags());
    assertEquals(3L, resourceFile.getFileSize());
    assertFalse(actualIsCategory2Result);
    assertTrue(resourceFile.getExtraFeatureNames().isEmpty());
    assertTrue(resourceFile.references.isEmpty());
  }
}

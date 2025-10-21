package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.resources.file.ResourceFile;

public class StringConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return {@link StringConstant#referencedResourceFile} FileName is {@code foo.txt}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringConstant#StringConstant(int, Clazz, Member, int, ResourceFile)}
   *   <li>{@link StringConstant#toString()}
   *   <li>{@link StringConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StringConstant.<init>()",
    "void StringConstant.<init>(int, Clazz, Member)",
    "void StringConstant.<init>(int, Clazz, Member, int, ResourceFile)",
    "void StringConstant.<init>(int, ResourceFile)",
    "boolean StringConstant.isCategory2()",
    "String StringConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnReferencedResourceFileFileNameIsFooTxt() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    StringConstant actualStringConstant =
        new StringConstant(
            1, referencedClass, referencedMember, 1, new ResourceFile("foo.txt", 3L));
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return {@link StringConstant#referencedResourceFile} FileName is {@code foo.txt}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringConstant#StringConstant(int, ResourceFile)}
   *   <li>{@link StringConstant#toString()}
   *   <li>{@link StringConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StringConstant.<init>()",
    "void StringConstant.<init>(int, Clazz, Member)",
    "void StringConstant.<init>(int, Clazz, Member, int, ResourceFile)",
    "void StringConstant.<init>(int, ResourceFile)",
    "boolean StringConstant.isCategory2()",
    "String StringConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnReferencedResourceFileFileNameIsFooTxt2() {
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

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code String(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringConstant#StringConstant()}
   *   <li>{@link StringConstant#toString()}
   *   <li>{@link StringConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StringConstant.<init>()",
    "void StringConstant.<init>(int, Clazz, Member)",
    "void StringConstant.<init>(int, Clazz, Member, int, ResourceFile)",
    "void StringConstant.<init>(int, ResourceFile)",
    "boolean StringConstant.isCategory2()",
    "String StringConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsString0() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return toString is {@code String(1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringConstant#StringConstant(int, Clazz, Member)}
   *   <li>{@link StringConstant#toString()}
   *   <li>{@link StringConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StringConstant.<init>()",
    "void StringConstant.<init>(int, Clazz, Member)",
    "void StringConstant.<init>(int, Clazz, Member, int, ResourceFile)",
    "void StringConstant.<init>(int, ResourceFile)",
    "boolean StringConstant.isCategory2()",
    "String StringConstant.toString()"
  })
  public void testGettersAndSetters_whenLibraryClass_thenReturnToStringIsString1() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    StringConstant actualStringConstant =
        new StringConstant(1, referencedClass, new LibraryField(1, "Name", "Descriptor"));
    String actualToStringResult = actualStringConstant.toString();
    boolean actualIsCategory2Result = actualStringConstant.isCategory2();

    // Assert
    assertEquals("String(1)", actualToStringResult);
    assertNull(actualStringConstant.getProcessingInfo());
    assertEquals(0, actualStringConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link StringConstant#getTag()}.
   *
   * <p>Method under test: {@link StringConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int StringConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(8, (new StringConstant()).getTag());
  }

  /**
   * Test {@link StringConstant#equals(Object)}, and {@link StringConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringConstant#equals(Object)}
   *   <li>{@link StringConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringConstant.equals(Object)", "int StringConstant.hashCode()"})
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
   * Test {@link StringConstant#equals(Object)}, and {@link StringConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringConstant#equals(Object)}
   *   <li>{@link StringConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringConstant.equals(Object)", "int StringConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringConstant stringConstant = new StringConstant();

    // Act and Assert
    assertEquals(stringConstant, stringConstant);
    int expectedHashCodeResult = stringConstant.hashCode();
    assertEquals(expectedHashCodeResult, stringConstant.hashCode());
  }

  /**
   * Test {@link StringConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringConstant.equals(Object)", "int StringConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StringConstant stringConstant = new StringConstant(1, new ResourceFile("foo.txt", 3L));

    // Act and Assert
    assertNotEquals(stringConstant, new StringConstant());
  }

  /**
   * Test {@link StringConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringConstant.equals(Object)", "int StringConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StringConstant stringConstant = new StringConstant(0, new ResourceFile("foo.txt", 3L));

    // Act and Assert
    assertNotEquals(stringConstant, new StringConstant());
  }

  /**
   * Test {@link StringConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringConstant.equals(Object)", "int StringConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StringConstant stringConstant = new StringConstant(1, new ResourceFile("foo.txt", 3L));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        stringConstant,
        new StringConstant(1, referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link StringConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringConstant.equals(Object)", "int StringConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StringConstant stringConstant = new StringConstant(1, new ResourceFile("foo.txt", 3L));

    // Act and Assert
    assertNotEquals(
        stringConstant, new StringConstant(1, null, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link StringConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringConstant.equals(Object)", "int StringConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringConstant(), null);
  }

  /**
   * Test {@link StringConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringConstant.equals(Object)", "int StringConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringConstant(), "Different type to StringConstant");
  }
}

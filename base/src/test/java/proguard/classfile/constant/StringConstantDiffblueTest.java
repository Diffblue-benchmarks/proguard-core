package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.Member;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;
import proguard.resources.file.ResourceFile;
import proguard.resources.file.visitor.ResourceFileVisitor;
import proguard.resources.file.visitor.ResourceJavaReferenceCleaner;

class StringConstantDiffblueTest {
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
  @DisplayName("Test getters and setters; then return referencedResourceFile FileName is 'foo.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.StringConstant.<init>()",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.classfile.Clazz, proguard.classfile.Member)",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.classfile.Clazz, proguard.classfile.Member, int, proguard.resources.file.ResourceFile)",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.resources.file.ResourceFile)",
    "boolean proguard.classfile.constant.StringConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.StringConstant.toString()"
  })
  void testGettersAndSetters_thenReturnReferencedResourceFileFileNameIsFooTxt() {
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
  @DisplayName("Test getters and setters; then return referencedResourceFile FileName is 'foo.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.StringConstant.<init>()",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.classfile.Clazz, proguard.classfile.Member)",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.classfile.Clazz, proguard.classfile.Member, int, proguard.resources.file.ResourceFile)",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.resources.file.ResourceFile)",
    "boolean proguard.classfile.constant.StringConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.StringConstant.toString()"
  })
  void testGettersAndSetters_thenReturnReferencedResourceFileFileNameIsFooTxt2() {
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
  @DisplayName("Test getters and setters; then return toString is 'String(0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.StringConstant.<init>()",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.classfile.Clazz, proguard.classfile.Member)",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.classfile.Clazz, proguard.classfile.Member, int, proguard.resources.file.ResourceFile)",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.resources.file.ResourceFile)",
    "boolean proguard.classfile.constant.StringConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.StringConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsString0() {
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
  @DisplayName("Test getters and setters; when LibraryClass(); then return toString is 'String(1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.StringConstant.<init>()",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.classfile.Clazz, proguard.classfile.Member)",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.classfile.Clazz, proguard.classfile.Member, int, proguard.resources.file.ResourceFile)",
    "void proguard.classfile.constant.StringConstant.<init>(int, proguard.resources.file.ResourceFile)",
    "boolean proguard.classfile.constant.StringConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.StringConstant.toString()"
  })
  void testGettersAndSetters_whenLibraryClass_thenReturnToStringIsString1() {
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
   * Test {@link StringConstant#getString(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#getString(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getString(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.StringConstant.getString(proguard.classfile.Clazz)"
  })
  void testGetString_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    StringConstant stringConstant = new StringConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualString = stringConstant.getString(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualString);
  }

  /**
   * Test {@link StringConstant#getTag()}.
   *
   * <p>Method under test: {@link StringConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.StringConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(8, (new StringConstant()).getTag());
  }

  /**
   * Test {@link StringConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitStringConstant(Clazz, StringConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); then calls visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.StringConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_thenCallsVisitStringConstant() {
    // Arrange
    StringConstant stringConstant = new StringConstant();
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitStringConstant(Mockito.<Clazz>any(), Mockito.<StringConstant>any());

    // Act
    stringConstant.accept(clazz, constantVisitor);

    // Assert
    verify(constantVisitor).visitStringConstant(isA(Clazz.class), isA(StringConstant.class));
  }

  /**
   * Test {@link StringConstant#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.StringConstant.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    StringConstant stringConstant = new StringConstant();
    stringConstant.referencedClass = new LibraryClass();
    stringConstant.referencedMember = null;
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    stringConstant.referencedClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link StringConstant#referencedMemberAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryField} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#referencedMemberAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMemberAccept(MemberVisitor); given LibraryField accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.StringConstant.referencedMemberAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMemberAccept_givenLibraryFieldAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryField libraryField = mock(LibraryField.class);
    doNothing().when(libraryField).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    StringConstant stringConstant = new StringConstant();
    stringConstant.referencedMember = libraryField;

    // Act
    stringConstant.referencedMemberAccept(new AttributeSorter());

    // Assert
    verify(libraryField).accept((Clazz) isNull(), isA(MemberVisitor.class));
  }

  /**
   * Test {@link StringConstant#referencedResourceFileAccept(ResourceFileVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringConstant#referencedResourceFileAccept(ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedResourceFileAccept(ResourceFileVisitor); then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.StringConstant.referencedResourceFileAccept(proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testReferencedResourceFileAccept_thenCallsAccept() {
    // Arrange
    ResourceFile resourceFile = mock(ResourceFile.class);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());
    StringConstant stringConstant = new StringConstant();
    stringConstant.referencedResourceFile = resourceFile;

    // Act
    stringConstant.referencedResourceFileAccept(new ResourceJavaReferenceCleaner());

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.StringConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.StringConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.StringConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.StringConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.StringConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.StringConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.StringConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.StringConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.StringConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.StringConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.StringConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.StringConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.StringConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.StringConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.StringConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.StringConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringConstant(), "Different type to StringConstant");
  }
}

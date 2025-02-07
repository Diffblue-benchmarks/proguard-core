package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.editor.ClassReferenceFixer;
import proguard.classfile.visitor.ClassVisitor;

class ClassElementValueDiffblueTest {
  /**
   * Test {@link ClassElementValue#ClassElementValue()}.
   *
   * <p>Method under test: {@link ClassElementValue#ClassElementValue()}
   */
  @Test
  @DisplayName("Test new ClassElementValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.ClassElementValue.<init>()",
    "void proguard.classfile.attribute.annotation.ClassElementValue.<init>(int, int)"
  })
  void testNewClassElementValue() {
    // Arrange and Act
    ClassElementValue actualClassElementValue = new ClassElementValue();

    // Assert
    assertNull(actualClassElementValue.getProcessingInfo());
    assertEquals(0, actualClassElementValue.getProcessingFlags());
  }

  /**
   * Test {@link ClassElementValue#ClassElementValue(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementValue#ClassElementValue(int, int)}
   */
  @Test
  @DisplayName("Test new ClassElementValue(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.ClassElementValue.<init>()",
    "void proguard.classfile.attribute.annotation.ClassElementValue.<init>(int, int)"
  })
  void testNewClassElementValue_whenOne() {
    // Arrange and Act
    ClassElementValue actualClassElementValue = new ClassElementValue(1, 1);

    // Assert
    assertNull(actualClassElementValue.getProcessingInfo());
    assertEquals(0, actualClassElementValue.getProcessingFlags());
  }

  /**
   * Test {@link ClassElementValue#getClassName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementValue#getClassName(Clazz)}
   */
  @Test
  @DisplayName("Test getClassName(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.annotation.ClassElementValue.getClassName(proguard.classfile.Clazz)"
  })
  void testGetClassName_givenString_thenReturnString() {
    // Arrange
    ClassElementValue classElementValue = new ClassElementValue(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualClassName = classElementValue.getClassName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualClassName);
  }

  /**
   * Test {@link ClassElementValue#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementValue#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.ClassElementValue.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    ClassElementValue classElementValue = new ClassElementValue(1, 1);
    classElementValue.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    classElementValue.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassElementValue#getTag()}.
   *
   * <p>Method under test: {@link ClassElementValue#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char proguard.classfile.attribute.annotation.ClassElementValue.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_CLASS, (new ClassElementValue(1, 1)).getTag());
  }

  /**
   * Test {@link ClassElementValue#accept(Clazz, Annotation, ElementValueVisitor)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementValue#accept(Clazz, Annotation, ElementValueVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Annotation, ElementValueVisitor); given 'String'; when LibraryClass getString(int) return 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.ClassElementValue.accept(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.visitor.ElementValueVisitor)"
  })
  void testAccept_givenString_whenLibraryClassGetStringReturnString_thenCallsGetString() {
    // Arrange
    ClassElementValue classElementValue = new ClassElementValue(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classElementValue.accept(clazz, annotation, new ClassReferenceFixer(true));

    // Assert
    verify(clazz).getString(eq(1));
  }
}

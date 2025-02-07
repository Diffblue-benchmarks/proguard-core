package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;

class EnclosingMethodAttributeDiffblueTest {
  /**
   * Test {@link EnclosingMethodAttribute#EnclosingMethodAttribute()}.
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#EnclosingMethodAttribute()}
   */
  @Test
  @DisplayName("Test new EnclosingMethodAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.EnclosingMethodAttribute.<init>()",
    "void proguard.classfile.attribute.EnclosingMethodAttribute.<init>(int, int, int)"
  })
  void testNewEnclosingMethodAttribute() {
    // Arrange and Act
    EnclosingMethodAttribute actualEnclosingMethodAttribute = new EnclosingMethodAttribute();

    // Assert
    assertNull(actualEnclosingMethodAttribute.getProcessingInfo());
    assertEquals(0, actualEnclosingMethodAttribute.getProcessingFlags());
  }

  /**
   * Test {@link EnclosingMethodAttribute#EnclosingMethodAttribute(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#EnclosingMethodAttribute(int, int, int)}
   */
  @Test
  @DisplayName("Test new EnclosingMethodAttribute(int, int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.EnclosingMethodAttribute.<init>()",
    "void proguard.classfile.attribute.EnclosingMethodAttribute.<init>(int, int, int)"
  })
  void testNewEnclosingMethodAttribute_whenOne() {
    // Arrange and Act
    EnclosingMethodAttribute actualEnclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Assert
    assertNull(actualEnclosingMethodAttribute.getProcessingInfo());
    assertEquals(0, actualEnclosingMethodAttribute.getProcessingFlags());
  }

  /**
   * Test {@link EnclosingMethodAttribute#getClassName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#getClassName(Clazz)}
   */
  @Test
  @DisplayName("Test getClassName(Clazz); given 'Class Name'; then return 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.EnclosingMethodAttribute.getClassName(proguard.classfile.Clazz)"
  })
  void testGetClassName_givenClassName_thenReturnClassName() {
    // Arrange
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    String actualClassName = enclosingMethodAttribute.getClassName(clazz);

    // Assert
    verify(clazz).getClassName(eq(1));
    assertEquals("Class Name", actualClassName);
  }

  /**
   * Test {@link EnclosingMethodAttribute#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getName(int)} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'Name'; when LibraryClass getName(int) return 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.EnclosingMethodAttribute.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenName_whenLibraryClassGetNameReturnName_thenReturnName() {
    // Arrange
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");

    // Act
    String actualName = enclosingMethodAttribute.getName(clazz);

    // Assert
    verify(clazz).getName(eq(1));
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link EnclosingMethodAttribute#getType(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getType(int)} return {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#getType(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getType(Clazz); given 'Type'; when LibraryClass getType(int) return 'Type'; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.EnclosingMethodAttribute.getType(proguard.classfile.Clazz)"
  })
  void testGetType_givenType_whenLibraryClassGetTypeReturnType_thenReturnType() {
    // Arrange
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    String actualType = enclosingMethodAttribute.getType(clazz);

    // Assert
    verify(clazz).getType(eq(1));
    assertEquals("Type", actualType);
  }

  /**
   * Test {@link EnclosingMethodAttribute#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.EnclosingMethodAttribute.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);
    enclosingMethodAttribute.referencedClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    enclosingMethodAttribute.referencedClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link EnclosingMethodAttribute#referencedMethodAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#referencedMethodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMethodAccept(MemberVisitor); given LibraryMethod accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.EnclosingMethodAttribute.referencedMethodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMethodAccept_givenLibraryMethodAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);
    enclosingMethodAttribute.referencedMethod = libraryMethod;

    // Act
    enclosingMethodAttribute.referencedMethodAccept(new AttributeSorter());

    // Assert
    verify(libraryMethod).accept((Clazz) isNull(), isA(MemberVisitor.class));
  }

  /**
   * Test {@link EnclosingMethodAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz},
   * {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitEnclosingMethodAttribute(Clazz,
   *       EnclosingMethodAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.EnclosingMethodAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitEnclosingMethodAttribute() {
    // Arrange
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitEnclosingMethodAttribute(
            Mockito.<Clazz>any(), Mockito.<EnclosingMethodAttribute>any());

    // Act
    enclosingMethodAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitEnclosingMethodAttribute(isA(Clazz.class), isA(EnclosingMethodAttribute.class));
  }
}

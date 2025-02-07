package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.visitor.MemberVisitor;

class ElementValueDiffblueTest {
  /**
   * Test {@link ElementValue#getMethodName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValue#getMethodName(Clazz)}
   */
  @Test
  @DisplayName("Test getMethodName(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.annotation.ElementValue.getMethodName(proguard.classfile.Clazz)"
  })
  void testGetMethodName_givenString_thenReturnString() {
    // Arrange
    AnnotationElementValue annotationElementValue = new AnnotationElementValue();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualMethodName = annotationElementValue.getMethodName(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualMethodName);
  }

  /**
   * Test {@link ElementValue#referencedMethodAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValue#referencedMethodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMethodAccept(MemberVisitor); given LibraryMethod accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.ElementValue.referencedMethodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMethodAccept_givenLibraryMethodAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    AnnotationElementValue annotationElementValue = new AnnotationElementValue();
    annotationElementValue.referencedMethod = libraryMethod;

    // Act
    annotationElementValue.referencedMethodAccept(new AttributeSorter());

    // Assert
    verify(libraryMethod).accept((Clazz) isNull(), isA(MemberVisitor.class));
  }
}

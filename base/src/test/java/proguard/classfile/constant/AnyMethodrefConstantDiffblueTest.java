package proguard.classfile.constant;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.visitor.MemberVisitor;

class AnyMethodrefConstantDiffblueTest {
  /**
   * Test {@link AnyMethodrefConstant#referencedMethodAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnyMethodrefConstant#referencedMethodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMethodAccept(MemberVisitor); given LibraryMethod accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.AnyMethodrefConstant.referencedMethodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMethodAccept_givenLibraryMethodAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    interfaceMethodrefConstant.referencedMethod = libraryMethod;

    // Act
    interfaceMethodrefConstant.referencedMethodAccept(new AttributeSorter());

    // Assert
    verify(libraryMethod).accept((Clazz) isNull(), isA(MemberVisitor.class));
  }

  /**
   * Test {@link AnyMethodrefConstant#referencedMemberAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnyMethodrefConstant#referencedMemberAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMemberAccept(MemberVisitor); given LibraryMethod accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.AnyMethodrefConstant.referencedMemberAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMemberAccept_givenLibraryMethodAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    interfaceMethodrefConstant.referencedMethod = libraryMethod;

    // Act
    interfaceMethodrefConstant.referencedMemberAccept(new AttributeSorter());

    // Assert
    verify(libraryMethod).accept((Clazz) isNull(), isA(MemberVisitor.class));
  }
}

package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.editor.AttributeSorter;
import proguard.util.SimpleProcessable;

class MemberProcessingFlagFilterDiffblueTest {
  /**
   * Test {@link MemberProcessingFlagFilter#visitAnyMember(Clazz, Member)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link SimpleProcessable#getProcessingFlags()}.
   * </ul>
   *
   * <p>Method under test: {@link MemberProcessingFlagFilter#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName("Test visitAnyMember(Clazz, Member); given one; then calls getProcessingFlags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberProcessingFlagFilter.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember_givenOne_thenCallsGetProcessingFlags() {
    // Arrange
    MemberProcessingFlagFilter memberProcessingFlagFilter =
        new MemberProcessingFlagFilter(1, 1, new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    LibraryField member = mock(LibraryField.class);
    when(member.getProcessingFlags()).thenReturn(1);

    // Act
    memberProcessingFlagFilter.visitAnyMember(clazz, member);

    // Assert
    verify(member).getProcessingFlags();
  }

  /**
   * Test {@link MemberProcessingFlagFilter#visitAnyMember(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberProcessingFlagFilter#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName("Test visitAnyMember(Clazz, Member); then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberProcessingFlagFilter.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember_thenCallsAccept() {
    // Arrange
    MemberProcessingFlagFilter memberProcessingFlagFilter =
        new MemberProcessingFlagFilter(1, 0, new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    LibraryField member = mock(LibraryField.class);
    doNothing().when(member).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    when(member.getProcessingFlags()).thenReturn(1);

    // Act
    memberProcessingFlagFilter.visitAnyMember(clazz, member);

    // Assert
    verify(member).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(member).getProcessingFlags();
  }
}

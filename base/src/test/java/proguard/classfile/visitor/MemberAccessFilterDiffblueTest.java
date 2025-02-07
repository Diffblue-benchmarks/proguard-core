package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;

class MemberAccessFilterDiffblueTest {
  /**
   * Test {@link MemberAccessFilter#visitAnyMember(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessFilter#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMember(Clazz, Member); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberAccessFilter.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember_thenCallsVisitLibraryField() {
    // Arrange
    MemberVisitor acceptedMemberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(acceptedMemberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    MemberAccessFilter memberAccessFilter = new MemberAccessFilter(1, 0, acceptedMemberVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    memberAccessFilter.visitAnyMember(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(acceptedMemberVisitor)
        .visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }
}

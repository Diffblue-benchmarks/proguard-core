package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.classfile.editor.AttributeSorter;

class MemberCollectionFilterDiffblueTest {
  /**
   * Test {@link MemberCollectionFilter#visitAnyMember(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberCollectionFilter#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMember(Clazz, Member); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberCollectionFilter.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember_thenCallsVisitLibraryField() {
    // Arrange
    MemberVisitor rejectedVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(rejectedVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    HashSet<Member> members = new HashSet<>();
    MemberCollectionFilter memberCollectionFilter =
        new MemberCollectionFilter(members, new AttributeSorter(), rejectedVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    memberCollectionFilter.visitAnyMember(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(rejectedVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }
}

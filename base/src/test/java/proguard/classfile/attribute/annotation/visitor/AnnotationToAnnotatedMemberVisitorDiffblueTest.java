package proguard.classfile.attribute.annotation.visitor;

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
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.visitor.MemberVisitor;

class AnnotationToAnnotatedMemberVisitorDiffblueTest {
  /**
   * Test {@link AnnotationToAnnotatedMemberVisitor#visitAnnotation(Clazz, Member, Annotation)} with
   * {@code clazz}, {@code member}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationToAnnotatedMemberVisitor#visitAnnotation(Clazz, Member,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Member, Annotation) with 'clazz', 'member', 'annotation'; then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationToAnnotatedMemberVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMemberAnnotation_thenCallsVisitLibraryField() {
    // Arrange
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    AnnotationToAnnotatedMemberVisitor annotationToAnnotatedMemberVisitor =
        new AnnotationToAnnotatedMemberVisitor(memberVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    annotationToAnnotatedMemberVisitor.visitAnnotation(clazz, (Member) member, new Annotation());

    // Assert
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }
}

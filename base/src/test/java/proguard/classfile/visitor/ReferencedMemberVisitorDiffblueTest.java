package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.editor.AttributeSorter;

class ReferencedMemberVisitorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReferencedMemberVisitor#ReferencedMemberVisitor(MemberVisitor)}
   *   <li>{@link ReferencedMemberVisitor#visitAnyConstant(Clazz, Constant)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedMemberVisitor.<init>(proguard.classfile.visitor.MemberVisitor)",
    "void proguard.classfile.visitor.ReferencedMemberVisitor.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ReferencedMemberVisitor actualReferencedMemberVisitor =
        new ReferencedMemberVisitor(new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    actualReferencedMemberVisitor.visitAnyConstant(clazz, new ClassConstant());

    // Assert
    assertTrue(actualReferencedMemberVisitor.memberVisitor instanceof AttributeSorter);
  }

  /**
   * Test {@link ReferencedMemberVisitor#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link StringConstant#referencedMemberAccept(MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedMemberVisitor#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then calls referencedMemberAccept(MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedMemberVisitor.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsReferencedMemberAccept() {
    // Arrange
    ReferencedMemberVisitor referencedMemberVisitor =
        new ReferencedMemberVisitor(new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    StringConstant stringConstant = mock(StringConstant.class);
    doNothing().when(stringConstant).referencedMemberAccept(Mockito.<MemberVisitor>any());

    // Act
    referencedMemberVisitor.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).referencedMemberAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link ReferencedMemberVisitor#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedMemberVisitor#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedMemberVisitor.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsVisitLibraryField() {
    // Arrange
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    ReferencedMemberVisitor referencedMemberVisitor = new ReferencedMemberVisitor(memberVisitor);
    LibraryClass clazz = new LibraryClass();
    StringConstant stringConstant = new StringConstant();
    stringConstant.referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    referencedMemberVisitor.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(memberVisitor).visitLibraryField(isNull(), isA(LibraryField.class));
  }

  /**
   * Test {@link ReferencedMemberVisitor#visitAnyElementValue(Clazz, Annotation, ElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ElementValue#referencedMethodAccept(MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedMemberVisitor#visitAnyElementValue(Clazz, Annotation,
   * ElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnyElementValue(Clazz, Annotation, ElementValue); then calls referencedMethodAccept(MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedMemberVisitor.visitAnyElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testVisitAnyElementValue_thenCallsReferencedMethodAccept() {
    // Arrange
    ReferencedMemberVisitor referencedMemberVisitor =
        new ReferencedMemberVisitor(new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue elementValue = mock(AnnotationElementValue.class);
    doNothing().when(elementValue).referencedMethodAccept(Mockito.<MemberVisitor>any());

    // Act
    referencedMemberVisitor.visitAnyElementValue(clazz, annotation, elementValue);

    // Assert
    verify(elementValue).referencedMethodAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link ReferencedMemberVisitor#visitAnyElementValue(Clazz, Annotation, ElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedMemberVisitor#visitAnyElementValue(Clazz, Annotation,
   * ElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnyElementValue(Clazz, Annotation, ElementValue); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedMemberVisitor.visitAnyElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testVisitAnyElementValue_thenCallsVisitLibraryMethod() {
    // Arrange
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    ReferencedMemberVisitor referencedMemberVisitor = new ReferencedMemberVisitor(memberVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue elementValue = new AnnotationElementValue();
    elementValue.referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    referencedMemberVisitor.visitAnyElementValue(clazz, annotation, elementValue);

    // Assert
    verify(memberVisitor).visitLibraryMethod(isNull(), isA(LibraryMethod.class));
  }
}

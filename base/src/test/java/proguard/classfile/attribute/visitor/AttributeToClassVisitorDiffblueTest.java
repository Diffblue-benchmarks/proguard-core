package proguard.classfile.attribute.visitor;

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
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.visitor.ClassVisitor;

class AttributeToClassVisitorDiffblueTest {
  /**
   * Test {@link AttributeToClassVisitor#visitAnyAttribute(Clazz, Attribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeToClassVisitor#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAttribute(Clazz, Attribute); when LibraryClass(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeToClassVisitor.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testVisitAnyAttribute_whenLibraryClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AttributeToClassVisitor attributeToClassVisitor = new AttributeToClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeToClassVisitor.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}

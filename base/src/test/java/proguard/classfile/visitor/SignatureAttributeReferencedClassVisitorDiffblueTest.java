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
import proguard.classfile.attribute.SignatureAttribute;

class SignatureAttributeReferencedClassVisitorDiffblueTest {
  /**
   * Test {@link SignatureAttributeReferencedClassVisitor#visitSignatureAttribute(Clazz,
   * SignatureAttribute)} with {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link
   * SignatureAttributeReferencedClassVisitor#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SignatureAttributeReferencedClassVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    SignatureAttributeReferencedClassVisitor signatureAttributeReferencedClassVisitor =
        new SignatureAttributeReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    signatureAttribute.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    signatureAttributeReferencedClassVisitor.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}

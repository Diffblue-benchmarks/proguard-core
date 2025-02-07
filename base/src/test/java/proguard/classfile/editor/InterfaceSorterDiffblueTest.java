package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import proguard.classfile.attribute.SignatureAttribute;

class InterfaceSorterDiffblueTest {
  /**
   * Test {@link InterfaceSorter#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link InterfaceSorter#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InterfaceSorter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    InterfaceSorter interfaceSorter = new InterfaceSorter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getInterfaceCount()).thenReturn(-1);
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getSignature(Mockito.<Clazz>any())).thenReturn("S");

    // Act
    interfaceSorter.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(clazz).getInterfaceCount();
    verify(signatureAttribute, atLeast(1)).getSignature(isA(Clazz.class));
  }
}

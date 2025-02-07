package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.MultiAttributeVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;
import proguard.classfile.visitor.ClassVisitor;

class SignatureAttributeDiffblueTest {
  /**
   * Test {@link SignatureAttribute#SignatureAttribute()}.
   *
   * <p>Method under test: {@link SignatureAttribute#SignatureAttribute()}
   */
  @Test
  @DisplayName("Test new SignatureAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.<init>()",
    "void proguard.classfile.attribute.SignatureAttribute.<init>(int, int)"
  })
  void testNewSignatureAttribute() {
    // Arrange and Act
    SignatureAttribute actualSignatureAttribute = new SignatureAttribute();

    // Assert
    assertNull(actualSignatureAttribute.getProcessingInfo());
    assertEquals(0, actualSignatureAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SignatureAttribute#SignatureAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAttribute#SignatureAttribute(int, int)}
   */
  @Test
  @DisplayName("Test new SignatureAttribute(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.<init>()",
    "void proguard.classfile.attribute.SignatureAttribute.<init>(int, int)"
  })
  void testNewSignatureAttribute_whenOne() {
    // Arrange and Act
    SignatureAttribute actualSignatureAttribute = new SignatureAttribute(1, 1);

    // Assert
    assertNull(actualSignatureAttribute.getProcessingInfo());
    assertEquals(0, actualSignatureAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SignatureAttribute#getSignature(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAttribute#getSignature(Clazz)}
   */
  @Test
  @DisplayName("Test getSignature(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.SignatureAttribute.getSignature(proguard.classfile.Clazz)"
  })
  void testGetSignature_givenString_thenReturnString() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualSignature = signatureAttribute.getSignature(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualSignature);
  }

  /**
   * Test {@link SignatureAttribute#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAttribute#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    signatureAttribute.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    signatureAttribute.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link SignatureAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSignatureAttribute(Clazz, SignatureAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitSignatureAttribute(Clazz, SignatureAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitSignatureAttribute() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSignatureAttribute(Mockito.<Clazz>any(), Mockito.<SignatureAttribute>any());

    // Act
    signatureAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSignatureAttribute(isA(Clazz.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link SignatureAttribute#accept(Clazz, Field, AttributeVisitor)} with {@code clazz},
   * {@code field}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSignatureAttribute(Clazz, Field,
   *       SignatureAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAttribute#accept(Clazz, Field, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, AttributeVisitor) with 'clazz', 'field', 'attributeVisitor'; then calls visitSignatureAttribute(Clazz, Field, SignatureAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzFieldAttributeVisitor_thenCallsVisitSignatureAttribute() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<SignatureAttribute>any());

    // Act
    signatureAttribute.accept(clazz, field, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSignatureAttribute(isA(Clazz.class), isA(Field.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link SignatureAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code clazz},
   * {@code method}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSignatureAttribute(Clazz, Method,
   *       SignatureAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'; then calls visitSignatureAttribute(Clazz, Method, SignatureAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor_thenCallsVisitSignatureAttribute() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<SignatureAttribute>any());

    // Act
    signatureAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSignatureAttribute(
            isA(Clazz.class), isA(Method.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)} with
   * {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link SignatureAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    signatureAttribute.accept(clazz, recordComponentInfo, new DominatorCalculator(true));

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }

  /**
   * Test {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)} with
   * {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link SignatureAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor2() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));

    // Act
    signatureAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }

  /**
   * Test {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)} with
   * {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link SignatureAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor3() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});

    // Act
    signatureAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert
    assertEquals(0, signatureAttribute.u2attributeNameIndex);
    assertEquals(0, signatureAttribute.u2signatureIndex);
  }

  /**
   * Test {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)} with
   * {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>When {@link MultiAttributeVisitor#MultiAttributeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'; when MultiAttributeVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SignatureAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor_whenMultiAttributeVisitor() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    signatureAttribute.accept(clazz, recordComponentInfo, new MultiAttributeVisitor());

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }
}

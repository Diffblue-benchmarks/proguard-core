package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.editor.ConstantPoolRemapper;

public class NonEmptyAttributeFilterDiffblueTest {
  /**
   * Test {@link NonEmptyAttributeFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link NonEmptyAttributeFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NonEmptyAttributeFilter.visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute() {
    // Arrange
    NonEmptyAttributeFilter nonEmptyAttributeFilter =
        new NonEmptyAttributeFilter(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    nonEmptyAttributeFilter.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }

  /**
   * Test {@link NonEmptyAttributeFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link NonEmptyAttributeFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NonEmptyAttributeFilter.visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute2() {
    // Arrange
    NonEmptyAttributeFilter nonEmptyAttributeFilter =
        new NonEmptyAttributeFilter(new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    nonEmptyAttributeFilter.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }

  /**
   * Test {@link NonEmptyAttributeFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link NonEmptyAttributeFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NonEmptyAttributeFilter.visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    NonEmptyAttributeFilter nonEmptyAttributeFilter = new NonEmptyAttributeFilter(attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    nonEmptyAttributeFilter.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }

  /**
   * Test {@link NonEmptyAttributeFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link NonEmptyAttributeFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NonEmptyAttributeFilter.visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});
    NonEmptyAttributeFilter nonEmptyAttributeFilter = new NonEmptyAttributeFilter(attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    nonEmptyAttributeFilter.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert
    assertEquals(0, signatureAttribute.u2attributeNameIndex);
    assertEquals(0, signatureAttribute.u2signatureIndex);
  }
}

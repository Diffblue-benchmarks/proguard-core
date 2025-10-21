package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.MultiAttributeVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;

public class SignatureAttributeDiffblueTest {
  /**
   * Test {@link SignatureAttribute#SignatureAttribute()}.
   *
   * <p>Method under test: {@link SignatureAttribute#SignatureAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SignatureAttribute.<init>()",
    "void SignatureAttribute.<init>(int, int)"
  })
  public void testNewSignatureAttribute() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SignatureAttribute.<init>()",
    "void SignatureAttribute.<init>(int, int)"
  })
  public void testNewSignatureAttribute_whenOne() {
    // Arrange and Act
    SignatureAttribute actualSignatureAttribute = new SignatureAttribute(1, 1);

    // Assert
    assertNull(actualSignatureAttribute.getProcessingInfo());
    assertEquals(0, actualSignatureAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)} with
   * {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link SignatureAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SignatureAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SignatureAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SignatureAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SignatureAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor_whenMultiAttributeVisitor() {
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

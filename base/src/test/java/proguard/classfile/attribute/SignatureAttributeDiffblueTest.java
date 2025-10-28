package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.MultiAttributeVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;

public class SignatureAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept() {
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
   * Method under test:
   * {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept2() {
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

  /**
   * Method under test:
   * {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept3() {
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
   * Method under test:
   * {@link SignatureAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[]{1, 0, 1, 0});

    // Act
    signatureAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert
    assertEquals(0, signatureAttribute.u2attributeNameIndex);
    assertEquals(0, signatureAttribute.u2signatureIndex);
  }

  /**
   * Method under test: {@link SignatureAttribute#SignatureAttribute()}
   */
  @Test
  public void testNewSignatureAttribute() {
    // Arrange and Act
    SignatureAttribute actualSignatureAttribute = new SignatureAttribute();

    // Assert
    assertNull(actualSignatureAttribute.getProcessingInfo());
    assertEquals(0, actualSignatureAttribute.getProcessingFlags());
  }

  /**
   * Method under test: {@link SignatureAttribute#SignatureAttribute(int, int)}
   */
  @Test
  public void testNewSignatureAttribute2() {
    // Arrange and Act
    SignatureAttribute actualSignatureAttribute = new SignatureAttribute(1, 1);

    // Assert
    assertNull(actualSignatureAttribute.getProcessingInfo());
    assertEquals(0, actualSignatureAttribute.getProcessingFlags());
  }
}

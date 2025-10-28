package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute;
import proguard.classfile.editor.ConstantPoolRemapper;

public class DebugAttributeVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    debugAttributeVisitor.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute2() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    debugAttributeVisitor.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    debugAttributeVisitor.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert that nothing has changed
    assertEquals(1, signatureAttribute.u2attributeNameIndex);
    assertEquals(1, signatureAttribute.u2signatureIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  public void testVisitSignatureAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[]{1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    // Act
    debugAttributeVisitor.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert
    assertEquals(0, signatureAttribute.u2attributeNameIndex);
    assertEquals(0, signatureAttribute.u2signatureIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(clazz, recordComponentInfo,
        runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(clazz, recordComponentInfo,
        runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(clazz, recordComponentInfo,
        runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[]{1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(clazz, recordComponentInfo,
        runtimeVisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeVisibleAnnotationsAttribute5() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeVisibleAnnotationsAttribute6() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeVisibleAnnotationsAttribute7() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeVisibleAnnotationsAttribute8() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[]{1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(clazz, runtimeVisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(clazz, recordComponentInfo,
        runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(clazz, recordComponentInfo,
        runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(clazz, recordComponentInfo,
        runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[]{1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(clazz, recordComponentInfo,
        runtimeInvisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeInvisibleAnnotationsAttribute5() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeInvisibleAnnotationsAttribute6() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeInvisibleAnnotationsAttribute7() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  public void testVisitRuntimeInvisibleAnnotationsAttribute8() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[]{1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor = new DebugAttributeVisitor("Not all who wander are lost",
        attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }
}

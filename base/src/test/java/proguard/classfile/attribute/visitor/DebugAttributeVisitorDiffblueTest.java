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
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute;
import proguard.classfile.editor.ConstantPoolRemapper;

public class DebugAttributeVisitorDiffblueTest {
  /**
   * Test {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new DominatorCalculator(true));
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
   * Test {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute2() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new MultiAttributeVisitor());
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
   * Test {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
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
   * Test {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link DebugAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute)"
  })
  public void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
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
   * Test {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", new MultiAttributeVisitor());
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * DebugAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DebugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute)"
  })
  public void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});
    DebugAttributeVisitor debugAttributeVisitor =
        new DebugAttributeVisitor("Not all who wander are lost", attributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    debugAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }
}

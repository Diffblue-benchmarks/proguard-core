package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.MultiAttributeVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;

public class RuntimeInvisibleAnnotationsAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, new DominatorCalculator(true));

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, new MultiAttributeVisitor());

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[]{1, 0, 1, 0});

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link RuntimeInvisibleAnnotationsAttribute#RuntimeInvisibleAnnotationsAttribute()}
   */
  @Test
  public void testNewRuntimeInvisibleAnnotationsAttribute() {
    // Arrange and Act
    RuntimeInvisibleAnnotationsAttribute actualRuntimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeInvisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link RuntimeInvisibleAnnotationsAttribute#RuntimeInvisibleAnnotationsAttribute(int, int, Annotation[])}
   */
  @Test
  public void testNewRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange and Act
    RuntimeInvisibleAnnotationsAttribute actualRuntimeInvisibleAnnotationsAttribute = new RuntimeInvisibleAnnotationsAttribute(
        1, 3, new Annotation[]{new Annotation()});

    // Assert
    assertNull(actualRuntimeInvisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleAnnotationsAttribute.getProcessingFlags());
  }
}

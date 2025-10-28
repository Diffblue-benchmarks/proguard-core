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

public class RuntimeVisibleAnnotationsAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    runtimeVisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, new DominatorCalculator(true));

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    runtimeVisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, new MultiAttributeVisitor());

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    MultiAttributeVisitor attributeVisitor = new MultiAttributeVisitor();
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));
    attributeVisitor.addAttributeVisitor(new DominatorCalculator(true));

    // Act
    runtimeVisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[]{1, 0, 1, 0});

    // Act
    runtimeVisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link RuntimeVisibleAnnotationsAttribute#RuntimeVisibleAnnotationsAttribute()}
   */
  @Test
  public void testNewRuntimeVisibleAnnotationsAttribute() {
    // Arrange and Act
    RuntimeVisibleAnnotationsAttribute actualRuntimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeVisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link RuntimeVisibleAnnotationsAttribute#RuntimeVisibleAnnotationsAttribute(int, int, Annotation[])}
   */
  @Test
  public void testNewRuntimeVisibleAnnotationsAttribute2() {
    // Arrange and Act
    RuntimeVisibleAnnotationsAttribute actualRuntimeVisibleAnnotationsAttribute = new RuntimeVisibleAnnotationsAttribute(
        1, 3, new Annotation[]{new Annotation()});

    // Assert
    assertNull(actualRuntimeVisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleAnnotationsAttribute.getProcessingFlags());
  }
}

package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.MultiAttributeVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;

public class RuntimeVisibleAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link RuntimeVisibleAnnotationsAttribute#RuntimeVisibleAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeVisibleAnnotationsAttribute#RuntimeVisibleAnnotationsAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleAnnotationsAttribute.<init>()",
    "void RuntimeVisibleAnnotationsAttribute.<init>(int, int, Annotation[])"
  })
  public void testNewRuntimeVisibleAnnotationsAttribute() {
    // Arrange and Act
    RuntimeVisibleAnnotationsAttribute actualRuntimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeVisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeVisibleAnnotationsAttribute#RuntimeVisibleAnnotationsAttribute(int, int,
   * Annotation[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeVisibleAnnotationsAttribute#RuntimeVisibleAnnotationsAttribute(int, int, Annotation[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleAnnotationsAttribute.<init>()",
    "void RuntimeVisibleAnnotationsAttribute.<init>(int, int, Annotation[])"
  })
  public void testNewRuntimeVisibleAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeVisibleAnnotationsAttribute actualRuntimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute(1, 3, new Annotation[] {new Annotation()});

    // Assert
    assertNull(actualRuntimeVisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleAnnotationsAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor() {
    // Arrange
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    runtimeVisibleAnnotationsAttribute.accept(
        clazz, recordComponentInfo, new DominatorCalculator(true));

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleAnnotationsAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor2() {
    // Arrange
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();
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
   * Test {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleAnnotationsAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor3() {
    // Arrange
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});

    // Act
    runtimeVisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>When {@link MultiAttributeVisitor#MultiAttributeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeVisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleAnnotationsAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor_whenMultiAttributeVisitor() {
    // Arrange
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    runtimeVisibleAnnotationsAttribute.accept(
        clazz, recordComponentInfo, new MultiAttributeVisitor());

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }
}

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

public class RuntimeInvisibleAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#RuntimeInvisibleAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleAnnotationsAttribute#RuntimeInvisibleAnnotationsAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleAnnotationsAttribute.<init>()",
    "void RuntimeInvisibleAnnotationsAttribute.<init>(int, int, Annotation[])"
  })
  public void testNewRuntimeInvisibleAnnotationsAttribute() {
    // Arrange and Act
    RuntimeInvisibleAnnotationsAttribute actualRuntimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeInvisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#RuntimeInvisibleAnnotationsAttribute(int, int,
   * Annotation[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleAnnotationsAttribute#RuntimeInvisibleAnnotationsAttribute(int, int,
   * Annotation[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleAnnotationsAttribute.<init>()",
    "void RuntimeInvisibleAnnotationsAttribute.<init>(int, int, Annotation[])"
  })
  public void testNewRuntimeInvisibleAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeInvisibleAnnotationsAttribute actualRuntimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute(1, 3, new Annotation[] {new Annotation()});

    // Assert
    assertNull(actualRuntimeInvisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleAnnotationsAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(
        clazz, recordComponentInfo, new DominatorCalculator(true));

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleAnnotationsAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor2() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();
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
   * Test {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleAnnotationsAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor3() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    ConstantPoolRemapper attributeVisitor = new ConstantPoolRemapper();
    attributeVisitor.setConstantIndexMap(new int[] {1, 0, 1, 0});

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>When {@link MultiAttributeVisitor#MultiAttributeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleAnnotationsAttribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"
  })
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor_whenMultiAttributeVisitor() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(
        clazz, recordComponentInfo, new MultiAttributeVisitor());

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }
}

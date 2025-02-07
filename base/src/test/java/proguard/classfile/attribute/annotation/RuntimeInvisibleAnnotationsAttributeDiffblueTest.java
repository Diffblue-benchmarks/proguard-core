package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.MultiAttributeVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;

class RuntimeInvisibleAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#RuntimeInvisibleAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleAnnotationsAttribute#RuntimeInvisibleAnnotationsAttribute()}
   */
  @Test
  @DisplayName("Test new RuntimeInvisibleAnnotationsAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.<init>(int, int, proguard.classfile.attribute.annotation.Annotation[])"
  })
  void testNewRuntimeInvisibleAnnotationsAttribute() {
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
  @DisplayName("Test new RuntimeInvisibleAnnotationsAttribute(int, int, Annotation[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.<init>(int, int, proguard.classfile.attribute.annotation.Annotation[])"
  })
  void testNewRuntimeInvisibleAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeInvisibleAnnotationsAttribute actualRuntimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute(1, 3, new Annotation[] {new Annotation()});

    // Assert
    assertNull(actualRuntimeInvisibleAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, AttributeVisitor)} with {@code
   * clazz}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeInvisibleAnnotationsAttribute>any());

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, Field, AttributeVisitor)} with
   * {@code clazz}, {@code field}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, Field,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, AttributeVisitor) with 'clazz', 'field', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzFieldAttributeVisitor() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(clazz, field, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, Method, AttributeVisitor)} with
   * {@code clazz}, {@code method}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, Method,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor() {
    // Arrange
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());

    // Act
    runtimeInvisibleAnnotationsAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor() {
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
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor2() {
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
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor3() {
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
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'; when MultiAttributeVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor_whenMultiAttributeVisitor() {
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

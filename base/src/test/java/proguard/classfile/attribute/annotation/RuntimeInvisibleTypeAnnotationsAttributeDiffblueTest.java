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
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class RuntimeInvisibleTypeAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link
   * RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute()}
   */
  @Test
  @DisplayName("Test new RuntimeInvisibleTypeAnnotationsAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.<init>(int, int, proguard.classfile.attribute.annotation.TypeAnnotation[])"
  })
  void testNewRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange and Act
    RuntimeInvisibleTypeAnnotationsAttribute actualRuntimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link
   * RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute(int, int,
   * TypeAnnotation[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute(int, int,
   * TypeAnnotation[])}
   */
  @Test
  @DisplayName(
      "Test new RuntimeInvisibleTypeAnnotationsAttribute(int, int, TypeAnnotation[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.<init>(int, int, proguard.classfile.attribute.annotation.TypeAnnotation[])"
  })
  void testNewRuntimeInvisibleTypeAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeInvisibleTypeAnnotationsAttribute actualRuntimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute(
            1, 3, new TypeAnnotation[] {new TypeAnnotation()});

    // Assert
    assertNull(actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz, AttributeVisitor)} with
   * {@code clazz}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor() {
    // Arrange
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());

    // Act
    runtimeInvisibleTypeAnnotationsAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz, Field, AttributeVisitor)}
   * with {@code clazz}, {@code field}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz, Field,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, AttributeVisitor) with 'clazz', 'field', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzFieldAttributeVisitor() {
    // Arrange
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());

    // Act
    runtimeInvisibleTypeAnnotationsAttribute.accept(clazz, field, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Field.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz, Method, AttributeVisitor)}
   * with {@code clazz}, {@code method}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz, Method,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor() {
    // Arrange
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());

    // Act
    runtimeInvisibleTypeAnnotationsAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz, Method, CodeAttribute,
   * AttributeVisitor)} with {@code clazz}, {@code method}, {@code codeAttribute}, {@code
   * attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz, Method,
   * CodeAttribute, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
    // Arrange
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());

    // Act
    runtimeInvisibleTypeAnnotationsAttribute.accept(clazz, method, codeAttribute, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz, RecordComponentInfo,
   * AttributeVisitor)} with {@code clazz}, {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link RuntimeInvisibleTypeAnnotationsAttribute#accept(Clazz,
   * RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor() {
    // Arrange
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());

    // Act
    runtimeInvisibleTypeAnnotationsAttribute.accept(clazz, recordComponentInfo, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }
}

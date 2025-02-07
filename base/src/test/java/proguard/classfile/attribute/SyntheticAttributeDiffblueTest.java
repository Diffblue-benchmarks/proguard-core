package proguard.classfile.attribute;

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
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class SyntheticAttributeDiffblueTest {
  /**
   * Test {@link SyntheticAttribute#SyntheticAttribute()}.
   *
   * <p>Method under test: {@link SyntheticAttribute#SyntheticAttribute()}
   */
  @Test
  @DisplayName("Test new SyntheticAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SyntheticAttribute.<init>()",
    "void proguard.classfile.attribute.SyntheticAttribute.<init>(int)"
  })
  void testNewSyntheticAttribute() {
    // Arrange and Act
    SyntheticAttribute actualSyntheticAttribute = new SyntheticAttribute();

    // Assert
    assertNull(actualSyntheticAttribute.getProcessingInfo());
    assertEquals(0, actualSyntheticAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SyntheticAttribute#SyntheticAttribute(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SyntheticAttribute#SyntheticAttribute(int)}
   */
  @Test
  @DisplayName("Test new SyntheticAttribute(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SyntheticAttribute.<init>()",
    "void proguard.classfile.attribute.SyntheticAttribute.<init>(int)"
  })
  void testNewSyntheticAttribute_whenOne() {
    // Arrange and Act
    SyntheticAttribute actualSyntheticAttribute = new SyntheticAttribute(1);

    // Assert
    assertNull(actualSyntheticAttribute.getProcessingInfo());
    assertEquals(0, actualSyntheticAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SyntheticAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSyntheticAttribute(Clazz, SyntheticAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SyntheticAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitSyntheticAttribute(Clazz, SyntheticAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SyntheticAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitSyntheticAttribute() {
    // Arrange
    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSyntheticAttribute(Mockito.<Clazz>any(), Mockito.<SyntheticAttribute>any());

    // Act
    syntheticAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSyntheticAttribute(isA(Clazz.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link SyntheticAttribute#accept(Clazz, Field, AttributeVisitor)} with {@code clazz},
   * {@code field}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSyntheticAttribute(Clazz, Field,
   *       SyntheticAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SyntheticAttribute#accept(Clazz, Field, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, AttributeVisitor) with 'clazz', 'field', 'attributeVisitor'; then calls visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SyntheticAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzFieldAttributeVisitor_thenCallsVisitSyntheticAttribute() {
    // Arrange
    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSyntheticAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<SyntheticAttribute>any());

    // Act
    syntheticAttribute.accept(clazz, field, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSyntheticAttribute(isA(Clazz.class), isA(Field.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link SyntheticAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code clazz},
   * {@code method}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSyntheticAttribute(Clazz, Method,
   *       SyntheticAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SyntheticAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'; then calls visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SyntheticAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor_thenCallsVisitSyntheticAttribute() {
    // Arrange
    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSyntheticAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<SyntheticAttribute>any());

    // Act
    syntheticAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSyntheticAttribute(
            isA(Clazz.class), isA(Method.class), isA(SyntheticAttribute.class));
  }
}

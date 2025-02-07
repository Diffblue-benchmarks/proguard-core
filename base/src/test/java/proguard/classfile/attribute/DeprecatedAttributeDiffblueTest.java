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

class DeprecatedAttributeDiffblueTest {
  /**
   * Test {@link DeprecatedAttribute#DeprecatedAttribute()}.
   *
   * <p>Method under test: {@link DeprecatedAttribute#DeprecatedAttribute()}
   */
  @Test
  @DisplayName("Test new DeprecatedAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.DeprecatedAttribute.<init>()",
    "void proguard.classfile.attribute.DeprecatedAttribute.<init>(int)"
  })
  void testNewDeprecatedAttribute() {
    // Arrange and Act
    DeprecatedAttribute actualDeprecatedAttribute = new DeprecatedAttribute();

    // Assert
    assertNull(actualDeprecatedAttribute.getProcessingInfo());
    assertEquals(0, actualDeprecatedAttribute.getProcessingFlags());
  }

  /**
   * Test {@link DeprecatedAttribute#DeprecatedAttribute(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DeprecatedAttribute#DeprecatedAttribute(int)}
   */
  @Test
  @DisplayName("Test new DeprecatedAttribute(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.DeprecatedAttribute.<init>()",
    "void proguard.classfile.attribute.DeprecatedAttribute.<init>(int)"
  })
  void testNewDeprecatedAttribute_whenOne() {
    // Arrange and Act
    DeprecatedAttribute actualDeprecatedAttribute = new DeprecatedAttribute(1);

    // Assert
    assertNull(actualDeprecatedAttribute.getProcessingInfo());
    assertEquals(0, actualDeprecatedAttribute.getProcessingFlags());
  }

  /**
   * Test {@link DeprecatedAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link DeprecatedAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitDeprecatedAttribute(Clazz, DeprecatedAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.DeprecatedAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitDeprecatedAttribute() {
    // Arrange
    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitDeprecatedAttribute(Mockito.<Clazz>any(), Mockito.<DeprecatedAttribute>any());

    // Act
    deprecatedAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitDeprecatedAttribute(isA(Clazz.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link DeprecatedAttribute#accept(Clazz, Field, AttributeVisitor)} with {@code clazz},
   * {@code field}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitDeprecatedAttribute(Clazz, Field,
   *       DeprecatedAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link DeprecatedAttribute#accept(Clazz, Field, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, AttributeVisitor) with 'clazz', 'field', 'attributeVisitor'; then calls visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.DeprecatedAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzFieldAttributeVisitor_thenCallsVisitDeprecatedAttribute() {
    // Arrange
    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitDeprecatedAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<DeprecatedAttribute>any());

    // Act
    deprecatedAttribute.accept(clazz, field, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitDeprecatedAttribute(
            isA(Clazz.class), isA(Field.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link DeprecatedAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code clazz},
   * {@code method}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitDeprecatedAttribute(Clazz, Method,
   *       DeprecatedAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link DeprecatedAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'; then calls visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.DeprecatedAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor_thenCallsVisitDeprecatedAttribute() {
    // Arrange
    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitDeprecatedAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<DeprecatedAttribute>any());

    // Act
    deprecatedAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitDeprecatedAttribute(
            isA(Clazz.class), isA(Method.class), isA(DeprecatedAttribute.class));
  }
}

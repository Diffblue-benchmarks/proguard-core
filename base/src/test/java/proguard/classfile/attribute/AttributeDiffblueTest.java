package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class AttributeDiffblueTest {
  /**
   * Test {@link Attribute#getAttributeName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link Attribute#getAttributeName(Clazz)}
   */
  @Test
  @DisplayName("Test getAttributeName(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.Attribute.getAttributeName(proguard.classfile.Clazz)"
  })
  void testGetAttributeName_givenString_thenReturnString() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualAttributeName = bootstrapMethodsAttribute.getAttributeName(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualAttributeName);
  }

  /**
   * Test {@link Attribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Attribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.Attribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenThrowUnsupportedOperationException() {
    // Arrange
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> codeAttribute.accept(clazz, new DominatorCalculator(true)));
  }

  /**
   * Test {@link Attribute#accept(Clazz, Field, AttributeVisitor)} with {@code clazz}, {@code
   * field}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Attribute#accept(Clazz, Field, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, AttributeVisitor) with 'clazz', 'field', 'attributeVisitor'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.Attribute.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzFieldAttributeVisitor_thenThrowUnsupportedOperationException() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bootstrapMethodsAttribute.accept(clazz, field, new DominatorCalculator(true)));
  }

  /**
   * Test {@link Attribute#accept(Clazz, Method, AttributeVisitor)} with {@code clazz}, {@code
   * method}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Attribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.Attribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor_thenThrowUnsupportedOperationException() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bootstrapMethodsAttribute.accept(clazz, method, new DominatorCalculator(true)));
  }

  /**
   * Test {@link Attribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)} with {@code
   * clazz}, {@code method}, {@code codeAttribute}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link Attribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.Attribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bootstrapMethodsAttribute.accept(
                clazz, method, codeAttribute, new DominatorCalculator(true)));
  }

  /**
   * Test {@link Attribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)} with {@code
   * clazz}, {@code method}, {@code codeAttribute}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link Attribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.Attribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor2() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bootstrapMethodsAttribute.accept(clazz, method, null, new DominatorCalculator(true)));
  }

  /**
   * Test {@link Attribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)} with {@code clazz},
   * {@code recordComponentInfo}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link Attribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, RecordComponentInfo, AttributeVisitor) with 'clazz', 'recordComponentInfo', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.Attribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzRecordComponentInfoAttributeVisitor() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bootstrapMethodsAttribute.accept(
                clazz, recordComponentInfo, new DominatorCalculator(true)));
  }
}

package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
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

class UnknownAttributeDiffblueTest {
  /**
   * Test {@link UnknownAttribute#UnknownAttribute(int, int, byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownAttribute#UnknownAttribute(int, int, byte[])}
   */
  @Test
  @DisplayName("Test new UnknownAttribute(int, int, byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.UnknownAttribute.<init>(int, int)",
    "void proguard.classfile.attribute.UnknownAttribute.<init>(int, int, byte[])"
  })
  void testNewUnknownAttribute_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    UnknownAttribute actualUnknownAttribute =
        new UnknownAttribute(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualUnknownAttribute.getProcessingInfo());
    assertEquals(0, actualUnknownAttribute.getProcessingFlags());
  }

  /**
   * Test {@link UnknownAttribute#UnknownAttribute(int, int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link UnknownAttribute#UnknownAttribute(int, int)}
   */
  @Test
  @DisplayName("Test new UnknownAttribute(int, int); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.UnknownAttribute.<init>(int, int)",
    "void proguard.classfile.attribute.UnknownAttribute.<init>(int, int, byte[])"
  })
  void testNewUnknownAttribute_whenThree() {
    // Arrange and Act
    UnknownAttribute actualUnknownAttribute = new UnknownAttribute(1, 3);

    // Assert
    assertNull(actualUnknownAttribute.getProcessingInfo());
    assertEquals(0, actualUnknownAttribute.getProcessingFlags());
  }

  /**
   * Test {@link UnknownAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.UnknownAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitUnknownAttribute() {
    // Arrange
    UnknownAttribute unknownAttribute = new UnknownAttribute(1, 3);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitUnknownAttribute(Mockito.<Clazz>any(), Mockito.<UnknownAttribute>any());

    // Act
    unknownAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor).visitUnknownAttribute(isA(Clazz.class), isA(UnknownAttribute.class));
  }

  /**
   * Test {@link UnknownAttribute#accept(Clazz, Field, AttributeVisitor)} with {@code clazz}, {@code
   * field}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownAttribute#accept(Clazz, Field, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, AttributeVisitor) with 'clazz', 'field', 'attributeVisitor'; then calls visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.UnknownAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzFieldAttributeVisitor_thenCallsVisitUnknownAttribute() {
    // Arrange
    UnknownAttribute unknownAttribute = new UnknownAttribute(1, 3);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitUnknownAttribute(Mockito.<Clazz>any(), Mockito.<UnknownAttribute>any());

    // Act
    unknownAttribute.accept(clazz, field, attributeVisitor);

    // Assert
    verify(attributeVisitor).visitUnknownAttribute(isA(Clazz.class), isA(UnknownAttribute.class));
  }

  /**
   * Test {@link UnknownAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code clazz},
   * {@code method}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'; then calls visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.UnknownAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor_thenCallsVisitUnknownAttribute() {
    // Arrange
    UnknownAttribute unknownAttribute = new UnknownAttribute(1, 3);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitUnknownAttribute(Mockito.<Clazz>any(), Mockito.<UnknownAttribute>any());

    // Act
    unknownAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor).visitUnknownAttribute(isA(Clazz.class), isA(UnknownAttribute.class));
  }

  /**
   * Test {@link UnknownAttribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)} with
   * {@code clazz}, {@code method}, {@code codeAttribute}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link UnknownAttribute#accept(Clazz, Method, CodeAttribute,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.UnknownAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
    // Arrange
    UnknownAttribute unknownAttribute = new UnknownAttribute(1, 3);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitUnknownAttribute(Mockito.<Clazz>any(), Mockito.<UnknownAttribute>any());

    // Act
    unknownAttribute.accept(clazz, method, codeAttribute, attributeVisitor);

    // Assert
    verify(attributeVisitor).visitUnknownAttribute(isA(Clazz.class), isA(UnknownAttribute.class));
  }
}

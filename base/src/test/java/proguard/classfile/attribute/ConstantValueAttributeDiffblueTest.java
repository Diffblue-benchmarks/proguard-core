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
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class ConstantValueAttributeDiffblueTest {
  /**
   * Test {@link ConstantValueAttribute#ConstantValueAttribute()}.
   *
   * <p>Method under test: {@link ConstantValueAttribute#ConstantValueAttribute()}
   */
  @Test
  @DisplayName("Test new ConstantValueAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ConstantValueAttribute.<init>()",
    "void proguard.classfile.attribute.ConstantValueAttribute.<init>(int, int)"
  })
  void testNewConstantValueAttribute() {
    // Arrange and Act
    ConstantValueAttribute actualConstantValueAttribute = new ConstantValueAttribute();

    // Assert
    assertNull(actualConstantValueAttribute.getProcessingInfo());
    assertEquals(0, actualConstantValueAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ConstantValueAttribute#ConstantValueAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantValueAttribute#ConstantValueAttribute(int, int)}
   */
  @Test
  @DisplayName("Test new ConstantValueAttribute(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ConstantValueAttribute.<init>()",
    "void proguard.classfile.attribute.ConstantValueAttribute.<init>(int, int)"
  })
  void testNewConstantValueAttribute_whenOne() {
    // Arrange and Act
    ConstantValueAttribute actualConstantValueAttribute = new ConstantValueAttribute(1, 1);

    // Assert
    assertNull(actualConstantValueAttribute.getProcessingInfo());
    assertEquals(0, actualConstantValueAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ConstantValueAttribute#accept(Clazz, Field, AttributeVisitor)} with {@code clazz},
   * {@code field}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitConstantValueAttribute(Clazz, Field,
   *       ConstantValueAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantValueAttribute#accept(Clazz, Field, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, AttributeVisitor) with 'clazz', 'field', 'attributeVisitor'; then calls visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ConstantValueAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzFieldAttributeVisitor_thenCallsVisitConstantValueAttribute() {
    // Arrange
    ConstantValueAttribute constantValueAttribute = new ConstantValueAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitConstantValueAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<ConstantValueAttribute>any());

    // Act
    constantValueAttribute.accept(clazz, field, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitConstantValueAttribute(
            isA(Clazz.class), isA(Field.class), isA(ConstantValueAttribute.class));
  }
}

package proguard.classfile.attribute.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;

class AttributeVisitorDiffblueTest {
  /**
   * Test {@link AttributeVisitor#visitAnyAttribute(Clazz, Attribute)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeVisitor#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  @DisplayName("Test visitAnyAttribute(Clazz, Attribute); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttributeVisitor.visitAnyAttribute(Clazz, Attribute)"})
  void testVisitAnyAttribute_thenThrowUnsupportedOperationException() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> multiAttributeVisitor.visitAnyAttribute(clazz, new BootstrapMethodsAttribute()));
  }

  /**
   * Test {@link AttributeVisitor#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link AttributeVisitor#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttributeVisitor.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  void testVisitCodeAttribute() {
    // Arrange
    AttributeCounter attributeCounter = new AttributeCounter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeCounter.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    assertEquals(1, attributeCounter.getCount());
  }
}

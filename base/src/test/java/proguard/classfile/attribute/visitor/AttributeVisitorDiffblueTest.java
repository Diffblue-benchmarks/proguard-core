package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;

public class AttributeVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link AttributeVisitor#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  public void testVisitAnyAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> multiAttributeVisitor.visitAnyAttribute(clazz, new BootstrapMethodsAttribute()));
  }

  /**
   * Method under test:
   * {@link AttributeVisitor#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute() {
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

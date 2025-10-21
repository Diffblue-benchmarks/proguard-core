package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;

public class AttributeVisitorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeVisitor.visitAnyAttribute(Clazz, Attribute)"})
  public void testVisitAnyAttribute_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeVisitor.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
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

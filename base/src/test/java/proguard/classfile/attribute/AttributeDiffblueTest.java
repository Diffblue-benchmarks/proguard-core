package proguard.classfile.attribute;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.visitor.AttributeVisitor;

public class AttributeDiffblueTest {
  /**
   * Method under test: {@link Attribute#accept(Clazz, Field, AttributeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> bootstrapMethodsAttribute.accept(clazz, field, new DominatorCalculator(true)));
  }

  /**
   * Method under test:
   * {@link Attribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> bootstrapMethodsAttribute.accept(clazz, method, codeAttribute, new DominatorCalculator(true)));
  }

  /**
   * Method under test:
   * {@link Attribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> bootstrapMethodsAttribute.accept(clazz, method, null, new DominatorCalculator(true)));
  }

  /**
   * Method under test: {@link Attribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> bootstrapMethodsAttribute.accept(clazz, method, new DominatorCalculator(true)));
  }

  /**
   * Method under test:
   * {@link Attribute#accept(Clazz, RecordComponentInfo, AttributeVisitor)}
   */
  @Test
  public void testAccept5() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> bootstrapMethodsAttribute.accept(clazz, recordComponentInfo, new DominatorCalculator(true)));
  }

  /**
   * Method under test: {@link Attribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  public void testAccept6() {
    // Arrange
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> codeAttribute.accept(clazz, new DominatorCalculator(true)));
  }
}

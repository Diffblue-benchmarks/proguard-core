package proguard.classfile.attribute;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Attribute.accept(Clazz, AttributeVisitor)"})
  public void testAcceptWithClazzAttributeVisitor_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Attribute.accept(Clazz, Field, AttributeVisitor)"})
  public void testAcceptWithClazzFieldAttributeVisitor_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Attribute.accept(Clazz, Method, AttributeVisitor)"})
  public void testAcceptWithClazzMethodAttributeVisitor_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Attribute.accept(Clazz, Method, CodeAttribute, AttributeVisitor)"})
  public void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Attribute.accept(Clazz, Method, CodeAttribute, AttributeVisitor)"})
  public void testAcceptWithClazzMethodCodeAttributeAttributeVisitor2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Attribute.accept(Clazz, RecordComponentInfo, AttributeVisitor)"})
  public void testAcceptWithClazzRecordComponentInfoAttributeVisitor() {
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

package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor;
import proguard.classfile.editor.CodeAttributeComposer;

public class TargetInfoDiffblueTest {
  /**
   * Test {@link TargetInfo#getTargetType()}.
   *
   * <p>Method under test: {@link TargetInfo#getTargetType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte TargetInfo.getTargetType()"})
  public void testGetTargetType() {
    // Arrange, Act and Assert
    assertEquals('A', (new CatchTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link TargetInfo#accept(Clazz, Field, TypeAnnotation, TargetInfoVisitor)} with {@code
   * clazz}, {@code field}, {@code typeAnnotation}, {@code targetInfoVisitor}.
   *
   * <p>Method under test: {@link TargetInfo#accept(Clazz, Field, TypeAnnotation,
   * TargetInfoVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TargetInfo.accept(Clazz, Field, TypeAnnotation, TargetInfoVisitor)"})
  public void testAcceptWithClazzFieldTypeAnnotationTargetInfoVisitor() {
    // Arrange
    CatchTargetInfo catchTargetInfo = new CatchTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> catchTargetInfo.accept(clazz, field, typeAnnotation, new CodeAttributeComposer()));
  }

  /**
   * Test {@link TargetInfo#accept(Clazz, Method, CodeAttribute, TypeAnnotation, TargetInfoVisitor)}
   * with {@code clazz}, {@code method}, {@code codeAttribute}, {@code typeAnnotation}, {@code
   * targetInfoVisitor}.
   *
   * <p>Method under test: {@link TargetInfo#accept(Clazz, Method, CodeAttribute, TypeAnnotation,
   * TargetInfoVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TargetInfo.accept(Clazz, Method, CodeAttribute, TypeAnnotation, TargetInfoVisitor)"
  })
  public void testAcceptWithClazzMethodCodeAttributeTypeAnnotationTargetInfoVisitor() {
    // Arrange
    EmptyTargetInfo emptyTargetInfo = new EmptyTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            emptyTargetInfo.accept(
                clazz, method, codeAttribute, typeAnnotation, new CodeAttributeComposer()));
  }

  /**
   * Test {@link TargetInfo#accept(Clazz, Method, TypeAnnotation, TargetInfoVisitor)} with {@code
   * clazz}, {@code method}, {@code typeAnnotation}, {@code targetInfoVisitor}.
   *
   * <p>Method under test: {@link TargetInfo#accept(Clazz, Method, TypeAnnotation,
   * TargetInfoVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TargetInfo.accept(Clazz, Method, TypeAnnotation, TargetInfoVisitor)"})
  public void testAcceptWithClazzMethodTypeAnnotationTargetInfoVisitor() {
    // Arrange
    CatchTargetInfo catchTargetInfo = new CatchTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> catchTargetInfo.accept(clazz, method, typeAnnotation, new CodeAttributeComposer()));
  }
}

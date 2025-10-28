package proguard.classfile.attribute.annotation.target;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
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
   * Method under test: {@link TargetInfo#getTargetType()}
   */
  @Test
  public void testGetTargetType() {
    // Arrange, Act and Assert
    assertEquals('A', (new CatchTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Method under test:
   * {@link TargetInfo#accept(Clazz, Field, TypeAnnotation, TargetInfoVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    CatchTargetInfo catchTargetInfo = new CatchTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> catchTargetInfo.accept(clazz, field, typeAnnotation, new CodeAttributeComposer()));
  }

  /**
   * Method under test:
   * {@link TargetInfo#accept(Clazz, Method, TypeAnnotation, TargetInfoVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    CatchTargetInfo catchTargetInfo = new CatchTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> catchTargetInfo.accept(clazz, method, typeAnnotation, new CodeAttributeComposer()));
  }

  /**
   * Method under test:
   * {@link TargetInfo#accept(Clazz, Method, CodeAttribute, TypeAnnotation, TargetInfoVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    EmptyTargetInfo emptyTargetInfo = new EmptyTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> emptyTargetInfo.accept(clazz, method, codeAttribute, typeAnnotation, new CodeAttributeComposer()));
  }
}

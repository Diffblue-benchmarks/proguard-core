package proguard.classfile.attribute.annotation.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.editor.ConstantPoolRemapper;

public class ElementValueVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link ElementValueVisitor#visitAnyElementValue(Clazz, Annotation, ElementValue)}
   */
  @Test
  public void testVisitAnyElementValue() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> constantPoolRemapper.visitAnyElementValue(clazz, annotation, new AnnotationElementValue()));
  }
}

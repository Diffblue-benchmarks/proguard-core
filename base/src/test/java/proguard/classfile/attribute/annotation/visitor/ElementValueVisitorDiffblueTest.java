package proguard.classfile.attribute.annotation.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.editor.ConstantPoolRemapper;

public class ElementValueVisitorDiffblueTest {
  /**
   * Test {@link ElementValueVisitor#visitAnyElementValue(Clazz, Annotation, ElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValueVisitor#visitAnyElementValue(Clazz, Annotation,
   * ElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ElementValueVisitor.visitAnyElementValue(Clazz, Annotation, ElementValue)"
  })
  public void testVisitAnyElementValue_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            constantPoolRemapper.visitAnyElementValue(
                clazz, annotation, new AnnotationElementValue()));
  }
}

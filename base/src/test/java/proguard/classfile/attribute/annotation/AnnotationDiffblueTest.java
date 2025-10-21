package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AnnotationDiffblueTest {
  /**
   * Test {@link Annotation#Annotation()}.
   *
   * <p>Method under test: {@link Annotation#Annotation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Annotation.<init>()",
    "void Annotation.<init>(int, int, ElementValue[])"
  })
  public void testNewAnnotation() {
    // Arrange and Act
    Annotation actualAnnotation = new Annotation();

    // Assert
    assertNull(actualAnnotation.getProcessingInfo());
    assertEquals(0, actualAnnotation.getProcessingFlags());
  }

  /**
   * Test {@link Annotation#Annotation(int, int, ElementValue[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link Annotation#Annotation(int, int, ElementValue[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Annotation.<init>()",
    "void Annotation.<init>(int, int, ElementValue[])"
  })
  public void testNewAnnotation_whenOne() {
    // Arrange and Act
    Annotation actualAnnotation =
        new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()});

    // Assert
    assertNull(actualAnnotation.getProcessingInfo());
    assertEquals(0, actualAnnotation.getProcessingFlags());
  }
}

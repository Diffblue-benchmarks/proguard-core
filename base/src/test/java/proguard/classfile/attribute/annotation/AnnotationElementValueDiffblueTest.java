package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AnnotationElementValueDiffblueTest {
  /**
   * Test {@link AnnotationElementValue#AnnotationElementValue()}.
   *
   * <p>Method under test: {@link AnnotationElementValue#AnnotationElementValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AnnotationElementValue.<init>()",
    "void AnnotationElementValue.<init>(int, Annotation)"
  })
  public void testNewAnnotationElementValue() {
    // Arrange and Act
    AnnotationElementValue actualAnnotationElementValue = new AnnotationElementValue();

    // Assert
    assertNull(actualAnnotationElementValue.getProcessingInfo());
    assertEquals(0, actualAnnotationElementValue.getProcessingFlags());
  }

  /**
   * Test {@link AnnotationElementValue#AnnotationElementValue(int, Annotation)}.
   *
   * <ul>
   *   <li>Then return {@link AnnotationElementValue#annotationValue} ProcessingInfo is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationElementValue#AnnotationElementValue(int, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AnnotationElementValue.<init>()",
    "void AnnotationElementValue.<init>(int, Annotation)"
  })
  public void testNewAnnotationElementValue_thenReturnAnnotationValueProcessingInfoIsNull() {
    // Arrange and Act
    AnnotationElementValue actualAnnotationElementValue =
        new AnnotationElementValue(1, new Annotation());

    // Assert
    assertNull(actualAnnotationElementValue.getProcessingInfo());
    Annotation annotation = actualAnnotationElementValue.annotationValue;
    assertNull(annotation.getProcessingInfo());
    assertEquals(0, actualAnnotationElementValue.getProcessingFlags());
    assertEquals(0, annotation.getProcessingFlags());
  }

  /**
   * Test {@link AnnotationElementValue#getTag()}.
   *
   * <p>Method under test: {@link AnnotationElementValue#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char AnnotationElementValue.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ANNOTATION, (new AnnotationElementValue()).getTag());
  }
}

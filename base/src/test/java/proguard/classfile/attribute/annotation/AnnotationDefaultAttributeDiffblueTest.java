package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AnnotationDefaultAttributeDiffblueTest {
  /**
   * Test {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute()}.
   *
   * <p>Method under test: {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AnnotationDefaultAttribute.<init>()",
    "void AnnotationDefaultAttribute.<init>(int, ElementValue)"
  })
  public void testNewAnnotationDefaultAttribute() {
    // Arrange and Act
    AnnotationDefaultAttribute actualAnnotationDefaultAttribute = new AnnotationDefaultAttribute();

    // Assert
    assertNull(actualAnnotationDefaultAttribute.getProcessingInfo());
    assertEquals(0, actualAnnotationDefaultAttribute.getProcessingFlags());
  }

  /**
   * Test {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute(int, ElementValue)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute(int,
   * ElementValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AnnotationDefaultAttribute.<init>()",
    "void AnnotationDefaultAttribute.<init>(int, ElementValue)"
  })
  public void testNewAnnotationDefaultAttribute_whenOne() {
    // Arrange and Act
    AnnotationDefaultAttribute actualAnnotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new AnnotationElementValue());

    // Assert
    assertNull(actualAnnotationDefaultAttribute.getProcessingInfo());
    assertEquals(0, actualAnnotationDefaultAttribute.getProcessingFlags());
  }
}

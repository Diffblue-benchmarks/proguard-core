package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RuntimeInvisibleTypeAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link
   * RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleTypeAnnotationsAttribute.<init>()",
    "void RuntimeInvisibleTypeAnnotationsAttribute.<init>(int, int, TypeAnnotation[])"
  })
  public void testNewRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange and Act
    RuntimeInvisibleTypeAnnotationsAttribute actualRuntimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link
   * RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute(int, int,
   * TypeAnnotation[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute(int, int,
   * TypeAnnotation[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleTypeAnnotationsAttribute.<init>()",
    "void RuntimeInvisibleTypeAnnotationsAttribute.<init>(int, int, TypeAnnotation[])"
  })
  public void testNewRuntimeInvisibleTypeAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeInvisibleTypeAnnotationsAttribute actualRuntimeInvisibleTypeAnnotationsAttribute =
        new RuntimeInvisibleTypeAnnotationsAttribute(
            1, 3, new TypeAnnotation[] {new TypeAnnotation()});

    // Assert
    assertNull(actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingFlags());
  }
}

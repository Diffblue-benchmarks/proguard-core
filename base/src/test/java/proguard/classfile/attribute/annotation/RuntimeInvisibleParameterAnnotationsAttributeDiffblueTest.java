package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RuntimeInvisibleParameterAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link
   * RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleParameterAnnotationsAttribute.<init>()",
    "void RuntimeInvisibleParameterAnnotationsAttribute.<init>(int, int, int[], Annotation[][])"
  })
  public void testNewRuntimeInvisibleParameterAnnotationsAttribute() {
    // Arrange and Act
    RuntimeInvisibleParameterAnnotationsAttribute
        actualRuntimeInvisibleParameterAnnotationsAttribute =
            new RuntimeInvisibleParameterAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link
   * RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute(int,
   * int, int[], Annotation[][])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute(int,
   * int, int[], Annotation[][])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeInvisibleParameterAnnotationsAttribute.<init>()",
    "void RuntimeInvisibleParameterAnnotationsAttribute.<init>(int, int, int[], Annotation[][])"
  })
  public void testNewRuntimeInvisibleParameterAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeInvisibleParameterAnnotationsAttribute
        actualRuntimeInvisibleParameterAnnotationsAttribute =
            new RuntimeInvisibleParameterAnnotationsAttribute(
                1,
                3,
                new int[] {3, 1, 3, 1},
                new Annotation[][] {new Annotation[] {new Annotation()}});

    // Assert
    assertNull(actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingFlags());
  }
}

package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RuntimeVisibleParameterAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link
   * RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleParameterAnnotationsAttribute.<init>()",
    "void RuntimeVisibleParameterAnnotationsAttribute.<init>(int, int, int[], Annotation[][])"
  })
  public void testNewRuntimeVisibleParameterAnnotationsAttribute() {
    // Arrange and Act
    RuntimeVisibleParameterAnnotationsAttribute actualRuntimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link
   * RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute(int,
   * int, int[], Annotation[][])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute(int,
   * int, int[], Annotation[][])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleParameterAnnotationsAttribute.<init>()",
    "void RuntimeVisibleParameterAnnotationsAttribute.<init>(int, int, int[], Annotation[][])"
  })
  public void testNewRuntimeVisibleParameterAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeVisibleParameterAnnotationsAttribute actualRuntimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute(
            1, 3, new int[] {3, 1, 3, 1}, new Annotation[][] {new Annotation[] {new Annotation()}});

    // Assert
    assertNull(actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingFlags());
  }
}

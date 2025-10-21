package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RuntimeVisibleTypeAnnotationsAttributeDiffblueTest {
  /**
   * Test {@link RuntimeVisibleTypeAnnotationsAttribute#RuntimeVisibleTypeAnnotationsAttribute()}.
   *
   * <p>Method under test: {@link
   * RuntimeVisibleTypeAnnotationsAttribute#RuntimeVisibleTypeAnnotationsAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleTypeAnnotationsAttribute.<init>()",
    "void RuntimeVisibleTypeAnnotationsAttribute.<init>(int, int, TypeAnnotation[])"
  })
  public void testNewRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange and Act
    RuntimeVisibleTypeAnnotationsAttribute actualRuntimeVisibleTypeAnnotationsAttribute =
        new RuntimeVisibleTypeAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeVisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleTypeAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link RuntimeVisibleTypeAnnotationsAttribute#RuntimeVisibleTypeAnnotationsAttribute(int,
   * int, TypeAnnotation[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuntimeVisibleTypeAnnotationsAttribute#RuntimeVisibleTypeAnnotationsAttribute(int, int,
   * TypeAnnotation[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeVisibleTypeAnnotationsAttribute.<init>()",
    "void RuntimeVisibleTypeAnnotationsAttribute.<init>(int, int, TypeAnnotation[])"
  })
  public void testNewRuntimeVisibleTypeAnnotationsAttribute_whenOne() {
    // Arrange and Act
    RuntimeVisibleTypeAnnotationsAttribute actualRuntimeVisibleTypeAnnotationsAttribute =
        new RuntimeVisibleTypeAnnotationsAttribute(
            1, 3, new TypeAnnotation[] {new TypeAnnotation()});

    // Assert
    assertNull(actualRuntimeVisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleTypeAnnotationsAttribute.getProcessingFlags());
  }
}

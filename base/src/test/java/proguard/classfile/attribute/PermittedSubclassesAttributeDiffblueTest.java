package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PermittedSubclassesAttributeDiffblueTest {
  /**
   * Test {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute()}.
   *
   * <p>Method under test: {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PermittedSubclassesAttribute.<init>()",
    "void PermittedSubclassesAttribute.<init>(int, int, int[])"
  })
  public void testNewPermittedSubclassesAttribute() {
    // Arrange and Act
    PermittedSubclassesAttribute actualPermittedSubclassesAttribute =
        new PermittedSubclassesAttribute();

    // Assert
    assertNull(actualPermittedSubclassesAttribute.getProcessingInfo());
    assertEquals(0, actualPermittedSubclassesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute(int,
   * int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PermittedSubclassesAttribute.<init>()",
    "void PermittedSubclassesAttribute.<init>(int, int, int[])"
  })
  public void testNewPermittedSubclassesAttribute_whenOne() {
    // Arrange and Act
    PermittedSubclassesAttribute actualPermittedSubclassesAttribute =
        new PermittedSubclassesAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualPermittedSubclassesAttribute.getProcessingInfo());
    assertEquals(0, actualPermittedSubclassesAttribute.getProcessingFlags());
  }
}

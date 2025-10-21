package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InnerClassesAttributeDiffblueTest {
  /**
   * Test {@link InnerClassesAttribute#InnerClassesAttribute()}.
   *
   * <p>Method under test: {@link InnerClassesAttribute#InnerClassesAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InnerClassesAttribute.<init>()",
    "void InnerClassesAttribute.<init>(int, int, InnerClassesInfo[])"
  })
  public void testNewInnerClassesAttribute() {
    // Arrange and Act
    InnerClassesAttribute actualInnerClassesAttribute = new InnerClassesAttribute();

    // Assert
    assertNull(actualInnerClassesAttribute.getProcessingInfo());
    assertEquals(0, actualInnerClassesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link InnerClassesAttribute#InnerClassesAttribute(int, int, InnerClassesInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAttribute#InnerClassesAttribute(int, int,
   * InnerClassesInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InnerClassesAttribute.<init>()",
    "void InnerClassesAttribute.<init>(int, int, InnerClassesInfo[])"
  })
  public void testNewInnerClassesAttribute_whenOne() {
    // Arrange and Act
    InnerClassesAttribute actualInnerClassesAttribute =
        new InnerClassesAttribute(1, 3, new InnerClassesInfo[] {new InnerClassesInfo(1, 1, 1, 1)});

    // Assert
    assertNull(actualInnerClassesAttribute.getProcessingInfo());
    assertEquals(0, actualInnerClassesAttribute.getProcessingFlags());
  }
}

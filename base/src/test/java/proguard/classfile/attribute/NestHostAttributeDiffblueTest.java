package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NestHostAttributeDiffblueTest {
  /**
   * Test {@link NestHostAttribute#NestHostAttribute()}.
   *
   * <p>Method under test: {@link NestHostAttribute#NestHostAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NestHostAttribute.<init>()", "void NestHostAttribute.<init>(int, int)"})
  public void testNewNestHostAttribute() {
    // Arrange and Act
    NestHostAttribute actualNestHostAttribute = new NestHostAttribute();

    // Assert
    assertNull(actualNestHostAttribute.getProcessingInfo());
    assertEquals(0, actualNestHostAttribute.getProcessingFlags());
  }

  /**
   * Test {@link NestHostAttribute#NestHostAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link NestHostAttribute#NestHostAttribute(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NestHostAttribute.<init>()", "void NestHostAttribute.<init>(int, int)"})
  public void testNewNestHostAttribute_whenOne() {
    // Arrange and Act
    NestHostAttribute actualNestHostAttribute = new NestHostAttribute(1, 1);

    // Assert
    assertNull(actualNestHostAttribute.getProcessingInfo());
    assertEquals(0, actualNestHostAttribute.getProcessingFlags());
  }
}

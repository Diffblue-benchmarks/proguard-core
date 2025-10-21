package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NestMembersAttributeDiffblueTest {
  /**
   * Test {@link NestMembersAttribute#NestMembersAttribute()}.
   *
   * <p>Method under test: {@link NestMembersAttribute#NestMembersAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NestMembersAttribute.<init>()",
    "void NestMembersAttribute.<init>(int, int, int[])"
  })
  public void testNewNestMembersAttribute() {
    // Arrange and Act
    NestMembersAttribute actualNestMembersAttribute = new NestMembersAttribute();

    // Assert
    assertNull(actualNestMembersAttribute.getProcessingInfo());
    assertEquals(0, actualNestMembersAttribute.getProcessingFlags());
  }

  /**
   * Test {@link NestMembersAttribute#NestMembersAttribute(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link NestMembersAttribute#NestMembersAttribute(int, int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NestMembersAttribute.<init>()",
    "void NestMembersAttribute.<init>(int, int, int[])"
  })
  public void testNewNestMembersAttribute_whenOne() {
    // Arrange and Act
    NestMembersAttribute actualNestMembersAttribute =
        new NestMembersAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualNestMembersAttribute.getProcessingInfo());
    assertEquals(0, actualNestMembersAttribute.getProcessingFlags());
  }
}

package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocalVariableTableAttributeDiffblueTest {
  /**
   * Test {@link LocalVariableTableAttribute#LocalVariableTableAttribute()}.
   *
   * <p>Method under test: {@link LocalVariableTableAttribute#LocalVariableTableAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTableAttribute.<init>()",
    "void LocalVariableTableAttribute.<init>(int, int, LocalVariableInfo[])"
  })
  public void testNewLocalVariableTableAttribute() {
    // Arrange and Act
    LocalVariableTableAttribute actualLocalVariableTableAttribute =
        new LocalVariableTableAttribute();

    // Assert
    assertNull(actualLocalVariableTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTableAttribute#LocalVariableTableAttribute(int, int,
   * LocalVariableInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTableAttribute#LocalVariableTableAttribute(int, int,
   * LocalVariableInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTableAttribute.<init>()",
    "void LocalVariableTableAttribute.<init>(int, int, LocalVariableInfo[])"
  })
  public void testNewLocalVariableTableAttribute_whenOne() {
    // Arrange and Act
    LocalVariableTableAttribute actualLocalVariableTableAttribute =
        new LocalVariableTableAttribute(
            1, 3, new LocalVariableInfo[] {new LocalVariableInfo(1, 3, 1, 1, 1)});

    // Assert
    assertNull(actualLocalVariableTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTableAttribute.getProcessingFlags());
  }
}

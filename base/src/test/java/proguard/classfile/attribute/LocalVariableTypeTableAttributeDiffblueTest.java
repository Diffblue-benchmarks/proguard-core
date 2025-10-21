package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocalVariableTypeTableAttributeDiffblueTest {
  /**
   * Test {@link LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute()}.
   *
   * <p>Method under test: {@link LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTypeTableAttribute.<init>()",
    "void LocalVariableTypeTableAttribute.<init>(int, int, LocalVariableTypeInfo[])"
  })
  public void testNewLocalVariableTypeTableAttribute() {
    // Arrange and Act
    LocalVariableTypeTableAttribute actualLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute();

    // Assert
    assertNull(actualLocalVariableTypeTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute(int, int,
   * LocalVariableTypeInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute(int, int,
   * LocalVariableTypeInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTypeTableAttribute.<init>()",
    "void LocalVariableTypeTableAttribute.<init>(int, int, LocalVariableTypeInfo[])"
  })
  public void testNewLocalVariableTypeTableAttribute_whenOne() {
    // Arrange and Act
    LocalVariableTypeTableAttribute actualLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(
            1, 3, new LocalVariableTypeInfo[] {new LocalVariableTypeInfo(1, 3, 1, 1, 1)});

    // Assert
    assertNull(actualLocalVariableTypeTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeTableAttribute.getProcessingFlags());
  }
}

package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModuleMainClassAttributeDiffblueTest {
  /**
   * Test {@link ModuleMainClassAttribute#ModuleMainClassAttribute()}.
   *
   * <p>Method under test: {@link ModuleMainClassAttribute#ModuleMainClassAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModuleMainClassAttribute.<init>()",
    "void ModuleMainClassAttribute.<init>(int, int)"
  })
  public void testNewModuleMainClassAttribute() {
    // Arrange and Act
    ModuleMainClassAttribute actualModuleMainClassAttribute = new ModuleMainClassAttribute();

    // Assert
    assertNull(actualModuleMainClassAttribute.getProcessingInfo());
    assertEquals(0, actualModuleMainClassAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModuleMainClassAttribute#ModuleMainClassAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ModuleMainClassAttribute#ModuleMainClassAttribute(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModuleMainClassAttribute.<init>()",
    "void ModuleMainClassAttribute.<init>(int, int)"
  })
  public void testNewModuleMainClassAttribute_whenOne() {
    // Arrange and Act
    ModuleMainClassAttribute actualModuleMainClassAttribute = new ModuleMainClassAttribute(1, 1);

    // Assert
    assertNull(actualModuleMainClassAttribute.getProcessingInfo());
    assertEquals(0, actualModuleMainClassAttribute.getProcessingFlags());
  }
}

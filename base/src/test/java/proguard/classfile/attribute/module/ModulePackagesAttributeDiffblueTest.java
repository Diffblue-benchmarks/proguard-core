package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModulePackagesAttributeDiffblueTest {
  /**
   * Test {@link ModulePackagesAttribute#ModulePackagesAttribute()}.
   *
   * <p>Method under test: {@link ModulePackagesAttribute#ModulePackagesAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModulePackagesAttribute.<init>()",
    "void ModulePackagesAttribute.<init>(int, int, int[])"
  })
  public void testNewModulePackagesAttribute() {
    // Arrange and Act
    ModulePackagesAttribute actualModulePackagesAttribute = new ModulePackagesAttribute();

    // Assert
    assertNull(actualModulePackagesAttribute.getProcessingInfo());
    assertEquals(0, actualModulePackagesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModulePackagesAttribute#ModulePackagesAttribute(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ModulePackagesAttribute#ModulePackagesAttribute(int, int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModulePackagesAttribute.<init>()",
    "void ModulePackagesAttribute.<init>(int, int, int[])"
  })
  public void testNewModulePackagesAttribute_whenOne() {
    // Arrange and Act
    ModulePackagesAttribute actualModulePackagesAttribute =
        new ModulePackagesAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualModulePackagesAttribute.getProcessingInfo());
    assertEquals(0, actualModulePackagesAttribute.getProcessingFlags());
  }
}

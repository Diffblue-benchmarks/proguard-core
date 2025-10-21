package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModuleAttributeDiffblueTest {
  /**
   * Test {@link ModuleAttribute#ModuleAttribute()}.
   *
   * <p>Method under test: {@link ModuleAttribute#ModuleAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModuleAttribute.<init>()",
    "void ModuleAttribute.<init>(int, int, int, int, int, RequiresInfo[], int, ExportsInfo[], int, OpensInfo[], int, int[], int, ProvidesInfo[])"
  })
  public void testNewModuleAttribute() {
    // Arrange and Act
    ModuleAttribute actualModuleAttribute = new ModuleAttribute();

    // Assert
    assertNull(actualModuleAttribute.getProcessingInfo());
    assertEquals(0, actualModuleAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModuleAttribute#ModuleAttribute(int, int, int, int, int, RequiresInfo[], int,
   * ExportsInfo[], int, OpensInfo[], int, int[], int, ProvidesInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ModuleAttribute#ModuleAttribute(int, int, int, int, int,
   * RequiresInfo[], int, ExportsInfo[], int, OpensInfo[], int, int[], int, ProvidesInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModuleAttribute.<init>()",
    "void ModuleAttribute.<init>(int, int, int, int, int, RequiresInfo[], int, ExportsInfo[], int, OpensInfo[], int, int[], int, ProvidesInfo[])"
  })
  public void testNewModuleAttribute_whenOne() {
    // Arrange and Act
    ModuleAttribute actualModuleAttribute =
        new ModuleAttribute(
            1,
            1,
            1,
            1,
            3,
            new RequiresInfo[] {new RequiresInfo(1, 1, 1)},
            3,
            new ExportsInfo[] {new ExportsInfo()},
            3,
            new OpensInfo[] {new OpensInfo()},
            3,
            new int[] {1, 0, 1, 0},
            1,
            new ProvidesInfo[] {new ProvidesInfo()});

    // Assert
    assertNull(actualModuleAttribute.getProcessingInfo());
    assertEquals(0, actualModuleAttribute.getProcessingFlags());
  }
}

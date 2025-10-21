package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BootstrapMethodsAttributeDiffblueTest {
  /**
   * Test {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute()}.
   *
   * <p>Method under test: {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodsAttribute.<init>()",
    "void BootstrapMethodsAttribute.<init>(int, int, BootstrapMethodInfo[])"
  })
  public void testNewBootstrapMethodsAttribute() {
    // Arrange and Act
    BootstrapMethodsAttribute actualBootstrapMethodsAttribute = new BootstrapMethodsAttribute();

    // Assert
    assertNull(actualBootstrapMethodsAttribute.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute(int, int,
   * BootstrapMethodInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute(int, int,
   * BootstrapMethodInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodsAttribute.<init>()",
    "void BootstrapMethodsAttribute.<init>(int, int, BootstrapMethodInfo[])"
  })
  public void testNewBootstrapMethodsAttribute_whenOne() {
    // Arrange and Act
    BootstrapMethodsAttribute actualBootstrapMethodsAttribute =
        new BootstrapMethodsAttribute(1, 3, new BootstrapMethodInfo[] {new BootstrapMethodInfo()});

    // Assert
    assertNull(actualBootstrapMethodsAttribute.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodsAttribute.getProcessingFlags());
  }
}

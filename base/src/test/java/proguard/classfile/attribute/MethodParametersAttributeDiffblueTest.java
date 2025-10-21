package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MethodParametersAttributeDiffblueTest {
  /**
   * Test {@link MethodParametersAttribute#MethodParametersAttribute()}.
   *
   * <p>Method under test: {@link MethodParametersAttribute#MethodParametersAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodParametersAttribute.<init>()",
    "void MethodParametersAttribute.<init>(int, int, ParameterInfo[])"
  })
  public void testNewMethodParametersAttribute() {
    // Arrange and Act
    MethodParametersAttribute actualMethodParametersAttribute = new MethodParametersAttribute();

    // Assert
    assertNull(actualMethodParametersAttribute.getProcessingInfo());
    assertEquals(0, actualMethodParametersAttribute.getProcessingFlags());
  }

  /**
   * Test {@link MethodParametersAttribute#MethodParametersAttribute(int, int, ParameterInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link MethodParametersAttribute#MethodParametersAttribute(int, int,
   * ParameterInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodParametersAttribute.<init>()",
    "void MethodParametersAttribute.<init>(int, int, ParameterInfo[])"
  })
  public void testNewMethodParametersAttribute_whenOne() {
    // Arrange and Act
    MethodParametersAttribute actualMethodParametersAttribute =
        new MethodParametersAttribute(1, 3, new ParameterInfo[] {new ParameterInfo(1, 1)});

    // Assert
    assertNull(actualMethodParametersAttribute.getProcessingInfo());
    assertEquals(0, actualMethodParametersAttribute.getProcessingFlags());
  }
}

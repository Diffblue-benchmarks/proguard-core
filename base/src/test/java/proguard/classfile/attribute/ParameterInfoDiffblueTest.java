package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ParameterInfoDiffblueTest {
  /**
   * Test {@link ParameterInfo#ParameterInfo()}.
   *
   * <p>Method under test: {@link ParameterInfo#ParameterInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ParameterInfo.<init>()", "void ParameterInfo.<init>(int, int)"})
  public void testNewParameterInfo() {
    // Arrange and Act
    ParameterInfo actualParameterInfo = new ParameterInfo();

    // Assert
    assertNull(actualParameterInfo.getProcessingInfo());
    assertEquals(0, actualParameterInfo.getProcessingFlags());
  }

  /**
   * Test {@link ParameterInfo#ParameterInfo(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ParameterInfo#ParameterInfo(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ParameterInfo.<init>()", "void ParameterInfo.<init>(int, int)"})
  public void testNewParameterInfo_whenOne() {
    // Arrange and Act
    ParameterInfo actualParameterInfo = new ParameterInfo(1, 1);

    // Assert
    assertNull(actualParameterInfo.getProcessingInfo());
    assertEquals(0, actualParameterInfo.getProcessingFlags());
  }
}

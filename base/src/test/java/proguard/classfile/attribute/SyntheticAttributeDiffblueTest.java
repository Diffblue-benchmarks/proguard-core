package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SyntheticAttributeDiffblueTest {
  /**
   * Test {@link SyntheticAttribute#SyntheticAttribute()}.
   *
   * <p>Method under test: {@link SyntheticAttribute#SyntheticAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyntheticAttribute.<init>()", "void SyntheticAttribute.<init>(int)"})
  public void testNewSyntheticAttribute() {
    // Arrange and Act
    SyntheticAttribute actualSyntheticAttribute = new SyntheticAttribute();

    // Assert
    assertNull(actualSyntheticAttribute.getProcessingInfo());
    assertEquals(0, actualSyntheticAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SyntheticAttribute#SyntheticAttribute(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SyntheticAttribute#SyntheticAttribute(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyntheticAttribute.<init>()", "void SyntheticAttribute.<init>(int)"})
  public void testNewSyntheticAttribute_whenOne() {
    // Arrange and Act
    SyntheticAttribute actualSyntheticAttribute = new SyntheticAttribute(1);

    // Assert
    assertNull(actualSyntheticAttribute.getProcessingInfo());
    assertEquals(0, actualSyntheticAttribute.getProcessingFlags());
  }
}

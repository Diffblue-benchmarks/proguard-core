package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassElementValueDiffblueTest {
  /**
   * Test {@link ClassElementValue#ClassElementValue()}.
   *
   * <p>Method under test: {@link ClassElementValue#ClassElementValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementValue.<init>()", "void ClassElementValue.<init>(int, int)"})
  public void testNewClassElementValue() {
    // Arrange and Act
    ClassElementValue actualClassElementValue = new ClassElementValue();

    // Assert
    assertNull(actualClassElementValue.getProcessingInfo());
    assertEquals(0, actualClassElementValue.getProcessingFlags());
  }

  /**
   * Test {@link ClassElementValue#ClassElementValue(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementValue#ClassElementValue(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementValue.<init>()", "void ClassElementValue.<init>(int, int)"})
  public void testNewClassElementValue_whenOne() {
    // Arrange and Act
    ClassElementValue actualClassElementValue = new ClassElementValue(1, 1);

    // Assert
    assertNull(actualClassElementValue.getProcessingInfo());
    assertEquals(0, actualClassElementValue.getProcessingFlags());
  }

  /**
   * Test {@link ClassElementValue#getTag()}.
   *
   * <p>Method under test: {@link ClassElementValue#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char ClassElementValue.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_CLASS, (new ClassElementValue(1, 1)).getTag());
  }
}

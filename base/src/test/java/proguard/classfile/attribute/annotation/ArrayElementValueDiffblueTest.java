package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ArrayElementValueDiffblueTest {
  /**
   * Test {@link ArrayElementValue#ArrayElementValue()}.
   *
   * <p>Method under test: {@link ArrayElementValue#ArrayElementValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ArrayElementValue.<init>()",
    "void ArrayElementValue.<init>(int, int, ElementValue[])"
  })
  public void testNewArrayElementValue() {
    // Arrange and Act
    ArrayElementValue actualArrayElementValue = new ArrayElementValue();

    // Assert
    assertNull(actualArrayElementValue.getProcessingInfo());
    assertEquals(0, actualArrayElementValue.getProcessingFlags());
  }

  /**
   * Test {@link ArrayElementValue#ArrayElementValue(int, int, ElementValue[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayElementValue#ArrayElementValue(int, int, ElementValue[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ArrayElementValue.<init>()",
    "void ArrayElementValue.<init>(int, int, ElementValue[])"
  })
  public void testNewArrayElementValue_whenOne() {
    // Arrange and Act
    ArrayElementValue actualArrayElementValue =
        new ArrayElementValue(1, 3, new ElementValue[] {new AnnotationElementValue()});

    // Assert
    assertNull(actualArrayElementValue.getProcessingInfo());
    assertEquals(0, actualArrayElementValue.getProcessingFlags());
  }

  /**
   * Test {@link ArrayElementValue#getTag()}.
   *
   * <p>Method under test: {@link ArrayElementValue#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char ArrayElementValue.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ARRAY, (new ArrayElementValue()).getTag());
  }
}

package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EnumConstantElementValueDiffblueTest {
  /**
   * Test {@link EnumConstantElementValue#EnumConstantElementValue()}.
   *
   * <p>Method under test: {@link EnumConstantElementValue#EnumConstantElementValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void EnumConstantElementValue.<init>()",
    "void EnumConstantElementValue.<init>(int, int, int)"
  })
  public void testNewEnumConstantElementValue() {
    // Arrange and Act
    EnumConstantElementValue actualEnumConstantElementValue = new EnumConstantElementValue();

    // Assert
    assertNull(actualEnumConstantElementValue.getProcessingInfo());
    assertEquals(0, actualEnumConstantElementValue.getProcessingFlags());
  }

  /**
   * Test {@link EnumConstantElementValue#EnumConstantElementValue(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link EnumConstantElementValue#EnumConstantElementValue(int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void EnumConstantElementValue.<init>()",
    "void EnumConstantElementValue.<init>(int, int, int)"
  })
  public void testNewEnumConstantElementValue_whenOne() {
    // Arrange and Act
    EnumConstantElementValue actualEnumConstantElementValue = new EnumConstantElementValue(1, 1, 1);

    // Assert
    assertNull(actualEnumConstantElementValue.getProcessingInfo());
    assertEquals(0, actualEnumConstantElementValue.getProcessingFlags());
  }

  /**
   * Test {@link EnumConstantElementValue#getTag()}.
   *
   * <p>Method under test: {@link EnumConstantElementValue#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char EnumConstantElementValue.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ENUM_CONSTANT, (new EnumConstantElementValue(1, 1, 1)).getTag());
  }
}

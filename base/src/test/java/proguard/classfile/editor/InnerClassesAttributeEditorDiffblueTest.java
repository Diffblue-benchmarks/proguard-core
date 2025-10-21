package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.InnerClassesInfo;

public class InnerClassesAttributeEditorDiffblueTest {
  /**
   * Test {@link InnerClassesAttributeEditor#addInnerClassesInfo(InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAttributeEditor#addInnerClassesInfo(InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InnerClassesAttributeEditor.addInnerClassesInfo(InnerClassesInfo)"})
  public void testAddInnerClassesInfo_thenReturnThree() {
    // Arrange
    InnerClassesAttributeEditor innerClassesAttributeEditor =
        new InnerClassesAttributeEditor(
            new InnerClassesAttribute(
                1, 3, new InnerClassesInfo[] {new InnerClassesInfo(1, 1, 1, 1)}));

    // Act and Assert
    assertEquals(
        3, innerClassesAttributeEditor.addInnerClassesInfo(new InnerClassesInfo(1, 1, 1, 1)));
  }

  /**
   * Test {@link InnerClassesAttributeEditor#addInnerClassesInfo(InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAttributeEditor#addInnerClassesInfo(InnerClassesInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InnerClassesAttributeEditor.addInnerClassesInfo(InnerClassesInfo)"})
  public void testAddInnerClassesInfo_thenReturnZero() {
    // Arrange
    InnerClassesAttributeEditor innerClassesAttributeEditor =
        new InnerClassesAttributeEditor(
            new InnerClassesAttribute(
                1, 0, new InnerClassesInfo[] {new InnerClassesInfo(1, 1, 1, 1)}));

    // Act and Assert
    assertEquals(
        0, innerClassesAttributeEditor.addInnerClassesInfo(new InnerClassesInfo(1, 1, 1, 1)));
  }
}

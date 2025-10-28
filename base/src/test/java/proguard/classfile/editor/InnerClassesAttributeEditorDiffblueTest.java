package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.InnerClassesInfo;

public class InnerClassesAttributeEditorDiffblueTest {
  /**
   * Method under test:
   * {@link InnerClassesAttributeEditor#addInnerClassesInfo(InnerClassesInfo)}
   */
  @Test
  public void testAddInnerClassesInfo() {
    // Arrange
    InnerClassesAttributeEditor innerClassesAttributeEditor = new InnerClassesAttributeEditor(
        new InnerClassesAttribute(1, 3, new InnerClassesInfo[]{new InnerClassesInfo(1, 1, 1, 1)}));

    // Act and Assert
    assertEquals(3, innerClassesAttributeEditor.addInnerClassesInfo(new InnerClassesInfo(1, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link InnerClassesAttributeEditor#addInnerClassesInfo(InnerClassesInfo)}
   */
  @Test
  public void testAddInnerClassesInfo2() {
    // Arrange
    InnerClassesAttributeEditor innerClassesAttributeEditor = new InnerClassesAttributeEditor(
        new InnerClassesAttribute(1, 0, new InnerClassesInfo[]{new InnerClassesInfo(1, 1, 1, 1)}));

    // Act and Assert
    assertEquals(0, innerClassesAttributeEditor.addInnerClassesInfo(new InnerClassesInfo(1, 1, 1, 1)));
  }
}

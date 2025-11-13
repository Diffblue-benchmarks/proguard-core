package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.InnerClassesInfo;

class InnerClassesAttributeEditorDiffblueTest {
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
  @DisplayName("Test addInnerClassesInfo(InnerClassesInfo); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InnerClassesAttributeEditor.addInnerClassesInfo(InnerClassesInfo)"})
  void testAddInnerClassesInfo_thenReturnThree() {
    // Arrange
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);
    InnerClassesInfo[] classes = new InnerClassesInfo[] {innerClassesInfo};
    InnerClassesAttributeEditor innerClassesAttributeEditor =
        new InnerClassesAttributeEditor(new InnerClassesAttribute(1, 3, classes));
    InnerClassesInfo innerClassesInfo2 = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    int actualAddInnerClassesInfoResult =
        innerClassesAttributeEditor.addInnerClassesInfo(innerClassesInfo2);

    // Assert
    assertEquals(3, actualAddInnerClassesInfoResult);
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
  @DisplayName("Test addInnerClassesInfo(InnerClassesInfo); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InnerClassesAttributeEditor.addInnerClassesInfo(InnerClassesInfo)"})
  void testAddInnerClassesInfo_thenReturnZero() {
    // Arrange
    InnerClassesInfo innerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);
    InnerClassesInfo[] classes = new InnerClassesInfo[] {innerClassesInfo};
    InnerClassesAttributeEditor innerClassesAttributeEditor =
        new InnerClassesAttributeEditor(new InnerClassesAttribute(1, 0, classes));
    InnerClassesInfo innerClassesInfo2 = new InnerClassesInfo(1, 1, 1, 1);

    // Act
    int actualAddInnerClassesInfoResult =
        innerClassesAttributeEditor.addInnerClassesInfo(innerClassesInfo2);

    // Assert
    assertEquals(0, actualAddInnerClassesInfoResult);
  }
}

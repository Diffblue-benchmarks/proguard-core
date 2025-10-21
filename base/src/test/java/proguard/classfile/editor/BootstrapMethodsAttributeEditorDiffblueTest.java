package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class BootstrapMethodsAttributeEditorDiffblueTest {
  /**
   * Test {@link BootstrapMethodsAttributeEditor#addBootstrapMethodInfo(BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link
   * BootstrapMethodsAttributeEditor#addBootstrapMethodInfo(BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int BootstrapMethodsAttributeEditor.addBootstrapMethodInfo(BootstrapMethodInfo)"
  })
  public void testAddBootstrapMethodInfo_thenReturnThree() {
    // Arrange
    BootstrapMethodsAttributeEditor bootstrapMethodsAttributeEditor =
        new BootstrapMethodsAttributeEditor(
            new BootstrapMethodsAttribute(
                1, 3, new BootstrapMethodInfo[] {new BootstrapMethodInfo()}));

    // Act and Assert
    assertEquals(
        3, bootstrapMethodsAttributeEditor.addBootstrapMethodInfo(new BootstrapMethodInfo()));
  }

  /**
   * Test {@link BootstrapMethodsAttributeEditor#addBootstrapMethodInfo(BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * BootstrapMethodsAttributeEditor#addBootstrapMethodInfo(BootstrapMethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int BootstrapMethodsAttributeEditor.addBootstrapMethodInfo(BootstrapMethodInfo)"
  })
  public void testAddBootstrapMethodInfo_thenReturnZero() {
    // Arrange
    BootstrapMethodsAttributeEditor bootstrapMethodsAttributeEditor =
        new BootstrapMethodsAttributeEditor(
            new BootstrapMethodsAttribute(
                1, 0, new BootstrapMethodInfo[] {new BootstrapMethodInfo()}));

    // Act and Assert
    assertEquals(
        0, bootstrapMethodsAttributeEditor.addBootstrapMethodInfo(new BootstrapMethodInfo()));
  }
}

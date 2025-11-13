package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

class BootstrapMethodsAttributeEditorDiffblueTest {
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
  @DisplayName("Test addBootstrapMethodInfo(BootstrapMethodInfo); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BootstrapMethodsAttributeEditor.addBootstrapMethodInfo(BootstrapMethodInfo)"
  })
  void testAddBootstrapMethodInfo_thenReturnThree() {
    // Arrange
    BootstrapMethodInfo[] bootstrapMethods = new BootstrapMethodInfo[] {new BootstrapMethodInfo()};
    BootstrapMethodsAttributeEditor bootstrapMethodsAttributeEditor =
        new BootstrapMethodsAttributeEditor(new BootstrapMethodsAttribute(1, 3, bootstrapMethods));

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
  @DisplayName("Test addBootstrapMethodInfo(BootstrapMethodInfo); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BootstrapMethodsAttributeEditor.addBootstrapMethodInfo(BootstrapMethodInfo)"
  })
  void testAddBootstrapMethodInfo_thenReturnZero() {
    // Arrange
    BootstrapMethodInfo[] bootstrapMethods = new BootstrapMethodInfo[] {new BootstrapMethodInfo()};
    BootstrapMethodsAttributeEditor bootstrapMethodsAttributeEditor =
        new BootstrapMethodsAttributeEditor(new BootstrapMethodsAttribute(1, 0, bootstrapMethods));

    // Act and Assert
    assertEquals(
        0, bootstrapMethodsAttributeEditor.addBootstrapMethodInfo(new BootstrapMethodInfo()));
  }
}

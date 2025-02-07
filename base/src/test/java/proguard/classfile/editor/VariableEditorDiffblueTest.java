package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VariableEditorDiffblueTest {
  /**
   * Test {@link VariableEditor#isDeleted(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableEditor} (default constructor) deleteVariable one.
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VariableEditor#isDeleted(int)}
   */
  @Test
  @DisplayName(
      "Test isDeleted(int); given VariableEditor (default constructor) deleteVariable one; when one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.editor.VariableEditor.isDeleted(int)"})
  void testIsDeleted_givenVariableEditorDeleteVariableOne_whenOne_thenReturnTrue() {
    // Arrange
    VariableEditor variableEditor = new VariableEditor();
    variableEditor.deleteVariable(1);

    // Act and Assert
    assertTrue(variableEditor.isDeleted(1));
  }

  /**
   * Test {@link VariableEditor#isDeleted(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableEditor} (default constructor).
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableEditor#isDeleted(int)}
   */
  @Test
  @DisplayName(
      "Test isDeleted(int); given VariableEditor (default constructor); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.editor.VariableEditor.isDeleted(int)"})
  void testIsDeleted_givenVariableEditor_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new VariableEditor()).isDeleted(1));
  }

  /**
   * Test new {@link VariableEditor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link VariableEditor}
   */
  @Test
  @DisplayName("Test new VariableEditor (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.VariableEditor.<init>()"})
  void testNewVariableEditor() {
    // Arrange, Act and Assert
    assertFalse((new VariableEditor()).isDeleted(1));
  }
}

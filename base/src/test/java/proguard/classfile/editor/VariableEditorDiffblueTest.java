package proguard.classfile.editor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VariableEditorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableEditor.isDeleted(int)"})
  public void testIsDeleted_givenVariableEditorDeleteVariableOne_whenOne_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VariableEditor.isDeleted(int)"})
  public void testIsDeleted_givenVariableEditor_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new VariableEditor()).isDeleted(1));
  }

  /**
   * Test new {@link VariableEditor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link VariableEditor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableEditor.<init>()"})
  public void testNewVariableEditor() {
    // Arrange, Act and Assert
    assertFalse((new VariableEditor()).isDeleted(1));
  }
}

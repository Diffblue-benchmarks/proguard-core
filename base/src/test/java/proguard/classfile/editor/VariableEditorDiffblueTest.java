package proguard.classfile.editor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class VariableEditorDiffblueTest {
  /**
   * Method under test: {@link VariableEditor#isDeleted(int)}
   */
  @Test
  public void testIsDeleted() {
    // Arrange, Act and Assert
    assertFalse((new VariableEditor()).isDeleted(1));
  }

  /**
   * Method under test: {@link VariableEditor#isDeleted(int)}
   */
  @Test
  public void testIsDeleted2() {
    // Arrange
    VariableEditor variableEditor = new VariableEditor();
    variableEditor.deleteVariable(1);

    // Act and Assert
    assertTrue(variableEditor.isDeleted(1));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link VariableEditor}
   */
  @Test
  public void testNewVariableEditor() {
    // Arrange, Act and Assert
    assertFalse((new VariableEditor()).isDeleted(1));
  }
}

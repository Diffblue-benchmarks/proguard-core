package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class BootstrapMethodsAttributeEditorDiffblueTest {
  /**
   * Method under test:
   * {@link BootstrapMethodsAttributeEditor#addBootstrapMethodInfo(BootstrapMethodInfo)}
   */
  @Test
  public void testAddBootstrapMethodInfo() {
    // Arrange
    BootstrapMethodsAttributeEditor bootstrapMethodsAttributeEditor = new BootstrapMethodsAttributeEditor(
        new BootstrapMethodsAttribute(1, 3, new BootstrapMethodInfo[]{new BootstrapMethodInfo()}));

    // Act and Assert
    assertEquals(3, bootstrapMethodsAttributeEditor.addBootstrapMethodInfo(new BootstrapMethodInfo()));
  }

  /**
   * Method under test:
   * {@link BootstrapMethodsAttributeEditor#addBootstrapMethodInfo(BootstrapMethodInfo)}
   */
  @Test
  public void testAddBootstrapMethodInfo2() {
    // Arrange
    BootstrapMethodsAttributeEditor bootstrapMethodsAttributeEditor = new BootstrapMethodsAttributeEditor(
        new BootstrapMethodsAttribute(1, 0, new BootstrapMethodInfo[]{new BootstrapMethodInfo()}));

    // Act and Assert
    assertEquals(0, bootstrapMethodsAttributeEditor.addBootstrapMethodInfo(new BootstrapMethodInfo()));
  }
}

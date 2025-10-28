package proguard.classfile.editor;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.attribute.CodeAttribute;

public class AttributesEditorDiffblueTest {
  /**
   * Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  public void testFindAttribute() {
    // Arrange, Act and Assert
    assertNull((new AttributesEditor(new ProgramClass(), true)).findAttribute("Attribute Name"));
  }

  /**
   * Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  public void testFindAttribute2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertNull((new AttributesEditor(targetClass, new ProgramField(), true)).findAttribute("Attribute Name"));
  }

  /**
   * Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  public void testFindAttribute3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ProgramField targetMember = new ProgramField();

    // Act and Assert
    assertNull(
        (new AttributesEditor(targetClass, targetMember, new CodeAttribute(1), true)).findAttribute("Attribute Name"));
  }
}

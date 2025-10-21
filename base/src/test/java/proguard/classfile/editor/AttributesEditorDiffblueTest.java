package proguard.classfile.editor;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.attribute.CodeAttribute;

public class AttributesEditorDiffblueTest {
  /**
   * Test {@link AttributesEditor#findAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.attribute.Attribute AttributesEditor.findAttribute(String)"
  })
  public void testFindAttributeWithAttributeName() {
    // Arrange, Act and Assert
    assertNull((new AttributesEditor(new ProgramClass(), true)).findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#findAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.attribute.Attribute AttributesEditor.findAttribute(String)"
  })
  public void testFindAttributeWithAttributeName2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertNull(
        (new AttributesEditor(targetClass, new ProgramField(), true))
            .findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#findAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.attribute.Attribute AttributesEditor.findAttribute(String)"
  })
  public void testFindAttributeWithAttributeName3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ProgramField targetMember = new ProgramField();

    // Act and Assert
    assertNull(
        (new AttributesEditor(targetClass, targetMember, new CodeAttribute(1), true))
            .findAttribute("Attribute Name"));
  }
}

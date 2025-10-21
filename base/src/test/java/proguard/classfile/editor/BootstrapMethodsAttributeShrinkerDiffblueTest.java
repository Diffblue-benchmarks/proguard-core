package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class BootstrapMethodsAttributeShrinkerDiffblueTest {
  /**
   * Test {@link BootstrapMethodsAttributeShrinker#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BootstrapMethodsAttributeShrinker#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodsAttributeShrinker.visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)"
  })
  public void testVisitBootstrapMethodsAttribute_whenProgramClass_thenFirstElementIsNull() {
    // Arrange
    BootstrapMethodsAttributeShrinker bootstrapMethodsAttributeShrinker =
        new BootstrapMethodsAttributeShrinker();
    ProgramClass clazz = new ProgramClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute =
        new BootstrapMethodsAttribute(1, 1, new BootstrapMethodInfo[] {new BootstrapMethodInfo()});

    // Act
    bootstrapMethodsAttributeShrinker.visitBootstrapMethodsAttribute(
        clazz, bootstrapMethodsAttribute);

    // Assert
    BootstrapMethodInfo[] bootstrapMethodInfoArray = bootstrapMethodsAttribute.bootstrapMethods;
    assertNull(bootstrapMethodInfoArray[0]);
    assertEquals(0, bootstrapMethodsAttribute.u2bootstrapMethodsCount);
    assertEquals(1, bootstrapMethodInfoArray.length);
  }
}

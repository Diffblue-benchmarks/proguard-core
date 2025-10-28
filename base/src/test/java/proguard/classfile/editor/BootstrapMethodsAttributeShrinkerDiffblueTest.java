package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class BootstrapMethodsAttributeShrinkerDiffblueTest {
  /**
   * Method under test:
   * {@link BootstrapMethodsAttributeShrinker#visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)}
   */
  @Test
  public void testVisitBootstrapMethodsAttribute() {
    // Arrange
    BootstrapMethodsAttributeShrinker bootstrapMethodsAttributeShrinker = new BootstrapMethodsAttributeShrinker();
    ProgramClass clazz = new ProgramClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute(1, 1,
        new BootstrapMethodInfo[]{new BootstrapMethodInfo()});

    // Act
    bootstrapMethodsAttributeShrinker.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    BootstrapMethodInfo[] bootstrapMethodInfoArray = bootstrapMethodsAttribute.bootstrapMethods;
    assertNull(bootstrapMethodInfoArray[0]);
    assertEquals(0, bootstrapMethodsAttribute.u2bootstrapMethodsCount);
    assertEquals(1, bootstrapMethodInfoArray.length);
  }
}

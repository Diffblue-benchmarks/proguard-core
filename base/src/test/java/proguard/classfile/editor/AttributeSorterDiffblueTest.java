package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class AttributeSorterDiffblueTest {
  /**
   * Method under test: {@link AttributeSorter#compare(Object, Object)}
   */
  @Test
  public void testCompare() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();

    // Act and Assert
    assertEquals(0, attributeSorter.compare(bootstrapMethodsAttribute, new BootstrapMethodsAttribute()));
  }
}

package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class AttributeSorterDiffblueTest {
  /**
   * Test {@link AttributeSorter#compare(Object, Object)}.
   *
   * <p>Method under test: {@link AttributeSorter#compare(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AttributeSorter.compare(Object, Object)"})
  public void testCompare() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();

    // Act and Assert
    assertEquals(
        0, attributeSorter.compare(bootstrapMethodsAttribute, new BootstrapMethodsAttribute()));
  }
}

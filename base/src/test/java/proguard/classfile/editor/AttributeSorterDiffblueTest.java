package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

class AttributeSorterDiffblueTest {
  /**
   * Test {@link AttributeSorter#compare(Object, Object)}.
   *
   * <p>Method under test: {@link AttributeSorter#compare(Object, Object)}
   */
  @Test
  @DisplayName("Test compare(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttributeSorter.compare(Object, Object)"})
  void testCompare() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();

    // Act and Assert
    assertEquals(
        0, attributeSorter.compare(bootstrapMethodsAttribute, new BootstrapMethodsAttribute()));
  }
}

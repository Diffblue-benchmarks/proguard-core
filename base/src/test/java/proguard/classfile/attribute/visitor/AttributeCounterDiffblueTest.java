package proguard.classfile.attribute.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

class AttributeCounterDiffblueTest {
  /**
   * Test {@link AttributeCounter#visitAnyAttribute(Clazz, Attribute)}.
   *
   * <p>Method under test: {@link AttributeCounter#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  @DisplayName("Test visitAnyAttribute(Clazz, Attribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeCounter.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testVisitAnyAttribute() {
    // Arrange
    AttributeCounter attributeCounter = new AttributeCounter();
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeCounter.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(1, attributeCounter.getCount());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AttributeCounter}
   *   <li>{@link AttributeCounter#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeCounter.<init>()",
    "int proguard.classfile.attribute.visitor.AttributeCounter.getCount()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new AttributeCounter()).getCount());
  }
}

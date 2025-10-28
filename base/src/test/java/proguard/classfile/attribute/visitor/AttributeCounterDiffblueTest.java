package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class AttributeCounterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AttributeCounter}
   *   <li>{@link AttributeCounter#getCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new AttributeCounter()).getCount());
  }

  /**
   * Method under test:
   * {@link AttributeCounter#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  public void testVisitAnyAttribute() {
    // Arrange
    AttributeCounter attributeCounter = new AttributeCounter();
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeCounter.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(1, attributeCounter.getCount());
  }
}

package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class AttributeCounterDiffblueTest {
  /**
   * Test {@link AttributeCounter#visitAnyAttribute(Clazz, Attribute)}.
   *
   * <p>Method under test: {@link AttributeCounter#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeCounter.visitAnyAttribute(Clazz, Attribute)"})
  public void testVisitAnyAttribute() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeCounter.<init>()", "int AttributeCounter.getCount()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new AttributeCounter()).getCount());
  }
}

package proguard.classfile.constant.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

public class BootstrapMethodHandleTravelerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BootstrapMethodHandleTraveler#BootstrapMethodHandleTraveler(ConstantVisitor)}
   *   <li>{@link BootstrapMethodHandleTraveler#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link BootstrapMethodHandleTraveler#visitAnyConstant(Clazz, Constant)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BootstrapMethodHandleTraveler actualBootstrapMethodHandleTraveler = new BootstrapMethodHandleTraveler(
        new ConstantLookupVisitor());
    LibraryClass clazz = new LibraryClass();
    actualBootstrapMethodHandleTraveler.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());
    LibraryClass clazz2 = new LibraryClass();
    actualBootstrapMethodHandleTraveler.visitAnyConstant(clazz2, new ClassConstant());

    // Assert that nothing has changed
    assertEquals(0, actualBootstrapMethodHandleTraveler.bootstrapMethodAttributeIndex);
  }
}

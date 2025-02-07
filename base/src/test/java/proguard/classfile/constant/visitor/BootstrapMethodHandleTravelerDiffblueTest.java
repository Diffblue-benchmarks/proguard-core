package proguard.classfile.constant.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.visitor.BootstrapMethodInfoVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class BootstrapMethodHandleTravelerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BootstrapMethodHandleTraveler#BootstrapMethodHandleTraveler(ConstantVisitor)}
   *   <li>{@link BootstrapMethodHandleTraveler#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link BootstrapMethodHandleTraveler#visitAnyConstant(Clazz, Constant)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler.<init>(proguard.classfile.constant.visitor.ConstantVisitor)",
    "void proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)",
    "void proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BootstrapMethodHandleTraveler actualBootstrapMethodHandleTraveler =
        new BootstrapMethodHandleTraveler(new ConstantLookupVisitor());
    LibraryClass clazz = new LibraryClass();
    actualBootstrapMethodHandleTraveler.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());
    LibraryClass clazz2 = new LibraryClass();
    actualBootstrapMethodHandleTraveler.visitAnyConstant(clazz2, new ClassConstant());

    // Assert
    assertEquals(0, actualBootstrapMethodHandleTraveler.bootstrapMethodAttributeIndex);
  }

  /**
   * Test {@link BootstrapMethodHandleTraveler#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodsAttribute#bootstrapMethodEntryAccept(Clazz, int,
   *       BootstrapMethodInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BootstrapMethodHandleTraveler#visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls bootstrapMethodEntryAccept(Clazz, int, BootstrapMethodInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsBootstrapMethodEntryAccept() {
    // Arrange
    BootstrapMethodHandleTraveler bootstrapMethodHandleTraveler =
        new BootstrapMethodHandleTraveler(new ConstantLookupVisitor());
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = mock(BootstrapMethodsAttribute.class);
    doNothing()
        .when(bootstrapMethodsAttribute)
        .bootstrapMethodEntryAccept(
            Mockito.<Clazz>any(), anyInt(), Mockito.<BootstrapMethodInfoVisitor>any());

    // Act
    bootstrapMethodHandleTraveler.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    verify(bootstrapMethodsAttribute)
        .bootstrapMethodEntryAccept(isA(Clazz.class), eq(0), isA(BootstrapMethodInfoVisitor.class));
  }
}

package proguard.classfile.attribute.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

class AllBootstrapMethodInfoVisitorDiffblueTest {
  /**
   * Test {@link AllBootstrapMethodInfoVisitor#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodsAttribute#bootstrapMethodEntriesAccept(Clazz,
   *       BootstrapMethodInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllBootstrapMethodInfoVisitor#visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls bootstrapMethodEntriesAccept(Clazz, BootstrapMethodInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AllBootstrapMethodInfoVisitor.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsBootstrapMethodEntriesAccept() {
    // Arrange
    AllBootstrapMethodInfoVisitor allBootstrapMethodInfoVisitor =
        new AllBootstrapMethodInfoVisitor(mock(BootstrapMethodInfoVisitor.class));
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = mock(BootstrapMethodsAttribute.class);
    doNothing()
        .when(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(
            Mockito.<Clazz>any(), Mockito.<BootstrapMethodInfoVisitor>any());

    // Act
    allBootstrapMethodInfoVisitor.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    verify(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(isA(Clazz.class), isA(BootstrapMethodInfoVisitor.class));
  }
}

package proguard.classfile.constant.visitor;

import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.attribute.BootstrapMethodInfo;

class AllBootstrapMethodArgumentVisitorDiffblueTest {
  /**
   * Test {@link AllBootstrapMethodArgumentVisitor#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodInfo#methodArgumentsAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllBootstrapMethodArgumentVisitor#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo); then calls methodArgumentsAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.AllBootstrapMethodArgumentVisitor.visitBootstrapMethodInfo(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo_thenCallsMethodArgumentsAccept() {
    // Arrange
    AllBootstrapMethodArgumentVisitor allBootstrapMethodArgumentVisitor =
        new AllBootstrapMethodArgumentVisitor(new ConstantLookupVisitor());
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodInfo bootstrapMethodInfo = mock(BootstrapMethodInfo.class);
    doNothing()
        .when(bootstrapMethodInfo)
        .methodArgumentsAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    allBootstrapMethodArgumentVisitor.visitBootstrapMethodInfo(clazz, bootstrapMethodInfo);

    // Assert
    verify(bootstrapMethodInfo).methodArgumentsAccept(isA(Clazz.class), isA(ConstantVisitor.class));
  }
}

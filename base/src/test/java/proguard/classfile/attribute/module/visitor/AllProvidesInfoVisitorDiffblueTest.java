package proguard.classfile.attribute.module.visitor;

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
import proguard.classfile.attribute.module.ExportsInfo;
import proguard.classfile.attribute.module.ModuleAttribute;
import proguard.classfile.attribute.module.OpensInfo;
import proguard.classfile.attribute.module.ProvidesInfo;
import proguard.classfile.attribute.module.RequiresInfo;

class AllProvidesInfoVisitorDiffblueTest {
  /**
   * Test {@link AllProvidesInfoVisitor#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ProvidesInfoVisitor#visitProvidesInfo(Clazz, ProvidesInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link AllProvidesInfoVisitor#visitModuleAttribute(Clazz,
   * ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); then calls visitProvidesInfo(Clazz, ProvidesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.visitor.AllProvidesInfoVisitor.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_thenCallsVisitProvidesInfo() {
    // Arrange
    ProvidesInfoVisitor providesInfoVisitor = mock(ProvidesInfoVisitor.class);
    doNothing()
        .when(providesInfoVisitor)
        .visitProvidesInfo(Mockito.<Clazz>any(), Mockito.<ProvidesInfo>any());
    AllProvidesInfoVisitor allProvidesInfoVisitor = new AllProvidesInfoVisitor(providesInfoVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    allProvidesInfoVisitor.visitModuleAttribute(
        clazz,
        new ModuleAttribute(
            1,
            1,
            1,
            1,
            3,
            new RequiresInfo[] {new RequiresInfo(1, 1, 1)},
            3,
            new ExportsInfo[] {new ExportsInfo()},
            3,
            new OpensInfo[] {new OpensInfo()},
            3,
            new int[] {1, 0, 1, 0},
            1,
            new ProvidesInfo[] {new ProvidesInfo()}));

    // Assert
    verify(providesInfoVisitor).visitProvidesInfo(isA(Clazz.class), isA(ProvidesInfo.class));
  }
}

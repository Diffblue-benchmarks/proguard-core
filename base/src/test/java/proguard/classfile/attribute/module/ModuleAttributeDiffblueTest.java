package proguard.classfile.attribute.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import proguard.classfile.attribute.module.visitor.ProvidesInfoVisitor;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class ModuleAttributeDiffblueTest {
  /**
   * Test {@link ModuleAttribute#ModuleAttribute()}.
   *
   * <p>Method under test: {@link ModuleAttribute#ModuleAttribute()}
   */
  @Test
  @DisplayName("Test new ModuleAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModuleAttribute.<init>()",
    "void proguard.classfile.attribute.module.ModuleAttribute.<init>(int, int, int, int, int, proguard.classfile.attribute.module.RequiresInfo[], int, proguard.classfile.attribute.module.ExportsInfo[], int, proguard.classfile.attribute.module.OpensInfo[], int, int[], int, proguard.classfile.attribute.module.ProvidesInfo[])"
  })
  void testNewModuleAttribute() {
    // Arrange and Act
    ModuleAttribute actualModuleAttribute = new ModuleAttribute();

    // Assert
    assertNull(actualModuleAttribute.getProcessingInfo());
    assertEquals(0, actualModuleAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModuleAttribute#ModuleAttribute(int, int, int, int, int, RequiresInfo[], int,
   * ExportsInfo[], int, OpensInfo[], int, int[], int, ProvidesInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ModuleAttribute#ModuleAttribute(int, int, int, int, int,
   * RequiresInfo[], int, ExportsInfo[], int, OpensInfo[], int, int[], int, ProvidesInfo[])}
   */
  @Test
  @DisplayName(
      "Test new ModuleAttribute(int, int, int, int, int, RequiresInfo[], int, ExportsInfo[], int, OpensInfo[], int, int[], int, ProvidesInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModuleAttribute.<init>()",
    "void proguard.classfile.attribute.module.ModuleAttribute.<init>(int, int, int, int, int, proguard.classfile.attribute.module.RequiresInfo[], int, proguard.classfile.attribute.module.ExportsInfo[], int, proguard.classfile.attribute.module.OpensInfo[], int, int[], int, proguard.classfile.attribute.module.ProvidesInfo[])"
  })
  void testNewModuleAttribute_whenOne() {
    // Arrange and Act
    ModuleAttribute actualModuleAttribute =
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
            new ProvidesInfo[] {new ProvidesInfo()});

    // Assert
    assertNull(actualModuleAttribute.getProcessingInfo());
    assertEquals(0, actualModuleAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModuleAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModuleAttribute(Clazz, ModuleAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitModuleAttribute(Clazz, ModuleAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModuleAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitModuleAttribute() {
    // Arrange
    ModuleAttribute moduleAttribute = new ModuleAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitModuleAttribute(Mockito.<Clazz>any(), Mockito.<ModuleAttribute>any());

    // Act
    moduleAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor).visitModuleAttribute(isA(Clazz.class), isA(ModuleAttribute.class));
  }

  /**
   * Test {@link ModuleAttribute#providesAccept(Clazz, ProvidesInfoVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ProvidesInfoVisitor#visitProvidesInfo(Clazz, ProvidesInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleAttribute#providesAccept(Clazz, ProvidesInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test providesAccept(Clazz, ProvidesInfoVisitor); then calls visitProvidesInfo(Clazz, ProvidesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModuleAttribute.providesAccept(proguard.classfile.Clazz, proguard.classfile.attribute.module.visitor.ProvidesInfoVisitor)"
  })
  void testProvidesAccept_thenCallsVisitProvidesInfo() {
    // Arrange
    ModuleAttribute moduleAttribute =
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
            new ProvidesInfo[] {new ProvidesInfo()});
    LibraryClass clazz = new LibraryClass();
    ProvidesInfoVisitor providesInfoVisitor = mock(ProvidesInfoVisitor.class);
    doNothing()
        .when(providesInfoVisitor)
        .visitProvidesInfo(Mockito.<Clazz>any(), Mockito.<ProvidesInfo>any());

    // Act
    moduleAttribute.providesAccept(clazz, providesInfoVisitor);

    // Assert
    verify(providesInfoVisitor).visitProvidesInfo(isA(Clazz.class), isA(ProvidesInfo.class));
  }
}

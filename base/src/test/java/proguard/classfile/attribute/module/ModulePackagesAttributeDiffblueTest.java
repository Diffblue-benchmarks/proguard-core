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
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class ModulePackagesAttributeDiffblueTest {
  /**
   * Test {@link ModulePackagesAttribute#ModulePackagesAttribute()}.
   *
   * <p>Method under test: {@link ModulePackagesAttribute#ModulePackagesAttribute()}
   */
  @Test
  @DisplayName("Test new ModulePackagesAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModulePackagesAttribute.<init>()",
    "void proguard.classfile.attribute.module.ModulePackagesAttribute.<init>(int, int, int[])"
  })
  void testNewModulePackagesAttribute() {
    // Arrange and Act
    ModulePackagesAttribute actualModulePackagesAttribute = new ModulePackagesAttribute();

    // Assert
    assertNull(actualModulePackagesAttribute.getProcessingInfo());
    assertEquals(0, actualModulePackagesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModulePackagesAttribute#ModulePackagesAttribute(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ModulePackagesAttribute#ModulePackagesAttribute(int, int, int[])}
   */
  @Test
  @DisplayName("Test new ModulePackagesAttribute(int, int, int[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModulePackagesAttribute.<init>()",
    "void proguard.classfile.attribute.module.ModulePackagesAttribute.<init>(int, int, int[])"
  })
  void testNewModulePackagesAttribute_whenOne() {
    // Arrange and Act
    ModulePackagesAttribute actualModulePackagesAttribute =
        new ModulePackagesAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualModulePackagesAttribute.getProcessingInfo());
    assertEquals(0, actualModulePackagesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModulePackagesAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModulePackagesAttribute(Clazz,
   *       ModulePackagesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePackagesAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModulePackagesAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitModulePackagesAttribute() {
    // Arrange
    ModulePackagesAttribute modulePackagesAttribute = new ModulePackagesAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitModulePackagesAttribute(Mockito.<Clazz>any(), Mockito.<ModulePackagesAttribute>any());

    // Act
    modulePackagesAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitModulePackagesAttribute(isA(Clazz.class), isA(ModulePackagesAttribute.class));
  }
}

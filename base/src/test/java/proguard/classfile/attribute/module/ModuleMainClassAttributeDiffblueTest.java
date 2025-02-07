package proguard.classfile.attribute.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class ModuleMainClassAttributeDiffblueTest {
  /**
   * Test {@link ModuleMainClassAttribute#ModuleMainClassAttribute()}.
   *
   * <p>Method under test: {@link ModuleMainClassAttribute#ModuleMainClassAttribute()}
   */
  @Test
  @DisplayName("Test new ModuleMainClassAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModuleMainClassAttribute.<init>()",
    "void proguard.classfile.attribute.module.ModuleMainClassAttribute.<init>(int, int)"
  })
  void testNewModuleMainClassAttribute() {
    // Arrange and Act
    ModuleMainClassAttribute actualModuleMainClassAttribute = new ModuleMainClassAttribute();

    // Assert
    assertNull(actualModuleMainClassAttribute.getProcessingInfo());
    assertEquals(0, actualModuleMainClassAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModuleMainClassAttribute#ModuleMainClassAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ModuleMainClassAttribute#ModuleMainClassAttribute(int, int)}
   */
  @Test
  @DisplayName("Test new ModuleMainClassAttribute(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModuleMainClassAttribute.<init>()",
    "void proguard.classfile.attribute.module.ModuleMainClassAttribute.<init>(int, int)"
  })
  void testNewModuleMainClassAttribute_whenOne() {
    // Arrange and Act
    ModuleMainClassAttribute actualModuleMainClassAttribute = new ModuleMainClassAttribute(1, 1);

    // Assert
    assertNull(actualModuleMainClassAttribute.getProcessingInfo());
    assertEquals(0, actualModuleMainClassAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ModuleMainClassAttribute#getMainClassName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleMainClassAttribute#getMainClassName(Clazz)}
   */
  @Test
  @DisplayName("Test getMainClassName(Clazz); given 'Class Name'; then return 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.module.ModuleMainClassAttribute.getMainClassName(proguard.classfile.Clazz)"
  })
  void testGetMainClassName_givenClassName_thenReturnClassName() {
    // Arrange
    ModuleMainClassAttribute moduleMainClassAttribute = new ModuleMainClassAttribute(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    String actualMainClassName = moduleMainClassAttribute.getMainClassName(clazz);

    // Assert
    verify(clazz).getClassName(eq(1));
    assertEquals("Class Name", actualMainClassName);
  }

  /**
   * Test {@link ModuleMainClassAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz},
   * {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModuleMainClassAttribute(Clazz,
   *       ModuleMainClassAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleMainClassAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.module.ModuleMainClassAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitModuleMainClassAttribute() {
    // Arrange
    ModuleMainClassAttribute moduleMainClassAttribute = new ModuleMainClassAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitModuleMainClassAttribute(
            Mockito.<Clazz>any(), Mockito.<ModuleMainClassAttribute>any());

    // Act
    moduleMainClassAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitModuleMainClassAttribute(isA(Clazz.class), isA(ModuleMainClassAttribute.class));
  }
}

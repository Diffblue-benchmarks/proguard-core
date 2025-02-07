package proguard.classfile.attribute;

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
import proguard.classfile.attribute.visitor.BootstrapMethodInfoVisitor;

class BootstrapMethodsAttributeDiffblueTest {
  /**
   * Test {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute()}.
   *
   * <p>Method under test: {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute()}
   */
  @Test
  @DisplayName("Test new BootstrapMethodsAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.BootstrapMethodsAttribute.<init>()",
    "void proguard.classfile.attribute.BootstrapMethodsAttribute.<init>(int, int, proguard.classfile.attribute.BootstrapMethodInfo[])"
  })
  void testNewBootstrapMethodsAttribute() {
    // Arrange and Act
    BootstrapMethodsAttribute actualBootstrapMethodsAttribute = new BootstrapMethodsAttribute();

    // Assert
    assertNull(actualBootstrapMethodsAttribute.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute(int, int,
   * BootstrapMethodInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute(int, int,
   * BootstrapMethodInfo[])}
   */
  @Test
  @DisplayName("Test new BootstrapMethodsAttribute(int, int, BootstrapMethodInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.BootstrapMethodsAttribute.<init>()",
    "void proguard.classfile.attribute.BootstrapMethodsAttribute.<init>(int, int, proguard.classfile.attribute.BootstrapMethodInfo[])"
  })
  void testNewBootstrapMethodsAttribute_whenOne() {
    // Arrange and Act
    BootstrapMethodsAttribute actualBootstrapMethodsAttribute =
        new BootstrapMethodsAttribute(1, 3, new BootstrapMethodInfo[] {new BootstrapMethodInfo()});

    // Assert
    assertNull(actualBootstrapMethodsAttribute.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link BootstrapMethodsAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz},
   * {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitBootstrapMethodsAttribute(Clazz,
   *       BootstrapMethodsAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodsAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.BootstrapMethodsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitBootstrapMethodsAttribute() {
    // Arrange
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitBootstrapMethodsAttribute(
            Mockito.<Clazz>any(), Mockito.<BootstrapMethodsAttribute>any());

    // Act
    bootstrapMethodsAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitBootstrapMethodsAttribute(isA(Clazz.class), isA(BootstrapMethodsAttribute.class));
  }

  /**
   * Test {@link BootstrapMethodsAttribute#bootstrapMethodEntryAccept(Clazz, int,
   * BootstrapMethodInfoVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodInfoVisitor#visitBootstrapMethodInfo(Clazz,
   *       BootstrapMethodInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodsAttribute#bootstrapMethodEntryAccept(Clazz, int,
   * BootstrapMethodInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test bootstrapMethodEntryAccept(Clazz, int, BootstrapMethodInfoVisitor); then calls visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.BootstrapMethodsAttribute.bootstrapMethodEntryAccept(proguard.classfile.Clazz, int, proguard.classfile.attribute.visitor.BootstrapMethodInfoVisitor)"
  })
  void testBootstrapMethodEntryAccept_thenCallsVisitBootstrapMethodInfo() {
    // Arrange
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    BootstrapMethodsAttribute bootstrapMethodsAttribute =
        new BootstrapMethodsAttribute(
            1, 3, new BootstrapMethodInfo[] {bootstrapMethodInfo, new BootstrapMethodInfo()});
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodInfoVisitor bootstrapMethodInfoVisitor = mock(BootstrapMethodInfoVisitor.class);
    doNothing()
        .when(bootstrapMethodInfoVisitor)
        .visitBootstrapMethodInfo(Mockito.<Clazz>any(), Mockito.<BootstrapMethodInfo>any());

    // Act
    bootstrapMethodsAttribute.bootstrapMethodEntryAccept(clazz, 1, bootstrapMethodInfoVisitor);

    // Assert
    verify(bootstrapMethodInfoVisitor)
        .visitBootstrapMethodInfo(isA(Clazz.class), isA(BootstrapMethodInfo.class));
  }
}

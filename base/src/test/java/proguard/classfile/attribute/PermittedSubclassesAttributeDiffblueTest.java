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

class PermittedSubclassesAttributeDiffblueTest {
  /**
   * Test {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute()}.
   *
   * <p>Method under test: {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute()}
   */
  @Test
  @DisplayName("Test new PermittedSubclassesAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.PermittedSubclassesAttribute.<init>()",
    "void proguard.classfile.attribute.PermittedSubclassesAttribute.<init>(int, int, int[])"
  })
  void testNewPermittedSubclassesAttribute() {
    // Arrange and Act
    PermittedSubclassesAttribute actualPermittedSubclassesAttribute =
        new PermittedSubclassesAttribute();

    // Assert
    assertNull(actualPermittedSubclassesAttribute.getProcessingInfo());
    assertEquals(0, actualPermittedSubclassesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute(int,
   * int, int[])}
   */
  @Test
  @DisplayName("Test new PermittedSubclassesAttribute(int, int, int[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.PermittedSubclassesAttribute.<init>()",
    "void proguard.classfile.attribute.PermittedSubclassesAttribute.<init>(int, int, int[])"
  })
  void testNewPermittedSubclassesAttribute_whenOne() {
    // Arrange and Act
    PermittedSubclassesAttribute actualPermittedSubclassesAttribute =
        new PermittedSubclassesAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualPermittedSubclassesAttribute.getProcessingInfo());
    assertEquals(0, actualPermittedSubclassesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link PermittedSubclassesAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz},
   * {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitPermittedSubclassesAttribute(Clazz,
   *       PermittedSubclassesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link PermittedSubclassesAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.PermittedSubclassesAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitPermittedSubclassesAttribute() {
    // Arrange
    PermittedSubclassesAttribute permittedSubclassesAttribute = new PermittedSubclassesAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitPermittedSubclassesAttribute(
            Mockito.<Clazz>any(), Mockito.<PermittedSubclassesAttribute>any());

    // Act
    permittedSubclassesAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitPermittedSubclassesAttribute(
            isA(Clazz.class), isA(PermittedSubclassesAttribute.class));
  }
}

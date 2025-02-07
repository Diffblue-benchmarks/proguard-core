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

class NestMembersAttributeDiffblueTest {
  /**
   * Test {@link NestMembersAttribute#NestMembersAttribute()}.
   *
   * <p>Method under test: {@link NestMembersAttribute#NestMembersAttribute()}
   */
  @Test
  @DisplayName("Test new NestMembersAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.NestMembersAttribute.<init>()",
    "void proguard.classfile.attribute.NestMembersAttribute.<init>(int, int, int[])"
  })
  void testNewNestMembersAttribute() {
    // Arrange and Act
    NestMembersAttribute actualNestMembersAttribute = new NestMembersAttribute();

    // Assert
    assertNull(actualNestMembersAttribute.getProcessingInfo());
    assertEquals(0, actualNestMembersAttribute.getProcessingFlags());
  }

  /**
   * Test {@link NestMembersAttribute#NestMembersAttribute(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link NestMembersAttribute#NestMembersAttribute(int, int, int[])}
   */
  @Test
  @DisplayName("Test new NestMembersAttribute(int, int, int[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.NestMembersAttribute.<init>()",
    "void proguard.classfile.attribute.NestMembersAttribute.<init>(int, int, int[])"
  })
  void testNewNestMembersAttribute_whenOne() {
    // Arrange and Act
    NestMembersAttribute actualNestMembersAttribute =
        new NestMembersAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualNestMembersAttribute.getProcessingInfo());
    assertEquals(0, actualNestMembersAttribute.getProcessingFlags());
  }

  /**
   * Test {@link NestMembersAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitNestMembersAttribute(Clazz,
   *       NestMembersAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link NestMembersAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitNestMembersAttribute(Clazz, NestMembersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.NestMembersAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitNestMembersAttribute() {
    // Arrange
    NestMembersAttribute nestMembersAttribute = new NestMembersAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitNestMembersAttribute(Mockito.<Clazz>any(), Mockito.<NestMembersAttribute>any());

    // Act
    nestMembersAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitNestMembersAttribute(isA(Clazz.class), isA(NestMembersAttribute.class));
  }
}

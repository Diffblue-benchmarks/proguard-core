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

class InnerClassesAttributeDiffblueTest {
  /**
   * Test {@link InnerClassesAttribute#InnerClassesAttribute()}.
   *
   * <p>Method under test: {@link InnerClassesAttribute#InnerClassesAttribute()}
   */
  @Test
  @DisplayName("Test new InnerClassesAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.InnerClassesAttribute.<init>()",
    "void proguard.classfile.attribute.InnerClassesAttribute.<init>(int, int, proguard.classfile.attribute.InnerClassesInfo[])"
  })
  void testNewInnerClassesAttribute() {
    // Arrange and Act
    InnerClassesAttribute actualInnerClassesAttribute = new InnerClassesAttribute();

    // Assert
    assertNull(actualInnerClassesAttribute.getProcessingInfo());
    assertEquals(0, actualInnerClassesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link InnerClassesAttribute#InnerClassesAttribute(int, int, InnerClassesInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAttribute#InnerClassesAttribute(int, int,
   * InnerClassesInfo[])}
   */
  @Test
  @DisplayName("Test new InnerClassesAttribute(int, int, InnerClassesInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.InnerClassesAttribute.<init>()",
    "void proguard.classfile.attribute.InnerClassesAttribute.<init>(int, int, proguard.classfile.attribute.InnerClassesInfo[])"
  })
  void testNewInnerClassesAttribute_whenOne() {
    // Arrange and Act
    InnerClassesAttribute actualInnerClassesAttribute =
        new InnerClassesAttribute(1, 3, new InnerClassesInfo[] {new InnerClassesInfo(1, 1, 1, 1)});

    // Assert
    assertNull(actualInnerClassesAttribute.getProcessingInfo());
    assertEquals(0, actualInnerClassesAttribute.getProcessingFlags());
  }

  /**
   * Test {@link InnerClassesAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitInnerClassesAttribute(Clazz,
   *       InnerClassesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.InnerClassesAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitInnerClassesAttribute() {
    // Arrange
    InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitInnerClassesAttribute(Mockito.<Clazz>any(), Mockito.<InnerClassesAttribute>any());

    // Act
    innerClassesAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitInnerClassesAttribute(isA(Clazz.class), isA(InnerClassesAttribute.class));
  }
}

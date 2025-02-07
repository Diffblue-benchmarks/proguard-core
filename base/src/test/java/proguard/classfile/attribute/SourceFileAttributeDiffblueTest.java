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

class SourceFileAttributeDiffblueTest {
  /**
   * Test {@link SourceFileAttribute#SourceFileAttribute()}.
   *
   * <p>Method under test: {@link SourceFileAttribute#SourceFileAttribute()}
   */
  @Test
  @DisplayName("Test new SourceFileAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceFileAttribute.<init>()",
    "void proguard.classfile.attribute.SourceFileAttribute.<init>(int, int)"
  })
  void testNewSourceFileAttribute() {
    // Arrange and Act
    SourceFileAttribute actualSourceFileAttribute = new SourceFileAttribute();

    // Assert
    assertNull(actualSourceFileAttribute.getProcessingInfo());
    assertEquals(0, actualSourceFileAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceFileAttribute#SourceFileAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SourceFileAttribute#SourceFileAttribute(int, int)}
   */
  @Test
  @DisplayName("Test new SourceFileAttribute(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceFileAttribute.<init>()",
    "void proguard.classfile.attribute.SourceFileAttribute.<init>(int, int)"
  })
  void testNewSourceFileAttribute_whenOne() {
    // Arrange and Act
    SourceFileAttribute actualSourceFileAttribute = new SourceFileAttribute(1, 1);

    // Assert
    assertNull(actualSourceFileAttribute.getProcessingInfo());
    assertEquals(0, actualSourceFileAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceFileAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SourceFileAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceFileAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitSourceFileAttribute() {
    // Arrange
    SourceFileAttribute sourceFileAttribute = new SourceFileAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSourceFileAttribute(Mockito.<Clazz>any(), Mockito.<SourceFileAttribute>any());

    // Act
    sourceFileAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSourceFileAttribute(isA(Clazz.class), isA(SourceFileAttribute.class));
  }
}

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

class SourceDirAttributeDiffblueTest {
  /**
   * Test {@link SourceDirAttribute#SourceDirAttribute()}.
   *
   * <p>Method under test: {@link SourceDirAttribute#SourceDirAttribute()}
   */
  @Test
  @DisplayName("Test new SourceDirAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceDirAttribute.<init>()",
    "void proguard.classfile.attribute.SourceDirAttribute.<init>(int, int)"
  })
  void testNewSourceDirAttribute() {
    // Arrange and Act
    SourceDirAttribute actualSourceDirAttribute = new SourceDirAttribute();

    // Assert
    assertNull(actualSourceDirAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDirAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceDirAttribute#SourceDirAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SourceDirAttribute#SourceDirAttribute(int, int)}
   */
  @Test
  @DisplayName("Test new SourceDirAttribute(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceDirAttribute.<init>()",
    "void proguard.classfile.attribute.SourceDirAttribute.<init>(int, int)"
  })
  void testNewSourceDirAttribute_whenOne() {
    // Arrange and Act
    SourceDirAttribute actualSourceDirAttribute = new SourceDirAttribute(1, 1);

    // Assert
    assertNull(actualSourceDirAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDirAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceDirAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz}, {@code
   * attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SourceDirAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceDirAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitSourceDirAttribute() {
    // Arrange
    SourceDirAttribute sourceDirAttribute = new SourceDirAttribute(1, 1);
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSourceDirAttribute(Mockito.<Clazz>any(), Mockito.<SourceDirAttribute>any());

    // Act
    sourceDirAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSourceDirAttribute(isA(Clazz.class), isA(SourceDirAttribute.class));
  }
}

package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class SourceDebugExtensionAttributeDiffblueTest {
  /**
   * Test {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute()}.
   *
   * <p>Method under test: {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute()}
   */
  @Test
  @DisplayName("Test new SourceDebugExtensionAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceDebugExtensionAttribute.<init>()",
    "void proguard.classfile.attribute.SourceDebugExtensionAttribute.<init>(int, int, byte[])"
  })
  void testNewSourceDebugExtensionAttribute() {
    // Arrange and Act
    SourceDebugExtensionAttribute actualSourceDebugExtensionAttribute =
        new SourceDebugExtensionAttribute();

    // Assert
    assertNull(actualSourceDebugExtensionAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDebugExtensionAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute(int, int, byte[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute(int,
   * int, byte[])}
   */
  @Test
  @DisplayName("Test new SourceDebugExtensionAttribute(int, int, byte[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceDebugExtensionAttribute.<init>()",
    "void proguard.classfile.attribute.SourceDebugExtensionAttribute.<init>(int, int, byte[])"
  })
  void testNewSourceDebugExtensionAttribute_whenOne() throws UnsupportedEncodingException {
    // Arrange and Act
    SourceDebugExtensionAttribute actualSourceDebugExtensionAttribute =
        new SourceDebugExtensionAttribute(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualSourceDebugExtensionAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDebugExtensionAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceDebugExtensionAttribute#accept(Clazz, AttributeVisitor)} with {@code clazz},
   * {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceDebugExtensionAttribute(Clazz,
   *       SourceDebugExtensionAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link SourceDebugExtensionAttribute#accept(Clazz, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, AttributeVisitor) with 'clazz', 'attributeVisitor'; then calls visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.SourceDebugExtensionAttribute.accept(proguard.classfile.Clazz, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzAttributeVisitor_thenCallsVisitSourceDebugExtensionAttribute() {
    // Arrange
    SourceDebugExtensionAttribute sourceDebugExtensionAttribute =
        new SourceDebugExtensionAttribute();
    LibraryClass clazz = new LibraryClass();
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSourceDebugExtensionAttribute(
            Mockito.<Clazz>any(), Mockito.<SourceDebugExtensionAttribute>any());

    // Act
    sourceDebugExtensionAttribute.accept(clazz, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitSourceDebugExtensionAttribute(
            isA(Clazz.class), isA(SourceDebugExtensionAttribute.class));
  }
}

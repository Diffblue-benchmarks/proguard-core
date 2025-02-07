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
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class ExceptionsAttributeDiffblueTest {
  /**
   * Test {@link ExceptionsAttribute#ExceptionsAttribute()}.
   *
   * <p>Method under test: {@link ExceptionsAttribute#ExceptionsAttribute()}
   */
  @Test
  @DisplayName("Test new ExceptionsAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ExceptionsAttribute.<init>()",
    "void proguard.classfile.attribute.ExceptionsAttribute.<init>(int, int, int[])"
  })
  void testNewExceptionsAttribute() {
    // Arrange and Act
    ExceptionsAttribute actualExceptionsAttribute = new ExceptionsAttribute();

    // Assert
    assertNull(actualExceptionsAttribute.getProcessingInfo());
    assertEquals(0, actualExceptionsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ExceptionsAttribute#ExceptionsAttribute(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionsAttribute#ExceptionsAttribute(int, int, int[])}
   */
  @Test
  @DisplayName("Test new ExceptionsAttribute(int, int, int[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ExceptionsAttribute.<init>()",
    "void proguard.classfile.attribute.ExceptionsAttribute.<init>(int, int, int[])"
  })
  void testNewExceptionsAttribute_whenOne() {
    // Arrange and Act
    ExceptionsAttribute actualExceptionsAttribute =
        new ExceptionsAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualExceptionsAttribute.getProcessingInfo());
    assertEquals(0, actualExceptionsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ExceptionsAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code clazz},
   * {@code method}, {@code attributeVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitExceptionsAttribute(Clazz, Method,
   *       ExceptionsAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionsAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'; then calls visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ExceptionsAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor_thenCallsVisitExceptionsAttribute() {
    // Arrange
    ExceptionsAttribute exceptionsAttribute = new ExceptionsAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitExceptionsAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ExceptionsAttribute>any());

    // Act
    exceptionsAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitExceptionsAttribute(
            isA(Clazz.class), isA(Method.class), isA(ExceptionsAttribute.class));
  }
}

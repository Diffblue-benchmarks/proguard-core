package proguard.classfile.attribute.preverification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.editor.CodeAttributeComposer;

class StackMapTableAttributeDiffblueTest {
  /**
   * Test {@link StackMapTableAttribute#StackMapTableAttribute()}.
   *
   * <p>Method under test: {@link StackMapTableAttribute#StackMapTableAttribute()}
   */
  @Test
  @DisplayName("Test new StackMapTableAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapTableAttribute.<init>()",
    "void proguard.classfile.attribute.preverification.StackMapTableAttribute.<init>(int, proguard.classfile.attribute.preverification.StackMapFrame[])"
  })
  void testNewStackMapTableAttribute() {
    // Arrange and Act
    StackMapTableAttribute actualStackMapTableAttribute = new StackMapTableAttribute();

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link StackMapTableAttribute#StackMapTableAttribute(StackMapFrame[])}.
   *
   * <p>Method under test: {@link StackMapTableAttribute#StackMapTableAttribute(StackMapFrame[])}
   */
  @Test
  @DisplayName("Test new StackMapTableAttribute(StackMapFrame[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapTableAttribute.<init>(proguard.classfile.attribute.preverification.StackMapFrame[])"
  })
  void testNewStackMapTableAttribute2() {
    // Arrange
    FullFrame fullFrame = new FullFrame();

    // Act
    StackMapTableAttribute actualStackMapTableAttribute =
        new StackMapTableAttribute(new StackMapFrame[] {fullFrame});

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
    assertEquals(0, actualStackMapTableAttribute.u2attributeNameIndex);
    StackMapFrame[] stackMapFrameArray = actualStackMapTableAttribute.stackMapFrames;
    assertEquals(1, stackMapFrameArray.length);
    assertEquals(1, actualStackMapTableAttribute.u2stackMapFramesCount);
    assertSame(fullFrame, stackMapFrameArray[0]);
  }

  /**
   * Test {@link StackMapTableAttribute#StackMapTableAttribute(int, StackMapFrame[])}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link StackMapTableAttribute#StackMapTableAttribute(int,
   * StackMapFrame[])}
   */
  @Test
  @DisplayName("Test new StackMapTableAttribute(int, StackMapFrame[]); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapTableAttribute.<init>()",
    "void proguard.classfile.attribute.preverification.StackMapTableAttribute.<init>(int, proguard.classfile.attribute.preverification.StackMapFrame[])"
  })
  void testNewStackMapTableAttribute_whenThree() {
    // Arrange and Act
    StackMapTableAttribute actualStackMapTableAttribute =
        new StackMapTableAttribute(3, new StackMapFrame[] {new FullFrame()});

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link StackMapTableAttribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)} with
   * {@code clazz}, {@code method}, {@code codeAttribute}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link StackMapTableAttribute#accept(Clazz, Method, CodeAttribute,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapTableAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
    // Arrange
    StackMapTableAttribute stackMapTableAttribute = new StackMapTableAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitStackMapTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapTableAttribute>any());

    // Act
    stackMapTableAttribute.accept(clazz, method, codeAttribute, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitStackMapTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapTableAttribute.class));
  }

  /**
   * Test {@link StackMapTableAttribute#stackMapFramesAccept(Clazz, Method, CodeAttribute,
   * StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Given {@link FullFrame} {@link StackMapFrame#getOffsetDelta()} return two.
   *   <li>Then calls {@link FullFrame#accept(Clazz, Method, CodeAttribute, int,
   *       StackMapFrameVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StackMapTableAttribute#stackMapFramesAccept(Clazz, Method,
   * CodeAttribute, StackMapFrameVisitor)}
   */
  @Test
  @DisplayName(
      "Test stackMapFramesAccept(Clazz, Method, CodeAttribute, StackMapFrameVisitor); given FullFrame getOffsetDelta() return two; then calls accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapTableAttribute.stackMapFramesAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testStackMapFramesAccept_givenFullFrameGetOffsetDeltaReturnTwo_thenCallsAccept() {
    // Arrange
    FullFrame fullFrame = mock(FullFrame.class);
    when(fullFrame.getOffsetDelta()).thenReturn(2);
    doNothing()
        .when(fullFrame)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<StackMapFrameVisitor>any());
    StackMapTableAttribute stackMapTableAttribute =
        new StackMapTableAttribute(new StackMapFrame[] {fullFrame});
    stackMapTableAttribute.u2stackMapFramesCount = 1;
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    stackMapTableAttribute.stackMapFramesAccept(
        clazz, method, codeAttribute, new CodeAttributeComposer());

    // Assert
    verify(fullFrame)
        .accept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(StackMapFrameVisitor.class));
    verify(fullFrame).getOffsetDelta();
  }
}

package proguard.classfile.attribute.preverification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class StackMapAttributeDiffblueTest {
  /**
   * Test {@link StackMapAttribute#StackMapAttribute()}.
   *
   * <p>Method under test: {@link StackMapAttribute#StackMapAttribute()}
   */
  @Test
  @DisplayName("Test new StackMapAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapAttribute.<init>()",
    "void proguard.classfile.attribute.preverification.StackMapAttribute.<init>(int, proguard.classfile.attribute.preverification.FullFrame[])"
  })
  void testNewStackMapAttribute() {
    // Arrange and Act
    StackMapAttribute actualStackMapAttribute = new StackMapAttribute();

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
  }

  /**
   * Test {@link StackMapAttribute#StackMapAttribute(FullFrame[])}.
   *
   * <p>Method under test: {@link StackMapAttribute#StackMapAttribute(FullFrame[])}
   */
  @Test
  @DisplayName("Test new StackMapAttribute(FullFrame[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapAttribute.<init>(proguard.classfile.attribute.preverification.FullFrame[])"
  })
  void testNewStackMapAttribute2() {
    // Arrange
    FullFrame fullFrame = new FullFrame();

    // Act
    StackMapAttribute actualStackMapAttribute = new StackMapAttribute(new FullFrame[] {fullFrame});

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
    assertEquals(0, actualStackMapAttribute.u2attributeNameIndex);
    FullFrame[] fullFrameArray = actualStackMapAttribute.stackMapFrames;
    assertEquals(1, fullFrameArray.length);
    assertEquals(1, actualStackMapAttribute.u2stackMapFramesCount);
    assertSame(fullFrame, fullFrameArray[0]);
  }

  /**
   * Test {@link StackMapAttribute#StackMapAttribute(int, FullFrame[])}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link StackMapAttribute#StackMapAttribute(int, FullFrame[])}
   */
  @Test
  @DisplayName("Test new StackMapAttribute(int, FullFrame[]); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapAttribute.<init>()",
    "void proguard.classfile.attribute.preverification.StackMapAttribute.<init>(int, proguard.classfile.attribute.preverification.FullFrame[])"
  })
  void testNewStackMapAttribute_whenThree() {
    // Arrange and Act
    StackMapAttribute actualStackMapAttribute =
        new StackMapAttribute(3, new FullFrame[] {new FullFrame()});

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
  }

  /**
   * Test {@link StackMapAttribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)} with
   * {@code clazz}, {@code method}, {@code codeAttribute}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link StackMapAttribute#accept(Clazz, Method, CodeAttribute,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.StackMapAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
    // Arrange
    StackMapAttribute stackMapAttribute = new StackMapAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitStackMapAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapAttribute>any());

    // Act
    stackMapAttribute.accept(clazz, method, codeAttribute, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitStackMapAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapAttribute.class));
  }
}

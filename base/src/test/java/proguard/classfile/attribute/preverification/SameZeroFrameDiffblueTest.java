package proguard.classfile.attribute.preverification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor;
import proguard.classfile.editor.CodeAttributeComposer;

class SameZeroFrameDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SameZeroFrame#SameZeroFrame()}
   *   <li>{@link SameZeroFrame#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.SameZeroFrame.<init>()",
    "java.lang.String proguard.classfile.attribute.preverification.SameZeroFrame.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SameZeroFrame actualSameZeroFrame = new SameZeroFrame();

    // Assert
    assertEquals("[0] Var: ..., Stack: (empty)", actualSameZeroFrame.toString());
    assertNull(actualSameZeroFrame.getProcessingInfo());
    assertEquals(0, actualSameZeroFrame.getOffsetDelta());
    assertEquals(0, actualSameZeroFrame.getProcessingFlags());
  }

  /**
   * Test {@link SameZeroFrame#SameZeroFrame(int)}.
   *
   * <p>Method under test: {@link SameZeroFrame#SameZeroFrame(int)}
   */
  @Test
  @DisplayName("Test new SameZeroFrame(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.attribute.preverification.SameZeroFrame.<init>(int)"})
  void testNewSameZeroFrame() {
    // Arrange and Act
    SameZeroFrame actualSameZeroFrame = new SameZeroFrame(1);

    // Assert
    assertNull(actualSameZeroFrame.getProcessingInfo());
    assertEquals(0, actualSameZeroFrame.getProcessingFlags());
    assertEquals(1, actualSameZeroFrame.getTag());
    assertEquals(1, actualSameZeroFrame.getOffsetDelta());
  }

  /**
   * Test {@link SameZeroFrame#getTag()}.
   *
   * <ul>
   *   <li>Given {@link SameZeroFrame#SameZeroFrame(int)} with tag is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SameZeroFrame#getTag()}
   */
  @Test
  @DisplayName("Test getTag(); given SameZeroFrame(int) with tag is one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.attribute.preverification.SameZeroFrame.getTag()"})
  void testGetTag_givenSameZeroFrameWithTagIsOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new SameZeroFrame(1)).getTag());
  }

  /**
   * Test {@link SameZeroFrame#getTag()}.
   *
   * <ul>
   *   <li>Then return {@link StackMapFrame#SAME_ZERO_FRAME_EXTENDED}.
   * </ul>
   *
   * <p>Method under test: {@link SameZeroFrame#getTag()}
   */
  @Test
  @DisplayName("Test getTag(); then return SAME_ZERO_FRAME_EXTENDED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.attribute.preverification.SameZeroFrame.getTag()"})
  void testGetTag_thenReturnSame_zero_frame_extended() {
    // Arrange
    SameZeroFrame sameZeroFrame = new SameZeroFrame(1);
    sameZeroFrame.u2offsetDelta = StackMapFrame.SAME_ONE_FRAME;

    // Act and Assert
    assertEquals(StackMapFrame.SAME_ZERO_FRAME_EXTENDED, sameZeroFrame.getTag());
  }

  /**
   * Test {@link SameZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link StackMapFrameVisitor#visitSameZeroFrame(Clazz, Method, CodeAttribute,
   *       int, SameZeroFrame)}.
   * </ul>
   *
   * <p>Method under test: {@link SameZeroFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor); then calls visitSameZeroFrame(Clazz, Method, CodeAttribute, int, SameZeroFrame)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.SameZeroFrame.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testAccept_thenCallsVisitSameZeroFrame() {
    // Arrange
    SameZeroFrame sameZeroFrame = new SameZeroFrame(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer stackMapFrameVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(stackMapFrameVisitor)
        .visitSameZeroFrame(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<SameZeroFrame>any());

    // Act
    sameZeroFrame.accept(clazz, method, codeAttribute, 2, stackMapFrameVisitor);

    // Assert
    verify(stackMapFrameVisitor)
        .visitSameZeroFrame(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(SameZeroFrame.class));
  }
}

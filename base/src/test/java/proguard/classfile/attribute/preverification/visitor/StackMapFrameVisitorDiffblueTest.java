package proguard.classfile.attribute.preverification.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.preverification.FullFrame;
import proguard.classfile.attribute.preverification.MoreZeroFrame;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.StackMapFrame;
import proguard.classfile.visitor.ClassCleaner;
import proguard.classfile.visitor.ProcessingInfoSetter;

class StackMapFrameVisitorDiffblueTest {
  /**
   * Test {@link StackMapFrameVisitor#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int,
   * StackMapFrame)}.
   *
   * <ul>
   *   <li>When {@link FullFrame#FullFrame()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link StackMapFrameVisitor#visitAnyStackMapFrame(Clazz, Method,
   * CodeAttribute, int, StackMapFrame)}
   */
  @Test
  @DisplayName(
      "Test visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame); when FullFrame(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor.visitAnyStackMapFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.StackMapFrame)"
  })
  void testVisitAnyStackMapFrame_whenFullFrame_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classCleaner.visitAnyStackMapFrame(clazz, method, codeAttribute, 2, new FullFrame()));
  }

  /**
   * Test {@link StackMapFrameVisitor#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one ProcessingInfo is {@code
   *       Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link StackMapFrameVisitor#visitSameOneFrame(Clazz, Method,
   * CodeAttribute, int, SameOneFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); then SameOneFrame(int) with tag is one ProcessingInfo is 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor.visitSameOneFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.SameOneFrame)"
  })
  void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneProcessingInfoIsProcessingInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = new SameOneFrame(1);

    // Act
    processingInfoSetter.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    assertEquals("Processing Info", sameOneFrame.getProcessingInfo());
  }

  /**
   * Test {@link StackMapFrameVisitor#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int,
   * MoreZeroFrame)}.
   *
   * <p>Method under test: {@link StackMapFrameVisitor#visitMoreZeroFrame(Clazz, Method,
   * CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  @DisplayName("Test visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor.visitMoreZeroFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.MoreZeroFrame)"
  })
  void testVisitMoreZeroFrame() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);

    // Act
    processingInfoSetter.visitMoreZeroFrame(clazz, method, codeAttribute, 2, moreZeroFrame);

    // Assert
    assertEquals("Processing Info", moreZeroFrame.getProcessingInfo());
  }

  /**
   * Test {@link StackMapFrameVisitor#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}.
   *
   * <ul>
   *   <li>When {@link FullFrame#FullFrame()}.
   *   <li>Then {@link FullFrame#FullFrame()} ProcessingInfo is {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link StackMapFrameVisitor#visitFullFrame(Clazz, Method, CodeAttribute,
   * int, FullFrame)}
   */
  @Test
  @DisplayName(
      "Test visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame); when FullFrame(); then FullFrame() ProcessingInfo is 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor.visitFullFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.FullFrame)"
  })
  void testVisitFullFrame_whenFullFrame_thenFullFrameProcessingInfoIsProcessingInfo() {
    // Arrange
    ProcessingInfoSetter processingInfoSetter = new ProcessingInfoSetter("Processing Info");
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    FullFrame fullFrame = new FullFrame();

    // Act
    processingInfoSetter.visitFullFrame(clazz, method, codeAttribute, 2, fullFrame);

    // Assert
    assertEquals("Processing Info", fullFrame.getProcessingInfo());
  }
}

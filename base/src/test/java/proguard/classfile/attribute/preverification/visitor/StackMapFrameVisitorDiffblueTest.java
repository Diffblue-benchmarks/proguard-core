package proguard.classfile.attribute.preverification.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class StackMapFrameVisitorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StackMapFrameVisitor.visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame)"
  })
  public void testVisitAnyStackMapFrame_whenFullFrame_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StackMapFrameVisitor.visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)"
  })
  public void testVisitSameOneFrame_thenSameOneFrameWithTagIsOneProcessingInfoIsProcessingInfo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StackMapFrameVisitor.visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)"
  })
  public void testVisitMoreZeroFrame() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StackMapFrameVisitor.visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)"
  })
  public void testVisitFullFrame_whenFullFrame_thenFullFrameProcessingInfoIsProcessingInfo() {
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

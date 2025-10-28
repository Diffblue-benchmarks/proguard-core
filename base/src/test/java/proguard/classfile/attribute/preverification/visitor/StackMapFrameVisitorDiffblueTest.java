package proguard.classfile.attribute.preverification.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
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
   * Method under test:
   * {@link StackMapFrameVisitor#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame)}
   */
  @Test
  public void testVisitAnyStackMapFrame() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> classCleaner.visitAnyStackMapFrame(clazz, method, codeAttribute, 2, new FullFrame()));
  }

  /**
   * Method under test:
   * {@link StackMapFrameVisitor#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame() {
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
   * Method under test:
   * {@link StackMapFrameVisitor#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
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
   * Method under test:
   * {@link StackMapFrameVisitor#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}
   */
  @Test
  public void testVisitFullFrame() {
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

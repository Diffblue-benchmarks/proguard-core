package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor;
import proguard.classfile.visitor.ProcessingInfoSetter;

public class SameOneFrameDiffblueTest {
  /**
   * Method under test: {@link SameOneFrame#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(1, (new SameOneFrame(1)).getTag());
  }

  /**
   * Method under test: {@link SameOneFrame#getTag()}
   */
  @Test
  public void testGetTag2() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame(1);
    sameOneFrame.u2offsetDelta = StackMapFrame.SAME_ONE_FRAME;

    // Act and Assert
    assertEquals(StackMapFrame.SAME_ONE_FRAME_EXTENDED, sameOneFrame.getTag());
  }

  /**
   * Method under test:
   * {@link SameOneFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    sameOneFrame.accept(clazz, method, codeAttribute, 2, new ProcessingInfoSetter("Processing Info"));

    // Assert
    assertEquals("Processing Info", sameOneFrame.getProcessingInfo());
  }

  /**
   * Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame();

    // Act and Assert
    assertNotEquals(sameOneFrame, new SameOneFrame(1));
  }

  /**
   * Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame(VerificationTypeFactory.DOUBLE_TYPE);

    // Act and Assert
    assertNotEquals(sameOneFrame, new SameOneFrame(StackMapFrame.SAME_ONE_FRAME));
  }

  /**
   * Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(NullPointerException.class, () -> (new SameOneFrame(1)).equals(new SameOneFrame(1)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SameOneFrame#equals(Object)}
   *   <li>{@link SameOneFrame#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame(VerificationTypeFactory.DOUBLE_TYPE);
    SameOneFrame sameOneFrame2 = new SameOneFrame(VerificationTypeFactory.DOUBLE_TYPE);

    // Act and Assert
    assertEquals(sameOneFrame, sameOneFrame2);
    int expectedHashCodeResult = sameOneFrame.hashCode();
    assertEquals(expectedHashCodeResult, sameOneFrame2.hashCode());
  }

  /**
   * Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SameOneFrame(1), null);
  }

  /**
   * Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SameOneFrame(1), "Different type to SameOneFrame");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SameOneFrame#SameOneFrame(VerificationType)}
   *   <li>{@link SameOneFrame#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SameOneFrame actualSameOneFrame = new SameOneFrame(VerificationTypeFactory.DOUBLE_TYPE);

    // Assert
    assertEquals("[0] Var: ..., Stack: [d]", actualSameOneFrame.toString());
    assertNull(actualSameOneFrame.getProcessingInfo());
    assertEquals(0, actualSameOneFrame.getOffsetDelta());
    assertEquals(0, actualSameOneFrame.getProcessingFlags());
  }

  /**
   * Method under test: {@link SameOneFrame#SameOneFrame()}
   */
  @Test
  public void testNewSameOneFrame() {
    // Arrange and Act
    SameOneFrame actualSameOneFrame = new SameOneFrame();

    // Assert
    assertNull(actualSameOneFrame.getProcessingInfo());
    assertEquals(0, actualSameOneFrame.getOffsetDelta());
    assertEquals(0, actualSameOneFrame.getProcessingFlags());
  }

  /**
   * Method under test: {@link SameOneFrame#SameOneFrame(int)}
   */
  @Test
  public void testNewSameOneFrame2() {
    // Arrange and Act
    SameOneFrame actualSameOneFrame = new SameOneFrame(1);

    // Assert
    assertNull(actualSameOneFrame.getProcessingInfo());
    assertNull(actualSameOneFrame.stackItem);
    assertEquals(-63, actualSameOneFrame.getOffsetDelta());
    assertEquals(0, actualSameOneFrame.getProcessingFlags());
    assertEquals(1, actualSameOneFrame.getTag());
  }
}

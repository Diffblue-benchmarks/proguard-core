package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;
import proguard.classfile.visitor.ProcessingInfoSetter;

public class MoreZeroFrameDiffblueTest {
  /**
   * Method under test: {@link MoreZeroFrame#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(1, (new MoreZeroFrame(1)).getTag());
  }

  /**
   * Method under test:
   * {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    moreZeroFrame.accept(clazz, method, codeAttribute, 2, new ConstantPoolRemapper());

    // Assert that nothing has changed
    assertNull(moreZeroFrame.getProcessingInfo());
  }

  /**
   * Method under test:
   * {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    moreZeroFrame.accept(clazz, method, codeAttribute, 2, new ProcessingInfoSetter("Processing Info"));

    // Assert
    assertEquals("Processing Info", moreZeroFrame.getProcessingInfo());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MoreZeroFrame#equals(Object)}
   *   <li>{@link MoreZeroFrame#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    MoreZeroFrame moreZeroFrame2 = new MoreZeroFrame(1);

    // Act and Assert
    assertEquals(moreZeroFrame, moreZeroFrame2);
    int expectedHashCodeResult = moreZeroFrame.hashCode();
    assertEquals(expectedHashCodeResult, moreZeroFrame2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MoreZeroFrame#equals(Object)}
   *   <li>{@link MoreZeroFrame#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);

    // Act and Assert
    assertEquals(moreZeroFrame, moreZeroFrame);
    int expectedHashCodeResult = moreZeroFrame.hashCode();
    assertEquals(expectedHashCodeResult, moreZeroFrame.hashCode());
  }

  /**
   * Method under test: {@link MoreZeroFrame#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[0] Var: ..., Stack: (empty)", (new MoreZeroFrame(1)).toString());
    assertEquals("[0] Var: ...[d], Stack: (empty)",
        (new MoreZeroFrame(new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE})).toString());
  }

  /**
   * Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(-250);

    // Act and Assert
    assertNotEquals(moreZeroFrame, new MoreZeroFrame(1));
  }

  /**
   * Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MoreZeroFrame(1), null);
  }

  /**
   * Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MoreZeroFrame(1), "Different type to MoreZeroFrame");
  }

  /**
   * Method under test: {@link MoreZeroFrame#MoreZeroFrame()}
   */
  @Test
  public void testNewMoreZeroFrame() {
    // Arrange and Act
    MoreZeroFrame actualMoreZeroFrame = new MoreZeroFrame();

    // Assert
    assertNull(actualMoreZeroFrame.getProcessingInfo());
    assertEquals(0, actualMoreZeroFrame.getOffsetDelta());
    assertEquals(0, actualMoreZeroFrame.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link MoreZeroFrame#MoreZeroFrame(int, VerificationType[])}
   */
  @Test
  public void testNewMoreZeroFrame2() {
    // Arrange and Act
    MoreZeroFrame actualMoreZeroFrame = new MoreZeroFrame(3,
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE});

    // Assert
    assertNull(actualMoreZeroFrame.getProcessingInfo());
    assertEquals(0, actualMoreZeroFrame.getOffsetDelta());
    assertEquals(0, actualMoreZeroFrame.getProcessingFlags());
  }

  /**
   * Method under test: {@link MoreZeroFrame#MoreZeroFrame(int)}
   */
  @Test
  public void testNewMoreZeroFrame3() {
    // Arrange and Act
    MoreZeroFrame actualMoreZeroFrame = new MoreZeroFrame(1);

    // Assert
    assertNull(actualMoreZeroFrame.additionalVariables);
    assertNull(actualMoreZeroFrame.getProcessingInfo());
    assertEquals(-250, actualMoreZeroFrame.additionalVariablesCount);
    assertEquals(0, actualMoreZeroFrame.getOffsetDelta());
    assertEquals(0, actualMoreZeroFrame.getProcessingFlags());
    assertEquals(1, actualMoreZeroFrame.getTag());
  }
}

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

public class FullFrameDiffblueTest {
  /**
   * Method under test: {@link FullFrame#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(StackMapFrame.FULL_FRAME, (new FullFrame()).getTag());
  }

  /**
   * Method under test:
   * {@link FullFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    FullFrame fullFrame = new FullFrame();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    fullFrame.accept(clazz, method, codeAttribute, 2, new ConstantPoolRemapper());

    // Assert that nothing has changed
    assertNull(fullFrame.getProcessingInfo());
  }

  /**
   * Method under test:
   * {@link FullFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    FullFrame fullFrame = new FullFrame();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    fullFrame.accept(clazz, method, codeAttribute, 2, new ProcessingInfoSetter("Processing Info"));

    // Assert
    assertEquals("Processing Info", fullFrame.getProcessingInfo());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FullFrame#equals(Object)}
   *   <li>{@link FullFrame#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FullFrame fullFrame = new FullFrame();
    FullFrame fullFrame2 = new FullFrame();

    // Act and Assert
    assertEquals(fullFrame, fullFrame2);
    int expectedHashCodeResult = fullFrame.hashCode();
    assertEquals(expectedHashCodeResult, fullFrame2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FullFrame#equals(Object)}
   *   <li>{@link FullFrame#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FullFrame fullFrame = new FullFrame(2, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE},
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE});
    FullFrame fullFrame2 = new FullFrame(2, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE},
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertEquals(fullFrame, fullFrame2);
    int expectedHashCodeResult = fullFrame.hashCode();
    assertEquals(expectedHashCodeResult, fullFrame2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FullFrame#equals(Object)}
   *   <li>{@link FullFrame#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FullFrame fullFrame = new FullFrame();

    // Act and Assert
    assertEquals(fullFrame, fullFrame);
    int expectedHashCodeResult = fullFrame.hashCode();
    assertEquals(expectedHashCodeResult, fullFrame.hashCode());
  }

  /**
   * Method under test: {@link FullFrame#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[0] Var: , Stack: ", (new FullFrame()).toString());
    assertEquals("[2] Var: [d], Stack: [d]",
        (new FullFrame(2, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE})).toString());
  }

  /**
   * Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FullFrame fullFrame = new FullFrame(2, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE},
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertNotEquals(fullFrame, new FullFrame());
  }

  /**
   * Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FullFrame fullFrame = new FullFrame(0, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE},
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertNotEquals(fullFrame, new FullFrame());
  }

  /**
   * Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FullFrame fullFrame = new FullFrame(0, new VerificationType[]{},
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertNotEquals(fullFrame, new FullFrame());
  }

  /**
   * Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FullFrame fullFrame = new FullFrame(2, new VerificationType[]{VerificationTypeFactory.FLOAT_TYPE},
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertNotEquals(fullFrame, new FullFrame(2, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE},
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE}));
  }

  /**
   * Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FullFrame fullFrame = new FullFrame(2, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE},
        new VerificationType[]{VerificationTypeFactory.FLOAT_TYPE});

    // Act and Assert
    assertNotEquals(fullFrame, new FullFrame(2, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE},
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE}));
  }

  /**
   * Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullFrame(), null);
  }

  /**
   * Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullFrame(), "Different type to FullFrame");
  }

  /**
   * Method under test: {@link FullFrame#FullFrame()}
   */
  @Test
  public void testNewFullFrame() {
    // Arrange and Act
    FullFrame actualFullFrame = new FullFrame();

    // Assert
    assertNull(actualFullFrame.getProcessingInfo());
    assertEquals(0, actualFullFrame.getOffsetDelta());
    assertEquals(0, actualFullFrame.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link FullFrame#FullFrame(int, int, VerificationType[], int, VerificationType[])}
   */
  @Test
  public void testNewFullFrame2() {
    // Arrange and Act
    FullFrame actualFullFrame = new FullFrame(2, 3, new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE}, 3,
        new VerificationType[]{VerificationTypeFactory.DOUBLE_TYPE});

    // Assert
    assertNull(actualFullFrame.getProcessingInfo());
    assertEquals(0, actualFullFrame.getProcessingFlags());
    assertEquals(2, actualFullFrame.getOffsetDelta());
  }
}

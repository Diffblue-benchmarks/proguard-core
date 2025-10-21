package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
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
import proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;
import proguard.classfile.visitor.ProcessingInfoSetter;

public class SameOneFrameDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link VerificationTypeFactory#DOUBLE_TYPE}.
   *   <li>Then return toString is {@code [0] Var: ..., Stack: [d]}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SameOneFrame#SameOneFrame(VerificationType)}
   *   <li>{@link SameOneFrame#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SameOneFrame.<init>()",
    "void SameOneFrame.<init>(VerificationType)",
    "java.lang.String SameOneFrame.toString()"
  })
  public void testGettersAndSetters_whenDouble_type_thenReturnToStringIs0VarStackD() {
    // Arrange and Act
    SameOneFrame actualSameOneFrame = new SameOneFrame(VerificationTypeFactory.DOUBLE_TYPE);

    // Assert
    assertEquals("[0] Var: ..., Stack: [d]", actualSameOneFrame.toString());
    assertNull(actualSameOneFrame.getProcessingInfo());
    assertEquals(0, actualSameOneFrame.getOffsetDelta());
    assertEquals(0, actualSameOneFrame.getProcessingFlags());
  }

  /**
   * Test {@link SameOneFrame#SameOneFrame()}.
   *
   * <p>Method under test: {@link SameOneFrame#SameOneFrame()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SameOneFrame.<init>()",
    "void SameOneFrame.<init>(VerificationType)",
    "java.lang.String SameOneFrame.toString()"
  })
  public void testNewSameOneFrame() {
    // Arrange and Act
    SameOneFrame actualSameOneFrame = new SameOneFrame();

    // Assert
    assertNull(actualSameOneFrame.getProcessingInfo());
    assertEquals(0, actualSameOneFrame.getOffsetDelta());
    assertEquals(0, actualSameOneFrame.getProcessingFlags());
  }

  /**
   * Test {@link SameOneFrame#SameOneFrame(int)}.
   *
   * <p>Method under test: {@link SameOneFrame#SameOneFrame(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SameOneFrame.<init>(int)"})
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

  /**
   * Test {@link SameOneFrame#getTag()}.
   *
   * <ul>
   *   <li>Given {@link SameOneFrame#SameOneFrame(int)} with tag is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SameOneFrame.getTag()"})
  public void testGetTag_givenSameOneFrameWithTagIsOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new SameOneFrame(1)).getTag());
  }

  /**
   * Test {@link SameOneFrame#getTag()}.
   *
   * <ul>
   *   <li>Then return {@link StackMapFrame#SAME_ONE_FRAME_EXTENDED}.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SameOneFrame.getTag()"})
  public void testGetTag_thenReturnSame_one_frame_extended() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame(1);
    sameOneFrame.u2offsetDelta = StackMapFrame.SAME_ONE_FRAME;

    // Act and Assert
    assertEquals(StackMapFrame.SAME_ONE_FRAME_EXTENDED, sameOneFrame.getTag());
  }

  /**
   * Test {@link SameOneFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(VerificationType)} with stackItem is {@link
   *       VerificationTypeFactory#DOUBLE_TYPE} ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SameOneFrame.accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)"
  })
  public void testAccept_thenSameOneFrameWithStackItemIsDouble_typeProcessingInfoIsNull() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame(VerificationTypeFactory.DOUBLE_TYPE);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    sameOneFrame.accept(clazz, method, codeAttribute, 2, new ConstantPoolRemapper());

    // Assert that nothing has changed
    assertNull(sameOneFrame.getProcessingInfo());
  }

  /**
   * Test {@link SameOneFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then {@link SameOneFrame#SameOneFrame(int)} with tag is one ProcessingInfo is {@code
   *       Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SameOneFrame.accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)"
  })
  public void testAccept_thenSameOneFrameWithTagIsOneProcessingInfoIsProcessingInfo() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    sameOneFrame.accept(
        clazz, method, codeAttribute, 2, new ProcessingInfoSetter("Processing Info"));

    // Assert
    assertEquals("Processing Info", sameOneFrame.getProcessingInfo());
  }

  /**
   * Test {@link SameOneFrame#equals(Object)}, and {@link SameOneFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SameOneFrame#equals(Object)}
   *   <li>{@link SameOneFrame#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SameOneFrame.equals(Object)", "int SameOneFrame.hashCode()"})
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
   * Test {@link SameOneFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SameOneFrame.equals(Object)", "int SameOneFrame.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame();

    // Act and Assert
    assertNotEquals(sameOneFrame, new SameOneFrame(1));
  }

  /**
   * Test {@link SameOneFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SameOneFrame.equals(Object)", "int SameOneFrame.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SameOneFrame sameOneFrame = new SameOneFrame(VerificationTypeFactory.DOUBLE_TYPE);

    // Act and Assert
    assertNotEquals(sameOneFrame, new SameOneFrame(StackMapFrame.SAME_ONE_FRAME));
  }

  /**
   * Test {@link SameOneFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SameOneFrame.equals(Object)", "int SameOneFrame.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SameOneFrame(1), null);
  }

  /**
   * Test {@link SameOneFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SameOneFrame.equals(Object)", "int SameOneFrame.hashCode()"})
  public void testEquals_whenOtherIsSame_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(
        NullPointerException.class, () -> (new SameOneFrame(1)).equals(new SameOneFrame(1)));
  }

  /**
   * Test {@link SameOneFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SameOneFrame#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SameOneFrame.equals(Object)", "int SameOneFrame.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SameOneFrame(1), "Different type to SameOneFrame");
  }
}

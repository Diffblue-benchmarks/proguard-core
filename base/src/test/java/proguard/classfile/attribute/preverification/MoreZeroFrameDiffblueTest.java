package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

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

public class MoreZeroFrameDiffblueTest {
  /**
   * Test {@link MoreZeroFrame#MoreZeroFrame()}.
   *
   * <p>Method under test: {@link MoreZeroFrame#MoreZeroFrame()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MoreZeroFrame.<init>()",
    "void MoreZeroFrame.<init>(int, VerificationType[])"
  })
  public void testNewMoreZeroFrame() {
    // Arrange and Act
    MoreZeroFrame actualMoreZeroFrame = new MoreZeroFrame();

    // Assert
    assertNull(actualMoreZeroFrame.getProcessingInfo());
    assertEquals(0, actualMoreZeroFrame.getOffsetDelta());
    assertEquals(0, actualMoreZeroFrame.getProcessingFlags());
  }

  /**
   * Test {@link MoreZeroFrame#MoreZeroFrame(int)}.
   *
   * <p>Method under test: {@link MoreZeroFrame#MoreZeroFrame(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MoreZeroFrame.<init>(int)"})
  public void testNewMoreZeroFrame2() {
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

  /**
   * Test {@link MoreZeroFrame#MoreZeroFrame(int, VerificationType[])}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#MoreZeroFrame(int, VerificationType[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MoreZeroFrame.<init>()",
    "void MoreZeroFrame.<init>(int, VerificationType[])"
  })
  public void testNewMoreZeroFrame_whenThree() {
    // Arrange and Act
    MoreZeroFrame actualMoreZeroFrame =
        new MoreZeroFrame(3, new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});

    // Assert
    assertNull(actualMoreZeroFrame.getProcessingInfo());
    assertEquals(0, actualMoreZeroFrame.getOffsetDelta());
    assertEquals(0, actualMoreZeroFrame.getProcessingFlags());
  }

  /**
   * Test {@link MoreZeroFrame#getTag()}.
   *
   * <p>Method under test: {@link MoreZeroFrame#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MoreZeroFrame.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(1, (new MoreZeroFrame(1)).getTag());
  }

  /**
   * Test {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <p>Method under test: {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MoreZeroFrame.accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)"
  })
  public void testAccept() {
    // Arrange
    MoreZeroFrame moreZeroFrame =
        new MoreZeroFrame(new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    moreZeroFrame.accept(clazz, method, codeAttribute, 2, new ConstantPoolRemapper());

    // Assert that nothing has changed
    assertNull(moreZeroFrame.getProcessingInfo());
  }

  /**
   * Test {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then {@link MoreZeroFrame#MoreZeroFrame(int)} with tag is one ProcessingInfo is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MoreZeroFrame.accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)"
  })
  public void testAccept_thenMoreZeroFrameWithTagIsOneProcessingInfoIsNull() {
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
   * Test {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then {@link MoreZeroFrame#MoreZeroFrame(int)} with tag is one ProcessingInfo is {@code
   *       Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MoreZeroFrame.accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)"
  })
  public void testAccept_thenMoreZeroFrameWithTagIsOneProcessingInfoIsProcessingInfo() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    moreZeroFrame.accept(
        clazz, method, codeAttribute, 2, new ProcessingInfoSetter("Processing Info"));

    // Assert
    assertEquals("Processing Info", moreZeroFrame.getProcessingInfo());
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}, and {@link MoreZeroFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MoreZeroFrame#equals(Object)}
   *   <li>{@link MoreZeroFrame#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MoreZeroFrame.equals(Object)", "int MoreZeroFrame.hashCode()"})
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
   * Test {@link MoreZeroFrame#equals(Object)}, and {@link MoreZeroFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MoreZeroFrame#equals(Object)}
   *   <li>{@link MoreZeroFrame#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MoreZeroFrame.equals(Object)", "int MoreZeroFrame.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);

    // Act and Assert
    assertEquals(moreZeroFrame, moreZeroFrame);
    int expectedHashCodeResult = moreZeroFrame.hashCode();
    assertEquals(expectedHashCodeResult, moreZeroFrame.hashCode());
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MoreZeroFrame.equals(Object)", "int MoreZeroFrame.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(-250);

    // Act and Assert
    assertNotEquals(moreZeroFrame, new MoreZeroFrame(1));
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MoreZeroFrame.equals(Object)", "int MoreZeroFrame.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MoreZeroFrame(1), null);
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MoreZeroFrame.equals(Object)", "int MoreZeroFrame.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MoreZeroFrame(1), "Different type to MoreZeroFrame");
  }

  /**
   * Test {@link MoreZeroFrame#toString()}.
   *
   * <ul>
   *   <li>Given {@link MoreZeroFrame#MoreZeroFrame(int)} with tag is one.
   *   <li>Then return {@code [0] Var: ..., Stack: (empty)}.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MoreZeroFrame.toString()"})
  public void testToString_givenMoreZeroFrameWithTagIsOne_thenReturn0VarStackEmpty() {
    // Arrange, Act and Assert
    assertEquals("[0] Var: ..., Stack: (empty)", (new MoreZeroFrame(1)).toString());
  }

  /**
   * Test {@link MoreZeroFrame#toString()}.
   *
   * <ul>
   *   <li>Then return {@code [0] Var: ...[d], Stack: (empty)}.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MoreZeroFrame.toString()"})
  public void testToString_thenReturn0VarDStackEmpty() {
    // Arrange, Act and Assert
    assertEquals(
        "[0] Var: ...[d], Stack: (empty)",
        (new MoreZeroFrame(new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE}))
            .toString());
  }
}

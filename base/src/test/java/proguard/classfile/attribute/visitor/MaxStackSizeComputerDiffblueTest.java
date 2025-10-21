package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer.StackSizeConsumer;
import proguard.classfile.exception.NegativeStackSizeException;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SwitchInstruction;
import proguard.exception.ProguardCoreException;

public class MaxStackSizeComputerDiffblueTest {
  /**
   * Test {@link MaxStackSizeComputer#MaxStackSizeComputer()}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#MaxStackSizeComputer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaxStackSizeComputer.<init>()"})
  public void testNewMaxStackSizeComputer() {
    // Arrange and Act
    MaxStackSizeComputer actualMaxStackSizeComputer = new MaxStackSizeComputer();

    // Assert
    assertEquals(0, actualMaxStackSizeComputer.getMaxStackSize());
    assertEquals(8096, actualMaxStackSizeComputer.evaluated.length);
  }

  /**
   * Test {@link MaxStackSizeComputer#MaxStackSizeComputer(StackSizeConsumer)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#MaxStackSizeComputer(StackSizeConsumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaxStackSizeComputer.<init>(StackSizeConsumer)"})
  public void testNewMaxStackSizeComputer2() {
    // Arrange and Act
    MaxStackSizeComputer actualMaxStackSizeComputer = new MaxStackSizeComputer(null);

    // Assert
    assertEquals(0, actualMaxStackSizeComputer.getMaxStackSize());
    assertEquals(8096, actualMaxStackSizeComputer.evaluated.length);
  }

  /**
   * Test {@link MaxStackSizeComputer#isReachable(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#isReachable(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MaxStackSizeComputer.isReachable(int)"})
  public void testIsReachable_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MaxStackSizeComputer()).isReachable(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaxStackSizeComputer#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link MaxStackSizeComputer#getMaxStackSize()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int MaxStackSizeComputer.getMaxStackSize()",
    "void MaxStackSizeComputer.visitAnyAttribute(Clazz, Attribute)"
  })
  public void testGettersAndSetters() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();

    // Act
    maxStackSizeComputer.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(0, maxStackSizeComputer.getMaxStackSize());
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaxStackSizeComputer.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaxStackSizeComputer.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {1, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaxStackSizeComputer.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {-60, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaxStackSizeComputer.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute4() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {-124, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaxStackSizeComputer.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute_thenThrowProguardCoreException() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            maxStackSizeComputer.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {-1, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction_whenA_thenThrowNegativeStackSizeException() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction_whenA_thenThrowNegativeStackSizeException2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', -60, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction_whenA_thenThrowNegativeStackSizeException3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 0, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction_whenA_thenThrowNegativeStackSizeException4() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', -124, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)"
  })
  public void testVisitAnySwitchInstruction() throws UnsupportedEncodingException {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)"
  })
  public void testVisitAnySwitchInstruction2() throws UnsupportedEncodingException {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAAAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)"
  })
  public void testVisitAnySwitchInstruction_whenA_thenThrowNegativeStackSizeException() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 'X', 'A', 4, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)"
  })
  public void testVisitAnySwitchInstruction_whenA_thenThrowNegativeStackSizeException2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 'X', 'A', -60, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NegativeStackSizeException}.
   * </ul>
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)"
  })
  public void testVisitAnySwitchInstruction_whenA_thenThrowNegativeStackSizeException3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitAnySwitchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new LookUpSwitchInstruction(
                    (byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0})));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  public void testVisitExceptionInfo() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  public void testVisitExceptionInfo2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', -60, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Test {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MaxStackSizeComputer.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  public void testVisitExceptionInfo3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', -124, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        NegativeStackSizeException.class,
        () ->
            maxStackSizeComputer.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }
}

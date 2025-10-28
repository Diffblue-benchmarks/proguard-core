package proguard.analysis.datastructure.callgraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.Value;

public class CallDiffblueTest {
  /**
   * Method under test: {@link Call#isStatic()}
   */
  @Test
  public void testIsStatic() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse((new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).isStatic());
  }

  /**
   * Method under test: {@link Call#getArgumentCount()}
   */
  @Test
  public void testGetArgumentCount() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(0, (new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getArgumentCount());
  }

  /**
   * Method under test: {@link Call#getJvmArgumentSize()}
   */
  @Test
  public void testGetJvmArgumentSize() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(2, (new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getJvmArgumentSize());
  }

  /**
   * Method under test: {@link Call#getJvmArgumentSize()}
   */
  @Test
  public void testGetJvmArgumentSize2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(3, (new SymbolicCall(caller, ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getJvmArgumentSize());
  }

  /**
   * Method under test: {@link Call#getJvmArgumentSize()}
   */
  @Test
  public void testGetJvmArgumentSize3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(3, (new SymbolicCall(caller, ClassConstants.CLASS_GET_METHOD_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getJvmArgumentSize());
  }

  /**
   * Method under test: {@link Call#getArgument(int)}
   */
  @Test
  public void testGetArgument() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNull((new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getArgument(1));
  }

  /**
   * Method under test: {@link Call#setArguments(List)}
   */
  @Test
  public void testSetArguments() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);

    // Act
    symbolicCall.setArguments(new ArrayList<>());

    // Assert
    assertEquals(0, symbolicCall.getArgumentCount());
  }

  /**
   * Method under test: {@link Call#setArguments(List)}
   */
  @Test
  public void testSetArguments2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);

    ArrayList<Value> arguments = new ArrayList<>();
    arguments.add(BasicValueFactory.DOUBLE_VALUE);

    // Act
    symbolicCall.setArguments(arguments);

    // Assert
    assertEquals(1, symbolicCall.getArgumentCount());
  }

  /**
   * Method under test: {@link Call#setArguments(List)}
   */
  @Test
  public void testSetArguments3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);

    ArrayList<Value> arguments = new ArrayList<>();
    arguments.add(BasicValueFactory.DOUBLE_VALUE);
    arguments.add(BasicValueFactory.DOUBLE_VALUE);

    // Act
    symbolicCall.setArguments(arguments);

    // Assert
    assertEquals(2, symbolicCall.getArgumentCount());
  }

  /**
   * Method under test: {@link Call#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNull((new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getInstance());
  }

  /**
   * Method under test: {@link Call#setInstance(Value)}
   */
  @Test
  public void testSetInstance() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);
    DoubleValue instance = BasicValueFactory.DOUBLE_VALUE;

    // Act
    symbolicCall.setInstance(instance);

    // Assert
    assertSame(instance, symbolicCall.getInstance());
  }

  /**
   * Method under test: {@link Call#getReturnValue()}
   */
  @Test
  public void testGetReturnValue() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNull((new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getReturnValue());
  }

  /**
   * Method under test: {@link Call#setReturnValue(Value)}
   */
  @Test
  public void testSetReturnValue() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);
    DoubleValue returnValue = BasicValueFactory.DOUBLE_VALUE;

    // Act
    symbolicCall.setReturnValue(returnValue);

    // Assert
    assertSame(returnValue, symbolicCall.getReturnValue());
  }

  /**
   * Method under test: {@link Call#clearValues()}
   */
  @Test
  public void testClearValues() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);

    // Act
    symbolicCall.clearValues();

    // Assert
    assertEquals(1, symbolicCall.getArgumentCount());
  }

  /**
   * Method under test: {@link Call#isCertainlyCalled()}
   */
  @Test
  public void testIsCertainlyCalled() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse((new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).isCertainlyCalled());
  }

  /**
   * Method under test: {@link Call#isCertainlyCalled()}
   */
  @Test
  public void testIsCertainlyCalled2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse((new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), false, true)).isCertainlyCalled());
  }

  /**
   * Method under test: {@link Call#isCertainlyCalled()}
   */
  @Test
  public void testIsCertainlyCalled3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertTrue((new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), false, false)).isCertainlyCalled());
  }

  /**
   * Method under test: {@link Call#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] Lnull;Name+0002 (line -1) -> Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava"
            + "/lang/Class; (always throws NullPointerException)",
        (new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
            new BranchInstruction((byte) 'A', 1), true, true)).toString());
  }

  /**
   * Method under test: {@link Call#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz,
        new LibraryMethod(1, " (always throws NullPointerException)", " (always throws NullPointerException)"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] L?; (always throws NullPointerException)(always throws NullPointerException))+0002 (line"
            + " -1) -> Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class; (always throws"
            + " NullPointerException)",
        (new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
            new BranchInstruction((byte) 'A', 1), true, true)).toString());
  }

  /**
   * Method under test: {@link Call#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    MethodSignature target = new MethodSignature(" (always throws NullPointerException)",
        " (always throws NullPointerException)", " (always throws NullPointerException)");

    // Act and Assert
    assertEquals(
        "[lstore_2] Lnull;Name+0002 (line -1) -> L (always throws NullPointerException); (always throws"
            + " NullPointerException)(always throws NullPointerException)) (always throws NullPointerException)",
        (new SymbolicCall(caller, target, 1, new BranchInstruction((byte) 'A', 1), true, true)).toString());
  }

  /**
   * Method under test: {@link Call#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] Lnull;Name+0002 (line -1) -> Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava"
            + "/lang/Class; (might throw NullPointerException)",
        (new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0,
            new BranchInstruction((byte) 'A', 1), true, true)).toString());
  }

  /**
   * Method under test: {@link Call#toString()}
   */
  @Test
  public void testToString5() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] Lnull;Name+0002 (line -1) -> Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava"
            + "/lang/Class;",
        (new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, -1,
            new BranchInstruction((byte) 'A', 1), true, true)).toString());
  }

  /**
   * Method under test: {@link Call#toSimpleString()}
   */
  @Test
  public void testToSimpleString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals("[lstore_2] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        (new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
            new BranchInstruction((byte) 'A', 1), true, true)).toSimpleString());
  }

  /**
   * Method under test: {@link Call#toSimpleString()}
   */
  @Test
  public void testToSimpleString2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals("[lstore_2] Ljava/lang/ClassLoader;loadClass(Ljava/lang/String;)Ljava/lang/Class;",
        (new SymbolicCall(caller, ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE, 1,
            new BranchInstruction((byte) 'A', 1), true, true)).toSimpleString());
  }

  /**
   * Method under test: {@link Call#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall2 = new SymbolicCall(caller2, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);

    // Act and Assert
    assertEquals(symbolicCall, symbolicCall2);
    int expectedHashCodeResult = symbolicCall.hashCode();
    assertEquals(expectedHashCodeResult, symbolicCall2.hashCode());
  }

  /**
   * Method under test: {@link Call#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);

    // Act and Assert
    assertEquals(symbolicCall, symbolicCall);
    int expectedHashCodeResult = symbolicCall.hashCode();
    assertEquals(expectedHashCodeResult, symbolicCall.hashCode());
  }

  /**
   * Method under test: {@link Call#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(symbolicCall, new SymbolicCall(caller2, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true));
  }

  /**
   * Method under test: {@link Call#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2,
        new BranchInstruction((byte) 'A', 1), true, true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(symbolicCall, new SymbolicCall(caller2, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true));
  }

  /**
   * Method under test: {@link Call#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 1, 1), true, true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(symbolicCall, new SymbolicCall(caller2, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true));
  }

  /**
   * Method under test: {@link Call#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true), null);
  }

  /**
   * Method under test: {@link Call#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true), "Different type to Call");
  }
}

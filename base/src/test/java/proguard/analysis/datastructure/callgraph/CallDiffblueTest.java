package proguard.analysis.datastructure.callgraph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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

class CallDiffblueTest {
  /**
   * Test {@link Call#isStatic()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Call#isStatic()}
   */
  @Test
  @DisplayName("Test isStatic(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.datastructure.callgraph.Call.isStatic()"})
  void testIsStatic_thenReturnFalse() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .isStatic());
  }

  /**
   * Test {@link Call#getArgumentCount()}.
   *
   * <p>Method under test: {@link Call#getArgumentCount()}
   */
  @Test
  @DisplayName("Test getArgumentCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.analysis.datastructure.callgraph.Call.getArgumentCount()"})
  void testGetArgumentCount() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        0,
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .getArgumentCount());
  }

  /**
   * Test {@link Call#getJvmArgumentSize()}.
   *
   * <p>Method under test: {@link Call#getJvmArgumentSize()}
   */
  @Test
  @DisplayName("Test getJvmArgumentSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.analysis.datastructure.callgraph.Call.getJvmArgumentSize()"})
  void testGetJvmArgumentSize() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        3,
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .getJvmArgumentSize());
  }

  /**
   * Test {@link Call#getJvmArgumentSize()}.
   *
   * <p>Method under test: {@link Call#getJvmArgumentSize()}
   */
  @Test
  @DisplayName("Test getJvmArgumentSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.analysis.datastructure.callgraph.Call.getJvmArgumentSize()"})
  void testGetJvmArgumentSize2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        3,
        (new SymbolicCall(
                caller,
                ClassConstants.CLASS_GET_METHOD_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .getJvmArgumentSize());
  }

  /**
   * Test {@link Call#getJvmArgumentSize()}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link Call#getJvmArgumentSize()}
   */
  @Test
  @DisplayName("Test getJvmArgumentSize(); then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.analysis.datastructure.callgraph.Call.getJvmArgumentSize()"})
  void testGetJvmArgumentSize_thenReturnTwo() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        2,
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .getJvmArgumentSize());
  }

  /**
   * Test {@link Call#getArgument(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Call#getArgument(int)}
   */
  @Test
  @DisplayName("Test getArgument(int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.analysis.datastructure.callgraph.Call.getArgument(int)"
  })
  void testGetArgument_whenOne_thenReturnNull() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNull(
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .getArgument(1));
  }

  /**
   * Test {@link Call#setArguments(List)}.
   *
   * <p>Method under test: {@link Call#setArguments(List)}
   */
  @Test
  @DisplayName("Test setArguments(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.Call.setArguments(java.util.List)"
  })
  void testSetArguments() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    symbolicCall.setArguments(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(0, symbolicCall.getArgumentCount());
  }

  /**
   * Test {@link Call#setArguments(List)}.
   *
   * <p>Method under test: {@link Call#setArguments(List)}
   */
  @Test
  @DisplayName("Test setArguments(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.Call.setArguments(java.util.List)"
  })
  void testSetArguments2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    ArrayList<Value> arguments = new ArrayList<>();
    arguments.add(BasicValueFactory.DOUBLE_VALUE);

    // Act
    symbolicCall.setArguments(arguments);

    // Assert
    assertEquals(1, symbolicCall.getArgumentCount());
  }

  /**
   * Test {@link Call#setArguments(List)}.
   *
   * <p>Method under test: {@link Call#setArguments(List)}
   */
  @Test
  @DisplayName("Test setArguments(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.Call.setArguments(java.util.List)"
  })
  void testSetArguments3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    ArrayList<Value> arguments = new ArrayList<>();
    arguments.add(BasicValueFactory.DOUBLE_VALUE);
    arguments.add(BasicValueFactory.DOUBLE_VALUE);

    // Act
    symbolicCall.setArguments(arguments);

    // Assert
    assertEquals(2, symbolicCall.getArgumentCount());
  }

  /**
   * Test {@link Call#getInstance()}.
   *
   * <p>Method under test: {@link Call#getInstance()}
   */
  @Test
  @DisplayName("Test getInstance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.analysis.datastructure.callgraph.Call.getInstance()"
  })
  void testGetInstance() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNull(
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .getInstance());
  }

  /**
   * Test {@link Call#setInstance(Value)}.
   *
   * <p>Method under test: {@link Call#setInstance(Value)}
   */
  @Test
  @DisplayName("Test setInstance(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.Call.setInstance(proguard.evaluation.value.Value)"
  })
  void testSetInstance() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);
    DoubleValue instance = BasicValueFactory.DOUBLE_VALUE;

    // Act
    symbolicCall.setInstance(instance);

    // Assert
    assertSame(instance, symbolicCall.getInstance());
  }

  /**
   * Test {@link Call#getReturnValue()}.
   *
   * <p>Method under test: {@link Call#getReturnValue()}
   */
  @Test
  @DisplayName("Test getReturnValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.analysis.datastructure.callgraph.Call.getReturnValue()"
  })
  void testGetReturnValue() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNull(
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .getReturnValue());
  }

  /**
   * Test {@link Call#setReturnValue(Value)}.
   *
   * <p>Method under test: {@link Call#setReturnValue(Value)}
   */
  @Test
  @DisplayName("Test setReturnValue(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.Call.setReturnValue(proguard.evaluation.value.Value)"
  })
  void testSetReturnValue() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);
    DoubleValue returnValue = BasicValueFactory.DOUBLE_VALUE;

    // Act
    symbolicCall.setReturnValue(returnValue);

    // Assert
    assertSame(returnValue, symbolicCall.getReturnValue());
  }

  /**
   * Test {@link Call#clearValues()}.
   *
   * <p>Method under test: {@link Call#clearValues()}
   */
  @Test
  @DisplayName("Test clearValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.analysis.datastructure.callgraph.Call.clearValues()"})
  void testClearValues() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    symbolicCall.clearValues();

    // Assert
    assertEquals(1, symbolicCall.getArgumentCount());
  }

  /**
   * Test {@link Call#isCertainlyCalled()}.
   *
   * <p>Method under test: {@link Call#isCertainlyCalled()}
   */
  @Test
  @DisplayName("Test isCertainlyCalled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.datastructure.callgraph.Call.isCertainlyCalled()"})
  void testIsCertainlyCalled() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .isCertainlyCalled());
  }

  /**
   * Test {@link Call#isCertainlyCalled()}.
   *
   * <p>Method under test: {@link Call#isCertainlyCalled()}
   */
  @Test
  @DisplayName("Test isCertainlyCalled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.datastructure.callgraph.Call.isCertainlyCalled()"})
  void testIsCertainlyCalled2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                false,
                true))
            .isCertainlyCalled());
  }

  /**
   * Test {@link Call#isCertainlyCalled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Call#isCertainlyCalled()}
   */
  @Test
  @DisplayName("Test isCertainlyCalled(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.datastructure.callgraph.Call.isCertainlyCalled()"})
  void testIsCertainlyCalled_thenReturnTrue() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertTrue(
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                false,
                false))
            .isCertainlyCalled());
  }

  /**
   * Test {@link Call#toString()}.
   *
   * <p>Method under test: {@link Call#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.callgraph.Call.toString()"})
  void testToString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] Lnull;Name+0002 (line -1) -> Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava"
            + "/lang/Class; (always throws NullPointerException)",
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .toString());
  }

  /**
   * Test {@link Call#toString()}.
   *
   * <p>Method under test: {@link Call#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.callgraph.Call.toString()"})
  void testToString2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller =
        new CodeLocation(
            clazz,
            new LibraryMethod(
                1,
                " (always throws NullPointerException)",
                " (always throws NullPointerException)"),
            2);

    // Act and Assert
    assertEquals(
        "[lstore_2] L?; (always throws NullPointerException)(always throws NullPointerException))+0002 (line"
            + " -1) -> Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class; (always throws"
            + " NullPointerException)",
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .toString());
  }

  /**
   * Test {@link Call#toString()}.
   *
   * <p>Method under test: {@link Call#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.callgraph.Call.toString()"})
  void testToString3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    MethodSignature target =
        new MethodSignature(
            " (always throws NullPointerException)",
            " (always throws NullPointerException)",
            " (always throws NullPointerException)");

    // Act and Assert
    assertEquals(
        "[lstore_2] Lnull;Name+0002 (line -1) -> L (always throws NullPointerException); (always throws"
            + " NullPointerException)(always throws NullPointerException)) (always throws NullPointerException)",
        (new SymbolicCall(caller, target, 1, new BranchInstruction((byte) 'A', 1), true, true))
            .toString());
  }

  /**
   * Test {@link Call#toString()}.
   *
   * <p>Method under test: {@link Call#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.callgraph.Call.toString()"})
  void testToString4() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] Lnull;Name+0002 (line -1) -> Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava"
            + "/lang/Class; (might throw NullPointerException)",
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                0,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .toString());
  }

  /**
   * Test {@link Call#toString()}.
   *
   * <p>Method under test: {@link Call#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.callgraph.Call.toString()"})
  void testToString5() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] Lnull;Name+0002 (line -1) -> Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava"
            + "/lang/Class;",
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                -1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .toString());
  }

  /**
   * Test {@link Call#toSimpleString()}.
   *
   * <p>Method under test: {@link Call#toSimpleString()}
   */
  @Test
  @DisplayName("Test toSimpleString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.datastructure.callgraph.Call.toSimpleString()"
  })
  void testToSimpleString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .toSimpleString());
  }

  /**
   * Test {@link Call#toSimpleString()}.
   *
   * <p>Method under test: {@link Call#toSimpleString()}
   */
  @Test
  @DisplayName("Test toSimpleString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.datastructure.callgraph.Call.toSimpleString()"
  })
  void testToSimpleString2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(
        "[lstore_2] Ljava/lang/ClassLoader;loadClass(Ljava/lang/String;)Ljava/lang/Class;",
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .toSimpleString());
  }

  /**
   * Test {@link Call#equals(Object)}, and {@link Call#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Call#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.Call.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.Call.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall2 =
        new SymbolicCall(
            caller2,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act and Assert
    assertEquals(symbolicCall, symbolicCall2);
    int expectedHashCodeResult = symbolicCall.hashCode();
    assertEquals(expectedHashCodeResult, symbolicCall2.hashCode());
  }

  /**
   * Test {@link Call#equals(Object)}, and {@link Call#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Call#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.Call.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.Call.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act and Assert
    assertEquals(symbolicCall, symbolicCall);
    int expectedHashCodeResult = symbolicCall.hashCode();
    assertEquals(expectedHashCodeResult, symbolicCall.hashCode());
  }

  /**
   * Test {@link Call#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Call#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.Call.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.Call.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(
        symbolicCall,
        new SymbolicCall(
            caller2,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));
  }

  /**
   * Test {@link Call#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Call#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.Call.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.Call.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            2,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(
        symbolicCall,
        new SymbolicCall(
            caller2,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));
  }

  /**
   * Test {@link Call#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Call#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.Call.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.Call.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 1, 1),
            true,
            true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(
        symbolicCall,
        new SymbolicCall(
            caller2,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));
  }

  /**
   * Test {@link Call#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Call#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.Call.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.Call.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true),
        null);
  }

  /**
   * Test {@link Call#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Call#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.Call.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.Call.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true),
        "Different type to Call");
  }
}

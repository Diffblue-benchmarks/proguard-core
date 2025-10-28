package proguard.analysis.datastructure.callgraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;

public class SymbolicCallDiffblueTest {
  /**
   * Method under test: {@link SymbolicCall#equals(Object)}
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
   * Method under test: {@link SymbolicCall#equals(Object)}
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
   * Method under test: {@link SymbolicCall#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertNotEquals(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true), "Different type to SymbolicCall");
  }

  /**
   * Method under test: {@link SymbolicCall#getTarget()}
   */
  @Test
  public void testGetTarget() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    MethodSignature actualTarget = (new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getTarget();

    // Assert
    assertEquals("Class ClassLoader.findLoadedClass(String)", actualTarget.getPrettyFqn());
    MethodDescriptor descriptor = actualTarget.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;", actualTarget.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", actualTarget.getMethodName());
    assertEquals("java.lang", actualTarget.getExternalPackageName());
    assertEquals("java.lang", actualTarget.getPackageName());
    assertEquals("java/lang/ClassLoader", actualTarget.getClassName());
    assertNull(actualTarget.getReferencedClass());
    assertNull(actualTarget.getReferencedMethod());
    assertFalse(descriptor.isIncomplete());
    assertFalse(actualTarget.isIncomplete());
  }

  /**
   * Method under test: {@link SymbolicCall#hasIncompleteTarget()}
   */
  @Test
  public void testHasIncompleteTarget() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse((new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).hasIncompleteTarget());
  }

  /**
   * Method under test: {@link SymbolicCall#hasIncompleteTarget()}
   */
  @Test
  public void testHasIncompleteTarget2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertTrue((new SymbolicCall(caller, MethodSignature.UNKNOWN, 1, new BranchInstruction((byte) 'A', 1), true, true))
        .hasIncompleteTarget());
  }

  /**
   * Method under test: {@link SymbolicCall#hasIncompleteTarget()}
   */
  @Test
  public void testHasIncompleteTarget3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertTrue(
        (new SymbolicCall(caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true)).hasIncompleteTarget());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SymbolicCall#equals(Object)}
   *   <li>{@link SymbolicCall#hashCode()}
   * </ul>
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
   * Methods under test:
   * <ul>
   *   <li>{@link SymbolicCall#equals(Object)}
   *   <li>{@link SymbolicCall#hashCode()}
   * </ul>
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
   * Method under test:
   * {@link SymbolicCall#SymbolicCall(CodeLocation, MethodSignature, int, Instruction, boolean, boolean)}
   */
  @Test
  public void testNewSymbolicCall() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    MethodSignature target = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act
    SymbolicCall actualSymbolicCall = new SymbolicCall(caller, target, 1, new BranchInstruction((byte) 'A', 1), true,
        true);

    // Assert
    Instruction instruction = actualSymbolicCall.instruction;
    assertTrue(instruction instanceof BranchInstruction);
    CodeLocation codeLocation = actualSymbolicCall.caller;
    assertEquals("Lnull;Name", codeLocation.getName());
    assertEquals("Name", codeLocation.getMemberName());
    assertEquals("[lstore_2] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        actualSymbolicCall.toSimpleString());
    assertEquals("lstore_2", instruction.getName());
    assertNull(actualSymbolicCall.getInstance());
    assertNull(actualSymbolicCall.getReturnValue());
    assertEquals(-1, codeLocation.line);
    assertEquals(0, actualSymbolicCall.getArgumentCount());
    assertEquals(1, actualSymbolicCall.throwsNullptr);
    assertEquals(1, ((BranchInstruction) instruction).branchOffset);
    assertEquals(2, actualSymbolicCall.getJvmArgumentSize());
    assertEquals(2, codeLocation.offset);
    assertFalse(actualSymbolicCall.isCertainlyCalled());
    assertFalse(actualSymbolicCall.isStatic());
    assertFalse(actualSymbolicCall.hasIncompleteTarget());
    assertTrue(instruction.isCategory2());
    assertTrue(actualSymbolicCall.controlFlowDependent);
    assertTrue(actualSymbolicCall.runtimeTypeDependent);
    assertEquals('A', ((BranchInstruction) instruction).opcode);
    assertSame(caller.clazz, codeLocation.clazz);
    assertSame(caller.member, codeLocation.member);
    assertSame(caller.signature, codeLocation.signature);
    assertSame(target, actualSymbolicCall.getTarget());
  }
}

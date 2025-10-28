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
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;

public class ConcreteCallDiffblueTest {
  /**
   * Method under test: {@link ConcreteCall#getTarget()}
   */
  @Test
  public void testGetTarget() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod();

    // Act
    MethodSignature actualTarget = (new ConcreteCall(caller, targetClass, target, 1,
        new BranchInstruction((byte) 'A', 1), true, true)).getTarget();

    // Assert
    assertEquals(actualTarget.UNKNOWN, actualTarget);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConcreteCall#equals(Object)}
   *   <li>{@link ConcreteCall#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    ConcreteCall concreteCall = new ConcreteCall(caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1),
        true, true);

    // Act and Assert
    assertEquals(concreteCall, concreteCall);
    int expectedHashCodeResult = concreteCall.hashCode();
    assertEquals(expectedHashCodeResult, concreteCall.hashCode());
  }

  /**
   * Method under test: {@link ConcreteCall#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    ConcreteCall concreteCall = new ConcreteCall(caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1),
        true, true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass2 = new LibraryClass();
    LibraryMethod target2 = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(concreteCall,
        new ConcreteCall(caller2, targetClass2, target2, 1, new BranchInstruction((byte) 'A', 1), true, true));
  }

  /**
   * Method under test: {@link ConcreteCall#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    ConcreteCall concreteCall = new ConcreteCall(caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1),
        true, true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass2 = new LibraryClass();
    LibraryMethod target2 = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(concreteCall,
        new ConcreteCall(caller2, targetClass2, target2, 1, new BranchInstruction((byte) 'A', 1), true, true));
  }

  /**
   * Method under test: {@link ConcreteCall#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(new ConcreteCall(caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true),
        null);
  }

  /**
   * Method under test: {@link ConcreteCall#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(new ConcreteCall(caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true),
        "Different type to ConcreteCall");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ConcreteCall#ConcreteCall(CodeLocation, Clazz, Method, Value, List, Value, int, Instruction, boolean, boolean)}
   *   <li>{@link ConcreteCall#getTargetClass()}
   *   <li>{@link ConcreteCall#getTargetMethod()}
   *   <li>{@link ConcreteCall#hasIncompleteTarget()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    ArrayList<Value> arguments = new ArrayList<>();

    // Act
    ConcreteCall actualConcreteCall = new ConcreteCall(caller, targetClass, target, BasicValueFactory.DOUBLE_VALUE,
        arguments, BasicValueFactory.DOUBLE_VALUE, 1, new BranchInstruction((byte) 'A', 1), true, true);
    Clazz actualTargetClass = actualConcreteCall.getTargetClass();
    Method actualTargetMethod = actualConcreteCall.getTargetMethod();
    boolean actualHasIncompleteTargetResult = actualConcreteCall.hasIncompleteTarget();

    // Assert
    CodeLocation codeLocation = actualConcreteCall.caller;
    assertEquals("Lnull;Name", codeLocation.getName());
    assertEquals("Name", codeLocation.getMemberName());
    assertFalse(actualHasIncompleteTargetResult);
    assertSame(targetClass, actualTargetClass);
    assertSame(target, actualTargetMethod);
  }

  /**
   * Method under test:
   * {@link ConcreteCall#ConcreteCall(CodeLocation, Clazz, Method, int, Instruction, boolean, boolean)}
   */
  @Test
  public void testNewConcreteCall() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    ConcreteCall actualConcreteCall = new ConcreteCall(caller, targetClass, target, 1,
        new BranchInstruction((byte) 'A', 1), true, true);

    // Assert
    Instruction instruction = actualConcreteCall.instruction;
    assertTrue(instruction instanceof BranchInstruction);
    CodeLocation codeLocation = actualConcreteCall.caller;
    assertEquals("Lnull;Name", codeLocation.getName());
    assertEquals("Name", codeLocation.getMemberName());
    assertEquals("lstore_2", instruction.getName());
    assertNull(actualConcreteCall.getInstance());
    assertNull(actualConcreteCall.getReturnValue());
    assertEquals(-1, codeLocation.line);
    assertEquals(0, actualConcreteCall.getArgumentCount());
    assertEquals(1, actualConcreteCall.throwsNullptr);
    assertEquals(1, ((BranchInstruction) instruction).branchOffset);
    assertEquals(2, codeLocation.offset);
    assertFalse(actualConcreteCall.isCertainlyCalled());
    assertFalse(actualConcreteCall.isStatic());
    assertFalse(actualConcreteCall.hasIncompleteTarget());
    assertTrue(instruction.isCategory2());
    assertTrue(actualConcreteCall.controlFlowDependent);
    assertTrue(actualConcreteCall.runtimeTypeDependent);
    assertEquals('A', ((BranchInstruction) instruction).opcode);
    assertSame(targetClass, actualConcreteCall.getTargetClass());
    assertSame(target, actualConcreteCall.getTargetMethod());
    assertSame(caller.clazz, codeLocation.clazz);
    assertSame(caller.member, codeLocation.member);
    assertSame(caller.signature, codeLocation.signature);
  }
}

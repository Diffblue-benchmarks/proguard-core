package proguard.analysis.datastructure.callgraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConcreteCall#ConcreteCall(CodeLocation, Clazz, Method, Value, List, Value, int,
   *       Instruction, boolean, boolean)}
   *   <li>{@link ConcreteCall#getTargetClass()}
   *   <li>{@link ConcreteCall#getTargetMethod()}
   *   <li>{@link ConcreteCall#hasIncompleteTarget()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConcreteCall.<init>(CodeLocation, Clazz, Method, Value, List, Value, int, Instruction, boolean, boolean)",
    "Clazz ConcreteCall.getTargetClass()",
    "Method ConcreteCall.getTargetMethod()",
    "boolean ConcreteCall.hasIncompleteTarget()"
  })
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    ArrayList<Value> arguments = new ArrayList<>();

    // Act
    ConcreteCall actualConcreteCall =
        new ConcreteCall(
            caller,
            targetClass,
            target,
            BasicValueFactory.DOUBLE_VALUE,
            arguments,
            BasicValueFactory.DOUBLE_VALUE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);
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
   * Test {@link ConcreteCall#ConcreteCall(CodeLocation, Clazz, Method, int, Instruction, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link ConcreteCall#ConcreteCall(CodeLocation, Clazz, Method, int,
   * Instruction, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConcreteCall.<init>(CodeLocation, Clazz, Method, int, Instruction, boolean, boolean)"
  })
  public void testNewConcreteCall() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    ConcreteCall actualConcreteCall =
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Assert
    Clazz targetClass2 = actualConcreteCall.getTargetClass();
    assertTrue(targetClass2 instanceof LibraryClass);
    Method targetMethod = actualConcreteCall.getTargetMethod();
    assertTrue(targetMethod instanceof LibraryMethod);
    assertTrue(actualConcreteCall.instruction instanceof BranchInstruction);
    assertNull(actualConcreteCall.getInstance());
    assertNull(actualConcreteCall.getReturnValue());
    assertEquals(0, actualConcreteCall.getArgumentCount());
    assertEquals(1, actualConcreteCall.throwsNullptr);
    assertFalse(actualConcreteCall.isCertainlyCalled());
    assertFalse(actualConcreteCall.isStatic());
    assertFalse(actualConcreteCall.hasIncompleteTarget());
    assertTrue(actualConcreteCall.controlFlowDependent);
    assertTrue(actualConcreteCall.runtimeTypeDependent);
    assertSame(targetClass, targetClass2);
    assertSame(target, targetMethod);
  }

  /**
   * Test {@link ConcreteCall#getTarget()}.
   *
   * <ul>
   *   <li>Then return {@link MethodSignature#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ConcreteCall#getTarget()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodSignature ConcreteCall.getTarget()"})
  public void testGetTarget_thenReturnUnknown() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod();

    // Act
    MethodSignature actualTarget =
        (new ConcreteCall(
                caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true))
            .getTarget();

    // Assert
    assertEquals(actualTarget.UNKNOWN, actualTarget);
  }

  /**
   * Test {@link ConcreteCall#equals(Object)}, and {@link ConcreteCall#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConcreteCall#equals(Object)}
   *   <li>{@link ConcreteCall#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConcreteCall.equals(Object)", "int ConcreteCall.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    ConcreteCall concreteCall =
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Act and Assert
    assertEquals(concreteCall, concreteCall);
    int expectedHashCodeResult = concreteCall.hashCode();
    assertEquals(expectedHashCodeResult, concreteCall.hashCode());
  }

  /**
   * Test {@link ConcreteCall#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConcreteCall#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConcreteCall.equals(Object)", "int ConcreteCall.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    ConcreteCall concreteCall =
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass2 = new LibraryClass();
    LibraryMethod target2 = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(
        concreteCall,
        new ConcreteCall(
            caller2, targetClass2, target2, 1, new BranchInstruction((byte) 'A', 1), true, true));
  }

  /**
   * Test {@link ConcreteCall#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConcreteCall#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConcreteCall.equals(Object)", "int ConcreteCall.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    ConcreteCall concreteCall =
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass2 = new LibraryClass();
    LibraryMethod target2 = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(
        concreteCall,
        new ConcreteCall(
            caller2, targetClass2, target2, 1, new BranchInstruction((byte) 'A', 1), true, true));
  }

  /**
   * Test {@link ConcreteCall#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConcreteCall#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConcreteCall.equals(Object)", "int ConcreteCall.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true),
        null);
  }

  /**
   * Test {@link ConcreteCall#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConcreteCall#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConcreteCall.equals(Object)", "int ConcreteCall.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true),
        "Different type to ConcreteCall");
  }
}

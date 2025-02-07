package proguard.analysis.datastructure.callgraph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.MethodSignature;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.visitor.MemberVisitor;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;

class ConcreteCallDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.ConcreteCall.<init>(proguard.analysis.datastructure.CodeLocation, proguard.classfile.Clazz, proguard.classfile.Method, proguard.evaluation.value.Value, java.util.List, proguard.evaluation.value.Value, int, proguard.classfile.instruction.Instruction, boolean, boolean)",
    "proguard.classfile.Clazz proguard.analysis.datastructure.callgraph.ConcreteCall.getTargetClass()",
    "proguard.classfile.Method proguard.analysis.datastructure.callgraph.ConcreteCall.getTargetMethod()",
    "boolean proguard.analysis.datastructure.callgraph.ConcreteCall.hasIncompleteTarget()"
  })
  void testGettersAndSetters() {
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
  @DisplayName(
      "Test new ConcreteCall(CodeLocation, Clazz, Method, int, Instruction, boolean, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.ConcreteCall.<init>(proguard.analysis.datastructure.CodeLocation, proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, boolean, boolean)"
  })
  void testNewConcreteCall() {
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
  @DisplayName("Test getTarget(); then return UNKNOWN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.MethodSignature proguard.analysis.datastructure.callgraph.ConcreteCall.getTarget()"
  })
  void testGetTarget_thenReturnUnknown() {
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
   * Test {@link ConcreteCall#targetMethodAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConcreteCall#targetMethodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test targetMethodAccept(MemberVisitor); given LibraryMethod accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.ConcreteCall.targetMethodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testTargetMethodAccept_givenLibraryMethodAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryMethod target = mock(LibraryMethod.class);
    doNothing().when(target).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    ConcreteCall concreteCall =
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Act
    concreteCall.targetMethodAccept(new AttributeSorter());

    // Assert
    verify(target).accept(isA(Clazz.class), isA(MemberVisitor.class));
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.ConcreteCall.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.ConcreteCall.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.ConcreteCall.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.ConcreteCall.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.ConcreteCall.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.ConcreteCall.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.ConcreteCall.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.ConcreteCall.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.callgraph.ConcreteCall.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.callgraph.ConcreteCall.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

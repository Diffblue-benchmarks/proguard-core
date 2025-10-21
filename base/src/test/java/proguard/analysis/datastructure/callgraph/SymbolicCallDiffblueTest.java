package proguard.analysis.datastructure.callgraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link SymbolicCall#SymbolicCall(CodeLocation, MethodSignature, int, Instruction, boolean,
   * boolean)}.
   *
   * <p>Method under test: {@link SymbolicCall#SymbolicCall(CodeLocation, MethodSignature, int,
   * Instruction, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SymbolicCall.<init>(CodeLocation, MethodSignature, int, Instruction, boolean, boolean)"
  })
  public void testNewSymbolicCall() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    MethodSignature target = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act
    SymbolicCall actualSymbolicCall =
        new SymbolicCall(caller, target, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Assert
    assertTrue(actualSymbolicCall.instruction instanceof BranchInstruction);
    assertEquals(
        "[lstore_2] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        actualSymbolicCall.toSimpleString());
    assertNull(actualSymbolicCall.getInstance());
    assertNull(actualSymbolicCall.getReturnValue());
    assertEquals(0, actualSymbolicCall.getArgumentCount());
    assertEquals(1, actualSymbolicCall.throwsNullptr);
    assertEquals(2, actualSymbolicCall.getJvmArgumentSize());
    assertFalse(actualSymbolicCall.isCertainlyCalled());
    assertFalse(actualSymbolicCall.isStatic());
    assertFalse(actualSymbolicCall.hasIncompleteTarget());
    assertTrue(actualSymbolicCall.controlFlowDependent);
    assertTrue(actualSymbolicCall.runtimeTypeDependent);
    assertSame(target, actualSymbolicCall.getTarget());
  }

  /**
   * Test {@link SymbolicCall#getTarget()}.
   *
   * <p>Method under test: {@link SymbolicCall#getTarget()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodSignature SymbolicCall.getTarget()"})
  public void testGetTarget() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    MethodSignature actualTarget =
        (new SymbolicCall(
                caller,
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .getTarget();

    // Assert
    assertEquals("Class ClassLoader.findLoadedClass(String)", actualTarget.getPrettyFqn());
    MethodDescriptor descriptor = actualTarget.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        actualTarget.getFqn());
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
   * Test {@link SymbolicCall#hasIncompleteTarget()}.
   *
   * <p>Method under test: {@link SymbolicCall#hasIncompleteTarget()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SymbolicCall.hasIncompleteTarget()"})
  public void testHasIncompleteTarget() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertTrue(
        (new SymbolicCall(
                caller,
                MethodSignature.UNKNOWN,
                1,
                new BranchInstruction((byte) 'A', 1),
                true,
                true))
            .hasIncompleteTarget());
  }

  /**
   * Test {@link SymbolicCall#hasIncompleteTarget()}.
   *
   * <p>Method under test: {@link SymbolicCall#hasIncompleteTarget()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SymbolicCall.hasIncompleteTarget()"})
  public void testHasIncompleteTarget2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertTrue(
        (new SymbolicCall(caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true))
            .hasIncompleteTarget());
  }

  /**
   * Test {@link SymbolicCall#hasIncompleteTarget()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SymbolicCall#hasIncompleteTarget()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SymbolicCall.hasIncompleteTarget()"})
  public void testHasIncompleteTarget_thenReturnFalse() {
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
            .hasIncompleteTarget());
  }

  /**
   * Test {@link SymbolicCall#equals(Object)}, and {@link SymbolicCall#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SymbolicCall#equals(Object)}
   *   <li>{@link SymbolicCall#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SymbolicCall.equals(Object)", "int SymbolicCall.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
   * Test {@link SymbolicCall#equals(Object)}, and {@link SymbolicCall#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SymbolicCall#equals(Object)}
   *   <li>{@link SymbolicCall#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SymbolicCall.equals(Object)", "int SymbolicCall.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
   * Test {@link SymbolicCall#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SymbolicCall#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SymbolicCall.equals(Object)", "int SymbolicCall.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
   * Test {@link SymbolicCall#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SymbolicCall#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SymbolicCall.equals(Object)", "int SymbolicCall.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
   * Test {@link SymbolicCall#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SymbolicCall#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SymbolicCall.equals(Object)", "int SymbolicCall.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
        "Different type to SymbolicCall");
  }
}

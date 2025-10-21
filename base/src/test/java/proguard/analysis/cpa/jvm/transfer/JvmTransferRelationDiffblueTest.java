package proguard.analysis.cpa.jvm.transfer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;

public class JvmTransferRelationDiffblueTest {
  /**
   * Test {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction, List)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LatticeAbstractState JvmTransferRelation.calculateArithmeticInstruction(Instruction, List)"
  })
  public void testCalculateArithmeticInstruction() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    SetAbstractState<JvmTaintSource> actualCalculateArithmeticInstructionResult =
        jvmTaintTransferRelation.calculateArithmeticInstruction(instruction, new ArrayList<>());

    // Assert
    assertTrue(actualCalculateArithmeticInstructionResult.isEmpty());
    SetAbstractState setAbstractState = actualCalculateArithmeticInstructionResult.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualCalculateArithmeticInstructionResult);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractByteConstant(byte)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractByteConstant(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LatticeAbstractState JvmTransferRelation.getAbstractByteConstant(byte)"})
  public void testGetAbstractByteConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractByteConstant =
        jvmTaintTransferRelation.getAbstractByteConstant((byte) 'A');

    // Assert
    assertTrue(actualAbstractByteConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractByteConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractByteConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractDoubleConstant(double)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractDoubleConstant(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JvmTransferRelation.getAbstractDoubleConstant(double)"})
  public void testGetAbstractDoubleConstant() {
    // Arrange and Act
    List<SetAbstractState<JvmTaintSource>> actualAbstractDoubleConstant =
        (new JvmTaintTransferRelation(new HashMap<>())).getAbstractDoubleConstant(10.0d);

    // Assert
    assertEquals(2, actualAbstractDoubleConstant.size());
    SetAbstractState<JvmTaintSource> getResult = actualAbstractDoubleConstant.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(getResult, actualAbstractDoubleConstant.get(1));
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractFloatConstant(float)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractFloatConstant(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LatticeAbstractState JvmTransferRelation.getAbstractFloatConstant(float)"})
  public void testGetAbstractFloatConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractFloatConstant =
        jvmTaintTransferRelation.getAbstractFloatConstant(10.0f);

    // Assert
    assertTrue(actualAbstractFloatConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractFloatConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractFloatConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractIntegerConstant(int)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractIntegerConstant(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LatticeAbstractState JvmTransferRelation.getAbstractIntegerConstant(int)"})
  public void testGetAbstractIntegerConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractIntegerConstant =
        jvmTaintTransferRelation.getAbstractIntegerConstant(1);

    // Assert
    assertTrue(actualAbstractIntegerConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractIntegerConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractIntegerConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractLongConstant(long)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractLongConstant(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JvmTransferRelation.getAbstractLongConstant(long)"})
  public void testGetAbstractLongConstant() {
    // Arrange and Act
    List<SetAbstractState<JvmTaintSource>> actualAbstractLongConstant =
        (new JvmTaintTransferRelation(new HashMap<>())).getAbstractLongConstant(1L);

    // Assert
    assertEquals(2, actualAbstractLongConstant.size());
    SetAbstractState<JvmTaintSource> getResult = actualAbstractLongConstant.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(getResult, actualAbstractLongConstant.get(1));
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractNull()}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LatticeAbstractState JvmTransferRelation.getAbstractNull()"})
  public void testGetAbstractNull() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractNull =
        jvmTaintTransferRelation.getAbstractNull();

    // Assert
    assertTrue(actualAbstractNull.isEmpty());
    SetAbstractState setAbstractState = actualAbstractNull.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractNull);
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractShortConstant(short)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractShortConstant(short)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LatticeAbstractState JvmTransferRelation.getAbstractShortConstant(short)"})
  public void testGetAbstractShortConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractShortConstant =
        jvmTaintTransferRelation.getAbstractShortConstant((short) 1);

    // Assert
    assertTrue(actualAbstractShortConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractShortConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractShortConstant);
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractReferenceValue(String)} with {@code className}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LatticeAbstractState JvmTransferRelation.getAbstractReferenceValue(String)"})
  public void testGetAbstractReferenceValueWithClassName() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue =
        jvmTaintTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean)}
   * with {@code className}, {@code referencedClazz}, {@code mayBeExtension}, {@code mayBeNull}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LatticeAbstractState JvmTransferRelation.getAbstractReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testGetAbstractReferenceValueWithClassNameReferencedClazzMayBeExtensionMayBeNull() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue =
        jvmTaintTransferRelation.getAbstractReferenceValue(
            "Class Name", new LibraryClass(), true, true);

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int, Object)} with {@code className}, {@code referencedClazz}, {@code
   * mayBeExtension}, {@code mayBeNull}, {@code creationClass}, {@code creationMethod}, {@code
   * creationOffset}, {@code value}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LatticeAbstractState JvmTransferRelation.getAbstractReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  public void
      testGetAbstractReferenceValueWithClassNameReferencedClazzMayBeExtensionMayBeNullCreationClassCreationMethodCreationOffsetValue() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    LibraryClass referencedClazz = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue =
        jvmTaintTransferRelation.getAbstractReferenceValue(
            "Class Name",
            referencedClazz,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value");

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Test {@link JvmTransferRelation#isInstanceOf(LatticeAbstractState, String)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#isInstanceOf(LatticeAbstractState, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LatticeAbstractState JvmTransferRelation.isInstanceOf(LatticeAbstractState, String)"
  })
  public void testIsInstanceOf() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualIsInstanceOfResult =
        jvmTaintTransferRelation.isInstanceOf(null, "Type");

    // Assert
    assertTrue(actualIsInstanceOfResult.isEmpty());
    SetAbstractState setAbstractState = actualIsInstanceOfResult.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualIsInstanceOfResult);
  }

  /**
   * Test {@link JvmTransferRelation#handleCheckCast(LatticeAbstractState, String)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#handleCheckCast(LatticeAbstractState, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LatticeAbstractState JvmTransferRelation.handleCheckCast(LatticeAbstractState, String)"
  })
  public void testHandleCheckCast() {
    // Arrange, Act and Assert
    assertNull((new JvmTaintTransferRelation(new HashMap<>())).handleCheckCast(null, "Type Name"));
  }
}

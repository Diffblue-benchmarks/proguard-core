package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.InstructionOffsetValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.TracedReferenceValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;

public class ReferenceTracingInvocationUnitDiffblueTest {
  /**
   * Test {@link
   * ReferenceTracingInvocationUnit#ReferenceTracingInvocationUnit(SimplifiedInvocationUnit)}.
   *
   * <p>Method under test: {@link
   * ReferenceTracingInvocationUnit#ReferenceTracingInvocationUnit(SimplifiedInvocationUnit)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReferenceTracingInvocationUnit.<init>(SimplifiedInvocationUnit)"})
  public void testNewReferenceTracingInvocationUnit() {
    // Arrange and Act
    ReferenceTracingInvocationUnit actualReferenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));

    // Assert
    assertNull(actualReferenceTracingInvocationUnit.method);
    assertNull(actualReferenceTracingInvocationUnit.stack);
    assertNull(actualReferenceTracingInvocationUnit.variables);
    assertFalse(actualReferenceTracingInvocationUnit.isLoad);
    assertFalse(actualReferenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-eight.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferenceTracingInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventyEight() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -78;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertTrue(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-five.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferenceTracingInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventyFive() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -75;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-four.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferenceTracingInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventyFour() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -74;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-seven.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferenceTracingInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventySeven() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -77;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-six.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferenceTracingInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventySix() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -76;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isStatic);
    assertTrue(referenceTracingInvocationUnit.isLoad);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>Given minus seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferenceTracingInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_givenMinusSeventyTwo() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -72;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction, Stack, Variables)}.
   *
   * <ul>
   *   <li>When {@link ConstantInstruction#ConstantInstruction(byte, int)} with opcode is {@code A}
   *       and constantIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferenceTracingInvocationUnit.invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)"
  })
  public void testInvokeMember_whenConstantInstructionWithOpcodeIsAAndConstantIndexIsOne() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(
        clazz, method, codeAttribute, 2, constantInstruction, stack, new Variables(3));

    // Assert that nothing has changed
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz,
   * ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getExceptionValue(Clazz, ClassConstant)"
  })
  public void testGetExceptionValue_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));

    // Act
    Value actualExceptionValue =
        referenceTracingInvocationUnit.getExceptionValue(new LibraryClass(), null);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualExceptionValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualExceptionValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualExceptionValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Throwable;", ((TracedReferenceValue) actualExceptionValue).getType());
    assertNull(((TracedReferenceValue) actualExceptionValue).getReferencedClass());
    assertEquals(1, ((TracedReferenceValue) actualExceptionValue).isNotNull());
    assertFalse(actualExceptionValue.isCategory2());
    assertFalse(actualExceptionValue.isParticular());
    assertTrue(actualExceptionValue.isSpecific());
    assertEquals(InitializationFinder.NONE, ((TracedReferenceValue) actualExceptionValue).isNull());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz,
   * ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getExceptionValue(Clazz, ClassConstant)"
  })
  public void testGetExceptionValue_whenNull_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));

    // Act
    Value actualExceptionValue =
        referenceTracingInvocationUnit.getExceptionValue(new LibraryClass(), null);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualExceptionValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualExceptionValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualExceptionValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Throwable;", ((TracedReferenceValue) actualExceptionValue).getType());
    assertNull(((TracedReferenceValue) actualExceptionValue).getReferencedClass());
    assertEquals(1, ((TracedReferenceValue) actualExceptionValue).isNotNull());
    assertFalse(actualExceptionValue.isCategory2());
    assertFalse(actualExceptionValue.isParticular());
    assertTrue(actualExceptionValue.isSpecific());
    assertEquals(InitializationFinder.NONE, ((TracedReferenceValue) actualExceptionValue).isNull());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getFieldClassValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldClassValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualFieldClassValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getFieldClassValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldClassValue_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualFieldClassValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getFieldClassValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldClassValue_thenReferenceValueReturnMultiTypedReferenceValue() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ExecutingInvocationUnit(
                KotlinConstants.dummyClassPool,
                KotlinConstants.dummyClassPool,
                valueFactory,
                true,
                new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(referenceValue.isParticular());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getFieldClassValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldClassValue_thenReturnTypeIsLjavaLangObject() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualFieldClassValue).getType());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(
        expectedReferenceValue, ((TracedReferenceValue) actualFieldClassValue).getReferenceValue());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue_thenReferenceValueReturnIdentifiedReferenceValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue_thenReferenceValueReturnMultiTypedReferenceValue() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ExecutingInvocationUnit(
                KotlinConstants.dummyClassPool,
                KotlinConstants.dummyClassPool,
                valueFactory,
                true,
                new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(referenceValue.isParticular());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz,
   * FieldrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldValue_thenReturnTypeIsLjavaLangObject() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualFieldValue).getType());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(
        expectedReferenceValue, ((TracedReferenceValue) actualFieldValue).getReferenceValue());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String,
   * Clazz)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz,
   * Method, int, String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        referenceTracingInvocationUnit.getMethodParameterValue(
            clazz, method, 1, "Type", referencedClass);

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String,
   * Clazz)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz,
   * Method, int, String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        referenceTracingInvocationUnit.getMethodParameterValue(
            clazz, method, 1, "Type", referencedClass);

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String,
   * Clazz)}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz,
   * Method, int, String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue3() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ProgramClass referencedClass = new ProgramClass();

    // Act
    Value actualMethodParameterValue =
        referenceTracingInvocationUnit.getMethodParameterValue(
            clazz, method, 1, "Type", referencedClass);

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String,
   * Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then TraceValue return {@link InstructionOffsetValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz,
   * Method, int, String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue_whenNull_thenTraceValueReturnInstructionOffsetValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        referenceTracingInvocationUnit.getMethodParameterValue(
            clazz, new LibraryMethod(1, "Name", "Descriptor"), 1, "Type", null);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualMethodParameterValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertEquals("Type", ((TracedReferenceValue) actualMethodParameterValue).getType());
    assertNull(((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertTrue(actualMethodParameterValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant,
   * String)} with {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantType() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant,
   * String)} with {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantType2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant,
   * String)} with {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantType3() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualMethodReturnValue).getType());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(
        expectedReferenceValue,
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant,
   * String)} with {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantType4() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ExecutingInvocationUnit(
                KotlinConstants.dummyClassPool,
                KotlinConstants.dummyClassPool,
                valueFactory,
                true,
                new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(referenceValue.isParticular());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant,
   * String)} with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodReturnValue(Clazz, InvokeDynamicConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzInvokeDynamicConstantType() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InvokeDynamicConstant(), "Type");

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant,
   * String)} with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodReturnValue(Clazz, InvokeDynamicConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzInvokeDynamicConstantType2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InvokeDynamicConstant(), "Type");

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant,
   * String)} with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value ReferenceTracingInvocationUnit.getMethodReturnValue(Clazz, InvokeDynamicConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzInvokeDynamicConstantType3() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(
            new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        referenceTracingInvocationUnit.getMethodReturnValue(
            clazz, new InvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()}), "Type");

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue()
            instanceof IdentifiedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) actualMethodReturnValue).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, int)} with {@code value}, {@code
   * trace}.
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingInvocationUnit.trace(Value, int)"})
  public void testTraceWithValueTrace() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));

    // Act
    Value actualTraceResult =
        referenceTracingInvocationUnit.trace(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE),
            1);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualTraceResult).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualTraceResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertSame(valueFactory.REFERENCE_VALUE, referenceValue);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, InstructionOffsetValue)} with {@code
   * value}, {@code traceValue}.
   *
   * <ul>
   *   <li>Then TraceValue return {@link InstructionOffsetValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value,
   * InstructionOffsetValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingInvocationUnit.trace(Value, InstructionOffsetValue)"})
  public void testTraceWithValueTraceValue_thenTraceValueReturnInstructionOffsetValue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit =
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(valueFactory));
    InstructionOffsetValue traceValue = InstructionOffsetValue.EMPTY_VALUE;

    // Act
    Value actualTraceResult =
        referenceTracingInvocationUnit.trace(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE),
            traceValue);

    // Assert
    Value traceValue2 = ((TracedReferenceValue) actualTraceResult).getTraceValue();
    assertTrue(traceValue2 instanceof InstructionOffsetValue);
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualTraceResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isCategory2());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertSame(valueFactory.REFERENCE_VALUE, referenceValue);
    assertSame(traceValue.EMPTY_VALUE, traceValue2);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, int)} with {@code value}, {@code
   * trace}.
   *
   * <ul>
   *   <li>Then return ReferenceValue is {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingInvocationUnit.trace(Value, int)"})
  public void testTraceWithValueTrace_thenReturnReferenceValueIsReference_value() {
    // Arrange
    ReferenceValue value = BasicValueFactory.REFERENCE_VALUE;

    // Act
    Value actualTraceResult =
        (new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())))
            .trace(value, 1);

    // Assert
    assertTrue(
        ((TracedReferenceValue) actualTraceResult).getTraceValue()
            instanceof InstructionOffsetValue);
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualTraceResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertSame(value, referenceValue);
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, int)} with {@code value}, {@code
   * trace}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingInvocationUnit.trace(Value, int)"})
  public void testTraceWithValueTrace_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        value,
        (new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())))
            .trace(value, 1));
  }

  /**
   * Test {@link ReferenceTracingInvocationUnit#trace(Value, int)} with {@code value}, {@code
   * trace}.
   *
   * <ul>
   *   <li>When {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceTracingInvocationUnit.trace(Value, int)"})
  public void testTraceWithValueTrace_whenEmpty_value_thenReturnEmpty_value() {
    // Arrange and Act
    Value actualTraceResult =
        (new ReferenceTracingInvocationUnit(
                new BasicInvocationUnit(new ParticularReferenceValueFactory())))
            .trace(InstructionOffsetValue.EMPTY_VALUE, 1);

    // Assert
    assertSame(((InstructionOffsetValue) actualTraceResult).EMPTY_VALUE, actualTraceResult);
  }
}

package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
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
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.AnalyzedObject;

public class ReferenceTracingInvocationUnitDiffblueTest {
  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack,
        new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -78;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack,
        new Variables(3));

    // Assert
    assertTrue(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember3() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -77;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack,
        new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember4() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -76;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack,
        new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isStatic);
    assertTrue(referenceTracingInvocationUnit.isLoad);
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember5() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -75;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack,
        new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember6() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -74;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack,
        new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertFalse(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#invokeMember(Clazz, Method, CodeAttribute, int, ConstantInstruction, Stack, Variables)}
   */
  @Test
  public void testInvokeMember7() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    constantInstruction.opcode = (byte) -72;
    Stack stack = new Stack(3);

    // Act
    referenceTracingInvocationUnit.invokeMember(clazz, method, codeAttribute, 2, constantInstruction, stack,
        new Variables(3));

    // Assert
    assertFalse(referenceTracingInvocationUnit.isLoad);
    assertTrue(referenceTracingInvocationUnit.isStatic);
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz, ClassConstant)}
   */
  @Test
  public void testGetExceptionValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));

    // Act
    Value actualExceptionValue = referenceTracingInvocationUnit.getExceptionValue(new LibraryClass(), null);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualExceptionValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualExceptionValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualExceptionValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Throwable;", referenceValue.getType());
    assertEquals("Ljava/lang/Throwable;", ((TracedReferenceValue) actualExceptionValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualExceptionValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualExceptionValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, referenceValue.isNotNull());
    assertEquals(1, ((TracedReferenceValue) actualExceptionValue).isNotNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualExceptionValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualExceptionValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualExceptionValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertEquals(InitializationFinder.NONE, referenceValue.isNull());
    assertEquals(InitializationFinder.NONE, ((TracedReferenceValue) actualExceptionValue).isNull());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getExceptionValue(Clazz, ClassConstant)}
   */
  @Test
  public void testGetExceptionValue2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory())));

    // Act
    Value actualExceptionValue = referenceTracingInvocationUnit.getExceptionValue(new LibraryClass(), null);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualExceptionValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualExceptionValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualExceptionValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Throwable;", referenceValue.getType());
    assertEquals("Ljava/lang/Throwable;", ((TracedReferenceValue) actualExceptionValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualExceptionValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualExceptionValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, referenceValue.isNotNull());
    assertEquals(1, ((TracedReferenceValue) actualExceptionValue).isNotNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualExceptionValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualExceptionValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualExceptionValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertEquals(InitializationFinder.NONE, referenceValue.isNull());
    assertEquals(InitializationFinder.NONE, ((TracedReferenceValue) actualExceptionValue).isNull());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldClassValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue = referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(),
        "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualFieldClassValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualFieldClassValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualFieldClassValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldClassValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldClassValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualFieldClassValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualFieldClassValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualFieldClassValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldClassValue2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue = referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(),
        "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualFieldClassValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualFieldClassValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualFieldClassValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldClassValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldClassValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualFieldClassValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualFieldClassValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualFieldClassValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldClassValue3() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue = referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(),
        "Type");

    // Assert
    Value traceValue = ((TracedReferenceValue) actualFieldClassValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualFieldClassValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualFieldClassValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((TracedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((TracedReferenceValue) actualFieldClassValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldClassValue).isNull());
    assertFalse(actualFieldClassValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualFieldClassValue.isParticular());
    assertFalse(actualFieldClassValue.isSpecific());
    assertTrue(traceValue.isParticular());
    assertTrue(traceValue.isSpecific());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedReferenceValue, ((TracedReferenceValue) actualFieldClassValue).getReferenceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldClassValue4() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ExecutingInvocationUnit(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, valueFactory, true,
            new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue = referenceTracingInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(),
        "Type");

    // Assert
    Value traceValue = ((TracedReferenceValue) actualFieldClassValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldClassValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualFieldClassValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualFieldClassValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) referenceValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((TracedReferenceValue) actualFieldClassValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldClassValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldClassValue).isNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldClassValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualFieldClassValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualFieldClassValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(traceValue.isSpecific());
    assertSame(value, generalizedType.getValue());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualFieldValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualFieldValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualFieldValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualFieldValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualFieldValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualFieldValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualFieldValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualFieldValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualFieldValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualFieldValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue3() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    Value traceValue = ((TracedReferenceValue) actualFieldValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualFieldValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualFieldValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((TracedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((TracedReferenceValue) actualFieldValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(actualFieldValue.isSpecific());
    assertTrue(traceValue.isParticular());
    assertTrue(traceValue.isSpecific());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedReferenceValue, ((TracedReferenceValue) actualFieldValue).getReferenceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}
   */
  @Test
  public void testGetFieldValue4() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ExecutingInvocationUnit(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, valueFactory, true,
            new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue = referenceTracingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    Value traceValue = ((TracedReferenceValue) actualFieldValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualFieldValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualFieldValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualFieldValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) referenceValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((TracedReferenceValue) actualFieldValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualFieldValue).isNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualFieldValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(traceValue.isSpecific());
    assertSame(value, generalizedType.getValue());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue = referenceTracingInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type",
        referencedClass);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodParameterValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodParameterValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodParameterValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue = referenceTracingInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type",
        referencedClass);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodParameterValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodParameterValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodParameterValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue3() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ProgramClass referencedClass = new ProgramClass();

    // Act
    Value actualMethodParameterValue = referenceTracingInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type",
        referencedClass);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodParameterValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodParameterValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodParameterValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(referencedClass, ((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}
   */
  @Test
  public void testGetMethodParameterValue4() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodParameterValue = referenceTracingInvocationUnit.getMethodParameterValue(clazz,
        new LibraryMethod(1, "Name", "Descriptor"), 1, "Type", null);

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodParameterValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodParameterValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodParameterValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodParameterValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodParameterValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodParameterValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodParameterValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodParameterValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = referenceTracingInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodReturnValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue2() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = referenceTracingInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodReturnValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue3() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(valueFactory));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = referenceTracingInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(), "Type");

    // Assert
    Value traceValue = ((TracedReferenceValue) actualMethodReturnValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualMethodReturnValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(actualMethodReturnValue.isSpecific());
    assertTrue(traceValue.isParticular());
    assertTrue(traceValue.isSpecific());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedReferenceValue, ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue4() {
    // Arrange
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ExecutingInvocationUnit(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, valueFactory, true,
            new ArrayList<>()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = referenceTracingInvocationUnit.getMethodReturnValue(clazz,
        new InterfaceMethodrefConstant(), "Type");

    // Assert
    Value traceValue = ((TracedReferenceValue) actualMethodReturnValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) referenceValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) referenceValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualMethodReturnValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(((MultiTypedReferenceValue) referenceValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(traceValue.isSpecific());
    assertSame(value, generalizedType.getValue());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue5() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = referenceTracingInvocationUnit.getMethodReturnValue(clazz,
        new InvokeDynamicConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodReturnValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue6() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new ReferenceTracingInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory())));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = referenceTracingInvocationUnit.getMethodReturnValue(clazz,
        new InvokeDynamicConstant(), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodReturnValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   */
  @Test
  public void testGetMethodReturnValue7() {
    // Arrange
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue = referenceTracingInvocationUnit.getMethodReturnValue(clazz,
        new InvokeDynamicConstant(1, 1, new Clazz[]{new LibraryClass()}), "Type");

    // Assert
    ReferenceValue referenceValue = ((TracedReferenceValue) actualMethodReturnValue).getReferenceValue();
    assertTrue(referenceValue instanceof IdentifiedReferenceValue);
    Value traceValue = ((TracedReferenceValue) actualMethodReturnValue).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualMethodReturnValue instanceof TracedReferenceValue);
    assertEquals("Type", referenceValue.getType());
    assertEquals("Type", ((TracedReferenceValue) actualMethodReturnValue).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualMethodReturnValue).getValue();
    assertNull(value.getPreciseValue());
    assertNull(referenceValue.getReferencedClass());
    assertNull(((TracedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNotNull());
    assertEquals(0, referenceValue.isNull());
    assertEquals(0, ((TracedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(traceValue.isParticular());
    assertTrue(actualMethodReturnValue.isSpecific());
    assertTrue(referenceValue.isSpecific());
    assertTrue(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  public void testTrace() {
    // Arrange
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(value,
        (new ReferenceTracingInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory())))
            .trace(value, 1));
  }

  /**
   * Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  public void testTrace2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(valueFactory));

    // Act
    Value actualTraceResult = referenceTracingInvocationUnit
        .trace(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE), 1);

    // Assert
    Value traceValue = ((TracedReferenceValue) actualTraceResult).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualTraceResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertTrue(traceValue.isParticular());
    assertTrue(traceValue.isSpecific());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedReferenceValue, ((TracedReferenceValue) actualTraceResult).getReferenceValue());
  }

  /**
   * Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  public void testTrace3() {
    // Arrange
    ReferenceValue value = BasicValueFactory.REFERENCE_VALUE;

    // Act
    Value actualTraceResult = (new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()))).trace(value, 1);

    // Assert
    Value traceValue = ((TracedReferenceValue) actualTraceResult).getTraceValue();
    assertTrue(traceValue instanceof InstructionOffsetValue);
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    AnalyzedObject value2 = ((TracedReferenceValue) actualTraceResult).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    assertTrue(traceValue.isParticular());
    assertTrue(traceValue.isSpecific());
    assertSame(value, ((TracedReferenceValue) actualTraceResult).getReferenceValue());
  }

  /**
   * Method under test: {@link ReferenceTracingInvocationUnit#trace(Value, int)}
   */
  @Test
  public void testTrace4() {
    // Arrange and Act
    Value actualTraceResult = (new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()))).trace(InstructionOffsetValue.EMPTY_VALUE, 1);

    // Assert
    assertSame(((InstructionOffsetValue) actualTraceResult).EMPTY_VALUE, actualTraceResult);
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#trace(Value, InstructionOffsetValue)}
   */
  @Test
  public void testTrace5() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ReferenceTracingInvocationUnit referenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(valueFactory));
    InstructionOffsetValue traceValue = InstructionOffsetValue.EMPTY_VALUE;

    // Act
    Value actualTraceResult = referenceTracingInvocationUnit
        .trace(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE), traceValue);

    // Assert
    assertTrue(actualTraceResult instanceof TracedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((TracedReferenceValue) actualTraceResult).getType());
    AnalyzedObject value = ((TracedReferenceValue) actualTraceResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((TracedReferenceValue) actualTraceResult).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNotNull());
    assertEquals(0, ((TracedReferenceValue) actualTraceResult).isNull());
    assertFalse(actualTraceResult.isCategory2());
    assertFalse(actualTraceResult.isParticular());
    assertFalse(actualTraceResult.isSpecific());
    ReferenceValue expectedReferenceValue = valueFactory.REFERENCE_VALUE;
    assertSame(expectedReferenceValue, ((TracedReferenceValue) actualTraceResult).getReferenceValue());
    InstructionOffsetValue expectedTraceValue = traceValue.EMPTY_VALUE;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualTraceResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link ReferenceTracingInvocationUnit#ReferenceTracingInvocationUnit(SimplifiedInvocationUnit)}
   */
  @Test
  public void testNewReferenceTracingInvocationUnit() {
    // Arrange and Act
    ReferenceTracingInvocationUnit actualReferenceTracingInvocationUnit = new ReferenceTracingInvocationUnit(
        new BasicInvocationUnit(new ParticularReferenceValueFactory()));

    // Assert
    assertNull(actualReferenceTracingInvocationUnit.method);
    assertNull(actualReferenceTracingInvocationUnit.stack);
    assertNull(actualReferenceTracingInvocationUnit.variables);
    assertFalse(actualReferenceTracingInvocationUnit.isLoad);
    assertFalse(actualReferenceTracingInvocationUnit.isStatic);
  }
}

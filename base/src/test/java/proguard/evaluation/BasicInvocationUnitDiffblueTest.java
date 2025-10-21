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
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;

public class BasicInvocationUnitDiffblueTest {
  /**
   * Test {@link BasicInvocationUnit#BasicInvocationUnit(ValueFactory)}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#BasicInvocationUnit(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicInvocationUnit.<init>(ValueFactory)"})
  public void testNewBasicInvocationUnit() {
    // Arrange and Act
    BasicInvocationUnit actualBasicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualBasicInvocationUnit.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualBasicInvocationUnit.method);
    assertNull(actualBasicInvocationUnit.stack);
    assertNull(actualBasicInvocationUnit.variables);
    assertFalse(actualBasicInvocationUnit.isLoad);
    assertFalse(actualBasicInvocationUnit.isStatic);
  }

  /**
   * Test {@link BasicInvocationUnit#getExceptionValue(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getExceptionValue(Clazz, ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicInvocationUnit.getExceptionValue(Clazz, ClassConstant)"})
  public void testGetExceptionValue() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getExceptionValue(new LibraryClass(), null));
  }

  /**
   * Test {@link BasicInvocationUnit#getExceptionValue(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getExceptionValue(Clazz, ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicInvocationUnit.getExceptionValue(Clazz, ClassConstant)"})
  public void testGetExceptionValue_whenNull_thenReturnIdentifiedReferenceValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());

    // Act
    Value actualExceptionValue = basicInvocationUnit.getExceptionValue(new LibraryClass(), null);

    // Assert
    assertTrue(actualExceptionValue instanceof IdentifiedReferenceValue);
    assertEquals(
        "Ljava/lang/Throwable;", ((IdentifiedReferenceValue) actualExceptionValue).getType());
    assertNull(((IdentifiedReferenceValue) actualExceptionValue).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) actualExceptionValue).isNotNull());
    assertFalse(actualExceptionValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualExceptionValue).mayBeExtension());
    assertTrue(actualExceptionValue.isSpecific());
    assertEquals(
        InitializationFinder.NONE, ((IdentifiedReferenceValue) actualExceptionValue).isNull());
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getFieldClassValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldClassValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        basicInvocationUnit.getFieldClassValue(
            clazz,
            new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor")),
            "Type");

    // Assert
    assertTrue(actualFieldClassValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldClassValue).getType());
    assertNull(((IdentifiedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldClassValue).isNull());
    assertFalse(actualFieldClassValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldClassValue).mayBeExtension());
    assertTrue(actualFieldClassValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getFieldClassValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldClassValue2() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type"));
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getFieldClassValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldClassValue_thenReturnIdentifiedReferenceValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        basicInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldClassValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldClassValue).getType());
    assertNull(((IdentifiedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldClassValue).isNull());
    assertFalse(actualFieldClassValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldClassValue).mayBeExtension());
    assertTrue(actualFieldClassValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldClassValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getFieldClassValue(Clazz, FieldrefConstant, String)"
  })
  public void testGetFieldClassValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldClassValue =
        basicInvocationUnit.getFieldClassValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldClassValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualFieldClassValue).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualFieldClassValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) actualFieldClassValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualFieldClassValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldClassValue.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualFieldClassValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"})
  public void testGetFieldValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        basicInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldValue).getType());
    assertNull(((IdentifiedReferenceValue) actualFieldValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldValue).mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"})
  public void testGetFieldValue2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        executingInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldValue).getType());
    assertNull(((IdentifiedReferenceValue) actualFieldValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldValue).mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"})
  public void testGetFieldValue3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    ExecutingInvocationUnit executingInvocationUnit =
        new ExecutingInvocationUnit(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            valueFactory,
            true,
            new ArrayList<>());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualFieldValue =
        executingInvocationUnit.getFieldValue(
            clazz,
            new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor")),
            "Type");

    // Assert
    assertTrue(actualFieldValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldValue).getType());
    assertNull(((IdentifiedReferenceValue) actualFieldValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldValue).mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"})
  public void testGetFieldValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualFieldValue =
        basicInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type");

    // Assert
    assertTrue(actualFieldValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualFieldValue).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualFieldValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) actualFieldValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualFieldValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualFieldValue.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualFieldValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>Then return {@link PrimitiveTypedReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"})
  public void testGetFieldValue_thenReturnPrimitiveTypedReferenceValueFactoryReference_value() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getFieldValue(clazz, new FieldrefConstant(), "Type"));
  }

  /**
   * Test {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant, String)}.
   *
   * <ul>
   *   <li>When {@link LibraryField#LibraryField(int, String, String)} with u2accessFlags is one and
   *       {@code Name} and {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getFieldValue(Clazz, FieldrefConstant,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicInvocationUnit.getFieldValue(Clazz, FieldrefConstant, String)"})
  public void testGetFieldValue_whenLibraryFieldWithU2accessFlagsIsOneAndNameAndDescriptor() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualFieldValue =
        basicInvocationUnit.getFieldValue(
            clazz,
            new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor")),
            "Type");

    // Assert
    assertTrue(actualFieldValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualFieldValue).getType());
    assertNull(((IdentifiedReferenceValue) actualFieldValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualFieldValue).isNull());
    assertFalse(actualFieldValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualFieldValue).mayBeExtension());
    assertTrue(actualFieldValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int,
   * String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type", new LibraryClass()));
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int,
   * String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue_thenReferencedClassReturnLibraryClass() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        basicInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type", referencedClass);

    // Assert
    Clazz referencedClass2 =
        ((MultiTypedReferenceValue) actualMethodParameterValue).getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualMethodParameterValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualMethodParameterValue).getType());
    assertEquals(
        1, ((MultiTypedReferenceValue) actualMethodParameterValue).getPotentialTypes().size());
    assertFalse(actualMethodParameterValue.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualMethodParameterValue).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}.
   *
   * <ul>
   *   <li>Then return Null is zero.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int,
   * String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue_thenReturnNullIsZero() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        basicInvocationUnit.getMethodParameterValue(
            clazz, new LibraryMethod(8, "Name", "Descriptor"), 0, "Type", null);

    // Assert
    assertTrue(actualMethodParameterValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodParameterValue).getType());
    assertNull(((IdentifiedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodParameterValue).isNull());
    assertFalse(actualMethodParameterValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodParameterValue).mayBeExtension());
    assertTrue(actualMethodParameterValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}.
   *
   * <ul>
   *   <li>Then return ReferencedClass is {@link LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int,
   * String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue_thenReturnReferencedClassIsLibraryClass() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        basicInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type", referencedClass);

    // Assert
    assertTrue(actualMethodParameterValue instanceof IdentifiedReferenceValue);
    assertSame(
        referencedClass,
        ((IdentifiedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}.
   *
   * <ul>
   *   <li>Then return ReferencedClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int,
   * String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue_thenReturnReferencedClassIsProgramClass() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ProgramClass referencedClass = new ProgramClass();

    // Act
    Value actualMethodParameterValue =
        basicInvocationUnit.getMethodParameterValue(clazz, method, 1, "Type", referencedClass);

    // Assert
    assertTrue(actualMethodParameterValue instanceof IdentifiedReferenceValue);
    assertSame(
        referencedClass,
        ((IdentifiedReferenceValue) actualMethodParameterValue).getReferencedClass());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int, String, Clazz)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodParameterValue(Clazz, Method, int,
   * String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodParameterValue(Clazz, Method, int, String, Clazz)"
  })
  public void testGetMethodParameterValue_whenZero_thenReturnNotNullIsOne() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodParameterValue =
        basicInvocationUnit.getMethodParameterValue(
            clazz, new LibraryMethod(1, "Name", "Descriptor"), 0, "Type", null);

    // Assert
    assertTrue(actualMethodParameterValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodParameterValue).getType());
    assertNull(((IdentifiedReferenceValue) actualMethodParameterValue).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) actualMethodParameterValue).isNotNull());
    assertFalse(actualMethodParameterValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodParameterValue).mayBeExtension());
    assertTrue(actualMethodParameterValue.isSpecific());
    assertEquals(
        InitializationFinder.NONE,
        ((IdentifiedReferenceValue) actualMethodParameterValue).isNull());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)} with
   * {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantType() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        basicInvocationUnit.getMethodReturnValue(clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((IdentifiedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodReturnValue).mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)} with
   * {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantType2() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        basicInvocationUnit.getMethodReturnValue(clazz, new InterfaceMethodrefConstant(), "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualMethodReturnValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(
        1, ((MultiTypedReferenceValue) actualMethodReturnValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualMethodReturnValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)} with
   * {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantType3() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        basicInvocationUnit.getMethodReturnValue(
            clazz,
            new InterfaceMethodrefConstant(
                1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor")),
            "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((IdentifiedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodReturnValue).mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodReturnValue(Clazz, AnyMethodrefConstant, String)} with
   * {@code clazz}, {@code anyMethodrefConstant}, {@code type}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodReturnValue(Clazz,
   * AnyMethodrefConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodReturnValue(Clazz, AnyMethodrefConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzAnyMethodrefConstantType4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getMethodReturnValue(clazz, new InterfaceMethodrefConstant(), "Type"));
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   * with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodReturnValue(Clazz, InvokeDynamicConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzInvokeDynamicConstantType() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        basicInvocationUnit.getMethodReturnValue(clazz, new InvokeDynamicConstant(), "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((IdentifiedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodReturnValue).mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   * with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodReturnValue(Clazz, InvokeDynamicConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzInvokeDynamicConstantType2() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    invokeDynamicConstant.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    Value actualMethodReturnValue =
        basicInvocationUnit.getMethodReturnValue(clazz, invokeDynamicConstant, "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) actualMethodReturnValue).getType());
    assertNull(((IdentifiedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) actualMethodReturnValue).isNull());
    assertFalse(actualMethodReturnValue.isParticular());
    assertTrue(((IdentifiedReferenceValue) actualMethodReturnValue).mayBeExtension());
    assertTrue(actualMethodReturnValue.isSpecific());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   * with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodReturnValue(Clazz, InvokeDynamicConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzInvokeDynamicConstantType3() {
    // Arrange
    BasicInvocationUnit basicInvocationUnit =
        new BasicInvocationUnit(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    Value actualMethodReturnValue =
        basicInvocationUnit.getMethodReturnValue(clazz, new InvokeDynamicConstant(), "Type");

    // Assert
    assertTrue(actualMethodReturnValue instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualMethodReturnValue).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualMethodReturnValue).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) actualMethodReturnValue).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(
        1, ((MultiTypedReferenceValue) actualMethodReturnValue).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMethodReturnValue.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualMethodReturnValue).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link BasicInvocationUnit#getMethodReturnValue(Clazz, InvokeDynamicConstant, String)}
   * with {@code clazz}, {@code invokeDynamicConstant}, {@code type}.
   *
   * <p>Method under test: {@link BasicInvocationUnit#getMethodReturnValue(Clazz,
   * InvokeDynamicConstant, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Value BasicInvocationUnit.getMethodReturnValue(Clazz, InvokeDynamicConstant, String)"
  })
  public void testGetMethodReturnValueWithClazzInvokeDynamicConstantType4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();
    BasicInvocationUnit basicInvocationUnit = new BasicInvocationUnit(valueFactory);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        basicInvocationUnit.getMethodReturnValue(clazz, new InvokeDynamicConstant(), "Type"));
  }
}

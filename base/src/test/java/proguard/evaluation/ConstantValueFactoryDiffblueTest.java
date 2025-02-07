package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.ArrayReferenceValueFactory;
import proguard.evaluation.value.DetailedArrayReferenceValue;
import proguard.evaluation.value.DetailedArrayValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValue;
import proguard.evaluation.value.MultiTypedReferenceValueFactory;
import proguard.evaluation.value.ParticularReferenceValue;
import proguard.evaluation.value.PrimitiveTypedReferenceValueFactory;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.UnknownFloatValue;
import proguard.evaluation.value.UnknownIntegerValue;
import proguard.evaluation.value.UnknownLongValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.ValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

class ConstantValueFactoryDiffblueTest {
  /**
   * Test {@link ConstantValueFactory#ConstantValueFactory(ValueFactory)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#ConstantValueFactory(ValueFactory)}
   */
  @Test
  @DisplayName("Test new ConstantValueFactory(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.<init>(proguard.evaluation.value.ValueFactory)"
  })
  void testNewConstantValueFactory() {
    // Arrange and Act
    ConstantValueFactory actualConstantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualConstantValueFactory.valueFactory instanceof ParticularReferenceValueFactory);
    assertNull(actualConstantValueFactory.value);
  }

  /**
   * Test {@link ConstantValueFactory#constantValue(Clazz, int)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantValueFactory#constantValue(Clazz, int)}
   */
  @Test
  @DisplayName("Test constantValue(Clazz, int); when LibraryClass(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.ConstantValueFactory.constantValue(proguard.classfile.Clazz, int)"
  })
  void testConstantValue_whenLibraryClass_thenReturnNull() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());

    // Act and Assert
    assertNull(constantValueFactory.constantValue(new LibraryClass(), 1));
  }

  /**
   * Test {@link ConstantValueFactory#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @DisplayName("Test visitIntegerConstant(Clazz, IntegerConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitIntegerConstant(proguard.classfile.Clazz, proguard.classfile.constant.IntegerConstant)"
  })
  void testVisitIntegerConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitIntegerConstant(clazz, new IntegerConstant(42));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownIntegerValue);
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Test {@link ConstantValueFactory#visitLongConstant(Clazz, LongConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  @DisplayName("Test visitLongConstant(Clazz, LongConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitLongConstant(proguard.classfile.Clazz, proguard.classfile.constant.LongConstant)"
  })
  void testVisitLongConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitLongConstant(clazz, new LongConstant(42L));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownLongValue);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertTrue(value.isCategory2());
  }

  /**
   * Test {@link ConstantValueFactory#visitFloatConstant(Clazz, FloatConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  @DisplayName("Test visitFloatConstant(Clazz, FloatConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitFloatConstant(proguard.classfile.Clazz, proguard.classfile.constant.FloatConstant)"
  })
  void testVisitFloatConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitFloatConstant(clazz, new FloatConstant(10.0f));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownFloatValue);
    assertFalse(value.isCategory2());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Test {@link ConstantValueFactory#visitDoubleConstant(Clazz, DoubleConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  @DisplayName("Test visitDoubleConstant(Clazz, DoubleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitDoubleConstant(proguard.classfile.Clazz, proguard.classfile.constant.DoubleConstant)"
  })
  void testVisitDoubleConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitDoubleConstant(clazz, new DoubleConstant(10.0d));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownDoubleValue);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertTrue(value.isCategory2());
  }

  /**
   * Test {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @DisplayName("Test visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)"
  })
  void testVisitPrimitiveArrayConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("[\u0000", ((IdentifiedReferenceValue) value).getType());
    AnalyzedObject value2 = ((IdentifiedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @DisplayName("Test visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)"
  })
  void testVisitPrimitiveArrayConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new DetailedArrayValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof DetailedArrayReferenceValue);
    AnalyzedObject value2 = ((DetailedArrayReferenceValue) value).getValue();
    Model modeledOrNullValue = value2.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[\u0000", modeledOrNullValue.getType());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    assertSame(modeledOrNullValue, value2.getModeledValue());
  }

  /**
   * Test {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @DisplayName("Test visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)"
  })
  void testVisitPrimitiveArrayConstant3() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitPrimitiveArrayConstant(clazz, new PrimitiveArrayConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertEquals("[\u0000", ((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertEquals("[\u0000", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) value).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(value.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(value.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertEquals(InitializationFinder.NONE, generalizedType.isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantValueFactory.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(clazz).getString(eq(0));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof ParticularReferenceValue);
    assertEquals("String", ((ParticularReferenceValue) value).getValue().getPreciseValue());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((ParticularReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ArrayReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantValueFactory.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(clazz).getString(eq(0));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof TypedReferenceValue);
    AnalyzedObject value2 = ((TypedReferenceValue) value).getValue();
    assertNull(value2.getPreciseValue());
    assertNull(value2.getModeledOrNullValue());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((TypedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant3() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    constantValueFactory.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof ParticularReferenceValue);
    assertEquals("String", ((ParticularReferenceValue) value).getValue().getPreciseValue());
    assertTrue(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((ParticularReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant4() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    constantValueFactory.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isParticular());
  }

  /**
   * Test {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName("Test visitDynamicConstant(Clazz, DynamicConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    constantValueFactory.visitDynamicConstant(clazz, new DynamicConstant());

    // Assert
    verify(clazz).getType(eq(0));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertTrue(((IdentifiedReferenceValue) value).mayBeExtension());
    assertTrue(value.isSpecific());
  }

  /**
   * Test {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName("Test visitDynamicConstant(Clazz, DynamicConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(
            new MultiTypedReferenceValueFactory(
                true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    constantValueFactory.visitDynamicConstant(clazz, new DynamicConstant());

    // Assert
    verify(clazz).getType(eq(0));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) value).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) value).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertNull(((MultiTypedReferenceValue) value).getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) value).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(value.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(((MultiTypedReferenceValue) value).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
  }

  /**
   * Test {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName("Test visitDynamicConstant(Clazz, DynamicConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant3() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    constantValueFactory.visitDynamicConstant(
        clazz, new DynamicConstant(1, 1, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(clazz).getType(eq(1));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertTrue(((IdentifiedReferenceValue) value).mayBeExtension());
    assertTrue(value.isSpecific());
  }

  /**
   * Test {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName("Test visitDynamicConstant(Clazz, DynamicConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant4() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    DynamicConstant dynamicConstant = mock(DynamicConstant.class);
    when(dynamicConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantValueFactory.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    verify(dynamicConstant).getType(isA(Clazz.class));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isParticular());
  }

  /**
   * Test {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link DynamicConstant#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantValueFactory#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); when LibraryClass; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_whenLibraryClass_thenCallsGetType() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    DynamicConstant dynamicConstant = mock(DynamicConstant.class);
    when(dynamicConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantValueFactory.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    verify(dynamicConstant).getType(isA(Clazz.class));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Type", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(0, ((IdentifiedReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertTrue(((IdentifiedReferenceValue) value).mayBeExtension());
    assertTrue(value.isSpecific());
  }

  /**
   * Test {@link ConstantValueFactory#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName("Test visitMethodHandleConstant(Clazz, MethodHandleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Ljava/lang/invoke/MethodHandle;", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName("Test visitMethodHandleConstant(Clazz, MethodHandleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Test {@link ConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantValueFactory.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("LString;", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("");

    // Act
    constantValueFactory.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("L;", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant3() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantValueFactory.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("LName;", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant4() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantValueFactory.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }

  /**
   * Test {@link ConstantValueFactory#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName("Test visitMethodTypeConstant(Clazz, MethodTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new ParticularReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof IdentifiedReferenceValue);
    assertEquals("Ljava/lang/invoke/MethodType;", ((IdentifiedReferenceValue) value).getType());
    assertNull(((IdentifiedReferenceValue) value).getReferencedClass());
    assertEquals(1, ((IdentifiedReferenceValue) value).isNotNull());
    assertFalse(((IdentifiedReferenceValue) value).mayBeExtension());
    assertFalse(value.isParticular());
    assertTrue(value.isSpecific());
    assertEquals(InitializationFinder.NONE, ((IdentifiedReferenceValue) value).isNull());
  }

  /**
   * Test {@link ConstantValueFactory#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <p>Method under test: {@link ConstantValueFactory#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName("Test visitMethodTypeConstant(Clazz, MethodTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.ConstantValueFactory.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant2() {
    // Arrange
    ConstantValueFactory constantValueFactory =
        new ConstantValueFactory(new PrimitiveTypedReferenceValueFactory());
    LibraryClass clazz = new LibraryClass();

    // Act
    constantValueFactory.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    Value value = constantValueFactory.value;
    assertTrue(value instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", ((UnknownReferenceValue) value).getType());
    assertNull(((UnknownReferenceValue) value).getReferencedClass());
    assertEquals(0, ((UnknownReferenceValue) value).isNotNull());
    assertEquals(0, ((UnknownReferenceValue) value).isNull());
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
  }
}

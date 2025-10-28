package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.object.AnalyzedObject;

public class MultiTypedReferenceValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createReferenceValueNull()}
   */
  @Test
  public void testCreateReferenceValueNull() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueNullResult = multiTypedReferenceValueFactory.createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof MultiTypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueNullResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueNullResult.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueNullResult.isCategory2());
    assertFalse(actualCreateReferenceValueNullResult.isParticular());
    assertFalse(actualCreateReferenceValueNullResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).mayBeUnknown);
    assertEquals(Value.NEVER, actualCreateReferenceValueNullResult.isNotNull());
    ReferenceValue expectedGeneralizedType = multiTypedReferenceValueFactory.REFERENCE_VALUE_NULL;
    assertSame(expectedGeneralizedType,
        ((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = multiTypedReferenceValueFactory.createReferenceValue("Type",
        referencedClass, true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueResult)
        .getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue2() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult = multiTypedReferenceValueFactory.createReferenceValue(null,
        new LibraryClass(), false, false);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
    ReferenceValue expectedGeneralizedType = multiTypedReferenceValueFactory.REFERENCE_VALUE_NULL;
    assertSame(expectedGeneralizedType,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue3() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = multiTypedReferenceValueFactory
        .createReferenceValue("Ljava/lang/Object;", referencedClass, false, false);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualCreateReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateReferenceValueResult)
        .getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, actualCreateReferenceValueResult.isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeExtension);
    assertFalse(generalizedType.mayBeNull);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue4() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult = multiTypedReferenceValueFactory
        .createReferenceValue("Ljava/lang/Object;", new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    ReferenceValue expectedGeneralizedType = multiTypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;
    assertSame(expectedGeneralizedType,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue5() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult = multiTypedReferenceValueFactory
        .createReferenceValue("Ljava/lang/Object;", new LibraryClass(), true, false);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getPotentialTypes().size());
    assertEquals(1, actualCreateReferenceValueResult.isNotNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueResult).mayBeUnknown);
    ReferenceValue expectedGeneralizedType = multiTypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;
    assertSame(expectedGeneralizedType,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = multiTypedReferenceValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult)
        .getGeneralizedType();
    assertEquals("[Type", generalizedType.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeExtension);
    assertFalse(generalizedType.mayBeNull);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = multiTypedReferenceValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult)
        .getGeneralizedType();
    assertEquals("[Type", generalizedType.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeExtension);
    assertFalse(generalizedType.mayBeNull);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue3() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = multiTypedReferenceValueFactory
        .createArrayReferenceValue("Ljava/lang/Object;", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Ljava/lang/Object;", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult)
        .getGeneralizedType();
    assertEquals("[Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeExtension);
    assertFalse(generalizedType.mayBeNull);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue4() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = multiTypedReferenceValueFactory
        .createArrayReferenceValue("Ljava/lang/Object;", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Ljava/lang/Object;", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult)
        .getGeneralizedType();
    assertEquals("[Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeExtension);
    assertFalse(generalizedType.mayBeNull);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue5() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = multiTypedReferenceValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult)
        .getGeneralizedType();
    assertEquals("[Type", generalizedType.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeExtension);
    assertFalse(generalizedType.mayBeNull);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = multiTypedReferenceValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue2() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = multiTypedReferenceValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue3() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();

    // Act
    Value actualCreateValueResult = multiTypedReferenceValueFactory.createValue("Ljava/lang/Object;",
        new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    ReferenceValue expectedGeneralizedType = multiTypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;
    assertSame(expectedGeneralizedType, ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue4() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = multiTypedReferenceValueFactory.createValue("Type", referencedClass, false, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue5() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = multiTypedReferenceValueFactory.createValue("Type", referencedClass, true, false);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeNull);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(generalizedType.mayBeExtension);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue6() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory(true,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act
    Value actualCreateValueResult = multiTypedReferenceValueFactory.createValue("Ljava/lang/Object;",
        new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    ReferenceValue expectedGeneralizedType = multiTypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;
    assertSame(expectedGeneralizedType, ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue7() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = multiTypedReferenceValueFactory.createValue("Ljava/lang/Object;", referencedClass,
        false, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(generalizedType.isSpecific());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    assertFalse(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue8() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory = new MultiTypedReferenceValueFactory();

    // Act
    Value actualCreateValueResult = multiTypedReferenceValueFactory.createValue("Ljava/lang/Object;",
        new LibraryClass(), true, false);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    AnalyzedObject value = ((MultiTypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).getPotentialTypes().size());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(actualCreateValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateValueResult).mayBeUnknown);
    ReferenceValue expectedGeneralizedType = multiTypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;
    assertSame(expectedGeneralizedType, ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType());
  }
}

package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.analysis.cpa.jvm.domain.value.JvmCfaReferenceValueFactory;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.object.AnalyzedObject;

public class TypedReferenceValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link TypedReferenceValueFactory#createReferenceValueNull()}
   */
  @Test
  public void testCreateReferenceValueNull() {
    // Arrange
    TypedReferenceValueFactory typedReferenceValueFactory = new TypedReferenceValueFactory();

    // Act and Assert
    assertSame(typedReferenceValueFactory.REFERENCE_VALUE_NULL, typedReferenceValueFactory.createReferenceValueNull());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    TypedReferenceValueFactory typedReferenceValueFactory = new TypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = typedReferenceValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory = new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = jvmCfaReferenceValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue3() {
    // Arrange
    TypedReferenceValueFactory typedReferenceValueFactory = new TypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = typedReferenceValueFactory
        .createArrayReferenceValue("Ljava/lang/Object;", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("[Ljava/lang/Object;", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue4() {
    // Arrange
    TypedReferenceValueFactory typedReferenceValueFactory = new TypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = typedReferenceValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link TypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue5() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory = new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = jvmCfaReferenceValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }
}

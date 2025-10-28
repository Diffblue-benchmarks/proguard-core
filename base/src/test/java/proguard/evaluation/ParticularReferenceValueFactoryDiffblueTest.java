package proguard.evaluation;

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
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.object.AnalyzedObject;

public class ParticularReferenceValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue("Type",
        referencedClass, true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue(null,
        new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue3() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue(null,
        new LibraryClass(), true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue4() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue5() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue(null,
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue6() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory = new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = jvmCfaReferenceValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualCreateReferenceValueResult).id);
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue7() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue(null,
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = particularReferenceValueFactory
        .createReferenceValueForId("Type", referencedClass, true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof IdentifiedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = particularReferenceValueFactory
        .createReferenceValueForId(null, new LibraryClass(), true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueForIdResult.getType());
    assertNull(actualCreateReferenceValueForIdResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueForIdResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link ParticularReferenceValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId3() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = particularReferenceValueFactory
        .createReferenceValueForId(null, new LibraryClass(), true, true, "Id", "Value");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueForIdResult.getType());
    assertNull(actualCreateReferenceValueForIdResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueForIdResult.isNotNull());
  }
}

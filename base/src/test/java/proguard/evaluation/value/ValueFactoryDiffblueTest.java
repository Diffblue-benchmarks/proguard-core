package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class ValueFactoryDiffblueTest {
  /**
   * Method under test: {@link ValueFactory#createReferenceValue(Clazz)}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue(clazz);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("LThis Class Name;", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(clazz, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ValueFactory#createReferenceValue(Clazz)}
   */
  @Test
  public void testCreateReferenceValue2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(Value.NEVER, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue(clazz);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("LThis Class Name;", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(clazz, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test: {@link ValueFactory#createReferenceValue(Clazz, Object)}
   */
  @Test
  public void testCreateReferenceValue3() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory = new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularReferenceValueFactory.createReferenceValue(clazz,
        (Object) null);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals("LThis Class Name;", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
    assertSame(clazz, actualCreateReferenceValueResult.getReferencedClass());
  }
}

package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

class ValueFactoryDiffblueTest {
  /**
   * Test {@link ValueFactory#createReferenceValue(Clazz, AnalyzedObject)} with {@code Clazz},
   * {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ValueFactory#createReferenceValue(Clazz, AnalyzedObject)}
   */
  @Test
  @DisplayName("Test createReferenceValue(Clazz, AnalyzedObject) with 'Clazz', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ValueFactory.createReferenceValue(proguard.classfile.Clazz, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzAnalyzedObject() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass clazz =
        new LibraryClass(
            12, "The object value should not be null", "The object value should not be null");

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(null);
    when(value.isModeled()).thenReturn(true);

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(clazz, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).isModeled();
    Clazz referencedClass = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals(
        "LThe object value should not be null;", actualCreateReferenceValueResult.getType());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
    assertSame(clazz, referencedClass);
  }

  /**
   * Test {@link ValueFactory#createReferenceValue(Clazz, Object)} with {@code Clazz}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link ValueFactory#createReferenceValue(Clazz, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, Object) with 'Clazz', 'Object'; then ReferencedClass return LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ValueFactory.createReferenceValue(proguard.classfile.Clazz, java.lang.Object)"
  })
  void testCreateReferenceValueWithClazzObject_thenReferencedClassReturnLibraryClass() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(clazz, (Object) null);

    // Assert
    Clazz referencedClass = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals("LThis Class Name;", actualCreateReferenceValueResult.getType());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
    assertSame(clazz, referencedClass);
  }

  /**
   * Test {@link ValueFactory#createReferenceValue(Clazz)} with {@code Clazz}.
   *
   * <ul>
   *   <li>Then return mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link ValueFactory#createReferenceValue(Clazz)}
   */
  @Test
  @DisplayName("Test createReferenceValue(Clazz) with 'Clazz'; then return mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ValueFactory.createReferenceValue(proguard.classfile.Clazz)"
  })
  void testCreateReferenceValueWithClazz_thenReturnMayBeExtension() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(clazz);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertSame(clazz, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Test {@link ValueFactory#createReferenceValue(Clazz)} with {@code Clazz}.
   *
   * <ul>
   *   <li>Then return not mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link ValueFactory#createReferenceValue(Clazz)}
   */
  @Test
  @DisplayName("Test createReferenceValue(Clazz) with 'Clazz'; then return not mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ValueFactory.createReferenceValue(proguard.classfile.Clazz)"
  })
  void testCreateReferenceValueWithClazz_thenReturnNotMayBeExtension() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass clazz = new LibraryClass(Value.NEVER, "This Class Name", "Super Class Name");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(clazz);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertSame(clazz, actualCreateReferenceValueResult.getReferencedClass());
  }
}

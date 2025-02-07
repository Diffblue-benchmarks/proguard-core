package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
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
import proguard.evaluation.value.object.model.ClassLoaderModel;

class ParticularReferenceValueDiffblueTest {
  /**
   * Test {@link ParticularReferenceValue#ParticularReferenceValue(Clazz, ValueFactory, Object,
   * AnalyzedObject)}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#ParticularReferenceValue(Clazz,
   * ValueFactory, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName("Test new ParticularReferenceValue(Clazz, ValueFactory, Object, AnalyzedObject)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.ParticularReferenceValue.<init>(proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testNewParticularReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ParticularReferenceValue actualParticularReferenceValue =
        new ParticularReferenceValue(referencedClass, valueFactory, "Reference ID", value);

    // Assert
    verify(value, atLeast(1)).getType();
    Clazz referencedClass2 = actualParticularReferenceValue.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertEquals("Reference ID", actualParticularReferenceValue.id);
    assertEquals("Type", actualParticularReferenceValue.getType());
    assertEquals(1, actualParticularReferenceValue.isNotNull());
    assertFalse(actualParticularReferenceValue.isCategory2());
    assertFalse(actualParticularReferenceValue.mayBeExtension());
    assertFalse(actualParticularReferenceValue.mayBeExtension);
    assertTrue(actualParticularReferenceValue.isSpecific());
    assertTrue(actualParticularReferenceValue.isParticular());
    assertTrue(actualParticularReferenceValue.mayBeNull);
    assertEquals(Value.NEVER, actualParticularReferenceValue.isNull());
    assertSame(referencedClass, referencedClass2);
    assertSame(value, actualParticularReferenceValue.getValue());
  }

  /**
   * Test {@link ParticularReferenceValue#value()}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#getPreciseValue()} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#value()}
   */
  @Test
  @DisplayName(
      "Test value(); given AnalyzedObject getPreciseValue() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object proguard.evaluation.value.ParticularReferenceValue.value()"})
  void testValue_givenAnalyzedObjectGetPreciseValueReturnFalse_thenReturnFalse() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.getPreciseValue()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Object actualValueResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .value();

    // Assert
    verify(value).getPreciseValue();
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
    assertFalse((Boolean) actualValueResult);
  }

  /**
   * Test {@link ParticularReferenceValue#value()}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#getPreciseValue()} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#value()}
   */
  @Test
  @DisplayName(
      "Test value(); given AnalyzedObject getPreciseValue() return 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object proguard.evaluation.value.ParticularReferenceValue.value()"})
  void testValue_givenAnalyzedObjectGetPreciseValueReturnTrue_thenReturnTrue() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.getPreciseValue()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Object actualValueResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .value();

    // Assert
    verify(value).getPreciseValue();
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
    assertTrue((Boolean) actualValueResult);
  }

  /**
   * Test {@link ParticularReferenceValue#value()}.
   *
   * <ul>
   *   <li>Then return {@link ClassLoaderModel}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#value()}
   */
  @Test
  @DisplayName("Test value(); then return ClassLoaderModel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object proguard.evaluation.value.ParticularReferenceValue.value()"})
  void testValue_thenReturnClassLoaderModel() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();
    when(value.getModeledValue()).thenReturn(classLoaderModel);
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Object actualValueResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .value();

    // Assert
    verify(value).getModeledValue();
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
    assertTrue(actualValueResult instanceof ClassLoaderModel);
    assertEquals("Ljava/lang/ClassLoader;", ((ClassLoaderModel) actualValueResult).getType());
    assertSame(classLoaderModel, actualValueResult);
  }

  /**
   * Test {@link ParticularReferenceValue#value()}.
   *
   * <ul>
   *   <li>Then return {@code Precise Value}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#value()}
   */
  @Test
  @DisplayName("Test value(); then return 'Precise Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object proguard.evaluation.value.ParticularReferenceValue.value()"})
  void testValue_thenReturnPreciseValue() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.getPreciseValue()).thenReturn("Precise Value");
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Object actualValueResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .value();

    // Assert
    verify(value).getPreciseValue();
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
    assertEquals("Precise Value", actualValueResult);
  }

  /**
   * Test {@link ParticularReferenceValue#value()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#value()}
   */
  @Test
  @DisplayName("Test value(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object proguard.evaluation.value.ParticularReferenceValue.value()"})
  void testValue_thenThrowIllegalStateException() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenThrow(new IllegalStateException("foo"));
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            (new ParticularReferenceValue(
                    referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
                .value());
    verify(value).getModeledValue();
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
  }

  /**
   * Test {@link ParticularReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code false}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#isNull()}
   */
  @Test
  @DisplayName("Test isNull(); given AnalyzedObject isNull() return 'false'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.ParticularReferenceValue.isNull()"})
  void testIsNull_givenAnalyzedObjectIsNullReturnFalse_thenReturnNever() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualIsNullResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .isNull();

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value).isNull();
    assertEquals(Value.NEVER, actualIsNullResult);
  }

  /**
   * Test {@link ParticularReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code true}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#isNull()}
   */
  @Test
  @DisplayName("Test isNull(); given AnalyzedObject isNull() return 'true'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.ParticularReferenceValue.isNull()"})
  void testIsNull_givenAnalyzedObjectIsNullReturnTrue_thenReturnOne() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualIsNullResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .isNull();

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value).isNull();
    assertEquals(1, actualIsNullResult);
  }

  /**
   * Test {@link ParticularReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#isNull()}
   */
  @Test
  @DisplayName("Test isNull(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.ParticularReferenceValue.isNull()"})
  void testIsNull_thenThrowIllegalStateException() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenThrow(new IllegalStateException("foo"));
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            (new ParticularReferenceValue(
                    referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
                .isNull());
    verify(value, atLeast(1)).getType();
    verify(value).isNull();
  }

  /**
   * Test {@link ParticularReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            null, new ParticularReferenceValueFactory(), "Reference ID", value);

    // Act
    int actualInstanceOfResult =
        particularReferenceValue.instanceOf("Other Type", new LibraryClass());

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualInstanceOfResult);
  }

  /**
   * Test {@link ParticularReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf2() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass =
        new LibraryClass(Short.SIZE, "This Class Name", "Super Class Name");

    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    // Act
    int actualInstanceOfResult =
        particularReferenceValue.instanceOf("Other Type", new LibraryClass());

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(Value.NEVER, actualInstanceOfResult);
  }

  /**
   * Test {@link ParticularReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz); then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf_thenReturnNever() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    // Act
    int actualInstanceOfResult =
        particularReferenceValue.instanceOf("Other Type", new LibraryClass());

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(Value.NEVER, actualInstanceOfResult);
  }

  /**
   * Test {@link ParticularReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz); when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf_whenNull_thenReturnZero() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualInstanceOfResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .instanceOf("Other Type", null);

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualInstanceOfResult);
  }

  /**
   * Test {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        particularReferenceValue.cast(
            "Type", referencedClass2, new ParticularReferenceValueFactory(), true);

    // Assert
    verify(value, atLeast(1)).getType();
    assertSame(particularReferenceValue, actualCastResult);
  }

  /**
   * Test {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast2() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        particularReferenceValue.cast(
            "Type", referencedClass2, new ParticularReferenceValueFactory(), false);

    // Assert
    verify(value, atLeast(1)).getType();
    assertSame(particularReferenceValue, actualCastResult);
  }

  /**
   * Test {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast3() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("foo");
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            null, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        particularReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCastResult instanceof IdentifiedReferenceValue);
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isParticular());
    assertTrue(actualCastResult.mayBeExtension());
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#getType()} return {@code foo}.
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); given AnalyzedObject getType() return 'foo'; then return IdentifiedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_givenAnalyzedObjectGetTypeReturnFoo_thenReturnIdentifiedReferenceValue() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("foo");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        particularReferenceValue.cast(
            "Type", referencedClass2, new ParticularReferenceValueFactory(), true);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCastResult instanceof IdentifiedReferenceValue);
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isParticular());
    assertTrue(actualCastResult.mayBeExtension());
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayReferenceValueFactory} (default constructor).
   *   <li>Then return {@link TypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when ArrayReferenceValueFactory (default constructor); then return TypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_whenArrayReferenceValueFactory_thenReturnTypedReferenceValue() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("foo");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        particularReferenceValue.cast(
            "Type", referencedClass2, new ArrayReferenceValueFactory(), true);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCastResult instanceof TypedReferenceValue);
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertTrue(actualCastResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCastResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link MultiTypedReferenceValueFactory#MultiTypedReferenceValueFactory()}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when MultiTypedReferenceValueFactory(); then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_whenMultiTypedReferenceValueFactory_thenReturnType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("foo");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        particularReferenceValue.cast(
            "Type", referencedClass2, new MultiTypedReferenceValueFactory(), true);

    // Assert
    verify(value, atLeast(1)).getType();
    Clazz referencedClass3 = actualCastResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    assertSame(referencedClass2, referencedClass3);
  }

  /**
   * Test {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link MultiTypedReferenceValueFactory#MultiTypedReferenceValueFactory()}.
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when MultiTypedReferenceValueFactory(); then return Type is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_whenMultiTypedReferenceValueFactory_thenReturnTypeIsNull() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();
    MultiTypedReferenceValueFactory valueFactory = new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCastResult =
        particularReferenceValue.cast(null, referencedClass2, valueFactory, true);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertNull(actualCastResult.getType());
    assertNull(actualCastResult.getReferencedClass());
    ReferenceValue expectedGeneralizedType = valueFactory.REFERENCE_VALUE_NULL;
    assertSame(
        expectedGeneralizedType,
        ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
  }

  /**
   * Test {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ReferencedClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when 'null'; then return ReferencedClass is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_whenNull_thenReturnReferencedClassIsNull() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("foo");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    // Act
    ReferenceValue actualCastResult =
        particularReferenceValue.cast("Type", null, new ParticularReferenceValueFactory(), true);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCastResult instanceof IdentifiedReferenceValue);
    assertNull(actualCastResult.getReferencedClass());
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isParticular());
    assertTrue(actualCastResult.mayBeExtension());
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValue other =
        new ParticularReferenceValue(
            referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2);

    // Act
    ReferenceValue actualGeneralizeResult = particularReferenceValue.generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2).isNull();
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue2() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), 1, value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            new ParticularReferenceValue(
                referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    AnalyzedObject value3 = actualGeneralizeResult.getValue();
    assertNull(value3.getPreciseValue());
    assertNull(value3.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue3() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass,
            valueFactory,
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"),
            value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            new ParticularReferenceValue(
                referencedClass3, new ParticularReferenceValueFactory(), "Reference ID", value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    AnalyzedObject value3 = actualGeneralizeResult.getValue();
    assertNull(value3.getPreciseValue());
    assertNull(value3.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue4() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(false);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValue particularReferenceValue2 =
        new ParticularReferenceValue(
            referencedClass2,
            new ParticularReferenceValueFactory(),
            particularReferenceValue,
            value2);
    AnalyzedObject value3 = mock(AnalyzedObject.class);
    when(value3.isNull()).thenReturn(true);
    when(value3.getType()).thenReturn("Type");
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue2.generalize(
            new ParticularReferenceValue(
                referencedClass3, new ParticularReferenceValueFactory(), "Reference ID", value3));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value3, atLeast(1)).getType();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    AnalyzedObject value4 = actualGeneralizeResult.getValue();
    assertNull(value4.getPreciseValue());
    assertNull(value4.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue5() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass,
            valueFactory,
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            new ParticularReferenceValue(
                referencedClass3, new ParticularReferenceValueFactory(), "Reference ID", value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    AnalyzedObject value3 = actualGeneralizeResult.getValue();
    assertNull(value3.getPreciseValue());
    assertNull(value3.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue6() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(false);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValue particularReferenceValue2 =
        new ParticularReferenceValue(
            referencedClass2,
            new ParticularReferenceValueFactory(),
            particularReferenceValue,
            value2);
    AnalyzedObject value3 = mock(AnalyzedObject.class);
    when(value3.isNull()).thenReturn(true);
    when(value3.getType()).thenReturn("Type");
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue2.generalize(
            new ParticularReferenceValue(
                referencedClass3, new ParticularReferenceValueFactory(), null, value3));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value3, atLeast(1)).getType();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    AnalyzedObject value4 = actualGeneralizeResult.getValue();
    assertNull(value4.getPreciseValue());
    assertNull(value4.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue7() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass,
            valueFactory,
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            new ParticularReferenceValue(
                referencedClass3, new ParticularReferenceValueFactory(), null, value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    AnalyzedObject value3 = actualGeneralizeResult.getValue();
    assertNull(value3.getPreciseValue());
    assertNull(value3.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'; given AnalyzedObject isNull() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue_givenAnalyzedObjectIsNullReturnFalse() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            new ParticularReferenceValue(
                referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    AnalyzedObject value3 = actualGeneralizeResult.getValue();
    assertNull(value3.getPreciseValue());
    assertNull(value3.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue_givenFalse() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(false);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            new ParticularReferenceValue(
                referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value2).isNull();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    AnalyzedObject value3 = actualGeneralizeResult.getValue();
    assertNull(value3.getPreciseValue());
    assertNull(value3.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ParticularReferenceValue)} with {@code
   * ParticularReferenceValue}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ParticularReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularReferenceValue) with 'ParticularReferenceValue'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ParticularReferenceValue)"
  })
  void testGeneralizeWithParticularReferenceValue_thenThrowIllegalStateException() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenThrow(new IllegalStateException("Type"));
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            particularReferenceValue.generalize(
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2)));
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2).isNull();
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue2() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue3() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue4() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2).isNull();
    assertSame(particularReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue5() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    valueFactory,
                    new IdentifiedReferenceValue(
                        "Type",
                        referencedClass3,
                        true,
                        true,
                        new ParticularReferenceValueFactory(),
                        "Id"),
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue6() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValue particularReferenceValue2 =
        new ParticularReferenceValue(
            referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2);

    AnalyzedObject value3 = mock(AnalyzedObject.class);
    when(value3.isNull()).thenReturn(true);
    when(value3.getType()).thenReturn("Type");
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass3,
                    new ParticularReferenceValueFactory(),
                    particularReferenceValue2,
                    value3));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value3, atLeast(1)).getType();
    verify(value).isNull();
    verify(value3, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue7() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), null, value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValue particularReferenceValue2 =
        new ParticularReferenceValue(
            referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2);

    AnalyzedObject value3 = mock(AnalyzedObject.class);
    when(value3.isNull()).thenReturn(true);
    when(value3.getType()).thenReturn("Type");
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass3,
                    new ParticularReferenceValueFactory(),
                    particularReferenceValue2,
                    value3));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value3, atLeast(1)).getType();
    verify(value).isNull();
    verify(value3, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue8() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    valueFactory,
                    new IdentifiedArrayReferenceValue(
                        "Type",
                        referencedClass3,
                        true,
                        BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                        new ParticularReferenceValueFactory(),
                        1),
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue9() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), null, value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    valueFactory,
                    new IdentifiedReferenceValue(
                        "Type",
                        referencedClass3,
                        true,
                        true,
                        new ParticularReferenceValueFactory(),
                        "Id"),
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; given AnalyzedObject isNull() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_givenAnalyzedObjectIsNullReturnFalse() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; given 'false'; when AnalyzedObject isNull() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_givenFalse_whenAnalyzedObjectIsNullReturnFalse() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(false);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then return mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnMayBeExtension() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenThrowIllegalStateException() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenThrow(new IllegalStateException("Type"));
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            particularReferenceValue.generalize(
                (ReferenceValue)
                    new ParticularReferenceValue(
                        referencedClass2,
                        new ParticularReferenceValueFactory(),
                        "Reference ID",
                        value2)));
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2).isNull();
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_null() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    verify(value, atLeast(1)).getType();
    assertSame(particularReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ParticularReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ParticularReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        particularReferenceValue,
        new ParticularReferenceValue(
            referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2));
  }

  /**
   * Test {@link ParticularReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ParticularReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ParticularReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
        1);
  }

  /**
   * Test {@link ParticularReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ParticularReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ParticularReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
        null);
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#getType()} return {@code foo}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; given AnalyzedObject getType() return 'foo'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_givenAnalyzedObjectGetTypeReturnFoo_thenReturnNever() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("foo");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code false}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; given AnalyzedObject isNull() return 'false'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_givenAnalyzedObjectIsNullReturnFalse_thenReturnNever() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; given 'false'; when AnalyzedObject isNull() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_givenFalse_whenAnalyzedObjectIsNullReturnFalse() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(false);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value2).isNull();
    verify(value, atLeast(1)).isNull();
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; given 'true'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_givenTrue_thenReturnOne() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2).isNull();
    assertEquals(1, actualEqualResult);
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_thenThrowIllegalStateException() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenThrow(new IllegalStateException("Type"));
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            particularReferenceValue.equal(
                (ReferenceValue)
                    new ParticularReferenceValue(
                        referencedClass2,
                        new ParticularReferenceValueFactory(),
                        "Reference ID",
                        value2)));
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2).isNull();
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link TypedReferenceValueFactory#REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_java_lang_object_maybe_null() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualEqualResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL);

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_null_thenReturnZero() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualEqualResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link ParticularReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualEqualResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .equal(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link ParticularReferenceValue#toString()}.
   *
   * <p>Method under test: {@link ParticularReferenceValue#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.evaluation.value.ParticularReferenceValue.toString()"
  })
  void testToString() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    (new ParticularReferenceValue(
            null, new ParticularReferenceValueFactory(), "Reference ID", value))
        .toString();

    // Assert
    verify(value, atLeast(1)).getType();
  }

  /**
   * Test {@link ParticularReferenceValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#getType()} return {@code Type}.
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularReferenceValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given AnalyzedObject getType() return 'Type'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.evaluation.value.ParticularReferenceValue.toString()"
  })
  void testToString_givenAnalyzedObjectGetTypeReturnType_thenCallsGetType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    (new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
        .toString();

    // Assert
    verify(value, atLeast(1)).getType();
  }
}

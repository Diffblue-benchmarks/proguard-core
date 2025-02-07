package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.analysis.cpa.jvm.domain.value.JvmCfaReferenceValueFactory;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ParticularReferenceValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.object.AnalyzedObject;

class ParticularReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(Clazz,
   * boolean, boolean, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value, atLeast(1)).getType();
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(1, actualCreateReferenceValueResult.isNotNull());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
    assertSame(value, actualCreateReferenceValueResult.getValue());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(Clazz,
   * boolean, boolean, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn(null);

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value).getType();
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value2 = actualCreateReferenceValueResult.getValue();
    assertNull(value2.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * CodeLocation}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(Clazz,
   * boolean, boolean, CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * CodeLocation}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(Clazz,
   * boolean, boolean, CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn(null);

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value).getType();
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value2 = actualCreateReferenceValueResult.getValue();
    assertNull(value2.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * CodeLocation}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(Clazz,
   * boolean, boolean, CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject3() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory =
        new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        jvmCfaReferenceValueFactory.createReferenceValue(null, true, true, creationLocation, value);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertNull(((ParticularReferenceValue) actualCreateReferenceValueResult).id);
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueResult.isNotNull());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNull());
    assertSame(value, actualCreateReferenceValueResult.getValue());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(null, new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code
   * boolean}, {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code
   * boolean}, {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(
            null,
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code
   * boolean}, {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt3() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory =
        new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        jvmCfaReferenceValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, creationClass, new LibraryMethod(), 1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertNull(((IdentifiedReferenceValue) actualCreateReferenceValueResult).id);
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean},
   * {@code boolean}, {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(
            null,
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value");

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
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Object}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanObject() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularReferenceValueFactory.createReferenceValue(
            null, new LibraryClass(), true, true, "Value");

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
   * Test {@link ParticularReferenceValueFactory#createReferenceValueForId(Clazz, boolean, boolean,
   * Object, AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValueForId(Clazz,
   * boolean, boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularReferenceValueFactory.createReferenceValueForId(
            referencedClass, true, true, "Id", value);

    // Assert
    verify(value, atLeast(1)).getType();
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof ParticularReferenceValue);
    assertEquals("Id", ((ParticularReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNotNull());
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueForIdResult.isNull());
    assertSame(referencedClass, referencedClass2);
    assertSame(value, actualCreateReferenceValueForIdResult.getValue());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValueForId(Clazz, boolean, boolean,
   * Object, AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValueForId(Clazz,
   * boolean, boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn(null);

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularReferenceValueFactory.createReferenceValueForId(
            referencedClass, true, true, "Id", value);

    // Assert
    verify(value).getType();
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    AnalyzedObject value2 = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value2.getPreciseValue());
    assertNull(actualCreateReferenceValueForIdResult.getType());
    assertNull(actualCreateReferenceValueForIdResult.getReferencedClass());
    assertNull(value2.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueForIdResult.isNotNull());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularReferenceValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof IdentifiedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId2() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularReferenceValueFactory.createReferenceValueForId(
            null, new LibraryClass(), true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueForIdResult.getType());
    assertNull(actualCreateReferenceValueForIdResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertEquals(InitializationFinder.NONE, actualCreateReferenceValueForIdResult.isNotNull());
  }

  /**
   * Test {@link ParticularReferenceValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension},
   * {@code mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.ParticularReferenceValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    ParticularReferenceValueFactory particularReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularReferenceValueFactory.createReferenceValueForId(
            null, new LibraryClass(), true, true, "Id", "Value");

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

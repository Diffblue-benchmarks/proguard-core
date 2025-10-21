package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link ParticularReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanObject() {
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
   * Test {@link ParticularReferenceValueFactory#createReferenceValueForId(String, Clazz, boolean,
   * boolean, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}.
   *
   * <p>Method under test: {@link ParticularReferenceValueFactory#createReferenceValueForId(String,
   * Clazz, boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ParticularReferenceValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue() {
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

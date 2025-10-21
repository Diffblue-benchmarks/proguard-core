package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.ParticularReferenceValueFactory;

public class BasicValueFactoryDiffblueTest {
  /**
   * Test {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicValueFactory.createValue(String, Clazz, boolean, boolean)"})
  public void testCreateValue_thenReferencedClassReturnLibraryClass() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult =
        arrayReferenceValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = ((TypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof TypedReferenceValue);
    assertEquals("Type", ((TypedReferenceValue) actualCreateValueResult).getType());
    assertEquals(0, ((TypedReferenceValue) actualCreateValueResult).isNull());
    assertFalse(actualCreateValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BasicValueFactory.createValue(String, Clazz, boolean, boolean)"})
  public void testCreateValue_thenReturnBasicValueFactoryReference_value() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link BasicValueFactory#createIntegerValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createIntegerValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue BasicValueFactory.createIntegerValue()"})
  public void testCreateIntegerValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue());
  }

  /**
   * Test {@link BasicValueFactory#createIntegerValue(int, int)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue BasicValueFactory.createIntegerValue(int, int)"})
  public void testCreateIntegerValueWithMinMax_thenReturnBasicValueFactoryInteger_value() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue(1, 3));
  }

  /**
   * Test {@link BasicValueFactory#createIntegerValue(int, int)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue BasicValueFactory.createIntegerValue(int, int)"})
  public void testCreateIntegerValueWithMinMax_thenReturnIdentifiedIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        (new DetailedArrayValueFactory()).createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof IdentifiedIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link BasicValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createIntegerValue(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue BasicValueFactory.createIntegerValue(int)"})
  public void testCreateIntegerValueWithValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue(42));
  }

  /**
   * Test {@link BasicValueFactory#createLongValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createLongValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.LongValue BasicValueFactory.createLongValue()"})
  public void testCreateLongValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.LONG_VALUE, basicValueFactory.createLongValue());
  }

  /**
   * Test {@link BasicValueFactory#createLongValue(long)} with {@code long}.
   *
   * <p>Method under test: {@link BasicValueFactory#createLongValue(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.LongValue BasicValueFactory.createLongValue(long)"})
  public void testCreateLongValueWithLong() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.LONG_VALUE, basicValueFactory.createLongValue(42L));
  }

  /**
   * Test {@link BasicValueFactory#createFloatValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createFloatValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.FloatValue BasicValueFactory.createFloatValue()"})
  public void testCreateFloatValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.FLOAT_VALUE, basicValueFactory.createFloatValue());
  }

  /**
   * Test {@link BasicValueFactory#createFloatValue(float)} with {@code float}.
   *
   * <p>Method under test: {@link BasicValueFactory#createFloatValue(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue BasicValueFactory.createFloatValue(float)"
  })
  public void testCreateFloatValueWithFloat() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.FLOAT_VALUE, basicValueFactory.createFloatValue(10.0f));
  }

  /**
   * Test {@link BasicValueFactory#createDoubleValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createDoubleValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.DoubleValue BasicValueFactory.createDoubleValue()"})
  public void testCreateDoubleValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.DOUBLE_VALUE, basicValueFactory.createDoubleValue());
  }

  /**
   * Test {@link BasicValueFactory#createDoubleValue(double)} with {@code double}.
   *
   * <p>Method under test: {@link BasicValueFactory#createDoubleValue(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue BasicValueFactory.createDoubleValue(double)"
  })
  public void testCreateDoubleValueWithDouble() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.DOUBLE_VALUE, basicValueFactory.createDoubleValue(10.0d));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue BasicValueFactory.createReferenceValue()"})
  public void testCreateReferenceValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createReferenceValue());
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean)} with
   * {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        arrayReferenceValueFactory.createReferenceValue(
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
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value"));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        arrayReferenceValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanObject() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue("Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanObject2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        arrayReferenceValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueNull()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue BasicValueFactory.createReferenceValueNull()"})
  public void testCreateReferenceValueNull() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createReferenceValueNull());
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        arrayReferenceValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  public void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValueForId(
            "Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  public void
      testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        arrayReferenceValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id", "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link BasicValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link BasicValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        basicRangeValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code elementValues}.
   *
   * <p>Method under test: {@link BasicValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), arrayLength, "Element Values"));
    assertSame(arrayLength, basicValueFactory.createIntegerValue());
  }

  /**
   * Test {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code elementValues}.
   *
   * <p>Method under test: {@link BasicValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue BasicValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues2() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        primitiveTypedReferenceValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    assertTrue(
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength
            instanceof UnknownIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
    IntegerValue expectedCreateIntegerValueResult =
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertSame(
        expectedCreateIntegerValueResult, primitiveTypedReferenceValueFactory.createIntegerValue());
  }

  /**
   * Test {@link BasicValueFactory#checkCreationLocation(CodeLocation)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#checkCreationLocation(CodeLocation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicValueFactory.checkCreationLocation(CodeLocation)"})
  public void testCheckCreationLocation_thenThrowIllegalStateException() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            BasicValueFactory.checkCreationLocation(
                new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)));
  }
}

package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;

public class ArrayReferenceValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayReferenceValue#ArrayReferenceValue(String, Clazz, boolean, IntegerValue)}
   *   <li>{@link ArrayReferenceValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ArrayReferenceValue.<init>(String, Clazz, boolean, IntegerValue)",
    "String ArrayReferenceValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ArrayReferenceValue actualArrayReferenceValue =
        new ArrayReferenceValue(
            "Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertEquals("Type![b]", actualArrayReferenceValue.toString());
    assertEquals("Type", actualArrayReferenceValue.getType());
    assertSame(referencedClass, actualArrayReferenceValue.getReferencedClass());
  }

  /**
   * Test {@link ArrayReferenceValue#arrayLength(ValueFactory)}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ArrayReferenceValue.arrayLength(ValueFactory)"})
  public void testArrayLength() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(
        arrayReferenceValue.arrayLength,
        arrayReferenceValue.arrayLength(new ParticularReferenceValueFactory()));
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(
        arrayReferenceValue,
        arrayReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue3() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "proguard.evaluation.value.ArrayReferenceValue",
            null,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "proguard.evaluation.value.ArrayReferenceValue",
            new LibraryClass(),
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            new ArrayReferenceValue("Type", null, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue5() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            null, new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return not mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue_thenReturnNotMayBeExtension() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            new ArrayReferenceValue(
                null, new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue_thenReturnType() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", referencedClass, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(
        other,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue2() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

    // Act and Assert
    assertSame(
        other,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue3() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ArrayReferenceValue other =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, arrayReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue5() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, arrayReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue8() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(
        other,
        (new ArrayReferenceValue(
                "", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue9() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue10() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue11() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            null, new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue12() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    null,
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = arrayReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_null() {
    // Arrange and Act
    ReferenceValue actualGeneralizeResult =
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value() {
    // Arrange
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1))
            .generalize(other));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue2() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue5() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue6() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, ParticularValueFactory.INTEGER_VALUE_0);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue_thenReturnNever() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "proguard.evaluation.value.ArrayReferenceValue",
            new LibraryClass(),
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        arrayReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);

    // Act and Assert
    assertEquals(
        0,
        identifiedArrayReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedArrayReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue5() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue6() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    new ComparisonValue(
                        BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                        BasicRangeValueFactory.INTEGER_VALUE_BYTE))));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link TypedReferenceValueFactory#REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_java_lang_object_maybe_null() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_null_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link ArrayReferenceValue#equals(Object)}, and {@link ArrayReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayReferenceValue#equals(Object)}
   *   <li>{@link ArrayReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ArrayReferenceValue.equals(Object)",
    "int ArrayReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ArrayReferenceValue arrayReferenceValue2 =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(arrayReferenceValue, arrayReferenceValue2);
    int expectedHashCodeResult = arrayReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayReferenceValue2.hashCode());
  }

  /**
   * Test {@link ArrayReferenceValue#equals(Object)}, and {@link ArrayReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayReferenceValue#equals(Object)}
   *   <li>{@link ArrayReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ArrayReferenceValue.equals(Object)",
    "int ArrayReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(arrayReferenceValue, arrayReferenceValue);
    int expectedHashCodeResult = arrayReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayReferenceValue.hashCode());
  }

  /**
   * Test {@link ArrayReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ArrayReferenceValue.equals(Object)",
    "int ArrayReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "proguard.evaluation.value.ArrayReferenceValue",
            new LibraryClass(),
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        arrayReferenceValue,
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ArrayReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ArrayReferenceValue.equals(Object)",
    "int ArrayReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Test {@link ArrayReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ArrayReferenceValue.equals(Object)",
    "int ArrayReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ArrayReferenceValue");
  }
}

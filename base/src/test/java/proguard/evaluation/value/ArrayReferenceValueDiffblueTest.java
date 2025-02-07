package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

class ArrayReferenceValueDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.ArrayReferenceValue.<init>(java.lang.String, proguard.classfile.Clazz, boolean, proguard.evaluation.value.IntegerValue)",
    "java.lang.String proguard.evaluation.value.ArrayReferenceValue.toString()"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test arrayLength(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ArrayReferenceValue.arrayLength(proguard.evaluation.value.ValueFactory)"
  })
  void testArrayLength() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue2() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue3() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue4() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue5() {
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
  @DisplayName(
      "Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'; then return not mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue_thenReturnNotMayBeExtension() {
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
  @DisplayName(
      "Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue_thenReturnType() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue() {
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
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue2() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue3() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue4() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue5() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue6() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue7() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue) new TypedReferenceValue("Type", referencedClass, false, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then ReferencedClass return LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReferencedClassReturnLibraryClass() {
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
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return MultiTypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue() {
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
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return MultiTypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue2() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
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
   *   <li>Then return not mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return not mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnNotMayBeExtension() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnType() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        arrayReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return Type is 'Ljava/lang/Object;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnTypeIsLjavaLangObject() {
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
            (ReferenceValue)
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
   * Test {@link ArrayReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_null_thenReturnType() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        (new ArrayReferenceValue(
                "Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
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
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value() {
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
   * Test {@link ArrayReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue2() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue3() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue4() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue5() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue6() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue_thenReturnNever() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue() {
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
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue2() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue3() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualEqualResult =
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "proguard.evaluation.value.ArrayReferenceValue",
            new LibraryClass(),
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualEqualResult =
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; given 'Type'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_givenType_thenCallsGetType() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualEqualResult =
        arrayReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
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
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_java_lang_object_maybe_null() {
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
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_null_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link ArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.REFERENCE_VALUE));
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ArrayReferenceValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ArrayReferenceValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ArrayReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ArrayReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ArrayReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ArrayReferenceValue");
  }
}

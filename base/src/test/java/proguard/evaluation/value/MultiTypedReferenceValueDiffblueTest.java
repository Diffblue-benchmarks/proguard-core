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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

class MultiTypedReferenceValueDiffblueTest {
  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName("Test new MultiTypedReferenceValue(Set, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    potentialTypes.add(arrayReferenceValue);

    // Act and Assert
    assertSame(
        arrayReferenceValue,
        (new MultiTypedReferenceValue(potentialTypes, true)).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName("Test new MultiTypedReferenceValue(Set, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue2() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    LibraryClass referencedClass2 = new LibraryClass();
    potentialTypes.add(
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass2,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(generalizedType.mayBeExtension);
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName("Test new MultiTypedReferenceValue(Set, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue3() {
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
    ParticularReferenceValue particularReferenceValue2 =
        new ParticularReferenceValue(
            referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(particularReferenceValue2);
    potentialTypes.add(particularReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).isNull();
    verify(value, atLeast(1)).isNull();
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertSame(typedReferenceValue, generalizedType);
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}.
   *
   * <p>Method under test: {@link
   * MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  @DisplayName("Test new MultiTypedReferenceValue(TypedReferenceValue, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(proguard.evaluation.value.TypedReferenceValue, boolean)"
  })
  void testNewMultiTypedReferenceValue4() {
    // Arrange
    TypedReferenceValue type = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(type, true);

    // Assert
    assertTrue(actualMultiTypedReferenceValue.getReferencedClass() instanceof LibraryClass);
    assertSame(type, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}.
   *
   * <p>Method under test: {@link
   * MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  @DisplayName("Test new MultiTypedReferenceValue(TypedReferenceValue, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(proguard.evaluation.value.TypedReferenceValue, boolean)"
  })
  void testNewMultiTypedReferenceValue5() {
    // Arrange
    TypedReferenceValue type = new TypedReferenceValue("Type", new LibraryClass(), false, true);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(type, true);

    // Assert
    assertTrue(actualMultiTypedReferenceValue.getReferencedClass() instanceof LibraryClass);
    assertSame(type, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Type is a string.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MultiTypedReferenceValue(Set, boolean); given 'null'; then return Type is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_givenNull_thenReturnTypeIsAString() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(null);
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(
            "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
                + " code would crash if not fixed.",
            new LibraryClass(),
            false,
            true);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        actualMultiTypedReferenceValue.getType());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MultiTypedReferenceValue(Set, boolean); then ReferencedClass return LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_thenReferencedClassReturnLibraryClass() {
    // Arrange
    LinkedHashSet<TypedReferenceValue> potentialTypes = new LinkedHashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    Clazz referencedClass = actualMultiTypedReferenceValue.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(
        referencedClass, actualMultiTypedReferenceValue.getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>Then return GeneralizedType mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MultiTypedReferenceValue(Set, boolean); then return GeneralizedType mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_thenReturnGeneralizedTypeMayBeExtension() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(generalizedType.mayBeExtension);
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>Then return GeneralizedType Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MultiTypedReferenceValue(Set, boolean); then return GeneralizedType Type is 'Ljava/lang/Object;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_thenReturnGeneralizedTypeTypeIsLjavaLangObject() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", null, true, true));
    potentialTypes.add(
        new TypedReferenceValue(
            "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
                + " code would crash if not fixed.",
            new LibraryClass(),
            false,
            true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Ljava/lang/Object;", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    assertNull(actualMultiTypedReferenceValue.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>Then return not GeneralizedType mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MultiTypedReferenceValue(Set, boolean); then return not GeneralizedType mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_thenReturnNotGeneralizedTypeMayBeExtension() {
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
    ParticularReferenceValue particularReferenceValue2 =
        new ParticularReferenceValue(
            referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue2);
    potentialTypes.add(particularReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).isNull();
    verify(value, atLeast(1)).isNull();
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(generalizedType.mayBeExtension);
    assertEquals(Value.NEVER, actualMultiTypedReferenceValue.isNotNull());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName("Test new MultiTypedReferenceValue(Set, boolean); then return NotNull is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_thenReturnNotNullIsOne() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(
            "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
                + " code would crash if not fixed.",
            new LibraryClass(),
            true,
            false);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals(1, actualMultiTypedReferenceValue.isNotNull());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MultiTypedReferenceValue(TypedReferenceValue, boolean); then return NotNull is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(proguard.evaluation.value.TypedReferenceValue, boolean)"
  })
  void testNewMultiTypedReferenceValue_thenReturnNotNullIsOne2() {
    // Arrange
    TypedReferenceValue type = new TypedReferenceValue("Type", new LibraryClass(), true, false);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(type, true);

    // Assert
    assertTrue(actualMultiTypedReferenceValue.getReferencedClass() instanceof LibraryClass);
    assertEquals(1, actualMultiTypedReferenceValue.isNotNull());
    assertSame(type, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>Then return Type is a string.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName("Test new MultiTypedReferenceValue(Set, boolean); then return Type is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_thenReturnTypeIsAString() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(
            "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
                + " code would crash if not fixed.",
            new LibraryClass(),
            false,
            true);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        actualMultiTypedReferenceValue.getType());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName("Test new MultiTypedReferenceValue(Set, boolean); then return Type is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_thenReturnTypeIsNull() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), false, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertNull(actualMultiTypedReferenceValue.getType());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MultiTypedReferenceValue(Set, boolean); when HashSet(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(java.util.Set, boolean)"
  })
  void testNewMultiTypedReferenceValue_whenHashSet_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MultiTypedReferenceValue(new HashSet<>(), true));
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Value PreciseValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MultiTypedReferenceValue(TypedReferenceValue, boolean); when 'null'; then return Value PreciseValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.MultiTypedReferenceValue.<init>(proguard.evaluation.value.TypedReferenceValue, boolean)"
  })
  void testNewMultiTypedReferenceValue_whenNull_thenReturnValuePreciseValueIsNull() {
    // Arrange and Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue((TypedReferenceValue) null, true);

    // Assert
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualMultiTypedReferenceValue.getGeneralizedType());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertSame(
        multiTypedReferenceValue,
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, false);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes2, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", null, true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("", new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'; then ReferencedClass return LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testGeneralizeWithMultiTypedReferenceValue_thenReferencedClassReturnLibraryClass() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, false);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertSame(typedReferenceValue, generalizedType);
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertSame(typedReferenceValue, generalizedType);
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    potentialTypes.add(arrayReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertSame(
        arrayReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue6() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertSame(
        particularReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue7() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue8() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        referencedClass2,
        ((MultiTypedReferenceValue) actualGeneralizeResult)
            .getGeneralizedType()
            .getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue9() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
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
    verify(value, atLeast(1)).isNull();
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        referencedClass3,
        ((MultiTypedReferenceValue) actualGeneralizeResult)
            .getGeneralizedType()
            .getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue10() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
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
    verify(value, atLeast(1)).isNull();
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        referencedClass3,
        ((MultiTypedReferenceValue) actualGeneralizeResult)
            .getGeneralizedType()
            .getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue11() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue12() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue13() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act and Assert
    assertSame(other, multiTypedReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue14() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), false, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue15() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    TypedReferenceValue type = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            (ReferenceValue) new MultiTypedReferenceValue(type, false));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(type, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue16() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            (ReferenceValue)
                new MultiTypedReferenceValue(
                    new TypedReferenceValue(null, new LibraryClass(), true, true), true));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue17() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    potentialTypes.add(particularReferenceValue);
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return not GeneralizedType mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return not GeneralizedType mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnNotGeneralizedTypeMayBeExtension() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(generalizedType.mayBeExtension);
    assertSame(referencedClass2, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then return NotNull is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnNotNullIsOne() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return PotentialTypes size is two.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return PotentialTypes size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnPotentialTypesSizeIsTwo() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(particularReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertSame(typedReferenceValue, generalizedType);
    assertSame(referencedClass2, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then return Type is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnTypeIsNull() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertNull(actualGeneralizeResult.getType());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet9() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @DisplayName("Test generalize(Set) with 'Set'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(java.util.Set)"
  })
  void testGeneralizeWithSet10() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(particularReferenceValue);

    // Act
    TypedReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(potentialTypes2);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value).isNull();
    assertSame(particularReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, false);

    // Act and Assert
    assertSame(
        multiTypedReferenceValue,
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, false));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), false, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue9() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", null, true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue10() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new TypedReferenceValue("Type", null, true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <ul>
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(TypedReferenceValue) with 'TypedReferenceValue'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue_thenCallsGetType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <ul>
   *   <li>Then return not {@link MultiTypedReferenceValue#mayBeUnknown}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(TypedReferenceValue) with 'TypedReferenceValue'; then return not mayBeUnknown")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue_thenReturnNotMayBeUnknown() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, false);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertFalse(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) actualGeneralizeResult)
            .getGeneralizedType()
            .getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <ul>
   *   <li>Then return not {@link MultiTypedReferenceValue#mayBeUnknown}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(TypedReferenceValue) with 'TypedReferenceValue'; then return not mayBeUnknown")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue_thenReturnNotMayBeUnknown2() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, false);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertFalse(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertSame(
        referencedClass2,
        ((MultiTypedReferenceValue) actualGeneralizeResult)
            .getGeneralizedType()
            .getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    potentialTypes.add(arrayReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertSame(
        arrayReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue5() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertSame(
        particularReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue6() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue7() {
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
    ParticularReferenceValue particularReferenceValue2 =
        new ParticularReferenceValue(
            referencedClass2, new ParticularReferenceValueFactory(), "Reference ID", value2);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue2);
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    verify(value2, atLeast(1)).getType();
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).isNull();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(generalizedType.mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNotNull());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue8() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(particularReferenceValue);
    LibraryClass referencedClass2 = new LibraryClass();
    potentialTypes.add(
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass2,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <ul>
   *   <li>Then return GeneralizedType NotNull is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'; then return GeneralizedType NotNull is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue_thenReturnGeneralizedTypeNotNullIsZero() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    potentialTypes.add(particularReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'; then return NotNull is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue_thenReturnNotNullIsOne() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <ul>
   *   <li>Then return PotentialTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'; then return PotentialTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue_thenReturnPotentialTypesSizeIsOne() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <ul>
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'; then return Type is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue_thenReturnTypeIsNull() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertNull(actualGeneralizeResult.getType());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#getType()}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#getType()}
   */
  @Test
  @DisplayName("Test getType(); then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.evaluation.value.MultiTypedReferenceValue.getType()"
  })
  void testGetType_thenReturnType() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals("Type", (new MultiTypedReferenceValue(potentialTypes, true)).getType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#getReferencedClass()}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#getReferencedClass()}
   */
  @Test
  @DisplayName("Test getReferencedClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.evaluation.value.MultiTypedReferenceValue.getReferencedClass()"
  })
  void testGetReferencedClass() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act and Assert
    assertSame(
        typedReferenceValue.referencedClass,
        (new MultiTypedReferenceValue(potentialTypes, true)).getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValue#mayBeExtension()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#mayBeExtension()}
   */
  @Test
  @DisplayName("Test mayBeExtension(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.MultiTypedReferenceValue.mayBeExtension()"})
  void testMayBeExtension_thenReturnFalse() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Act and Assert
    assertFalse((new MultiTypedReferenceValue(potentialTypes, true)).mayBeExtension());
  }

  /**
   * Test {@link MultiTypedReferenceValue#mayBeExtension()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#mayBeExtension()}
   */
  @Test
  @DisplayName("Test mayBeExtension(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.MultiTypedReferenceValue.mayBeExtension()"})
  void testMayBeExtension_thenReturnTrue() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertTrue((new MultiTypedReferenceValue(potentialTypes, true)).mayBeExtension());
  }

  /**
   * Test {@link MultiTypedReferenceValue#mayBeExtension()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#mayBeExtension()}
   */
  @Test
  @DisplayName("Test mayBeExtension(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.MultiTypedReferenceValue.mayBeExtension()"})
  void testMayBeExtension_thenReturnTrue2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertTrue((new MultiTypedReferenceValue(potentialTypes, true)).mayBeExtension());
  }

  /**
   * Test {@link MultiTypedReferenceValue#isNull()}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#isNull()}
   */
  @Test
  @DisplayName("Test isNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.MultiTypedReferenceValue.isNull()"})
  void testIsNull() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, (new MultiTypedReferenceValue(potentialTypes, true)).isNull());
  }

  /**
   * Test {@link MultiTypedReferenceValue#isNull()}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#isNull()}
   */
  @Test
  @DisplayName("Test isNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.MultiTypedReferenceValue.isNull()"})
  void testIsNull2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, (new MultiTypedReferenceValue(potentialTypes, true)).isNull());
  }

  /**
   * Test {@link MultiTypedReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#isNull()}
   */
  @Test
  @DisplayName("Test isNull(); then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.MultiTypedReferenceValue.isNull()"})
  void testIsNull_thenReturnNever() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));

    // Act and Assert
    assertEquals(Value.NEVER, (new MultiTypedReferenceValue(potentialTypes, true)).isNull());
  }

  /**
   * Test {@link MultiTypedReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#isNull()}
   */
  @Test
  @DisplayName("Test isNull(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.MultiTypedReferenceValue.isNull()"})
  void testIsNull_thenReturnZero() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, (new MultiTypedReferenceValue(potentialTypes, true)).isNull());
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Other Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(
        Value.NEVER, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(
        Value.NEVER, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(
        new TypedReferenceValue("Type", new LibraryClass(Short.SIZE, "Type", "Type"), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(
        Value.NEVER, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", null, true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Other Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Other Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz); then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf_thenReturnNever() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(
        Value.NEVER, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Object;}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz); when 'Ljava/lang/Object;'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf_whenLjavaLangObject_thenReturnZero() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.instanceOf("Ljava/lang/Object;", new LibraryClass()));
  }

  /**
   * Test {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz); when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf_whenNull_thenReturnZero() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(
        0, (new MultiTypedReferenceValue(potentialTypes, true)).instanceOf("Other Type", null));
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        multiTypedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualCastResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        multiTypedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualCastResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        multiTypedReferenceValue,
        multiTypedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true));
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        multiTypedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(
        typedReferenceValue, ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        multiTypedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(
        typedReferenceValue, ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", null, true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        multiTypedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualCastResult.isNotNull());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertTrue(generalizedType.mayBeNull);
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean); then return NotNull is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_thenReturnNotNullIsOne() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, false));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        multiTypedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(1, actualCastResult.isNotNull());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals(1, generalizedType.isNotNull());
    assertFalse(generalizedType.mayBeNull);
    assertEquals(Value.NEVER, generalizedType.isNull());
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>Then return NotNull is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean); then return NotNull is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_thenReturnNotNullIsZero() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        multiTypedReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualCastResult.isNotNull());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertTrue(generalizedType.mayBeNull);
  }

  /**
   * Test {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ReferencedClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when 'null'; then return ReferencedClass is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_whenNull_thenReturnReferencedClassIsNull() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualCastResult =
        multiTypedReferenceValue.cast("Type", null, new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertNull(actualCastResult.getReferencedClass());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertNull(generalizedType.getReferencedClass());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertTrue(generalizedType.mayBeNull);
  }

  /**
   * Test {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue,
   * ValueFactory)}
   */
  @Test
  @DisplayName("Test referenceArrayLoad(IntegerValue, ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.referenceArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testReferenceArrayLoad() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        multiTypedReferenceValue.referenceArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue,
   * ValueFactory)}
   */
  @Test
  @DisplayName("Test referenceArrayLoad(IntegerValue, ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.referenceArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testReferenceArrayLoad2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        multiTypedReferenceValue.referenceArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue,
   * ValueFactory)}
   */
  @Test
  @DisplayName(
      "Test referenceArrayLoad(IntegerValue, ValueFactory); then return ParticularReferenceValueFactory (default constructor) REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.MultiTypedReferenceValue.referenceArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testReferenceArrayLoad_thenReturnParticularReferenceValueFactoryReference_value() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        multiTypedReferenceValue.referenceArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.equal(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testEqualWithMultiTypedReferenceValue() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(
        0, multiTypedReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Test {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.equal(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testEqualWithMultiTypedReferenceValue2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(
        0, multiTypedReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Test {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.equal(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testEqualWithMultiTypedReferenceValue3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Act and Assert
    assertEquals(
        0, multiTypedReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Test {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(MultiTypedReferenceValue) with 'MultiTypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.equal(proguard.evaluation.value.MultiTypedReferenceValue)"
  })
  void testEqualWithMultiTypedReferenceValue4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("", new LibraryClass(), false, true));

    // Act and Assert
    assertEquals(
        0, multiTypedReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Test {@link MultiTypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(
        0,
        multiTypedReferenceValue.equal(
            (ReferenceValue)
                new MultiTypedReferenceValue(
                    new TypedReferenceValue("Type", new LibraryClass(), true, true), true)));
  }

  /**
   * Test {@link MultiTypedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.MultiTypedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(
        0,
        (new MultiTypedReferenceValue(potentialTypes, true))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link MultiTypedReferenceValue#internalType()}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType(); then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.evaluation.value.MultiTypedReferenceValue.internalType()"
  })
  void testInternalType_thenReturnType() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals("Type", (new MultiTypedReferenceValue(potentialTypes, true)).internalType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#equals(Object)}, and {@link
   * MultiTypedReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MultiTypedReferenceValue#equals(Object)}
   *   <li>{@link MultiTypedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.MultiTypedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.MultiTypedReferenceValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue2 =
        new MultiTypedReferenceValue(potentialTypes2, true);

    // Act and Assert
    assertEquals(multiTypedReferenceValue, multiTypedReferenceValue2);
    int expectedHashCodeResult = multiTypedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, multiTypedReferenceValue2.hashCode());
  }

  /**
   * Test {@link MultiTypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.MultiTypedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.MultiTypedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(multiTypedReferenceValue, new MultiTypedReferenceValue(potentialTypes2, true));
  }

  /**
   * Test {@link MultiTypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.MultiTypedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.MultiTypedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, false);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(multiTypedReferenceValue, new MultiTypedReferenceValue(potentialTypes2, true));
  }

  /**
   * Test {@link MultiTypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.MultiTypedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.MultiTypedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(new MultiTypedReferenceValue(potentialTypes, true), 1);
  }

  /**
   * Test {@link MultiTypedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.MultiTypedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.MultiTypedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(new MultiTypedReferenceValue(potentialTypes, true), null);
  }
}

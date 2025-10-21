package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class MultiTypedReferenceValueDiffblueTest {
  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue2() {
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
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    potentialTypes.add(
        new TypedReferenceValue(
            "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
                + " code would crash if not fixed.",
            null,
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
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertTrue(actualMultiTypedReferenceValue.getReferencedClass() instanceof LibraryClass);
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertTrue(actualMultiTypedReferenceValue.getReferencedClass() instanceof LibraryClass);
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertTrue(actualMultiTypedReferenceValue.getReferencedClass() instanceof LibraryClass);
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertTrue(actualMultiTypedReferenceValue.getReferencedClass() instanceof LibraryClass);
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", null, false, true));
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
   * Test {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}.
   *
   * <p>Method under test: {@link
   * MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(TypedReferenceValue, boolean)"})
  public void testNewMultiTypedReferenceValue9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(TypedReferenceValue, boolean)"})
  public void testNewMultiTypedReferenceValue10() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue_givenNull_thenReturnTypeIsAString() {
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
   *   <li>Then return GeneralizedType Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue_thenReturnGeneralizedTypeTypeIsType() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    Clazz referencedClass = actualMultiTypedReferenceValue.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertSame(referencedClass, generalizedType.getReferencedClass());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue_thenReturnNotNullIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(TypedReferenceValue, boolean)"})
  public void testNewMultiTypedReferenceValue_thenReturnNotNullIsOne2() {
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
   *   <li>Then return PotentialTypes is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue_thenReturnPotentialTypesIsLinkedHashSet() {
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
   *   <li>Then return Type is a string.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue_thenReturnTypeIsAString() {
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
   *   <li>Then return Type is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue_thenReturnTypeIsEmptyString() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertTrue(actualMultiTypedReferenceValue.getReferencedClass() instanceof LibraryClass);
    assertEquals("", actualMultiTypedReferenceValue.getType());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue_thenReturnTypeIsNull() {
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
    assertEquals(Value.NEVER, actualMultiTypedReferenceValue.isNotNull());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(Set, boolean)"})
  public void testNewMultiTypedReferenceValue_whenHashSet_thenThrowIllegalArgumentException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTypedReferenceValue.<init>(TypedReferenceValue, boolean)"})
  public void testNewMultiTypedReferenceValue_whenNull_thenReturnValuePreciseValueIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue7() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue8() {
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
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue9() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("", null, true, true));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue_thenReferencedClassReturnLibraryClass() {
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
   * Test {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.generalize(MultiTypedReferenceValue)"
  })
  public void testGeneralizeWithMultiTypedReferenceValue_thenReturnNotNullIsOne() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    potentialTypes2.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue3() {
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
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue4() {
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
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue9() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue10() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            (ReferenceValue) new TypedReferenceValue("Type", new LibraryClass(), true, true));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue11() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue12() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue13() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        referencedClass,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue14() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), false, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue15() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue16() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue17() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
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
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue18() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue19() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue20() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, false);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue21() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_givenHashSetAddNull() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(null);
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
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return GeneralizedType Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnGeneralizedTypeTypeIsLjavaLangObject() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnNotNullIsOne() {
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
   *   <li>Then return Type is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnTypeIsEmptyString() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("", generalizedType.getType());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(typedReferenceValue, generalizedType);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnTypeIsNull() {
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
    assertEquals(Value.NEVER, actualGeneralizeResult.isNotNull());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnTypeIsNull2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertNull(actualGeneralizeResult.getType());
    assertEquals(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertEquals(Value.NEVER, actualGeneralizeResult.isNotNull());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_null() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new MultiTypedReferenceValue(potentialTypes, true))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet7() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet8() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet10() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue(null, new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet11() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypedReferenceValue MultiTypedReferenceValue.generalize(Set)"})
  public void testGeneralizeWithSet12() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Test {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue7() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue8() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue10() {
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
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue11() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
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
   * <ul>
   *   <li>Then return not {@link MultiTypedReferenceValue#mayBeUnknown}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue_thenReturnNotMayBeUnknown() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue_thenReturnNotMayBeUnknown2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
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
   * Test {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
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
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_givenHashSetAddNull() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(null);
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
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(
        typedReferenceValue,
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnGeneralizedTypeNotNullIsZero() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnNotNullIsOne() {
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
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnNotNullIsOne2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("Type", new LibraryClass(), true, false);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnPotentialTypesSizeIsOne() {
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
   *   <li>Then return Type is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnTypeIsEmptyString() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue =
        new TypedReferenceValue("", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("", generalizedType.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertSame(typedReferenceValue, generalizedType);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnTypeIsNull() {
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
    assertEquals(Value.NEVER, actualGeneralizeResult.isNotNull());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MultiTypedReferenceValue.getType()"})
  public void testGetType_thenReturnType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz MultiTypedReferenceValue.getReferencedClass()"})
  public void testGetReferencedClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiTypedReferenceValue.mayBeExtension()"})
  public void testMayBeExtension_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiTypedReferenceValue.mayBeExtension()"})
  public void testMayBeExtension_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiTypedReferenceValue.mayBeExtension()"})
  public void testMayBeExtension_thenReturnTrue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.isNull()"})
  public void testIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.isNull()"})
  public void testIsNull2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.isNull()"})
  public void testIsNull_thenReturnNever() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.isNull()"})
  public void testIsNull_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf_thenReturnNever() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf_whenLjavaLangObject_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf_whenNull_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_thenReturnNotNullIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_thenReturnNotNullIsZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  public void testCast_whenNull_thenReturnReferencedClassIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.referenceArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testReferenceArrayLoad() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.referenceArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testReferenceArrayLoad2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValue.referenceArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testReferenceArrayLoad_thenReturnParticularReferenceValueFactoryReference_value() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.equal(MultiTypedReferenceValue)"})
  public void testEqualWithMultiTypedReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.equal(MultiTypedReferenceValue)"})
  public void testEqualWithMultiTypedReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.equal(MultiTypedReferenceValue)"})
  public void testEqualWithMultiTypedReferenceValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.equal(MultiTypedReferenceValue)"})
  public void testEqualWithMultiTypedReferenceValue4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTypedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MultiTypedReferenceValue.internalType()"})
  public void testInternalType_thenReturnType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MultiTypedReferenceValue.equals(Object)",
    "int MultiTypedReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MultiTypedReferenceValue.equals(Object)",
    "int MultiTypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MultiTypedReferenceValue.equals(Object)",
    "int MultiTypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MultiTypedReferenceValue.equals(Object)",
    "int MultiTypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MultiTypedReferenceValue.equals(Object)",
    "int MultiTypedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(new MultiTypedReferenceValue(potentialTypes, true), null);
  }
}

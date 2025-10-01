package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;

class UnknownReferenceValueDiffblueTest {
  /**
   * Test {@link UnknownReferenceValue#mayBeExtension()}.
   *
   * <p>Method under test: {@link UnknownReferenceValue#mayBeExtension()}
   */
  @Test
  @DisplayName("Test mayBeExtension()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnknownReferenceValue.mayBeExtension()"})
  void testMayBeExtension() {
    // Arrange, Act and Assert
    assertTrue(new UnknownReferenceValue().mayBeExtension());
  }

  /**
   * Test {@link UnknownReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link UnknownReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnknownReferenceValue.instanceOf(String, Clazz)"})
  void testInstanceOf() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(0, unknownReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory} (default constructor).
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when BasicValueFactory (default constructor); then return REFERENCE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  void testCast_whenBasicValueFactory_thenReturnReference_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        BasicValueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast("Type", referencedClass, new BasicValueFactory(), true));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when empty string; then return REFERENCE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  void testCast_whenEmptyString_thenReturnReference_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        BasicValueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast(
            "", referencedClass, new PrimitiveTypedReferenceValueFactory(), true));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link MultiTypedReferenceValueFactory#MultiTypedReferenceValueFactory()}.
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when MultiTypedReferenceValueFactory(); then return MultiTypedReferenceValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  void testCast_whenMultiTypedReferenceValueFactory_thenReturnMultiTypedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        unknownReferenceValue.cast(
            "Type", referencedClass, new MultiTypedReferenceValueFactory(), true);

    // Assert
    Clazz referencedClass2 = actualCastResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isParticular());
    assertFalse(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link ParticularReferenceValueFactory} (default constructor).
   *   <li>Then return {@link IdentifiedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when ParticularReferenceValueFactory (default constructor); then return IdentifiedReferenceValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  void testCast_whenParticularReferenceValueFactory_thenReturnIdentifiedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult =
        unknownReferenceValue.cast(
            "Type", referencedClass, new ParticularReferenceValueFactory(), true);

    // Assert
    Clazz referencedClass2 = actualCastResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCastResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    assertEquals(0, actualCastResult.isNull());
    assertFalse(actualCastResult.isParticular());
    assertTrue(actualCastResult.mayBeExtension());
    assertTrue(actualCastResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCastResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory} (default constructor).
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when PrimitiveTypedReferenceValueFactory (default constructor); then return REFERENCE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue UnknownReferenceValue.cast(String, Clazz, ValueFactory, boolean)"
  })
  void testCast_whenPrimitiveTypedReferenceValueFactory_thenReturnReference_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        BasicValueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast(
            "Type", referencedClass, new PrimitiveTypedReferenceValueFactory(), true));
  }

  /**
   * Test {@link UnknownReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return MultiTypedReferenceValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceValue UnknownReferenceValue.generalize(ReferenceValue)"})
  void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    TypedReferenceValue type = new TypedReferenceValue("Type", new LibraryClass(), true, true);
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(type, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        unknownReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link UnknownReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return TracedReferenceValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceValue UnknownReferenceValue.generalize(ReferenceValue)"})
  void testGeneralizeWithReferenceValue_thenReturnTracedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        unknownReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link UnknownReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return UnknownReferenceValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceValue UnknownReferenceValue.generalize(ReferenceValue)"})
  void testGeneralizeWithReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    ReferenceValue actualGeneralizeResult =
        unknownReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertSame(unknownReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link UnknownReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnknownReferenceValue.equal(ReferenceValue)"})
  void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new UnknownReferenceValue().equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link UnknownReferenceValue#internalType()}.
   *
   * <p>Method under test: {@link UnknownReferenceValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UnknownReferenceValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/Object;", new UnknownReferenceValue().internalType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownReferenceValue}
   *   <li>{@link UnknownReferenceValue#toString()}
   *   <li>{@link UnknownReferenceValue#getReferencedClass()}
   *   <li>{@link UnknownReferenceValue#getType()}
   *   <li>{@link UnknownReferenceValue#isNull()}
   *   <li>{@link UnknownReferenceValue#isParticular()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownReferenceValue.<init>()",
    "Clazz UnknownReferenceValue.getReferencedClass()",
    "String UnknownReferenceValue.getType()",
    "int UnknownReferenceValue.isNull()",
    "boolean UnknownReferenceValue.isParticular()",
    "String UnknownReferenceValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    UnknownReferenceValue actualUnknownReferenceValue = new UnknownReferenceValue();
    String actualToStringResult = actualUnknownReferenceValue.toString();
    Clazz actualReferencedClass = actualUnknownReferenceValue.getReferencedClass();
    String actualType = actualUnknownReferenceValue.getType();
    int actualIsNullResult = actualUnknownReferenceValue.isNull();

    // Assert
    assertEquals("Ljava/lang/Object;", actualType);
    assertEquals("a", actualToStringResult);
    assertNull(actualReferencedClass);
    assertEquals(0, actualIsNullResult);
    assertFalse(actualUnknownReferenceValue.isParticular());
  }
}

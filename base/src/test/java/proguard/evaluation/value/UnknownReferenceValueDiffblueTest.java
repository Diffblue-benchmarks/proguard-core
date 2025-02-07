package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.UnknownReferenceValue.mayBeExtension()"})
  void testMayBeExtension() {
    // Arrange, Act and Assert
    assertTrue((new UnknownReferenceValue()).mayBeExtension());
  }

  /**
   * Test {@link UnknownReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link UnknownReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.UnknownReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
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
   *   <li>Then return {@link PrimitiveTypedReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); then return PrimitiveTypedReferenceValueFactory (default constructor) REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.UnknownReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_thenReturnPrimitiveTypedReferenceValueFactoryReference_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory} (default constructor).
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @DisplayName(
      "Test cast(String, Clazz, ValueFactory, boolean); when BasicValueFactory (default constructor); then return BasicValueFactory (default constructor) REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.UnknownReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_whenBasicValueFactory_thenReturnBasicValueFactoryReference_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    BasicValueFactory valueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast("Type", referencedClass, valueFactory, true));
  }

  /**
   * Test {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link UnknownReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  @DisplayName("Test cast(String, Clazz, ValueFactory, boolean); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.UnknownReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
  })
  void testCast_whenEmptyString() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();
    PrimitiveTypedReferenceValueFactory valueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        unknownReferenceValue.cast("", referencedClass, valueFactory, true));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.UnknownReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.UnknownReferenceValue.cast(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.ValueFactory, boolean)"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.UnknownReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.UnknownReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.UnknownReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(
        unknownReferenceValue, unknownReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.UnknownReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownReferenceValue()).equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link UnknownReferenceValue#internalType()}.
   *
   * <p>Method under test: {@link UnknownReferenceValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.evaluation.value.UnknownReferenceValue.internalType()"
  })
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/Object;", (new UnknownReferenceValue()).internalType());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.UnknownReferenceValue.<init>()",
    "proguard.classfile.Clazz proguard.evaluation.value.UnknownReferenceValue.getReferencedClass()",
    "java.lang.String proguard.evaluation.value.UnknownReferenceValue.getType()",
    "int proguard.evaluation.value.UnknownReferenceValue.isNull()",
    "boolean proguard.evaluation.value.UnknownReferenceValue.isParticular()",
    "java.lang.String proguard.evaluation.value.UnknownReferenceValue.toString()"
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

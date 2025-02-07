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

class IdentifiedArrayReferenceValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedArrayReferenceValue#IdentifiedArrayReferenceValue(String, Clazz,
   *       boolean, IntegerValue, ValueFactory, int)}
   *   <li>{@link IdentifiedArrayReferenceValue#toString()}
   *   <li>{@link IdentifiedArrayReferenceValue#isSpecific()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.IdentifiedArrayReferenceValue.<init>(java.lang.String, proguard.classfile.Clazz, boolean, proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory, int)",
    "boolean proguard.evaluation.value.IdentifiedArrayReferenceValue.isSpecific()",
    "java.lang.String proguard.evaluation.value.IdentifiedArrayReferenceValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    IdentifiedArrayReferenceValue actualIdentifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    String actualToStringResult = actualIdentifiedArrayReferenceValue.toString();
    boolean actualIsSpecificResult = actualIdentifiedArrayReferenceValue.isSpecific();

    // Assert
    assertEquals("Type![b]#1", actualToStringResult);
    assertEquals("Type", actualIdentifiedArrayReferenceValue.getType());
    assertTrue(actualIsSpecificResult);
    assertSame(referencedClass, actualIdentifiedArrayReferenceValue.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)} with
   * {@code IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue() {
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
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertNull(((LibraryClass) referencedClass3).interfaceNames);
    assertNull(((LibraryClass) referencedClass3).fields);
    assertNull(((LibraryClass) referencedClass3).methods);
    assertNull(referencedClass3.getProcessingInfo());
    assertNull(referencedClass3.getName());
    assertNull(referencedClass3.getSuperName());
    assertNull(referencedClass3.getFeatureName());
    assertNull(referencedClass3.getSuperClass());
    assertNull(((LibraryClass) referencedClass3).kotlinMetadata);
    assertEquals(0, referencedClass3.getAccessFlags());
    assertEquals(0, referencedClass3.getInterfaceCount());
    assertEquals(0, referencedClass3.getProcessingFlags());
    assertEquals(0, ((LibraryClass) referencedClass3).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) referencedClass3).subClassCount);
    assertTrue(referencedClass3.getExtraFeatureNames().isEmpty());
    assertSame(referencedClass2.subClasses, ((LibraryClass) referencedClass3).subClasses);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)} with
   * {@code IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertNull(((LibraryClass) referencedClass3).interfaceNames);
    assertNull(((LibraryClass) referencedClass3).fields);
    assertNull(((LibraryClass) referencedClass3).methods);
    assertNull(referencedClass3.getProcessingInfo());
    assertNull(referencedClass3.getName());
    assertNull(referencedClass3.getSuperName());
    assertNull(referencedClass3.getFeatureName());
    assertNull(referencedClass3.getSuperClass());
    assertNull(((LibraryClass) referencedClass3).kotlinMetadata);
    assertEquals(0, referencedClass3.getAccessFlags());
    assertEquals(0, referencedClass3.getInterfaceCount());
    assertEquals(0, referencedClass3.getProcessingFlags());
    assertEquals(0, ((LibraryClass) referencedClass3).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) referencedClass3).subClassCount);
    assertTrue(referencedClass3.getExtraFeatureNames().isEmpty());
    assertSame(referencedClass2.subClasses, ((LibraryClass) referencedClass3).subClasses);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)} with
   * {@code IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            2);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertNull(((LibraryClass) referencedClass3).interfaceNames);
    assertNull(((LibraryClass) referencedClass3).fields);
    assertNull(((LibraryClass) referencedClass3).methods);
    assertNull(referencedClass3.getProcessingInfo());
    assertNull(referencedClass3.getName());
    assertNull(referencedClass3.getSuperName());
    assertNull(referencedClass3.getFeatureName());
    assertNull(referencedClass3.getSuperClass());
    assertNull(((LibraryClass) referencedClass3).kotlinMetadata);
    assertEquals(0, referencedClass3.getAccessFlags());
    assertEquals(0, referencedClass3.getInterfaceCount());
    assertEquals(0, referencedClass3.getProcessingFlags());
    assertEquals(0, ((LibraryClass) referencedClass3).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) referencedClass3).subClassCount);
    assertTrue(referencedClass3.getExtraFeatureNames().isEmpty());
    assertSame(referencedClass2.subClasses, ((LibraryClass) referencedClass3).subClasses);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)} with
   * {@code IdentifiedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue_thenReturnType() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                false,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

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
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

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
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue3() {
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
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue4() {
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
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, identifiedArrayReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue5() {
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
            (ReferenceValue) new TypedReferenceValue("Type", referencedClass2, false, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return MultiTypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue() {
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
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return MultiTypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <ul>
   *   <li>Then return not mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return not mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnNotMayBeExtension() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then return NotNull is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnNotNullIsOne() {
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
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then return NotNull is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnNotNullIsOne2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
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
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnType() {
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
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedArrayReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_null_thenReturnType() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        (new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)} with {@code
   * ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedArrayReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value() {
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
   * Test {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue() {
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
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "proguard.evaluation.value.IdentifiedArrayReferenceValue",
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
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedArrayReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedArrayReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                false,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IdentifiedArrayReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue_thenReturnNever() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "proguard.evaluation.value.IdentifiedArrayReferenceValue",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        Value.NEVER,
        identifiedArrayReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                false,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue() {
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
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue2() {
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
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        identifiedArrayReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "proguard.evaluation.value.IdentifiedArrayReferenceValue",
            referencedClass,
            false,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        identifiedArrayReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            false,
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
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; given 'Type'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_givenType_thenCallsGetType() {
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
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        identifiedArrayReferenceValue.equal(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link TypedReferenceValueFactory#REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_java_lang_object_maybe_null() {
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
            .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_null_thenReturnNever() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        Value.NEVER,
        (new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
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
   * Test {@link IdentifiedArrayReferenceValue#equals(Object)}, and {@link
   * IdentifiedArrayReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedArrayReferenceValue#equals(Object)}
   *   <li>{@link IdentifiedArrayReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
    assertEquals(identifiedArrayReferenceValue, identifiedArrayReferenceValue);
    int expectedHashCodeResult = identifiedArrayReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedArrayReferenceValue.hashCode());
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    assertNotEquals(
        identifiedArrayReferenceValue,
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass2,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1),
        null);
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedArrayReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedArrayReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1),
        "Different type to IdentifiedArrayReferenceValue");
  }
}

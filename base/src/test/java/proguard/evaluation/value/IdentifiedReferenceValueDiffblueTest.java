package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

class IdentifiedReferenceValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedReferenceValue#IdentifiedReferenceValue(String, Clazz, boolean, boolean,
   *       ValueFactory, Object)}
   *   <li>{@link IdentifiedReferenceValue#toString()}
   *   <li>{@link IdentifiedReferenceValue#isSpecific()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.IdentifiedReferenceValue.<init>(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.ValueFactory, java.lang.Object)",
    "boolean proguard.evaluation.value.IdentifiedReferenceValue.isSpecific()",
    "java.lang.String proguard.evaluation.value.IdentifiedReferenceValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    IdentifiedReferenceValue actualIdentifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    String actualToStringResult = actualIdentifiedReferenceValue.toString();
    boolean actualIsSpecificResult = actualIdentifiedReferenceValue.isSpecific();

    // Assert
    assertEquals("Type", actualIdentifiedReferenceValue.getType());
    assertEquals("Type#Id", actualToStringResult);
    assertTrue(actualIsSpecificResult);
    assertSame(referencedClass, actualIdentifiedReferenceValue.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, referencedClass3);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, false, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, referencedClass3);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, referencedClass3);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, referencedClass3);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            valuefactory,
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass3, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Clazz referencedClass4 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass4 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, referencedClass4);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            valuefactory,
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass3, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Clazz referencedClass4 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass4 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, referencedClass4);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue_thenCallsGetType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, referencedClass3);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then return not mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'; then return not mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue_thenReturnNotMayBeExtension() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                false,
                true,
                new ParticularReferenceValueFactory(),
                "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, referencedClass3);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .generalize(other));
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue2() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue3() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue4() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
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
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue5() {
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

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2).isNull();
    assertSame(particularReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue6() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    valueFactory,
                    new IdentifiedReferenceValue(
                        "Type",
                        referencedClass3,
                        true,
                        true,
                        new ParticularReferenceValueFactory(),
                        "Id"),
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue7() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    valueFactory,
                    new IdentifiedArrayReferenceValue(
                        "Type",
                        referencedClass3,
                        true,
                        BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                        new ParticularReferenceValueFactory(),
                        1),
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue8() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), null, value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    valueFactory,
                    new IdentifiedReferenceValue(
                        "Type",
                        referencedClass3,
                        true,
                        true,
                        new ParticularReferenceValueFactory(),
                        "Id"),
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then return mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnMayBeExtension() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
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
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return not mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then return not mayBeExtension")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReturnNotMayBeExtension() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    AnalyzedObject value2 = mock(AnalyzedObject.class);
    when(value2.isNull()).thenReturn(true);
    when(value2.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            (ReferenceValue)
                new ParticularReferenceValue(
                    referencedClass2,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value2));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value2, atLeast(1)).getType();
    verify(value).isNull();
    verify(value2, atLeast(1)).isNull();
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_null() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);

    // Act
    ReferenceValue actualGeneralizeResult =
        particularReferenceValue.generalize(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    verify(value, atLeast(1)).getType();
    assertSame(particularReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE; then return REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.IdentifiedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value))
            .generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                true,
                true,
                new ParticularReferenceValueFactory(),
                "Id")));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "proguard.evaluation.value.IdentifiedReferenceValue",
            referencedClass,
            true,
            true,
            new ParticularReferenceValueFactory(),
            "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                true,
                true,
                new ParticularReferenceValueFactory(),
                "Id")));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, false, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                true,
                true,
                new ParticularReferenceValueFactory(),
                "Id")));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                true,
                true,
                new ParticularReferenceValueFactory(),
                "Id")));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue5() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                false,
                true,
                new ParticularReferenceValueFactory(),
                "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue_thenCallsGetType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue_thenReturnNever() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("foo");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                false,
                true,
                new ParticularReferenceValueFactory(),
                "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id")));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, false, true, new ParticularReferenceValueFactory(), "Id");
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        identifiedReferenceValue.equal(
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
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, false, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id")));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#getType()} return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; given AnalyzedObject getType() return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_givenAnalyzedObjectGetTypeReturnType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValue particularReferenceValue =
        new ParticularReferenceValue(
            referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        particularReferenceValue.equal(
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
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link AnalyzedObject} {@link AnalyzedObject#getType()} return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; given 'Type'; when AnalyzedObject getType() return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_givenType_whenAnalyzedObjectGetTypeReturnType() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        identifiedReferenceValue.equal(
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
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_thenReturnNever() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "proguard.evaluation.value.IdentifiedReferenceValue",
            referencedClass,
            false,
            true,
            new ParticularReferenceValueFactory(),
            "Id");
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        identifiedReferenceValue.equal(
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
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link TypedReferenceValueFactory#REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_java_lang_object_maybe_null() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IdentifiedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_null() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equals(Object)}, and {@link
   * IdentifiedReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedReferenceValue#equals(Object)}
   *   <li>{@link IdentifiedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedReferenceValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    // Act and Assert
    assertEquals(identifiedReferenceValue, identifiedReferenceValue);
    int expectedHashCodeResult = identifiedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedReferenceValue.hashCode());
  }

  /**
   * Test {@link IdentifiedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        identifiedReferenceValue,
        new IdentifiedReferenceValue(
            "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));
  }

  /**
   * Test {@link IdentifiedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        null);
  }

  /**
   * Test {@link IdentifiedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        "Different type to IdentifiedReferenceValue");
  }
}

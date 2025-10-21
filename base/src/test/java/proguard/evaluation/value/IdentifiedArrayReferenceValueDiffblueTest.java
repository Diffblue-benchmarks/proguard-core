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

public class IdentifiedArrayReferenceValueDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IdentifiedArrayReferenceValue.<init>(String, Clazz, boolean, IntegerValue, ValueFactory, int)",
    "boolean IdentifiedArrayReferenceValue.isSpecific()",
    "String IdentifiedArrayReferenceValue.toString()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedArrayReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedArrayReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedArrayReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedArrayReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue_thenReturnType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue4() {
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
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
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
                    "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue7() {
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
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue8() {
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
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnMultiTypedReferenceValue() {
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
   *   <li>Then return NotNull is zero.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnNotNullIsZero() {
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
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedArrayReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue_thenReturnNever() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue identifiedArrayReferenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicValueFactory.INTEGER_VALUE,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue4() {
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
                    "Type", new LibraryClass(), false, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue5() {
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
                new ArrayReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    new ComparisonValue(
                        BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                        BasicRangeValueFactory.INTEGER_VALUE_BYTE))));
  }

  /**
   * Test {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue7() {
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
   *   <li>When {@link TypedReferenceValueFactory#REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedArrayReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_java_lang_object_maybe_null() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_null_thenReturnNever() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedArrayReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedArrayReferenceValue.equals(Object)",
    "int IdentifiedArrayReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedArrayReferenceValue.equals(Object)",
    "int IdentifiedArrayReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedArrayReferenceValue.equals(Object)",
    "int IdentifiedArrayReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedArrayReferenceValue.equals(Object)",
    "int IdentifiedArrayReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

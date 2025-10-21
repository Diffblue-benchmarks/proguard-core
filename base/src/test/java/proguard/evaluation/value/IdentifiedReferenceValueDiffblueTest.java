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

public class IdentifiedReferenceValueDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IdentifiedReferenceValue.<init>(String, Clazz, boolean, boolean, ValueFactory, Object)",
    "boolean IdentifiedReferenceValue.isSpecific()",
    "String IdentifiedReferenceValue.toString()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedReferenceValue.generalize(IdentifiedReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedReferenceValue() {
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
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedReferenceValue.generalize(IdentifiedReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedReferenceValue2() {
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
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedReferenceValue.generalize(IdentifiedReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedReferenceValue3() {
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
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedReferenceValue.generalize(IdentifiedReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedReferenceValue4() {
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
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedReferenceValue.generalize(IdentifiedReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedReferenceValue5() {
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
    assertNull(((LibraryClass) referencedClass4).interfaceNames);
    assertNull(((LibraryClass) referencedClass4).fields);
    assertNull(((LibraryClass) referencedClass4).methods);
    assertNull(referencedClass4.getProcessingInfo());
    assertNull(referencedClass4.getName());
    assertNull(referencedClass4.getSuperName());
    assertNull(referencedClass4.getFeatureName());
    assertNull(referencedClass4.getSuperClass());
    assertNull(((LibraryClass) referencedClass4).kotlinMetadata);
    assertEquals(0, referencedClass4.getAccessFlags());
    assertEquals(0, referencedClass4.getInterfaceCount());
    assertEquals(0, referencedClass4.getProcessingFlags());
    assertEquals(0, ((LibraryClass) referencedClass4).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) referencedClass4).subClassCount);
    assertTrue(referencedClass4.getExtraFeatureNames().isEmpty());
    assertSame(referencedClass3.subClasses, ((LibraryClass) referencedClass4).subClasses);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedReferenceValue.generalize(IdentifiedReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedReferenceValue6() {
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
    assertNull(((LibraryClass) referencedClass4).interfaceNames);
    assertNull(((LibraryClass) referencedClass4).fields);
    assertNull(((LibraryClass) referencedClass4).methods);
    assertNull(referencedClass4.getProcessingInfo());
    assertNull(referencedClass4.getName());
    assertNull(referencedClass4.getSuperName());
    assertNull(referencedClass4.getFeatureName());
    assertNull(referencedClass4.getSuperClass());
    assertNull(((LibraryClass) referencedClass4).kotlinMetadata);
    assertEquals(0, referencedClass4.getAccessFlags());
    assertEquals(0, referencedClass4.getInterfaceCount());
    assertEquals(0, referencedClass4.getProcessingFlags());
    assertEquals(0, ((LibraryClass) referencedClass4).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) referencedClass4).subClassCount);
    assertTrue(referencedClass4.getExtraFeatureNames().isEmpty());
    assertSame(referencedClass3.subClasses, ((LibraryClass) referencedClass4).subClasses);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedReferenceValue.generalize(IdentifiedReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedReferenceValue_thenReturnNotNullIsOne() {
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
                "Type",
                referencedClass2,
                true,
                false,
                new ParticularReferenceValueFactory(),
                "Id"));

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue IdentifiedReferenceValue.generalize(IdentifiedReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedReferenceValue_thenReturnType() {
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
                "Type",
                referencedClass2,
                false,
                true,
                new ParticularReferenceValueFactory(),
                "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertFalse(actualGeneralizeResult.mayBeExtension());
    assertFalse(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    // Act and Assert
    assertSame(
        identifiedReferenceValue,
        identifiedReferenceValue.generalize(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", referencedClass2, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act and Assert
    assertSame(other, identifiedReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act and Assert
    assertSame(
        other,
        (new IdentifiedReferenceValue(
                "", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .generalize(other));
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue8() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

    // Act and Assert
    assertSame(
        other,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id"))
            .generalize(other));
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue9() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", referencedClass2, false, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue10() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, false, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue12() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), 1);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue13() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    valuefactory,
                    new IdentifiedReferenceValue(
                        "Type",
                        referencedClass3,
                        true,
                        true,
                        new ParticularReferenceValueFactory(),
                        "Id")));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue14() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    LibraryClass referencedClass3 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    valuefactory,
                    new IdentifiedArrayReferenceValue(
                        "Type",
                        referencedClass3,
                        true,
                        BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                        new ParticularReferenceValueFactory(),
                        1)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass2, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue15() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, false, true, new ParticularReferenceValueFactory(), "Id");
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue16() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id");
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue17() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            valuefactory,
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue18() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            valuefactory,
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true));

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            (ReferenceValue)
                new MultiTypedReferenceValue(
                    new TypedReferenceValue("Type", new LibraryClass(), true, true), true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(identifiedReferenceValue.id, actualGeneralizeResult);
  }

  /**
   * Test {@link IdentifiedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue19() {
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
    MultiTypedReferenceValue other =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_null() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id"))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue IdentifiedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_thenReturnReference_value() {
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
   * Test {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue5() {
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
                false,
                true,
                new ParticularReferenceValueFactory(),
                "Id")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue_thenReturnNever() {
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
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        Value.NEVER,
        identifiedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                false,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue3() {
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
   * <p>Method under test: {@link IdentifiedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue5() {
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
                    false,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_thenReturnNever() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        Value.NEVER,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id"))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_java_lang_object_maybe_null() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IdentifiedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_null() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedReferenceValue.equals(Object)",
    "int IdentifiedReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedReferenceValue.equals(Object)",
    "int IdentifiedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedReferenceValue.equals(Object)",
    "int IdentifiedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean IdentifiedReferenceValue.equals(Object)",
    "int IdentifiedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        "Different type to IdentifiedReferenceValue");
  }
}

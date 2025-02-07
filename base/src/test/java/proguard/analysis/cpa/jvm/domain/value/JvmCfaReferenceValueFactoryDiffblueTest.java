package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ParticularReferenceValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.object.AnalyzedObject;

class JvmCfaReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link JvmCfaReferenceValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * CodeLocation}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link JvmCfaReferenceValueFactory#createReferenceValue(Clazz, boolean,
   * boolean, CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.analysis.cpa.jvm.domain.value.JvmCfaReferenceValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory =
        new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        jvmCfaReferenceValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value, atLeast(1)).getType();
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertNull(((ParticularReferenceValue) actualCreateReferenceValueResult).id);
    assertEquals(-1, actualCreateReferenceValueResult.isNull());
    assertEquals(1, actualCreateReferenceValueResult.isNotNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
    assertSame(value, actualCreateReferenceValueResult.getValue());
  }

  /**
   * Test {@link JvmCfaReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link JvmCfaReferenceValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.analysis.cpa.jvm.domain.value.JvmCfaReferenceValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory =
        new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        jvmCfaReferenceValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, creationClass, new LibraryMethod(), 1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertNull(((IdentifiedReferenceValue) actualCreateReferenceValueResult).id);
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, referencedClass2);
  }
}

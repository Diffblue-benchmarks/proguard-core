package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ReferenceValue;

public class JvmCfaReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link JvmCfaReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link JvmCfaReferenceValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue JvmCfaReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
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

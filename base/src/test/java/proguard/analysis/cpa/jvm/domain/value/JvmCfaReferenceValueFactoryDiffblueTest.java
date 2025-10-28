package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.object.AnalyzedObject;

public class JvmCfaReferenceValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link JvmCfaReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    JvmCfaReferenceValueFactory jvmCfaReferenceValueFactory = new JvmCfaReferenceValueFactory(new JvmCfa());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = jvmCfaReferenceValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(((IdentifiedReferenceValue) actualCreateReferenceValueResult).id);
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }
}

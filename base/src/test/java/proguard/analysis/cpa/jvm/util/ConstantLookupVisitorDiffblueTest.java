package proguard.analysis.cpa.jvm.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ConstantLookupVisitorDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ConstantLookupVisitor}
   */
  @Test
  public void testNewConstantLookupVisitor() {
    // Arrange and Act
    ConstantLookupVisitor actualConstantLookupVisitor = new ConstantLookupVisitor();

    // Assert
    assertNull(actualConstantLookupVisitor.result);
    assertNull(actualConstantLookupVisitor.resultClazz);
    assertEquals(-1, actualConstantLookupVisitor.resultSize);
    assertFalse(actualConstantLookupVisitor.isStatic);
  }
}

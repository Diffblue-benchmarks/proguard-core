package proguard.analysis.cpa.jvm.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConstantLookupVisitorDiffblueTest {
  /**
   * Test new {@link ConstantLookupVisitor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ConstantLookupVisitor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantLookupVisitor.<init>()"})
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

package proguard.dexfile.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.converter.Dex2IRConverter.DvmValue;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.reader.DexLabel;

public class Dex2IRConverterDiffblueTest {
  /**
   * Test DvmValue {@link DvmValue#DvmValue()}.
   *
   * <ul>
   *   <li>Then return {@link DvmValue#otherParent} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DvmValue#DvmValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DvmValue.<init>()", "void DvmValue.<init>(Local)"})
  public void testDvmValueNewDvmValue_thenReturnOtherParentIsNull() {
    // Arrange and Act
    DvmValue actualDvmValue = new DvmValue();

    // Assert
    assertNull(actualDvmValue.otherParent);
    assertNull(actualDvmValue.parent);
    assertNull(actualDvmValue.local);
  }

  /**
   * Test DvmValue {@link DvmValue#DvmValue(Local)}.
   *
   * <ul>
   *   <li>When {@link Local#Local()}.
   *   <li>Then return {@link DvmValue#local} toString0 is {@code a0}.
   * </ul>
   *
   * <p>Method under test: {@link DvmValue#DvmValue(Local)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DvmValue.<init>()", "void DvmValue.<init>(Local)"})
  public void testDvmValueNewDvmValue_whenLocal_thenReturnLocalToString0IsA0() {
    // Arrange, Act and Assert
    Local local = (new DvmValue(new Local())).local;
    assertEquals("a0", local.toString0());
    assertNull(local.getOps());
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
  }

  /**
   * Test {@link Dex2IRConverter#sizeofType(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Dex2IRConverter#sizeofType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Dex2IRConverter.sizeofType(String)"})
  public void testSizeofType_whenFoo_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, Dex2IRConverter.sizeofType("foo"));
  }

  /**
   * Test {@link Dex2IRConverter#methodArgCount(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Dex2IRConverter#methodArgCount(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Dex2IRConverter.methodArgCount(String[])"})
  public void testMethodArgCount_whenArrayOfStringWithArgs_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, Dex2IRConverter.methodArgCount(new String[] {"Args"}));
  }

  /**
   * Test {@link Dex2IRConverter#getLocal(DvmValue)}.
   *
   * <ul>
   *   <li>When {@link DvmValue#DvmValue(Local)} with thiz is {@link Local#Local()}.
   *   <li>Then return {@link DvmValue#DvmValue(Local)} with thiz is {@link Local#Local()} {@link
   *       DvmValue#local}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2IRConverter#getLocal(DvmValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Local Dex2IRConverter.getLocal(DvmValue)"})
  public void testGetLocal_whenDvmValueWithThizIsLocal_thenReturnDvmValueWithThizIsLocalLocal() {
    // Arrange
    Dex2IRConverter dex2IRConverter = new Dex2IRConverter();
    DvmValue value = new DvmValue(new Local());

    // Act and Assert
    assertSame(value.local, dex2IRConverter.getLocal(value));
  }

  /**
   * Test {@link Dex2IRConverter#getLabel(DexLabel)}.
   *
   * <ul>
   *   <li>When {@link DexLabel#DexLabel()}.
   *   <li>Then return Ops is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2IRConverter#getLabel(DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LabelStmt Dex2IRConverter.getLabel(DexLabel)"})
  public void testGetLabel_whenDexLabel_thenReturnOpsIsNull() {
    // Arrange
    Dex2IRConverter dex2IRConverter = new Dex2IRConverter();

    // Act
    LabelStmt actualLabel = dex2IRConverter.getLabel(new DexLabel());

    // Assert
    assertNull(actualLabel.getOps());
    assertNull(actualLabel.tag);
    assertNull(actualLabel.frame);
    assertNull(actualLabel.phis);
    assertNull(actualLabel.exceptionHandlers);
    assertNull(actualLabel._cfg_froms);
    assertNull(actualLabel.getOp());
    assertNull(actualLabel.getOp1());
    assertNull(actualLabel.getOp2());
    assertNull(actualLabel.getNext());
    assertNull(actualLabel.getPre());
    assertNull(actualLabel._ts_default_next);
    assertEquals(-1, actualLabel.lineNumber);
    assertEquals(0, actualLabel.id);
    assertEquals(1, dex2IRConverter.map.size());
    assertEquals(ET.E0, actualLabel.et);
    assertEquals(ST.LABEL, actualLabel.st);
    assertFalse(actualLabel.visited);
  }

  /**
   * Test new {@link Dex2IRConverter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Dex2IRConverter}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Dex2IRConverter.<init>()"})
  public void testNewDex2IRConverter() {
    // Arrange and Act
    Dex2IRConverter actualDex2IRConverter = new Dex2IRConverter();

    // Assert
    assertTrue(actualDex2IRConverter.preEmit.isEmpty());
    assertTrue(actualDex2IRConverter.labelMap.isEmpty());
    assertTrue(actualDex2IRConverter.map.isEmpty());
  }
}

package proguard.dexfile.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.reader.DexLabel;

public class Dex2IRConverterDiffblueTest {
  /**
   * Method under test: {@link Dex2IRConverter.DvmValue#DvmValue()}
   */
  @Test
  public void testDvmValueNewDvmValue() {
    // Arrange and Act
    Dex2IRConverter.DvmValue actualDvmValue = new Dex2IRConverter.DvmValue();

    // Assert
    assertNull(actualDvmValue.otherParent);
    assertNull(actualDvmValue.parent);
    assertNull(actualDvmValue.local);
  }

  /**
   * Method under test: {@link Dex2IRConverter.DvmValue#DvmValue(Local)}
   */
  @Test
  public void testDvmValueNewDvmValue2() {
    // Arrange, Act and Assert
    Local local = (new Dex2IRConverter.DvmValue(new Local())).local;
    assertEquals("a0", local.toString0());
    assertNull(local.getOps());
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
  }

  /**
   * Method under test: {@link Dex2IRConverter#sizeofType(String)}
   */
  @Test
  public void testSizeofType() {
    // Arrange, Act and Assert
    assertEquals(1, Dex2IRConverter.sizeofType("foo"));
  }

  /**
   * Method under test: {@link Dex2IRConverter#methodArgCount(String[])}
   */
  @Test
  public void testMethodArgCount() {
    // Arrange, Act and Assert
    assertEquals(1, Dex2IRConverter.methodArgCount(new String[]{"Args"}));
  }

  /**
   * Method under test: {@link Dex2IRConverter#getLocal(Dex2IRConverter.DvmValue)}
   */
  @Test
  public void testGetLocal() {
    // Arrange
    Dex2IRConverter dex2IRConverter = new Dex2IRConverter();
    Dex2IRConverter.DvmValue value = new Dex2IRConverter.DvmValue(new Local());

    // Act and Assert
    assertSame(value.local, dex2IRConverter.getLocal(value));
  }

  /**
   * Method under test: {@link Dex2IRConverter#getLabel(DexLabel)}
   */
  @Test
  public void testGetLabel() {
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
    assertEquals(Stmt.ST.LABEL, actualLabel.st);
    assertFalse(actualLabel.visited);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Dex2IRConverter}
   */
  @Test
  public void testNewDex2IRConverter() {
    // Arrange and Act
    Dex2IRConverter actualDex2IRConverter = new Dex2IRConverter();

    // Assert
    assertTrue(actualDex2IRConverter.preEmit.isEmpty());
    assertTrue(actualDex2IRConverter.labelMap.isEmpty());
    assertTrue(actualDex2IRConverter.map.isEmpty());
  }
}

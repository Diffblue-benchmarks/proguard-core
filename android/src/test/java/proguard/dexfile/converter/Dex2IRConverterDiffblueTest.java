package proguard.dexfile.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.converter.Dex2IRConverter.DvmValue;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.reader.DexLabel;

class Dex2IRConverterDiffblueTest {
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
  @DisplayName("Test DvmValue new DvmValue(); then return otherParent is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DvmValue.<init>()", "void DvmValue.<init>(Local)"})
  void testDvmValueNewDvmValue_thenReturnOtherParentIsNull() {
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
  @DisplayName(
      "Test DvmValue new DvmValue(Local); when Local(); then return local toString0 is 'a0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DvmValue.<init>()", "void DvmValue.<init>(Local)"})
  void testDvmValueNewDvmValue_whenLocal_thenReturnLocalToString0IsA0() {
    // Arrange, Act and Assert
    Local local = new DvmValue(new Local()).local;
    assertEquals("a0", local.toString0());
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
    assertNull(local.getOps());
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
  @DisplayName("Test sizeofType(String); when 'foo'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Dex2IRConverter.sizeofType(String)"})
  void testSizeofType_whenFoo_thenReturnOne() {
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
  @DisplayName("Test methodArgCount(String[]); when array of String with 'Args'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Dex2IRConverter.methodArgCount(String[])"})
  void testMethodArgCount_whenArrayOfStringWithArgs_thenReturnOne() {
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
  @DisplayName(
      "Test getLocal(DvmValue); when DvmValue(Local) with thiz is Local(); then return DvmValue(Local) with thiz is Local() local")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Local Dex2IRConverter.getLocal(DvmValue)"})
  void testGetLocal_whenDvmValueWithThizIsLocal_thenReturnDvmValueWithThizIsLocalLocal() {
    // Arrange
    Dex2IRConverter dex2IRConverter = new Dex2IRConverter();
    DvmValue value = new DvmValue(new Local());

    // Act
    Local actualLocal = dex2IRConverter.getLocal(value);

    // Assert
    assertSame(value.local, actualLocal);
  }

  /**
   * Test {@link Dex2IRConverter#getLabel(DexLabel)}.
   *
   * <ul>
   *   <li>When {@link DexLabel#DexLabel()}.
   *   <li>Then return {@link LabelStmt#tag} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2IRConverter#getLabel(DexLabel)}
   */
  @Test
  @DisplayName("Test getLabel(DexLabel); when DexLabel(); then return tag is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LabelStmt Dex2IRConverter.getLabel(DexLabel)"})
  void testGetLabel_whenDexLabel_thenReturnTagIsNull() {
    // Arrange
    Dex2IRConverter dex2IRConverter = new Dex2IRConverter();

    // Act
    LabelStmt actualLabel = dex2IRConverter.getLabel(new DexLabel());

    // Assert
    assertNull(actualLabel.tag);
    assertNull(actualLabel.frame);
    assertNull(actualLabel.phis);
    assertNull(actualLabel.exceptionHandlers);
    assertNull(actualLabel._cfg_froms);
    assertNull(actualLabel.getOp());
    assertNull(actualLabel.getOp1());
    assertNull(actualLabel.getOp2());
    assertNull(actualLabel.getOps());
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
  @DisplayName("Test new Dex2IRConverter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dex2IRConverter.<init>()"})
  void testNewDex2IRConverter() {
    // Arrange and Act
    Dex2IRConverter actualDex2IRConverter = new Dex2IRConverter();

    // Assert
    assertTrue(actualDex2IRConverter.preEmit.isEmpty());
    assertTrue(actualDex2IRConverter.labelMap.isEmpty());
    assertTrue(actualDex2IRConverter.map.isEmpty());
  }
}

package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.reader.DexType;

class ConstantDiffblueTest {
  /**
   * Test {@link Constant#Constant(Object)}.
   *
   * <p>Method under test: {@link Constant#Constant(Object)}
   */
  @Test
  @DisplayName("Test new Constant(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Constant.<init>(Object)"})
  void testNewConstant() {
    // Arrange and Act
    Constant actualConstant = new Constant(Constant.Null);

    // Assert
    assertNull(actualConstant.tag);
    assertNull(actualConstant.valueType);
    assertNull(actualConstant.getOp());
    assertNull(actualConstant.getOp1());
    assertNull(actualConstant.getOp2());
    assertNull(actualConstant.getOps());
    assertEquals(ET.E0, actualConstant.et);
    assertEquals(VT.CONSTANT, actualConstant.vt);
  }

  /**
   * Test {@link Constant#clone()}.
   *
   * <p>Method under test: {@link Constant#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Constant.clone()"})
  void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nNull().clone();

    // Assert
    assertTrue(actualCloneResult instanceof Constant);
    assertNull(((Constant) actualCloneResult).tag);
    assertNull(((Constant) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertEquals(ET.E0, ((Constant) actualCloneResult).et);
    assertEquals(VT.CONSTANT, ((Constant) actualCloneResult).vt);
  }

  /**
   * Test {@link Constant#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link Constant#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Constant.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    Value actualCloneResult = nNullResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof Constant);
    assertNull(((Constant) actualCloneResult).tag);
    assertNull(((Constant) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertEquals(ET.E0, ((Constant) actualCloneResult).et);
    assertEquals(VT.CONSTANT, ((Constant) actualCloneResult).vt);
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given {@link Constant#Constant(Object)} with value is {@code 42}.
   *   <li>Then return {@code "42"}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given Constant(Object) with value is '42'; then return '\"42\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenConstantWithValueIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("\"42\"", new Constant("42").toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given {@link Constant#Constant(Object)} with value is forty-two.
   *   <li>Then return {@code 42L}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given Constant(Object) with value is forty-two; then return '42L'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenConstantWithValueIsFortyTwo_thenReturn42l() {
    // Arrange, Act and Assert
    assertEquals("42L", new Constant(42L).toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given {@link Constant#Constant(Object)} with value is {@code null}.
   *   <li>Then return {@code NULL}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given Constant(Object) with value is 'null'; then return 'NULL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenConstantWithValueIsNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("NULL", new Constant(null).toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given {@link Constant#Constant(Object)} with value is ten.
   *   <li>Then return {@code 10.0F}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given Constant(Object) with value is ten; then return '10.0F'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenConstantWithValueIsTen_thenReturn100f() {
    // Arrange, Act and Assert
    assertEquals("10.0F", new Constant(10.0f).toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given {@link DexType#DexType(String)} with desc is empty string.
   *   <li>Then return {@code .class}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given DexType(String) with desc is empty string; then return '.class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenDexTypeWithDescIsEmptyString_thenReturnClass() {
    // Arrange, Act and Assert
    assertEquals(".class", new Constant(new DexType("")).toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given {@link DexType#DexType(String)} with desc is {@code null}.
   *   <li>Then return {@code .class}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given DexType(String) with desc is 'null'; then return '.class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenDexTypeWithDescIsNull_thenReturnClass() {
    // Arrange, Act and Assert
    assertEquals(".class", new Constant(new DexType(null)).toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given {@link DexType#DexType(String)} with {@code Desc}.
   *   <li>Then return {@code double.class}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given DexType(String) with 'Desc'; then return 'double.class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenDexTypeWithDesc_thenReturnDoubleClass() {
    // Arrange, Act and Assert
    assertEquals("double.class", new Constant(new DexType("Desc")).toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nByte {@code A}.
   *   <li>Then return {@code 65}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nByte 'A'; then return '65'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenNByteA_thenReturn65() {
    // Arrange
    Constant nByteResult = Exprs.nByte((byte) 'A');

    // Act and Assert
    assertEquals("65", nByteResult.toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nChar {@code A}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nChar 'A'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenNCharA_thenReturnA() {
    // Arrange
    Constant nCharResult = Exprs.nChar('A');

    // Act and Assert
    assertEquals("A", nCharResult.toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nNull.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nNull; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  void testToString0_givenNNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", Exprs.nNull().toString0());
  }
}

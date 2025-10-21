package proguard.dexfile.converter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;

public class DexFixDiffblueTest {
  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Desc}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  public void testIsPrimitiveZero_whenDesc_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DexFix.isPrimitiveZero("Desc", 0.0d));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  public void testIsPrimitiveZero_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero("", Constant.Null));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  public void testIsPrimitiveZero_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero(null, null));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  public void testIsPrimitiveZero_whenNull_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero(null, 0));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  public void testIsPrimitiveZero_whenTen_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero("Desc", 10.0d));
  }

  /**
   * Test {@link DexFix#isPrimitiveZero(String, Object)}.
   *
   * <ul>
   *   <li>When {@code The characteristics of someone or something}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DexFix.isPrimitiveZero(String, Object)"})
  public void testIsPrimitiveZero_whenTheCharacteristicsOfSomeoneOrSomething_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        DexFix.isPrimitiveZero("The characteristics of someone or something", Constant.Null));
  }
}

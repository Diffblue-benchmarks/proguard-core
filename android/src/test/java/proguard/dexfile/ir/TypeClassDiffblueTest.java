package proguard.dexfile.ir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeClassDiffblueTest {
  /**
   * Test {@link TypeClass#clzOf(String)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#clzOf(String)}
   */
  @Test
  @DisplayName("Test clzOf(String); when 'BOOLEAN'; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  void testClzOf_whenBoolean_thenReturnInt() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.INT, TypeClass.clzOf("BOOLEAN"));
  }

  /**
   * Test {@link TypeClass#clzOf(String)}.
   *
   * <ul>
   *   <li>When {@code Desc}.
   *   <li>Then return {@code DOUBLE}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#clzOf(String)}
   */
  @Test
  @DisplayName("Test clzOf(String); when 'Desc'; then return 'DOUBLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  void testClzOf_whenDesc_thenReturnDouble() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.DOUBLE, TypeClass.clzOf("Desc"));
  }

  /**
   * Test {@link TypeClass#clzOf(String)}.
   *
   * <ul>
   *   <li>When {@code F}.
   *   <li>Then return {@code FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#clzOf(String)}
   */
  @Test
  @DisplayName("Test clzOf(String); when 'F'; then return 'FLOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  void testClzOf_whenF_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.FLOAT, TypeClass.clzOf("F"));
  }

  /**
   * Test {@link TypeClass#clzOf(String)}.
   *
   * <ul>
   *   <li>When {@code J}.
   *   <li>Then return {@code LONG}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#clzOf(String)}
   */
  @Test
  @DisplayName("Test clzOf(String); when 'J'; then return 'LONG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  void testClzOf_whenJ_thenReturnLong() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.LONG, TypeClass.clzOf("J"));
  }

  /**
   * Test {@link TypeClass#clzOf(String)}.
   *
   * <ul>
   *   <li>When {@code L}.
   *   <li>Then return {@code OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#clzOf(String)}
   */
  @Test
  @DisplayName("Test clzOf(String); when 'L'; then return 'OBJECT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  void testClzOf_whenL_thenReturnObject() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.OBJECT, TypeClass.clzOf("L"));
  }

  /**
   * Test {@link TypeClass#clzOf(String)}.
   *
   * <ul>
   *   <li>When {@code The characteristics of someone or something}.
   *   <li>Then return {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#clzOf(String)}
   */
  @Test
  @DisplayName(
      "Test clzOf(String); when 'The characteristics of someone or something'; then return 'UNKNOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  void testClzOf_whenTheCharacteristicsOfSomeoneOrSomething_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.UNKNOWN, TypeClass.clzOf("The characteristics of someone or something"));
  }

  /**
   * Test {@link TypeClass#clzOf(String)}.
   *
   * <ul>
   *   <li>When {@code V}.
   *   <li>Then return {@code VOID}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#clzOf(String)}
   */
  @Test
  @DisplayName("Test clzOf(String); when 'V'; then return 'VOID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  void testClzOf_whenV_thenReturnVoid() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.VOID, TypeClass.clzOf("V"));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'BOOLEAN'; then return 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenBoolean_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.BOOLEAN, TypeClass.merge(TypeClass.BOOLEAN, TypeClass.BOOLEAN));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@link TypeClass#BOOLEAN}.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when BOOLEAN; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenBoolean_thenReturnInt() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.BOOLEAN, TypeClass.INT));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'BOOLEAN'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenBoolean_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.BOOLEAN, TypeClass.FLOAT));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'FLOAT'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenFloat_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.FLOAT, TypeClass.BOOLEAN));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@link TypeClass#INT}.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when INT; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenInt_thenReturnInt() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.INT, TypeClass.BOOLEAN));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@link TypeClass#INT}.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when INT; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenInt_thenReturnInt2() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.INT, TypeClass.JD));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code INT}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'INT'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenInt_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.INT, TypeClass.FLOAT));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@link TypeClass#JD}.
   *   <li>Then return {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when JD; then return 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenJd_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.BOOLEAN, TypeClass.merge(TypeClass.JD, TypeClass.BOOLEAN));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@link TypeClass#JD}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when JD; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenJd_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.JD, TypeClass.IF));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@link TypeClass#JD}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when JD; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenJd_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.IF, TypeClass.JD));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@link TypeClass#UNKNOWN}.
   *   <li>Then return {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when UNKNOWN; then return 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenUnknown_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.BOOLEAN, TypeClass.merge(TypeClass.UNKNOWN, TypeClass.BOOLEAN));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@link TypeClass#UNKNOWN}.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when UNKNOWN; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenUnknown_thenReturnInt() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.INT, TypeClass.UNKNOWN));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZI}.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZI'; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZi_thenReturnInt() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.ZI, TypeClass.IF));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZI}.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZI'; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZi_thenReturnInt2() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.IF, TypeClass.ZI));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZI}.
   *   <li>Then return {@code ZI}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZI'; then return 'ZI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZi_thenReturnZi() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.ZI, TypeClass.merge(TypeClass.ZI, TypeClass.ZIFL));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZIF}.
   *   <li>Then return {@code IF}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZIF'; then return 'IF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZif_thenReturnIf() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.IF, TypeClass.merge(TypeClass.ZIF, TypeClass.IF));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZIF}.
   *   <li>Then return {@code ZI}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZIF'; then return 'ZI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZif_thenReturnZi() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.ZI, TypeClass.merge(TypeClass.ZIF, TypeClass.ZI));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZIF}.
   *   <li>Then return {@code ZIF}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZIF'; then return 'ZIF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZif_thenReturnZif() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.ZIF, TypeClass.merge(TypeClass.ZIF, TypeClass.ZIFL));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZIFL}.
   *   <li>Then return {@code IF}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZIFL'; then return 'IF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZifl_thenReturnIf() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.IF, TypeClass.merge(TypeClass.IF, TypeClass.ZIFL));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZIFL}.
   *   <li>Then return {@code IF}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZIFL'; then return 'IF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZifl_thenReturnIf2() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.IF, TypeClass.merge(TypeClass.ZIFL, TypeClass.IF));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZIL}.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZIL'; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZil_thenReturnInt() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.ZIL, TypeClass.IF));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZIL}.
   *   <li>Then return {@code ZI}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZIL'; then return 'ZI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZil_thenReturnZi() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.ZI, TypeClass.merge(TypeClass.ZIL, TypeClass.ZIF));
  }

  /**
   * Test {@link TypeClass#merge(TypeClass, TypeClass)}.
   *
   * <ul>
   *   <li>When {@code ZIL}.
   *   <li>Then return {@code ZIL}.
   * </ul>
   *
   * <p>Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  @DisplayName("Test merge(TypeClass, TypeClass); when 'ZIL'; then return 'ZIL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  void testMerge_whenZil_thenReturnZil() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.ZIL, TypeClass.merge(TypeClass.ZIL, TypeClass.ZIFL));
  }

  /**
   * Test {@link TypeClass#toString()}.
   *
   * <p>Method under test: {@link TypeClass#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeClass.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Z", TypeClass.valueOf("BOOLEAN").toString());
  }
}

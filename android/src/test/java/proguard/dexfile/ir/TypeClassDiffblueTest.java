package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypeClassDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  public void testClzOf_whenBoolean_thenReturnInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  public void testClzOf_whenDesc_thenReturnDouble() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  public void testClzOf_whenF_thenReturnFloat() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  public void testClzOf_whenJ_thenReturnLong() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  public void testClzOf_whenL_thenReturnObject() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  public void testClzOf_whenTheCharacteristicsOfSomeoneOrSomething_thenReturnUnknown() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.clzOf(String)"})
  public void testClzOf_whenV_thenReturnVoid() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenBoolean_thenReturnBoolean() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenBoolean_thenReturnInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenBoolean_thenThrowRuntimeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenFloat_thenThrowRuntimeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenInt_thenReturnInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenInt_thenReturnInt2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenInt_thenThrowRuntimeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenJd_thenReturnBoolean() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenJd_thenThrowRuntimeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenJd_thenThrowRuntimeException2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenUnknown_thenReturnBoolean() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenUnknown_thenReturnInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZi_thenReturnInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZi_thenReturnInt2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZi_thenReturnZi() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZif_thenReturnIf() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZif_thenReturnZi() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZif_thenReturnZif() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZifl_thenReturnIf() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZifl_thenReturnIf2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZil_thenReturnInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZil_thenReturnZi() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TypeClass TypeClass.merge(TypeClass, TypeClass)"})
  public void testMerge_whenZil_thenReturnZil() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.ZIL, TypeClass.merge(TypeClass.ZIL, TypeClass.ZIFL));
  }

  /**
   * Test {@link TypeClass#toString()}.
   *
   * <p>Method under test: {@link TypeClass#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeClass.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Z", TypeClass.valueOf("BOOLEAN").toString());
  }
}

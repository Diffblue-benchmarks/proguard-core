package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class TypeClassDiffblueTest {
  /**
   * Method under test: {@link TypeClass#clzOf(String)}
   */
  @Test
  public void testClzOf() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.UNKNOWN, TypeClass.clzOf("The characteristics of someone or something"));
    assertEquals(TypeClass.DOUBLE, TypeClass.clzOf("Desc"));
    assertEquals(TypeClass.INT, TypeClass.clzOf("BOOLEAN"));
    assertEquals(TypeClass.FLOAT, TypeClass.clzOf("F"));
    assertEquals(TypeClass.LONG, TypeClass.clzOf("J"));
    assertEquals(TypeClass.OBJECT, TypeClass.clzOf("L"));
    assertEquals(TypeClass.VOID, TypeClass.clzOf("V"));
  }

  /**
   * Method under test: {@link TypeClass#merge(TypeClass, TypeClass)}
   */
  @Test
  public void testMerge() {
    // Arrange, Act and Assert
    assertEquals(TypeClass.BOOLEAN, TypeClass.merge(TypeClass.BOOLEAN, TypeClass.BOOLEAN));
    assertEquals(TypeClass.BOOLEAN, TypeClass.merge(TypeClass.UNKNOWN, TypeClass.BOOLEAN));
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.INT, TypeClass.UNKNOWN));
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.INT, TypeClass.BOOLEAN));
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.INT, TypeClass.JD));
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.BOOLEAN, TypeClass.INT));
    assertEquals(TypeClass.BOOLEAN, TypeClass.merge(TypeClass.JD, TypeClass.BOOLEAN));
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.JD, TypeClass.IF));
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.FLOAT, TypeClass.BOOLEAN));
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.BOOLEAN, TypeClass.FLOAT));
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.INT, TypeClass.FLOAT));
    assertThrows(RuntimeException.class, () -> TypeClass.merge(TypeClass.IF, TypeClass.JD));
    assertEquals(TypeClass.IF, TypeClass.merge(TypeClass.IF, TypeClass.ZIFL));
    assertEquals(TypeClass.ZIF, TypeClass.merge(TypeClass.ZIF, TypeClass.ZIFL));
    assertEquals(TypeClass.ZI, TypeClass.merge(TypeClass.ZI, TypeClass.ZIFL));
    assertEquals(TypeClass.IF, TypeClass.merge(TypeClass.ZIF, TypeClass.IF));
    assertEquals(TypeClass.ZI, TypeClass.merge(TypeClass.ZIF, TypeClass.ZI));
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.ZI, TypeClass.IF));
    assertEquals(TypeClass.IF, TypeClass.merge(TypeClass.ZIFL, TypeClass.IF));
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.IF, TypeClass.ZI));
    assertEquals(TypeClass.ZIL, TypeClass.merge(TypeClass.ZIL, TypeClass.ZIFL));
    assertEquals(TypeClass.INT, TypeClass.merge(TypeClass.ZIL, TypeClass.IF));
    assertEquals(TypeClass.ZI, TypeClass.merge(TypeClass.ZIL, TypeClass.ZIF));
  }

  /**
   * Method under test: {@link TypeClass#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Z", TypeClass.valueOf("BOOLEAN").toString());
  }
}

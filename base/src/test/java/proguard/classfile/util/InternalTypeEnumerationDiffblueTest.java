package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class InternalTypeEnumerationDiffblueTest {
  /**
   * Method under test: {@link InternalTypeEnumeration#typeCount()}
   */
  @Test
  public void testTypeCount() {
    // Arrange, Act and Assert
    assertEquals(10, (new InternalTypeEnumeration("Descriptor")).typeCount());
  }

  /**
   * Method under test: {@link InternalTypeEnumeration#typesSize()}
   */
  @Test
  public void testTypesSize() {
    // Arrange, Act and Assert
    assertEquals(11, (new InternalTypeEnumeration("Descriptor")).typesSize());
  }

  /**
   * Method under test: {@link InternalTypeEnumeration#hasFormalTypeParameters()}
   */
  @Test
  public void testHasFormalTypeParameters() {
    // Arrange, Act and Assert
    assertFalse((new InternalTypeEnumeration("Descriptor")).hasFormalTypeParameters());
  }

  /**
   * Method under test: {@link InternalTypeEnumeration#formalTypeParameters()}
   */
  @Test
  public void testFormalTypeParameters() {
    // Arrange, Act and Assert
    assertEquals("", (new InternalTypeEnumeration("Descriptor")).formalTypeParameters());
  }

  /**
   * Method under test: {@link InternalTypeEnumeration#isMethodSignature()}
   */
  @Test
  public void testIsMethodSignature() {
    // Arrange, Act and Assert
    assertFalse((new InternalTypeEnumeration("Descriptor")).isMethodSignature());
  }

  /**
   * Method under test: {@link InternalTypeEnumeration#hasMoreTypes()}
   */
  @Test
  public void testHasMoreTypes() {
    // Arrange, Act and Assert
    assertTrue((new InternalTypeEnumeration("Descriptor")).hasMoreTypes());
  }

  /**
   * Method under test: {@link InternalTypeEnumeration#hasNext()}
   */
  @Test
  public void testHasNext() {
    // Arrange, Act and Assert
    assertTrue((new InternalTypeEnumeration("Descriptor")).hasNext());
  }

  /**
   * Method under test:
   * {@link InternalTypeEnumeration#InternalTypeEnumeration(String)}
   */
  @Test
  public void testNewInternalTypeEnumeration() {
    // Arrange and Act
    InternalTypeEnumeration actualInternalTypeEnumeration = new InternalTypeEnumeration("Descriptor");

    // Assert
    String actualNextResult = actualInternalTypeEnumeration.next();
    String actualNextResult2 = actualInternalTypeEnumeration.next();
    String actualNextResult3 = actualInternalTypeEnumeration.next();
    String actualNextResult4 = actualInternalTypeEnumeration.next();
    String actualNextResult5 = actualInternalTypeEnumeration.next();
    String actualNextResult6 = actualInternalTypeEnumeration.next();
    String actualNextResult7 = actualInternalTypeEnumeration.next();
    String actualNextResult8 = actualInternalTypeEnumeration.next();
    String actualNextResult9 = actualInternalTypeEnumeration.next();
    assertEquals("D", actualNextResult);
    assertEquals("c", actualNextResult4);
    assertEquals("e", actualNextResult2);
    assertEquals("i", actualNextResult6);
    assertEquals("o", actualNextResult9);
    assertEquals("p", actualNextResult7);
    assertEquals("r", actualNextResult5);
    assertEquals("r", actualInternalTypeEnumeration.next());
    assertEquals("s", actualNextResult3);
    assertEquals("t", actualNextResult8);
    assertFalse(actualInternalTypeEnumeration.hasNext());
  }
}

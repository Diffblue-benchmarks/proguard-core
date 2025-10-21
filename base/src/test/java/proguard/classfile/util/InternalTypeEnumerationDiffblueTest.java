package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InternalTypeEnumerationDiffblueTest {
  /**
   * Test {@link InternalTypeEnumeration#InternalTypeEnumeration(String)}.
   *
   * <ul>
   *   <li>When {@code Descriptor}.
   *   <li>Then return next is {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTypeEnumeration#InternalTypeEnumeration(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InternalTypeEnumeration.<init>(String)"})
  public void testNewInternalTypeEnumeration_whenDescriptor_thenReturnNextIsD() {
    // Arrange and Act
    InternalTypeEnumeration actualInternalTypeEnumeration =
        new InternalTypeEnumeration("Descriptor");

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

  /**
   * Test {@link InternalTypeEnumeration#typeCount()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#typeCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InternalTypeEnumeration.typeCount()"})
  public void testTypeCount() {
    // Arrange, Act and Assert
    assertEquals(10, (new InternalTypeEnumeration("Descriptor")).typeCount());
  }

  /**
   * Test {@link InternalTypeEnumeration#typesSize()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#typesSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InternalTypeEnumeration.typesSize()"})
  public void testTypesSize() {
    // Arrange, Act and Assert
    assertEquals(11, (new InternalTypeEnumeration("Descriptor")).typesSize());
  }

  /**
   * Test {@link InternalTypeEnumeration#hasFormalTypeParameters()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasFormalTypeParameters()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InternalTypeEnumeration.hasFormalTypeParameters()"})
  public void testHasFormalTypeParameters() {
    // Arrange, Act and Assert
    assertFalse((new InternalTypeEnumeration("Descriptor")).hasFormalTypeParameters());
  }

  /**
   * Test {@link InternalTypeEnumeration#formalTypeParameters()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#formalTypeParameters()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InternalTypeEnumeration.formalTypeParameters()"})
  public void testFormalTypeParameters() {
    // Arrange, Act and Assert
    assertEquals("", (new InternalTypeEnumeration("Descriptor")).formalTypeParameters());
  }

  /**
   * Test {@link InternalTypeEnumeration#isMethodSignature()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#isMethodSignature()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InternalTypeEnumeration.isMethodSignature()"})
  public void testIsMethodSignature() {
    // Arrange, Act and Assert
    assertFalse((new InternalTypeEnumeration("Descriptor")).isMethodSignature());
  }

  /**
   * Test {@link InternalTypeEnumeration#hasMoreTypes()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasMoreTypes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InternalTypeEnumeration.hasMoreTypes()"})
  public void testHasMoreTypes() {
    // Arrange, Act and Assert
    assertTrue((new InternalTypeEnumeration("Descriptor")).hasMoreTypes());
  }

  /**
   * Test {@link InternalTypeEnumeration#hasNext()}.
   *
   * <p>Method under test: {@link InternalTypeEnumeration#hasNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InternalTypeEnumeration.hasNext()"})
  public void testHasNext() {
    // Arrange, Act and Assert
    assertTrue((new InternalTypeEnumeration("Descriptor")).hasNext());
  }
}

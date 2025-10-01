package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InternalTypeIterableDiffblueTest {
  /**
   * Test {@link InternalTypeIterable#InternalTypeIterable(String)}.
   *
   * <ul>
   *   <li>Then iterator return {@link InternalTypeEnumeration}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTypeIterable#InternalTypeIterable(String)}
   */
  @Test
  @DisplayName(
      "Test new InternalTypeIterable(String); then iterator return InternalTypeEnumeration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InternalTypeIterable.<init>(String)"})
  void testNewInternalTypeIterable_thenIteratorReturnInternalTypeEnumeration() {
    // Arrange and Act
    Iterator<String> actualIteratorResult = new InternalTypeIterable("Descriptor").iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof InternalTypeEnumeration);
    String actualNextResult = actualIteratorResult.next();
    String actualNextResult2 = actualIteratorResult.next();
    String actualNextResult3 = actualIteratorResult.next();
    String actualNextResult4 = actualIteratorResult.next();
    String actualNextResult5 = actualIteratorResult.next();
    String actualNextResult6 = actualIteratorResult.next();
    String actualNextResult7 = actualIteratorResult.next();
    String actualNextResult8 = actualIteratorResult.next();
    String actualNextResult9 = actualIteratorResult.next();
    String actualNextResult10 = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertEquals("D", actualNextResult);
    assertEquals("e", actualNextResult2);
    assertEquals("s", actualNextResult3);
    assertEquals("c", actualNextResult4);
    assertEquals("r", actualNextResult5);
    assertEquals("i", actualNextResult6);
    assertEquals("p", actualNextResult7);
    assertEquals("t", actualNextResult8);
    assertEquals("o", actualNextResult9);
    assertEquals("r", actualNextResult10);
  }

  /**
   * Test {@link InternalTypeIterable#iterator()}.
   *
   * <p>Method under test: {@link InternalTypeIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator InternalTypeIterable.iterator()"})
  void testIterator() {
    // Arrange and Act
    Iterator<String> actualIteratorResult = new InternalTypeIterable("Descriptor").iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof InternalTypeEnumeration);
    String actualNextResult = actualIteratorResult.next();
    String actualNextResult2 = actualIteratorResult.next();
    String actualNextResult3 = actualIteratorResult.next();
    String actualNextResult4 = actualIteratorResult.next();
    String actualNextResult5 = actualIteratorResult.next();
    String actualNextResult6 = actualIteratorResult.next();
    String actualNextResult7 = actualIteratorResult.next();
    String actualNextResult8 = actualIteratorResult.next();
    String actualNextResult9 = actualIteratorResult.next();
    String actualNextResult10 = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertEquals("D", actualNextResult);
    assertEquals("e", actualNextResult2);
    assertEquals("s", actualNextResult3);
    assertEquals("c", actualNextResult4);
    assertEquals("r", actualNextResult5);
    assertEquals("i", actualNextResult6);
    assertEquals("p", actualNextResult7);
    assertEquals("t", actualNextResult8);
    assertEquals("o", actualNextResult9);
    assertEquals("r", actualNextResult10);
  }
}

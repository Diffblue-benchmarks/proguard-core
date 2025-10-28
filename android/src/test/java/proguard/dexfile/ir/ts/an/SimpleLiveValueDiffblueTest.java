package proguard.dexfile.ir.ts.an;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SimpleLiveValueDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link SimpleLiveValue}
   */
  @Test
  public void testNewSimpleLiveValue() {
    // Arrange and Act
    SimpleLiveValue actualSimpleLiveValue = new SimpleLiveValue();

    // Assert
    assertEquals('.', actualSimpleLiveValue.toRsp());
    assertNull(actualSimpleLiveValue.otherParents);
    assertNull(actualSimpleLiveValue.parent);
    assertFalse(actualSimpleLiveValue.used);
  }

  /**
   * Method under test: {@link SimpleLiveValue#toRsp()}
   */
  @Test
  public void testToRsp() {
    // Arrange, Act and Assert
    assertEquals('.', (new SimpleLiveValue()).toRsp());
  }

  /**
   * Method under test: {@link SimpleLiveValue#toRsp()}
   */
  @Test
  public void testToRsp2() {
    // Arrange
    SimpleLiveValue simpleLiveValue = new SimpleLiveValue();
    simpleLiveValue.used = true;

    // Act and Assert
    assertEquals('x', simpleLiveValue.toRsp());
  }
}

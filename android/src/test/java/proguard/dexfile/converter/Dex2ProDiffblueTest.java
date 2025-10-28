package proguard.dexfile.converter;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class Dex2ProDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Dex2Pro#Dex2Pro()}
   *   <li>{@link Dex2Pro#usePrimitiveArrayConstants(boolean)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Dex2Pro actualDex2Pro = new Dex2Pro();

    // Assert
    assertSame(actualDex2Pro, actualDex2Pro.usePrimitiveArrayConstants(true));
  }

  /**
   * Method under test: {@link Dex2Pro#shutdown(int)}
   */
  @Test
  public void testShutdown() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Dex2Pro(1)).shutdown(10));
  }

  /**
   * Method under test: {@link Dex2Pro#Dex2Pro(int)}
   */
  @Test
  public void testNewDex2Pro() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Dex2Pro(0));
  }
}

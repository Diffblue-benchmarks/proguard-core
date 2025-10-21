package proguard.dexfile.converter;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Dex2ProDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dex2Pro#Dex2Pro()}
   *   <li>{@link Dex2Pro#usePrimitiveArrayConstants(boolean)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Dex2Pro.<init>()",
    "Dex2Pro Dex2Pro.usePrimitiveArrayConstants(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Dex2Pro actualDex2Pro = new Dex2Pro();

    // Assert
    assertSame(actualDex2Pro, actualDex2Pro.usePrimitiveArrayConstants(true));
  }

  /**
   * Test {@link Dex2Pro#Dex2Pro(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#Dex2Pro(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Dex2Pro.<init>(int)"})
  public void testNewDex2Pro_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Dex2Pro(0));
  }

  /**
   * Test {@link Dex2Pro#shutdown(int)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#shutdown(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Dex2Pro.shutdown(int)"})
  public void testShutdown_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Dex2Pro(1)).shutdown(10));
  }
}

package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.testutils.cpa.NamedClass;

public class NestHostFinderDiffblueTest {
  /**
   * Method under test: {@link NestHostFinder#inSameNest(Clazz, Clazz)}
   */
  @Test
  public void testInSameNest() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();
    LibraryClass class1 = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertFalse(nestHostFinder.inSameNest(class1, new LibraryClass()));
  }

  /**
   * Method under test: {@link NestHostFinder#inSameNest(Clazz, Clazz)}
   */
  @Test
  public void testInSameNest2() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();
    NamedClass class1 = new NamedClass("Member Name");

    // Act and Assert
    assertFalse(nestHostFinder.inSameNest(class1, new LibraryClass()));
  }

  /**
   * Method under test: {@link NestHostFinder#inSameNest(Clazz, Clazz)}
   */
  @Test
  public void testInSameNest3() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();
    LibraryClass class1 = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertTrue(nestHostFinder.inSameNest(class1, new LibraryClass(1, "This Class Name", "Super Class Name")));
  }

  /**
   * Method under test: {@link NestHostFinder#findNestHostClassName(Clazz)}
   */
  @Test
  public void testFindNestHostClassName() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();

    // Act and Assert
    assertNull(nestHostFinder.findNestHostClassName(new LibraryClass()));
  }

  /**
   * Method under test: {@link NestHostFinder#findNestHostClassName(Clazz)}
   */
  @Test
  public void testFindNestHostClassName2() {
    // Arrange
    NestHostFinder nestHostFinder = new NestHostFinder();

    // Act and Assert
    assertEquals("Member Name", nestHostFinder.findNestHostClassName(new NamedClass("Member Name")));
  }
}

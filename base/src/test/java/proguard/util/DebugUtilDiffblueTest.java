package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.MethodSignature;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.testutils.cpa.NamedClass;

public class DebugUtilDiffblueTest {
  /**
   * Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature)}
   */
  @Test
  public void testAsString() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> DebugUtil.asString(new JvmCfa(), ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertThrows(IllegalStateException.class,
        () -> DebugUtil.asString(new JvmCfa(), ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true));
    assertThrows(IllegalStateException.class, () -> DebugUtil.asString(KotlinConstants.dummyClassPool, "Class Name"));
    assertEquals(
        "_____________________________________________________________________\n" + "- Library class: clazz\n"
            + "  Superclass:    clazz\n" + "  Access flags:  0x1\n" + "    = public class clazz extends clazz\n" + "\n"
            + "Interfaces (count = 0):\n" + "Fields (count = 0):\n" + "Methods (count = 0):\n",
        DebugUtil.asString(new LibraryClass(1, "clazz", "clazz")));
  }

  /**
   * Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature)}
   */
  @Test
  public void testAsString2() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    cfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new LibraryClass());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> DebugUtil.asString(cfa, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Method under test: {@link DebugUtil#asString(JvmCfa, MethodSignature)}
   */
  @Test
  public void testAsString3() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    cfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new NamedClass("cfa"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> DebugUtil.asString(cfa, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Method under test:
   * {@link DebugUtil#asString(JvmCfa, MethodSignature, boolean)}
   */
  @Test
  public void testAsString4() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    cfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new LibraryClass());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> DebugUtil.asString(cfa, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true));
  }

  /**
   * Method under test:
   * {@link DebugUtil#asString(JvmCfa, MethodSignature, boolean)}
   */
  @Test
  public void testAsString5() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    cfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new NamedClass("cfa"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> DebugUtil.asString(cfa, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true));
  }

  /**
   * Method under test: {@link DebugUtil#asString(Clazz, Method)}
   */
  @Test
  public void testAsString6() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("", DebugUtil.asString(clazz, new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link DebugUtil#asString(Clazz, Method, boolean)}
   */
  @Test
  public void testAsString7() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("", DebugUtil.asString(clazz, new LibraryMethod(1, "Name", "Descriptor"), false));
  }

  /**
   * Method under test: {@link DebugUtil#getMethodFqnList(ClassPool, String)}
   */
  @Test
  public void testGetMethodFqnList() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> DebugUtil.getMethodFqnList(KotlinConstants.dummyClassPool, "Class Name"));
  }
}

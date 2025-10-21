package proguard.backport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.testutils.cpa.NamedClass;

public class LambdaExpressionDiffblueTest {
  /**
   * Test {@link LambdaExpression#LambdaExpression(ProgramClass, int, BootstrapMethodInfo, String,
   * String[], String[], String, String, int, String, String, String, Clazz, Method, int)}.
   *
   * <p>Method under test: {@link LambdaExpression#LambdaExpression(ProgramClass, int,
   * BootstrapMethodInfo, String, String[], String[], String, String, int, String, String, String,
   * Clazz, Method, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LambdaExpression.<init>(ProgramClass, int, BootstrapMethodInfo, String, String[], String[], String, String, int, String, String, String, Clazz, Method, int)"
  })
  public void testNewLambdaExpression() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act
    LambdaExpression actualLambdaExpression =
        new LambdaExpression(
            referencedClass,
            1,
            bootstrapMethodInfo,
            "Factory Method Descriptor",
            new String[] {"Interfaces"},
            new String[] {"Bridge Method Descriptors"},
            "Interface Method",
            "Interface Method Descriptor",
            1,
            "Invoked Class Name",
            "Invoked Method Name",
            "Invoked Method Desc",
            referencedInvokedClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);

    // Assert
    BootstrapMethodInfo bootstrapMethodInfo2 = actualLambdaExpression.bootstrapMethodInfo;
    assertNull(bootstrapMethodInfo2.getProcessingInfo());
    ProgramClass programClass = actualLambdaExpression.referencedClass;
    assertNull(programClass.getProcessingInfo());
    assertNull(programClass.getSuperName());
    assertNull(programClass.getFeatureName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.getAccessFlags());
    assertEquals(0, programClass.getInterfaceCount());
    assertEquals(0, bootstrapMethodInfo2.getProcessingFlags());
    assertEquals(0, programClass.getProcessingFlags());
    assertTrue(programClass.getExtraFeatureNames().isEmpty());
  }

  /**
   * Test {@link LambdaExpression#getLambdaClassName()}.
   *
   * <ul>
   *   <li>Then return {@code %s$$Lambda$%d$$Lambda$1}.
   * </ul>
   *
   * <p>Method under test: {@link LambdaExpression#getLambdaClassName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LambdaExpression.getLambdaClassName()"})
  public void testGetLambdaClassName_thenReturnSLambdaDLambda1() {
    // Arrange
    NamedClass referencedClass = new NamedClass("%s$$Lambda$%d");
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        "%s$$Lambda$%d$$Lambda$1",
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .getLambdaClassName());
  }

  /**
   * Test {@link LambdaExpression#isSerializable()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LambdaExpression#isSerializable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.isSerializable()"})
  public void testIsSerializable_thenReturnFalse() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertFalse(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .isSerializable());
  }

  /**
   * Test {@link LambdaExpression#isSerializable()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LambdaExpression#isSerializable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.isSerializable()"})
  public void testIsSerializable_thenReturnTrue() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertTrue(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"java/io/Serializable"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .isSerializable());
  }

  /**
   * Test {@link LambdaExpression#isMethodReference()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LambdaExpression#isMethodReference()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.isMethodReference()"})
  public void testIsMethodReference_thenReturnFalse() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();
    LambdaExpression lambdaExpression =
        new LambdaExpression(
            referencedClass,
            1,
            bootstrapMethodInfo,
            "Factory Method Descriptor",
            new String[] {"Interfaces"},
            new String[] {"Bridge Method Descriptors"},
            "Interface Method",
            "Interface Method Descriptor",
            1,
            "Invoked Class Name",
            "Invoked Method Name",
            "Invoked Method Desc",
            referencedInvokedClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);
    lambdaExpression.invokedMethodName = "lambda$";

    // Act and Assert
    assertFalse(lambdaExpression.isMethodReference());
  }

  /**
   * Test {@link LambdaExpression#isMethodReference()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LambdaExpression#isMethodReference()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.isMethodReference()"})
  public void testIsMethodReference_thenReturnTrue() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertTrue(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .isMethodReference());
  }

  /**
   * Test {@link LambdaExpression#invokesStaticInterfaceMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#invokesStaticInterfaceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.invokesStaticInterfaceMethod()"})
  public void testInvokesStaticInterfaceMethod() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertFalse(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .invokesStaticInterfaceMethod());
  }

  /**
   * Test {@link LambdaExpression#invokesStaticInterfaceMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#invokesStaticInterfaceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.invokesStaticInterfaceMethod()"})
  public void testInvokesStaticInterfaceMethod2() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();
    LambdaExpression lambdaExpression =
        new LambdaExpression(
            referencedClass,
            1,
            bootstrapMethodInfo,
            "Factory Method Descriptor",
            new String[] {"Interfaces"},
            new String[] {"Bridge Method Descriptors"},
            "Interface Method",
            "Interface Method Descriptor",
            1,
            "Invoked Class Name",
            "Invoked Method Name",
            "Invoked Method Desc",
            referencedInvokedClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);
    lambdaExpression.invokedReferenceKind = 6;
    lambdaExpression.referencedInvokedClass = null;

    // Act and Assert
    assertFalse(lambdaExpression.invokesStaticInterfaceMethod());
  }

  /**
   * Test {@link LambdaExpression#invokesStaticInterfaceMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#invokesStaticInterfaceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.invokesStaticInterfaceMethod()"})
  public void testInvokesStaticInterfaceMethod3() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();
    LambdaExpression lambdaExpression =
        new LambdaExpression(
            referencedClass,
            1,
            bootstrapMethodInfo,
            "Factory Method Descriptor",
            new String[] {"Interfaces"},
            new String[] {"Bridge Method Descriptors"},
            "Interface Method",
            "Interface Method Descriptor",
            1,
            "Invoked Class Name",
            "Invoked Method Name",
            "Invoked Method Desc",
            referencedInvokedClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);
    lambdaExpression.invokedReferenceKind = 6;
    lambdaExpression.referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertFalse(lambdaExpression.invokesStaticInterfaceMethod());
  }

  /**
   * Test {@link LambdaExpression#referencesPrivateSyntheticInterfaceMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#referencesPrivateSyntheticInterfaceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.referencesPrivateSyntheticInterfaceMethod()"})
  public void testReferencesPrivateSyntheticInterfaceMethod() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertFalse(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .referencesPrivateSyntheticInterfaceMethod());
  }

  /**
   * Test {@link LambdaExpression#referencesPrivateSyntheticInterfaceMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#referencesPrivateSyntheticInterfaceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.referencesPrivateSyntheticInterfaceMethod()"})
  public void testReferencesPrivateSyntheticInterfaceMethod2() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();
    LambdaExpression lambdaExpression =
        new LambdaExpression(
            referencedClass,
            1,
            bootstrapMethodInfo,
            "Factory Method Descriptor",
            new String[] {"Interfaces"},
            new String[] {"Bridge Method Descriptors"},
            "Interface Method",
            "Interface Method Descriptor",
            1,
            "Invoked Class Name",
            "Invoked Method Name",
            "Invoked Method Desc",
            referencedInvokedClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);
    lambdaExpression.referencedInvokedClass = null;

    // Act and Assert
    assertFalse(lambdaExpression.referencesPrivateSyntheticInterfaceMethod());
  }

  /**
   * Test {@link LambdaExpression#referencesPrivateSyntheticInterfaceMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#referencesPrivateSyntheticInterfaceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.referencesPrivateSyntheticInterfaceMethod()"})
  public void testReferencesPrivateSyntheticInterfaceMethod3() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass =
        new LibraryClass(512, "This Class Name", "Super Class Name");

    // Act and Assert
    assertFalse(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .referencesPrivateSyntheticInterfaceMethod());
  }

  /**
   * Test {@link LambdaExpression#needsAccessorMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#needsAccessorMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.needsAccessorMethod()"})
  public void testNeedsAccessorMethod() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass =
        new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertTrue(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .needsAccessorMethod());
  }

  /**
   * Test {@link LambdaExpression#needsAccessorMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#needsAccessorMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.needsAccessorMethod()"})
  public void testNeedsAccessorMethod2() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass =
        new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertTrue(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                null,
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .needsAccessorMethod());
  }

  /**
   * Test {@link LambdaExpression#needsAccessorMethod()}.
   *
   * <p>Method under test: {@link LambdaExpression#needsAccessorMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.needsAccessorMethod()"})
  public void testNeedsAccessorMethod3() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass =
        new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertTrue(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                null,
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .needsAccessorMethod());
  }

  /**
   * Test {@link LambdaExpression#needsAccessorMethod()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LambdaExpression#needsAccessorMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.needsAccessorMethod()"})
  public void testNeedsAccessorMethod_thenReturnFalse() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();

    // Act and Assert
    assertFalse(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                null,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .needsAccessorMethod());
  }

  /**
   * Test {@link LambdaExpression#referencesPrivateConstructor()}.
   *
   * <p>Method under test: {@link LambdaExpression#referencesPrivateConstructor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.referencesPrivateConstructor()"})
  public void testReferencesPrivateConstructor() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertFalse(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                1,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .referencesPrivateConstructor());
  }

  /**
   * Test {@link LambdaExpression#referencesPrivateConstructor()}.
   *
   * <p>Method under test: {@link LambdaExpression#referencesPrivateConstructor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.referencesPrivateConstructor()"})
  public void testReferencesPrivateConstructor2() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();
    LambdaExpression lambdaExpression =
        new LambdaExpression(
            referencedClass,
            1,
            bootstrapMethodInfo,
            "Factory Method Descriptor",
            new String[] {"Interfaces"},
            new String[] {"Bridge Method Descriptors"},
            "Interface Method",
            "Interface Method Descriptor",
            1,
            "Invoked Class Name",
            "Invoked Method Name",
            "Invoked Method Desc",
            referencedInvokedClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);
    lambdaExpression.invokedReferenceKind = 8;
    lambdaExpression.invokedMethodName = "<init>";

    // Act and Assert
    assertFalse(lambdaExpression.referencesPrivateConstructor());
  }

  /**
   * Test {@link LambdaExpression#referencesPrivateConstructor()}.
   *
   * <p>Method under test: {@link LambdaExpression#referencesPrivateConstructor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LambdaExpression.referencesPrivateConstructor()"})
  public void testReferencesPrivateConstructor3() {
    // Arrange
    ProgramClass referencedClass = new ProgramClass();
    BootstrapMethodInfo bootstrapMethodInfo = new BootstrapMethodInfo();
    LibraryClass referencedInvokedClass = new LibraryClass();

    // Act and Assert
    assertFalse(
        (new LambdaExpression(
                referencedClass,
                1,
                bootstrapMethodInfo,
                "Factory Method Descriptor",
                new String[] {"Interfaces"},
                new String[] {"Bridge Method Descriptors"},
                "Interface Method",
                "Interface Method Descriptor",
                8,
                "Invoked Class Name",
                "Invoked Method Name",
                "Invoked Method Desc",
                referencedInvokedClass,
                new LibraryMethod(1, "Name", "Descriptor"),
                1))
            .referencesPrivateConstructor());
  }
}

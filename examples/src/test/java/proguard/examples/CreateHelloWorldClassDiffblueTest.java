package proguard.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;

public class CreateHelloWorldClassDiffblueTest {
  /**
   * Test {@link CreateHelloWorldClass#createMessagePrintingClass(String, String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Object}.
   *   <li>Then return Name is {@code java/lang/Object}.
   * </ul>
   *
   * <p>Method under test: {@link CreateHelloWorldClass#createMessagePrintingClass(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProgramClass CreateHelloWorldClass.createMessagePrintingClass(String, String)"
  })
  public void testCreateMessagePrintingClass_whenJavaLangObject_thenReturnNameIsJavaLangObject() {
    // Arrange and Act
    ProgramClass actualCreateMessagePrintingClassResult =
        CreateHelloWorldClass.createMessagePrintingClass(
            "java/lang/Object", "Not all who wander are lost");

    // Assert
    assertEquals("java/lang/Object", actualCreateMessagePrintingClassResult.getName());
    assertEquals(2, actualCreateMessagePrintingClassResult.u2superClass);
    assertEquals(20, actualCreateMessagePrintingClassResult.u2constantPoolCount);
    Clazz actualSuperClass = actualCreateMessagePrintingClassResult.getSuperClass();
    assertSame(actualCreateMessagePrintingClassResult, actualSuperClass);
  }

  /**
   * Test {@link CreateHelloWorldClass#createMessagePrintingClass(String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CreateHelloWorldClass#createMessagePrintingClass(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProgramClass CreateHelloWorldClass.createMessagePrintingClass(String, String)"
  })
  public void testCreateMessagePrintingClass_whenName_thenReturnName() {
    // Arrange and Act
    ProgramClass actualCreateMessagePrintingClassResult =
        CreateHelloWorldClass.createMessagePrintingClass("Name", "Not all who wander are lost");

    // Assert
    assertEquals("Name", actualCreateMessagePrintingClassResult.getName());
    assertNull(actualCreateMessagePrintingClassResult.getSuperClass());
    assertEquals(22, actualCreateMessagePrintingClassResult.u2constantPoolCount);
    assertEquals(4, actualCreateMessagePrintingClassResult.u2superClass);
  }
}

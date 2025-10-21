package proguard.classfile.util.inject.location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.util.inject.location.InjectStrategy.InjectLocation;
import proguard.testutils.cpa.NamedMember;

public class FirstBlockDiffblueTest {
  /**
   * Test {@link FirstBlock#getSingleInjectionLocation(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then return Offset is zero.
   * </ul>
   *
   * <p>Method under test: {@link FirstBlock#getSingleInjectionLocation(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InjectLocation FirstBlock.getSingleInjectionLocation(ProgramClass, ProgramMethod)"
  })
  public void testGetSingleInjectionLocation_thenReturnOffsetIsZero() {
    // Arrange
    FirstBlock firstBlock = new FirstBlock();
    ProgramClass targetClass = new ProgramClass();

    // Act
    InjectLocation actualSingleInjectionLocation =
        firstBlock.getSingleInjectionLocation(
            targetClass, new NamedMember("Member Name", "Descriptor"));

    // Assert
    assertEquals(0, actualSingleInjectionLocation.getOffset());
    assertTrue(actualSingleInjectionLocation.shouldInjectBefore());
  }

  /**
   * Test {@link FirstBlock#getAllSuitableInjectionLocation(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then return first element Offset is zero.
   * </ul>
   *
   * <p>Method under test: {@link FirstBlock#getAllSuitableInjectionLocation(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InjectLocation[] FirstBlock.getAllSuitableInjectionLocation(ProgramClass, ProgramMethod)"
  })
  public void testGetAllSuitableInjectionLocation_thenReturnFirstElementOffsetIsZero() {
    // Arrange
    FirstBlock firstBlock = new FirstBlock();
    ProgramClass targetClass = new ProgramClass();

    // Act
    InjectLocation[] actualAllSuitableInjectionLocation =
        firstBlock.getAllSuitableInjectionLocation(
            targetClass, new NamedMember("Member Name", "Descriptor"));

    // Assert
    InjectLocation injectLocation = actualAllSuitableInjectionLocation[0];
    assertEquals(0, injectLocation.getOffset());
    assertEquals(1, actualAllSuitableInjectionLocation.length);
    assertTrue(injectLocation.shouldInjectBefore());
  }
}

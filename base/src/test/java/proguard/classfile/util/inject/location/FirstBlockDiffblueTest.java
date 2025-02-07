package proguard.classfile.util.inject.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.util.inject.location.InjectStrategy.InjectLocation;
import proguard.testutils.cpa.NamedMember;

class FirstBlockDiffblueTest {
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
  @DisplayName(
      "Test getSingleInjectionLocation(ProgramClass, ProgramMethod); then return Offset is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.util.inject.location.InjectStrategy$InjectLocation proguard.classfile.util.inject.location.FirstBlock.getSingleInjectionLocation(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testGetSingleInjectionLocation_thenReturnOffsetIsZero() {
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
  @DisplayName(
      "Test getAllSuitableInjectionLocation(ProgramClass, ProgramMethod); then return first element Offset is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.util.inject.location.InjectStrategy$InjectLocation[] proguard.classfile.util.inject.location.FirstBlock.getAllSuitableInjectionLocation(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testGetAllSuitableInjectionLocation_thenReturnFirstElementOffsetIsZero() {
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

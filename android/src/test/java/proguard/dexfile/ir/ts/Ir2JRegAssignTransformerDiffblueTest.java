package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ts.Ir2JRegAssignTransformer.Reg;

class Ir2JRegAssignTransformerDiffblueTest {
  /**
   * Test {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Reg[])}.
   *
   * <ul>
   *   <li>Given {@link Reg} (default constructor) {@link Reg#type} is start of heading.
   *   <li>Then return {@code A} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Reg[])}
   */
  @Test
  @DisplayName(
      "Test groupAndCleanUpByType(Reg[]); given Reg (default constructor) type is start of heading; then return 'A' size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.dexfile.ir.ts.Ir2JRegAssignTransformer.groupAndCleanUpByType(proguard.dexfile.ir.ts.Ir2JRegAssignTransformer$Reg[])"
  })
  void testGroupAndCleanUpByType_givenRegTypeIsStartOfHeading_thenReturnASizeIsOne() {
    // Arrange
    Ir2JRegAssignTransformer ir2JRegAssignTransformer = new Ir2JRegAssignTransformer();
    Reg reg = new Reg();
    reg.excludes = new HashSet<>();
    reg.prefers = new HashSet<>();
    reg.type = '\u0001';

    HashSet<Reg> regSet = new HashSet<>();
    regSet.add(reg);
    Reg reg2 = new Reg();
    reg2.excludes = regSet;
    reg2.prefers = new HashSet<>();
    reg2.type = 'A';

    // Act
    Map<Character, List<Reg>> actualGroupAndCleanUpByTypeResult =
        ir2JRegAssignTransformer.groupAndCleanUpByType(new Reg[] {reg2});

    // Assert
    assertEquals(1, actualGroupAndCleanUpByTypeResult.size());
    List<Reg> getResult = actualGroupAndCleanUpByTypeResult.get('A');
    assertEquals(1, getResult.size());
    assertSame(reg2, getResult.get(0));
  }

  /**
   * Test {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Reg[])}.
   *
   * <ul>
   *   <li>Given {@link Reg} (default constructor) {@link Reg#type} is start of heading.
   *   <li>Then return {@code A} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Reg[])}
   */
  @Test
  @DisplayName(
      "Test groupAndCleanUpByType(Reg[]); given Reg (default constructor) type is start of heading; then return 'A' size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.dexfile.ir.ts.Ir2JRegAssignTransformer.groupAndCleanUpByType(proguard.dexfile.ir.ts.Ir2JRegAssignTransformer$Reg[])"
  })
  void testGroupAndCleanUpByType_givenRegTypeIsStartOfHeading_thenReturnASizeIsOne2() {
    // Arrange
    Ir2JRegAssignTransformer ir2JRegAssignTransformer = new Ir2JRegAssignTransformer();
    Reg reg = new Reg();
    reg.excludes = new HashSet<>();
    reg.prefers = new HashSet<>();
    reg.type = '\u0001';

    HashSet<Reg> regSet = new HashSet<>();
    regSet.add(reg);
    Reg reg2 = new Reg();
    reg2.excludes = new HashSet<>();
    reg2.prefers = regSet;
    reg2.type = 'A';

    // Act
    Map<Character, List<Reg>> actualGroupAndCleanUpByTypeResult =
        ir2JRegAssignTransformer.groupAndCleanUpByType(new Reg[] {reg2});

    // Assert
    assertEquals(1, actualGroupAndCleanUpByTypeResult.size());
    List<Reg> getResult = actualGroupAndCleanUpByTypeResult.get('A');
    assertEquals(1, getResult.size());
    assertSame(reg2, getResult.get(0));
  }

  /**
   * Test {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Reg[])}.
   *
   * <ul>
   *   <li>When array of {@link Reg} with {@link Reg} (default constructor).
   *   <li>Then return {@code A} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Reg[])}
   */
  @Test
  @DisplayName(
      "Test groupAndCleanUpByType(Reg[]); when array of Reg with Reg (default constructor); then return 'A' size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.dexfile.ir.ts.Ir2JRegAssignTransformer.groupAndCleanUpByType(proguard.dexfile.ir.ts.Ir2JRegAssignTransformer$Reg[])"
  })
  void testGroupAndCleanUpByType_whenArrayOfRegWithReg_thenReturnASizeIsOne() {
    // Arrange
    Ir2JRegAssignTransformer ir2JRegAssignTransformer = new Ir2JRegAssignTransformer();
    Reg reg = new Reg();
    reg.excludes = new HashSet<>();
    reg.prefers = new HashSet<>();
    reg.type = 'A';

    // Act
    Map<Character, List<Reg>> actualGroupAndCleanUpByTypeResult =
        ir2JRegAssignTransformer.groupAndCleanUpByType(new Reg[] {reg});

    // Assert
    assertEquals(1, actualGroupAndCleanUpByTypeResult.size());
    List<Reg> getResult = actualGroupAndCleanUpByTypeResult.get('A');
    assertEquals(1, getResult.size());
    assertSame(reg, getResult.get(0));
  }

  /**
   * Test Reg new {@link Reg} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Reg}
   */
  @Test
  @DisplayName("Test Reg new Reg (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.ts.Ir2JRegAssignTransformer$Reg.<init>()"})
  void testRegNewReg() {
    // Arrange and Act
    Reg actualReg = new Reg();

    // Assert
    assertEquals('\u0000', actualReg.type);
    assertEquals(-1, actualReg.reg);
    assertTrue(actualReg.excludes.isEmpty());
    assertTrue(actualReg.prefers.isEmpty());
  }
}

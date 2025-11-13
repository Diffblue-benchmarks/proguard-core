package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
   *   <li>Given {@link Reg} (default constructor) {@link Reg#type} is {@code A}.
   *   <li>Then return {@code A} size is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Reg[])}
   */
  @Test
  @DisplayName(
      "Test groupAndCleanUpByType(Reg[]); given Reg (default constructor) type is 'A'; then return 'A' size is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Ir2JRegAssignTransformer.groupAndCleanUpByType(Reg[])"})
  void testGroupAndCleanUpByType_givenRegTypeIsA_thenReturnASizeIsEighteen() {
    // Arrange
    Ir2JRegAssignTransformer ir2JRegAssignTransformer = new Ir2JRegAssignTransformer();
    Reg reg = new Reg();
    reg.excludes = new HashSet<>();
    reg.prefers = new HashSet<>();
    reg.type = 'A';

    LinkedHashSet<Reg> regSet = new LinkedHashSet<>();
    regSet.add(reg);
    Reg reg2 = new Reg();
    reg2.excludes = new HashSet<>();
    reg2.prefers = new HashSet<>();
    reg2.type = 'A';

    LinkedHashSet<Reg> regSet2 = new LinkedHashSet<>();
    regSet2.add(reg2);
    Reg reg3 = new Reg();
    reg3.excludes = new HashSet<>();
    reg3.prefers = new HashSet<>();
    reg3.type = 'A';
    reg3.excludes = regSet;
    reg3.prefers = regSet2;
    Reg reg4 = new Reg();
    reg4.excludes = new HashSet<>();
    reg4.prefers = new HashSet<>();
    reg4.type = 'A';

    LinkedHashSet<Reg> regSet3 = new LinkedHashSet<>();
    regSet3.add(reg4);
    Reg reg5 = new Reg();
    reg5.excludes = new HashSet<>();
    reg5.prefers = new HashSet<>();
    reg5.type = 'A';

    LinkedHashSet<Reg> regSet4 = new LinkedHashSet<>();
    regSet4.add(reg5);
    Reg reg6 = new Reg();
    reg6.excludes = new HashSet<>();
    reg6.prefers = new HashSet<>();
    reg6.type = 'A';
    reg6.excludes = regSet3;
    reg6.prefers = regSet4;
    Reg reg7 = new Reg();
    reg7.excludes = new HashSet<>();
    reg7.prefers = new HashSet<>();
    reg7.type = 'A';

    LinkedHashSet<Reg> regSet5 = new LinkedHashSet<>();
    regSet5.add(reg7);
    Reg reg8 = new Reg();
    reg8.excludes = new HashSet<>();
    reg8.prefers = new HashSet<>();
    reg8.type = 'A';

    LinkedHashSet<Reg> regSet6 = new LinkedHashSet<>();
    regSet6.add(reg8);
    Reg reg9 = new Reg();
    reg9.excludes = new HashSet<>();
    reg9.prefers = new HashSet<>();
    reg9.type = 'A';
    reg9.excludes = regSet5;
    reg9.prefers = regSet6;
    Reg reg10 = new Reg();
    reg10.excludes = new HashSet<>();
    reg10.prefers = new HashSet<>();
    reg10.type = 'A';

    LinkedHashSet<Reg> regSet7 = new LinkedHashSet<>();
    regSet7.add(reg10);
    Reg reg11 = new Reg();
    reg11.excludes = new HashSet<>();
    reg11.prefers = new HashSet<>();
    reg11.type = 'A';

    LinkedHashSet<Reg> regSet8 = new LinkedHashSet<>();
    regSet8.add(reg11);
    Reg reg12 = new Reg();
    reg12.excludes = new HashSet<>();
    reg12.prefers = new HashSet<>();
    reg12.type = 'A';
    reg12.excludes = regSet7;
    reg12.prefers = regSet8;
    Reg reg13 = new Reg();
    reg13.excludes = new HashSet<>();
    reg13.prefers = new HashSet<>();
    reg13.type = 'A';

    LinkedHashSet<Reg> regSet9 = new LinkedHashSet<>();
    regSet9.add(reg13);
    Reg reg14 = new Reg();
    reg14.excludes = new HashSet<>();
    reg14.prefers = new HashSet<>();
    reg14.type = 'A';

    LinkedHashSet<Reg> regSet10 = new LinkedHashSet<>();
    regSet10.add(reg14);
    Reg reg15 = new Reg();
    reg15.excludes = new HashSet<>();
    reg15.prefers = new HashSet<>();
    reg15.type = 'A';
    reg15.excludes = regSet9;
    reg15.prefers = regSet10;
    Reg reg16 = new Reg();
    reg16.excludes = new HashSet<>();
    reg16.prefers = new HashSet<>();
    reg16.type = 'A';

    LinkedHashSet<Reg> regSet11 = new LinkedHashSet<>();
    regSet11.add(reg16);
    Reg reg17 = new Reg();
    reg17.excludes = new HashSet<>();
    reg17.prefers = new HashSet<>();
    reg17.type = 'A';

    LinkedHashSet<Reg> regSet12 = new LinkedHashSet<>();
    regSet12.add(reg17);
    Reg reg18 = new Reg();
    reg18.excludes = new HashSet<>();
    reg18.prefers = new HashSet<>();
    reg18.type = 'A';
    reg18.excludes = regSet11;
    reg18.prefers = regSet12;
    Reg reg19 = new Reg();
    reg19.excludes = new HashSet<>();
    reg19.prefers = new HashSet<>();
    reg19.type = 'A';

    LinkedHashSet<Reg> regSet13 = new LinkedHashSet<>();
    regSet13.add(reg19);
    Reg reg20 = new Reg();
    reg20.excludes = new HashSet<>();
    reg20.prefers = new HashSet<>();
    reg20.type = 'A';

    LinkedHashSet<Reg> regSet14 = new LinkedHashSet<>();
    regSet14.add(reg20);
    Reg reg21 = new Reg();
    reg21.excludes = new HashSet<>();
    reg21.prefers = new HashSet<>();
    reg21.type = 'A';
    reg21.excludes = regSet13;
    reg21.prefers = regSet14;
    Reg reg22 = new Reg();
    reg22.excludes = new HashSet<>();
    reg22.prefers = new HashSet<>();
    reg22.type = 'A';

    LinkedHashSet<Reg> regSet15 = new LinkedHashSet<>();
    regSet15.add(reg22);
    Reg reg23 = new Reg();
    reg23.excludes = new HashSet<>();
    reg23.prefers = new HashSet<>();
    reg23.type = 'A';

    LinkedHashSet<Reg> regSet16 = new LinkedHashSet<>();
    regSet16.add(reg23);
    Reg reg24 = new Reg();
    reg24.excludes = new HashSet<>();
    reg24.prefers = new HashSet<>();
    reg24.type = 'A';
    reg24.excludes = regSet15;
    reg24.prefers = regSet16;
    Reg reg25 = new Reg();
    reg25.excludes = new HashSet<>();
    reg25.prefers = new HashSet<>();
    reg25.type = 'A';

    LinkedHashSet<Reg> regSet17 = new LinkedHashSet<>();
    regSet17.add(reg25);
    Reg reg26 = new Reg();
    reg26.excludes = new HashSet<>();
    reg26.prefers = new HashSet<>();
    reg26.type = 'A';

    LinkedHashSet<Reg> regSet18 = new LinkedHashSet<>();
    regSet18.add(reg26);
    Reg reg27 = new Reg();
    reg27.excludes = new HashSet<>();
    reg27.prefers = new HashSet<>();
    reg27.type = 'A';
    reg27.excludes = regSet17;
    reg27.prefers = regSet18;
    Reg reg28 = new Reg();
    reg28.excludes = new HashSet<>();
    reg28.prefers = new HashSet<>();
    reg28.type = 'A';

    LinkedHashSet<Reg> regSet19 = new LinkedHashSet<>();
    regSet19.add(reg28);
    Reg reg29 = new Reg();
    reg29.excludes = new HashSet<>();
    reg29.prefers = new HashSet<>();
    reg29.type = 'A';

    LinkedHashSet<Reg> regSet20 = new LinkedHashSet<>();
    regSet20.add(reg29);
    Reg reg30 = new Reg();
    reg30.excludes = new HashSet<>();
    reg30.prefers = new HashSet<>();
    reg30.type = 'A';
    reg30.excludes = regSet19;
    reg30.prefers = regSet20;
    Reg reg31 = new Reg();
    reg31.excludes = new HashSet<>();
    reg31.prefers = new HashSet<>();
    reg31.type = 'A';

    LinkedHashSet<Reg> regSet21 = new LinkedHashSet<>();
    regSet21.add(reg31);
    Reg reg32 = new Reg();
    reg32.excludes = new HashSet<>();
    reg32.prefers = new HashSet<>();
    reg32.type = 'A';

    LinkedHashSet<Reg> regSet22 = new LinkedHashSet<>();
    regSet22.add(reg32);
    Reg reg33 = new Reg();
    reg33.excludes = new HashSet<>();
    reg33.prefers = new HashSet<>();
    reg33.type = 'A';
    reg33.excludes = regSet21;
    reg33.prefers = regSet22;
    Reg reg34 = new Reg();
    reg34.excludes = new HashSet<>();
    reg34.prefers = new HashSet<>();
    reg34.type = 'A';

    LinkedHashSet<Reg> regSet23 = new LinkedHashSet<>();
    regSet23.add(reg34);
    Reg reg35 = new Reg();
    reg35.excludes = new HashSet<>();
    reg35.prefers = new HashSet<>();
    reg35.type = 'A';

    LinkedHashSet<Reg> regSet24 = new LinkedHashSet<>();
    regSet24.add(reg35);
    Reg reg36 = new Reg();
    reg36.excludes = new HashSet<>();
    reg36.prefers = new HashSet<>();
    reg36.type = 'A';
    reg36.excludes = regSet23;
    reg36.prefers = regSet24;
    Reg reg37 = new Reg();
    reg37.excludes = new HashSet<>();
    reg37.prefers = new HashSet<>();
    reg37.type = 'A';

    LinkedHashSet<Reg> regSet25 = new LinkedHashSet<>();
    regSet25.add(reg37);
    Reg reg38 = new Reg();
    reg38.excludes = new HashSet<>();
    reg38.prefers = new HashSet<>();
    reg38.type = 'A';

    LinkedHashSet<Reg> regSet26 = new LinkedHashSet<>();
    regSet26.add(reg38);
    Reg reg39 = new Reg();
    reg39.excludes = new HashSet<>();
    reg39.prefers = new HashSet<>();
    reg39.type = 'A';
    reg39.excludes = regSet25;
    reg39.prefers = regSet26;
    Reg reg40 = new Reg();
    reg40.excludes = new HashSet<>();
    reg40.prefers = new HashSet<>();
    reg40.type = 'A';

    LinkedHashSet<Reg> regSet27 = new LinkedHashSet<>();
    regSet27.add(reg40);
    Reg reg41 = new Reg();
    reg41.excludes = new HashSet<>();
    reg41.prefers = new HashSet<>();
    reg41.type = 'A';

    LinkedHashSet<Reg> regSet28 = new LinkedHashSet<>();
    regSet28.add(reg41);
    Reg reg42 = new Reg();
    reg42.excludes = new HashSet<>();
    reg42.prefers = new HashSet<>();
    reg42.type = 'A';
    reg42.excludes = regSet27;
    reg42.prefers = regSet28;
    Reg reg43 = new Reg();
    reg43.excludes = new HashSet<>();
    reg43.prefers = new HashSet<>();
    reg43.type = 'A';

    LinkedHashSet<Reg> regSet29 = new LinkedHashSet<>();
    regSet29.add(reg43);
    Reg reg44 = new Reg();
    reg44.excludes = new HashSet<>();
    reg44.prefers = new HashSet<>();
    reg44.type = 'A';

    LinkedHashSet<Reg> regSet30 = new LinkedHashSet<>();
    regSet30.add(reg44);
    Reg reg45 = new Reg();
    reg45.excludes = new HashSet<>();
    reg45.prefers = new HashSet<>();
    reg45.type = 'A';
    reg45.excludes = regSet29;
    reg45.prefers = regSet30;
    Reg reg46 = new Reg();
    reg46.excludes = new HashSet<>();
    reg46.prefers = new HashSet<>();
    reg46.type = 'A';

    LinkedHashSet<Reg> regSet31 = new LinkedHashSet<>();
    regSet31.add(reg46);
    Reg reg47 = new Reg();
    reg47.excludes = new HashSet<>();
    reg47.prefers = new HashSet<>();
    reg47.type = 'A';

    LinkedHashSet<Reg> regSet32 = new LinkedHashSet<>();
    regSet32.add(reg47);
    Reg reg48 = new Reg();
    reg48.excludes = new HashSet<>();
    reg48.prefers = new HashSet<>();
    reg48.type = 'A';
    reg48.excludes = regSet31;
    reg48.prefers = regSet32;
    Reg reg49 = new Reg();
    reg49.excludes = new HashSet<>();
    reg49.prefers = new HashSet<>();
    reg49.type = 'A';

    LinkedHashSet<Reg> regSet33 = new LinkedHashSet<>();
    regSet33.add(reg49);
    Reg reg50 = new Reg();
    reg50.excludes = new HashSet<>();
    reg50.prefers = new HashSet<>();
    reg50.type = 'A';

    LinkedHashSet<Reg> regSet34 = new LinkedHashSet<>();
    regSet34.add(reg50);
    Reg reg51 = new Reg();
    reg51.excludes = new HashSet<>();
    reg51.prefers = new HashSet<>();
    reg51.type = 'A';
    reg51.excludes = regSet33;
    reg51.prefers = regSet34;
    Reg reg52 = new Reg();
    reg52.excludes = new HashSet<>();
    reg52.prefers = new HashSet<>();
    reg52.type = 'A';

    LinkedHashSet<Reg> regSet35 = new LinkedHashSet<>();
    regSet35.add(reg52);
    Reg reg53 = new Reg();
    reg53.excludes = new HashSet<>();
    reg53.prefers = new HashSet<>();
    reg53.type = 'A';

    LinkedHashSet<Reg> regSet36 = new LinkedHashSet<>();
    regSet36.add(reg53);
    Reg reg54 = new Reg();
    reg54.excludes = new HashSet<>();
    reg54.prefers = new HashSet<>();
    reg54.type = 'A';
    reg54.excludes = regSet35;
    reg54.prefers = regSet36;

    // Act
    Map<Character, List<Reg>> actualGroupAndCleanUpByTypeResult =
        ir2JRegAssignTransformer.groupAndCleanUpByType(
            new Reg[] {
              reg3, reg6, reg9, reg12, reg15, reg18, reg21, reg24, reg27, reg30, reg33, reg36,
              reg39, reg42, reg45, reg48, reg51, reg54
            });

    // Assert
    assertEquals(1, actualGroupAndCleanUpByTypeResult.size());
    List<Reg> getResult = actualGroupAndCleanUpByTypeResult.get('A');
    assertEquals(18, getResult.size());
    assertSame(reg6, getResult.get(1));
    assertSame(reg48, getResult.get(15));
    assertSame(reg54, getResult.get(17));
    assertSame(reg9, getResult.get(2));
    assertSame(reg51, getResult.get(Short.SIZE));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Ir2JRegAssignTransformer.groupAndCleanUpByType(Reg[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Ir2JRegAssignTransformer.groupAndCleanUpByType(Reg[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Ir2JRegAssignTransformer.groupAndCleanUpByType(Reg[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Reg.<init>()"})
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

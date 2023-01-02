package com.utn.frba.srs.controller;

import com.utn.frba.srs.component.GeneratorComponent;
import com.utn.frba.srs.component.RoundComponent;
import com.utn.frba.srs.component.RoundPlanningComponent;
import com.utn.frba.srs.utils.BaseAPI;
import org.junit.jupiter.api.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.utn.frba.srs.component.CheckpointComponent.createCheckpoint;
import static com.utn.frba.srs.component.CheckpointComponent.deleteCheckpoint;
import static com.utn.frba.srs.component.CompanySecurityComponent.createCompanySecurity;
import static com.utn.frba.srs.component.CompanySecurityComponent.deleteCompanySecurity;
import static com.utn.frba.srs.component.CustomerComponent.createCustomer;
import static com.utn.frba.srs.component.CustomerComponent.deleteCustomer;
import static com.utn.frba.srs.component.RoundComponent.deleteRound;
import static com.utn.frba.srs.component.SubsidiaryComponent.createSubsidary;
import static com.utn.frba.srs.component.SubsidiaryComponent.deleteSubsidary;
import static com.utn.frba.srs.config.TestSuiteTags.LOCAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundPlanningControllerTest extends BaseAPI {


    private static Long companySecurityId;
    private static Long customerId;
    private static Long subsidiaryId;

    private static Long roundId;
    private static HashMap<Integer, String> nfc;
    private static Integer countNfc = 10;


    @BeforeAll
    public static void beforeAllTests() {
        companySecurityId = createCompanySecurity(GeneratorComponent.createNameCompanySecurity(), "CUIT", GeneratorComponent.createDocument());
        customerId = createCustomer(companySecurityId, GeneratorComponent.createNameCustoemr(), "CUIT", GeneratorComponent.createDocument());
        subsidiaryId = createSubsidary(customerId, GeneratorComponent.createNameSubsidiary());
        nfc = new HashMap<>();
        for (int i = 1; i <= countNfc; i++) {
            var nfcCode = GeneratorComponent.createNFCCheckpoint();
            nfc.put(i, nfcCode);
            createCheckpoint(subsidiaryId, nfcCode);
        }

        List<RoundController.RoundCheckPointDto> checkpoints = new ArrayList<>();
        List<RoundController.RoundRouteDto> rutas = new ArrayList<>();
        for (int i = 1; i <= nfc.size(); i++) {
            checkpoints.add(new RoundController.RoundCheckPointDto(nfc.get(i), i));
        }
        for (int i = 1; i <= checkpoints.size() * 4; i++) {
            rutas.add(new RoundController.RoundRouteDto(i, GeneratorComponent.latitud(), GeneratorComponent.longitud()));
        }
        roundId = RoundComponent.createRound(subsidiaryId, GeneratorComponent.createNameRound(), checkpoints, rutas);
    }

    @AfterAll
    public static void afterAllTests() {
        deleteSubsidary(subsidiaryId);
        deleteCustomer(customerId);
        deleteCompanySecurity(companySecurityId);
        for (int i = 1; i <= countNfc; i++) {
            deleteCheckpoint(nfc.get(i));
        }
        deleteRound(roundId);
    }


    @Test
    @Tag(LOCAL)
    @DisplayName("Create Round Planning")
    void create() {
        List<Planing> planning = new ArrayList<>();
        planning.add(new Planing(DayOfWeek.MONDAY.name(), LocalTime.of(14, 0)));
        planning.add(new Planing(DayOfWeek.MONDAY.name(), LocalTime.of(18, 30)));
        planning.add(new Planing(DayOfWeek.MONDAY.name(), LocalTime.of(21, 0)));
        planning.add(new Planing(DayOfWeek.WEDNESDAY.name(), LocalTime.of(14, 0)));
        planning.add(new Planing(DayOfWeek.WEDNESDAY.name(), LocalTime.of(18, 30)));
        planning.add(new Planing(DayOfWeek.WEDNESDAY.name(), LocalTime.of(21, 0)));
        planning.forEach((unit) -> RoundPlanningComponent.createRoundPlanning(new RoundPlanningController.RoundPlanningDto(roundId, unit.day(), unit.timeInit())));
        var response = RoundPlanningComponent.findByRoundId(roundId);
        assertEquals(planning.size(), response.plannings().size());

        RoundPlanningComponent.deleteRoundPlanning(roundId);
    }

    record Planing(String day, LocalTime timeInit) {
    }

    @Test
    @Tag(LOCAL)
    @DisplayName("Update Round Planning")
    void update() {
        List<Planing> planning = new ArrayList<>();
        planning.add(new Planing(DayOfWeek.MONDAY.name(), LocalTime.of(14, 0)));
        planning.add(new Planing(DayOfWeek.MONDAY.name(), LocalTime.of(18, 30)));
        planning.add(new Planing(DayOfWeek.MONDAY.name(), LocalTime.of(21, 0)));
        planning.add(new Planing(DayOfWeek.WEDNESDAY.name(), LocalTime.of(14, 0)));
        planning.add(new Planing(DayOfWeek.WEDNESDAY.name(), LocalTime.of(18, 30)));
        planning.add(new Planing(DayOfWeek.WEDNESDAY.name(), LocalTime.of(21, 0)));
        planning.forEach((unit) -> RoundPlanningComponent.createRoundPlanning(new RoundPlanningController.RoundPlanningDto(roundId, unit.day(), unit.timeInit())));


        var response = RoundPlanningComponent.findByRoundId(roundId);
        response.plannings().stream().filter(roundPlanningReduceDto -> roundPlanningReduceDto.dayName().equals(DayOfWeek.WEDNESDAY.name())).forEach(
                (roundPlanningReduceDto) -> RoundPlanningComponent.deleteRoundPlanning(roundPlanningReduceDto.id()));

        planning = new ArrayList<>();
        planning.add(new Planing(DayOfWeek.THURSDAY.name(), LocalTime.of(14, 0)));
        planning.add(new Planing(DayOfWeek.THURSDAY.name(), LocalTime.of(18, 30)));
        planning.add(new Planing(DayOfWeek.THURSDAY.name(), LocalTime.of(21, 0)));
        planning.forEach((unit) -> RoundPlanningComponent.createRoundPlanning(new RoundPlanningController.RoundPlanningDto(roundId, unit.day(), unit.timeInit())));

        response = RoundPlanningComponent.findByRoundId(roundId);
        assertEquals(3 + 3, response.plannings().size());

        response.plannings().forEach(
                (roundPlanningReduceDto) -> RoundPlanningComponent.deleteRoundPlanning(roundPlanningReduceDto.id()));
    }


}

package com.utn.frba.srs.controller;

import com.utn.frba.srs.component.GeneratorComponent;
import com.utn.frba.srs.component.RoundComponent;
import com.utn.frba.srs.utils.BaseAPI;
import org.junit.jupiter.api.*;

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

public class RoundControllerTest extends BaseAPI {


    private static Long companySecurityId;
    private static Long customerId;
    private static Long subsidiaryId;
    private static HashMap<Integer, String> nfc;
    private static final Integer countNfc = 10;


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
    }

    @AfterAll
    public static void afterAllTests() {
        deleteSubsidary(subsidiaryId);
        deleteCustomer(customerId);
        deleteCompanySecurity(companySecurityId);
        for (int i = 1; i <= countNfc; i++) {
            deleteCheckpoint(nfc.get(i));
        }
    }

    @Test
    @Tag(LOCAL)
    @DisplayName("Create Round")
    void create() {
        List<RoundController.RoundCheckPointDto> checkpoints = new ArrayList<>();
        List<RoundController.RoundRouteDto> rutas = new ArrayList<>();
        for (int i = 1; i <=nfc.size(); i++) {
            checkpoints.add(new RoundController.RoundCheckPointDto(nfc.get(i), i));
        }
        for (int i = 1; i <= checkpoints.size() * 4; i++) {
            rutas.add(new RoundController.RoundRouteDto(i, GeneratorComponent.latitud(), GeneratorComponent.longitud()));
        }
        Long roundId = RoundComponent.createRound(subsidiaryId, GeneratorComponent.createNameRound(), checkpoints, rutas);

        var round= RoundComponent.findById(roundId);
        assertEquals(checkpoints.size(),round.checkpoints().size());
        assertEquals(rutas.size(),round.routes().size());
        deleteRound(roundId);
    }

    @Test
    @Tag(LOCAL)
    @DisplayName("Update Round")
    void update() {
        List<RoundController.RoundCheckPointDto> checkpoints = new ArrayList<>();
        List<RoundController.RoundRouteDto> rutas = new ArrayList<>();
        for (int i = 1; i <=nfc.size(); i++) {
            checkpoints.add(new RoundController.RoundCheckPointDto(nfc.get(i), i));
        }
        for (int i = 1; i <= checkpoints.size() * 4; i++) {
            rutas.add(new RoundController.RoundRouteDto(i, GeneratorComponent.latitud(), GeneratorComponent.longitud()));
        }
        String name= GeneratorComponent.createNameRound();
        Long roundId = RoundComponent.createRound(subsidiaryId, name, checkpoints, rutas);


        for (int i = 1; i <=3; i++) {
            checkpoints.add(new RoundController.RoundCheckPointDto(nfc.get(i), i));
        }
        for (int i = 1; i <=3 * 4; i++) {
            rutas.add(new RoundController.RoundRouteDto(i, GeneratorComponent.latitud(), GeneratorComponent.longitud()));
        }
        RoundComponent.updateRound(roundId,subsidiaryId,name,checkpoints, rutas);

        var round= RoundComponent.findById(roundId);
        assertEquals(round.checkpoints().size(),3);
        assertEquals(round.routes().size(),3 * 4);
        deleteRound(roundId);
    }


}

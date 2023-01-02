package com.utn.frba.srs.controller;

import com.utn.frba.srs.component.CheckpointComponent;
import com.utn.frba.srs.component.GeneratorComponent;
import com.utn.frba.srs.utils.BaseAPI;
import org.junit.jupiter.api.*;

import static com.utn.frba.srs.component.CheckpointComponent.*;
import static com.utn.frba.srs.component.CompanySecurityComponent.createCompanySecurity;
import static com.utn.frba.srs.component.CompanySecurityComponent.deleteCompanySecurity;
import static com.utn.frba.srs.component.CustomerComponent.createCustomer;
import static com.utn.frba.srs.component.CustomerComponent.deleteCustomer;
import static com.utn.frba.srs.component.SubsidiaryComponent.createSubsidary;
import static com.utn.frba.srs.component.SubsidiaryComponent.deleteSubsidary;
import static com.utn.frba.srs.config.TestSuiteTags.LOCAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CheckpointControllerTest extends BaseAPI {


    private static Long companySecurityId;
    private static Long customerId;
    private static Long subsidiaryId;


    @BeforeAll
    public static void beforeAllTests() {
        companySecurityId = createCompanySecurity(GeneratorComponent.createNameCompanySecurity(), "CUIT", GeneratorComponent.createDocument());
        customerId = createCustomer(companySecurityId, GeneratorComponent.createNameCustoemr(), "CUIT", GeneratorComponent.createDocument());
        subsidiaryId = createSubsidary(customerId, GeneratorComponent.createNameSubsidiary());
    }

    @AfterAll
    public static void afterAllTests() {
        deleteSubsidary(subsidiaryId);
        deleteCustomer(customerId);
        deleteCompanySecurity(companySecurityId);
    }


    @Test
    @Tag(LOCAL)
    @DisplayName("Create Checkpoint")
    void create() {
        var identificadorNFC = GeneratorComponent.createNFCCheckpoint();
        createCheckpoint(subsidiaryId, identificadorNFC);
        CheckpointController.CheckpointReduceDto checkpoint = CheckpointComponent.findById(identificadorNFC);
        assertNotNull(checkpoint);
        deleteCheckpoint(identificadorNFC);
    }


    @Test
    @Tag(LOCAL)
    @DisplayName("Update Checkpoint")
    void update() {
        var identificadorNFC = GeneratorComponent.createNFCCheckpoint();
        createCheckpoint(subsidiaryId, identificadorNFC);
        updateCheckpoint(new CheckpointController.CheckpointDto(identificadorNFC, "", "", subsidiaryId));

        CheckpointController.CheckpointReduceDto checkpoint = CheckpointComponent.findById(identificadorNFC);
        assertEquals(checkpoint.latitude(), "");
        assertEquals(checkpoint.longitude(), "");
        deleteCheckpoint(identificadorNFC);
    }

    @Test
    @Tag(LOCAL)
    @DisplayName("Find By Subsidiary Checkpoint")
    void findBySubsidiary() {
        var identificadorNFC1 = GeneratorComponent.createNFCCheckpoint();
        var identificadorNFC2 = GeneratorComponent.createNFCCheckpoint();
        createCheckpoint(subsidiaryId, identificadorNFC1);
        createCheckpoint(subsidiaryId, identificadorNFC2);

        var response = CheckpointComponent.findBySubsidiary(subsidiaryId);
        assertEquals(response.checkpoints().size(), 2);

        deleteCheckpoint(identificadorNFC1);
        deleteCheckpoint(identificadorNFC2);
    }


}
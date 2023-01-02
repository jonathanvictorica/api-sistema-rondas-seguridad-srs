package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.SubsidiaryController;
import com.utn.frba.srs.model.Subsidiary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SubsidiaryMapper {




    @Mappings({
            @Mapping(source="name", target="name"),
            @Mapping(source="description", target="description"),
            @Mapping(source="streetName", target="domicile.streetName"),
            @Mapping(source="streetNumber", target="domicile.streetNumber"),
            @Mapping(source="apartment", target="domicile.apartment"),
            @Mapping(source="flat", target="domicile.flat"),
            @Mapping(source="city", target="domicile.city"),
            @Mapping(source="party", target="domicile.party"),
            @Mapping(source="province", target="domicile.province"),
            @Mapping(source="latitude", target="domicile.ubiety.latitude"),
            @Mapping(source="longitude", target="domicile.ubiety.longitude"),
            @Mapping(source="customerId", target="customer.id")

    })
    Subsidiary toSubsidiary(SubsidiaryController.SubsidiaryDto entity);


    @Mappings({
            @Mapping(target="name", source="name"),
            @Mapping(target="description", source="description"),
            @Mapping(target="streetName", source="domicile.streetName"),
            @Mapping(target="streetNumber", source="domicile.streetNumber"),
            @Mapping(target="apartment", source="domicile.apartment"),
            @Mapping(target="flat", source="domicile.flat"),
            @Mapping(target="city", source="domicile.city"),
            @Mapping(target="party", source="domicile.party"),
            @Mapping(target="province", source="domicile.province"),
            @Mapping(target="latitude", source="domicile.ubiety.latitude"),
            @Mapping(target="longitude", source="domicile.ubiety.longitude"),
            @Mapping(target="customerId", source="customer.id")

    })
    SubsidiaryController.SubsidiaryReduceDto toSubsidiaryReduceDto(Subsidiary entity) ;
}

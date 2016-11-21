package com.softserve.osbb.dto.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softserve.osbb.dto.OsbbRegistrationDTO;
import com.softserve.osbb.model.Osbb;

/**
 * Created by nazar.dovhyy on 29.10.2016.
 */
@Component
public class OsbbRegistartionToOsbbAdapter extends DTOToEntityAdapter<OsbbRegistrationDTO, Osbb> {

    @Autowired
    private UserRegistrationToUserAdapter userRegistrationToUserAdapter;

    @Override
    public Osbb parse(OsbbRegistrationDTO osbbRegistrationDTO) {
        Osbb registeredOsbb = new Osbb();
        if (osbbRegistrationDTO == null) {

            if (dto == null) {
                throw new IllegalArgumentException();
            }
            osbbRegistrationDTO = (OsbbRegistrationDTO) dto;
            _parse(osbbRegistrationDTO, registeredOsbb);
            return registeredOsbb;
        }
        _parse(osbbRegistrationDTO, registeredOsbb);
        return registeredOsbb;
    }

    private void _parse(OsbbRegistrationDTO osbbRegistrationDTO, Osbb registeredOsbb) {
        registeredOsbb.setName(osbbRegistrationDTO.getName());
        registeredOsbb.setDescription(osbbRegistrationDTO.getDescription());
        registeredOsbb.setCreator(userRegistrationToUserAdapter.parse(osbbRegistrationDTO.getCreator()));
        registeredOsbb.setAddress(osbbRegistrationDTO.getAddress());
        registeredOsbb.setDistrict(osbbRegistrationDTO.getDistrict());
        registeredOsbb.setCreationDate(osbbRegistrationDTO.getCreationDate());
        registeredOsbb.setAvailable(registeredOsbb.getAvailable());

    }
}

package com.softserve.osbb.dto.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softserve.osbb.dto.OsbbRegistrationDTO;
import com.softserve.osbb.dto.adapter.OsbbRegistartionToOsbbAdapter;
import com.softserve.osbb.model.Osbb;

/**
 * Created by nazar.dovhyy on 29.10.2016.
 */
@Component
public class OsbbRegistrationDTOMapper extends AbstractDTOMapper<Osbb, OsbbRegistrationDTO> {

    @Autowired
    private OsbbRegistartionToOsbbAdapter osbbRegistartionToOsbbAdapter;

    @Override
    public OsbbRegistrationDTO mapEntityToDTO(Osbb entity) {
        return null;
    }

    @Override
    public Osbb mapDTOToEntity(OsbbRegistrationDTO dto) {
        return osbbRegistartionToOsbbAdapter.parse(dto);
    }
}

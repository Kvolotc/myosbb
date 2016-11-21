package com.softserve.osbb.util.resources.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;

import com.softserve.osbb.controller.TicketController;
import com.softserve.osbb.dto.TicketDTO;

/**
 * Created by Kris on 23.08.2016.
 */
public class TicketResourceListDTO  extends EntityResourceList<TicketDTO> {
        @Override
        public Resource<TicketDTO> createLink(Resource<TicketDTO> reportResource) {
            TicketDTO report = reportResource.getContent();

            reportResource.add(linkTo(methodOn(TicketController.class)
                    .getTicketById(report.getTicketId())).withSelfRel());


            return reportResource;
        }
}

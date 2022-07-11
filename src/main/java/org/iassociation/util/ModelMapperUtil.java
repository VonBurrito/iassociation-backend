package org.iassociation.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Hamza Amentag
 * @since 7/11/2022
 */
@Component
public class ModelMapperUtil {

    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //no-args constructor for IoC
    public ModelMapperUtil() {
    }
}

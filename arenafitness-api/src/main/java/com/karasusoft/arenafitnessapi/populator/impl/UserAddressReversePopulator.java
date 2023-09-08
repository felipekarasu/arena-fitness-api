package com.karasusoft.arenafitnessapi.populator;

import com.karasusoft.arenafitnessapi.dto.AddressDto;
import com.karasusoft.arenafitnessapi.dto.CreateUserDto;
import com.karasusoft.arenafitnessapi.model.AddressModel;
import com.karasusoft.arenafitnessapi.model.UserModel;
import org.apache.commons.lang3.StringUtils;

public class UserAddressReversePopulator implements Populator<CreateUserDto, UserModel> {

    //@Override
    public void populate(CreateUserDto source, UserModel target) {

        if( source.getAddressDtoList().isEmpty()) {
            return;
        }

        for(AddressDto address : source.getAddressDtoList()) {

            AddressModel newAddressModel = new AddressModel();

            //TODO REMOVE AND USE PREPERSIST
            newAddressModel.setUser(target);

            if(StringUtils.isNotEmpty(address.getAddressName())){
                newAddressModel.setAddressName(address.getAddressName());
            }

            if(StringUtils.isNotEmpty(address.getAddressNumber())){
                newAddressModel.setAddressNumber(address.getAddressNumber());
            }

            if(StringUtils.isNotEmpty(address.getArea())){
                newAddressModel.setArea(address.getArea());
            }

            if(StringUtils.isNotEmpty(address.getCity())){
                newAddressModel.setCity(address.getCity());
            }

            if(StringUtils.isNotEmpty(address.getState())){
                newAddressModel.setState(address.getState());
            }

            if(StringUtils.isNotEmpty(address.getCity())){
                newAddressModel.setCity(address.getCity());
            }

            if(StringUtils.isNotEmpty(address.getCountry())){
                newAddressModel.setCountry(address.getCountry());
            }

            if(StringUtils.isNotEmpty(address.getPostalCode())){
                newAddressModel.setPostalCode(address.getPostalCode());
            }

            target.getAddressModelList().add(newAddressModel);
        }
    }
}

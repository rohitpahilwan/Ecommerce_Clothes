package com.app.service;



import java.util.List;

import com.app.dto.AddressDTO;

public interface AddressService {

    AddressDTO createAddress(AddressDTO addressDTO);

    AddressDTO getAddressById(Long id);

    List<AddressDTO> getAllAddresses();

    AddressDTO updateAddress(Long id, AddressDTO addressDTO);

    void deleteAddress(Long id);
}

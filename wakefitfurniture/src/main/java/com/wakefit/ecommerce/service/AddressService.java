package com.wakefit.ecommerce.service;

import com.wakefit.ecommerce.entity.Address;

public interface AddressService {
    Address addAddress(Address address);
    Address getAddressById(Long addressId);
    Address updateAddress(Long addressId, Address address);
    void deleteAddress(Long addressId);
    
}

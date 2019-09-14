package com.shopping_mall.service;

import com.shopping_mall.common.UnitOfWork;
import com.shopping_mall.entity.Address;
import com.shopping_mall.mapper.AddressMapper;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddressService {

    private AddressMapper addressMapper;

    public AddressService(){
        addressMapper = new AddressMapper();

    }

    public void createAddress(Address address) throws Exception {

        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(address);
        UnitOfWork.getCurrent().commit();

    }

    public void updateAddress(Address address) throws Exception {

        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(address);
        UnitOfWork.getCurrent().commit();

    }

    public void deleteAddress(Address address) throws Exception {

        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDeleted(address);
        UnitOfWork.getCurrent().commit();

    }


    /**
     * View all relevant address of a user in the database
     */
    public ArrayList<Address> viewAllAddressOfUser(int userId) {
        ArrayList<Address> addressList = AddressMapper.findAddressByUserId(userId);
        return addressList;
    }

    public Address viewOneAddressById(int addressId) {
        Address address = AddressMapper.findAddressById(addressId);
        return address;
    }

}

package com.ntu.edu.group5.ecommerce.service;

import com.ntu.edu.group5.ecommerce.repository.AddressRepository;
import com.ntu.edu.group5.ecommerce.entity.Address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceWithLoggingImpl implements AddressService {

    private final Logger logger = LoggerFactory.getLogger(AddressServiceWithLoggingImpl.class);

    private final AddressRepository addressRepository;

    public AddressServiceWithLoggingImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public ArrayList<Address> searchAddressesByCity(String city) {
        logger.info("AddressServiceWithLoggingImpl calling searchAddressesByCity()");
        List<Address> foundAddresses = addressRepository.findByCity(city);
        return (ArrayList<Address>) foundAddresses;
    }

    @Override
    public Address createAddress(Address address) {
        logger.info("AddressServiceWithLoggingImpl calling createAddress()");
        Address newAddress = addressRepository.save(address);
        return newAddress;
    }

    @Override
    public ArrayList<Address> getAllAddresses() {
        logger.info("AddressServiceWithLoggingImpl calling getAllAddresses()");
        List<Address> allAddresses = addressRepository.findAll();
        return (ArrayList<Address>) allAddresses;
    }

    @Override
    public void deleteAddress(Long id) {
        logger.info("AddressServiceWithLoggingImpl calling deleteAddress()");
        addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        logger.info("AddressServiceWithLoggingImpl calling updateAddress()");
        if (addressRepository.existsById(id)) {
            address.setId(id);
            return addressRepository.save(address);
        }
        return null; // or throw an exception indicating that the address with the given id doesn't exist
    }

    @Override
    public Address getAddress(Long id) {
        logger.info("AddressServiceWithLoggingImpl calling getAddress()");
        return addressRepository.findById(id).orElse(null);
    }
}



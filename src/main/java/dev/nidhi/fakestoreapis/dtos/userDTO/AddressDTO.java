package dev.nidhi.fakestoreapis.dtos.userDTO;

import dev.nidhi.fakestoreapis.models.FakeStore.Address;
import lombok.Data;

@Data
public class AddressDTO {
    private GeolocationDTO geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;

    public static AddressDTO from(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setGeolocation(GeolocationDTO.from(address.getGeolocation()));
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setNumber(address.getNumber());
        addressDTO.setZipcode(address.getZipcode());
        return addressDTO;
    }

    public static Address toAddress(AddressDTO address) {
        Address address1 = new Address();
        address1.setGeolocation(GeolocationDTO.toGeolocation(address.getGeolocation()));
        address1.setCity(address.getCity());
        address1.setStreet(address.getStreet());
        address1.setNumber(address.getNumber());
        address1.setZipcode(address.getZipcode());
        return address1;
    }
}

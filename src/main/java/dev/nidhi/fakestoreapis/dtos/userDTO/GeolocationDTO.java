package dev.nidhi.fakestoreapis.dtos.userDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.nidhi.fakestoreapis.models.FakeStore.Geolocation;
import lombok.Data;

@Data
public class GeolocationDTO {
    private String lat;
    @JsonProperty("long")
    private String longi;

    public static GeolocationDTO from(Geolocation geolocation) {
        GeolocationDTO geolocationDTO = new GeolocationDTO();
        geolocationDTO.setLat(geolocation.getLat());
        geolocationDTO.setLongi(geolocation.getLongi());
        return geolocationDTO;
    }

    public static Geolocation toGeolocation(GeolocationDTO geolocation) {
        Geolocation geolocationDTO = new Geolocation();
        geolocationDTO.setLat(geolocation.getLat());
        geolocationDTO.setLongi(geolocation.getLongi());
        return geolocationDTO;
    }
}

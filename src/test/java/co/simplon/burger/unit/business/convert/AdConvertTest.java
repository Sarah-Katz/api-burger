package co.simplon.burger.unit.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.burger.business.convert.AdConvert;
import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.persistance.entity.Ad;

class AdConvertTest {
    private static AdConvert adConvert = AdConvert.getInstance();

    @Test
    void testToEntity() {
        AdDto adDto = new AdDto();
        Ad ad = adConvert.toEntity(adDto);
        assertEquals(Ad.class, ad.getClass());
    }

    @Test
    void testToDto() {
        Ad ad = new Ad();
        AdDto adDto = adConvert.toDto(ad);
        assertEquals(AdDto.class, adDto.getClass());
    }

    @Test
    void testToDtoList() {
        List<Ad> ads = List.of(new Ad(), new Ad());
        List<AdDto> adDtos = adConvert.listToDto(ads);
        assertEquals(AdDto.class, adDtos.get(0).getClass());
    }

    @Test
    void testToEntityList() {
        List<AdDto> adDtos = List.of(new AdDto(), new AdDto());
        List<Ad> ads = adConvert.listToEntity(adDtos);
        assertEquals(Ad.class, ads.get(0).getClass());
    }
}

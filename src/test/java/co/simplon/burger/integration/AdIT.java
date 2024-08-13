package co.simplon.burger.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.service.ad.IAdService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-tests.properties")
class AdIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IAdService adService;

    @BeforeEach
    void setUp() {
        AdDto ad = new AdDto();
        ad.setTitle("Burger Ad");
        ad.setDescription("This is a test ad for burgers.");
        ad.setPrice(10.99);

        AdDto ad2 = new AdDto();
        ad2.setTitle("Fries Ad");
        ad2.setDescription("This is a test ad for fries.");
        ad2.setPrice(5.99);
        adService.saveAd(ad);
        adService.saveAd(ad2);
    }

    @AfterEach
    void tearDown() {
        List<AdDto> ads = adService.getAllAds();
        for (AdDto ad : ads) {
            adService.deleteAd(ad.getIdAd());
        }
    }

    private String getUrl(final String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    void createAd() {
        AdDto adDto = new AdDto();
        adDto.setTitle("Pasta Ad");
        adDto.setDescription("This is a test ad for pasta.");
        adDto.setPrice(9.99);

        ResponseEntity<String> res = this.restTemplate.postForEntity(getUrl("/ads"), adDto, String.class);
        List<AdDto> ads = adService.getAllAds();

        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertEquals(3, ads.size());
        assertEquals("Pasta Ad", ads.get(2).getTitle());
    }

    @Test
    void getAllAds() {
        ResponseEntity<?> res = this.restTemplate.getForEntity(getUrl("/ads"), List.class);

        System.out.println(res);
        assertEquals(HttpStatus.OK, res.getStatusCode());
    }
}

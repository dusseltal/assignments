package com.cs.assignment;

import com.cs.assignment.model.Smoothie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = Application.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmoothieControllerIntegrationTest {
  @Autowired private TestRestTemplate restTemplate;

  @LocalServerPort private int port;

  private String getRootUrl() {
    return "http://localhost:" + port;
  }

  @Test
  public void contextLoads() {}

  @Test
  public void testGetAllSmoothies() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    ResponseEntity<String> response =
        restTemplate.exchange(getRootUrl() + "/smoothies", HttpMethod.GET, entity, String.class);

    assertNotNull(response.getBody());
  }

  @Test
  public void testGetSmoothieById() {
    Smoothie smoothie = restTemplate.getForObject(getRootUrl() + "/smoothies/1", Smoothie.class);
    System.out.println(smoothie.getName());
    assertNotNull(smoothie);
  }

  @Test
  public void testCreateSmoothie() {
    Smoothie smoothie = new Smoothie();
    smoothie.setName("admin");
    smoothie.setVitaminA("0.01");

    ResponseEntity<Smoothie> postResponse =
        restTemplate.postForEntity(getRootUrl() + "/smoothies", smoothie, Smoothie.class);
    assertNotNull(postResponse);
    assertNotNull(postResponse.getBody());
  }

  @Test
  public void testUpdateSmoothie() {
    int id = 1;
    Smoothie smoothie =
        restTemplate.getForObject(getRootUrl() + "/smoothies/" + id, Smoothie.class);
    smoothie.setName("admin1");
    smoothie.setVitaminA("0.1");

    restTemplate.put(getRootUrl() + "/smoothies/" + id, smoothie);

    Smoothie updatedSmoothie =
        restTemplate.getForObject(getRootUrl() + "/smoothies/" + id, Smoothie.class);
    assertNotNull(updatedSmoothie);
  }

  @Test
  public void testDeleteSmoothie() {
    List<Smoothie> smoothieData = getSampleSmoothieData();
    // Mockito.when(covidDetailsService.getCovidDataByCode("TS", false)).thenReturn(smoothieData);

    int id = 2;
    Smoothie smoothie =
        restTemplate.getForObject(getRootUrl() + "/smoothies/" + id, Smoothie.class);
    assertNotNull(smoothie);

    restTemplate.delete(getRootUrl() + "/smoothies/" + id);
    smoothie = restTemplate.getForObject(getRootUrl() + "/smoothies/" + id, Smoothie.class);

    //    try {
    //      smoothie = restTemplate.getForObject(getRootUrl() + "/smoothies/" + id, Smoothie.class);
    //    } catch (HttpClientErrorException e) {
    //      assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
    //    }
  }

  private List<Smoothie> getSampleSmoothieData() {
    Smoothie smoothieData1 = new Smoothie();
    smoothieData1.setId(1L);
    smoothieData1.setName("name1");
    Smoothie smoothieData2 = new Smoothie();
    smoothieData2.setId(1L);
    smoothieData2.setName("name2");
    Smoothie smoothieData3 = new Smoothie();
    smoothieData3.setId(1L);
    smoothieData3.setName("name3");
    List<Smoothie> smoothieData = Arrays.asList(smoothieData1, smoothieData2, smoothieData3);
    return smoothieData;
  }
}

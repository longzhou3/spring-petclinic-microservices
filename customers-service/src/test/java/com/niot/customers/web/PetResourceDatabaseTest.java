package com.niot.customers.web;

import com.niot.customers.model.OwnerRepository;
import com.niot.customers.model.Pet;
import com.niot.customers.model.PetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author Maciej Szarlinski
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class PetResourceDatabaseTest {

    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void shouldGetAPet() throws Exception {
        Pet pet = petRepository.findOne(2);
        assertThat(petRepository.findAll()).contains(pet);
    }
}

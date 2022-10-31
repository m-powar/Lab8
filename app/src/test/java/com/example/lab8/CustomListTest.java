package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        City test = new City("City","AB");
        list.addCity(test);
        assertEquals(true,list.hasCity(test));
    }
    @Test
    void testDeleteCities() {
        CustomList cityList = MockCityList();
        City city = new City("Edmonton", "AB");
        City cityold = new City("cityold", "AB");
        cityList.addCity(cityold);
        City oldCity = (City) cityList.getCities().get(0);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
        cityList.addCity(city);

          assertTrue(cityList.hasCity(city));
          assertFalse(cityList.hasCity(oldCity));
    }
    }

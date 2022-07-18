package cn.sduonline.healthmonitorbackend.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By guosurui on 2022/7/18 11:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class IngredientControllerTest {
    @Resource
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        System.out.println("-------- API Test Start --------");
    }

    @AfterEach
    void tearDown() {
        System.out.println("-------- API Test Finish --------");
    }

    @Test
    void ingredientDelete() {
    }

    @Test
    void ingredientQuery() {
    }

    @Test
    void ingredientAdd() {
    }

    @Test
    void ingredientListGet() {
    }
}
package ru.rt.testwork.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.rt.testwork.services.CodeService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CodeController.class)
public class CodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("codeServiceImpl")
    CodeService codeService;


    @Test
    public void getCodeByCountryName() throws Exception {


        when(codeService.getCodeByCountryName("Russia")).thenReturn("7");
        when(codeService.getCodeByCountryName("NewVasyuki")).thenReturn(null);
        when(codeService.getCodeByCountryName("KolxozPobeda")).thenThrow(new RuntimeException("Just another exception"));

        mockMvc.perform(get("/code/Russia"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));

        mockMvc.perform(get("/code/NewVasyuki"))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/code/KolxozPobeda"))
                .andExpect(status().isInternalServerError());

    }
}
package pl.dawydiuk.pl.dawydiuk.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import pl.dawydiuk.AbstractControllerTest;

import java.util.concurrent.ExecutionException;


/**
 * Created by Konrad on 02.10.2016.
 */
@Transactional
public class UserControllerTest extends AbstractControllerTest{

    private String mainUrl = "/users/";


    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void getAllUser() throws Exception{
        String url = mainUrl+"getAllUsers";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals("Failure - expected HTTP status 200",200,status);
        Assert.assertTrue("Failure - expected HTTP response to have a value",content.trim().length()>0);
    }


}

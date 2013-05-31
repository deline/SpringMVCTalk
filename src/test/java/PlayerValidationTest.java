import com.delineneo.ModelErrorsResultMatchers;
import com.delineneo.web.controller.AddPlayerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * User: deline
 * Date: 31/05/13
 * Time: 7:23 PM
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration({
//        "classpath:spring/spring-mvc-config.xml",
//        "classpath:spring/spring-app-config.xml"
//})
public class PlayerValidationTest {

//    @Autowired
//    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AddPlayerController()).build();
    }

    @Test
    public void blah() throws Exception {
        mockMvc.perform(post("/player/add").param("firstName", "deline"))
            .andExpect(new ModelErrorsResultMatchers().attributeHasErrorMessageForField("player", "Required field", "lastName"));
    }
}

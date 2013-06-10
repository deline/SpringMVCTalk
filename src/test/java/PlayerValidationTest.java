import com.delineneo.ModelErrorsResultMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * User: deline
 * Date: 31/05/13
 * Time: 7:23 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "classpath:spring/spring-mvc-config.xml",
        "classpath:spring/spring-app-config.xml",
})
@DirtiesContext
public class PlayerValidationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void submitReturnsHttpOk() throws Exception {
        mockMvc.perform(
                post("/player/add")
                        .param("firstName", "deline")
                        .param("lastName", "neo"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/player/1"));
    }

    @Test
    public void submitWithValidationErrors() throws Exception {
        mockMvc.perform(
                post("/player/add"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("player", "firstName", "lastName"))
                .andExpect(model().errorCount(2));
    }

    @Test
    public void errorMessagesDisplayedWhenValidationFails() throws Exception {
        mockMvc.perform(post("/player/add"))
                .andExpect(modelErrors().attributeHasErrorMessageForField("player", "First name is required", "firstName"))
                .andExpect(modelErrors().attributeHasErrorMessageForField("player", "Last name is required", "lastName"));
    }

    public static ModelErrorsResultMatchers modelErrors() {
        return new ModelErrorsResultMatchers();
    }
}

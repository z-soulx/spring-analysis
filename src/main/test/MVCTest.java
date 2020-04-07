import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: spring
 * @description:
 * @author: soulx
 * @create: 2019-12-02 09:57
 **/
@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("dev")
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-servlet.xml",
//        "classpath:config.xml"
         })
//@SpringBootTest(classes = SmjjAppletApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
public class MVCTest {
    @Autowired
    public WebApplicationContext wac;

    public MockMvc mockMvc;

    public MockHttpSession session;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }



    @org.junit.Test
    public void test() {
        System.out.println("1");
    }

    @org.junit.Test
    public void testGetSequence() {
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/echo")

                    .param("name","1"))

                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            int status = mvcResult.getResponse().getStatus();
            System.out.println("请求状态码：" + status);
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println("接口返回结果：" + result);
            JSONObject resultObj = JSON.parseObject(result);
            // 判断接口返回json中success字段是否为true
            Assert.assertTrue(resultObj.getBooleanValue("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void testGetSequence2() {
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/echoAgain")

                    .param("name","1")
            .param("age","201"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            int status = mvcResult.getResponse().getStatus();
            System.out.println("请求状态码：" + status);
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println("接口返回结果：" + result);
            JSONObject resultObj = JSON.parseObject(result);
            // 判断接口返回json中success字段是否为true
            Assert.assertTrue(resultObj.getBooleanValue("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testGetSequenceJson() {
        try {
            String paraJson ="{\n" +
                    "\"name\":\"ss\",\n" +
                    "\"age\":19\n" +
                    "}";
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/echoJson")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(paraJson))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            int status = mvcResult.getResponse().getStatus();
            System.out.println("请求状态码：" + status);
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println("接口返回结果：" + result);
            JSONObject resultObj = JSON.parseObject(result);
            // 判断接口返回json中success字段是否为true
            Assert.assertTrue(resultObj.getBooleanValue("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

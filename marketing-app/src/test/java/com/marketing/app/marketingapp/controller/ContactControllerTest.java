package com.marketing.app.marketingapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketing.app.marketingapp.controller.impl.MarketingContactController;
import com.marketing.app.marketingapp.entities.VendorContact;
import com.marketing.app.marketingapp.models.Contact;
import com.marketing.app.marketingapp.service.MarketingContactService;
import com.marketing.app.marketingapp.util.TestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(MarketingContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private MarketingContactService marketingContactService;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testPostContact() throws Exception {
        MockHttpServletResponse response = createContact();
        assertEquals(201, response.getStatus());
    }

    @Test
    public void testGetContact() throws Exception {
        Contact createdContact = getCreatedContact(createContact());

        Mockito.when(marketingContactService.read(Mockito.any(String.class))).thenReturn(createdContact);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/marketing-app/contacts/" + createdContact.getCompanyName())
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());
        assertEquals(createdContact.getContactId(), getCreatedContact(response).getContactId());
    }

    @Test
    public void testPostContact_With_Bad_Request() throws Exception {
        TestDataBuilder dataBuilder = new TestDataBuilder();
        Contact contact = dataBuilder.buildTestContact();
        contact.setEmailAddress(null);
        RequestBuilder requestBuilder = getRequestBuilder(contact, MockMvcRequestBuilders
                .post("/marketing-app/contacts"));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    public void testGetContact_With_Entity_Not_Found() throws Exception {
        Mockito.when(marketingContactService.read(Mockito.any(String.class))).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/marketing-app/contacts/" + "testco")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void testUpdateContact() throws Exception {
        Contact createdContact = getCreatedContact(createContact());
        createdContact.setContactId(134L);

        Mockito.when(marketingContactService.update(Mockito.any(Contact.class))).thenReturn(createdContact);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/marketing-app/contacts")
                .accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(createdContact))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());
        assertEquals(createdContact.getContactId(), getCreatedContact(response).getContactId());
    }

    @Test
    public void testGetContacts() throws Exception {
        List<Contact> testContactList = new ArrayList<>();
        List<VendorContact> testVendorContacts = new ArrayList<>();
        TestDataBuilder dataBuilder = new TestDataBuilder();

        dataBuilder.buildDataSets(testContactList, testVendorContacts);

        Mockito.when(marketingContactService.getContacts(Mockito.any(String.class))).thenReturn(testContactList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/marketing-app/contacts/company/" + testContactList.get(0).getCompanyName())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());

    }

    private MockHttpServletResponse createContact() throws Exception {
        TestDataBuilder dataBuilder = new TestDataBuilder();
        Contact contact = dataBuilder.buildTestContact();

        Mockito.when(marketingContactService.saveContact(Mockito.any(Contact.class))).thenReturn(contact);
        RequestBuilder requestBuilder = getRequestBuilder(contact, MockMvcRequestBuilders
                .post("/marketing-app/contacts"));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        return result.getResponse();

    }

    private MockHttpServletRequestBuilder getRequestBuilder(Contact contact, MockHttpServletRequestBuilder post) throws JsonProcessingException {
        return post
                .accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(contact))
                .contentType(MediaType.APPLICATION_JSON);
    }

    private Contact getCreatedContact(MockHttpServletResponse response) throws Exception {
        return objectMapper.readValue(response.getContentAsString(), Contact.class);
    }
}
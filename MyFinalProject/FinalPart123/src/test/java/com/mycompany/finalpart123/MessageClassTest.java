/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.finalpart123;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class MessageClassTest {
    
    public MessageClassTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRecipientCell method, of class MessageClass.
     */
    //part 1&2
    @Test
    public void testGetRecipientCell() {
        System.out.println("getRecipientCell");
        MessageClass instance = new MessageClass();
        String expResult = "";
        String result = instance.getRecipientCell();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMessageText method, of class MessageClass.
     */
    @Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        MessageClass instance = new MessageClass();
        String expResult = "";
        String result = instance.getMessageText();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMessageId method, of class MessageClass.
     */
    @Test
    public void testGetMessageId() {
        System.out.println("getMessageId");
        MessageClass instance = new MessageClass();
        String expResult = "";
        String result = instance.getMessageId();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkRecipientCell method, of class MessageClass.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        MessageClass instance = new MessageClass("+27123456789", "Hello World");
        String expResult = "Valid Recipient";
        String result = instance.checkRecipientCell();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of createMessageHash method, of class MessageClass.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        MessageClass instance = new MessageClass("+27123456789", "Hello World");
        String expResult = "HELLOWORLD";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of SentMessages method, of class MessageClass.
     */
    @Test
    public void testSentMessages() {
        System.out.println("SentMessages");
        int choice = 0;
        MessageClass instance = new MessageClass("+27123456789", "Test Messages");
        String expResult = "";
        String result = instance.SentMessages(choice);
        assertEquals(expResult, result);
        assertEquals("Message successfully sent", instance.SentMessages(1));
        assertEquals("Message deleted successfully", instance.SentMessages(2));
        assertEquals("Messages successfully stored", instance.SentMessages(3));
        
       
    }

    /**
     * Test of printMessages method, of class MessageClass.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        MessageClass instance = new MessageClass("+27123456789", "Hello World");
        String expResult = "";
        String result = instance.printMessages();
        assertNotNull(result);
        assertTrue(result.contains("Recipient: +27123456789"));
        assertTrue(result.contains("Message: Hello World"));  
        assertEquals(expResult, result);
        
    }

    /**
     * Test of returnTotalMessages method, of class MessageClass.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        MessageClass instance = new MessageClass("+27123456789", "Counter Check");
        int initialCount = MessageClass.returnTotalMessages();
        instance.SentMessages(1);
        int expResult = initialCount + 1;
        int result = MessageClass.returnTotalMessages();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of storeMessage method, of class MessageClass.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        MessageClass instance = new MessageClass("+27123456789", "JSON Test");
        try {
        instance.storeMessage();
        assertTrue(true);
        } catch (Exception e) {
            fail("storeMessage crashed: " + e.getMessage());
        }
        
    }

    /**
     * Test of populateTestData method, of class MessageClass.
     */
    @Test
    public void testPopulateTestData() {
        System.out.println("Testing: populateTestData");
        MessageClass.populateTestData();
        
        //Verrifies the arrays
        assertEquals(5, MessageClass.count);
        
    }

    /**
     * Test of displaySendersRecipients method, of class MessageClass.
     */
    @Test
    public void testDisplaySendersRecipients() {
        System.out.println(" Testing: displaySendersRecipients");
        String expResult = "";
        String result = MessageClass.displaySendersRecipients();
        
        //Verifies the dashboard output
        assertNotNull(result);
        assertTrue(result.contains("+27838884567"));
        assertTrue(result.contains("Where are you?"));
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findLongestMessage method, of class MessageClass.
     */
    @Test
    public void testFindLongestMessage() {
        System.out.println("Testing: findLongestMessage");
        String expResult = "Where are you? You are late! I have asked you to be on time.";
        String result = MessageClass.findLongestMessage();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of searchById method, of class MessageClass.
     */
    @Test
    public void testSearchById() {
        System.out.println("Testing: searchById");
        String searchId = "";
        String expResult = "";
        
        //Search for MSG004 so that it can retrieve the correct sequence
        String result = MessageClass.searchById("MSG004");
        assertTrue(result.contains("0838884567"));
        assertEquals(expResult, result);
        
    }

    /**
     * Test of searchByRecipient method, of class MessageClass.
     */
    @Test
    public void testSearchByRecipient() {
        System.out.println("Testing: searchByRecipient");
        String recipient = "";
        List<String> expResult = null;
        
        //Searching for the recipient phone number
        List<String> result = MessageClass.searchByRecipient("+27838884567");
        assertTrue(result.contains("Where are you?"));
        assertTrue(result.contains("Ok, I am leaving without you."));
        assertEquals(expResult, result);
        
    }

    /**
     * Test of deleteMessageByHash method, of class MessageClass.
     */
    @Test
    public void testDeleteMessageByHash() {
        System.out.println("Testing: deleteMessageByHash");
        String hash = "";
        String expResult = "";
        
        //Try and delete the hash if it will successfully proceed
        String result = MessageClass.deleteMessageByHash("HASH002");
        assertTrue(result.contains("successfully deleted"));
        
        //confirmation check
        String searchCheck = MessageClass.searchById("MSG002");
        assertTrue(searchCheck.contains("not found"));
        assertEquals(expResult, result);
        
    }

    /**
     * Test of generateReport method, of class MessageClass.
     */
    @Test
    public void testGenerateReport() {
        System.out.println("Testing: generateReport");
        String expResult = "";
        String result = MessageClass.generateReport();
        
        //These are the asserts that structered the report
        assertNotNull(result);
        assertTrue(result.contains("HASH001"));
        assertTrue(result.contains("HASH004"));
        assertTrue(result.contains("HASH005"));
        
        
    }

    /**
     * Test of getSentMessagesOnly method, of class MessageClass.
     */
    @Test
    public void testGetSentMessagesOnly() {
        System.out.println("Testing: getSentMessagesOnly");
        List<String> expResult = null;
        List<String> result = MessageClass.getSentMessagesOnly();
        List<String> sentList = MessageClass.getSentMessagesOnly();
        assertEquals(2, sentList.size());
        assertEquals(expResult, result);
       
    }
    
}

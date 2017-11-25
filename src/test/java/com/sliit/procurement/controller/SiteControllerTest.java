package com.sliit.procurement.controller;

import com.sliit.procurement.model.Site;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Munsif on 11/24/2017.
 */
public class SiteControllerTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    /**
     * Test of getAllSites method, of class SiteController.
     */
    @Test
    public void testGetAllSites() {
        System.out.println("getAllSites");
        SiteController instance = new SiteController();
        List<Site> expResult = null;
        List<Site> result = instance.getAllSites();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSiteById method, of class SiteController.
     */
    @Test
    public void testGetSiteById() {
        System.out.println("getSiteById");
        String siteId = "";
        SiteController instance = new SiteController();
        Site expResult = null;
        Site result = instance.getSiteById(siteId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSite method, of class SiteController.
     */
    @Test
    public void testAddSite() {
        System.out.println("addSite");
        Site site = null;
        SiteController instance = new SiteController();
        Site expResult = null;
        Site result = instance.addSite(site);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSite method, of class SiteController.
     */
    @Test
    public void testUpdateSite() {
        System.out.println("updateSite");
        Site site = null;
        SiteController instance = new SiteController();
        Site expResult = null;
        Site result = instance.updateSite(site);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSite method, of class SiteController.
     */
    @Test
    public void testDeleteSite() {
        System.out.println("deleteSite");
        String siteId = "";
        SiteController instance = new SiteController();
        String expResult = "";
        String result = instance.deleteSite(siteId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
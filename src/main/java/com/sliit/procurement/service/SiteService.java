package com.sliit.procurement.service;

import com.sliit.procurement.model.Site;

import java.util.List;

/**
 * Created by Munsif on 11/15/2017.
 */
public interface SiteService {

    List<Site> getAllSites();

    Site getSiteBySiteId(String id);

    Site addSite(Site site);

    Site updateSite(Site site);

    void deleteSite(String id);
}

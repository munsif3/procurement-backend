package com.sliit.procurement.service.Impl;

import com.sliit.procurement.model.Site;
import com.sliit.procurement.repository.SiteRepository;
import com.sliit.procurement.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Munsif on 11/15/2017.
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteRepository siteRepository;

    @Override
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @Override
    public Site getSiteBySiteId(String id) {
        return siteRepository.findOne(id);
    }

    @Override
    public Site addSite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public Site updateSite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public void deleteSite(String id) {
        siteRepository.delete(id);
    }
}

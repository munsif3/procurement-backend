package com.sliit.procurement.model;

import com.sliit.procurement.model.Employee;
import com.sliit.procurement.model.Project;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author munsif
 */
@Entity
@Table(name = "site",  schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
    , @NamedQuery(name = "Site.findBySiteId", query = "SELECT s FROM Site s WHERE s.siteId = :siteId")
    , @NamedQuery(name = "Site.findByAddress", query = "SELECT s FROM Site s WHERE s.address = :address")
    , @NamedQuery(name = "Site.findBySiteName", query = "SELECT s FROM Site s WHERE s.siteName = :siteName")
    , @NamedQuery(name = "Site.findBySiteNo", query = "SELECT s FROM Site s WHERE s.siteNo = :siteNo")})
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "siteId")
    private Integer siteId;

    @Column(name = "address")
    private String address;

    @Column(name = "siteName")
    private String siteName;

    @Column(name = "siteNo")
    private String siteNo;

    @JoinColumn(name = "personNo", referencedColumnName = "personNo")
    @OneToOne
    private Employee personNo;

//    @OneToOne//(mappedBy = "siteNo")
//    @JoinColumn(name = "siteNo", insertable=false, updatable=false)
//    private Project project;

    public Site() {
    }

    public Site(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNo() {
        return siteNo;
    }

    public void setSiteNo(String siteNo) {
        this.siteNo = siteNo;
    }

    public Employee getPersonNo() {
        return personNo;
    }

    public void setPersonNo(Employee personNo) {
        this.personNo = personNo;
    }

//    @XmlTransient
//    public Project getProjectList() {
//        return project;
//    }
//
//    public void setProjectList(Project projectList) {
//        this.project = projectList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteId != null ? siteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.Site[ siteId=" + siteId + " ]";
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.lib.xlsbean;

import th.co.geniustree.lib.xlsbean.annotation.XlsColumn;

/**
 *
 * @author Teng
 */
public class SingTypeCsvModel {
    
    @XlsColumn(columnName="HOS_DCODE")
    protected String hosDcode;
    @XlsColumn(columnName="WCODE")
    protected String wcode;
    @XlsColumn(columnName="GENERIC_NAME")
    protected String genericName;
    @XlsColumn(columnName="STRENGTH")
    protected String strength;
    @XlsColumn(columnName="DGDSFNM")
    protected String dgdsfnm;
    @XlsColumn(columnName="UNIT")
    protected String unit;
    @XlsColumn(columnName="TRADE_NAME")
    protected String tradeName;
    @XlsColumn(columnName="REG_NO")
    protected String regNo;
    @XlsColumn(columnName="DISTRIBUTER_COMPANY")
    protected String distributerCompany;
    @XlsColumn(columnName="MAN_COMPANY")
    protected String manCompany;
    @XlsColumn(columnName="STDCODE")
    protected String stdcode;
    @XlsColumn(columnName="NDTYPE")
    protected String ndtype;
    @XlsColumn(columnName="NICHEDRUG")
    protected String nichedrug;
    @XlsColumn(columnName="IOWA")
    protected String iowa;
    @XlsColumn(columnName="ATC")
    protected String atc;
    @XlsColumn(columnName="MANUFACTURER")
    protected String manufacturer;
    @XlsColumn(columnName="COUNTRY")
    protected String country;
    @XlsColumn(columnName="EQUAL")
    protected String equal;

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDgdsfnm() {
        return dgdsfnm;
    }

    public void setDgdsfnm(String dgdsfnm) {
        this.dgdsfnm = dgdsfnm;
    }

    public String getDistributerCompany() {
        return distributerCompany;
    }

    public void setDistributerCompany(String distributerCompany) {
        this.distributerCompany = distributerCompany;
    }

    public String getEqual() {
        return equal;
    }

    public void setEqual(String equal) {
        this.equal = equal;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getHosDcode() {
        return hosDcode;
    }

    public void setHosDcode(String hosDcode) {
        this.hosDcode = hosDcode;
    }

    public String getIowa() {
        return iowa;
    }

    public void setIowa(String iowa) {
        this.iowa = iowa;
    }

    public String getManCompany() {
        return manCompany;
    }

    public void setManCompany(String manCompany) {
        this.manCompany = manCompany;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNdtype() {
        return ndtype;
    }

    public void setNdtype(String ndtype) {
        this.ndtype = ndtype;
    }

    public String getNichedrug() {
        return nichedrug;
    }

    public void setNichedrug(String nichedrug) {
        this.nichedrug = nichedrug;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getStdcode() {
        return stdcode;
    }

    public void setStdcode(String stdcode) {
        this.stdcode = stdcode;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWcode() {
        return wcode;
    }

    public void setWcode(String wcode) {
        this.wcode = wcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SingTypeCsvModel other = (SingTypeCsvModel) obj;
        if ((this.hosDcode == null) ? (other.hosDcode != null) : !this.hosDcode.equals(other.hosDcode)) {
            return false;
        }
        if ((this.wcode == null) ? (other.wcode != null) : !this.wcode.equals(other.wcode)) {
            return false;
        }
        if ((this.genericName == null) ? (other.genericName != null) : !this.genericName.equals(other.genericName)) {
            return false;
        }
        if ((this.strength == null) ? (other.strength != null) : !this.strength.equals(other.strength)) {
            return false;
        }
        if ((this.dgdsfnm == null) ? (other.dgdsfnm != null) : !this.dgdsfnm.equals(other.dgdsfnm)) {
            return false;
        }
        if ((this.unit == null) ? (other.unit != null) : !this.unit.equals(other.unit)) {
            return false;
        }
        if ((this.tradeName == null) ? (other.tradeName != null) : !this.tradeName.equals(other.tradeName)) {
            return false;
        }
        if ((this.regNo == null) ? (other.regNo != null) : !this.regNo.equals(other.regNo)) {
            return false;
        }
        if ((this.distributerCompany == null) ? (other.distributerCompany != null) : !this.distributerCompany.equals(other.distributerCompany)) {
            return false;
        }
        if ((this.manCompany == null) ? (other.manCompany != null) : !this.manCompany.equals(other.manCompany)) {
            return false;
        }
        if ((this.stdcode == null) ? (other.stdcode != null) : !this.stdcode.equals(other.stdcode)) {
            return false;
        }
        if ((this.ndtype == null) ? (other.ndtype != null) : !this.ndtype.equals(other.ndtype)) {
            return false;
        }
        if ((this.nichedrug == null) ? (other.nichedrug != null) : !this.nichedrug.equals(other.nichedrug)) {
            return false;
        }
        if ((this.iowa == null) ? (other.iowa != null) : !this.iowa.equals(other.iowa)) {
            return false;
        }
        if ((this.atc == null) ? (other.atc != null) : !this.atc.equals(other.atc)) {
            return false;
        }
        if ((this.manufacturer == null) ? (other.manufacturer != null) : !this.manufacturer.equals(other.manufacturer)) {
            return false;
        }
        if ((this.country == null) ? (other.country != null) : !this.country.equals(other.country)) {
            return false;
        }
        if ((this.equal == null) ? (other.equal != null) : !this.equal.equals(other.equal)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.hosDcode != null ? this.hosDcode.hashCode() : 0);
        hash = 13 * hash + (this.wcode != null ? this.wcode.hashCode() : 0);
        hash = 13 * hash + (this.genericName != null ? this.genericName.hashCode() : 0);
        hash = 13 * hash + (this.strength != null ? this.strength.hashCode() : 0);
        hash = 13 * hash + (this.dgdsfnm != null ? this.dgdsfnm.hashCode() : 0);
        hash = 13 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        hash = 13 * hash + (this.tradeName != null ? this.tradeName.hashCode() : 0);
        hash = 13 * hash + (this.regNo != null ? this.regNo.hashCode() : 0);
        hash = 13 * hash + (this.distributerCompany != null ? this.distributerCompany.hashCode() : 0);
        hash = 13 * hash + (this.manCompany != null ? this.manCompany.hashCode() : 0);
        hash = 13 * hash + (this.stdcode != null ? this.stdcode.hashCode() : 0);
        hash = 13 * hash + (this.ndtype != null ? this.ndtype.hashCode() : 0);
        hash = 13 * hash + (this.nichedrug != null ? this.nichedrug.hashCode() : 0);
        hash = 13 * hash + (this.iowa != null ? this.iowa.hashCode() : 0);
        hash = 13 * hash + (this.atc != null ? this.atc.hashCode() : 0);
        hash = 13 * hash + (this.manufacturer != null ? this.manufacturer.hashCode() : 0);
        hash = 13 * hash + (this.country != null ? this.country.hashCode() : 0);
        hash = 13 * hash + (this.equal != null ? this.equal.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "SingTypeCsvModel{" + "hosDcode=" + hosDcode + ", wcode=" + wcode + ", genericName=" + genericName + ", strength=" + strength + ", dgdsfnm=" + dgdsfnm + ", unit=" + unit + ", tradeName=" + tradeName + ", regNo=" + regNo + ", distributerCompany=" + distributerCompany + ", manCompany=" + manCompany + ", stdcode=" + stdcode + ", ndtype=" + ndtype + ", nichedrug=" + nichedrug + ", iowa=" + iowa + ", atc=" + atc + ", manufacturer=" + manufacturer + ", country=" + country + ", equal=" + equal + '}';
    }
    
}

package priv.xiaohan.ssm.model;

import net.sourceforge.jtds.jdbc.DateTime;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/7/19.
 */
public class BaseUser implements Serializable{
    private int MID;
    private int Perid;
    private String Username;
    private String Realname;
    private char Sex;
    private DateTime BirthDate;
    private String Stature;
    private int Nation;
    private int Polity;
    private String Country;
    private String enCountry;
    private int WorkPlaceArea;
    private int WorkPlaceCity;
    private String WorkPlaceName;
    private int HomePlaceArea;
    private int HomePlaceCity;
    private String homePlaceName;
    private int Degree;
    private String Graduate;
    private int IDType;
    private String IDCode;
    private int Contact1;
    private int Contact2;
    private int Contact3;
    private String Mobile;
    private String Phone;
    private String QQ;
    private String PostCode;
    private String Address;
    private String enAddress;
    private String HomePage;
    private int PhotoFlag;

    public int getMID() {
        return MID;
    }

    public int getPerid() {
        return Perid;
    }

    public String getUsername() {
        return Username;
    }

    public String getRealname() {
        return Realname;
    }

    public char getSex() {
        return Sex;
    }

    public DateTime getBirthDate() {
        return BirthDate;
    }

    public String getStature() {
        return Stature;
    }

    public int getNation() {
        return Nation;
    }

    public int getPolity() {
        return Polity;
    }

    public String getCountry() {
        return Country;
    }

    public String getEnCountry() {
        return enCountry;
    }

    public int getWorkPlaceArea() {
        return WorkPlaceArea;
    }

    public int getWorkPlaceCity() {
        return WorkPlaceCity;
    }

    public String getWorkPlaceName() {
        return WorkPlaceName;
    }

    public int getHomePlaceArea() {
        return HomePlaceArea;
    }

    public int getHomePlaceCity() {
        return HomePlaceCity;
    }

    public String getHomePlaceName() {
        return homePlaceName;
    }

    public int getDegree() {
        return Degree;
    }

    public String getGraduate() {
        return Graduate;
    }

    public int getIDType() {
        return IDType;
    }

    public String getIDCode() {
        return IDCode;
    }

    public int getContact1() {
        return Contact1;
    }

    public int getContact2() {
        return Contact2;
    }

    public int getContact3() {
        return Contact3;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getPhone() {
        return Phone;
    }

    public String getQQ() {
        return QQ;
    }

    public String getPostCode() {
        return PostCode;
    }

    public String getAddress() {
        return Address;
    }

    public String getEnAddress() {
        return enAddress;
    }

    public String getHomePage() {
        return HomePage;
    }

    public int getPhotoFlag() {
        return PhotoFlag;
    }

    public void setMID(int MID) {
        this.MID = MID;
    }

    public void setPerid(int perid) {
        Perid = perid;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setRealname(String realname) {
        Realname = realname;
    }

    public void setSex(char sex) {
        Sex = sex;
    }

    public void setBirthDate(DateTime birthDate) {
        BirthDate = birthDate;
    }

    public void setStature(String stature) {
        Stature = stature;
    }

    public void setNation(int nation) {
        Nation = nation;
    }

    public void setPolity(int polity) {
        Polity = polity;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setEnCountry(String enCountry) {
        this.enCountry = enCountry;
    }

    public void setWorkPlaceArea(int workPlaceArea) {
        WorkPlaceArea = workPlaceArea;
    }

    public void setWorkPlaceCity(int workPlaceCity) {
        WorkPlaceCity = workPlaceCity;
    }

    public void setWorkPlaceName(String workPlaceName) {
        WorkPlaceName = workPlaceName;
    }

    public void setHomePlaceArea(int homePlaceArea) {
        HomePlaceArea = homePlaceArea;
    }

    public void setHomePlaceCity(int homePlaceCity) {
        HomePlaceCity = homePlaceCity;
    }

    public void setHomePlaceName(String homePlaceName) {
        this.homePlaceName = homePlaceName;
    }

    public void setDegree(int degree) {
        Degree = degree;
    }

    public void setGraduate(String graduate) {
        Graduate = graduate;
    }

    public void setIDType(int IDType) {
        this.IDType = IDType;
    }

    public void setIDCode(String IDCode) {
        this.IDCode = IDCode;
    }

    public void setContact1(int contact1) {
        Contact1 = contact1;
    }

    public void setContact2(int contact2) {
        Contact2 = contact2;
    }

    public void setContact3(int contact3) {
        Contact3 = contact3;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setEnAddress(String enAddress) {
        this.enAddress = enAddress;
    }

    public void setHomePage(String homePage) {
        HomePage = homePage;
    }

    public void setPhotoFlag(int photoFlag) {
        PhotoFlag = photoFlag;
    }

    @Override
    public String toString() {
        return "BaseUser{" +
                "MID=" + MID +
                ", Perid=" + Perid +
                ", Username='" + Username + '\'' +
                ", Realname='" + Realname + '\'' +
                ", Sex=" + Sex +
                ", BirthDate=" + BirthDate +
                ", Stature='" + Stature + '\'' +
                ", Nation=" + Nation +
                ", Polity=" + Polity +
                ", Country='" + Country + '\'' +
                ", enCountry='" + enCountry + '\'' +
                ", WorkPlaceArea=" + WorkPlaceArea +
                ", WorkPlaceCity=" + WorkPlaceCity +
                ", WorkPlaceName='" + WorkPlaceName + '\'' +
                ", HomePlaceArea=" + HomePlaceArea +
                ", HomePlaceCity=" + HomePlaceCity +
                ", homePlaceName='" + homePlaceName + '\'' +
                ", Degree=" + Degree +
                ", Graduate='" + Graduate + '\'' +
                ", IDType=" + IDType +
                ", IDCode='" + IDCode + '\'' +
                ", Contact1=" + Contact1 +
                ", Contact2=" + Contact2 +
                ", Contact3=" + Contact3 +
                ", Mobile='" + Mobile + '\'' +
                ", Phone='" + Phone + '\'' +
                ", QQ='" + QQ + '\'' +
                ", PostCode='" + PostCode + '\'' +
                ", Address='" + Address + '\'' +
                ", enAddress='" + enAddress + '\'' +
                ", HomePage='" + HomePage + '\'' +
                ", PhotoFlag=" + PhotoFlag +
                '}';
    }
}



import java.util.Date;

public class Content {
    private int id;
    private String name;
    private String inn;
    private String kpp;
    private String regnum;
    private String status;
    private String categ;
    private String regcod;
    private Date regfns;
    private String unregcod;
    private Date unrefns;
    private int unZLSZVM;
    private int unZLRSV;
    private int unZLRSV0;

    public Content(int id, String name, String inn, String kpp, String regnum, String status, String categ, String regcod, Date regfns, String unregcod, Date unrefns, int unZLSZVM, int unZLRSV, int unZLRSV0) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.kpp = kpp;
        this.regnum = regnum;
        this.status = status;
        this.categ = categ;
        this.regcod = regcod;
        this.regfns = regfns;
        this.unregcod = unregcod;
        this.unrefns = unrefns;
        this.unZLSZVM = unZLSZVM;
        this.unZLRSV = unZLRSV;
        this.unZLRSV0 = unZLRSV0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getRegnum() {
        return regnum;
    }

    public void setRegnum(String regnum) {
        this.regnum = regnum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getRegcod() {
        return regcod;
    }

    public void setRegcod(String regcod) {
        this.regcod = regcod;
    }

    public Date getRegfns() {
        return regfns;
    }

    public void setRegfns(Date regfns) {
        this.regfns = regfns;
    }

    public String getUnregcod() {
        return unregcod;
    }

    public void setUnregcod(String unregcod) {
        this.unregcod = unregcod;
    }

    public Date getUnrefns() {
        return unrefns;
    }

    public void setUnrefns(Date unrefns) {
        this.unrefns = unrefns;
    }

    public int getUnZLSZVM() {
        return unZLSZVM;
    }

    public void setUnZLSZVM(int unZLSZVM) {
        this.unZLSZVM = unZLSZVM;
    }

    public int getUnZLRSV() {
        return unZLRSV;
    }

    public void setUnZLRSV(int unZLRSV) {
        this.unZLRSV = unZLRSV;
    }

    public int getUnZLRSV0() {
        return unZLRSV0;
    }

    public void setUnZLRSV0(int unZLRSV0) {
        this.unZLRSV0 = unZLRSV0;
    }
}

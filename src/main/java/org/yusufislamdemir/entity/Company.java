package org.yusufislamdemir.entity;

public class Company extends BaseEntity {
    private String sector;

    public Company(int id, String name, String sector) {
        super(id, name);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Company{" +
                super.toString()+
                " sector='" + sector + '\'' +
                '}';
    }
}

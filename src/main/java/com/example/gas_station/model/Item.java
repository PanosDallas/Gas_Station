package com.example.gas_station.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item", schema = "gas_station")
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idi", nullable = false)
    private Long idi;
    @Basic
    @Column(name = "code", nullable = false, length = -1)
    private String code;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "item_type", nullable = false, length = -1)
    private String itemType;
    @Basic
    @Column(name = "price", nullable = false, length = -1)
    private String price;
    @Basic
    @Column(name = "cost", nullable = false, length = -1)
    private String cost;
    @Basic
    @Column(name = "idc", nullable = false)
    private Long idc;
    @Basic
    @Column(name = "idt", nullable = false)
    private Long idt;
    @Basic
    @Column(name = "idtl", nullable = false)
    private Long idtl;

    public Long getIdi() {
        return idi;
    }

    public void setIdi(Long idi) {
        this.idi = idi;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Long getIdc() {
        return idc;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
    }

    public Long getIdt() {
        return idt;
    }

    public void setIdt(Long idt) {
        this.idt = idt;
    }

    public Long getIdtl() {
        return idtl;
    }

    public void setIdtl(Long idtl) {
        this.idtl = idtl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (idi != null ? !idi.equals(item.idi) : item.idi != null) return false;
        if (code != null ? !code.equals(item.code) : item.code != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (itemType != null ? !itemType.equals(item.itemType) : item.itemType != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (cost != null ? !cost.equals(item.cost) : item.cost != null) return false;
        if (idc != null ? !idc.equals(item.idc) : item.idc != null) return false;
        if (idt != null ? !idt.equals(item.idt) : item.idt != null) return false;
        if (idtl != null ? !idtl.equals(item.idtl) : item.idtl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idi != null ? idi.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (itemType != null ? itemType.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (idc != null ? idc.hashCode() : 0);
        result = 31 * result + (idt != null ? idt.hashCode() : 0);
        result = 31 * result + (idtl != null ? idtl.hashCode() : 0);
        return result;
    }
}

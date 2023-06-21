package com.example.gas_station.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items", schema = "gas_station")
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_item", nullable = false)
    private Long idItem;
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
    @Column(name = "id_transaction_line", nullable = false, length = -1)
    private Long idTransactionLine;

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (idItem != null ? !idItem.equals(item.idItem) : item.idItem != null) return false;
        if (code != null ? !code.equals(item.code) : item.code != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (itemType != null ? !itemType.equals(item.itemType) : item.itemType != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (cost != null ? !cost.equals(item.cost) : item.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idItem != null ? idItem.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (itemType != null ? itemType.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);

        return result;
    }
}

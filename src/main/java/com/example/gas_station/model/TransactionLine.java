package com.example.gas_station.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction_line", schema = "gas_station")
public class TransactionLine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idtl", nullable = false)
    private Long idtl;
    @Basic
    @Column(name = "quantity", nullable = false, length = -1)
    private String quantity;
    @Basic
    @Column(name = "item_price", nullable = false, length = -1)
    private String itemPrice;
    @Basic
    @Column(name = "net_value", nullable = false, length = -1)
    private String netValue;
    @Basic
    @Column(name = "discount_percent", nullable = false, length = -1)
    private String discountPercent;
    @Basic
    @Column(name = "discount_value", nullable = false, length = -1)
    private String discountValue;
    @Basic
    @Column(name = "total_value", nullable = false, length = -1)
    private String totalValue;
    @Basic
    @Column(name = "idt", nullable = false)
    private Long idt;
    @Basic
    @Column(name = "idc", nullable = false)
    private Long idc;

    public Long getIdtl() {
        return idtl;
    }

    public void setIdtl(Long idtl) {
        this.idtl = idtl;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getNetValue() {
        return netValue;
    }

    public void setNetValue(String netValue) {
        this.netValue = netValue;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public Long getIdt() {
        return idt;
    }

    public void setIdt(Long idt) {
        this.idt = idt;
    }

    public Long getIdc() {
        return idc;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionLine that = (TransactionLine) o;

        if (idtl != null ? !idtl.equals(that.idtl) : that.idtl != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (itemPrice != null ? !itemPrice.equals(that.itemPrice) : that.itemPrice != null) return false;
        if (netValue != null ? !netValue.equals(that.netValue) : that.netValue != null) return false;
        if (discountPercent != null ? !discountPercent.equals(that.discountPercent) : that.discountPercent != null)
            return false;
        if (discountValue != null ? !discountValue.equals(that.discountValue) : that.discountValue != null)
            return false;
        if (totalValue != null ? !totalValue.equals(that.totalValue) : that.totalValue != null) return false;
        if (idt != null ? !idt.equals(that.idt) : that.idt != null) return false;
        if (idc != null ? !idc.equals(that.idc) : that.idc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtl != null ? idtl.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (itemPrice != null ? itemPrice.hashCode() : 0);
        result = 31 * result + (netValue != null ? netValue.hashCode() : 0);
        result = 31 * result + (discountPercent != null ? discountPercent.hashCode() : 0);
        result = 31 * result + (discountValue != null ? discountValue.hashCode() : 0);
        result = 31 * result + (totalValue != null ? totalValue.hashCode() : 0);
        result = 31 * result + (idt != null ? idt.hashCode() : 0);
        result = 31 * result + (idc != null ? idc.hashCode() : 0);
        return result;
    }
}

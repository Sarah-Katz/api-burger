package co.simplon.burger.persistance.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction")
    private int id;

    @ManyToMany
    @JoinTable(name = "transaction_ad", joinColumns = @JoinColumn(name = "id_transaction"), inverseJoinColumns = @JoinColumn(name = "id_ad"))
    private List<Ad> ads;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    @Column(name = "id_buyer", nullable = false)
    private int idBuyer;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;

    @Column(name = "return_date", nullable = false)
    private Date returnDate;

    @Column(name = "has_returned", nullable = false)
    private boolean hasReturned;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return the ads
     */
    public List<Ad> getAds() {
        return ads;
    }

    /**
     * @param ads the ads to set
     */
    public void setAds(final List<Ad> ads) {
        this.ads = ads;
    }

    /**
     * @return the isPaid
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * @param isPaid the isPaid to set
     */
    public void setPaid(final boolean isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * @return the idBuyer
     */
    public int getIdBuyer() {
        return idBuyer;
    }

    /**
     * @param idBuyer the idBuyer to set
     */
    public void setIdBuyer(final int idBuyer) {
        this.idBuyer = idBuyer;
    }

    /**
     * @return the transactionDate
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(final Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * @return the date at which the items should be returned
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the date at which the items should be returned
     */
    public void setReturnDate(final Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return returns whether the items have been returned
     */
    public boolean isHasReturned() {
        return hasReturned;
    }

    /**
     * @param hasReturned sets whether the items have been returned
     */
    public void setHasReturned(final boolean hasReturned) {
        this.hasReturned = hasReturned;
    }
}

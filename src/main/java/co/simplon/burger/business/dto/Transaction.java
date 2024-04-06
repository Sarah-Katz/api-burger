package co.simplon.burger.business.dto;

import java.util.Date;
import java.util.List;

public class Transaction {
    private int idTransaction;
    private List<AdDto> ads;
    private boolean isPaid;
    private int idBuyer;
    private Date transactionDate;
    private Date returnDate;
    private boolean hasReturned;

    /**
     * @return the idTransaction
     */
    public int getIdTransaction() {
        return idTransaction;
    }

    /**
     * @param idTransaction the idTransaction to set
     */
    public void setIdTransaction(final int idTransaction) {
        this.idTransaction = idTransaction;
    }

    /**
     * @return the ads
     */
    public List<AdDto> getAds() {
        return ads;
    }

    /**
     * @param ads the ads to set
     */
    public void setAds(final List<AdDto> ads) {
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
     * @return the date of the transaction
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the date of the transaction
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
     * @return wether the items have been returned
     */
    public boolean isHasReturned() {
        return hasReturned;
    }

    /**
     * @param hasReturned wether the items have been returned
     */
    public void setHasReturned(final boolean hasReturned) {
        this.hasReturned = hasReturned;
    }
}

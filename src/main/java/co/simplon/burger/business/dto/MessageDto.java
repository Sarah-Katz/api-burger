package co.simplon.burger.business.dto;

import java.util.Date;

public class MessageDto {
    private int idMessage;
    private int idSender;
    private String text;
    private Date dateTime;

    /**
     * @return the idMessage
     */
    public int getIdMessage() {
        return idMessage;
    }

    /**
     * @param idMessage the idMessage to set
     */
    public void setIdMessage(final int idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * @return the idSender
     */
    public int getIdSender() {
        return idSender;
    }

    /**
     * @param idSender the idSender to set
     */
    public void setIdSender(final int idSender) {
        this.idSender = idSender;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * @return the dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(final Date dateTime) {
        this.dateTime = dateTime;
    }
}

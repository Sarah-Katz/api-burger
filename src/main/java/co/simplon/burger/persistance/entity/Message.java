package co.simplon.burger.persistance.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private int idMessage;

    @Column(name = "id_sender", nullable = false)
    private int idSender;

    @Column(name = "text", length = 255, nullable = false)
    private String text;

    @Column(name = "date_time", nullable = false)
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
     * @return the sender's id
     */
    public int getIdSender() {
        return idSender;
    }

    /**
     * @param idSender the sender's id to set
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

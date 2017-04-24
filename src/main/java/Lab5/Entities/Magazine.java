package lab5.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import lab5.entities.Copies.Publication;

/**
 * @author Kodi
 */
@Entity
public class Magazine extends Publication implements Serializable {

    @Basic
    private int orderQTY;

    @Basic
    private Date currIssue;

    public int getOrderQTY() {
        return this.orderQTY;
    }

    public void setOrderQTY(int orderQTY) {
        this.orderQTY = orderQTY;
    }

    public Date getCurrIssue() {
        return this.currIssue;
    }

    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }

}

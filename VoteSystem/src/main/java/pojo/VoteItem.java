package pojo;

import javafx.util.converter.TimeStringConverter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 20:12
 * @Description:VoteItem
 */
public class VoteItem {
    private int id;
    private String title;
    private int type;
    private List<VoteOption> options;
    private Date create_date;
    private Date update_date;

    @Override
    public String toString() {
        return "VoteItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", options=" + options +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOption> options) {
        this.options = options;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public VoteItem(int id, String title, int type, List<VoteOption> options, Date create_date, Date update_date) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.options = options;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public VoteItem() {
    }
}

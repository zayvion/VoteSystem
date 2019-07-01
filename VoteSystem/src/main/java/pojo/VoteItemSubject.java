package pojo;


import java.util.Date;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 19:26
 * @Description:投票主题实体
 */
public class VoteItemSubject {
    private int id;
    private String title;
    private int type;
    private Date create_time;
    private Date update_time;

    @Override
    public String toString() {
        return "VoteItemSubject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public VoteItemSubject(String title, int type, Date create_time, Date update_time) {
        this.title = title;
        this.type = type;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public VoteItemSubject(int id, String title, int type, Date create_time, Date update_time) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public VoteItemSubject() {
    }
}

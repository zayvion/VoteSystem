package pojo;

import java.util.Date;

/**
 * @Auther: zayvion
 * @Date: 2019-07-09 23:07
 * @Description:评论实体类
 */
public class Comment {
    private int id;
    private int uid;
    private int sid;
    private String nickName;
    private String content;
    private Date publishTime;

    public Comment() {
    }

    public Comment(int uid, int sid, String nickName, String content, Date publishTime) {
        this.uid = uid;
        this.sid = sid;
        this.nickName = nickName;
        this.content = content;
        this.publishTime = publishTime;
    }

    public Comment(int id, int uid, int sid, String nickName, String content, Date publishTime) {
        this.id = id;
        this.uid = uid;
        this.sid = sid;
        this.nickName = nickName;
        this.content = content;
        this.publishTime = publishTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", uid=" + uid +
                ", sid=" + sid +
                ", nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                '}';
    }
}

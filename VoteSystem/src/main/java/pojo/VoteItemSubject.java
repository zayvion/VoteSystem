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
    private int oper_user;
    private boolean isJoin;
    private Date create_time;
    private Date update_time;
    private int joinNum;
    private int optionNum;
    private Date effective_time;
    private boolean isValidTime;

    @Override
    public String toString() {
        return "VoteItemSubject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", oper_user=" + oper_user +
                ", isJoin=" + isJoin +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", joinNum=" + joinNum +
                ", optionNum=" + optionNum +
                ", effective_time=" + effective_time +
                ", isValidTime=" + isValidTime +
                '}';
    }

    public VoteItemSubject(int id, String title, int type, int oper_user, boolean isJoin, Date create_time, Date update_time, int joinNum, int optionNum, Date effective_time, boolean isValidTime) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.oper_user = oper_user;
        this.isJoin = isJoin;
        this.create_time = create_time;
        this.update_time = update_time;
        this.joinNum = joinNum;
        this.optionNum = optionNum;
        this.effective_time = effective_time;
        this.isValidTime = isValidTime;
    }

    public boolean isValidTime() {
        return isValidTime;
    }

    public void setValidTime(boolean validTime) {
        isValidTime = validTime;
    }

    public Date getEffective_time() {
        return effective_time;
    }

    public void setEffective_time(Date effective_time) {
        this.effective_time = effective_time;
    }

    public Date geteffective_time() {
        return effective_time;
    }

    public void seteffective_time(Date effective_time) {
        this.effective_time = effective_time;
    }

    public int getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(int joinNum) {
        this.joinNum = joinNum;
    }

    public int getOptionNum() {
        return optionNum;
    }

    public void setOptionNum(int optionNum) {
        this.optionNum = optionNum;
    }

    public boolean isJoin() {
        return isJoin;
    }

    public void setJoin(boolean join) {
        isJoin = join;
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

    public int getOper_user() {
        return oper_user;
    }

    public void setOper_user(int oper_user) {
        this.oper_user = oper_user;
    }

    public VoteItemSubject(int id) {
        this.id = id;
    }


    public VoteItemSubject(int id, String title, int type, int oper_user, boolean isJoin, Date create_time, Date update_time, int joinNum, int optionNum, boolean isInvalid) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.oper_user = oper_user;
        this.isJoin = isJoin;
        this.create_time = create_time;
        this.update_time = update_time;
        this.joinNum = joinNum;
        this.optionNum = optionNum;
    }

    public VoteItemSubject(String title, int type, Date create_time, Date update_time) {
        this.title = title;
        this.type = type;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public VoteItemSubject(String title, int type, int oper_user, Date create_time, Date update_time) {
        this.title = title;
        this.type = type;
        this.oper_user = oper_user;
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

    public VoteItemSubject(int id, String title, int type, int oper_user, Date create_time, Date update_time) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.oper_user = oper_user;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public VoteItemSubject(String title, int type, int oper_user, boolean isJoin, Date create_time, Date update_time) {
        this.title = title;
        this.type = type;
        this.oper_user = oper_user;
        this.isJoin = isJoin;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public VoteItemSubject(int id, String title, int type, int oper_user, boolean isJoin, Date create_time, Date update_time) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.oper_user = oper_user;
        this.isJoin = isJoin;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public VoteItemSubject(int id, String title, int type, int oper_user, boolean isJoin, Date create_time, Date update_time, int joinNum, int optionNum) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.oper_user = oper_user;
        this.isJoin = isJoin;
        this.create_time = create_time;
        this.update_time = update_time;
        this.joinNum = joinNum;
        this.optionNum = optionNum;
    }

    public VoteItemSubject() {
    }
}

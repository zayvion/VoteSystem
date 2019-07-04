package pojo;

import java.util.Date;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 18:22
 * @Description:投票结果的封装类
 */
public class VoteResult {
    private int sid;
    private int oid;
    private int num;
    private int scale;
    private String option;
    private int joinNum;
    private int optionNum;
    private Date effective_time;

    public Date getEffective_time() {
        return effective_time;
    }

    public void setEffective_time(Date effective_time) {
        this.effective_time = effective_time;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
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

    public VoteResult() {
    }
}

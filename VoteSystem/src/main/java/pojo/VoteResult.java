package pojo;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 18:22
 * @Description:投票结果的封装类
 */
public class VoteResult {
    private int sid;
    private int oid;
    private int num;
    private double scale;

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

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public VoteResult() {
    }
}

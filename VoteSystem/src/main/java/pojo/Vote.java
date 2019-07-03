package pojo;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 08:23
 * @Description:用户投票实体类
 */
public class Vote {
    private int id;
    private int s_id;
    private int o_id;
    private int u_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public Vote(int id, int s_id, int o_id, int u_id) {
        this.id = id;
        this.s_id = s_id;
        this.o_id = o_id;
        this.u_id = u_id;
    }

    public Vote() {
    }
}

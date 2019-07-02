package pojo;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 17:20
 * @Description:投票选项
 */
public class VoteOption {
    private int id ;
    private String option;
    private int s_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public VoteOption(int id, String option, int s_id) {
        this.id = id;
        this.option = option;
        this.s_id = s_id;
    }

    public VoteOption(String option, int s_id) {
        this.option = option;
        this.s_id = s_id;
    }

    public VoteOption() {
    }

    @Override
    public String toString() {
        return "VoteOption{" +
                "id=" + id +
                ", option='" + option + '\'' +
                ", s_id=" + s_id +
                '}';
    }
}

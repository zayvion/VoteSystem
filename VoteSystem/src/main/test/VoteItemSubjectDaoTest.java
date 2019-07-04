import org.junit.Test;
import pojo.VoteItemSubject;
import service.VoteItemSubjectService;
import service.impl.VoteItemSubjectServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 17:08
 * @Description:
 */
public class VoteItemSubjectDaoTest {
    @Test
    public void testSubjectAdd(){
        VoteItemSubjectService itemService = new VoteItemSubjectServiceImpl();
        try {
            itemService.addVoteItemSubject(new VoteItemSubject("最喜欢的歌曲",0,new java.sql.Timestamp(new java.util.Date().getTime()),new java.sql.Timestamp(new java.util.Date().getTime())));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetSubject(){
        VoteItemSubjectService itemService = new VoteItemSubjectServiceImpl();
        try {
            VoteItemSubject subject = itemService.getVoteItemSubject(new VoteItemSubject(1));
            System.out.println(subject);
            Date time = subject.getCreate_time();
            System.out.println(time);
            Date now = new Date();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String format = dateFormatter.format(time);
            SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//如2016-08-10 20:40
            String fromDate = simpleFormat.format(time);
            String toDate = simpleFormat.format(now);
            long from = 0;
            long to = 0;
            try {
                from = simpleFormat.parse(fromDate).getTime();
                to = simpleFormat.parse(toDate).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
            System.out.println(days);

            //System.out.println(now);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testTime(){
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//如2016-08-10 20:40
        String fromDate = simpleFormat.format("2016-05-01 12:00");
        String toDate = simpleFormat.format("2016-06-01 12:00");
        long from = 0;
        long to = 0;
        try {
            from = simpleFormat.parse(fromDate).getTime();
            to = simpleFormat.parse(toDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
        System.out.println(days);


    }
}

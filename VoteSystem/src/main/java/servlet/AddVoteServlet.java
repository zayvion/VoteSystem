package servlet;


import pojo.VoteItemSubject;
import pojo.VoteOption;
import service.VoteItemSubjectService;
import service.VoteOptionService;
import service.impl.VoteItemSubjectServiceImpl;
import service.impl.VoteOptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 13:28
 * @Description:新建投票servlet
 */
public class AddVoteServlet extends HttpServlet {
    Connection conn = null ;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        int type = Integer.parseInt(req.getParameter("type"));
        int userid = (int) req.getSession().getAttribute("userid");
        String endTimeStr = req.getParameter("endTime");

        Date endTime = null;
        try {
            SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//如2016-08-10 20:40
            endTime = simpleFormat.parse(endTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] options = req.getParameter("options").split(",");
        VoteItemSubject subject = new VoteItemSubject();
        subject.setTitle(title);
        subject.setType(type);
        subject.setOper_user(userid);
        subject.setEffective_time(endTime);
         try{
            VoteItemSubjectService voteItemSubjectService = new VoteItemSubjectServiceImpl();
            VoteOptionService voteOptionService = new VoteOptionServiceImpl();
            Long id = voteItemSubjectService.addVoteItemSubject(subject);
            for(String option : options){
                VoteOption voteOption = new VoteOption();
                voteOption.setOption(option);
                voteOption.setS_id(Integer.parseInt(id.toString()));
                voteOptionService.addVoteOption(voteOption);
            }
      } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}

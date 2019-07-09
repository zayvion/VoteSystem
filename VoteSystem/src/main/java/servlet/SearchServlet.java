package servlet;

import com.google.gson.Gson;
import pojo.VoteItemSubject;
import service.VoteItemSubjectService;
import service.impl.VoteItemSubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-08 10:36
 * @Description:搜索Servlet
 */
public class SearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VoteItemSubjectService voteItemSubjectService = new VoteItemSubjectServiceImpl();
        try {
            int userid = (int)req.getSession().getAttribute("userid");
            String condition = req.getParameter("condition");
            System.out.println(condition);
            List<VoteItemSubject> list = voteItemSubjectService.getSearchVoteItem(userid, condition);
            for (VoteItemSubject subject:list) {
                boolean isjoin = voteItemSubjectService.isJoin(subject.getId(), userid);
                int optionNum = voteItemSubjectService.getOptionNum(subject.getId());
                int joinNum = voteItemSubjectService.getJoinNum(subject.getId());
                long effectiveTime = subject.getEffective_time().getTime();
                long now = new Date().getTime();
                if (effectiveTime>now){
                    subject.setValidTime(true);
                }
                subject.setJoin(isjoin);
                subject.setJoinNum(joinNum);
                subject.setOptionNum(optionNum);
            }
            //把数据用json传递到前台，进行ajax操作
            String json = new Gson().toJson(list);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

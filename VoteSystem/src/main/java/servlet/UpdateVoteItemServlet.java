package servlet;

import pojo.VoteItemSubject;
import pojo.VoteOption;
import service.VoteItemService;
import service.VoteItemSubjectService;
import service.impl.VoteItemServiceImpl;
import service.impl.VoteItemSubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-02 16:24
 * @Description:
 */
public class UpdateVoteItemServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userid = (int)(req.getSession().getAttribute("userid"));
        int length = Integer.parseInt(req.getParameter("length"));
        int id = Integer.parseInt(req.getParameter("id"));
        int type = Integer.parseInt(req.getParameter("type"));
        String title = req.getParameter("title");
        VoteItemSubject subject = new VoteItemSubject();
        subject.setOper_user(userid);
        subject.setId(id);
        subject.setTitle(title);
        VoteItemSubjectService voteItemSubjectService = new VoteItemSubjectServiceImpl();
        VoteItemService voteItemService = new VoteItemServiceImpl();
        List<VoteOption> list = new ArrayList<>();
        try {
            VoteItemSubject subject1 = voteItemSubjectService.getVoteItemSubject(subject);
            subject.setEffective_time(subject1.getEffective_time());
            subject.setType(type);
            for(int i = 0;i<length;i++){
                VoteOption option = new VoteOption();
                option.setId(Integer.parseInt(req.getParameter("options["+i+"][id]")));
                option.setOption(req.getParameter("options["+i+"][option]"));
                list.add(option);
            }
            voteItemService.updateVoteItem(subject,list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       /* Map<String, String> parameters = new HashMap<>();
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {

            String parameterName = names.nextElement();
            System.out.println(parameterName);
            System.out.println(req.getParameter(parameterName));
            parameters.put(parameterName, req.getParameter(parameterName));
        }*/


    }


}


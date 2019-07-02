package servlet;

import pojo.VoteItem;
import pojo.VoteItemSubject;
import pojo.VoteOption;
import service.VoteItemService;
import service.impl.VoteItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * @Auther: zayvion
 * @Date: 2019-07-02 16:24
 * @Description:
 */
public class UpdateVoteItemServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int length = Integer.parseInt(req.getParameter("length"));
        int id = Integer.parseInt(req.getParameter("id"));
        int type = Integer.parseInt(req.getParameter("type"));
        String title = req.getParameter("title");
        VoteItemSubject subject = new VoteItemSubject();
        subject.setId(id);
        subject.setType(type);
        subject.setTitle(title);
        VoteItemService voteItemService = new VoteItemServiceImpl();
        List<VoteOption> list = new ArrayList<>();
        for(int i = 0;i<length;i++){
            VoteOption option = new VoteOption();
            option.setId(Integer.parseInt(req.getParameter("options["+i+"][id]")));
            option.setOption(req.getParameter("options["+i+"][option]"));
            list.add(option);
        }
        try {
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


package servlet;

import com.google.gson.Gson;
import pojo.VoteItemSubject;
import pojo.VoteOption;
import pojo.VoteResult;
import service.VoteItemSubjectService;
import service.VoteOptionService;
import service.impl.VoteItemSubjectServiceImpl;
import service.impl.VoteOptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-02 23:01
 * @Description:
 */
public class ShowVoteResultServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        VoteItemSubject sub = new VoteItemSubject(id);
        VoteItemSubjectService voteItemSubjectService = new VoteItemSubjectServiceImpl();
        try {
            VoteItemSubject subject = voteItemSubjectService.getVoteItemSubject(sub);

            req.setAttribute("title", subject.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<VoteResult> list = new ArrayList<>();
        VoteOptionService voteOptionService = new VoteOptionServiceImpl();
        try {
            List<VoteOption> options = voteOptionService.getOptions(id);
            int length = options.size();
            System.out.println(length);
            for (int i = 0; i < options.size(); i++) {
                //选项选中的个数
                VoteOption option = options.get(i);
                int num = voteOptionService.getIsSelectedNum(option.getId());
                int sum = voteOptionService.getAllSelectedSum(id);
                System.out.println(num);
                VoteResult voteResult = new VoteResult();
                voteResult.setNum(num);
                voteResult.setOid(options.get(i).getId());
                voteResult.setSid(id);
                voteResult.setScale(new BigDecimal(num/sum).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
                list.add(voteResult);
            }
            String json = new Gson().toJson(list);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("vote_result.jsp").forward(req, resp);
    }
}

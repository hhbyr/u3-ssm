package cn.kgc.controller;

import cn.kgc.domain.Dept;
import cn.kgc.domain.Emp;
import cn.kgc.domain.EmpTerm;
import cn.kgc.serivce.DeptService;
import cn.kgc.serivce.EmpService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: zhaojing
 * @Date: 2019/9/27 11:50
 * @Description:
 */
@Controller
public class EmpController {

    /*引入service层对象*/
    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

   /* @RequestMapping("/list")
    public ModelAndView list(ModelAndView mv){
        //查询数据
        List<Emp> allList = empService.findAll();
        //把数据放到model中
        mv.addObject("allList",allList);
        //设置跳转的页面
        mv.setViewName("main");
        return mv;
    }*/

    /**
     * @RequestParam(defaultValue = "1"): 设置参数的默认值
     * @param term
     * @param pageNum
     * @param mv
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(EmpTerm term, @RequestParam(defaultValue = "1") Integer pageNum, ModelAndView mv){
        //查询所有的部门数据
        List<Dept> deptList = deptService.findDeptAll();
        //1.pageHelper
        PageHelper.startPage(pageNum,5);
        //2.查询数据
        List<Emp> allList = empService.findBySome(term);
        //3.设置分页
        PageInfo pageInfo = new PageInfo(allList);
        //把分页对象放到model中
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("deptList",deptList);
        //把Main.jsp页面的数据进行回显
        mv.addObject("term",term);
        //设置跳转的页面
        mv.setViewName("main");
        return mv;
    }

    //处理表单的异步请求操作=文件上传
    //返回JSON格式的字符串
    @RequestMapping("/uploadFile")
    public @ResponseBody
    String uploadFile(MultipartFile mfile, HttpSession session){
        /*上传到什么地方？？？*/
        String realPath = session.getServletContext().getRealPath("/uploads");
        /*创建JSON对象*/
        JSONObject json = new JSONObject();
        /*判断文件不能为空*/
        if(mfile==null){
            json.put("error","上传文件为空！");
            /*转换成JSON字符串*/
            return json.toJSONString();
        }
        //getSize():获取大小
        if(mfile.getSize()>1048576){
            json.put("error","单文件上传不能超过1M！");
            return json.toJSONString();
        }
        //获取用户名后缀
        String originalFilename = mfile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成新名字
        String name = UUID.randomUUID().toString();
        //生成存放名字的路径
        String afterPath = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss").format(new Date());
        //创建文件夹路径
        File fdir = new File(realPath+"/"+afterPath);
        if(!fdir.exists()){
            fdir.mkdirs();
        }
        //生成回显的url路径:相对路径
        String url = "/uploads/"+afterPath+"/"+name+ext;
        json.put("url",url);
        //创建文件的路径
        File file = new File(fdir,name+ext);
        //上传文件
        try {
            mfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            json.put("error","文件上传失败！");
        }
        return json.toJSONString();
    }

    /*在新增用户页面显示部门*/
    @RequestMapping("/showAddEmp")
    public String showAddEmp(Model model){
        //查询所有的部门数据
        List<Dept> deptList = deptService.findDeptAll();
        model.addAttribute("deptList",deptList);
        return "addEmp";
    }
}

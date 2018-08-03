package com.baomidou.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiAssert;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.ApiResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.springboot.ErrorCode;
import com.baomidou.springboot.entity.Student;
import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码生成器，参考源码测试用例：
 * <p>
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/MysqlGenerator.java
 */
@RestController
@RequestMapping("/student")
public class StudentController extends ApiController {

    @Autowired
    private IStudentService studentService;

    /**
     * <p>
     * 测试通用 Api Controller 逻辑
     * </p>
     * 测试地址：
     * http://localhost:8080/user/api
     * http://localhost:8080/user/api?test=mybatisplus
     */
    @GetMapping("/api")
    public ApiResult<String> testError(String test) {

        ApiAssert.isNull(ErrorCode.TEST, test);
        return success(test);
    }

    /**
     * http://localhost:8080/user/test
     */
    @GetMapping("/test")
    public IPage<Student> test() {
        return studentService.selectPage(new Page<Student>(0, 12), null);
    }

    /**
     * AR 部分测试
     * http://localhost:8080/user/test1
     */
    @GetMapping("/test1")
    public IPage<Student> test1() {
        Student student=new Student();
        student.setId(1L);
        student.setName("LLL");
        student.insert();
        System.err.println("查询插入结果：" + student.selectById().toString());

        student.setName("LiHaitao");
        System.err.println("更新：" + student.updateById());
        return student.selectPage(new Page<Student>(0, 12), null);
    }

    /**
     * 增删改查 CRUD
     * http://localhost:8080/user/test2
     */
    @GetMapping("/test2")
    public User test2() {
      /*  System.err.println("删除一条数据：" + userService.deleteById(1L));
        System.err.println("deleteAll：" + userService.deleteAll());
        System.err.println("插入一条数据：" + userService.insert(new User(1L, "张三", AgeEnum.TWO, 1)));
        User user = new User("张三", AgeEnum.TWO, 1);
        boolean result = userService.insert(user);
        // 自动回写的ID
        Long id = user.getId();
        System.err.println("插入一条数据：" + result + ", 插入信息：" + user.toString());
        System.err.println("查询：" + userService.selectById(id).toString());
        System.err.println("更新一条数据：" + userService.updateById(new User(1L, "三毛", AgeEnum.ONE, 1)));
        for (int i = 0; i < 5; ++i) {
            userService.insert(new User(Long.valueOf(100 + i), "张三" + i, AgeEnum.ONE, 1));
        }
        IPage<User> userListPage = userService.selectPage(new Page<User>(1, 5), new QueryWrapper<User>());
        System.err.println("total=" + userListPage.getTotal() + ", current list size=" + userListPage.getRecords().size());

        userListPage = userService.selectPage(new Page<User>(1, 5), new QueryWrapper<User>().orderByDesc("name"));
        System.err.println("total=" + userListPage.getTotal() + ", current list size=" + userListPage.getRecords().size());
        return userService.selectById(1L);*/
      return null;
    }

    /**
     * 插入 OR 修改
     * http://localhost:8080/user/test3
     */
    @GetMapping("/test3")
    public Student test3() {
       Student student = new Student();
       student.setId(1L);
       student.setName("LiuHao");
       studentService.insertOrUpdate(student);
        return studentService.selectById(1L);
    }

    /**
     * http://localhost:8080/user/add
     */
    @GetMapping("/add")
    public Object addUser() {
        Student student = new Student();
        student.setName("XXX");
        student.setId(2L);
        return student.insert();
    }










}

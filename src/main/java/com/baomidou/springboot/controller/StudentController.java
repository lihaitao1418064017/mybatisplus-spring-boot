package com.baomidou.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiAssert;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.ApiResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageHelper;
import com.baomidou.springboot.ErrorCode;
import com.baomidou.springboot.entity.Student;
import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.entity.enums.AgeEnum;
import com.baomidou.springboot.entity.enums.PhoneEnum;
import com.baomidou.springboot.service.IStudentService;
import com.baomidou.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    /**
     * http://localhost:8080/user/select_sql
     */
   /* @GetMapping("/select_sql")
    public Object getUserBySql() {
        return userService.selectListBySQL();
    }
*/
    /**
     * http://localhost:8080/user/select_wrapper
     */
   /* @GetMapping("/select_wrapper")
    public Object getUserByWrapper() {
        return userService.selectListByWrapper(new QueryWrapper<User>()
                .lambda().like(User::getName, "毛"));
    }*/

    /**
     * <p>
     * 参数模式分页
     * </p>
     * <p>
     * 7、分页 size 一页显示数量  current 当前页码
     * 方式一：http://localhost:8080/user/page?size=1&current=1<br>
     * 方式二：http://localhost:8080/user/page_helper?size=1&current=1<br>
     *
     * 集合模式，不进行分页直接返回所有结果集：
     * http://localhost:8080/user/page?listMode=true
     */
    /*@GetMapping("/page")
    public IPage page(Page page) {
        return userService.selectPage(page, null);
    }
*/
    /**
     * ThreadLocal 模式分页
     * http://localhost:8080/user/page_helper?size=2&current=1
     */
    /*@GetMapping("/page_helper")
    public IPage pagehelper(Page page) {
        PageHelper.setPage(page);
        page.setRecords(userService.selectList(null));
        //获取总数并释放资源 也可以 PageHelper.getTotal()
        page.setTotal(PageHelper.freeTotal());
        return page;
    }*/


    /**
     * 测试事物
     * http://localhost:8080/user/test_transactional<br>
     * 访问如下并未发现插入数据说明事物可靠！！<br>
     * http://localhost:8080/user/test<br>
     * <br>
     * 启动  Application 加上 @EnableTransactionManagement 注解其实可无默认貌似就开启了<br>
     * 需要事物的方法加上 @Transactional 必须的哦！！
     */
   /* @Transactional(rollbackFor = Exception.class)
    @GetMapping("/test_transactional")
    public void testTransactional() {
        User user = new User(1000L, "测试事物", AgeEnum.ONE, 3);
        userService.insert(user);
        System.out.println(" 这里手动抛出异常，自动回滚数据");
        throw new RuntimeException();
    }*/
}
